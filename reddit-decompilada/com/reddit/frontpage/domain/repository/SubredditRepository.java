package com.reddit.frontpage.domain.repository;

import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\u0001&J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u0003H&J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0015\u001a\u00020\u0006H&J:\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0004H&J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006H&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006H&J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010#\u001a\u00020\bH&J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0004H&¨\u0006'"}, d2 = {"Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "", "addOrUpdateRecentSubreddit", "Lio/reactivex/Single;", "", "username", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "deleteRecentSubreddit", "Lio/reactivex/Completable;", "kindWithId", "getDefaultSubreddits", "", "getFavoriteSubreddits", "getFollowingSubreddits", "getModeratedSubreddits", "getMultireddits", "Lcom/reddit/frontpage/domain/model/Multireddit;", "getRecentSubreddits", "getSubreddit", "subredditName", "getSubredditListing", "path", "parameters", "", "refresh", "getSubscribedSubreddits", "subscribe", "syncDefaultSubreddits", "syncModeratedSubreddits", "syncMultireddits", "syncSubscribedSubreddits", "unsubscribe", "updateFavoriteState", "favoriteSubreddit", "subredditId", "favorite", "SubredditAction", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRepository.kt */
public interface SubredditRepository {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/domain/repository/SubredditRepository$SubredditAction;", "", "action", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "toString", "SUBSCRIBE", "UNSUBSCRIBE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubredditRepository.kt */
    public enum SubredditAction {
        ;
        
        private final String f20263d;

        private SubredditAction(String str) {
            Intrinsics.m26847b(str, "action");
            this.f20263d = str;
        }

        public final String toString() {
            return this.f20263d;
        }
    }

    Completable m22491a(String str, String str2);

    Single<Boolean> m22492a();

    Single<Subreddit> m22493a(String str);

    Single<Boolean> m22494a(String str, Subreddit subreddit);

    Single<Boolean> m22495a(String str, String str2, boolean z);

    Single<List<Subreddit>> m22496a(String str, Map<String, String> map);

    Single<Boolean> m22497b();

    Single<List<Multireddit>> m22498b(String str);

    Single<Boolean> m22499c();

    Single<List<Subreddit>> m22500c(String str);

    Single<Boolean> m22501d();

    Single<List<Subreddit>> m22502d(String str);

    Single<List<Subreddit>> m22503e();

    Single<List<Subreddit>> m22504e(String str);

    Single<List<Subreddit>> m22505f(String str);

    Completable m22506g(String str);

    Completable m22507h(String str);

    Single<List<Subreddit>> m22508i(String str);
}
