package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0016R;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButtonImpl.C00343;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.List;

@DefaultBehavior(a = Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    int f11075a;
    boolean f11076b;
    final Rect f11077c;
    private ColorStateList f11078d;
    private Mode f11079e;
    private int f11080f;
    private int f11081g;
    private int f11082h;
    private int f11083i;
    private final Rect f11084j;
    private AppCompatImageHelper f11085k;
    private FloatingActionButtonImpl f11086l;

    public static abstract class OnVisibilityChangedListener {
    }

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private Rect f11071a;
        private OnVisibilityChangedListener f11072b;
        private boolean f11073c;

        public final /* synthetic */ boolean mo87a(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.f11077c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final /* synthetic */ boolean mo88b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                m9548a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else if (m9550a(view2) != null) {
                m9552b(view2, floatingActionButton);
            }
            return null;
        }

        public Behavior() {
            this.f11073c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.FloatingActionButton_Behavior_Layout);
            this.f11073c = context.getBoolean(C0016R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            context.recycle();
        }

        public final void mo86a(LayoutParams layoutParams) {
            if (layoutParams.f550h == 0) {
                layoutParams.f550h = 80;
            }
        }

        private static boolean m9550a(View view) {
            view = view.getLayoutParams();
            return view instanceof LayoutParams ? ((LayoutParams) view).f543a instanceof BottomSheetBehavior : null;
        }

        private boolean m9551a(View view, FloatingActionButton floatingActionButton) {
            LayoutParams layoutParams = (LayoutParams) floatingActionButton.getLayoutParams();
            if (this.f11073c && layoutParams.f548f == view.getId() && floatingActionButton.getUserSetVisibility() == null) {
                return true;
            }
            return false;
        }

        private boolean m9548a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m9551a((View) appBarLayout, floatingActionButton)) {
                return null;
            }
            if (this.f11071a == null) {
                this.f11071a = new Rect();
            }
            Rect rect = this.f11071a;
            ViewGroupUtils.m352a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m9565b(this.f11072b);
            } else {
                floatingActionButton.m9564a(this.f11072b);
            }
            return true;
        }

        private boolean m9552b(View view, FloatingActionButton floatingActionButton) {
            if (!m9551a(view, floatingActionButton)) {
                return null;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.m9565b(this.f11072b);
            } else {
                floatingActionButton.m9564a(this.f11072b);
            }
            return true;
        }

        private boolean m9549a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List a = coordinatorLayout.m16544a((View) floatingActionButton);
            int size = a.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) a.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (m9550a(view) && m9552b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m9548a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m16546a((View) floatingActionButton, i);
            i = floatingActionButton.f11077c;
            if (i != 0 && i.centerX() > 0 && i.centerY() > 0) {
                LayoutParams layoutParams = (LayoutParams) floatingActionButton.getLayoutParams();
                size = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin ? i.right : floatingActionButton.getLeft() <= layoutParams.leftMargin ? -i.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i2 = i.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i2 = -i.top;
                }
                if (i2 != 0) {
                    ViewCompat.m1231b((View) floatingActionButton, i2);
                }
                if (size != 0) {
                    ViewCompat.m1236c((View) floatingActionButton, size);
                }
            }
            return true;
        }
    }

    private class ShadowDelegateImpl implements ShadowViewDelegate {
        final /* synthetic */ FloatingActionButton f11074a;

        ShadowDelegateImpl(FloatingActionButton floatingActionButton) {
            this.f11074a = floatingActionButton;
        }

        public final float mo89a() {
            return ((float) this.f11074a.getSizeDimension()) / 2.0f;
        }

        public final void mo90a(int i, int i2, int i3, int i4) {
            this.f11074a.f11077c.set(i, i2, i3, i4);
            this.f11074a.setPadding(i + this.f11074a.f11075a, i2 + this.f11074a.f11075a, i3 + this.f11074a.f11075a, i4 + this.f11074a.f11075a);
        }

        public final void mo91a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean mo92b() {
            return this.f11074a.f11076b;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11077c = new Rect();
        this.f11084j = new Rect();
        ThemeUtils.m333a(context);
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.FloatingActionButton, i, C0016R.style.Widget_Design_FloatingActionButton);
        this.f11078d = context.getColorStateList(C0016R.styleable.FloatingActionButton_backgroundTint);
        this.f11079e = ViewUtils.m357a(context.getInt(C0016R.styleable.FloatingActionButton_backgroundTintMode, -1));
        this.f11081g = context.getColor(C0016R.styleable.FloatingActionButton_rippleColor, 0);
        this.f11082h = context.getInt(C0016R.styleable.FloatingActionButton_fabSize, -1);
        this.f11080f = context.getDimensionPixelSize(C0016R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = context.getDimension(C0016R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = context.getDimension(C0016R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f11076b = context.getBoolean(C0016R.styleable.FloatingActionButton_useCompatPadding, false);
        context.recycle();
        this.f11085k = new AppCompatImageHelper(this);
        this.f11085k.m1825a(attributeSet, i);
        this.f11083i = (int) getResources().getDimension(C0016R.dimen.design_fab_image_size);
        getImpl().mo98a(this.f11078d, this.f11079e, this.f11081g, this.f11080f);
        getImpl().m259a(dimension);
        context = getImpl();
        if (context.f593j != dimension2) {
            context.f593j = dimension2;
            context.mo96a(context.f592i, dimension2);
        }
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f11075a = (sizeDimension - this.f11083i) / 2;
        getImpl().m268d();
        i = Math.min(m9561a(sizeDimension, i), m9561a(sizeDimension, i2));
        setMeasuredDimension((this.f11077c.left + i) + this.f11077c.right, (i + this.f11077c.top) + this.f11077c.bottom);
    }

    public int getRippleColor() {
        return this.f11081g;
    }

    public void setRippleColor(int i) {
        if (this.f11081g != i) {
            this.f11081g = i;
            getImpl().mo97a(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f11078d;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11078d != colorStateList) {
            this.f11078d = colorStateList;
            FloatingActionButtonImpl impl = getImpl();
            if (impl.f588e != null) {
                DrawableCompat.m833a(impl.f588e, colorStateList);
            }
            if (impl.f590g != null) {
                impl.f590g.m187a(colorStateList);
            }
        }
    }

    public Mode getBackgroundTintMode() {
        return this.f11079e;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f11079e != mode) {
            this.f11079e = mode;
            FloatingActionButtonImpl impl = getImpl();
            if (impl.f588e != null) {
                DrawableCompat.m836a(impl.f588e, mode);
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.f11085k.m1822a(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m9564a(android.support.design.widget.FloatingActionButton.OnVisibilityChangedListener r6) {
        /*
        r5 = this;
        r0 = r5.getImpl();
        r6 = r5.m9563c(r6);
        r1 = r0.f594o;
        r1 = r1.getVisibility();
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r1 == 0) goto L_0x001a;
    L_0x0013:
        r1 = r0.f585b;
        if (r1 != r2) goto L_0x0018;
    L_0x0017:
        goto L_0x001e;
    L_0x0018:
        r3 = r4;
        goto L_0x001e;
    L_0x001a:
        r1 = r0.f585b;
        if (r1 == r3) goto L_0x0018;
    L_0x001e:
        if (r3 != 0) goto L_0x0086;
    L_0x0020:
        r1 = r0.f594o;
        r1 = r1.animate();
        r1.cancel();
        r1 = r0.m273i();
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r1 == 0) goto L_0x0072;
    L_0x0031:
        r0.f585b = r2;
        r1 = r0.f594o;
        r1 = r1.getVisibility();
        if (r1 == 0) goto L_0x004b;
    L_0x003b:
        r1 = r0.f594o;
        r2 = 0;
        r1.setAlpha(r2);
        r1 = r0.f594o;
        r1.setScaleY(r2);
        r1 = r0.f594o;
        r1.setScaleX(r2);
    L_0x004b:
        r1 = r0.f594o;
        r1 = r1.animate();
        r1 = r1.scaleX(r3);
        r1 = r1.scaleY(r3);
        r1 = r1.alpha(r3);
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1 = r1.setDuration(r2);
        r2 = android.support.design.widget.AnimationUtils.f409d;
        r1 = r1.setInterpolator(r2);
        r2 = new android.support.design.widget.FloatingActionButtonImpl$2;
        r2.<init>(r0, r6);
        r1.setListener(r2);
        return;
    L_0x0072:
        r6 = r0.f594o;
        r6.m361a(r4, r4);
        r6 = r0.f594o;
        r6.setAlpha(r3);
        r6 = r0.f594o;
        r6.setScaleY(r3);
        r6 = r0.f594o;
        r6.setScaleX(r3);
    L_0x0086:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.FloatingActionButton.a(android.support.design.widget.FloatingActionButton$OnVisibilityChangedListener):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m9565b(android.support.design.widget.FloatingActionButton.OnVisibilityChangedListener r6) {
        /*
        r5 = this;
        r0 = r5.getImpl();
        r6 = r5.m9563c(r6);
        r1 = r0.f594o;
        r1 = r1.getVisibility();
        r2 = 0;
        r3 = 1;
        if (r1 != 0) goto L_0x001a;
    L_0x0012:
        r1 = r0.f585b;
        if (r1 != r3) goto L_0x0018;
    L_0x0016:
        r1 = r3;
        goto L_0x0020;
    L_0x0018:
        r1 = r2;
        goto L_0x0020;
    L_0x001a:
        r1 = r0.f585b;
        r4 = 2;
        if (r1 == r4) goto L_0x0018;
    L_0x001f:
        goto L_0x0016;
    L_0x0020:
        if (r1 != 0) goto L_0x0061;
    L_0x0022:
        r1 = r0.f594o;
        r1 = r1.animate();
        r1.cancel();
        r1 = r0.m273i();
        if (r1 == 0) goto L_0x005b;
    L_0x0031:
        r0.f585b = r3;
        r1 = r0.f594o;
        r1 = r1.animate();
        r2 = 0;
        r1 = r1.scaleX(r2);
        r1 = r1.scaleY(r2);
        r1 = r1.alpha(r2);
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1 = r1.setDuration(r2);
        r2 = android.support.design.widget.AnimationUtils.f408c;
        r1 = r1.setInterpolator(r2);
        r2 = new android.support.design.widget.FloatingActionButtonImpl$1;
        r2.<init>(r0, r6);
        r1.setListener(r2);
        return;
    L_0x005b:
        r6 = r0.f594o;
        r0 = 4;
        r6.m361a(r0, r2);
    L_0x0061:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.FloatingActionButton.b(android.support.design.widget.FloatingActionButton$OnVisibilityChangedListener):void");
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f11076b != z) {
            this.f11076b = z;
            getImpl().mo103c();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f11076b;
    }

    public void setSize(int i) {
        if (i != this.f11082h) {
            this.f11082h = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f11082h;
    }

    private InternalVisibilityChangedListener m9563c(final OnVisibilityChangedListener onVisibilityChangedListener) {
        return onVisibilityChangedListener == null ? null : new InternalVisibilityChangedListener(this) {
            final /* synthetic */ FloatingActionButton f11070b;
        };
    }

    int getSizeDimension() {
        int i = this.f11082h;
        while (true) {
            Resources resources = getResources();
            if (i != -1) {
                break;
            }
            i = Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? 1 : 0;
        }
        if (i != 1) {
            return resources.getDimensionPixelSize(C0016R.dimen.design_fab_size_normal);
        }
        return resources.getDimensionPixelSize(C0016R.dimen.design_fab_size_mini);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloatingActionButtonImpl impl = getImpl();
        if (impl.mo104e()) {
            if (impl.f596q == null) {
                impl.f596q = new C00343(impl);
            }
            impl.f594o.getViewTreeObserver().addOnPreDrawListener(impl.f596q);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl = getImpl();
        if (impl.f596q != null) {
            impl.f594o.getViewTreeObserver().removeOnPreDrawListener(impl.f596q);
            impl.f596q = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo100a(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo101b();
    }

    public Drawable getContentBackground() {
        return getImpl().f591h;
    }

    private static int m9561a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, i2);
        }
        if (mode != 0) {
            return mode != 1073741824 ? i : i2;
        } else {
            return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            boolean z;
            Rect rect = this.f11084j;
            if (ViewCompat.m1206G(this)) {
                rect.set(0, 0, getWidth(), getHeight());
                rect.left += this.f11077c.left;
                rect.top += this.f11077c.top;
                rect.right -= this.f11077c.right;
                rect.bottom -= this.f11077c.bottom;
                z = true;
            } else {
                z = false;
            }
            if (z && !this.f11084j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getCompatElevation() {
        return getImpl().mo95a();
    }

    public void setCompatElevation(float f) {
        getImpl().m259a(f);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f11086l == null) {
            FloatingActionButtonImpl floatingActionButtonLollipop;
            if (VERSION.SDK_INT >= 21) {
                floatingActionButtonLollipop = new FloatingActionButtonLollipop(this, new ShadowDelegateImpl(this));
            } else {
                floatingActionButtonLollipop = new FloatingActionButtonImpl(this, new ShadowDelegateImpl(this));
            }
            this.f11086l = floatingActionButtonLollipop;
        }
        return this.f11086l;
    }
}
