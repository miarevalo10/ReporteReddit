package android.support.design.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0016R;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    int f11041a;
    int f11042b;
    boolean f11043c;
    int f11044d = 4;
    ViewDragHelper f11045e;
    int f11046f;
    WeakReference<V> f11047g;
    WeakReference<View> f11048h;
    BottomSheetCallback f11049i;
    int f11050j;
    boolean f11051k;
    private float f11052l;
    private int f11053m;
    private boolean f11054n;
    private int f11055o;
    private boolean f11056p;
    private boolean f11057q;
    private int f11058r;
    private boolean f11059s;
    private VelocityTracker f11060t;
    private int f11061u;
    private final Callback f11062v = new C09792(this);

    class C00261 implements Runnable {
        final /* synthetic */ View f450a;
        final /* synthetic */ int f451b = 4;
        final /* synthetic */ BottomSheetBehavior f452c;

        C00261(BottomSheetBehavior bottomSheetBehavior, View view) {
            this.f452c = bottomSheetBehavior;
            this.f450a = view;
        }

        public void run() {
            this.f452c.m9530a(this.f450a, this.f451b);
        }
    }

    public static abstract class BottomSheetCallback {
        public abstract void mo83a(int i);
    }

    private class SettleRunnable implements Runnable {
        final /* synthetic */ BottomSheetBehavior f453a;
        private final View f454b;
        private final int f455c;

        SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f453a = bottomSheetBehavior;
            this.f454b = view;
            this.f455c = i;
        }

        public void run() {
            if (this.f453a.f11045e == null || !this.f453a.f11045e.m1469b()) {
                this.f453a.m9528a(this.f455c);
            } else {
                ViewCompat.m1224a(this.f454b, (Runnable) this);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    class C09792 extends Callback {
        final /* synthetic */ BottomSheetBehavior f11040a;

        C09792(BottomSheetBehavior bottomSheetBehavior) {
            this.f11040a = bottomSheetBehavior;
        }

        public final boolean mo69a(View view, int i) {
            if (this.f11040a.f11044d == 1 || this.f11040a.f11051k) {
                return false;
            }
            if (this.f11040a.f11044d == 3 && this.f11040a.f11050j == i) {
                View view2 = (View) this.f11040a.f11048h.get();
                if (!(view2 == null || view2.canScrollVertically(-1) == 0)) {
                    return false;
                }
            }
            return this.f11040a.f11047g != 0 && this.f11040a.f11047g.get() == view;
        }

        public final void mo70b(View view, int i) {
            this.f11040a.m9527a();
        }

        public final void mo67a(int i) {
            if (i == 1) {
                this.f11040a.m9528a(1);
            }
        }

        public final void mo68a(View view, float f, float f2) {
            int i;
            int i2 = 4;
            if (f2 < 0.0f) {
                i = this.f11040a.f11041a;
            } else if (this.f11040a.f11043c && this.f11040a.m9536a(view, f2)) {
                i = this.f11040a.f11046f;
                i2 = 5;
                if (this.f11040a.f11045e.m1463a(view.getLeft(), i) != null) {
                    this.f11040a.m9528a(i2);
                }
                this.f11040a.m9528a((int) 2.8E-45f);
                ViewCompat.m1224a(view, new SettleRunnable(this.f11040a, view, i2));
                return;
            } else {
                if (f2 == 0.0f) {
                    f = view.getTop();
                    if (Math.abs(f - this.f11040a.f11041a) < Math.abs(f - this.f11040a.f11042b)) {
                        i = this.f11040a.f11041a;
                    } else {
                        i = this.f11040a.f11042b;
                    }
                } else {
                    i = this.f11040a.f11042b;
                }
                if (this.f11040a.f11045e.m1463a(view.getLeft(), i) != null) {
                    this.f11040a.m9528a((int) 2.8E-45f);
                    ViewCompat.m1224a(view, new SettleRunnable(this.f11040a, view, i2));
                    return;
                }
                this.f11040a.m9528a(i2);
            }
            i2 = 3;
            if (this.f11040a.f11045e.m1463a(view.getLeft(), i) != null) {
                this.f11040a.m9528a((int) 2.8E-45f);
                ViewCompat.m1224a(view, new SettleRunnable(this.f11040a, view, i2));
                return;
            }
            this.f11040a.m9528a(i2);
        }

        public final int mo71c(View view, int i) {
            return MathUtils.m854a(i, this.f11040a.f11041a, this.f11040a.f11043c ? this.f11040a.f11046f : this.f11040a.f11042b);
        }

        public final int mo72d(View view, int i) {
            return view.getLeft();
        }

        public final int mo66a() {
            if (this.f11040a.f11043c) {
                return this.f11040a.f11046f - this.f11040a.f11041a;
            }
            return this.f11040a.f11042b - this.f11040a.f11041a;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C00271();
        final int state;

        static class C00271 implements ClassLoaderCreator<SavedState> {
            C00271() {
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0016R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = attributeSet.peekValue(C0016R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            m9526b(attributeSet.getDimensionPixelSize(C0016R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            m9526b(peekValue.data);
        }
        this.f11043c = attributeSet.getBoolean(C0016R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        this.f11056p = attributeSet.getBoolean(C0016R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        attributeSet.recycle();
        this.f11052l = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable mo79b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo79b(coordinatorLayout, (View) v), this.f11044d);
    }

    public final void mo73a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo73a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.state != 1) {
            if (savedState.state != 2) {
                this.f11044d = savedState.state;
                return;
            }
        }
        this.f11044d = 4;
    }

    public final boolean mo75a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.m1265z(coordinatorLayout) && !ViewCompat.m1265z(v)) {
            ViewCompat.m1232b((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m16546a((View) v, i);
        this.f11046f = coordinatorLayout.getHeight();
        if (this.f11054n != 0) {
            if (this.f11055o == 0) {
                this.f11055o = coordinatorLayout.getResources().getDimensionPixelSize(C0016R.dimen.design_bottom_sheet_peek_height_min);
            }
            i = Math.max(this.f11055o, this.f11046f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i = this.f11053m;
        }
        this.f11041a = Math.max(0, this.f11046f - v.getHeight());
        this.f11042b = Math.max(this.f11046f - i, this.f11041a);
        if (this.f11044d == 3) {
            ViewCompat.m1231b((View) v, this.f11041a);
        } else if (this.f11043c != 0 && this.f11044d == 5) {
            ViewCompat.m1231b((View) v, this.f11046f);
        } else if (this.f11044d == 4) {
            ViewCompat.m1231b((View) v, this.f11042b);
        } else if (this.f11044d == 1 || this.f11044d == 2) {
            ViewCompat.m1231b((View) v, top - v.getTop());
        }
        if (this.f11045e == 0) {
            this.f11045e = ViewDragHelper.m1447a((ViewGroup) coordinatorLayout, this.f11062v);
        }
        this.f11047g = new WeakReference(v);
        this.f11048h = new WeakReference(m9524b((View) v));
        return true;
    }

    public final boolean mo76a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                m9525b();
            }
            if (this.f11060t == null) {
                this.f11060t = VelocityTracker.obtain();
            }
            this.f11060t.addMovement(motionEvent);
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        this.f11061u = (int) motionEvent.getY();
                        View view = this.f11048h != null ? (View) this.f11048h.get() : null;
                        if (view != null && coordinatorLayout.m16550a(view, x, this.f11061u)) {
                            this.f11050j = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.f11051k = true;
                        }
                        v = (this.f11050j == -1 && coordinatorLayout.m16550a((View) v, x, this.f11061u) == null) ? 1 : null;
                        this.f11057q = v;
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
            this.f11051k = false;
            this.f11050j = -1;
            if (this.f11057q != null) {
                this.f11057q = false;
                return false;
            }
            if (this.f11057q == null && this.f11045e.m1464a(motionEvent) != null) {
                return true;
            }
            View view2 = (View) this.f11048h.get();
            return actionMasked == 2 && view2 != null && !this.f11057q && this.f11044d != 1 && coordinatorLayout.m16550a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) == null && Math.abs(((float) this.f11061u) - motionEvent.getY()) > ((float) this.f11045e.f1675b);
        } else {
            this.f11057q = true;
            return false;
        }
    }

    public final boolean mo80b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown() == null) {
            return false;
        }
        coordinatorLayout = motionEvent.getActionMasked();
        if (this.f11044d == 1 && coordinatorLayout == null) {
            return true;
        }
        if (this.f11045e != null) {
            this.f11045e.m1468b(motionEvent);
        }
        if (coordinatorLayout == null) {
            m9525b();
        }
        if (this.f11060t == null) {
            this.f11060t = VelocityTracker.obtain();
        }
        this.f11060t.addMovement(motionEvent);
        if (coordinatorLayout == 2 && this.f11057q == null && Math.abs(((float) this.f11061u) - motionEvent.getY()) > ((float) this.f11045e.f1675b)) {
            this.f11045e.m1461a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.f11057q == null) {
            return true;
        }
        return false;
    }

    public final boolean mo78a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f11058r = 0;
        this.f11059s = false;
        if ((i & 2) != null) {
            return true;
        }
        return false;
    }

    public final void mo74a(V v, View view, int i, int[] iArr) {
        if (view == ((View) this.f11048h.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.f11041a) {
                    iArr[1] = top - this.f11041a;
                    ViewCompat.m1231b((View) v, -iArr[1]);
                    m9528a(3);
                } else {
                    iArr[1] = i;
                    ViewCompat.m1231b((View) v, -i);
                    m9528a(1);
                }
            } else if (i < 0 && view.canScrollVertically(-1) == null) {
                if (i2 > this.f11042b) {
                    if (this.f11043c == null) {
                        iArr[1] = top - this.f11042b;
                        ViewCompat.m1231b((View) v, -iArr[1]);
                        m9528a(4);
                    }
                }
                iArr[1] = i;
                ViewCompat.m1231b((View) v, -i);
                m9528a(1);
            }
            v.getTop();
            m9527a();
            this.f11058r = i;
            this.f11059s = true;
        }
    }

    public final void mo81c(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f11041a) {
            m9528a(3);
            return;
        }
        if (this.f11048h != null && view == this.f11048h.get()) {
            if (this.f11059s != null) {
                int i2;
                if (this.f11058r > null) {
                    i2 = this.f11041a;
                } else {
                    if (this.f11043c != null) {
                        this.f11060t.computeCurrentVelocity(1000, this.f11052l);
                        if (m9536a((View) v, this.f11060t.getYVelocity(this.f11050j)) != null) {
                            i2 = this.f11046f;
                            i = 5;
                        }
                    }
                    if (this.f11058r == null) {
                        coordinatorLayout = v.getTop();
                        if (Math.abs(coordinatorLayout - this.f11041a) < Math.abs(coordinatorLayout - this.f11042b)) {
                            i2 = this.f11041a;
                        } else {
                            i2 = this.f11042b;
                        }
                    } else {
                        i2 = this.f11042b;
                    }
                    i = 4;
                }
                if (this.f11045e.m1465a((View) v, v.getLeft(), i2) != null) {
                    m9528a(2);
                    ViewCompat.m1224a((View) v, new SettleRunnable(this, v, i));
                } else {
                    m9528a(i);
                }
                this.f11059s = null;
            }
        }
    }

    public final boolean mo77a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return (view != this.f11048h.get() || (this.f11044d == 3 && super.mo77a(coordinatorLayout, (View) v, view, f, f2) == null)) ? null : true;
    }

    private void m9526b(int i) {
        boolean z = true;
        if (i != -1) {
            if (!this.f11054n) {
                if (this.f11053m != i) {
                }
            }
            this.f11054n = false;
            this.f11053m = Math.max(0, i);
            this.f11042b = this.f11046f - i;
            if (!z) {
            }
        } else if (this.f11054n == 0) {
            this.f11054n = true;
            if (!z && this.f11044d == 4 && this.f11047g != 0) {
                View view = (View) this.f11047g.get();
                if (view != null) {
                    view.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
    }

    final void m9528a(int i) {
        if (this.f11044d != i) {
            this.f11044d = i;
            if (!(((View) this.f11047g.get()) == null || this.f11049i == null)) {
                this.f11049i.mo83a(i);
            }
        }
    }

    private void m9525b() {
        this.f11050j = -1;
        if (this.f11060t != null) {
            this.f11060t.recycle();
            this.f11060t = null;
        }
    }

    final boolean m9536a(View view, float f) {
        if (this.f11056p) {
            return true;
        }
        if (view.getTop() >= this.f11042b && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.f11042b)) / ((float) this.f11053m) > 0.5f) {
            return true;
        }
        return false;
    }

    private View m9524b(View view) {
        if (ViewCompat.m1204E(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View b = m9524b(viewGroup.getChildAt(i));
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    final void m9530a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.f11042b;
        } else if (i == 3) {
            i2 = this.f11041a;
        } else if (this.f11043c && i == 5) {
            i2 = this.f11046f;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Illegal state argument: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.f11045e.m1465a(view, view.getLeft(), i2)) {
            m9528a(2);
            ViewCompat.m1224a(view, new SettleRunnable(this, view, i));
            return;
        }
        m9528a(i);
    }

    final void m9527a() {
        this.f11047g.get();
    }

    public static <V extends View> BottomSheetBehavior<V> m9523a(V v) {
        v = v.getLayoutParams();
        if (v instanceof LayoutParams) {
            v = ((LayoutParams) v).f543a;
            if (v instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) v;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
