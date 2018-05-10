package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class zzdvo extends WeakReference<Throwable> {
    private final int f7349a;

    public zzdvo(Throwable th) {
        super(th, null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f7349a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzdvo com_google_android_gms_internal_zzdvo = (zzdvo) obj;
        return this.f7349a == com_google_android_gms_internal_zzdvo.f7349a && get() == com_google_android_gms_internal_zzdvo.get();
    }

    public final int hashCode() {
        return this.f7349a;
    }
}
