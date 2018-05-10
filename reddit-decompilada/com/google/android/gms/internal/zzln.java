package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzln extends zzeu implements zzll {
    zzln(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final void mo2038a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo2039a(zzlo com_google_android_gms_internal_zzlo) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzlo);
        m5935b(8, o_);
    }

    public final void mo2040a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(3, o_);
    }

    public final void mo2041b() throws RemoteException {
        m5935b(2, o_());
    }

    public final boolean mo2042c() throws RemoteException {
        Parcel a = m5934a(4, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final int mo2043d() throws RemoteException {
        Parcel a = m5934a(5, o_());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final float mo2044e() throws RemoteException {
        Parcel a = m5934a(9, o_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final float mo2045f() throws RemoteException {
        Parcel a = m5934a(6, o_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final float mo2046g() throws RemoteException {
        Parcel a = m5934a(7, o_());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final zzlo mo2047h() throws RemoteException {
        zzlo com_google_android_gms_internal_zzlo;
        Parcel a = m5934a(11, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzlo = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            com_google_android_gms_internal_zzlo = queryLocalInterface instanceof zzlo ? (zzlo) queryLocalInterface : new zzlq(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzlo;
    }

    public final boolean mo2048i() throws RemoteException {
        Parcel a = m5934a(10, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final boolean mo2049j() throws RemoteException {
        Parcel a = m5934a(12, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }
}
