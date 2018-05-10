package net.hockeyapp.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsUtil {
    public SharedPreferences f26611a;
    private SharedPreferences f26612b;

    private static class PrefsUtilHolder {
        static final PrefsUtil f26610a = new PrefsUtil();
    }

    private PrefsUtil() {
    }

    public static PrefsUtil m28225a() {
        return PrefsUtilHolder.f26610a;
    }

    public final void m28226a(Context context, String str) {
        if (context != null) {
            this.f26612b = context.getSharedPreferences("net.hockeyapp.android.prefs_feedback_token", 0);
            if (this.f26612b != null) {
                context = this.f26612b.edit();
                context.putString("net.hockeyapp.android.prefs_key_feedback_token", str);
                context.apply();
            }
        }
    }
}
