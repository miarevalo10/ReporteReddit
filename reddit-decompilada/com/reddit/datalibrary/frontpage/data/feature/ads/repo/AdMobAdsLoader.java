package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import io.reactivex.ObservableEmitter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J1\u0010\u001a\u001a\u00020\u00192\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\b2\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00190\u001dH\u0001¢\u0006\u0002\b\u001eJ\u0019\u0010\u001f\u001a\u00020\u00192\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\bH\u0001¢\u0006\u0002\b J\r\u0010!\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\"R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\u00020\u00118@X\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdMobAdsLoader;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoader;", "context", "Landroid/content/Context;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsToFetch", "", "requestCounter", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lio/reactivex/ObservableEmitter;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;ILkotlin/jvm/functions/Function0;)V", "adLoader", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;", "adLoader$annotations", "()V", "getAdLoader$app_standardRelease", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;", "adLoader$delegate", "Lkotlin/Lazy;", "fetchNextAd", "", "loadImage", "nativeAd", "onSuccess", "Lkotlin/Function1;", "loadImage$app_standardRelease", "onAdReceived", "onAdReceived$app_standardRelease", "sendAnalyticsEvent", "sendAnalyticsEvent$app_standardRelease", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
public final class AdMobAdsLoader implements AdsLoader {
    static final /* synthetic */ KProperty[] f15762a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(AdMobAdsLoader.class), "adLoader", "getAdLoader$app_standardRelease()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;"))};
    final Context f15763b;
    final ObservableEmitter<NativeAdInfo<?>> f15764c;
    private final Lazy f15765d = LazyKt.a((Function0) new AdMobAdsLoader$adLoader$2(this));
    private final FrontpageSettings f15766e;
    private final AdContext f15767f;
    private int f15768g;
    private final Function0<Integer> f15769h;

    private RedditAdLoader m15856b() {
        return (RedditAdLoader) this.f15765d.b();
    }

    public AdMobAdsLoader(Context context, FrontpageSettings frontpageSettings, ObservableEmitter<NativeAdInfo<?>> observableEmitter, AdContext adContext, int i, Function0<Integer> function0) {
        Intrinsics.b(context, "context");
        Intrinsics.b(frontpageSettings, "settings");
        Intrinsics.b(observableEmitter, "emitter");
        Intrinsics.b(adContext, "adContext");
        Intrinsics.b(function0, "requestCounter");
        this.f15763b = context;
        this.f15766e = frontpageSettings;
        this.f15764c = observableEmitter;
        this.f15767f = adContext;
        this.f15768g = i;
        this.f15769h = function0;
    }

    public final void mo2917a() {
        int i = this.f15768g;
        this.f15768g = i - 1;
        if (i > 0) {
            if (!m15856b().m8816a().m4370a()) {
                RedditAdLoader b = m15856b();
                b.m8816a().m4368a(((Builder) b.f10349b.b()).m4392a("placement", String.valueOf(((Number) this.f15769h.invoke()).intValue())).m4393a());
                AppAnalytics.a(this.f15767f.f10323b);
                return;
            }
        }
        this.f15764c.aA_();
    }
}
