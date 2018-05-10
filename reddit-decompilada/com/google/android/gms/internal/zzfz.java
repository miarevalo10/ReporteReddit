package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;

public final class zzfz implements zzhd {
    private final WeakReference<View> f14466a;
    private final WeakReference<zzafo> f14467b;

    public zzfz(View view, zzafo com_google_android_gms_internal_zzafo) {
        this.f14466a = new WeakReference(view);
        this.f14467b = new WeakReference(com_google_android_gms_internal_zzafo);
    }

    public final View mo1943a() {
        return (View) this.f14466a.get();
    }

    public final boolean mo1944b() {
        if (this.f14466a.get() != null) {
            if (this.f14467b.get() != null) {
                return false;
            }
        }
        return true;
    }

    public final zzhd mo1945c() {
        return new zzfy((View) this.f14466a.get(), (zzafo) this.f14467b.get());
    }
}
