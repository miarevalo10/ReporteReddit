package com.reddit.frontpage.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001\"\n\b\u0001\u0010\u0005 \u0000*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "kotlin.jvm.PlatformType", "T", "P", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "it", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdsUseCase.kt */
final class AdsUseCase$getAds$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ AdsUseCase f27965a;
    final /* synthetic */ AdsParams f27966b;

    AdsUseCase$getAds$2(AdsUseCase adsUseCase, AdsParams adsParams) {
        this.f27965a = adsUseCase;
        this.f27966b = adsParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Boolean bool = (Boolean) obj;
        Intrinsics.m26847b(bool, "it");
        if (bool.booleanValue() != null) {
            return this.f27965a.f20271c.m22402a(this.f27966b.mo6430a(), this.f27966b.mo6431b());
        }
        return Observable.empty();
    }
}
