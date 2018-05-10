package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzi implements zzz {
    private final Executor f14510a;

    public zzi(Handler handler) {
        this.f14510a = new zzj(handler);
    }

    public final void mo1954a(zzr<?> com_google_android_gms_internal_zzr_, zzad com_google_android_gms_internal_zzad) {
        com_google_android_gms_internal_zzr_.m6628b("post-error");
        this.f14510a.execute(new zzk(com_google_android_gms_internal_zzr_, zzw.m6770a(com_google_android_gms_internal_zzad), null));
    }

    public final void mo1955a(zzr<?> com_google_android_gms_internal_zzr_, zzw<?> com_google_android_gms_internal_zzw_) {
        mo1956a(com_google_android_gms_internal_zzr_, com_google_android_gms_internal_zzw_, null);
    }

    public final void mo1956a(zzr<?> com_google_android_gms_internal_zzr_, zzw<?> com_google_android_gms_internal_zzw_, Runnable runnable) {
        com_google_android_gms_internal_zzr_.f7973h = true;
        com_google_android_gms_internal_zzr_.m6628b("post-response");
        this.f14510a.execute(new zzk(com_google_android_gms_internal_zzr_, com_google_android_gms_internal_zzw_, runnable));
    }
}
