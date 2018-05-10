package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

class DefaultCachedSettingsIo implements CachedSettingsIo {
    private final Kit f31032a;

    public DefaultCachedSettingsIo(Kit kit) {
        this.f31032a = kit;
    }

    public final JSONObject mo5609a() {
        Closeable fileInputStream;
        Throwable e;
        Fabric.m26243b().mo5562a("Fabric", "Reading cached settings...");
        Closeable closeable = null;
        try {
            JSONObject jSONObject;
            File file = new File(new FileStoreImpl(this.f31032a).mo5605a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.m26285a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Fabric.m26243b().mo5568c("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m26294a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.m26294a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            Fabric.m26243b().mo5562a("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.m26294a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            Fabric.m26243b().mo5568c("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.m26294a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m26294a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public final void mo5610a(long j, JSONObject jSONObject) {
        Throwable e;
        Fabric.m26243b().mo5562a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                Closeable fileWriter = new FileWriter(new File(new FileStoreImpl(this.f31032a).mo5605a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.m26294a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = fileWriter;
                    try {
                        Fabric.m26243b().mo5568c("Fabric", "Failed to cache settings", e);
                        CommonUtils.m26294a(closeable, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        CommonUtils.m26294a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    closeable = fileWriter;
                    CommonUtils.m26294a(closeable, "Failed to close settings writer.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                Fabric.m26243b().mo5568c("Fabric", "Failed to cache settings", e);
                CommonUtils.m26294a(closeable, "Failed to close settings writer.");
            }
        }
    }
}
