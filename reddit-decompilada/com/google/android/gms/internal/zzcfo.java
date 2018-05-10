package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzcfo extends zzbfm {
    public static final Creator<zzcfo> CREATOR = new zzcfp();
    static final List<zzcdv> f17735a = Collections.emptyList();
    private LocationRequest f17736b;
    private List<zzcdv> f17737c;
    private String f17738d;
    private boolean f17739e;
    private boolean f17740f;
    private boolean f17741g;
    private String f17742h;
    private boolean f17743i = true;

    zzcfo(LocationRequest locationRequest, List<zzcdv> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f17736b = locationRequest;
        this.f17737c = list;
        this.f17738d = str;
        this.f17739e = z;
        this.f17740f = z2;
        this.f17741g = z3;
        this.f17742h = str2;
    }

    @Deprecated
    public static zzcfo m17956a(LocationRequest locationRequest) {
        return new zzcfo(locationRequest, f17735a, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcfo)) {
            return false;
        }
        zzcfo com_google_android_gms_internal_zzcfo = (zzcfo) obj;
        return zzbg.m4806a(this.f17736b, com_google_android_gms_internal_zzcfo.f17736b) && zzbg.m4806a(this.f17737c, com_google_android_gms_internal_zzcfo.f17737c) && zzbg.m4806a(this.f17738d, com_google_android_gms_internal_zzcfo.f17738d) && this.f17739e == com_google_android_gms_internal_zzcfo.f17739e && this.f17740f == com_google_android_gms_internal_zzcfo.f17740f && this.f17741g == com_google_android_gms_internal_zzcfo.f17741g && zzbg.m4806a(this.f17742h, com_google_android_gms_internal_zzcfo.f17742h);
    }

    public final int hashCode() {
        return this.f17736b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f17736b.toString());
        if (this.f17738d != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.f17738d);
        }
        if (this.f17742h != null) {
            stringBuilder.append(" moduleId=");
            stringBuilder.append(this.f17742h);
        }
        stringBuilder.append(" hideAppOps=");
        stringBuilder.append(this.f17739e);
        stringBuilder.append(" clients=");
        stringBuilder.append(this.f17737c);
        stringBuilder.append(" forceCoarseLocation=");
        stringBuilder.append(this.f17740f);
        if (this.f17741g) {
            stringBuilder.append(" exemptFromBackgroundThrottle");
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f17736b, i);
        zzbfp.m5559c(parcel, 5, this.f17737c);
        zzbfp.m5545a(parcel, 6, this.f17738d);
        zzbfp.m5547a(parcel, 7, this.f17739e);
        zzbfp.m5547a(parcel, 8, this.f17740f);
        zzbfp.m5547a(parcel, 9, this.f17741g);
        zzbfp.m5545a(parcel, 10, this.f17742h);
        zzbfp.m5537a(parcel, a);
    }
}
