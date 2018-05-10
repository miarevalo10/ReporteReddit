package net.hockeyapp.android.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;

public class PermissionsUtil {
    public static int[] m28224a(Context context, String... strArr) {
        if (strArr == null) {
            return null;
        }
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = context.checkCallingOrSelfPermission(strArr[i]);
        }
        return iArr;
    }

    public static boolean m28223a(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return 1;
    }

    public static boolean m28222a(Context context) {
        if (VERSION.SDK_INT >= 26) {
            if (context.getApplicationInfo().targetSdkVersion >= 26) {
                if (context.getPackageManager().canRequestPackageInstalls() == null) {
                    return null;
                }
            }
            return true;
        } else if (VERSION.SDK_INT < 17 || VERSION.SDK_INT >= 21) {
            return "1".equals(Secure.getString(context.getContentResolver(), "install_non_market_apps"));
        } else {
            return "1".equals(Global.getString(context.getContentResolver(), "install_non_market_apps"));
        }
    }
}
