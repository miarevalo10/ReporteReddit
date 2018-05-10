package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@zzzv
public final class zznd {
    final Collection<zzmx<?>> f7855a = new ArrayList();
    final Collection<zzmx<String>> f7856b = new ArrayList();
    final Collection<zzmx<String>> f7857c = new ArrayList();

    public final List<String> m6485a() {
        List<String> arrayList = new ArrayList();
        for (zzmx a : this.f7856b) {
            String str = (String) zzkb.m6350f().m6488a(a);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final void m6486a(Editor editor, JSONObject jSONObject) {
        for (zzmx com_google_android_gms_internal_zzmx : this.f7855a) {
            if (com_google_android_gms_internal_zzmx.f7847a == 1) {
                com_google_android_gms_internal_zzmx.mo2058a(editor, com_google_android_gms_internal_zzmx.mo2057a(jSONObject));
            }
        }
    }
}
