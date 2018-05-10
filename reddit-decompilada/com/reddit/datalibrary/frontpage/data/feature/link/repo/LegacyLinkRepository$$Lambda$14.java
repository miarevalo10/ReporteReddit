package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$14 implements Callable {
    private final LegacyLinkRepository f10687a;
    private final String f10688b;
    private final ListingRequestParams f10689c;
    private final String f10690d;

    public LegacyLinkRepository$$Lambda$14(LegacyLinkRepository legacyLinkRepository, String str, ListingRequestParams listingRequestParams, String str2) {
        this.f10687a = legacyLinkRepository;
        this.f10688b = str;
        this.f10689c = listingRequestParams;
        this.f10690d = str2;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10687a;
        return legacyLinkRepository.f10704a.mo2943a(this.f10688b, this.f10689c, this.f10690d);
    }
}
