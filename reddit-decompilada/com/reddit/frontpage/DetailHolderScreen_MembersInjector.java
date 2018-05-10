package com.reddit.frontpage;

import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.MembersInjector;

public final class DetailHolderScreen_MembersInjector implements MembersInjector<DetailHolderScreen> {
    public static void m28858a(DetailHolderScreen detailHolderScreen, LegacyLinkRepository legacyLinkRepository) {
        detailHolderScreen.f39058v = legacyLinkRepository;
    }
}
