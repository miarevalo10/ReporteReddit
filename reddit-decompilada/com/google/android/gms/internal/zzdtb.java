package com.google.android.gms.internal;

public enum zzdtb implements zzfga {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdtb> f14356f = null;
    private final int f14358g;

    static {
        f14356f = new zzdtc();
    }

    private zzdtb(int i) {
        this.f14358g = i;
    }

    public static zzdtb m13673a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
            default:
                return null;
        }
    }

    public final int mo1865a() {
        if (this != UNRECOGNIZED) {
            return this.f14358g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
