package com.google.android.gms.internal;

@zzzv
public final class zzapa {
    final int f6683a;
    public final int f6684b;
    public final int f6685c;

    private zzapa(int i, int i2, int i3) {
        this.f6683a = i;
        this.f6685c = i2;
        this.f6684b = i3;
    }

    public static zzapa m5484a() {
        return new zzapa(0, 0, 0);
    }

    public static zzapa m5485a(int i, int i2) {
        return new zzapa(1, i, i2);
    }

    public static zzapa m5486a(zzjn com_google_android_gms_internal_zzjn) {
        return com_google_android_gms_internal_zzjn.f18155d ? new zzapa(3, 0, 0) : com_google_android_gms_internal_zzjn.f18160i ? new zzapa(2, 0, 0) : com_google_android_gms_internal_zzjn.f18159h ? m5484a() : m5485a(com_google_android_gms_internal_zzjn.f18157f, com_google_android_gms_internal_zzjn.f18154c);
    }

    public static zzapa m5487b() {
        return new zzapa(4, 0, 0);
    }

    public final boolean m5488c() {
        return this.f6683a == 3;
    }
}
