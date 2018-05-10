package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012.\u0010\u0004\u001a*\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$getCategories$1<T, R> implements Function<T, R> {
    public static final RedditCategoryRepository$getCategories$1 f15792a = new RedditCategoryRepository$getCategories$1();

    RedditCategoryRepository$getCategories$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.b(pair, "it");
        List c = CollectionsKt.c(new SubredditCategory[]{(SubredditCategory) pair.a});
        obj = pair.b;
        Intrinsics.a(obj, "it.second");
        c.addAll((Collection) obj);
        return CollectionsKt.n(c);
    }
}
