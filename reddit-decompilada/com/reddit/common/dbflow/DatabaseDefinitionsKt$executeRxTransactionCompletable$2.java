package com.reddit.common.dbflow;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "it", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/CompletableSource;"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseDefinitions.kt */
final class DatabaseDefinitionsKt$executeRxTransactionCompletable$2<T, R> implements Function<Boolean, CompletableSource> {
    public static final DatabaseDefinitionsKt$executeRxTransactionCompletable$2 f15712a = new DatabaseDefinitionsKt$executeRxTransactionCompletable$2();

    DatabaseDefinitionsKt$executeRxTransactionCompletable$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.b(bool, "it");
        return (CompletableSource) (bool.booleanValue() != null ? Completable.complete() : Completable.never());
    }
}
