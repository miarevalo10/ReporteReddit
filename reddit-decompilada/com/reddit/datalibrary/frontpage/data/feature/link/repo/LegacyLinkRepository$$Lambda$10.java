package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$10 implements Consumer {
    private final AsyncCallback f16055a;

    public LegacyLinkRepository$$Lambda$10(AsyncCallback asyncCallback) {
        this.f16055a = asyncCallback;
    }

    public final void accept(Object obj) {
        this.f16055a.mo3013a(new Exception((Throwable) obj));
    }
}
