package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TransactionWrapper implements ITransaction {
    private final List<ITransaction> transactions = new ArrayList();

    public TransactionWrapper(ITransaction... iTransactionArr) {
        this.transactions.addAll(Arrays.asList(iTransactionArr));
    }

    public TransactionWrapper(Collection<ITransaction> collection) {
        this.transactions.addAll(collection);
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        for (ITransaction execute : this.transactions) {
            execute.execute(databaseWrapper);
        }
    }
}
