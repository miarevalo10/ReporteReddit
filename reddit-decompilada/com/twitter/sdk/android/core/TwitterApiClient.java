package com.twitter.sdk.android.core;

import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.OkHttpClientHelper;
import com.twitter.sdk.android.core.models.BindingValues;
import com.twitter.sdk.android.core.models.BindingValuesAdapter;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterApiClient {
    final ConcurrentHashMap<Class, Object> f23924a;
    final Retrofit f23925b;

    private TwitterApiClient(OkHttpClient okHttpClient, TwitterApi twitterApi) {
        this.f23924a = new ConcurrentHashMap();
        this.f23925b = new Builder().a(okHttpClient).a(twitterApi.getBaseHostUrl()).a(GsonConverterFactory.a(new GsonBuilder().a(new SafeListAdapter()).a(new SafeMapAdapter()).a(BindingValues.class, new BindingValuesAdapter()).a())).a();
    }

    public TwitterApiClient(TwitterSession twitterSession) {
        this(OkHttpClientHelper.m25871a(twitterSession, TwitterCore.m31719a().f30696d, TwitterCore.m31719a().m31725b()), new TwitterApi());
    }

    public TwitterApiClient() {
        this(OkHttpClientHelper.m25870a(TwitterCore.m31719a().m31726d(), TwitterCore.m31719a().m31725b()), new TwitterApi());
    }

    public final AccountService m25844a() {
        return (AccountService) m25845a(AccountService.class);
    }

    public final FavoriteService m25846b() {
        return (FavoriteService) m25845a(FavoriteService.class);
    }

    public final StatusesService m25847c() {
        return (StatusesService) m25845a(StatusesService.class);
    }

    protected final <T> T m25845a(Class<T> cls) {
        if (!this.f23924a.contains(cls)) {
            this.f23924a.putIfAbsent(cls, this.f23925b.a(cls));
        }
        return this.f23924a.get(cls);
    }
}
