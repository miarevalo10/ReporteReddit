package com.reddit.datalibrary.frontpage.data.feature.subreddit.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import javax.inject.Singleton;

public class SubredditRepositoryModule {
    @Singleton
    static LegacySubredditRepository m9124a(LegacyRemoteSubredditDataSource legacyRemoteSubredditDataSource, LegacyLocalSubredditDataSource legacyLocalSubredditDataSource) {
        return new LegacySubredditRepository(legacyRemoteSubredditDataSource, legacyLocalSubredditDataSource);
    }
}
