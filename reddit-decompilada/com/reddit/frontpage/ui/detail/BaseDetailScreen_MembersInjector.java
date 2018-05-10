package com.reddit.frontpage.ui.detail;

import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.MembersInjector;

public final class BaseDetailScreen_MembersInjector implements MembersInjector<BaseDetailScreen> {
    public static void m30010a(BaseDetailScreen baseDetailScreen, LegacyLinkRepository legacyLinkRepository) {
        baseDetailScreen.f39164X = legacyLinkRepository;
    }
}
