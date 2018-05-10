package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType", "success", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Single;"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseAccountDataSource.kt */
final class DatabaseAccountDataSource$saveOrUpdate$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ Single f15750a;

    DatabaseAccountDataSource$saveOrUpdate$1(Single single) {
        this.f15750a = single;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.b(bool, "success");
        if (bool.booleanValue() != null) {
            return this.f15750a;
        }
        return Single.just(Boolean.valueOf(null));
    }
}
