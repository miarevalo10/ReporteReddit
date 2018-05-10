package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import android.database.Cursor;
import com.raizlabs.android.dbflow.rx2.language.RXModelQueriable;
import com.raizlabs.android.dbflow.rx2.language.RXModelQueriableImpl;
import com.raizlabs.android.dbflow.rx2.language.RXQueriable;
import com.raizlabs.android.dbflow.rx2.language.RXQueriableImpl;
import com.raizlabs.android.dbflow.rx2.language.RXSQLite;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020'*\u00020\u00042\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)H\f\u001a#\u0010\u0007\u001a\u00020'*\u00020\u00042\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0)H\f\u001a9\u0010\f\u001a\u00020'\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u001a\b\u0004\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\r\u0012\u0004\u0012\u00020*0)H\f\u001a#\u0010+\u001a\u00020'*\u00020,2\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)H\f\u001a&\u0010+\u001a\u00020'*\u00020,2\u0006\u0010-\u001a\u00020.2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)\u001a#\u0010\u0013\u001a\u00020'*\u00020\u00042\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)H\f\u001a#\u0010/\u001a\u00020'*\u00020,2\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)H\f\u001a&\u0010/\u001a\u00020'*\u00020,2\u0006\u0010-\u001a\u00020.2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)\u001a9\u0010\u0016\u001a\u00020'\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u001a\b\u0004\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0017\u0012\u0004\u0012\u00020*0)H\f\u001a5\u0010\u001a\u001a\u00020'\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0016\b\u0004\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0004\u0012\u00020*0)H\f\u001a(\u00100\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e01\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0%\u001a\u0019\u00100\u001a\u000202\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u000203H\b\u001a#\u00104\u001a\u00020'*\u00020,2\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)H\f\u001a&\u00104\u001a\u00020'*\u00020,2\u0006\u0010-\u001a\u00020.2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)\u001a#\u0010\u001d\u001a\u00020'*\u00020\u00042\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020*0)H\f\u001a5\u0010 \u001a\u00020'\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0016\b\u0004\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0004\u0012\u00020*0)H\f\u001a9\u0010$\u001a\u00020'\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u001a\b\u0004\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0%\u0012\u0004\u0012\u00020*0)H\f\u001a#\u00105\u001a\u00020'*\u00020,2\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)H\f\u001a&\u00105\u001a\u00020'*\u00020,2\u0006\u0010-\u001a\u00020.2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*0)\"$\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\t0\t0\b*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"P\u0010\f\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e\u0018\u00010\r0\r0\u0001\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"$\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00140\u00140\u0001*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006\"P\u0010\u0016\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e\u0018\u00010\u00180\u00170\u0001\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"4\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e0\b\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"$\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u001e0\u001e0\u0001*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006\"4\u0010 \u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e0!\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\"\u0010#\"P\u0010$\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u000eH\u000e\u0018\u00010%0%0!\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b&\u0010#¨\u00066"}, d2 = {"count", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType", "Lcom/raizlabs/android/dbflow/rx2/language/RXQueriable;", "getCount", "(Lcom/raizlabs/android/dbflow/rx2/language/RXQueriable;)Lio/reactivex/Single;", "cursor", "Lio/reactivex/Maybe;", "Landroid/database/Cursor;", "getCursor", "(Lcom/raizlabs/android/dbflow/rx2/language/RXQueriable;)Lio/reactivex/Maybe;", "cursorResult", "Lcom/raizlabs/android/dbflow/sql/language/CursorResult;", "T", "", "Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriable;", "getCursorResult", "(Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriable;)Lio/reactivex/Single;", "hasData", "", "getHasData", "list", "", "", "getList", "result", "getResult", "(Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriable;)Lio/reactivex/Maybe;", "statement", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseStatement;", "getStatement", "streamResults", "Lio/reactivex/Flowable;", "getStreamResults", "(Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriable;)Lio/reactivex/Flowable;", "tableChanges", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "getTableChanges", "Lio/reactivex/disposables/Disposable;", "func", "Lkotlin/Function1;", "", "delete", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "databaseWrapper", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "insert", "rx", "Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriableImpl;", "Lcom/raizlabs/android/dbflow/rx2/language/RXQueriableImpl;", "Lcom/raizlabs/android/dbflow/sql/queriable/Queriable;", "save", "update", "dbflow-rx2-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt {
    public static final <T> RXModelQueriableImpl<T> rx(ModelQueriable<T> modelQueriable) {
        Intrinsics.b(modelQueriable, "$receiver");
        return RXSQLite.rx(modelQueriable);
    }

    private static final <T> RXQueriableImpl rx(Queriable queriable) {
        Intrinsics.b();
        return RXSQLite.rx(Object.class, queriable);
    }

    public static final Single<Long> getCount(RXQueriable rXQueriable) {
        Intrinsics.b(rXQueriable, "$receiver");
        return rXQueriable.count();
    }

    public static final Maybe<Cursor> getCursor(RXQueriable rXQueriable) {
        Intrinsics.b(rXQueriable, "$receiver");
        return rXQueriable.query();
    }

    public static final Single<Boolean> getHasData(RXQueriable rXQueriable) {
        Intrinsics.b(rXQueriable, "$receiver");
        return rXQueriable.hasData();
    }

    public static final Single<DatabaseStatement> getStatement(RXQueriable rXQueriable) {
        Intrinsics.b(rXQueriable, "$receiver");
        return rXQueriable.compileStatement();
    }

    public static final <T> Single<List<T>> getList(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        return rXModelQueriable.queryList();
    }

    public static final <T> Maybe<T> getResult(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        return rXModelQueriable.querySingle();
    }

    public static final <T> Single<CursorResult<T>> getCursorResult(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        return rXModelQueriable.queryResults();
    }

    public static final <T> Flowable<T> getStreamResults(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        return rXModelQueriable.queryStreamResults();
    }

    public static final <T> Flowable<ModelQueriable<T>> getTableChanges(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        return rXModelQueriable.observeOnTableChanges();
    }

    public static final Disposable save(BaseRXModel baseRXModel, DatabaseWrapper databaseWrapper, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(databaseWrapper, "databaseWrapper");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.save(databaseWrapper).subscribe((Consumer) new QueryExtensionsKt$save$1(function1));
        Intrinsics.a(baseRXModel, "save(databaseWrapper).su…uccess -> func(success) }");
        return baseRXModel;
    }

    public static final Disposable save(BaseRXModel baseRXModel, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.save().subscribe(new QueryExtensionsKt$save$2(function1));
        Intrinsics.a(baseRXModel, "save().subscribe { success -> func(success) }");
        return baseRXModel;
    }

    public static final Disposable insert(BaseRXModel baseRXModel, DatabaseWrapper databaseWrapper, Function1<? super Long, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(databaseWrapper, "databaseWrapper");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.insert(databaseWrapper).subscribe((Consumer) new QueryExtensionsKt$insert$1(function1));
        Intrinsics.a(baseRXModel, "insert(databaseWrapper).… { rowId -> func(rowId) }");
        return baseRXModel;
    }

    public static final Disposable insert(BaseRXModel baseRXModel, Function1<? super Long, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.insert().subscribe(new QueryExtensionsKt$insert$2(function1));
        Intrinsics.a(baseRXModel, "insert().subscribe { rowId -> func(rowId) }");
        return baseRXModel;
    }

    public static final Disposable update(BaseRXModel baseRXModel, DatabaseWrapper databaseWrapper, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(databaseWrapper, "databaseWrapper");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.update(databaseWrapper).subscribe((Consumer) new QueryExtensionsKt$update$1(function1));
        Intrinsics.a(baseRXModel, "update(databaseWrapper).…uccess -> func(success) }");
        return baseRXModel;
    }

    public static final Disposable update(BaseRXModel baseRXModel, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.update().subscribe(new QueryExtensionsKt$update$2(function1));
        Intrinsics.a(baseRXModel, "update().subscribe { success -> func(success) }");
        return baseRXModel;
    }

    public static final Disposable delete(BaseRXModel baseRXModel, DatabaseWrapper databaseWrapper, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(databaseWrapper, "databaseWrapper");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.delete(databaseWrapper).subscribe((Consumer) new QueryExtensionsKt$delete$1(function1));
        Intrinsics.a(baseRXModel, "delete(databaseWrapper).…uccess -> func(success) }");
        return baseRXModel;
    }

    public static final Disposable delete(BaseRXModel baseRXModel, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(baseRXModel, "$receiver");
        Intrinsics.b(function1, "func");
        baseRXModel = baseRXModel.delete().subscribe(new QueryExtensionsKt$delete$2(function1));
        Intrinsics.a(baseRXModel, "delete().subscribe { success -> func(success) }");
        return baseRXModel;
    }

    public static final <T> Disposable list(RXModelQueriable<T> rXModelQueriable, Function1<? super List<T>, Unit> function1) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXModelQueriable = rXModelQueriable.queryList().subscribe(new QueryExtensionsKt$list$1(function1));
        Intrinsics.a(rXModelQueriable, "list.subscribe { modelList -> func(modelList) }");
        return rXModelQueriable;
    }

    public static final <T> Disposable result(RXModelQueriable<T> rXModelQueriable, Function1<? super T, Unit> function1) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXModelQueriable = rXModelQueriable.querySingle().subscribe(new QueryExtensionsKt$result$1(function1));
        Intrinsics.a(rXModelQueriable, "result.subscribe { result -> func(result) }");
        return rXModelQueriable;
    }

    public static final <T> Disposable streamResults(RXModelQueriable<T> rXModelQueriable, Function1<? super T, Unit> function1) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXModelQueriable = rXModelQueriable.queryStreamResults().subscribe(new QueryExtensionsKt$streamResults$1(function1));
        Intrinsics.a(rXModelQueriable, "streamResults.subscribe { model -> func(model) }");
        return rXModelQueriable;
    }

    public static final <T> Disposable cursorResult(RXModelQueriable<T> rXModelQueriable, Function1<? super CursorResult<T>, Unit> function1) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXModelQueriable = rXModelQueriable.queryResults().subscribe(new QueryExtensionsKt$cursorResult$1(function1));
        Intrinsics.a(rXModelQueriable, "cursorResult.subscribe { result -> func(result) }");
        return rXModelQueriable;
    }

    public static final <T> Disposable tableChanges(RXModelQueriable<T> rXModelQueriable, Function1<? super ModelQueriable<T>, Unit> function1) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXModelQueriable = rXModelQueriable.observeOnTableChanges().subscribe(new QueryExtensionsKt$tableChanges$1(function1));
        Intrinsics.a(rXModelQueriable, "tableChanges.subscribe {…able -> func(queriable) }");
        return rXModelQueriable;
    }

    public static final Disposable statement(RXQueriable rXQueriable, Function1<? super DatabaseStatement, Unit> function1) {
        Intrinsics.b(rXQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXQueriable = rXQueriable.compileStatement().subscribe(new QueryExtensionsKt$statement$1(function1));
        Intrinsics.a(rXQueriable, "statement.subscribe { st…ment -> func(statement) }");
        return rXQueriable;
    }

    public static final Disposable hasData(RXQueriable rXQueriable, Function1<? super Boolean, Unit> function1) {
        Intrinsics.b(rXQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXQueriable = rXQueriable.hasData().subscribe(new QueryExtensionsKt$hasData$1(function1));
        Intrinsics.a(rXQueriable, "hasData.subscribe { hasData -> func(hasData) }");
        return rXQueriable;
    }

    public static final Disposable cursor(RXQueriable rXQueriable, Function1<? super Cursor, Unit> function1) {
        Intrinsics.b(rXQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXQueriable = rXQueriable.query().subscribe(new QueryExtensionsKt$cursor$1(function1));
        Intrinsics.a(rXQueriable, "cursor.subscribe { cursor -> func(cursor) }");
        return rXQueriable;
    }

    public static final Disposable count(RXQueriable rXQueriable, Function1<? super Long, Unit> function1) {
        Intrinsics.b(rXQueriable, "$receiver");
        Intrinsics.b(function1, "func");
        rXQueriable = rXQueriable.count().subscribe(new QueryExtensionsKt$count$1(function1));
        Intrinsics.a(rXQueriable, "count.subscribe { count -> func(count) }");
        return rXQueriable;
    }
}
