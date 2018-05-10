package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;

final /* synthetic */ class ClientLink$$Lambda$3 implements Function {
    static final Function $instance = new ClientLink$$Lambda$3();

    private ClientLink$$Lambda$3() {
    }

    public final Object apply(Object obj) {
        return new AdEvent(((com.reddit.frontpage.domain.model.AdEvent) obj).getUrl(), ((com.reddit.frontpage.domain.model.AdEvent) obj).getType());
    }
}
