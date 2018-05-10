package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzcbc;

public final class zzj {
    private static SharedPreferences f6013a;

    public static SharedPreferences m4972a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f6013a == null) {
                f6013a = (SharedPreferences) zzcbc.m5593a(new zzk(context));
            }
            sharedPreferences = f6013a;
        }
        return sharedPreferences;
    }
}
