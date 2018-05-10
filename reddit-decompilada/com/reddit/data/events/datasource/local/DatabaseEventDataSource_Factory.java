package com.reddit.data.events.datasource.local;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DatabaseEventDataSource_Factory implements Factory<DatabaseEventDataSource> {
    private final Provider<Moshi> f18677a;

    private DatabaseEventDataSource_Factory(Provider<Moshi> provider) {
        this.f18677a = provider;
    }

    public static DatabaseEventDataSource_Factory m19655a(Provider<Moshi> provider) {
        return new DatabaseEventDataSource_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new DatabaseEventDataSource((Moshi) this.f18677a.get());
    }
}
