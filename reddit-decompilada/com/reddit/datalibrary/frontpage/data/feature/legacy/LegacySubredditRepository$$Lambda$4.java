package com.reddit.datalibrary.frontpage.data.feature.legacy;

import java.util.concurrent.Callable;

public final /* synthetic */ class LegacySubredditRepository$$Lambda$4 implements Callable {
    private final LegacySubredditRepository f10416a;
    private final String f10417b;

    public LegacySubredditRepository$$Lambda$4(LegacySubredditRepository legacySubredditRepository, String str) {
        this.f10416a = legacySubredditRepository;
        this.f10417b = str;
    }

    public final Object call() {
        LegacySubredditRepository legacySubredditRepository = this.f10416a;
        return legacySubredditRepository.f10418a.mo2951b(this.f10417b);
    }
}
