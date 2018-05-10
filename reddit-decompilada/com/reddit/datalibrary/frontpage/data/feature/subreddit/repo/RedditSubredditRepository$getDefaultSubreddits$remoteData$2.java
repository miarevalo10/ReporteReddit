package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "result", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$getDefaultSubreddits$remoteData$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditSubredditRepository f16185a;

    RedditSubredditRepository$getDefaultSubreddits$remoteData$2(RedditSubredditRepository redditSubredditRepository) {
        this.f16185a = redditSubredditRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final List list = (List) obj;
        Intrinsics.b(list, "result");
        return this.f16185a.f16215e.mo2990b((Collection) list).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Intrinsics.b((Boolean) obj, "it");
                return list;
            }
        });
    }
}
