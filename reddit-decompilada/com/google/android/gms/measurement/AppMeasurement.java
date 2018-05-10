package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcge;
import com.google.android.gms.internal.zzcgf;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcjk;
import com.google.android.gms.internal.zzcjt;
import com.google.android.gms.internal.zzcju;
import com.google.android.gms.internal.zzcln;
import com.google.android.gms.internal.zzclq;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    private final zzcim zziwf;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            zzbq.m4808a((Object) conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzclq.m18520b(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mValue = conditionalUserProperty.mValue;
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    public interface EventInterceptor {
    }

    public interface OnEventListener {
    }

    public interface zza {
        boolean m6846a();
    }

    public static class zzb {
        public String f8208b;
        public String f8209c;
        public long f8210d;

        public zzb(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
            this.f8208b = com_google_android_gms_measurement_AppMeasurement_zzb.f8208b;
            this.f8209c = com_google_android_gms_measurement_AppMeasurement_zzb.f8209c;
            this.f8210d = com_google_android_gms_measurement_AppMeasurement_zzb.f8210d;
        }
    }

    public static final class Event extends com.google.firebase.analytics.FirebaseAnalytics.Event {
        public static final String[] f14802a = new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"};
        public static final String[] f14803b = new String[]{"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_vs", "_ep"};

        public static String m14497a(String str) {
            return zzclq.m18507a(str, f14802a, f14803b);
        }
    }

    public static final class Param extends com.google.firebase.analytics.FirebaseAnalytics.Param {
        public static final String[] f14804a = new String[]{"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", Kind.TOPIC, "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name"};
        public static final String[] f14805b = new String[]{"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en"};

        public static String m14498a(String str) {
            return zzclq.m18507a(str, f14804a, f14805b);
        }
    }

    public static final class UserProperty extends com.google.firebase.analytics.FirebaseAnalytics.UserProperty {
        public static final String[] f14806a = new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install"};
        public static final String[] f14807b = new String[]{"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi"};

        public static String m14499a(String str) {
            return zzclq.m18507a(str, f14806a, f14807b);
        }
    }

    public AppMeasurement(zzcim com_google_android_gms_internal_zzcim) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        this.zziwf = com_google_android_gms_internal_zzcim;
    }

    @Keep
    public long generateEventId() {
        return this.zziwf.m5758i().m18583y();
    }

    @Keep
    public String getCurrentScreenClass() {
        zzb z = this.zziwf.m5762m().m18394z();
        return z != null ? z.f8209c : null;
    }

    @Keep
    public String getCurrentScreenName() {
        zzb z = this.zziwf.m5762m().m18394z();
        return z != null ? z.f8208b : null;
    }

    @Keep
    public int getMaxUserProperties(String str) {
        this.zziwf.m5757h();
        zzbq.m4810a(str);
        return 25;
    }

    public Map<String, Object> getUserProperties(boolean z) {
        List<zzcln> b = this.zziwf.m5757h().m18338b(z);
        Map<String, Object> arrayMap = new ArrayMap(b.size());
        for (zzcln com_google_android_gms_internal_zzcln : b) {
            arrayMap.put(com_google_android_gms_internal_zzcln.f17900a, com_google_android_gms_internal_zzcln.m18501a());
        }
        return arrayMap;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zziwf.m5757h().m18332a(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zziwf.m5757h().m18333a(str, str2, bundle, j);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zziwf.m5757h().m18330a(onEventListener);
    }

    @Keep
    protected void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zziwf.m5757h().m18328a(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zziwf.m5757h().m18340b(conditionalUserProperty);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zziwf.m5757h().m18329a(eventInterceptor);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zziwf.m5757h().m18337a(z);
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zziwf.m5757h().m18335a(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zziwf.m5757h().m18341b(onEventListener);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzcim.m5720a(context).f6979f;
    }

    public final void logEvent(String str, Bundle bundle) {
        boolean z;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        int i = 0;
        if ("_iap".equals(str) == null) {
            int b = this.zziwf.m5758i().m18549b(str);
            if (b != null) {
                this.zziwf.m5758i();
                String a = zzclq.m18506a(str, 40, true);
                if (str != null) {
                    i = str.length();
                }
                this.zziwf.m5758i().m18539a(b, "_ev", a, i);
                return;
            }
        }
        bundle = this.zziwf.m5757h();
        String str2 = "app";
        if (bundle.f17873b != null) {
            if (!zzclq.m18527h(str)) {
                z = false;
                bundle.m18334a(str2, str, bundle2, z, true);
            }
        }
        z = true;
        bundle.m18334a(str2, str, bundle2, z, true);
    }

    public final void setUserProperty(String str, String str2) {
        zzclq i = this.zziwf.m5758i();
        int i2 = 0;
        int i3 = 6;
        if (i.m18545a("user property", str)) {
            if (!i.m18546a("user property", UserProperty.f14806a, str)) {
                i3 = 15;
            } else if (i.m18544a("user property", 24, str)) {
                i3 = 0;
            }
        }
        if (i3 != 0) {
            this.zziwf.m5758i();
            str2 = zzclq.m18506a(str, 24, true);
            if (str != null) {
                i2 = str.length();
            }
            this.zziwf.m5758i().m18539a(i3, "_ev", str2, i2);
            return;
        }
        setUserPropertyInternal("app", str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        zzcjk h = this.zziwf.m5757h();
        h.mo1827s().m18271a(new zzcjt(h, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzcjk h = this.zziwf.m5757h();
        h.mo1827s().m18271a(new zzcju(h, j));
    }

    @Keep
    public void registerOnScreenChangeCallback(zza com_google_android_gms_measurement_AppMeasurement_zza) {
        zzcjk m = this.zziwf.m5762m();
        if (com_google_android_gms_measurement_AppMeasurement_zza == null) {
            m.mo1828t().f17818c.m5693a("Attempting to register null OnScreenChangeCallback");
            return;
        }
        m.f17882f.remove(com_google_android_gms_measurement_AppMeasurement_zza);
        m.f17882f.add(com_google_android_gms_measurement_AppMeasurement_zza);
    }

    @Keep
    public void unregisterOnScreenChangeCallback(zza com_google_android_gms_measurement_AppMeasurement_zza) {
        this.zziwf.m5762m().f17882f.remove(com_google_android_gms_measurement_AppMeasurement_zza);
    }

    @Keep
    public String getAppInstanceId() {
        return (String) this.zziwf.m5757h().f17874c.get();
    }

    @Keep
    public String getGmpAppId() {
        try {
            return zzbz.m4736a();
        } catch (IllegalStateException e) {
            this.zziwf.m5754e().f17816a.m5694a("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        zzcjk r = this.zziwf.m5767r();
        if (str != null) {
            if (str.length() != 0) {
                r.mo1827s().m18271a(new zzcge(r, str, r.mo1819k().mo1633b()));
                return;
            }
        }
        r.mo1828t().f17816a.m5693a("Ad unit id must be a non-empty string");
    }

    @Keep
    public void endAdUnitExposure(String str) {
        zzcjk r = this.zziwf.m5767r();
        if (str != null) {
            if (str.length() != 0) {
                r.mo1827s().m18271a(new zzcgf(r, str, r.mo1819k().mo1633b()));
                return;
            }
        }
        r.mo1828t().f17816a.m5693a("Ad unit id must be a non-empty string");
    }

    @Keep
    protected void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zziwf.m5757h().m18336a(null, str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzcjk h = this.zziwf.m5757h();
        zzbq.m4810a(str);
        h.mo1809a();
        h.m18336a(str, str2, str3, bundle);
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zziwf.m5757h().m18326a(null, str, str2, z);
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzcjk h = this.zziwf.m5757h();
        zzbq.m4810a(str);
        h.mo1809a();
        return h.m18326a(str, str2, str3, z);
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zziwf.m5757h().m18325a(null, str, str2);
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzcjk h = this.zziwf.m5757h();
        zzbq.m4810a(str);
        h.mo1809a();
        return h.m18325a(str, str2, str3);
    }
}
