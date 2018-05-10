package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzbq;

class zzchv extends BroadcastReceiver {
    private static String f6916d = "com.google.android.gms.internal.zzchv";
    final zzcim f6917a;
    boolean f6918b;
    boolean f6919c;

    zzchv(zzcim com_google_android_gms_internal_zzcim) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        this.f6917a = com_google_android_gms_internal_zzcim;
    }

    public void onReceive(Context context, Intent intent) {
        this.f6917a.m5736a();
        context = intent.getAction();
        this.f6917a.m5754e().f17822g.m5694a("NetworkBroadcastReceiver received action", context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context) != null) {
            Intent y = this.f6917a.m5761l().m18210y();
            if (this.f6919c != y) {
                this.f6919c = y;
                this.f6917a.m5755f().m18271a(new zzchw(this, y));
            }
            return;
        }
        this.f6917a.m5754e().f17818c.m5694a("NetworkBroadcastReceiver received unknown action", context);
    }

    public final void m5700a() {
        this.f6917a.m5736a();
        this.f6917a.m5755f().mo1811c();
        this.f6917a.m5755f().mo1811c();
        if (this.f6918b) {
            this.f6917a.m5754e().f17822g.m5693a("Unregistering connectivity change receiver");
            this.f6918b = false;
            this.f6919c = false;
            try {
                this.f6917a.f6974a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f6917a.m5754e().f17816a.m5694a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
