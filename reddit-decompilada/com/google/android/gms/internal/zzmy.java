package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class zzmy extends zzmx<Boolean> {
    zzmy(int i, String str, Boolean bool) {
        super(i, str, bool);
    }

    public final /* synthetic */ void mo2058a(Editor editor, Object obj) {
        editor.putBoolean(this.f7848b, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ Object mo2057a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(this.f7848b, ((Boolean) this.f7849c).booleanValue()));
    }

    public final /* synthetic */ Object mo2056a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(this.f7848b, ((Boolean) this.f7849c).booleanValue()));
    }
}
