package com.birbit.android.jobqueue.log;

import android.util.Log;

public class JqLog {
    private static CustomLogger f2982a = new C10461();

    static class C10461 implements CustomLogger {
        public final void mo817a(String str, Object... objArr) {
        }

        public final void mo818a(Throwable th, String str, Object... objArr) {
        }

        public final void mo819b(String str, Object... objArr) {
        }

        public final void mo820c(String str, Object... objArr) {
        }

        C10461() {
        }
    }

    public static class ErrorLogger implements CustomLogger {
        public final void mo817a(String str, Object... objArr) {
        }

        public final void mo820c(String str, Object... objArr) {
        }

        public final void mo818a(Throwable th, String str, Object... objArr) {
            Log.e("JobManager", String.format(str, objArr), th);
        }

        public final void mo819b(String str, Object... objArr) {
            Log.e("JobManager", String.format(str, objArr));
        }
    }

    public static boolean m2560a() {
        return false;
    }

    public static void m2557a(CustomLogger customLogger) {
        f2982a = customLogger;
    }

    public static void m2558a(String str, Object... objArr) {
        f2982a.mo817a(str, objArr);
    }

    public static void m2559a(Throwable th, String str, Object... objArr) {
        f2982a.mo818a(th, str, objArr);
    }

    public static void m2561b(String str, Object... objArr) {
        f2982a.mo819b(str, objArr);
    }

    public static void m2562c(String str, Object... objArr) {
        f2982a.mo820c(str, objArr);
    }
}
