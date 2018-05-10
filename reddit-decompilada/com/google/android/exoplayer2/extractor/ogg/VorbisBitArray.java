package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;

final class VorbisBitArray {
    int f4526a;
    int f4527b;
    private final byte[] f4528c;
    private final int f4529d;

    public VorbisBitArray(byte[] bArr) {
        this.f4528c = bArr;
        this.f4529d = bArr.length;
    }

    public final boolean m3842a() {
        boolean z = (((this.f4528c[this.f4526a] & 255) >> this.f4527b) & 1) == 1;
        m3843b(1);
        return z;
    }

    public final int m3841a(int i) {
        int i2 = this.f4526a;
        int min = Math.min(i, 8 - this.f4527b);
        int i3 = i2 + 1;
        i2 = ((this.f4528c[i2] & 255) >> this.f4527b) & (255 >> (8 - min));
        while (min < i) {
            i2 |= (this.f4528c[i3] & 255) << min;
            min += 8;
            i3++;
        }
        i2 &= -1 >>> (32 - i);
        m3843b(i);
        return i2;
    }

    public final void m3843b(int i) {
        int i2 = i / 8;
        this.f4526a += i2;
        this.f4527b += i - (i2 * 8);
        boolean z = true;
        if (this.f4527b > 7) {
            this.f4526a++;
            this.f4527b -= 8;
        }
        if (this.f4526a >= 0) {
            if (this.f4526a >= this.f4529d) {
                if (this.f4526a == this.f4529d && this.f4527b == 0) {
                }
            }
            Assertions.m4186b(z);
        }
        z = false;
        Assertions.m4186b(z);
    }
}
