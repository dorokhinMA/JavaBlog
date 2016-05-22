package mdorokhin.dao.jdbc.connectservice;

import java.sql.Connection;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public interface ConnectionProvider {
   Connection getConnection();
}
