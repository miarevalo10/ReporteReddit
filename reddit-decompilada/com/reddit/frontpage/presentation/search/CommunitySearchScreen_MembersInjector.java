package com.reddit.frontpage.presentation.search;

import dagger.MembersInjector;

public final class CommunitySearchScreen_MembersInjector implements MembersInjector<CommunitySearchScreen> {
    public static void m29871a(CommunitySearchScreen communitySearchScreen, RecentSearchPresenter recentSearchPresenter) {
        communitySearchScreen.f40139w = recentSearchPresenter;
    }

    public static void m29870a(CommunitySearchScreen communitySearchScreen, CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter) {
        communitySearchScreen.f40140x = communityTypeAheadSearchPresenter;
    }

    public static void m29869a(CommunitySearchScreen communitySearchScreen, CommunitySearchResultsPresenter communitySearchResultsPresenter) {
        communitySearchScreen.f40141y = communitySearchResultsPresenter;
    }
}
