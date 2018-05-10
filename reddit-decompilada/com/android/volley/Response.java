package com.android.volley;

import com.android.volley.Cache.Entry;

public class Response<T> {
    public final T f2801a;
    public final Entry f2802b;
    public final VolleyError f2803c;
    public boolean f2804d;

    public interface ErrorListener {
        void mo793a(VolleyError volleyError);
    }

    public interface Listener<T> {
        void mo794a(T t);
    }

    public static <T> Response<T> m2445a(T t, Entry entry) {
        return new Response(t, entry);
    }

    public static <T> Response<T> m2444a(VolleyError volleyError) {
        return new Response(volleyError);
    }

    private Response(T t, Entry entry) {
        this.f2804d = false;
        this.f2801a = t;
        this.f2802b = entry;
        this.f2803c = null;
    }

    private Response(VolleyError volleyError) {
        this.f2804d = false;
        this.f2801a = null;
        this.f2802b = null;
        this.f2803c = volleyError;
    }
}
