package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
final class RedditAdsRepository$loadAdsBatch$observable$1<T> implements ObservableOnSubscribe<T> {
    final /* synthetic */ RedditAdsRepository f15780a;
    final /* synthetic */ AdContext f15781b;
    final /* synthetic */ int f15782c;

    RedditAdsRepository$loadAdsBatch$observable$1(RedditAdsRepository redditAdsRepository, AdContext adContext, int i) {
        this.f15780a = redditAdsRepository;
        this.f15781b = adContext;
        this.f15782c = i;
    }

    public final void m15878a(ObservableEmitter<NativeAdInfo<?>> observableEmitter) {
        Intrinsics.b(observableEmitter, "emitter");
        this.f15780a.f15790f;
        AdsLoaderFactory.m8788a(this.f15780a.f15788d, this.f15780a.f15787c, observableEmitter, this.f15781b, RedditAdsRepository.m15879a(this.f15780a, this.f15782c), new RedditAdsRepository$loadAdsBatch$observable$1$loader$1(this.f15780a.f15786b)).mo2917a();
    }
}
