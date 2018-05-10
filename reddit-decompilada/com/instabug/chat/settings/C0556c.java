package com.instabug.chat.settings;

import android.content.SharedPreferences;

/* compiled from: PersistableSettings */
public class C0556c {
    private static C0556c f9299b;
    SharedPreferences f9300a;

    private C0556c(SharedPreferences sharedPreferences) {
        this.f9300a = sharedPreferences;
    }

    static void m7962a(SharedPreferences sharedPreferences) {
        f9299b = new C0556c(sharedPreferences);
    }

    static C0556c m7961a() {
        return f9299b;
    }
}
