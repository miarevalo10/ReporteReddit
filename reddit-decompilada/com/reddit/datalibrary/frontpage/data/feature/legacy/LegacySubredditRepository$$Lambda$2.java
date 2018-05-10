package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;

final /* synthetic */ class LegacySubredditRepository$$Lambda$2 implements SubredditRetriever {
    private final LegacySubredditRepository f15862a;
    private final Session f15863b;

    LegacySubredditRepository$$Lambda$2(LegacySubredditRepository legacySubredditRepository, Session session) {
        this.f15862a = legacySubredditRepository;
        this.f15863b = session;
    }

    public final Listing mo2932a(String str) {
        return this.f15862a.f10418a.mo2950b();
    }
}
