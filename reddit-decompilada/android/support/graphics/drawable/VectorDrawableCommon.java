package android.support.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable f11187b;

    VectorDrawableCommon() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f11187b != null) {
            this.f11187b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        return this.f11187b != null ? DrawableCompat.m842e(this.f11187b) : null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f11187b != null) {
            return this.f11187b.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f11187b != null) {
            this.f11187b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f11187b != null) {
            DrawableCompat.m830a(this.f11187b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f11187b != null) {
            DrawableCompat.m832a(this.f11187b, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f11187b != null) {
            this.f11187b.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f11187b != null) {
            DrawableCompat.m829a(this.f11187b);
        }
    }

    public void applyTheme(Theme theme) {
        if (this.f11187b != null) {
            DrawableCompat.m834a(this.f11187b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f11187b != null) {
            this.f11187b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f11187b != null) {
            return this.f11187b.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f11187b != null) {
            return this.f11187b.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f11187b != null) {
            return this.f11187b.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f11187b != null) {
            return this.f11187b.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f11187b != null) {
            return this.f11187b.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f11187b != null) {
            return this.f11187b.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f11187b != null) {
            this.f11187b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f11187b != null) {
            return this.f11187b.setState(iArr);
        }
        return super.setState(iArr);
    }
}
