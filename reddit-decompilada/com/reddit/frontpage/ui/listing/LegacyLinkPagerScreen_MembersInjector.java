package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.MembersInjector;

public final class LegacyLinkPagerScreen_MembersInjector implements MembersInjector<LegacyLinkPagerScreen> {
    public static void m30107a(LegacyLinkPagerScreen legacyLinkPagerScreen, LegacyLinkRepository legacyLinkRepository) {
        legacyLinkPagerScreen.f39221x = legacyLinkRepository;
    }
}
