package com.google.android.exoplayer2.util;

public final class ParsableBitArray {
    public byte[] f5252a;
    public int f5253b;
    public int f5254c;
    private int f5255d;

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.f5252a = bArr;
        this.f5255d = i;
    }

    public final void m4232a(byte[] bArr, int i) {
        this.f5252a = bArr;
        this.f5253b = 0;
        this.f5254c = 0;
        this.f5255d = i;
    }

    public final int m4230a() {
        return ((this.f5255d - this.f5253b) * 8) - this.f5254c;
    }

    public final int m4233b() {
        Assertions.m4186b(this.f5254c == 0);
        return this.f5253b;
    }

    public final void m4231a(int i) {
        this.f5253b = i / 8;
        this.f5254c = i - (this.f5253b * 8);
        m4239e();
    }

    public final void m4234b(int i) {
        int i2 = i / 8;
        this.f5253b += i2;
        this.f5254c += i - (i2 * 8);
        if (this.f5254c > 7) {
            this.f5253b++;
            this.f5254c -= 8;
        }
        m4239e();
    }

    public final boolean m4237c() {
        boolean z = (this.f5252a[this.f5253b] & (128 >> this.f5254c)) != 0;
        int i = this.f5254c + 1;
        this.f5254c = i;
        if (i == 8) {
            this.f5254c = 0;
            this.f5253b++;
        }
        m4239e();
        return z;
    }

    public final int m4236c(int i) {
        if (i == 0) {
            return 0;
        }
        this.f5254c += i;
        int i2 = 0;
        while (this.f5254c > 8) {
            this.f5254c -= 8;
            byte[] bArr = this.f5252a;
            int i3 = this.f5253b;
            this.f5253b = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.f5254c;
        }
        i = (-1 >>> (32 - i)) & (i2 | ((this.f5252a[this.f5253b] & 255) >> (8 - this.f5254c)));
        if (this.f5254c == 8) {
            this.f5254c = 0;
            this.f5253b++;
        }
        m4239e();
        return i;
    }

    public final void m4238d() {
        if (this.f5254c != 0) {
            this.f5254c = 0;
            this.f5253b++;
            m4239e();
        }
    }

    public final void m4235b(byte[] bArr, int i) {
        Assertions.m4186b(this.f5254c == 0);
        System.arraycopy(this.f5252a, this.f5253b, bArr, 0, i);
        this.f5253b += i;
        m4239e();
    }

    public final void m4239e() {
        boolean z = this.f5253b >= 0 && (this.f5253b < this.f5255d || (this.f5253b == this.f5255d && this.f5254c == 0));
        Assertions.m4186b(z);
    }
}
