package com.google.android.gms.internal;

public final class zzfdb {
    private final byte[] f7374a = new byte[256];
    private int f7375b;
    private int f7376c;

    public zzfdb(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.f7374a[i] = (byte) i;
        }
        i = 0;
        int i2 = i;
        while (i < 256) {
            i2 = ((i2 + this.f7374a[i]) + bArr[i % bArr.length]) & 255;
            byte b = this.f7374a[i];
            this.f7374a[i] = this.f7374a[i2];
            this.f7374a[i2] = b;
            i++;
        }
        this.f7375b = 0;
        this.f7376c = 0;
    }

    public final void m5944a(byte[] bArr) {
        int i = this.f7375b;
        int i2 = this.f7376c;
        for (int i3 = 0; i3 < 256; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f7374a[i]) & 255;
            byte b = this.f7374a[i];
            this.f7374a[i] = this.f7374a[i2];
            this.f7374a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f7374a[(this.f7374a[i] + this.f7374a[i2]) & 255]);
        }
        this.f7375b = i;
        this.f7376c = i2;
    }
}
