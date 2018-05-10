package com.reddit.frontpage.debug;

import android.content.Context;
import android.content.Intent;
import com.reddit.frontpage.LiveThreadActivity;

final /* synthetic */ class DebugActivity$$Lambda$13 implements Runnable {
    private final DebugActivity f20125a;

    DebugActivity$$Lambda$13(DebugActivity debugActivity) {
        this.f20125a = debugActivity;
    }

    public final void run() {
        Context context = this.f20125a;
        context.startActivity(new Intent(context, LiveThreadActivity.class).putExtra("live_thread_id", "10g9r5rk8r2rg"));
    }
}
