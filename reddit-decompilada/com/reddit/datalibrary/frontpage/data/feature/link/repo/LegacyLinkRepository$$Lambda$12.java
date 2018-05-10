package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class LegacyLinkRepository$$Lambda$12 implements Callable {
    private final LegacyLinkRepository f10678a;
    private final String f10679b;
    private final ListingRequestParams f10680c;
    private final List f10681d;
    private final String f10682e;

    LegacyLinkRepository$$Lambda$12(LegacyLinkRepository legacyLinkRepository, String str, ListingRequestParams listingRequestParams, List list, String str2) {
        this.f10678a = legacyLinkRepository;
        this.f10679b = str;
        this.f10680c = listingRequestParams;
        this.f10681d = list;
        this.f10682e = str2;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10678a;
        return legacyLinkRepository.f10704a.mo2944a(this.f10679b, this.f10680c, this.f10681d, this.f10682e);
    }
}
