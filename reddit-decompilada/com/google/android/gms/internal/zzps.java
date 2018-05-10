package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public final class zzps extends zzeu implements zzpq {
    zzps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final IObjectWrapper mo2091a() throws RemoteException {
        Parcel a = m5934a(1, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final Uri mo2092b() throws RemoteException {
        Parcel a = m5934a(2, o_());
        Uri uri = (Uri) zzew.m5937a(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    public final double mo2093c() throws RemoteException {
        Parcel a = m5934a(3, o_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }
}
