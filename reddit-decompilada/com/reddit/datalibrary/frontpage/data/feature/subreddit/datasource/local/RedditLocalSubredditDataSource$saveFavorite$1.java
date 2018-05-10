package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "apply", "(Ljava/lang/Long;)Z"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$saveFavorite$1<T, R> implements Function<T, R> {
    public static final RedditLocalSubredditDataSource$saveFavorite$1 f16159a = new RedditLocalSubredditDataSource$saveFavorite$1();

    RedditLocalSubredditDataSource$saveFavorite$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Long l = (Long) obj;
        Intrinsics.b(l, "it");
        return Boolean.valueOf(Intrinsics.a(l.longValue(), 0) > null ? true : null);
    }
}
