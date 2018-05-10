package com.instabug.library.internal.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.instabug.library.util.InstabugSDKLogger;

public class InstabugDeviceProperties {
    public static String getAppVersion(Context context) {
        PackageInfo packageInfo = new PackageInfo();
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(InstabugDeviceProperties.class, "failed to get app version", context2);
            context2 = packageInfo;
        }
        return String.format("%s (%s)", new Object[]{context2.versionName, Integer.valueOf(context2.versionCode)});
    }

    public static String getAppVersionName(Context context) {
        PackageInfo packageInfo = new PackageInfo();
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(InstabugDeviceProperties.class, "failed to get app version", context2);
            context2 = packageInfo;
        }
        return context2.versionName;
    }

    public static String getPackageName(Context context) {
        try {
            return context.getApplicationInfo().packageName;
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(InstabugDeviceProperties.class, "failed to get package name", context2);
            return "Could not get information";
        }
    }

    public static String getDeviceType() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append(" ");
        stringBuilder.append(Build.MODEL);
        return stringBuilder.toString();
    }

    public static int getCurrentOSLevel() {
        return VERSION.SDK_INT;
    }
}
