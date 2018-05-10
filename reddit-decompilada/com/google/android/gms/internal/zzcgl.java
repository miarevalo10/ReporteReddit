package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgl extends zzbfm {
    public static final Creator<zzcgl> CREATOR = new zzcgm();
    public String f17774a;
    public String f17775b;
    public zzcln f17776c;
    public long f17777d;
    public boolean f17778e;
    public String f17779f;
    public zzcha f17780g;
    public long f17781h;
    public zzcha f17782i;
    public long f17783j;
    public zzcha f17784k;
    private int f17785l;

    zzcgl(int i, String str, String str2, zzcln com_google_android_gms_internal_zzcln, long j, boolean z, String str3, zzcha com_google_android_gms_internal_zzcha, long j2, zzcha com_google_android_gms_internal_zzcha2, long j3, zzcha com_google_android_gms_internal_zzcha3) {
        this.f17785l = i;
        this.f17774a = str;
        this.f17775b = str2;
        this.f17776c = com_google_android_gms_internal_zzcln;
        this.f17777d = j;
        this.f17778e = z;
        this.f17779f = str3;
        this.f17780g = com_google_android_gms_internal_zzcha;
        this.f17781h = j2;
        this.f17782i = com_google_android_gms_internal_zzcha2;
        this.f17783j = j3;
        this.f17784k = com_google_android_gms_internal_zzcha3;
    }

    zzcgl(zzcgl com_google_android_gms_internal_zzcgl) {
        this.f17785l = 1;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        this.f17774a = com_google_android_gms_internal_zzcgl.f17774a;
        this.f17775b = com_google_android_gms_internal_zzcgl.f17775b;
        this.f17776c = com_google_android_gms_internal_zzcgl.f17776c;
        this.f17777d = com_google_android_gms_internal_zzcgl.f17777d;
        this.f17778e = com_google_android_gms_internal_zzcgl.f17778e;
        this.f17779f = com_google_android_gms_internal_zzcgl.f17779f;
        this.f17780g = com_google_android_gms_internal_zzcgl.f17780g;
        this.f17781h = com_google_android_gms_internal_zzcgl.f17781h;
        this.f17782i = com_google_android_gms_internal_zzcgl.f17782i;
        this.f17783j = com_google_android_gms_internal_zzcgl.f17783j;
        this.f17784k = com_google_android_gms_internal_zzcgl.f17784k;
    }

    zzcgl(String str, String str2, zzcln com_google_android_gms_internal_zzcln, long j, boolean z, String str3, zzcha com_google_android_gms_internal_zzcha, long j2, zzcha com_google_android_gms_internal_zzcha2, long j3, zzcha com_google_android_gms_internal_zzcha3) {
        this.f17785l = 1;
        this.f17774a = str;
        this.f17775b = str2;
        this.f17776c = com_google_android_gms_internal_zzcln;
        this.f17777d = j;
        this.f17778e = z;
        this.f17779f = str3;
        this.f17780g = com_google_android_gms_internal_zzcha;
        this.f17781h = j2;
        this.f17782i = com_google_android_gms_internal_zzcha2;
        this.f17783j = j3;
        this.f17784k = com_google_android_gms_internal_zzcha3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17785l);
        zzbfp.m5545a(parcel, 2, this.f17774a);
        zzbfp.m5545a(parcel, 3, this.f17775b);
        zzbfp.m5544a(parcel, 4, this.f17776c, i);
        zzbfp.m5541a(parcel, 5, this.f17777d);
        zzbfp.m5547a(parcel, 6, this.f17778e);
        zzbfp.m5545a(parcel, 7, this.f17779f);
        zzbfp.m5544a(parcel, 8, this.f17780g, i);
        zzbfp.m5541a(parcel, 9, this.f17781h);
        zzbfp.m5544a(parcel, 10, this.f17782i, i);
        zzbfp.m5541a(parcel, 11, this.f17783j);
        zzbfp.m5544a(parcel, 12, this.f17784k, i);
        zzbfp.m5537a(parcel, a);
    }
}
