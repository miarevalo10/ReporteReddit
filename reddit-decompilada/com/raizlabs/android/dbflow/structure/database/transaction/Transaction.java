package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;

public final class Transaction {
    private static Handler TRANSACTION_HANDLER;
    final DatabaseDefinition databaseDefinition;
    final Error errorCallback;
    final String name;
    final boolean runCallbacksOnSameThread;
    final boolean shouldRunInTransaction;
    final Success successCallback;
    final ITransaction transaction;

    class C08811 implements Runnable {
        C08811() {
        }

        public void run() {
            Transaction.this.successCallback.onSuccess(Transaction.this);
        }
    }

    public static final class Builder {
        final DatabaseDefinition databaseDefinition;
        Error errorCallback;
        String name;
        private boolean runCallbacksOnSameThread;
        boolean shouldRunInTransaction = true;
        Success successCallback;
        final ITransaction transaction;

        public Builder(ITransaction iTransaction, DatabaseDefinition databaseDefinition) {
            this.transaction = iTransaction;
            this.databaseDefinition = databaseDefinition;
        }

        public final Builder error(Error error) {
            this.errorCallback = error;
            return this;
        }

        public final Builder success(Success success) {
            this.successCallback = success;
            return this;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder shouldRunInTransaction(boolean z) {
            this.shouldRunInTransaction = z;
            return this;
        }

        public final Builder runCallbacksOnSameThread(boolean z) {
            this.runCallbacksOnSameThread = z;
            return this;
        }

        public final Transaction build() {
            return new Transaction(this);
        }

        public final void execute() {
            build().execute();
        }
    }

    public interface Error {
        void onError(Transaction transaction, Throwable th);
    }

    public interface Success {
        void onSuccess(Transaction transaction);
    }

    static Handler getTransactionHandler() {
        if (TRANSACTION_HANDLER == null) {
            TRANSACTION_HANDLER = new Handler(Looper.getMainLooper());
        }
        return TRANSACTION_HANDLER;
    }

    Transaction(Builder builder) {
        this.databaseDefinition = builder.databaseDefinition;
        this.errorCallback = builder.errorCallback;
        this.successCallback = builder.successCallback;
        this.transaction = builder.transaction;
        this.name = builder.name;
        this.shouldRunInTransaction = builder.shouldRunInTransaction;
        this.runCallbacksOnSameThread = builder.runCallbacksOnSameThread;
    }

    public final Error error() {
        return this.errorCallback;
    }

    public final Success success() {
        return this.successCallback;
    }

    public final ITransaction transaction() {
        return this.transaction;
    }

    public final String name() {
        return this.name;
    }

    public final void execute() {
        this.databaseDefinition.getTransactionManager().addTransaction(this);
    }

    public final void cancel() {
        this.databaseDefinition.getTransactionManager().cancelTransaction(this);
    }

    public final void executeSync() {
        try {
            if (this.shouldRunInTransaction) {
                this.databaseDefinition.executeTransaction(this.transaction);
            } else {
                this.transaction.execute(this.databaseDefinition.getWritableDatabase());
            }
            if (this.successCallback != null) {
                if (this.runCallbacksOnSameThread) {
                    this.successCallback.onSuccess(this);
                    return;
                }
                getTransactionHandler().post(new C08811());
            }
        } catch (final Throwable th) {
            FlowLog.logError(th);
            if (this.errorCallback == null) {
                RuntimeException runtimeException = new RuntimeException("An exception occurred while executing a transaction", th);
            } else if (this.runCallbacksOnSameThread) {
                this.errorCallback.onError(this, th);
            } else {
                getTransactionHandler().post(new Runnable() {
                    public void run() {
                        Transaction.this.errorCallback.onError(Transaction.this, th);
                    }
                });
            }
        }
    }

    public final Builder newBuilder() {
        return new Builder(this.transaction, this.databaseDefinition).error(this.errorCallback).success(this.successCallback).name(this.name).shouldRunInTransaction(this.shouldRunInTransaction).runCallbacksOnSameThread(this.runCallbacksOnSameThread);
    }
}
