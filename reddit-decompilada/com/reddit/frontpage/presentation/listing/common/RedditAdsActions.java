package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.ads.NativeAppInstallAdInfoPresentationModel;
import com.reddit.datalibrary.frontpage.data.feature.ads.NativeContentAdInfoPresentationModel;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAppInstallAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeContentAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0002J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditAdsActions;", "Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "(Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;)V", "adConfig", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$AdsConfiguration;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration;", "getAdConfig", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$AdsConfiguration;", "adConfig$delegate", "Lkotlin/Lazy;", "adStableId", "", "ads", "", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "interval", "", "getInterval", "()I", "interval$delegate", "lastAdInsertionPosition", "Ljava/lang/Integer;", "startPosition", "getStartPosition", "startPosition$delegate", "unplacedAds", "attemptAdInsertion", "nativeAdInfo", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "(Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;Ljava/util/List;)Ljava/lang/Integer;", "destroyAds", "", "getNextAdInsertionIndex", "insertAds", "", "", "models", "nextBatchSize", "currentListingSize", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsActions.kt */
public final class RedditAdsActions implements AdsActions {
    static final /* synthetic */ KProperty[] f28274a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditAdsActions.class), "adConfig", "getAdConfig()Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$AdsConfiguration;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditAdsActions.class), "startPosition", "getStartPosition()I")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(RedditAdsActions.class), "interval", "getInterval()I"))};
    public static final Companion f28275b = new Companion();
    private final Lazy f28276c = LazyKt.m26777a((Function0) new RedditAdsActions$adConfig$2(this));
    private final Lazy f28277d = LazyKt.m26777a((Function0) new RedditAdsActions$startPosition$2(this));
    private final Lazy f28278e = LazyKt.m26777a((Function0) new RedditAdsActions$interval$2(this));
    private long f28279f = -5000;
    private final List<NativeAdInfo<?>> f28280g = ((List) new ArrayList());
    private Integer f28281h;
    private final List<NativeAdInfo<?>> f28282i = ((List) new ArrayList());
    private final FrontpageSettings f28283j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditAdsActions$Companion;", "", "()V", "EMPTY_LISTING_SIZE", "", "INITIAL_AD_ID", "", "LISTING_BATCH_SIZE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdsActions.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final int m29576b() {
        return ((Number) this.f28278e.mo5678b()).intValue();
    }

    public RedditAdsActions(FrontpageSettings frontpageSettings) {
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        this.f28283j = frontpageSettings;
    }

    public final int mo4840a(int i) {
        if (i == 0) {
            return 25;
        }
        i += 25;
        Integer num = this.f28281h;
        Object obj = null;
        i = Integer.valueOf((i - (num != null ? num.intValue() : 0)) - (this.f28282i.size() * m29576b()));
        if (((Number) i).intValue() > 0) {
            obj = 1;
        }
        if (obj == null) {
            i = 0;
        }
        if (i != 0) {
            return i.intValue();
        }
        return 25;
    }

    public final Set<Integer> mo4841a(List<? extends NativeAdInfo<?>> list, List<Listable> list2) {
        Intrinsics.m26847b(list, "ads");
        Intrinsics.m26847b(list2, "models");
        Set<Integer> linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        this.f28282i.addAll(list);
        int i = 0;
        for (NativeAdInfo nativeAdInfo : this.f28282i) {
            int intValue;
            Integer num;
            int i2 = i + 1;
            if (this.f28281h == null) {
                intValue = ((Number) this.f28277d.mo5678b()).intValue();
            } else {
                Integer num2 = this.f28281h;
                if (num2 == null) {
                    Intrinsics.m26842a();
                }
                intValue = num2.intValue() + m29576b();
            }
            if (intValue > CollectionsKt__CollectionsKt.m26787a((List) list2)) {
                num = null;
            } else {
                Object nativeContentAdInfoPresentationModel;
                this.f28280g.add(nativeAdInfo);
                long j = this.f28279f;
                this.f28279f = 1 + j;
                float a = nativeAdInfo.a();
                if (nativeAdInfo instanceof NativeContentAdInfo) {
                    nativeContentAdInfoPresentationModel = new NativeContentAdInfoPresentationModel(j, ((NativeContentAdInfo) nativeAdInfo).b, a);
                } else if (nativeAdInfo instanceof NativeAppInstallAdInfo) {
                    nativeContentAdInfoPresentationModel = new NativeAppInstallAdInfoPresentationModel(j, ((NativeAppInstallAdInfo) nativeAdInfo).b, a);
                } else {
                    list2 = new StringBuilder("Unsupported ad type ");
                    list2.append(Reflection.m26850a(nativeAdInfo.getClass()));
                    throw ((Throwable) new IllegalStateException(list2.toString()));
                }
                list2.add(intValue, nativeContentAdInfoPresentationModel);
                this.f28281h = Integer.valueOf(intValue);
                num = Integer.valueOf(intValue);
            }
            if (num != null) {
                linkedHashSet.add(Integer.valueOf(num.intValue()));
                arrayList.add(Integer.valueOf(i));
            }
            i = i2;
        }
        list = CollectionsKt___CollectionsKt.m41447l(arrayList).iterator();
        while (list.hasNext() != null) {
            this.f28282i.remove(((Number) list.next()).intValue());
        }
        return linkedHashSet;
    }

    public final void mo4842a() {
        this.f28279f = -5000;
        this.f28281h = null;
        List<NativeAdInfo> list = this.f28280g;
        for (NativeAdInfo c : list) {
            c.c();
        }
        list.clear();
        list = this.f28282i;
        for (NativeAdInfo c2 : list) {
            c2.c();
        }
        list.clear();
    }
}
