package mdorokhin.dao.jdbc.util;

import mdorokhin.dao.jdbc.pool.ConnectionPool;
import mdorokhin.dao.jdbc.pool.ConnectionProvider;
import mdorokhin.dao.jdbc.pool.TomcatPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maxim Dorokhin
 *         22.05.2016.
 */
public class DBUtil {

    private static final Logger log = LoggerFactory.getLogger(DBUtil.class);
    static ConnectionPool connectionPool = ConnectionProvider.getInstance();

    public static Connection getConnection() {

        return connectionPool.getConnection();
    }

    public static void closeConnection(Connection connection) {

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException logOrIgnore) {
                log.debug("Can't close connection");
            }
        }
    }

    public static void closeStatement(Statement statement) {

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException logOrIgnore) {
                log.debug("Can't close statement");
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {

        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException logOrIgnore) {
                log.debug("Can't close resultSet");
            }
        }
    }


}
