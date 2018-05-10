package com.sendbird.android.shadow.okhttp3.internal.http2;

public final class Settings {
    int f23535a;
    final int[] f23536b = new int[10];

    final Settings m25527a(int i, int i2) {
        if (i >= 0) {
            if (i < this.f23536b.length) {
                this.f23535a = (1 << i) | this.f23535a;
                this.f23536b[i] = i2;
                return this;
            }
        }
        return this;
    }

    final boolean m25528a(int i) {
        return ((1 << i) & this.f23535a) != 0;
    }

    final int m25526a() {
        return (this.f23535a & 2) != 0 ? this.f23536b[1] : -1;
    }

    public final int m25529b() {
        return (this.f23535a & 128) != 0 ? this.f23536b[7] : 65535;
    }
}
