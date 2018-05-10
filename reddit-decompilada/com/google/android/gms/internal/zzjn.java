package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;

@zzzv
public class zzjn extends zzbfm {
    public static final Creator<zzjn> CREATOR = new zzjo();
    public final String f18152a;
    public final int f18153b;
    public final int f18154c;
    public final boolean f18155d;
    public final int f18156e;
    public final int f18157f;
    public final zzjn[] f18158g;
    public final boolean f18159h;
    public final boolean f18160i;
    public boolean f18161j;

    public zzjn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzjn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public zzjn(zzjn com_google_android_gms_internal_zzjn, zzjn[] com_google_android_gms_internal_zzjnArr) {
        this(com_google_android_gms_internal_zzjn.f18152a, com_google_android_gms_internal_zzjn.f18153b, com_google_android_gms_internal_zzjn.f18154c, com_google_android_gms_internal_zzjn.f18155d, com_google_android_gms_internal_zzjn.f18156e, com_google_android_gms_internal_zzjn.f18157f, com_google_android_gms_internal_zzjnArr, com_google_android_gms_internal_zzjn.f18159h, com_google_android_gms_internal_zzjn.f18160i, com_google_android_gms_internal_zzjn.f18161j);
    }

    zzjn(String str, int i, int i2, boolean z, int i3, int i4, zzjn[] com_google_android_gms_internal_zzjnArr, boolean z2, boolean z3, boolean z4) {
        this.f18152a = str;
        this.f18153b = i;
        this.f18154c = i2;
        this.f18155d = z;
        this.f18156e = i3;
        this.f18157f = i4;
        this.f18158g = com_google_android_gms_internal_zzjnArr;
        this.f18159h = z2;
        this.f18160i = z3;
        this.f18161j = z4;
    }

    public static int m18775a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static zzjn m18776a() {
        return new zzjn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int m18777b(DisplayMetrics displayMetrics) {
        return (int) (((float) m18779c(displayMetrics)) * displayMetrics.density);
    }

    public static zzjn m18778b() {
        return new zzjn("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    private static int m18779c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public final AdSize m18780c() {
        return zzb.m4570a(this.f18156e, this.f18153b, this.f18152a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f18152a);
        zzbfp.m5540a(parcel, 3, this.f18153b);
        zzbfp.m5540a(parcel, 4, this.f18154c);
        zzbfp.m5547a(parcel, 5, this.f18155d);
        zzbfp.m5540a(parcel, 6, this.f18156e);
        zzbfp.m5540a(parcel, 7, this.f18157f);
        zzbfp.m5549a(parcel, 8, this.f18158g, i);
        zzbfp.m5547a(parcel, 9, this.f18159h);
        zzbfp.m5547a(parcel, 10, this.f18160i);
        zzbfp.m5547a(parcel, 11, this.f18161j);
        zzbfp.m5537a(parcel, a);
    }

    public zzjn(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        String adSize;
        int i3;
        AdSize adSize2 = adSizeArr[0];
        this.f18155d = false;
        boolean z = adSize2.f5378k == -3 && adSize2.f5379l == -4;
        this.f18160i = z;
        if (this.f18160i) {
            this.f18156e = AdSize.f5368a.f5378k;
            this.f18153b = AdSize.f5368a.f5379l;
        } else {
            this.f18156e = adSize2.f5378k;
            this.f18153b = adSize2.f5379l;
        }
        z = this.f18156e == -1;
        boolean z2 = this.f18153b == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            double d;
            zzkb.m6345a();
            if (zzajr.m5339g(context)) {
                zzkb.m6345a();
                if (zzajr.m5340h(context)) {
                    i = displayMetrics.widthPixels;
                    zzkb.m6345a();
                    i -= zzajr.m5341i(context);
                    this.f18157f = i;
                    d = (double) (((float) this.f18157f) / displayMetrics.density);
                    i2 = (int) d;
                    if (d - ((double) i2) >= 0.01d) {
                        i2++;
                    }
                }
            }
            i = displayMetrics.widthPixels;
            this.f18157f = i;
            d = (double) (((float) this.f18157f) / displayMetrics.density);
            i2 = (int) d;
            if (d - ((double) i2) >= 0.01d) {
                i2++;
            }
        } else {
            i2 = this.f18156e;
            zzkb.m6345a();
            this.f18157f = zzajr.m5319a(displayMetrics, this.f18156e);
        }
        i = z2 ? m18779c(displayMetrics) : this.f18153b;
        zzkb.m6345a();
        this.f18154c = zzajr.m5319a(displayMetrics, i);
        if (!z) {
            if (!z2) {
                adSize = this.f18160i ? "320x50_mb" : adSize2.toString();
                this.f18152a = adSize;
                if (adSizeArr.length <= 1) {
                    this.f18158g = new zzjn[adSizeArr.length];
                    for (i3 = 0; i3 < adSizeArr.length; i3++) {
                        this.f18158g[i3] = new zzjn(context, adSizeArr[i3]);
                    }
                } else {
                    this.f18158g = null;
                }
                this.f18159h = false;
                this.f18161j = false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append(i2);
        stringBuilder.append("x");
        stringBuilder.append(i);
        stringBuilder.append("_as");
        adSize = stringBuilder.toString();
        this.f18152a = adSize;
        if (adSizeArr.length <= 1) {
            this.f18158g = null;
        } else {
            this.f18158g = new zzjn[adSizeArr.length];
            for (i3 = 0; i3 < adSizeArr.length; i3++) {
                this.f18158g[i3] = new zzjn(context, adSizeArr[i3]);
            }
        }
        this.f18159h = false;
        this.f18161j = false;
    }
}
