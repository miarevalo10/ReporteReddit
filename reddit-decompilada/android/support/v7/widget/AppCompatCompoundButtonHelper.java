package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
    ColorStateList f2134a = null;
    Mode f2135b = null;
    private final CompoundButton f2136c;
    private boolean f2137d = false;
    private boolean f2138e = false;
    private boolean f2139f;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f2136c = compoundButton;
    }

    final void m1804a(AttributeSet attributeSet, int i) {
        attributeSet = this.f2136c.getContext().obtainStyledAttributes(attributeSet, C0164R.styleable.CompoundButton, i, 0);
        try {
            if (attributeSet.hasValue(C0164R.styleable.CompoundButton_android_button) != 0) {
                i = attributeSet.getResourceId(C0164R.styleable.CompoundButton_android_button, 0);
                if (i != 0) {
                    this.f2136c.setButtonDrawable(AppCompatResources.m1570b(this.f2136c.getContext(), i));
                }
            }
            if (attributeSet.hasValue(C0164R.styleable.CompoundButton_buttonTint) != 0) {
                CompoundButtonCompat.m1373a(this.f2136c, attributeSet.getColorStateList(C0164R.styleable.CompoundButton_buttonTint));
            }
            if (attributeSet.hasValue(C0164R.styleable.CompoundButton_buttonTintMode) != 0) {
                CompoundButtonCompat.m1374a(this.f2136c, DrawableUtils.m1957a(attributeSet.getInt(C0164R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
            attributeSet.recycle();
        } catch (Throwable th) {
            attributeSet.recycle();
        }
    }

    final void m1802a(ColorStateList colorStateList) {
        this.f2134a = colorStateList;
        this.f2137d = true;
        m1799b();
    }

    final void m1803a(Mode mode) {
        this.f2135b = mode;
        this.f2138e = true;
        m1799b();
    }

    final void m1801a() {
        if (this.f2139f) {
            this.f2139f = false;
            return;
        }
        this.f2139f = true;
        m1799b();
    }

    private void m1799b() {
        Drawable a = CompoundButtonCompat.m1372a(this.f2136c);
        if (a == null) {
            return;
        }
        if (this.f2137d || this.f2138e) {
            a = DrawableCompat.m844g(a).mutate();
            if (this.f2137d) {
                DrawableCompat.m833a(a, this.f2134a);
            }
            if (this.f2138e) {
                DrawableCompat.m836a(a, this.f2135b);
            }
            if (a.isStateful()) {
                a.setState(this.f2136c.getDrawableState());
            }
            this.f2136c.setButtonDrawable(a);
        }
    }

    final int m1800a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = CompoundButtonCompat.m1372a(this.f2136c);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }
}
