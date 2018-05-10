package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresApi;
import android.support.design.C0016R;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@DefaultBehavior(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean f416a;
    int f417b;
    WindowInsetsCompat f418c;
    boolean f419d;
    private int f420e;
    private int f421f;
    private int f422g;
    private List<OnOffsetChangedListener> f423h;
    private boolean f424i;
    private int[] f425j;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public int f414a = 1;
        Interpolator f415b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            attributeSet = context.obtainStyledAttributes(attributeSet, C0016R.styleable.AppBarLayout_Layout);
            this.f414a = attributeSet.getInt(C0016R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (attributeSet.hasValue(C0016R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f415b = AnimationUtils.loadInterpolator(context, attributeSet.getResourceId(C0016R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            attributeSet.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface OnOffsetChangedListener {
        void mo85a(AppBarLayout appBarLayout, int i);
    }

    class C09731 implements OnApplyWindowInsetsListener {
        final /* synthetic */ AppBarLayout f11034a;

        C09731(AppBarLayout appBarLayout) {
            this.f11034a = appBarLayout;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            view = this.f11034a;
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.m1265z(view) ? windowInsetsCompat : null;
            if (!ObjectsCompat.m1037a(view.f418c, windowInsetsCompat2)) {
                view.f418c = windowInsetsCompat2;
                view.m169a();
            }
            return windowInsetsCompat;
        }
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private int f18833b;
        private ValueAnimator f18834c;
        private int f18835d = -1;
        private boolean f18836e;
        private float f18837f;
        private WeakReference<View> f18838g;
        private DragCallback f18839h;

        public static abstract class DragCallback {
            public abstract boolean m165a();
        }

        protected static class SavedState extends AbsSavedState {
            public static final Creator<SavedState> CREATOR = new C00201();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            static class C00201 implements ClassLoaderCreator<SavedState> {
                C00201() {
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
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != null ? true : null;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte((byte) this.firstVisibleChildAtMinimumHeight);
            }
        }

        private static boolean m19879a(int i, int i2) {
            return (i & i2) == i2;
        }

        final /* synthetic */ int mo3818a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int a = mo3817a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f18833b = 0;
                return 0;
            }
            i = MathUtils.m854a(i, i2, i3);
            if (a == i) {
                return 0;
            }
            int i4;
            View childAt;
            android.support.design.widget.CoordinatorLayout.Behavior behavior;
            if (appBarLayout.f416a != 0) {
                i2 = Math.abs(i);
                i3 = appBarLayout.getChildCount();
                i4 = 0;
                while (i4 < i3) {
                    childAt = appBarLayout.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator interpolator = layoutParams.f415b;
                    if (i2 < childAt.getTop() || i2 > childAt.getBottom()) {
                        i4++;
                    } else if (interpolator != null) {
                        i3 = layoutParams.f414a;
                        if ((i3 & 1) != 0) {
                            i4 = ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) + 0;
                            i3 = (i3 & 2) != 0 ? i4 - ViewCompat.m1253n(childAt) : i4;
                        } else {
                            i3 = 0;
                        }
                        if (ViewCompat.m1265z(childAt)) {
                            i3 -= appBarLayout.getTopInset();
                        }
                        if (i3 > 0) {
                            i3 = (float) i3;
                            i2 = Integer.signum(i) * (childAt.getTop() + Math.round(i3 * interpolator.getInterpolation(((float) (i2 - childAt.getTop())) / i3)));
                            i3 = super.mo3824a(i2);
                            i4 = a - i;
                            this.f18833b = i - i2;
                            if (i3 == 0 && appBarLayout.f416a != 0) {
                                i2 = coordinatorLayout.f16424e.m251b(appBarLayout);
                                if (i2 != 0 && i2.isEmpty() == 0) {
                                    for (i3 = 0; i3 < i2.size(); i3++) {
                                        childAt = (View) i2.get(i3);
                                        behavior = ((android.support.design.widget.CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f543a;
                                        if (behavior != null) {
                                            behavior.mo88b(coordinatorLayout, childAt, (View) appBarLayout);
                                        }
                                    }
                                }
                            }
                            appBarLayout.m170a(super.mo3828c());
                            m19878a(coordinatorLayout, appBarLayout, i, i >= a ? -1 : 1, false);
                            return i4;
                        }
                    }
                }
            }
            i2 = i;
            i3 = super.mo3824a(i2);
            i4 = a - i;
            this.f18833b = i - i2;
            i2 = coordinatorLayout.f16424e.m251b(appBarLayout);
            for (i3 = 0; i3 < i2.size(); i3++) {
                childAt = (View) i2.get(i3);
                behavior = ((android.support.design.widget.CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f543a;
                if (behavior != null) {
                    behavior.mo88b(coordinatorLayout, childAt, (View) appBarLayout);
                }
            }
            appBarLayout.m170a(super.mo3828c());
            if (i >= a) {
            }
            m19878a(coordinatorLayout, appBarLayout, i, i >= a ? -1 : 1, false);
            return i4;
        }

        final /* synthetic */ int mo3819a(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        public final /* synthetic */ void mo73a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo73a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f18835d = savedState.firstVisibleChildIndex;
                this.f18837f = savedState.firstVisibleChildPercentageShown;
                this.f18836e = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.mo73a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f18835d = -1;
        }

        public final /* synthetic */ void mo3821a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i == 0) {
                m19876a(coordinatorLayout, appBarLayout);
            }
            this.f18838g = new WeakReference(view2);
        }

        public final /* synthetic */ void mo3822a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i2 < 0) {
                m16560b(coordinatorLayout, appBarLayout, i2, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        public final /* synthetic */ void mo3823a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int[] iArr, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i != 0) {
                if (i < 0) {
                    view = -appBarLayout.getTotalScrollRange();
                    view2 = appBarLayout.getDownNestedPreScrollRange() + view;
                } else {
                    view = -appBarLayout.getUpNestedPreScrollRange();
                    view2 = null;
                }
                int i3 = view;
                int i4 = view2;
                if (i3 != i4) {
                    iArr[1] = m16560b(coordinatorLayout, appBarLayout, i, i3, i4);
                }
            }
        }

        public final /* synthetic */ boolean mo75a(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            i = super.mo75a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.f18835d >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.f18835d);
                int i2 = -childAt.getBottom();
                if (this.f18836e) {
                    i2 += ViewCompat.m1253n(childAt) + appBarLayout.getTopInset();
                } else {
                    i2 += Math.round(((float) childAt.getHeight()) * this.f18837f);
                }
                a_(coordinatorLayout, appBarLayout, i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        m19877a(coordinatorLayout, appBarLayout, pendingAction);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m19877a(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.f417b = 0;
            this.f18835d = -1;
            super.mo3824a(MathUtils.m854a(super.mo3828c(), -appBarLayout.getTotalScrollRange(), 0));
            m19878a(coordinatorLayout, appBarLayout, super.mo3828c(), 0, true);
            appBarLayout.m170a(super.mo3828c());
            return i;
        }

        public final /* synthetic */ boolean mo3086a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            View view2 = (AppBarLayout) view;
            if (((android.support.design.widget.CoordinatorLayout.LayoutParams) view2.getLayoutParams()).height != -2) {
                return super.mo3086a(coordinatorLayout, view2, i, i2, i3, i4);
            }
            coordinatorLayout.m16548a(view2, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public final /* synthetic */ boolean mo3825a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            view3 = i & 2;
            i = 0;
            if (view3 != null) {
                if ((appBarLayout.getTotalScrollRange() != null ? 1 : null) != null && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()) {
                    i = 1;
                }
            }
            if (!(i == 0 || this.f18834c == null)) {
                this.f18834c.cancel();
            }
            this.f18838g = null;
            return i;
        }

        final /* synthetic */ int mo3826b(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        public final /* synthetic */ Parcelable mo79b(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            coordinatorLayout = super.mo79b(coordinatorLayout, (View) appBarLayout);
            int c = super.mo3828c();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + c;
                if (childAt.getTop() + c > 0 || bottom < 0) {
                    i++;
                } else {
                    Parcelable savedState = new SavedState(coordinatorLayout);
                    savedState.firstVisibleChildIndex = i;
                    if (bottom == ViewCompat.m1253n(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z;
                    savedState.firstVisibleChildPercentageShown = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return coordinatorLayout;
        }

        public final /* bridge */ /* synthetic */ int mo3828c() {
            return super.mo3828c();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void m19877a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int round;
            int abs = Math.abs(mo3817a() - i);
            float abs2 = Math.abs(0.0f);
            if (abs2 > 0.0f) {
                round = 3 * Math.round(1000.0f * (((float) abs) / abs2));
            } else {
                round = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            if (mo3817a() == i) {
                if (!(this.f18834c == null || this.f18834c.isRunning() == null)) {
                    this.f18834c.cancel();
                }
                return;
            }
            if (this.f18834c == null) {
                this.f18834c = new ValueAnimator();
                this.f18834c.setInterpolator(AnimationUtils.f410e);
                this.f18834c.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ Behavior f413c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f413c.a_(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.f18834c.cancel();
            }
            this.f18834c.setDuration((long) Math.min(round, 600));
            this.f18834c.setIntValues(new int[]{abs, i});
            this.f18834c.start();
        }

        private void m19876a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo3817a();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int i2 = -a;
                if (childAt.getTop() <= i2 && childAt.getBottom() >= i2) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                int i3 = ((LayoutParams) childAt2.getLayoutParams()).f414a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    i2 = -childAt2.getBottom();
                    if (i == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m19879a(i3, 2)) {
                        i2 += ViewCompat.m1253n(childAt2);
                    } else if (m19879a(i3, 5)) {
                        childCount = ViewCompat.m1253n(childAt2) + i2;
                        if (a < childCount) {
                            i4 = childCount;
                        } else {
                            i2 = childCount;
                        }
                    }
                    if (a < (i2 + i4) / 2) {
                        i4 = i2;
                    }
                    m19877a(coordinatorLayout, appBarLayout, MathUtils.m854a(i4, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void m19878a(android.support.design.widget.CoordinatorLayout r6, android.support.design.widget.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
            r0 = java.lang.Math.abs(r8);
            r1 = r7.getChildCount();
            r2 = 0;
            r3 = r2;
        L_0x000a:
            if (r3 >= r1) goto L_0x0020;
        L_0x000c:
            r4 = r7.getChildAt(r3);
            r5 = r4.getTop();
            if (r0 < r5) goto L_0x001d;
        L_0x0016:
            r5 = r4.getBottom();
            if (r0 > r5) goto L_0x001d;
        L_0x001c:
            goto L_0x0021;
        L_0x001d:
            r3 = r3 + 1;
            goto L_0x000a;
        L_0x0020:
            r4 = 0;
        L_0x0021:
            if (r4 == 0) goto L_0x00af;
        L_0x0023:
            r0 = r4.getLayoutParams();
            r0 = (android.support.design.widget.AppBarLayout.LayoutParams) r0;
            r0 = r0.f414a;
            r1 = r0 & 1;
            r3 = 1;
            if (r1 == 0) goto L_0x005b;
        L_0x0030:
            r1 = android.support.v4.view.ViewCompat.m1253n(r4);
            if (r9 <= 0) goto L_0x0049;
        L_0x0036:
            r9 = r0 & 12;
            if (r9 == 0) goto L_0x0049;
        L_0x003a:
            r8 = -r8;
            r9 = r4.getBottom();
            r9 = r9 - r1;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x005b;
        L_0x0047:
            r8 = r3;
            goto L_0x005c;
        L_0x0049:
            r9 = r0 & 2;
            if (r9 == 0) goto L_0x005b;
        L_0x004d:
            r8 = -r8;
            r9 = r4.getBottom();
            r9 = r9 - r1;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x005b;
        L_0x005a:
            goto L_0x0047;
        L_0x005b:
            r8 = r2;
        L_0x005c:
            r9 = r7.f419d;
            if (r9 == r8) goto L_0x0067;
        L_0x0060:
            r7.f419d = r8;
            r7.refreshDrawableState();
            r8 = r3;
            goto L_0x0068;
        L_0x0067:
            r8 = r2;
        L_0x0068:
            r9 = android.os.Build.VERSION.SDK_INT;
            r0 = 11;
            if (r9 < r0) goto L_0x00af;
        L_0x006e:
            if (r10 != 0) goto L_0x00ac;
        L_0x0070:
            if (r8 == 0) goto L_0x00af;
        L_0x0072:
            r8 = r6.f16424e;
            r8 = r8.m251b(r7);
            r9 = r6.f16425f;
            r9.clear();
            if (r8 == 0) goto L_0x0084;
        L_0x007f:
            r9 = r6.f16425f;
            r9.addAll(r8);
        L_0x0084:
            r6 = r6.f16425f;
            r8 = r6.size();
            r9 = r2;
        L_0x008b:
            if (r9 >= r8) goto L_0x00aa;
        L_0x008d:
            r10 = r6.get(r9);
            r10 = (android.view.View) r10;
            r10 = r10.getLayoutParams();
            r10 = (android.support.design.widget.CoordinatorLayout.LayoutParams) r10;
            r10 = r10.f543a;
            r0 = r10 instanceof android.support.design.widget.AppBarLayout.ScrollingViewBehavior;
            if (r0 == 0) goto L_0x00a7;
        L_0x009f:
            r10 = (android.support.design.widget.AppBarLayout.ScrollingViewBehavior) r10;
            r6 = r10.f16452d;
            if (r6 == 0) goto L_0x00aa;
        L_0x00a5:
            r2 = r3;
            goto L_0x00aa;
        L_0x00a7:
            r9 = r9 + 1;
            goto L_0x008b;
        L_0x00aa:
            if (r2 == 0) goto L_0x00af;
        L_0x00ac:
            r7.jumpDrawablesToCurrentState();
        L_0x00af:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.Behavior.a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        final int mo3817a() {
            return super.mo3828c() + this.f18833b;
        }

        final /* synthetic */ boolean mo3827b() {
            if (this.f18839h != null) {
                return this.f18839h.m165a();
            }
            if (this.f18838g != null) {
                View view = (View) this.f18838g.get();
                if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        final /* synthetic */ View mo3830a(List list) {
            return m19896b(list);
        }

        public final /* bridge */ /* synthetic */ boolean mo3086a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo3086a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public final /* bridge */ /* synthetic */ int mo3828c() {
            return super.mo3828c();
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.ScrollingViewBehavior_Layout);
            this.f16452d = context.getDimensionPixelSize(C0016R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            context.recycle();
        }

        public final boolean mo3832a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public final boolean mo3831a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout b = m19896b(coordinatorLayout.m16544a(view));
            if (b != null) {
                rect.offset(view.getLeft(), view.getTop());
                view = this.a;
                view.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (view.contains(rect) == null) {
                    b.m172a(false, z ^ 1, true);
                    return true;
                }
            }
            return false;
        }

        final float mo3829a(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                view = ((android.support.design.widget.CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f543a;
                view = view instanceof Behavior ? ((Behavior) view).mo3817a() : null;
                if (downNestedPreScrollRange != 0 && totalScrollRange + view <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return 1.0f + (((float) view) / ((float) totalScrollRange));
                }
            }
            return 0.0f;
        }

        private static AppBarLayout m19896b(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        final int mo3833b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo3833b(view);
        }

        public boolean mo88b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            coordinatorLayout = ((android.support.design.widget.CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f543a;
            if (coordinatorLayout instanceof Behavior) {
                ViewCompat.m1231b(view, (((view2.getBottom() - view.getTop()) + ((Behavior) coordinatorLayout).f18833b) + this.f16451c) - m16569c(view2));
            }
            return null;
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m167a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m168a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m44250generateLayoutParams(AttributeSet attributeSet) {
        return m167a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m44251generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m168a(layoutParams);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f420e = -1;
        this.f421f = -1;
        this.f422g = -1;
        this.f417b = 0;
        setOrientation(1);
        ThemeUtils.m333a(context);
        if (VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m358a(this);
            ViewUtilsLollipop.m360a(this, attributeSet, C0016R.style.Widget_Design_AppBarLayout);
        }
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.AppBarLayout, 0, C0016R.style.Widget_Design_AppBarLayout);
        ViewCompat.m1219a((View) this, context.getDrawable(C0016R.styleable.AppBarLayout_android_background));
        if (context.hasValue(C0016R.styleable.AppBarLayout_expanded) != null) {
            m172a(context.getBoolean(C0016R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && context.hasValue(C0016R.styleable.AppBarLayout_elevation) != null) {
            ViewUtilsLollipop.m359a(this, (float) context.getDimensionPixelSize(C0016R.styleable.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (context.hasValue(C0016R.styleable.AppBarLayout_android_keyboardNavigationCluster) != null) {
                setKeyboardNavigationCluster(context.getBoolean(C0016R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (context.hasValue(C0016R.styleable.AppBarLayout_android_touchscreenBlocksFocus) != null) {
                setTouchscreenBlocksFocus(context.getBoolean(C0016R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        context.recycle();
        ViewCompat.m1221a((View) this, new C09731(this));
    }

    public final void m171a(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.f423h == null) {
            this.f423h = new ArrayList();
        }
        if (onOffsetChangedListener != null && !this.f423h.contains(onOffsetChangedListener)) {
            this.f423h.add(onOffsetChangedListener);
        }
    }

    public final void m173b(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.f423h != null && onOffsetChangedListener != null) {
            this.f423h.remove(onOffsetChangedListener);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m169a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m169a();
        z = false;
        this.f416a = false;
        i = getChildCount();
        for (i2 = 0; i2 < i; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).f415b != 0) {
                this.f416a = true;
                break;
            }
        }
        i = getChildCount();
        for (i2 = 0; i2 < i; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            i4 = ((layoutParams.f414a & 1) != 1 || (layoutParams.f414a & 10) == 0) ? 0 : 1;
            if (i4 != 0) {
                z = true;
                break;
            }
        }
        if (this.f424i != z) {
            this.f424i = z;
            refreshDrawableState();
        }
    }

    final void m169a() {
        this.f420e = -1;
        this.f421f = -1;
        this.f422g = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        m172a(z, ViewCompat.m1206G(this), true);
    }

    public final void m172a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        z = (z ? true : true) | (z2 ? true : false);
        if (z3) {
            i = 8;
        }
        this.f417b = z | i;
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams m167a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams m168a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof android.widget.LinearLayout.LayoutParams)) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int getTotalScrollRange() {
        if (this.f420e != -1) {
            return this.f420e;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f414a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += (measuredHeight + layoutParams.topMargin) + layoutParams.bottomMargin;
            if ((i3 & 2) != 0) {
                i2 -= ViewCompat.m1253n(childAt);
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2 - getTopInset());
        this.f420e = childCount;
        return childCount;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.f421f != -1) {
            return this.f421f;
        }
        int childCount;
        int i = 0;
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = layoutParams.f414a;
            if ((i2 & 5) != 5) {
                if (i > 0) {
                    break;
                }
            } else {
                i += layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i2 & 8) != 0) {
                    i += ViewCompat.m1253n(childAt);
                } else if ((i2 & 2) != 0) {
                    i += measuredHeight - ViewCompat.m1253n(childAt);
                } else {
                    i += measuredHeight - getTopInset();
                }
            }
        }
        childCount = Math.max(0, i);
        this.f421f = childCount;
        return childCount;
    }

    int getDownNestedScrollRange() {
        if (this.f422g != -1) {
            return this.f422g;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            int i3 = layoutParams.f414a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i3 & 2) != 0) {
                i2 -= ViewCompat.m1253n(childAt) + getTopInset();
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2);
        this.f422g = childCount;
        return childCount;
    }

    final void m170a(int i) {
        if (this.f423h != null) {
            int size = this.f423h.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnOffsetChangedListener onOffsetChangedListener = (OnOffsetChangedListener) this.f423h.get(i2);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.mo85a(this, i);
                }
            }
        }
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int n = ViewCompat.m1253n(this);
        if (n != 0) {
            return (n * 2) + topInset;
        }
        n = getChildCount();
        n = n > 0 ? ViewCompat.m1253n(getChildAt(n - 1)) : 0;
        if (n != 0) {
            return (n * 2) + topInset;
        }
        return getHeight() / 3;
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.f425j == null) {
            this.f425j = new int[2];
        }
        int[] iArr = this.f425j;
        i = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f424i ? C0016R.attr.state_collapsible : -C0016R.attr.state_collapsible;
        int i2 = (this.f424i && this.f419d) ? C0016R.attr.state_collapsed : -C0016R.attr.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(i, iArr);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m359a(this, f);
        }
    }

    int getPendingAction() {
        return this.f417b;
    }

    final int getTopInset() {
        return this.f418c != null ? this.f418c.m1309b() : 0;
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m44249generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
