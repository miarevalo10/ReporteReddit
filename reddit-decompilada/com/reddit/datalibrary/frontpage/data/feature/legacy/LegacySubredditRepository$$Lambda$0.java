package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;

final /* synthetic */ class LegacySubredditRepository$$Lambda$0 implements SubredditRetriever {
    private final LegacyRemoteSubredditDataSource f15859a;

    private LegacySubredditRepository$$Lambda$0(LegacyRemoteSubredditDataSource legacyRemoteSubredditDataSource) {
        this.f15859a = legacyRemoteSubredditDataSource;
    }

    static SubredditRetriever m15922a(LegacyRemoteSubredditDataSource legacyRemoteSubredditDataSource) {
        return new LegacySubredditRepository$$Lambda$0(legacyRemoteSubredditDataSource);
    }

    public final Listing mo2932a(String str) {
        return this.f15859a.mo2946a();
    }
}
