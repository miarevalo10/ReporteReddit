package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.common.base.Function;
import com.reddit.frontpage.domain.model.FlairRichTextItem;

final /* synthetic */ class ClientLink$$Lambda$4 implements Function {
    static final Function $instance = new ClientLink$$Lambda$4();

    private ClientLink$$Lambda$4() {
    }

    public final Object apply(Object obj) {
        return new FlairRichTextItem((FlairRichTextItem) obj);
    }
}
