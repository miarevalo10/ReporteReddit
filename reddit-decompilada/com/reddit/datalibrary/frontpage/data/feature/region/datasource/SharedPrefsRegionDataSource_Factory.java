package com.reddit.datalibrary.frontpage.data.feature.region.datasource;

import android.content.SharedPreferences;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SharedPrefsRegionDataSource_Factory implements Factory<SharedPrefsRegionDataSource> {
    private final Provider<Moshi> f18705a;
    private final Provider<SharedPreferences> f18706b;

    private SharedPrefsRegionDataSource_Factory(Provider<Moshi> provider, Provider<SharedPreferences> provider2) {
        this.f18705a = provider;
        this.f18706b = provider2;
    }

    public static SharedPrefsRegionDataSource_Factory m19685a(Provider<Moshi> provider, Provider<SharedPreferences> provider2) {
        return new SharedPrefsRegionDataSource_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new SharedPrefsRegionDataSource((Moshi) this.f18705a.get(), (SharedPreferences) this.f18706b.get());
    }
}
