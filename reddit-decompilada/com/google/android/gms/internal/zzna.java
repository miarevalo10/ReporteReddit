package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class zzna extends zzmx<Long> {
    zzna(int i, String str, Long l) {
        super(i, str, l);
    }

    public final /* synthetic */ void mo2058a(Editor editor, Object obj) {
        editor.putLong(this.f7848b, ((Long) obj).longValue());
    }

    public final /* synthetic */ Object mo2057a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(this.f7848b, ((Long) this.f7849c).longValue()));
    }

    public final /* synthetic */ Object mo2056a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(this.f7848b, ((Long) this.f7849c).longValue()));
    }
}
