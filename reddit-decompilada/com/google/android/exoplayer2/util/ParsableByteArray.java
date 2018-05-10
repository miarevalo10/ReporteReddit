package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

public final class ParsableByteArray {
    public byte[] f5256a;
    public int f5257b;
    public int f5258c;

    public ParsableByteArray(int i) {
        this.f5256a = new byte[i];
        this.f5258c = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f5256a = bArr;
        this.f5258c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.f5256a = bArr;
        this.f5258c = i;
    }

    public final void m4242a(int i) {
        m4244a(m4248c() < i ? new byte[i] : this.f5256a, i);
    }

    public final void m4244a(byte[] bArr, int i) {
        this.f5256a = bArr;
        this.f5258c = i;
        this.f5257b = null;
    }

    public final void m4241a() {
        this.f5257b = 0;
        this.f5258c = 0;
    }

    public final int m4246b() {
        return this.f5258c - this.f5257b;
    }

    public final void m4247b(int i) {
        boolean z = i >= 0 && i <= this.f5256a.length;
        Assertions.m4184a(z);
        this.f5258c = i;
    }

    public final int m4248c() {
        return this.f5256a == null ? 0 : this.f5256a.length;
    }

    public final void m4249c(int i) {
        boolean z = i >= 0 && i <= this.f5258c;
        Assertions.m4184a(z);
        this.f5257b = i;
    }

    public final void m4251d(int i) {
        m4249c(this.f5257b + i);
    }

    public final void m4243a(ParsableBitArray parsableBitArray, int i) {
        m4245a(parsableBitArray.f5252a, 0, i);
        parsableBitArray.m4231a(0);
    }

    public final void m4245a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f5256a, this.f5257b, bArr, i, i2);
        this.f5257b += i2;
    }

    public final int m4250d() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        return bArr[i] & 255;
    }

    public final int m4252e() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.f5256a;
        int i3 = this.f5257b;
        this.f5257b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int m4254f() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f5256a;
        int i3 = this.f5257b;
        this.f5257b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public final int m4256g() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.f5256a;
        int i3 = this.f5257b;
        this.f5257b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f5256a;
        i3 = this.f5257b;
        this.f5257b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final long m4257h() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f5256a;
        int i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        return j | (255 & ((long) bArr2[i2]));
    }

    public final long m4258i() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f5256a;
        int i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        return j | ((255 & ((long) bArr2[i2])) << 24);
    }

    public final int m4259j() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.f5256a;
        int i3 = this.f5257b;
        this.f5257b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f5256a;
        i3 = this.f5257b;
        this.f5257b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f5256a;
        i3 = this.f5257b;
        this.f5257b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int m4260k() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.f5256a;
        int i3 = this.f5257b;
        this.f5257b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.f5256a;
        i3 = this.f5257b;
        this.f5257b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.f5256a;
        i3 = this.f5257b;
        this.f5257b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public final long m4261l() {
        byte[] bArr = this.f5256a;
        int i = this.f5257b;
        this.f5257b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f5256a;
        int i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f5256a;
        i2 = this.f5257b;
        this.f5257b = i2 + 1;
        return j | (255 & ((long) bArr2[i2]));
    }

    public final int m4262m() {
        return (((m4250d() << 21) | (m4250d() << 14)) | (m4250d() << 7)) | m4250d();
    }

    public final int m4263n() {
        int j = m4259j();
        if (j >= 0) {
            return j;
        }
        StringBuilder stringBuilder = new StringBuilder("Top bit not zero: ");
        stringBuilder.append(j);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final int m4264o() {
        int k = m4260k();
        if (k >= 0) {
            return k;
        }
        StringBuilder stringBuilder = new StringBuilder("Top bit not zero: ");
        stringBuilder.append(k);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final long m4265p() {
        long l = m4261l();
        if (l >= 0) {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder("Top bit not zero: ");
        stringBuilder.append(l);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final String m4253e(int i) {
        return m4240a(i, Charset.forName("UTF-8"));
    }

    public final String m4240a(int i, Charset charset) {
        String str = new String(this.f5256a, this.f5257b, i, charset);
        this.f5257b += i;
        return str;
    }

    public final String m4255f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.f5257b + i) - 1;
        i2 = (i2 >= this.f5258c || this.f5256a[i2] != (byte) 0) ? i : i - 1;
        String str = new String(this.f5256a, this.f5257b, i2);
        this.f5257b += i;
        return str;
    }

    public final String m4266q() {
        if (m4246b() == 0) {
            return null;
        }
        int i = this.f5257b;
        while (i < this.f5258c && this.f5256a[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.f5256a, this.f5257b, i - this.f5257b);
        this.f5257b = i;
        if (this.f5257b < this.f5258c) {
            this.f5257b++;
        }
        return str;
    }

    public final String m4267r() {
        if (m4246b() == 0) {
            return null;
        }
        int i = this.f5257b;
        while (i < this.f5258c && !Util.m4311a(this.f5256a[i])) {
            i++;
        }
        if (i - this.f5257b >= 3 && this.f5256a[this.f5257b] == (byte) -17 && this.f5256a[this.f5257b + 1] == (byte) -69 && this.f5256a[this.f5257b + 2] == (byte) -65) {
            this.f5257b += 3;
        }
        String str = new String(this.f5256a, this.f5257b, i - this.f5257b);
        this.f5257b = i;
        if (this.f5257b == this.f5258c) {
            return str;
        }
        if (this.f5256a[this.f5257b] == (byte) 13) {
            this.f5257b++;
            if (this.f5257b == this.f5258c) {
                return str;
            }
        }
        if (this.f5256a[this.f5257b] == (byte) 10) {
            this.f5257b++;
        }
        return str;
    }
}
