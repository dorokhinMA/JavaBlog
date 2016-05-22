package mdorokhin.dao.jdbc.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Executor {

    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        stmt.close();
    }

    public <T> T executeQuery(String query, ResultHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        return value;
    }
}
