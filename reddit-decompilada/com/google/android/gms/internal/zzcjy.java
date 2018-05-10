package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzcjy implements Callable<String> {
    private /* synthetic */ zzcjn f7096a;

    zzcjy(zzcjn com_google_android_gms_internal_zzcjn) {
        this.f7096a = com_google_android_gms_internal_zzcjn;
    }

    public final /* synthetic */ Object call() throws Exception {
        String z = this.f7096a.mo1829u().m18224z();
        if (z != null) {
            return z;
        }
        zzcjk f = this.f7096a.mo1814f();
        String str = null;
        if (f.mo1827s().m18296z()) {
            f.mo1828t().f17816a.m5693a("Cannot retrieve app instance id from analytics worker thread");
        } else {
            f.mo1827s();
            if (zzcih.m18267y()) {
                f.mo1828t().f17816a.m5693a("Cannot retrieve app instance id from main thread");
            } else {
                long b = f.mo1819k().mo1633b();
                String a = f.m18324a(120000);
                long b2 = f.mo1819k().mo1633b() - b;
                str = (a != null || b2 >= 120000) ? a : f.m18324a(120000 - b2);
            }
        }
        if (str == null) {
            throw new TimeoutException();
        }
        f = this.f7096a.mo1829u();
        synchronized (f.f17839l) {
            f.f17837j = str;
            f.f17838k = f.mo1819k().mo1633b();
        }
        return str;
    }
}
