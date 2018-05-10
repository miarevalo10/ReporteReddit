package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource.DefaultImpls;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001aB\u00120\u0012.\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0001H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lkotlin/Pair;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$recommendedCategoryStore$2 extends Lambda implements Function0<Store<Pair<? extends SubredditCategory, ? extends List<? extends Subreddit>>, Unit>> {
    final /* synthetic */ RedditCategoryRepository f19350a;

    RedditCategoryRepository$recommendedCategoryStore$2(RedditCategoryRepository redditCategoryRepository) {
        this.f19350a = redditCategoryRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Pair<? extends SubredditCategory, ? extends List<? extends Subreddit>>, Unit>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                Intrinsics.b((Unit) obj, "it");
                return DefaultImpls.subredditsInRecommended$default(this.f19350a.f15805f, null, 1, null).flatMap(new RedditCategoryRepository$remoteGetRecommendedCategory$1(this.f19350a));
            }
        };
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a().m8698a(5);
        a2.f10232a = TimeUnit.MINUTES;
        a.f10250c = a2.m8699a();
        return a.m8706b();
    }
}
