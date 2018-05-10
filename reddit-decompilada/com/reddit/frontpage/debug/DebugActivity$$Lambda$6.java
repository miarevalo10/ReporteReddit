package com.reddit.frontpage.debug;

import android.support.design.widget.Snackbar;
import java.util.UUID;

final /* synthetic */ class DebugActivity$$Lambda$6 implements Runnable {
    private final DebugActivity f20132a;

    DebugActivity$$Lambda$6(DebugActivity debugActivity) {
        this.f20132a = debugActivity;
    }

    public final void run() {
        Snackbar.a(this.f20132a.getListView(), UUID.randomUUID().toString(), -1).a();
    }
}
