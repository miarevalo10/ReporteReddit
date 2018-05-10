package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

@zzzv
public final class zzabm extends zzbfm {
    public static final Creator<zzabm> CREATOR = new zzabn();
    private Bundle f17472a;
    private zzakd f17473b;
    private ApplicationInfo f17474c;
    private String f17475d;
    private List<String> f17476e;
    private PackageInfo f17477f;
    private String f17478g;
    private boolean f17479h;
    private String f17480i;

    public zzabm(Bundle bundle, zzakd com_google_android_gms_internal_zzakd, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, String str2, boolean z, String str3) {
        this.f17472a = bundle;
        this.f17473b = com_google_android_gms_internal_zzakd;
        this.f17475d = str;
        this.f17474c = applicationInfo;
        this.f17476e = list;
        this.f17477f = packageInfo;
        this.f17478g = str2;
        this.f17479h = z;
        this.f17480i = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5542a(parcel, 1, this.f17472a);
        zzbfp.m5544a(parcel, 2, this.f17473b, i);
        zzbfp.m5544a(parcel, 3, this.f17474c, i);
        zzbfp.m5545a(parcel, 4, this.f17475d);
        zzbfp.m5557b(parcel, 5, this.f17476e);
        zzbfp.m5544a(parcel, 6, this.f17477f, i);
        zzbfp.m5545a(parcel, 7, this.f17478g);
        zzbfp.m5547a(parcel, 8, this.f17479h);
        zzbfp.m5545a(parcel, 9, this.f17480i);
        zzbfp.m5537a(parcel, a);
    }
}
