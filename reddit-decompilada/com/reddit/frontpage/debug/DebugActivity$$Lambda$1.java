package com.reddit.frontpage.debug;

import android.app.Activity;
import com.cookpad.puree.Puree;
import com.reddit.frontpage.widgets.RedditSnackbar;
import com.reddit.frontpage.widgets.RedditSnackbar.Builder;

final /* synthetic */ class DebugActivity$$Lambda$1 implements Runnable {
    private final DebugActivity f20127a;

    DebugActivity$$Lambda$1(DebugActivity debugActivity) {
        this.f20127a = debugActivity;
    }

    public final void run() {
        Activity activity = this.f20127a;
        Puree.a();
        Builder a = RedditSnackbar.m24189a(activity);
        a.f21934a = "Logs flushed";
        a.m24188a();
    }
}
