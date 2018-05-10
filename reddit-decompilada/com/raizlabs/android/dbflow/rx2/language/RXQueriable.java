package com.raizlabs.android.dbflow.rx2.language;

import android.database.Cursor;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface RXQueriable {
    Single<DatabaseStatement> compileStatement();

    Single<DatabaseStatement> compileStatement(DatabaseWrapper databaseWrapper);

    Single<Long> count();

    Single<Long> count(DatabaseWrapper databaseWrapper);

    Completable execute();

    Completable execute(DatabaseWrapper databaseWrapper);

    Single<Long> executeInsert();

    Single<Long> executeInsert(DatabaseWrapper databaseWrapper);

    Single<Long> executeUpdateDelete();

    Single<Long> executeUpdateDelete(DatabaseWrapper databaseWrapper);

    Single<Boolean> hasData();

    Single<Boolean> hasData(DatabaseWrapper databaseWrapper);

    Single<Long> longValue();

    Single<Long> longValue(DatabaseWrapper databaseWrapper);

    Maybe<Cursor> query();

    Maybe<Cursor> query(DatabaseWrapper databaseWrapper);
}
