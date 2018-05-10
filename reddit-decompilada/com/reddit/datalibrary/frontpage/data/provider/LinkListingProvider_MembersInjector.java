package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.MembersInjector;

public final class LinkListingProvider_MembersInjector implements MembersInjector<LinkListingProvider> {
    public static void m16258a(LinkListingProvider linkListingProvider, LegacyLinkRepository legacyLinkRepository) {
        linkListingProvider.f18741d = legacyLinkRepository;
    }
}
