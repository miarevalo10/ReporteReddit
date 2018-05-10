package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

@zzzv
public abstract class zzmx<T> {
    final int f7847a;
    final String f7848b;
    final T f7849c;

    public static zzmx<Float> m6475a(int i, String str) {
        return new zznb(i, str, Float.valueOf(0.0f));
    }

    public static zzmx<Integer> m6476a(int i, String str, int i2) {
        return new zzmz(i, str, Integer.valueOf(i2));
    }

    public static zzmx<Long> m6477a(int i, String str, long j) {
        return new zzna(i, str, Long.valueOf(j));
    }

    public static zzmx<Boolean> m6478a(int i, String str, Boolean bool) {
        return new zzmy(i, str, bool);
    }

    public static zzmx<String> m6479a(int i, String str, String str2) {
        return new zznc(i, str, str2);
    }

    protected abstract T mo2056a(SharedPreferences sharedPreferences);

    protected abstract T mo2057a(JSONObject jSONObject);

    public abstract void mo2058a(Editor editor, T t);

    private zzmx(int i, String str, T t) {
        this.f7847a = i;
        this.f7848b = str;
        this.f7849c = t;
        zzkb.m6349e().f7855a.add(this);
    }

    public static zzmx<String> m6480b(int i, String str) {
        i = m6479a(i, str, null);
        zzkb.m6349e().f7856b.add(i);
        return i;
    }

    public static zzmx<String> m6481c(int i, String str) {
        i = m6479a(i, str, null);
        zzkb.m6349e().f7857c.add(i);
        return i;
    }
}
