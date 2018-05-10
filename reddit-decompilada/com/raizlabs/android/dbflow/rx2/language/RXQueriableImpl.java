package com.raizlabs.android.dbflow.rx2.language;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.concurrent.Callable;

public class RXQueriableImpl implements RXQueriable {
    private final Queriable queriable;
    private final Class<?> table;

    class C08501 implements Callable<Cursor> {
        C08501() {
        }

        public Cursor call() throws Exception {
            return RXQueriableImpl.this.getInnerQueriable().query();
        }
    }

    class C08523 implements Callable<DatabaseStatement> {
        C08523() {
        }

        public DatabaseStatement call() throws Exception {
            return RXQueriableImpl.this.getInnerQueriable().compileStatement();
        }
    }

    class C08545 implements Callable<Long> {
        C08545() {
        }

        public Long call() throws Exception {
            return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().count());
        }
    }

    class C08567 implements Callable<Long> {
        C08567() {
        }

        public Long call() throws Exception {
            return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().longValue());
        }
    }

    class C08589 implements Callable<Long> {
        C08589() {
        }

        public Long call() throws Exception {
            return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().executeInsert(FlowManager.getWritableDatabaseForTable(RXQueriableImpl.this.table)));
        }
    }

    public RXQueriableImpl(Class<?> cls, Queriable queriable) {
        this.table = cls;
        this.queriable = queriable;
    }

    private Queriable getInnerQueriable() {
        return this.queriable;
    }

    public Maybe<Cursor> query() {
        return Maybe.fromCallable(new C08501());
    }

    public Maybe<Cursor> query(final DatabaseWrapper databaseWrapper) {
        return Maybe.fromCallable(new Callable<Cursor>() {
            public Cursor call() throws Exception {
                return RXQueriableImpl.this.getInnerQueriable().query(databaseWrapper);
            }
        });
    }

    public Single<DatabaseStatement> compileStatement() {
        return Single.fromCallable(new C08523());
    }

    public Single<DatabaseStatement> compileStatement(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<DatabaseStatement>() {
            public DatabaseStatement call() throws Exception {
                return RXQueriableImpl.this.getInnerQueriable().compileStatement(databaseWrapper);
            }
        });
    }

    public Single<Long> count() {
        return Single.fromCallable(new C08545());
    }

    public Single<Long> count(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().count(databaseWrapper));
            }
        });
    }

    public Single<Long> longValue() {
        return Single.fromCallable(new C08567());
    }

    public Single<Long> longValue(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().longValue(databaseWrapper));
            }
        });
    }

    public Single<Long> executeInsert() {
        return Single.fromCallable(new C08589());
    }

    public Single<Long> executeInsert(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().executeInsert(databaseWrapper));
            }
        });
    }

    public Single<Long> executeUpdateDelete(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().executeUpdateDelete(databaseWrapper));
            }
        });
    }

    public Single<Long> executeUpdateDelete() {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXQueriableImpl.this.getInnerQueriable().executeUpdateDelete());
            }
        });
    }

    public Single<Boolean> hasData() {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXQueriableImpl.this.getInnerQueriable().hasData());
            }
        });
    }

    public Single<Boolean> hasData(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXQueriableImpl.this.getInnerQueriable().hasData(databaseWrapper));
            }
        });
    }

    public Completable execute() {
        return Completable.fromRunnable(new Runnable() {
            public void run() {
                RXQueriableImpl.this.getInnerQueriable().execute();
            }
        });
    }

    public Completable execute(final DatabaseWrapper databaseWrapper) {
        return Completable.fromRunnable(new Runnable() {
            public void run() {
                RXQueriableImpl.this.getInnerQueriable().execute(databaseWrapper);
            }
        });
    }
}
