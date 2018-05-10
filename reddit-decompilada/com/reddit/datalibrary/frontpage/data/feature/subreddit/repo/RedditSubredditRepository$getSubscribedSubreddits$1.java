package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Predicate;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "subreddits", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "test"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$getSubscribedSubreddits$1<T> implements Predicate<List<? extends Subreddit>> {
    public static final RedditSubredditRepository$getSubscribedSubreddits$1 f16196a = new RedditSubredditRepository$getSubscribedSubreddits$1();

    RedditSubredditRepository$getSubscribedSubreddits$1() {
    }

    public final /* synthetic */ boolean test(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "subreddits");
        return ((Collection) list).isEmpty() == null ? true : null;
    }
}
