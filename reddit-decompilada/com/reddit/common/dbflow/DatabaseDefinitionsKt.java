package com.reddit.common.dbflow;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u00020\t*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\n"}, d2 = {"executeRxTransaction", "Lio/reactivex/Single;", "", "Lcom/raizlabs/android/dbflow/config/DatabaseDefinition;", "transaction", "Lkotlin/Function0;", "", "Lcom/raizlabs/android/dbflow/structure/database/transaction/ITransaction;", "executeRxTransactionCompletable", "Lio/reactivex/Completable;", "common_release"}, k = 2, mv = {1, 1, 9})
/* compiled from: DatabaseDefinitions.kt */
public final class DatabaseDefinitionsKt {
    public static final Single<Boolean> m8723a(DatabaseDefinition databaseDefinition, Function0<Unit> function0) {
        Intrinsics.b(databaseDefinition, "$receiver");
        Intrinsics.b(function0, "transaction");
        databaseDefinition = Single.create(new DatabaseDefinitionsKt$executeRxTransaction$1(databaseDefinition, function0));
        Intrinsics.a(databaseDefinition, "Single.create<Boolean> {…         .execute()\n    }");
        return databaseDefinition;
    }

    public static final Completable m8724b(DatabaseDefinition databaseDefinition, Function0<Unit> function0) {
        Intrinsics.b(databaseDefinition, "$receiver");
        Intrinsics.b(function0, "transaction");
        databaseDefinition = Single.create(new DatabaseDefinitionsKt$executeRxTransactionCompletable$1(databaseDefinition, function0)).flatMapCompletable((Function) DatabaseDefinitionsKt$executeRxTransactionCompletable$2.f15712a);
        Intrinsics.a(databaseDefinition, "Single.create<Boolean> {…lse Completable.never() }");
        return databaseDefinition;
    }

    public static final Single<Boolean> m8722a(DatabaseDefinition databaseDefinition, ITransaction iTransaction) {
        Intrinsics.b(databaseDefinition, "$receiver");
        Intrinsics.b(iTransaction, "transaction");
        databaseDefinition = Single.create(new DatabaseDefinitionsKt$executeRxTransaction$2(databaseDefinition, iTransaction));
        Intrinsics.a(databaseDefinition, "Single.create<Boolean> {…         .execute()\n    }");
        return databaseDefinition;
    }
}
