package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzcha extends zzbfm {
    public static final Creator<zzcha> CREATOR = new zzchb();
    public final String f17798a;
    public final zzcgx f17799b;
    public final String f17800c;
    public final long f17801d;

    zzcha(zzcha com_google_android_gms_internal_zzcha, long j) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        this.f17798a = com_google_android_gms_internal_zzcha.f17798a;
        this.f17799b = com_google_android_gms_internal_zzcha.f17799b;
        this.f17800c = com_google_android_gms_internal_zzcha.f17800c;
        this.f17801d = j;
    }

    public zzcha(String str, zzcgx com_google_android_gms_internal_zzcgx, String str2, long j) {
        this.f17798a = str;
        this.f17799b = com_google_android_gms_internal_zzcgx;
        this.f17800c = str2;
        this.f17801d = j;
    }

    public final String toString() {
        String str = this.f17800c;
        String str2 = this.f17798a;
        String valueOf = String.valueOf(this.f17799b);
        StringBuilder stringBuilder = new StringBuilder(((21 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("origin=");
        stringBuilder.append(str);
        stringBuilder.append(",name=");
        stringBuilder.append(str2);
        stringBuilder.append(",params=");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17798a);
        zzbfp.m5544a(parcel, 3, this.f17799b, i);
        zzbfp.m5545a(parcel, 4, this.f17800c);
        zzbfp.m5541a(parcel, 5, this.f17801d);
        zzbfp.m5537a(parcel, a);
    }
}
