package com.reddit.datalibrary.frontpage.data.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.LruCache;
import com.google.gson.Gson;
import com.reddit.frontpage.util.JsonUtil;
import java.lang.reflect.Type;

public abstract class BasePersistentKVStorage<T> {
    private final Context f10299a;
    private final SharedPreferences f10300b;
    private final Gson f10301c;
    private final LruCache<String, T> f10302d = new LruCache(10);

    private static String m8750b(String str) {
        return str != null ? str : "__anonymous__";
    }

    public abstract String mo2911a();

    public abstract Type mo2912b();

    public BasePersistentKVStorage(Context context) {
        this.f10299a = context;
        this.f10300b = this.f10299a.getSharedPreferences(mo2911a(), 0);
        this.f10301c = JsonUtil.a();
    }

    public final void m8753a(String str, T t) {
        this.f10300b.edit().putString(str, this.f10301c.m7487b(t)).apply();
        this.f10302d.put(m8750b(str), t);
    }

    public final T m8751a(String str) {
        T t = this.f10302d.get(m8750b(str));
        if (t != null) {
            return t;
        }
        String string = this.f10300b.getString(str, null);
        if (string == null) {
            return t;
        }
        t = this.f10301c.m7483a(string, mo2912b());
        this.f10302d.put(m8750b(str), t);
        return t;
    }
}
