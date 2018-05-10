package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.design.C0016R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.util.StateSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

@RequiresApi(14)
class FloatingActionButtonImpl {
    static final Interpolator f580a = AnimationUtils.f408c;
    static final int[] f581k = new int[]{16842919, 16842910};
    static final int[] f582l = new int[]{16842908, 16842910};
    static final int[] f583m = new int[]{16842910};
    static final int[] f584n = new int[0];
    int f585b = 0;
    ShadowDrawableWrapper f586c;
    float f587d;
    Drawable f588e;
    Drawable f589f;
    CircularBorderDrawable f590g;
    Drawable f591h;
    float f592i;
    float f593j;
    final VisibilityAwareImageButton f594o;
    final ShadowViewDelegate f595p;
    OnPreDrawListener f596q;
    private final StateListAnimator f597r;
    private final Rect f598s = new Rect();

    class C00321 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f568a = null;
        final /* synthetic */ InternalVisibilityChangedListener f569b;
        final /* synthetic */ FloatingActionButtonImpl f570c;
        private boolean f571d;

        C00321(FloatingActionButtonImpl floatingActionButtonImpl, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.f570c = floatingActionButtonImpl;
            this.f569b = internalVisibilityChangedListener;
        }

        public void onAnimationStart(Animator animator) {
            this.f570c.f594o.m361a(0, this.f568a);
            this.f571d = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f571d = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f570c.f585b = 0;
            if (this.f571d == null) {
                this.f570c.f594o.m361a(this.f568a ? 8 : 4, this.f568a);
            }
        }
    }

    class C00332 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean f572a = null;
        final /* synthetic */ InternalVisibilityChangedListener f573b;
        final /* synthetic */ FloatingActionButtonImpl f574c;

        C00332(FloatingActionButtonImpl floatingActionButtonImpl, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.f574c = floatingActionButtonImpl;
            this.f573b = internalVisibilityChangedListener;
        }

        public void onAnimationStart(Animator animator) {
            this.f574c.f594o.m361a(0, this.f572a);
        }

        public void onAnimationEnd(Animator animator) {
            this.f574c.f585b = 0;
        }
    }

    class C00343 implements OnPreDrawListener {
        final /* synthetic */ FloatingActionButtonImpl f575a;

        C00343(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f575a = floatingActionButtonImpl;
        }

        public boolean onPreDraw() {
            FloatingActionButtonImpl floatingActionButtonImpl = this.f575a;
            float rotation = floatingActionButtonImpl.f594o.getRotation();
            if (floatingActionButtonImpl.f587d != rotation) {
                floatingActionButtonImpl.f587d = rotation;
                if (VERSION.SDK_INT == 19) {
                    if (floatingActionButtonImpl.f587d % 90.0f != 0.0f) {
                        if (floatingActionButtonImpl.f594o.getLayerType() != 1) {
                            floatingActionButtonImpl.f594o.setLayerType(1, null);
                        }
                    } else if (floatingActionButtonImpl.f594o.getLayerType() != 0) {
                        floatingActionButtonImpl.f594o.setLayerType(0, null);
                    }
                }
                if (floatingActionButtonImpl.f586c != null) {
                    ShadowDrawableWrapper shadowDrawableWrapper = floatingActionButtonImpl.f586c;
                    float f = -floatingActionButtonImpl.f587d;
                    if (shadowDrawableWrapper.f11110l != f) {
                        shadowDrawableWrapper.f11110l = f;
                        shadowDrawableWrapper.invalidateSelf();
                    }
                }
                if (floatingActionButtonImpl.f590g != null) {
                    CircularBorderDrawable circularBorderDrawable = floatingActionButtonImpl.f590g;
                    float f2 = -floatingActionButtonImpl.f587d;
                    if (f2 != circularBorderDrawable.f467j) {
                        circularBorderDrawable.f467j = f2;
                        circularBorderDrawable.invalidateSelf();
                    }
                }
            }
            return true;
        }
    }

    interface InternalVisibilityChangedListener {
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        private boolean f576a;
        final /* synthetic */ FloatingActionButtonImpl f577b;
        private float f578c;
        private float f579d;

        protected abstract float mo94a();

        private ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f577b = floatingActionButtonImpl;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f576a) {
                this.f578c = this.f577b.f586c.f11108j;
                this.f579d = mo94a();
                this.f576a = true;
            }
            this.f577b.f586c.m9589a(this.f578c + ((this.f579d - this.f578c) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            this.f577b.f586c.m9589a(this.f579d);
            this.f576a = null;
        }
    }

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl f11087a;

        protected final float mo94a() {
            return 0.0f;
        }

        DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f11087a = floatingActionButtonImpl;
            super();
        }
    }

    private class ElevateToTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl f11088a;

        ElevateToTranslationZAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f11088a = floatingActionButtonImpl;
            super();
        }

        protected final float mo94a() {
            return this.f11088a.f592i + this.f11088a.f593j;
        }
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl f11089a;

        ResetElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f11089a = floatingActionButtonImpl;
            super();
        }

        protected final float mo94a() {
            return this.f11089a.f592i;
        }
    }

    void mo102b(Rect rect) {
    }

    void mo103c() {
    }

    boolean mo104e() {
        return true;
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.f594o = visibilityAwareImageButton;
        this.f595p = shadowViewDelegate;
        this.f597r = new StateListAnimator();
        this.f597r.m295a(f581k, m255a(new ElevateToTranslationZAnimation(this)));
        this.f597r.m295a(f582l, m255a(new ElevateToTranslationZAnimation(this)));
        this.f597r.m295a(f583m, m255a(new ResetElevationAnimation(this)));
        this.f597r.m295a(f584n, m255a(new DisabledElevationAnimation(this)));
        this.f587d = this.f594o.getRotation();
    }

    void mo98a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        this.f588e = DrawableCompat.m844g(m271g());
        DrawableCompat.m833a(this.f588e, colorStateList);
        if (mode != null) {
            DrawableCompat.m836a(this.f588e, mode);
        }
        this.f589f = DrawableCompat.m844g(m271g());
        DrawableCompat.m833a(this.f589f, m256b(i));
        if (i2 > 0) {
            this.f590g = m258a(i2, colorStateList);
            colorStateList = new Drawable[]{this.f590g, this.f588e, this.f589f};
        } else {
            this.f590g = null;
            colorStateList = new Drawable[]{this.f588e, this.f589f};
        }
        this.f591h = new LayerDrawable(colorStateList);
        this.f586c = new ShadowDrawableWrapper(this.f594o.getContext(), this.f591h, this.f595p.mo89a(), this.f592i, this.f592i + this.f593j);
        colorStateList = this.f586c;
        colorStateList.f11109k = false;
        colorStateList.invalidateSelf();
        this.f595p.mo91a(this.f586c);
    }

    void mo97a(int i) {
        if (this.f589f != null) {
            DrawableCompat.m833a(this.f589f, m256b(i));
        }
    }

    final void m259a(float f) {
        if (this.f592i != f) {
            this.f592i = f;
            mo96a(f, this.f593j);
        }
    }

    float mo95a() {
        return this.f592i;
    }

    void mo96a(float f, float f2) {
        if (this.f586c != null) {
            this.f586c.m9590a(f, this.f593j + f);
            m268d();
        }
    }

    void mo100a(int[] iArr) {
        Tuple tuple;
        StateListAnimator stateListAnimator = this.f597r;
        int size = stateListAnimator.f616a.size();
        for (int i = 0; i < size; i++) {
            tuple = (Tuple) stateListAnimator.f616a.get(i);
            if (StateSet.stateSetMatches(tuple.f614a, iArr)) {
                break;
            }
        }
        tuple = null;
        if (tuple != stateListAnimator.f617b) {
            if (!(stateListAnimator.f617b == null || stateListAnimator.f618c == null)) {
                stateListAnimator.f618c.cancel();
                stateListAnimator.f618c = null;
            }
            stateListAnimator.f617b = tuple;
            if (tuple != null) {
                stateListAnimator.f618c = tuple.f615b;
                stateListAnimator.f618c.start();
            }
        }
    }

    void mo101b() {
        StateListAnimator stateListAnimator = this.f597r;
        if (stateListAnimator.f618c != null) {
            stateListAnimator.f618c.end();
            stateListAnimator.f618c = null;
        }
    }

    final void m268d() {
        Rect rect = this.f598s;
        mo99a(rect);
        mo102b(rect);
        this.f595p.mo90a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void mo99a(Rect rect) {
        this.f586c.getPadding(rect);
    }

    final CircularBorderDrawable m258a(int i, ColorStateList colorStateList) {
        Context context = this.f594o.getContext();
        CircularBorderDrawable f = mo105f();
        int c = ContextCompat.m719c(context, C0016R.color.design_fab_stroke_top_outer_color);
        int c2 = ContextCompat.m719c(context, C0016R.color.design_fab_stroke_top_inner_color);
        int c3 = ContextCompat.m719c(context, C0016R.color.design_fab_stroke_end_inner_color);
        int c4 = ContextCompat.m719c(context, C0016R.color.design_fab_stroke_end_outer_color);
        f.f462e = c;
        f.f463f = c2;
        f.f464g = c3;
        f.f465h = c4;
        i = (float) i;
        if (f.f461d != i) {
            f.f461d = i;
            f.f458a.setStrokeWidth(i * 1068149139);
            f.f466i = true;
            f.invalidateSelf();
        }
        f.m187a(colorStateList);
        return f;
    }

    CircularBorderDrawable mo105f() {
        return new CircularBorderDrawable();
    }

    final GradientDrawable m271g() {
        GradientDrawable h = mo106h();
        h.setShape(1);
        h.setColor(-1);
        return h;
    }

    GradientDrawable mo106h() {
        return new GradientDrawable();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.ValueAnimator m255a(android.support.design.widget.FloatingActionButtonImpl.ShadowAnimatorImpl r3) {
        /*
        r0 = new android.animation.ValueAnimator;
        r0.<init>();
        r1 = f580a;
        r0.setInterpolator(r1);
        r1 = 100;
        r0.setDuration(r1);
        r0.addListener(r3);
        r0.addUpdateListener(r3);
        r3 = 2;
        r3 = new float[r3];
        r3 = {0, 1065353216};
        r0.setFloatValues(r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.FloatingActionButtonImpl.a(android.support.design.widget.FloatingActionButtonImpl$ShadowAnimatorImpl):android.animation.ValueAnimator");
    }

    private static ColorStateList m256b(int i) {
        r1 = new int[3][];
        int[] iArr = new int[]{f582l, i, f581k};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r1, iArr);
    }

    final boolean m273i() {
        return ViewCompat.m1206G(this.f594o) && !this.f594o.isInEditMode();
    }
}
