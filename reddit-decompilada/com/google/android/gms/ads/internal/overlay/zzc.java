package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzc extends zzbfm {
    public static final Creator<zzc> CREATOR = new zzb();
    public final String f17095a;
    public final String f17096b;
    public final String f17097c;
    public final String f17098d;
    public final String f17099e;
    public final Intent f17100f;
    private String f17101g;
    private String f17102h;

    public zzc(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.f17101g = str;
        this.f17095a = str2;
        this.f17096b = str3;
        this.f17097c = str4;
        this.f17098d = str5;
        this.f17099e = str6;
        this.f17102h = str7;
        this.f17100f = intent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17101g);
        zzbfp.m5545a(parcel, 3, this.f17095a);
        zzbfp.m5545a(parcel, 4, this.f17096b);
        zzbfp.m5545a(parcel, 5, this.f17097c);
        zzbfp.m5545a(parcel, 6, this.f17098d);
        zzbfp.m5545a(parcel, 7, this.f17099e);
        zzbfp.m5545a(parcel, 8, this.f17102h);
        zzbfp.m5544a(parcel, 9, this.f17100f, i);
        zzbfp.m5537a(parcel, a);
    }
}
