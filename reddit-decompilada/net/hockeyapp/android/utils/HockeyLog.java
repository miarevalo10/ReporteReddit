package net.hockeyapp.android.utils;

import android.util.Log;

public class HockeyLog {
    private static int f26603a = 6;

    public static void m28204a(String str) {
        m28205a(null, str);
    }

    public static void m28205a(String str, String str2) {
        str = m28210d(str);
        if (f26603a <= 3) {
            Log.d(str, str2);
        }
    }

    public static void m28209c(String str) {
        m28208b(null, str);
    }

    public static void m28208b(String str, String str2) {
        str = m28210d(str);
        if (f26603a <= 6) {
            Log.e(str, str2);
        }
    }

    private static String m28210d(String str) {
        return (str == null || str.length() == 0 || str.length() > 23) ? "HockeyApp" : str;
    }

    public static void m28207b(String str) {
        String d = m28210d(null);
        if (f26603a <= 5) {
            Log.w(d, str);
        }
    }

    public static void m28206a(String str, Throwable th) {
        String d = m28210d(null);
        if (f26603a <= 6) {
            Log.e(d, str, th);
        }
    }
}
