package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.RedditLinkRepository.Companion;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/HistoryKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$historyLinkStore$2 extends Lambda implements Function0<Store<Listing<? extends Link>, HistoryKey>> {
    final /* synthetic */ RedditLinkRepository f19413a;

    RedditLinkRepository$historyLinkStore$2(RedditLinkRepository redditLinkRepository) {
        this.f19413a = redditLinkRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Companion companion = RedditLinkRepository.f16088b;
        Pair c = RedditLinkRepository.f16091m;
        long longValue = ((Number) c.a).longValue();
        TimeUnit timeUnit = (TimeUnit) c.b;
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Listing<? extends Link>, HistoryKey>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                HistoryKey historyKey = (HistoryKey) obj;
                Intrinsics.b(historyKey, "<name for destructuring parameter 0>");
                String str = historyKey.f10667a;
                HistorySortType historySortType = historyKey.f10668b;
                obj = historyKey.f10669c;
                if (Intrinsics.a(historySortType, HistorySortType.a)) {
                    return this.f19413a.f16099j.mo2959a();
                }
                return this.f19413a.f16097h.getHistoryListing(str, historySortType, obj);
            }
        };
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a().m8698a(longValue);
        a2.f10232a = timeUnit;
        a.f10250c = a2.m8699a();
        return a.m8706b();
    }
}
