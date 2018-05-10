package com.google.android.gms.internal;

public enum zzdsa implements zzfga {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdsa> f14321e = null;
    private final int f14323f;

    static {
        f14321e = new zzdsb();
    }

    private zzdsa(int i) {
        this.f14323f = i;
    }

    public static zzdsa m13665a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
            default:
                return null;
        }
    }

    public final int mo1865a() {
        if (this != UNRECOGNIZED) {
            return this.f14323f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
