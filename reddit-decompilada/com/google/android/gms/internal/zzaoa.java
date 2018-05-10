package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zze;
import java.util.HashMap;
import java.util.Map;

@zzzv
public final class zzaoa extends zzlm {
    final zzamp f17580a;
    final Object f17581b = new Object();
    int f17582c;
    boolean f17583d = true;
    float f17584e;
    float f17585f;
    private final boolean f17586g;
    private final boolean f17587h;
    private final float f17588i;
    private zzlo f17589j;
    private boolean f17590k;
    private boolean f17591l = true;
    private boolean f17592m;
    private boolean f17593n;

    public zzaoa(zzamp com_google_android_gms_internal_zzamp, float f, boolean z, boolean z2) {
        this.f17580a = com_google_android_gms_internal_zzamp;
        this.f17588i = f;
        this.f17586g = z;
        this.f17587h = z2;
    }

    private final void m17875a(String str, Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbs.m4486e();
        zzahn.m5173a(new zzaob(this, hashMap));
    }

    public final void mo2038a() {
        m17875a("play", null);
    }

    public final void mo2039a(zzlo com_google_android_gms_internal_zzlo) {
        synchronized (this.f17581b) {
            this.f17589j = com_google_android_gms_internal_zzlo;
        }
    }

    public final void m17882a(zzmr com_google_android_gms_internal_zzmr) {
        synchronized (this.f17581b) {
            this.f17591l = com_google_android_gms_internal_zzmr.f18171a;
            this.f17592m = com_google_android_gms_internal_zzmr.f18172b;
            this.f17593n = com_google_android_gms_internal_zzmr.f18173c;
        }
        m17875a("initialState", zze.m4899a("muteStart", com_google_android_gms_internal_zzmr.f18171a ? "1" : "0", "customControlsRequested", com_google_android_gms_internal_zzmr.f18172b ? "1" : "0", "clickToExpandRequested", com_google_android_gms_internal_zzmr.f18173c ? "1" : "0"));
    }

    public final void mo2040a(boolean z) {
        m17875a(z ? "mute" : "unmute", null);
    }

    public final void mo2041b() {
        m17875a("pause", null);
    }

    public final boolean mo2042c() {
        boolean z;
        synchronized (this.f17581b) {
            z = this.f17583d;
        }
        return z;
    }

    public final int mo2043d() {
        int i;
        synchronized (this.f17581b) {
            i = this.f17582c;
        }
        return i;
    }

    public final float mo2044e() {
        float f;
        synchronized (this.f17581b) {
            f = this.f17585f;
        }
        return f;
    }

    public final float mo2045f() {
        return this.f17588i;
    }

    public final float mo2046g() {
        float f;
        synchronized (this.f17581b) {
            f = this.f17584e;
        }
        return f;
    }

    public final zzlo mo2047h() throws RemoteException {
        zzlo com_google_android_gms_internal_zzlo;
        synchronized (this.f17581b) {
            com_google_android_gms_internal_zzlo = this.f17589j;
        }
        return com_google_android_gms_internal_zzlo;
    }

    public final boolean mo2048i() {
        boolean z;
        synchronized (this.f17581b) {
            z = this.f17586g && this.f17592m;
        }
        return z;
    }

    public final boolean mo2049j() {
        boolean i = mo2048i();
        synchronized (this.f17581b) {
            if (!i) {
                if (this.f17593n && this.f17587h) {
                    i = true;
                }
            }
            i = false;
        }
        return i;
    }
}
