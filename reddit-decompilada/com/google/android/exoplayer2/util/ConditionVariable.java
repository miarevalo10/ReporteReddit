package com.google.android.exoplayer2.util;

public final class ConditionVariable {
    private boolean f5224a;

    public final synchronized boolean m4203a() {
        if (this.f5224a) {
            return false;
        }
        this.f5224a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean m4204b() {
        boolean z;
        z = this.f5224a;
        this.f5224a = false;
        return z;
    }

    public final synchronized void m4205c() throws InterruptedException {
        while (!this.f5224a) {
            wait();
        }
    }
}
