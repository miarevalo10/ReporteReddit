package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

public interface SettingsJsonTransform {
    SettingsData mo5613a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}