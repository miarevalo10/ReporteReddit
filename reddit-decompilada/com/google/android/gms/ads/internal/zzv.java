package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzaex;
import com.google.android.gms.internal.zzafc;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzamh;
import com.google.android.gms.internal.zzamu;
import com.google.android.gms.internal.zzanf;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzv {
    public final zzanf f5649a;
    public final zzamc f5650b;
    public final zzafc f5651c;
    public final zzix f5652d;

    private zzv(zzanf com_google_android_gms_internal_zzanf, zzamc com_google_android_gms_internal_zzamc, zzafc com_google_android_gms_internal_zzafc, zzix com_google_android_gms_internal_zzix) {
        this.f5649a = com_google_android_gms_internal_zzanf;
        this.f5650b = com_google_android_gms_internal_zzamc;
        this.f5651c = com_google_android_gms_internal_zzafc;
        this.f5652d = com_google_android_gms_internal_zzix;
    }

    public static zzv m4517a(Context context) {
        return new zzv(new zzamu(), new zzamh(), new zzaew(new zzaex()), new zzix(context));
    }
}
