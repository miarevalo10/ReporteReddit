package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzp;

public final class zzb {
    private SharedPreferences zzani;

    public zzb(Context context) {
        try {
            context = zzp.getRemoteContext(context);
            this.zzani = context == null ? null : context.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.zzani = null;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        try {
            return this.zzani == null ? false : this.zzani.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    final float getFloat(String str, float f) {
        try {
            return this.zzani == null ? 0.0f : this.zzani.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    final String getString(String str, String str2) {
        try {
            return this.zzani == null ? str2 : this.zzani.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }
}
