package com.google.android.gms.internal;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class zzank implements OnAttachStateChangeListener {
    private /* synthetic */ zzafb f6642a;
    private /* synthetic */ zzani f6643b;

    zzank(zzani com_google_android_gms_internal_zzani, zzafb com_google_android_gms_internal_zzafb) {
        this.f6643b = com_google_android_gms_internal_zzani;
        this.f6642a = com_google_android_gms_internal_zzafb;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f6643b.m5437a(view, this.f6642a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
