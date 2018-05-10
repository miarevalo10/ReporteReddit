package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcba extends zzeu implements zzcay {
    zzcba(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        zzew.m5940a(o_, z);
        o_.writeInt(i);
        Parcel a = m5934a(2, o_);
        z = zzew.m5941a(a);
        a.recycle();
        return z;
    }

    public final int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeInt(i);
        o_.writeInt(i2);
        Parcel a = m5934a(3, o_);
        i = a.readInt();
        a.recycle();
        return i;
    }

    public final long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeLong(j);
        o_.writeInt(i);
        Parcel a = m5934a(4, o_);
        j = a.readLong();
        a.recycle();
        return j;
    }

    public final String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        o_.writeInt(i);
        Parcel a = m5934a(5, o_);
        str2 = a.readString();
        a.recycle();
        return str2;
    }

    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(1, o_);
    }
}
