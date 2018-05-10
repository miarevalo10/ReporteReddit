package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final int[] f1612a = new int[]{16842931};
    static final boolean f1613b = (VERSION.SDK_INT >= 19);
    private static final int[] f1614l = new int[]{16843828};
    private static final boolean f1615m;
    private int f1616A;
    private boolean f1617B;
    private DrawerListener f1618C;
    private float f1619D;
    private float f1620E;
    private Drawable f1621F;
    private Drawable f1622G;
    private Drawable f1623H;
    private Drawable f1624I;
    private Drawable f1625J;
    private Drawable f1626K;
    private Drawable f1627L;
    private final ArrayList<View> f1628M;
    final ViewDragHelper f1629c;
    final ViewDragHelper f1630d;
    int f1631e;
    boolean f1632f;
    List<DrawerListener> f1633g;
    CharSequence f1634h;
    CharSequence f1635i;
    Object f1636j;
    boolean f1637k;
    private final ChildAccessibilityDelegate f1638n;
    private float f1639o;
    private int f1640p;
    private int f1641q;
    private float f1642r;
    private Paint f1643s;
    private final ViewDragCallback f1644t;
    private final ViewDragCallback f1645u;
    private boolean f1646v;
    private boolean f1647w;
    private int f1648x;
    private int f1649y;
    private int f1650z;

    class C01361 implements OnApplyWindowInsetsListener {
        final /* synthetic */ DrawerLayout f1606a;

        C01361(DrawerLayout drawerLayout) {
            this.f1606a = drawerLayout;
        }

        @TargetApi(21)
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            DrawerLayout drawerLayout = (DrawerLayout) view;
            boolean z = false;
            boolean z2 = windowInsets.getSystemWindowInsetTop() > 0;
            drawerLayout.f1636j = windowInsets;
            drawerLayout.f1637k = z2;
            if (!z2 && drawerLayout.getBackground() == null) {
                z = true;
            }
            drawerLayout.setWillNotDraw(z);
            drawerLayout.requestLayout();
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public interface DrawerListener {
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int f1607a = 0;
        float f1608b;
        boolean f1609c;
        int f1610d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1612a);
            this.f1607a = context.getInt(0, 0);
            context.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1607a = layoutParams.f1607a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout f11490a;
        private final Rect f11491c = new Rect();

        AccessibilityDelegate(DrawerLayout drawerLayout) {
            this.f11490a = drawerLayout;
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f1613b) {
                super.mo38a(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1319a(accessibilityNodeInfoCompat);
                super.mo38a(view, a);
                accessibilityNodeInfoCompat.f1523a.setSource(view);
                ViewParent g = ViewCompat.m1244g(view);
                if (g instanceof View) {
                    accessibilityNodeInfoCompat.m1323a((View) g);
                }
                Rect rect = this.f11491c;
                a.m1322a(rect);
                accessibilityNodeInfoCompat.f1523a.setBoundsInParent(rect);
                a.m1328b(rect);
                accessibilityNodeInfoCompat.f1523a.setBoundsInScreen(rect);
                boolean b = a.m1330b();
                if (VERSION.SDK_INT >= 16) {
                    accessibilityNodeInfoCompat.f1523a.setVisibleToUser(b);
                }
                accessibilityNodeInfoCompat.f1523a.setPackageName(a.f1523a.getPackageName());
                accessibilityNodeInfoCompat.m1324a(a.f1523a.getClassName());
                accessibilityNodeInfoCompat.f1523a.setContentDescription(a.f1523a.getContentDescription());
                accessibilityNodeInfoCompat.f1523a.setEnabled(a.f1523a.isEnabled());
                accessibilityNodeInfoCompat.f1523a.setClickable(a.f1523a.isClickable());
                accessibilityNodeInfoCompat.m1329b(a.f1523a.isFocusable());
                accessibilityNodeInfoCompat.m1331c(a.f1523a.isFocused());
                b = a.m1332c();
                if (VERSION.SDK_INT >= 16) {
                    accessibilityNodeInfoCompat.f1523a.setAccessibilityFocused(b);
                }
                accessibilityNodeInfoCompat.f1523a.setSelected(a.f1523a.isSelected());
                accessibilityNodeInfoCompat.f1523a.setLongClickable(a.f1523a.isLongClickable());
                accessibilityNodeInfoCompat.m1321a(a.f1523a.getActions());
                a.f1523a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.m1387h(childAt)) {
                        accessibilityNodeInfoCompat.f1523a.addChild(childAt);
                    }
                }
            }
            accessibilityNodeInfoCompat.m1324a(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.m1329b(false);
            accessibilityNodeInfoCompat.m1331c(false);
            accessibilityNodeInfoCompat.m1327a(AccessibilityActionCompat.f1494a);
            accessibilityNodeInfoCompat.m1327a(AccessibilityActionCompat.f1495b);
        }

        public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo84a(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean mo388d(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.mo388d(view, accessibilityEvent);
            }
            view = accessibilityEvent.getText();
            accessibilityEvent = this.f11490a.m1395b();
            if (accessibilityEvent != null) {
                accessibilityEvent = this.f11490a.m1396c(accessibilityEvent);
                View view2 = this.f11490a;
                accessibilityEvent = GravityCompat.m1096a(accessibilityEvent, ViewCompat.m1242f(view2));
                if (accessibilityEvent == 3) {
                    accessibilityEvent = view2.f1634h;
                } else if (accessibilityEvent == 5) {
                    accessibilityEvent = view2.f1635i;
                } else {
                    accessibilityEvent = null;
                }
                if (accessibilityEvent != null) {
                    view.add(accessibilityEvent);
                }
            }
            return true;
        }

        public final boolean mo387a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!DrawerLayout.f1613b) {
                if (!DrawerLayout.m1387h(view)) {
                    return null;
                }
            }
            return super.mo387a(viewGroup, view, accessibilityEvent);
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.m1387h(view) == null) {
                accessibilityNodeInfoCompat.m1323a(null);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C01371();
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity = null;

        static class C01371 implements ClassLoaderCreator<SavedState> {
            C01371() {
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
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    private class ViewDragCallback extends Callback {
        final int f11492a;
        ViewDragHelper f11493b;
        final /* synthetic */ DrawerLayout f11494c;
        private final Runnable f11495d = new C01381(this);

        class C01381 implements Runnable {
            final /* synthetic */ ViewDragCallback f1611a;

            C01381(ViewDragCallback viewDragCallback) {
                this.f1611a = viewDragCallback;
            }

            public void run() {
                View a;
                int i;
                ViewDragCallback viewDragCallback = this.f1611a;
                int i2 = viewDragCallback.f11493b.f1681h;
                int i3 = 0;
                boolean z = viewDragCallback.f11492a == 3;
                if (z) {
                    a = viewDragCallback.f11494c.m1390a(3);
                    i = (a != null ? -a.getWidth() : 0) + i2;
                } else {
                    a = viewDragCallback.f11494c.m1390a(5);
                    i = viewDragCallback.f11494c.getWidth() - i2;
                }
                if (a == null) {
                    return;
                }
                if (((z && a.getLeft() < i) || (!z && a.getLeft() > i)) && viewDragCallback.f11494c.m1389a(a) == 0) {
                    LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                    viewDragCallback.f11493b.m1465a(a, i, a.getTop());
                    layoutParams.f1609c = true;
                    viewDragCallback.f11494c.invalidate();
                    viewDragCallback.m10194c();
                    DrawerLayout drawerLayout = viewDragCallback.f11494c;
                    if (!drawerLayout.f1632f) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        while (i3 < childCount) {
                            drawerLayout.getChildAt(i3).dispatchTouchEvent(obtain);
                            i3++;
                        }
                        obtain.recycle();
                        drawerLayout.f1632f = true;
                    }
                }
            }
        }

        ViewDragCallback(DrawerLayout drawerLayout, int i) {
            this.f11494c = drawerLayout;
            this.f11492a = i;
        }

        public final void m10191b() {
            this.f11494c.removeCallbacks(this.f11495d);
        }

        public final boolean mo69a(View view, int i) {
            return (DrawerLayout.m1385d(view) == 0 || this.f11494c.m1394a(view, this.f11492a) == 0 || this.f11494c.m1389a(view) != null) ? null : true;
        }

        public final void mo67a(int i) {
            LayoutParams layoutParams;
            DrawerLayout drawerLayout = this.f11494c;
            View view = this.f11493b.f1683j;
            int i2 = drawerLayout.f1629c.f1674a;
            int i3 = drawerLayout.f1630d.f1674a;
            int i4 = 2;
            if (i2 != 1) {
                if (i3 != 1) {
                    if (i2 != 2) {
                        if (i3 != 2) {
                            i4 = 0;
                        }
                    }
                    if (view != null && i == 0) {
                        layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams.f1608b == 0.0f) {
                            layoutParams = (LayoutParams) view.getLayoutParams();
                            if ((layoutParams.f1610d & 1) == 1) {
                                layoutParams.f1610d = 0;
                                if (drawerLayout.f1633g != 0) {
                                    for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                                        drawerLayout.f1633g.get(i);
                                    }
                                }
                                drawerLayout.m1393a(view, false);
                                if (drawerLayout.hasWindowFocus() != 0) {
                                    i = drawerLayout.getRootView();
                                    if (i != 0) {
                                        i.sendAccessibilityEvent(32);
                                    }
                                }
                            }
                        } else if (layoutParams.f1608b == 1065353216) {
                            layoutParams = (LayoutParams) view.getLayoutParams();
                            if ((layoutParams.f1610d & 1) == 0) {
                                layoutParams.f1610d = 1;
                                if (drawerLayout.f1633g != 0) {
                                    for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                                        drawerLayout.f1633g.get(i);
                                    }
                                }
                                drawerLayout.m1393a(view, true);
                                if (drawerLayout.hasWindowFocus() != 0) {
                                    drawerLayout.sendAccessibilityEvent(32);
                                }
                            }
                        }
                    }
                    if (i4 != drawerLayout.f1631e) {
                        drawerLayout.f1631e = i4;
                        if (drawerLayout.f1633g != 0) {
                            for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                                drawerLayout.f1633g.get(i);
                            }
                        }
                    }
                }
            }
            i4 = 1;
            layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f1608b == 0.0f) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f1610d & 1) == 1) {
                    layoutParams.f1610d = 0;
                    if (drawerLayout.f1633g != 0) {
                        for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                            drawerLayout.f1633g.get(i);
                        }
                    }
                    drawerLayout.m1393a(view, false);
                    if (drawerLayout.hasWindowFocus() != 0) {
                        i = drawerLayout.getRootView();
                        if (i != 0) {
                            i.sendAccessibilityEvent(32);
                        }
                    }
                }
            } else if (layoutParams.f1608b == 1065353216) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f1610d & 1) == 0) {
                    layoutParams.f1610d = 1;
                    if (drawerLayout.f1633g != 0) {
                        for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                            drawerLayout.f1633g.get(i);
                        }
                    }
                    drawerLayout.m1393a(view, true);
                    if (drawerLayout.hasWindowFocus() != 0) {
                        drawerLayout.sendAccessibilityEvent(32);
                    }
                }
            }
            if (i4 != drawerLayout.f1631e) {
                drawerLayout.f1631e = i4;
                if (drawerLayout.f1633g != 0) {
                    for (i = drawerLayout.f1633g.size() - 1; i >= 0; i--) {
                        drawerLayout.f1633g.get(i);
                    }
                }
            }
        }

        public final void mo70b(View view, int i) {
            float f;
            int width = view.getWidth();
            if (this.f11494c.m1394a(view, 3)) {
                f = ((float) (i + width)) / ((float) width);
            } else {
                f = ((float) (this.f11494c.getWidth() - i)) / ((float) width);
            }
            this.f11494c.m1392a(view, f);
            view.setVisibility(f == 0 ? 4 : 0);
            this.f11494c.invalidate();
        }

        public final void mo116e(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1609c = false;
            m10194c();
        }

        final void m10194c() {
            int i = 3;
            if (this.f11492a == 3) {
                i = 5;
            }
            View a = this.f11494c.m1390a(i);
            if (a != null) {
                this.f11494c.m1398f(a);
            }
        }

        public final void mo68a(View view, float f, float f2) {
            int i;
            f2 = DrawerLayout.m1382b(view);
            int width = view.getWidth();
            if (this.f11494c.m1394a(view, 3)) {
                f = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (f <= null) {
                    if (f != null || f2 <= 0.5f) {
                        i = -width;
                    }
                }
                i = 0;
            } else {
                int width2 = this.f11494c.getWidth();
                if (f < 0.0f || (f == 0.0f && f2 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f11493b.m1463a(i, view.getTop());
            this.f11494c.invalidate();
        }

        public final void mo390d() {
            this.f11494c.postDelayed(this.f11495d, 160);
        }

        public final void mo389a(int i, int i2) {
            View a;
            if ((i & 1) == 1) {
                a = this.f11494c.m1390a(3);
            } else {
                a = this.f11494c.m1390a(5);
            }
            if (a != 0 && this.f11494c.m1389a(a) == 0) {
                this.f11493b.m1461a(a, i2);
            }
        }

        public final int mo115a(View view) {
            return DrawerLayout.m1385d(view) ? view.getWidth() : null;
        }

        public final int mo72d(View view, int i) {
            if (this.f11494c.m1394a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f11494c.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int mo71c(View view, int i) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f1615m = z;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1638n = new ChildAccessibilityDelegate();
        this.f1641q = -1728053248;
        this.f1643s = new Paint();
        this.f1647w = true;
        this.f1648x = 3;
        this.f1649y = 3;
        this.f1650z = 3;
        this.f1616A = 3;
        this.f1624I = null;
        this.f1625J = null;
        this.f1626K = null;
        this.f1627L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1640p = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f1644t = new ViewDragCallback(this, 3);
        this.f1645u = new ViewDragCallback(this, 5);
        this.f1629c = ViewDragHelper.m1446a((ViewGroup) this, 1.0f, this.f1644t);
        this.f1629c.f1682i = 1;
        this.f1629c.f1680g = f2;
        this.f1644t.f11493b = this.f1629c;
        this.f1630d = ViewDragHelper.m1446a((ViewGroup) this, 1.0f, this.f1645u);
        this.f1630d.f1682i = 2;
        this.f1630d.f1680g = f2;
        this.f1645u.f11493b = this.f1630d;
        setFocusableInTouchMode(true);
        ViewCompat.m1214a((View) this, 1);
        ViewCompat.m1220a((View) this, new AccessibilityDelegate(this));
        ViewGroupCompat.m1270a(this);
        if (ViewCompat.m1265z(this) != null) {
            if (VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new C01361(this));
                setSystemUiVisibility(1280);
                context = context.obtainStyledAttributes(f1614l);
                try {
                    this.f1621F = context.getDrawable(null);
                } finally {
                    context.recycle();
                }
            } else {
                this.f1621F = null;
            }
        }
        this.f1639o = 1092616192 * f;
        this.f1628M = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.f1639o = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m1385d(childAt)) {
                ViewCompat.m1243f(childAt, this.f1639o);
            }
        }
    }

    public float getDrawerElevation() {
        return f1615m ? this.f1639o : 0.0f;
    }

    public void setScrimColor(int i) {
        this.f1641q = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        if (this.f1618C != null) {
            DrawerListener drawerListener2 = this.f1618C;
            if (!(drawerListener2 == null || this.f1633g == null)) {
                this.f1633g.remove(drawerListener2);
            }
        }
        if (!(drawerListener == null || drawerListener == null)) {
            if (this.f1633g == null) {
                this.f1633g = new ArrayList();
            }
            this.f1633g.add(drawerListener);
        }
        this.f1618C = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        m1379a(i, 3);
        m1379a(i, 5);
    }

    private void m1379a(int i, int i2) {
        int a = GravityCompat.m1096a(i2, ViewCompat.m1242f(this));
        if (i2 == 3) {
            this.f1648x = i;
        } else if (i2 == 5) {
            this.f1649y = i;
        } else if (i2 == 8388611) {
            this.f1650z = i;
        } else if (i2 == 8388613) {
            this.f1616A = i;
        }
        if (i != 0) {
            (a == 3 ? this.f1629c : this.f1630d).m1460a();
        }
        switch (i) {
            case 1:
                i = m1390a(a);
                if (i != 0) {
                    m1398f(i);
                    break;
                }
                break;
            case 2:
                i = m1390a(a);
                if (i != 0) {
                    m1397e(i);
                    return;
                }
                break;
            default:
                break;
        }
    }

    public final int m1389a(View view) {
        if (m1385d(view)) {
            view = ((LayoutParams) view.getLayoutParams()).f1607a;
            int f = ViewCompat.m1242f(this);
            if (view != 3) {
                if (view != 5) {
                    if (view != 8388611) {
                        if (view == 8388613) {
                            if (this.f1616A != 3) {
                                return this.f1616A;
                            }
                            if (f == 0) {
                                view = this.f1649y;
                            } else {
                                view = this.f1648x;
                            }
                            if (view != 3) {
                                return view;
                            }
                        }
                    } else if (this.f1650z != 3) {
                        return this.f1650z;
                    } else {
                        if (f == 0) {
                            view = this.f1648x;
                        } else {
                            view = this.f1649y;
                        }
                        if (view != 3) {
                            return view;
                        }
                    }
                } else if (this.f1649y != 3) {
                    return this.f1649y;
                } else {
                    if (f == 0) {
                        view = this.f1616A;
                    } else {
                        view = this.f1650z;
                    }
                    if (view != 3) {
                        return view;
                    }
                }
            } else if (this.f1648x != 3) {
                return this.f1648x;
            } else {
                view = f == 0 ? this.f1650z : this.f1616A;
                if (view != 3) {
                    return view;
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    final void m1393a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m1385d(childAt)) && !(z && childAt == view)) {
                ViewCompat.m1214a(childAt, 4);
            } else {
                ViewCompat.m1214a(childAt, 1);
            }
        }
    }

    final void m1392a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f1608b) {
            layoutParams.f1608b = f;
            if (this.f1633g != null) {
                for (view = this.f1633g.size() - 1; view >= null; view--) {
                    this.f1633g.get(view);
                }
            }
        }
    }

    static float m1382b(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1608b;
    }

    final int m1396c(View view) {
        return GravityCompat.m1096a(((LayoutParams) view.getLayoutParams()).f1607a, ViewCompat.m1242f(this));
    }

    final boolean m1394a(View view, int i) {
        return (m1396c(view) & i) == i ? true : null;
    }

    private View m1384c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f1610d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View m1390a(int i) {
        i = GravityCompat.m1096a(i, ViewCompat.m1242f(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m1396c(childAt) & 7) == i) {
                return childAt;
            }
        }
        return 0;
    }

    public static String m1383b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1647w = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1647w = true;
    }

    protected void onMeasure(int i, int i2) {
        DrawerLayout drawerLayout = this;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        mode = (drawerLayout.f1636j == null || !ViewCompat.m1265z(this)) ? 0 : 1;
        int f = ViewCompat.m1242f(this);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        while (i4 < childCount) {
            int a;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (mode != 0) {
                    a = GravityCompat.m1096a(layoutParams.f1607a, f);
                    WindowInsets windowInsets;
                    if (ViewCompat.m1265z(childAt)) {
                        if (VERSION.SDK_INT >= 21) {
                            windowInsets = (WindowInsets) drawerLayout.f1636j;
                            if (a == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (VERSION.SDK_INT >= 21) {
                        windowInsets = (WindowInsets) drawerLayout.f1636j;
                        if (a == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                        } else if (a == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                    }
                }
                if (m1388i(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (m1385d(childAt)) {
                    if (f1615m && ViewCompat.m1260u(childAt) != drawerLayout.f1639o) {
                        ViewCompat.m1243f(childAt, drawerLayout.f1639o);
                    }
                    mode2 = m1396c(childAt) & 7;
                    int i7 = mode2 == 3 ? 1 : i3;
                    if ((i7 == 0 || r10 == 0) && (i7 != 0 || r11 == 0)) {
                        if (i7 != 0) {
                            i5 = 1;
                        } else {
                            i6 = 1;
                        }
                        childAt.measure(getChildMeasureSpec(i, (drawerLayout.f1640p + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i4++;
                        i3 = 0;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                        stringBuilder.append(m1383b(mode2));
                        stringBuilder.append(" but this DrawerLayout already has a drawer view along that edge");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("Child ");
                    stringBuilder2.append(childAt);
                    stringBuilder2.append(" at index ");
                    stringBuilder2.append(i4);
                    stringBuilder2.append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(stringBuilder2.toString());
                }
            }
            a = i;
            int i8 = i2;
            i4++;
            i3 = 0;
        }
    }

    private static boolean m1381a(Drawable drawable, int i) {
        if (drawable != null) {
            if (DrawableCompat.m838b(drawable)) {
                DrawableCompat.m839b(drawable, i);
                return true;
            }
        }
        return null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = true;
        this.f1646v = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m1388i(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m1394a(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i7 = (-measuredWidth) + ((int) (layoutParams.f1608b * f2));
                        f = ((float) (measuredWidth + i7)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i8 = i5 - ((int) (layoutParams.f1608b * f3));
                        f = ((float) (i5 - i8)) / f3;
                        i7 = i8;
                    }
                    boolean z3 = f != layoutParams.f1608b ? z2 : false;
                    int i9 = layoutParams.f1607a & 112;
                    int i10;
                    if (i9 == 16) {
                        i10 = i4 - i2;
                        i9 = (i10 - measuredHeight) / 2;
                        if (i9 < layoutParams.topMargin) {
                            i9 = layoutParams.topMargin;
                        } else if (i9 + measuredHeight > i10 - layoutParams.bottomMargin) {
                            i9 = (i10 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i7, i9, measuredWidth + i7, measuredHeight + i9);
                    } else if (i9 != 80) {
                        childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, layoutParams.topMargin + measuredHeight);
                    } else {
                        i10 = i4 - i2;
                        childAt.layout(i7, (i10 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i10 - layoutParams.bottomMargin);
                    }
                    if (z3) {
                        m1392a(childAt, f);
                    }
                    int i11 = layoutParams.f1608b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
            i6++;
            z2 = true;
        }
        r0.f1646v = false;
        r0.f1647w = false;
    }

    public void requestLayout() {
        if (!this.f1646v) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f1608b);
        }
        this.f1642r = f;
        boolean b = this.f1629c.m1469b();
        boolean b2 = this.f1630d.m1469b();
        if (b || b2) {
            ViewCompat.m1234c(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1621F = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1621F;
    }

    public void setStatusBarBackground(int i) {
        this.f1621F = i != 0 ? ContextCompat.m714a(getContext(), i) : 0;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f1621F = new ColorDrawable(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1637k && this.f1621F != null) {
            int systemWindowInsetTop = (VERSION.SDK_INT < 21 || this.f1636j == null) ? 0 : ((WindowInsets) this.f1636j).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.f1621F.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f1621F.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int i2;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean i3 = m1388i(view);
        int width = getWidth();
        int save = canvas.save();
        if (i3) {
            int childCount = getChildCount();
            i = width;
            width = 0;
            i2 = width;
            while (width < childCount) {
                View childAt = getChildAt(width);
                if (childAt != view2 && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    int i4 = (background == null || background.getOpacity() != -1) ? 0 : 1;
                    if (i4 != 0 && m1385d(childAt) && childAt.getHeight() >= height) {
                        int right;
                        if (m1394a(childAt, 3)) {
                            right = childAt.getRight();
                            if (right > i2) {
                                i2 = right;
                            }
                        } else {
                            right = childAt.getLeft();
                            if (right < i) {
                                i = right;
                            }
                        }
                    }
                }
                width++;
            }
            canvas2.clipRect(i2, 0, i, getHeight());
        } else {
            i = width;
            i2 = 0;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas2.restoreToCount(save);
        if (r0.f1642r > 0.0f && i3) {
            r0.f1643s.setColor((((int) (((float) ((r0.f1641q & -16777216) >>> 24)) * r0.f1642r)) << 24) | (r0.f1641q & 16777215));
            canvas2.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), r0.f1643s);
        } else if (r0.f1622G != null && m1394a(view2, 3)) {
            height = r0.f1622G.getIntrinsicWidth();
            r7 = view.getRight();
            r5 = Math.max(0.0f, Math.min(((float) r7) / ((float) r0.f1629c.f1681h), 1.0f));
            r0.f1622G.setBounds(r7, view.getTop(), height + r7, view.getBottom());
            r0.f1622G.setAlpha((int) (255.0f * r5));
            r0.f1622G.draw(canvas2);
        } else if (r0.f1623H != null && m1394a(view2, 5)) {
            height = r0.f1623H.getIntrinsicWidth();
            r7 = view.getLeft();
            r5 = Math.max(0.0f, Math.min(((float) (getWidth() - r7)) / ((float) r0.f1630d.f1681h), 1.0f));
            r0.f1623H.setBounds(r7 - height, view.getTop(), r7, view.getBottom());
            r0.f1623H.setAlpha((int) (255.0f * r5));
            r0.f1623H.draw(canvas2);
        }
        return drawChild;
    }

    private static boolean m1388i(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1607a == null ? true : null;
    }

    static boolean m1385d(View view) {
        view = GravityCompat.m1096a(((LayoutParams) view.getLayoutParams()).f1607a, ViewCompat.m1242f(view));
        return ((view & 3) == 0 && (view & 5) == null) ? null : true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int length;
        int a = this.f1629c.m1464a(motionEvent) | this.f1630d.m1464a(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                motionEvent = motionEvent.getY();
                this.f1619D = x;
                this.f1620E = motionEvent;
                if (this.f1642r > 0.0f) {
                    motionEvent = this.f1629c.m1466b((int) x, (int) motionEvent);
                    if (!(motionEvent == null || m1388i(motionEvent) == null)) {
                        motionEvent = 1;
                        this.f1617B = false;
                        this.f1632f = false;
                        break;
                    }
                }
                motionEvent = null;
                this.f1617B = false;
                this.f1632f = false;
            case 1:
            case 3:
                m1380a(true);
                this.f1617B = false;
                this.f1632f = false;
                break;
            case 2:
                motionEvent = this.f1629c;
                length = motionEvent.f1676c.length;
                int i = 0;
                while (i < length) {
                    boolean z;
                    if (motionEvent.m1462a(i)) {
                        float f = motionEvent.f1678e[i] - motionEvent.f1676c[i];
                        float f2 = motionEvent.f1679f[i] - motionEvent.f1677d[i];
                        if ((f * f) + (f2 * f2) > ((float) (motionEvent.f1675b * motionEvent.f1675b))) {
                            z = true;
                            if (z) {
                                motionEvent = 1;
                                if (motionEvent != null) {
                                    this.f1644t.m10191b();
                                    this.f1645u.m10191b();
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    z = false;
                    if (z) {
                        motionEvent = 1;
                        if (motionEvent != null) {
                            this.f1644t.m10191b();
                            this.f1645u.m10191b();
                        }
                    } else {
                        i++;
                    }
                }
                motionEvent = null;
                if (motionEvent != null) {
                    this.f1644t.m10191b();
                    this.f1645u.m10191b();
                }
                break;
            default:
                break;
        }
        motionEvent = null;
        if (a == 0 && r9 == null) {
            motionEvent = getChildCount();
            length = 0;
            while (length < motionEvent) {
                if (((LayoutParams) getChildAt(length).getLayoutParams()).f1609c) {
                    motionEvent = 1;
                    if (motionEvent == null) {
                        if (this.f1632f != null) {
                            return false;
                        }
                    }
                } else {
                    length++;
                }
            }
            motionEvent = null;
            if (motionEvent == null) {
                if (this.f1632f != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1629c.m1468b(motionEvent);
        this.f1630d.m1468b(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            float x;
            switch (action) {
                case 0:
                    x = motionEvent.getX();
                    motionEvent = motionEvent.getY();
                    this.f1619D = x;
                    this.f1620E = motionEvent;
                    this.f1617B = false;
                    this.f1632f = false;
                    break;
                case 1:
                    boolean z;
                    x = motionEvent.getX();
                    motionEvent = motionEvent.getY();
                    View b = this.f1629c.m1466b((int) x, (int) motionEvent);
                    if (b != null && m1388i(b)) {
                        x -= this.f1619D;
                        motionEvent -= this.f1620E;
                        int i = this.f1629c.f1675b;
                        if ((x * x) + (motionEvent * motionEvent) < ((float) (i * i))) {
                            View c = m1384c();
                            if (c != null) {
                                if (m1389a(c) != 2) {
                                    z = null;
                                    m1380a(z);
                                    this.f1617B = false;
                                    break;
                                }
                            }
                        }
                    }
                    z = 1;
                    m1380a(z);
                    this.f1617B = false;
                default:
                    break;
            }
        }
        m1380a(true);
        this.f1617B = false;
        this.f1632f = false;
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1617B = z;
        if (z) {
            m1380a(true);
        }
    }

    private void m1380a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m1385d(childAt) && (!z || layoutParams.f1609c)) {
                int width = childAt.getWidth();
                if (m1394a(childAt, 3)) {
                    i2 |= this.f1629c.m1465a(childAt, -width, childAt.getTop());
                } else {
                    i2 |= this.f1630d.m1465a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f1609c = false;
            }
            i++;
        }
        this.f1644t.m10191b();
        this.f1645u.m10191b();
        if (i2 != 0) {
            invalidate();
        }
    }

    public final void m1397e(View view) {
        if (m1385d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1647w) {
                layoutParams.f1608b = 1.0f;
                layoutParams.f1610d = 1;
                m1393a(view, true);
            } else {
                layoutParams.f1610d |= 2;
                if (m1394a(view, 3)) {
                    this.f1629c.m1465a(view, 0, view.getTop());
                } else {
                    this.f1630d.m1465a(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a sliding drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void m1398f(View view) {
        if (m1385d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1647w) {
                layoutParams.f1608b = null;
                layoutParams.f1610d = null;
            } else {
                layoutParams.f1610d |= 4;
                if (m1394a(view, 3)) {
                    this.f1629c.m1465a(view, -view.getWidth(), view.getTop());
                } else {
                    this.f1630d.m1465a(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a sliding drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static boolean m1386g(View view) {
        if (m1385d(view)) {
            return (((LayoutParams) view.getLayoutParams()).f1610d & 1) == 1 ? true : null;
        } else {
            StringBuilder stringBuilder = new StringBuilder("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            int i5 = i4;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (!m1385d(childAt)) {
                    this.f1628M.add(childAt);
                } else if (m1386g(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    i5 = 1;
                }
                i4++;
            }
            if (i5 == 0) {
                childCount = this.f1628M.size();
                while (i3 < childCount) {
                    View view = (View) this.f1628M.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.f1628M.clear();
        }
    }

    final View m1395b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1385d(childAt)) {
                if (m1385d(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).f1608b > 0.0f ? 1 : null) != null) {
                        return childAt;
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder("View ");
                    stringBuilder.append(childAt);
                    stringBuilder.append(" is not a drawer");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        return null;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View b = m1395b();
        if (b != 0 && m1389a(b) == 0) {
            m1380a(false);
        }
        if (b != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.openDrawerGravity != 0) {
                View a = m1390a(savedState.openDrawerGravity);
                if (a != null) {
                    m1397e(a);
                }
            }
            if (savedState.lockModeLeft != 3) {
                m1379a(savedState.lockModeLeft, 3);
            }
            if (savedState.lockModeRight != 3) {
                m1379a(savedState.lockModeRight, 5);
            }
            if (savedState.lockModeStart != 3) {
                m1379a(savedState.lockModeStart, 8388611);
            }
            if (savedState.lockModeEnd != 3) {
                m1379a(savedState.lockModeEnd, 8388613);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = 1;
            Object obj2 = layoutParams.f1610d == 1 ? 1 : null;
            if (layoutParams.f1610d != 2) {
                obj = null;
            }
            if (obj2 == null) {
                if (obj == null) {
                    i++;
                }
            }
            savedState.openDrawerGravity = layoutParams.f1607a;
            break;
        }
        savedState.lockModeLeft = this.f1648x;
        savedState.lockModeRight = this.f1649y;
        savedState.lockModeStart = this.f1650z;
        savedState.lockModeEnd = this.f1616A;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m1384c() == 0) {
            if (m1385d(view) == 0) {
                ViewCompat.m1214a(view, 1);
                if (f1613b == 0) {
                    ViewCompat.m1220a(view, this.f1638n);
                }
            }
        }
        ViewCompat.m1214a(view, 4);
        if (f1613b == 0) {
            ViewCompat.m1220a(view, this.f1638n);
        }
    }

    static boolean m1387h(View view) {
        return (ViewCompat.m1237d(view) == 4 || ViewCompat.m1237d(view) == 2) ? null : true;
    }

    public void onRtlPropertiesChanged(int i) {
        if (f1615m == 0) {
            i = ViewCompat.m1242f(this);
            if (i == 0) {
                if (this.f1624I != null) {
                    m1381a(this.f1624I, i);
                    i = this.f1624I;
                    this.f1622G = i;
                    i = ViewCompat.m1242f(this);
                    if (i == 0) {
                        if (this.f1625J != null) {
                            m1381a(this.f1625J, i);
                            i = this.f1625J;
                            this.f1623H = i;
                        }
                    } else if (this.f1624I != null) {
                        m1381a(this.f1624I, i);
                        i = this.f1624I;
                        this.f1623H = i;
                    }
                    i = this.f1627L;
                    this.f1623H = i;
                }
            } else if (this.f1625J != null) {
                m1381a(this.f1625J, i);
                i = this.f1625J;
                this.f1622G = i;
                i = ViewCompat.m1242f(this);
                if (i == 0) {
                    if (this.f1624I != null) {
                        m1381a(this.f1624I, i);
                        i = this.f1624I;
                        this.f1623H = i;
                    }
                } else if (this.f1625J != null) {
                    m1381a(this.f1625J, i);
                    i = this.f1625J;
                    this.f1623H = i;
                }
                i = this.f1627L;
                this.f1623H = i;
            }
            i = this.f1626K;
            this.f1622G = i;
            i = ViewCompat.m1242f(this);
            if (i == 0) {
                if (this.f1625J != null) {
                    m1381a(this.f1625J, i);
                    i = this.f1625J;
                    this.f1623H = i;
                }
            } else if (this.f1624I != null) {
                m1381a(this.f1624I, i);
                i = this.f1624I;
                this.f1623H = i;
            }
            i = this.f1627L;
            this.f1623H = i;
        }
    }

    public final void m1391a() {
        View a = m1390a(8388611);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("No drawer view found with gravity ");
            stringBuilder.append(m1383b(8388611));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        m1398f(a);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (m1395b() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
