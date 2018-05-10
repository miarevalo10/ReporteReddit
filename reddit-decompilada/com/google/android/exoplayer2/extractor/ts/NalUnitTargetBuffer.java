package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {
    boolean f4609a;
    public byte[] f4610b = new byte[131];
    public int f4611c;
    private final int f4612d;
    private boolean f4613e;

    public NalUnitTargetBuffer(int i) {
        this.f4612d = i;
        this.f4610b[2] = (byte) 1;
    }

    public final void m3865a() {
        this.f4613e = false;
        this.f4609a = false;
    }

    public final void m3866a(int i) {
        boolean z = true;
        Assertions.m4186b(this.f4613e ^ true);
        if (i != this.f4612d) {
            z = false;
        }
        this.f4613e = z;
        if (this.f4613e != 0) {
            this.f4611c = 3;
            this.f4609a = false;
        }
    }

    public final void m3867a(byte[] bArr, int i, int i2) {
        if (this.f4613e) {
            i2 -= i;
            if (this.f4610b.length < this.f4611c + i2) {
                this.f4610b = Arrays.copyOf(this.f4610b, (this.f4611c + i2) * 2);
            }
            System.arraycopy(bArr, i, this.f4610b, this.f4611c, i2);
            this.f4611c += i2;
        }
    }

    public final boolean m3868b(int i) {
        if (!this.f4613e) {
            return false;
        }
        this.f4611c -= i;
        this.f4613e = false;
        this.f4609a = true;
        return true;
    }
}
