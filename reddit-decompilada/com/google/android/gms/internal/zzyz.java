package com.google.android.gms.internal;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

final class zzyz implements OnGlobalLayoutListener {
    private /* synthetic */ WeakReference f8189a;
    private /* synthetic */ zzyt f8190b;

    zzyz(zzyt com_google_android_gms_internal_zzyt, WeakReference weakReference) {
        this.f8190b = com_google_android_gms_internal_zzyt;
        this.f8189a = weakReference;
    }

    public final void onGlobalLayout() {
        zzyt.m6826a(this.f8190b, this.f8189a, false);
    }
}
