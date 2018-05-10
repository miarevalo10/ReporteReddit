package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsSession;
import java.util.Iterator;
import java.util.List;

final class zzaho implements zzof {
    private /* synthetic */ List f14101a;
    private /* synthetic */ zzoe f14102b;
    private /* synthetic */ Context f14103c;

    zzaho(List list, zzoe com_google_android_gms_internal_zzoe, Context context) {
        this.f14101a = list;
        this.f14102b = com_google_android_gms_internal_zzoe;
        this.f14103c = context;
    }

    public final void mo1718a() {
        Iterator it = this.f14101a.iterator();
        while (true) {
            CustomTabsSession customTabsSession = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            String str2 = "Pinging url: ";
            String valueOf = String.valueOf(str);
            zzakb.m5370d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            Uri parse = Uri.parse(str);
            zzoe com_google_android_gms_internal_zzoe = this.f14102b;
            if (com_google_android_gms_internal_zzoe.f14570b != null) {
                if (com_google_android_gms_internal_zzoe.f14570b != null) {
                    if (com_google_android_gms_internal_zzoe.f14569a == null) {
                        customTabsSession = com_google_android_gms_internal_zzoe.f14570b.m144b();
                    }
                    customTabsSession = com_google_android_gms_internal_zzoe.f14569a;
                    if (customTabsSession != null) {
                        customTabsSession.m148a(parse);
                    }
                }
                com_google_android_gms_internal_zzoe.f14569a = customTabsSession;
                customTabsSession = com_google_android_gms_internal_zzoe.f14569a;
                if (customTabsSession != null) {
                    customTabsSession.m148a(parse);
                }
            }
        }
        zzoe com_google_android_gms_internal_zzoe2 = this.f14102b;
        Activity activity = (Activity) this.f14103c;
        if (com_google_android_gms_internal_zzoe2.f14571c != null) {
            activity.unbindService(com_google_android_gms_internal_zzoe2.f14571c);
            com_google_android_gms_internal_zzoe2.f14570b = null;
            com_google_android_gms_internal_zzoe2.f14569a = null;
            com_google_android_gms_internal_zzoe2.f14571c = null;
        }
    }
}
