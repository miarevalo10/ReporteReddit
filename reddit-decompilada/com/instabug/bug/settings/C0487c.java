package com.instabug.bug.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: PersistableSettings */
public class C0487c {
    private static C0487c f9149c;
    SharedPreferences f9150a;
    Editor f9151b = this.f9150a.edit();

    private C0487c(Context context) {
        this.f9150a = context.getSharedPreferences("instabug_bug_reporting", 0);
    }

    public static void m7831a(Context context) {
        f9149c = new C0487c(context);
    }

    public static C0487c m7830a() {
        return f9149c;
    }
}
