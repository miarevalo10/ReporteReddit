package com.reddit.datalibrary.frontpage.data.feature.common;

import com.squareup.moshi.JsonAdapter;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import okio.Buffer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lokio/Buffer;", "kotlin.jvm.PlatformType", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
final class PersistDataSourceUtil$saveSubreddits$1<V> implements Callable<T> {
    final /* synthetic */ JsonAdapter f10380a;
    final /* synthetic */ List f10381b;

    PersistDataSourceUtil$saveSubreddits$1(JsonAdapter jsonAdapter, List list) {
        this.f10380a = jsonAdapter;
        this.f10381b = list;
    }

    public final /* synthetic */ Object call() {
        return new Buffer().a(this.f10380a.toJson(this.f10381b));
    }
}
