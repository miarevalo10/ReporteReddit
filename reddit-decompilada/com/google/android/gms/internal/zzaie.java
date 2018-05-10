package com.google.android.gms.internal;

@zzzv
public final class zzaie {
    private boolean f6392a = false;
    private float f6393b = 1.0f;

    private final synchronized boolean m5257c() {
        return this.f6393b >= 0.0f;
    }

    public final synchronized float m5258a() {
        if (!m5257c()) {
            return 1.0f;
        }
        return this.f6393b;
    }

    public final synchronized void m5259a(float f) {
        this.f6393b = f;
    }

    public final synchronized void m5260a(boolean z) {
        this.f6392a = z;
    }

    public final synchronized boolean m5261b() {
        return this.f6392a;
    }
}
