package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzajm implements Callable<String> {
    private /* synthetic */ Context f6455a;
    private /* synthetic */ Context f6456b;

    zzajm(Context context, Context context2) {
        this.f6455a = context;
        this.f6456b = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        int i = 0;
        if (this.f6455a != null) {
            zzagf.m13278a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f6455a.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzagf.m13278a("Attempting to read user agent from local cache.");
            sharedPreferences = this.f6456b.getSharedPreferences("admob_user_agent", 0);
            i = 1;
        }
        Object string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzagf.m13278a("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f6456b);
            if (i != 0) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzagf.m13278a("Persisting user agent.");
            }
        }
        return string;
    }
}
