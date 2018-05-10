package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class zzyu implements Runnable {
    final /* synthetic */ JSONObject f8186a;
    final /* synthetic */ zzalf f8187b;
    final /* synthetic */ zzyt f8188c;

    zzyu(zzyt com_google_android_gms_internal_zzyt, JSONObject jSONObject, zzalf com_google_android_gms_internal_zzalf) {
        this.f8188c = com_google_android_gms_internal_zzyt;
        this.f8186a = jSONObject;
        this.f8187b = com_google_android_gms_internal_zzalf;
    }

    public final void run() {
        try {
            zzyt com_google_android_gms_internal_zzyt = this.f8188c;
            zzbs.m4487f();
            zzanh a = zzanr.m5464a(com_google_android_gms_internal_zzyt.f8175a, zzapa.m5484a(), "native-video", false, false, com_google_android_gms_internal_zzyt.f8176b, com_google_android_gms_internal_zzyt.f8177c.f6314a.f17404k, com_google_android_gms_internal_zzyt.f8178d, null, com_google_android_gms_internal_zzyt.f8179e.m17462h(), com_google_android_gms_internal_zzyt.f8177c.f6322i);
            a.mo3981a(zzapa.m5487b());
            this.f8188c.f8179e.f19545j = a;
            WeakReference weakReference = new WeakReference(a);
            a.mo4019w().m5443a(zzyt.m6823a(this.f8188c, weakReference), zzyt.m6827b(this.f8188c, weakReference));
            zzyt.m6825a(this.f8188c, a);
            a.mo4019w().f6618e = new zzyv(this, a);
            a.mo4019w().f6617d = new zzyw(this);
            a.loadUrl((String) zzkb.m6350f().m6488a(zznh.bL));
        } catch (Throwable e) {
            zzakb.m5369c("Exception occurred while getting video view", e);
            this.f8187b.m13330b(null);
        }
    }
}
