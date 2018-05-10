package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzk implements Callable<SharedPreferences> {
    private /* synthetic */ Context f6014a;

    zzk(Context context) {
        this.f6014a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.f6014a.getSharedPreferences("google_sdk_flags", 0);
    }
}
