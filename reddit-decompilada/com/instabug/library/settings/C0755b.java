package com.instabug.library.settings;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PersistableSettings */
public class C0755b {
    private static C0755b f9876b;
    SharedPreferences f9877a;

    private C0755b(Context context) {
        this.f9877a = context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0);
    }

    public static void m8319a(Context context) {
        f9876b = new C0755b(context);
    }

    public static C0755b m8318a() {
        return f9876b;
    }

    public final int m8320b() {
        return this.f9877a.getInt("ib_sessions_count", 0);
    }
}
