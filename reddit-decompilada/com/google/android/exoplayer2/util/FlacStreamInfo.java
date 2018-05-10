package com.google.android.exoplayer2.util;

public final class FlacStreamInfo {
    public final int f5225a;
    public final int f5226b;
    public final int f5227c;
    public final int f5228d;
    public final int f5229e;
    public final int f5230f;
    public final int f5231g;
    public final long f5232h;

    public FlacStreamInfo(byte[] bArr) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.m4231a(136);
        this.f5225a = parsableBitArray.m4236c(16);
        this.f5226b = parsableBitArray.m4236c(16);
        this.f5227c = parsableBitArray.m4236c(24);
        this.f5228d = parsableBitArray.m4236c(24);
        this.f5229e = parsableBitArray.m4236c(20);
        this.f5230f = parsableBitArray.m4236c(3) + 1;
        this.f5231g = parsableBitArray.m4236c(5) + 1;
        this.f5232h = ((((long) parsableBitArray.m4236c(4)) & 15) << 32) | (((long) parsableBitArray.m4236c(32)) & 4294967295L);
    }
}
