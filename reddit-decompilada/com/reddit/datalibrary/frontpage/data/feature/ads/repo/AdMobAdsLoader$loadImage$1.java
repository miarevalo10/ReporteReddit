package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.graphics.Bitmap;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/datalibrary/frontpage/data/feature/ads/repo/AdMobAdsLoader$loadImage$1", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "(Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;Lkotlin/jvm/functions/Function1;)V", "onResourceReady", "", "resource", "glideAnimation", "Lcom/bumptech/glide/request/transition/Transition;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
public final class AdMobAdsLoader$loadImage$1 extends SimpleTarget<Bitmap> {
    final /* synthetic */ NativeAdInfo f19767a;
    final /* synthetic */ Function1 f19768b;

    AdMobAdsLoader$loadImage$1(NativeAdInfo nativeAdInfo, Function1 function1) {
        this.f19767a = nativeAdInfo;
        this.f19768b = function1;
    }

    public final /* synthetic */ void mo3858a(Object obj, Transition transition) {
        Bitmap bitmap = (Bitmap) obj;
        Intrinsics.b(bitmap, "resource");
        this.f19767a.mo2921a(((float) bitmap.getWidth()) / ((float) bitmap.getHeight()));
        this.f19768b.a(this.f19767a);
    }
}
