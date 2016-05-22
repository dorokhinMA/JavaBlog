package mdorokhin.dao.jdbc.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
