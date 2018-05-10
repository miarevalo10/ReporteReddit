package com.instabug.library.util;

import android.util.Log;
import com.instabug.library.settings.SettingsManager;

public final class InstabugSDKLogger {
    private static final String LOG_TAG = "INSTABUG - ";

    private InstabugSDKLogger() {
    }

    public static String logTag(Object obj) {
        if (obj instanceof Class) {
            obj = ((Class) obj).getSimpleName();
        } else {
            obj = obj.getClass().getSimpleName();
        }
        StringBuilder stringBuilder = new StringBuilder(LOG_TAG);
        stringBuilder.append(obj);
        return stringBuilder.toString();
    }

    public static void m8360v(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            obj = logTag(obj);
            if (str.length() > 4000) {
                int length = str.length() / 4000;
                StringBuilder stringBuilder = new StringBuilder("logMessage length = ");
                stringBuilder.append(str.length());
                stringBuilder.append(" divided to ");
                int i = length + 1;
                stringBuilder.append(i);
                stringBuilder.append(" chunks");
                Log.v(obj, stringBuilder.toString());
                int i2 = 0;
                while (i2 <= length) {
                    String substring;
                    int i3 = i2 + 1;
                    int i4 = 4000 * i3;
                    if (i4 >= str.length()) {
                        substring = str.substring(i2 * 4000);
                    } else {
                        substring = str.substring(i2 * 4000, i4);
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("chunk ");
                    stringBuilder2.append(i3);
                    stringBuilder2.append(" of ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(":\n");
                    stringBuilder2.append(substring);
                    Log.v(obj, stringBuilder2.toString());
                    i2 = i3;
                }
                return;
            }
            Log.v(obj, str);
        }
    }

    public static void m8356d(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            obj = logTag(obj);
            if (str.length() > 4000) {
                int length = str.length() / 4000;
                StringBuilder stringBuilder = new StringBuilder("logMessage length = ");
                stringBuilder.append(str.length());
                stringBuilder.append(" divided to ");
                int i = length + 1;
                stringBuilder.append(i);
                stringBuilder.append(" chunks");
                Log.d(obj, stringBuilder.toString());
                int i2 = 0;
                while (i2 <= length) {
                    String substring;
                    int i3 = i2 + 1;
                    int i4 = 4000 * i3;
                    if (i4 >= str.length()) {
                        substring = str.substring(i2 * 4000);
                    } else {
                        substring = str.substring(i2 * 4000, i4);
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("chunk ");
                    stringBuilder2.append(i3);
                    stringBuilder2.append(" of ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(":\n");
                    stringBuilder2.append(substring);
                    Log.d(obj, stringBuilder2.toString());
                    i2 = i3;
                }
                return;
            }
            Log.d(obj, str);
        }
    }

    public static void m8359i(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.i(logTag(obj), str);
        }
    }

    public static void m8361w(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.w(logTag(obj), str);
        }
    }

    public static void m8357e(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.e(logTag(obj), str);
        }
    }

    public static void m8358e(Object obj, String str, Throwable th) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.e(logTag(obj), str, th);
        }
    }

    public static void wtf(Object obj, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.wtf(logTag(obj), str);
        }
    }

    public static void wtf(Object obj, String str, Throwable th) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.wtf(logTag(obj), str, th);
        }
    }
}
