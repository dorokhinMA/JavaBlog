package mdorokhin.dao.jdbc.pool;

import java.sql.Connection;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public interface ConnectionPool {

   Connection getConnection();
}
