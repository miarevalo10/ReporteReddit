package com.google.android.gms.internal;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzbs;

final class zzph implements Runnable {
    private /* synthetic */ zzow f7962a;
    private /* synthetic */ zzpg f7963b;

    zzph(zzpg com_google_android_gms_internal_zzpg, zzow com_google_android_gms_internal_zzow) {
        this.f7963b = com_google_android_gms_internal_zzpg;
        this.f7962a = com_google_android_gms_internal_zzow;
    }

    public final void run() {
        zzanh e;
        if (this.f7963b.f18249f) {
            if (this.f7963b.f18248e == null) {
                this.f7963b.f18248e = new View(this.f7963b.f18247d.getContext());
                this.f7963b.f18248e.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (this.f7963b.f18247d != this.f7963b.f18248e.getParent()) {
                this.f7963b.f18247d.addView(this.f7963b.f18248e);
            }
        }
        try {
            e = this.f7962a.mo3545e();
        } catch (Throwable e2) {
            zzbs.m4488g();
            if (zzaht.m5234e()) {
                zzakb.m5371e("Privileged processes cannot create HTML overlays.");
            } else {
                zzakb.m5367b("Error obtaining overlay.", e2);
            }
            e = null;
        }
        if (!(e == null || this.f7963b.f18245a == null)) {
            FrameLayout frameLayout = this.f7963b.f18245a;
            if (e == null) {
                throw null;
            }
            frameLayout.addView((View) e);
        }
        zzpg.m18934a(this.f7963b, this.f7962a);
    }
}
