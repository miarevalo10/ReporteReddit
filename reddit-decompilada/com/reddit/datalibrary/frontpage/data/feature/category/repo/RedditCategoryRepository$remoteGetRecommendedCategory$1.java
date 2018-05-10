package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.reddit.datalibrary.frontpage.data.common.SubredditLoaderUtils;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.RecommendedCategory;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001ar\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u0002 \u0006*8\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "it", "Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategory;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$remoteGetRecommendedCategory$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ RedditCategoryRepository f15799a;

    RedditCategoryRepository$remoteGetRecommendedCategory$1(RedditCategoryRepository redditCategoryRepository) {
        this.f15799a = redditCategoryRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        RecommendedCategory recommendedCategory = (RecommendedCategory) obj;
        Intrinsics.b(recommendedCategory, "it");
        final SubredditCategory subredditCategory = new SubredditCategory("recommended", "Recommended", recommendedCategory.getColor(), recommendedCategory.getIcon());
        obj = recommendedCategory.getSubreddits();
        if (obj.getAfter() == null) {
            return Single.just(new Pair(subredditCategory, obj.getChildren()));
        }
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        return SubredditLoaderUtils.m8758a(obj.getAfter(), new Function1<String, Single<Listing<? extends Subreddit>>>() {

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategory;", "apply"}, k = 3, mv = {1, 1, 9})
            /* compiled from: RedditCategoryRepository.kt */
            static final class C14931<T, R> implements Function<T, R> {
                public static final C14931 f15796a = new C14931();

                C14931() {
                }

                public final /* synthetic */ Object apply(Object obj) {
                    RecommendedCategory recommendedCategory = (RecommendedCategory) obj;
                    Intrinsics.b(recommendedCategory, "it");
                    return recommendedCategory.getSubreddits();
                }
            }

            public final /* synthetic */ Object m20621a(Object obj) {
                obj = this.f15799a.f15805f.subredditsInRecommended((String) obj).map(C14931.f15796a);
                Intrinsics.a(obj, "remote.subredditsInRecom…er).map { it.subreddits }");
                return obj;
            }
        }).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                List list = (List) obj;
                Intrinsics.b(list, "it");
                List c = CollectionsKt.c(obj.getChildren());
                c.addAll(list);
                return new Pair(subredditCategory, c);
            }
        });
    }
}
