package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import dagger.MembersInjector;

public final class SubredditNameInfoProvider_MembersInjector implements MembersInjector<SubredditNameInfoProvider> {
    public static void m16295a(SubredditNameInfoProvider subredditNameInfoProvider, LegacySubredditRepository legacySubredditRepository) {
        subredditNameInfoProvider.f10799b = legacySubredditRepository;
    }
}
