package android.support.v4.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new C01281();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C01292();
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new C01303(this);
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static class C01281 implements Comparator<ItemInfo> {
        C01281() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ItemInfo) obj).f1467b - ((ItemInfo) obj2).f1467b;
        }
    }

    static class C01292 implements Interpolator {
        public final float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C01292() {
        }
    }

    class C01303 implements Runnable {
        final /* synthetic */ ViewPager f1465a;

        C01303(ViewPager viewPager) {
            this.f1465a = viewPager;
        }

        public void run() {
            this.f1465a.setScrollState(0);
            this.f1465a.populate();
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {
        Object f1466a;
        int f1467b;
        boolean f1468c;
        float f1469d;
        float f1470e;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f1471a;
        public int f1472b;
        float f1473c = 0.0f;
        boolean f1474d;
        int f1475e;
        int f1476f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f1472b = context.getInteger(null, 48);
            context.recycle();
        }
    }

    public interface OnAdapterChangeListener {
        void mo117a(ViewPager viewPager, PagerAdapter pagerAdapter);
    }

    public interface OnPageChangeListener {
        void mo118a(int i);

        void mo119a(int i, float f);

        void mo120b(int i);
    }

    public interface PageTransformer {
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager f1477a;

        PagerObserver(ViewPager viewPager) {
            this.f1477a = viewPager;
        }

        public void onChanged() {
            this.f1477a.dataSetChanged();
        }

        public void onInvalidated() {
            this.f1477a.dataSetChanged();
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f1471a != layoutParams2.f1471a) {
                return layoutParams.f1471a != null ? 1 : -1;
            } else {
                return layoutParams.f1475e - layoutParams2.f1475e;
            }
        }
    }

    class C10094 implements OnApplyWindowInsetsListener {
        final /* synthetic */ ViewPager f11473a;
        private final Rect f11474b = new Rect();

        C10094(ViewPager viewPager) {
            this.f11473a = viewPager;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat a = ViewCompat.m1212a(view, windowInsetsCompat);
            if (a.m1312e() != null) {
                return a;
            }
            windowInsetsCompat = this.f11474b;
            windowInsetsCompat.left = a.m1307a();
            windowInsetsCompat.top = a.m1309b();
            windowInsetsCompat.right = a.m1310c();
            windowInsetsCompat.bottom = a.m1311d();
            int childCount = this.f11473a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat b = ViewCompat.m1229b(this.f11473a.getChildAt(i), a);
                windowInsetsCompat.left = Math.min(b.m1307a(), windowInsetsCompat.left);
                windowInsetsCompat.top = Math.min(b.m1309b(), windowInsetsCompat.top);
                windowInsetsCompat.right = Math.min(b.m1310c(), windowInsetsCompat.right);
                windowInsetsCompat.bottom = Math.min(b.m1311d(), windowInsetsCompat.bottom);
            }
            return a.m1308a(windowInsetsCompat.left, windowInsetsCompat.top, windowInsetsCompat.right, windowInsetsCompat.bottom);
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager f11475a;

        MyAccessibilityDelegate(ViewPager viewPager) {
            this.f11475a = viewPager;
        }

        public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo84a(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m10158a());
            if (accessibilityEvent.getEventType() == 4096 && this.f11475a.mAdapter != null) {
                accessibilityEvent.setItemCount(this.f11475a.mAdapter.mo3684c());
                accessibilityEvent.setFromIndex(this.f11475a.mCurItem);
                accessibilityEvent.setToIndex(this.f11475a.mCurItem);
            }
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m1324a(ViewPager.class.getName());
            accessibilityNodeInfoCompat.m1334d(m10158a());
            if (this.f11475a.canScrollHorizontally(1) != null) {
                accessibilityNodeInfoCompat.m1321a(4096);
            }
            if (this.f11475a.canScrollHorizontally(-1) != null) {
                accessibilityNodeInfoCompat.m1321a(8192);
            }
        }

        public final boolean mo82a(View view, int i, Bundle bundle) {
            if (super.mo82a(view, i, bundle) != null) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || this.f11475a.canScrollHorizontally(-1) == null) {
                    return false;
                }
                this.f11475a.setCurrentItem(this.f11475a.mCurItem - 1);
                return true;
            } else if (this.f11475a.canScrollHorizontally(1) == null) {
                return false;
            } else {
                this.f11475a.setCurrentItem(this.f11475a.mCurItem + 1);
                return true;
            }
        }

        private boolean m10158a() {
            return this.f11475a.mAdapter != null && this.f11475a.mAdapter.mo3684c() > 1;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C01311();
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static class C01311 implements ClassLoaderCreator<SavedState> {
            C01311() {
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.position);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void mo118a(int i) {
        }

        public final void mo119a(int i, float f) {
        }

        public void mo120b(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        ViewCompat.m1220a((View) this, new MyAccessibilityDelegate(this));
        if (ViewCompat.m1237d(this) == 0) {
            ViewCompat.m1214a((View) this, 1);
        }
        ViewCompat.m1221a((View) this, new C10094(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        int i;
        int i2 = 0;
        if (this.mAdapter != null) {
            this.mAdapter.m1137a(null);
            this.mAdapter.mo234a((ViewGroup) this);
            for (i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
                this.mAdapter.mo235a(this, itemInfo.f1467b, itemInfo.f1466a);
            }
            this.mAdapter.mo232a();
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver(this);
            }
            this.mAdapter.m1137a(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.mo3684c();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.mo233a(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            i = this.mAdapterChangeListeners.size();
            while (i2 < i) {
                ((OnAdapterChangeListener) this.mAdapterChangeListeners.get(i2)).mo117a(this, pagerAdapter);
                i2++;
            }
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f1471a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(onAdapterChangeListener);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, this.mFirstLayout ^ 1, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (this.mAdapter != null) {
            if (this.mAdapter.mo3684c() > 0) {
                if (!z2 && this.mCurItem == i && this.mItems.size()) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                z2 = true;
                if (i < 0) {
                    i = 0;
                } else if (i >= this.mAdapter.mo3684c()) {
                    i = this.mAdapter.mo3684c() - 1;
                }
                int i3 = this.mOffscreenPageLimit;
                if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                    for (i3 = 0; i3 < this.mItems.size(); i3++) {
                        ((ItemInfo) this.mItems.get(i3)).f1468c = true;
                    }
                }
                if (this.mCurItem == i) {
                    z2 = false;
                }
                if (this.mFirstLayout) {
                    this.mCurItem = i;
                    if (z2) {
                        dispatchOnPageSelected(i);
                    }
                    requestLayout();
                    return;
                }
                populate(i);
                scrollToItem(i, z, i2, z2);
                return;
            }
        }
        setScrollingCacheEnabled(false);
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        ItemInfo infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f1470e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(onPageChangeListener);
        }
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i) {
        int i2 = 1;
        boolean z2 = pageTransformer != null;
        int i3 = z2 != (this.mPageTransformer != null) ? 1 : 0;
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (i3 != 0) {
            populate();
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).f1476f;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("Requested offscreen page limit ");
            stringBuilder.append(i);
            stringBuilder.append(" too small; defaulting to 1");
            Log.w(str, stringBuilder.toString());
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.m714a(getContext(), i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.mMarginDrawable) {
                return null;
            }
        }
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int currX;
        boolean z = (this.mScroller == null || this.mScroller.isFinished()) ? false : true;
        if (z) {
            currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            currX = getScrollX();
        }
        int i4 = currX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        i = getClientWidth();
        i2 = i / 2;
        i = (float) i;
        i2 = (float) i2;
        i2 += distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / i)) * i2;
        i3 = Math.abs(i3);
        if (i3 > 0) {
            i = 4 * Math.round(1000.0f * Math.abs(i2 / ((float) i3)));
        } else {
            i = (int) (((((float) Math.abs(i5)) / ((i * 1065353216) + ((float) this.mPageMargin))) + 1065353216) * 1120403456);
        }
        int min = Math.min(i, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, min);
        ViewCompat.m1234c(this);
    }

    ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f1467b = i;
        itemInfo.f1466a = this.mAdapter.mo231a((ViewGroup) this, i);
        itemInfo.f1469d = 1065353216;
        if (i2 >= 0) {
            if (i2 < this.mItems.size()) {
                this.mItems.add(i2, itemInfo);
                return itemInfo;
            }
        }
        this.mItems.add(itemInfo);
        return itemInfo;
    }

    void dataSetChanged() {
        int i;
        int c = this.mAdapter.mo3684c();
        this.mExpectedAdapterCount = c;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < c;
        int i2 = this.mCurItem;
        for (i = 0; i < this.mItems.size(); i++) {
            this.mItems.get(i);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            c = getChildCount();
            for (i = 0; i < c; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                if (!layoutParams.f1471a) {
                    layoutParams.f1473c = 0.0f;
                }
            }
            setCurrentItemInternal(i2, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    public void populate(int r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r18 = this;
        r0 = r18;
        r1 = r19;
        r2 = r0.mCurItem;
        if (r2 == r1) goto L_0x0011;
    L_0x0008:
        r2 = r0.mCurItem;
        r2 = r0.infoForPosition(r2);
        r0.mCurItem = r1;
        goto L_0x0012;
    L_0x0011:
        r2 = 0;
    L_0x0012:
        r1 = r0.mAdapter;
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r18.sortChildDrawingOrder();
        return;
    L_0x001a:
        r1 = r0.mPopulatePending;
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r18.sortChildDrawingOrder();
        return;
    L_0x0022:
        r1 = r18.getWindowToken();
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return;
    L_0x0029:
        r1 = r0.mAdapter;
        r1.mo234a(r0);
        r1 = r0.mOffscreenPageLimit;
        r4 = r0.mCurItem;
        r4 = r4 - r1;
        r5 = 0;
        r4 = java.lang.Math.max(r5, r4);
        r6 = r0.mAdapter;
        r6 = r6.mo3684c();
        r7 = r6 + -1;
        r8 = r0.mCurItem;
        r8 = r8 + r1;
        r1 = java.lang.Math.min(r7, r8);
        r7 = r0.mExpectedAdapterCount;
        if (r6 == r7) goto L_0x00a0;
    L_0x004b:
        r1 = r18.getResources();	 Catch:{ NotFoundException -> 0x0058 }
        r2 = r18.getId();	 Catch:{ NotFoundException -> 0x0058 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0058 }
        goto L_0x0060;
    L_0x0058:
        r1 = r18.getId();
        r1 = java.lang.Integer.toHexString(r1);
    L_0x0060:
        r2 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r3.<init>(r4);
        r4 = r0.mExpectedAdapterCount;
        r3.append(r4);
        r4 = ", found: ";
        r3.append(r4);
        r3.append(r6);
        r4 = " Pager id: ";
        r3.append(r4);
        r3.append(r1);
        r1 = " Pager class: ";
        r3.append(r1);
        r1 = r18.getClass();
        r3.append(r1);
        r1 = " Problematic adapter: ";
        r3.append(r1);
        r1 = r0.mAdapter;
        r1 = r1.getClass();
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1);
        throw r2;
    L_0x00a0:
        r7 = r5;
    L_0x00a1:
        r8 = r0.mItems;
        r8 = r8.size();
        if (r7 >= r8) goto L_0x00c1;
    L_0x00a9:
        r8 = r0.mItems;
        r8 = r8.get(r7);
        r8 = (android.support.v4.view.ViewPager.ItemInfo) r8;
        r9 = r8.f1467b;
        r10 = r0.mCurItem;
        if (r9 < r10) goto L_0x00be;
    L_0x00b7:
        r9 = r8.f1467b;
        r10 = r0.mCurItem;
        if (r9 != r10) goto L_0x00c1;
    L_0x00bd:
        goto L_0x00c2;
    L_0x00be:
        r7 = r7 + 1;
        goto L_0x00a1;
    L_0x00c1:
        r8 = 0;
    L_0x00c2:
        if (r8 != 0) goto L_0x00cc;
    L_0x00c4:
        if (r6 <= 0) goto L_0x00cc;
    L_0x00c6:
        r8 = r0.mCurItem;
        r8 = r0.addNewItem(r8, r7);
    L_0x00cc:
        r9 = 0;
        if (r8 == 0) goto L_0x01ee;
    L_0x00cf:
        r10 = r7 + -1;
        if (r10 < 0) goto L_0x00dc;
    L_0x00d3:
        r11 = r0.mItems;
        r11 = r11.get(r10);
        r11 = (android.support.v4.view.ViewPager.ItemInfo) r11;
        goto L_0x00dd;
    L_0x00dc:
        r11 = 0;
    L_0x00dd:
        r12 = r18.getClientWidth();
        r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 > 0) goto L_0x00e7;
    L_0x00e5:
        r3 = r9;
        goto L_0x00f4;
    L_0x00e7:
        r14 = r8.f1469d;
        r14 = r13 - r14;
        r15 = r18.getPaddingLeft();
        r15 = (float) r15;
        r3 = (float) r12;
        r15 = r15 / r3;
        r3 = r14 + r15;
    L_0x00f4:
        r14 = r0.mCurItem;
        r14 = r14 + -1;
        r15 = r10;
        r10 = r7;
        r7 = r9;
    L_0x00fb:
        if (r14 < 0) goto L_0x015a;
    L_0x00fd:
        r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r16 < 0) goto L_0x0128;
    L_0x0101:
        if (r14 >= r4) goto L_0x0128;
    L_0x0103:
        if (r11 == 0) goto L_0x015a;
    L_0x0105:
        r5 = r11.f1467b;
        if (r14 != r5) goto L_0x0156;
    L_0x0109:
        r5 = r11.f1468c;
        if (r5 != 0) goto L_0x0156;
    L_0x010d:
        r5 = r0.mItems;
        r5.remove(r15);
        r5 = r0.mAdapter;
        r11 = r11.f1466a;
        r5.mo235a(r0, r14, r11);
        r15 = r15 + -1;
        r10 = r10 + -1;
        if (r15 < 0) goto L_0x0154;
    L_0x011f:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x0128:
        if (r11 == 0) goto L_0x013e;
    L_0x012a:
        r5 = r11.f1467b;
        if (r14 != r5) goto L_0x013e;
    L_0x012e:
        r5 = r11.f1469d;
        r7 = r7 + r5;
        r15 = r15 + -1;
        if (r15 < 0) goto L_0x0154;
    L_0x0135:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x013e:
        r5 = r15 + 1;
        r5 = r0.addNewItem(r14, r5);
        r5 = r5.f1469d;
        r7 = r7 + r5;
        r10 = r10 + 1;
        if (r15 < 0) goto L_0x0154;
    L_0x014b:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x0154:
        r5 = 0;
    L_0x0155:
        r11 = r5;
    L_0x0156:
        r14 = r14 + -1;
        r5 = 0;
        goto L_0x00fb;
    L_0x015a:
        r3 = r8.f1469d;
        r4 = r10 + 1;
        r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r5 >= 0) goto L_0x01eb;
    L_0x0162:
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x0173;
    L_0x016a:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0174;
    L_0x0173:
        r5 = 0;
    L_0x0174:
        if (r12 > 0) goto L_0x0178;
    L_0x0176:
        r7 = r9;
        goto L_0x0180;
    L_0x0178:
        r7 = r18.getPaddingRight();
        r7 = (float) r7;
        r11 = (float) r12;
        r7 = r7 / r11;
        r7 = r7 + r13;
    L_0x0180:
        r11 = r0.mCurItem;
    L_0x0182:
        r11 = r11 + 1;
        if (r11 >= r6) goto L_0x01eb;
    L_0x0186:
        r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r12 < 0) goto L_0x01b5;
    L_0x018a:
        if (r11 <= r1) goto L_0x01b5;
    L_0x018c:
        if (r5 == 0) goto L_0x01eb;
    L_0x018e:
        r12 = r5.f1467b;
        if (r11 != r12) goto L_0x01ea;
    L_0x0192:
        r12 = r5.f1468c;
        if (r12 != 0) goto L_0x01ea;
    L_0x0196:
        r12 = r0.mItems;
        r12.remove(r4);
        r12 = r0.mAdapter;
        r5 = r5.f1466a;
        r12.mo235a(r0, r11, r5);
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01aa:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x01ea;
    L_0x01b3:
        r5 = 0;
        goto L_0x01ea;
    L_0x01b5:
        if (r5 == 0) goto L_0x01d1;
    L_0x01b7:
        r12 = r5.f1467b;
        if (r11 != r12) goto L_0x01d1;
    L_0x01bb:
        r5 = r5.f1469d;
        r3 = r3 + r5;
        r4 = r4 + 1;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01c8:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x01ea;
    L_0x01d1:
        r5 = r0.addNewItem(r11, r4);
        r4 = r4 + 1;
        r5 = r5.f1469d;
        r3 = r3 + r5;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01e2:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
    L_0x01ea:
        goto L_0x0182;
    L_0x01eb:
        r0.calculatePageOffsets(r8, r10, r2);
    L_0x01ee:
        r1 = r0.mAdapter;
        if (r8 == 0) goto L_0x01f5;
    L_0x01f2:
        r3 = r8.f1466a;
        goto L_0x01f6;
    L_0x01f5:
        r3 = 0;
    L_0x01f6:
        r1.mo236a(r3);
        r1 = r0.mAdapter;
        r1.mo232a();
        r1 = r18.getChildCount();
        r2 = 0;
    L_0x0203:
        if (r2 >= r1) goto L_0x022c;
    L_0x0205:
        r3 = r0.getChildAt(r2);
        r4 = r3.getLayoutParams();
        r4 = (android.support.v4.view.ViewPager.LayoutParams) r4;
        r4.f1476f = r2;
        r5 = r4.f1471a;
        if (r5 != 0) goto L_0x0229;
    L_0x0215:
        r5 = r4.f1473c;
        r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x0229;
    L_0x021b:
        r3 = r0.infoForChild(r3);
        if (r3 == 0) goto L_0x0229;
    L_0x0221:
        r5 = r3.f1469d;
        r4.f1473c = r5;
        r3 = r3.f1467b;
        r4.f1475e = r3;
    L_0x0229:
        r2 = r2 + 1;
        goto L_0x0203;
    L_0x022c:
        r18.sortChildDrawingOrder();
        r1 = r18.hasFocus();
        if (r1 == 0) goto L_0x026a;
    L_0x0235:
        r1 = r18.findFocus();
        if (r1 == 0) goto L_0x0240;
    L_0x023b:
        r3 = r0.infoForAnyChild(r1);
        goto L_0x0241;
    L_0x0240:
        r3 = 0;
    L_0x0241:
        if (r3 == 0) goto L_0x0249;
    L_0x0243:
        r1 = r3.f1467b;
        r2 = r0.mCurItem;
        if (r1 == r2) goto L_0x026a;
    L_0x0249:
        r1 = 0;
    L_0x024a:
        r2 = r18.getChildCount();
        if (r1 >= r2) goto L_0x026a;
    L_0x0250:
        r2 = r0.getChildAt(r1);
        r3 = r0.infoForChild(r2);
        if (r3 == 0) goto L_0x0267;
    L_0x025a:
        r3 = r3.f1467b;
        r4 = r0.mCurItem;
        if (r3 != r4) goto L_0x0267;
    L_0x0260:
        r3 = 2;
        r2 = r2.requestFocus(r3);
        if (r2 != 0) goto L_0x026a;
    L_0x0267:
        r1 = r1 + 1;
        goto L_0x024a;
    L_0x026a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        int size;
        int c = this.mAdapter.mo3684c();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i2 = itemInfo2.f1467b;
            ItemInfo itemInfo3;
            if (i2 < itemInfo.f1467b) {
                float f2 = (itemInfo2.f1470e + itemInfo2.f1469d) + f;
                i2++;
                itemInfo2 = null;
                while (i2 <= itemInfo.f1467b && itemInfo2 < this.mItems.size()) {
                    itemInfo3 = (ItemInfo) this.mItems.get(itemInfo2);
                    while (i2 > itemInfo3.f1467b && itemInfo2 < this.mItems.size() - 1) {
                        itemInfo2++;
                        itemInfo3 = (ItemInfo) this.mItems.get(itemInfo2);
                    }
                    while (i2 < itemInfo3.f1467b) {
                        f2 += 1.0f + f;
                        i2++;
                    }
                    itemInfo3.f1470e = f2;
                    f2 += itemInfo3.f1469d + f;
                    i2++;
                }
            } else if (i2 > itemInfo.f1467b) {
                size = this.mItems.size() - 1;
                itemInfo2 = itemInfo2.f1470e;
                i2--;
                while (i2 >= itemInfo.f1467b && size >= 0) {
                    itemInfo3 = (ItemInfo) this.mItems.get(size);
                    while (i2 < itemInfo3.f1467b && size > 0) {
                        size--;
                        itemInfo3 = (ItemInfo) this.mItems.get(size);
                    }
                    while (i2 > itemInfo3.f1467b) {
                        itemInfo2 -= 1.0f + f;
                        i2--;
                    }
                    itemInfo2 -= itemInfo3.f1469d + f;
                    itemInfo3.f1470e = itemInfo2;
                    i2--;
                }
            }
        }
        itemInfo2 = this.mItems.size();
        float f3 = itemInfo.f1470e;
        size = itemInfo.f1467b - 1;
        this.mFirstOffset = itemInfo.f1467b == 0 ? itemInfo.f1470e : -3.4028235E38f;
        c--;
        this.mLastOffset = itemInfo.f1467b == c ? (itemInfo.f1470e + itemInfo.f1469d) - 1.0f : Float.MAX_VALUE;
        int i3 = i - 1;
        while (i3 >= 0) {
            ItemInfo itemInfo4 = (ItemInfo) this.mItems.get(i3);
            while (size > itemInfo4.f1467b) {
                size--;
                f3 -= 1.0f + f;
            }
            f3 -= itemInfo4.f1469d + f;
            itemInfo4.f1470e = f3;
            if (itemInfo4.f1467b == 0) {
                this.mFirstOffset = f3;
            }
            i3--;
            size--;
        }
        f3 = (itemInfo.f1470e + itemInfo.f1469d) + f;
        itemInfo = itemInfo.f1467b + 1;
        i++;
        while (i < itemInfo2) {
            ItemInfo itemInfo5 = (ItemInfo) this.mItems.get(i);
            while (itemInfo < itemInfo5.f1467b) {
                itemInfo++;
                f3 += 1.0f + f;
            }
            if (itemInfo5.f1467b == c) {
                this.mLastOffset = (itemInfo5.f1469d + f3) - 1.0f;
            }
            itemInfo5.f1470e = f3;
            f3 += itemInfo5.f1469d + f;
            i++;
            itemInfo++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.mo238b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.mo233a(savedState.adapterState, savedState.loader);
                setCurrentItemInternal(savedState.position, false, true);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f1471a |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.f1471a) {
            layoutParams2.f1474d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null ? true : null;
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (this.mAdapter.mo237a(view, itemInfo.f1466a)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            View parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null) {
                break;
            } else if ((parent instanceof View) == null) {
                break;
            } else {
                view = parent;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            if (itemInfo.f1467b == i) {
                return itemInfo;
            }
        }
        return 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        measuredWidth = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = measuredHeight;
        measuredHeight = measuredWidth;
        measuredWidth = 0;
        while (true) {
            boolean z2 = true;
            int i5 = 1073741824;
            if (measuredWidth >= childCount) {
                break;
            }
            View childAt = getChildAt(measuredWidth);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f1471a) {
                    int i6;
                    int i7;
                    int i8 = layoutParams.f1472b & 7;
                    int i9 = layoutParams.f1472b & 112;
                    if (i9 != 48) {
                        if (i9 != 80) {
                            i9 = z;
                            if (i8 != 3) {
                                if (i8 == 5) {
                                    z2 = z;
                                }
                            }
                            i8 = Integer.MIN_VALUE;
                            if (i9 != 0) {
                                i6 = Integer.MIN_VALUE;
                                i8 = 1073741824;
                            } else {
                                i6 = z2 ? 1073741824 : Integer.MIN_VALUE;
                            }
                            if (layoutParams.width == -2) {
                                i7 = layoutParams.width == -1 ? layoutParams.width : measuredHeight;
                                i8 = 1073741824;
                            } else {
                                i7 = measuredHeight;
                            }
                            if (layoutParams.height == -2) {
                                i3 = layoutParams.height == -1 ? layoutParams.height : i4;
                            } else {
                                i3 = i4;
                                i5 = i6;
                            }
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                            if (i9 != 0) {
                                i4 -= childAt.getMeasuredHeight();
                            } else if (z2) {
                                measuredHeight -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    i9 = true;
                    if (i8 != 3) {
                        if (i8 == 5) {
                            z2 = z;
                        }
                    }
                    i8 = Integer.MIN_VALUE;
                    if (i9 != 0) {
                        i6 = Integer.MIN_VALUE;
                        i8 = 1073741824;
                    } else if (z2) {
                    }
                    if (layoutParams.width == -2) {
                        i7 = measuredHeight;
                    } else {
                        if (layoutParams.width == -1) {
                        }
                        i8 = 1073741824;
                    }
                    if (layoutParams.height == -2) {
                        i3 = i4;
                        i5 = i6;
                    } else if (layoutParams.height == -1) {
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                    if (i9 != 0) {
                        i4 -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        measuredHeight -= childAt.getMeasuredWidth();
                    }
                }
            }
            measuredWidth++;
            z = false;
        }
        r0.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        r0.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        r0.mInLayout = true;
        populate();
        i3 = 0;
        r0.mInLayout = false;
        measuredWidth = getChildCount();
        while (i3 < measuredWidth) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2 == null || !layoutParams2.f1471a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) measuredHeight) * layoutParams2.f1473c), 1073741824), r0.mChildHeightMeasureSpec);
                }
            }
            i3++;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            i2 = infoForPosition(this.mCurItem);
            i = (int) ((i2 != 0 ? Math.min(i2.f1470e, this.mLastOffset) : 0) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (i != getScrollX()) {
                completeScroll(0);
                scrollTo(i, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ViewPager viewPager = this;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        paddingBottom = paddingTop;
        paddingTop = paddingLeft;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt = getChildAt(paddingLeft);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1471a) {
                    int i9 = layoutParams.f1472b & 7;
                    int i10 = layoutParams.f1472b & 112;
                    if (i9 == 1) {
                        i9 = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingTop);
                    } else if (i9 == 3) {
                        i9 = paddingTop;
                        paddingTop = childAt.getMeasuredWidth() + paddingTop;
                    } else if (i9 != 5) {
                        i9 = paddingTop;
                    } else {
                        i9 = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i10 == 16) {
                        i10 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingBottom);
                    } else if (i10 == 48) {
                        i10 = paddingBottom;
                        paddingBottom = childAt.getMeasuredHeight() + paddingBottom;
                    } else if (i10 != 80) {
                        i10 = paddingBottom;
                    } else {
                        i10 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    i9 += scrollX;
                    childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9, i10 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        i5 = (i5 - paddingTop) - paddingRight;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt2 = getChildAt(paddingLeft);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f1471a) {
                    ItemInfo infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        float f = (float) i5;
                        int i11 = ((int) (infoForChild.f1470e * f)) + paddingTop;
                        if (layoutParams2.f1474d) {
                            layoutParams2.f1474d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f1473c), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingBottom) - i7, 1073741824));
                        }
                        childAt2.layout(i11, paddingBottom, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + paddingBottom);
                    }
                }
            }
        }
        viewPager.mTopPageBounds = paddingBottom;
        viewPager.mBottomPageBounds = i6 - i7;
        viewPager.mDecorChildCount = i8;
        if (viewPager.mFirstLayout) {
            z2 = false;
            scrollToItem(viewPager.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        viewPager.mFirstLayout = z2;
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.m1234c(this);
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = (float) clientWidth;
            float f2 = ((float) this.mPageMargin) / f;
            int i3 = infoForCurrentScrollPosition.f1467b;
            i = ((((float) i) / f) - infoForCurrentScrollPosition.f1470e) / (infoForCurrentScrollPosition.f1469d + f2);
            int i4 = (int) (((float) i2) * i);
            this.mCalledSuper = false;
            onPageScrolled(i3, i, i4);
            if (this.mCalledSuper != 0) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout != 0) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0, 0);
            if (this.mCalledSuper != 0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        int i3 = 0;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i4 = paddingRight;
            paddingRight = paddingLeft;
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                View childAt = getChildAt(paddingLeft);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1471a) {
                    int i5 = layoutParams.f1472b & 7;
                    if (i5 != 1) {
                        if (i5 == 3) {
                            i5 = childAt.getWidth() + paddingRight;
                        } else if (i5 != 5) {
                            i5 = paddingRight;
                        } else {
                            i5 = (width - i4) - childAt.getMeasuredWidth();
                            i4 += childAt.getMeasuredWidth();
                        }
                        paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                        if (paddingRight != 0) {
                            childAt.offsetLeftAndRight(paddingRight);
                        }
                        paddingRight = i5;
                    } else {
                        i5 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingRight);
                    }
                    int i6 = i5;
                    i5 = paddingRight;
                    paddingRight = i6;
                    paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                    if (paddingRight != 0) {
                        childAt.offsetLeftAndRight(paddingRight);
                    }
                    paddingRight = i5;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != 0) {
            getScrollX();
            i = getChildCount();
            while (i3 < i) {
                f = getChildAt(i3);
                if (((LayoutParams) f.getLayoutParams()).f1471a == 0) {
                    f.getLeft();
                    getClientWidth();
                }
                i3++;
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != 0) {
            this.mOnPageChangeListener.mo119a(i, f);
        }
        if (this.mOnPageChangeListeners != 0) {
            int size = this.mOnPageChangeListeners.size();
            for (i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo119a(i, f);
                }
            }
        }
        if (this.mInternalPageChangeListener != 0) {
            this.mInternalPageChangeListener.mo119a(i, f);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.mo120b(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo120b(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.mo120b(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.mo118a(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo118a(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.mo118a(i);
        }
    }

    private void completeScroll(boolean z) {
        int scrollX;
        int i = this.mScrollState == 2 ? 1 : false;
        if (i != 0) {
            setScrollingCacheEnabled(false);
            if ((this.mScroller.isFinished() ^ 1) != 0) {
                this.mScroller.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        scrollX = i;
        for (i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (itemInfo.f1468c) {
                itemInfo.f1468c = false;
                scrollX = 1;
            }
        }
        if (scrollX != 0) {
            if (z) {
                ViewCompat.m1224a((View) this, this.mEndScrollRunnable);
                return;
            }
            this.mEndScrollRunnable.run();
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view = this;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            if (action != 1) {
                if (action != 0) {
                    if (view.mIsBeingDragged) {
                        return true;
                    }
                    if (view.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (action == 0) {
                    float x = motionEvent.getX();
                    view.mInitialMotionX = x;
                    view.mLastMotionX = x;
                    x = motionEvent.getY();
                    view.mInitialMotionY = x;
                    view.mLastMotionY = x;
                    view.mActivePointerId = motionEvent2.getPointerId(0);
                    view.mIsUnableToDrag = false;
                    view.mIsScrollStarted = true;
                    view.mScroller.computeScrollOffset();
                    if (view.mScrollState != 2 || Math.abs(view.mScroller.getFinalX() - view.mScroller.getCurrX()) <= view.mCloseEnough) {
                        completeScroll(false);
                        view.mIsBeingDragged = false;
                    } else {
                        view.mScroller.abortAnimation();
                        view.mPopulatePending = false;
                        populate();
                        view.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                } else if (action == 2) {
                    action = view.mActivePointerId;
                    if (action != -1) {
                        action = motionEvent2.findPointerIndex(action);
                        float x2 = motionEvent2.getX(action);
                        float f = x2 - view.mLastMotionX;
                        float abs = Math.abs(f);
                        float y = motionEvent2.getY(action);
                        float abs2 = Math.abs(y - view.mInitialMotionY);
                        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                        if (i == 0 || isGutterDrag(view.mLastMotionX, f) || !canScroll(view, false, (int) f, (int) x2, (int) y)) {
                            if (abs > ((float) view.mTouchSlop) && abs * 0.5f > abs2) {
                                view.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                view.mLastMotionX = i > 0 ? view.mInitialMotionX + ((float) view.mTouchSlop) : view.mInitialMotionX - ((float) view.mTouchSlop);
                                view.mLastMotionY = y;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) view.mTouchSlop)) {
                                view.mIsUnableToDrag = true;
                            }
                            if (view.mIsBeingDragged && performDrag(x2)) {
                                ViewCompat.m1234c(view);
                            }
                        } else {
                            view.mLastMotionX = x2;
                            view.mLastMotionY = y;
                            view.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
                if (view.mVelocityTracker == null) {
                    view.mVelocityTracker = VelocityTracker.obtain();
                }
                view.mVelocityTracker.addMovement(motionEvent2);
                return view.mIsBeingDragged;
            }
        }
        resetTouch();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && this.mAdapter != null) {
            if (this.mAdapter.mo3684c() != 0) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                float x;
                int xVelocity;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        x = motionEvent.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        x = motionEvent.getY();
                        this.mInitialMotionY = x;
                        this.mLastMotionY = x;
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        break;
                    case 1:
                        if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                            this.mPopulatePending = true;
                            int clientWidth = getClientWidth();
                            int scrollX = getScrollX();
                            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                            float f = (float) clientWidth;
                            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f1467b, ((((float) scrollX) / f) - infoForCurrentScrollPosition.f1470e) / (infoForCurrentScrollPosition.f1469d + (((float) this.mPageMargin) / f)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 2:
                        if (!this.mIsBeingDragged) {
                            xVelocity = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (xVelocity == -1) {
                                z = resetTouch();
                                break;
                            }
                            float x2 = motionEvent.getX(xVelocity);
                            float abs = Math.abs(x2 - this.mLastMotionX);
                            x = motionEvent.getY(xVelocity);
                            float abs2 = Math.abs(x - this.mLastMotionY);
                            if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                this.mLastMotionX = x2 - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                                this.mLastMotionY = x;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                            break;
                        }
                        break;
                    case 3:
                        if (this.mIsBeingDragged != null) {
                            scrollToItem(this.mCurItem, true, 0, false);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 5:
                        xVelocity = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(xVelocity);
                        this.mActivePointerId = motionEvent.getPointerId(xVelocity);
                        break;
                    case 6:
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                        break;
                    default:
                        break;
                }
                if (z) {
                    ViewCompat.m1234c(this);
                }
                return true;
            }
        }
        return false;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (!this.mLeftEdge.isFinished()) {
            if (!this.mRightEdge.isFinished()) {
                return false;
            }
        }
        return true;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        f = ((float) getScrollX()) + f2;
        f2 = (float) getClientWidth();
        float f3 = this.mFirstOffset * f2;
        float f4 = this.mLastOffset * f2;
        boolean z3 = false;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
        if (itemInfo.f1467b != 0) {
            f3 = itemInfo.f1470e * f2;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f1467b != this.mAdapter.mo3684c() - 1) {
            f4 = itemInfo2.f1470e * f2;
            z2 = false;
        } else {
            z2 = true;
        }
        if (f < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - f) / f2);
                z3 = true;
            }
            f = f3;
        } else if (f > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(f - f4) / f2);
                z3 = true;
            }
            f = f4;
        }
        int i = (int) f;
        this.mLastMotionX += f - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = f2;
        int i = 0;
        int i2 = -1;
        ItemInfo itemInfo = null;
        int i3 = 1;
        while (i < this.mItems.size()) {
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(i);
            if (i3 == 0) {
                i2++;
                if (itemInfo2.f1467b != i2) {
                    itemInfo2 = this.mTempItem;
                    itemInfo2.f1470e = (f2 + f3) + f;
                    itemInfo2.f1467b = i2;
                    itemInfo2.f1469d = 1.0f;
                    i--;
                }
            }
            f2 = itemInfo2.f1470e;
            float f4 = (itemInfo2.f1469d + f2) + f;
            if (i3 == 0) {
                if (scrollX < f2) {
                    return itemInfo;
                }
            }
            if (scrollX >= f4) {
                if (i != this.mItems.size() - 1) {
                    i2 = itemInfo2.f1467b;
                    f3 = itemInfo2.f1469d;
                    i++;
                    i3 = 0;
                    itemInfo = itemInfo2;
                }
            }
            return itemInfo2;
        }
        return itemInfo;
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 1053609165 : 1058642330));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= null) {
            return i;
        }
        return Math.max(((ItemInfo) this.mItems.get(0)).f1467b, Math.min(i, ((ItemInfo) this.mItems.get(this.mItems.size() - 1)).f1467b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        int i = 0;
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || this.mAdapter == null || this.mAdapter.mo3684c() <= 1) {
                this.mLeftEdge.finish();
                this.mRightEdge.finish();
                if (i != 0) {
                    ViewCompat.m1234c(this);
                }
            }
        }
        if (!this.mLeftEdge.isFinished()) {
            overScrollMode = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
            this.mLeftEdge.setSize(height, width);
            i = 0 | this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (!this.mRightEdge.isFinished()) {
            overScrollMode = canvas.save();
            height = getWidth();
            width = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
            this.mRightEdge.setSize(width, height);
            i |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (i != 0) {
            ViewCompat.m1234c(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && r0.mMarginDrawable != null && r0.mItems.size() > 0 && r0.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = (float) width;
            float f2 = ((float) r0.mPageMargin) / f;
            int i = 0;
            ItemInfo itemInfo = (ItemInfo) r0.mItems.get(0);
            float f3 = itemInfo.f1470e;
            int size = r0.mItems.size();
            int i2 = itemInfo.f1467b;
            int i3 = ((ItemInfo) r0.mItems.get(size - 1)).f1467b;
            while (i2 < i3) {
                float f4;
                float f5;
                while (i2 > itemInfo.f1467b && i < size) {
                    i++;
                    itemInfo = (ItemInfo) r0.mItems.get(i);
                }
                if (i2 == itemInfo.f1467b) {
                    f4 = (itemInfo.f1470e + itemInfo.f1469d) * f;
                    f3 = (itemInfo.f1470e + itemInfo.f1469d) + f2;
                } else {
                    f4 = (f3 + 1.0f) * f;
                    f3 += 1.0f + f2;
                }
                if (((float) r0.mPageMargin) + f4 > ((float) scrollX)) {
                    f5 = f2;
                    r0.mMarginDrawable.setBounds(Math.round(f4), r0.mTopPageBounds, Math.round(((float) r0.mPageMargin) + f4), r0.mBottomPageBounds);
                    r0.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f5 = f2;
                }
                if (f4 <= ((float) (scrollX + width))) {
                    i2++;
                    f2 = f5;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f1467b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f1470e) / infoForCurrentScrollPosition.f1469d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            f = (float) getClientWidth();
            float f2 = this.mFirstOffset * f;
            float f3 = this.mLastOffset * f;
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
            if (itemInfo.f1467b != 0) {
                f2 = itemInfo.f1470e * f;
            }
            if (itemInfo2.f1467b != this.mAdapter.mo3684c() - 1) {
                f3 = itemInfo2.f1470e * f;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            f = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(f);
            f.recycle();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (z && view2.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (executeKeyEvent(keyEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageLeft();
                        }
                        return arrowScroll(17);
                    case 22:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageRight();
                        }
                        return arrowScroll(66);
                    default:
                        break;
                }
            } else if (keyEvent.hasNoModifiers()) {
                return arrowScroll(2);
            } else {
                if (keyEvent.hasModifiers(1) != null) {
                    return arrowScroll(1);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r8) {
        /*
        r7 = this;
        r0 = r7.findFocus();
        r1 = 1;
        r2 = 0;
        r3 = 0;
        if (r0 != r7) goto L_0x000a;
    L_0x0009:
        goto L_0x0066;
    L_0x000a:
        if (r0 == 0) goto L_0x0065;
    L_0x000c:
        r4 = r0.getParent();
    L_0x0010:
        r5 = r4 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x001d;
    L_0x0014:
        if (r4 != r7) goto L_0x0018;
    L_0x0016:
        r4 = r1;
        goto L_0x001e;
    L_0x0018:
        r4 = r4.getParent();
        goto L_0x0010;
    L_0x001d:
        r4 = r2;
    L_0x001e:
        if (r4 != 0) goto L_0x0065;
    L_0x0020:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r0.getClass();
        r5 = r5.getSimpleName();
        r4.append(r5);
        r0 = r0.getParent();
    L_0x0034:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x004d;
    L_0x0038:
        r5 = " => ";
        r4.append(r5);
        r5 = r0.getClass();
        r5 = r5.getSimpleName();
        r4.append(r5);
        r0 = r0.getParent();
        goto L_0x0034;
    L_0x004d:
        r0 = "ViewPager";
        r5 = new java.lang.StringBuilder;
        r6 = "arrowScroll tried to find focus based on non-child current focused view ";
        r5.<init>(r6);
        r4 = r4.toString();
        r5.append(r4);
        r4 = r5.toString();
        android.util.Log.e(r0, r4);
        goto L_0x0066;
    L_0x0065:
        r3 = r0;
    L_0x0066:
        r0 = android.view.FocusFinder.getInstance();
        r0 = r0.findNextFocus(r7, r3, r8);
        r4 = 66;
        r5 = 17;
        if (r0 == 0) goto L_0x00b1;
    L_0x0074:
        if (r0 == r3) goto L_0x00b1;
    L_0x0076:
        if (r8 != r5) goto L_0x0096;
    L_0x0078:
        r1 = r7.mTempRect;
        r1 = r7.getChildRectInPagerCoordinates(r1, r0);
        r1 = r1.left;
        r2 = r7.mTempRect;
        r2 = r7.getChildRectInPagerCoordinates(r2, r3);
        r2 = r2.left;
        if (r3 == 0) goto L_0x0091;
    L_0x008a:
        if (r1 < r2) goto L_0x0091;
    L_0x008c:
        r2 = r7.pageLeft();
        goto L_0x00c4;
    L_0x0091:
        r2 = r0.requestFocus();
        goto L_0x00c4;
    L_0x0096:
        if (r8 != r4) goto L_0x00c4;
    L_0x0098:
        r1 = r7.mTempRect;
        r1 = r7.getChildRectInPagerCoordinates(r1, r0);
        r1 = r1.left;
        r2 = r7.mTempRect;
        r2 = r7.getChildRectInPagerCoordinates(r2, r3);
        r2 = r2.left;
        if (r3 == 0) goto L_0x00ac;
    L_0x00aa:
        if (r1 <= r2) goto L_0x00bb;
    L_0x00ac:
        r2 = r0.requestFocus();
        goto L_0x00c4;
    L_0x00b1:
        if (r8 == r5) goto L_0x00c0;
    L_0x00b3:
        if (r8 != r1) goto L_0x00b6;
    L_0x00b5:
        goto L_0x00c0;
    L_0x00b6:
        if (r8 == r4) goto L_0x00bb;
    L_0x00b8:
        r0 = 2;
        if (r8 != r0) goto L_0x00c4;
    L_0x00bb:
        r2 = r7.pageRight();
        goto L_0x00c4;
    L_0x00c0:
        r2 = r7.pageLeft();
    L_0x00c4:
        if (r2 == 0) goto L_0x00cd;
    L_0x00c6:
        r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8);
        r7.playSoundEffect(r8);
    L_0x00cd:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        view = view.getParent();
        while ((view instanceof ViewGroup) && view != this) {
            ViewGroup viewGroup = (ViewGroup) view;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            view = viewGroup.getParent();
        }
        return rect;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.mo3684c() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.f1467b == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || isFocusable() == 0) {
            return;
        }
        if (!(((i2 & 1) == 1 && isInTouchMode() != 0 && isFocusableInTouchMode() == 0) || arrayList == null)) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1467b == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int childCount = getChildCount();
        int i3 = -1;
        if ((i & 2) != 0) {
            i3 = childCount;
            childCount = 0;
            i2 = 1;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i3) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1467b == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1467b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
