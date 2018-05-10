package com.reddit.frontpage.debug;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;

final /* synthetic */ class DebugActivity$$Lambda$8 implements Runnable {
    private final DebugActivity f20134a;

    DebugActivity$$Lambda$8(DebugActivity debugActivity) {
        this.f20134a = debugActivity;
    }

    public final void run() {
        RedditAlertDialog.m23309a(this.f20134a, (int) C1761R.string.label_loading, true).show();
    }
}
