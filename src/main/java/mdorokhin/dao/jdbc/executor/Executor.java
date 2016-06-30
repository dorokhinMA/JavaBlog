package mdorokhin.dao.jdbc.executor;

import mdorokhin.dao.jdbc.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Executor {

    private static final Logger log = LoggerFactory.getLogger(Executor.class);
    private final Connection connection;

    public Executor(Connection connection){
        this.connection = connection;
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        log.debug("query: {}", query);
        stmt.execute(query);
        log.debug("Execute query: {}", query);
        DBUtil.closeStatement(stmt);
    }

    public <T> T executeQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        log.debug("query: {}", query);
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        log.debug("Execute query: {}", query);
        DBUtil.closeResultSet(result);
        DBUtil.closeStatement(stmt);
        return value;
    }
}
