package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class zznc extends zzmx<String> {
    zznc(int i, String str, String str2) {
        super(i, str, str2);
    }

    public final /* synthetic */ void mo2058a(Editor editor, Object obj) {
        editor.putString(this.f7848b, (String) obj);
    }

    public final /* synthetic */ Object mo2057a(JSONObject jSONObject) {
        return jSONObject.optString(this.f7848b, (String) this.f7849c);
    }

    public final /* synthetic */ Object mo2056a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(this.f7848b, (String) this.f7849c);
    }
}
