package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import java.util.concurrent.Callable;

final /* synthetic */ class LegacyLinkRepository$$Lambda$16 implements Callable {
    private final LegacyLinkRepository f10691a;
    private final Link f10692b;

    LegacyLinkRepository$$Lambda$16(LegacyLinkRepository legacyLinkRepository, Link link) {
        this.f10691a = legacyLinkRepository;
        this.f10692b = link;
    }

    public final Object call() {
        LegacyLinkRepository legacyLinkRepository = this.f10691a;
        legacyLinkRepository.f10705b.mo2929a(this.f10692b);
        return null;
    }
}
