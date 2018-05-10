package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
final class AdMobAdsLoader$onAdReceived$1 extends Lambda implements Function1<NativeAdInfo<?>, Unit> {
    final /* synthetic */ AdMobAdsLoader f19345a;
    final /* synthetic */ NativeAdInfo f19346b;

    AdMobAdsLoader$onAdReceived$1(AdMobAdsLoader adMobAdsLoader, NativeAdInfo nativeAdInfo) {
        this.f19345a = adMobAdsLoader;
        this.f19346b = nativeAdInfo;
        super(1);
    }

    public final /* synthetic */ Object m20617a(Object obj) {
        Intrinsics.b((NativeAdInfo) obj, "it");
        this.f19345a.f15764c.a(this.f19346b);
        this.f19345a.mo2917a();
        return Unit.a;
    }
}
