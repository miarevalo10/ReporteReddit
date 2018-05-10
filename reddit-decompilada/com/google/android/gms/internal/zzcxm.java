package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzan;

public final class zzcxm extends zzeu implements zzcxl {
    zzcxm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void mo1851a(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(7, o_);
    }

    public final void mo1852a(zzan com_google_android_gms_common_internal_zzan, int i, boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_common_internal_zzan);
        o_.writeInt(i);
        zzew.m5940a(o_, z);
        m5935b(9, o_);
    }

    public final void mo1853a(zzcxo com_google_android_gms_internal_zzcxo, zzcxj com_google_android_gms_internal_zzcxj) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcxo);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzcxj);
        m5935b(12, o_);
    }
}
