package com.google.android.gms.internal;

public final class zzw<T> {
    public final T f8108a;
    public final zzc f8109b;
    public final zzad f8110c;
    public boolean f8111d;

    private zzw(zzad com_google_android_gms_internal_zzad) {
        this.f8111d = false;
        this.f8108a = null;
        this.f8109b = null;
        this.f8110c = com_google_android_gms_internal_zzad;
    }

    private zzw(T t, zzc com_google_android_gms_internal_zzc) {
        this.f8111d = false;
        this.f8108a = t;
        this.f8109b = com_google_android_gms_internal_zzc;
        this.f8110c = null;
    }

    public static <T> zzw<T> m6770a(zzad com_google_android_gms_internal_zzad) {
        return new zzw(com_google_android_gms_internal_zzad);
    }

    public static <T> zzw<T> m6771a(T t, zzc com_google_android_gms_internal_zzc) {
        return new zzw(t, com_google_android_gms_internal_zzc);
    }
}
