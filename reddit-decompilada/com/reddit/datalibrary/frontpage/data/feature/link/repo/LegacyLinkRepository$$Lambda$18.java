package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import java.util.concurrent.Callable;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$18 implements Callable {
    private final LegacyLinkRepository f10696a;
    private final String f10697b;

    public LegacyLinkRepository$$Lambda$18(LegacyLinkRepository legacyLinkRepository, String str) {
        this.f10696a = legacyLinkRepository;
        this.f10697b = str;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10696a;
        return legacyLinkRepository.f10705b.mo2930a(this.f10697b);
    }
}
