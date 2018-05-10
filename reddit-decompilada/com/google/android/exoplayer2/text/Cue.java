package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;

public class Cue {
    public final CharSequence f4928a;
    public final Alignment f4929b;
    public final Bitmap f4930c;
    public final float f4931d;
    public final int f4932e;
    public final int f4933f;
    public final float f4934g;
    public final int f4935h;
    public final float f4936i;
    public final float f4937j;
    public final boolean f4938k;
    public final int f4939l;

    public Cue(Bitmap bitmap, float f, float f2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, 0, f, 0, f3, f4, false, -16777216);
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, -16777216);
    }

    public Cue(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, f3, Float.MIN_VALUE, z, i4);
    }

    private Cue(CharSequence charSequence, Alignment alignment, Bitmap bitmap, float f, int i, int i2, float f2, int i3, float f3, float f4, boolean z, int i4) {
        this.f4928a = charSequence;
        this.f4929b = alignment;
        this.f4930c = bitmap;
        this.f4931d = f;
        this.f4932e = i;
        this.f4933f = i2;
        this.f4934g = f2;
        this.f4935h = i3;
        this.f4936i = f3;
        this.f4937j = f4;
        this.f4938k = z;
        this.f4939l = i4;
    }
}
