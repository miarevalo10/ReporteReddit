package com.reddit.datalibrary.frontpage.data.feature.common;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "it", "Lokio/BufferedSource;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
final class PersistDataSourceUtil$readLinks$1<T, R> implements Function<T, R> {
    final /* synthetic */ JsonAdapter f15820a;

    PersistDataSourceUtil$readLinks$1(JsonAdapter jsonAdapter) {
        this.f15820a = jsonAdapter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        BufferedSource bufferedSource = (BufferedSource) obj;
        Intrinsics.b(bufferedSource, "it");
        obj = this.f15820a.fromJson(bufferedSource);
        if (obj == null) {
            Intrinsics.a();
        }
        return (Listing) obj;
    }
}
