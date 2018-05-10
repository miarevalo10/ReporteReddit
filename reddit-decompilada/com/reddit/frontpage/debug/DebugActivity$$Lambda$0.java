package com.reddit.frontpage.debug;

import android.app.Activity;
import com.cookpad.puree.Puree;
import com.reddit.frontpage.widgets.RedditSnackbar;
import com.reddit.frontpage.widgets.RedditSnackbar.Builder;

final /* synthetic */ class DebugActivity$$Lambda$0 implements Runnable {
    private final DebugActivity f20121a;

    DebugActivity$$Lambda$0(DebugActivity debugActivity) {
        this.f20121a = debugActivity;
    }

    public final void run() {
        Activity activity = this.f20121a;
        Puree.b();
        Builder a = RedditSnackbar.m24189a(activity);
        a.f21934a = "Logs cleared";
        a.m24188a();
    }
}
