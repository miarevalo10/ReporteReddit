package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzafg implements Callable {
    private final zzaff f6270a;
    private final Context f6271b;

    zzafg(zzaff com_google_android_gms_internal_zzaff, Context context) {
        this.f6270a = com_google_android_gms_internal_zzaff;
        this.f6271b = context;
    }

    public final Object call() {
        return (String) this.f6270a.m5086a("getAppInstanceId", this.f6271b);
    }
}
