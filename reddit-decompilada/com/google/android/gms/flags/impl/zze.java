package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zze implements Callable<Integer> {
    private /* synthetic */ SharedPreferences f6004a;
    private /* synthetic */ String f6005b;
    private /* synthetic */ Integer f6006c;

    zze(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f6004a = sharedPreferences;
        this.f6005b = str;
        this.f6006c = num;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Integer.valueOf(this.f6004a.getInt(this.f6005b, this.f6006c.intValue()));
    }
}
