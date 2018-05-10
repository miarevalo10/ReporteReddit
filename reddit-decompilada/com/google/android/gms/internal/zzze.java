package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.instabug.chat.model.Attachment;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzze implements zzys<zzon> {
    private final boolean f14776a;

    public zzze(boolean z) {
        this.f14776a = z;
    }

    private static <K, V> SimpleArrayMap<K, V> m14470a(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap();
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            simpleArrayMap2.put(simpleArrayMap.m1053b(i), ((Future) simpleArrayMap.m1054c(i)).get());
        }
        return simpleArrayMap2;
    }

    public final /* synthetic */ zzou mo2295a(zzym com_google_android_gms_internal_zzym, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        View view;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        Future a = com_google_android_gms_internal_zzym.m6816a(jSONObject);
        zzakv a2 = com_google_android_gms_internal_zzym.m6817a(jSONObject, Attachment.TYPE_VIDEO);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                simpleArrayMap2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if (Attachment.TYPE_IMAGE.equals(string)) {
                string = jSONObject2.getString("name");
                boolean z = this.f14776a;
                jSONObject2 = jSONObject2.getJSONObject("image_value");
                boolean optBoolean = jSONObject2.optBoolean("require", true);
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                simpleArrayMap.put(string, com_google_android_gms_internal_zzym.m6819a(jSONObject2, optBoolean, z));
            } else {
                String str = "Unknown custom asset type: ";
                string = String.valueOf(string);
                zzakb.m5371e(string.length() != 0 ? str.concat(string) : new String(str));
            }
        }
        com_google_android_gms_internal_zzym = zzym.m6808a(a2);
        String string2 = jSONObject.getString("custom_template_id");
        SimpleArrayMap a3 = m14470a(simpleArrayMap);
        zzog com_google_android_gms_internal_zzog = (zzog) a.get();
        zzll b = com_google_android_gms_internal_zzym != null ? com_google_android_gms_internal_zzym.mo3464b() : null;
        if (com_google_android_gms_internal_zzym == null) {
            view = null;
        } else if (com_google_android_gms_internal_zzym == null) {
            throw null;
        } else {
            view = (View) com_google_android_gms_internal_zzym;
        }
        return new zzon(string2, a3, simpleArrayMap2, com_google_android_gms_internal_zzog, b, view);
    }
}
