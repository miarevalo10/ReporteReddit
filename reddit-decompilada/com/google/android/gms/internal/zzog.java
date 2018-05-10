package com.google.android.gms.internal;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzog extends zzpn {
    private static final int f18178h = Color.rgb(12, 174, 206);
    private static final int f18179i;
    private static int f18180j;
    private static int f18181k = f18178h;
    final List<zzoi> f18182a = new ArrayList();
    final int f18183b;
    final int f18184c;
    final int f18185d;
    final int f18186e;
    final int f18187f;
    final boolean f18188g;
    private final String f18189l;
    private final List<zzpq> f18190m = new ArrayList();

    static {
        int rgb = Color.rgb(204, 204, 204);
        f18179i = rgb;
        f18180j = rgb;
    }

    public zzog(String str, List<zzoi> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.f18189l = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzoi com_google_android_gms_internal_zzoi = (zzoi) list.get(i3);
                this.f18182a.add(com_google_android_gms_internal_zzoi);
                this.f18190m.add(com_google_android_gms_internal_zzoi);
            }
        }
        this.f18183b = num != null ? num.intValue() : f18180j;
        this.f18184c = num2 != null ? num2.intValue() : f18181k;
        this.f18185d = num3 != null ? num3.intValue() : 12;
        this.f18186e = i;
        this.f18187f = i2;
        this.f18188g = z;
    }

    public final String mo2089a() {
        return this.f18189l;
    }

    public final List<zzpq> mo2090b() {
        return this.f18190m;
    }
}
