package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzq;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

public final class zzcfq extends zzbfm {
    public static final Creator<zzcfq> CREATOR = new zzcfr();
    private int f17744a;
    private zzcfo f17745b;
    private zzs f17746c;
    private PendingIntent f17747d;
    private zzp f17748e;
    private zzceu f17749f;

    zzcfq(int i, zzcfo com_google_android_gms_internal_zzcfo, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f17744a = i;
        this.f17745b = com_google_android_gms_internal_zzcfo;
        zzceu com_google_android_gms_internal_zzceu = null;
        this.f17746c = iBinder == null ? null : zzt.m14495a(iBinder);
        this.f17747d = pendingIntent;
        this.f17748e = iBinder2 == null ? null : zzq.m14492a(iBinder2);
        if (iBinder3 != null) {
            if (iBinder3 != null) {
                IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                com_google_android_gms_internal_zzceu = queryLocalInterface instanceof zzceu ? (zzceu) queryLocalInterface : new zzcew(iBinder3);
            }
        }
        this.f17749f = com_google_android_gms_internal_zzceu;
    }

    public static zzcfq m17957a(zzp com_google_android_gms_location_zzp, zzceu com_google_android_gms_internal_zzceu) {
        return new zzcfq(2, null, null, null, com_google_android_gms_location_zzp.asBinder(), com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null);
    }

    public static zzcfq m17958a(zzs com_google_android_gms_location_zzs, zzceu com_google_android_gms_internal_zzceu) {
        return new zzcfq(2, null, com_google_android_gms_location_zzs.asBinder(), null, null, com_google_android_gms_internal_zzceu != null ? com_google_android_gms_internal_zzceu.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17744a);
        zzbfp.m5544a(parcel, 2, this.f17745b, i);
        IBinder iBinder = null;
        zzbfp.m5543a(parcel, 3, this.f17746c == null ? null : this.f17746c.asBinder());
        zzbfp.m5544a(parcel, 4, this.f17747d, i);
        zzbfp.m5543a(parcel, 5, this.f17748e == null ? null : this.f17748e.asBinder());
        if (this.f17749f != null) {
            iBinder = this.f17749f.asBinder();
        }
        zzbfp.m5543a(parcel, 6, iBinder);
        zzbfp.m5537a(parcel, a);
    }
}
