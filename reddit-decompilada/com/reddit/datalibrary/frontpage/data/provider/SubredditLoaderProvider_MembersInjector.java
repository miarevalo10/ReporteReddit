package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import dagger.MembersInjector;

public final class SubredditLoaderProvider_MembersInjector implements MembersInjector<SubredditLoaderProvider> {
    public static void m16292a(SubredditLoaderProvider subredditLoaderProvider, LegacySubredditRepository legacySubredditRepository) {
        subredditLoaderProvider.f18772a = legacySubredditRepository;
    }
}
