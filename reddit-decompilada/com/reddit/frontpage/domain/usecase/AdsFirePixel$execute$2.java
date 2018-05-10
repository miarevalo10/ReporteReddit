package com.reddit.frontpage.domain.usecase;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/reddit/frontpage/domain/usecase/AdsFirePixel$execute$2", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Lcom/bumptech/glide/load/resource/gif/GifDrawable;", "(Lcom/reddit/frontpage/domain/usecase/AdsPixelParams;)V", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsFirePixel.kt */
public final class AdsFirePixel$execute$2 extends SimpleTarget<GifDrawable> {
    final /* synthetic */ AdsPixelParams f39060a;

    public AdsFirePixel$execute$2(AdsPixelParams adsPixelParams) {
        this.f39060a = adsPixelParams;
    }

    public final /* synthetic */ void m38897a(Object obj, Transition transition) {
        Intrinsics.m26847b((GifDrawable) obj, "resource");
        obj = new StringBuilder("Ad pixel successful: ");
        obj.append(this.f39060a.mo6432a());
        Timber.a(obj.toString(), new Object[null]);
    }

    public final void m38898c(Drawable drawable) {
        drawable = new StringBuilder("Ad pixel failed: ");
        drawable.append(this.f39060a.mo6432a());
        Timber.e(drawable.toString(), new Object[0]);
    }
}
