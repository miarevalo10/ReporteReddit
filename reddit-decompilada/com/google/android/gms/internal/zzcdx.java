package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.zze;
import java.util.Collections;
import java.util.List;

public final class zzcdx extends zzbfm {
    public static final Creator<zzcdx> CREATOR = new zzcdy();
    static final List<zzcdv> f17718a = Collections.emptyList();
    static final zze f17719b = new zze();
    private zze f17720c;
    private List<zzcdv> f17721d;
    private String f17722e;

    zzcdx(zze com_google_android_gms_location_zze, List<zzcdv> list, String str) {
        this.f17720c = com_google_android_gms_location_zze;
        this.f17721d = list;
        this.f17722e = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcdx)) {
            return false;
        }
        zzcdx com_google_android_gms_internal_zzcdx = (zzcdx) obj;
        return zzbg.m4806a(this.f17720c, com_google_android_gms_internal_zzcdx.f17720c) && zzbg.m4806a(this.f17721d, com_google_android_gms_internal_zzcdx.f17721d) && zzbg.m4806a(this.f17722e, com_google_android_gms_internal_zzcdx.f17722e);
    }

    public final int hashCode() {
        return this.f17720c.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, this.f17720c, i);
        zzbfp.m5559c(parcel, 2, this.f17721d);
        zzbfp.m5545a(parcel, 3, this.f17722e);
        zzbfp.m5537a(parcel, a);
    }
}
