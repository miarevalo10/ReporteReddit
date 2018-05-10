package com.raizlabs.android.dbflow.rx2.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.RetrievalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Collection;
import java.util.concurrent.Callable;

public class RXModelAdapter<T> extends RXRetrievalAdapter<T> {
    private final ModelAdapter<T> modelAdapter;

    public static <T> RXModelAdapter<T> from(ModelAdapter<T> modelAdapter) {
        return new RXModelAdapter((ModelAdapter) modelAdapter);
    }

    public static <T> RXModelAdapter<T> from(Class<T> cls) {
        return new RXModelAdapter((Class) cls);
    }

    RXModelAdapter(ModelAdapter<T> modelAdapter) {
        super((RetrievalAdapter) modelAdapter);
        this.modelAdapter = modelAdapter;
    }

    public RXModelAdapter(Class<T> cls) {
        this(FlowManager.getModelAdapter(cls));
    }

    public Single<Boolean> save(final T t) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.save(t));
            }
        });
    }

    public Single<Boolean> save(final T t, final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.save(t, databaseWrapper));
            }
        });
    }

    public Completable saveAll(final Collection<T> collection) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.saveAll(collection);
                return null;
            }
        });
    }

    public Completable saveAll(final Collection<T> collection, final DatabaseWrapper databaseWrapper) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.saveAll(collection, databaseWrapper);
                return null;
            }
        });
    }

    public Single<Long> insert(final T t) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXModelAdapter.this.modelAdapter.insert(t));
            }
        });
    }

    public Single<Long> insert(final T t, final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(RXModelAdapter.this.modelAdapter.insert(t, databaseWrapper));
            }
        });
    }

    public Completable insertAll(final Collection<T> collection) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.insertAll(collection);
                return null;
            }
        });
    }

    public Completable insertAll(final Collection<T> collection, final DatabaseWrapper databaseWrapper) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.insertAll(collection, databaseWrapper);
                return null;
            }
        });
    }

    public Single<Boolean> update(final T t) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.update(t));
            }
        });
    }

    public Single<Boolean> update(final T t, final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.update(t, databaseWrapper));
            }
        });
    }

    public Completable updateAll(final Collection<T> collection) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.updateAll(collection);
                return null;
            }
        });
    }

    public Completable updateAll(final Collection<T> collection, final DatabaseWrapper databaseWrapper) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.updateAll(collection, databaseWrapper);
                return null;
            }
        });
    }

    public Single<Boolean> delete(final T t) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.delete(t));
            }
        });
    }

    public Single<Boolean> delete(final T t, final DatabaseWrapper databaseWrapper) {
        return Single.fromCallable(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(RXModelAdapter.this.modelAdapter.delete(t, databaseWrapper));
            }
        });
    }

    public Completable deleteAll(final Collection<T> collection) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.deleteAll(collection);
                return null;
            }
        });
    }

    public Completable deleteAll(final Collection<T> collection, final DatabaseWrapper databaseWrapper) {
        return Completable.fromCallable(new Callable<Void>() {
            public Void call() throws Exception {
                RXModelAdapter.this.modelAdapter.deleteAll(collection, databaseWrapper);
                return null;
            }
        });
    }
}
