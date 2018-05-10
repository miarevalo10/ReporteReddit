package com.reddit.frontpage.util;

import android.content.Intent;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditDeepLinkActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.InstallEvent;
import com.reddit.frontpage.commons.analytics.events.v1.InstallEvent.InstallPayload;
import com.reddit.frontpage.commons.analytics.events.v1.SessionStartEvent;
import com.reddit.frontpage.commons.analytics.events.v1.SessionStartEvent.SessionStartPayload;
import io.branch.referral.Branch;
import org.json.JSONObject;
import timber.log.Timber;

public class BranchUtil {
    public static void m23662a() {
        Branch.m31872a(FrontpageApplication.f27402a).m31915a(new BranchUtil$$Lambda$0(System.currentTimeMillis()), null);
        if (!InternalSettings.a().f()) {
            InternalSettings.a().a(null);
        }
    }

    static final /* synthetic */ void m23663a(long j, JSONObject jSONObject) {
        long optLong;
        long j2;
        JSONObject jSONObject2 = jSONObject;
        Timber.b("Branch params: %s", new Object[]{jSONObject2});
        String a = m23661a(jSONObject2, "mweb_loid");
        InternalSettings a2 = InternalSettings.a();
        long j3 = 0;
        if (!TextUtils.isEmpty(a)) {
            optLong = jSONObject2.optLong("mweb_loid_created");
            if (optLong == 0) {
                optLong = System.currentTimeMillis();
            }
            a2.a.edit().putString("com.reddit.frontpage.install_settings.external_installation_id", a).putLong("com.reddit.frontpage.install_settings.installation_id_creation_time", optLong).apply();
            Config.i = a;
            Config.m = optLong;
        }
        if (InternalSettings.a().f()) {
            BaseEvent installEvent = new InstallEvent();
            if (jSONObject2.optBoolean("+match_guaranteed", false)) {
                ((InstallPayload) installEvent.payload).branch_params = JsonUtil.m23770a().a(jSONObject2).h().c("nameValuePairs");
            }
            ((InstallPayload) installEvent.payload).branch_response_timing = System.currentTimeMillis() - j;
            ((InstallPayload) installEvent.payload).url_parsed_utm_content = m23661a(jSONObject2, "utm_content");
            ((InstallPayload) installEvent.payload).url_parsed_utm_medium = m23661a(jSONObject2, "utm_medium");
            ((InstallPayload) installEvent.payload).url_parsed_utm_name = m23661a(jSONObject2, "utm_name");
            ((InstallPayload) installEvent.payload).url_parsed_utm_source = m23661a(jSONObject2, "utm_source");
            String a3 = m23661a(jSONObject2, "$og_redirect");
            if (a3 == null) {
                a3 = m23660a(jSONObject);
            }
            if (a3 != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a3), FrontpageApplication.f27402a, RedditDeepLinkActivity.class);
                a2.a(a3);
                ((InstallPayload) installEvent.payload).deeplinked = true;
            }
            AppAnalytics.m21852a(installEvent);
            Timber.b("Install event fired", new Object[0]);
        }
        InternalSettings a4 = InternalSettings.a();
        long uidTxBytes = TrafficStats.getUidTxBytes(Process.myUid());
        optLong = TrafficStats.getUidRxBytes(Process.myUid());
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        if (currentTimeMillis <= a4.a.getLong("com.reddit.frontpage.last_boot", 0) + 10) {
            j2 = a4.a.getLong("com.reddit.frontpage.data_tx", 0);
            j3 = j2;
            j2 = a4.a.getLong("com.reddit.frontpage.data_rx", 0);
        } else {
            j2 = 0;
        }
        BaseEvent sessionStartEvent = new SessionStartEvent();
        ((SessionStartPayload) sessionStartEvent.payload).bytes_transmitted = uidTxBytes - j3;
        ((SessionStartPayload) sessionStartEvent.payload).bytes_received = optLong - j2;
        ((SessionStartPayload) sessionStartEvent.payload).push_notifications_enabled = NotificationUtil.m23854a();
        a4.a.edit().putLong("com.reddit.frontpage.data_tx", uidTxBytes).apply();
        a4.a.edit().putLong("com.reddit.frontpage.data_rx", optLong).apply();
        a4.a.edit().putLong("com.reddit.frontpage.last_boot", currentTimeMillis).apply();
        AppAnalytics.m21852a(sessionStartEvent);
        Timber.b("Session event fired", new Object[0]);
    }

    public static String m23660a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String a = m23661a(jSONObject, "$canonical_url");
        if (a == null) {
            a = m23661a(jSONObject, "$android_deeplink_path");
            if (a != null && a.startsWith("reddit://") == null) {
                jSONObject = new StringBuilder("reddit://");
                jSONObject.append(a);
                a = jSONObject.toString();
            }
        }
        return a;
    }

    private static String m23661a(JSONObject jSONObject, String str) {
        return jSONObject.optBoolean("+match_guaranteed", false) ? jSONObject.optString(str, null) : null;
    }
}
