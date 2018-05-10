package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Random;

final class zzte extends zzki {
    private final zzkh f18299a;

    zzte(zzkh com_google_android_gms_internal_zzkh) {
        this.f18299a = com_google_android_gms_internal_zzkh;
    }

    public final void mo1962a() throws RemoteException {
        if (zztn.m6660a()) {
            int intValue = ((Integer) zzkb.m6350f().m6488a(zznh.aN)).intValue();
            int intValue2 = ((Integer) zzkb.m6350f().m6488a(zznh.aO)).intValue();
            if (intValue > 0) {
                if (intValue2 >= 0) {
                    zzahn.f6379a.postDelayed(zztf.f8002a, (long) (intValue + new Random().nextInt(intValue2 + 1)));
                }
            }
            zzbs.m4498q().m6650a();
        }
        this.f18299a.mo1962a();
    }

    public final void mo1963a(int i) throws RemoteException {
        this.f18299a.mo1963a(i);
    }

    public final void mo1964b() throws RemoteException {
        this.f18299a.mo1964b();
    }

    public final void mo1965c() throws RemoteException {
        this.f18299a.mo1965c();
    }

    public final void mo1966d() throws RemoteException {
        this.f18299a.mo1966d();
    }

    public final void mo1967e() throws RemoteException {
        this.f18299a.mo1967e();
    }

    public final void mo1968f() throws RemoteException {
        this.f18299a.mo1968f();
    }
}
