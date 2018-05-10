package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import dagger.internal.Factory;

public final class DatabaseAccountDataSource_Factory implements Factory<DatabaseAccountDataSource> {
    private static final DatabaseAccountDataSource_Factory f18680a = new DatabaseAccountDataSource_Factory();

    public static DatabaseAccountDataSource_Factory m19661a() {
        return f18680a;
    }

    public final /* synthetic */ Object get() {
        return new DatabaseAccountDataSource();
    }
}
