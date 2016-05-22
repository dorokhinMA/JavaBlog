package mdorokhin.utils.transactionHelper;

import mdorokhin.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

/**
 * @author Maxim Dorokhin
 *         14.05.2016.
 */
public class TransactionHelperImpl implements TransactionHelper<Object> {

    private static final Logger log = LoggerFactory.getLogger(TransactionHelperImpl.class);
    private final Connection connection;

    public TransactionHelperImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void doTransaction(Runnable runnable){

        try {
            connection.setAutoCommit(false);
            runnable.run();
            connection.commit();
            log.debug("Transaction has been successful");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
                log.debug("Can't rollback");
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                //connection.close();
            } catch (SQLException ignore) {
            }
        }
    }


    @Override
    public Object doTransaction(Supplier<? extends BaseEntity> supplier) {

        Object value;

        try {
            connection.setAutoCommit(false);
            value = supplier.get();
            connection.commit();
            log.debug("Transaction has been successful");
            return value;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
                log.debug("Can't rollback");
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }

        return null;
    }


}
