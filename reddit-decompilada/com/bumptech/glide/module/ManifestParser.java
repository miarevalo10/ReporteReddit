package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {
    private final Context f3598a;

    public ManifestParser(Context context) {
        this.f3598a = context;
    }

    public final List<GlideModule> m3106a() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        List<GlideModule> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f3598a.getPackageManager().getApplicationInfo(this.f3598a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                StringBuilder stringBuilder = new StringBuilder("Got app info metadata: ");
                stringBuilder.append(applicationInfo.metaData);
                Log.v("ManifestParser", stringBuilder.toString());
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(m3104a(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        StringBuilder stringBuilder2 = new StringBuilder("Loaded Glide module: ");
                        stringBuilder2.append(str);
                        Log.d("ManifestParser", stringBuilder2.toString());
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static GlideModule m3104a(String str) {
        try {
            str = Class.forName(str);
            Object obj = null;
            try {
                obj = str.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                m3105a(str, e);
            } catch (Exception e2) {
                m3105a(str, e2);
            } catch (Exception e22) {
                m3105a(str, e22);
            } catch (Exception e222) {
                m3105a(str, e222);
            }
            if ((obj instanceof GlideModule) != null) {
                return (GlideModule) obj;
            }
            StringBuilder stringBuilder = new StringBuilder("Expected instanceof GlideModule, but found: ");
            stringBuilder.append(obj);
            throw new RuntimeException(stringBuilder.toString());
        } catch (String str2) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", str2);
        }
    }

    private static void m3105a(Class<?> cls, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Unable to instantiate GlideModule implementation for ");
        stringBuilder.append(cls);
        throw new RuntimeException(stringBuilder.toString(), exception);
    }
}
