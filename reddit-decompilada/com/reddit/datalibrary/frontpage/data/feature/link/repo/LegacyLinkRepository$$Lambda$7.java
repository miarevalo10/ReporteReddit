package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$7 implements Callable {
    private final LegacyLinkRepository f10700a;
    private final String f10701b;
    private final ListingRequestParams f10702c;
    private final String f10703d;

    public LegacyLinkRepository$$Lambda$7(LegacyLinkRepository legacyLinkRepository, String str, ListingRequestParams listingRequestParams, String str2) {
        this.f10700a = legacyLinkRepository;
        this.f10701b = str;
        this.f10702c = listingRequestParams;
        this.f10703d = str2;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10700a;
        return legacyLinkRepository.f10704a.mo2942a(this.f10701b, this.f10702c);
    }
}
