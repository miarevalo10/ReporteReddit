package com.google.android.gms.internal;

public enum zzdtt implements zzfga {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdtt> f14365g = null;
    private final int f14367h;

    static {
        f14365g = new zzdtu();
    }

    private zzdtt(int i) {
        this.f14367h = i;
    }

    public static zzdtt m13675a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
            case 4:
                return CRUNCHY;
            default:
                return null;
        }
    }

    public final int mo1865a() {
        if (this != UNRECOGNIZED) {
            return this.f14367h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
