package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;

public final class AdSize {
    public static final AdSize f5368a = new AdSize(320, 50, "320x50_mb");
    public static final AdSize f5369b = new AdSize(468, 60, "468x60_as");
    public static final AdSize f5370c = new AdSize(320, 100, "320x100_as");
    public static final AdSize f5371d = new AdSize(728, 90, "728x90_as");
    public static final AdSize f5372e = new AdSize(300, 250, "300x250_as");
    public static final AdSize f5373f = new AdSize(160, 600, "160x600_as");
    public static final AdSize f5374g = new AdSize(-1, -2, "smart_banner");
    public static final AdSize f5375h = new AdSize(-3, -4, "fluid");
    public static final AdSize f5376i = new AdSize(50, 50, "50x50_mb");
    public static final AdSize f5377j = new AdSize(-3, 0, "search_v2");
    public final int f5378k;
    public final int f5379l;
    private final String f5380m;

    public AdSize(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String str = "_as";
        StringBuilder stringBuilder = new StringBuilder(((1 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(str).length());
        stringBuilder.append(valueOf);
        stringBuilder.append("x");
        stringBuilder.append(valueOf2);
        stringBuilder.append(str);
        this(i, i2, stringBuilder.toString());
    }

    AdSize(int i, int i2, String str) {
        StringBuilder stringBuilder;
        if (i < 0 && i != -1 && i != -3) {
            stringBuilder = new StringBuilder(37);
            stringBuilder.append("Invalid width for AdSize: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f5378k = i;
            this.f5379l = i2;
            this.f5380m = str;
        } else {
            stringBuilder = new StringBuilder(38);
            stringBuilder.append("Invalid height for AdSize: ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final int m4372a(Context context) {
        switch (this.f5379l) {
            case -4:
            case -3:
                return -1;
            case -2:
                return zzjn.m18777b(context.getResources().getDisplayMetrics());
            default:
                zzkb.m6345a();
                return zzajr.m5318a(context, this.f5379l);
        }
    }

    public final int m4373b(Context context) {
        int i = this.f5378k;
        if (i == -1) {
            return zzjn.m18775a(context.getResources().getDisplayMetrics());
        }
        switch (i) {
            case -4:
            case -3:
                return -1;
            default:
                zzkb.m6345a();
                return zzajr.m5318a(context, this.f5378k);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f5378k == adSize.f5378k && this.f5379l == adSize.f5379l && this.f5380m.equals(adSize.f5380m);
    }

    public final int hashCode() {
        return this.f5380m.hashCode();
    }

    public final String toString() {
        return this.f5380m;
    }
}
