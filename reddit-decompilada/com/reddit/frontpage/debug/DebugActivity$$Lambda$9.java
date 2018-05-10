package com.reddit.frontpage.debug;

import android.support.design.widget.Snackbar;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class DebugActivity$$Lambda$9 implements Runnable {
    private final DebugActivity f20135a;

    DebugActivity$$Lambda$9(DebugActivity debugActivity) {
        this.f20135a = debugActivity;
    }

    public final void run() {
        DebugActivity debugActivity = this.f20135a;
        boolean z = FrontpageSettings.a().a.getBoolean("com.reddit.pref.dummy_upcoming_event", false) ^ 1;
        FrontpageSettings.a().g(z);
        Snackbar.a(debugActivity.getListView(), z ? "Enabled - please refresh frontpage to view" : "disabled", -1).a();
    }
}
