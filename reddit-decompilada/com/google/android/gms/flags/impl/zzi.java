package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzi implements Callable<String> {
    private /* synthetic */ SharedPreferences f6010a;
    private /* synthetic */ String f6011b;
    private /* synthetic */ String f6012c;

    zzi(SharedPreferences sharedPreferences, String str, String str2) {
        this.f6010a = sharedPreferences;
        this.f6011b = str;
        this.f6012c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        return this.f6010a.getString(this.f6011b, this.f6012c);
    }
}
