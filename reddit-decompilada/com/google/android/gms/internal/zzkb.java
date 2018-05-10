package com.google.android.gms.internal;

@zzzv
public final class zzkb {
    private static final Object f7769a = new Object();
    private static zzkb f7770b;
    private final zzajr f7771c = new zzajr();
    private final zzjr f7772d = new zzjr(new zzji(), new zzjh(), new zzmb(), new zzri(), new zzadt(), new zzxd(), new zzrj());
    private final String f7773e = zzajr.m5334c();
    private final zznd f7774f = new zznd();
    private final zzne f7775g = new zzne();
    private final zznf f7776h = new zznf();

    static {
        zzkb com_google_android_gms_internal_zzkb = new zzkb();
        synchronized (f7769a) {
            f7770b = com_google_android_gms_internal_zzkb;
        }
    }

    protected zzkb() {
    }

    public static zzajr m6345a() {
        return m6351g().f7771c;
    }

    public static zzjr m6346b() {
        return m6351g().f7772d;
    }

    public static String m6347c() {
        return m6351g().f7773e;
    }

    public static zzne m6348d() {
        return m6351g().f7775g;
    }

    public static zznd m6349e() {
        return m6351g().f7774f;
    }

    public static zznf m6350f() {
        return m6351g().f7776h;
    }

    private static zzkb m6351g() {
        zzkb com_google_android_gms_internal_zzkb;
        synchronized (f7769a) {
            com_google_android_gms_internal_zzkb = f7770b;
        }
        return com_google_android_gms_internal_zzkb;
    }
}
