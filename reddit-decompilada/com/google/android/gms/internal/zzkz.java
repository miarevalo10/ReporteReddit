package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzkz extends zzeu implements zzkx {
    zzkz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void mo2017a(String str, String str2) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        m5935b(1, o_);
    }
}
