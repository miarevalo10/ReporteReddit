package com.reddit.datalibrary.frontpage.data.feature.region.repo;

import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.RecordState;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy;
import com.nytimes.android.external.store3.base.impl.MemoryPolicy.MemoryPolicyBuilder;
import com.nytimes.android.external.store3.base.impl.RealStoreBuilder;
import com.nytimes.android.external.store3.base.impl.StalePolicy;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.reddit.datalibrary.frontpage.data.feature.region.repo.RedditRegionRepository.Companion;
import com.reddit.frontpage.domain.model.Region;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Region;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditRegionRepository.kt */
final class RedditRegionRepository$store$2 extends Lambda implements Function0<Store<List<? extends Region>, Unit>> {
    final /* synthetic */ RedditRegionRepository f19418a;

    RedditRegionRepository$store$2(RedditRegionRepository redditRegionRepository) {
        this.f19418a = redditRegionRepository;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        RealStoreBuilder a = StoreBuilder.m8709a();
        a.f10249b = new Fetcher<List<? extends Region>, Unit>() {

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Region;", "it", "", "", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteRegionDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
            /* compiled from: RedditRegionRepository.kt */
            static final class C15121<T, R> implements Function<T, R> {
                public static final C15121 f16122a = new C15121();

                C15121() {
                }

                public final /* synthetic */ Object apply(Object obj) {
                    Map map = (Map) obj;
                    Intrinsics.b(map, "it");
                    Companion companion = RedditRegionRepository.f16125b;
                    return Companion.m9006a(map);
                }
            }

            public final /* synthetic */ Single mo2915a(Object obj) {
                Intrinsics.b((Unit) obj, "it");
                return this.f19418a.f16130e.getRegions().map(C15121.f16122a);
            }
        };
        a.f10248a = new Object() {
            public final /* synthetic */ Maybe mo2708a(Object obj) {
                Intrinsics.b((Unit) obj, "key");
                return this.f19418a.f16131f.mo2976a();
            }

            public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
                List list = (List) obj2;
                Intrinsics.b((Unit) obj, "key");
                Intrinsics.b(list, "raw");
                return this.f19418a.f16131f.mo2977a(list);
            }

            public final /* bridge */ /* synthetic */ RecordState mo3787b(Object obj) {
                Intrinsics.b((Unit) obj, "key");
                return RecordState.STALE;
            }
        };
        MemoryPolicyBuilder a2 = MemoryPolicy.m8700a();
        Companion companion = RedditRegionRepository.f16125b;
        a2 = a2.m8698a(RedditRegionRepository.f16126g);
        companion = RedditRegionRepository.f16125b;
        a2.f10232a = RedditRegionRepository.f16127h;
        a.f10250c = a2.m8699a();
        a.f10251d = StalePolicy.REFRESH_ON_STALE;
        return a.m8706b();
    }
}
