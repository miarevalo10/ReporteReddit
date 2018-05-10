package com.google.android.gms.internal;

import java.util.List;

final class zzyp implements zzakh<List<zzoi>, zzog> {
    private /* synthetic */ String f14752a;
    private /* synthetic */ Integer f14753b;
    private /* synthetic */ Integer f14754c;
    private /* synthetic */ int f14755d;
    private /* synthetic */ int f14756e;
    private /* synthetic */ int f14757f;
    private /* synthetic */ int f14758g;
    private /* synthetic */ boolean f14759h;

    zzyp(String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.f14752a = str;
        this.f14753b = num;
        this.f14754c = num2;
        this.f14755d = i;
        this.f14756e = i2;
        this.f14757f = i3;
        this.f14758g = i4;
        this.f14759h = z;
    }

    public final /* synthetic */ Object mo1655a(Object obj) {
        List list = (List) obj;
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String str = this.f14752a;
        Integer num2 = this.f14753b;
        Integer num3 = this.f14754c;
        if (this.f14755d > 0) {
            num = Integer.valueOf(this.f14755d);
        }
        return new zzog(str, list, num2, num3, num, this.f14756e + this.f14757f, this.f14758g, this.f14759h);
    }
}
