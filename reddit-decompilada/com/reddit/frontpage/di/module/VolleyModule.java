package com.reddit.frontpage.di.module;

import com.android.volley.CacheDispatcher;
import com.android.volley.NetworkDispatcher;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.NoCache;
import com.reddit.datalibrary.frontpage.requests.api.v1.BackoffRequestQueue;
import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork;
import javax.inject.Named;
import javax.inject.Singleton;

public class VolleyModule {
    @Singleton
    @Named("no_body_logging")
    public static RequestQueue m22387a(@Named("no_body_logging") OkHttpStack okHttpStack) {
        return m22389c(okHttpStack);
    }

    @Singleton
    @Named("no_redirects")
    public static RequestQueue m22388b(@Named("no_redirects") OkHttpStack okHttpStack) {
        return m22389c(okHttpStack);
    }

    private static RequestQueue m22389c(OkHttpStack okHttpStack) {
        RequestQueue backoffRequestQueue = new BackoffRequestQueue(new NoCache(), new SessionAwareNetwork(okHttpStack));
        if (backoffRequestQueue.i != null) {
            okHttpStack = backoffRequestQueue.i;
            okHttpStack.a = true;
            okHttpStack.interrupt();
        }
        okHttpStack = null;
        for (int i = 0; i < backoffRequestQueue.h.length; i++) {
            if (backoffRequestQueue.h[i] != null) {
                NetworkDispatcher networkDispatcher = backoffRequestQueue.h[i];
                networkDispatcher.a = true;
                networkDispatcher.interrupt();
            }
        }
        backoffRequestQueue.i = new CacheDispatcher(backoffRequestQueue.c, backoffRequestQueue.d, backoffRequestQueue.e, backoffRequestQueue.g);
        backoffRequestQueue.i.start();
        while (okHttpStack < backoffRequestQueue.h.length) {
            NetworkDispatcher networkDispatcher2 = new NetworkDispatcher(backoffRequestQueue.d, backoffRequestQueue.f, backoffRequestQueue.e, backoffRequestQueue.g);
            backoffRequestQueue.h[okHttpStack] = networkDispatcher2;
            networkDispatcher2.start();
            okHttpStack++;
        }
        return backoffRequestQueue;
    }
}
