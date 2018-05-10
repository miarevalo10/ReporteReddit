package com.reddit.datalibrary.frontpage.data.feature.region.datasource;

import android.content.SharedPreferences.Editor;
import com.reddit.datalibrary.frontpage.data.feature.region.datasource.SharedPrefsRegionDataSource.Companion;
import com.squareup.moshi.JsonAdapter;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: SharedPrefsRegionDataSource.kt */
final class SharedPrefsRegionDataSource$save$1<V> implements Callable<T> {
    final /* synthetic */ SharedPrefsRegionDataSource f10751a;
    final /* synthetic */ List f10752b;

    SharedPrefsRegionDataSource$save$1(SharedPrefsRegionDataSource sharedPrefsRegionDataSource, List list) {
        this.f10751a = sharedPrefsRegionDataSource;
        this.f10752b = list;
    }

    public final /* synthetic */ Object call() {
        Editor edit = this.f10751a.f16121e.edit();
        Companion companion = SharedPrefsRegionDataSource.f16116b;
        edit.putString(SharedPrefsRegionDataSource.f16118g, ((JsonAdapter) this.f10751a.f16119c.b()).toJson(this.f10752b)).apply();
        return Boolean.valueOf(true);
    }
}
