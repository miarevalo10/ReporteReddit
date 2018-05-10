package com.raizlabs.android.dbflow.rx2.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.RetrievalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.concurrent.Callable;

public class RXRetrievalAdapter<TModel> {
    private final RetrievalAdapter<TModel> retrievalAdapter;

    public static <T> RXRetrievalAdapter<T> from(RetrievalAdapter<T> retrievalAdapter) {
        return new RXRetrievalAdapter((RetrievalAdapter) retrievalAdapter);
    }

    public static <T> RXRetrievalAdapter<T> from(Class<T> cls) {
        return new RXRetrievalAdapter((Class) cls);
    }

    RXRetrievalAdapter(RetrievalAdapter<TModel> retrievalAdapter) {
        this.retrievalAdapter = retrievalAdapter;
    }

    RXRetrievalAdapter(Class<TModel> cls) {
        this(FlowManager.getInstanceAdapter(cls));
    }

    public Completable load(final TModel tModel) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXRetrievalAdapter.this.retrievalAdapter.load(tModel);
                return null;
            }
        });
    }

    public Completable load(final TModel tModel, final DatabaseWrapper databaseWrapper) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXRetrievalAdapter.this.retrievalAdapter.load(tModel, databaseWrapper);
                return null;
            }
        });
    }

    public Single<Boolean> exists(final TModel tModel) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXRetrievalAdapter.this.retrievalAdapter.exists(tModel));
            }
        });
    }

    public Single<Boolean> exists(final TModel tModel, final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXRetrievalAdapter.this.retrievalAdapter.exists(tModel, databaseWrapper));
            }
        });
    }
}
