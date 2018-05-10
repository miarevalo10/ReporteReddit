package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.common.base.Function;
import com.reddit.frontpage.domain.model.ImageResolution;

final /* synthetic */ class LinkPreview$$Lambda$0 implements Function {
    static final Function $instance = new LinkPreview$$Lambda$0();

    private LinkPreview$$Lambda$0() {
    }

    public final Object apply(Object obj) {
        return new ImageResolution((ImageResolution) obj);
    }
}
