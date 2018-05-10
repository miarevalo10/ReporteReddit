package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

public class ApiKey {
    public static String m26273a(Context context) {
        Object b = m26274b(context);
        if (TextUtils.isEmpty(b)) {
            b = m26275c(context);
        }
        if (TextUtils.isEmpty(b)) {
            FirebaseInfo firebaseInfo = new FirebaseInfo();
            b = FirebaseInfo.m26324a(context);
        }
        if (TextUtils.isEmpty(b)) {
            if (!Fabric.m26246c()) {
                if (CommonUtils.m26312h(context) == null) {
                    Fabric.m26243b().mo5570e("Fabric", "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
                }
            }
            throw new IllegalArgumentException("Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
        }
        return b;
    }

    protected static String m26274b(Context context) {
        StringBuilder stringBuilder;
        String str = null;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context == null) {
                return null;
            }
            String string = context.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    Fabric.m26243b().mo5562a("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                Fabric.m26243b().mo5562a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return context.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                context = e;
                str = string;
                stringBuilder = new StringBuilder("Caught non-fatal exception while retrieving apiKey: ");
                stringBuilder.append(context);
                Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
                return str;
            }
        } catch (Exception e2) {
            context = e2;
            stringBuilder = new StringBuilder("Caught non-fatal exception while retrieving apiKey: ");
            stringBuilder.append(context);
            Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
            return str;
        }
    }

    protected static String m26275c(Context context) {
        int a = CommonUtils.m26278a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            Fabric.m26243b().mo5562a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = CommonUtils.m26278a(context, "com.crashlytics.ApiKey", "string");
        }
        return a != 0 ? context.getResources().getString(a) : null;
    }
}
