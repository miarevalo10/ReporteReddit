package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzae {
    public static boolean f6235a = Log.isLoggable("Volley", 2);
    private static String f6236b = "Volley";

    static class zza {
        public static final boolean f6232a = zzae.f6235a;
        private final List<zzaf> f6233b = new ArrayList();
        private boolean f6234c = false;

        zza() {
        }

        public final synchronized void m5039a(String str) {
            long j;
            this.f6234c = true;
            if (this.f6233b.size() == 0) {
                j = 0;
            } else {
                j = ((zzaf) this.f6233b.get(this.f6233b.size() - 1)).f6261c - ((zzaf) this.f6233b.get(0)).f6261c;
            }
            if (j > 0) {
                long j2 = ((zzaf) this.f6233b.get(0)).f6261c;
                zzae.m5043b("(%-4d ms) %s", Long.valueOf(j), str);
                for (zzaf com_google_android_gms_internal_zzaf : this.f6233b) {
                    zzae.m5043b("(+%-4d) [%2d] %s", Long.valueOf(com_google_android_gms_internal_zzaf.f6261c - j2), Long.valueOf(com_google_android_gms_internal_zzaf.f6260b), com_google_android_gms_internal_zzaf.f6259a);
                    j2 = com_google_android_gms_internal_zzaf.f6261c;
                }
            }
        }

        public final synchronized void m5040a(String str, long j) {
            if (this.f6234c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f6233b.add(new zzaf(str, j, SystemClock.elapsedRealtime()));
        }

        protected final void finalize() throws Throwable {
            if (!this.f6234c) {
                m5039a("Request on the loose");
                zzae.m5044c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void m5041a(String str, Object... objArr) {
        if (f6235a) {
            Log.v(f6236b, m5045d(str, objArr));
        }
    }

    public static void m5042a(Throwable th, String str, Object... objArr) {
        Log.e(f6236b, m5045d(str, objArr), th);
    }

    public static void m5043b(String str, Object... objArr) {
        Log.d(f6236b, m5045d(str, objArr));
    }

    public static void m5044c(String str, Object... objArr) {
        Log.e(f6236b, m5045d(str, objArr));
    }

    private static String m5045d(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(zzae.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(methodName).length());
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(methodName);
                str2 = stringBuilder.toString();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
