package com.reddit.datalibrary.frontpage.data.common;

import com.google.common.base.Optional;
import com.raizlabs.android.dbflow.rx2.language.RXModelQueriable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\"\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0007"}, d2 = {"queryMaybe", "Lio/reactivex/Maybe;", "T", "Lcom/raizlabs/android/dbflow/rx2/language/RXModelQueriable;", "querySingleOptional", "Lio/reactivex/Single;", "Lcom/google/common/base/Optional;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: RxModelQueriables.kt */
public final class RxModelQueriablesKt {
    public static final <T> Single<Optional<T>> m8756a(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        rXModelQueriable = rXModelQueriable.queryList().map(RxModelQueriablesKt$querySingleOptional$1.f15722a);
        Intrinsics.a(rXModelQueriable, "queryList().map { list -…e Optional.absent()\n    }");
        return rXModelQueriable;
    }

    public static final <T> Maybe<T> m8757b(RXModelQueriable<T> rXModelQueriable) {
        Intrinsics.b(rXModelQueriable, "$receiver");
        rXModelQueriable = rXModelQueriable.queryList().flatMapMaybe(RxModelQueriablesKt$queryMaybe$1.f15721a);
        Intrinsics.a(rXModelQueriable, "queryList().flatMapMaybe… else Maybe.empty()\n    }");
        return rXModelQueriable;
    }
}
