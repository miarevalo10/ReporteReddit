package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TweetImageView extends ImageView {
    Overlay f24248a = new Overlay(null);

    protected static class Overlay {
        final Drawable f24247a;

        Overlay(Drawable drawable) {
            this.f24247a = drawable;
        }

        protected final void m25967a(int i, int i2) {
            if (this.f24247a != null) {
                this.f24247a.setBounds(0, 0, i, i2);
            }
        }

        protected final void m25968a(int[] iArr) {
            if (this.f24247a != null && this.f24247a.isStateful()) {
                this.f24247a.setState(iArr);
            }
        }
    }

    public TweetImageView(Context context) {
        super(context);
    }

    public TweetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Overlay overlay = this.f24248a;
        if (overlay.f24247a != null) {
            overlay.f24247a.draw(canvas);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f24248a.m25968a(getDrawableState());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f24248a.m25967a(getMeasuredWidth(), getMeasuredHeight());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24248a.m25967a(i, i2);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f24248a.f24247a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        Overlay overlay = this.f24248a;
        if (overlay.f24247a != null) {
            overlay.f24247a.setCallback(null);
            unscheduleDrawable(overlay.f24247a);
        }
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f24248a = new Overlay(drawable);
        this.f24248a.m25968a(getDrawableState());
        requestLayout();
    }
}
