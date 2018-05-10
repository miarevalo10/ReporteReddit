package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class LegacyLinkRepository$$Lambda$0 implements Callable {
    private final LegacyLinkRepository f10670a;
    private final ListingRequestParams f10671b;
    private final List f10672c;
    private final String f10673d;

    LegacyLinkRepository$$Lambda$0(LegacyLinkRepository legacyLinkRepository, ListingRequestParams listingRequestParams, List list, String str) {
        this.f10670a = legacyLinkRepository;
        this.f10671b = listingRequestParams;
        this.f10672c = list;
        this.f10673d = str;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10670a;
        return legacyLinkRepository.f10704a.mo2941a(this.f10671b, this.f10672c, this.f10673d);
    }
}
