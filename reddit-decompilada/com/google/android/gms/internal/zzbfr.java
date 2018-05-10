package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;

public final class zzbfr {
    public static <T extends zzbfq> void m5560a(T t, Intent intent, String str) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        t = obtain.marshall();
        obtain.recycle();
        intent.putExtra(str, t);
    }
}
