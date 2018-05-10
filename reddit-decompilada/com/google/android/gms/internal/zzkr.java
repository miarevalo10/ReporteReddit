package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkr extends zzeu implements zzkq {
    zzkr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    public final IBinder mo1984a(IObjectWrapper iObjectWrapper, String str, zzux com_google_android_gms_internal_zzux) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        Parcel a = m5934a(1, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
