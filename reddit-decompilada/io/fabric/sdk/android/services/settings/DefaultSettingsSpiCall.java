package io.fabric.sdk.android.services.settings;

import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    private DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    private JSONObject m32002a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Failed to parse settings JSON from ");
            stringBuilder.append(getUrl());
            Fabric.m26243b().mo5563a("Fabric", stringBuilder.toString(), e);
            StringBuilder stringBuilder2 = new StringBuilder("Settings response ");
            stringBuilder2.append(str);
            Fabric.m26243b().mo5562a("Fabric", stringBuilder2.toString());
            return null;
        }
    }

    private static void m32003a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.header(str, str2);
        }
    }

    public final JSONObject mo5614a(SettingsRequest settingsRequest) {
        HttpRequest httpRequest;
        JSONObject jSONObject = null;
        StringBuilder stringBuilder;
        String str;
        try {
            Map hashMap = new HashMap();
            hashMap.put("build_version", settingsRequest.buildVersion);
            hashMap.put("display_version", settingsRequest.displayVersion);
            hashMap.put("source", Integer.toString(settingsRequest.source));
            if (settingsRequest.iconHash != null) {
                hashMap.put("icon_hash", settingsRequest.iconHash);
            }
            String str2 = settingsRequest.instanceId;
            if (!CommonUtils.m26308d(str2)) {
                hashMap.put("instance", str2);
            }
            httpRequest = getHttpRequest(hashMap);
            try {
                m32003a(httpRequest, AbstractSpiCall.HEADER_API_KEY, settingsRequest.apiKey);
                m32003a(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, "android");
                m32003a(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
                m32003a(httpRequest, "Accept", "application/json");
                m32003a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
                m32003a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
                m32003a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
                m32003a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.installationId);
                if (TextUtils.isEmpty(settingsRequest.advertisingId)) {
                    m32003a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", settingsRequest.androidId);
                } else {
                    m32003a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", settingsRequest.advertisingId);
                }
                StringBuilder stringBuilder2 = new StringBuilder("Requesting settings from ");
                stringBuilder2.append(getUrl());
                Fabric.m26243b().mo5562a("Fabric", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("Settings query params were: ");
                stringBuilder2.append(hashMap);
                Fabric.m26243b().mo5562a("Fabric", stringBuilder2.toString());
                settingsRequest = httpRequest.code();
                stringBuilder2 = new StringBuilder("Settings result was: ");
                stringBuilder2.append(settingsRequest);
                Fabric.m26243b().mo5562a("Fabric", stringBuilder2.toString());
                if (!(settingsRequest == 200 || settingsRequest == 201 || settingsRequest == 202)) {
                    if (settingsRequest != 203) {
                        settingsRequest = null;
                        if (settingsRequest == null) {
                            jSONObject = m32002a(httpRequest.body());
                        } else {
                            stringBuilder = new StringBuilder("Failed to retrieve settings from ");
                            stringBuilder.append(getUrl());
                            Fabric.m26243b().mo5570e("Fabric", stringBuilder.toString());
                        }
                        if (httpRequest != null) {
                            settingsRequest = Fabric.m26243b();
                            str = "Fabric";
                            stringBuilder = new StringBuilder("Settings request ID: ");
                            stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                            settingsRequest.mo5562a(str, stringBuilder.toString());
                        }
                        return jSONObject;
                    }
                }
                settingsRequest = true;
                if (settingsRequest == null) {
                    stringBuilder = new StringBuilder("Failed to retrieve settings from ");
                    stringBuilder.append(getUrl());
                    Fabric.m26243b().mo5570e("Fabric", stringBuilder.toString());
                } else {
                    jSONObject = m32002a(httpRequest.body());
                }
                if (httpRequest != null) {
                    settingsRequest = Fabric.m26243b();
                    str = "Fabric";
                    stringBuilder = new StringBuilder("Settings request ID: ");
                    stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                    settingsRequest.mo5562a(str, stringBuilder.toString());
                }
            } catch (HttpRequestException e) {
                settingsRequest = e;
                try {
                    Fabric.m26243b().mo5568c("Fabric", "Settings request failed.", settingsRequest);
                    if (httpRequest != null) {
                        settingsRequest = Fabric.m26243b();
                        str = "Fabric";
                        stringBuilder = new StringBuilder("Settings request ID: ");
                        stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                        settingsRequest.mo5562a(str, stringBuilder.toString());
                    }
                    return jSONObject;
                } catch (Throwable th) {
                    settingsRequest = th;
                    if (httpRequest != null) {
                        stringBuilder = new StringBuilder("Settings request ID: ");
                        stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                        Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
                    }
                    throw settingsRequest;
                }
            }
        } catch (HttpRequestException e2) {
            settingsRequest = e2;
            httpRequest = null;
            Fabric.m26243b().mo5568c("Fabric", "Settings request failed.", settingsRequest);
            if (httpRequest != null) {
                settingsRequest = Fabric.m26243b();
                str = "Fabric";
                stringBuilder = new StringBuilder("Settings request ID: ");
                stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                settingsRequest.mo5562a(str, stringBuilder.toString());
            }
            return jSONObject;
        } catch (Throwable th2) {
            settingsRequest = th2;
            httpRequest = null;
            if (httpRequest != null) {
                stringBuilder = new StringBuilder("Settings request ID: ");
                stringBuilder.append(httpRequest.header(AbstractSpiCall.HEADER_REQUEST_ID));
                Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
            }
            throw settingsRequest;
        }
        return jSONObject;
    }
}
