package com.reddit.datalibrary.frontpage.requests.api.v1;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import java.lang.reflect.Type;
import timber.log.Timber;

public abstract class JsonRequest<T> extends Request<T> {
    private final Gson gson;
    private final Listener<T> listener;
    private final Type type;

    public JsonRequest(int i, String str, Type type, Gson gson, Listener<T> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.listener = listener;
        this.type = type;
        this.gson = gson;
    }

    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String str = new String(networkResponse.f2778b, HttpHeaderParser.m2468a(networkResponse.f2779c));
            if (networkResponse.f2779c.containsKey("x-reddit-loid")) {
                Config.m9152a((String) networkResponse.f2779c.get("x-reddit-loid"));
            }
            if (networkResponse.f2779c.containsKey("x-reddit-session")) {
                Config.m9155b((String) networkResponse.f2779c.get("x-reddit-session"));
            }
            return Response.m2445a(this.gson.m7483a(str, this.type), HttpHeaderParser.m2467a(networkResponse));
        } catch (Throwable e) {
            return Response.m2444a(new ParseError(e));
        } catch (NetworkResponse networkResponse2) {
            Timber.c(networkResponse2, "Failed parsing network response", new Object[0]);
            throw networkResponse2;
        }
    }

    protected void deliverResponse(T t) {
        this.listener.mo794a(t);
    }
}
