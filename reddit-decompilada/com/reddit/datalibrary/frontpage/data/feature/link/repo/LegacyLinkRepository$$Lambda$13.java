package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$13 implements Callable {
    private final LegacyLinkRepository f10683a;
    private final String f10684b;
    private final String f10685c;
    private final List f10686d;

    public LegacyLinkRepository$$Lambda$13(LegacyLinkRepository legacyLinkRepository, String str, String str2, List list) {
        this.f10683a = legacyLinkRepository;
        this.f10684b = str;
        this.f10685c = str2;
        this.f10686d = list;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10683a;
        return legacyLinkRepository.f10704a.mo2945a(this.f10684b, this.f10685c, this.f10686d);
    }
}
