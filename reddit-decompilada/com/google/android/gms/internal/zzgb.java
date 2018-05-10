package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import org.json.JSONObject;

@zzzv
public final class zzgb implements zzgo {
    private final zzft f14468a;
    private final zzanh f14469b;
    private final zzt<zzanh> f14470c = new zzgc(this);
    private final zzt<zzanh> f14471d = new zzgd(this);
    private final zzt<zzanh> f14472e = new zzge(this);

    public final void mo1946a(JSONObject jSONObject, boolean z) {
        if (z) {
            this.f14468a.m6243c(this);
        } else {
            this.f14469b.mo3465b("AFMA_updateActiveView", jSONObject);
        }
    }

    public final boolean mo1947a() {
        return true;
    }

    public final void mo1948b() {
        zzanh com_google_android_gms_internal_zzanh = this.f14469b;
        com_google_android_gms_internal_zzanh.mo3992b("/visibilityChanged", this.f14472e);
        com_google_android_gms_internal_zzanh.mo3992b("/untrackActiveViewUnit", this.f14471d);
        com_google_android_gms_internal_zzanh.mo3992b("/updateActiveView", this.f14470c);
    }

    public zzgb(zzft com_google_android_gms_internal_zzft, zzanh com_google_android_gms_internal_zzanh) {
        this.f14468a = com_google_android_gms_internal_zzft;
        this.f14469b = com_google_android_gms_internal_zzanh;
        com_google_android_gms_internal_zzft = this.f14469b;
        com_google_android_gms_internal_zzft.mo3984a("/updateActiveView", this.f14470c);
        com_google_android_gms_internal_zzft.mo3984a("/untrackActiveViewUnit", this.f14471d);
        com_google_android_gms_internal_zzft.mo3984a("/visibilityChanged", this.f14472e);
        com_google_android_gms_internal_zzft = "Custom JS tracking ad unit: ";
        com_google_android_gms_internal_zzanh = String.valueOf(this.f14468a.f7578b.f7573c);
        zzakb.m5366b(com_google_android_gms_internal_zzanh.length() != 0 ? com_google_android_gms_internal_zzft.concat(com_google_android_gms_internal_zzanh) : new String(com_google_android_gms_internal_zzft));
    }
}
