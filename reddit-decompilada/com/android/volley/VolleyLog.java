package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VolleyLog {
    public static String f2813a = "Volley";
    public static boolean f2814b = Log.isLoggable("Volley", 2);

    static class MarkerLog {
        public static final boolean f2810a = VolleyLog.f2814b;
        private final List<Marker> f2811b = new ArrayList();
        private boolean f2812c = false;

        private static class Marker {
            public final String f2807a;
            public final long f2808b;
            public final long f2809c;

            public Marker(String str, long j, long j2) {
                this.f2807a = str;
                this.f2808b = j;
                this.f2809c = j2;
            }
        }

        MarkerLog() {
        }

        public final synchronized void m2453a(String str, long j) {
            if (this.f2812c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f2811b.add(new Marker(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void m2452a(String str) {
            long j;
            this.f2812c = true;
            if (this.f2811b.size() == 0) {
                j = 0;
            } else {
                j = ((Marker) this.f2811b.get(this.f2811b.size() - 1)).f2809c - ((Marker) this.f2811b.get(0)).f2809c;
            }
            if (j > 0) {
                long j2 = ((Marker) this.f2811b.get(0)).f2809c;
                VolleyLog.m2456b("(%-4d ms) %s", Long.valueOf(j), str);
                for (Marker marker : this.f2811b) {
                    VolleyLog.m2456b("(+%-4d) [%2d] %s", Long.valueOf(marker.f2809c - j2), Long.valueOf(marker.f2808b), marker.f2807a);
                    j2 = marker.f2809c;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.f2812c) {
                m2452a("Request on the loose");
                VolleyLog.m2457c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void m2454a(String str, Object... objArr) {
        if (f2814b) {
            Log.v(f2813a, m2459e(str, objArr));
        }
    }

    public static void m2456b(String str, Object... objArr) {
        Log.d(f2813a, m2459e(str, objArr));
    }

    public static void m2457c(String str, Object... objArr) {
        Log.e(f2813a, m2459e(str, objArr));
    }

    public static void m2455a(Throwable th, String str, Object... objArr) {
        Log.e(f2813a, m2459e(str, objArr), th);
    }

    public static void m2458d(String str, Object... objArr) {
        Log.wtf(f2813a, m2459e(str, objArr));
    }

    private static String m2459e(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        objArr = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < objArr.length; i++) {
            if (!objArr[i].getClass().equals(VolleyLog.class)) {
                str2 = objArr[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(objArr[i].getMethodName());
                str2 = stringBuilder.toString();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
