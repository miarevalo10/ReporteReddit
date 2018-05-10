package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzkm extends zzeu implements zzkk {
    zzkm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String mo1969a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo1970a(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        m5935b(1, o_);
    }

    public final void mo1971a(zzjj com_google_android_gms_internal_zzjj, int i) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeInt(i);
        m5935b(5, o_);
    }

    public final String mo1972b() throws RemoteException {
        Parcel a = m5934a(4, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean mo1973c() throws RemoteException {
        Parcel a = m5934a(3, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
