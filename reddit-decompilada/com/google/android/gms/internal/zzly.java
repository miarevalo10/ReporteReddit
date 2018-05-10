package com.google.android.gms.internal;

@zzzv
public final class zzly {
    private static zzly f7841a;
    private static final Object f7842b = new Object();
    private zzlg f7843c;

    private zzly() {
    }

    public static zzly m6467a() {
        zzly com_google_android_gms_internal_zzly;
        synchronized (f7842b) {
            if (f7841a == null) {
                f7841a = new zzly();
            }
            com_google_android_gms_internal_zzly = f7841a;
        }
        return com_google_android_gms_internal_zzly;
    }

    public final float m6468b() {
        if (this.f7843c == null) {
            return 1.0f;
        }
        try {
            return this.f7843c.mo2036b();
        } catch (Throwable e) {
            zzakb.m5367b("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final boolean m6469c() {
        if (this.f7843c == null) {
            return false;
        }
        try {
            return this.f7843c.mo2037c();
        } catch (Throwable e) {
            zzakb.m5367b("Unable to get app mute state.", e);
            return false;
        }
    }
}
