package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;

final /* synthetic */ class LegacySubredditRepository$$Lambda$1 implements SubredditRetriever {
    private final LegacySubredditRepository f15860a;
    private final Session f15861b;

    LegacySubredditRepository$$Lambda$1(LegacySubredditRepository legacySubredditRepository, Session session) {
        this.f15860a = legacySubredditRepository;
        this.f15861b = session;
    }

    public final Listing mo2932a(String str) {
        return this.f15860a.f10418a.mo2947a(str);
    }
}
