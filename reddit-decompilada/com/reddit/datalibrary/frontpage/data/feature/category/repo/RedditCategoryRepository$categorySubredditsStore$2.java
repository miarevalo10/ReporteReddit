package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.common.SubredditLoaderUtils;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$categorySubredditsStore$2 extends Lambda implements Function0<Store<List<? extends Subreddit>, String>> {
    final /* synthetic */ RedditCategoryRepository f19349a;

    RedditCategoryRepository$categorySubredditsStore$2(RedditCategoryRepository redditCategoryRepository) {
        this.f19349a = redditCategoryRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<List<? extends Subreddit>, String>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                String str = (String) obj;
                Intrinsics.b(str, "categoryId");
                return SubredditLoaderUtils.f10303a;
            }
        };
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a().m8698a(5);
        a2.f10232a = TimeUnit.MINUTES;
        a.f10250c = a2.m8699a();
        return a.m8706b();
    }
}
