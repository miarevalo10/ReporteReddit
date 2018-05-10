package com.reddit.frontpage.ui.profile;

import io.reactivex.functions.Consumer;
import java.util.List;

final /* synthetic */ class ProfilePagerScreen$$Lambda$0 implements Consumer {
    private final BaseAccountScreen f29226a;

    private ProfilePagerScreen$$Lambda$0(BaseAccountScreen baseAccountScreen) {
        this.f29226a = baseAccountScreen;
    }

    static Consumer m30326a(BaseAccountScreen baseAccountScreen) {
        return new ProfilePagerScreen$$Lambda$0(baseAccountScreen);
    }

    public final void accept(Object obj) {
        this.f29226a.m39364a((List) obj);
    }
}
