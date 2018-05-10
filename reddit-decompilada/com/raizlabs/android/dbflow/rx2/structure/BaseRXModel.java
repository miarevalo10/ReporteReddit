package com.raizlabs.android.dbflow.rx2.structure;

import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Completable;
import io.reactivex.Single;

public class BaseRXModel {
    @ColumnIgnore
    private transient RXModelAdapter modelAdapter;

    public Single<Boolean> save() {
        return getRXModelAdapter().save(this);
    }

    public Single<Boolean> save(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().save(this, databaseWrapper);
    }

    public Completable load() {
        return getRXModelAdapter().load(this);
    }

    public Completable load(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().load(this, databaseWrapper);
    }

    public Single<Boolean> delete() {
        return getRXModelAdapter().delete(this);
    }

    public Single<Boolean> delete(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().delete(this, databaseWrapper);
    }

    public Single<Boolean> update() {
        return getRXModelAdapter().update(this);
    }

    public Single<Boolean> update(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().update(this, databaseWrapper);
    }

    public Single<Long> insert() {
        return getRXModelAdapter().insert(this);
    }

    public Single<Long> insert(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().insert(this, databaseWrapper);
    }

    public Single<Boolean> exists() {
        return getRXModelAdapter().exists(this);
    }

    public Single<Boolean> exists(DatabaseWrapper databaseWrapper) {
        return getRXModelAdapter().exists(this, databaseWrapper);
    }

    private RXModelAdapter getRXModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = new RXModelAdapter(getClass());
        }
        return this.modelAdapter;
    }
}
