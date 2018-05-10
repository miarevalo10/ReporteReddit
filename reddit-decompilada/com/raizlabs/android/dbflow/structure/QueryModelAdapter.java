package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public abstract class QueryModelAdapter<TQueryModel> extends InstanceAdapter<TQueryModel> {
    public QueryModelAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public OperatorGroup getPrimaryConditionClause(TQueryModel tQueryModel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    public boolean exists(TQueryModel tQueryModel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    public boolean exists(TQueryModel tQueryModel, DatabaseWrapper databaseWrapper) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }
}
