package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzxf extends zzev implements zzxe {
    public zzxf() {
        attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzxe m14435a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof zzxe ? (zzxe) queryLocalInterface : new zzxg(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo2278a((Bundle) zzew.m5937a(parcel, Bundle.CREATOR));
                break;
            case 2:
                mo2283f();
                break;
            case 3:
                mo2284g();
                break;
            case 4:
                mo2285h();
                break;
            case 5:
                mo2286i();
                break;
            case 6:
                Bundle bundle = (Bundle) zzew.m5937a(parcel, Bundle.CREATOR);
                mo2280b(bundle);
                parcel2.writeNoException();
                zzew.m5943b(parcel2, bundle);
                return true;
            case 7:
                mo2287j();
                break;
            case 8:
                mo2288k();
                break;
            case 9:
                mo2289l();
                break;
            case 10:
                mo2281d();
                break;
            case 11:
                boolean e = mo2282e();
                parcel2.writeNoException();
                zzew.m5940a(parcel2, e);
                return true;
            case 12:
                mo2277a(parcel.readInt(), parcel.readInt(), (Intent) zzew.m5937a(parcel, Intent.CREATOR));
                break;
            case 13:
                mo2279a(zza.m13115a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
