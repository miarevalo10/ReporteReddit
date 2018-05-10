package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;

public class FirebaseInfo {
    protected static String m26324a(Context context) {
        int a = CommonUtils.m26278a(context, "google_app_id", "string");
        if (a == 0) {
            return null;
        }
        Fabric.m26243b().mo5562a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return CommonUtils.m26301b(context.getResources().getString(a)).substring(0, 40);
    }

    public static boolean m26325b(Context context) {
        if (CommonUtils.m26297a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        boolean z = CommonUtils.m26278a(context, "google_app_id", "string") != 0;
        ApiKey apiKey = new ApiKey();
        if (TextUtils.isEmpty(ApiKey.m26274b(context))) {
            apiKey = new ApiKey();
            if (TextUtils.isEmpty(ApiKey.m26275c(context)) != null) {
                context = null;
                return z && context == null;
            }
        }
        context = 1;
        if (!z) {
        }
    }
}
