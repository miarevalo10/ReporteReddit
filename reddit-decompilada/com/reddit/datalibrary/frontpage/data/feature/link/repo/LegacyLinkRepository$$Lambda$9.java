package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$9 implements Consumer {
    private final AsyncCallback f16067a;

    private LegacyLinkRepository$$Lambda$9(AsyncCallback asyncCallback) {
        this.f16067a = asyncCallback;
    }

    public static Consumer m16025a(AsyncCallback asyncCallback) {
        return new LegacyLinkRepository$$Lambda$9(asyncCallback);
    }

    public final void accept(Object obj) {
        this.f16067a.mo3014a((Listing) obj);
    }
}
