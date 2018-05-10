package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzbc extends zzeu implements zzba {
    zzbc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean mo1629a(zzn com_google_android_gms_common_zzn, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_common_zzn);
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(5, o_);
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
