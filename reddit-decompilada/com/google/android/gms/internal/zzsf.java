package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzsf extends zzki {
    private /* synthetic */ zzse f18294a;

    zzsf(zzse com_google_android_gms_internal_zzse) {
        this.f18294a = com_google_android_gms_internal_zzse;
    }

    public final void mo1962a() throws RemoteException {
        this.f18294a.f7994a.add(new zzsg());
    }

    public final void mo1963a(int i) throws RemoteException {
        this.f18294a.f7994a.add(new zzsh(i));
        zzagf.m13278a("Pooled interstitial failed to load.");
    }

    public final void mo1964b() throws RemoteException {
        this.f18294a.f7994a.add(new zzsi());
    }

    public final void mo1965c() throws RemoteException {
        this.f18294a.f7994a.add(new zzsj());
        zzagf.m13278a("Pooled interstitial loaded.");
    }

    public final void mo1966d() throws RemoteException {
        this.f18294a.f7994a.add(new zzsk());
    }

    public final void mo1967e() throws RemoteException {
        this.f18294a.f7994a.add(new zzsm());
    }

    public final void mo1968f() throws RemoteException {
        this.f18294a.f7994a.add(new zzsl());
    }
}
