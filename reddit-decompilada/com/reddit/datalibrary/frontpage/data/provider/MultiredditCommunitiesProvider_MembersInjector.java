package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import dagger.MembersInjector;

public final class MultiredditCommunitiesProvider_MembersInjector implements MembersInjector<MultiredditCommunitiesProvider> {
    public static void m16287a(MultiredditCommunitiesProvider multiredditCommunitiesProvider, LegacySubredditRepository legacySubredditRepository) {
        multiredditCommunitiesProvider.f16271a = legacySubredditRepository;
    }
}
