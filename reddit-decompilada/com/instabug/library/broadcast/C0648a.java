package com.instabug.library.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: SDKInvokedBroadcast */
public class C0648a extends BroadcastReceiver {
    private C0647a f9579a;

    /* compiled from: SDKInvokedBroadcast */
    public interface C0647a {
        void mo2567a(boolean z);
    }

    public C0648a(C0647a c0647a) {
        this.f9579a = c0647a;
    }

    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.m8360v(this, " - onReceive");
        this.f9579a.mo2567a(intent.getExtras().getBoolean("SDK invoking state"));
    }
}
