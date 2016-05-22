package mdorokhin.utils.transactionHelper;


import mdorokhin.model.BaseEntity;

import java.util.function.Supplier;

/**
 * @author Maxim Dorokhin
 *         13.05.2016.
 */
public interface TransactionHelper<T> {
    void doTransaction(Runnable runnable);
    T doTransaction(Supplier<? extends BaseEntity> supplier);
}
