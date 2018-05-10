package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.common.busevents.CreateEditCommentResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.CommentListResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.CommentResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.CreateCommentResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.CreateEditLinkResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.DiscoveryUnitListingDataModelJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.EnvelopeJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.EnvelopeListJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.FrontpageLinkListingResponseAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.ListingEnvelopeJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.RecommendedCategoryJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.RemoteSearchResultJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.StringConversionErrorHandlerAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.SubredditListingDataModelJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.converter.TrophiesEnvelopeJsonAdapter;
import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.InstabugUtil;
import com.reddit.frontpage.util.Util;
import com.squareup.moshi.Moshi;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0007¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/di/module/NetworkModule;", "", "()V", "analyticsRetrofitClient", "Lretrofit2/Retrofit;", "client", "Lokhttp3/OkHttpClient;", "disableSslValidation", "Lokhttp3/OkHttpClient$Builder;", "builder", "gatewayRetrofitClient", "oauthHttpClient", "okHttpClient", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideObservableWebSocketClient", "Lcom/reddit/datalibrary/frontpage/data/common/websocket/ObservableWebSocketClient;", "retrofitClient", "moshi", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NetworkModule.kt */
public final class NetworkModule {
    @Singleton
    public static OkHttpClient m22349a() {
        Builder builder = new Builder();
        builder.addNetworkInterceptor(InstabugUtil.f21744a);
        Object build = builder.build();
        Intrinsics.m26843a(build, "builder.build()");
        return build;
    }

    @Singleton
    public static Retrofit m22351a(OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.m26847b(okHttpClient, "client");
        Intrinsics.m26847b(moshi, "moshi");
        Object a = new Retrofit.Builder().a(okHttpClient).a(FrontpageSettings.a().i()).a(RxJava2CallAdapterFactory.a()).a(MoshiConverterFactory.a(moshi)).a();
        Intrinsics.m26843a(a, "Retrofit.Builder()\n     …\n                .build()");
        return a;
    }

    @Singleton
    public static Retrofit m22350a(OkHttpClient okHttpClient) {
        Intrinsics.m26847b(okHttpClient, "client");
        Object a = new Retrofit.Builder().a(okHttpClient).a(FrontpageSettings.a().j()).a(RxJava2CallAdapterFactory.a()).a(GsonConverterFactory.a()).a();
        Intrinsics.m26843a(a, "Retrofit.Builder()\n     …\n                .build()");
        return a;
    }

    @Singleton
    public static Retrofit m22353b(OkHttpClient okHttpClient) {
        Intrinsics.m26847b(okHttpClient, "client");
        Object a = new Retrofit.Builder().a(okHttpClient).a(Util.m24027f((int) C1761R.string.events_test_uri)).a(RxJava2CallAdapterFactory.a()).a();
        Intrinsics.m26843a(a, "Retrofit.Builder()\n     …\n                .build()");
        return a;
    }

    @Singleton
    public static Moshi m22352b() {
        Object a = new Moshi.Builder().m25713a(StringConversionErrorHandlerAdapter.INSTANCE).m25712a(EnvelopeJsonAdapter.Companion.getFACTORY()).m25712a(ListingEnvelopeJsonAdapter.Companion.getFACTORY()).m25712a(EnvelopeListJsonAdapter.Companion.getFACTORY()).m25712a(TrophiesEnvelopeJsonAdapter.Companion.getFACTORY()).m25712a(RecommendedCategoryJsonAdapter.Companion.getFACTORY()).m25713a(SubredditListingDataModelJsonAdapter.INSTANCE).m25713a(DiscoveryUnitListingDataModelJsonAdapter.INSTANCE).m25713a(CommentResponseAdapter.INSTANCE).m25713a(CreateCommentResponseAdapter.INSTANCE).m25713a(CreateEditCommentResponseAdapter.a).m25713a(CreateEditLinkResponseAdapter.INSTANCE).m25712a(CommentListResponseAdapter.Companion.getFACTORY()).m25712a(FrontpageLinkListingResponseAdapter.Companion.getFACTORY()).m25713a(RemoteSearchResultJsonAdapter.INSTANCE).m25714a();
        Intrinsics.m26843a(a, "Moshi.Builder()\n        …\n                .build()");
        return a;
    }

    @Singleton
    public static ObservableWebSocketClient m22354c(OkHttpClient okHttpClient) {
        Intrinsics.m26847b(okHttpClient, "client");
        return new ObservableWebSocketClient(okHttpClient);
    }
}
