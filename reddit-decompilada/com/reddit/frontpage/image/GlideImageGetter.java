package com.reddit.frontpage.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import android.widget.TextView;
import com.reddit.config.GlideApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/image/GlideImageGetter;", "Landroid/text/Html$ImageGetter;", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "source", "", "getImageSize", "", "Companion", "SwappableDrawable", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GlideImageGetter.kt */
public final class GlideImageGetter implements ImageGetter {
    public static final Companion f20310a = new Companion();
    private final TextView f20311b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/image/GlideImageGetter$Companion;", "", "()V", "EMOJI_SIZE_MULTIPLIER", "", "SIZE_OFFSET", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GlideImageGetter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R(\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/image/GlideImageGetter$SwappableDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "value", "innerDrawable", "getInnerDrawable", "()Landroid/graphics/drawable/Drawable;", "setInnerDrawable", "(Landroid/graphics/drawable/Drawable;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GlideImageGetter.kt */
    private static final class SwappableDrawable extends Drawable {
        Drawable f20309a;

        public final void draw(Canvas canvas) {
            Drawable drawable = this.f20309a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        public final void setAlpha(int i) {
            Drawable drawable = this.f20309a;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }

        public final int getOpacity() {
            Drawable drawable = this.f20309a;
            return drawable != null ? drawable.getOpacity() : -3;
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.f20309a;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }

        public final int getIntrinsicWidth() {
            Drawable drawable = this.f20309a;
            return drawable != null ? drawable.getIntrinsicWidth() : super.getIntrinsicWidth();
        }

        public final int getIntrinsicHeight() {
            Drawable drawable = this.f20309a;
            return drawable != null ? drawable.getIntrinsicHeight() : super.getIntrinsicHeight();
        }
    }

    public GlideImageGetter(TextView textView) {
        Intrinsics.m26847b(textView, "textView");
        this.f20311b = textView;
    }

    public final Drawable getDrawable(String str) {
        SwappableDrawable swappableDrawable = new SwappableDrawable();
        GlideApp.a(this.f20311b.getContext()).b(str).into(new GlideImageGetter$getDrawable$1(this, (int) (((double) this.f20311b.getTextSize()) * 1.5d), swappableDrawable));
        return swappableDrawable;
    }
}
