package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public abstract class ModelLoader<TModel, TReturn> {
    private DatabaseDefinition databaseDefinition;
    private InstanceAdapter<TModel> instanceAdapter;
    private final Class<TModel> modelClass;

    public abstract TReturn convertToData(FlowCursor flowCursor, TReturn tReturn);

    public ModelLoader(Class<TModel> cls) {
        this.modelClass = cls;
    }

    public TReturn load(String str) {
        return load(getDatabaseDefinition().getWritableDatabase(), str);
    }

    public TReturn load(String str, TReturn tReturn) {
        return load(getDatabaseDefinition().getWritableDatabase(), str, tReturn);
    }

    public TReturn load(DatabaseWrapper databaseWrapper, String str) {
        return load(databaseWrapper, str, null);
    }

    public TReturn load(DatabaseWrapper databaseWrapper, String str, TReturn tReturn) {
        return load(databaseWrapper.rawQuery(str, null), (Object) tReturn);
    }

    public TReturn load(FlowCursor flowCursor) {
        return load(flowCursor, null);
    }

    public TReturn load(FlowCursor flowCursor, TReturn tReturn) {
        if (flowCursor != null) {
            try {
                tReturn = convertToData(flowCursor, tReturn);
            } finally {
                flowCursor.close();
            }
        }
        return tReturn;
    }

    public Class<TModel> getModelClass() {
        return this.modelClass;
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        if (this.instanceAdapter == null) {
            this.instanceAdapter = FlowManager.getInstanceAdapter(this.modelClass);
        }
        return this.instanceAdapter;
    }

    public DatabaseDefinition getDatabaseDefinition() {
        if (this.databaseDefinition == null) {
            this.databaseDefinition = FlowManager.getDatabaseForTable(this.modelClass);
        }
        return this.databaseDefinition;
    }
}
