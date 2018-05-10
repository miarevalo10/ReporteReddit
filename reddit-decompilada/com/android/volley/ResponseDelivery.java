package com.android.volley;

public interface ResponseDelivery {
    void mo774a(Request<?> request, Response<?> response);

    void mo775a(Request<?> request, Response<?> response, Runnable runnable);

    void mo776a(Request<?> request, VolleyError volleyError);
}
