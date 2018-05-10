package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcih;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcjk;
import com.google.android.gms.internal.zzcka;
import com.google.android.gms.internal.zzckc;
import com.google.android.gms.internal.zzckf;
import com.google.android.gms.internal.zzclq;
import com.google.android.gms.tasks.Task;

@Keep
public final class FirebaseAnalytics {
    private final zzcim zziwf;

    public static class Event {
    }

    public static class Param {
    }

    public static class UserProperty {
    }

    public FirebaseAnalytics(zzcim com_google_android_gms_internal_zzcim) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        this.zziwf = com_google_android_gms_internal_zzcim;
    }

    public final Task<String> getAppInstanceId() {
        return this.zziwf.m5757h().m18363y();
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return zzcim.m5720a(context).f6980g;
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zziwf.f6979f.logEvent(str, bundle);
    }

    public final void setUserProperty(String str, String str2) {
        this.zziwf.f6979f.setUserProperty(str, str2);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zzcjk m = this.zziwf.m5762m();
        if (activity == null) {
            m.mo1828t().f17818c.m5693a("setCurrentScreen must be called with a non-null activity");
            return;
        }
        m.mo1827s();
        if (!zzcih.m18267y()) {
            m.mo1828t().f17818c.m5693a("setCurrentScreen must be called from the main thread");
        } else if (m.f17883g) {
            m.mo1828t().f17818c.m5693a("Cannot call setCurrentScreen from onScreenChangeCallback");
        } else if (m.f17878b == null) {
            m.mo1828t().f17818c.m5693a("setCurrentScreen cannot be called while no activity active");
        } else if (m.f17881e.get(activity) == null) {
            m.mo1828t().f17818c.m5693a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzckc.m18364a(activity.getClass().getCanonicalName());
            }
            boolean equals = m.f17878b.f8209c.equals(str2);
            boolean b = zzclq.m18521b(m.f17878b.f8208b, str);
            if (equals && b) {
                m.mo1828t().f17819d.m5693a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                m.mo1828t().f17818c.m5694a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                m.mo1828t().f17822g.m5695a("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzckf com_google_android_gms_internal_zzckf = new zzckf(str, str2, m.mo1824p().m18583y());
                m.f17881e.put(activity, com_google_android_gms_internal_zzckf);
                m.m18369a(activity, com_google_android_gms_internal_zzckf, true);
            } else {
                m.mo1828t().f17818c.m5694a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zziwf.f6979f.setMeasurementEnabled(z);
    }

    public final void setUserId(String str) {
        this.zziwf.f6979f.setUserPropertyInternal("app", "_id", str);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zziwf.f6979f.setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zziwf.f6979f.setSessionTimeoutDuration(j);
    }

    public final void resetAnalyticsData() {
        zzcjk h = this.zziwf.m5757h();
        h.mo1827s().m18271a(new zzcka(h));
    }
}
