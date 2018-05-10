package com.reddit.frontpage.ui.detail;

import com.reddit.frontpage.util.ModUtil;

final /* synthetic */ class BaseDetailScreen$$Lambda$5 implements Runnable {
    private final BaseDetailScreen f21153a;

    BaseDetailScreen$$Lambda$5(BaseDetailScreen baseDetailScreen) {
        this.f21153a = baseDetailScreen;
    }

    public final void run() {
        BaseDetailScreen baseDetailScreen = this.f21153a;
        ModUtil.m23832b();
        if (!(baseDetailScreen.f39153F == null || baseDetailScreen.f39153F.getSubredditDetail() == null)) {
            ModUtil.m23830a(baseDetailScreen.f39153F.getSubredditDetail().getName(), baseDetailScreen.f39153F.getSubredditDetail().display_name);
        }
        baseDetailScreen.m39093O();
    }
}
