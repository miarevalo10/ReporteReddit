package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzlh extends zzev implements zzlg {
    public zzlh() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2030a();
                break;
            case 2:
                mo2031a(parcel.readFloat());
                break;
            case 3:
                mo2033a(parcel.readString());
                break;
            case 4:
                mo2035a(zzew.m5941a(parcel));
                break;
            case 5:
                mo2032a(zza.m13115a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 6:
                mo2034a(parcel.readString(), zza.m13115a(parcel.readStrongBinder()));
                break;
            case 7:
                float b = mo2036b();
                parcel2.writeNoException();
                parcel2.writeFloat(b);
                return true;
            case 8:
                boolean c = mo2037c();
                parcel2.writeNoException();
                zzew.m5940a(parcel2, c);
                return true;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
