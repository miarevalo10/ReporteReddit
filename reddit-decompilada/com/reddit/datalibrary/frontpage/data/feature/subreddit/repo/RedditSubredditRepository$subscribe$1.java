package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "success", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/CompletableSource;"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$subscribe$1<T, R> implements Function<Boolean, CompletableSource> {
    final /* synthetic */ RedditSubredditRepository f16204a;
    final /* synthetic */ String f16205b;

    RedditSubredditRepository$subscribe$1(RedditSubredditRepository redditSubredditRepository, String str) {
        this.f16204a = redditSubredditRepository;
        this.f16205b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.b(bool, "success");
        if (bool.booleanValue() != null) {
            return Completable.complete();
        }
        return this.f16204a.m16173a(this.f16205b).toCompletable();
    }
}
