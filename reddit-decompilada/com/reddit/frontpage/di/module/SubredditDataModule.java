package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.RedditSubredditRepository;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/di/module/SubredditDataModule;", "", "()V", "provideSubscriptionCountRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;", "remoteSubredditDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/remote/RemoteSubredditDataSource;", "client", "Lretrofit2/Retrofit;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/LocalSubredditDataSource;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditDataModule.kt */
public final class SubredditDataModule {
    @Singleton
    public static RemoteSubredditDataSource m22369a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteSubredditDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteSubr…itDataSource::class.java)");
        return (RemoteSubredditDataSource) a;
    }

    @Singleton
    public static SubredditRepository m22371a(BackgroundThread backgroundThread, RemoteSubredditDataSource remoteSubredditDataSource, LocalSubredditDataSource localSubredditDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteSubredditDataSource, "remote");
        Intrinsics.m26847b(localSubredditDataSource, "local");
        return new RedditSubredditRepository(backgroundThread, remoteSubredditDataSource, localSubredditDataSource);
    }

    @Singleton
    public static SubscriptionCountRepository m22370a() {
        return new SubscriptionCountRepository();
    }
}
