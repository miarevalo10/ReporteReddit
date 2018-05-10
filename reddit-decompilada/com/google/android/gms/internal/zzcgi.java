package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgi extends zzbfm {
    public static final Creator<zzcgi> CREATOR = new zzcgj();
    public final String f17759a;
    public final String f17760b;
    public final String f17761c;
    public final String f17762d;
    public final long f17763e;
    public final long f17764f;
    public final String f17765g;
    public final boolean f17766h;
    public final boolean f17767i;
    public final long f17768j;
    public final String f17769k;
    public final long f17770l;
    public final long f17771m;
    public final int f17772n;
    public final boolean f17773o;

    zzcgi(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3) {
        zzbq.m4810a(str);
        this.f17759a = str;
        r0.f17760b = TextUtils.isEmpty(str2) ? null : str2;
        r0.f17761c = str3;
        r0.f17768j = j;
        r0.f17762d = str4;
        r0.f17763e = j2;
        r0.f17764f = j3;
        r0.f17765g = str5;
        r0.f17766h = z;
        r0.f17767i = z2;
        r0.f17769k = str6;
        r0.f17770l = j4;
        r0.f17771m = j5;
        r0.f17772n = i;
        r0.f17773o = z3;
    }

    zzcgi(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3) {
        this.f17759a = str;
        this.f17760b = str2;
        this.f17761c = str3;
        this.f17768j = j3;
        this.f17762d = str4;
        this.f17763e = j;
        this.f17764f = j2;
        this.f17765g = str5;
        this.f17766h = z;
        this.f17767i = z2;
        this.f17769k = str6;
        this.f17770l = j4;
        this.f17771m = j5;
        this.f17772n = i;
        this.f17773o = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17759a);
        zzbfp.m5545a(parcel, 3, this.f17760b);
        zzbfp.m5545a(parcel, 4, this.f17761c);
        zzbfp.m5545a(parcel, 5, this.f17762d);
        zzbfp.m5541a(parcel, 6, this.f17763e);
        zzbfp.m5541a(parcel, 7, this.f17764f);
        zzbfp.m5545a(parcel, 8, this.f17765g);
        zzbfp.m5547a(parcel, 9, this.f17766h);
        zzbfp.m5547a(parcel, 10, this.f17767i);
        zzbfp.m5541a(parcel, 11, this.f17768j);
        zzbfp.m5545a(parcel, 12, this.f17769k);
        zzbfp.m5541a(parcel, 13, this.f17770l);
        zzbfp.m5541a(parcel, 14, this.f17771m);
        zzbfp.m5540a(parcel, 15, this.f17772n);
        zzbfp.m5547a(parcel, 16, this.f17773o);
        zzbfp.m5537a(parcel, i);
    }
}
