package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.bumptech.glide.request.target.Target;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.reddit.config.GlideApp;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
final class AdMobAdsLoader$adLoader$2 extends Lambda implements Function0<RedditAdLoader> {
    final /* synthetic */ AdMobAdsLoader f19344a;

    AdMobAdsLoader$adLoader$2(AdMobAdsLoader adMobAdsLoader) {
        this.f19344a = adMobAdsLoader;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new RedditAdLoader(this.f19344a.f15763b, this.f19344a.f15766e, this.f19344a.f15767f, new Function1<NativeAdInfo<?>, Unit>(this.f19344a) {
            public final KDeclarationContainer m20610a() {
                return Reflection.a(AdMobAdsLoader.class);
            }

            public final String m20611b() {
                return "onAdReceived";
            }

            public final String m20612c() {
                return "onAdReceived$app_standardRelease(Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;)V";
            }

            public final /* synthetic */ Object m20609a(Object obj) {
                NativeAdInfo nativeAdInfo = (NativeAdInfo) obj;
                Intrinsics.b(nativeAdInfo, "p1");
                AdMobAdsLoader adMobAdsLoader = (AdMobAdsLoader) this.b;
                Intrinsics.b(nativeAdInfo, "nativeAd");
                if ((nativeAdInfo.mo2922b().isEmpty() ^ 1) != 0) {
                    Function1 adMobAdsLoader$onAdReceived$1 = new AdMobAdsLoader$onAdReceived$1(adMobAdsLoader, nativeAdInfo);
                    Intrinsics.b(nativeAdInfo, "nativeAd");
                    Intrinsics.b(adMobAdsLoader$onAdReceived$1, "onSuccess");
                    GlideApp.m8727a(adMobAdsLoader.f15763b).m19651h().load(((Image) CollectionsKt.d(nativeAdInfo.mo2922b())).mo2095b()).into((Target) new AdMobAdsLoader$loadImage$1(nativeAdInfo, adMobAdsLoader$onAdReceived$1));
                } else {
                    adMobAdsLoader.f15764c.a(nativeAdInfo);
                    adMobAdsLoader.mo2917a();
                }
                return Unit.a;
            }
        }, new Function1<Throwable, Unit>(this.f19344a.f15764c) {
            public final KDeclarationContainer m20614a() {
                return Reflection.a(ObservableEmitter.class);
            }

            public final String m20615b() {
                return "onError";
            }

            public final String m20616c() {
                return "onError(Ljava/lang/Throwable;)V";
            }

            public final /* synthetic */ Object m20613a(Object obj) {
                Throwable th = (Throwable) obj;
                Intrinsics.b(th, "p1");
                ((ObservableEmitter) this.b).a(th);
                return Unit.a;
            }
        });
    }
}
