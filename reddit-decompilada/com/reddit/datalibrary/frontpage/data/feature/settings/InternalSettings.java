package com.reddit.datalibrary.frontpage.data.feature.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.util.JsonUtil;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.UUID;

public class InternalSettings {
    private static InternalSettings f10762b;
    public final SharedPreferences f10763a;

    private InternalSettings(Context context) {
        this.f10763a = context.getSharedPreferences("com.reddit.frontpage.internal_settings", 0);
    }

    public static InternalSettings m9061a() {
        if (f10762b == null) {
            f10762b = new InternalSettings(FrontpageApplication.a);
        }
        return f10762b;
    }

    public final String m9071b() {
        String string = this.f10763a.getString("com.reddit.frontpage.install_settings.installation_id", null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis();
        this.f10763a.edit().putString("com.reddit.frontpage.install_settings.installation_id", string).putLong("com.reddit.frontpage.install_settings.installation_id_creation_time", currentTimeMillis).putLong("com.reddit.frontpage.install_settings.install_timestamp", currentTimeMillis).apply();
        return string;
    }

    public final String m9072c() {
        return this.f10763a.getString("com.reddit.frontpage.install_settings.external_installation_id", null);
    }

    public final long m9073d() {
        m9071b();
        return this.f10763a.getLong("com.reddit.frontpage.install_settings.installation_id_creation_time", 0);
    }

    public final String m9074e() {
        return this.f10763a.getString("com.reddit.frontpage.install_settings.reddit_ad_id", null);
    }

    public final boolean m9075f() {
        return !m9076g();
    }

    public final boolean m9076g() {
        return this.f10763a.getBoolean("com.reddit.frontpage.seen_introduction", false);
    }

    public final void m9070a(boolean z) {
        this.f10763a.edit().putBoolean("com.reddit.frontpage.seen_introduction", z).apply();
    }

    public final ShareEvent m9077h() {
        return (ShareEvent) m9062a("com.reddit.frontpage.share_event", ShareEvent.class);
    }

    public final void m9066a(ShareEventBuilder shareEventBuilder) {
        m9069a("com.reddit.frontpage.share_event_v2", (Object) shareEventBuilder);
    }

    public final void m9078i() {
        this.f10763a.edit().remove("com.reddit.frontpage.share_event_v2").apply();
    }

    public final ShareEventBuilder m9079j() {
        return (ShareEventBuilder) m9062a("com.reddit.frontpage.share_event_v2", ShareEventBuilder.class);
    }

    public final void m9080k() {
        this.f10763a.edit().putBoolean("com.reddit.frontpage.user_rated_app", true).apply();
    }

    public final int m9081l() {
        return this.f10763a.getInt("com.reddit.frontpage.app_open_count", 0);
    }

    public final String m9082m() {
        return this.f10763a.getString("com.reddit.frontpage.version_user_prompted_to_rate", null);
    }

    public final void m9083n() {
        this.f10763a.edit().putBoolean("com.reddit.frontpage.has_employee_account", true).apply();
    }

    public final boolean m9084o() {
        return this.f10763a.getBoolean("com.reddit.frontpage.has_employee_account", false);
    }

    public final void m9067a(String str) {
        this.f10763a.edit().putString("com.reddit.frontpage.initial_deeplink", str).apply();
    }

    public final String m9085p() {
        return this.f10763a.getString("com.reddit.frontpage.initial_deeplink", null);
    }

    public final void m9068a(String str, int i, long j) {
        this.f10763a.edit().putLong(m9063a(str, i), j).apply();
    }

    public static String m9063a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("com.reddit.frontpage.sync_timestamp_");
        stringBuilder.append(str);
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public final void m9064a(int i) {
        this.f10763a.edit().putInt("com.reddit.pref.old_version", i).apply();
    }

    public final boolean m9086q() {
        return this.f10763a.getBoolean("com.reddit.frontpage.use_legacy_videoplayer", false);
    }

    public final NotificationSettings m9087r() {
        return (NotificationSettings) m9062a("com.reddit.frontpage.last_notification_settings", NotificationSettings.class);
    }

    public final void m9065a(NotificationSettings notificationSettings) {
        m9069a("com.reddit.frontpage.last_notification_settings", (Object) notificationSettings);
    }

    public final void m9069a(String str, Object obj) {
        this.f10763a.edit().putString(str, JsonUtil.a(obj)).apply();
    }

    private <T> T m9062a(String str, Class<T> cls) {
        str = this.f10763a.getString(str, null);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JsonUtil.a(str, cls);
    }
}
