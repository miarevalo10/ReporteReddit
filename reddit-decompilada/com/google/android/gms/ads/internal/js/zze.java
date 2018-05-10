package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzani;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zze implements zzc {
    private final zzanh f19075a;
    private final Context f19076b;

    public zze(Context context, zzakd com_google_android_gms_internal_zzakd, zzcv com_google_android_gms_internal_zzcv) throws zzanv {
        this.f19076b = context;
        zzbs.m4487f();
        this.f19075a = zzanr.m5464a(context, zzapa.m5484a(), "", false, false, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzakd, null, null, null, zzis.m6322a());
        zzanh com_google_android_gms_internal_zzanh = this.f19075a;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        ((View) com_google_android_gms_internal_zzanh).setWillNotDraw(true);
    }

    private static void m20128a(Runnable runnable) {
        zzkb.m6345a();
        if (zzajr.m5332b()) {
            runnable.run();
        } else {
            zzahn.f6379a.post(runnable);
        }
    }

    public final void mo3936a() {
        this.f19075a.destroy();
    }

    public final void mo3938a(String str) {
        m20128a(new zzh(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void mo3934a(String str, zzt<? super zzaj> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj) {
        this.f19075a.mo4019w().m5446a(str, new zzl(this, com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj));
    }

    public final void mo3462a(String str, Map<String, ?> map) {
        this.f19075a.mo3462a(str, (Map) map);
    }

    public final void mo3463a(String str, JSONObject jSONObject) {
        this.f19075a.mo3463a(str, jSONObject);
    }

    public final zzak mo3939b() {
        return new zzal(this);
    }

    public final void mo3940b(String str) {
        m20128a(new zzj(this, str));
    }

    public final void mo3465b(String str, JSONObject jSONObject) {
        m20128a(new zzg(this, str, jSONObject));
    }

    public final void mo3941c(String str) {
        m20128a(new zzi(this, str));
    }

    public final void mo3935b(String str, zzt<? super zzaj> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj) {
        zzani w = this.f19075a.mo4019w();
        zzr com_google_android_gms_ads_internal_js_zzf = new zzf(com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj);
        synchronized (w.f6616c) {
            List<zzt> list = (List) w.f6615b.get(str);
            if (list == null) {
                return;
            }
            Collection arrayList = new ArrayList();
            for (zzt com_google_android_gms_ads_internal_gmsg_zzt : list) {
                if (com_google_android_gms_ads_internal_js_zzf.mo1511a(com_google_android_gms_ads_internal_gmsg_zzt)) {
                    arrayList.add(com_google_android_gms_ads_internal_gmsg_zzt);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void mo3937a(zzd com_google_android_gms_ads_internal_js_zzd) {
        this.f19075a.mo4019w().f6617d = new zzk(com_google_android_gms_ads_internal_js_zzd);
    }
}
