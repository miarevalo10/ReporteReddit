package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {
    static final int[] f11819f = new int[]{C0164R.attr.actionBarSize, 16842841};
    private final Runnable f11820A;
    private final Runnable f11821B;
    private final NestedScrollingParentHelper f11822C;
    ActionBarContainer f11823a;
    public boolean f11824b;
    boolean f11825c;
    ViewPropertyAnimator f11826d;
    final AnimatorListenerAdapter f11827e;
    private int f11828g;
    private int f11829h;
    private ContentFrameLayout f11830i;
    private DecorToolbar f11831j;
    private Drawable f11832k;
    private boolean f11833l;
    private boolean f11834m;
    private boolean f11835n;
    private int f11836o;
    private int f11837p;
    private final Rect f11838q;
    private final Rect f11839r;
    private final Rect f11840s;
    private final Rect f11841t;
    private final Rect f11842u;
    private final Rect f11843v;
    private final Rect f11844w;
    private ActionBarVisibilityCallback f11845x;
    private final int f11846y;
    private OverScroller f11847z;

    class C01911 extends AnimatorListenerAdapter {
        final /* synthetic */ ActionBarOverlayLayout f2071a;

        C01911(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f2071a = actionBarOverlayLayout;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2071a.f11826d = null;
            this.f2071a.f11825c = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2071a.f11826d = null;
            this.f2071a.f11825c = false;
        }
    }

    class C01922 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f2072a;

        C01922(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f2072a = actionBarOverlayLayout;
        }

        public void run() {
            this.f2072a.m10525a();
            this.f2072a.f11826d = this.f2072a.f11823a.animate().translationY(0.0f).setListener(this.f2072a.f11827e);
        }
    }

    class C01933 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f2073a;

        C01933(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f2073a = actionBarOverlayLayout;
        }

        public void run() {
            this.f2073a.m10525a();
            this.f2073a.f11826d = this.f2073a.f11823a.animate().translationY((float) (-this.f2073a.f11823a.getHeight())).setListener(this.f2073a.f11827e);
        }
    }

    public interface ActionBarVisibilityCallback {
        void mo476b(int i);

        void mo477g(boolean z);

        void mo478l();

        void mo479m();

        void mo480n();
    }

    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11829h = null;
        this.f11838q = new Rect();
        this.f11839r = new Rect();
        this.f11840s = new Rect();
        this.f11841t = new Rect();
        this.f11842u = new Rect();
        this.f11843v = new Rect();
        this.f11844w = new Rect();
        this.f11846y = 600;
        this.f11827e = new C01911(this);
        this.f11820A = new C01922(this);
        this.f11821B = new C01933(this);
        m10522a(context);
        this.f11822C = new NestedScrollingParentHelper(this);
    }

    private void m10522a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f11819f);
        boolean z = false;
        this.f11828g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11832k = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f11832k == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f11833l = z;
        this.f11847z = new OverScroller(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10525a();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f11845x = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f11845x.mo476b(this.f11829h);
            if (this.f11837p != null) {
                onWindowSystemUiVisibilityChanged(this.f11837p);
                ViewCompat.m1264y(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f11824b = z;
        z = z && getContext().getApplicationInfo().targetSdkVersion < true;
        this.f11833l = z;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f11834m = z;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m10522a(getContext());
        ViewCompat.m1264y(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m10524i();
        int i2 = this.f11837p ^ i;
        this.f11837p = i;
        int i3 = 0;
        int i4 = (i & 4) == 0 ? 1 : 0;
        if ((i & 256) != 0) {
            i3 = 1;
        }
        if (this.f11845x != 0) {
            this.f11845x.mo477g(i3 ^ 1);
            if (i4 == 0) {
                if (i3 != 0) {
                    this.f11845x.mo479m();
                }
            }
            this.f11845x.mo478l();
        }
        if ((i2 & 256) != 0 && this.f11845x != 0) {
            ViewCompat.m1264y(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f11829h = i;
        if (this.f11845x != null) {
            this.f11845x.mo476b(i);
        }
    }

    private static boolean m10523a(View view, Rect rect, boolean z) {
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        } else {
            z2 = false;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        m10524i();
        ViewCompat.m1263x(this);
        boolean a = m10523a(this.f11823a, rect, false);
        this.f11841t.set(rect);
        ViewUtils.m2389a(this, this.f11841t, this.f11838q);
        if (this.f11842u.equals(this.f11841t) == null) {
            this.f11842u.set(this.f11841t);
            a = true;
        }
        if (this.f11839r.equals(this.f11838q) == null) {
            this.f11839r.set(this.f11838q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m10524i();
        measureChildWithMargins(this.f11823a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f11823a.getLayoutParams();
        int max = Math.max(0, (this.f11823a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, (this.f11823a.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f11823a.getMeasuredState());
        boolean z = (ViewCompat.m1263x(this) & 256) != 0;
        if (z) {
            i3 = this.f11828g;
            if (this.f11834m && this.f11823a.getTabContainer() != null) {
                i3 += this.f11828g;
            }
        } else {
            i3 = this.f11823a.getVisibility() != 8 ? this.f11823a.getMeasuredHeight() : 0;
        }
        this.f11840s.set(this.f11838q);
        this.f11843v.set(this.f11841t);
        Rect rect;
        if (this.f11824b || z) {
            rect = this.f11843v;
            rect.top += i3;
            rect = this.f11843v;
            rect.bottom += 0;
        } else {
            rect = this.f11840s;
            rect.top += i3;
            rect = this.f11840s;
            rect.bottom += 0;
        }
        m10523a(this.f11830i, this.f11840s, true);
        if (!this.f11844w.equals(this.f11843v)) {
            this.f11844w.set(this.f11843v);
            this.f11830i.m1914a(this.f11843v);
        }
        measureChildWithMargins(this.f11830i, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f11830i.getLayoutParams();
        max = Math.max(max, (this.f11830i.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin);
        max2 = Math.max(max2, (this.f11830i.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f11830i.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        i = getPaddingLeft();
        getPaddingRight();
        i2 = getPaddingTop();
        getPaddingBottom();
        for (boolean z2 = false; z2 < z; z2++) {
            i4 = getChildAt(z2);
            if (i4.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) i4.getLayoutParams();
                int i5 = layoutParams.leftMargin + i;
                int i6 = layoutParams.topMargin + i2;
                i4.layout(i5, i6, i4.getMeasuredWidth() + i5, i4.getMeasuredHeight() + i6);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f11832k != null && !this.f11833l) {
            int bottom = this.f11823a.getVisibility() == 0 ? (int) ((((float) this.f11823a.getBottom()) + this.f11823a.getTranslationY()) + 0.5f) : 0;
            this.f11832k.setBounds(0, bottom, getWidth(), this.f11832k.getIntrinsicHeight() + bottom);
            this.f11832k.draw(canvas);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) != null) {
            if (this.f11823a.getVisibility() == null) {
                return this.f11835n;
            }
        }
        return null;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f11822C.f1447a = i;
        this.f11836o = getActionBarHideOffset();
        m10525a();
        if (this.f11845x != null) {
            this.f11845x.mo480n();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f11836o += i2;
        setActionBarHideOffset(this.f11836o);
    }

    public void onStopNestedScroll(View view) {
        if (this.f11835n != null && this.f11825c == null) {
            if (this.f11836o <= this.f11823a.getHeight()) {
                m10525a();
                postDelayed(this.f11820A, 600);
                return;
            }
            m10525a();
            postDelayed(this.f11821B, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        f = 0.0f;
        if (this.f11835n != null) {
            if (z) {
                this.f11847z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, RedditJobManager.f10810d);
                if (this.f11847z.getFinalY() > this.f11823a.getHeight()) {
                    f = Float.MIN_VALUE;
                }
                if (f != null) {
                    m10525a();
                    this.f11821B.run();
                } else {
                    m10525a();
                    this.f11820A.run();
                }
                this.f11825c = true;
                return true;
            }
        }
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f11822C.f1447a;
    }

    private void m10524i() {
        if (this.f11830i == null) {
            DecorToolbar decorToolbar;
            this.f11830i = (ContentFrameLayout) findViewById(C0164R.id.action_bar_activity_content);
            this.f11823a = (ActionBarContainer) findViewById(C0164R.id.action_bar_container);
            View findViewById = findViewById(C0164R.id.action_bar);
            if (findViewById instanceof DecorToolbar) {
                decorToolbar = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                decorToolbar = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder stringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
                stringBuilder.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.f11831j = decorToolbar;
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f11835n) {
            this.f11835n = z;
            if (!z) {
                m10525a();
                setActionBarHideOffset(false);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f11823a != null ? -((int) this.f11823a.getTranslationY()) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m10525a();
        this.f11823a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f11823a.getHeight()))));
    }

    final void m10525a() {
        removeCallbacks(this.f11820A);
        removeCallbacks(this.f11821B);
        if (this.f11826d != null) {
            this.f11826d.cancel();
        }
    }

    public void setWindowCallback(Callback callback) {
        m10524i();
        this.f11831j.mo742a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m10524i();
        this.f11831j.mo743a(charSequence);
    }

    public CharSequence getTitle() {
        m10524i();
        return this.f11831j.mo753e();
    }

    public final void mo556a(int i) {
        m10524i();
        if (i == 2) {
            this.f11831j.mo754f();
        } else if (i != 5) {
            if (i == 109) {
                setOverlayMode(1);
            }
        } else {
            this.f11831j.mo755g();
        }
    }

    public void setIcon(int i) {
        m10524i();
        this.f11831j.mo737a(i);
    }

    public void setIcon(Drawable drawable) {
        m10524i();
        this.f11831j.mo738a(drawable);
    }

    public void setLogo(int i) {
        m10524i();
        this.f11831j.mo746b(i);
    }

    public final boolean mo558b() {
        m10524i();
        return this.f11831j.mo756h();
    }

    public final boolean mo559c() {
        m10524i();
        return this.f11831j.mo757i();
    }

    public final boolean mo560d() {
        m10524i();
        return this.f11831j.mo758j();
    }

    public final boolean mo561e() {
        m10524i();
        return this.f11831j.mo759k();
    }

    public final boolean mo562f() {
        m10524i();
        return this.f11831j.mo760l();
    }

    public final void mo563g() {
        m10524i();
        this.f11831j.mo761m();
    }

    public final void mo557a(Menu menu, MenuPresenter.Callback callback) {
        m10524i();
        this.f11831j.mo741a(menu, callback);
    }

    public final void mo564h() {
        m10524i();
        this.f11831j.mo762n();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
