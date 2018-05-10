package com.reddit.datalibrary.frontpage.data.feature.region.datasource;

import com.squareup.moshi.JsonAdapter;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Region;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: SharedPrefsRegionDataSource.kt */
final class SharedPrefsRegionDataSource$get$1<V> implements Callable<T> {
    final /* synthetic */ SharedPrefsRegionDataSource f10749a;
    final /* synthetic */ String f10750b;

    SharedPrefsRegionDataSource$get$1(SharedPrefsRegionDataSource sharedPrefsRegionDataSource, String str) {
        this.f10749a = sharedPrefsRegionDataSource;
        this.f10750b = str;
    }

    public final /* synthetic */ Object call() {
        return (List) ((JsonAdapter) this.f10749a.f16119c.b()).fromJson(this.f10750b);
    }
}
