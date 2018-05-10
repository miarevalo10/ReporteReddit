package com.reddit.datalibrary.frontpage.data.feature.common;

import com.nytimes.android.external.store3.base.Persister;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "it", "Lokio/Buffer;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
final class PersistDataSourceUtil$saveLinks$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ Lazy f15822a;
    final /* synthetic */ Key f15823b;

    PersistDataSourceUtil$saveLinks$2(Lazy lazy, Key key) {
        this.f15822a = lazy;
        this.f15823b = key;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Buffer buffer = (Buffer) obj;
        Intrinsics.b(buffer, "it");
        return ((Persister) this.f15822a.b()).mo2709a(this.f15823b, buffer);
    }
}
