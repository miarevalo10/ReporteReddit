package com.reddit.frontpage.debug;

import android.content.Context;
import android.content.Intent;
import com.reddit.frontpage.WebBrowserActivity;

final /* synthetic */ class DebugActivity$$Lambda$2 implements Runnable {
    private final DebugActivity f20128a;

    DebugActivity$$Lambda$2(DebugActivity debugActivity) {
        this.f20128a = debugActivity;
    }

    public final void run() {
        Context context = this.f20128a;
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("com.reddit.extra.initial_url", "https://www.time.com");
        context.startActivity(intent);
    }
}
