package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

@zzzv
public final class zzaax extends zzbfm {
    public static final Creator<zzaax> CREATOR = new zzaay();
    public final zzaeq f17421A;
    public final List<String> f17422B;
    public final List<String> f17423C;
    public final boolean f17424D;
    public final zzaaz f17425E;
    public final boolean f17426F;
    public String f17427G;
    public final List<String> f17428H;
    public final boolean f17429I;
    public final String f17430J;
    public final zzaey f17431K;
    public final String f17432L;
    public final boolean f17433M;
    public final boolean f17434N;
    public final boolean f17435O;
    public final int f17436P;
    private zzaat f17437Q;
    private int f17438R;
    private zzabj f17439S;
    private Bundle f17440T;
    public final String f17441a;
    public String f17442b;
    public final List<String> f17443c;
    public final int f17444d;
    public final List<String> f17445e;
    public final long f17446f;
    public final boolean f17447g;
    public final long f17448h;
    public final List<String> f17449i;
    public final long f17450j;
    public final int f17451k;
    public final String f17452l;
    public final long f17453m;
    public final String f17454n;
    public final boolean f17455o;
    public final String f17456p;
    public final String f17457q;
    public final boolean f17458r;
    public final boolean f17459s;
    public final boolean f17460t;
    public final boolean f17461u;
    public final boolean f17462v;
    public String f17463w;
    public final String f17464x;
    public final boolean f17465y;
    public final boolean f17466z;

    public zzaax(int i) {
        this(19, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0);
    }

    public zzaax(int i, long j) {
        this(19, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0);
    }

    zzaax(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzabj com_google_android_gms_internal_zzabj, String str7, String str8, boolean z8, boolean z9, zzaeq com_google_android_gms_internal_zzaeq, List<String> list4, List<String> list5, boolean z10, zzaaz com_google_android_gms_internal_zzaaz, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzaey com_google_android_gms_internal_zzaey, String str11, boolean z13, boolean z14, Bundle bundle, boolean z15, int i4) {
        this.f17438R = i;
        this.f17441a = str;
        this.f17442b = str2;
        List list7 = null;
        r0.f17443c = list != null ? Collections.unmodifiableList(list) : null;
        r0.f17444d = i2;
        r0.f17445e = list2 != null ? Collections.unmodifiableList(list2) : null;
        r0.f17446f = j;
        r0.f17447g = z;
        r0.f17448h = j2;
        if (list3 != null) {
            list7 = Collections.unmodifiableList(list3);
        }
        r0.f17449i = list7;
        r0.f17450j = j3;
        r0.f17451k = i3;
        r0.f17452l = str3;
        r0.f17453m = j4;
        r0.f17454n = str4;
        r0.f17455o = z2;
        r0.f17456p = str5;
        r0.f17457q = str6;
        r0.f17458r = z3;
        r0.f17459s = z4;
        r0.f17460t = z5;
        r0.f17461u = z6;
        r0.f17433M = z13;
        r0.f17462v = z7;
        r0.f17439S = com_google_android_gms_internal_zzabj;
        r0.f17463w = str7;
        r0.f17464x = str8;
        if (r0.f17442b == null && r0.f17439S != null) {
            zzabx com_google_android_gms_internal_zzabx = (zzabx) r0.f17439S.m17705a(zzabx.CREATOR);
            if (!(com_google_android_gms_internal_zzabx == null || TextUtils.isEmpty(com_google_android_gms_internal_zzabx.f17494a))) {
                r0.f17442b = com_google_android_gms_internal_zzabx.f17494a;
            }
        }
        r0.f17465y = z8;
        r0.f17466z = z9;
        r0.f17421A = com_google_android_gms_internal_zzaeq;
        r0.f17422B = list4;
        r0.f17423C = list5;
        r0.f17424D = z10;
        r0.f17425E = com_google_android_gms_internal_zzaaz;
        r0.f17426F = z11;
        r0.f17427G = str9;
        r0.f17428H = list6;
        r0.f17429I = z12;
        r0.f17430J = str10;
        r0.f17431K = com_google_android_gms_internal_zzaey;
        r0.f17432L = str11;
        r0.f17434N = z14;
        r0.f17440T = bundle;
        r0.f17435O = z15;
        r0.f17436P = i4;
    }

