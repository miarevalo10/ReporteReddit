package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcfr implements Creator<zzcfq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        zzcfo com_google_android_gms_internal_zzcfo = null;
        IBinder iBinder = com_google_android_gms_internal_zzcfo;
        PendingIntent pendingIntent = iBinder;
        IBinder iBinder2 = pendingIntent;
        IBinder iBinder3 = iBinder2;
        int i = 1;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzcfo = (zzcfo) zzbfn.m5512a(parcel, readInt, zzcfo.CREATOR);
                    break;
                case 3:
                    iBinder = zzbfn.m5528l(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzbfn.m5512a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = zzbfn.m5528l(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = zzbfn.m5528l(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcfq(i, com_google_android_gms_internal_zzcfo, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfq[i];
    }
}
