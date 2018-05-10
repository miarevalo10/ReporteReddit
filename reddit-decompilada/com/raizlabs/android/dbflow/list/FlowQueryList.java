package com.raizlabs.android.dbflow.list;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorList.OnCursorRefreshListener;
import com.raizlabs.android.dbflow.runtime.FlowContentObserver;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class FlowQueryList<TModel> extends FlowContentObserver implements IFlowCursorIterator<TModel>, List<TModel> {
    private static final Handler REFRESH_HANDLER = new Handler(Looper.myLooper());
    private boolean changeInTransaction;
    private final ProcessModel<TModel> deleteModel;
    private final Error errorCallback;
    private final FlowCursorList<TModel> internalCursorList;
    private final Error internalErrorCallback;
    private final Success internalSuccessCallback;
    private boolean pendingRefresh;
    private final Runnable refreshRunnable;
    private final ProcessModel<TModel> saveModel;
    private final Success successCallback;
    private boolean transact;
    private final ProcessModel<TModel> updateModel;

    class C08376 implements Runnable {
        C08376() {
        }

        public void run() {
            synchronized (this) {
                FlowQueryList.this.pendingRefresh = false;
            }
            FlowQueryList.this.refresh();
        }
    }

    public static class Builder<TModel> {
        private boolean cacheModels;
        private boolean changeInTransaction;
        private String contentAuthority;
        private Cursor cursor;
        private Error error;
        private ModelCache<TModel, ?> modelCache;
        private ModelQueriable<TModel> modelQueriable;
        private Success success;
        private final Class<TModel> table;
        private boolean transact;

        private Builder(FlowCursorList<TModel> flowCursorList) {
            this.cacheModels = true;
            this.table = flowCursorList.table();
            this.cursor = flowCursorList.cursor();
            this.cacheModels = flowCursorList.cachingEnabled();
            this.modelQueriable = flowCursorList.modelQueriable();
            this.modelCache = flowCursorList.modelCache();
        }

        public Builder(Class<TModel> cls) {
            this.cacheModels = true;
            this.table = cls;
        }

        public Builder(ModelQueriable<TModel> modelQueriable) {
            this(modelQueriable.getTable());
            modelQueriable(modelQueriable);
        }

        public Builder<TModel> cursor(Cursor cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder<TModel> modelQueriable(ModelQueriable<TModel> modelQueriable) {
            this.modelQueriable = modelQueriable;
            return this;
        }

        public Builder<TModel> transact(boolean z) {
            this.transact = z;
            return this;
        }

        public Builder<TModel> modelCache(ModelCache<TModel, ?> modelCache) {
            this.modelCache = modelCache;
            return this;
        }

        public Builder<TModel> contentAuthority(String str) {
            this.contentAuthority = str;
            return this;
        }

        public Builder<TModel> changeInTransaction(boolean z) {
            this.changeInTransaction = z;
            return this;
        }

        public Builder<TModel> cacheModels(boolean z) {
            this.cacheModels = z;
            return this;
        }

        public Builder<TModel> success(Success success) {
            this.success = success;
            return this;
        }

        public Builder<TModel> error(Error error) {
            this.error = error;
            return this;
        }

        public FlowQueryList<TModel> build() {
            return new FlowQueryList();
        }
    }

    class C14541 implements ProcessModel<TModel> {
        C14541() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            FlowQueryList.this.getModelAdapter().save(tModel);
        }
    }

    class C14552 implements ProcessModel<TModel> {
        C14552() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            FlowQueryList.this.getModelAdapter().update(tModel);
        }
    }

    class C14563 implements ProcessModel<TModel> {
        C14563() {
        }

        public void processModel(TModel tModel, DatabaseWrapper databaseWrapper) {
            FlowQueryList.this.getModelAdapter().delete(tModel);
        }
    }

    class C14574 implements Error {
        C14574() {
        }

        public void onError(Transaction transaction, Throwable th) {
            if (FlowQueryList.this.errorCallback != null) {
                FlowQueryList.this.errorCallback.onError(transaction, th);
            }
        }
    }

    class C14585 implements Success {
        C14585() {
        }

        public void onSuccess(Transaction transaction) {
            if (FlowQueryList.this.isInTransaction) {
                FlowQueryList.this.changeInTransaction = true;
            } else {
                FlowQueryList.this.refreshAsync();
            }
            if (FlowQueryList.this.successCallback != null) {
                FlowQueryList.this.successCallback.onSuccess(transaction);
            }
        }
    }

    private FlowQueryList(Builder<TModel> builder) {
        super(StringUtils.isNotNullOrEmpty(builder.contentAuthority) ? builder.contentAuthority : FlowManager.DEFAULT_AUTHORITY);
        this.transact = false;
        this.changeInTransaction = false;
        this.pendingRefresh = false;
        this.saveModel = new C14541();
        this.updateModel = new C14552();
        this.deleteModel = new C14563();
        this.internalErrorCallback = new C14574();
        this.internalSuccessCallback = new C14585();
        this.refreshRunnable = new C08376();
        this.transact = builder.transact;
        this.changeInTransaction = builder.changeInTransaction;
        this.successCallback = builder.success;
        this.errorCallback = builder.error;
        this.internalCursorList = new com.raizlabs.android.dbflow.list.FlowCursorList.Builder(builder.table).cursor(builder.cursor).cacheModels(builder.cacheModels).modelQueriable(builder.modelQueriable).modelCache(builder.modelCache).build();
    }

    public void registerForContentChanges(Context context) {
        super.registerForContentChanges(context, this.internalCursorList.table());
    }

    public void addOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.addOnCursorRefreshListener(onCursorRefreshListener);
    }

    public void removeOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.removeOnCursorRefreshListener(onCursorRefreshListener);
    }

    public void registerForContentChanges(Context context, Class<?> cls) {
        throw new RuntimeException("This method is not to be used in the FlowQueryList. We should only ever receive notifications for one class here. Call registerForContentChanges(Context) instead");
    }

    public void onChange(boolean z) {
        super.onChange(z);
        if (this.isInTransaction) {
            this.changeInTransaction = true;
        } else {
            refreshAsync();
        }
    }

    @TargetApi(16)
    public void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        if (this.isInTransaction) {
            this.changeInTransaction = true;
        } else {
            refreshAsync();
        }
    }

    public List<TModel> getCopy() {
        return this.internalCursorList.getAll();
    }

    public FlowCursorList<TModel> cursorList() {
        return this.internalCursorList;
    }

    public Error error() {
        return this.errorCallback;
    }

    public Success success() {
        return this.successCallback;
    }

    public boolean changeInTransaction() {
        return this.changeInTransaction;
    }

    public boolean transact() {
        return this.transact;
    }

    ModelAdapter<TModel> getModelAdapter() {
        return this.internalCursorList.getModelAdapter();
    }

    InstanceAdapter<TModel> getInstanceAdapter() {
        return this.internalCursorList.getInstanceAdapter();
    }

    public Builder<TModel> newBuilder() {
        return new Builder(this.internalCursorList).success(this.successCallback).error(this.errorCallback).changeInTransaction(this.changeInTransaction).transact(this.transact);
    }

    public void refresh() {
        this.internalCursorList.refresh();
    }

    public void refreshAsync() {
        synchronized (this) {
            if (this.pendingRefresh) {
                return;
            }
            this.pendingRefresh = true;
            REFRESH_HANDLER.post(this.refreshRunnable);
        }
    }

    public void endTransactionAndNotify() {
        if (this.changeInTransaction) {
            this.changeInTransaction = false;
            refresh();
        }
        super.endTransactionAndNotify();
    }

    public void add(int i, TModel tModel) {
        add(tModel);
    }

    public boolean add(TModel tModel) {
        if (tModel == null) {
            return null;
        }
        tModel = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.saveModel).add(tModel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            tModel.execute();
        } else {
            tModel.executeSync();
        }
        return true;
    }

    public boolean addAll(int i, Collection<? extends TModel> collection) {
        return addAll(collection);
    }

    public boolean addAll(Collection<? extends TModel> collection) {
        collection = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.saveModel).addAll((Collection) collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            collection.execute();
        } else {
            collection.executeSync();
        }
        return true;
    }

    public void clear() {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.Builder(SQLite.delete().from(this.internalCursorList.table())).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
    }

    public boolean contains(Object obj) {
        return (obj == null || !this.internalCursorList.table().isAssignableFrom(obj.getClass())) ? null : this.internalCursorList.getInstanceAdapter().exists(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        boolean isEmpty = collection.isEmpty() ^ 1;
        if (!isEmpty) {
            return isEmpty;
        }
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return isEmpty;
    }

    public long getCount() {
        return this.internalCursorList.getCount();
    }

    public TModel getItem(long j) {
        return this.internalCursorList.getItem(j);
    }

    public Cursor cursor() {
        return this.internalCursorList.cursor();
    }

    public TModel get(int i) {
        return this.internalCursorList.getItem((long) i);
    }

    public int indexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    public boolean isEmpty() {
        return this.internalCursorList.isEmpty();
    }

    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator(this);
    }

    public FlowCursorIterator<TModel> iterator(int i, long j) {
        return new FlowCursorIterator(this, i, j);
    }

    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    public ListIterator<TModel> listIterator() {
        return new FlowCursorIterator(this);
    }

    public ListIterator<TModel> listIterator(int i) {
        return new FlowCursorIterator(this, i);
    }

    public TModel remove(int i) {
        i = this.internalCursorList.getItem((long) i);
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.deleteModel).add(i).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return i;
    }

    public boolean remove(Object obj) {
        if (!this.internalCursorList.table().isAssignableFrom(obj.getClass())) {
            return null;
        }
        obj = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.deleteModel).add(obj).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            obj.execute();
        } else {
            obj.executeSync();
        }
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        collection = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.deleteModel).addAll((Collection) collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            collection.execute();
        } else {
            collection.executeSync();
        }
        return true;
    }

    public boolean retainAll(Collection<?> collection) {
        Collection all = this.internalCursorList.getAll();
        all.removeAll(collection);
        collection = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(all, this.deleteModel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            collection.execute();
        } else {
            collection.executeSync();
        }
        return true;
    }

    public TModel set(int i, TModel tModel) {
        return set(tModel);
    }

    public TModel set(TModel tModel) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder(this.updateModel).add(tModel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return tModel;
    }

    public int size() {
        return (int) this.internalCursorList.getCount();
    }

    public List<TModel> subList(int i, int i2) {
        return this.internalCursorList.getAll().subList(i, i2);
    }

    public Object[] toArray() {
        return this.internalCursorList.getAll().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.internalCursorList.getAll().toArray(tArr);
    }

    public void close() {
        this.internalCursorList.close();
    }
}
