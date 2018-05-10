package com.reddit.frontpage.di.module;

import android.content.SharedPreferences;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.search.LocalSearchDataSource;
import com.reddit.datalibrary.frontpage.data.feature.search.RedditSearchRepository;
import com.reddit.datalibrary.frontpage.data.feature.search.RemoteSearchDataSource;
import com.reddit.datalibrary.frontpage.data.feature.search.SharedPrefsSearchDataSource;
import com.reddit.frontpage.domain.repository.SearchRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/di/module/UserSearchDataModule;", "", "()V", "localSearchDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;", "prefs", "Landroid/content/SharedPreferences;", "searchRepository", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/search/RemoteSearchDataSource;", "local", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSearchDataModule.kt */
public final class UserSearchDataModule {
    public static LocalSearchDataSource m22383a(SharedPreferences sharedPreferences) {
        Intrinsics.m26847b(sharedPreferences, "prefs");
        return new SharedPrefsSearchDataSource(sharedPreferences);
    }

    public static SearchRepository m22384a(BackgroundThread backgroundThread, RemoteSearchDataSource remoteSearchDataSource, LocalSearchDataSource localSearchDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteSearchDataSource, "remote");
        Intrinsics.m26847b(localSearchDataSource, "local");
        return new RedditSearchRepository(remoteSearchDataSource, localSearchDataSource, backgroundThread);
    }
}
