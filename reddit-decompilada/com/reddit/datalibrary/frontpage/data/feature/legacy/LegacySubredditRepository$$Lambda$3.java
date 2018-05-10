package com.reddit.datalibrary.frontpage.data.feature.legacy;

import java.util.concurrent.Callable;

public final /* synthetic */ class LegacySubredditRepository$$Lambda$3 implements Callable {
    private final LegacySubredditRepository f10413a;
    private final String f10414b;
    private final String f10415c;

    public LegacySubredditRepository$$Lambda$3(LegacySubredditRepository legacySubredditRepository, String str, String str2) {
        this.f10413a = legacySubredditRepository;
        this.f10414b = str;
        this.f10415c = str2;
    }

    public final Object call() {
        LegacySubredditRepository legacySubredditRepository = this.f10413a;
        return legacySubredditRepository.f10418a.mo2948a(this.f10414b, this.f10415c);
    }
}
