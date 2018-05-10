package com.raizlabs.android.dbflow.rx2.language;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;

public interface RXModelQueriable<TModel> extends RXQueriable {
    Single<FlowCursorList<TModel>> cursorList();

    RXModelQueriable<TModel> disableCaching();

    Single<FlowQueryList<TModel>> flowQueryList();

    Class<TModel> getTable();

    Flowable<ModelQueriable<TModel>> observeOnTableChanges();

    <TQueryModel> Single<List<TQueryModel>> queryCustomList(Class<TQueryModel> cls);

    <TQueryModel> Maybe<TQueryModel> queryCustomSingle(Class<TQueryModel> cls);

    Single<List<TModel>> queryList();

    Single<List<TModel>> queryList(DatabaseWrapper databaseWrapper);

    Single<CursorResult<TModel>> queryResults();

    Maybe<TModel> querySingle();

    Maybe<TModel> querySingle(DatabaseWrapper databaseWrapper);

    Flowable<TModel> queryStreamResults();
}
