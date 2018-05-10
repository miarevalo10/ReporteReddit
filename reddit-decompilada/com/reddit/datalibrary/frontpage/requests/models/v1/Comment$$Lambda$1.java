package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.util.List;

final /* synthetic */ class Comment$$Lambda$1 implements Function {
    static final Function $instance = new Comment$$Lambda$1();

    private Comment$$Lambda$1() {
    }

    public final Object apply(Object obj) {
        return ((String[]) Iterables.m7140a((Iterable) (List) obj, String.class));
    }
}
