package com.raizlabs.android.dbflow.config;

import android.content.Context;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;
import com.raizlabs.android.dbflow.runtime.ContentResolverNotifier;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.sql.migration.Migration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowSQLiteOpenHelper;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import com.raizlabs.android.dbflow.structure.database.transaction.DefaultTransactionManager;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class DatabaseDefinition {
    private DatabaseConfig databaseConfig;
    private DatabaseHelperListener helperListener;
    private boolean isResetting = false;
    private final Map<Integer, List<Migration>> migrationMap = new HashMap();
    private final Map<Class<?>, ModelAdapter> modelAdapters = new HashMap();
    private ModelNotifier modelNotifier;
    private final Map<String, Class<?>> modelTableNames = new HashMap();
    private final Map<Class<?>, ModelViewAdapter> modelViewAdapterMap = new LinkedHashMap();
    private OpenHelper openHelper;
    private final Map<Class<?>, QueryModelAdapter> queryModelAdapterMap = new LinkedHashMap();
    private BaseTransactionManager transactionManager;

    public abstract boolean areConsistencyChecksEnabled();

    public abstract boolean backupEnabled();

    public abstract Class<?> getAssociatedDatabaseClassFile();

    public abstract int getDatabaseVersion();

    public abstract boolean isForeignKeysSupported();

    public DatabaseDefinition() {
        applyDatabaseConfig((DatabaseConfig) FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile()));
    }

    void applyDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        if (databaseConfig != null) {
            for (TableConfig tableConfig : databaseConfig.tableConfigMap().values()) {
                ModelAdapter modelAdapter = (ModelAdapter) this.modelAdapters.get(tableConfig.tableClass());
                if (modelAdapter != null) {
                    if (tableConfig.listModelLoader() != null) {
                        modelAdapter.setListModelLoader(tableConfig.listModelLoader());
                    }
                    if (tableConfig.singleModelLoader() != null) {
                        modelAdapter.setSingleModelLoader(tableConfig.singleModelLoader());
                    }
                    if (tableConfig.modelSaver() != null) {
                        modelAdapter.setModelSaver(tableConfig.modelSaver());
                    }
                }
            }
            this.helperListener = databaseConfig.helperListener();
        }
        if (databaseConfig != null) {
            if (databaseConfig.transactionManagerCreator() != null) {
                this.transactionManager = databaseConfig.transactionManagerCreator().createManager(this);
                return;
            }
        }
        this.transactionManager = new DefaultTransactionManager(this);
    }

    protected <T> void addModelAdapter(ModelAdapter<T> modelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelAdapter.getModelClass(), this);
        this.modelTableNames.put(modelAdapter.getTableName(), modelAdapter.getModelClass());
        this.modelAdapters.put(modelAdapter.getModelClass(), modelAdapter);
    }

    protected <T> void addModelViewAdapter(ModelViewAdapter<T> modelViewAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(modelViewAdapter.getModelClass(), this);
        this.modelViewAdapterMap.put(modelViewAdapter.getModelClass(), modelViewAdapter);
    }

    protected <T> void addQueryModelAdapter(QueryModelAdapter<T> queryModelAdapter, DatabaseHolder databaseHolder) {
        databaseHolder.putDatabaseForTable(queryModelAdapter.getModelClass(), this);
        this.queryModelAdapterMap.put(queryModelAdapter.getModelClass(), queryModelAdapter);
    }

    protected void addMigration(int i, Migration migration) {
        List list = (List) this.migrationMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            this.migrationMap.put(Integer.valueOf(i), list);
        }
        list.add(migration);
    }

    public List<Class<?>> getModelClasses() {
        return new ArrayList(this.modelAdapters.keySet());
    }

    public BaseTransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    public List<ModelAdapter> getModelAdapters() {
        return new ArrayList(this.modelAdapters.values());
    }

    public <T> ModelAdapter<T> getModelAdapterForTable(Class<T> cls) {
        return (ModelAdapter) this.modelAdapters.get(cls);
    }

    public Class<?> getModelClassForName(String str) {
        return (Class) this.modelTableNames.get(str);
    }

    public List<Class<?>> getModelViews() {
        return new ArrayList(this.modelViewAdapterMap.keySet());
    }

    public <T> ModelViewAdapter<T> getModelViewAdapterForTable(Class<T> cls) {
        return (ModelViewAdapter) this.modelViewAdapterMap.get(cls);
    }

    public List<ModelViewAdapter> getModelViewAdapters() {
        return new ArrayList(this.modelViewAdapterMap.values());
    }

    public List<QueryModelAdapter> getModelQueryAdapters() {
        return new ArrayList(this.queryModelAdapterMap.values());
    }

    public <T> QueryModelAdapter<T> getQueryModelAdapterForQueryClass(Class<T> cls) {
        return (QueryModelAdapter) this.queryModelAdapterMap.get(cls);
    }

    public Map<Integer, List<Migration>> getMigrations() {
        return this.migrationMap;
    }

    public synchronized OpenHelper getHelper() {
        if (this.openHelper == null) {
            DatabaseConfig databaseConfig = (DatabaseConfig) FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig != null) {
                if (databaseConfig.helperCreator() != null) {
                    this.openHelper = databaseConfig.helperCreator().createHelper(this, this.helperListener);
                    this.openHelper.performRestoreFromBackup();
                }
            }
            this.openHelper = new FlowSQLiteOpenHelper(this, this.helperListener);
            this.openHelper.performRestoreFromBackup();
        }
        return this.openHelper;
    }

    public DatabaseWrapper getWritableDatabase() {
        return getHelper().getDatabase();
    }

    public ModelNotifier getModelNotifier() {
        if (this.modelNotifier == null) {
            DatabaseConfig databaseConfig = (DatabaseConfig) FlowManager.getConfig().databaseConfigMap().get(getAssociatedDatabaseClassFile());
            if (databaseConfig != null) {
                if (databaseConfig.modelNotifier() != null) {
                    this.modelNotifier = databaseConfig.modelNotifier();
                }
            }
            this.modelNotifier = new ContentResolverNotifier(FlowManager.DEFAULT_AUTHORITY);
        }
        return this.modelNotifier;
    }

    public Builder beginTransactionAsync(ITransaction iTransaction) {
        return new Builder(iTransaction, this);
    }

    public void executeTransaction(ITransaction iTransaction) {
        DatabaseWrapper writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            iTransaction.execute(writableDatabase);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public String getDatabaseName() {
        return this.databaseConfig != null ? this.databaseConfig.getDatabaseName() : getAssociatedDatabaseClassFile().getSimpleName();
    }

    public String getDatabaseFileName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDatabaseName());
        stringBuilder.append(getDatabaseExtensionName());
        return stringBuilder.toString();
    }

    public String getDatabaseExtensionName() {
        return this.databaseConfig != null ? this.databaseConfig.getDatabaseExtensionName() : ".db";
    }

    public boolean isInMemory() {
        return this.databaseConfig != null && this.databaseConfig.isInMemory();
    }

    @Deprecated
    public void reset(Context context) {
        reset(this.databaseConfig);
    }

    public void reset() {
        reset(this.databaseConfig);
    }

    public void reset(DatabaseConfig databaseConfig) {
        if (!this.isResetting) {
            destroy();
            applyDatabaseConfig(databaseConfig);
            getHelper().getDatabase();
        }
    }

    public void reopen(DatabaseConfig databaseConfig) {
        if (!this.isResetting) {
            close();
            this.openHelper = null;
            applyDatabaseConfig(databaseConfig);
            getHelper().getDatabase();
            this.isResetting = null;
        }
    }

    public void reopen() {
        reopen(this.databaseConfig);
    }

    public void destroy() {
        if (!this.isResetting) {
            this.isResetting = true;
            close();
            FlowManager.getContext().deleteDatabase(getDatabaseFileName());
            this.openHelper = null;
            this.isResetting = false;
        }
    }

    public void close() {
        getTransactionManager().stopQueue();
        for (ModelAdapter modelAdapter : this.modelAdapters.values()) {
            modelAdapter.closeInsertStatement();
            modelAdapter.closeCompiledStatement();
            modelAdapter.closeDeleteStatement();
            modelAdapter.closeUpdateStatement();
        }
        getHelper().closeDB();
    }

    public boolean isDatabaseIntegrityOk() {
        return getHelper().isDatabaseIntegrityOk();
    }

    public void backupDatabase() {
        getHelper().backupDB();
    }
}
