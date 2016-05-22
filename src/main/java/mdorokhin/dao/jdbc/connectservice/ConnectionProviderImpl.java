package mdorokhin.dao.jdbc.connectservice;

import mdorokhin.utils.DBPropertiesHandler;
import mdorokhin.utils.PropertiesHelper;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class ConnectionProviderImpl implements ConnectionProvider {

    private static ConnectionProvider connectionProvider;
    private PropertiesHelper propertiesHelper;
    private String url;
    private final Connection connection;


    private ConnectionProviderImpl(){
        this.propertiesHelper = new DBPropertiesHandler();
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
            e.printStackTrace();
        }
            Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
