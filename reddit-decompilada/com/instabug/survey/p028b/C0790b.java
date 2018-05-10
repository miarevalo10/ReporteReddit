package com.instabug.survey.p028b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: PersistableSettings */
public class C0790b {
    private static C0790b f9960c;
    public SharedPreferences f9961a;
    Editor f9962b = this.f9961a.edit();

    private C0790b(Context context) {
        this.f9961a = context.getSharedPreferences("instabug_survey", 0);
    }

    public static void m8397a(Context context) {
        f9960c = new C0790b(context);
    }

    public static C0790b m8396a() {
        return f9960c;
    }

    public final void m8398a(long j) {
        this.f9962b.putLong("last_survey_time", j);
        this.f9962b.apply();
    }
}
