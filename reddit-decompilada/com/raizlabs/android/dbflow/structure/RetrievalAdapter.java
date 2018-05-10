package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.TableConfig;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public abstract class RetrievalAdapter<TModel> {
    private ListModelLoader<TModel> listModelLoader;
    private SingleModelLoader<TModel> singleModelLoader;
    private TableConfig<TModel> tableConfig;

    public abstract boolean exists(TModel tModel, DatabaseWrapper databaseWrapper);

    public abstract Class<TModel> getModelClass();

    public abstract OperatorGroup getPrimaryConditionClause(TModel tModel);

    public abstract void loadFromCursor(FlowCursor flowCursor, TModel tModel);

    public RetrievalAdapter(DatabaseDefinition databaseDefinition) {
        databaseDefinition = FlowManager.getConfig().getConfigForDatabase(databaseDefinition.getAssociatedDatabaseClassFile());
        if (databaseDefinition != null) {
            this.tableConfig = databaseDefinition.getTableConfigForTable(getModelClass());
            if (this.tableConfig != null) {
                if (this.tableConfig.singleModelLoader() != null) {
                    this.singleModelLoader = this.tableConfig.singleModelLoader();
                }
                if (this.tableConfig.listModelLoader() != null) {
                    this.listModelLoader = this.tableConfig.listModelLoader();
                }
            }
        }
    }

    public void load(TModel tModel) {
        load(tModel, FlowManager.getDatabaseForTable(getModelClass()).getWritableDatabase());
    }

    public void load(TModel tModel, DatabaseWrapper databaseWrapper) {
        getNonCacheableSingleModelLoader().load(databaseWrapper, SQLite.select(new IProperty[0]).from(getModelClass()).where(getPrimaryConditionClause(tModel)).getQuery(), tModel);
    }

    public boolean exists(TModel tModel) {
        return exists(tModel, FlowManager.getDatabaseForTable(getModelClass()).getWritableDatabase());
    }

    protected TableConfig<TModel> getTableConfig() {
        return this.tableConfig;
    }

    public ListModelLoader<TModel> getListModelLoader() {
        if (this.listModelLoader == null) {
            this.listModelLoader = createListModelLoader();
        }
        return this.listModelLoader;
    }

    public ListModelLoader<TModel> createListModelLoader() {
        return new ListModelLoader(getModelClass());
    }

    public SingleModelLoader<TModel> createSingleModelLoader() {
        return new SingleModelLoader(getModelClass());
    }

    public SingleModelLoader<TModel> getSingleModelLoader() {
        if (this.singleModelLoader == null) {
            this.singleModelLoader = createSingleModelLoader();
        }
        return this.singleModelLoader;
    }

    public SingleModelLoader<TModel> getNonCacheableSingleModelLoader() {
        return new SingleModelLoader(getModelClass());
    }

    public ListModelLoader<TModel> getNonCacheableListModelLoader() {
        return new ListModelLoader(getModelClass());
    }

    public void setSingleModelLoader(SingleModelLoader<TModel> singleModelLoader) {
        this.singleModelLoader = singleModelLoader;
    }

    public void setListModelLoader(ListModelLoader<TModel> listModelLoader) {
        this.listModelLoader = listModelLoader;
    }
}
