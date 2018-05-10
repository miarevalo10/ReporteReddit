package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource.DefaultImpls;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RequestKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$popularLinkStore$2 extends Lambda implements Function0<Store<Listing<? extends Link>, RequestKey>> {
    final /* synthetic */ RedditLinkRepository f19415a;

    RedditLinkRepository$popularLinkStore$2(RedditLinkRepository redditLinkRepository) {
        this.f19415a = redditLinkRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Listing<? extends Link>, RequestKey>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                RequestKey requestKey = (RequestKey) obj;
                Intrinsics.b(requestKey, "<name for destructuring parameter 0>");
                SortType sortType = requestKey.f10706a;
                SortTimeFrame sortTimeFrame = requestKey.f10707b;
                String str = requestKey.f10708c;
                String str2 = requestKey.f10709d;
                ListingViewMode listingViewMode = requestKey.f10710e;
                RemoteLinkDatasource d = this.f19415a.f16097h;
                if (sortType == null) {
                    Intrinsics.a();
                }
                return DefaultImpls.getPopularLinks$default(d, sortType, sortTimeFrame, str, str2, false, listingViewMode, 16, null);
            }
        };
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a().m8698a(0);
        a2.f10232a = TimeUnit.SECONDS;
        a2.f10233b = 0;
        a.f10250c = a2.m8699a();
        a.f10248a = new LinkPersister(new Function4<Listing<? extends Link>, SortType, SortTimeFrame, String, Single<Boolean>>(this.f19415a.f16099j) {
            public final KDeclarationContainer m20640a() {
                return Reflection.a(LocalLinkDataSource.class);
            }

            public final String m20641b() {
                return "savePopularLinks";
            }

            public final String m20642c() {
                return "savePopularLinks(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;)Lio/reactivex/Single;";
            }

            public final /* synthetic */ Object m20639a(Object obj, Object obj2, Object obj3, Object obj4) {
                Listing listing = (Listing) obj;
                SortType sortType = (SortType) obj2;
                SortTimeFrame sortTimeFrame = (SortTimeFrame) obj3;
                String str = (String) obj4;
                Intrinsics.b(listing, "p1");
                return ((LocalLinkDataSource) this.b).mo2966b(listing, sortType, sortTimeFrame, str);
            }
        }, new Function3<SortType, SortTimeFrame, String, Maybe<Listing<? extends Link>>>(this.f19415a.f16099j) {
            public final KDeclarationContainer m20644a() {
                return Reflection.a(LocalLinkDataSource.class);
            }

            public final String m20645b() {
                return "getPopularLinks";
            }

            public final String m20646c() {
                return "getPopularLinks(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;)Lio/reactivex/Maybe;";
            }

            public final /* synthetic */ Object m20643a(Object obj, Object obj2, Object obj3) {
                return ((LocalLinkDataSource) this.b).mo2965b((SortType) obj, (SortTimeFrame) obj2, (String) obj3);
            }
        });
        return a.m8706b();
    }
}
