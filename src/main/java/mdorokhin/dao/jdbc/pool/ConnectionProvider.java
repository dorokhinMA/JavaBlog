package mdorokhin.dao.jdbc.pool;

import mdorokhin.utils.propertiesHelper.DBPropertiesHandler;
import mdorokhin.utils.propertiesHelper.PropertiesHelper;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         22.05.2016.
 */
public class ConnectionProvider implements ConnectionPool {

    private static ConnectionProvider connectionProvider;
    private PropertiesHelper propertiesHelper;
    private String url;

    private ConnectionProvider(){
        this.propertiesHelper = new DBPropertiesHandler("src/main/resources/jdbc.properties");
        this.url = loadURL();
    }

    public static synchronized ConnectionProvider getInstance(){

        if (connectionProvider == null){
            connectionProvider = new ConnectionProvider();
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

        return initConnection();
    }
}
