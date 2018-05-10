package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyDatabaseSubredditDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyApiSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import javax.inject.Singleton;

@Deprecated
public class LegacySubredditDataSourceModule {
    @Singleton
    static LegacyRemoteSubredditDataSource m8845a() {
        return new LegacyApiSubredditDataSource();
    }

    @Singleton
    static LegacyLocalSubredditDataSource m8846b() {
        return new LegacyDatabaseSubredditDataSourceLegacy();
    }
}
