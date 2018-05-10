package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FileLinkDataSource_Factory implements Factory<FileLinkDataSource> {
    private final Provider<Moshi> f18693a;
    private final Provider<Context> f18694b;

    private FileLinkDataSource_Factory(Provider<Moshi> provider, Provider<Context> provider2) {
        this.f18693a = provider;
        this.f18694b = provider2;
    }

    public static FileLinkDataSource_Factory m19673a(Provider<Moshi> provider, Provider<Context> provider2) {
        return new FileLinkDataSource_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new FileLinkDataSource((Moshi) this.f18693a.get(), (Context) this.f18694b.get());
    }
}
