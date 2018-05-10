package com.google.android.gms.internal;

@zzzv
public abstract class zzagb implements zzaif<zzakv> {
    private final Runnable f14098a = new zzagc(this);
    private volatile Thread f14099b;
    private boolean f14100c = false;

    public zzagb(byte b) {
    }

    public abstract void mo3384a();

    public abstract void mo3385b();

    public final void mo1644d() {
        mo3385b();
        if (this.f14099b != null) {
            this.f14099b.interrupt();
        }
    }

    public final /* synthetic */ Object mo1645e() {
        return this.f14100c ? zzahh.m5147a(1, this.f14098a) : zzahh.m5148a(this.f14098a);
    }

    public final zzakv m13277h() {
        return this.f14100c ? zzahh.m5147a(1, this.f14098a) : zzahh.m5148a(this.f14098a);
    }
}
