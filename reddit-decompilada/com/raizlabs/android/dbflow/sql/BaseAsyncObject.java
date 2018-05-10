package com.raizlabs.android.dbflow.sql;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success;

public class BaseAsyncObject<TAsync> {
    private Transaction currentTransaction;
    private final DatabaseDefinition databaseDefinition;
    private final Error error = new C14671();
    private Error errorCallback;
    private final Success success = new C14682();
    private Success successCallback;
    private final Class<?> table;

    class C14671 implements Error {
        C14671() {
        }

        public void onError(Transaction transaction, Throwable th) {
            if (BaseAsyncObject.this.errorCallback != null) {
                BaseAsyncObject.this.errorCallback.onError(transaction, th);
            }
            BaseAsyncObject.this.onError(transaction, th);
            BaseAsyncObject.this.currentTransaction = null;
        }
    }

    class C14682 implements Success {
        C14682() {
        }

        public void onSuccess(Transaction transaction) {
            if (BaseAsyncObject.this.successCallback != null) {
                BaseAsyncObject.this.successCallback.onSuccess(transaction);
            }
            BaseAsyncObject.this.onSuccess(transaction);
            BaseAsyncObject.this.currentTransaction = null;
        }
    }

    protected void onError(Transaction transaction, Throwable th) {
    }

    public void onSuccess(Transaction transaction) {
    }

    public BaseAsyncObject(Class<?> cls) {
        this.table = cls;
        this.databaseDefinition = FlowManager.getDatabaseForTable(cls);
    }

    public Class<?> getTable() {
        return this.table;
    }

    public TAsync error(Error error) {
        this.errorCallback = error;
        return this;
    }

    public TAsync success(Success success) {
        this.successCallback = success;
        return this;
    }

    public void cancel() {
        if (this.currentTransaction != null) {
            this.currentTransaction.cancel();
        }
    }

    protected void executeTransaction(ITransaction iTransaction) {
        cancel();
        this.currentTransaction = this.databaseDefinition.beginTransactionAsync(iTransaction).error(this.error).success(this.success).build();
        this.currentTransaction.execute();
    }
}
