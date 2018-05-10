package com.instabug.survey.p028b;

/* compiled from: SurveysSettings */
public class C0791c {
    public static void m8401a(boolean z) {
        C0789a.m8395b().f9956a = z;
    }

    public static boolean m8402a() {
        return C0789a.m8395b().f9956a;
    }

    public static void m8400a(Runnable runnable) {
        C0789a.m8395b().f9957b = runnable;
    }

    public static Runnable m8403b() {
        return C0789a.m8395b().f9957b;
    }

    public static void m8404b(Runnable runnable) {
        C0789a.m8395b().f9958c = runnable;
    }

    public static Runnable m8405c() {
        return C0789a.m8395b().f9958c;
    }

    public static void m8399a(long j) {
        C0790b a = C0790b.m8396a();
        a.f9962b.putLong("survey_last_fetch_time", j);
        a.f9962b.apply();
    }

    public static long m8406d() {
        return C0790b.m8396a().f9961a.getLong("survey_last_fetch_time", 0);
    }
}
