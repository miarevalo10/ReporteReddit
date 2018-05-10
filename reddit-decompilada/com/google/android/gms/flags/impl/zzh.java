package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.zzcbc;

public final class zzh extends zza<String> {
    public static String m13132a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) zzcbc.m5593a(new zzi(sharedPreferences, str, str2));
        } catch (Exception e) {
            str = "FlagDataUtils";
            String str3 = "Flag value not available, returning default: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return str2;
        }
    }
}
