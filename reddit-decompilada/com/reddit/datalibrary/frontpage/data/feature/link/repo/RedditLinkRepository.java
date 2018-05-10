package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import android.annotation.SuppressLint;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.UserLinkKey;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource.DefaultImpls;
import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.PathKey;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Result;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.common.ui.Features;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.MaybesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\u0018\u0000 a2\u00020\u0001:\u0002abB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016J \u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J$\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/0.2\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020\"H\u0016J(\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J(\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J*\u00108\u001a\b\u0012\u0004\u0012\u0002090.2\u0006\u0010:\u001a\u00020\"2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0<H\u0016JN\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\f0.2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010?\u001a\u0004\u0018\u00010\"2\b\u0010@\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u00020,2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J8\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.2\u0006\u0010E\u001a\u00020\"2\u0006\u00103\u001a\u00020F2\b\u0010?\u001a\u0004\u0018\u00010\"2\b\u0010G\u001a\u0004\u0018\u00010\"H\u0017J8\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.2\u0006\u0010:\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u0001062\b\u0010?\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u00020,H\u0016J8\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0J0.2\u0006\u0010:\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u0001062\b\u0010?\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u00020,H\u0016J\"\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\"0JH\u0016JL\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010?\u001a\u0004\u0018\u00010\"2\b\u0010@\u001a\u0004\u0018\u00010\"2\u0006\u0010A\u001a\u00020,2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0014\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.H\u0002J&\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0.2\u0006\u0010E\u001a\u00020\"2\b\u0010?\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010P\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016J\u0010\u0010Q\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010R\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010T\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\r\u0010U\u001a\u00020,H\u0001¢\u0006\u0002\bVJ\u0010\u0010W\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010X\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010Y\u001a\u00020,H\u0016J\u0010\u0010Z\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016J\u0010\u0010[\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010\\\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010]\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016J\u0010\u0010^\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010_\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010`\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R-\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R-\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00140\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00180\u000b8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u001c0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0010¨\u0006c"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RedditLinkRepository;", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/RemoteLinkDatasource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "localDb", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/RemoteLinkDatasource;Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;)V", "historyLinkStore", "Lcom/nytimes/android/external/store3/base/impl/Store;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/HistoryKey;", "getHistoryLinkStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "historyLinkStore$delegate", "Lkotlin/Lazy;", "linkListingStore", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "getLinkListingStore", "linkListingStore$delegate", "popularLinkStore", "Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RequestKey;", "getPopularLinkStore", "popularLinkStore$delegate", "submittedStore", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/UserLinkKey;", "getSubmittedStore", "submittedStore$delegate", "approve", "Lio/reactivex/Completable;", "id", "", "clearRecentHistory", "linkIds", "", "delete", "linkId", "distinguish", "how", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "sticky", "", "edit", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result;", "text", "getAllLocalFrontpageLinks", "Lio/reactivex/Maybe;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getAllLocalPopularLinks", "getDiscoveryUnitListing", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "path", "parameters", "", "getFrontpage", "Lcom/reddit/frontpage/domain/model/ILink;", "after", "adDistance", "refresh", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getHistory", "username", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "recentIds", "getLinkListing", "getLinks", "", "getLinksByIds", "ids", "getPopular", "getReadLinks", "getSubmitted", "hide", "lockComments", "markLinkAsRead", "markNsfw", "markSpoiler", "mvpEnabled", "mvpEnabled$app_standardRelease", "pinAnnouncement", "remove", "isSpam", "save", "unMarkNsfw", "unMarkSpoiler", "unhide", "unlockComments", "unpinAnnouncement", "unsave", "Companion", "LinkListingPersister", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
public final class RedditLinkRepository implements LinkRepository {
    static final /* synthetic */ KProperty[] f16087a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLinkRepository.class), "submittedStore", "getSubmittedStore()Lcom/nytimes/android/external/store3/base/impl/Store;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLinkRepository.class), "popularLinkStore", "getPopularLinkStore()Lcom/nytimes/android/external/store3/base/impl/Store;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLinkRepository.class), "historyLinkStore", "getHistoryLinkStore()Lcom/nytimes/android/external/store3/base/impl/Store;")), Reflection.a(new PropertyReference1Impl(Reflection.a(RedditLinkRepository.class), "linkListingStore", "getLinkListingStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    public static final Companion f16088b = new Companion();
    private static final SortType f16089k = SortType.f15833f;
    private static final Pair<Long, TimeUnit> f16090l = TuplesKt.a(Long.valueOf(10), TimeUnit.SECONDS);
    private static final Pair<Long, TimeUnit> f16091m = TuplesKt.a(Long.valueOf(60), TimeUnit.SECONDS);
    private final Lazy f16092c = LazyKt.a((Function0) new RedditLinkRepository$submittedStore$2(this));
    private final Lazy f16093d = LazyKt.a((Function0) new RedditLinkRepository$popularLinkStore$2(this));
    private final Lazy f16094e = LazyKt.a((Function0) new RedditLinkRepository$historyLinkStore$2(this));
    private final Lazy f16095f = LazyKt.a((Function0) new RedditLinkRepository$linkListingStore$2(this));
    private final BackgroundThread f16096g;
    private final RemoteLinkDatasource f16097h;
    private final LocalLinkDataSource f16098i;
    private final LocalLinkDataSource f16099j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\f8\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RedditLinkRepository$Companion;", "", "()V", "CACHE_EXPIRE_AFTER", "", "CACHE_MEMORY_SIZE", "HISTORY_DURATION_TO_TIMEUNIT", "Lkotlin/Pair;", "Ljava/util/concurrent/TimeUnit;", "getHISTORY_DURATION_TO_TIMEUNIT", "()Lkotlin/Pair;", "KEY_AFTER", "", "KEY_AFTER$annotations", "KEY_SORT_TIME_FRAME", "KEY_SORT_TIME_FRAME$annotations", "SUBMITTED_DEFAULT_SORT", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "SUBMITTED_DEFAULT_SORT$annotations", "getSUBMITTED_DEFAULT_SORT", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "SUBMITTED_DURATION_TO_TIMEUNIT", "getSUBMITTED_DURATION_TO_TIMEUNIT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLinkRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SortType m8993a() {
            return RedditLinkRepository.f16089k;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001Bx\u0012B\u0010\u0005\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006\u0012-\u0010\u000e\u001a)\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R5\u0010\u000e\u001a)\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000RJ\u0010\u0005\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RedditLinkRepository$LinkListingPersister;", "Lcom/nytimes/android/external/store3/base/Persister;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/datalibrary/frontpage/data/model/PathKey;", "persist", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "links", "", "key", "Lio/reactivex/Single;", "", "fetch", "Lkotlin/Function1;", "Lio/reactivex/Maybe;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "keyToString", "read", "write", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditLinkRepository.kt */
    private static final class LinkListingPersister implements Persister<Listing<? extends Link>, PathKey> {
        private final Function2<Listing<Link>, String, Single<Boolean>> f18702a;
        private final Function1<String, Maybe<Listing<Link>>> f18703b;

        public LinkListingPersister(Function2<? super Listing<Link>, ? super String, ? extends Single<Boolean>> function2, Function1<? super String, ? extends Maybe<Listing<Link>>> function1) {
            Intrinsics.b(function2, "persist");
            Intrinsics.b(function1, "fetch");
            this.f18702a = function2;
            this.f18703b = function1;
        }

        public final /* synthetic */ Maybe mo2708a(Object obj) {
            PathKey pathKey = (PathKey) obj;
            Intrinsics.b(pathKey, "key");
            return (Maybe) this.f18703b.a(m19679a(pathKey));
        }

        public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
            PathKey pathKey = (PathKey) obj;
            Listing listing = (Listing) obj2;
            Intrinsics.b(pathKey, "key");
            Intrinsics.b(listing, "links");
            return (Single) this.f18702a.a(listing, m19679a(pathKey));
        }

        private static String m19679a(PathKey pathKey) {
            String a = CollectionsKt.a(MapsKt.a(pathKey.getParameters()).entrySet(), "&", null, null, 0, null, RedditLinkRepository$LinkListingPersister$keyToString$params$1.f19406a, 30);
            if ((StringsKt.a(a) ^ 1) == 0) {
                return pathKey.getPath();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pathKey.getPath());
            stringBuilder.append('?');
            stringBuilder.append(a);
            return stringBuilder.toString();
        }
    }

    public RedditLinkRepository(BackgroundThread backgroundThread, RemoteLinkDatasource remoteLinkDatasource, LocalLinkDataSource localLinkDataSource, LocalLinkDataSource localLinkDataSource2) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteLinkDatasource, "remote");
        Intrinsics.b(localLinkDataSource, "local");
        Intrinsics.b(localLinkDataSource2, "localDb");
        this.f16096g = backgroundThread;
        this.f16097h = remoteLinkDatasource;
        this.f16098i = localLinkDataSource;
        this.f16099j = localLinkDataSource2;
    }

    public final Single<Listing<Link>> m16046a(String str, String str2) {
        Intrinsics.b(str, "username");
        str = ((Store) this.f16092c.b()).mo2713a(new UserLinkKey(str, Companion.m8993a(), str2));
        Intrinsics.a(str, "submittedStore.get(linkKey)");
        return SinglesKt.a(str, (Thread) this.f16096g);
    }

    public final Single<Listing<ILink>> m16044a(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode) {
        SortType sortType2 = sortType;
        SortTimeFrame sortTimeFrame2 = sortTimeFrame;
        String str3 = str;
        Maybe map = this.f16099j.mo2956a(sortType2, sortTimeFrame2, str3).map(RedditLinkRepository$getFrontpage$local$1.f16072a);
        Maybe maybe = map;
        Single doOnError = DefaultImpls.getFrontpageLinks$default(this.f16097h, sortType2, sortTimeFrame2, str3, str2, false, listingViewMode, 16, null).flatMap(new RedditLinkRepository$getFrontpage$remote$1(this, sortType2, sortTimeFrame2, str3, map)).doOnError(RedditLinkRepository$getFrontpage$remote$2.f16082a);
        if (!z) {
            doOnError = maybe.concatWith(doOnError.toMaybe()).firstOrError();
        }
        Intrinsics.a(doOnError, "if (refresh) {\n         ….firstOrError()\n        }");
        return SinglesKt.a(doOnError, r6.f16096g);
    }

    public final Single<Listing<Link>> m16051b(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode) {
        Intrinsics.b(sortType, "sort");
        sortType = new RedditLinkRepository$getPopular$1(this, z, new RequestKey(sortType, sortTimeFrame, str, str2, listingViewMode)).m20630a();
        Intrinsics.a(sortType, "fetchFunction()");
        return SinglesKt.a(sortType, (Thread) this.f16096g);
    }

    @SuppressLint({"VisibleForTests"})
    public final Single<Listing<Link>> m16045a(String str, HistorySortType historySortType, String str2, String str3) {
        Intrinsics.b(str, "username");
        Intrinsics.b(historySortType, "sort");
        if (Intrinsics.a(historySortType, HistorySortType.a)) {
            Object obj = null;
            Object obj2 = (Features.b() && Features.a()) ? 1 : null;
            if (obj2 == null) {
                CharSequence charSequence = str3;
                if (charSequence == null || charSequence.length() == null) {
                    obj = 1;
                }
                if (obj != null) {
                    str = Single.just(new Listing(CollectionsKt.a(), null, null, null, 8, null));
                    Intrinsics.a(str, "Single.just(Listing(chil…r = null, before = null))");
                    return str;
                }
                str = this.f16097h;
                if (str3 == null) {
                    Intrinsics.a();
                }
                return SinglesKt.a(str.getLinksByIds(str3), (Thread) this.f16096g);
            }
        }
        str = ((Store) this.f16094e.b()).mo2713a(new HistoryKey(str, historySortType, str2));
        Intrinsics.a(str, "historyLinkStore.get(requestKey)");
        return SinglesKt.a(str, (Thread) this.f16096g);
    }

    public final Completable m16039a(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modMarkNsfw(str), this.f16096g);
    }

    public final Completable m16049b(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modUnMarkNsfw(str), this.f16096g);
    }

    public final Completable m16053c(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modMarkSpoiler(str), this.f16096g);
    }

    public final Completable m16054d(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modUnMarkSpoiler(str), this.f16096g);
    }

    public final Completable m16055e(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modLockComments(str), this.f16096g);
    }

    public final Completable m16056f(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modUnlockComments(str), this.f16096g);
    }

    public final Completable m16040a(String str, DistinguishType distinguishType, boolean z) {
        Intrinsics.b(str, "id");
        Intrinsics.b(distinguishType, "how");
        return CompletablesKt.a(this.f16097h.modDistinguish(str, distinguishType, z), (Thread) this.f16096g);
    }

    public final Completable m16057g(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.setSubredditSticky(str, true), this.f16096g);
    }

    public final Completable m16058h(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.setSubredditSticky(str, false), this.f16096g);
    }

    public final Completable m16041a(String str, boolean z) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modRemove(str, z), (Thread) this.f16096g);
    }

    public final Completable m16059i(String str) {
        Intrinsics.b(str, "id");
        return CompletablesKt.a(this.f16097h.modApprove(str), this.f16096g);
    }

    public final Single<Listing<Link>> m16047a(String str, String str2, boolean z) {
        Intrinsics.b(str, "path");
        Map linkedHashMap = new LinkedHashMap();
        if (str2 != null) {
            linkedHashMap.put("after", str2);
        }
        str = new RedditLinkRepository$getLinkListing$3(this, z, new PathKey(str, linkedHashMap)).m20629a();
        Intrinsics.a(str, "retrieve()");
        return SinglesKt.a(str, (Thread) this.f16096g);
    }

    public final Single<DiscoveryUnitListingDataModel> m16048a(String str, Map<String, String> map) {
        Intrinsics.b(str, "path");
        Intrinsics.b(map, "parameters");
        return SinglesKt.a(DefaultImpls.getDiscoveryUnitListing$default(this.f16097h, str, map, 0, 4, null), (Thread) this.f16096g);
    }

    public final Maybe<Listing<Link>> m16043a(SortType sortType, SortTimeFrame sortTimeFrame) {
        return MaybesKt.a(this.f16099j.mo2955a(sortType, sortTimeFrame), (Thread) this.f16096g);
    }

    public final Maybe<Listing<Link>> m16050b(SortType sortType, SortTimeFrame sortTimeFrame) {
        return MaybesKt.a(this.f16099j.mo2964b(sortType, sortTimeFrame), (Thread) this.f16096g);
    }

    public final Completable m16060j(String str) {
        Intrinsics.b(str, "linkId");
        return CompletablesKt.a(this.f16099j.mo2963b(str), this.f16096g);
    }

    public final Completable m16042a(Collection<String> collection) {
        Intrinsics.b(collection, "linkIds");
        return CompletablesKt.a(this.f16099j.mo2954a((Iterable) collection), this.f16096g);
    }

    public final Completable m16061k(String str) {
        Intrinsics.b(str, "linkId");
        return CompletablesKt.a(this.f16099j.mo2967c(str), this.f16096g);
    }

    public final Completable m16062l(String str) {
        Intrinsics.b(str, "linkId");
        return CompletablesKt.a(this.f16099j.mo2968d(str), this.f16096g);
    }

    public final Single<Result<Link>> m16052b(String str, String str2) {
        Intrinsics.b(str, "linkId");
        Intrinsics.b(str2, "text");
        RemoteLinkDatasource remoteLinkDatasource = this.f16097h;
        ThingUtil thingUtil = ThingUtil.f10274a;
        str = DefaultImpls.edit$default(remoteLinkDatasource, ThingUtil.m8721b(str, ThingType.f10269c), str2, null, 4, null).flatMap(new RedditLinkRepository$edit$1(this, str));
        Intrinsics.a(str, "remote.edit(\n           …}\n            }\n        }");
        return SinglesKt.a(str, (Thread) this.f16096g);
    }

    public final Completable m16063m(String str) {
        Intrinsics.b(str, "linkId");
        return CompletablesKt.a(this.f16099j.mo2970f(str), this.f16096g);
    }
}
