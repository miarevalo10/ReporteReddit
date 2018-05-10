package com.reddit.frontpage.debug;

import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;

final /* synthetic */ class DebugActivity$$Lambda$5 implements Runnable {
    static final Runnable f20131a = new DebugActivity$$Lambda$5();

    private DebugActivity$$Lambda$5() {
    }

    public final void run() {
        InternalSettings.a().a(false);
    }
}
