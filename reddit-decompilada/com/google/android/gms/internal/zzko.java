package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public abstract class zzko extends zzev implements zzkn {
    public zzko() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        zzkh com_google_android_gms_internal_zzkh = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                IInterface a = mo1974a();
                parcel2.writeNoException();
                zzew.m5938a(parcel2, a);
                return true;
            case 2:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    com_google_android_gms_internal_zzkh = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new zzkj(readStrongBinder);
                }
                mo1976a(com_google_android_gms_internal_zzkh);
                break;
            case 3:
                mo1979a(zzqr.m14223a(parcel.readStrongBinder()));
                break;
            case 4:
                mo1980a(zzqu.m14225a(parcel.readStrongBinder()));
                break;
            case 5:
                mo1983a(parcel.readString(), zzra.m14229a(parcel.readStrongBinder()), zzqx.m14227a(parcel.readStrongBinder()));
                break;
            case 6:
                mo1978a((zzpe) zzew.m5937a(parcel, zzpe.CREATOR));
                break;
            case 7:
                zzld com_google_android_gms_internal_zzlf;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    com_google_android_gms_internal_zzlf = queryLocalInterface instanceof zzld ? (zzld) queryLocalInterface : new zzlf(readStrongBinder);
                }
                mo1977a(com_google_android_gms_internal_zzlf);
                break;
            case 8:
                mo1982a(zzrg.m14232a(parcel.readStrongBinder()), (zzjn) zzew.m5937a(parcel, zzjn.CREATOR));
                break;
            case 9:
                mo1975a((PublisherAdViewOptions) zzew.m5937a(parcel, PublisherAdViewOptions.CREATOR));
                break;
            case 10:
                mo1981a(zzrd.m14231a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
