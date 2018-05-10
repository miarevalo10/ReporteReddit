package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.MembersInjector;

public final class CardLinkAdapter_MembersInjector implements MembersInjector<CardLinkAdapter> {
    public static void m30235a(CardLinkAdapter cardLinkAdapter, LegacyLinkRepository legacyLinkRepository) {
        cardLinkAdapter.f29115l = legacyLinkRepository;
    }
}
