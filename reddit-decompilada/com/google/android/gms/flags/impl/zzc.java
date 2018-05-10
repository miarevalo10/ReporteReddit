package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable<Boolean> {
    private /* synthetic */ SharedPreferences f6001a;
    private /* synthetic */ String f6002b;
    private /* synthetic */ Boolean f6003c;

    zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f6001a = sharedPreferences;
        this.f6002b = str;
        this.f6003c = bool;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.f6001a.getBoolean(this.f6002b, this.f6003c.booleanValue()));
    }
}
