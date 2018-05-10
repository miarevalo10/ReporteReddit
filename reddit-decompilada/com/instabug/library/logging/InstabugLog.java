package com.instabug.library.logging;

import android.content.Context;
import android.util.Log;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import org.json.JSONObject;

public class InstabugLog {
    private static final String INSTABUG_LOG_TAG = "INSTABUG_LOG_TAG";
    public static final String LOG_MESSAGE_DATE_FORMAT = "MM-dd HH:mm:ss.SSS";

    enum C0732a {
        V("v"),
        D("d"),
        I("i"),
        E("e"),
        W("w"),
        WTF("wtf");
        
        private final String f9793g;

        private C0732a(String str) {
            this.f9793g = str;
        }

        public final String toString() {
            return this.f9793g;
        }
    }

    static class C0733b {
        String f9794a;
        C0732a f9795b;
        long f9796c;

        C0733b() {
        }

        public final JSONObject m8287a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("log_message", this.f9794a);
                jSONObject.put("log_message_level", this.f9795b.toString());
                jSONObject.put("log_message_date", this.f9796c);
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(InstabugLog.class.getSimpleName(), e.getMessage(), e);
            }
            return jSONObject;
        }
    }

    public static void m8291v(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(2, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.V;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void m8288d(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(3, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.D;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void m8290i(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(4, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.I;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void m8289e(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(6, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.E;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void m8292w(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(5, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.W;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void wtf(String str) {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("logMessage").setType(String.class));
        if (!isInstabugLogsDisabled()) {
            str = StringUtility.trimString(str);
            printInstabugLogs(5, str);
            C0733b c0733b = new C0733b();
            c0733b.f9794a = str;
            c0733b.f9795b = C0732a.WTF;
            c0733b.f9796c = getDate();
            addLog(c0733b);
        }
    }

    public static void clearLogs() {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter[0]);
        clearLogMessages();
    }

    public static void trimLogs() {
        C0735a.m8298c();
    }

    @Deprecated
    public static String getLogs(Context context) {
        AnalyticsObserver.getInstance().catchDeprecatedLoggingApiUsage(new Parameter[0]);
        return getLogs();
    }

    public static String getLogs() {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter[0]);
        return getLogMessages();
    }

    private static synchronized void addLog(C0733b c0733b) {
        synchronized (InstabugLog.class) {
            C0735a.m8294a(c0733b);
        }
    }

    private static void clearLogMessages() {
        C0735a.m8296b();
    }

    private static String getLogMessages() {
        return C0735a.m8293a().toString();
    }

    private static long getDate() {
        return InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
    }

    private static void printInstabugLogs(int i, String str) {
        if (SettingsManager.getInstance().isDebugEnabled()) {
            Log.println(i, INSTABUG_LOG_TAG, str);
        }
    }

    private static boolean isInstabugLogsDisabled() {
        return C0645b.m8104a().m8113b(Feature.INSTABUG_LOGS) == State.DISABLED;
    }
}
