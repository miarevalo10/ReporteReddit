package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray {
    public int f5233a;
    private long[] f5234b;

    public LongArray() {
        this((byte) 0);
    }

    private LongArray(byte b) {
        this.f5234b = new long[(byte) 32];
    }

    public final void m4207a(long j) {
        if (this.f5233a == this.f5234b.length) {
            this.f5234b = Arrays.copyOf(this.f5234b, this.f5233a * 2);
        }
        long[] jArr = this.f5234b;
        int i = this.f5233a;
        this.f5233a = i + 1;
        jArr[i] = j;
    }

    public final long m4206a(int i) {
        if (i >= 0) {
            if (i < this.f5233a) {
                return this.f5234b[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid index ");
        stringBuilder.append(i);
        stringBuilder.append(", size is ");
        stringBuilder.append(this.f5233a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final long[] m4208a() {
        return Arrays.copyOf(this.f5234b, this.f5233a);
    }
}
