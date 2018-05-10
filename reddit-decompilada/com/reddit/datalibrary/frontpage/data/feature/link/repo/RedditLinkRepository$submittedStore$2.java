package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.UserLinkKey;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.RedditLinkRepository.Companion;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/UserLinkKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$submittedStore$2 extends Lambda implements Function0<Store<Listing<? extends Link>, UserLinkKey>> {
    final /* synthetic */ RedditLinkRepository f19416a;

    RedditLinkRepository$submittedStore$2(RedditLinkRepository redditLinkRepository) {
        this.f19416a = redditLinkRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Companion companion = RedditLinkRepository.f16088b;
        Pair b = RedditLinkRepository.f16090l;
        long longValue = ((Number) b.a).longValue();
        TimeUnit timeUnit = (TimeUnit) b.b;
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Listing<? extends Link>, UserLinkKey>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                UserLinkKey userLinkKey = (UserLinkKey) obj;
                Intrinsics.b(userLinkKey, "<name for destructuring parameter 0>");
                return this.f19416a.f16097h.getUserSubmittedPosts(userLinkKey.f16048a, userLinkKey.f16049b, userLinkKey.f16050c, userLinkKey.f16051d);
            }
        };
        a.f10248a = new SubmittedLinkPersister(this.f19416a.f16098i);
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a().m8698a(longValue);
        a2.f10232a = timeUnit;
        a.f10250c = a2.m8699a();
        return a.m8705a().m8706b();
    }
}
