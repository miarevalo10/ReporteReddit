package com.instabug.crash.p013b;

import android.content.Context;

/* compiled from: CrashSettings */
public class C0582a {
    private static C0582a f9371a;

    private C0582a() {
    }

    public static void m7997a(Context context) {
        f9371a = new C0582a();
        C0584c.m8004a(context);
        C0583b.m8001a();
    }

    public static C0582a m7995a() {
        if (f9371a == null) {
            f9371a = new C0582a();
        }
        return f9371a;
    }

    public static Runnable m7999b() {
        return C0583b.m8002b().f9373a;
    }

    public static void m7998a(Runnable runnable) {
        C0583b.m8002b().f9373a = runnable;
    }

    public static void m7996a(long j) {
        C0584c.m8003a().m8005a(j);
    }

    public static long m8000c() {
        return C0584c.m8003a().f9375a.getLong("last_crash_time", 0);
    }
}
