package com.android.volley;

public class VolleyError extends Exception {
    public final NetworkResponse f2805a;
    long f2806b;

    public VolleyError() {
        this.f2805a = null;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.f2805a = networkResponse;
    }

    public VolleyError(String str) {
        super(str);
        this.f2805a = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f2805a = null;
    }
}
