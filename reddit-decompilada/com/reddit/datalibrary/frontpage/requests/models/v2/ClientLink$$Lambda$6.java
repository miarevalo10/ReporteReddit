package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.google.common.base.Function;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;

final /* synthetic */ class ClientLink$$Lambda$6 implements Function {
    static final Function $instance = new ClientLink$$Lambda$6();

    private ClientLink$$Lambda$6() {
    }

    public final Object apply(Object obj) {
        return new ClientLink((LinkPresentationModel) obj);
    }
}
