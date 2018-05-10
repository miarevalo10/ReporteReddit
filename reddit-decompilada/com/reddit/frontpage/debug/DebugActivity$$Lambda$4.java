package com.reddit.frontpage.debug;

import android.content.Context;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class DebugActivity$$Lambda$4 implements Runnable {
    private final DebugActivity f20130a;

    DebugActivity$$Lambda$4(DebugActivity debugActivity) {
        this.f20130a = debugActivity;
    }

    public final void run() {
        Context context = this.f20130a;
        context.startActivity(IntentUtil.m23745a(context, DetailHolderScreen.m38887b("5gafop", null, null)));
    }
}
