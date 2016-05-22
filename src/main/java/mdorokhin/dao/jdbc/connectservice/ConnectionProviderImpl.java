package mdorokhin.dao.jdbc.connectservice;

import mdorokhin.utils.propertiesHelper.DBPropertiesHandler;
import mdorokhin.utils.propertiesHelper.PropertiesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class ConnectionProviderImpl implements ConnectionProvider {

    private static final Logger log = LoggerFactory.getLogger(ConnectionProviderImpl.class);
    private static ConnectionProvider connectionProvider;
    private PropertiesHelper propertiesHelper;
    private final String url;
    private final Connection connection;


    private ConnectionProviderImpl(){
        this.propertiesHelper = new DBPropertiesHandler("src/main/resources/jdbc_db.properties");
        this.url = loadURL();
        this.connection = initConnection();
    }

    public static ConnectionProvider getInstance(){

        if (connectionProvider == null){
            connectionProvider = new ConnectionProviderImpl();
        }
        return  connectionProvider;
    }

    private String loadURL() {
        StringBuilder url = new StringBuilder();

        url.append(propertiesHelper.getProperty("host"))
                .append("?")
                .append("user=")
                .append(propertiesHelper.getProperty("user"))
                .append("&")
                .append("password=")
                .append(propertiesHelper.getProperty("password"));

        return url.toString();

    }

    private Connection initConnection() {

        try {
            DriverManager.registerDriver((Driver) Class.forName(propertiesHelper.getProperty("driver")).newInstance());
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.debug("Can't register sql driver");
        }
            Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            log.debug("Can't get sql connection");
        }
        return connection;

    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
