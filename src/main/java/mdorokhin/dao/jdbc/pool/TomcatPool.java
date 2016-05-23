package mdorokhin.dao.jdbc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class TomcatPool implements ConnectionPool {

    private static final Logger log = LoggerFactory.getLogger(TomcatPool.class);
    private static ConnectionPool connectionPool;
    private static DataSource dataSource;

    private TomcatPool(){
        initConnectionPool();
    }

    public static synchronized ConnectionPool getInstance(){

        if (connectionPool == null){
            connectionPool = new TomcatPool();
        }
        return connectionPool;
    }

    private void initConnectionPool() {

        try {
            InitialContext context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/blog");
        } catch (NamingException ex){
            log.debug("Error of connection pool {}", ex);
        }
    }

    @Override
    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex){
            log.debug("Can't get connection", ex);
        }
        return connection;
    }

}
