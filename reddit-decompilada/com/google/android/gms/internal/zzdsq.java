package com.google.android.gms.internal;

public enum zzdsq implements zzfga {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzfgb<zzdsq> f14339g = null;
    private final int f14341h;

    static {
        f14339g = new zzdsr();
    }

    private zzdsq(int i) {
        this.f14341h = i;
    }

    public static zzdsq m13669a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA224;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
            default:
                return null;
        }
    }

    public final int mo1865a() {
        if (this != UNRECOGNIZED) {
            return this.f14341h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
