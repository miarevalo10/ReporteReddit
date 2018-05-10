package com.google.android.gms.internal;

public final class zzfjn<M extends zzfjm<M>, T> {
    protected final Class<T> f7541a;
    public final int f7542b;
    protected final boolean f7543c;
    private int f7544d;

    protected final int m6185a(Object obj) {
        int i = this.f7542b >>> 3;
        switch (this.f7544d) {
            case 10:
                return (zzfjk.m6160b(i) << 1) + ((zzfjs) obj).m6211e();
            case 11:
                return zzfjk.m6162b(i, (zzfjs) obj);
            default:
                i = this.f7544d;
                StringBuilder stringBuilder = new StringBuilder(24);
                stringBuilder.append("Unknown type ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected final void m6186a(Object obj, zzfjk com_google_android_gms_internal_zzfjk) {
        try {
            com_google_android_gms_internal_zzfjk.m6182c(this.f7542b);
            switch (this.f7544d) {
                case 10:
                    int i = this.f7542b >>> 3;
                    ((zzfjs) obj).mo1928a(com_google_android_gms_internal_zzfjk);
                    com_google_android_gms_internal_zzfjk.m6183c(i, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zzfjk.m6180a((zzfjs) obj);
                    return;
                default:
                    int i2 = this.f7544d;
                    StringBuilder stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i2);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfjn)) {
            return false;
        }
        zzfjn com_google_android_gms_internal_zzfjn = (zzfjn) obj;
        return this.f7544d == com_google_android_gms_internal_zzfjn.f7544d && this.f7541a == com_google_android_gms_internal_zzfjn.f7541a && this.f7542b == com_google_android_gms_internal_zzfjn.f7542b && this.f7543c == com_google_android_gms_internal_zzfjn.f7543c;
    }

    public final int hashCode() {
        return ((((((1147 + this.f7544d) * 31) + this.f7541a.hashCode()) * 31) + this.f7542b) * 31) + this.f7543c;
    }
}
