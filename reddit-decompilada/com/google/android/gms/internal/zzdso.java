package com.google.android.gms.internal;

public enum zzdso implements zzfga {
    UNKNOWN_CURVE(0),
    NIST_P224(1),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdso> f14330g = null;
    private final int f14332h;

    static {
        f14330g = new zzdsp();
    }

    private zzdso(int i) {
        this.f14332h = i;
    }

    public static zzdso m13667a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_CURVE;
            case 1:
                return NIST_P224;
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            default:
                return null;
        }
    }

    public final int mo1865a() {
        if (this != UNRECOGNIZED) {
            return this.f14332h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
