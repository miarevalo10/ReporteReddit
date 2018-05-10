package com.reddit.common.dbflow;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseDefinitions.kt */
final class DatabaseDefinitionsKt$executeRxTransaction$2<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ DatabaseDefinition f15705a;
    final /* synthetic */ ITransaction f15706b;

    DatabaseDefinitionsKt$executeRxTransaction$2(DatabaseDefinition databaseDefinition, ITransaction iTransaction) {
        this.f15705a = databaseDefinition;
        this.f15706b = iTransaction;
    }

    public final void m15711a(final SingleEmitter<Boolean> singleEmitter) {
        Intrinsics.b(singleEmitter, "emitter");
        this.f15705a.beginTransactionAsync(this.f15706b).success(new Success() {
            public final void onSuccess(Transaction transaction) {
                Intrinsics.b(transaction, "it");
                singleEmitter.a(Boolean.valueOf(true));
            }
        }).error(new Error() {
            public final void onError(Transaction transaction, Throwable th) {
                Intrinsics.b(transaction, "<anonymous parameter 0>");
                Intrinsics.b(th, "<anonymous parameter 1>");
                singleEmitter.a(Boolean.valueOf(null));
            }
        }).runCallbacksOnSameThread(true).execute();
    }
}
