package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.List;

@zzzv
public final class zzjj extends zzbfm {
    public static final Creator<zzjj> CREATOR = new zzjl();
    public final int f18134a;
    public final long f18135b;
    public final Bundle f18136c;
    public final int f18137d;
    public final List<String> f18138e;
    public final boolean f18139f;
    public final int f18140g;
    public final boolean f18141h;
    public final String f18142i;
    public final zzmn f18143j;
    public final Location f18144k;
    public final String f18145l;
    public final Bundle f18146m;
    public final Bundle f18147n;
    public final List<String> f18148o;
    public final String f18149p;
    public final String f18150q;
    public final boolean f18151r;

    public zzjj(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzmn com_google_android_gms_internal_zzmn, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f18134a = i;
        this.f18135b = j;
        r0.f18136c = bundle == null ? new Bundle() : bundle;
        r0.f18137d = i2;
        r0.f18138e = list;
        r0.f18139f = z;
        r0.f18140g = i3;
        r0.f18141h = z2;
        r0.f18142i = str;
        r0.f18143j = com_google_android_gms_internal_zzmn;
        r0.f18144k = location;
        r0.f18145l = str2;
        r0.f18146m = bundle2 == null ? new Bundle() : bundle2;
        r0.f18147n = bundle3;
        r0.f18148o = list2;
        r0.f18149p = str3;
        r0.f18150q = str4;
        r0.f18151r = z3;
    }

    public static void m18774a(zzjj com_google_android_gms_internal_zzjj) {
        com_google_android_gms_internal_zzjj.f18146m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", com_google_android_gms_internal_zzjj.f18136c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj com_google_android_gms_internal_zzjj = (zzjj) obj;
        return this.f18134a == com_google_android_gms_internal_zzjj.f18134a && this.f18135b == com_google_android_gms_internal_zzjj.f18135b && zzbg.m4806a(this.f18136c, com_google_android_gms_internal_zzjj.f18136c) && this.f18137d == com_google_android_gms_internal_zzjj.f18137d && zzbg.m4806a(this.f18138e, com_google_android_gms_internal_zzjj.f18138e) && this.f18139f == com_google_android_gms_internal_zzjj.f18139f && this.f18140g == com_google_android_gms_internal_zzjj.f18140g && this.f18141h == com_google_android_gms_internal_zzjj.f18141h && zzbg.m4806a(this.f18142i, com_google_android_gms_internal_zzjj.f18142i) && zzbg.m4806a(this.f18143j, com_google_android_gms_internal_zzjj.f18143j) && zzbg.m4806a(this.f18144k, com_google_android_gms_internal_zzjj.f18144k) && zzbg.m4806a(this.f18145l, com_google_android_gms_internal_zzjj.f18145l) && zzbg.m4806a(this.f18146m, com_google_android_gms_internal_zzjj.f18146m) && zzbg.m4806a(this.f18147n, com_google_android_gms_internal_zzjj.f18147n) && zzbg.m4806a(this.f18148o, com_google_android_gms_internal_zzjj.f18148o) && zzbg.m4806a(this.f18149p, com_google_android_gms_internal_zzjj.f18149p) && zzbg.m4806a(this.f18150q, com_google_android_gms_internal_zzjj.f18150q) && this.f18151r == com_google_android_gms_internal_zzjj.f18151r;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18134a), Long.valueOf(this.f18135b), this.f18136c, Integer.valueOf(this.f18137d), this.f18138e, Boolean.valueOf(this.f18139f), Integer.valueOf(this.f18140g), Boolean.valueOf(this.f18141h), this.f18142i, this.f18143j, this.f18144k, this.f18145l, this.f18146m, this.f18147n, this.f18148o, this.f18149p, this.f18150q, Boolean.valueOf(this.f18151r)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18134a);
        zzbfp.m5541a(parcel, 2, this.f18135b);
        zzbfp.m5542a(parcel, 3, this.f18136c);
        zzbfp.m5540a(parcel, 4, this.f18137d);
        zzbfp.m5557b(parcel, 5, this.f18138e);
        zzbfp.m5547a(parcel, 6, this.f18139f);
        zzbfp.m5540a(parcel, 7, this.f18140g);
        zzbfp.m5547a(parcel, 8, this.f18141h);
        zzbfp.m5545a(parcel, 9, this.f18142i);
        zzbfp.m5544a(parcel, 10, this.f18143j, i);
        zzbfp.m5544a(parcel, 11, this.f18144k, i);
        zzbfp.m5545a(parcel, 12, this.f18145l);
        zzbfp.m5542a(parcel, 13, this.f18146m);
        zzbfp.m5542a(parcel, 14, this.f18147n);
        zzbfp.m5557b(parcel, 15, this.f18148o);
        zzbfp.m5545a(parcel, 16, this.f18149p);
        zzbfp.m5545a(parcel, 17, this.f18150q);
        zzbfp.m5547a(parcel, 18, this.f18151r);
        zzbfp.m5537a(parcel, a);
    }
}
