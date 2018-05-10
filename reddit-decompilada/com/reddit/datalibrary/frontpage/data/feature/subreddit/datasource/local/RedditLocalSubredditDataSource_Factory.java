package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RedditLocalSubredditDataSource_Factory implements Factory<RedditLocalSubredditDataSource> {
    private final Provider<Moshi> f18711a;
    private final Provider<Context> f18712b;

    private RedditLocalSubredditDataSource_Factory(Provider<Moshi> provider, Provider<Context> provider2) {
        this.f18711a = provider;
        this.f18712b = provider2;
    }

    public static RedditLocalSubredditDataSource_Factory m19695a(Provider<Moshi> provider, Provider<Context> provider2) {
        return new RedditLocalSubredditDataSource_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new RedditLocalSubredditDataSource((Moshi) this.f18711a.get(), (Context) this.f18712b.get());
    }
}
