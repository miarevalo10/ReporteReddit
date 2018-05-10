package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "it", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$syncModeratedSubreddits$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditSubredditRepository f16207a;

    RedditSubredditRepository$syncModeratedSubreddits$2(RedditSubredditRepository redditSubredditRepository) {
        this.f16207a = redditSubredditRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        return this.f16207a.f16215e.mo2990b((Collection) list);
    }
}
