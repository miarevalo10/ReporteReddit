package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzao extends zzbfm {
    public static final Creator<zzao> CREATOR = new zzap();
    public final boolean f17171a;
    public final boolean f17172b;
    public final boolean f17173c;
    public final float f17174d;
    public final int f17175e;
    public final boolean f17176f;
    public final boolean f17177g;
    private String f17178h;

    zzao(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5) {
        this.f17171a = z;
        this.f17172b = z2;
        this.f17178h = str;
        this.f17173c = z3;
        this.f17174d = f;
        this.f17175e = i;
        this.f17176f = z4;
        this.f17177g = z5;
    }

    public zzao(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5) {
        this(z, z2, null, z3, f, i, z4, z5);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 2, this.f17171a);
        zzbfp.m5547a(parcel, 3, this.f17172b);
        zzbfp.m5545a(parcel, 4, this.f17178h);
        zzbfp.m5547a(parcel, 5, this.f17173c);
        zzbfp.m5539a(parcel, 6, this.f17174d);
        zzbfp.m5540a(parcel, 7, this.f17175e);
        zzbfp.m5547a(parcel, 8, this.f17176f);
        zzbfp.m5547a(parcel, 9, this.f17177g);
        zzbfp.m5537a(parcel, i);
    }
}
