package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray {
    private byte[] f5259a;
    private int f5260b;
    private int f5261c;
    private int f5262d;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        m4272a(bArr, i, i2);
    }

    public final void m4272a(byte[] bArr, int i, int i2) {
        this.f5259a = bArr;
        this.f5261c = i;
        this.f5260b = i2;
        this.f5262d = null;
        m4269f();
    }

    public final void m4270a() {
        int i = 1;
        int i2 = this.f5262d + 1;
        this.f5262d = i2;
        if (i2 == 8) {
            this.f5262d = 0;
            i2 = this.f5261c;
            if (m4268d(this.f5261c + 1)) {
                i = 2;
            }
            this.f5261c = i2 + i;
        }
        m4269f();
    }

    public final void m4271a(int i) {
        int i2 = this.f5261c;
        int i3 = i / 8;
        this.f5261c += i3;
        this.f5262d += i - (i3 * 8);
        if (this.f5262d > 7) {
            this.f5261c++;
            this.f5262d -= 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f5261c) {
                m4269f();
                return;
            } else if (m4268d(i2) != 0) {
                this.f5261c++;
                i2 += 2;
            }
        }
    }

    public final boolean m4274b(int i) {
        int i2 = this.f5261c;
        int i3 = i / 8;
        int i4 = this.f5261c + i3;
        int i5 = (this.f5262d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= i4 && i4 < this.f5260b) {
                if (m4268d(i2)) {
                    i4++;
                    i2 += 2;
                }
            }
        }
        if (i4 < this.f5260b) {
            return true;
        }
        if (i4 == this.f5260b && r3 == 0) {
            return true;
        }
        return false;
    }

    public final boolean m4273b() {
        boolean z = (this.f5259a[this.f5261c] & (128 >> this.f5262d)) != 0;
        m4270a();
        return z;
    }

    public final int m4275c(int i) {
        this.f5262d += i;
        int i2 = 0;
        while (true) {
            int i3 = 2;
            if (this.f5262d <= 8) {
                break;
            }
            this.f5262d -= 8;
            i2 |= (this.f5259a[this.f5261c] & 255) << this.f5262d;
            int i4 = this.f5261c;
            if (!m4268d(this.f5261c + 1)) {
                i3 = 1;
            }
            this.f5261c = i4 + i3;
        }
        i = (-1 >>> (32 - i)) & (i2 | ((this.f5259a[this.f5261c] & 255) >> (8 - this.f5262d)));
        if (this.f5262d == 8) {
            this.f5262d = 0;
            int i5 = this.f5261c;
            if (!m4268d(this.f5261c + 1)) {
                i3 = 1;
            }
            this.f5261c = i5 + i3;
        }
        m4269f();
        return i;
    }

    public final boolean m4276c() {
        int i = this.f5261c;
        int i2 = this.f5262d;
        int i3 = 0;
        while (this.f5261c < this.f5260b && !m4273b()) {
            i3++;
        }
        boolean z = this.f5261c == this.f5260b;
        this.f5261c = i;
        this.f5262d = i2;
        if (z || !m4274b((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public final int m4277d() {
        int e = m4278e();
        return (e % 2 == 0 ? -1 : 1) * ((e + 1) / 2);
    }

    public final int m4278e() {
        int i = 0;
        int i2 = 0;
        while (!m4273b()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = m4275c(i2);
        }
        return i3 + i;
    }

    private boolean m4268d(int i) {
        return 2 <= i && i < this.f5260b && this.f5259a[i] == (byte) 3 && this.f5259a[i - 2] == (byte) 0 && this.f5259a[i - 1] == 0;
    }

    private void m4269f() {
        boolean z = this.f5261c >= 0 && (this.f5261c < this.f5260b || (this.f5261c == this.f5260b && this.f5262d == 0));
        Assertions.m4186b(z);
    }
}
