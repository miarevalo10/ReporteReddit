package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zzz implements zzt<Object> {
    private final Context f13738a;

    public zzz(Context context) {
        this.f13738a = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzbs.m4507z().m5090a(this.f13738a)) {
            zzbs.m4507z().m5089a(this.f13738a, (String) map.get("eventName"), (String) map.get("eventId"));
        }
    }
}
