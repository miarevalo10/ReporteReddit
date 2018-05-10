package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakj;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzala;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zztu;
import com.google.android.gms.internal.zzzv;
import org.json.JSONObject;

@zzzv
public final class zzac {
    Context f5497a;
    private final Object f5498b = new Object();
    private long f5499c = 0;

    public final void m4457a(Context context, zzakd com_google_android_gms_internal_zzakd, String str, Runnable runnable) {
        m4458a(context, com_google_android_gms_internal_zzakd, true, null, str, null, runnable);
    }

    final void m4458a(Context context, zzakd com_google_android_gms_internal_zzakd, boolean z, zzafs com_google_android_gms_internal_zzafs, String str, String str2, Runnable runnable) {
        if (zzbs.m4492k().mo1633b() - this.f5499c < 5000) {
            zzakb.m5371e("Not retrying to fetch app settings");
            return;
        }
        this.f5499c = zzbs.m4492k().mo1633b();
        Object obj = 1;
        if (com_google_android_gms_internal_zzafs != null) {
            if ((zzbs.m4492k().mo1632a() - com_google_android_gms_internal_zzafs.f6338a > ((Long) zzkb.m6350f().m6488a(zznh.cd)).longValue() ? 1 : null) == null) {
                if (com_google_android_gms_internal_zzafs.f6342e != null) {
                    obj = null;
                }
            }
        }
        if (obj != null) {
            if (context == null) {
                zzakb.m5371e("Context not provided to fetch application settings");
            } else if (TextUtils.isEmpty(str) == null || TextUtils.isEmpty(str2) == null) {
                com_google_android_gms_internal_zzafs = context.getApplicationContext();
                if (com_google_android_gms_internal_zzafs == null) {
                    com_google_android_gms_internal_zzafs = context;
                }
                this.f5497a = com_google_android_gms_internal_zzafs;
                com_google_android_gms_internal_zzakd = zzbs.m4499r().m6661a(this.f5497a, com_google_android_gms_internal_zzakd).m6665a("google.afma.config.fetchAppSettings", zztu.f8035a, zztu.f8035a);
                try {
                    com_google_android_gms_internal_zzafs = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        com_google_android_gms_internal_zzafs.put("app_id", str);
                    } else if (TextUtils.isEmpty(str2) == null) {
                        com_google_android_gms_internal_zzafs.put("ad_unit_id", str2);
                    }
                    com_google_android_gms_internal_zzafs.put("is_init", z);
                    com_google_android_gms_internal_zzafs.put("pn", context.getPackageName());
                    zzakv b = com_google_android_gms_internal_zzakd.mo3566b(com_google_android_gms_internal_zzafs);
                    com_google_android_gms_internal_zzakd = zzakl.m5379a(b, new zzad(this), zzala.f6512b);
                    if (runnable != null) {
                        b.mo1732a(runnable, zzala.f6512b);
                    }
                    zzakj.m5376a(com_google_android_gms_internal_zzakd, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Context context2) {
                    zzakb.m5367b("Error requesting application settings", context2);
                }
            } else {
                zzakb.m5371e("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
