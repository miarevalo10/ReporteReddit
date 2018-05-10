package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.Method;

@RequiresApi(21)
class DrawableWrapperApi21 extends DrawableWrapperApi19 {
    private static Method f18853d;

    private static class DrawableWrapperStateLollipop extends DrawableWrapperState {
        DrawableWrapperStateLollipop(DrawableWrapperState drawableWrapperState) {
            super(drawableWrapperState, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new DrawableWrapperApi21(this, resources);
        }
    }

    DrawableWrapperApi21(Drawable drawable) {
        super(drawable);
        m19921d();
    }

    DrawableWrapperApi21(DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
        m19921d();
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo3834c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (mo3834c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo3834c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (super.setState(iArr) == null) {
            return null;
        }
        invalidateSelf();
        return 1;
    }

    protected final boolean mo3834c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if (!((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable))) {
            if (!(drawable instanceof RippleDrawable)) {
                return false;
            }
        }
        return true;
    }

    final DrawableWrapperState mo3132b() {
        return new DrawableWrapperStateLollipop(this.b);
    }

    private static void m19921d() {
        if (f18853d == null) {
            try {
                f18853d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Throwable e) {
                Log.w("DrawableWrapperApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
