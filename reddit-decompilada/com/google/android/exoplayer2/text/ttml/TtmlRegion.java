package com.google.android.exoplayer2.text.ttml;

final class TtmlRegion {
    public final String f5061a;
    public final float f5062b;
    public final float f5063c;
    public final int f5064d;
    public final int f5065e;
    public final float f5066f;

    public TtmlRegion() {
        this(null, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float f, float f2, int i, int i2, float f3) {
        this.f5061a = str;
        this.f5062b = f;
        this.f5063c = f2;
        this.f5064d = i;
        this.f5065e = i2;
        this.f5066f = f3;
    }
}
