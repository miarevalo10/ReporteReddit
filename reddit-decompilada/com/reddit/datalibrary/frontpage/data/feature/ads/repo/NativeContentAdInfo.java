package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeContentAdInfo;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "Lcom/google/android/gms/ads/formats/NativeContentAd;", "nativeAd", "aspectRatio", "", "(Lcom/google/android/gms/ads/formats/NativeContentAd;F)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "images", "", "Lcom/google/android/gms/ads/formats/NativeAd$Image;", "getImages", "()Ljava/util/List;", "getNativeAd", "()Lcom/google/android/gms/ads/formats/NativeContentAd;", "destroy", "", "hasVideo", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
public final class NativeContentAdInfo implements NativeAdInfo<NativeContentAd> {
    public final NativeContentAd f15775b;
    private float f15776c;

    private NativeContentAdInfo(NativeContentAd nativeContentAd, float f) {
        Intrinsics.b(nativeContentAd, "nativeAd");
        this.f15775b = nativeContentAd;
        this.f15776c = f;
    }

    public final float mo2920a() {
        return this.f15776c;
    }

    public final void mo2921a(float f) {
        this.f15776c = f;
    }

    public final List<Image> mo2922b() {
        List<Image> c = this.f15775b.mo3558c();
        Intrinsics.a(c, "nativeAd.images");
        return c;
    }

    public final void mo2923c() {
        this.f15775b.mo3564i();
    }
}
