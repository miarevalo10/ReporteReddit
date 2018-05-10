package io.fabric.sdk.android.services.settings;

import com.crashlytics.android.beta.BuildConfig;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Feature;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    public final SettingsData mo5613a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        AppIconSettingsData appIconSettingsData;
        long j;
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt("settings_version", 0);
        int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("app");
        String string = jSONObject3.getString("identifier");
        String string2 = jSONObject3.getString("status");
        String string3 = jSONObject3.getString(UpdateFragment.FRAGMENT_URL);
        String string4 = jSONObject3.getString("reports_url");
        String string5 = jSONObject3.getString("ndk_reports_url");
        boolean optBoolean = jSONObject3.optBoolean("update_required", false);
        if (jSONObject3.has("icon") && jSONObject3.getJSONObject("icon").has("hash")) {
            jSONObject3 = jSONObject3.getJSONObject("icon");
            appIconSettingsData = new AppIconSettingsData(jSONObject3.getString("hash"), jSONObject3.getInt("width"), jSONObject3.getInt("height"));
        } else {
            appIconSettingsData = null;
        }
        AppSettingsData appSettingsData = new AppSettingsData(string, string2, string3, string4, string5, optBoolean, appIconSettingsData);
        JSONObject jSONObject4 = jSONObject2.getJSONObject(Session.TYPE_SESSION);
        SessionSettingsData sessionSettingsData = new SessionSettingsData(jSONObject4.optInt("log_buffer_size", 64000), jSONObject4.optInt("max_chained_exception_depth", 8), jSONObject4.optInt("max_custom_exception_events", 64), jSONObject4.optInt("max_custom_key_value_pairs", 64), jSONObject4.optInt("identifier_mask", 255), jSONObject4.optBoolean("send_session_without_crash", false), jSONObject4.optInt("max_complete_sessions_count", 4));
        jSONObject4 = jSONObject2.getJSONObject("prompt");
        PromptSettingsData promptSettingsData = new PromptSettingsData(jSONObject4.optString("title", "Send Crash Report?"), jSONObject4.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject4.optString("send_button_title", "Send"), jSONObject4.optBoolean("show_cancel_button", true), jSONObject4.optString("cancel_button_title", "Don't Send"), jSONObject4.optBoolean("show_always_send_button", true), jSONObject4.optString("always_send_button_title", "Always Send"));
        jSONObject4 = jSONObject2.getJSONObject(Feature.TYPE_FEATURES);
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(jSONObject4.optBoolean("prompt_enabled", false), jSONObject4.optBoolean("collect_logged_exceptions", true), jSONObject4.optBoolean("collect_reports", true), jSONObject4.optBoolean("collect_analytics", false));
        jSONObject4 = jSONObject2.getJSONObject("analytics");
        AnalyticsSettingsData analyticsSettingsData = new AnalyticsSettingsData(jSONObject4.optString(UpdateFragment.FRAGMENT_URL, "https://e.crashlytics.com/spi/v2/events"), jSONObject4.optInt("flush_interval_secs", 600), jSONObject4.optInt("max_byte_size_per_file", EventsFilesManager.MAX_BYTE_SIZE_PER_FILE), jSONObject4.optInt("max_file_count_per_send", 1), jSONObject4.optInt("max_pending_send_file_count", 100), jSONObject4.optBoolean("forward_to_google_analytics", false), jSONObject4.optBoolean("include_purchase_events_in_forwarded_events", false), jSONObject4.optBoolean("track_custom_events", true), jSONObject4.optBoolean("track_predefined_events", true), jSONObject4.optInt("sampling_rate", 1), jSONObject4.optBoolean("flush_on_background", true));
        jSONObject4 = jSONObject2.getJSONObject(BuildConfig.ARTIFACT_ID);
        BetaSettingsData betaSettingsData = new BetaSettingsData(jSONObject4.optString("update_endpoint", SettingsJsonConstants.f24933a), jSONObject4.optInt("update_suspend_duration", 3600));
        long j2 = (long) optInt2;
        if (jSONObject2.has("expires_at")) {
            j = jSONObject2.getLong("expires_at");
        } else {
            j = currentTimeProvider.mo5580a() + (j2 * 1000);
        }
        return new SettingsData(j, appSettingsData, sessionSettingsData, promptSettingsData, featuresSettingsData, analyticsSettingsData, betaSettingsData, optInt, optInt2);
    }
}
