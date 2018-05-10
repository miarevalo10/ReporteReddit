package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowLog.Level;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.structure.BaseModel.Action;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public class AutoIncrementModelSaver<TModel> extends ModelSaver<TModel> {
    public synchronized long insert(TModel tModel) {
        return insert(tModel, getWritableDatabase());
    }

    public synchronized long insert(TModel tModel, DatabaseWrapper databaseWrapper) {
        DatabaseStatement compiledStatement;
        long executeInsert;
        boolean hasAutoIncrement = getModelAdapter().hasAutoIncrement(tModel);
        if (hasAutoIncrement) {
            compiledStatement = getModelAdapter().getCompiledStatement(databaseWrapper);
        } else {
            compiledStatement = getModelAdapter().getInsertStatement(databaseWrapper);
        }
        try {
            getModelAdapter().saveForeignKeys(tModel, databaseWrapper);
            if (hasAutoIncrement) {
                getModelAdapter().bindToStatement(compiledStatement, tModel);
            } else {
                getModelAdapter().bindToInsertStatement(compiledStatement, tModel);
            }
            executeInsert = compiledStatement.executeInsert();
            if (executeInsert > -1) {
                getModelAdapter().updateAutoIncrement(tModel, Long.valueOf(executeInsert));
                NotifyDistributor.get().notifyModelChanged(tModel, getModelAdapter(), Action.INSERT);
            }
        } finally {
            compiledStatement.close();
        }
        return executeInsert;
    }

    public synchronized long insert(TModel tModel, DatabaseStatement databaseStatement, DatabaseWrapper databaseWrapper) {
        if (getModelAdapter().hasAutoIncrement(tModel)) {
            Level level = Level.W;
            StringBuilder stringBuilder = new StringBuilder("Ignoring insert statement ");
            stringBuilder.append(databaseStatement);
            stringBuilder.append(" since an autoincrement column specified in the insert.");
            FlowLog.log(level, stringBuilder.toString());
            return insert(tModel, databaseWrapper);
        }
        return super.insert(tModel, databaseStatement, databaseWrapper);
    }
}
