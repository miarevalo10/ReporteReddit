package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame.Companion;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.PathKey;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$linkListingStore$2 extends Lambda implements Function0<Store<Listing<? extends Link>, PathKey>> {
    final /* synthetic */ RedditLinkRepository f19414a;

    RedditLinkRepository$linkListingStore$2(RedditLinkRepository redditLinkRepository) {
        this.f19414a = redditLinkRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<Listing<? extends Link>, PathKey>() {
            public final /* synthetic */ Single mo2915a(Object obj) {
                SortTimeFrame a;
                PathKey pathKey = (PathKey) obj;
                Intrinsics.b(pathKey, "request");
                RemoteLinkDatasource d = this.f19414a.f16097h;
                String path = pathKey.getPath();
                String str = (String) pathKey.getParameters().get("sortTimeFrame");
                if (str != null) {
                    Companion companion = SortTimeFrame.f10397g;
                    a = Companion.m8825a(str);
                } else {
                    a = null;
                }
                return d.getLinkListing(path, a, (String) pathKey.getParameters().get("after"));
            }
        };
        a.f10248a = new LinkListingPersister(new Function2<Listing<? extends Link>, String, Single<Boolean>>(this.f19414a.f16098i) {
            public final KDeclarationContainer m20632a() {
                return Reflection.a(LocalLinkDataSource.class);
            }

            public final String m20633b() {
                return "saveLinkListing";
            }

            public final String m20634c() {
                return "saveLinkListing(Lcom/reddit/datalibrary/frontpage/data/model/Listing;Ljava/lang/String;)Lio/reactivex/Single;";
            }

            public final /* synthetic */ Object m20631a(Object obj, Object obj2) {
                Listing listing = (Listing) obj;
                String str = (String) obj2;
                Intrinsics.b(listing, "p1");
                Intrinsics.b(str, "p2");
                return ((LocalLinkDataSource) this.b).mo2961a(listing, str);
            }
        }, new Function1<String, Maybe<Listing<? extends Link>>>(this.f19414a.f16098i) {
            public final KDeclarationContainer m20636a() {
                return Reflection.a(LocalLinkDataSource.class);
            }

            public final String m20637b() {
                return "getLinkListing";
            }

            public final String m20638c() {
                return "getLinkListing(Ljava/lang/String;)Lio/reactivex/Maybe;";
            }

            public final /* synthetic */ Object m20635a(Object obj) {
                String str = (String) obj;
                Intrinsics.b(str, "p1");
                return ((LocalLinkDataSource) this.b).mo2957a(str);
            }
        });
        return a.m8706b();
    }
}
