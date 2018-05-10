package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import io.fabric.sdk.android.services.settings.IconRequest;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.UpdateAppSpiCall;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class Onboarding extends Kit<Boolean> {
    private final HttpRequestFactory f30979a = new DefaultHttpRequestFactory();
    private PackageManager f30980b;
    private String f30981c;
    private PackageInfo f30982d;
    private String f30983e;
    private String f30984f;
    private String f30985g;
    private String f30986h;
    private String f30987i;
    private final Future<Map<String, KitInfo>> f30988j;
    private final Collection<Kit> f30989k;

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    public String getVersion() {
        return "1.4.1.19";
    }

    protected /* synthetic */ Object doInBackground() {
        return m31952a();
    }

    public Onboarding(Future<Map<String, KitInfo>> future, Collection<Kit> collection) {
        this.f30988j = future;
        this.f30989k = collection;
    }

    protected boolean onPreExecute() {
        try {
            this.f30985g = getIdManager().m26334d();
            this.f30980b = getContext().getPackageManager();
            this.f30981c = getContext().getPackageName();
            this.f30982d = this.f30980b.getPackageInfo(this.f30981c, 0);
            this.f30983e = Integer.toString(this.f30982d.versionCode);
            this.f30984f = this.f30982d.versionName == null ? "0.0" : this.f30982d.versionName;
            this.f30986h = this.f30980b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.f30987i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            Fabric.m26243b().mo5568c("Fabric", "Failed init", e);
            return false;
        }
    }

    private Boolean m31952a() {
        String i = CommonUtils.m26313i(getContext());
        SettingsData b = m31954b();
        boolean z = false;
        if (b != null) {
            try {
                Map map;
                boolean d;
                if (this.f30988j != null) {
                    map = (Map) this.f30988j.get();
                } else {
                    map = new HashMap();
                }
                map = m31953a(map, this.f30989k);
                AppSettingsData appSettingsData = b.f24924a;
                Collection values = map.values();
                if ("new".equals(appSettingsData.f24889b)) {
                    if (new CreateAppSpiCall(this, m31955c(), appSettingsData.f24890c, this.f30979a).mo6604a(m31951a(IconRequest.build(getContext(), i), values))) {
                        d = Settings.m26437a().m26442d();
                    } else {
                        Fabric.m26243b().mo5568c("Fabric", "Failed to create app with Crashlytics service.", null);
                    }
                } else if ("configured".equals(appSettingsData.f24889b)) {
                    d = Settings.m26437a().m26442d();
                } else {
                    if (appSettingsData.f24893f) {
                        Fabric.m26243b().mo5562a("Fabric", "Server says an update is required - forcing a full App update.");
                        new UpdateAppSpiCall(this, m31955c(), appSettingsData.f24890c, this.f30979a).mo6604a(m31951a(IconRequest.build(getContext(), i), values));
                    }
                    z = true;
                }
                z = d;
            } catch (Throwable e) {
                Fabric.m26243b().mo5568c("Fabric", "Error performing auto configuration.", e);
            }
        }
        return Boolean.valueOf(z);
    }

    private SettingsData m31954b() {
        try {
            Settings.m26437a().m26439a(this, this.idManager, this.f30979a, this.f30983e, this.f30984f, m31955c()).m26441c();
            return Settings.m26437a().m26440b();
        } catch (Throwable e) {
            Fabric.m26243b().mo5568c("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    private static Map<String, KitInfo> m31953a(Map<String, KitInfo> map, Collection<Kit> collection) {
        for (Kit kit : collection) {
            if (!map.containsKey(kit.getIdentifier())) {
                map.put(kit.getIdentifier(), new KitInfo(kit.getIdentifier(), kit.getVersion(), "binary"));
            }
        }
        return map;
    }

    private AppRequestData m31951a(IconRequest iconRequest, Collection<KitInfo> collection) {
        Context context = getContext();
        ApiKey apiKey = new ApiKey();
        return new AppRequestData(ApiKey.m26273a(context), getIdManager().f24759b, this.f30984f, this.f30983e, CommonUtils.m26291a(CommonUtils.m26315k(context)), this.f30986h, DeliveryMechanism.m26319a(this.f30985g).f24744e, this.f30987i, "0", iconRequest, collection);
    }

    private String m31955c() {
        return CommonUtils.m26306d(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
