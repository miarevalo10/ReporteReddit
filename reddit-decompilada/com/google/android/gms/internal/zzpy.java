package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzpy extends zzeu implements zzpx {
    zzpy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    public final IBinder mo2102a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5938a(o_, (IInterface) iObjectWrapper2);
        zzew.m5938a(o_, (IInterface) iObjectWrapper3);
        o_.writeInt(zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        Parcel a = m5934a(1, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
