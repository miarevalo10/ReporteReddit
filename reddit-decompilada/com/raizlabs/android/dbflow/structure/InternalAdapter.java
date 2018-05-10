package com.raizlabs.android.dbflow.structure;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.Collection;

public interface InternalAdapter<TModel> {
    void bindToContentValues(ContentValues contentValues, TModel tModel);

    void bindToDeleteStatement(DatabaseStatement databaseStatement, TModel tModel);

    void bindToInsertStatement(DatabaseStatement databaseStatement, TModel tModel);

    void bindToInsertStatement(DatabaseStatement databaseStatement, TModel tModel, int i);

    void bindToInsertValues(ContentValues contentValues, TModel tModel);

    void bindToStatement(DatabaseStatement databaseStatement, TModel tModel);

    void bindToUpdateStatement(DatabaseStatement databaseStatement, TModel tModel);

    boolean cachingEnabled();

    boolean delete(TModel tModel);

    boolean delete(TModel tModel, DatabaseWrapper databaseWrapper);

    void deleteAll(Collection<TModel> collection);

    void deleteAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    Number getAutoIncrementingId(TModel tModel);

    String getTableName();

    long insert(TModel tModel);

    long insert(TModel tModel, DatabaseWrapper databaseWrapper);

    void insertAll(Collection<TModel> collection);

    void insertAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    boolean save(TModel tModel);

    boolean save(TModel tModel, DatabaseWrapper databaseWrapper);

    void saveAll(Collection<TModel> collection);

    void saveAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    boolean update(TModel tModel);

    boolean update(TModel tModel, DatabaseWrapper databaseWrapper);

    void updateAll(Collection<TModel> collection);

    void updateAll(Collection<TModel> collection, DatabaseWrapper databaseWrapper);

    void updateAutoIncrement(TModel tModel, Number number);
}
