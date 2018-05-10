package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\bH&J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\u0005H&J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00122\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0019\u001a\u00020\nH&J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0018H&J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH&J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\nH&J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0015\u001a\u00020\u0005H&J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0013\u001a\u00020\u0005H&¨\u0006%"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/LocalSubredditDataSource;", "", "deleteRecentSubreddit", "Lio/reactivex/Completable;", "username", "", "kindWithId", "getDefaultSubreddits", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getFavoriteSubreddits", "getFollowingSubreddits", "getModeratingSubreddits", "getMultireddits", "Lcom/reddit/frontpage/domain/model/Multireddit;", "getRecentSubreddits", "getSubreddit", "Lio/reactivex/Maybe;", "subredditName", "getSubredditListing", "path", "getSubscribedSubreddits", "saveFavorite", "", "subreddit", "subredditId", "favorite", "saveMultireddits", "multireddits", "", "saveOrUpdateRecentSubreddit", "saveSubredditListing", "subreddits", "saveSubreddits", "subscribeSubreddit", "unsubscribeSubreddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalSubredditDataSource.kt */
public interface LocalSubredditDataSource {
    Completable mo2981a(String str, String str2);

    Maybe<Subreddit> mo2982a(String str);

    Single<List<Subreddit>> mo2983a();

    Single<Boolean> mo2984a(String str, Subreddit subreddit);

    Single<Boolean> mo2985a(String str, boolean z);

    Single<Boolean> mo2986a(Collection<Multireddit> collection);

    Single<Boolean> mo2987a(List<Subreddit> list, String str);

    Single<List<Multireddit>> mo2988b();

    Single<Boolean> mo2989b(String str);

    Single<Boolean> mo2990b(Collection<Subreddit> collection);

    Single<List<Subreddit>> mo2991c();

    Single<Boolean> mo2992c(String str);

    Maybe<List<Subreddit>> mo2993d(String str);

    Single<List<Subreddit>> mo2994d();

    Single<List<Subreddit>> mo2995e();

    Single<List<Subreddit>> mo2996e(String str);

    Single<List<Subreddit>> mo2997f();
}
