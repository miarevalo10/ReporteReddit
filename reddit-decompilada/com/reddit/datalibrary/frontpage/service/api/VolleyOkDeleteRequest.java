package com.reddit.datalibrary.frontpage.service.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.ProhibitRetryPolicy;
import com.reddit.frontpage.util.JsonUtil;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

public class VolleyOkDeleteRequest extends Request<ImgDeleteResponse> {
    private static final String TAG = "VolleyOkDeleteRequest";
    private final Listener<ImgDeleteResponse> listener;

    public VolleyOkDeleteRequest(String str, ErrorListener errorListener, Listener<ImgDeleteResponse> listener) {
        super(3, str, errorListener);
        this.listener = listener;
        setRetryPolicy(new ProhibitRetryPolicy());
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        if (headers == null || headers.equals(Collections.emptyMap())) {
            headers = new HashMap(2);
        }
        headers.put("Accept", "application/json");
        headers.put(HttpRequest.HEADER_AUTHORIZATION, "Client-ID OGZmZWQ0Yzc4Y2");
        return headers;
    }

    protected Response<ImgDeleteResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.a(JsonUtil.m23771a(new String(networkResponse.b, HttpHeaderParser.a(networkResponse.c)), ImgDeleteResponse.class), HttpHeaderParser.a(networkResponse));
        } catch (NetworkResponse networkResponse2) {
            Timber.c(networkResponse2, TAG, new Object[0]);
            return Response.a(new VolleyError());
        }
    }

    protected void deliverResponse(ImgDeleteResponse imgDeleteResponse) {
        this.listener.a(imgDeleteResponse);
    }
}