    public zzaax(zzaat com_google_android_gms_internal_zzaat, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzaeq com_google_android_gms_internal_zzaeq, List<String> list4, List<String> list5, boolean z10, zzaaz com_google_android_gms_internal_zzaaz, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzaey com_google_android_gms_internal_zzaey, String str10, boolean z13, boolean z14, boolean z15) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, com_google_android_gms_internal_zzaeq, list4, list5, z10, com_google_android_gms_internal_zzaaz, z11, str8, list6, z12, str9, com_google_android_gms_internal_zzaey, str10, z13, z14, null, z15, 0);
        this.f17437Q = com_google_android_gms_internal_zzaat;
    }

    public zzaax(zzaat com_google_android_gms_internal_zzaat, String str, String str2, List<String> list, List<String> list2, long j, boolean z, List<String> list3, long j2, int i, String str3, long j3, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, String str6, boolean z6, boolean z7, zzaeq com_google_android_gms_internal_zzaeq, List<String> list4, List<String> list5, boolean z8, zzaaz com_google_android_gms_internal_zzaaz, boolean z9, String str7, List<String> list6, boolean z10, String str8, zzaey com_google_android_gms_internal_zzaey, String str9, boolean z11, boolean z12, boolean z13, int i2) {
        this(19, str, str2, list, -2, list2, j, z, -1, list3, j2, i, str3, j3, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z6, z7, com_google_android_gms_internal_zzaeq, list4, list5, z8, com_google_android_gms_internal_zzaaz, z9, str7, list6, z10, str8, com_google_android_gms_internal_zzaey, str9, z11, z12, null, z13, i2);
        this.f17437Q = com_google_android_gms_internal_zzaat;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!(this.f17437Q == null || this.f17437Q.f17394a < 9 || TextUtils.isEmpty(this.f17442b))) {
            this.f17439S = new zzabj(new zzabx(this.f17442b));
            this.f17442b = null;
        }
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17438R);
        zzbfp.m5545a(parcel, 2, this.f17441a);
        zzbfp.m5545a(parcel, 3, this.f17442b);
        zzbfp.m5557b(parcel, 4, this.f17443c);
        zzbfp.m5540a(parcel, 5, this.f17444d);
        zzbfp.m5557b(parcel, 6, this.f17445e);
        zzbfp.m5541a(parcel, 7, this.f17446f);
        zzbfp.m5547a(parcel, 8, this.f17447g);
        zzbfp.m5541a(parcel, 9, this.f17448h);
        zzbfp.m5557b(parcel, 10, this.f17449i);
        zzbfp.m5541a(parcel, 11, this.f17450j);
        zzbfp.m5540a(parcel, 12, this.f17451k);
        zzbfp.m5545a(parcel, 13, this.f17452l);
        zzbfp.m5541a(parcel, 14, this.f17453m);
        zzbfp.m5545a(parcel, 15, this.f17454n);
        zzbfp.m5547a(parcel, 18, this.f17455o);
        zzbfp.m5545a(parcel, 19, this.f17456p);
        zzbfp.m5545a(parcel, 21, this.f17457q);
        zzbfp.m5547a(parcel, 22, this.f17458r);
        zzbfp.m5547a(parcel, 23, this.f17459s);
        zzbfp.m5547a(parcel, 24, this.f17460t);
        zzbfp.m5547a(parcel, 25, this.f17461u);
        zzbfp.m5547a(parcel, 26, this.f17462v);
        zzbfp.m5544a(parcel, 28, this.f17439S, i);
        zzbfp.m5545a(parcel, 29, this.f17463w);
        zzbfp.m5545a(parcel, 30, this.f17464x);
        zzbfp.m5547a(parcel, 31, this.f17465y);
        zzbfp.m5547a(parcel, 32, this.f17466z);
        zzbfp.m5544a(parcel, 33, this.f17421A, i);
        zzbfp.m5557b(parcel, 34, this.f17422B);
        zzbfp.m5557b(parcel, 35, this.f17423C);
        zzbfp.m5547a(parcel, 36, this.f17424D);
        zzbfp.m5544a(parcel, 37, this.f17425E, i);
        zzbfp.m5547a(parcel, 38, this.f17426F);
        zzbfp.m5545a(parcel, 39, this.f17427G);
        zzbfp.m5557b(parcel, 40, this.f17428H);
        zzbfp.m5547a(parcel, 42, this.f17429I);
        zzbfp.m5545a(parcel, 43, this.f17430J);
        zzbfp.m5544a(parcel, 44, this.f17431K, i);
        zzbfp.m5545a(parcel, 45, this.f17432L);
        zzbfp.m5547a(parcel, 46, this.f17433M);
        zzbfp.m5547a(parcel, 47, this.f17434N);
        zzbfp.m5542a(parcel, 48, this.f17440T);
        zzbfp.m5547a(parcel, 49, this.f17435O);
        zzbfp.m5540a(parcel, 50, this.f17436P);
        zzbfp.m5537a(parcel, a);
    }
}
