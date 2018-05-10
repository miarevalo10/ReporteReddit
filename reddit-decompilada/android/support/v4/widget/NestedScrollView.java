package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild2, NestedScrollingParent {
    private static final AccessibilityDelegate f16506w = new AccessibilityDelegate();
    private static final int[] f16507x = new int[]{16843130};
    private float f16508A;
    private OnScrollChangeListener f16509B;
    private long f16510a;
    private final Rect f16511b;
    private OverScroller f16512c;
    private EdgeEffect f16513d;
    private EdgeEffect f16514e;
    private int f16515f;
    private boolean f16516g;
    private boolean f16517h;
    private View f16518i;
    private boolean f16519j;
    private VelocityTracker f16520k;
    private boolean f16521l;
    private boolean f16522m;
    private int f16523n;
    private int f16524o;
    private int f16525p;
    private int f16526q;
    private final int[] f16527r;
    private final int[] f16528s;
    private int f16529t;
    private int f16530u;
    private SavedState f16531v;
    private final NestedScrollingParentHelper f16532y;
    private final NestedScrollingChildHelper f16533z;

    public interface OnScrollChangeListener {
        void mo409a(NestedScrollView nestedScrollView);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01391();
        public int f1653a;

        static class C01391 implements Creator<SavedState> {
            C01391() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1653a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1653a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.f1653a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public final boolean mo82a(View view, int i, Bundle bundle) {
            if (super.mo82a(view, i, bundle) != null) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled() == null) {
                return false;
            }
            if (i == 4096) {
                i = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m16710a(i);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                i = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m16710a(i);
                return true;
            }
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.m1324a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    accessibilityNodeInfoCompat.m1334d(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat.m1321a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        accessibilityNodeInfoCompat.m1321a(4096);
                    }
                }
            }
        }

        public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo84a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.m1336a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.m1337b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    private static int m16698b(int i, int i2, int i3) {
        if (i2 < i3) {
            if (i >= 0) {
                return i2 + i > i3 ? i3 - i2 : i;
            }
        }
        return 0;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16511b = new Rect();
        this.f16516g = true;
        this.f16517h = false;
        this.f16518i = null;
        this.f16519j = false;
        this.f16522m = true;
        this.f16526q = -1;
        this.f16527r = new int[2];
        this.f16528s = new int[2];
        this.f16512c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f16523n = viewConfiguration.getScaledTouchSlop();
        this.f16524o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16525p = viewConfiguration.getScaledMaximumFlingVelocity();
        context = context.obtainStyledAttributes(attributeSet, f16507x, i, 0);
        setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.f16532y = new NestedScrollingParentHelper(this);
        this.f16533z = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.m1220a((View) this, f16506w);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f16533z.m1124a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f16533z.f1442a;
    }

    public boolean startNestedScroll(int i) {
        return this.f16533z.m1128a(i, 0);
    }

    private boolean m16701b(int i) {
        return this.f16533z.m1128a(2, i);
    }

    public void stopNestedScroll() {
        this.f16533z.m1133b(0);
    }

    private void m16703c(int i) {
        this.f16533z.m1133b(i);
    }

    public boolean hasNestedScrollingParent() {
        return this.f16533z.m1127a(0);
    }

    private boolean m16705d(int i) {
        return this.f16533z.m1127a(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f16533z.m1129a(i, i2, i3, i4, iArr);
    }

    private boolean m16693a(int i, int i2, int[] iArr, int i3) {
        return this.f16533z.m1130a(0, i, 0, i2, iArr, i3);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f16533z.m1131a(i, i2, iArr, iArr2);
    }

    private boolean m16694a(int i, int[] iArr, int[] iArr2, int i2) {
        return this.f16533z.m1132a(0, i, iArr, iArr2, i2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f16533z.m1126a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f16533z.m1125a(f, f2);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f16532y.f1447a = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f16532y.f1447a = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        view = getScrollY();
        scrollBy(0, i4);
        int scrollY = getScrollY() - view;
        dispatchNestedScroll(0, scrollY, 0, i4 - scrollY, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return null;
        }
        m16709h((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f16532y.f1447a;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.f16509B = onScrollChangeListener;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f16521l) {
            this.f16521l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f16522m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f16509B != 0) {
            this.f16509B.mo409a(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f16521l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            i2 = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (i2.getMeasuredHeight() < measuredHeight) {
                i2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) i2.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (m16711a(keyEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public final boolean m16711a(KeyEvent keyEvent) {
        boolean z;
        int keyCode;
        int i;
        this.f16511b.setEmpty();
        boolean z2 = false;
        View childAt = getChildAt(0);
        if (childAt != null) {
            if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
                z = true;
                if (!z) {
                    if (keyEvent.getAction() == 0) {
                        keyCode = keyEvent.getKeyCode();
                        i = 33;
                        if (keyCode != 62) {
                            switch (keyCode) {
                                case 19:
                                    if (keyEvent.isAltPressed() != null) {
                                        z2 = m16706e(33);
                                        break;
                                    }
                                    z2 = m16707f(33);
                                    break;
                                case 20:
                                    if (keyEvent.isAltPressed() != null) {
                                        z2 = m16706e(130);
                                        break;
                                    }
                                    z2 = m16707f(130);
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (keyEvent.isShiftPressed() != null) {
                            i = 130;
                        }
                        keyEvent = i != 130 ? 1 : null;
                        keyCode = getHeight();
                        if (keyEvent == null) {
                            this.f16511b.top = getScrollY() + keyCode;
                            keyEvent = getChildCount();
                            if (keyEvent > null) {
                                keyEvent = getChildAt(keyEvent - 1);
                                if (this.f16511b.top + keyCode > keyEvent.getBottom()) {
                                    this.f16511b.top = keyEvent.getBottom() - keyCode;
                                }
                            }
                        } else {
                            this.f16511b.top = getScrollY() - keyCode;
                            if (this.f16511b.top < null) {
                                this.f16511b.top = 0;
                            }
                        }
                        this.f16511b.bottom = this.f16511b.top + keyCode;
                        m16691a(i, this.f16511b.top, this.f16511b.bottom);
                    }
                    return z2;
                } else if (isFocused() || keyEvent.getKeyCode() == 4) {
                    return false;
                } else {
                    keyEvent = findFocus();
                    if (keyEvent == this) {
                        keyEvent = null;
                    }
                    Object findNextFocus = FocusFinder.getInstance().findNextFocus(this, keyEvent, 130);
                    return (findNextFocus == null || findNextFocus == this || findNextFocus.requestFocus(130) == null) ? false : true;
                }
            }
        }
        z = false;
        if (!z) {
            if (keyEvent.getAction() == 0) {
                keyCode = keyEvent.getKeyCode();
                i = 33;
                if (keyCode != 62) {
                    switch (keyCode) {
                        case 19:
                            if (keyEvent.isAltPressed() != null) {
                                z2 = m16707f(33);
                                break;
                            }
                            z2 = m16706e(33);
                            break;
                        case 20:
                            if (keyEvent.isAltPressed() != null) {
                                z2 = m16707f(130);
                                break;
                            }
                            z2 = m16706e(130);
                            break;
                        default:
                            break;
                    }
                }
                if (keyEvent.isShiftPressed() != null) {
                    i = 130;
                }
                if (i != 130) {
                }
                keyCode = getHeight();
                if (keyEvent == null) {
                    this.f16511b.top = getScrollY() - keyCode;
                    if (this.f16511b.top < null) {
                        this.f16511b.top = 0;
                    }
                } else {
                    this.f16511b.top = getScrollY() + keyCode;
                    keyEvent = getChildCount();
                    if (keyEvent > null) {
                        keyEvent = getChildAt(keyEvent - 1);
                        if (this.f16511b.top + keyCode > keyEvent.getBottom()) {
                            this.f16511b.top = keyEvent.getBottom() - keyCode;
                        }
                    }
                }
                this.f16511b.bottom = this.f16511b.top + keyCode;
                m16691a(i, this.f16511b.top, this.f16511b.bottom);
            }
            return z2;
        }
        if (isFocused()) {
        }
        return false;
    }

    private void m16688a() {
        if (this.f16520k == null) {
            this.f16520k = VelocityTracker.obtain();
        }
    }

    private void m16699b() {
        if (this.f16520k != null) {
            this.f16520k.recycle();
            this.f16520k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m16699b();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f16519j) {
            return true;
        }
        action &= 255;
        if (action != 6) {
            switch (action) {
                case 0:
                    boolean z;
                    action = (int) motionEvent.getY();
                    int x = (int) motionEvent.getX();
                    if (getChildCount() > 0) {
                        int scrollY = getScrollY();
                        View childAt = getChildAt(0);
                        if (action >= childAt.getTop() - scrollY && action < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                            z = true;
                            if (!z) {
                                this.f16515f = action;
                                this.f16526q = motionEvent.getPointerId(0);
                                if (this.f16520k != null) {
                                    this.f16520k = VelocityTracker.obtain();
                                } else {
                                    this.f16520k.clear();
                                }
                                this.f16520k.addMovement(motionEvent);
                                this.f16512c.computeScrollOffset();
                                this.f16519j = this.f16512c.isFinished() ^ 1;
                                m16701b(0);
                                break;
                            }
                            this.f16519j = false;
                            m16699b();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f16515f = action;
                        this.f16526q = motionEvent.getPointerId(0);
                        if (this.f16520k != null) {
                            this.f16520k.clear();
                        } else {
                            this.f16520k = VelocityTracker.obtain();
                        }
                        this.f16520k.addMovement(motionEvent);
                        this.f16512c.computeScrollOffset();
                        this.f16519j = this.f16512c.isFinished() ^ 1;
                        m16701b(0);
                    } else {
                        this.f16519j = false;
                        m16699b();
                    }
                case 1:
                case 3:
                    this.f16519j = false;
                    this.f16526q = -1;
                    m16699b();
                    if (this.f16512c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != null) {
                        ViewCompat.m1234c(this);
                    }
                    m16703c(0);
                    break;
                case 2:
                    action = this.f16526q;
                    if (action != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(action);
                        if (findPointerIndex != -1) {
                            action = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(action - this.f16515f) > this.f16523n && (2 & getNestedScrollAxes()) == 0) {
                                this.f16519j = true;
                                this.f16515f = action;
                                m16688a();
                                this.f16520k.addMovement(motionEvent);
                                this.f16529t = 0;
                                motionEvent = getParent();
                                if (motionEvent != null) {
                                    motionEvent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder("Invalid pointerId=");
                        stringBuilder.append(action);
                        stringBuilder.append(" in onInterceptTouchEvent");
                        Log.e("NestedScrollView", stringBuilder.toString());
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        m16690a(motionEvent);
        return this.f16519j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m16688a();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f16529t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f16529t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean isFinished = this.f16512c.isFinished() ^ true;
                    this.f16519j = isFinished;
                    if (isFinished) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f16512c.isFinished()) {
                        this.f16512c.abortAnimation();
                    }
                    this.f16515f = (int) motionEvent.getY();
                    this.f16526q = motionEvent.getPointerId(0);
                    m16701b(0);
                    break;
                }
                return false;
            case 1:
                motionEvent = this.f16520k;
                motionEvent.computeCurrentVelocity(1000, (float) this.f16525p);
                motionEvent = (int) motionEvent.getYVelocity(this.f16526q);
                if (Math.abs(motionEvent) > this.f16524o) {
                    m16709h(-motionEvent);
                } else if (this.f16512c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != null) {
                    ViewCompat.m1234c(this);
                }
                this.f16526q = -1;
                m16702c();
                break;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.f16526q);
                if (actionMasked != -1) {
                    int y = (int) motionEvent.getY(actionMasked);
                    int i = this.f16515f - y;
                    if (m16694a(i, this.f16528s, this.f16527r, 0)) {
                        i -= this.f16528s[1];
                        obtain.offsetLocation(0.0f, (float) this.f16527r[1]);
                        this.f16529t += this.f16527r[1];
                    }
                    if (!this.f16519j && Math.abs(i) > this.f16523n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f16519j = true;
                        if (i > 0) {
                            i -= this.f16523n;
                        } else {
                            i += this.f16523n;
                        }
                    }
                    if (this.f16519j) {
                        boolean z;
                        int scrollY;
                        this.f16515f = y - this.f16527r[1];
                        y = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode != 0) {
                            if (overScrollMode != 1 || scrollRange <= 0) {
                                z = false;
                                if (m16692a(i, 0, getScrollY(), scrollRange) && !m16705d(0)) {
                                    this.f16520k.clear();
                                }
                                scrollY = getScrollY() - y;
                                if (m16693a(scrollY, i - scrollY, this.f16527r, 0)) {
                                    if (z) {
                                        m16704d();
                                        y += i;
                                        if (y < 0) {
                                            EdgeEffectCompat.m1400a(this.f16513d, ((float) i) / ((float) getHeight()), motionEvent.getX(actionMasked) / ((float) getWidth()));
                                            if (this.f16514e.isFinished() == null) {
                                                this.f16514e.onRelease();
                                            }
                                        } else if (y > scrollRange) {
                                            EdgeEffectCompat.m1400a(this.f16514e, ((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(actionMasked) / ((float) getWidth())));
                                            if (this.f16513d.isFinished() == null) {
                                                this.f16513d.onRelease();
                                            }
                                        }
                                        if (this.f16513d != null && (this.f16513d.isFinished() == null || this.f16514e.isFinished() == null)) {
                                            ViewCompat.m1234c(this);
                                            break;
                                        }
                                    }
                                }
                                this.f16515f -= this.f16527r[1];
                                obtain.offsetLocation(0.0f, (float) this.f16527r[1]);
                                this.f16529t += this.f16527r[1];
                                break;
                            }
                        }
                        z = true;
                        this.f16520k.clear();
                        scrollY = getScrollY() - y;
                        if (m16693a(scrollY, i - scrollY, this.f16527r, 0)) {
                            if (z) {
                                m16704d();
                                y += i;
                                if (y < 0) {
                                    EdgeEffectCompat.m1400a(this.f16513d, ((float) i) / ((float) getHeight()), motionEvent.getX(actionMasked) / ((float) getWidth()));
                                    if (this.f16514e.isFinished() == null) {
                                        this.f16514e.onRelease();
                                    }
                                } else if (y > scrollRange) {
                                    EdgeEffectCompat.m1400a(this.f16514e, ((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(actionMasked) / ((float) getWidth())));
                                    if (this.f16513d.isFinished() == null) {
                                        this.f16513d.onRelease();
                                    }
                                }
                                ViewCompat.m1234c(this);
                                break;
                            }
                        }
                        this.f16515f -= this.f16527r[1];
                        obtain.offsetLocation(0.0f, (float) this.f16527r[1]);
                        this.f16529t += this.f16527r[1];
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Invalid pointerId=");
                stringBuilder.append(this.f16526q);
                stringBuilder.append(" in onTouchEvent");
                Log.e("NestedScrollView", stringBuilder.toString());
                break;
                break;
            case 3:
                if (!(this.f16519j == null || getChildCount() <= null || this.f16512c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == null)) {
                    ViewCompat.m1234c(this);
                }
                this.f16526q = -1;
                m16702c();
                break;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                this.f16515f = (int) motionEvent.getY(actionMasked);
                this.f16526q = motionEvent.getPointerId(actionMasked);
                break;
            case 6:
                m16690a(motionEvent);
                this.f16515f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f16526q));
                break;
            default:
                break;
        }
        if (this.f16520k != null) {
            this.f16520k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m16690a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f16526q) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.f16515f = (int) motionEvent.getY(actionIndex);
            this.f16526q = motionEvent.getPointerId(actionIndex);
            if (this.f16520k != null) {
                this.f16520k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            if (motionEvent.getAction() == 8) {
                if (!this.f16519j) {
                    motionEvent = motionEvent.getAxisValue(9);
                    if (motionEvent != 0.0f) {
                        motionEvent = (int) (motionEvent * getVerticalScrollFactorCompat());
                        int scrollRange = getScrollRange();
                        int scrollY = getScrollY();
                        motionEvent = scrollY - motionEvent;
                        if (motionEvent < null) {
                            motionEvent = null;
                        } else if (motionEvent > scrollRange) {
                            motionEvent = scrollRange;
                        }
                        if (motionEvent != scrollY) {
                            super.scrollTo(getScrollX(), motionEvent);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f16508A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f16508A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f16508A;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean m16692a(int i, int i2, int i3, int i4) {
        boolean z;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        i2 += 0;
        i += i3;
        i3 = 0 + i4;
        if (i2 <= 0) {
            if (i2 >= 0) {
                z = false;
                if (i > i3) {
                    i = 1;
                } else if (i >= 0) {
                    i = 1;
                    i3 = 0;
                } else {
                    i3 = i;
                    i = 0;
                }
                if (!(i == 0 || m16705d(1))) {
                    this.f16512c.springBack(i2, i3, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i2, i3, z, i);
                if (!z) {
                    if (i != 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        z = true;
        i2 = 0;
        if (i > i3) {
            i = 1;
        } else if (i >= 0) {
            i3 = i;
            i = 0;
        } else {
            i = 1;
            i3 = 0;
        }
        this.f16512c.springBack(i2, i3, 0, 0, 0, getScrollRange());
        onOverScrolled(i2, i3, z, i);
        if (z) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private boolean m16706e(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f16511b.top = 0;
        this.f16511b.bottom = height;
        if (i2 != 0) {
            int childCount = getChildCount();
            if (childCount > 0) {
                this.f16511b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
                this.f16511b.top = this.f16511b.bottom - height;
            }
        }
        return m16691a(i, this.f16511b.top, this.f16511b.bottom);
    }

    private boolean m16691a(int i, int i2, int i3) {
        boolean z;
        View view = this;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int height = getHeight();
        int scrollY = getScrollY();
        height += scrollY;
        Object obj = i4 == 33 ? 1 : null;
        List focusables = getFocusables(2);
        int size = focusables.size();
        View view2 = null;
        Object obj2 = null;
        for (int i7 = 0; i7 < size; i7++) {
            View view3 = (View) focusables.get(i7);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i5 < bottom && top < i6) {
                Object obj3 = (i5 >= top || bottom >= i6) ? null : 1;
                if (view2 == null) {
                    view2 = view3;
                    obj2 = obj3;
                } else {
                    Object obj4 = ((obj == null || top >= view2.getTop()) && (obj != null || bottom <= view2.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj3 == null || obj4 == null)) {
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        obj2 = 1;
                    } else if (obj4 == null) {
                    }
                    view2 = view3;
                }
            }
        }
        if (view2 == null) {
            view2 = view;
        }
        if (i5 < scrollY || i6 > height) {
            m16708g(obj != null ? i5 - scrollY : i6 - height);
            z = true;
        } else {
            z = false;
        }
        if (view2 != findFocus()) {
            view2.requestFocus(i4);
        }
        return z;
    }

    private boolean m16707f(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m16696a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom());
                if (bottom < maxScrollAmount) {
                    maxScrollAmount = bottom;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m16708g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f16511b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f16511b);
            m16708g(m16687a(this.f16511b));
            findNextFocus.requestFocus(i);
        }
        if (!(findFocus == null || findFocus.isFocused() == 0 || m16695a(findFocus) == 0)) {
            i = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(i);
        }
        return true;
    }

    private boolean m16695a(View view) {
        return m16696a(view, 0, getHeight()) == null;
    }

    private boolean m16696a(View view, int i, int i2) {
        view.getDrawingRect(this.f16511b);
        offsetDescendantRectToMyCoords(view, this.f16511b);
        return (this.f16511b.bottom + i < getScrollY() || this.f16511b.top - i > getScrollY() + i2) ? null : true;
    }

    private void m16708g(int i) {
        if (i != 0) {
            if (this.f16522m) {
                m16689a(0, i);
                return;
            }
            scrollBy(0, i);
        }
    }

    private void m16689a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f16510a > 250) {
                i = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f16512c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, i)) - scrollY);
                ViewCompat.m1234c(this);
            } else {
                if (!this.f16512c.isFinished()) {
                    this.f16512c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f16510a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m16710a(int i) {
        m16689a(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        int i = 0;
        if (this.f16512c.computeScrollOffset()) {
            this.f16512c.getCurrX();
            int currY = this.f16512c.getCurrY();
            int i2 = currY - this.f16530u;
            if (m16694a(i2, this.f16528s, null, 1)) {
                i2 -= this.f16528s[1];
            }
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                m16692a(i2, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                if (!m16693a(scrollY2, i2 - scrollY2, null, 1)) {
                    i2 = getOverScrollMode();
                    if (i2 == 0 || (i2 == 1 && scrollRange > 0)) {
                        i = 1;
                    }
                    if (i != 0) {
                        m16704d();
                        if (currY <= 0 && scrollY > 0) {
                            this.f16513d.onAbsorb((int) this.f16512c.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.f16514e.onAbsorb((int) this.f16512c.getCurrVelocity());
                        }
                    }
                }
            }
            this.f16530u = currY;
            ViewCompat.m1234c(this);
            return;
        }
        if (m16705d(1)) {
            m16703c(1);
        }
        this.f16530u = 0;
    }

    private void m16700b(View view) {
        view.getDrawingRect(this.f16511b);
        offsetDescendantRectToMyCoords(view, this.f16511b);
        view = m16687a(this.f16511b);
        if (view != null) {
            scrollBy(0, view);
        }
    }

    private int m16687a(Rect rect) {
        int i = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i2 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i2 && rect.top > scrollY) {
            if (rect.height() > height) {
                rect = (rect.top - scrollY) + null;
            } else {
                rect = (rect.bottom - i2) + null;
            }
            i = Math.min(rect, getChildAt(0).getBottom() - i2);
        } else if (rect.top < scrollY && rect.bottom < i2) {
            if (rect.height() > height) {
                i = 0 - (i2 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            i = Math.max(i, -getScrollY());
        }
        return i;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f16516g) {
            this.f16518i = view2;
        } else {
            m16700b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || m16695a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int a = m16687a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m16689a(0, a);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.f16516g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f16516g = false;
        if (!(this.f16518i == 0 || m16697a(this.f16518i, (View) this) == 0)) {
            m16700b(this.f16518i);
        }
        this.f16518i = null;
        if (this.f16517h == 0) {
            if (this.f16531v != 0) {
                scrollTo(getScrollX(), this.f16531v.f1653a);
                this.f16531v = null;
            }
            i = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > i) {
                scrollTo(getScrollX(), i);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f16517h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16517h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null) {
            if (this != findFocus) {
                if (m16696a(findFocus, 0, i4) != 0) {
                    findFocus.getDrawingRect(this.f16511b);
                    offsetDescendantRectToMyCoords(findFocus, this.f16511b);
                    m16708g(m16687a(this.f16511b));
                }
            }
        }
    }

    private static boolean m16697a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        view = view.getParent();
        if (!(view instanceof ViewGroup) || m16697a(view, view2) == null) {
            return null;
        }
        return true;
    }

    private void m16709h(int i) {
        boolean z;
        float f;
        int scrollY = getScrollY();
        if (scrollY > 0 || i > 0) {
            if (scrollY >= getScrollRange()) {
                if (i < 0) {
                }
            }
            z = true;
            f = (float) i;
            if (!dispatchNestedPreFling(0.0f, f)) {
                dispatchNestedFling(0.0f, f, z);
                if (getChildCount() > 0) {
                    m16701b(1);
                    this.f16512c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, RedditJobManager.f10810d, 0, 0);
                    this.f16530u = getScrollY();
                    ViewCompat.m1234c(this);
                }
            }
        }
        z = false;
        f = (float) i;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            if (getChildCount() > 0) {
                m16701b(1);
                this.f16512c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, RedditJobManager.f10810d, 0, 0);
                this.f16530u = getScrollY();
                ViewCompat.m1234c(this);
            }
        }
    }

    private void m16702c() {
        this.f16519j = false;
        m16699b();
        m16703c(0);
        if (this.f16513d != null) {
            this.f16513d.onRelease();
            this.f16514e.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            i = m16698b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            i2 = m16698b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    private void m16704d() {
        if (getOverScrollMode() == 2) {
            this.f16513d = null;
            this.f16514e = null;
        } else if (this.f16513d == null) {
            Context context = getContext();
            this.f16513d = new EdgeEffect(context);
            this.f16514e = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f16513d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f16513d.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f16513d.setSize(width, getHeight());
                if (this.f16513d.draw(canvas)) {
                    ViewCompat.m1234c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f16514e.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f16514e.setSize(width, height);
                if (this.f16514e.draw(canvas)) {
                    ViewCompat.m1234c(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f16531v = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1653a = getScrollY();
        return savedState;
    }
}
