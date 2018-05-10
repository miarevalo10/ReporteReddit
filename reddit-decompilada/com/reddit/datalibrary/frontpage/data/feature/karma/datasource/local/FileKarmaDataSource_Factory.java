package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FileKarmaDataSource_Factory implements Factory<FileKarmaDataSource> {
    private final Provider<Moshi> f18688a;
    private final Provider<Context> f18689b;

    private FileKarmaDataSource_Factory(Provider<Moshi> provider, Provider<Context> provider2) {
        this.f18688a = provider;
        this.f18689b = provider2;
    }

    public static FileKarmaDataSource_Factory m19667a(Provider<Moshi> provider, Provider<Context> provider2) {
        return new FileKarmaDataSource_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new FileKarmaDataSource((Moshi) this.f18688a.get(), (Context) this.f18689b.get());
    }
}
