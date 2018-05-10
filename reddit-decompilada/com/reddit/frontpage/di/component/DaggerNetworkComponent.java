package com.reddit.frontpage.di.component;

import com.android.volley.RequestQueue;
import com.danikula.videocache.HttpProxyCacheServer;
import com.reddit.config.RedditGlideModule;
import com.reddit.config.RedditGlideModule_MembersInjector;
import com.reddit.config.http.RetrofitModule_ProvideAwsServiceFactory;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient_MembersInjector;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient_MembersInjector;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon_MembersInjector;
import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import com.reddit.datalibrary.frontpage.service.api.AwsService;
import com.reddit.frontpage.di.module.OkHttpModule;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideNoRedirectOkHttpClientFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideNoRedirectsOkHttpStackFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideOkHttpClientFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideWebSocketClientFactory;
import com.reddit.frontpage.di.module.OkHttpModule_ProvideWebSocketOkHttpClientFactory;
import com.reddit.frontpage.di.module.VideoCacheModule;
import com.reddit.frontpage.di.module.VideoCacheModule_ProvideVideoCacheFactory;
import com.reddit.frontpage.di.module.VolleyModule;
import com.reddit.frontpage.di.module.VolleyModule_ProvideNoBodyLoggingRequestQueueFactory;
import com.reddit.frontpage.di.module.VolleyModule_ProvideNoRedirectRequestQueueFactory;
import com.reddit.frontpage.video.mpdparser.core.mapper.LocalUrlMPDMapper;
import com.reddit.frontpage.video.mpdparser.core.mapper.LocalUrlMPDMapper_MembersInjector;
import com.reddit.frontpage.video.proxy.DashProxy;
import com.reddit.frontpage.video.proxy.DashProxy_MembersInjector;
import com.reddit.frontpage.widgets.video.VideoPlayer;
import com.reddit.frontpage.widgets.video.VideoPlayer_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class DaggerNetworkComponent implements NetworkComponent {
    private Provider<OkHttpClient> f27766a;
    private Provider<OkHttpStack> f27767b;
    private Provider<RequestQueue> f27768c;
    private Provider<HttpProxyCacheServer> f27769d;
    private Provider<OkHttpClient> f27770e;
    private Provider<OkHttpClient> f27771f;
    private Provider<OkHttpStack> f27772g;
    private Provider<RequestQueue> f27773h;
    private Provider<OkHttpClient> f27774i;
    private Provider<WebSocketClient> f27775j;
    private Provider<AwsService> f27776k;

    public static final class Builder {
        public OkHttpModule f20204a;
        public VolleyModule f20205b;
        public VideoCacheModule f20206c;

        private Builder() {
        }
    }

    private DaggerNetworkComponent(Builder builder) {
        this.f27766a = DoubleCheck.m31842a(OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory.m34513a(builder.f20204a));
        this.f27767b = DoubleCheck.m31842a(OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory.m34514a(builder.f20204a, this.f27766a));
        this.f27768c = DoubleCheck.m31842a(VolleyModule_ProvideNoBodyLoggingRequestQueueFactory.m34552a(builder.f20205b, this.f27767b));
        this.f27769d = DoubleCheck.m31842a(VideoCacheModule_ProvideVideoCacheFactory.m34550a(builder.f20206c));
        this.f27770e = DoubleCheck.m31842a(OkHttpModule_ProvideOkHttpClientFactory.m34517a(builder.f20204a));
        this.f27771f = DoubleCheck.m31842a(OkHttpModule_ProvideNoRedirectOkHttpClientFactory.m34515a(builder.f20204a));
        this.f27772g = DoubleCheck.m31842a(OkHttpModule_ProvideNoRedirectsOkHttpStackFactory.m34516a(builder.f20204a, this.f27771f));
        this.f27773h = DoubleCheck.m31842a(VolleyModule_ProvideNoRedirectRequestQueueFactory.m34553a(builder.f20205b, this.f27772g));
        this.f27774i = DoubleCheck.m31842a(OkHttpModule_ProvideWebSocketOkHttpClientFactory.m34519a(builder.f20204a));
        this.f27775j = DoubleCheck.m31842a(OkHttpModule_ProvideWebSocketClientFactory.m34518a(builder.f20204a, this.f27774i));
        this.f27776k = DoubleCheck.m31842a(RetrofitModule_ProvideAwsServiceFactory.a(this.f27766a));
    }

    public static Builder m29196a() {
        return new Builder();
    }

    public final AwsService mo4701b() {
        return (AwsService) this.f27776k.get();
    }

    public final void mo4697a(Cannon cannon) {
        Cannon_MembersInjector.a(cannon, (RequestQueue) this.f27768c.get());
    }

    public final void mo4700a(VideoPlayer videoPlayer) {
        VideoPlayer_MembersInjector.m30576a(videoPlayer, (HttpProxyCacheServer) this.f27769d.get());
    }

    public final void mo4694a(RedditGlideModule redditGlideModule) {
        RedditGlideModule_MembersInjector.a(redditGlideModule, (OkHttpClient) this.f27770e.get());
    }

    public final void mo4695a(RedditAuthClient redditAuthClient) {
        RedditAuthClient_MembersInjector.a(redditAuthClient, (RequestQueue) this.f27773h.get());
    }

    public final void mo4696a(RedditClient redditClient) {
        RedditClient_MembersInjector.a(redditClient, DoubleCheck.m31843b(this.f27775j));
    }

    public final void mo4699a(DashProxy dashProxy) {
        DashProxy_MembersInjector.m30480a(dashProxy, (OkHttpClient) this.f27770e.get());
    }

    public final void mo4698a(LocalUrlMPDMapper localUrlMPDMapper) {
        LocalUrlMPDMapper_MembersInjector.m30466a(localUrlMPDMapper, (HttpProxyCacheServer) this.f27769d.get());
    }
}
