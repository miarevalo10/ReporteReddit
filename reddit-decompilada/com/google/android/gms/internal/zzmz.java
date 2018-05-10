package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class zzmz extends zzmx<Integer> {
    zzmz(int i, String str, Integer num) {
        super(i, str, num);
    }

    public final /* synthetic */ void mo2058a(Editor editor, Object obj) {
        editor.putInt(this.f7848b, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object mo2057a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(this.f7848b, ((Integer) this.f7849c).intValue()));
    }

    public final /* synthetic */ Object mo2056a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(this.f7848b, ((Integer) this.f7849c).intValue()));
    }
}
