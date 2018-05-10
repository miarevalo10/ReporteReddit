package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzcln extends zzbfm {
    public static final Creator<zzcln> CREATOR = new zzclo();
    public final String f17900a;
    public final long f17901b;
    public final String f17902c;
    private int f17903d;
    private Long f17904e;
    private Float f17905f;
    private String f17906g;
    private Double f17907h;

    zzcln(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f17903d = i;
        this.f17900a = str;
        this.f17901b = j;
        this.f17904e = l;
        Double d2 = null;
        this.f17905f = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.f17907h = d2;
        } else {
            this.f17907h = d;
        }
        this.f17906g = str2;
        this.f17902c = str3;
    }

    zzcln(zzclp com_google_android_gms_internal_zzclp) {
        this(com_google_android_gms_internal_zzclp.f7177c, com_google_android_gms_internal_zzclp.f7178d, com_google_android_gms_internal_zzclp.f7179e, com_google_android_gms_internal_zzclp.f7176b);
    }

    zzcln(String str, long j, Object obj, String str2) {
        zzbq.m4810a(str);
        this.f17903d = 2;
        this.f17900a = str;
        this.f17901b = j;
        this.f17902c = str2;
        if (obj == null) {
            this.f17904e = null;
            this.f17905f = null;
            this.f17907h = null;
            this.f17906g = null;
        } else if (obj instanceof Long) {
            this.f17904e = (Long) obj;
            this.f17905f = null;
            this.f17907h = null;
            this.f17906g = null;
        } else if (obj instanceof String) {
            this.f17904e = null;
            this.f17905f = null;
            this.f17907h = null;
            this.f17906g = (String) obj;
        } else if (obj instanceof Double) {
            this.f17904e = null;
            this.f17905f = null;
            this.f17907h = (Double) obj;
            this.f17906g = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object m18501a() {
        return this.f17904e != null ? this.f17904e : this.f17907h != null ? this.f17907h : this.f17906g != null ? this.f17906g : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17903d);
        zzbfp.m5545a(parcel, 2, this.f17900a);
        zzbfp.m5541a(parcel, 3, this.f17901b);
        zzbfp.m5553a(parcel, this.f17904e);
        zzbfp.m5545a(parcel, 6, this.f17906g);
        zzbfp.m5545a(parcel, 7, this.f17902c);
        zzbfp.m5552a(parcel, this.f17907h);
        zzbfp.m5537a(parcel, i);
    }
}
