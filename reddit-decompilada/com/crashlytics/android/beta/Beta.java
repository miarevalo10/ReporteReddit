package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.HashMap;
import java.util.Map;

public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final MemoryValueCache<String> deviceTokenCache = new MemoryValueCache();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.7.19";
    }

    public static Beta getInstance() {
        return (Beta) Fabric.a(Beta.class);
    }

    @TargetApi(14)
    protected boolean onPreExecute() {
        this.updatesController = createUpdatesController(VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    protected Boolean doInBackground() {
        Fabric.b().a(TAG, "Beta kit initializing...");
        Context context = getContext();
        IdManager idManager = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, idManager.d()))) {
            Fabric.b().a(TAG, "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        Fabric.b().a(TAG, "Beta device token is present, checking for app updates.");
        BetaSettingsData betaSettingsData = getBetaSettingsData();
        BuildProperties loadBuildProperties = loadBuildProperties(context);
        if (canCheckForUpdates(betaSettingsData, loadBuildProperties)) {
            this.updatesController.initialize(context, this, idManager, betaSettingsData, loadBuildProperties, new PreferenceStoreImpl(this), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.b()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    UpdatesController createUpdatesController(int i, Application application) {
        if (i >= 14) {
            return new ActivityLifecycleCheckForUpdatesController(getFabric().e, getFabric().c);
        }
        return new ImmediateCheckForUpdatesController();
    }

    public Map<DeviceIdentifierType, String> getDeviceIdentifiers() {
        CharSequence betaDeviceToken = getBetaDeviceToken(getContext(), getIdManager().d());
        Map<DeviceIdentifierType, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            hashMap.put(DeviceIdentifierType.c, betaDeviceToken);
        }
        return hashMap;
    }

    boolean canCheckForUpdates(BetaSettingsData betaSettingsData, BuildProperties buildProperties) {
        return (betaSettingsData == null || TextUtils.isEmpty(betaSettingsData.a) != null || buildProperties == null) ? null : true;
    }

    private String getBetaDeviceToken(Context context, String str) {
        str = null;
        try {
            String str2 = (String) this.deviceTokenCache.get(context, this.deviceTokenLoader);
            if (!"".equals(str2)) {
                str = str2;
            }
        } catch (Context context2) {
            Fabric.b().c(TAG, "Failed to load the Beta device token", context2);
        }
        context2 = Fabric.b();
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder("Beta device token present: ");
        stringBuilder.append(TextUtils.isEmpty(str) ^ 1);
        context2.a(str3, stringBuilder.toString());
        return str;
    }

    private BetaSettingsData getBetaSettingsData() {
        SettingsData b = Settings.a().b();
        return b != null ? b.f : null;
    }

    private BuildProperties loadBuildProperties(Context context) {
        BuildProperties fromPropertiesStream;
        Throwable th;
        BuildProperties buildProperties = null;
        try {
            context = context.getAssets().open(CRASHLYTICS_BUILD_PROPERTIES);
            if (context != null) {
                try {
                    fromPropertiesStream = BuildProperties.fromPropertiesStream(context);
                } catch (Throwable e) {
                    Throwable th2 = e;
                    fromPropertiesStream = null;
                    th = th2;
                    try {
                        Fabric.b().c(TAG, "Error reading Beta build properties", th);
                        if (context != null) {
                            try {
                                context.close();
                            } catch (Context context2) {
                                Fabric.b().c(TAG, "Error closing Beta build properties asset", context2);
                            }
                        }
                        return fromPropertiesStream;
                    } catch (Throwable th3) {
                        th = th3;
                        if (context2 != null) {
                            try {
                                context2.close();
                            } catch (Context context22) {
                                Fabric.b().c(TAG, "Error closing Beta build properties asset", context22);
                            }
                        }
                        throw th;
                    }
                }
                try {
                    Logger b = Fabric.b();
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(fromPropertiesStream.packageName);
                    stringBuilder.append(" build properties: ");
                    stringBuilder.append(fromPropertiesStream.versionName);
                    stringBuilder.append(" (");
                    stringBuilder.append(fromPropertiesStream.versionCode);
                    stringBuilder.append(") - ");
                    stringBuilder.append(fromPropertiesStream.buildId);
                    b.a(str, stringBuilder.toString());
                    buildProperties = fromPropertiesStream;
                } catch (Exception e2) {
                    th = e2;
                    Fabric.b().c(TAG, "Error reading Beta build properties", th);
                    if (context22 != null) {
                        context22.close();
                    }
                    return fromPropertiesStream;
                }
            }
            if (context22 == null) {
                return buildProperties;
            }
            try {
                context22.close();
                return buildProperties;
            } catch (Context context222) {
                Fabric.b().c(TAG, "Error closing Beta build properties asset", context222);
                return buildProperties;
            }
        } catch (Context context2222) {
            fromPropertiesStream = null;
            th = context2222;
            context2222 = fromPropertiesStream;
            Fabric.b().c(TAG, "Error reading Beta build properties", th);
            if (context2222 != null) {
                context2222.close();
            }
            return fromPropertiesStream;
        } catch (Context context22222) {
            th = context22222;
            context22222 = null;
            if (context22222 != null) {
                context22222.close();
            }
            throw th;
        }
    }

    String getOverridenSpiEndpoint() {
        return CommonUtils.d(getContext(), CRASHLYTICS_API_ENDPOINT);
    }
}
