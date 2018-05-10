package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "subreddit", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$getSubreddit$remoteSubreddit$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditSubredditRepository f16195a;

    RedditSubredditRepository$getSubreddit$remoteSubreddit$1(RedditSubredditRepository redditSubredditRepository) {
        this.f16195a = redditSubredditRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final Subreddit subreddit = (Subreddit) obj;
        Intrinsics.b(subreddit, "subreddit");
        return this.f16195a.f16215e.mo2990b((Collection) CollectionsKt.a(subreddit)).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Intrinsics.b((Boolean) obj, "it");
                return subreddit;
            }
        });
    }
}
