package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AdvertisingInfoProvider {
    final PreferenceStore f24716a;
    private final Context f24717b;

    class C25391 extends BackgroundPriorityRunnable {
        final /* synthetic */ AdvertisingInfo f30990a;
        final /* synthetic */ AdvertisingInfoProvider f30991b;

        C25391(AdvertisingInfoProvider advertisingInfoProvider, AdvertisingInfo advertisingInfo) {
            this.f30991b = advertisingInfoProvider;
            this.f30990a = advertisingInfo;
        }

        public void onRun() {
            AdvertisingInfo a = this.f30991b.m26267a();
            if (!this.f30990a.equals(a)) {
                Fabric.m26243b().mo5562a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                this.f30991b.m26268a(a);
            }
        }
    }

    public AdvertisingInfoProvider(Context context) {
        this.f24717b = context.getApplicationContext();
        this.f24716a = new PreferenceStoreImpl(context, "TwitterAdvertisingInfoPreferences");
    }

    @SuppressLint({"CommitPrefEdits"})
    final void m26268a(AdvertisingInfo advertisingInfo) {
        if (m26266b(advertisingInfo)) {
            this.f24716a.mo5607a(this.f24716a.mo5608b().putString("advertising_id", advertisingInfo.f24714a).putBoolean("limit_ad_tracking_enabled", advertisingInfo.f24715b));
        } else {
            this.f24716a.mo5607a(this.f24716a.mo5608b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    static boolean m26266b(AdvertisingInfo advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.f24714a) != null) ? null : true;
    }

    final AdvertisingInfo m26267a() {
        AdvertisingInfo a = new AdvertisingInfoReflectionStrategy(this.f24717b).mo5578a();
        if (m26266b(a)) {
            Fabric.m26243b().mo5562a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = new AdvertisingInfoServiceStrategy(this.f24717b).mo5578a();
            if (m26266b(a)) {
                Fabric.m26243b().mo5562a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                Fabric.m26243b().mo5562a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
