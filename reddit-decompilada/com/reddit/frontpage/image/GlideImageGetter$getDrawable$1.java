package com.reddit.frontpage.image;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/image/GlideImageGetter$getDrawable$1", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/drawable/Drawable;", "(Lcom/reddit/frontpage/image/GlideImageGetter;ILcom/reddit/frontpage/image/GlideImageGetter$SwappableDrawable;)V", "onResourceReady", "", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GlideImageGetter.kt */
public final class GlideImageGetter$getDrawable$1 extends SimpleTarget<Drawable> {
    final /* synthetic */ GlideImageGetter f39061a;
    final /* synthetic */ int f39062b;
    final /* synthetic */ SwappableDrawable f39063c;

    GlideImageGetter$getDrawable$1(GlideImageGetter glideImageGetter, int i, SwappableDrawable swappableDrawable) {
        this.f39061a = glideImageGetter;
        this.f39062b = i;
        this.f39063c = swappableDrawable;
    }

    public final /* synthetic */ void m38899a(Object obj, Transition transition) {
        Drawable drawable = (Drawable) obj;
        Intrinsics.m26847b(drawable, "resource");
        drawable.setBounds(0, -6, this.f39062b, this.f39062b - 6);
        this.f39063c.setBounds(0, -6, this.f39062b, this.f39062b - 6);
        transition = this.f39063c;
        transition.f20309a = drawable;
        transition.invalidateSelf();
        this.f39061a.f20311b.setText(this.f39061a.f20311b.getText());
    }
}
