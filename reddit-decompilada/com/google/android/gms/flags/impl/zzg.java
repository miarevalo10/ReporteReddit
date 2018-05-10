package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzg implements Callable<Long> {
    private /* synthetic */ SharedPreferences f6007a;
    private /* synthetic */ String f6008b;
    private /* synthetic */ Long f6009c;

    zzg(SharedPreferences sharedPreferences, String str, Long l) {
        this.f6007a = sharedPreferences;
        this.f6008b = str;
        this.f6009c = l;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Long.valueOf(this.f6007a.getLong(this.f6008b, this.f6009c.longValue()));
    }
}
