package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private static final int[] f11497D = new int[]{16842766};
    private static final String f11498m = "SwipeRefreshLayout";
    private int f11499A;
    private boolean f11500B;
    private final DecelerateInterpolator f11501C;
    private int f11502E;
    private Animation f11503F;
    private Animation f11504G;
    private Animation f11505H;
    private Animation f11506I;
    private Animation f11507J;
    private int f11508K;
    private OnChildScrollUpCallback f11509L;
    private AnimationListener f11510M;
    private final Animation f11511N;
    private final Animation f11512O;
    OnRefreshListener f11513a;
    public boolean f11514b;
    int f11515c;
    boolean f11516d;
    CircleImageView f11517e;
    protected int f11518f;
    float f11519g;
    protected int f11520h;
    int f11521i;
    CircularProgressDrawable f11522j;
    boolean f11523k;
    boolean f11524l;
    private View f11525n;
    private int f11526o;
    private float f11527p;
    private float f11528q;
    private final NestedScrollingParentHelper f11529r;
    private final NestedScrollingChildHelper f11530s;
    private final int[] f11531t;
    private final int[] f11532u;
    private boolean f11533v;
    private int f11534w;
    private float f11535x;
    private float f11536y;
    private boolean f11537z;

    class C01401 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1657a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C01401(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1657a = swipeRefreshLayout;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1657a.f11514b != null) {
                this.f1657a.f11522j.setAlpha(255);
                this.f1657a.f11522j.start();
                if (!(this.f1657a.f11523k == null || this.f1657a.f11513a == null)) {
                    this.f1657a.f11513a.m1420a();
                }
                this.f1657a.f11515c = this.f1657a.f11517e.getTop();
                return;
            }
            this.f1657a.m10218a();
        }
    }

    class C01412 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1658a;

        C01412(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1658a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1658a.setAnimationProgress(f);
        }
    }

    class C01423 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1659a;

        C01423(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1659a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1659a.setAnimationProgress(1.0f - f);
        }
    }

    class C01445 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1663a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C01445(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1663a = swipeRefreshLayout;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1663a.f11516d == null) {
                this.f1663a.m10220a(null);
            }
        }
    }

    class C01456 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1664a;

        C01456(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1664a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            if (this.f1664a.f11524l == null) {
                transformation = this.f1664a.f11521i - Math.abs(this.f1664a.f11520h);
            } else {
                transformation = this.f1664a.f11521i;
            }
            this.f1664a.setTargetOffsetTopAndBottom((this.f1664a.f11518f + ((int) (((float) (transformation - this.f1664a.f11518f)) * f))) - this.f1664a.f11517e.getTop());
            this.f1664a.f11522j.m1365a(1.0f - f);
        }
    }

    class C01467 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1665a;

        C01467(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1665a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1665a.m10219a(f);
        }
    }

    class C01478 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1666a;

        C01478(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1666a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1666a.setAnimationProgress(this.f1666a.f11519g + ((-this.f1666a.f11519g) * f));
            this.f1666a.m10219a(f);
        }
    }

    public interface OnChildScrollUpCallback {
        boolean m1419a();
    }

    public interface OnRefreshListener {
        void m1420a();
    }

    final void m10218a() {
        this.f11517e.clearAnimation();
        this.f11522j.stop();
        this.f11517e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f11516d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f11520h - this.f11515c);
        }
        this.f11515c = this.f11517e.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            m10218a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10218a();
    }

    private void setColorViewAlpha(int i) {
        this.f11517e.getBackground().setAlpha(i);
        this.f11522j.setAlpha(i);
    }

    public final void setProgressViewOffset$4958629f(int i) {
        this.f11516d = true;
        this.f11520h = i;
        this.f11521i = 300;
        this.f11524l = true;
        m10218a();
        this.f11514b = false;
    }

    public int getProgressViewStartOffset() {
        return this.f11520h;
    }

    public int getProgressViewEndOffset() {
        return this.f11521i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f11508K = (int) (56.0f * displayMetrics.density);
            } else {
                this.f11508K = (int) (40.0f * displayMetrics.density);
            }
            this.f11517e.setImageDrawable(null);
            this.f11522j.m1366a(i);
            this.f11517e.setImageDrawable(this.f11522j);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11514b = false;
        this.f11527p = -1.0f;
        this.f11531t = new int[2];
        this.f11532u = new int[2];
        this.f11499A = -1;
        this.f11502E = -1;
        this.f11510M = new C01401(this);
        this.f11511N = new C01456(this);
        this.f11512O = new C01467(this);
        this.f11526o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11534w = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f11501C = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f11508K = (int) (40.0f * displayMetrics.density);
        this.f11517e = new CircleImageView(getContext());
        this.f11522j = new CircularProgressDrawable(getContext());
        this.f11522j.m1366a(1);
        this.f11517e.setImageDrawable(this.f11522j);
        this.f11517e.setVisibility(8);
        addView(this.f11517e);
        setChildrenDrawingOrderEnabled(true);
        this.f11521i = (int) (64.0f * displayMetrics.density);
        this.f11527p = (float) this.f11521i;
        this.f11529r = new NestedScrollingParentHelper(this);
        this.f11530s = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.f11508K;
        this.f11515c = i;
        this.f11520h = i;
        m10219a(1.0f);
        context = context.obtainStyledAttributes(attributeSet, f11497D);
        setEnabled(context.getBoolean(0, true));
        context.recycle();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f11502E < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f11502E;
        }
        return i2 >= this.f11502E ? i2 + 1 : i2;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f11513a = onRefreshListener;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f11514b == z) {
            m10211a(z, false);
            return;
        }
        this.f11514b = z;
        if (this.f11524l) {
            z = this.f11521i;
        } else {
            z = this.f11521i + this.f11520h;
        }
        setTargetOffsetTopAndBottom(z - this.f11515c);
        this.f11523k = false;
        z = this.f11510M;
        this.f11517e.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f11522j.setAlpha(255);
        }
        this.f11503F = new C01412(this);
        this.f11503F.setDuration((long) this.f11534w);
        if (z) {
            this.f11517e.f1564a = z;
        }
        this.f11517e.clearAnimation();
        this.f11517e.startAnimation(this.f11503F);
    }

    void setAnimationProgress(float f) {
        this.f11517e.setScaleX(f);
        this.f11517e.setScaleY(f);
    }

    private void m10211a(boolean z, boolean z2) {
        if (this.f11514b != z) {
            this.f11523k = z2;
            m10214c();
            this.f11514b = z;
            if (this.f11514b) {
                z = this.f11515c;
                z2 = this.f11510M;
                this.f11518f = z;
                this.f11511N.reset();
                this.f11511N.setDuration(200);
                this.f11511N.setInterpolator(this.f11501C);
                if (z2) {
                    this.f11517e.f1564a = z2;
                }
                this.f11517e.clearAnimation();
                this.f11517e.startAnimation(this.f11511N);
                return;
            }
            m10220a(this.f11510M);
        }
    }

    final void m10220a(AnimationListener animationListener) {
        this.f11504G = new C01423(this);
        this.f11504G.setDuration(150);
        this.f11517e.f1564a = animationListener;
        this.f11517e.clearAnimation();
        this.f11517e.startAnimation(this.f11504G);
    }

    private Animation m10209a(final int i, final int i2) {
        Animation c01434 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout f1662c;

            public void applyTransformation(float f, Transformation transformation) {
                this.f1662c.f11522j.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        c01434.setDuration(300);
        this.f11517e.f1564a = 0;
        this.f11517e.clearAnimation();
        this.f11517e.startAnimation(c01434);
        return c01434;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.m719c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f11517e.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.m719c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m10214c();
        CircularProgressDrawable circularProgressDrawable = this.f11522j;
        circularProgressDrawable.f1594a.m1353a(iArr);
        circularProgressDrawable.f1594a.m1351a(0);
        circularProgressDrawable.invalidateSelf();
    }

    public final boolean m10221b() {
        return this.f11514b;
    }

    private void m10214c() {
        if (this.f11525n == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f11517e)) {
                    i++;
                } else {
                    this.f11525n = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f11527p = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getMeasuredWidth();
        i = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f11525n == 0) {
                m10214c();
            }
            if (this.f11525n != 0) {
                i2 = this.f11525n;
                i3 = getPaddingLeft();
                i4 = getPaddingTop();
                i2.layout(i3, i4, ((z - getPaddingLeft()) - getPaddingRight()) + i3, ((i - getPaddingTop()) - getPaddingBottom()) + i4);
                i = this.f11517e.getMeasuredWidth();
                z /= 2;
                i /= 2;
                this.f11517e.layout(z - i, this.f11515c, z + i, this.f11515c + this.f11517e.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11525n == 0) {
            m10214c();
        }
        if (this.f11525n != 0) {
            this.f11525n.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f11517e.measure(MeasureSpec.makeMeasureSpec(this.f11508K, 1073741824), MeasureSpec.makeMeasureSpec(this.f11508K, 1073741824));
            this.f11502E = -1;
            for (i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) == this.f11517e) {
                    this.f11502E = i;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f11508K;
    }

    private boolean m10217d() {
        if (this.f11509L != null) {
            return this.f11509L.m1419a();
        }
        if (this.f11525n instanceof ListView) {
            return ListViewCompat.m1410a((ListView) this.f11525n);
        }
        return this.f11525n.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.f11509L = onChildScrollUpCallback;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m10214c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11500B && actionMasked == 0) {
            this.f11500B = false;
        }
        if (!(!isEnabled() || this.f11500B || m10217d() || this.f11514b)) {
            if (!this.f11533v) {
                if (actionMasked != 6) {
                    switch (actionMasked) {
                        case 0:
                            setTargetOffsetTopAndBottom(this.f11520h - this.f11517e.getTop());
                            this.f11499A = motionEvent.getPointerId(0);
                            this.f11537z = false;
                            actionMasked = motionEvent.findPointerIndex(this.f11499A);
                            if (actionMasked >= 0) {
                                this.f11536y = motionEvent.getY(actionMasked);
                                break;
                            }
                            return false;
                        case 1:
                        case 3:
                            this.f11537z = false;
                            this.f11499A = -1;
                            break;
                        case 2:
                            if (this.f11499A != -1) {
                                actionMasked = motionEvent.findPointerIndex(this.f11499A);
                                if (actionMasked >= 0) {
                                    m10216d(motionEvent.getY(actionMasked));
                                    break;
                                }
                                return false;
                            }
                            Log.e(f11498m, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        default:
                            break;
                    }
                }
                m10210a(motionEvent);
                return this.f11537z;
            }
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f11525n instanceof AbsListView)) {
            return;
        }
        if (this.f11525n == null || ViewCompat.m1204E(this.f11525n)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (isEnabled() == null || this.f11500B != null || this.f11514b != null || (i & 2) == null) ? null : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f11529r.f1447a = i;
        startNestedScroll(i & 2);
        this.f11528q = null;
        this.f11533v = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f11528q > 0.0f) {
            float f = (float) i2;
            if (f > this.f11528q) {
                iArr[1] = i2 - ((int) this.f11528q);
                this.f11528q = 0.0f;
            } else {
                this.f11528q -= f;
                iArr[1] = i2;
            }
            m10213b(this.f11528q);
        }
        if (this.f11524l && i2 > 0 && this.f11528q == 0.0f && Math.abs(i2 - iArr[1]) > null) {
            this.f11517e.setVisibility(8);
        }
        view = this.f11531t;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], view, null) != 0) {
            iArr[0] = iArr[0] + view[0];
            iArr[1] = iArr[1] + view[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f11529r.f1447a;
    }

    public void onStopNestedScroll(View view) {
        this.f11529r.f1447a = 0;
        this.f11533v = false;
        if (this.f11528q > null) {
            m10215c(this.f11528q);
            this.f11528q = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f11532u);
        i4 += this.f11532u[1];
        if (i4 < 0 && m10217d() == null) {
            this.f11528q += (float) Math.abs(i4);
            m10213b(this.f11528q);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f11530s.m1124a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f11530s.f1442a;
    }

    public boolean startNestedScroll(int i) {
        return this.f11530s.m1128a(i, 0);
    }

    public void stopNestedScroll() {
        this.f11530s.m1133b(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.f11530s.m1127a(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f11530s.m1129a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f11530s.m1131a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f11530s.m1126a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f11530s.m1125a(f, f2);
    }

    private static boolean m10212a(Animation animation) {
        return (animation != null && animation.hasStarted() && animation.hasEnded() == null) ? true : null;
    }

    private void m10213b(float f) {
        this.f11522j.m1367a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f11527p));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f2 = (float) (this.f11524l ? this.f11521i - this.f11520h : this.f11521i);
        double max2 = (double) (Math.max(0.0f, Math.min(Math.abs(f) - this.f11527p, f2 * 2.0f) / f2) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i = this.f11520h + ((int) ((f2 * min) + ((f2 * pow) * 2.0f)));
        if (this.f11517e.getVisibility() != 0) {
            this.f11517e.setVisibility(0);
        }
        if (!this.f11516d) {
            this.f11517e.setScaleX(1.0f);
            this.f11517e.setScaleY(1.0f);
        }
        if (this.f11516d) {
            setAnimationProgress(Math.min(1.0f, f / this.f11527p));
        }
        if (f < this.f11527p) {
            if (this.f11522j.getAlpha() > 1.06E-43f && m10212a(this.f11505H) == null) {
                this.f11505H = m10209a(this.f11522j.getAlpha(), 76);
            }
        } else if (this.f11522j.getAlpha() < 3.57E-43f && m10212a(this.f11506I) == null) {
            this.f11506I = m10209a(this.f11522j.getAlpha(), 255);
        }
        this.f11522j.m1368b(Math.min(0.8f, max * 0.8f));
        this.f11522j.m1365a(Math.min(1.0f, max));
        f = ((-0.25f + (0.4f * max)) + (pow * 2.0f)) * 0.5f;
        CircularProgressDrawable circularProgressDrawable = this.f11522j;
        circularProgressDrawable.f1594a.f1576g = f;
        circularProgressDrawable.invalidateSelf();
        setTargetOffsetTopAndBottom(i - this.f11515c);
    }

    private void m10215c(float f) {
        if (f > this.f11527p) {
            m10211a(true, true);
            return;
        }
        this.f11514b = false;
        this.f11522j.m1368b(0.0f);
        AnimationListener animationListener = null;
        if (!this.f11516d) {
            animationListener = new C01445(this);
        }
        int i = this.f11515c;
        if (this.f11516d) {
            this.f11518f = i;
            this.f11519g = this.f11517e.getScaleX();
            this.f11507J = new C01478(this);
            this.f11507J.setDuration(150);
            if (animationListener != null) {
                this.f11517e.f1564a = animationListener;
            }
            this.f11517e.clearAnimation();
            this.f11517e.startAnimation(this.f11507J);
        } else {
            this.f11518f = i;
            this.f11512O.reset();
            this.f11512O.setDuration(200);
            this.f11512O.setInterpolator(this.f11501C);
            if (animationListener != null) {
                this.f11517e.f1564a = animationListener;
            }
            this.f11517e.clearAnimation();
            this.f11517e.startAnimation(this.f11512O);
        }
        this.f11522j.m1367a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11500B && actionMasked == 0) {
            this.f11500B = false;
        }
        if (!(!isEnabled() || this.f11500B || m10217d() || this.f11514b)) {
            if (!this.f11533v) {
                switch (actionMasked) {
                    case 0:
                        this.f11499A = motionEvent.getPointerId(0);
                        this.f11537z = false;
                        break;
                    case 1:
                        actionMasked = motionEvent.findPointerIndex(this.f11499A);
                        if (actionMasked < 0) {
                            Log.e(f11498m, "Got ACTION_UP event but don't have an active pointer id.");
                            return false;
                        }
                        if (this.f11537z) {
                            motionEvent = (motionEvent.getY(actionMasked) - this.f11535x) * 1056964608;
                            this.f11537z = false;
                            m10215c(motionEvent);
                        }
                        this.f11499A = -1;
                        return false;
                    case 2:
                        actionMasked = motionEvent.findPointerIndex(this.f11499A);
                        if (actionMasked < 0) {
                            Log.e(f11498m, "Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        motionEvent = motionEvent.getY(actionMasked);
                        m10216d(motionEvent);
                        if (this.f11537z) {
                            motionEvent = (motionEvent - this.f11535x) * 1056964608;
                            if (motionEvent > 0.0f) {
                                m10213b(motionEvent);
                                break;
                            }
                            return false;
                        }
                        break;
                    case 3:
                        return false;
                    case 5:
                        actionMasked = motionEvent.getActionIndex();
                        if (actionMasked >= 0) {
                            this.f11499A = motionEvent.getPointerId(actionMasked);
                            break;
                        }
                        Log.e(f11498m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    case 6:
                        m10210a(motionEvent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        return false;
    }

    private void m10216d(float f) {
        if (f - this.f11536y > ((float) this.f11526o) && this.f11537z == null) {
            this.f11535x = this.f11536y + ((float) this.f11526o);
            this.f11537z = true;
            this.f11522j.setAlpha(76);
        }
    }

    final void m10219a(float f) {
        setTargetOffsetTopAndBottom((this.f11518f + ((int) (((float) (this.f11520h - this.f11518f)) * f))) - this.f11517e.getTop());
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.f11517e.bringToFront();
        ViewCompat.m1231b(this.f11517e, i);
        this.f11515c = this.f11517e.getTop();
    }

    private void m10210a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f11499A) {
            this.f11499A = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
