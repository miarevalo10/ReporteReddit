package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class zzi<TListener> {
    private TListener f5936a;
    private boolean f5937b = false;
    private /* synthetic */ zzd f5938c;

    public zzi(zzd com_google_android_gms_common_internal_zzd, TListener tListener) {
        this.f5938c = com_google_android_gms_common_internal_zzd;
        this.f5936a = tListener;
    }

    protected abstract void mo1630a(TListener tListener);

    public final void m4870b() {
        synchronized (this) {
            Object obj = this.f5936a;
            if (this.f5937b) {
                String valueOf = String.valueOf(this);
                StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
                stringBuilder.append("Callback proxy ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" being reused. This is not safe.");
                Log.w("GmsClient", stringBuilder.toString());
            }
        }
        if (obj != null) {
            try {
                mo1630a(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f5937b = true;
        }
        m4871c();
    }

    public final void m4871c() {
        m4872d();
        synchronized (this.f5938c.f5926r) {
            this.f5938c.f5926r.remove(this);
        }
    }

    public final void m4872d() {
        synchronized (this) {
            this.f5936a = null;
        }
    }
}
