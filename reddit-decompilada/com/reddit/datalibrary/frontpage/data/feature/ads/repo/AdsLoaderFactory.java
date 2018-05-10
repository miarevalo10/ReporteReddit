package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoaderFactory;", "", "()V", "createAdMobLoader", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoader;", "context", "Landroid/content/Context;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsToFetch", "", "requestCounter", "Lkotlin/Function0;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsLoader.kt */
public final class AdsLoaderFactory {
    public static final AdsLoaderFactory f10326a = new AdsLoaderFactory();

    private AdsLoaderFactory() {
    }

    public static AdsLoader m8788a(Context context, FrontpageSettings frontpageSettings, ObservableEmitter<NativeAdInfo<?>> observableEmitter, AdContext adContext, int i, Function0<Integer> function0) {
        Intrinsics.b(context, "context");
        Intrinsics.b(frontpageSettings, "settings");
        Intrinsics.b(observableEmitter, "emitter");
        Intrinsics.b(adContext, "adContext");
        Intrinsics.b(function0, "requestCounter");
        return new AdMobAdsLoader(context, frontpageSettings, observableEmitter, adContext, i, function0);
    }
}
