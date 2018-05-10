package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonImpl {
    private InsetDrawable f11090r;

    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulGradientDrawable() {
        }
    }

    final void mo100a(int[] iArr) {
    }

    final void mo101b() {
    }

    final boolean mo104e() {
        return false;
    }

    FloatingActionButtonLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    final void mo98a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        this.e = DrawableCompat.m844g(m271g());
        DrawableCompat.m833a(this.e, colorStateList);
        if (mode != null) {
            DrawableCompat.m836a(this.e, mode);
        }
        if (i2 > 0) {
            this.g = m258a(i2, colorStateList);
            colorStateList = new LayerDrawable(new Drawable[]{this.g, this.e});
        } else {
            this.g = null;
            colorStateList = this.e;
        }
        this.f = new RippleDrawable(ColorStateList.valueOf(i), colorStateList, null);
        this.h = this.f;
        this.p.mo91a(this.f);
    }

    final void mo97a(int i) {
        if (this.f instanceof RippleDrawable) {
            ((RippleDrawable) this.f).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo97a(i);
        }
    }

    final void mo96a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.o, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(k, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.o, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(l, animatorSet);
            f2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.o, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Z, new float[]{this.o.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            f2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            f2.setInterpolator(a);
            stateListAnimator.addState(m, f2);
            f = new AnimatorSet();
            f.play(ObjectAnimator.ofFloat(this.o, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.o, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            f.setInterpolator(a);
            stateListAnimator.addState(n, f);
            this.o.setStateListAnimator(stateListAnimator);
        } else if (this.o.isEnabled()) {
            this.o.setElevation(f);
            if (this.o.isFocused() == null) {
                if (this.o.isPressed() == null) {
                    this.o.setTranslationZ(0.0f);
                }
            }
            this.o.setTranslationZ(f2);
        } else {
            this.o.setElevation(0.0f);
            this.o.setTranslationZ(0.0f);
        }
        if (this.p.mo92b() != null) {
            m268d();
        }
    }

    public final float mo95a() {
        return this.o.getElevation();
    }

    final void mo103c() {
        m268d();
    }

    final void mo102b(Rect rect) {
        if (this.p.mo92b()) {
            this.f11090r = new InsetDrawable(this.f, rect.left, rect.top, rect.right, rect.bottom);
            this.p.mo91a(this.f11090r);
            return;
        }
        this.p.mo91a(this.f);
    }

    final CircularBorderDrawable mo105f() {
        return new CircularBorderDrawableLollipop();
    }

    final GradientDrawable mo106h() {
        return new AlwaysStatefulGradientDrawable();
    }

    final void mo99a(Rect rect) {
        if (this.p.mo92b()) {
            float a = this.p.mo89a();
            float elevation = this.o.getElevation() + this.j;
            int ceil = (int) Math.ceil((double) ShadowDrawableWrapper.m9587b(elevation, a, false));
            int ceil2 = (int) Math.ceil((double) ShadowDrawableWrapper.m9586a(elevation, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
