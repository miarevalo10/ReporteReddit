package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$17 implements Callable {
    private final LegacyLinkRepository f10693a;
    private final String f10694b;
    private final String f10695c;

    public LegacyLinkRepository$$Lambda$17(LegacyLinkRepository legacyLinkRepository, String str, String str2) {
        this.f10693a = legacyLinkRepository;
        this.f10694b = str;
        this.f10695c = str2;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10693a;
        return legacyLinkRepository.f10704a.mo2940a(this.f10694b, this.f10695c);
    }
}
