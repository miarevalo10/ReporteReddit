package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "it", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$getCategories$recommended$1<T, R> implements Function<T, R> {
    public static final RedditCategoryRepository$getCategories$recommended$1 f15793a = new RedditCategoryRepository$getCategories$recommended$1();

    RedditCategoryRepository$getCategories$recommended$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.b(pair, "it");
        return (SubredditCategory) pair.a;
    }
}
