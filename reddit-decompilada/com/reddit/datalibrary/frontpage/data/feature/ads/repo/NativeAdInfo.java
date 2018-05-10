package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u0016*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\u0016J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "T", "Lcom/google/android/gms/ads/formats/NativeAd;", "", "aspectRatio", "", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "images", "", "Lcom/google/android/gms/ads/formats/NativeAd$Image;", "getImages", "()Ljava/util/List;", "nativeAd", "getNativeAd", "()Lcom/google/android/gms/ads/formats/NativeAd;", "destroy", "", "hasVideo", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
public interface NativeAdInfo<T extends NativeAd> {
    public static final Companion f10345a = Companion.f10343a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo$Companion;", "", "()V", "DEFAULT_ASPECT_RATIO", "", "getDEFAULT_ASPECT_RATIO", "()F", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditAdsRepository.kt */
    public static final class Companion {
        static final /* synthetic */ Companion f10343a = new Companion();
        private static final float f10344b = -1.0f;

        private Companion() {
        }

        public static float m8805a() {
            return f10344b;
        }
    }

    float mo2920a();

    void mo2921a(float f);

    List<Image> mo2922b();

    void mo2923c();
}
