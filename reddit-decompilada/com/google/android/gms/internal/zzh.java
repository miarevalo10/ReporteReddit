package com.google.android.gms.internal;

public final class zzh implements zzaa {
    private int f14499a;
    private int f14500b;
    private final int f14501c;
    private final float f14502d;

    public zzh() {
        this((byte) 0);
    }

    private zzh(byte b) {
        this.f14499a = 2500;
        this.f14501c = 1;
        this.f14502d = 1.0f;
    }

    public final int mo1950a() {
        return this.f14499a;
    }

    public final void mo1951a(zzad com_google_android_gms_internal_zzad) throws zzad {
        int i = 1;
        this.f14500b++;
        this.f14499a = (int) (((float) this.f14499a) + (((float) this.f14499a) * this.f14502d));
        if (this.f14500b > this.f14501c) {
            i = 0;
        }
        if (i == 0) {
            throw com_google_android_gms_internal_zzad;
        }
    }

    public final int mo1952b() {
        return this.f14500b;
    }
}
