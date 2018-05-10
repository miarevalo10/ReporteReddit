package com.google.android.gms.common.util;

import android.os.Build.VERSION;

public final class zzq {
    public static boolean m4909a() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean m4910b() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean m4911c() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m4912d() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean m4913e() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean m4914f() {
        return VERSION.SDK_INT >= 20;
    }

    public static boolean m4915g() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m4916h() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean m4917i() {
        if (!(VERSION.SDK_INT >= 26 || "O".equals(VERSION.CODENAME) || VERSION.CODENAME.startsWith("OMR"))) {
            if (!VERSION.CODENAME.startsWith("ODR")) {
                return false;
            }
        }
        return true;
    }
}
