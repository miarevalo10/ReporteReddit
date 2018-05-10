package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class zzahs extends BroadcastReceiver {
    private /* synthetic */ zzahn f6389a;

    private zzahs(zzahn com_google_android_gms_internal_zzahn) {
        this.f6389a = com_google_android_gms_internal_zzahn;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.f6389a.f6382d = true;
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f6389a.f6382d = false;
        }
    }
}
