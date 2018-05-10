package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "remote", "local", "apply", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$updateFavoriteState$1<T1, T2, R> implements BiFunction<Boolean, Boolean, Boolean> {
    public static final RedditSubredditRepository$updateFavoriteState$1 f16210a = new RedditSubredditRepository$updateFavoriteState$1();

    RedditSubredditRepository$updateFavoriteState$1() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        Boolean bool2 = (Boolean) obj2;
        Intrinsics.b(bool, "remote");
        Intrinsics.b(bool2, "local");
        return bool;
    }
}
