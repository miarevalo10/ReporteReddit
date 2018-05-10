package com.reddit.datalibrary.frontpage.requests.api.v1;

import com.android.volley.Request;

final /* synthetic */ class BackoffRequestQueue$$Lambda$0 implements Runnable {
    private final BackoffRequestQueue f10886a;
    private final Request f10887b;

    BackoffRequestQueue$$Lambda$0(BackoffRequestQueue backoffRequestQueue, Request request) {
        this.f10886a = backoffRequestQueue;
        this.f10887b = request;
    }

    public final void run() {
        this.f10886a.m16387b(this.f10887b);
    }
}
