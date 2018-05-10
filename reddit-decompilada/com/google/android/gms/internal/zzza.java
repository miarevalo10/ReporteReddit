package com.google.android.gms.internal;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

final class zzza implements OnScrollChangedListener {
    private /* synthetic */ WeakReference f8191a;
    private /* synthetic */ zzyt f8192b;

    zzza(zzyt com_google_android_gms_internal_zzyt, WeakReference weakReference) {
        this.f8192b = com_google_android_gms_internal_zzyt;
        this.f8191a = weakReference;
    }

    public final void onScrollChanged() {
        zzyt.m6826a(this.f8192b, this.f8191a, true);
    }
}
