package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzl extends zzeu implements zzk {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int mo1638a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        zzew.m5940a(o_, z);
        Parcel a = m5934a(3, o_);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final IObjectWrapper mo1639a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        o_.writeInt(i);
        Parcel a = m5934a(2, o_);
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
