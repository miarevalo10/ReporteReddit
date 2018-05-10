package com.google.android.gms.internal;

public enum zzfiy {
    DOUBLE(zzfjd.DOUBLE, 1),
    FLOAT(zzfjd.FLOAT, 5),
    INT64(zzfjd.LONG, 0),
    UINT64(zzfjd.LONG, 0),
    INT32(zzfjd.INT, 0),
    FIXED64(zzfjd.LONG, 1),
    FIXED32(zzfjd.INT, 5),
    BOOL(zzfjd.BOOLEAN, 0),
    STRING,
    GROUP,
    MESSAGE,
    BYTES,
    UINT32(zzfjd.INT, 0),
    ENUM(zzfjd.ENUM, 0),
    SFIXED32(zzfjd.INT, 5),
    SFIXED64(zzfjd.LONG, 1),
    SINT32(zzfjd.INT, 0),
    SINT64(zzfjd.LONG, 0);
    
    final zzfjd f7516s;
    private final int f7517t;

    private zzfiy(zzfjd com_google_android_gms_internal_zzfjd, int i) {
        this.f7516s = com_google_android_gms_internal_zzfjd;
        this.f7517t = i;
    }
}
