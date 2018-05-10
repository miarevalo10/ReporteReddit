package com.raizlabs.android.dbflow.rx2.language;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;

public class RXModelQueriableImpl<T> extends RXQueriableImpl implements RXModelQueriable<T> {
    private final ModelQueriable<T> modelQueriable;

    class C08411 implements Callable<CursorResult<T>> {
        C08411() {
        }

        public CursorResult<T> call() throws Exception {
            return RXModelQueriableImpl.this.getInnerModelQueriable().queryResults();
        }
    }

    class C08422 implements Callable<List<T>> {
        C08422() {
        }

        public List<T> call() throws Exception {
            return RXModelQueriableImpl.this.getInnerModelQueriable().queryList();
        }
    }

    class C08444 implements Callable<T> {
        C08444() {
        }

        public T call() throws Exception {
            return RXModelQueriableImpl.this.getInnerModelQueriable().querySingle();
        }
    }

    class C08466 implements Callable<FlowCursorList<T>> {
        C08466() {
        }

        public FlowCursorList<T> call() throws Exception {
            return RXModelQueriableImpl.this.getInnerModelQueriable().cursorList();
        }
    }

    class C08477 implements Callable<FlowQueryList<T>> {
        C08477() {
        }

        public FlowQueryList<T> call() throws Exception {
            return RXModelQueriableImpl.this.getInnerModelQueriable().flowQueryList();
        }
    }

    public RXModelQueriableImpl(ModelQueriable<T> modelQueriable) {
        super(modelQueriable.getTable(), modelQueriable);
        this.modelQueriable = modelQueriable;
    }

    private ModelQueriable<T> getInnerModelQueriable() {
        return this.modelQueriable;
    }

    public Flowable<T> queryStreamResults() {
        return new CursorResultFlowable(this);
    }

    public Single<CursorResult<T>> queryResults() {
        return Single.fromCallable(new C08411());
    }

    public Single<List<T>> queryList() {
        return Single.fromCallable(new C08422());
    }

    public Single<List<T>> queryList(final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<List<T>>() {
            public List<T> call() throws Exception {
                return RXModelQueriableImpl.this.getInnerModelQueriable().queryList(databaseWrapper);
            }
        });
    }

    public Maybe<T> querySingle() {
        return Maybe.fromCallable(new C08444());
    }

    public Maybe<T> querySingle(final DatabaseWrapper databaseWrapper) {
        return Maybe.fromCallable(new Callable<T>() {
            public T call() throws Exception {
                return RXModelQueriableImpl.this.getInnerModelQueriable().querySingle(databaseWrapper);
            }
        });
    }

    public Class<T> getTable() {
        return getInnerModelQueriable().getTable();
    }

    public Single<FlowCursorList<T>> cursorList() {
        return Single.fromCallable(new C08466());
    }

    public Single<FlowQueryList<T>> flowQueryList() {
        return Single.fromCallable(new C08477());
    }

    public <TQueryModel> Single<List<TQueryModel>> queryCustomList(final Class<TQueryModel> cls) {
        return Single.fromCallable(new Callable<List<TQueryModel>>() {
            public List<TQueryModel> call() throws Exception {
                return RXModelQueriableImpl.this.getInnerModelQueriable().queryCustomList(cls);
            }
        });
    }

    public <TQueryModel> Maybe<TQueryModel> queryCustomSingle(final Class<TQueryModel> cls) {
        return Maybe.fromCallable(new Callable<TQueryModel>() {
            public TQueryModel call() throws Exception {
                return RXModelQueriableImpl.this.getInnerModelQueriable().queryCustomSingle(cls);
            }
        });
    }

    public RXModelQueriable<T> disableCaching() {
        getInnerModelQueriable().disableCaching();
        return this;
    }

    public Flowable<ModelQueriable<T>> observeOnTableChanges() {
        return Flowable.create(new TableChangeOnSubscribe(getInnerModelQueriable()), BackpressureStrategy.e);
    }
}
