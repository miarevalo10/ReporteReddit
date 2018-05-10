package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzli extends zzeu implements zzlg {
    zzli(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void mo2030a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo2031a(float f) throws RemoteException {
        Parcel o_ = o_();
        o_.writeFloat(f);
        m5935b(2, o_);
    }

    public final void mo2032a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        m5935b(5, o_);
    }

    public final void mo2033a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        m5935b(3, o_);
    }

    public final void mo2034a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(6, o_);
    }

    public final void mo2035a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(4, o_);
    }

    public final float mo2036b() throws RemoteException {
        Parcel a = m5934a(7, o_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final boolean mo2037c() throws RemoteException {
        Parcel a = m5934a(8, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
