package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.RequiresApi;

@RequiresApi(14)
class DrawableWrapperApi14 extends Drawable implements Callback, DrawableWrapper, TintAwareDrawable {
    static final Mode f11422a = Mode.SRC_IN;
    DrawableWrapperState f11423b;
    Drawable f11424c;
    private int f11425d;
    private Mode f11426e;
    private boolean f11427f;
    private boolean f11428g;

    protected static abstract class DrawableWrapperState extends ConstantState {
        int mChangingConfigurations;
        ConstantState mDrawableState;
        ColorStateList mTint = null;
        Mode mTintMode = DrawableWrapperApi14.f11422a;

        public abstract Drawable newDrawable(Resources resources);

        DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            if (drawableWrapperState != null) {
                this.mChangingConfigurations = drawableWrapperState.mChangingConfigurations;
                this.mDrawableState = drawableWrapperState.mDrawableState;
                this.mTint = drawableWrapperState.mTint;
                this.mTintMode = drawableWrapperState.mTintMode;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations | (this.mDrawableState != null ? this.mDrawableState.getChangingConfigurations() : 0);
        }

        boolean canConstantState() {
            return this.mDrawableState != null;
        }
    }

    private static class DrawableWrapperStateBase extends DrawableWrapperState {
        DrawableWrapperStateBase(DrawableWrapperState drawableWrapperState) {
            super(drawableWrapperState, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new DrawableWrapperApi14(this, resources);
        }
    }

    protected boolean mo3834c() {
        return true;
    }

    DrawableWrapperApi14(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.f11423b = drawableWrapperState;
        if (this.f11423b != null && this.f11423b.mDrawableState != null) {
            mo274a(this.f11423b.mDrawableState.newDrawable(resources));
        }
    }

    DrawableWrapperApi14(Drawable drawable) {
        this.f11423b = mo3132b();
        mo274a(drawable);
    }

    public void jumpToCurrentState() {
        this.f11424c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f11424c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f11424c != null) {
            this.f11424c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f11424c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | (this.f11423b != null ? this.f11423b.getChangingConfigurations() : 0)) | this.f11424c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f11424c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f11424c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f11424c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11424c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo3834c() || this.f11423b == null) ? null : this.f11423b.mTint;
        return (colorStateList != null && colorStateList.isStateful()) || this.f11424c.isStateful();
    }

    public boolean setState(int[] iArr) {
        boolean state = this.f11424c.setState(iArr);
        if (m10028a(iArr) == null) {
            if (!state) {
                return null;
            }
        }
        return 1;
    }

    public int[] getState() {
        return this.f11424c.getState();
    }

    public Drawable getCurrent() {
        return this.f11424c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (!super.setVisible(z, z2)) {
            if (!this.f11424c.setVisible(z, z2)) {
                return false;
            }
        }
        return true;
    }

    public int getOpacity() {
        return this.f11424c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f11424c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f11424c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f11424c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f11424c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f11424c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f11424c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f11423b == null || !this.f11423b.canConstantState()) {
            return null;
        }
        this.f11423b.mChangingConfigurations = getChangingConfigurations();
        return this.f11423b;
    }

    public Drawable mutate() {
        if (!this.f11428g && super.mutate() == this) {
            this.f11423b = mo3132b();
            if (this.f11424c != null) {
                this.f11424c.mutate();
            }
            if (this.f11423b != null) {
                this.f11423b.mDrawableState = this.f11424c != null ? this.f11424c.getConstantState() : null;
            }
            this.f11428g = true;
        }
        return this;
    }

    DrawableWrapperState mo3132b() {
        return new DrawableWrapperStateBase(this.f11423b);
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
        return this.f11424c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f11423b.mTint = colorStateList;
        m10028a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f11423b.mTintMode = mode;
        m10028a(getState());
    }

    private boolean m10028a(int[] iArr) {
        if (!mo3834c()) {
            return false;
        }
        ColorStateList colorStateList = this.f11423b.mTint;
        Mode mode = this.f11423b.mTintMode;
        if (colorStateList == null || mode == null) {
            this.f11427f = false;
            clearColorFilter();
        } else {
            iArr = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f11427f && iArr == this.f11425d && mode == this.f11426e)) {
                setColorFilter(iArr, mode);
                this.f11425d = iArr;
                this.f11426e = mode;
                this.f11427f = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable mo273a() {
        return this.f11424c;
    }

    public final void mo274a(Drawable drawable) {
        if (this.f11424c != null) {
            this.f11424c.setCallback(null);
        }
        this.f11424c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f11423b != null) {
                this.f11423b.mDrawableState = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
