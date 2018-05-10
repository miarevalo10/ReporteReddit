package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.C0182R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.google.android.gms.ads.AdRequest;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (VERSION.SDK_INT < 23);
    private static final boolean ALLOW_THREAD_GAP_WORK = (VERSION.SDK_INT < 21);
    private static final int[] CLIP_TO_PADDING_ATTR = new int[]{16842987};
    static final boolean DEBUG = false;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (VERSION.SDK_INT > 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (VERSION.SDK_INT > 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = new int[]{16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (VERSION.SDK_INT < 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new C02143();
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    private int mDispatchScrollCounter;
    private int mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutRequestEaten;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private final int[] mScrollConsumed;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    class C02121 implements Runnable {
        final /* synthetic */ RecyclerView f2347a;

        C02121(RecyclerView recyclerView) {
            this.f2347a = recyclerView;
        }

        public void run() {
            if (this.f2347a.mFirstLayoutComplete) {
                if (!this.f2347a.isLayoutRequested()) {
                    if (!this.f2347a.mIsAttached) {
                        this.f2347a.requestLayout();
                    } else if (this.f2347a.mLayoutFrozen) {
                        this.f2347a.mLayoutRequestEaten = true;
                    } else {
                        this.f2347a.consumePendingUpdateOperations();
                    }
                }
            }
        }
    }

    class C02132 implements Runnable {
        final /* synthetic */ RecyclerView f2348a;

        C02132(RecyclerView recyclerView) {
            this.f2348a = recyclerView;
        }

        public void run() {
            if (this.f2348a.mItemAnimator != null) {
                this.f2348a.mItemAnimator.mo3230a();
            }
            this.f2348a.mPostedAnimatorRunner = false;
        }
    }

    static class C02143 implements Interpolator {
        public final float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C02143() {
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        public final AdapterDataObservable a_ = new AdapterDataObservable();
        protected boolean f2349e = false;

        public abstract int mo39a();

        public long mo40a(int i) {
            return -1;
        }

        public abstract VH mo41a(ViewGroup viewGroup, int i);

        public void mo42a(VH vh) {
        }

        public abstract void mo43a(VH vh, int i);

        public int mo44b(int i) {
            return 0;
        }

        public void m2024b(VH vh) {
        }

        public void m2026c(VH vh) {
        }

        public final VH m2021b(ViewGroup viewGroup, int i) {
            TraceCompat.m975a(RecyclerView.TRACE_CREATE_VIEW_TAG);
            viewGroup = mo41a(viewGroup, i);
            viewGroup.f2429h = i;
            TraceCompat.m974a();
            return viewGroup;
        }

        public final boolean m2029d() {
            return this.f2349e;
        }

        public final void m2016a(AdapterDataObserver adapterDataObserver) {
            this.a_.registerObserver(adapterDataObserver);
        }

        public final void m2023b(AdapterDataObserver adapterDataObserver) {
            this.a_.unregisterObserver(adapterDataObserver);
        }

        public final void m2030e() {
            this.a_.m2036b();
        }

        public final void m2027d(int i) {
            this.a_.m2033a(i, 1);
        }

        public final void m2014a(int i, int i2) {
            this.a_.m2033a(i, i2);
        }

        public final void m2015a(int i, int i2, Object obj) {
            this.a_.m2034a(i, i2, obj);
        }

        public final void m2031e(int i) {
            this.a_.m2037b(i, 1);
        }

        public final void m2022b(int i, int i2) {
            this.a_.m2039d(i, i2);
        }

        public final void m2025c(int i, int i2) {
            this.a_.m2037b(i, i2);
        }

        public final void m2032f(int i) {
            this.a_.m2038c(i, 1);
        }

        public final void m2028d(int i, int i2) {
            this.a_.m2038c(i, i2);
        }

        public void m2019a(boolean z) {
            if (this.a_.m2035a()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f2349e = z;
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public final boolean m2035a() {
            return !this.mObservers.isEmpty();
        }

        public final void m2036b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo704a();
            }
        }

        public final void m2033a(int i, int i2) {
            m2034a(i, i2, null);
        }

        public final void m2034a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo705a(i, i2, obj);
            }
        }

        public final void m2037b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo706b(i, i2);
            }
        }

        public final void m2038c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo707c(i, i2);
            }
        }

        public final void m2039d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo708d(i, i2);
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void mo704a() {
        }

        public void m2041a(int i, int i2) {
        }

        public void mo706b(int i, int i2) {
        }

        public void mo707c(int i, int i2) {
        }

        public void mo708d(int i, int i2) {
        }

        public void mo705a(int i, int i2, Object obj) {
            m2041a(i, i2);
        }
    }

    public interface ChildDrawingOrderCallback {
        int m2046a();
    }

    public static abstract class ItemAnimator {
        private ArrayList<Object> f2354a = new ArrayList();
        ItemAnimatorListener f2355h = null;
        protected long f2356i = 120;
        protected long f2357j = 120;
        protected long f2358k = 250;
        protected long f2359l = 250;

        interface ItemAnimatorListener {
            void mo698a(ViewHolder viewHolder);
        }

        public static class ItemHolderInfo {
            public int f2350a;
            public int f2351b;
            public int f2352c;
            public int f2353d;

            public final ItemHolderInfo m2048a(ViewHolder viewHolder) {
                viewHolder = viewHolder.f2424c;
                this.f2350a = viewHolder.getLeft();
                this.f2351b = viewHolder.getTop();
                this.f2352c = viewHolder.getRight();
                this.f2353d = viewHolder.getBottom();
                return this;
            }
        }

        public abstract void mo3230a();

        public abstract boolean mo711a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean mo712a(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean mo3235b();

        public abstract boolean mo713b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract void mo3237c(ViewHolder viewHolder);

        public abstract boolean mo714c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract void mo3238d();

        public boolean mo715g(ViewHolder viewHolder) {
            return true;
        }

        static int m2050e(ViewHolder viewHolder) {
            int f = viewHolder.f2423a & 14;
            if (viewHolder.m2234l()) {
                return 4;
            }
            if ((f & 4) == 0) {
                int i = viewHolder.f2427f;
                viewHolder = viewHolder.m2226d();
                if (!(i == -1 || viewHolder == -1 || i == viewHolder)) {
                    f |= MPEGConst.CODE_END;
                }
            }
            return f;
        }

        public final void m2062f(ViewHolder viewHolder) {
            if (this.f2355h != null) {
                this.f2355h.mo698a(viewHolder);
            }
        }

        public boolean mo3234a(ViewHolder viewHolder, List<Object> list) {
            return mo715g(viewHolder);
        }

        public final void m2061e() {
            int size = this.f2354a.size();
            for (int i = 0; i < size; i++) {
                this.f2354a.get(i);
            }
            this.f2354a.clear();
        }

        public static ItemHolderInfo m2051f() {
            return new ItemHolderInfo();
        }

        public static ItemHolderInfo m2049d(ViewHolder viewHolder) {
            return new ItemHolderInfo().m2048a(viewHolder);
        }
    }

    public static abstract class ItemDecoration {
        public void mo483a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void mo614b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void mo484a(Rect rect, View view, RecyclerView recyclerView, State state) {
            ((LayoutParams) view.getLayoutParams()).f2382c.m2224c();
            rect.set(0, 0, 0, 0);
        }
    }

    public static abstract class LayoutManager {
        boolean f2364A;
        int f2365B;
        int f2366C;
        int f2367D;
        public int f2368E;
        private final Callback f2369a = new C10341(this);
        private final Callback f2370b = new C10352(this);
        ChildHelper f2371p;
        RecyclerView f2372q;
        ViewBoundsCheck f2373r = new ViewBoundsCheck(this.f2369a);
        ViewBoundsCheck f2374s = new ViewBoundsCheck(this.f2370b);
        SmoothScroller f2375t;
        boolean f2376u = false;
        boolean f2377v = false;
        boolean f2378w = false;
        boolean f2379x = true;
        boolean f2380y = true;
        int f2381z;

        public interface LayoutPrefetchRegistry {
            void mo620a(int i, int i2);
        }

        public static class Properties {
            public int f2360a;
            public int f2361b;
            public boolean f2362c;
            public boolean f2363d;
        }

        class C10341 implements Callback {
            final /* synthetic */ LayoutManager f12039a;

            C10341(LayoutManager layoutManager) {
                this.f12039a = layoutManager;
            }

            public final View mo701a(int i) {
                return this.f12039a.m2134e(i);
            }

            public final int mo699a() {
                return this.f12039a.m2154t();
            }

            public final int mo702b() {
                return this.f12039a.f2367D - this.f12039a.m2156v();
            }

            public final int mo700a(View view) {
                return LayoutManager.m2080e(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int mo703b(View view) {
                return LayoutManager.m2082g(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        class C10352 implements Callback {
            final /* synthetic */ LayoutManager f12040a;

            C10352(LayoutManager layoutManager) {
                this.f12040a = layoutManager;
            }

            public final View mo701a(int i) {
                return this.f12040a.m2134e(i);
            }

            public final int mo699a() {
                return this.f12040a.m2155u();
            }

            public final int mo702b() {
                return this.f12040a.f2368E - this.f12040a.m2157w();
            }

            public final int mo700a(View view) {
                return LayoutManager.m2081f(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int mo703b(View view) {
                return LayoutManager.m2083h(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        public int mo622a(int i, Recycler recycler, State state) {
            return 0;
        }

        public View mo624a(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public void mo721a() {
        }

        public void mo722a(int i, int i2) {
        }

        public void mo625a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void mo626a(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void mo627a(Parcelable parcelable) {
        }

        public void mo628a(State state) {
        }

        public void mo630a(RecyclerView recyclerView, Recycler recycler) {
        }

        public boolean mo725a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int mo633b(int i, Recycler recycler, State state) {
            return 0;
        }

        public int mo634b(State state) {
            return 0;
        }

        public abstract LayoutParams mo636b();

        public void mo727b(int i, int i2) {
        }

        public int mo637c(State state) {
            return 0;
        }

        public void mo638c(int i) {
        }

        public void mo728c(int i, int i2) {
        }

        public boolean mo640c() {
            return false;
        }

        public int mo642d(State state) {
            return 0;
        }

        public Parcelable mo643d() {
            return null;
        }

        public void mo729d(int i, int i2) {
        }

        public int mo644e(State state) {
            return 0;
        }

        public boolean mo645e() {
            return false;
        }

        public int mo646f(State state) {
            return 0;
        }

        public boolean mo647f() {
            return false;
        }

        public int mo648g(State state) {
            return 0;
        }

        public void mo732h(int i) {
        }

        boolean mo649j() {
            return false;
        }

        final void m2101a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2372q = null;
                this.f2371p = null;
                this.f2367D = 0;
                this.f2368E = 0;
            } else {
                this.f2372q = recyclerView;
                this.f2371p = recyclerView.mChildHelper;
                this.f2367D = recyclerView.getWidth();
                this.f2368E = recyclerView.getHeight();
            }
            this.f2365B = 1073741824;
            this.f2366C = 1073741824;
        }

        final void m2138f(int i, int i2) {
            this.f2367D = MeasureSpec.getSize(i);
            this.f2365B = MeasureSpec.getMode(i);
            if (this.f2365B == 0 && RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == 0) {
                this.f2367D = 0;
            }
            this.f2368E = MeasureSpec.getSize(i2);
            this.f2366C = MeasureSpec.getMode(i2);
            if (this.f2366C == 0 && RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == 0) {
                this.f2368E = 0;
            }
        }

        final void m2142g(int i, int i2) {
            int q = m2151q();
            if (q == 0) {
                this.f2372q.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = RedditJobManager.f10810d;
            int i4 = Integer.MIN_VALUE;
            int i5 = i4;
            int i6 = RedditJobManager.f10810d;
            for (int i7 = 0; i7 < q; i7++) {
                View e = m2134e(i7);
                Rect rect = this.f2372q.mTempRect;
                RecyclerView.getDecoratedBoundsWithMarginsInt(e, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.f2372q.mTempRect.set(i3, i6, i4, i5);
            mo723a(this.f2372q.mTempRect, i, i2);
        }

        public void mo723a(Rect rect, int i, int i2) {
            m2145i(m2068a(i, (rect.width() + m2154t()) + m2156v(), ViewCompat.m1252m(this.f2372q)), m2068a(i2, (rect.height() + m2155u()) + m2157w(), ViewCompat.m1253n(this.f2372q)));
        }

        public final void m2148n() {
            if (this.f2372q != null) {
                this.f2372q.requestLayout();
            }
        }

        public static int m2068a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : i;
            } else {
                return Math.min(i, Math.max(i2, i3));
            }
        }

        public void mo632a(String str) {
            if (this.f2372q != null) {
                this.f2372q.assertNotInLayoutOrScroll(str);
            }
        }

        final void m2122b(RecyclerView recyclerView, Recycler recycler) {
            this.f2377v = false;
            mo630a(recyclerView, recycler);
        }

        public final boolean m2113a(Runnable runnable) {
            return this.f2372q != null ? this.f2372q.removeCallbacks(runnable) : null;
        }

        public final boolean m2149o() {
            return this.f2372q != null && this.f2372q.mClipToPadding;
        }

        public void mo639c(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams mo720a(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams mo719a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void mo629a(RecyclerView recyclerView, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final void m2099a(SmoothScroller smoothScroller) {
            if (!(this.f2375t == null || smoothScroller == this.f2375t || !this.f2375t.f2413k)) {
                this.f2375t.m2199c();
            }
            this.f2375t = smoothScroller;
            smoothScroller = this.f2375t;
            smoothScroller.f2410h = this.f2372q;
            smoothScroller.f2411i = this;
            if (smoothScroller.f2409g == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            smoothScroller.f2410h.mState.mTargetPosition = smoothScroller.f2409g;
            smoothScroller.f2413k = true;
            smoothScroller.f2412j = true;
            smoothScroller.f2414l = smoothScroller.f2410h.mLayout.mo623a(smoothScroller.f2409g);
            smoothScroller.f2410h.mViewFlinger.m2204a();
        }

        public final boolean m2150p() {
            return this.f2375t != null && this.f2375t.f2413k;
        }

        final void m2104a(View view, int i, boolean z) {
            LayoutParams layoutParams;
            int c;
            View e;
            ViewHolder childViewHolderInt;
            ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
            if (!z) {
                if (!childViewHolderInt2.m2237o()) {
                    this.f2372q.mViewInfoStore.m2386c(childViewHolderInt2);
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if (!childViewHolderInt2.m2231i()) {
                        if (childViewHolderInt2.m2229g()) {
                            if (view.getParent() != this.f2372q) {
                                c = this.f2371p.m1909c(view);
                                if (i == -1) {
                                    i = this.f2371p.m1901a();
                                }
                                if (c == -1) {
                                    z = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                                    z.append(this.f2372q.indexOfChild(view));
                                    z.append(this.f2372q.exceptionLabel());
                                    throw new IllegalStateException(z.toString());
                                } else if (c != i) {
                                    view = this.f2372q.mLayout;
                                    e = view.m2134e(c);
                                    if (e != null) {
                                        z = new StringBuilder("Cannot move a child from non-existing index:");
                                        z.append(c);
                                        z.append(view.f2372q.toString());
                                        throw new IllegalArgumentException(z.toString());
                                    }
                                    view.mo641d(c);
                                    LayoutParams layoutParams2 = (LayoutParams) e.getLayoutParams();
                                    childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                                    if (childViewHolderInt.m2237o()) {
                                        view.f2372q.mViewInfoStore.m2386c(childViewHolderInt);
                                    } else {
                                        view.f2372q.mViewInfoStore.m2384b(childViewHolderInt);
                                    }
                                    view.f2371p.m1904a(e, i, layoutParams2, childViewHolderInt.m2237o());
                                }
                            } else {
                                this.f2371p.m1905a(view, i, false);
                                layoutParams.f2384e = true;
                                if (!(this.f2375t == 0 || this.f2375t.f2413k == 0)) {
                                    i = this.f2375t;
                                    if (i.m2195a(view) == i.f2409g) {
                                        i.f2414l = view;
                                    }
                                }
                            }
                            if (layoutParams.f2385f == null) {
                                childViewHolderInt2.f2424c.invalidate();
                                layoutParams.f2385f = false;
                            }
                        }
                    }
                    if (childViewHolderInt2.m2229g()) {
                        childViewHolderInt2.m2232j();
                    } else {
                        childViewHolderInt2.m2230h();
                    }
                    this.f2371p.m1904a(view, i, view.getLayoutParams(), false);
                    if (layoutParams.f2385f == null) {
                        childViewHolderInt2.f2424c.invalidate();
                        layoutParams.f2385f = false;
                    }
                }
            }
            this.f2372q.mViewInfoStore.m2384b(childViewHolderInt2);
            layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt2.m2231i()) {
                if (childViewHolderInt2.m2229g()) {
                    if (view.getParent() != this.f2372q) {
                        this.f2371p.m1905a(view, i, false);
                        layoutParams.f2384e = true;
                        i = this.f2375t;
                        if (i.m2195a(view) == i.f2409g) {
                            i.f2414l = view;
                        }
                    } else {
                        c = this.f2371p.m1909c(view);
                        if (i == -1) {
                            i = this.f2371p.m1901a();
                        }
                        if (c == -1) {
                            z = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                            z.append(this.f2372q.indexOfChild(view));
                            z.append(this.f2372q.exceptionLabel());
                            throw new IllegalStateException(z.toString());
                        } else if (c != i) {
                            view = this.f2372q.mLayout;
                            e = view.m2134e(c);
                            if (e != null) {
                                view.mo641d(c);
                                LayoutParams layoutParams22 = (LayoutParams) e.getLayoutParams();
                                childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                                if (childViewHolderInt.m2237o()) {
                                    view.f2372q.mViewInfoStore.m2386c(childViewHolderInt);
                                } else {
                                    view.f2372q.mViewInfoStore.m2384b(childViewHolderInt);
                                }
                                view.f2371p.m1904a(e, i, layoutParams22, childViewHolderInt.m2237o());
                            } else {
                                z = new StringBuilder("Cannot move a child from non-existing index:");
                                z.append(c);
                                z.append(view.f2372q.toString());
                                throw new IllegalArgumentException(z.toString());
                            }
                        }
                    }
                    if (layoutParams.f2385f == null) {
                        childViewHolderInt2.f2424c.invalidate();
                        layoutParams.f2385f = false;
                    }
                }
            }
            if (childViewHolderInt2.m2229g()) {
                childViewHolderInt2.m2232j();
            } else {
                childViewHolderInt2.m2230h();
            }
            this.f2371p.m1904a(view, i, view.getLayoutParams(), false);
            if (layoutParams.f2385f == null) {
                childViewHolderInt2.f2424c.invalidate();
                layoutParams.f2385f = false;
            }
        }

        private void mo635b(int i) {
            if (m2134e(i) != null) {
                ChildHelper childHelper = this.f2371p;
                i = childHelper.m1902a(i);
                View b = childHelper.f2209a.mo685b(i);
                if (b != null) {
                    if (childHelper.f2210b.m1888d(i)) {
                        childHelper.m1908b(b);
                    }
                    childHelper.f2209a.mo681a(i);
                }
            }
        }

        public static int m2070a(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2382c.m2224c();
        }

        public final View m2118b(View view) {
            if (this.f2372q == null) {
                return null;
            }
            view = this.f2372q.findContainingItemView(view);
            if (view == null || this.f2371p.m1912d(view)) {
                return null;
            }
            return view;
        }

        public View mo623a(int i) {
            int q = m2151q();
            for (int i2 = 0; i2 < q; i2++) {
                View e = m2134e(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                if (childViewHolderInt != null && childViewHolderInt.m2224c() == i && !childViewHolderInt.m2222b() && (this.f2372q.mState.isPreLayout() || !childViewHolderInt.m2237o())) {
                    return e;
                }
            }
            return 0;
        }

        private void mo641d(int i) {
            m2134e(i);
            this.f2371p.m1911d(i);
        }

        public final void m2094a(int i, Recycler recycler) {
            View e = m2134e(i);
            mo635b(i);
            recycler.m2182a(e);
        }

        public final int m2151q() {
            return this.f2371p != null ? this.f2371p.m1901a() : 0;
        }

        public final View m2134e(int i) {
            return this.f2371p != null ? this.f2371p.m1907b(i) : 0;
        }

        public final int m2152r() {
            return this.f2367D;
        }

        public final int m2153s() {
            return this.f2368E;
        }

        public final int m2154t() {
            return this.f2372q != null ? this.f2372q.getPaddingLeft() : 0;
        }

        public final int m2155u() {
            return this.f2372q != null ? this.f2372q.getPaddingTop() : 0;
        }

        public final int m2156v() {
            return this.f2372q != null ? this.f2372q.getPaddingRight() : 0;
        }

        public final int m2157w() {
            return this.f2372q != null ? this.f2372q.getPaddingBottom() : 0;
        }

        public final View m2158x() {
            if (this.f2372q == null) {
                return null;
            }
            View focusedChild = this.f2372q.getFocusedChild();
            if (focusedChild != null) {
                if (!this.f2371p.m1912d(focusedChild)) {
                    return focusedChild;
                }
            }
            return null;
        }

        public final int m2159y() {
            Adapter adapter = this.f2372q != null ? this.f2372q.getAdapter() : null;
            return adapter != null ? adapter.mo39a() : 0;
        }

        public void mo730f(int i) {
            if (this.f2372q != null) {
                this.f2372q.offsetChildrenHorizontal(i);
            }
        }

        public void mo731g(int i) {
            if (this.f2372q != null) {
                this.f2372q.offsetChildrenVertical(i);
            }
        }

        public final void m2097a(Recycler recycler) {
            for (int q = m2151q() - 1; q >= 0; q--) {
                View e = m2134e(q);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
                if (!childViewHolderInt.m2222b()) {
                    if (!childViewHolderInt.m2234l() || childViewHolderInt.m2237o() || this.f2372q.mAdapter.f2349e) {
                        mo641d(q);
                        recycler.m2189c(e);
                        this.f2372q.mViewInfoStore.m2386c(childViewHolderInt);
                    } else {
                        mo635b(q);
                        recycler.m2180a(childViewHolderInt);
                    }
                }
            }
        }

        final boolean m2112a(View view, int i, int i2, LayoutParams layoutParams) {
            if (!(view.isLayoutRequested() || !this.f2379x || m2076b(view.getWidth(), i, layoutParams.width) == 0)) {
                if (m2076b(view.getHeight(), i2, layoutParams.height) != null) {
                    return null;
                }
            }
            return true;
        }

        static boolean m2076b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return i2 >= i;
            } else {
                if (mode != 0) {
                    return mode == 1073741824 && i2 == i;
                } else {
                    return true;
                }
            }
        }

        public static int m2069a(int i, int i2, int i3, int i4, boolean z) {
            i -= i3;
            i3 = 0;
            i = Math.max(0, i);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                                if (i2 != 1073741824) {
                                }
                            }
                        }
                        i4 = i;
                        i3 = i2;
                        return MeasureSpec.makeMeasureSpec(i4, i3);
                    }
                    i4 = 0;
                    return MeasureSpec.makeMeasureSpec(i4, i3);
                }
            } else if (i4 < 0) {
                if (i4 != -1) {
                    if (i4 == -2) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 1073741824) {
                                i4 = i;
                                return MeasureSpec.makeMeasureSpec(i4, i3);
                            }
                        }
                        i4 = i;
                        i3 = Integer.MIN_VALUE;
                        return MeasureSpec.makeMeasureSpec(i4, i3);
                    }
                    i4 = 0;
                    return MeasureSpec.makeMeasureSpec(i4, i3);
                }
                i4 = i;
                i3 = i2;
                return MeasureSpec.makeMeasureSpec(i4, i3);
            }
            i3 = 1073741824;
            return MeasureSpec.makeMeasureSpec(i4, i3);
        }

        public static int m2077c(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2383d;
            return (view.getMeasuredWidth() + rect.left) + rect.right;
        }

        public static int m2078d(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2383d;
            return (view.getMeasuredHeight() + rect.top) + rect.bottom;
        }

        public static void m2073a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f2383d;
            view.layout((i + rect.left) + layoutParams.leftMargin, (i2 + rect.top) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public final void m2105a(View view, Rect rect) {
            Rect rect2 = ((LayoutParams) view.getLayoutParams()).f2383d;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.f2372q != null) {
                Matrix matrix = view.getMatrix();
                if (!(matrix == null || matrix.isIdentity())) {
                    RectF rectF = this.f2372q.mTempRectF;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public static void m2075b(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public static int m2080e(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).f2383d.left;
        }

        public static int m2081f(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).f2383d.top;
        }

        public static int m2082g(View view) {
            return view.getRight() + ((LayoutParams) view.getLayoutParams()).f2383d.right;
        }

        public static int m2083h(View view) {
            return view.getBottom() + ((LayoutParams) view.getLayoutParams()).f2383d.bottom;
        }

        public final void m2128c(View view, Rect rect) {
            if (this.f2372q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f2372q.getItemDecorInsetsForChild(view));
            }
        }

        public final boolean m2146i(View view) {
            view = (!this.f2373r.m2370a(view) || this.f2374s.m2370a(view) == null) ? null : 1;
            return view == null;
        }

        public final void m2144h(int i, int i2) {
            this.f2372q.defaultOnMeasure(i, i2);
        }

        public final void m2145i(int i, int i2) {
            this.f2372q.setMeasuredDimension(i, i2);
        }

        final void m2160z() {
            if (this.f2375t != null) {
                this.f2375t.m2199c();
            }
        }

        public final void m2126c(Recycler recycler) {
            for (int q = m2151q() - 1; q >= 0; q--) {
                if (!RecyclerView.getChildViewHolderInt(m2134e(q)).m2222b()) {
                    m2094a(q, recycler);
                }
            }
        }

        public void mo631a(AccessibilityEvent accessibilityEvent) {
            Recycler recycler = this.f2372q.mRecycler;
            State state = this.f2372q.mState;
            if (this.f2372q != null) {
                if (accessibilityEvent != null) {
                    boolean z = true;
                    if (!(this.f2372q.canScrollVertically(1) || this.f2372q.canScrollVertically(-1) || this.f2372q.canScrollHorizontally(-1))) {
                        if (!this.f2372q.canScrollHorizontally(1)) {
                            z = false;
                        }
                    }
                    accessibilityEvent.setScrollable(z);
                    if (this.f2372q.mAdapter != null) {
                        accessibilityEvent.setItemCount(this.f2372q.mAdapter.mo39a());
                    }
                }
            }
        }

        final void m2106a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.m2237o() && !this.f2371p.m1912d(childViewHolderInt.f2424c)) {
                mo724a(this.f2372q.mRecycler, this.f2372q.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void mo724a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            state = null;
            int a = mo647f() != null ? m2070a(view) : 0;
            if (mo645e() != null) {
                state = m2070a(view);
            }
            accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(a, 1, state, 1, false, false));
        }

        public int mo718a(Recycler recycler, State state) {
            if (this.f2372q != null) {
                if (this.f2372q.mAdapter != null) {
                    if (mo647f() != null) {
                        return this.f2372q.mAdapter.mo39a();
                    }
                    return 1;
                }
            }
            return 1;
        }

        public int mo726b(Recycler recycler, State state) {
            if (this.f2372q != null) {
                if (this.f2372q.mAdapter != null) {
                    if (mo645e() != null) {
                        return this.f2372q.mAdapter.mo39a();
                    }
                    return 1;
                }
            }
            return 1;
        }

        public static Properties m2071a(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            context = context.obtainStyledAttributes(attributeSet, C0182R.styleable.RecyclerView, i, i2);
            properties.f2360a = context.getInt(C0182R.styleable.RecyclerView_android_orientation, 1);
            properties.f2361b = context.getInt(C0182R.styleable.RecyclerView_spanCount, 1);
            properties.f2362c = context.getBoolean(C0182R.styleable.RecyclerView_reverseLayout, false);
            properties.f2363d = context.getBoolean(C0182R.styleable.RecyclerView_stackFromEnd, false);
            context.recycle();
            return properties;
        }

        final void m2121b(RecyclerView recyclerView) {
            m2138f(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void m2107a(View view, Recycler recycler) {
            ChildHelper childHelper = this.f2371p;
            int a = childHelper.f2209a.mo680a(view);
            if (a >= 0) {
                if (childHelper.f2210b.m1888d(a)) {
                    childHelper.m1908b(view);
                }
                childHelper.f2209a.mo681a(a);
            }
            recycler.m2182a(view);
        }

        final void m2120b(Recycler recycler) {
            int size = recycler.f2392a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((ViewHolder) recycler.f2392a.get(i)).f2424c;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.m2222b()) {
                    childViewHolderInt.m2221a(false);
                    if (childViewHolderInt.m2238p()) {
                        this.f2372q.removeDetachedView(view, false);
                    }
                    if (this.f2372q.mItemAnimator != null) {
                        this.f2372q.mItemAnimator.mo3237c(childViewHolderInt);
                    }
                    childViewHolderInt.m2221a(true);
                    recycler.m2186b(view);
                }
            }
            recycler.f2392a.clear();
            if (recycler.f2393b != null) {
                recycler.f2393b.clear();
            }
            if (size > 0) {
                this.f2372q.invalidate();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean m2111a(android.support.v7.widget.RecyclerView r10, android.view.View r11, android.graphics.Rect r12, boolean r13, boolean r14) {
            /*
            r9 = this;
            r0 = 2;
            r0 = new int[r0];
            r1 = r9.m2154t();
            r2 = r9.m2155u();
            r3 = r9.f2367D;
            r4 = r9.m2156v();
            r3 = r3 - r4;
            r4 = r9.f2368E;
            r5 = r9.m2157w();
            r4 = r4 - r5;
            r5 = r11.getLeft();
            r6 = r12.left;
            r5 = r5 + r6;
            r6 = r11.getScrollX();
            r5 = r5 - r6;
            r6 = r11.getTop();
            r7 = r12.top;
            r6 = r6 + r7;
            r11 = r11.getScrollY();
            r6 = r6 - r11;
            r11 = r12.width();
            r11 = r11 + r5;
            r12 = r12.height();
            r12 = r12 + r6;
            r5 = r5 - r1;
            r1 = 0;
            r7 = java.lang.Math.min(r1, r5);
            r6 = r6 - r2;
            r2 = java.lang.Math.min(r1, r6);
            r11 = r11 - r3;
            r3 = java.lang.Math.max(r1, r11);
            r12 = r12 - r4;
            r12 = java.lang.Math.max(r1, r12);
            r4 = r9.f2372q;
            r4 = android.support.v4.view.ViewCompat.m1242f(r4);
            r8 = 1;
            if (r4 != r8) goto L_0x0061;
        L_0x0059:
            if (r3 == 0) goto L_0x005c;
        L_0x005b:
            goto L_0x006a;
        L_0x005c:
            r3 = java.lang.Math.max(r7, r11);
            goto L_0x006a;
        L_0x0061:
            if (r7 == 0) goto L_0x0065;
        L_0x0063:
            r3 = r7;
            goto L_0x006a;
        L_0x0065:
            r7 = java.lang.Math.min(r5, r3);
            goto L_0x0063;
        L_0x006a:
            if (r2 == 0) goto L_0x006d;
        L_0x006c:
            goto L_0x0071;
        L_0x006d:
            r2 = java.lang.Math.min(r6, r12);
        L_0x0071:
            r0[r1] = r3;
            r0[r8] = r2;
            r11 = r0[r1];
            r12 = r0[r8];
            if (r14 == 0) goto L_0x00b8;
        L_0x007b:
            r14 = r10.getFocusedChild();
            if (r14 != 0) goto L_0x0083;
        L_0x0081:
            r14 = r1;
            goto L_0x00b6;
        L_0x0083:
            r0 = r9.m2154t();
            r2 = r9.m2155u();
            r3 = r9.f2367D;
            r4 = r9.m2156v();
            r3 = r3 - r4;
            r4 = r9.f2368E;
            r5 = r9.m2157w();
            r4 = r4 - r5;
            r5 = r9.f2372q;
            r5 = r5.mTempRect;
            android.support.v7.widget.RecyclerView.getDecoratedBoundsWithMarginsInt(r14, r5);
            r14 = r5.left;
            r14 = r14 - r11;
            if (r14 >= r3) goto L_0x0081;
        L_0x00a5:
            r14 = r5.right;
            r14 = r14 - r11;
            if (r14 <= r0) goto L_0x0081;
        L_0x00aa:
            r14 = r5.top;
            r14 = r14 - r12;
            if (r14 >= r4) goto L_0x0081;
        L_0x00af:
            r14 = r5.bottom;
            r14 = r14 - r12;
            if (r14 > r2) goto L_0x00b5;
        L_0x00b4:
            goto L_0x0081;
        L_0x00b5:
            r14 = r8;
        L_0x00b6:
            if (r14 == 0) goto L_0x00bd;
        L_0x00b8:
            if (r11 != 0) goto L_0x00be;
        L_0x00ba:
            if (r12 == 0) goto L_0x00bd;
        L_0x00bc:
            goto L_0x00be;
        L_0x00bd:
            return r1;
        L_0x00be:
            if (r13 == 0) goto L_0x00c4;
        L_0x00c0:
            r10.scrollBy(r11, r12);
            goto L_0x00c7;
        L_0x00c4:
            r10.smoothScrollBy(r11, r12);
        L_0x00c7:
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.a(android.support.v7.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        static /* synthetic */ void m2072a(LayoutManager layoutManager, SmoothScroller smoothScroller) {
            if (layoutManager.f2375t == smoothScroller) {
                layoutManager.f2375t = null;
            }
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        ViewHolder f2382c;
        final Rect f2383d = new Rect();
        boolean f2384e = true;
        boolean f2385f = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void m2161a(View view);

        void m2162b(View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean mo717a(int i, int i2);
    }

    public interface OnItemTouchListener {
        void mo617a(MotionEvent motionEvent);

        boolean mo618a(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void mo716a(RecyclerView recyclerView, int i) {
        }

        public void mo616a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class RecycledViewPool {
        SparseArray<ScrapData> f2390a = new SparseArray();
        int f2391b = 0;

        static class ScrapData {
            ArrayList<ViewHolder> f2386a = new ArrayList();
            int f2387b = 5;
            long f2388c = 0;
            long f2389d = 0;

            ScrapData() {
            }
        }

        public final void m2170a() {
            ScrapData a = m2169a(Integer.MIN_VALUE);
            a.f2387b = 0;
            ArrayList arrayList = a.f2386a;
            if (arrayList != null) {
                while (arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        static long m2168a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        final void m2171b() {
            this.f2391b++;
        }

        final void m2172c() {
            this.f2391b--;
        }

        final ScrapData m2169a(int i) {
            ScrapData scrapData = (ScrapData) this.f2390a.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            scrapData = new ScrapData();
            this.f2390a.put(i, scrapData);
            return scrapData;
        }
    }

    public final class Recycler {
        final ArrayList<ViewHolder> f2392a = new ArrayList();
        ArrayList<ViewHolder> f2393b = null;
        final ArrayList<ViewHolder> f2394c = new ArrayList();
        final List<ViewHolder> f2395d = Collections.unmodifiableList(this.f2392a);
        int f2396e = 2;
        int f2397f = 2;
        RecycledViewPool f2398g;
        ViewCacheExtension f2399h;
        final /* synthetic */ RecyclerView f2400i;

        public Recycler(RecyclerView recyclerView) {
            this.f2400i = recyclerView;
        }

        public final void m2179a() {
            this.f2392a.clear();
            m2187c();
        }

        final void m2184b() {
            this.f2397f = this.f2396e + (this.f2400i.mLayout != null ? this.f2400i.mLayout.f2381z : 0);
            for (int size = this.f2394c.size() - 1; size >= 0 && this.f2394c.size() > this.f2397f; size--) {
                m2188c(size);
            }
        }

        public final int m2177a(int i) {
            if (i >= 0) {
                if (i < this.f2400i.mState.getItemCount()) {
                    if (this.f2400i.mState.isPreLayout()) {
                        return this.f2400i.mAdapterHelper.m10568b(i);
                    }
                    return i;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("invalid position ");
            stringBuilder.append(i);
            stringBuilder.append(". State item count is ");
            stringBuilder.append(this.f2400i.mState.getItemCount());
            stringBuilder.append(this.f2400i.exceptionLabel());
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        final ViewHolder m2178a(int i, long j) {
            StringBuilder stringBuilder;
            Recycler recycler = this;
            int i2 = i;
            if (i2 >= 0) {
                if (i2 < recycler.f2400i.mState.getItemCount()) {
                    ViewHolder d;
                    boolean z;
                    boolean z2;
                    StringBuilder stringBuilder2;
                    int b;
                    int b2;
                    View a;
                    ScrapData scrapData;
                    long nanoTime;
                    long j2;
                    boolean z3;
                    RecyclerView findNestedRecyclerView;
                    ScrapData a2;
                    ItemAnimator itemAnimator;
                    State state;
                    int b3;
                    int i3;
                    long nanoTime2;
                    long j3;
                    boolean z4;
                    Adapter adapter;
                    android.view.ViewGroup.LayoutParams layoutParams;
                    long nanoTime3;
                    View view;
                    boolean z5;
                    LayoutParams layoutParams2;
                    boolean z6 = true;
                    if (recycler.f2400i.mState.isPreLayout()) {
                        d = m2175d(i);
                        if (d != null) {
                            z = true;
                            if (d == null) {
                                d = m2176e(i);
                                if (d != null) {
                                    if (d.m2237o()) {
                                        if (d.f2426e >= 0) {
                                            if (d.f2426e >= recycler.f2400i.mAdapter.mo39a()) {
                                                if (recycler.f2400i.mState.isPreLayout() || recycler.f2400i.mAdapter.mo44b(d.f2426e) == d.f2429h) {
                                                    if (recycler.f2400i.mAdapter.f2349e || d.f2428g == recycler.f2400i.mAdapter.mo40a(d.f2426e)) {
                                                        z2 = true;
                                                    }
                                                }
                                                z2 = false;
                                            }
                                        }
                                        stringBuilder2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                                        stringBuilder2.append(d);
                                        stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                        throw new IndexOutOfBoundsException(stringBuilder2.toString());
                                    }
                                    z2 = recycler.f2400i.mState.isPreLayout();
                                    if (z2) {
                                        d.m2225c(4);
                                        if (d.m2229g()) {
                                            recycler.f2400i.removeDetachedView(d.f2424c, false);
                                            d.m2230h();
                                        } else if (d.m2231i()) {
                                            d.m2232j();
                                        }
                                        m2180a(d);
                                        d = null;
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                            if (d == null) {
                                b = recycler.f2400i.mAdapterHelper.m10568b(i2);
                                if (b >= 0) {
                                    if (b >= recycler.f2400i.mAdapter.mo39a()) {
                                        b2 = recycler.f2400i.mAdapter.mo44b(b);
                                        if (recycler.f2400i.mAdapter.f2349e) {
                                            d = m2173a(recycler.f2400i.mAdapter.mo40a(b), b2);
                                            if (d != null) {
                                                d.f2426e = b;
                                                z = true;
                                            }
                                        }
                                        if (d == null && recycler.f2399h != null) {
                                            a = recycler.f2399h.m2201a();
                                            if (a != null) {
                                                d = recycler.f2400i.getChildViewHolder(a);
                                                if (d == null) {
                                                    stringBuilder2 = new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                                    stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                                    throw new IllegalArgumentException(stringBuilder2.toString());
                                                } else if (d.m2222b()) {
                                                    stringBuilder2 = new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                                    stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                                    throw new IllegalArgumentException(stringBuilder2.toString());
                                                }
                                            }
                                        }
                                        if (d == null) {
                                            scrapData = (ScrapData) m2190d().f2390a.get(b2);
                                            if (scrapData != null || scrapData.f2386a.isEmpty()) {
                                                d = null;
                                            } else {
                                                ArrayList arrayList = scrapData.f2386a;
                                                d = (ViewHolder) arrayList.remove(arrayList.size() - 1);
                                            }
                                            if (d != null) {
                                                d.m2241s();
                                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST && (d.f2424c instanceof ViewGroup)) {
                                                    m2174a((ViewGroup) d.f2424c, false);
                                                }
                                            }
                                        }
                                        if (d == null) {
                                            nanoTime = recycler.f2400i.getNanoTime();
                                            if (j != RecyclerView.FOREVER_NS) {
                                                j2 = recycler.f2398g.m2169a(b2).f2388c;
                                                if (j2 != 0) {
                                                    if (j2 + nanoTime < j) {
                                                        z3 = false;
                                                        if (!z3) {
                                                            return null;
                                                        }
                                                    }
                                                }
                                                z3 = true;
                                                if (z3) {
                                                    return null;
                                                }
                                            }
                                            d = recycler.f2400i.mAdapter.m2021b(recycler.f2400i, b2);
                                            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                                                findNestedRecyclerView = RecyclerView.findNestedRecyclerView(d.f2424c);
                                                if (findNestedRecyclerView != null) {
                                                    d.f2425d = new WeakReference(findNestedRecyclerView);
                                                }
                                            }
                                            j2 = recycler.f2400i.getNanoTime() - nanoTime;
                                            a2 = recycler.f2398g.m2169a(b2);
                                            a2.f2388c = RecycledViewPool.m2168a(a2.f2388c, j2);
                                        }
                                    }
                                }
                                stringBuilder = new StringBuilder("Inconsistency detected. Invalid item position ");
                                stringBuilder.append(i2);
                                stringBuilder.append("(offset:");
                                stringBuilder.append(b);
                                stringBuilder.append(").state:");
                                stringBuilder.append(recycler.f2400i.mState.getItemCount());
                                stringBuilder.append(recycler.f2400i.exceptionLabel());
                                throw new IndexOutOfBoundsException(stringBuilder.toString());
                            }
                            if (z && !recycler.f2400i.mState.isPreLayout() && d.m2223b(8192)) {
                                d.m2217a(0, 8192);
                                if (recycler.f2400i.mState.mRunSimpleAnimations) {
                                    ItemAnimator.m2050e(d);
                                    itemAnimator = recycler.f2400i.mItemAnimator;
                                    state = recycler.f2400i.mState;
                                    d.m2240r();
                                    recycler.f2400i.recordAnimationInfoIfBouncedHiddenView(d, ItemAnimator.m2049d(d));
                                }
                            }
                            if (recycler.f2400i.mState.isPreLayout() || !d.m2236n()) {
                                if (d.m2236n() && !d.m2235m()) {
                                    if (d.m2234l()) {
                                    }
                                }
                                b3 = recycler.f2400i.mAdapterHelper.m10568b(i2);
                                d.f2436o = recycler.f2400i;
                                i3 = d.f2429h;
                                nanoTime2 = recycler.f2400i.getNanoTime();
                                if (j != RecyclerView.FOREVER_NS) {
                                    j3 = recycler.f2398g.m2169a(i3).f2389d;
                                    if (j3 != 0) {
                                        if (j3 + nanoTime2 < j) {
                                            z4 = false;
                                            if (!z4) {
                                            }
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                    }
                                }
                                adapter = recycler.f2400i.mAdapter;
                                d.f2426e = b3;
                                if (adapter.f2349e) {
                                    d.f2428g = adapter.mo40a(b3);
                                }
                                d.m2217a(1, 519);
                                TraceCompat.m975a(RecyclerView.TRACE_BIND_VIEW_TAG);
                                d.m2240r();
                                adapter.mo43a(d, b3);
                                d.m2239q();
                                layoutParams = d.f2424c.getLayoutParams();
                                if (layoutParams instanceof LayoutParams) {
                                    ((LayoutParams) layoutParams).f2384e = true;
                                }
                                TraceCompat.m974a();
                                nanoTime3 = recycler.f2400i.getNanoTime() - nanoTime2;
                                a2 = recycler.f2398g.m2169a(d.f2429h);
                                a2.f2389d = RecycledViewPool.m2168a(a2.f2389d, nanoTime3);
                                if (recycler.f2400i.isAccessibilityEnabled()) {
                                    view = d.f2424c;
                                    if (ViewCompat.m1237d(view) == 0) {
                                        ViewCompat.m1214a(view, 1);
                                    }
                                    if (!ViewCompat.m1228a(view)) {
                                        d.m2225c(16384);
                                        ViewCompat.m1220a(view, recycler.f2400i.mAccessibilityDelegate.mo3197a());
                                    }
                                }
                                if (recycler.f2400i.mState.isPreLayout()) {
                                    d.f2430i = i2;
                                }
                                z5 = true;
                                layoutParams = d.f2424c.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams2 = (LayoutParams) recycler.f2400i.generateDefaultLayoutParams();
                                    d.f2424c.setLayoutParams(layoutParams2);
                                } else if (recycler.f2400i.checkLayoutParams(layoutParams)) {
                                    layoutParams2 = (LayoutParams) recycler.f2400i.generateLayoutParams(layoutParams);
                                    d.f2424c.setLayoutParams(layoutParams2);
                                } else {
                                    layoutParams2 = (LayoutParams) layoutParams;
                                }
                                layoutParams2.f2382c = d;
                                if (z || !r1) {
                                    z6 = false;
                                }
                                layoutParams2.f2385f = z6;
                                return d;
                            }
                            d.f2430i = i2;
                            z5 = false;
                            layoutParams = d.f2424c.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams2 = (LayoutParams) recycler.f2400i.generateDefaultLayoutParams();
                                d.f2424c.setLayoutParams(layoutParams2);
                            } else if (recycler.f2400i.checkLayoutParams(layoutParams)) {
                                layoutParams2 = (LayoutParams) layoutParams;
                            } else {
                                layoutParams2 = (LayoutParams) recycler.f2400i.generateLayoutParams(layoutParams);
                                d.f2424c.setLayoutParams(layoutParams2);
                            }
                            layoutParams2.f2382c = d;
                            if (z) {
                            }
                            z6 = false;
                            layoutParams2.f2385f = z6;
                            return d;
                        }
                    }
                    d = null;
                    z = false;
                    if (d == null) {
                        d = m2176e(i);
                        if (d != null) {
                            if (d.m2237o()) {
                                if (d.f2426e >= 0) {
                                    if (d.f2426e >= recycler.f2400i.mAdapter.mo39a()) {
                                        if (recycler.f2400i.mAdapter.f2349e) {
                                        }
                                        z2 = true;
                                    }
                                }
                                stringBuilder2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                                stringBuilder2.append(d);
                                stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                throw new IndexOutOfBoundsException(stringBuilder2.toString());
                            }
                            z2 = recycler.f2400i.mState.isPreLayout();
                            if (z2) {
                                z = true;
                            } else {
                                d.m2225c(4);
                                if (d.m2229g()) {
                                    recycler.f2400i.removeDetachedView(d.f2424c, false);
                                    d.m2230h();
                                } else if (d.m2231i()) {
                                    d.m2232j();
                                }
                                m2180a(d);
                                d = null;
                            }
                        }
                    }
                    if (d == null) {
                        b = recycler.f2400i.mAdapterHelper.m10568b(i2);
                        if (b >= 0) {
                            if (b >= recycler.f2400i.mAdapter.mo39a()) {
                                b2 = recycler.f2400i.mAdapter.mo44b(b);
                                if (recycler.f2400i.mAdapter.f2349e) {
                                    d = m2173a(recycler.f2400i.mAdapter.mo40a(b), b2);
                                    if (d != null) {
                                        d.f2426e = b;
                                        z = true;
                                    }
                                }
                                a = recycler.f2399h.m2201a();
                                if (a != null) {
                                    d = recycler.f2400i.getChildViewHolder(a);
                                    if (d == null) {
                                        stringBuilder2 = new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                        stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                        throw new IllegalArgumentException(stringBuilder2.toString());
                                    } else if (d.m2222b()) {
                                        stringBuilder2 = new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                        stringBuilder2.append(recycler.f2400i.exceptionLabel());
                                        throw new IllegalArgumentException(stringBuilder2.toString());
                                    }
                                }
                                if (d == null) {
                                    scrapData = (ScrapData) m2190d().f2390a.get(b2);
                                    if (scrapData != null) {
                                    }
                                    d = null;
                                    if (d != null) {
                                        d.m2241s();
                                        m2174a((ViewGroup) d.f2424c, false);
                                    }
                                }
                                if (d == null) {
                                    nanoTime = recycler.f2400i.getNanoTime();
                                    if (j != RecyclerView.FOREVER_NS) {
                                        j2 = recycler.f2398g.m2169a(b2).f2388c;
                                        if (j2 != 0) {
                                            if (j2 + nanoTime < j) {
                                                z3 = false;
                                                if (z3) {
                                                    return null;
                                                }
                                            }
                                        }
                                        z3 = true;
                                        if (z3) {
                                            return null;
                                        }
                                    }
                                    d = recycler.f2400i.mAdapter.m2021b(recycler.f2400i, b2);
                                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                                        findNestedRecyclerView = RecyclerView.findNestedRecyclerView(d.f2424c);
                                        if (findNestedRecyclerView != null) {
                                            d.f2425d = new WeakReference(findNestedRecyclerView);
                                        }
                                    }
                                    j2 = recycler.f2400i.getNanoTime() - nanoTime;
                                    a2 = recycler.f2398g.m2169a(b2);
                                    a2.f2388c = RecycledViewPool.m2168a(a2.f2388c, j2);
                                }
                            }
                        }
                        stringBuilder = new StringBuilder("Inconsistency detected. Invalid item position ");
                        stringBuilder.append(i2);
                        stringBuilder.append("(offset:");
                        stringBuilder.append(b);
                        stringBuilder.append(").state:");
                        stringBuilder.append(recycler.f2400i.mState.getItemCount());
                        stringBuilder.append(recycler.f2400i.exceptionLabel());
                        throw new IndexOutOfBoundsException(stringBuilder.toString());
                    }
                    d.m2217a(0, 8192);
                    if (recycler.f2400i.mState.mRunSimpleAnimations) {
                        ItemAnimator.m2050e(d);
                        itemAnimator = recycler.f2400i.mItemAnimator;
                        state = recycler.f2400i.mState;
                        d.m2240r();
                        recycler.f2400i.recordAnimationInfoIfBouncedHiddenView(d, ItemAnimator.m2049d(d));
                    }
                    if (recycler.f2400i.mState.isPreLayout()) {
                    }
                    if (d.m2234l()) {
                        b3 = recycler.f2400i.mAdapterHelper.m10568b(i2);
                        d.f2436o = recycler.f2400i;
                        i3 = d.f2429h;
                        nanoTime2 = recycler.f2400i.getNanoTime();
                        if (j != RecyclerView.FOREVER_NS) {
                            j3 = recycler.f2398g.m2169a(i3).f2389d;
                            if (j3 != 0) {
                                if (j3 + nanoTime2 < j) {
                                    z4 = false;
                                    if (z4) {
                                    }
                                }
                            }
                            z4 = true;
                            if (z4) {
                            }
                        }
                        adapter = recycler.f2400i.mAdapter;
                        d.f2426e = b3;
                        if (adapter.f2349e) {
                            d.f2428g = adapter.mo40a(b3);
                        }
                        d.m2217a(1, 519);
                        TraceCompat.m975a(RecyclerView.TRACE_BIND_VIEW_TAG);
                        d.m2240r();
                        adapter.mo43a(d, b3);
                        d.m2239q();
                        layoutParams = d.f2424c.getLayoutParams();
                        if (layoutParams instanceof LayoutParams) {
                            ((LayoutParams) layoutParams).f2384e = true;
                        }
                        TraceCompat.m974a();
                        nanoTime3 = recycler.f2400i.getNanoTime() - nanoTime2;
                        a2 = recycler.f2398g.m2169a(d.f2429h);
                        a2.f2389d = RecycledViewPool.m2168a(a2.f2389d, nanoTime3);
                        if (recycler.f2400i.isAccessibilityEnabled()) {
                            view = d.f2424c;
                            if (ViewCompat.m1237d(view) == 0) {
                                ViewCompat.m1214a(view, 1);
                            }
                            if (ViewCompat.m1228a(view)) {
                                d.m2225c(16384);
                                ViewCompat.m1220a(view, recycler.f2400i.mAccessibilityDelegate.mo3197a());
                            }
                        }
                        if (recycler.f2400i.mState.isPreLayout()) {
                            d.f2430i = i2;
                        }
                        z5 = true;
                        layoutParams = d.f2424c.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams2 = (LayoutParams) recycler.f2400i.generateDefaultLayoutParams();
                            d.f2424c.setLayoutParams(layoutParams2);
                        } else if (recycler.f2400i.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (LayoutParams) recycler.f2400i.generateLayoutParams(layoutParams);
                            d.f2424c.setLayoutParams(layoutParams2);
                        } else {
                            layoutParams2 = (LayoutParams) layoutParams;
                        }
                        layoutParams2.f2382c = d;
                        if (z) {
                        }
                        z6 = false;
                        layoutParams2.f2385f = z6;
                        return d;
                    }
                    z5 = false;
                    layoutParams = d.f2424c.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams2 = (LayoutParams) recycler.f2400i.generateDefaultLayoutParams();
                        d.f2424c.setLayoutParams(layoutParams2);
                    } else if (recycler.f2400i.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) layoutParams;
                    } else {
                        layoutParams2 = (LayoutParams) recycler.f2400i.generateLayoutParams(layoutParams);
                        d.f2424c.setLayoutParams(layoutParams2);
                    }
                    layoutParams2.f2382c = d;
                    if (z) {
                    }
                    z6 = false;
                    layoutParams2.f2385f = z6;
                    return d;
                }
            }
            stringBuilder = new StringBuilder("Invalid item position ");
            stringBuilder.append(i2);
            stringBuilder.append("(");
            stringBuilder.append(i2);
            stringBuilder.append("). Item count:");
            stringBuilder.append(recycler.f2400i.mState.getItemCount());
            stringBuilder.append(recycler.f2400i.exceptionLabel());
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        private void m2174a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m2174a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility()) {
                viewGroup.setVisibility(false);
                viewGroup.setVisibility(4);
                return;
            }
            z = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(z);
        }

        public final void m2182a(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.m2238p()) {
                this.f2400i.removeDetachedView(view, false);
            }
            if (childViewHolderInt.m2229g() != null) {
                childViewHolderInt.m2230h();
            } else if (childViewHolderInt.m2231i() != null) {
                childViewHolderInt.m2232j();
            }
            m2180a(childViewHolderInt);
        }

        final void m2187c() {
            for (int size = this.f2394c.size() - 1; size >= 0; size--) {
                m2188c(size);
            }
            this.f2394c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                this.f2400i.mPrefetchRegistry.m10650a();
            }
        }

        final void m2188c(int i) {
            m2181a((ViewHolder) this.f2394c.get(i), true);
            this.f2394c.remove(i);
        }

        final void m2180a(ViewHolder viewHolder) {
            boolean z = false;
            if (!viewHolder.m2229g()) {
                if (viewHolder.f2424c.getParent() == null) {
                    if (viewHolder.m2238p()) {
                        StringBuilder stringBuilder = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                        stringBuilder.append(viewHolder);
                        stringBuilder.append(this.f2400i.exceptionLabel());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else if (viewHolder.m2222b()) {
                        StringBuilder stringBuilder2 = new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                        stringBuilder2.append(this.f2400i.exceptionLabel());
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    } else {
                        boolean z2;
                        boolean a = ViewHolder.m2209a(viewHolder);
                        if (this.f2400i.mAdapter != null && a) {
                            Adapter adapter = this.f2400i.mAdapter;
                        }
                        if (viewHolder.m2242t()) {
                            if (this.f2397f <= 0 || viewHolder.m2223b(526)) {
                                z2 = false;
                            } else {
                                int size = this.f2394c.size();
                                if (size >= this.f2397f && size > 0) {
                                    m2188c(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !this.f2400i.mPrefetchRegistry.m10653a(viewHolder.f2426e)) {
                                    size--;
                                    while (size >= 0) {
                                        if (!this.f2400i.mPrefetchRegistry.m10653a(((ViewHolder) this.f2394c.get(size)).f2426e)) {
                                            break;
                                        }
                                        size--;
                                    }
                                    size++;
                                }
                                this.f2394c.add(size, viewHolder);
                                z2 = true;
                            }
                            if (!z2) {
                                m2181a(viewHolder, true);
                                z = true;
                            }
                        } else {
                            z2 = false;
                        }
                        this.f2400i.mViewInfoStore.m2387d(viewHolder);
                        if (!z2 && !r1 && a) {
                            viewHolder.f2436o = null;
                            return;
                        }
                        return;
                    }
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            stringBuilder3.append(viewHolder.m2229g());
            stringBuilder3.append(" isAttached:");
            if (viewHolder.f2424c.getParent() != null) {
                z = true;
            }
            stringBuilder3.append(z);
            stringBuilder3.append(this.f2400i.exceptionLabel());
            throw new IllegalArgumentException(stringBuilder3.toString());
        }

        final void m2181a(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            if (viewHolder.m2223b(16384)) {
                viewHolder.m2217a(0, 16384);
                ViewCompat.m1220a(viewHolder.f2424c, null);
            }
            if (z) {
                if (this.f2400i.mRecyclerListener) {
                    z = this.f2400i.mRecyclerListener;
                }
                if (this.f2400i.mAdapter) {
                    this.f2400i.mAdapter.mo42a(viewHolder);
                }
                if (this.f2400i.mState) {
                    this.f2400i.mViewInfoStore.m2387d(viewHolder);
                }
            }
            viewHolder.f2436o = null;
            z = m2190d();
            int i = viewHolder.f2429h;
            ArrayList arrayList = z.m2169a(i).f2386a;
            if (((ScrapData) z.f2390a.get(i)).f2387b > arrayList.size()) {
                viewHolder.m2241s();
                arrayList.add(viewHolder);
            }
        }

        final void m2186b(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.f2438q = null;
            childViewHolderInt.f2439r = false;
            childViewHolderInt.m2232j();
            m2180a(childViewHolderInt);
        }

        final void m2189c(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            if (!view.m2223b(12) && view.m2243u()) {
                if (!this.f2400i.canReuseUpdatedViewHolder(view)) {
                    if (this.f2393b == null) {
                        this.f2393b = new ArrayList();
                    }
                    view.m2219a(this, true);
                    this.f2393b.add(view);
                    return;
                }
            }
            if (!view.m2234l() || view.m2237o() || this.f2400i.mAdapter.f2349e) {
                view.m2219a(this, false);
                this.f2392a.add(view);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            stringBuilder.append(this.f2400i.exceptionLabel());
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        final void m2185b(ViewHolder viewHolder) {
            if (viewHolder.f2439r) {
                this.f2393b.remove(viewHolder);
            } else {
                this.f2392a.remove(viewHolder);
            }
            viewHolder.f2438q = null;
            viewHolder.f2439r = false;
            viewHolder.m2232j();
        }

        private ViewHolder m2175d(int i) {
            if (this.f2393b != null) {
                int size = this.f2393b.size();
                if (size != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < size) {
                        ViewHolder viewHolder = (ViewHolder) this.f2393b.get(i3);
                        if (viewHolder.m2231i() || viewHolder.m2224c() != i) {
                            i3++;
                        } else {
                            viewHolder.m2225c(32);
                            return viewHolder;
                        }
                    }
                    if (this.f2400i.mAdapter.f2349e) {
                        i = this.f2400i.mAdapterHelper.m10563a(i, 0);
                        if (i > 0 && i < this.f2400i.mAdapter.mo39a()) {
                            long a = this.f2400i.mAdapter.mo40a(i);
                            while (i2 < size) {
                                ViewHolder viewHolder2 = (ViewHolder) this.f2393b.get(i2);
                                if (viewHolder2.m2231i() || viewHolder2.f2428g != a) {
                                    i2++;
                                } else {
                                    viewHolder2.m2225c(32);
                                    return viewHolder2;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private ViewHolder m2176e(int i) {
            View view;
            int size = this.f2392a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                ViewHolder viewHolder = (ViewHolder) this.f2392a.get(i3);
                if (viewHolder.m2231i() || viewHolder.m2224c() != i || viewHolder.m2234l() || (!this.f2400i.mState.mInPreLayout && viewHolder.m2237o())) {
                    i3++;
                } else {
                    viewHolder.m2225c(32);
                    return viewHolder;
                }
            }
            ChildHelper childHelper = this.f2400i.mChildHelper;
            i3 = childHelper.f2211c.size();
            for (int i4 = 0; i4 < i3; i4++) {
                view = (View) childHelper.f2211c.get(i4);
                ViewHolder b = childHelper.f2209a.mo684b(view);
                if (b.m2224c() == i && !b.m2234l() && !b.m2237o()) {
                    break;
                }
            }
            view = null;
            if (view != null) {
                i = RecyclerView.getChildViewHolderInt(view);
                childHelper = this.f2400i.mChildHelper;
                i2 = childHelper.f2209a.mo680a(view);
                StringBuilder stringBuilder;
                if (i2 < 0) {
                    stringBuilder = new StringBuilder("view is not a child, cannot hide ");
                    stringBuilder.append(view);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (childHelper.f2210b.m1887c(i2)) {
                    childHelper.f2210b.m1886b(i2);
                    childHelper.m1908b(view);
                    size = this.f2400i.mChildHelper.m1909c(view);
                    if (size == -1) {
                        StringBuilder stringBuilder2 = new StringBuilder("layout index should not be -1 after unhiding a view:");
                        stringBuilder2.append(i);
                        stringBuilder2.append(this.f2400i.exceptionLabel());
                        throw new IllegalStateException(stringBuilder2.toString());
                    }
                    this.f2400i.mChildHelper.m1911d(size);
                    m2189c(view);
                    i.m2225c(8224);
                    return i;
                } else {
                    stringBuilder = new StringBuilder("trying to unhide a view that was not hidden");
                    stringBuilder.append(view);
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
            size = this.f2394c.size();
            while (i2 < size) {
                ViewHolder viewHolder2 = (ViewHolder) this.f2394c.get(i2);
                if (viewHolder2.m2234l() || viewHolder2.m2224c() != i) {
                    i2++;
                } else {
                    this.f2394c.remove(i2);
                    return viewHolder2;
                }
            }
            return null;
        }

        private ViewHolder m2173a(long j, int i) {
            int size;
            for (size = this.f2392a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f2392a.get(size);
                if (viewHolder.f2428g == j && !viewHolder.m2231i()) {
                    if (i == viewHolder.f2429h) {
                        viewHolder.m2225c((int) 32);
                        if (viewHolder.m2237o() != null && this.f2400i.mState.isPreLayout() == null) {
                            viewHolder.m2217a((int) 2, 14);
                        }
                        return viewHolder;
                    }
                    this.f2392a.remove(size);
                    this.f2400i.removeDetachedView(viewHolder.f2424c, false);
                    m2186b(viewHolder.f2424c);
                }
            }
            size = this.f2394c.size() - 1;
            while (size >= 0) {
                ViewHolder viewHolder2 = (ViewHolder) this.f2394c.get(size);
                if (viewHolder2.f2428g != j) {
                    size--;
                } else if (i == viewHolder2.f2429h) {
                    this.f2394c.remove(size);
                    return viewHolder2;
                } else {
                    m2188c(size);
                    return null;
                }
            }
            return null;
        }

        final RecycledViewPool m2190d() {
            if (this.f2398g == null) {
                this.f2398g = new RecycledViewPool();
            }
            return this.f2398g;
        }

        public final View m2183b(int i) {
            return m2178a(i, (long) RecyclerView.FOREVER_NS).f2424c;
        }
    }

    public interface RecyclerListener {
    }

    public static abstract class SmoothScroller {
        private final Action f2408a = new Action();
        public int f2409g = -1;
        RecyclerView f2410h;
        protected LayoutManager f2411i;
        boolean f2412j;
        boolean f2413k;
        View f2414l;

        public static class Action {
            int f2401a;
            private int f2402b;
            private int f2403c;
            private int f2404d;
            private Interpolator f2405e;
            private boolean f2406f;
            private int f2407g;

            public Action() {
                this((byte) 0);
            }

            private Action(byte b) {
                this.f2401a = (byte) -1;
                this.f2406f = false;
                this.f2407g = 0;
                this.f2402b = 0;
                this.f2403c = 0;
                this.f2404d = (byte) 0;
                this.f2405e = (byte) 0;
            }

            final void m2192a(RecyclerView recyclerView) {
                int i;
                if (this.f2401a >= 0) {
                    i = this.f2401a;
                    this.f2401a = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f2406f = false;
                } else if (!this.f2406f) {
                    this.f2407g = 0;
                } else if (this.f2405e != null && this.f2404d <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f2404d <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    if (this.f2405e != null) {
                        recyclerView.mViewFlinger.m2206a(this.f2402b, this.f2403c, this.f2404d, this.f2405e);
                    } else if (this.f2404d == Integer.MIN_VALUE) {
                        recyclerView = recyclerView.mViewFlinger;
                        i = this.f2402b;
                        int i2 = this.f2403c;
                        recyclerView.m2205a(i, i2, recyclerView.m2203a(i, i2));
                    } else {
                        recyclerView.mViewFlinger.m2205a(this.f2402b, this.f2403c, this.f2404d);
                    }
                    this.f2407g++;
                    if (this.f2407g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2406f = false;
                }
            }

            public final void m2191a(int i, int i2, int i3, Interpolator interpolator) {
                this.f2402b = i;
                this.f2403c = i2;
                this.f2404d = i3;
                this.f2405e = interpolator;
                this.f2406f = true;
            }
        }

        public interface ScrollVectorProvider {
            PointF mo635b(int i);
        }

        protected abstract void mo650a();

        protected abstract void mo651a(int i, int i2, Action action);

        protected abstract void mo652a(View view, Action action);

        public final void m2200d(int i) {
            this.f2409g = i;
        }

        protected final void m2199c() {
            if (this.f2413k) {
                mo650a();
                this.f2410h.mState.mTargetPosition = -1;
                this.f2414l = null;
                this.f2409g = -1;
                this.f2412j = false;
                this.f2413k = false;
                LayoutManager.m2072a(this.f2411i, this);
                this.f2411i = null;
                this.f2410h = null;
            }
        }

        public final int m2195a(View view) {
            return this.f2410h.getChildLayoutPosition(view);
        }

        static /* synthetic */ void m2194a(SmoothScroller smoothScroller, int i, int i2) {
            RecyclerView recyclerView = smoothScroller.f2410h;
            if (!smoothScroller.f2413k || smoothScroller.f2409g == -1 || recyclerView == null) {
                smoothScroller.m2199c();
            }
            boolean z = false;
            smoothScroller.f2412j = false;
            if (smoothScroller.f2414l != null) {
                if (smoothScroller.m2195a(smoothScroller.f2414l) == smoothScroller.f2409g) {
                    View view = smoothScroller.f2414l;
                    State state = recyclerView.mState;
                    smoothScroller.mo652a(view, smoothScroller.f2408a);
                    smoothScroller.f2408a.m2192a(recyclerView);
                    smoothScroller.m2199c();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    smoothScroller.f2414l = null;
                }
            }
            if (smoothScroller.f2413k) {
                State state2 = recyclerView.mState;
                smoothScroller.mo651a(i, i2, smoothScroller.f2408a);
                if (smoothScroller.f2408a.f2401a >= 0) {
                    z = true;
                }
                smoothScroller.f2408a.m2192a(recyclerView);
                if (z) {
                    if (smoothScroller.f2413k != 0) {
                        smoothScroller.f2412j = true;
                        recyclerView.mViewFlinger.m2204a();
                        return;
                    }
                    smoothScroller.m2199c();
                }
            }
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout = false;
        boolean mIsMeasuring = false;
        int mItemCount = 0;
        int mLayoutStep = 1;
        int mPreviousLayoutItemCount = 0;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations = false;
        boolean mRunSimpleAnimations = false;
        boolean mStructureChanged = false;
        private int mTargetPosition = -1;
        boolean mTrackOldChangeHolders = false;

        void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) == 0) {
                StringBuilder stringBuilder = new StringBuilder("Layout state should be one of ");
                stringBuilder.append(Integer.toBinaryString(i));
                stringBuilder.append(" but it is ");
                stringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        State reset() {
            this.mTargetPosition = -1;
            if (this.mData != null) {
                this.mData.clear();
            }
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mIsMeasuring = false;
            return this;
        }

        void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.mo39a();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }

        public void remove(int i) {
            if (this.mData != null) {
                this.mData.remove(i);
            }
        }

        public <T> T get(int i) {
            if (this.mData == null) {
                return null;
            }
            return this.mData.get(i);
        }

        public void put(int i, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray();
            }
            this.mData.put(i, obj);
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            return this.mTargetPosition != -1;
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("State{mTargetPosition=");
            stringBuilder.append(this.mTargetPosition);
            stringBuilder.append(", mData=");
            stringBuilder.append(this.mData);
            stringBuilder.append(", mItemCount=");
            stringBuilder.append(this.mItemCount);
            stringBuilder.append(", mPreviousLayoutItemCount=");
            stringBuilder.append(this.mPreviousLayoutItemCount);
            stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            stringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            stringBuilder.append(", mStructureChanged=");
            stringBuilder.append(this.mStructureChanged);
            stringBuilder.append(", mInPreLayout=");
            stringBuilder.append(this.mInPreLayout);
            stringBuilder.append(", mRunSimpleAnimations=");
            stringBuilder.append(this.mRunSimpleAnimations);
            stringBuilder.append(", mRunPredictiveAnimations=");
            stringBuilder.append(this.mRunPredictiveAnimations);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View m2201a();
    }

    class ViewFlinger implements Runnable {
        int f2415a;
        int f2416b;
        OverScroller f2417c;
        Interpolator f2418d = RecyclerView.sQuinticInterpolator;
        final /* synthetic */ RecyclerView f2419e;
        private boolean f2420f = false;
        private boolean f2421g = false;

        ViewFlinger(RecyclerView recyclerView) {
            this.f2419e = recyclerView;
            this.f2417c = new OverScroller(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void run() {
            if (this.f2419e.mLayout == null) {
                m2207b();
                return;
            }
            boolean z;
            r0.f2421g = false;
            r0.f2420f = true;
            r0.f2419e.consumePendingUpdateOperations();
            OverScroller overScroller = r0.f2417c;
            SmoothScroller smoothScroller = r0.f2419e.mLayout.f2375t;
            if (overScroller.computeScrollOffset()) {
                int a;
                int i;
                int b;
                int i2;
                int itemCount;
                int[] access$500 = r0.f2419e.mScrollConsumed;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - r0.f2415a;
                int i4 = currY - r0.f2416b;
                r0.f2415a = currX;
                r0.f2416b = currY;
                if (r0.f2419e.dispatchNestedPreScroll(i3, i4, access$500, null, 1)) {
                    i3 -= access$500[0];
                    i4 -= access$500[1];
                }
                if (r0.f2419e.mAdapter != null) {
                    r0.f2419e.eatRequestLayout();
                    r0.f2419e.onEnterLayoutOrScroll();
                    TraceCompat.m975a(RecyclerView.TRACE_SCROLL_TAG);
                    r0.f2419e.fillRemainingScrollValues(r0.f2419e.mState);
                    if (i3 != 0) {
                        a = r0.f2419e.mLayout.mo622a(i3, r0.f2419e.mRecycler, r0.f2419e.mState);
                        i = i3 - a;
                    } else {
                        a = 0;
                        i = a;
                    }
                    if (i4 != 0) {
                        b = r0.f2419e.mLayout.mo633b(i4, r0.f2419e.mRecycler, r0.f2419e.mState);
                        i2 = i4 - b;
                    } else {
                        b = 0;
                        i2 = b;
                    }
                    TraceCompat.m974a();
                    r0.f2419e.repositionShadowingViews();
                    r0.f2419e.onExitLayoutOrScroll();
                    r0.f2419e.resumeRequestLayout(false);
                    if (!(smoothScroller == null || smoothScroller.f2412j || !smoothScroller.f2413k)) {
                        itemCount = r0.f2419e.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.m2199c();
                        } else {
                            if (smoothScroller.f2409g >= itemCount) {
                                smoothScroller.f2409g = itemCount - 1;
                            }
                            SmoothScroller.m2194a(smoothScroller, i3 - i, i4 - i2);
                        }
                    }
                } else {
                    a = 0;
                    i = a;
                    b = i;
                    i2 = b;
                }
                if (!r0.f2419e.mItemDecorations.isEmpty()) {
                    r0.f2419e.invalidate();
                }
                if (r0.f2419e.getOverScrollMode() != 2) {
                    r0.f2419e.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (!(r0.f2419e.dispatchNestedScroll(a, b, i, i2, null, 1) || (i == 0 && i2 == 0))) {
                    int i5;
                    itemCount = (int) overScroller.getCurrVelocity();
                    if (i != currX) {
                        if (i < 0) {
                            i5 = -itemCount;
                        } else if (i > 0) {
                            i5 = itemCount;
                        }
                        if (i2 != currY) {
                            if (i2 < 0) {
                                itemCount = -itemCount;
                            } else if (i2 > 0) {
                            }
                            if (r0.f2419e.getOverScrollMode() != 2) {
                                r0.f2419e.absorbGlows(i5, itemCount);
                            }
                            if ((i5 != 0 || i == currX || overScroller.getFinalX() == 0) && (itemCount != 0 || i2 == currY || overScroller.getFinalY() == 0)) {
                                overScroller.abortAnimation();
                            }
                        }
                        itemCount = 0;
                        if (r0.f2419e.getOverScrollMode() != 2) {
                            r0.f2419e.absorbGlows(i5, itemCount);
                        }
                        overScroller.abortAnimation();
                    }
                    i5 = 0;
                    if (i2 != currY) {
                        if (i2 < 0) {
                            itemCount = -itemCount;
                        } else if (i2 > 0) {
                        }
                        if (r0.f2419e.getOverScrollMode() != 2) {
                            r0.f2419e.absorbGlows(i5, itemCount);
                        }
                        overScroller.abortAnimation();
                    }
                    itemCount = 0;
                    if (r0.f2419e.getOverScrollMode() != 2) {
                        r0.f2419e.absorbGlows(i5, itemCount);
                    }
                    overScroller.abortAnimation();
                }
                if (!(a == 0 && b == 0)) {
                    r0.f2419e.dispatchOnScrolled(a, b);
                }
                if (!r0.f2419e.awakenScrollBars()) {
                    r0.f2419e.invalidate();
                }
                z = i4 != 0 && r0.f2419e.mLayout.mo647f() && b == i4;
                boolean z2 = i3 != 0 && r0.f2419e.mLayout.mo645e() && a == i3;
                if (!((i3 == 0 && i4 == 0) || z2)) {
                    if (!z) {
                        z = false;
                        if (!overScroller.isFinished()) {
                            if (!z || r0.f2419e.hasNestedScrollingParent(1)) {
                                m2204a();
                                if (r0.f2419e.mGapWorker != null) {
                                    r0.f2419e.mGapWorker.m1967a(r0.f2419e, i3, i4);
                                }
                            }
                        }
                        r0.f2419e.setScrollState(0);
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                            r0.f2419e.mPrefetchRegistry.m10650a();
                        }
                        r0.f2419e.stopNestedScroll(1);
                    }
                }
                z = true;
                if (overScroller.isFinished()) {
                    if (z) {
                    }
                    m2204a();
                    if (r0.f2419e.mGapWorker != null) {
                        r0.f2419e.mGapWorker.m1967a(r0.f2419e, i3, i4);
                    }
                }
                r0.f2419e.setScrollState(0);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    r0.f2419e.mPrefetchRegistry.m10650a();
                }
                r0.f2419e.stopNestedScroll(1);
            }
            if (smoothScroller != null) {
                if (smoothScroller.f2412j) {
                    z = false;
                    SmoothScroller.m2194a(smoothScroller, 0, 0);
                } else {
                    z = false;
                }
                if (!r0.f2421g) {
                    smoothScroller.m2199c();
                }
            } else {
                z = false;
            }
            r0.f2420f = z;
            if (r0.f2421g) {
                m2204a();
            }
        }

        final void m2204a() {
            if (this.f2420f) {
                this.f2421g = true;
                return;
            }
            this.f2419e.removeCallbacks(this);
            ViewCompat.m1224a(this.f2419e, (Runnable) this);
        }

        final int m2203a(int i, int i2) {
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            i = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            i2 = obj != null ? this.f2419e.getWidth() : this.f2419e.getHeight();
            int i3 = i2 / 2;
            i2 = (float) i2;
            float f = (float) i3;
            f += ((float) Math.sin((double) ((Math.min(1.0f, (((float) i) * 1065353216) / i2) - 1056964608) * 1055999547))) * f;
            if (sqrt > 0) {
                i = 4 * Math.round(1148846080 * Math.abs(f / ((float) sqrt)));
            } else {
                if (obj == null) {
                    abs = abs2;
                }
                i = (int) (((((float) abs) / i2) + 1065353216) * 1133903872);
            }
            return Math.min(i, 2000);
        }

        public final void m2205a(int i, int i2, int i3) {
            m2206a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        public final void m2206a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f2418d != interpolator) {
                this.f2418d = interpolator;
                this.f2417c = new OverScroller(this.f2419e.getContext(), interpolator);
            }
            this.f2419e.setScrollState(2);
            this.f2416b = 0;
            this.f2415a = 0;
            this.f2417c.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.f2417c.computeScrollOffset();
            }
            m2204a();
        }

        public final void m2207b() {
            this.f2419e.removeCallbacks(this);
            this.f2417c.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        private static final List<Object> f2422b = Collections.EMPTY_LIST;
        private int f2423a;
        public final View f2424c;
        WeakReference<RecyclerView> f2425d;
        int f2426e = -1;
        public int f2427f = -1;
        long f2428g = -1;
        public int f2429h = -1;
        int f2430i = -1;
        ViewHolder f2431j = null;
        ViewHolder f2432k = null;
        List<Object> f2433l = null;
        List<Object> f2434m = null;
        int f2435n = -1;
        RecyclerView f2436o;
        private int f2437p = 0;
        private Recycler f2438q = null;
        private boolean f2439r = false;
        private int f2440s = 0;

        final void m2217a(int r1, int r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.widget.RecyclerView.ViewHolder.a(int, int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 8 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.ViewHolder.a(int, int):void");
        }

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f2424c = view;
        }

        final void m2218a(int i, boolean z) {
            if (this.f2427f == -1) {
                this.f2427f = this.f2426e;
            }
            if (this.f2430i == -1) {
                this.f2430i = this.f2426e;
            }
            if (z) {
                this.f2430i += i;
            }
            this.f2426e += i;
            if (this.f2424c.getLayoutParams() != 0) {
                ((LayoutParams) this.f2424c.getLayoutParams()).f2384e = true;
            }
        }

        final void m2216a() {
            this.f2427f = -1;
            this.f2430i = -1;
        }

        final boolean m2222b() {
            return (this.f2423a & 128) != 0;
        }

        public final int m2224c() {
            return this.f2430i == -1 ? this.f2426e : this.f2430i;
        }

        public final int m2226d() {
            if (this.f2436o == null) {
                return -1;
            }
            return this.f2436o.getAdapterPositionFor(this);
        }

        public final int m2227e() {
            return this.f2427f;
        }

        public final int m2228f() {
            return this.f2429h;
        }

        final boolean m2229g() {
            return this.f2438q != null;
        }

        final void m2230h() {
            this.f2438q.m2185b(this);
        }

        final boolean m2231i() {
            return (this.f2423a & 32) != 0;
        }

        final void m2232j() {
            this.f2423a &= -33;
        }

        final void m2233k() {
            this.f2423a &= -257;
        }

        final void m2219a(Recycler recycler, boolean z) {
            this.f2438q = recycler;
            this.f2439r = z;
        }

        final boolean m2234l() {
            return (this.f2423a & 4) != 0;
        }

        final boolean m2235m() {
            return (this.f2423a & 2) != 0;
        }

        final boolean m2236n() {
            return (this.f2423a & 1) != 0;
        }

        final boolean m2237o() {
            return (this.f2423a & 8) != 0;
        }

        final boolean m2223b(int i) {
            return (i & this.f2423a) != 0;
        }

        final boolean m2238p() {
            return (this.f2423a & 256) != 0;
        }

        final void m2225c(int i) {
            this.f2423a = i | this.f2423a;
        }

        final void m2220a(Object obj) {
            if (obj == null) {
                m2225c(1024);
                return;
            }
            if ((1024 & this.f2423a) == 0) {
                if (this.f2433l == null) {
                    this.f2433l = new ArrayList();
                    this.f2434m = Collections.unmodifiableList(this.f2433l);
                }
                this.f2433l.add(obj);
            }
        }

        final void m2239q() {
            if (this.f2433l != null) {
                this.f2433l.clear();
            }
            this.f2423a &= -1025;
        }

        final List<Object> m2240r() {
            if ((this.f2423a & 1024) != 0) {
                return f2422b;
            }
            if (this.f2433l != null) {
                if (this.f2433l.size() != 0) {
                    return this.f2434m;
                }
            }
            return f2422b;
        }

        final void m2241s() {
            this.f2423a = 0;
            this.f2426e = -1;
            this.f2427f = -1;
            this.f2428g = -1;
            this.f2430i = -1;
            this.f2437p = 0;
            this.f2431j = null;
            this.f2432k = null;
            m2239q();
            this.f2440s = 0;
            this.f2435n = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public String toString() {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{");
            stringBuilder.append(Integer.toHexString(hashCode()));
            stringBuilder.append(" position=");
            stringBuilder.append(this.f2426e);
            stringBuilder.append(" id=");
            stringBuilder.append(this.f2428g);
            stringBuilder.append(", oldPos=");
            stringBuilder.append(this.f2427f);
            stringBuilder.append(", pLpos:");
            stringBuilder.append(this.f2430i);
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
            if (m2229g()) {
                stringBuilder2.append(" scrap ");
                stringBuilder2.append(this.f2439r ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m2234l()) {
                stringBuilder2.append(" invalid");
            }
            if (!m2236n()) {
                stringBuilder2.append(" unbound");
            }
            if (m2235m()) {
                stringBuilder2.append(" update");
            }
            if (m2237o()) {
                stringBuilder2.append(" removed");
            }
            if (m2222b()) {
                stringBuilder2.append(" ignored");
            }
            if (m2238p()) {
                stringBuilder2.append(" tmpDetached");
            }
            if (!m2242t()) {
                stringBuilder = new StringBuilder(" not recyclable(");
                stringBuilder.append(this.f2437p);
                stringBuilder.append(")");
                stringBuilder2.append(stringBuilder.toString());
            }
            if ((this.f2423a & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
                if (!m2234l()) {
                    obj = null;
                    if (obj != null) {
                        stringBuilder2.append(" undefined adapter position");
                    }
                    if (this.f2424c.getParent() == null) {
                        stringBuilder2.append(" no parent");
                    }
                    stringBuilder2.append("}");
                    return stringBuilder2.toString();
                }
            }
            obj = 1;
            if (obj != null) {
                stringBuilder2.append(" undefined adapter position");
            }
            if (this.f2424c.getParent() == null) {
                stringBuilder2.append(" no parent");
            }
            stringBuilder2.append("}");
            return stringBuilder2.toString();
        }

        public final void m2221a(boolean z) {
            this.f2437p = z ? this.f2437p - 1 : this.f2437p + 1;
            if (this.f2437p < 0) {
                this.f2437p = false;
                StringBuilder stringBuilder = new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                stringBuilder.append(this);
                Log.e("View", stringBuilder.toString());
            } else if (z || this.f2437p != 1) {
                if (z && !this.f2437p) {
                    this.f2423a &= -17;
                }
            } else {
                this.f2423a |= 16;
            }
        }

        public final boolean m2242t() {
            return (this.f2423a & 16) == 0 && !ViewCompat.m1233b(this.f2424c);
        }

        final boolean m2243u() {
            return (this.f2423a & 2) != 0;
        }

        static /* synthetic */ void m2208a(ViewHolder viewHolder, RecyclerView recyclerView) {
            viewHolder.f2440s = ViewCompat.m1237d(viewHolder.f2424c);
            recyclerView.setChildImportantForAccessibilityInternal(viewHolder, 4);
        }

        static /* synthetic */ void m2211b(ViewHolder viewHolder, RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(viewHolder, viewHolder.f2440s);
            viewHolder.f2440s = null;
        }

        static /* synthetic */ boolean m2209a(ViewHolder viewHolder) {
            return ((viewHolder.f2423a & 16) != 0 || ViewCompat.m1233b(viewHolder.f2424c) == null) ? null : true;
        }

        static /* synthetic */ boolean m2214e(ViewHolder viewHolder) {
            return (viewHolder.f2423a & 16) != null ? true : null;
        }
    }

    class C10314 implements ProcessCallback {
        final /* synthetic */ RecyclerView f12035a;

        C10314(RecyclerView recyclerView) {
            this.f12035a = recyclerView;
        }

        public final void mo676a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
            this.f12035a.mRecycler.m2185b(viewHolder);
            this.f12035a.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        public final void mo677b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
            this.f12035a.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        public final void mo678c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
            viewHolder.m2221a(false);
            if (this.f12035a.mDataSetHasChangedAfterLayout) {
                if (this.f12035a.mItemAnimator.mo712a(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2) != null) {
                    this.f12035a.postAnimationRunner();
                }
            } else if (this.f12035a.mItemAnimator.mo714c(viewHolder, itemHolderInfo, itemHolderInfo2) != null) {
                this.f12035a.postAnimationRunner();
            }
        }

        public final void mo675a(ViewHolder viewHolder) {
            this.f12035a.mLayout.m2107a(viewHolder.f2424c, this.f12035a.mRecycler);
        }
    }

    class C10325 implements Callback {
        final /* synthetic */ RecyclerView f12036a;

        C10325(RecyclerView recyclerView) {
            this.f12036a = recyclerView;
        }

        public final int mo679a() {
            return this.f12036a.getChildCount();
        }

        public final void mo682a(View view, int i) {
            this.f12036a.addView(view, i);
            this.f12036a.dispatchChildAttached(view);
        }

        public final int mo680a(View view) {
            return this.f12036a.indexOfChild(view);
        }

        public final void mo681a(int i) {
            View childAt = this.f12036a.getChildAt(i);
            if (childAt != null) {
                this.f12036a.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            this.f12036a.removeViewAt(i);
        }

        public final View mo685b(int i) {
            return this.f12036a.getChildAt(i);
        }

        public final ViewHolder mo684b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public final void mo683a(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.m2238p() || childViewHolderInt.m2222b()) {
                    childViewHolderInt.m2233k();
                } else {
                    i = new StringBuilder("Called attach on a child which is not detached: ");
                    i.append(childViewHolderInt);
                    i.append(this.f12036a.exceptionLabel());
                    throw new IllegalArgumentException(i.toString());
                }
            }
            this.f12036a.attachViewToParent(view, i, layoutParams);
        }

        public final void mo687c(int i) {
            View b = mo685b(i);
            if (b != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.m2238p() || childViewHolderInt.m2222b()) {
                        childViewHolderInt.m2225c(256);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("called detach on an already detached child ");
                        stringBuilder.append(childViewHolderInt);
                        stringBuilder.append(this.f12036a.exceptionLabel());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            this.f12036a.detachViewFromParent(i);
        }

        public final void mo688c(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                ViewHolder.m2208a(childViewHolderInt, this.f12036a);
            }
        }

        public final void mo689d(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            if (view != null) {
                ViewHolder.m2211b(view, this.f12036a);
            }
        }

        public final void mo686b() {
            int childCount = this.f12036a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View b = mo685b(i);
                this.f12036a.dispatchChildDetached(b);
                b.clearAnimation();
            }
            this.f12036a.removeAllViews();
        }
    }

    class C10336 implements Callback {
        final /* synthetic */ RecyclerView f12037a;

        C10336(RecyclerView recyclerView) {
            this.f12037a = recyclerView;
        }

        public final ViewHolder mo690a(int i) {
            i = this.f12037a.findViewHolderForPosition(i, true);
            if (i == 0 || this.f12037a.mChildHelper.m1912d(i.f2424c)) {
                return null;
            }
            return i;
        }

        public final void mo691a(int i, int i2) {
            this.f12037a.offsetPositionRecordsForRemove(i, i2, true);
            this.f12037a.mItemsAddedOrRemoved = true;
            i = this.f12037a.mState;
            i.mDeletedInvisibleItemCountSincePreviousLayout += i2;
        }

        public final void mo694b(int i, int i2) {
            this.f12037a.offsetPositionRecordsForRemove(i, i2, false);
            this.f12037a.mItemsAddedOrRemoved = true;
        }

        public final void mo692a(int i, int i2, Object obj) {
            this.f12037a.viewRangeUpdate(i, i2, obj);
            this.f12037a.mItemsChanged = true;
        }

        public final void mo693a(UpdateOp updateOp) {
            m10795c(updateOp);
        }

        private void m10795c(UpdateOp updateOp) {
            int i = updateOp.f2122a;
            if (i != 4) {
                if (i != 8) {
                    switch (i) {
                        case 1:
                            this.f12037a.mLayout.mo722a(updateOp.f2123b, updateOp.f2125d);
                            return;
                        case 2:
                            this.f12037a.mLayout.mo727b(updateOp.f2123b, updateOp.f2125d);
                            return;
                        default:
                            break;
                    }
                }
                this.f12037a.mLayout.mo729d(updateOp.f2123b, updateOp.f2125d);
                return;
            }
            this.f12037a.mLayout.mo728c(updateOp.f2123b, updateOp.f2125d);
        }

        public final void mo695b(UpdateOp updateOp) {
            m10795c(updateOp);
        }

        public final void mo696c(int i, int i2) {
            this.f12037a.offsetPositionRecordsForInsert(i, i2);
            this.f12037a.mItemsAddedOrRemoved = true;
        }

        public final void mo697d(int i, int i2) {
            this.f12037a.offsetPositionRecordsForMove(i, i2);
            this.f12037a.mItemsAddedOrRemoved = true;
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimatorListener {
        final /* synthetic */ RecyclerView f12038a;

        ItemAnimatorRestoreListener(RecyclerView recyclerView) {
            this.f12038a = recyclerView;
        }

        public final void mo698a(ViewHolder viewHolder) {
            viewHolder.m2221a(true);
            if (viewHolder.f2431j != null && viewHolder.f2432k == null) {
                viewHolder.f2431j = null;
            }
            viewHolder.f2432k = null;
            if (!ViewHolder.m2214e(viewHolder) && !this.f12038a.removeAnimatingView(viewHolder.f2424c) && viewHolder.m2238p()) {
                this.f12038a.removeDetachedView(viewHolder.f2424c, false);
            }
        }
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView f12041a;

        RecyclerViewDataObserver(RecyclerView recyclerView) {
            this.f12041a = recyclerView;
        }

        public final void mo704a() {
            this.f12041a.assertNotInLayoutOrScroll(null);
            this.f12041a.mState.mStructureChanged = true;
            this.f12041a.setDataSetChangedAfterLayout();
            if (!this.f12041a.mAdapterHelper.m10571d()) {
                this.f12041a.requestLayout();
            }
        }

        public final void mo705a(int i, int i2, Object obj) {
            this.f12041a.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = this.f12041a.mAdapterHelper;
            Object obj2 = 1;
            if (i2 > 0) {
                adapterHelper.f11874a.add(adapterHelper.mo575a(4, i, i2, obj));
                adapterHelper.f11880g |= 4;
                if (adapterHelper.f11874a.size() == 1) {
                    if (obj2 != null) {
                        m10815b();
                    }
                }
            }
            obj2 = null;
            if (obj2 != null) {
                m10815b();
            }
        }

        public final void mo706b(int i, int i2) {
            this.f12041a.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = this.f12041a.mAdapterHelper;
            int i3 = 1;
            if (i2 > 0) {
                adapterHelper.f11874a.add(adapterHelper.mo575a(1, i, i2, null));
                adapterHelper.f11880g |= 1;
                if (adapterHelper.f11874a.size() == 1) {
                    if (i3 != 0) {
                        m10815b();
                    }
                }
            }
            i3 = 0;
            if (i3 != 0) {
                m10815b();
            }
        }

        public final void mo707c(int i, int i2) {
            this.f12041a.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = this.f12041a.mAdapterHelper;
            Object obj = 1;
            if (i2 > 0) {
                adapterHelper.f11874a.add(adapterHelper.mo575a(2, i, i2, null));
                adapterHelper.f11880g |= 2;
                if (adapterHelper.f11874a.size() == 1) {
                    if (obj != null) {
                        m10815b();
                    }
                }
            }
            obj = null;
            if (obj != null) {
                m10815b();
            }
        }

        public final void mo708d(int i, int i2) {
            this.f12041a.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = this.f12041a.mAdapterHelper;
            Object obj = 1;
            if (i != i2) {
                adapterHelper.f11874a.add(adapterHelper.mo575a(8, i, i2, null));
                adapterHelper.f11880g |= 8;
                if (adapterHelper.f11874a.size() == 1) {
                    if (obj != null) {
                        m10815b();
                    }
                }
            }
            obj = null;
            if (obj != null) {
                m10815b();
            }
        }

        private void m10815b() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && this.f12041a.mHasFixedSize && this.f12041a.mIsAttached) {
                ViewCompat.m1224a(this.f12041a, this.f12041a.mUpdateChildViewsRunnable);
                return;
            }
            this.f12041a.mAdapterUpdateDuringMeasure = true;
            this.f12041a.requestLayout();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C02151();
        Parcelable mLayoutState;

        static class C02151 implements ClassLoaderCreator<SavedState> {
            C02151() {
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = LayoutManager.class.getClassLoader();
            }
            this.mLayoutState = parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    static {
        boolean z;
        if (!(VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19)) {
            if (VERSION.SDK_INT != 20) {
                z = false;
                FORCE_INVALIDATE_DISPLAY_LIST = z;
            }
        }
        z = true;
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        if (VERSION.SDK_INT < 23) {
        }
        if (VERSION.SDK_INT < 16) {
        }
        if (VERSION.SDK_INT < 21) {
        }
        if (VERSION.SDK_INT > 15) {
        }
        if (VERSION.SDK_INT > 15) {
        }
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new C02121(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mEatRequestLayout = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new C02132(this);
        this.mViewInfoProcessCallback = new C10314(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i, 0);
            this.mClipToPadding = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.m1266a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.m1267b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f2355h = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.m1237d(this) == 0) {
            ViewCompat.m1214a((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0182R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0182R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(C0182R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.mEnableFastScroller = obtainStyledAttributes.getBoolean(C0182R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(C0182R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(C0182R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(C0182R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(C0182R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes.recycle();
            createLayoutManager(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                context = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
                attributeSet = context.getBoolean(0, true);
                context.recycle();
                z = attributeSet;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        StringBuilder stringBuilder = new StringBuilder(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.mAdapter);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.mLayout);
        stringBuilder.append(", context:");
        stringBuilder.append(getContext());
        return stringBuilder.toString();
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.m1220a((View) this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            str = str.trim();
            if (!str.isEmpty()) {
                str = getFullClassName(context, str);
                try {
                    ClassLoader classLoader;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(str).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (Context context2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (int i3) {
                    i3.initCause(context2);
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Error creating LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), i3);
                } catch (Context context22) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Unable to find LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context22);
                } catch (Context context222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Could not instantiate the LayoutManager: ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context222);
                } catch (Context context2222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Could not instantiate the LayoutManager: ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context2222);
                } catch (Context context22222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Cannot access non-public constructor ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context22222);
                } catch (Context context222222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Class is not a LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context222222);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            return stringBuilder.toString();
        } else if (str.contains(".") != null) {
            return str;
        } else {
            context = new StringBuilder();
            context.append(RecyclerView.class.getPackage().getName());
            context.append('.');
            context.append(str);
            return context.toString();
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new C10325(this));
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new C10336(this));
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("setScrollingTouchSlop(): bad argument constant ");
                stringBuilder.append(i);
                stringBuilder.append("; using default value");
                Log.w(str, stringBuilder.toString());
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        requestLayout();
    }

    void removeAndRecycleViews() {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo3238d();
        }
        if (this.mLayout != null) {
            this.mLayout.m2126c(this.mRecycler);
            this.mLayout.m2120b(this.mRecycler);
        }
        this.mRecycler.m2179a();
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.m2023b(this.mObserver);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m10565a();
        z2 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.m2016a(this.mObserver);
        }
        adapter = this.mRecycler;
        Adapter adapter2 = this.mAdapter;
        adapter.m2179a();
        adapter = adapter.m2190d();
        if (z2) {
            adapter.m2172c();
        }
        if (!(z || adapter.f2391b)) {
            for (z = false; z < adapter.f2390a.size(); z++) {
                ((ScrapData) adapter.f2390a.valueAt(z)).f2386a.clear();
            }
        }
        if (adapter2 != null) {
            adapter.m2171b();
        }
        this.mState.mStructureChanged = true;
        setDataSetChangedAfterLayout();
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public int getBaseline() {
        if (this.mLayout != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(onChildAttachStateChangeListener);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mItemAnimator != null) {
                    this.mItemAnimator.mo3238d();
                }
                this.mLayout.m2126c(this.mRecycler);
                this.mLayout.m2120b(this.mRecycler);
                this.mRecycler.m2179a();
                if (this.mIsAttached) {
                    this.mLayout.m2122b(this, this.mRecycler);
                }
                this.mLayout.m2101a(null);
                this.mLayout = null;
            } else {
                this.mRecycler.m2179a();
            }
            ChildHelper childHelper = this.mChildHelper;
            Bucket bucket = childHelper.f2210b;
            while (true) {
                bucket.f2207a = 0;
                if (bucket.f2208b == null) {
                    break;
                }
                bucket = bucket.f2208b;
            }
            for (int size = childHelper.f2211c.size() - 1; size >= 0; size--) {
                childHelper.f2209a.mo689d((View) childHelper.f2211c.get(size));
                childHelper.f2211c.remove(size);
            }
            childHelper.f2209a.mo686b();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f2372q != null) {
                    StringBuilder stringBuilder = new StringBuilder("LayoutManager ");
                    stringBuilder.append(layoutManager);
                    stringBuilder.append(" is already attached to a RecyclerView:");
                    stringBuilder.append(layoutManager.f2372q.exceptionLabel());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.mLayout.m2101a(this);
                if (this.mIsAttached != null) {
                    this.mLayout.f2377v = true;
                }
            }
            this.mRecycler.m2184b();
            requestLayout();
        }
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            savedState.copyFrom(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            savedState.mLayoutState = this.mLayout.mo643d();
        } else {
            savedState.mLayoutState = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
            if (!(this.mLayout == null || this.mPendingSavedState.mLayoutState == null)) {
                this.mLayout.mo627a(this.mPendingSavedState.mLayoutState);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.f2424c;
        boolean z = view.getParent() == this;
        this.mRecycler.m2185b(getChildViewHolder(view));
        if (viewHolder.m2238p() != null) {
            this.mChildHelper.m1904a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            viewHolder = this.mChildHelper;
            int a = viewHolder.f2209a.mo680a(view);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("view is not a child, cannot hide ");
                stringBuilder.append(view);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            viewHolder.f2210b.m1884a(a);
            viewHolder.m1903a(view);
        } else {
            this.mChildHelper.m1905a(view, -1, true);
        }
    }

    boolean removeAnimatingView(View view) {
        eatRequestLayout();
        ChildHelper childHelper = this.mChildHelper;
        int a = childHelper.f2209a.mo680a(view);
        boolean z = true;
        if (a == -1) {
            childHelper.m1908b(view);
        } else if (childHelper.f2210b.m1887c(a)) {
            childHelper.f2210b.m1888d(a);
            childHelper.m1908b(view);
            childHelper.f2209a.mo681a(a);
        } else {
            z = false;
        }
        if (z) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m2185b(childViewHolderInt);
            this.mRecycler.m2180a(childViewHolderInt);
        }
        resumeRequestLayout(z ^ 1);
        return z;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.m2190d();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        Recycler recycler = this.mRecycler;
        if (recycler.f2398g != null) {
            recycler.f2398g.m2172c();
        }
        recycler.f2398g = recycledViewPool;
        if (recycledViewPool != null) {
            recycledViewPool = recycler.f2398g;
            recycler.f2400i.getAdapter();
            recycledViewPool.m2171b();
        }
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.f2399h = viewCacheExtension;
    }

    public void setItemViewCacheSize(int i) {
        Recycler recycler = this.mRecycler;
        recycler.f2396e = i;
        recycler.m2184b();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        if (this.mLayout != null) {
            this.mLayout.mo632a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0) {
            if (i < itemDecorationCount) {
                return (ItemDecoration) this.mItemDecorations.get(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0) {
            if (i < itemDecorationCount) {
                removeItemDecoration(getItemDecorationAt(i));
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        if (this.mLayout != null) {
            this.mLayout.mo632a("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty() != null) {
            setWillNotDraw(getOverScrollMode() == 2 ? true : null);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null ? true : null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.mLayout.mo638c(i);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo638c(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.mo629a(this, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            boolean e = this.mLayout.mo645e();
            boolean f = this.mLayout.mo647f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete) {
            if (!this.mDataSetHasChangedAfterLayout) {
                if (!this.mAdapterHelper.m10571d()) {
                    return;
                }
                if (!this.mAdapterHelper.m10567a(4) || this.mAdapterHelper.m10567a(11)) {
                    if (this.mAdapterHelper.m10571d()) {
                        TraceCompat.m975a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                        dispatchLayout();
                        TraceCompat.m974a();
                    }
                    return;
                }
                TraceCompat.m975a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                eatRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.m10569b();
                if (!this.mLayoutRequestEaten) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.m10570c();
                    }
                }
                resumeRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.m974a();
                return;
            }
        }
        TraceCompat.m975a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.m974a();
    }

    private boolean hasUpdatedView() {
        int a = this.mChildHelper.m1901a();
        for (int i = 0; i < a; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(i));
            if (childViewHolderInt != null && !childViewHolderInt.m2222b() && childViewHolderInt.m2243u()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int b;
        int i4;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            eatRequestLayout();
            onEnterLayoutOrScroll();
            TraceCompat.m975a(TRACE_SCROLL_TAG);
            fillRemainingScrollValues(this.mState);
            if (i != 0) {
                a = this.mLayout.mo622a(i, this.mRecycler, this.mState);
                i3 = i - a;
            } else {
                a = 0;
                i3 = a;
            }
            if (i2 != 0) {
                b = this.mLayout.mo633b(i2, this.mRecycler, this.mState);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = b;
            }
            TraceCompat.m974a();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
        } else {
            a = 0;
            i3 = a;
            b = i3;
            i4 = b;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(a, b, i3, i4, this.mScrollOffset, 0)) {
            this.mLastTouchX -= this.mScrollOffset[0];
            this.mLastTouchY -= this.mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
            }
            i = this.mNestedOffsets;
            i[0] = i[0] + this.mScrollOffset[0];
            i = this.mNestedOffsets;
            i[1] = i[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || MotionEventCompat.m1121b(motionEvent))) {
                pullGlows(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i4);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(a == 0 && b == 0)) {
            dispatchOnScrolled(a, b);
        }
        if (awakenScrollBars() == 0) {
            invalidate();
        }
        if (a == 0) {
            if (b == 0) {
                return false;
            }
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.mLayout != null && this.mLayout.mo645e()) {
            return this.mLayout.mo634b(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.mLayout != null && this.mLayout.mo645e()) {
            return this.mLayout.mo642d(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.mLayout != null && this.mLayout.mo645e()) {
            return this.mLayout.mo646f(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.mLayout != null && this.mLayout.mo647f()) {
            return this.mLayout.mo637c(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.mLayout != null && this.mLayout.mo647f()) {
            return this.mLayout.mo644e(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.mLayout != null && this.mLayout.mo647f()) {
            return this.mLayout.mo648g(this.mState);
        }
        return 0;
    }

    void eatRequestLayout() {
        this.mEatRequestLayout++;
        if (this.mEatRequestLayout == 1 && !this.mLayoutFrozen) {
            this.mLayoutRequestEaten = false;
        }
    }

    void resumeRequestLayout(boolean z) {
        if (this.mEatRequestLayout <= 0) {
            this.mEatRequestLayout = 1;
        }
        if (!z) {
            this.mLayoutRequestEaten = false;
        }
        if (this.mEatRequestLayout == 1) {
            if (z && this.mLayoutRequestEaten && !this.mLayoutFrozen && this.mLayout && this.mAdapter) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutRequestEaten = false;
            }
        }
        this.mEatRequestLayout -= true;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutFrozen = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
            } else {
                this.mLayoutFrozen = false;
                if (!(!this.mLayoutRequestEaten || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutRequestEaten = false;
            }
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            if (!this.mLayout.mo645e()) {
                i = 0;
            }
            if (!this.mLayout.mo647f()) {
                i2 = 0;
            }
            if (!(i == 0 && i2 == 0)) {
                ViewFlinger viewFlinger = this.mViewFlinger;
                int a = viewFlinger.m2203a(i, i2);
                if (interpolator == null) {
                    interpolator = sQuinticInterpolator;
                }
                viewFlinger.m2206a(i, i2, a, interpolator);
            }
        }
    }

    public boolean fling(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (r0.mLayoutFrozen) {
            return false;
        } else {
            int i3;
            int i4;
            float f;
            float f2;
            boolean z;
            int max;
            int max2;
            ViewFlinger viewFlinger;
            int e = r0.mLayout.mo645e();
            boolean f3 = r0.mLayout.mo647f();
            if (e != 0) {
                if (Math.abs(i) >= r0.mMinFlingVelocity) {
                    i3 = i;
                    if (f3) {
                        if (Math.abs(i2) < r0.mMinFlingVelocity) {
                            i4 = i2;
                            if (i3 != 0 && i4 == 0) {
                                return false;
                            }
                            f = (float) i3;
                            f2 = (float) i4;
                            if (!dispatchNestedPreFling(f, f2)) {
                                if (e == 0) {
                                    if (!f3) {
                                        z = false;
                                        dispatchNestedFling(f, f2, z);
                                        if (r0.mOnFlingListener == null && r0.mOnFlingListener.mo717a(i3, i4)) {
                                            return true;
                                        }
                                        if (z) {
                                            if (f3) {
                                                e |= 2;
                                            }
                                            startNestedScroll(e, 1);
                                            max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                                            max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                                            viewFlinger = r0.mViewFlinger;
                                            viewFlinger.f2419e.setScrollState(2);
                                            viewFlinger.f2416b = 0;
                                            viewFlinger.f2415a = 0;
                                            viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                                            viewFlinger.m2204a();
                                            return true;
                                        }
                                    }
                                }
                                z = true;
                                dispatchNestedFling(f, f2, z);
                                if (r0.mOnFlingListener == null) {
                                }
                                if (z) {
                                    if (f3) {
                                        e |= 2;
                                    }
                                    startNestedScroll(e, 1);
                                    max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                                    max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                                    viewFlinger = r0.mViewFlinger;
                                    viewFlinger.f2419e.setScrollState(2);
                                    viewFlinger.f2416b = 0;
                                    viewFlinger.f2415a = 0;
                                    viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                                    viewFlinger.m2204a();
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                    i4 = 0;
                    if (i3 != 0) {
                    }
                    f = (float) i3;
                    f2 = (float) i4;
                    if (dispatchNestedPreFling(f, f2)) {
                        if (e == 0) {
                            if (!f3) {
                                z = false;
                                dispatchNestedFling(f, f2, z);
                                if (r0.mOnFlingListener == null) {
                                }
                                if (z) {
                                    if (f3) {
                                        e |= 2;
                                    }
                                    startNestedScroll(e, 1);
                                    max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                                    max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                                    viewFlinger = r0.mViewFlinger;
                                    viewFlinger.f2419e.setScrollState(2);
                                    viewFlinger.f2416b = 0;
                                    viewFlinger.f2415a = 0;
                                    viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                                    viewFlinger.m2204a();
                                    return true;
                                }
                            }
                        }
                        z = true;
                        dispatchNestedFling(f, f2, z);
                        if (r0.mOnFlingListener == null) {
                        }
                        if (z) {
                            if (f3) {
                                e |= 2;
                            }
                            startNestedScroll(e, 1);
                            max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                            max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                            viewFlinger = r0.mViewFlinger;
                            viewFlinger.f2419e.setScrollState(2);
                            viewFlinger.f2416b = 0;
                            viewFlinger.f2415a = 0;
                            viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                            viewFlinger.m2204a();
                            return true;
                        }
                    }
                    return false;
                }
            }
            i3 = 0;
            if (f3) {
                if (Math.abs(i2) < r0.mMinFlingVelocity) {
                    i4 = i2;
                    if (i3 != 0) {
                    }
                    f = (float) i3;
                    f2 = (float) i4;
                    if (dispatchNestedPreFling(f, f2)) {
                        if (e == 0) {
                            if (!f3) {
                                z = false;
                                dispatchNestedFling(f, f2, z);
                                if (r0.mOnFlingListener == null) {
                                }
                                if (z) {
                                    if (f3) {
                                        e |= 2;
                                    }
                                    startNestedScroll(e, 1);
                                    max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                                    max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                                    viewFlinger = r0.mViewFlinger;
                                    viewFlinger.f2419e.setScrollState(2);
                                    viewFlinger.f2416b = 0;
                                    viewFlinger.f2415a = 0;
                                    viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                                    viewFlinger.m2204a();
                                    return true;
                                }
                            }
                        }
                        z = true;
                        dispatchNestedFling(f, f2, z);
                        if (r0.mOnFlingListener == null) {
                        }
                        if (z) {
                            if (f3) {
                                e |= 2;
                            }
                            startNestedScroll(e, 1);
                            max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                            max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                            viewFlinger = r0.mViewFlinger;
                            viewFlinger.f2419e.setScrollState(2);
                            viewFlinger.f2416b = 0;
                            viewFlinger.f2415a = 0;
                            viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                            viewFlinger.m2204a();
                            return true;
                        }
                    }
                    return false;
                }
            }
            i4 = 0;
            if (i3 != 0) {
            }
            f = (float) i3;
            f2 = (float) i4;
            if (dispatchNestedPreFling(f, f2)) {
                if (e == 0) {
                    if (!f3) {
                        z = false;
                        dispatchNestedFling(f, f2, z);
                        if (r0.mOnFlingListener == null) {
                        }
                        if (z) {
                            if (f3) {
                                e |= 2;
                            }
                            startNestedScroll(e, 1);
                            max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                            max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                            viewFlinger = r0.mViewFlinger;
                            viewFlinger.f2419e.setScrollState(2);
                            viewFlinger.f2416b = 0;
                            viewFlinger.f2415a = 0;
                            viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                            viewFlinger.m2204a();
                            return true;
                        }
                    }
                }
                z = true;
                dispatchNestedFling(f, f2, z);
                if (r0.mOnFlingListener == null) {
                }
                if (z) {
                    if (f3) {
                        e |= 2;
                    }
                    startNestedScroll(e, 1);
                    max = Math.max(-r0.mMaxFlingVelocity, Math.min(i3, r0.mMaxFlingVelocity));
                    max2 = Math.max(-r0.mMaxFlingVelocity, Math.min(i4, r0.mMaxFlingVelocity));
                    viewFlinger = r0.mViewFlinger;
                    viewFlinger.f2419e.setScrollState(2);
                    viewFlinger.f2416b = 0;
                    viewFlinger.f2415a = 0;
                    viewFlinger.f2417c.fling(0, 0, max, max2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
                    viewFlinger.m2204a();
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m2207b();
        if (this.mLayout != null) {
            this.mLayout.m2160z();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float f, float f2, float f3, float f4) {
        Object obj = 1;
        if (f2 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.m1400a(this.mLeftGlow, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
        } else if (f2 > 0.0f) {
            ensureRightGlow();
            EdgeEffectCompat.m1400a(this.mRightGlow, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
        } else {
            f3 = 0.0f;
            if (f4 < 0.0f) {
                ensureTopGlow();
                EdgeEffectCompat.m1400a(this.mTopGlow, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
            } else if (f4 <= 0.0f) {
                ensureBottomGlow();
                EdgeEffectCompat.m1400a(this.mBottomGlow, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
            } else {
                obj = f3;
            }
            if (obj == null || f2 != 0.0f || f4 != 0.0f) {
                ViewCompat.m1234c(this);
            }
            return;
        }
        f3 = Float.MIN_VALUE;
        if (f4 < 0.0f) {
            ensureTopGlow();
            EdgeEffectCompat.m1400a(this.mTopGlow, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 <= 0.0f) {
            obj = f3;
        } else {
            ensureBottomGlow();
            EdgeEffectCompat.m1400a(this.mBottomGlow, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        }
        if (obj == null) {
        }
        ViewCompat.m1234c(this);
    }

    private void releaseGlows() {
        int isFinished;
        if (this.mLeftGlow != null) {
            this.mLeftGlow.onRelease();
            isFinished = this.mLeftGlow.isFinished();
        } else {
            isFinished = 0;
        }
        if (this.mTopGlow != null) {
            this.mTopGlow.onRelease();
            isFinished |= this.mTopGlow.isFinished();
        }
        if (this.mRightGlow != null) {
            this.mRightGlow.onRelease();
            isFinished |= this.mRightGlow.isFinished();
        }
        if (this.mBottomGlow != null) {
            this.mBottomGlow.onRelease();
            isFinished |= this.mBottomGlow.isFinished();
        }
        if (isFinished != 0) {
            ViewCompat.m1234c(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i, int i2) {
        int i3;
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished() || i <= 0) {
            i3 = 0;
        } else {
            this.mLeftGlow.onRelease();
            i3 = this.mLeftGlow.isFinished();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished() || i >= 0)) {
            this.mRightGlow.onRelease();
            i3 |= this.mRightGlow.isFinished();
        }
        if (this.mTopGlow != 0 && this.mTopGlow.isFinished() == 0 && i2 > 0) {
            this.mTopGlow.onRelease();
            i3 |= this.mTopGlow.isFinished();
        }
        if (this.mBottomGlow != 0 && this.mBottomGlow.isFinished() == 0 && i2 < 0) {
            this.mBottomGlow.onRelease();
            i3 |= this.mBottomGlow.isFinished();
        }
        if (i3 != 0) {
            ViewCompat.m1234c(this);
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.m1234c(this);
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = new EdgeEffect(getContext());
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = new EdgeEffect(getContext());
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = new EdgeEffect(getContext());
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = new EdgeEffect(getContext());
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus;
        boolean z = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z && (i == 2 || i == 1)) {
            int i2;
            boolean z2;
            if (this.mLayout.mo647f()) {
                i2 = i == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.mo645e()) {
                i2 = ((ViewCompat.m1242f(this.mLayout.f2372q) == 1 ? 1 : 0) ^ (i == 2 ? 1 : 0)) != 0 ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                eatRequestLayout();
                this.mLayout.mo624a(view, i, this.mRecycler, this.mState);
                resumeRequestLayout(false);
            }
            findNextFocus = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus2 = instance.findNextFocus(this, view, i);
            if (findNextFocus2 == null && z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                eatRequestLayout();
                findNextFocus = this.mLayout.mo624a(view, i, this.mRecycler, this.mState);
                resumeRequestLayout(false);
            } else {
                findNextFocus = findNextFocus2;
            }
        }
        if (findNextFocus == null || findNextFocus.hasFocusable()) {
            if (isPreferredNextFocus(view, findNextFocus, i)) {
                return findNextFocus;
            }
            return super.focusSearch(view, i);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(findNextFocus, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        if (view2 != null) {
            if (view2 != this) {
                if (view == null) {
                    return true;
                }
                this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
                offsetDescendantRectToMyCoords(view, this.mTempRect);
                offsetDescendantRectToMyCoords(view2, this.mTempRect2);
                view2 = -1;
                view = ViewCompat.m1242f(this.mLayout.f2372q) == 1 ? -1 : 1;
                int i2 = ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) ? 1 : ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
                if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
                    view2 = 1;
                } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
                    view2 = null;
                }
                if (i == 17) {
                    return i2 < 0;
                } else {
                    if (i == 33) {
                        return view2 < null;
                    } else {
                        if (i == 66) {
                            return i2 > 0;
                        } else {
                            if (i == 130) {
                                return view2 > null;
                            } else {
                                switch (i) {
                                    case 1:
                                        if (view2 >= null) {
                                            if (view2 != null || i2 * view > 0) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    case 2:
                                        if (view2 <= null) {
                                            if (view2 != null || i2 * view < 0) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    default:
                                        view2 = new StringBuilder("Invalid direction: ");
                                        view2.append(i);
                                        view2.append(exceptionLabel());
                                        throw new IllegalArgumentException(view2.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void requestChildFocus(View view, View view2) {
        Object obj;
        if (!this.mLayout.m2150p()) {
            if (!isComputingLayout()) {
                obj = null;
                if (obj == null && view2 != null) {
                    requestChildOnScreen(view, view2);
                }
                super.requestChildFocus(view, view2);
            }
        }
        obj = 1;
        requestChildOnScreen(view, view2);
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f2384e) {
                Rect rect = layoutParams2.f2383d;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2 = this.mTempRect;
                rect2.right += rect.right;
                rect2 = this.mTempRect;
                rect2.top -= rect.top;
                rect2 = this.mTempRect;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.m2111a(this, view, this.mTempRect, this.mFirstLayoutComplete ^ 1, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.m2111a(this, view, rect, z, false);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        boolean z = this.mFirstLayoutComplete && !isLayoutRequested();
        this.mFirstLayoutComplete = z;
        if (this.mLayout != null) {
            this.mLayout.f2377v = true;
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            this.mGapWorker = (GapWorker) GapWorker.f2281a.get();
            if (this.mGapWorker == null) {
                float refreshRate;
                this.mGapWorker = new GapWorker();
                Display L = ViewCompat.m1211L(this);
                if (!(isInEditMode() || L == null)) {
                    refreshRate = L.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        this.mGapWorker.f2285d = (long) (1.0E9f / refreshRate);
                        GapWorker.f2281a.set(this.mGapWorker);
                    }
                }
                refreshRate = 60.0f;
                this.mGapWorker.f2285d = (long) (1.0E9f / refreshRate);
                GapWorker.f2281a.set(this.mGapWorker);
            }
            this.mGapWorker.f2283b.add(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo3238d();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.mLayout != null) {
            this.mLayout.m2122b(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        ViewInfoStore.m2378b();
        if (ALLOW_THREAD_GAP_WORK) {
            this.mGapWorker.f2283b.remove(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling");
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(exceptionLabel());
            throw new IllegalStateException(stringBuilder2.toString());
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling");
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(exceptionLabel());
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(stringBuilder2.toString()));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mActiveOnItemTouchListener == onItemTouchListener) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.mOnItemTouchListeners.get(i);
            if (!onItemTouchListener.mo618a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mActiveOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.mo617a(motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            action = this.mOnItemTouchListeners.size();
            for (int i = 0; i < action; i++) {
                OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.mOnItemTouchListeners.get(i);
                if (onItemTouchListener.mo618a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            int e = this.mLayout.mo645e();
            boolean f = this.mLayout.mo647f();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            switch (actionMasked) {
                case 0:
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = actionMasked;
                    this.mInitialTouchX = actionMasked;
                    motionEvent = (int) (motionEvent.getY() + 1056964608);
                    this.mLastTouchY = motionEvent;
                    this.mInitialTouchY = motionEvent;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    motionEvent = this.mNestedOffsets;
                    this.mNestedOffsets[1] = 0;
                    motionEvent[0] = null;
                    if (f) {
                        e |= 2;
                    }
                    startNestedScroll(e, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        motionEvent = (int) (motionEvent.getY(actionMasked) + 1056964608);
                        if (this.mScrollState != 1) {
                            boolean z;
                            actionMasked = actionIndex - this.mInitialTouchX;
                            int i = motionEvent - this.mInitialTouchY;
                            if (e == 0 || Math.abs(actionMasked) <= this.mTouchSlop) {
                                z = false;
                            } else {
                                this.mLastTouchX = actionIndex;
                                z = true;
                            }
                            if (f && Math.abs(i) > this.mTouchSlop) {
                                this.mLastTouchY = motionEvent;
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    motionEvent = TAG;
                    StringBuilder stringBuilder = new StringBuilder("Error processing scroll; pointer index for id ");
                    stringBuilder.append(this.mScrollPointerId);
                    stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                    Log.e(motionEvent, stringBuilder.toString());
                    return false;
                    break;
                case 3:
                    cancelTouch();
                    break;
                case 5:
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    e = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = e;
                    this.mInitialTouchX = e;
                    motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
                    this.mLastTouchY = motionEvent;
                    this.mInitialTouchY = motionEvent;
                    break;
                case 6:
                    onPointerUp(motionEvent);
                    break;
                default:
                    break;
            }
            if (this.mScrollState == 1) {
                return true;
            }
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mLayoutFrozen) {
            if (!this.mIgnoreMotionEventTillDown) {
                if (dispatchOnItemTouch(motionEvent)) {
                    cancelTouch();
                    return true;
                } else if (this.mLayout == null) {
                    return false;
                } else {
                    int[] iArr;
                    int e = this.mLayout.mo645e();
                    boolean f = this.mLayout.mo647f();
                    if (this.mVelocityTracker == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    int actionMasked = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        iArr = this.mNestedOffsets;
                        this.mNestedOffsets[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.mNestedOffsets[0], (float) this.mNestedOffsets[1]);
                    switch (actionMasked) {
                        case 0:
                            this.mScrollPointerId = motionEvent.getPointerId(0);
                            actionMasked = (int) (motionEvent.getX() + 0.5f);
                            this.mLastTouchX = actionMasked;
                            this.mInitialTouchX = actionMasked;
                            motionEvent = (int) (motionEvent.getY() + 1056964608);
                            this.mLastTouchY = motionEvent;
                            this.mInitialTouchY = motionEvent;
                            if (f) {
                                e |= 2;
                            }
                            startNestedScroll(e, 0);
                            break;
                        case 1:
                            this.mVelocityTracker.addMovement(obtain);
                            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                            float f2 = e != 0 ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                            float f3 = f ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                            if ((f2 == 0.0f && f3 == 0.0f) || fling((int) f2, (int) f3) == null) {
                                setScrollState(0);
                            }
                            resetTouch();
                            z = true;
                            break;
                        case 2:
                            actionMasked = motionEvent.findPointerIndex(this.mScrollPointerId);
                            if (actionMasked >= 0) {
                                actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                                motionEvent = (int) (motionEvent.getY(actionMasked) + 1056964608);
                                actionMasked = this.mLastTouchX - actionIndex;
                                int i = this.mLastTouchY - motionEvent;
                                if (dispatchNestedPreScroll(actionMasked, i, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                    actionMasked -= this.mScrollConsumed[0];
                                    i -= this.mScrollConsumed[1];
                                    obtain.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
                                    iArr = this.mNestedOffsets;
                                    iArr[0] = iArr[0] + this.mScrollOffset[0];
                                    iArr = this.mNestedOffsets;
                                    iArr[1] = iArr[1] + this.mScrollOffset[1];
                                }
                                if (this.mScrollState != 1) {
                                    boolean z2;
                                    if (e == 0 || Math.abs(actionMasked) <= this.mTouchSlop) {
                                        z2 = false;
                                    } else {
                                        if (actionMasked > 0) {
                                            actionMasked -= this.mTouchSlop;
                                        } else {
                                            actionMasked += this.mTouchSlop;
                                        }
                                        z2 = true;
                                    }
                                    if (f && Math.abs(i) > this.mTouchSlop) {
                                        if (i > 0) {
                                            i -= this.mTouchSlop;
                                        } else {
                                            i += this.mTouchSlop;
                                        }
                                        z2 = true;
                                    }
                                    if (z2) {
                                        setScrollState(1);
                                    }
                                }
                                if (this.mScrollState == 1) {
                                    this.mLastTouchX = actionIndex - this.mScrollOffset[0];
                                    this.mLastTouchY = motionEvent - this.mScrollOffset[1];
                                    if (scrollByInternal(e != 0 ? actionMasked : null, f ? i : 0, obtain) != null) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                    if (!(this.mGapWorker == null || (actionMasked == 0 && i == 0))) {
                                        this.mGapWorker.m1967a(this, actionMasked, i);
                                        break;
                                    }
                                }
                            }
                            motionEvent = TAG;
                            StringBuilder stringBuilder = new StringBuilder("Error processing scroll; pointer index for id ");
                            stringBuilder.append(this.mScrollPointerId);
                            stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                            Log.e(motionEvent, stringBuilder.toString());
                            return false;
                            break;
                        case 3:
                            cancelTouch();
                            break;
                        case 5:
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            e = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = e;
                            this.mInitialTouchX = e;
                            motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
                            this.mLastTouchY = motionEvent;
                            this.mInitialTouchY = motionEvent;
                            break;
                        case 6:
                            onPointerUp(motionEvent);
                            break;
                        default:
                            break;
                    }
                    if (!z) {
                        this.mVelocityTracker.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        return false;
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
            this.mLastTouchY = motionEvent;
            this.mInitialTouchY = motionEvent;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.mLayout == null || this.mLayoutFrozen || motionEvent.getAction() != 8)) {
            float f;
            float axisValue;
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.mLayout.mo647f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.mo645e()) {
                    axisValue = motionEvent.getAxisValue(10);
                    if (!(f == 0.0f && axisValue == 0.0f)) {
                        scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    f = motionEvent.getAxisValue(26);
                    if (this.mLayout.mo647f()) {
                        f = -f;
                    } else if (this.mLayout.mo645e()) {
                        axisValue = f;
                        f = 0.0f;
                        scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f = 0.0f;
                axisValue = f;
                scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
            }
            axisValue = 0.0f;
            scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (this.mLayout.f2378w) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLayout.m2144h(i, i2);
            if (!z) {
                if (this.mAdapter != null) {
                    if (this.mState.mLayoutStep == 1) {
                        dispatchLayoutStep1();
                    }
                    this.mLayout.m2138f(i, i2);
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.m2142g(i, i2);
                    if (this.mLayout.mo649j()) {
                        this.mLayout.m2138f(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                        this.mState.mIsMeasuring = true;
                        dispatchLayoutStep2();
                        this.mLayout.m2142g(i, i2);
                    }
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.m2144h(i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                eatRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.mRunPredictiveAnimations) {
                    this.mState.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.m10572e();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                resumeRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.mAdapter != null) {
                this.mState.mItemCount = this.mAdapter.mo39a();
            } else {
                this.mState.mItemCount = 0;
            }
            eatRequestLayout();
            this.mLayout.m2144h(i, i2);
            resumeRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.m2068a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.m1252m(this)), LayoutManager.m2068a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.m1253n(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo3238d();
            this.mItemAnimator.f2355h = null;
        }
        this.mItemAnimator = itemAnimator;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.f2355h = this.mItemAnimatorListener;
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter <= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(MPEGConst.CODE_END);
            AccessibilityEventCompat.m1315a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        accessibilityEvent = accessibilityEvent != null ? AccessibilityEventCompat.m1314a(accessibilityEvent) : null;
        if (accessibilityEvent == null) {
            accessibilityEvent = null;
        }
        this.mEatenAccessibilityChangeFlags = accessibilityEvent | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.m1224a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.mo640c();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        State state;
        boolean z2;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m10565a();
            this.mLayout.mo721a();
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m10569b();
        } else {
            this.mAdapterHelper.m10572e();
        }
        boolean z3 = true;
        if (!this.mItemsAddedOrRemoved) {
            if (!this.mItemsChanged) {
                z = false;
                state = this.mState;
                z2 = this.mFirstLayoutComplete && this.mItemAnimator != null && ((this.mDataSetHasChangedAfterLayout || z || this.mLayout.f2376u) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.f2349e));
                state.mRunSimpleAnimations = z2;
                state = this.mState;
                if (this.mState.mRunSimpleAnimations || !z || this.mDataSetHasChangedAfterLayout || !predictiveItemAnimationsEnabled()) {
                    z3 = false;
                }
                state.mRunPredictiveAnimations = z3;
            }
        }
        z = true;
        state = this.mState;
        if (!this.mFirstLayoutComplete) {
        }
        state.mRunSimpleAnimations = z2;
        state = this.mState;
        if (this.mState.mRunSimpleAnimations) {
        }
        z3 = false;
        state.mRunPredictiveAnimations = z3;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            boolean z = false;
            this.mState.mIsMeasuring = false;
            if (this.mState.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.m2121b(this);
                dispatchLayoutStep2();
            } else {
                AdapterHelper adapterHelper = this.mAdapterHelper;
                if (!(adapterHelper.f11875b.isEmpty() || adapterHelper.f11874a.isEmpty())) {
                    z = true;
                }
                if (!z && this.mLayout.f2367D == getWidth()) {
                    if (this.mLayout.f2368E == getHeight()) {
                        this.mLayout.m2121b(this);
                    }
                }
                this.mLayout.m2121b(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        ViewHolder viewHolder = null;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        long j;
        int i;
        State state = this.mState;
        if (this.mAdapter.f2349e) {
            j = viewHolder.f2428g;
        } else {
            j = -1;
        }
        state.mFocusedItemId = j;
        state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (viewHolder.m2237o()) {
            i = viewHolder.f2427f;
        } else {
            i = viewHolder.m2226d();
        }
        state.mFocusedItemPosition = i;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.f2424c);
    }

    private void resetFocusInfo() {
        this.mState.mFocusedItemId = -1;
        this.mState.mFocusedItemPosition = -1;
        this.mState.mFocusedSubChildId = -1;
    }

    private View findNextViewToFocus() {
        int i = this.mState.mFocusedItemPosition != -1 ? this.mState.mFocusedItemPosition : 0;
        int itemCount = this.mState.getItemCount();
        int i2 = i;
        while (i2 < itemCount) {
            ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition == null) {
                break;
            } else if (findViewHolderForAdapterPosition.f2424c.hasFocusable()) {
                return findViewHolderForAdapterPosition.f2424c;
            } else {
                i2++;
            }
        }
        for (i = Math.min(itemCount, i) - 1; i >= 0; i--) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition2 == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition2.f2424c.hasFocusable()) {
                return findViewHolderForAdapterPosition2.f2424c;
            }
        }
        return null;
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                View focusedChild;
                if (!isFocused()) {
                    focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.m1912d(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.m1901a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                ViewHolder findViewHolderForItemId = (this.mState.mFocusedItemId == -1 || !this.mAdapter.f2349e) ? null : findViewHolderForItemId(this.mState.mFocusedItemId);
                if (!(findViewHolderForItemId == null || this.mChildHelper.m1912d(findViewHolderForItemId.f2424c))) {
                    if (findViewHolderForItemId.f2424c.hasFocusable()) {
                        view = findViewHolderForItemId.f2424c;
                        if (view != null) {
                            if (((long) this.mState.mFocusedSubChildId) != -1) {
                                focusedChild = view.findViewById(this.mState.mFocusedSubChildId);
                                if (focusedChild != null && focusedChild.isFocusable()) {
                                    focusedChild.requestFocus();
                                }
                            }
                            focusedChild = view;
                            focusedChild.requestFocus();
                        }
                    }
                }
                if (this.mChildHelper.m1901a() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    if (((long) this.mState.mFocusedSubChildId) != -1) {
                        focusedChild = view.findViewById(this.mState.mFocusedSubChildId);
                        focusedChild.requestFocus();
                    }
                    focusedChild = view;
                    focusedChild.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller a = this.mViewFlinger.f2417c;
            state.mRemainingScrollHorizontal = a.getFinalX() - a.getCurrX();
            state.mRemainingScrollVertical = a.getFinalY() - a.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
        state.mRemainingScrollVertical = 0;
    }

    private void dispatchLayoutStep1() {
        int a;
        ViewHolder childViewHolderInt;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        eatRequestLayout();
        this.mViewInfoStore.m2380a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        boolean z = this.mState.mRunSimpleAnimations && this.mItemsChanged;
        state.mTrackOldChangeHolders = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.mo39a();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            a = this.mChildHelper.m1901a();
            for (int i = 0; i < a; i++) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(i));
                if (!childViewHolderInt.m2222b() && (!childViewHolderInt.m2234l() || this.mAdapter.f2349e)) {
                    ItemAnimator.m2050e(childViewHolderInt);
                    childViewHolderInt.m2240r();
                    this.mViewInfoStore.m2382a(childViewHolderInt, ItemAnimator.m2051f().m2048a(childViewHolderInt));
                    if (!(!this.mState.mTrackOldChangeHolders || !childViewHolderInt.m2243u() || childViewHolderInt.m2237o() || childViewHolderInt.m2222b() || childViewHolderInt.m2234l())) {
                        this.mViewInfoStore.m2381a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            boolean z2 = this.mState.mStructureChanged;
            this.mState.mStructureChanged = false;
            this.mLayout.mo639c(this.mRecycler, this.mState);
            this.mState.mStructureChanged = z2;
            for (a = 0; a < this.mChildHelper.m1901a(); a++) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(a));
                if (!childViewHolderInt.m2222b()) {
                    InfoRecord infoRecord = (InfoRecord) this.mViewInfoStore.f2674a.get(childViewHolderInt);
                    int i2 = (infoRecord == null || (infoRecord.f2671a & 4) == 0) ? false : 1;
                    if (i2 == 0) {
                        ItemAnimator.m2050e(childViewHolderInt);
                        boolean b = childViewHolderInt.m2223b(8192);
                        childViewHolderInt.m2240r();
                        ItemHolderInfo a2 = ItemAnimator.m2051f().m2048a(childViewHolderInt);
                        if (b) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt, a2);
                        } else {
                            ViewInfoStore viewInfoStore = this.mViewInfoStore;
                            InfoRecord infoRecord2 = (InfoRecord) viewInfoStore.f2674a.get(childViewHolderInt);
                            if (infoRecord2 == null) {
                                infoRecord2 = InfoRecord.m2371a();
                                viewInfoStore.f2674a.put(childViewHolderInt, infoRecord2);
                            }
                            infoRecord2.f2671a |= 2;
                            infoRecord2.f2672b = a2;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        resumeRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.m10572e();
        this.mState.mItemCount = this.mAdapter.mo39a();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        this.mState.mInPreLayout = false;
        this.mLayout.mo639c(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        this.mPendingSavedState = null;
        State state = this.mState;
        boolean z = this.mState.mRunSimpleAnimations && this.mItemAnimator != null;
        state.mRunSimpleAnimations = z;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        resumeRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.mLayoutStep = 1;
        if (this.mState.mRunSimpleAnimations) {
            for (int a = this.mChildHelper.m1901a() - 1; a >= 0; a--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(a));
                if (!childViewHolderInt.m2222b()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemHolderInfo a2 = ItemAnimator.m2051f().m2048a(childViewHolderInt);
                    ViewHolder viewHolder = (ViewHolder) this.mViewInfoStore.f2675b.m1015a(changedHolderKey);
                    if (!(viewHolder == null || viewHolder.m2222b())) {
                        boolean a3 = this.mViewInfoStore.m2383a(viewHolder);
                        boolean a4 = this.mViewInfoStore.m2383a(childViewHolderInt);
                        if (!(a3 && viewHolder == childViewHolderInt)) {
                            ItemHolderInfo a5 = this.mViewInfoStore.m2379a(viewHolder, 4);
                            this.mViewInfoStore.m2385b(childViewHolderInt, a2);
                            ItemHolderInfo a6 = this.mViewInfoStore.m2379a(childViewHolderInt, 8);
                            if (a5 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, viewHolder);
                            } else {
                                animateChange(viewHolder, childViewHolderInt, a5, a6, a3, a4);
                            }
                        }
                    }
                    this.mViewInfoStore.m2385b(childViewHolderInt, a2);
                }
            }
            ViewInfoStore viewInfoStore = this.mViewInfoStore;
            ProcessCallback processCallback = this.mViewInfoProcessCallback;
            for (int size = viewInfoStore.f2674a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder2 = (ViewHolder) viewInfoStore.f2674a.m1053b(size);
                InfoRecord infoRecord = (InfoRecord) viewInfoStore.f2674a.m1055d(size);
                if ((infoRecord.f2671a & 3) == 3) {
                    processCallback.mo675a(viewHolder2);
                } else if ((infoRecord.f2671a & 1) != 0) {
                    if (infoRecord.f2672b == null) {
                        processCallback.mo675a(viewHolder2);
                    } else {
                        processCallback.mo676a(viewHolder2, infoRecord.f2672b, infoRecord.f2673c);
                    }
                } else if ((infoRecord.f2671a & 14) == 14) {
                    processCallback.mo677b(viewHolder2, infoRecord.f2672b, infoRecord.f2673c);
                } else if ((infoRecord.f2671a & 12) == 12) {
                    processCallback.mo678c(viewHolder2, infoRecord.f2672b, infoRecord.f2673c);
                } else if ((infoRecord.f2671a & 4) != 0) {
                    processCallback.mo676a(viewHolder2, infoRecord.f2672b, null);
                } else if ((infoRecord.f2671a & 8) != 0) {
                    processCallback.mo677b(viewHolder2, infoRecord.f2672b, infoRecord.f2673c);
                } else {
                    int i = infoRecord.f2671a;
                }
                InfoRecord.m2372a(infoRecord);
            }
        }
        this.mLayout.m2120b(this.mRecycler);
        this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mState.mRunSimpleAnimations = false;
        this.mState.mRunPredictiveAnimations = false;
        this.mLayout.f2376u = false;
        if (this.mRecycler.f2393b != null) {
            this.mRecycler.f2393b.clear();
        }
        if (this.mLayout.f2364A) {
            this.mLayout.f2381z = 0;
            this.mLayout.f2364A = false;
            this.mRecycler.m2184b();
        }
        this.mLayout.mo628a(this.mState);
        onExitLayoutOrScroll();
        resumeRequestLayout(false);
        this.mViewInfoStore.m2380a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        StringBuilder stringBuilder;
        int a = this.mChildHelper.m1901a();
        int i = 0;
        while (i < a) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(i));
            if (childViewHolderInt == viewHolder || getChangedHolderKey(childViewHolderInt) != j) {
                i++;
            } else if (this.mAdapter == null || this.mAdapter.f2349e == null) {
                stringBuilder = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                stringBuilder.append(childViewHolderInt);
                stringBuilder.append(" \n View Holder 2:");
                stringBuilder.append(viewHolder);
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                stringBuilder.append(childViewHolderInt);
                stringBuilder.append(" \n View Holder 2:");
                stringBuilder.append(viewHolder);
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        j = TAG;
        stringBuilder = new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        stringBuilder.append(viewHolder2);
        stringBuilder.append(" cannot be found but it is necessary for ");
        stringBuilder.append(viewHolder);
        stringBuilder.append(exceptionLabel());
        Log.e(j, stringBuilder.toString());
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo) {
        viewHolder.m2217a(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.m2243u() && !viewHolder.m2237o() && !viewHolder.m2222b()) {
            this.mViewInfoStore.m2381a(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.m2382a(viewHolder, itemHolderInfo);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int a = this.mChildHelper.m1901a();
        if (a == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < a; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1907b(i3));
            if (!childViewHolderInt.m2222b()) {
                int c = childViewHolderInt.m2224c();
                if (c < i2) {
                    i2 = c;
                }
                if (c > i) {
                    i = c;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mMinMaxLayoutPositions[0] == i) {
            if (this.mMinMaxLayoutPositions[1] == i2) {
                return false;
            }
        }
        return true;
    }

    protected void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.m2238p()) {
                childViewHolderInt.m2233k();
            } else if (!childViewHolderInt.m2222b()) {
                z = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                z.append(childViewHolderInt);
                z.append(exceptionLabel());
                throw new IllegalArgumentException(z.toString());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.f2349e) {
            return viewHolder.f2428g;
        }
        return (long) viewHolder.f2426e;
    }

    void animateAppearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        viewHolder.m2221a(false);
        if (this.mItemAnimator.mo713b(viewHolder, itemHolderInfo, itemHolderInfo2) != null) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.m2221a(false);
        if (this.mItemAnimator.mo711a(viewHolder, itemHolderInfo, itemHolderInfo2) != null) {
            postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.m2221a(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.f2431j = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.m2185b(viewHolder);
            viewHolder2.m2221a(false);
            viewHolder2.f2432k = viewHolder;
        }
        if (this.mItemAnimator.mo712a(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2) != null) {
            postAnimationRunner();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.m975a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.m974a();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mEatRequestLayout != 0 || this.mLayoutFrozen) {
            this.mLayoutRequestEaten = true;
        } else {
            super.requestLayout();
        }
    }

    void markItemDecorInsetsDirty() {
        int i;
        int b = this.mChildHelper.m1906b();
        int i2 = 0;
        for (i = 0; i < b; i++) {
            ((LayoutParams) this.mChildHelper.m1910c(i).getLayoutParams()).f2384e = true;
        }
        Recycler recycler = this.mRecycler;
        i = recycler.f2394c.size();
        while (i2 < i) {
            LayoutParams layoutParams = (LayoutParams) ((ViewHolder) recycler.f2394c.get(i2)).f2424c.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f2384e = true;
            }
            i2++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ((ItemDecoration) this.mItemDecorations.get(i3)).mo483a(canvas, this);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i), 0.0f);
            i = (this.mLeftGlow == null || !this.mLeftGlow.draw(canvas)) ? 0 : 1;
            canvas.restoreToCount(size);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished())) {
            size = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            int i4 = (this.mTopGlow == null || !this.mTopGlow.draw(canvas)) ? 0 : 1;
            i |= i4;
            canvas.restoreToCount(size);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished())) {
            size = canvas.save();
            i4 = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-i4));
            i4 = (this.mRightGlow == null || !this.mRightGlow.draw(canvas)) ? 0 : 1;
            i |= i4;
            canvas.restoreToCount(size);
        }
        if (this.mBottomGlow == null || this.mBottomGlow.isFinished()) {
            i2 = i;
        } else {
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.draw(canvas)) {
                i2 = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (i2 == 0 && this.mItemAnimator != null && this.mItemDecorations.size() > null && this.mItemAnimator.mo3235b() != null) {
            i2 = 1;
        }
        if (i2 != 0) {
            ViewCompat.m1234c(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            ((ItemDecoration) this.mItemDecorations.get(i)).mo614b(canvas, this);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || this.mLayout.mo725a((LayoutParams) layoutParams) == null) ? null : true;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.mo636b();
        }
        StringBuilder stringBuilder = new StringBuilder("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.mo719a(getContext(), attributeSet);
        }
        StringBuilder stringBuilder = new StringBuilder("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.mo720a(layoutParams);
        }
        StringBuilder stringBuilder = new StringBuilder("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean isAnimating() {
        return this.mItemAnimator != null && this.mItemAnimator.mo3235b();
    }

    void saveOldPositions() {
        int b = this.mChildHelper.m1906b();
        for (int i = 0; i < b; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i));
            if (!childViewHolderInt.m2222b() && childViewHolderInt.f2427f == -1) {
                childViewHolderInt.f2427f = childViewHolderInt.f2426e;
            }
        }
    }

    void clearOldPositions() {
        int i;
        int i2;
        int b = this.mChildHelper.m1906b();
        int i3 = 0;
        for (i = 0; i < b; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i));
            if (!childViewHolderInt.m2222b()) {
                childViewHolderInt.m2216a();
            }
        }
        Recycler recycler = this.mRecycler;
        i = recycler.f2394c.size();
        for (i2 = 0; i2 < i; i2++) {
            ((ViewHolder) recycler.f2394c.get(i2)).m2216a();
        }
        i = recycler.f2392a.size();
        for (i2 = 0; i2 < i; i2++) {
            ((ViewHolder) recycler.f2392a.get(i2)).m2216a();
        }
        if (recycler.f2393b != null) {
            i = recycler.f2393b.size();
            while (i3 < i) {
                ((ViewHolder) recycler.f2393b.get(i3)).m2216a();
                i3++;
            }
        }
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int b = this.mChildHelper.m1906b();
        if (i < i2) {
            i3 = i;
            i4 = i2;
            i5 = -1;
        } else {
            i4 = i;
            i3 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < b; i6++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i6));
            if (childViewHolderInt != null && childViewHolderInt.f2426e >= r3 && childViewHolderInt.f2426e <= r4) {
                if (childViewHolderInt.f2426e == i) {
                    childViewHolderInt.m2218a(i2 - i, false);
                } else {
                    childViewHolderInt.m2218a(i5, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        Recycler recycler = this.mRecycler;
        int i7;
        int i8;
        if (i < i2) {
            i7 = i2;
            i3 = -1;
            i8 = i;
        } else {
            i8 = i2;
            i3 = 1;
            i7 = i;
        }
        i4 = recycler.f2394c.size();
        for (i5 = 0; i5 < i4; i5++) {
            ViewHolder viewHolder = (ViewHolder) recycler.f2394c.get(i5);
            if (viewHolder != null && viewHolder.f2426e >= r1 && viewHolder.f2426e <= r2) {
                if (viewHolder.f2426e == i) {
                    viewHolder.m2218a(i2 - i, false);
                } else {
                    viewHolder.m2218a(i3, false);
                }
            }
        }
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int i3;
        int b = this.mChildHelper.m1906b();
        int i4 = 0;
        for (i3 = 0; i3 < b; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.m2222b() || childViewHolderInt.f2426e < i)) {
                childViewHolderInt.m2218a(i2, false);
                this.mState.mStructureChanged = true;
            }
        }
        Recycler recycler = this.mRecycler;
        i3 = recycler.f2394c.size();
        while (i4 < i3) {
            childViewHolderInt = (ViewHolder) recycler.f2394c.get(i4);
            if (childViewHolderInt != null && childViewHolderInt.f2426e >= i) {
                childViewHolderInt.m2218a(i2, true);
            }
            i4++;
        }
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3;
        int i4 = i + i2;
        int b = this.mChildHelper.m1906b();
        for (i3 = 0; i3 < b; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.m2222b())) {
                if (childViewHolderInt.f2426e >= i4) {
                    childViewHolderInt.m2218a(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (childViewHolderInt.f2426e >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    childViewHolderInt.m2225c(8);
                    childViewHolderInt.m2218a(i6, z);
                    childViewHolderInt.f2426e = i5;
                    this.mState.mStructureChanged = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        for (i3 = recycler.f2394c.size() - 1; i3 >= 0; i3--) {
            ViewHolder viewHolder = (ViewHolder) recycler.f2394c.get(i3);
            if (viewHolder != null) {
                if (viewHolder.f2426e >= i4) {
                    viewHolder.m2218a(-i2, z);
                } else if (viewHolder.f2426e >= i) {
                    viewHolder.m2225c(8);
                    recycler.m2188c(i3);
                }
            }
        }
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int b = this.mChildHelper.m1906b();
        i2 += i;
        for (int i3 = 0; i3 < b; i3++) {
            View c = this.mChildHelper.m1910c(i3);
            ViewHolder childViewHolderInt = getChildViewHolderInt(c);
            if (childViewHolderInt != null && !childViewHolderInt.m2222b() && childViewHolderInt.f2426e >= i && childViewHolderInt.f2426e < i2) {
                childViewHolderInt.m2225c(2);
                childViewHolderInt.m2220a(obj);
                ((LayoutParams) c.getLayoutParams()).f2384e = true;
            }
        }
        obj = this.mRecycler;
        for (b = obj.f2394c.size() - 1; b >= 0; b--) {
            ViewHolder viewHolder = (ViewHolder) obj.f2394c.get(b);
            if (viewHolder != null) {
                int i4 = viewHolder.f2426e;
                if (i4 >= i && i4 < i2) {
                    viewHolder.m2225c(2);
                    obj.m2188c(b);
                }
            }
        }
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        if (this.mItemAnimator != null) {
            if (this.mItemAnimator.mo3234a(viewHolder, viewHolder.m2240r()) == null) {
                return null;
            }
        }
        return true;
    }

    void setDataSetChangedAfterLayout() {
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int i;
        int b = this.mChildHelper.m1906b();
        int i2 = 0;
        for (i = 0; i < b; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i));
            if (!(childViewHolderInt == null || childViewHolderInt.m2222b())) {
                childViewHolderInt.m2225c(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler = this.mRecycler;
        i = recycler.f2394c.size();
        while (i2 < i) {
            childViewHolderInt = (ViewHolder) recycler.f2394c.get(i2);
            if (childViewHolderInt != null) {
                childViewHolderInt.m2225c(6);
                childViewHolderInt.m2220a(null);
            }
            i2++;
        }
        if (recycler.f2400i.mAdapter == null || !recycler.f2400i.mAdapter.f2349e) {
            recycler.m2187c();
        }
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.mo632a("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public ViewHolder getChildViewHolder(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        StringBuilder stringBuilder = new StringBuilder("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a direct child of ");
        stringBuilder.append(this);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public View findContainingItemView(View view) {
        View parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        return parent == this ? view : null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        view = findContainingItemView(view);
        if (view == null) {
            return null;
        }
        return getChildViewHolder(view);
    }

    static ViewHolder getChildViewHolderInt(View view) {
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).f2382c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        view = getChildViewHolderInt(view);
        return view != null ? view.m2226d() : -1;
    }

    public int getChildLayoutPosition(View view) {
        view = getChildViewHolderInt(view);
        return view != null ? view.m2224c() : -1;
    }

    public long getChildItemId(View view) {
        if (this.mAdapter != null) {
            if (this.mAdapter.f2349e) {
                view = getChildViewHolderInt(view);
                if (view != null) {
                    return view.f2428g;
                }
                return -1;
            }
        }
        return -1;
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int b = this.mChildHelper.m1906b();
        for (int i2 = 0; i2 < b; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.m2237o() || getAdapterPositionFor(childViewHolderInt) != i)) {
                if (!this.mChildHelper.m1912d(childViewHolderInt.f2424c)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    ViewHolder findViewHolderForPosition(int i, boolean z) {
        int b = this.mChildHelper.m1906b();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < b; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.m2237o())) {
                if (z) {
                    if (childViewHolderInt.f2426e != i) {
                    }
                } else if (childViewHolderInt.m2224c() != i) {
                    continue;
                }
                if (!this.mChildHelper.m1912d(childViewHolderInt.f2424c)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        ViewHolder viewHolder = null;
        if (this.mAdapter != null) {
            if (this.mAdapter.f2349e) {
                int b = this.mChildHelper.m1906b();
                for (int i = 0; i < b; i++) {
                    ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1910c(i));
                    if (!(childViewHolderInt == null || childViewHolderInt.m2237o() || childViewHolderInt.f2428g != j)) {
                        if (!this.mChildHelper.m1912d(childViewHolderInt.f2424c)) {
                            return childViewHolderInt;
                        }
                        viewHolder = childViewHolderInt;
                    }
                }
                return viewHolder;
            }
        }
        return null;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int a = this.mChildHelper.m1901a() - 1; a >= 0; a--) {
            View b = this.mChildHelper.m1907b(a);
            float translationX = b.getTranslationX();
            float translationY = b.getTranslationY();
            if (f >= ((float) b.getLeft()) + translationX && f <= ((float) b.getRight()) + translationX && f2 >= ((float) b.getTop()) + translationY && f2 <= ((float) b.getBottom()) + translationY) {
                return b;
            }
        }
        return 0.0f;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int a = this.mChildHelper.m1901a();
        for (int i2 = 0; i2 < a; i2++) {
            this.mChildHelper.m1907b(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int a = this.mChildHelper.m1901a();
        for (int i2 = 0; i2 < a; i2++) {
            this.mChildHelper.m1907b(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f2383d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, (view.getRight() + rect2.right) + layoutParams.rightMargin, (view.getBottom() + rect2.bottom) + layoutParams.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f2384e) {
            return layoutParams.f2383d;
        }
        if (this.mState.isPreLayout() && (layoutParams.f2382c.m2243u() || layoutParams.f2382c.m2234l())) {
            return layoutParams.f2383d;
        }
        Rect rect = layoutParams.f2383d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((ItemDecoration) this.mItemDecorations.get(i)).mo484a(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.f2384e = false;
        return rect;
    }

    void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.mo616a(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (scrollX = this.mScrollListeners.size() - 1; scrollX >= 0; scrollX--) {
                ((OnScrollListener) this.mScrollListeners.get(scrollX)).mo616a(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo732h(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.mo716a(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.mScrollListeners.get(size)).mo716a(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.m10571d()) {
                return false;
            }
        }
        return true;
    }

    void repositionShadowingViews() {
        int a = this.mChildHelper.m1901a();
        for (int i = 0; i < a; i++) {
            View b = this.mChildHelper.m1907b(i);
            ViewHolder childViewHolder = getChildViewHolder(b);
            if (!(childViewHolder == null || childViewHolder.f2432k == null)) {
                View view = childViewHolder.f2432k.f2424c;
                int left = b.getLeft();
                int top = b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        if (viewHolder.f2425d != null) {
            View view = (View) viewHolder.f2425d.get();
            while (view != null) {
                if (view != viewHolder.f2424c) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.f2425d = null;
        }
    }

    long getNanoTime() {
        return ALLOW_THREAD_GAP_WORK ? System.nanoTime() : 0;
    }

    void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.m2026c(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.mOnChildAttachStateListeners.get(size)).m2162b(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.m2024b(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.mOnChildAttachStateListeners.get(size)).m2161a(view);
            }
        }
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.f2435n = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return null;
        }
        ViewCompat.m1214a(viewHolder.f2424c, i);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.f2424c.getParent() == this && !viewHolder.m2222b()) {
                int i = viewHolder.f2435n;
                if (i != -1) {
                    ViewCompat.m1214a(viewHolder.f2424c, i);
                    viewHolder.f2435n = -1;
                }
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(ViewHolder viewHolder) {
        if (!viewHolder.m2223b(524)) {
            if (viewHolder.m2236n()) {
                AdapterHelper adapterHelper = this.mAdapterHelper;
                viewHolder = viewHolder.f2426e;
                int size = adapterHelper.f11874a.size();
                for (int i = 0; i < size; i++) {
                    UpdateOp updateOp = (UpdateOp) adapterHelper.f11874a.get(i);
                    int i2 = updateOp.f2122a;
                    if (i2 != 8) {
                        switch (i2) {
                            case 1:
                                if (updateOp.f2123b > viewHolder) {
                                    break;
                                }
                                viewHolder += updateOp.f2125d;
                                break;
                            case 2:
                                if (updateOp.f2123b <= viewHolder) {
                                    if (updateOp.f2123b + updateOp.f2125d <= viewHolder) {
                                        viewHolder -= updateOp.f2125d;
                                        break;
                                    }
                                    return -1;
                                }
                                continue;
                            default:
                                break;
                        }
                    } else if (updateOp.f2123b == viewHolder) {
                        viewHolder = updateOp.f2125d;
                    } else {
                        if (updateOp.f2123b < viewHolder) {
                            viewHolder--;
                        }
                        if (updateOp.f2125d <= viewHolder) {
                            viewHolder++;
                        }
                    }
                }
                return viewHolder;
            }
        }
        return -1;
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (!(stateListDrawable == null || drawable == null || stateListDrawable2 == null)) {
            if (drawable2 != null) {
                Resources resources = getContext().getResources();
                FastScroller fastScroller = new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0182R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(C0182R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0182R.dimen.fastscroll_margin));
                return;
            }
        }
        drawable = new StringBuilder("Trying to set fast scroller without both required drawables.");
        drawable.append(exceptionLabel());
        throw new IllegalArgumentException(drawable.toString());
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m1124a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1442a;
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m1128a(i, 0);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().m1128a(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m1133b(0);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().m1133b(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m1127a(0);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().m1127a(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m1129a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m1130a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m1131a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m1132a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m1126a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m1125a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.mChildDrawingOrderCallback.m2046a();
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }
}
