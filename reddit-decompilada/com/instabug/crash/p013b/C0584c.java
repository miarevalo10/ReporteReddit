package com.instabug.crash.p013b;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PersistableSettings */
public class C0584c {
    private static C0584c f9374b;
    SharedPreferences f9375a;

    private C0584c(Context context) {
        this.f9375a = context.getSharedPreferences("instabug_crash", 0);
    }

    public static void m8004a(Context context) {
        f9374b = new C0584c(context);
    }

    public static C0584c m8003a() {
        return f9374b;
    }

    public final void m8005a(long j) {
        this.f9375a.edit().putLong("last_crash_time", j).apply();
    }
}
