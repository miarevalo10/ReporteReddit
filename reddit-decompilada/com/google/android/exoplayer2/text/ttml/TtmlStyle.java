package com.google.android.exoplayer2.text.ttml;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.util.Assertions;

final class TtmlStyle {
    String f5067a;
    int f5068b;
    boolean f5069c;
    int f5070d;
    boolean f5071e;
    int f5072f = -1;
    int f5073g = -1;
    int f5074h = -1;
    int f5075i = -1;
    int f5076j = -1;
    float f5077k;
    String f5078l;
    TtmlStyle f5079m;
    Alignment f5080n;

    public final int m4091a() {
        if (this.f5074h == -1 && this.f5075i == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.f5074h == 1 ? 1 : 0;
        if (this.f5075i == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final TtmlStyle m4094a(boolean z) {
        Assertions.m4186b(this.f5079m == null);
        this.f5072f = z;
        return this;
    }

    public final TtmlStyle m4096b(boolean z) {
        Assertions.m4186b(this.f5079m == null);
        this.f5073g = z;
        return this;
    }

    public final TtmlStyle m4092a(int i) {
        Assertions.m4186b(this.f5079m == null);
        this.f5068b = i;
        this.f5069c = true;
        return this;
    }

    public final TtmlStyle m4095b(int i) {
        this.f5070d = i;
        this.f5071e = true;
        return this;
    }

    public final TtmlStyle m4093a(TtmlStyle ttmlStyle) {
        if (ttmlStyle != null) {
            if (!this.f5069c && ttmlStyle.f5069c) {
                m4092a(ttmlStyle.f5068b);
            }
            if (this.f5074h == -1) {
                this.f5074h = ttmlStyle.f5074h;
            }
            if (this.f5075i == -1) {
                this.f5075i = ttmlStyle.f5075i;
            }
            if (this.f5067a == null) {
                this.f5067a = ttmlStyle.f5067a;
            }
            if (this.f5072f == -1) {
                this.f5072f = ttmlStyle.f5072f;
            }
            if (this.f5073g == -1) {
                this.f5073g = ttmlStyle.f5073g;
            }
            if (this.f5080n == null) {
                this.f5080n = ttmlStyle.f5080n;
            }
            if (this.f5076j == -1) {
                this.f5076j = ttmlStyle.f5076j;
                this.f5077k = ttmlStyle.f5077k;
            }
            if (!this.f5071e && ttmlStyle.f5071e) {
                m4095b(ttmlStyle.f5070d);
            }
        }
        return this;
    }
}
