package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzbq;

@zzzv
public final class zzmt {
    private final Context f7846a;

    public zzmt(Context context) {
        zzbq.m4809a((Object) context, (Object) "Context can not be null");
        this.f7846a = context;
    }

    public final boolean m6471a() {
        return ((Boolean) zzajk.m5302a(this.f7846a, new zzmu())).booleanValue() && zzbhf.m5574a(this.f7846a).m5568a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    final boolean m6472a(Intent intent) {
        zzbq.m4809a((Object) intent, (Object) "Intent can not be null");
        return !this.f7846a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    @TargetApi(14)
    public final boolean m6473b() {
        return m6472a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
