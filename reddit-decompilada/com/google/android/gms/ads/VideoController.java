package com.google.android.gms.ads;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class VideoController {
    private final Object f5384a = new Object();
    private zzll f5385b;
    private VideoLifecycleCallbacks f5386c;

    public static abstract class VideoLifecycleCallbacks {
    }

    public final zzll m4382a() {
        zzll com_google_android_gms_internal_zzll;
        synchronized (this.f5384a) {
            com_google_android_gms_internal_zzll = this.f5385b;
        }
        return com_google_android_gms_internal_zzll;
    }

    public final boolean m4384b() {
        boolean z;
        synchronized (this.f5384a) {
            z = this.f5385b != null;
        }
        return z;
    }

    public final void m4383a(zzll com_google_android_gms_internal_zzll) {
        synchronized (this.f5384a) {
            this.f5385b = com_google_android_gms_internal_zzll;
            if (this.f5386c != null) {
                Object obj = this.f5386c;
                zzbq.m4809a(obj, (Object) "VideoLifecycleCallbacks may not be null.");
                synchronized (this.f5384a) {
                    this.f5386c = obj;
                    if (this.f5385b != null) {
                        try {
                            this.f5385b.mo2039a(new zzmq(obj));
                        } catch (zzll com_google_android_gms_internal_zzll2) {
                            zzakb.m5367b("Unable to call setVideoLifecycleCallbacks on video controller.", com_google_android_gms_internal_zzll2);
                        }
                    }
                }
            }
        }
    }
}
