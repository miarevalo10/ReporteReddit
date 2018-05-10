package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
final class zzckb implements ActivityLifecycleCallbacks {
    private /* synthetic */ zzcjn f7100a;

    private zzckb(zzcjn com_google_android_gms_internal_zzcjn) {
        this.f7100a = com_google_android_gms_internal_zzcjn;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f7100a.mo1828t().f17822g.m5693a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        Bundle a = this.f7100a.mo1824p().m18533a(data);
                        this.f7100a.mo1824p();
                        String str = zzclq.m18510a(intent) ? "gs" : "auto";
                        if (a != null) {
                            this.f7100a.m18332a(str, "_cmp", a);
                        }
                    }
                    Object queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                        if (obj == null) {
                            this.f7100a.mo1828t().f17821f.m5693a("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.f7100a.mo1828t().f17821f.m5694a("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.f7100a.m18335a("auto", "_ldl", queryParameter);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            this.f7100a.mo1828t().f17816a.m5694a("Throwable caught in onActivityCreated", th);
        }
        zzckc j = this.f7100a.mo1818j();
        if (bundle != null) {
            bundle = bundle.getBundle("com.google.firebase.analytics.screen_service");
            if (bundle != null) {
                activity = j.m18367a(activity);
                activity.d = bundle.getLong("id");
                activity.b = bundle.getString("name");
                activity.c = bundle.getString("referrer_name");
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f7100a.mo1818j().f17881e.remove(activity);
    }

    public final void onActivityPaused(Activity activity) {
        zzcjk j = this.f7100a.mo1818j();
        activity = j.m18367a(activity);
        j.f17879c = j.f17878b;
        j.f17880d = j.mo1819k().mo1633b();
        j.f17878b = null;
        j.mo1827s().m18271a(new zzcke(j, activity));
        activity = this.f7100a.mo1826r();
        activity.mo1827s().m18271a(new zzclj(activity, activity.mo1819k().mo1633b()));
    }

    public final void onActivityResumed(Activity activity) {
        zzcjk j = this.f7100a.mo1818j();
        j.m18369a(activity, j.m18367a(activity), false);
        activity = j.mo1812d();
        activity.mo1827s().m18271a(new zzcgg(activity, activity.mo1819k().mo1633b()));
        activity = this.f7100a.mo1826r();
        activity.mo1827s().m18271a(new zzcli(activity, activity.mo1819k().mo1633b()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzckc j = this.f7100a.mo1818j();
        if (bundle != null) {
            zzckf com_google_android_gms_internal_zzckf = (zzckf) j.f17881e.get(activity);
            if (com_google_android_gms_internal_zzckf != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", com_google_android_gms_internal_zzckf.d);
                bundle2.putString("name", com_google_android_gms_internal_zzckf.b);
                bundle2.putString("referrer_name", com_google_android_gms_internal_zzckf.c);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }
}
