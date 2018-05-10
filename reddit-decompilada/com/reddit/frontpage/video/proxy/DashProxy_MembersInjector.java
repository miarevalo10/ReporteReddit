package com.reddit.frontpage.video.proxy;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

public final class DashProxy_MembersInjector implements MembersInjector<DashProxy> {
    public static void m30480a(DashProxy dashProxy, OkHttpClient okHttpClient) {
        dashProxy.f29441a = okHttpClient;
    }
}
