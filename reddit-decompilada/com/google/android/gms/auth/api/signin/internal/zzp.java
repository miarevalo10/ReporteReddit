package com.google.android.gms.auth.api.signin.internal;

public final class zzp {
    private static int f5721b = 31;
    public int f5722a = 1;

    public final zzp m4610a(Object obj) {
        this.f5722a = (f5721b * this.f5722a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final zzp m4611a(boolean z) {
        this.f5722a = (f5721b * this.f5722a) + z;
        return this;
    }
}
