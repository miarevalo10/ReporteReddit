package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import io.reactivex.Single;
import io.reactivex.rxkotlin.SinglesKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0017H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00172\u0006\u0010\u0019\u001a\u00020\u0012H\u0016Jt\u0010\u001a\u001an\u00120\u0012.\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t \u001b*\u0016\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00110\u0011 \u001b*6\u00120\u0012.\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t \u001b*\u0016\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00110\u0011\u0018\u00010\u00170\u0017H\u0002J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00172\u0006\u0010\u001d\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR9\u0010\u0010\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0011\u0012\u0004\u0012\u00020\u00130\b8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/category/repo/RedditCategoryRepository;", "Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/category/datasource/RemoteCategoryDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/category/datasource/RemoteCategoryDataSource;)V", "categorySubredditsStore", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "", "getCategorySubredditsStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "categorySubredditsStore$delegate", "Lkotlin/Lazy;", "recommendedCategoryStore", "Lkotlin/Pair;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "", "getRecommendedCategoryStore", "recommendedCategoryStore$delegate", "getCategories", "Lio/reactivex/Single;", "getSubredditsInCategory", "category", "remoteGetRecommendedCategory", "kotlin.jvm.PlatformType", "remoteGetSubredditsInCategory", "categoryId", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
public final class RedditCategoryRepository implements CategoryRepository {
    static final /* synthetic */ KProperty[] f15800a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditCategoryRepository.class), "recommendedCategoryStore", "getRecommendedCategoryStore()Lcom/nytimes/android/external/store3/base/impl/Store;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditCategoryRepository.class), "categorySubredditsStore", "getCategorySubredditsStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    public static final Companion f15801b = new Companion();
    private final Lazy f15802c = LazyKt.a((Function0) new RedditCategoryRepository$recommendedCategoryStore$2(this));
    private final Lazy f15803d = LazyKt.a((Function0) new RedditCategoryRepository$categorySubredditsStore$2(this));
    private final BackgroundThread f15804e;
    private final RemoteCategoryDataSource f15805f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00068\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/category/repo/RedditCategoryRepository$Companion;", "", "()V", "IN_MEMORY_CACHE_TIMEOUT_MINUTES", "", "RECOMMENDED_ID", "", "RECOMMENDED_ID$annotations", "RECOMMENDED_NAME", "RECOMMENDED_NAME$annotations", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditCategoryRepository.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final Store<Pair<SubredditCategory, List<Subreddit>>, Unit> m15892b() {
        return (Store) this.f15802c.b();
    }

    public RedditCategoryRepository(BackgroundThread backgroundThread, RemoteCategoryDataSource remoteCategoryDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteCategoryDataSource, "remote");
        this.f15804e = backgroundThread;
        this.f15805f = remoteCategoryDataSource;
    }

    public final Single<List<SubredditCategory>> m15894a() {
        Single map = m15892b().mo2713a(Unit.a).map(RedditCategoryRepository$getCategories$recommended$1.f15793a);
        Intrinsics.a(map, "recommendedCategoryStore…        .map { it.first }");
        map = SinglesKt.a(com.reddit.frontpage.util.kotlin.SinglesKt.a(map, this.f15804e), this.f15805f.subredditCategories()).map(RedditCategoryRepository$getCategories$1.f15792a);
        Intrinsics.a(map, "recommended.zipWith(cate…d)\n      }.toList()\n    }");
        return com.reddit.frontpage.util.kotlin.SinglesKt.a(map, this.f15804e);
    }

    public final Single<List<Subreddit>> m15895a(SubredditCategory subredditCategory) {
        Intrinsics.b(subredditCategory, "category");
        if (Intrinsics.a(subredditCategory.getId(), "recommended")) {
            subredditCategory = m15892b().mo2713a(Unit.a).map(RedditCategoryRepository$getSubredditsInCategory$1.f15794a);
            Intrinsics.a(subredditCategory, "recommendedCategoryStore…       .map { it.second }");
            return com.reddit.frontpage.util.kotlin.SinglesKt.a(subredditCategory, this.f15804e);
        }
        subredditCategory = ((Store) this.f15803d.b()).mo2713a(subredditCategory.getId());
        Intrinsics.a(subredditCategory, "categorySubredditsStore[category.id]");
        return com.reddit.frontpage.util.kotlin.SinglesKt.a(subredditCategory, this.f15804e);
    }
}
