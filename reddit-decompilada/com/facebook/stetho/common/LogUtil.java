package com.facebook.stetho.common;

import java.util.Locale;

public class LogUtil {
    private static final String TAG = "stetho";

    public static void m3436e(String str, Object... objArr) {
        m3435e(format(str, objArr));
    }

    public static void m3438e(Throwable th, String str, Object... objArr) {
        m3437e(th, format(str, objArr));
    }

    public static void m3435e(String str) {
        if (isLoggable(6)) {
            LogRedirector.m3423e(TAG, str);
        }
    }

    public static void m3437e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.m3424e(TAG, str, th);
        }
    }

    public static void m3448w(String str, Object... objArr) {
        m3447w(format(str, objArr));
    }

    public static void m3450w(Throwable th, String str, Object... objArr) {
        m3449w(th, format(str, objArr));
    }

    public static void m3447w(String str) {
        if (isLoggable(5)) {
            LogRedirector.m3429w(TAG, str);
        }
    }

    public static void m3449w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.m3430w(TAG, str, th);
        }
    }

    public static void m3440i(String str, Object... objArr) {
        m3439i(format(str, objArr));
    }

    public static void m3442i(Throwable th, String str, Object... objArr) {
        m3441i(th, format(str, objArr));
    }

    public static void m3439i(String str) {
        if (isLoggable(4)) {
            LogRedirector.m3425i(TAG, str);
        }
    }

    public static void m3441i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.m3426i(TAG, str, th);
        }
    }

    public static void m3432d(String str, Object... objArr) {
        m3431d(format(str, objArr));
    }

    public static void m3434d(Throwable th, String str, Object... objArr) {
        m3433d(th, format(str, objArr));
    }

    public static void m3431d(String str) {
        if (isLoggable(3)) {
            LogRedirector.m3421d(TAG, str);
        }
    }

    public static void m3433d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.m3422d(TAG, str, th);
        }
    }

    public static void m3444v(String str, Object... objArr) {
        m3443v(format(str, objArr));
    }

    public static void m3446v(Throwable th, String str, Object... objArr) {
        m3445v(th, format(str, objArr));
    }

    public static void m3443v(String str) {
        if (isLoggable(2)) {
            LogRedirector.m3427v(TAG, str);
        }
    }

    public static void m3445v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.m3428v(TAG, str, th);
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean isLoggable(int i) {
        switch (i) {
            case 5:
            case 6:
                return true;
            default:
                return LogRedirector.isLoggable(TAG, i);
        }
    }
}
