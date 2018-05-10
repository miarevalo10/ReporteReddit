package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.BaseAsyncObject;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.lang.ref.WeakReference;

public class AsyncModel<TModel> extends BaseAsyncObject<AsyncModel<TModel>> implements Model {
    private final TModel model;
    private ModelAdapter<TModel> modelAdapter;
    private transient WeakReference<OnModelChangedListener<TModel>> onModelChangedListener;

    public interface OnModelChangedListener<T> {
        void onModelChanged(T t);
    }

    class C14701 implements ProcessModel<TModel> {
        C14701() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            AsyncModel.this.getModelAdapter().save(tModel, databaseWrapper);
        }
    }

    class C14712 implements ProcessModel<TModel> {
        C14712() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            AsyncModel.this.getModelAdapter().delete(tModel, databaseWrapper);
        }
    }

    class C14723 implements ProcessModel<TModel> {
        C14723() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            AsyncModel.this.getModelAdapter().update(tModel, databaseWrapper);
        }
    }

    class C14734 implements ProcessModel<TModel> {
        C14734() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            AsyncModel.this.getModelAdapter().insert(tModel, databaseWrapper);
        }
    }

    class C14745 implements ProcessModel<TModel> {
        C14745() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            AsyncModel.this.getModelAdapter().load(tModel, databaseWrapper);
        }
    }

    public AsyncModel<? extends Model> async() {
        return this;
    }

    public AsyncModel(TModel tModel) {
        super(tModel.getClass());
        this.model = tModel;
    }

    public AsyncModel<TModel> withListener(OnModelChangedListener<TModel> onModelChangedListener) {
        this.onModelChangedListener = new WeakReference(onModelChangedListener);
        return this;
    }

    private ModelAdapter<TModel> getModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = FlowManager.getModelAdapter(this.model.getClass());
        }
        return this.modelAdapter;
    }

    public boolean save(DatabaseWrapper databaseWrapper) {
        return save();
    }

    public boolean save() {
        executeTransaction(new Builder(new C14701()).add(this.model).build());
        return false;
    }

    public boolean delete(DatabaseWrapper databaseWrapper) {
        return delete();
    }

    public boolean delete() {
        executeTransaction(new Builder(new C14712()).add(this.model).build());
        return false;
    }

    public boolean update(DatabaseWrapper databaseWrapper) {
        return update();
    }

    public boolean update() {
        executeTransaction(new Builder(new C14723()).add(this.model).build());
        return false;
    }

    public long insert(DatabaseWrapper databaseWrapper) {
        return insert();
    }

    public long insert() {
        executeTransaction(new Builder(new C14734()).add(this.model).build());
        return -1;
    }

    public void load(DatabaseWrapper databaseWrapper) {
        load();
    }

    public void load() {
        executeTransaction(new Builder(new C14745()).add(this.model).build());
    }

    public boolean exists(DatabaseWrapper databaseWrapper) {
        return exists();
    }

    public boolean exists() {
        return getModelAdapter().exists(this.model);
    }

    protected void onSuccess(Transaction transaction) {
        if (this.onModelChangedListener != null && this.onModelChangedListener.get() != null) {
            ((OnModelChangedListener) this.onModelChangedListener.get()).onModelChanged(this.model);
        }
    }
}
