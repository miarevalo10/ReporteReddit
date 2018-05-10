package com.reddit.datalibrary.frontpage.data.feature.common;

import com.squareup.moshi.JsonAdapter;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "it", "Lokio/BufferedSource;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
final class PersistDataSourceUtil$readSubreddits$1<T, R> implements Function<T, R> {
    final /* synthetic */ JsonAdapter f15821a;

    PersistDataSourceUtil$readSubreddits$1(JsonAdapter jsonAdapter) {
        this.f15821a = jsonAdapter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        BufferedSource bufferedSource = (BufferedSource) obj;
        Intrinsics.b(bufferedSource, "it");
        obj = this.f15821a.fromJson(bufferedSource);
        if (obj == null) {
            Intrinsics.a();
        }
        return (List) obj;
    }
}
