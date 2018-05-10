package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.js.zzc;
import com.google.android.gms.ads.internal.js.zzn;

@zzzv
public final class zztx {
    private static zzaiq<zzc> f8038a = new zzty();
    private static zzaiq<zzc> f8039b = new zztz();
    private final zzn f8040c;

    public zztx(Context context, zzakd com_google_android_gms_internal_zzakd, String str) {
        this.f8040c = new zzn(context, com_google_android_gms_internal_zzakd, str, f8038a, f8039b);
    }

    public final <I, O> zztp<I, O> m6665a(String str, zzts<I> com_google_android_gms_internal_zzts_I, zztr<O> com_google_android_gms_internal_zztr_O) {
        return new zzua(this.f8040c, str, com_google_android_gms_internal_zzts_I, com_google_android_gms_internal_zztr_O);
    }
}
