package com.reddit.frontpage.debug;

import android.support.design.widget.Snackbar;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;

final /* synthetic */ class DebugActivity$$Lambda$10 implements Runnable {
    private final DebugActivity f20122a;

    DebugActivity$$Lambda$10(DebugActivity debugActivity) {
        this.f20122a = debugActivity;
    }

    public final void run() {
        DebugActivity debugActivity = this.f20122a;
        boolean q = InternalSettings.a().q() ^ 1;
        InternalSettings.a().a.edit().putBoolean("com.reddit.frontpage.use_legacy_videoplayer", q).apply();
        Snackbar.a(debugActivity.getListView(), q ? "Using legacy video player" : "Using new video player", -1).a();
    }
}
