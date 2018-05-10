package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.common.base.Function;
import com.reddit.frontpage.domain.model.Link;

final /* synthetic */ class ClientLink$$Lambda$2 implements Function {
    static final Function $instance = new ClientLink$$Lambda$2();

    private ClientLink$$Lambda$2() {
    }

    public final Object apply(Object obj) {
        return new ClientLink((Link) obj);
    }
}
