package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$11 implements Callable {
    private final LegacyLinkRepository f10674a;
    private final String f10675b;
    private final ListingRequestParams f10676c;
    private final String f10677d;

    public LegacyLinkRepository$$Lambda$11(LegacyLinkRepository legacyLinkRepository, String str, ListingRequestParams listingRequestParams, String str2) {
        this.f10674a = legacyLinkRepository;
        this.f10675b = str;
        this.f10676c = listingRequestParams;
        this.f10677d = str2;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10674a;
        return legacyLinkRepository.f10704a.mo2942a(this.f10675b, this.f10676c);
    }
}
