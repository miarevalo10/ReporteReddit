package com.google.android.gms.internal;

abstract class zzcjl extends zzcjk {
    private boolean f14241a;

    final boolean m13544K() {
        return this.f14241a;
    }

    protected final void m13545L() {
        if (!m13544K()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m13546M() {
        if (this.f14241a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!mo3490w()) {
            this.s.m5771w();
            this.f14241a = true;
        }
    }

    public final void m13547N() {
        if (this.f14241a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l_();
        this.s.m5771w();
        this.f14241a = true;
    }

    protected void l_() {
    }

    protected abstract boolean mo3490w();

    zzcjl(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
        com_google_android_gms_internal_zzcim = this.s;
        com_google_android_gms_internal_zzcim.f6984k++;
    }
}
