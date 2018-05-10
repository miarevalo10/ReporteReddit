package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class zznb extends zzmx<Float> {
    zznb(int i, String str, Float f) {
        super(i, str, f);
    }

    public final /* synthetic */ void mo2058a(Editor editor, Object obj) {
        editor.putFloat(this.f7848b, ((Float) obj).floatValue());
    }

    public final /* synthetic */ Object mo2057a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(this.f7848b, (double) ((Float) this.f7849c).floatValue()));
    }

    public final /* synthetic */ Object mo2056a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(this.f7848b, ((Float) this.f7849c).floatValue()));
    }
}
