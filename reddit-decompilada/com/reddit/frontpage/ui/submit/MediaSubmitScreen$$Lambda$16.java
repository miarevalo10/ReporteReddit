package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Predicate;

final /* synthetic */ class MediaSubmitScreen$$Lambda$16 implements Predicate {
    private final MediaSubmitScreen f29319a;

    MediaSubmitScreen$$Lambda$16(MediaSubmitScreen mediaSubmitScreen) {
        this.f29319a = mediaSubmitScreen;
    }

    public final boolean test(Object obj) {
        return ((String) obj).equals(this.f29319a.submitRequestId);
    }
}
