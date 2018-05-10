package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@zzzv
public class zzkd extends AdListener {
    final Object f14567a = new Object();
    AdListener f14568b;

    public void mo1257a() {
        synchronized (this.f14567a) {
            if (this.f14568b != null) {
                this.f14568b.mo1257a();
            }
        }
    }

    public void mo1258a(int i) {
        synchronized (this.f14567a) {
            if (this.f14568b != null) {
                this.f14568b.mo1258a(i);
            }
        }
    }

    public final void mo1260b() {
        synchronized (this.f14567a) {
            if (this.f14568b != null) {
                this.f14568b.mo1260b();
            }
        }
    }

    public final void mo1261c() {
        synchronized (this.f14567a) {
            if (this.f14568b != null) {
                this.f14568b.mo1261c();
            }
        }
    }

    public final void mo1262d() {
        synchronized (this.f14567a) {
            if (this.f14568b != null) {
                this.f14568b.mo1262d();
            }
        }
    }
}
