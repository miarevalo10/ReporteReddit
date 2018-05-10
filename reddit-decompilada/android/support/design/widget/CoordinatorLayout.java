package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0016R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {
    static final String f16419a;
    static final Class<?>[] f16420b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f16421c = new ThreadLocal();
    static final Comparator<View> f16422d;
    private static final Pool<Rect> f16423j = new SynchronizedPool(12);
    final DirectedAcyclicGraph<View> f16424e;
    final List<View> f16425f;
    WindowInsetsCompat f16426g;
    boolean f16427h;
    OnHierarchyChangeListener f16428i;
    private final List<View> f16429k;
    private final List<View> f16430l;
    private final int[] f16431m;
    private boolean f16432n;
    private boolean f16433o;
    private int[] f16434p;
    private View f16435q;
    private View f16436r;
    private OnPreDrawListener f16437s;
    private boolean f16438t;
    private Drawable f16439u;
    private OnApplyWindowInsetsListener f16440v;
    private final NestedScrollingParentHelper f16441w;

    public static abstract class Behavior<V extends View> {
        public static WindowInsetsCompat m223a(WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void mo86a(LayoutParams layoutParams) {
        }

        public void mo73a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void mo74a(V v, View view, int i, int[] iArr) {
        }

        public boolean mo75a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean mo3086a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean mo3831a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean mo76a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo3832a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean mo77a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public boolean mo78a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean mo87a(V v, Rect rect) {
            return false;
        }

        @Deprecated
        public void m240b(View view, int i) {
        }

        public boolean mo80b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo88b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public void mo81c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean mo3825a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            return i2 == 0 ? mo78a(coordinatorLayout, (View) v, view, view2, i) : null;
        }

        public void mo3821a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                mo81c(coordinatorLayout, v, view);
            }
        }

        public void mo3822a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3) {
            if (i3 == 0) {
                m240b(view, i);
            }
        }

        public void mo3823a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr, int i2) {
            if (i2 == 0) {
                mo74a((View) v, view, i, iArr);
            }
        }

        public Parcelable mo79b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> m244a();
    }

    private class HierarchyChangeListener implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f542a;

        HierarchyChangeListener(CoordinatorLayout coordinatorLayout) {
            this.f542a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f542a.f16428i != null) {
                this.f542a.f16428i.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f542a.m16545a(2);
            if (this.f542a.f16428i != null) {
                this.f542a.f16428i.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        Behavior f543a;
        boolean f544b = false;
        public int f545c = 0;
        public int f546d = 0;
        public int f547e = -1;
        int f548f = -1;
        public int f549g = 0;
        public int f550h = 0;
        int f551i;
        int f552j;
        View f553k;
        View f554l;
        boolean f555m;
        boolean f556n;
        final Rect f557o = new Rect();
        Object f558p;
        private boolean f559q;
        private boolean f560r;

        public LayoutParams() {
            super(-2, -2);
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0016R.styleable.CoordinatorLayout_Layout);
            this.f545c = obtainStyledAttributes.getInteger(C0016R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f548f = obtainStyledAttributes.getResourceId(C0016R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f546d = obtainStyledAttributes.getInteger(C0016R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f547e = obtainStyledAttributes.getInteger(C0016R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f549g = obtainStyledAttributes.getInt(C0016R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f550h = obtainStyledAttributes.getInt(C0016R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f544b = obtainStyledAttributes.hasValue(C0016R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f544b) {
                this.f543a = CoordinatorLayout.m16529a(context, attributeSet, obtainStyledAttributes.getString(C0016R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f543a != null) {
                this.f543a.mo86a(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void m246a(Behavior behavior) {
            if (this.f543a != behavior) {
                this.f543a = behavior;
                this.f558p = null;
                this.f544b = true;
                if (behavior != null) {
                    behavior.mo86a(this);
                }
            }
        }

        final void m245a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f559q = z;
                    return;
                case 1:
                    this.f560r = z;
                    break;
                default:
                    break;
            }
        }

        final boolean m247a(int i) {
            switch (i) {
                case 0:
                    return this.f559q;
                case 1:
                    return this.f560r;
                default:
                    return false;
            }
        }
    }

    class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f561a;

        OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
            this.f561a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f561a.m16545a(0);
            return true;
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            obj = ViewCompat.m1207H((View) obj);
            obj2 = ViewCompat.m1207H(view);
            if (obj > obj2) {
                return -1;
            }
            return obj < obj2 ? 1 : null;
        }
    }

    class C09841 implements OnApplyWindowInsetsListener {
        final /* synthetic */ CoordinatorLayout f11068a;

        C09841(CoordinatorLayout coordinatorLayout) {
            this.f11068a = coordinatorLayout;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            view = this.f11068a;
            if (!ObjectsCompat.m1037a(view.f16426g, windowInsetsCompat)) {
                view.f16426g = windowInsetsCompat;
                int i = 0;
                boolean z = true;
                boolean z2 = windowInsetsCompat != null && windowInsetsCompat.m1309b() > 0;
                view.f16427h = z2;
                if (view.f16427h || view.getBackground() != null) {
                    z = false;
                }
                view.setWillNotDraw(z);
                if (!windowInsetsCompat.m1312e()) {
                    int childCount = view.getChildCount();
                    while (i < childCount) {
                        View childAt = view.getChildAt(i);
                        if (ViewCompat.m1265z(childAt) && ((LayoutParams) childAt.getLayoutParams()).f543a != null) {
                            windowInsetsCompat = Behavior.m223a(windowInsetsCompat);
                            if (windowInsetsCompat.m1312e()) {
                                break;
                            }
                        }
                        i++;
                    }
                }
                view.requestLayout();
            }
            return windowInsetsCompat;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C00311();
        SparseArray<Parcelable> behaviorStates;

        static class C00311 implements ClassLoaderCreator<SavedState> {
            C00311() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            parcel = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray(readInt);
            for (classLoader = null; classLoader < readInt; classLoader++) {
                this.behaviorStates.append(iArr[classLoader], parcel[classLoader]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int i2 = 0;
            int size = this.behaviorStates != null ? this.behaviorStates.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.behaviorStates.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.behaviorStates.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private static int m16539c(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int m16541d(int i) {
        return i == 0 ? 8388661 : i;
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f16419a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f16422d = new ViewElevationComparator();
        } else {
            f16422d = null;
        }
    }

    private static Rect m16528a() {
        Rect rect = (Rect) f16423j.mo362a();
        return rect == null ? new Rect() : rect;
    }

    private static void m16531a(Rect rect) {
        rect.setEmpty();
        f16423j.mo363a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16429k = new ArrayList();
        this.f16424e = new DirectedAcyclicGraph();
        this.f16430l = new ArrayList();
        this.f16425f = new ArrayList();
        this.f16431m = new int[2];
        this.f16441w = new NestedScrollingParentHelper(this);
        ThemeUtils.m333a(context);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0016R.styleable.CoordinatorLayout, i, C0016R.style.Widget_Design_CoordinatorLayout);
        int i2 = 0;
        i = attributeSet.getResourceId(C0016R.styleable.CoordinatorLayout_keylines, 0);
        if (i != 0) {
            context = context.getResources();
            this.f16434p = context.getIntArray(i);
            context = context.getDisplayMetrics().density;
            i = this.f16434p.length;
            while (i2 < i) {
                this.f16434p[i2] = (int) (((float) this.f16434p[i2]) * context);
                i2++;
            }
        }
        this.f16439u = attributeSet.getDrawable(C0016R.styleable.CoordinatorLayout_statusBarBackground);
        attributeSet.recycle();
        m16540c();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f16428i = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m16534a(false);
        if (this.f16438t) {
            if (this.f16437s == null) {
                this.f16437s = new OnPreDrawListener(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f16437s);
        }
        if (this.f16426g == null && ViewCompat.m1265z(this)) {
            ViewCompat.m1264y(this);
        }
        this.f16433o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m16534a(false);
        if (this.f16438t && this.f16437s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f16437s);
        }
        if (this.f16436r != null) {
            onStopNestedScroll(this.f16436r);
        }
        this.f16433o = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.f16439u != drawable) {
            Drawable drawable2 = null;
            if (this.f16439u != null) {
                this.f16439u.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f16439u = drawable2;
            if (this.f16439u != null) {
                if (this.f16439u.isStateful() != null) {
                    this.f16439u.setState(getDrawableState());
                }
                DrawableCompat.m839b(this.f16439u, ViewCompat.m1242f(this));
                this.f16439u.setVisible(getVisibility() == 0, false);
                this.f16439u.setCallback(this);
            }
            ViewCompat.m1234c(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f16439u;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f16439u;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.f16439u) {
                return null;
            }
        }
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f16439u != null && this.f16439u.isVisible() != z) {
            this.f16439u.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.m714a(getContext(), i) : 0);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final WindowInsetsCompat getLastWindowInsets() {
        return this.f16426g;
    }

    private void m16534a(boolean z) {
        boolean childCount = getChildCount();
        for (boolean z2 = false; z2 < childCount; z2++) {
            View childAt = getChildAt(z2);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).f543a;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.mo76a(this, childAt, obtain);
                } else {
                    behavior.mo80b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (z = false; z < childCount; z++) {
            ((LayoutParams) getChildAt(z).getLayoutParams()).f555m = false;
        }
        this.f16432n = false;
    }

    private boolean m16535a(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f16430l;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        if (f16422d != null) {
            Collections.sort(list, f16422d);
        }
        int size = list.size();
        boolean z = false;
        boolean z2 = z;
        MotionEvent motionEvent3 = null;
        for (i2 = z2; i2 < size; i2++) {
            View view = (View) list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.f543a;
            if ((z || r8) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (i) {
                        case 0:
                            behavior.mo76a(r0, view, motionEvent3);
                            break;
                        case 1:
                            behavior.mo80b(r0, view, motionEvent3);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                boolean z3;
                if (!(z || behavior == null)) {
                    switch (i) {
                        case 0:
                            z = behavior.mo76a(r0, view, motionEvent2);
                            break;
                        case 1:
                            z = behavior.mo80b(r0, view, motionEvent2);
                            break;
                        default:
                            break;
                    }
                    if (z) {
                        r0.f16435q = view;
                    }
                }
                if (layoutParams.f543a == null) {
                    layoutParams.f555m = false;
                }
                z2 = layoutParams.f555m;
                boolean z4 = true;
                if (layoutParams.f555m) {
                    z3 = true;
                } else {
                    z3 = layoutParams.f555m | false;
                    layoutParams.f555m = z3;
                }
                if (!z3 || z2) {
                    z4 = false;
                }
                if (!z3 || z4) {
                    z2 = z4;
                } else {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m16534a(true);
        }
        motionEvent = m16535a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m16534a(true);
        }
        return motionEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean b;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        boolean a;
        Behavior behavior;
        if (this.f16435q == null) {
            a = m16535a(motionEvent3, 1);
            if (a) {
                behavior = ((LayoutParams) r0.f16435q.getLayoutParams()).f543a;
                if (behavior != null) {
                    b = behavior.mo80b(r0, r0.f16435q, motionEvent3);
                    motionEvent2 = null;
                    if (r0.f16435q != null) {
                        b |= super.onTouchEvent(motionEvent);
                    } else if (a) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        super.onTouchEvent(motionEvent2);
                    }
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (actionMasked == 1 || actionMasked == 3) {
                        m16534a(false);
                    }
                    return b;
                }
            }
        }
        a = false;
        behavior = ((LayoutParams) r0.f16435q.getLayoutParams()).f543a;
        if (behavior != null) {
            b = behavior.mo80b(r0, r0.f16435q, motionEvent3);
            motionEvent2 = null;
            if (r0.f16435q != null) {
                b |= super.onTouchEvent(motionEvent);
            } else if (a) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            m16534a(false);
            return b;
        }
        b = false;
        motionEvent2 = null;
        if (r0.f16435q != null) {
            b |= super.onTouchEvent(motionEvent);
        } else if (a) {
            long uptimeMillis22 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis22, uptimeMillis22, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m16534a(false);
        return b;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f16432n) {
            m16534a(false);
            this.f16432n = true;
        }
    }

    private int m16536b(int i) {
        if (this.f16434p == null) {
            StringBuilder stringBuilder = new StringBuilder("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(i);
            Log.e("CoordinatorLayout", stringBuilder.toString());
            return 0;
        }
        if (i >= 0) {
            if (i < this.f16434p.length) {
                return this.f16434p[i];
            }
        }
        stringBuilder = new StringBuilder("Keyline index ");
        stringBuilder.append(i);
        stringBuilder.append(" out of range for ");
        stringBuilder.append(this);
        Log.e("CoordinatorLayout", stringBuilder.toString());
        return 0;
    }

    static Behavior m16529a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f16419a)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f16419a);
            stringBuilder2.append('.');
            stringBuilder2.append(str);
            str = stringBuilder2.toString();
        }
        try {
            Map map = (Map) f16421c.get();
            if (map == null) {
                map = new HashMap();
                f16421c.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f16420b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Context context2) {
            stringBuilder = new StringBuilder("Could not inflate Behavior subclass ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), context2);
        }
    }

    private static LayoutParams m16537b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f544b) {
            DefaultBehavior defaultBehavior = null;
            for (view = view.getClass(); view != null; view = view.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) view.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            if (defaultBehavior != null) {
                try {
                    layoutParams.m246a((Behavior) defaultBehavior.m244a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (View view2) {
                    StringBuilder stringBuilder = new StringBuilder("Default behavior class ");
                    stringBuilder.append(defaultBehavior.m244a().getName());
                    stringBuilder.append(" could not be instantiated. Did you forget a default constructor?");
                    Log.e("CoordinatorLayout", stringBuilder.toString(), view2);
                }
            }
            layoutParams.f544b = true;
        }
        return layoutParams;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16538b() {
        /*
        r11 = this;
        r0 = r11.f16429k;
        r0.clear();
        r0 = r11.f16424e;
        r1 = r0.f563b;
        r1 = r1.size();
        r2 = 0;
        r3 = r2;
    L_0x000f:
        if (r3 >= r1) goto L_0x0026;
    L_0x0011:
        r4 = r0.f563b;
        r4 = r4.m1054c(r3);
        r4 = (java.util.ArrayList) r4;
        if (r4 == 0) goto L_0x0023;
    L_0x001b:
        r4.clear();
        r5 = r0.f562a;
        r5.mo363a(r4);
    L_0x0023:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x0026:
        r0 = r0.f563b;
        r0.clear();
        r0 = r11.getChildCount();
        r1 = r2;
    L_0x0030:
        if (r1 >= r0) goto L_0x0197;
    L_0x0032:
        r3 = r11.getChildAt(r1);
        r4 = m16537b(r3);
        r5 = r4.f548f;
        r6 = -1;
        r7 = 0;
        r8 = 1;
        if (r5 != r6) goto L_0x0047;
    L_0x0041:
        r4.f554l = r7;
        r4.f553k = r7;
        goto L_0x00d9;
    L_0x0047:
        r5 = r4.f553k;
        if (r5 == 0) goto L_0x007c;
    L_0x004b:
        r5 = r4.f553k;
        r5 = r5.getId();
        r6 = r4.f548f;
        if (r5 == r6) goto L_0x0057;
    L_0x0055:
        r5 = r2;
        goto L_0x007a;
    L_0x0057:
        r5 = r4.f553k;
        r6 = r4.f553k;
        r6 = r6.getParent();
    L_0x005f:
        if (r6 == r11) goto L_0x0077;
    L_0x0061:
        if (r6 == 0) goto L_0x0072;
    L_0x0063:
        if (r6 != r3) goto L_0x0066;
    L_0x0065:
        goto L_0x0072;
    L_0x0066:
        r9 = r6 instanceof android.view.View;
        if (r9 == 0) goto L_0x006d;
    L_0x006a:
        r5 = r6;
        r5 = (android.view.View) r5;
    L_0x006d:
        r6 = r6.getParent();
        goto L_0x005f;
    L_0x0072:
        r4.f554l = r7;
        r4.f553k = r7;
        goto L_0x0055;
    L_0x0077:
        r4.f554l = r5;
        r5 = r8;
    L_0x007a:
        if (r5 != 0) goto L_0x00d9;
    L_0x007c:
        r5 = r4.f548f;
        r5 = r11.findViewById(r5);
        r4.f553k = r5;
        r5 = r4.f553k;
        if (r5 == 0) goto L_0x00cf;
    L_0x0088:
        r5 = r4.f553k;
        if (r5 != r11) goto L_0x009f;
    L_0x008c:
        r5 = r11.isInEditMode();
        if (r5 == 0) goto L_0x0097;
    L_0x0092:
        r4.f554l = r7;
        r4.f553k = r7;
        goto L_0x00d9;
    L_0x0097:
        r0 = new java.lang.IllegalStateException;
        r1 = "View can not be anchored to the the parent CoordinatorLayout";
        r0.<init>(r1);
        throw r0;
    L_0x009f:
        r5 = r4.f553k;
        r6 = r4.f553k;
        r6 = r6.getParent();
    L_0x00a7:
        if (r6 == r11) goto L_0x00cc;
    L_0x00a9:
        if (r6 == 0) goto L_0x00cc;
    L_0x00ab:
        if (r6 != r3) goto L_0x00c0;
    L_0x00ad:
        r5 = r11.isInEditMode();
        if (r5 == 0) goto L_0x00b8;
    L_0x00b3:
        r4.f554l = r7;
        r4.f553k = r7;
        goto L_0x00d9;
    L_0x00b8:
        r0 = new java.lang.IllegalStateException;
        r1 = "Anchor must not be a descendant of the anchored view";
        r0.<init>(r1);
        throw r0;
    L_0x00c0:
        r9 = r6 instanceof android.view.View;
        if (r9 == 0) goto L_0x00c7;
    L_0x00c4:
        r5 = r6;
        r5 = (android.view.View) r5;
    L_0x00c7:
        r6 = r6.getParent();
        goto L_0x00a7;
    L_0x00cc:
        r4.f554l = r5;
        goto L_0x00d9;
    L_0x00cf:
        r5 = r11.isInEditMode();
        if (r5 == 0) goto L_0x0171;
    L_0x00d5:
        r4.f554l = r7;
        r4.f553k = r7;
    L_0x00d9:
        r5 = r11.f16424e;
        r5.m250a(r3);
        r5 = r2;
    L_0x00df:
        if (r5 >= r0) goto L_0x016d;
    L_0x00e1:
        if (r5 == r1) goto L_0x0169;
    L_0x00e3:
        r6 = r11.getChildAt(r5);
        r7 = r4.f554l;
        if (r6 == r7) goto L_0x011a;
    L_0x00eb:
        r7 = android.support.v4.view.ViewCompat.m1242f(r11);
        r9 = r6.getLayoutParams();
        r9 = (android.support.design.widget.CoordinatorLayout.LayoutParams) r9;
        r9 = r9.f549g;
        r9 = android.support.v4.view.GravityCompat.m1096a(r9, r7);
        if (r9 == 0) goto L_0x0108;
    L_0x00fd:
        r10 = r4.f550h;
        r7 = android.support.v4.view.GravityCompat.m1096a(r10, r7);
        r7 = r7 & r9;
        if (r7 != r9) goto L_0x0108;
    L_0x0106:
        r7 = r8;
        goto L_0x0109;
    L_0x0108:
        r7 = r2;
    L_0x0109:
        if (r7 != 0) goto L_0x011a;
    L_0x010b:
        r7 = r4.f543a;
        if (r7 == 0) goto L_0x0118;
    L_0x010f:
        r7 = r4.f543a;
        r7 = r7.mo3832a(r11, r3, r6);
        if (r7 == 0) goto L_0x0118;
    L_0x0117:
        goto L_0x011a;
    L_0x0118:
        r7 = r2;
        goto L_0x011b;
    L_0x011a:
        r7 = r8;
    L_0x011b:
        if (r7 == 0) goto L_0x0169;
    L_0x011d:
        r7 = r11.f16424e;
        r7 = r7.f563b;
        r7 = r7.containsKey(r6);
        if (r7 != 0) goto L_0x012c;
    L_0x0127:
        r7 = r11.f16424e;
        r7.m250a(r6);
    L_0x012c:
        r7 = r11.f16424e;
        r9 = r7.f563b;
        r9 = r9.containsKey(r6);
        if (r9 == 0) goto L_0x0161;
    L_0x0136:
        r9 = r7.f563b;
        r9 = r9.containsKey(r3);
        if (r9 != 0) goto L_0x013f;
    L_0x013e:
        goto L_0x0161;
    L_0x013f:
        r9 = r7.f563b;
        r9 = r9.get(r6);
        r9 = (java.util.ArrayList) r9;
        if (r9 != 0) goto L_0x015d;
    L_0x0149:
        r9 = r7.f562a;
        r9 = r9.mo362a();
        r9 = (java.util.ArrayList) r9;
        if (r9 != 0) goto L_0x0158;
    L_0x0153:
        r9 = new java.util.ArrayList;
        r9.<init>();
    L_0x0158:
        r7 = r7.f563b;
        r7.put(r6, r9);
    L_0x015d:
        r9.add(r3);
        goto L_0x0169;
    L_0x0161:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "All nodes must be present in the graph before being added as an edge";
        r0.<init>(r1);
        throw r0;
    L_0x0169:
        r5 = r5 + 1;
        goto L_0x00df;
    L_0x016d:
        r1 = r1 + 1;
        goto L_0x0030;
    L_0x0171:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Could not find CoordinatorLayout descendant view with id ";
        r1.<init>(r2);
        r2 = r11.getResources();
        r4 = r4.f548f;
        r2 = r2.getResourceName(r4);
        r1.append(r2);
        r2 = " to anchor view ";
        r1.append(r2);
        r1.append(r3);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0197:
        r0 = r11.f16429k;
        r1 = r11.f16424e;
        r1 = r1.m249a();
        r0.addAll(r1);
        r0 = r11.f16429k;
        java.util.Collections.reverse(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.b():void");
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void m16548a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int size;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        CoordinatorLayout coordinatorLayout = this;
        m16538b();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            DirectedAcyclicGraph directedAcyclicGraph = coordinatorLayout.f16424e;
            size = directedAcyclicGraph.f563b.size();
            for (i4 = 0; i4 < size; i4++) {
                ArrayList arrayList = (ArrayList) directedAcyclicGraph.f563b.m1054c(i4);
                if (arrayList != null && arrayList.contains(childAt)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2 != coordinatorLayout.f16438t) {
            if (z2) {
                if (coordinatorLayout.f16433o) {
                    if (coordinatorLayout.f16437s == null) {
                        coordinatorLayout.f16437s = new OnPreDrawListener(coordinatorLayout);
                    }
                    getViewTreeObserver().addOnPreDrawListener(coordinatorLayout.f16437s);
                }
                coordinatorLayout.f16438t = true;
            } else {
                if (coordinatorLayout.f16433o && coordinatorLayout.f16437s != null) {
                    getViewTreeObserver().removeOnPreDrawListener(coordinatorLayout.f16437s);
                }
                coordinatorLayout.f16438t = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        childCount = getPaddingTop();
        int paddingRight = getPaddingRight();
        i3 = getPaddingBottom();
        int f = ViewCompat.m1242f(this);
        boolean z4 = f == 1;
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size3 = MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = childCount + i3;
        childCount = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        boolean z5 = coordinatorLayout.f16426g != null && ViewCompat.m1265z(this);
        i4 = coordinatorLayout.f16429k.size();
        int i7 = childCount;
        int i8 = i3;
        z = false;
        size = z;
        while (size < i4) {
            int i9;
            Object obj;
            int i10;
            View view = (View) coordinatorLayout.f16429k.get(size);
            int i11;
            if (view.getVisibility() != 8) {
                int i12;
                boolean z6;
                int max;
                int i13;
                int i14;
                Behavior behavior;
                View view2;
                int i15;
                int i16;
                boolean z7;
                View view3;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.f547e < 0 || mode == 0) {
                    i12 = i8;
                    z6 = z;
                } else {
                    childCount = m16536b(layoutParams.f547e);
                    i12 = i8;
                    i8 = GravityCompat.m1096a(m16541d(layoutParams.f545c), f) & 7;
                    z6 = z;
                    if ((i8 == 3 && !z4) || (i8 == 5 && z4)) {
                        i11 = 0;
                        max = Math.max(0, (size2 - paddingRight) - childCount);
                        if (z5) {
                        }
                        i13 = i;
                        i14 = i2;
                        behavior = layoutParams.f543a;
                        if (behavior != null) {
                            view2 = view;
                            i15 = i7;
                            i9 = i4;
                            i16 = i12;
                            z7 = z6;
                            obj = null;
                            i10 = size;
                            m16548a(view2, i13, max, i14, 0);
                        } else {
                            childAt = view;
                            i16 = i12;
                            view2 = childAt;
                            z7 = z6;
                            obj = null;
                            i15 = i7;
                            i10 = size;
                            i9 = i4;
                            if (!behavior.mo3086a(coordinatorLayout, childAt, i13, max, i14, 0)) {
                                m16548a(view2, i13, max, i14, 0);
                            }
                        }
                        view3 = view2;
                        i3 = Math.max(i15, ((i5 + view3.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                        i8 = Math.max(i16, ((i6 + view3.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                        z = View.combineMeasuredStates(z7, view3.getMeasuredState());
                        i7 = i3;
                    } else if ((i8 == 5 && !z4) || (i8 == 3 && z4)) {
                        max = Math.max(0, childCount - paddingLeft);
                        if (z5 || ViewCompat.m1265z(view)) {
                            i13 = i;
                            i14 = i2;
                        } else {
                            i8 = coordinatorLayout.f16426g.m1309b() + coordinatorLayout.f16426g.m1311d();
                            i13 = MeasureSpec.makeMeasureSpec(size2 - (coordinatorLayout.f16426g.m1307a() + coordinatorLayout.f16426g.m1310c()), mode);
                            i14 = MeasureSpec.makeMeasureSpec(size3 - i8, mode2);
                        }
                        behavior = layoutParams.f543a;
                        if (behavior != null) {
                            childAt = view;
                            i16 = i12;
                            view2 = childAt;
                            z7 = z6;
                            obj = null;
                            i15 = i7;
                            i10 = size;
                            i9 = i4;
                            if (behavior.mo3086a(coordinatorLayout, childAt, i13, max, i14, 0)) {
                                m16548a(view2, i13, max, i14, 0);
                            }
                        } else {
                            view2 = view;
                            i15 = i7;
                            i9 = i4;
                            i16 = i12;
                            z7 = z6;
                            obj = null;
                            i10 = size;
                            m16548a(view2, i13, max, i14, 0);
                        }
                        view3 = view2;
                        i3 = Math.max(i15, ((i5 + view3.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                        i8 = Math.max(i16, ((i6 + view3.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                        z = View.combineMeasuredStates(z7, view3.getMeasuredState());
                        i7 = i3;
                    }
                }
                max = 0;
                if (z5) {
                }
                i13 = i;
                i14 = i2;
                behavior = layoutParams.f543a;
                if (behavior != null) {
                    childAt = view;
                    i16 = i12;
                    view2 = childAt;
                    z7 = z6;
                    obj = null;
                    i15 = i7;
                    i10 = size;
                    i9 = i4;
                    if (behavior.mo3086a(coordinatorLayout, childAt, i13, max, i14, 0)) {
                        m16548a(view2, i13, max, i14, 0);
                    }
                } else {
                    view2 = view;
                    i15 = i7;
                    i9 = i4;
                    i16 = i12;
                    z7 = z6;
                    obj = null;
                    i10 = size;
                    m16548a(view2, i13, max, i14, 0);
                }
                view3 = view2;
                i3 = Math.max(i15, ((i5 + view3.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                i8 = Math.max(i16, ((i6 + view3.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                z = View.combineMeasuredStates(z7, view3.getMeasuredState());
                i7 = i3;
            } else {
                z3 = z;
                i10 = size;
                i9 = i4;
                obj = null;
                i11 = i8;
                i8 = i7;
                i8 = i11;
                z = z3;
            }
            size = i10 + 1;
            Object obj2 = obj;
            i4 = i9;
        }
        z3 = z;
        setMeasuredDimension(View.resolveSizeAndState(i7, i, -16777216 & z3), View.resolveSizeAndState(i8, i2, z3 << 16));
    }

    public final void m16546a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = 0;
        int i3 = (layoutParams.f553k != null || layoutParams.f548f == -1) ? 0 : 1;
        if (i3 != 0) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (layoutParams.f553k != null) {
            View view2 = layoutParams.f553k;
            view.getLayoutParams();
            r7 = m16528a();
            r8 = m16528a();
            try {
                ViewGroupUtils.m352a((ViewGroup) this, view2, r7);
                layoutParams = (LayoutParams) view.getLayoutParams();
                r9 = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                m16530a(i, r7, r8, layoutParams, r9, measuredHeight);
                m16532a(layoutParams, r8, r9, measuredHeight);
                view.layout(r8.left, r8.top, r8.right, r8.bottom);
            } finally {
                m16531a(r7);
                m16531a(r8);
            }
        } else if (layoutParams.f547e >= 0) {
            int i4 = layoutParams.f547e;
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            int a = GravityCompat.m1096a(m16541d(layoutParams2.f545c), i);
            int i5 = a & 7;
            a &= 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            r9 = view.getMeasuredHeight();
            if (i == 1) {
                i4 = width - i4;
            }
            i = m16536b(i4) - measuredWidth;
            if (i5 == 1) {
                i += measuredWidth / 2;
            } else if (i5 == 5) {
                i += measuredWidth;
            }
            if (a == 16) {
                i2 = 0 + (r9 / 2);
            } else if (a == 80) {
                i2 = 0 + r9;
            }
            i = Math.max(getPaddingLeft() + layoutParams2.leftMargin, Math.min(i, ((width - getPaddingRight()) - measuredWidth) - layoutParams2.rightMargin));
            i4 = Math.max(getPaddingTop() + layoutParams2.topMargin, Math.min(i2, ((height - getPaddingBottom()) - r9) - layoutParams2.bottomMargin));
            view.layout(i, i4, measuredWidth + i, r9 + i4);
        } else {
            layoutParams = (LayoutParams) view.getLayoutParams();
            r7 = m16528a();
            r7.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
            if (!(this.f16426g == null || !ViewCompat.m1265z(this) || ViewCompat.m1265z(view))) {
                r7.left += this.f16426g.m1307a();
                r7.top += this.f16426g.m1309b();
                r7.right -= this.f16426g.m1310c();
                r7.bottom -= this.f16426g.m1311d();
            }
            r8 = m16528a();
            GravityCompat.m1097a(m16539c(layoutParams.f545c), view.getMeasuredWidth(), view.getMeasuredHeight(), r7, r8, i);
            view.layout(r8.left, r8.top, r8.right, r8.bottom);
            m16531a(r7);
            m16531a(r8);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int f = ViewCompat.m1242f(this);
        i = this.f16429k.size();
        for (i2 = 0; i2 < i; i2++) {
            View view = (View) this.f16429k.get(i2);
            if (view.getVisibility() != 8) {
                i4 = ((LayoutParams) view.getLayoutParams()).f543a;
                if (i4 == 0 || i4.mo75a(this, view, f) == 0) {
                    m16546a(view, f);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16427h && this.f16439u != null) {
            int b = this.f16426g != null ? this.f16426g.m1309b() : 0;
            if (b > 0) {
                this.f16439u.setBounds(0, 0, getWidth(), b);
                this.f16439u.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m16540c();
    }

    private void m16533a(View view, boolean z, Rect rect) {
        if (!view.isLayoutRequested()) {
            if (view.getVisibility() != 8) {
                if (z) {
                    ViewGroupUtils.m352a((ViewGroup) this, view, rect);
                    return;
                } else {
                    rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    return;
                }
            }
        }
        rect.setEmpty();
    }

    private static void m16530a(int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int i4 = layoutParams.f545c;
        if (i4 == 0) {
            i4 = 17;
        }
        i4 = GravityCompat.m1096a(i4, i);
        i = GravityCompat.m1096a(m16539c(layoutParams.f546d), i);
        layoutParams = i4 & 7;
        i4 &= 112;
        int i5 = i & 7;
        i &= 112;
        if (i5 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i5 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i == 16) {
            i = rect.top + (rect.height() / 2);
        } else if (i != 80) {
            i = rect.top;
        } else {
            i = rect.bottom;
        }
        if (layoutParams == 1) {
            i5 -= i2 / 2;
        } else if (layoutParams != 5) {
            i5 -= i2;
        }
        if (i4 == 16) {
            i -= i3 / 2;
        } else if (i4 != 80) {
            i -= i3;
        }
        rect2.set(i5, i, i2 + i5, i3 + i);
    }

    private void m16532a(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        layoutParams = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(width, layoutParams, i + width, i2 + layoutParams);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    final void m16545a(int i) {
        Rect rect;
        int i2 = i;
        int f = ViewCompat.m1242f(this);
        int size = this.f16429k.size();
        Rect a = m16528a();
        Rect a2 = m16528a();
        Rect a3 = m16528a();
        int i3 = 0;
        while (i3 < size) {
            int i4;
            int i5;
            int i6;
            Rect rect2;
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            View view = (View) r0.f16429k.get(i3);
            LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
            if (i2 == 0) {
                if (view.getVisibility() == 8) {
                    i4 = size;
                    rect = a3;
                    i5 = i3;
                    i3 = i5 + 1;
                    size = i4;
                    a3 = rect;
                }
            }
            int i7 = 0;
            while (i7 < i3) {
                Rect a4;
                int i8;
                int i9;
                Behavior behavior;
                if (layoutParams3.f554l == ((View) r0.f16429k.get(i7))) {
                    LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
                    if (layoutParams4.f553k != null) {
                        Rect a5 = m16528a();
                        Rect a6 = m16528a();
                        a4 = m16528a();
                        ViewGroupUtils.m352a((ViewGroup) r0, layoutParams4.f553k, a5);
                        m16533a(view, false, a6);
                        int measuredWidth = view.getMeasuredWidth();
                        i6 = size;
                        size = view.getMeasuredHeight();
                        i5 = i3;
                        Rect rect3 = a6;
                        Rect rect4 = a5;
                        LayoutParams layoutParams5 = layoutParams4;
                        int i10 = measuredWidth;
                        rect2 = a3;
                        Object obj = 1;
                        i8 = i7;
                        layoutParams = layoutParams3;
                        m16530a(f, a5, a4, layoutParams5, i10, size);
                        if (a4.left == rect3.left) {
                            if (a4.top == rect3.top) {
                                layoutParams2 = layoutParams5;
                                i4 = i10;
                                obj = null;
                                m16532a(layoutParams2, a4, i4, size);
                                i4 = a4.left - rect3.left;
                                i9 = a4.top - rect3.top;
                                if (i4 != 0) {
                                    ViewCompat.m1236c(view, i4);
                                }
                                if (i9 != 0) {
                                    ViewCompat.m1231b(view, i9);
                                }
                                if (obj != null) {
                                    behavior = layoutParams2.f543a;
                                    if (behavior != null) {
                                        behavior.mo88b(r0, view, layoutParams2.f553k);
                                    }
                                }
                                m16531a(rect4);
                                m16531a(rect3);
                                m16531a(a4);
                                i7 = i8 + 1;
                                size = i6;
                                i3 = i5;
                                a3 = rect2;
                                layoutParams3 = layoutParams;
                            }
                        }
                        layoutParams2 = layoutParams5;
                        i4 = i10;
                        m16532a(layoutParams2, a4, i4, size);
                        i4 = a4.left - rect3.left;
                        i9 = a4.top - rect3.top;
                        if (i4 != 0) {
                            ViewCompat.m1236c(view, i4);
                        }
                        if (i9 != 0) {
                            ViewCompat.m1231b(view, i9);
                        }
                        if (obj != null) {
                            behavior = layoutParams2.f543a;
                            if (behavior != null) {
                                behavior.mo88b(r0, view, layoutParams2.f553k);
                            }
                        }
                        m16531a(rect4);
                        m16531a(rect3);
                        m16531a(a4);
                        i7 = i8 + 1;
                        size = i6;
                        i3 = i5;
                        a3 = rect2;
                        layoutParams3 = layoutParams;
                    }
                }
                i8 = i7;
                layoutParams = layoutParams3;
                i6 = size;
                rect2 = a3;
                i5 = i3;
                i7 = i8 + 1;
                size = i6;
                i3 = i5;
                a3 = rect2;
                layoutParams3 = layoutParams;
            }
            layoutParams = layoutParams3;
            i6 = size;
            rect2 = a3;
            i5 = i3;
            m16533a(view, true, a2);
            layoutParams2 = layoutParams;
            if (!(layoutParams2.f549g == 0 || a2.isEmpty())) {
                i4 = GravityCompat.m1096a(layoutParams2.f549g, f);
                size = i4 & 112;
                if (size == 48) {
                    a.top = Math.max(a.top, a2.bottom);
                } else if (size == 80) {
                    a.bottom = Math.max(a.bottom, getHeight() - a2.top);
                }
                i4 &= 7;
                if (i4 == 3) {
                    a.left = Math.max(a.left, a2.right);
                } else if (i4 == 5) {
                    a.right = Math.max(a.right, getWidth() - a2.left);
                }
            }
            if (layoutParams2.f550h != 0 && view.getVisibility() == 0 && ViewCompat.m1206G(view) && view.getWidth() > 0) {
                if (view.getHeight() > 0) {
                    layoutParams2 = (LayoutParams) view.getLayoutParams();
                    behavior = layoutParams2.f543a;
                    Rect a7 = m16528a();
                    a4 = m16528a();
                    a4.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (behavior == null || !behavior.mo87a(view, a7)) {
                        a7.set(a4);
                    } else if (!a4.contains(a7)) {
                        StringBuilder stringBuilder = new StringBuilder("Rect should be within the child's bounds. Rect:");
                        stringBuilder.append(a7.toShortString());
                        stringBuilder.append(" | Bounds:");
                        stringBuilder.append(a4.toShortString());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    m16531a(a4);
                    if (!a7.isEmpty()) {
                        Object obj2;
                        i4 = GravityCompat.m1096a(layoutParams2.f550h, f);
                        if ((i4 & 48) == 48) {
                            i9 = (a7.top - layoutParams2.topMargin) - layoutParams2.f552j;
                            if (i9 < a.top) {
                                m16543e(view, a.top - i9);
                                obj2 = 1;
                                if ((i4 & 80) == 80) {
                                    i9 = ((getHeight() - a7.bottom) - layoutParams2.bottomMargin) + layoutParams2.f552j;
                                    if (i9 < a.bottom) {
                                        m16543e(view, i9 - a.bottom);
                                        obj2 = 1;
                                    }
                                }
                                if (obj2 == null) {
                                    m16543e(view, 0);
                                }
                                if ((i4 & 3) == 3) {
                                    i9 = (a7.left - layoutParams2.leftMargin) - layoutParams2.f551i;
                                    if (i9 < a.left) {
                                        m16542d(view, a.left - i9);
                                        obj2 = 1;
                                        if ((i4 & 5) == 5) {
                                            i4 = ((getWidth() - a7.right) - layoutParams2.rightMargin) + layoutParams2.f551i;
                                            if (i4 < a.right) {
                                                m16542d(view, i4 - a.right);
                                                obj2 = 1;
                                            }
                                        }
                                        if (obj2 == null) {
                                            m16542d(view, 0);
                                        }
                                    }
                                }
                                obj2 = null;
                                if ((i4 & 5) == 5) {
                                    i4 = ((getWidth() - a7.right) - layoutParams2.rightMargin) + layoutParams2.f551i;
                                    if (i4 < a.right) {
                                        m16542d(view, i4 - a.right);
                                        obj2 = 1;
                                    }
                                }
                                if (obj2 == null) {
                                    m16542d(view, 0);
                                }
                            }
                        }
                        obj2 = null;
                        if ((i4 & 80) == 80) {
                            i9 = ((getHeight() - a7.bottom) - layoutParams2.bottomMargin) + layoutParams2.f552j;
                            if (i9 < a.bottom) {
                                m16543e(view, i9 - a.bottom);
                                obj2 = 1;
                            }
                        }
                        if (obj2 == null) {
                            m16543e(view, 0);
                        }
                        if ((i4 & 3) == 3) {
                            i9 = (a7.left - layoutParams2.leftMargin) - layoutParams2.f551i;
                            if (i9 < a.left) {
                                m16542d(view, a.left - i9);
                                obj2 = 1;
                                if ((i4 & 5) == 5) {
                                    i4 = ((getWidth() - a7.right) - layoutParams2.rightMargin) + layoutParams2.f551i;
                                    if (i4 < a.right) {
                                        m16542d(view, i4 - a.right);
                                        obj2 = 1;
                                    }
                                }
                                if (obj2 == null) {
                                    m16542d(view, 0);
                                }
                            }
                        }
                        obj2 = null;
                        if ((i4 & 5) == 5) {
                            i4 = ((getWidth() - a7.right) - layoutParams2.rightMargin) + layoutParams2.f551i;
                            if (i4 < a.right) {
                                m16542d(view, i4 - a.right);
                                obj2 = 1;
                            }
                        }
                        if (obj2 == null) {
                            m16542d(view, 0);
                        }
                    }
                    m16531a(a7);
                }
            }
            if (i2 != 2) {
                rect = rect2;
                rect.set(((LayoutParams) view.getLayoutParams()).f557o);
                if (rect.equals(a2)) {
                    i4 = i6;
                    i3 = i5 + 1;
                    size = i4;
                    a3 = rect;
                } else {
                    ((LayoutParams) view.getLayoutParams()).f557o.set(a2);
                }
            } else {
                rect = rect2;
            }
            i4 = i6;
            for (i3 = i5 + 1; i3 < i4; i3++) {
                View view2 = (View) r0.f16429k.get(i3);
                LayoutParams layoutParams6 = (LayoutParams) view2.getLayoutParams();
                Behavior behavior2 = layoutParams6.f543a;
                if (behavior2 != null && behavior2.mo3832a(r0, view2, view)) {
                    if (i2 == 0 && layoutParams6.f556n) {
                        layoutParams6.f556n = false;
                    } else {
                        boolean b;
                        if (i2 != 2) {
                            b = behavior2.mo88b(r0, view2, view);
                        } else {
                            b = true;
                        }
                        if (i2 == 1) {
                            layoutParams6.f556n = b;
                        }
                    }
                }
            }
            i3 = i5 + 1;
            size = i4;
            a3 = rect;
        }
        rect = a3;
        m16531a(a);
        m16531a(a2);
        m16531a(rect);
    }

    private static void m16542d(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f551i != i) {
            ViewCompat.m1236c(view, i - layoutParams.f551i);
            layoutParams.f551i = i;
        }
    }

    private static void m16543e(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f552j != i) {
            ViewCompat.m1231b(view, i - layoutParams.f552j);
            layoutParams.f552j = i;
        }
    }

    public final List<View> m16544a(View view) {
        DirectedAcyclicGraph directedAcyclicGraph = this.f16424e;
        int size = directedAcyclicGraph.f563b.size();
        Collection collection = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) directedAcyclicGraph.f563b.m1054c(i);
            if (arrayList != null && arrayList.contains(view)) {
                if (collection == null) {
                    collection = new ArrayList();
                }
                collection.add(directedAcyclicGraph.f563b.m1053b(i));
            }
        }
        this.f16425f.clear();
        if (collection != null) {
            this.f16425f.addAll(collection);
        }
        return this.f16425f;
    }

    final List<View> getDependencySortedChildren() {
        m16538b();
        return Collections.unmodifiableList(this.f16429k);
    }

    public final boolean m16550a(View view, int i, int i2) {
        Rect a = m16528a();
        ViewGroupUtils.m352a((ViewGroup) this, view, a);
        try {
            view = a.contains(i, i2);
            return view;
        } finally {
            m16531a(a);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo3083a(view, view2, i, 0);
    }

    public final boolean mo3083a(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        int i4 = 0;
        boolean z = i4;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.f543a;
                if (behavior != null) {
                    boolean a = behavior.mo3825a(r12, childAt, view, view2, i, i3);
                    boolean z2 = z | a;
                    layoutParams.m245a(i3, a);
                    z = z2;
                } else {
                    layoutParams.m245a(i3, false);
                }
            }
            i4++;
        }
        CoordinatorLayout coordinatorLayout = this;
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo3084b(view2, i);
    }

    public final void mo3084b(View view, int i) {
        this.f16441w.f1447a = i;
        this.f16436r = view;
        view = getChildCount();
        for (i = 0; i < view; i++) {
            getChildAt(i).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        mo3085c(view, 0);
    }

    public final void mo3085c(View view, int i) {
        this.f16441w.f1447a = 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.m247a(i)) {
                Behavior behavior = layoutParams.f543a;
                if (behavior != null) {
                    behavior.mo3821a(this, childAt, view, i);
                }
                layoutParams.m245a(i, false);
                layoutParams.f556n = false;
            }
        }
        this.f16436r = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo3081a(view, i2, i4, 0);
    }

    public final void mo3081a(View view, int i, int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m247a(i3)) {
                    Behavior behavior = layoutParams.f543a;
                    if (behavior != null) {
                        behavior.mo3822a(this, childAt, view, i, i2, i3);
                        i5 = 1;
                    }
                }
            }
            i4++;
        }
        if (i5 != 0) {
            m16545a(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo3082a(view, i, i2, iArr, 0);
    }

    public final void mo3082a(View view, int i, int i2, int[] iArr, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            int i8;
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i8 = i3;
                if (layoutParams.m247a(i8)) {
                    Behavior behavior = layoutParams.f543a;
                    if (behavior != null) {
                        int max;
                        int[] iArr2 = r7.f16431m;
                        r7.f16431m[1] = 0;
                        iArr2[0] = 0;
                        behavior.mo3823a(r7, childAt, view, i2, r7.f16431m, i8);
                        if (i > 0) {
                            i4 = Math.max(i6, r7.f16431m[0]);
                        } else {
                            i4 = Math.min(i6, r7.f16431m[0]);
                        }
                        if (i2 > 0) {
                            max = Math.max(i7, r7.f16431m[1]);
                        } else {
                            max = Math.min(i7, r7.f16431m[1]);
                        }
                        i6 = i4;
                        i7 = max;
                        i4 = 1;
                    }
                }
            } else {
                i8 = i3;
            }
            i5++;
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (i4 != 0) {
            m16545a(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        view = getChildCount();
        for (f2 = 0.0f; f2 < view; f2++) {
            z = getChildAt(f2);
            if (z.getVisibility() != 8) {
                z.getLayoutParams();
            }
        }
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m247a(0)) {
                    Behavior behavior = layoutParams.f543a;
                    if (behavior != null) {
                        z |= behavior.mo77a(this, childAt, view, f, f2);
                    }
                }
            }
            i++;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.f16441w.f1447a;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            parcelable = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = m16537b(childAt).f543a;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) parcelable.get(id);
                    if (parcelable2 != null) {
                        behavior.mo73a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).f543a;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.mo79b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).f543a;
        if (behavior == null || !behavior.mo3831a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void m16540c() {
        if (VERSION.SDK_INT >= 21) {
            if (ViewCompat.m1265z(this)) {
                if (this.f16440v == null) {
                    this.f16440v = new C09841(this);
                }
                ViewCompat.m1221a((View) this, this.f16440v);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.m1221a((View) this, null);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
