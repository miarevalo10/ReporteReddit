package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.util.List;

final /* synthetic */ class ClientLink$$Lambda$1 implements Function {
    static final Function $instance = new ClientLink$$Lambda$1();

    private ClientLink$$Lambda$1() {
    }

    public final Object apply(Object obj) {
        return ((String[]) Iterables.a((List) obj, String.class));
    }
}
