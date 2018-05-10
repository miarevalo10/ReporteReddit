package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    final SeekBar f11899b;
    Drawable f11900c;
    private ColorStateList f11901d = null;
    private Mode f11902e = null;
    private boolean f11903f = false;
    private boolean f11904g = false;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f11899b = seekBar;
    }

    final void mo588a(AttributeSet attributeSet, int i) {
        super.mo588a(attributeSet, i);
        attributeSet = TintTypedArray.m2308a(this.f11899b.getContext(), attributeSet, C0164R.styleable.AppCompatSeekBar, i, 0);
        i = attributeSet.m2314b(C0164R.styleable.AppCompatSeekBar_android_thumb);
        if (i != 0) {
            this.f11899b.setThumb(i);
        }
        i = attributeSet.m2311a(C0164R.styleable.AppCompatSeekBar_tickMark);
        if (this.f11900c != null) {
            this.f11900c.setCallback(null);
        }
        this.f11900c = i;
        if (i != 0) {
            i.setCallback(this.f11899b);
            DrawableCompat.m839b(i, ViewCompat.m1242f(this.f11899b));
            if (i.isStateful()) {
                i.setState(this.f11899b.getDrawableState());
            }
            m10576a();
        }
        this.f11899b.invalidate();
        if (attributeSet.m2322f(C0164R.styleable.AppCompatSeekBar_tickMarkTintMode) != 0) {
            this.f11902e = DrawableUtils.m1957a(attributeSet.m2310a(C0164R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f11902e);
            this.f11904g = true;
        }
        if (attributeSet.m2322f(C0164R.styleable.AppCompatSeekBar_tickMarkTint) != 0) {
            this.f11901d = attributeSet.m2320e(C0164R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f11903f = true;
        }
        attributeSet.f2595b.recycle();
        m10576a();
    }

    private void m10576a() {
        if (this.f11900c == null) {
            return;
        }
        if (this.f11903f || this.f11904g) {
            this.f11900c = DrawableCompat.m844g(this.f11900c.mutate());
            if (this.f11903f) {
                DrawableCompat.m833a(this.f11900c, this.f11901d);
            }
            if (this.f11904g) {
                DrawableCompat.m836a(this.f11900c, this.f11902e);
            }
            if (this.f11900c.isStateful()) {
                this.f11900c.setState(this.f11899b.getDrawableState());
            }
        }
    }
}
