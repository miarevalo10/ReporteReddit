package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkw extends zzeu implements zzkv {
    zzkw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder mo2016a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        o_.writeInt(i);
        Parcel a = m5934a(2, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
