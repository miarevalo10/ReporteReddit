package com.google.android.gms.internal;

final class zzfgt implements zzfhd {
    private zzfhd[] f14448a;

    zzfgt(zzfhd... com_google_android_gms_internal_zzfhdArr) {
        this.f14448a = com_google_android_gms_internal_zzfhdArr;
    }

    public final boolean mo1899a(Class<?> cls) {
        for (zzfhd a : this.f14448a) {
            if (a.mo1899a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzfhc mo1900b(Class<?> cls) {
        for (zzfhd com_google_android_gms_internal_zzfhd : this.f14448a) {
            if (com_google_android_gms_internal_zzfhd.mo1899a(cls)) {
                return com_google_android_gms_internal_zzfhd.mo1900b(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
