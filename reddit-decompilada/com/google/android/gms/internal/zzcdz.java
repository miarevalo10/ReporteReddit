package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzn;

public final class zzcdz extends zzbfm {
    public static final Creator<zzcdz> CREATOR = new zzcea();
    private int f17723a;
    private zzcdx f17724b;
    private zzm f17725c;
    private zzceu f17726d;

    zzcdz(int i, zzcdx com_google_android_gms_internal_zzcdx, IBinder iBinder, IBinder iBinder2) {
        this.f17723a = i;
        this.f17724b = com_google_android_gms_internal_zzcdx;
        zzceu com_google_android_gms_internal_zzceu = null;
        this.f17725c = iBinder == null ? null : zzn.m14491a(iBinder);
        if (iBinder2 != null) {
            if (iBinder2 != null) {
                IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                com_google_android_gms_internal_zzceu = queryLocalInterface instanceof zzceu ? (zzceu) queryLocalInterface : new zzcew(iBinder2);
            }
        }
        this.f17726d = com_google_android_gms_internal_zzceu;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17723a);
        zzbfp.m5544a(parcel, 2, this.f17724b, i);
        IBinder iBinder = null;
        zzbfp.m5543a(parcel, 3, this.f17725c == null ? null : this.f17725c.asBinder());
        if (this.f17726d != null) {
            iBinder = this.f17726d.asBinder();
        }
        zzbfp.m5543a(parcel, 4, iBinder);
        zzbfp.m5537a(parcel, a);
    }
}
