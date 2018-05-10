package com.google.android.gms.internal;

public final class zzdve {
    private final byte[] f7340a;

    private zzdve(byte[] bArr, int i) {
        this.f7340a = new byte[i];
        System.arraycopy(bArr, 0, this.f7340a, 0, i);
    }

    public static zzdve m5914a(byte[] bArr) {
        return bArr == null ? null : new zzdve(bArr, bArr.length);
    }

    public final byte[] m5915a() {
        Object obj = new byte[this.f7340a.length];
        System.arraycopy(this.f7340a, 0, obj, 0, this.f7340a.length);
        return obj;
    }
}
