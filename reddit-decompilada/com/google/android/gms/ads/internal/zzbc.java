package com.google.android.gms.ads.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzaat;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzpe;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzbc implements Callable<zzou> {
    private /* synthetic */ int f5515a;
    private /* synthetic */ JSONArray f5516b;
    private /* synthetic */ int f5517c;
    private /* synthetic */ zzafp f5518d;
    private /* synthetic */ zzba f5519e;

    zzbc(zzba com_google_android_gms_ads_internal_zzba, int i, JSONArray jSONArray, int i2, zzafp com_google_android_gms_internal_zzafp) {
        this.f5519e = com_google_android_gms_ads_internal_zzba;
        this.f5515a = i;
        this.f5516b = jSONArray;
        this.f5517c = i2;
        this.f5518d = com_google_android_gms_internal_zzafp;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.f5515a >= this.f5516b.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(r0.f5516b.get(r0.f5515a));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        zza com_google_android_gms_ads_internal_zzba = new zzba(r0.f5519e.e.f5600c, r0.f5519e.h, r0.f5519e.e.f5606i, r0.f5519e.e.f5599b, r0.f5519e.m, r0.f5519e.e.f5602e, true);
        zzba.m20857a(r0.f5519e.e, com_google_android_gms_ads_internal_zzba.e);
        com_google_android_gms_ads_internal_zzba.j_();
        com_google_android_gms_ads_internal_zzba.m17443a(r0.f5519e.b);
        zznu com_google_android_gms_internal_zznu = com_google_android_gms_ads_internal_zzba.f17125a;
        int i = r0.f5515a;
        com_google_android_gms_internal_zznu.m6504a("num_ads_requested", String.valueOf(r0.f5517c));
        com_google_android_gms_internal_zznu.m6504a("ad_index", String.valueOf(i));
        zzaat com_google_android_gms_internal_zzaat = r0.f5518d.f6314a;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = com_google_android_gms_internal_zzaat.f17396c.f18136c != null ? new Bundle(com_google_android_gms_internal_zzaat.f17396c.f18136c) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        int i2 = com_google_android_gms_internal_zzaat.f17396c.f18134a;
        long j = com_google_android_gms_internal_zzaat.f17396c.f18135b;
        int i3 = com_google_android_gms_internal_zzaat.f17396c.f18137d;
        List list = com_google_android_gms_internal_zzaat.f17396c.f18138e;
        boolean z = com_google_android_gms_internal_zzaat.f17396c.f18139f;
        int i4 = com_google_android_gms_internal_zzaat.f17396c.f18140g;
        boolean z2 = com_google_android_gms_internal_zzaat.f17396c.f18141h;
        String str = com_google_android_gms_internal_zzaat.f17396c.f18142i;
        zzmn com_google_android_gms_internal_zzmn = com_google_android_gms_internal_zzaat.f17396c.f18143j;
        Location location = com_google_android_gms_internal_zzaat.f17396c.f18144k;
        String str2 = com_google_android_gms_internal_zzaat.f17396c.f18145l;
        zzmn com_google_android_gms_internal_zzmn2 = com_google_android_gms_internal_zzmn;
        String str3 = str2;
        zzjj com_google_android_gms_internal_zzjj = new zzjj(i2, j, bundle, i3, list, z, i4, z2, str, com_google_android_gms_internal_zzmn2, location, str3, com_google_android_gms_internal_zzaat.f17396c.f18146m, com_google_android_gms_internal_zzaat.f17396c.f18147n, com_google_android_gms_internal_zzaat.f17396c.f18148o, com_google_android_gms_internal_zzaat.f17396c.f18149p, com_google_android_gms_internal_zzaat.f17396c.f18150q, com_google_android_gms_internal_zzaat.f17396c.f18151r);
        Bundle bundle2 = com_google_android_gms_internal_zzaat.f17395b;
        zzjn com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzaat.f17397d;
        String str4 = com_google_android_gms_internal_zzaat.f17398e;
        ApplicationInfo applicationInfo = com_google_android_gms_internal_zzaat.f17399f;
        PackageInfo packageInfo = com_google_android_gms_internal_zzaat.f17400g;
        String str5 = com_google_android_gms_internal_zzaat.f17402i;
        String str6 = com_google_android_gms_internal_zzaat.f17403j;
        zzakd com_google_android_gms_internal_zzakd = com_google_android_gms_internal_zzaat.f17404k;
        Bundle bundle3 = com_google_android_gms_internal_zzaat.f17405l;
        List list2 = com_google_android_gms_internal_zzaat.f17407n;
        List list3 = com_google_android_gms_internal_zzaat.f17419z;
        Bundle bundle4 = com_google_android_gms_internal_zzaat.f17408o;
        zza com_google_android_gms_ads_internal_zza = com_google_android_gms_ads_internal_zzba;
        boolean z3 = com_google_android_gms_internal_zzaat.f17409p;
        int i5 = com_google_android_gms_internal_zzaat.f17410q;
        int i6 = com_google_android_gms_internal_zzaat.f17411r;
        float f = com_google_android_gms_internal_zzaat.f17412s;
        String str7 = com_google_android_gms_internal_zzaat.f17413t;
        Bundle bundle5 = bundle3;
        List list4 = list2;
        long j2 = com_google_android_gms_internal_zzaat.f17414u;
        String str8 = com_google_android_gms_internal_zzaat.f17415v;
        List list5 = com_google_android_gms_internal_zzaat.f17416w;
        String str9 = com_google_android_gms_internal_zzaat.f17417x;
        zzpe com_google_android_gms_internal_zzpe = com_google_android_gms_internal_zzaat.f17418y;
        String str10 = com_google_android_gms_internal_zzaat.f17369B;
        float f2 = com_google_android_gms_internal_zzaat.f17370C;
        boolean z4 = com_google_android_gms_internal_zzaat.f17376I;
        int i7 = com_google_android_gms_internal_zzaat.f17371D;
        int i8 = com_google_android_gms_internal_zzaat.f17372E;
        boolean z5 = com_google_android_gms_internal_zzaat.f17373F;
        boolean z6 = com_google_android_gms_internal_zzaat.f17374G;
        Bundle bundle6 = bundle4;
        Future a = zzakl.m5377a(com_google_android_gms_internal_zzaat.f17375H);
        String str11 = com_google_android_gms_internal_zzaat.f17377J;
        boolean z7 = z6;
        boolean z8 = com_google_android_gms_internal_zzaat.f17378K;
        int i9 = com_google_android_gms_internal_zzaat.f17379L;
        Bundle bundle7 = com_google_android_gms_internal_zzaat.f17380M;
        String str12 = com_google_android_gms_internal_zzaat.f17381N;
        zzlr com_google_android_gms_internal_zzlr = com_google_android_gms_internal_zzaat.f17382O;
        boolean z9 = com_google_android_gms_internal_zzaat.f17383P;
        Bundle bundle8 = com_google_android_gms_internal_zzaat.f17384Q;
        List list6 = list3;
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        PackageInfo packageInfo2 = packageInfo;
        String str13 = str5;
        str3 = str6;
        zzakd com_google_android_gms_internal_zzakd2 = com_google_android_gms_internal_zzakd;
        Bundle bundle9 = bundle5;
        List list7 = list4;
        boolean z10 = z3;
        int i10 = i5;
        int i11 = i6;
        float f3 = f;
        String str14 = str7;
        long j3 = j2;
        String str15 = str8;
        List list8 = list5;
        String str16 = str9;
        zzpe com_google_android_gms_internal_zzpe2 = com_google_android_gms_internal_zzpe;
        String str17 = str10;
        float f4 = f2;
        boolean z11 = z4;
        int i12 = i7;
        int i13 = i8;
        boolean z12 = z5;
        boolean z13 = z7;
        zza com_google_android_gms_ads_internal_zza2 = com_google_android_gms_ads_internal_zza;
        com_google_android_gms_ads_internal_zza2.m20155a(new zzaau(bundle2, com_google_android_gms_internal_zzjj2, com_google_android_gms_internal_zzjn, str4, applicationInfo, packageInfo2, str13, str3, com_google_android_gms_internal_zzakd2, bundle9, list7, list6, bundle6, z10, i10, i11, f3, str14, j3, str15, list8, str16, com_google_android_gms_internal_zzpe2, str17, f4, z11, i12, i13, z12, z13, a, str11, z8, i9, bundle7, str12, com_google_android_gms_internal_zzlr, z9, bundle8, com_google_android_gms_internal_zzaat.f17388U, zzakl.m5377a(com_google_android_gms_internal_zzaat.f17401h), com_google_android_gms_internal_zzaat.f17389V, com_google_android_gms_internal_zzaat.f17390W, com_google_android_gms_internal_zzaat.f17391X, 1, com_google_android_gms_internal_zzaat.f17393Z, com_google_android_gms_internal_zzaat.aa, com_google_android_gms_internal_zzaat.ab), com_google_android_gms_ads_internal_zza2.f17125a);
        return (zzou) com_google_android_gms_ads_internal_zza2.f19544i.get();
    }
}