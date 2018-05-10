package com.google.android.gms.internal;

import java.util.Map;

@zzzv
public final class zzwt {
    public final zzanh f8123a;
    public final boolean f8124b;
    public final String f8125c;

    public zzwt(zzanh com_google_android_gms_internal_zzanh, Map<String, String> map) {
        this.f8123a = com_google_android_gms_internal_zzanh;
        this.f8125c = (String) map.get("forceOrientation");
        this.f8124b = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
    }
}
