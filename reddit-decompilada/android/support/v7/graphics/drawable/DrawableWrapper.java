package android.support.v7.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableCompat;

public class DrawableWrapper extends Drawable implements Callback {
    public Drawable f1861m;

    public DrawableWrapper(Drawable drawable) {
        if (this.f1861m != null) {
            this.f1861m.setCallback(null);
        }
        this.f1861m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f1861m.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1861m.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1861m.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1861m.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1861m.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1861m.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1861m.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1861m.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1861m.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1861m.setState(iArr);
    }

    public int[] getState() {
        return this.f1861m.getState();
    }

    public void jumpToCurrentState() {
        DrawableCompat.m829a(this.f1861m);
    }

    public Drawable getCurrent() {
        return this.f1861m.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (!super.setVisible(z, z2)) {
            if (!this.f1861m.setVisible(z, z2)) {
                return false;
            }
        }
        return true;
    }

    public int getOpacity() {
        return this.f1861m.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1861m.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1861m.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1861m.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1861m.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1861m.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1861m.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f1861m.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.m837a(this.f1861m, z);
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.m838b(this.f1861m);
    }

    public void setTint(int i) {
        DrawableCompat.m831a(this.f1861m, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.m833a(this.f1861m, colorStateList);
    }

    public void setTintMode(Mode mode) {
        DrawableCompat.m836a(this.f1861m, mode);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.m830a(this.f1861m, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.m832a(this.f1861m, i, i2, i3, i4);
    }
}
