package io.fabric.sdk.android.services.settings;

import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsController implements SettingsController {
    private final SettingsRequest f31033a;
    private final SettingsJsonTransform f31034b;
    private final CurrentTimeProvider f31035c;
    private final CachedSettingsIo f31036d;
    private final SettingsSpiCall f31037e;
    private final Kit f31038f;
    private final PreferenceStore f31039g = new PreferenceStoreImpl(this.f31038f);

    public DefaultSettingsController(Kit kit, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonTransform settingsJsonTransform, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall) {
        this.f31038f = kit;
        this.f31033a = settingsRequest;
        this.f31035c = currentTimeProvider;
        this.f31034b = settingsJsonTransform;
        this.f31036d = cachedSettingsIo;
        this.f31037e = settingsSpiCall;
    }

    public final SettingsData mo5611a() {
        return mo5612a(SettingsCacheBehavior.USE_CACHE);
    }

    public final SettingsData mo5612a(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsCacheBehavior settingsCacheBehavior2 = null;
        try {
            if (!Fabric.m26246c() && (this.f31039g.mo5606a().getString("existing_instance_identifier", "").equals(m31998b()) ^ 1) == 0) {
                settingsCacheBehavior2 = m31997b(settingsCacheBehavior);
            }
            if (settingsCacheBehavior2 == null) {
                settingsCacheBehavior = this.f31037e.mo5614a(this.f31033a);
                if (settingsCacheBehavior != null) {
                    SettingsData a = this.f31034b.mo5613a(this.f31035c, settingsCacheBehavior);
                    try {
                        this.f31036d.mo5610a(a.f24930g, settingsCacheBehavior);
                        m31996a(settingsCacheBehavior, "Loaded settings: ");
                        settingsCacheBehavior = m31998b();
                        Editor b = this.f31039g.mo5608b();
                        b.putString("existing_instance_identifier", settingsCacheBehavior);
                        this.f31039g.mo5607a(b);
                        settingsCacheBehavior2 = a;
                    } catch (Exception e) {
                        settingsCacheBehavior = e;
                        settingsCacheBehavior2 = a;
                        Fabric.m26243b().mo5568c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", settingsCacheBehavior);
                        return settingsCacheBehavior2;
                    }
                }
            }
            if (settingsCacheBehavior2 == null) {
                return m31997b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e2) {
            settingsCacheBehavior = e2;
            Fabric.m26243b().mo5568c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", settingsCacheBehavior);
            return settingsCacheBehavior2;
        }
        return settingsCacheBehavior2;
    }

    private SettingsData m31997b(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject a = this.f31036d.mo5609a();
            if (a != null) {
                SettingsData a2 = this.f31034b.mo5613a(this.f31035c, a);
                m31996a(a, "Loaded cached settings: ");
                long a3 = this.f31035c.mo5580a();
                if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) == null) {
                    if ((a2.f24930g < a3 ? true : null) != null) {
                        Fabric.m26243b().mo5562a("Fabric", "Cached settings have expired.");
                        return null;
                    }
                }
                try {
                    Fabric.m26243b().mo5562a("Fabric", "Returning cached settings.");
                    return a2;
                } catch (Exception e) {
                    settingsCacheBehavior = e;
                    settingsData = a2;
                    Fabric.m26243b().mo5568c("Fabric", "Failed to get cached settings", settingsCacheBehavior);
                    return settingsData;
                }
            }
            Fabric.m26243b().mo5562a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            settingsCacheBehavior = e2;
            Fabric.m26243b().mo5568c("Fabric", "Failed to get cached settings", settingsCacheBehavior);
            return settingsData;
        }
    }

    private static void m31996a(JSONObject jSONObject, String str) throws JSONException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(jSONObject.toString());
        Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
    }

    private String m31998b() {
        return CommonUtils.m26291a(CommonUtils.m26315k(this.f31038f.getContext()));
    }
}
