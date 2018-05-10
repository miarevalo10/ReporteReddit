package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.C0016R;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
    final CollapsingTextHelper f519a;
    Drawable f520b;
    int f521c;
    WindowInsetsCompat f522d;
    private boolean f523e;
    private int f524f;
    private Toolbar f525g;
    private View f526h;
    private View f527i;
    private int f528j;
    private int f529k;
    private int f530l;
    private int f531m;
    private final Rect f532n;
    private boolean f533o;
    private boolean f534p;
    private Drawable f535q;
    private int f536r;
    private boolean f537s;
    private ValueAnimator f538t;
    private long f539u;
    private int f540v;
    private OnOffsetChangedListener f541w;

    class C00302 implements AnimatorUpdateListener {
        final /* synthetic */ CollapsingToolbarLayout f516a;

        C00302(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f516a = collapsingToolbarLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f516a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int f517a = 0;
        float f518b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.CollapsingToolbarLayout_Layout);
            this.f517a = context.getInt(C0016R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f518b = context.getFloat(C0016R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            context.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class C09831 implements OnApplyWindowInsetsListener {
        final /* synthetic */ CollapsingToolbarLayout f11066a;

        C09831(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f11066a = collapsingToolbarLayout;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            view = this.f11066a;
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.m1265z(view) ? windowInsetsCompat : null;
            if (!ObjectsCompat.m1037a(view.f522d, windowInsetsCompat2)) {
                view.f522d = windowInsetsCompat2;
                view.requestLayout();
            }
            return windowInsetsCompat.m1313f();
        }
    }

    private class OffsetUpdateListener implements OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout f11067a;

        OffsetUpdateListener(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f11067a = collapsingToolbarLayout;
        }

        public final void mo85a(AppBarLayout appBarLayout, int i) {
            this.f11067a.f521c = i;
            appBarLayout = this.f11067a.f522d != null ? this.f11067a.f522d.m1309b() : null;
            int childCount = this.f11067a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f11067a.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper a = CollapsingToolbarLayout.m217a(childAt);
                switch (layoutParams.f517a) {
                    case 1:
                        a.m355a(MathUtils.m854a(-i, 0, this.f11067a.m222b(childAt)));
                        break;
                    case 2:
                        a.m355a(Math.round(((float) (-i)) * layoutParams.f518b));
                        break;
                    default:
                        break;
                }
            }
            this.f11067a.m221a();
            if (this.f11067a.f520b != null && appBarLayout > null) {
                ViewCompat.m1234c(this.f11067a);
            }
            this.f11067a.f519a.m202a(((float) Math.abs(i)) / ((float) ((this.f11067a.getHeight() - ViewCompat.m1253n(this.f11067a)) - appBarLayout)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f523e = true;
        this.f532n = new Rect();
        this.f540v = -1;
        ThemeUtils.m333a(context);
        this.f519a = new CollapsingTextHelper(this);
        this.f519a.m208a(AnimationUtils.f410e);
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.CollapsingToolbarLayout, i, C0016R.style.Widget_Design_CollapsingToolbar);
        this.f519a.m203a(context.getInt(C0016R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f519a.m212b(context.getInt(C0016R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        attributeSet = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f531m = attributeSet;
        this.f530l = attributeSet;
        this.f529k = attributeSet;
        this.f528j = attributeSet;
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart) != null) {
            this.f528j = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd) != null) {
            this.f530l = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop) != null) {
            this.f529k = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom) != null) {
            this.f531m = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f533o = context.getBoolean(C0016R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(context.getText(C0016R.styleable.CollapsingToolbarLayout_title));
        this.f519a.m216d(C0016R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f519a.m215c(C0164R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance) != null) {
            this.f519a.m216d(context.getResourceId(C0016R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (context.hasValue(C0016R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance) != null) {
            this.f519a.m215c(context.getResourceId(C0016R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f540v = context.getDimensionPixelSize(C0016R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f539u = (long) context.getInt(C0016R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(context.getDrawable(C0016R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(context.getDrawable(C0016R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f524f = context.getResourceId(C0016R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        context.recycle();
        setWillNotDraw(false);
        ViewCompat.m1221a((View) this, new C09831(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.m1232b((View) this, ViewCompat.m1265z((View) parent));
            if (this.f541w == null) {
                this.f541w = new OffsetUpdateListener(this);
            }
            ((AppBarLayout) parent).m171a(this.f541w);
            ViewCompat.m1264y(this);
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f541w != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m173b(this.f541w);
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m218b();
        if (this.f525g == null && this.f535q != null && this.f536r > 0) {
            this.f535q.mutate().setAlpha(this.f536r);
            this.f535q.draw(canvas);
        }
        if (this.f533o && this.f534p) {
            this.f519a.m206a(canvas);
        }
        if (this.f520b != null && this.f536r > 0) {
            int b = this.f522d != null ? this.f522d.m1309b() : 0;
            if (b > 0) {
                this.f520b.setBounds(0, -this.f521c, getWidth(), b - this.f521c);
                this.f520b.mutate().setAlpha(this.f536r);
                this.f520b.draw(canvas);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
        r4 = this;
        r0 = r4.f535q;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0033;
    L_0x0006:
        r0 = r4.f536r;
        if (r0 <= 0) goto L_0x0033;
    L_0x000a:
        r0 = r4.f526h;
        if (r0 == 0) goto L_0x0018;
    L_0x000e:
        r0 = r4.f526h;
        if (r0 != r4) goto L_0x0013;
    L_0x0012:
        goto L_0x0018;
    L_0x0013:
        r0 = r4.f526h;
        if (r6 != r0) goto L_0x001e;
    L_0x0017:
        goto L_0x001c;
    L_0x0018:
        r0 = r4.f525g;
        if (r6 != r0) goto L_0x001e;
    L_0x001c:
        r0 = r1;
        goto L_0x001f;
    L_0x001e:
        r0 = r2;
    L_0x001f:
        if (r0 == 0) goto L_0x0033;
    L_0x0021:
        r0 = r4.f535q;
        r0 = r0.mutate();
        r3 = r4.f536r;
        r0.setAlpha(r3);
        r0 = r4.f535q;
        r0.draw(r5);
        r0 = r1;
        goto L_0x0034;
    L_0x0033:
        r0 = r2;
    L_0x0034:
        r5 = super.drawChild(r5, r6, r7);
        if (r5 != 0) goto L_0x003e;
    L_0x003a:
        if (r0 == 0) goto L_0x003d;
    L_0x003c:
        goto L_0x003e;
    L_0x003d:
        return r2;
    L_0x003e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f535q != 0) {
            this.f535q.setBounds(0, 0, i, i2);
        }
    }

    private void m218b() {
        if (this.f523e) {
            Toolbar toolbar = null;
            this.f525g = null;
            this.f526h = null;
            if (this.f524f != -1) {
                this.f525g = (Toolbar) findViewById(this.f524f);
                if (this.f525g != null) {
                    View view = this.f525g;
                    CollapsingToolbarLayout parent = view.getParent();
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = parent;
                        }
                        parent = parent.getParent();
                    }
                    this.f526h = view;
                }
            }
            if (this.f525g == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                this.f525g = toolbar;
            }
            m220c();
            this.f523e = false;
        }
    }

    private void m220c() {
        if (!(this.f533o || this.f527i == null)) {
            ViewParent parent = this.f527i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f527i);
            }
        }
        if (this.f533o && this.f525g != null) {
            if (this.f527i == null) {
                this.f527i = new View(getContext());
            }
            if (this.f527i.getParent() == null) {
                this.f525g.addView(this.f527i, -1, -1);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m218b();
        super.onMeasure(i, i2);
        i2 = MeasureSpec.getMode(i2);
        int b = this.f522d != null ? this.f522d.m1309b() : 0;
        if (i2 == 0 && b > 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + b, 1073741824));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = false;
        if (this.f522d) {
            int b = this.f522d.m1309b();
            childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.m1265z(childAt) && childAt.getTop() < b) {
                    ViewCompat.m1231b(childAt, b);
                }
            }
        }
        if (this.f533o && this.f527i) {
            childCount = 1;
            z = ViewCompat.m1209J(this.f527i) && !this.f527i.getVisibility();
            this.f534p = z;
            if (this.f534p) {
                int titleMarginEnd;
                int titleMarginStart;
                if (!ViewCompat.m1242f(this)) {
                    childCount = 0;
                }
                z = m222b(this.f526h ? this.f526h : this.f525g);
                ViewGroupUtils.m352a((ViewGroup) this, this.f527i, this.f532n);
                CollapsingTextHelper collapsingTextHelper = this.f519a;
                int i6 = this.f532n.left;
                if (childCount != 0) {
                    titleMarginEnd = this.f525g.getTitleMarginEnd();
                } else {
                    titleMarginEnd = this.f525g.getTitleMarginStart();
                }
                i6 += titleMarginEnd;
                titleMarginEnd = (this.f532n.top + z) + this.f525g.getTitleMarginTop();
                int i7 = this.f532n.right;
                if (childCount != 0) {
                    titleMarginStart = this.f525g.getTitleMarginStart();
                } else {
                    titleMarginStart = this.f525g.getTitleMarginEnd();
                }
                collapsingTextHelper.m213b(i6, titleMarginEnd, i7 + titleMarginStart, (this.f532n.bottom + z) - this.f525g.getTitleMarginBottom());
                this.f519a.m204a(childCount != 0 ? this.f530l : this.f528j, this.f532n.top + this.f529k, (i3 - i) - (childCount != 0 ? this.f528j : this.f530l), (i4 - i2) - this.f531m);
                this.f519a.m211b();
            }
        }
        z = getChildCount();
        while (z2 < z) {
            m217a(getChildAt(z2)).m354a();
            z2++;
        }
        if (this.f525g) {
            if (this.f533o && TextUtils.isEmpty(this.f519a.f500i)) {
                this.f519a.m209a(this.f525g.getTitle());
            }
            if (this.f526h) {
                if (this.f526h != this) {
                    setMinimumHeight(m219c(this.f526h));
                }
            }
            setMinimumHeight(m219c(this.f525g));
        }
        m221a();
    }

    private static int m219c(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return (view.getHeight() + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin;
    }

    static ViewOffsetHelper m217a(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(C0016R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        viewOffsetHelper = new ViewOffsetHelper(view);
        view.setTag(C0016R.id.view_offset_helper, viewOffsetHelper);
        return viewOffsetHelper;
    }

    public void setTitle(CharSequence charSequence) {
        this.f519a.m209a(charSequence);
    }

    public CharSequence getTitle() {
        return this.f533o ? this.f519a.f500i : null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f533o) {
            this.f533o = z;
            m220c();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        int i = 0;
        int i2 = (!ViewCompat.m1206G(this) || isInEditMode()) ? 0 : 1;
        if (this.f537s != z) {
            int i3 = 255;
            if (i2 != 0) {
                if (!z) {
                    i3 = 0;
                }
                m218b();
                if (this.f538t == null) {
                    this.f538t = new ValueAnimator();
                    this.f538t.setDuration(this.f539u);
                    this.f538t.setInterpolator(i3 > this.f536r ? AnimationUtils.f408c : AnimationUtils.f409d);
                    this.f538t.addUpdateListener(new C00302(this));
                } else if (this.f538t.isRunning()) {
                    this.f538t.cancel();
                }
                this.f538t.setIntValues(new int[]{this.f536r, i3});
                this.f538t.start();
            } else {
                if (z) {
                    i = 255;
                }
                setScrimAlpha(i);
            }
            this.f537s = z;
        }
    }

    void setScrimAlpha(int i) {
        if (i != this.f536r) {
            if (!(this.f535q == null || this.f525g == null)) {
                ViewCompat.m1234c(this.f525g);
            }
            this.f536r = i;
            ViewCompat.m1234c(this);
        }
    }

    int getScrimAlpha() {
        return this.f536r;
    }

    public void setContentScrim(Drawable drawable) {
        if (this.f535q != drawable) {
            Drawable drawable2 = null;
            if (this.f535q != null) {
                this.f535q.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f535q = drawable2;
            if (this.f535q != null) {
                this.f535q.setBounds(0, 0, getWidth(), getHeight());
                this.f535q.setCallback(this);
                this.f535q.setAlpha(this.f536r);
            }
            ViewCompat.m1234c(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.m714a(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f535q;
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.f520b != drawable) {
            Drawable drawable2 = null;
            if (this.f520b != null) {
                this.f520b.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f520b = drawable2;
            if (this.f520b != null) {
                if (this.f520b.isStateful() != null) {
                    this.f520b.setState(getDrawableState());
                }
                DrawableCompat.m839b(this.f520b, ViewCompat.m1242f(this));
                this.f520b.setVisible(getVisibility() == 0, false);
                this.f520b.setCallback(this);
                this.f520b.setAlpha(this.f536r);
            }
            ViewCompat.m1234c(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f520b;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f535q;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.f519a != null) {
            i |= this.f519a.m210a(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!(super.verifyDrawable(drawable) || drawable == this.f535q)) {
            if (drawable != this.f520b) {
                return null;
            }
        }
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.f520b == null || this.f520b.isVisible() == z)) {
            this.f520b.setVisible(z, false);
        }
        if (this.f535q != null && this.f535q.isVisible() != z) {
            this.f535q.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.m714a(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f520b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f519a.m215c(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f519a.m205a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f519a.m212b(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f519a.f494c;
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f519a.m216d(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f519a.m214b(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f519a.m203a(i);
    }

    public int getExpandedTitleGravity() {
        return this.f519a.f493b;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f519a;
        if (CollapsingTextHelper.m192a(collapsingTextHelper.f498g, typeface)) {
            collapsingTextHelper.f498g = typeface;
            collapsingTextHelper.m211b();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f519a.m201a();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f519a;
        if (CollapsingTextHelper.m192a(collapsingTextHelper.f499h, typeface)) {
            collapsingTextHelper.f499h = typeface;
            collapsingTextHelper.m211b();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        CollapsingTextHelper collapsingTextHelper = this.f519a;
        return collapsingTextHelper.f499h != null ? collapsingTextHelper.f499h : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.f528j;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f528j = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f529k;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f529k = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f530l;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f530l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f531m;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f531m = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f540v != i) {
            this.f540v = i;
            m221a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.f540v >= 0) {
            return this.f540v;
        }
        int b = this.f522d != null ? this.f522d.m1309b() : 0;
        int n = ViewCompat.m1253n(this);
        if (n > 0) {
            return Math.min((n * 2) + b, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f539u = j;
    }

    public long getScrimAnimationDuration() {
        return this.f539u;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    final void m221a() {
        if (this.f535q != null || this.f520b != null) {
            setScrimsShown(getHeight() + this.f521c < getScrimVisibleHeightTrigger());
        }
    }

    final int m222b(View view) {
        return ((getHeight() - m217a(view).f721a) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m44252generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
