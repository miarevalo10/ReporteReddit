package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzbx extends BroadcastReceiver {
    public Context f5798a;
    private final zzby f5799b;

    public zzbx(zzby com_google_android_gms_common_api_internal_zzby) {
        this.f5799b = com_google_android_gms_common_api_internal_zzby;
    }

    public final synchronized void m4732a() {
        if (this.f5798a != null) {
            this.f5798a.unregisterReceiver(this);
        }
        this.f5798a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f5799b.mo1603a();
            m4732a();
        }
    }
}
