package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import org.json.JSONObject;

final /* synthetic */ class zztv implements zztr {
    static final zztr f14628a = new zztv();

    private zztv() {
    }

    public final Object mo2158a(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zztu.f8036b));
    }
}
