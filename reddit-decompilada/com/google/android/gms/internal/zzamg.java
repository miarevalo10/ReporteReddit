package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzbq;

@zzzv
public final class zzamg {
    final Context f6541a;
    final zzamp f6542b;
    final ViewGroup f6543c;
    zzamd f6544d;

    private zzamg(Context context, ViewGroup viewGroup, zzamp com_google_android_gms_internal_zzamp) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f6541a = context;
        this.f6543c = viewGroup;
        this.f6542b = com_google_android_gms_internal_zzamp;
        this.f6544d = null;
    }

    public zzamg(Context context, ViewGroup viewGroup, zzanh com_google_android_gms_internal_zzanh) {
        this(context, viewGroup, (zzamp) com_google_android_gms_internal_zzanh);
    }

    public final zzamd m5417a() {
        zzbq.m4816b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f6544d;
    }
}
