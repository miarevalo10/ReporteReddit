package com.reddit.datalibrary.frontpage.data.feature.region.repo;

import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.region.local.LocalRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.remote.RemoteRegionDataSource;
import com.reddit.datalibrary.frontpage.data.model.RemoteRegionDataModel;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/repo/RedditRegionRepository;", "Lcom/reddit/frontpage/domain/repository/RegionRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/region/remote/RemoteRegionDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/region/local/LocalRegionDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/region/remote/RemoteRegionDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/region/local/LocalRegionDataSource;)V", "store", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Region;", "", "getStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "store$delegate", "Lkotlin/Lazy;", "getRegions", "Lio/reactivex/Single;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditRegionRepository.kt */
public final class RedditRegionRepository implements RegionRepository {
    static final /* synthetic */ KProperty[] f16124a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditRegionRepository.class), "store", "getStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    public static final Companion f16125b = new Companion();
    private static final long f16126g = 1;
    private static final TimeUnit f16127h = TimeUnit.HOURS;
    private final Lazy f16128c = LazyKt.a((Function0) new RedditRegionRepository$store$2(this));
    private final BackgroundThread f16129d;
    private final RemoteRegionDataSource f16130e;
    private final LocalRegionDataSource f16131f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/repo/RedditRegionRepository$Companion;", "", "()V", "MEMORY_EXPIRE_DURATION", "", "getMEMORY_EXPIRE_DURATION", "()J", "MEMORY_EXPIRE_TIMEUNIT", "Ljava/util/concurrent/TimeUnit;", "getMEMORY_EXPIRE_TIMEUNIT", "()Ljava/util/concurrent/TimeUnit;", "mapRemoteToDomain", "", "Lcom/reddit/frontpage/domain/model/Region;", "remoteRegions", "", "", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteRegionDataModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditRegionRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public static List<Region> m9006a(Map<String, RemoteRegionDataModel> map) {
            if (map == null) {
                return CollectionsKt.a();
            }
            List<Region> arrayList = new ArrayList();
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                RemoteRegionDataModel remoteRegionDataModel = (RemoteRegionDataModel) entry.getValue();
                String name = remoteRegionDataModel.getName();
                String geoFilter = remoteRegionDataModel.getGeoFilter();
                Companion companion = RedditRegionRepository.f16125b;
                arrayList.add(new Region(str, name, m9006a(remoteRegionDataModel.getSubregions()), geoFilter));
            }
            return arrayList;
        }
    }

    public RedditRegionRepository(BackgroundThread backgroundThread, RemoteRegionDataSource remoteRegionDataSource, LocalRegionDataSource localRegionDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteRegionDataSource, "remote");
        Intrinsics.b(localRegionDataSource, "local");
        this.f16129d = backgroundThread;
        this.f16130e = remoteRegionDataSource;
        this.f16131f = localRegionDataSource;
    }

    public final Single<List<Region>> m16125a() {
        Single a = ((Store) this.f16128c.b()).mo2713a(Unit.a);
        Intrinsics.a(a, "store.get(Unit)");
        return SinglesKt.a(a, this.f16129d);
    }
}
