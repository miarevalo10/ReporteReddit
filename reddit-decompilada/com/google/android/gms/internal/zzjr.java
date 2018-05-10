package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

@zzzv
public class zzjr {
    private zzla f7757a;
    private final Object f7758b = new Object();
    private final zzji f7759c;
    private final zzjh f7760d;
    private final zzmb f7761e;
    private final zzri f7762f;
    private final zzadt f7763g;
    private final zzxd f7764h;
    private final zzrj f7765i;

    abstract class zza<T> {
        private /* synthetic */ zzjr f7756a;

        zza(zzjr com_google_android_gms_internal_zzjr) {
            this.f7756a = com_google_android_gms_internal_zzjr;
        }

        protected abstract T mo1959a() throws RemoteException;

        protected abstract T mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException;

        protected final T m6334b() {
            zzla a = this.f7756a.m6341b();
            if (a == null) {
                zzakb.m5371e("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return mo1960a(a);
            } catch (Throwable e) {
                zzakb.m5369c("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        protected final T m6335c() {
            try {
                return mo1959a();
            } catch (Throwable e) {
                zzakb.m5369c("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzjr(zzji com_google_android_gms_internal_zzji, zzjh com_google_android_gms_internal_zzjh, zzmb com_google_android_gms_internal_zzmb, zzri com_google_android_gms_internal_zzri, zzadt com_google_android_gms_internal_zzadt, zzxd com_google_android_gms_internal_zzxd, zzrj com_google_android_gms_internal_zzrj) {
        this.f7759c = com_google_android_gms_internal_zzji;
        this.f7760d = com_google_android_gms_internal_zzjh;
        this.f7761e = com_google_android_gms_internal_zzmb;
        this.f7762f = com_google_android_gms_internal_zzri;
        this.f7763g = com_google_android_gms_internal_zzadt;
        this.f7764h = com_google_android_gms_internal_zzxd;
        this.f7765i = com_google_android_gms_internal_zzrj;
    }

    private static zzla m6336a() {
        try {
            Object newInstance = zzjr.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zzlb.asInterface((IBinder) newInstance);
            }
            zzakb.m5371e("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            zzakb.m5369c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    public static <T> T m6338a(Context context, boolean z, zza<T> com_google_android_gms_internal_zzjr_zza_T) {
        T b;
        if (!z) {
            zzkb.m6345a();
            if (!zzajr.m5335c(context)) {
                zzakb.m5366b("Google Play Services is not available");
                z = true;
            }
        }
        zzkb.m6345a();
        int e = zzajr.m5337e(context);
        zzkb.m6345a();
        if (e > zzajr.m5336d(context)) {
            z = true;
        }
        if (z) {
            b = com_google_android_gms_internal_zzjr_zza_T.m6334b();
            if (b == null) {
                return com_google_android_gms_internal_zzjr_zza_T.m6335c();
            }
        }
        b = com_google_android_gms_internal_zzjr_zza_T.m6335c();
        if (b == null) {
            b = com_google_android_gms_internal_zzjr_zza_T.m6334b();
        }
        return b;
    }

    private final zzla m6341b() {
        zzla com_google_android_gms_internal_zzla;
        synchronized (this.f7758b) {
            if (this.f7757a == null) {
                this.f7757a = m6336a();
            }
            com_google_android_gms_internal_zzla = this.f7757a;
        }
        return com_google_android_gms_internal_zzla;
    }

    static /* synthetic */ void m6339a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzkb.m6345a();
        zzajr.m5324a(context, "gmob-apps", bundle);
    }
}
