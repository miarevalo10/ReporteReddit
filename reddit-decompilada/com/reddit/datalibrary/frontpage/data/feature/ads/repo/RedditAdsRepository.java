package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdsRepository;", "Lcom/reddit/frontpage/domain/repository/AdsRepository;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "context", "Landroid/content/Context;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "adsLoaderFactory", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoaderFactory;", "(Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Landroid/content/Context;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoaderFactory;)V", "requestCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getBatchSize", "", "batchSize", "loadAdsBatch", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "restart", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
public final class RedditAdsRepository implements AdsRepository {
    public static final Companion f15783a = new Companion();
    private static final int f15784g = 1;
    private static final int f15785h = 0;
    private final AtomicInteger f15786b = new AtomicInteger(f15785h);
    private final FrontpageSettings f15787c;
    private final Context f15788d;
    private final BackgroundThread f15789e;
    private final AdsLoaderFactory f15790f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdsRepository$Companion;", "", "()V", "DEFAULT_BATCH_SIZE", "", "getDEFAULT_BATCH_SIZE", "()I", "REQUEST_COUNT_INITIAL_VALUE", "getREQUEST_COUNT_INITIAL_VALUE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAdsRepository.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Inject
    public RedditAdsRepository(FrontpageSettings frontpageSettings, Context context, BackgroundThread backgroundThread, AdsLoaderFactory adsLoaderFactory) {
        Intrinsics.b(frontpageSettings, "settings");
        Intrinsics.b(context, "context");
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(adsLoaderFactory, "adsLoaderFactory");
        this.f15787c = frontpageSettings;
        this.f15788d = context;
        this.f15789e = backgroundThread;
        this.f15790f = adsLoaderFactory;
    }

    public final Observable<NativeAdInfo<?>> m15886a(AdContext adContext, int i) {
        Intrinsics.b(adContext, "adContext");
        adContext = Observable.create(new RedditAdsRepository$loadAdsBatch$observable$1(this, adContext, i));
        Intrinsics.a(adContext, "observable");
        return ObservablesKt.a(adContext, (Thread) this.f15789e);
    }

    public final void m15887a() {
        this.f15786b.set(f15785h);
    }

    public static final /* synthetic */ int m15879a(RedditAdsRepository redditAdsRepository, int i) {
        redditAdsRepository = redditAdsRepository.f15787c.m9059t();
        Intrinsics.a(redditAdsRepository, "settings.appConfig");
        redditAdsRepository = redditAdsRepository.m9367a();
        Intrinsics.a(redditAdsRepository, "adsConfig");
        Timber.b("Ads batch size: %d", new Object[]{Integer.valueOf(Math.max(i / redditAdsRepository.m9356c(), f15784g))});
        return Math.max(i / redditAdsRepository.m9356c(), f15784g);
    }
}
