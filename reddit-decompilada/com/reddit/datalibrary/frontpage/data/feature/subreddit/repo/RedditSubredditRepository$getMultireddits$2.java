package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.reddit.frontpage.domain.model.Multireddit;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Multireddit;", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$getMultireddits$2<T, R> implements Function<Throwable, List<? extends Multireddit>> {
    public static final RedditSubredditRepository$getMultireddits$2 f16191a = new RedditSubredditRepository$getMultireddits$2();

    RedditSubredditRepository$getMultireddits$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.b((Throwable) obj, "it");
        return CollectionsKt.a();
    }
}
