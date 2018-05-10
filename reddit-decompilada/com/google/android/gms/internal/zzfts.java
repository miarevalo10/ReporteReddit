package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public final class zzfts extends CustomTabsServiceConnection {
    private WeakReference<zzftt> f14461a;

    public zzfts(zzftt com_google_android_gms_internal_zzftt) {
        this.f14461a = new WeakReference(com_google_android_gms_internal_zzftt);
    }

    public final void mo1942a(CustomTabsClient customTabsClient) {
        zzftt com_google_android_gms_internal_zzftt = (zzftt) this.f14461a.get();
        if (com_google_android_gms_internal_zzftt != null) {
            com_google_android_gms_internal_zzftt.mo2067a(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzftt com_google_android_gms_internal_zzftt = (zzftt) this.f14461a.get();
        if (com_google_android_gms_internal_zzftt != null) {
            com_google_android_gms_internal_zzftt.mo2066a();
        }
    }
}
