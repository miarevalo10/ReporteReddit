package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends LayoutManager implements ScrollVectorProvider {
    private boolean f12060F;
    private SavedState f12061G;
    private int f12062H;
    private final Rect f12063I = new Rect();
    private final AnchorInfo f12064J = new AnchorInfo(this);
    private boolean f12065K = false;
    private boolean f12066L;
    private int[] f12067M;
    private final Runnable f12068N;
    Span[] f12069a;
    OrientationHelper f12070b;
    OrientationHelper f12071c;
    boolean f12072d = false;
    boolean f12073e = false;
    int f12074f = -1;
    int f12075g = Integer.MIN_VALUE;
    LazySpanLookup f12076h = new LazySpanLookup();
    private int f12077i = -1;
    private int f12078j;
    private int f12079k;
    private final LayoutState f12080l;
    private BitSet f12081m;
    private int f12082n = 2;
    private boolean f12083o;

    class C02281 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f2511a;

        C02281(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2511a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f2511a.m10918g();
        }
    }

    class AnchorInfo {
        int f2512a;
        int f2513b;
        boolean f2514c;
        boolean f2515d;
        boolean f2516e;
        int[] f2517f;
        final /* synthetic */ StaggeredGridLayoutManager f2518g;

        AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2518g = staggeredGridLayoutManager;
            m2268a();
        }

        final void m2268a() {
            this.f2512a = -1;
            this.f2513b = Integer.MIN_VALUE;
            this.f2514c = false;
            this.f2515d = false;
            this.f2516e = false;
            if (this.f2517f != null) {
                Arrays.fill(this.f2517f, -1);
            }
        }
    }

    static class LazySpanLookup {
        int[] f2523a;
        List<FullSpanItem> f2524b;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C02291();
            int f2519a;
            int f2520b;
            int[] f2521c;
            boolean f2522d;

            static class C02291 implements Creator<FullSpanItem> {
                C02291() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            }

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f2519a = parcel.readInt();
                this.f2520b = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f2522d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2521c = new int[readInt];
                    parcel.readIntArray(this.f2521c);
                }
            }

            FullSpanItem() {
            }

            final int m2269a(int i) {
                return this.f2521c == null ? 0 : this.f2521c[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2519a);
                parcel.writeInt(this.f2520b);
                parcel.writeInt(this.f2522d);
                if (this.f2521c == 0 || this.f2521c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f2521c.length);
                parcel.writeIntArray(this.f2521c);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("FullSpanItem{mPosition=");
                stringBuilder.append(this.f2519a);
                stringBuilder.append(", mGapDir=");
                stringBuilder.append(this.f2520b);
                stringBuilder.append(", mHasUnwantedGapAfter=");
                stringBuilder.append(this.f2522d);
                stringBuilder.append(", mGapPerSpan=");
                stringBuilder.append(Arrays.toString(this.f2521c));
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
        }

        LazySpanLookup() {
        }

        final int m2270a(int i) {
            if (this.f2524b != null) {
                for (int size = this.f2524b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f2524b.get(size)).f2519a >= i) {
                        this.f2524b.remove(size);
                    }
                }
            }
            return m2275b(i);
        }

        final int m2275b(int i) {
            if (this.f2523a == null || i >= this.f2523a.length) {
                return -1;
            }
            int size;
            if (this.f2524b != null) {
                FullSpanItem d = m2278d(i);
                if (d != null) {
                    this.f2524b.remove(d);
                }
                size = this.f2524b.size();
                int i2 = 0;
                while (i2 < size) {
                    if (((FullSpanItem) this.f2524b.get(i2)).f2519a >= i) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                if (i2 != -1) {
                    d = (FullSpanItem) this.f2524b.get(i2);
                    this.f2524b.remove(i2);
                    size = d.f2519a;
                    if (size != -1) {
                        Arrays.fill(this.f2523a, i, this.f2523a.length, -1);
                        return this.f2523a.length;
                    }
                    size++;
                    Arrays.fill(this.f2523a, i, size, -1);
                    return size;
                }
            }
            size = -1;
            if (size != -1) {
                size++;
                Arrays.fill(this.f2523a, i, size, -1);
                return size;
            }
            Arrays.fill(this.f2523a, i, this.f2523a.length, -1);
            return this.f2523a.length;
        }

        final void m2277c(int i) {
            if (this.f2523a == null) {
                this.f2523a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2523a, -1);
                return;
            }
            if (i >= this.f2523a.length) {
                Object obj = this.f2523a;
                int length = this.f2523a.length;
                while (length <= i) {
                    length *= 2;
                }
                this.f2523a = new int[length];
                System.arraycopy(obj, 0, this.f2523a, 0, obj.length);
                Arrays.fill(this.f2523a, obj.length, this.f2523a.length, -1);
            }
        }

        final void m2272a() {
            if (this.f2523a != null) {
                Arrays.fill(this.f2523a, -1);
            }
            this.f2524b = null;
        }

        final void m2273a(int i, int i2) {
            if (this.f2523a != null) {
                if (i < this.f2523a.length) {
                    int i3 = i + i2;
                    m2277c(i3);
                    System.arraycopy(this.f2523a, i3, this.f2523a, i, (this.f2523a.length - i) - i2);
                    Arrays.fill(this.f2523a, this.f2523a.length - i2, this.f2523a.length, -1);
                    if (this.f2524b != null) {
                        for (int size = this.f2524b.size() - 1; size >= 0; size--) {
                            FullSpanItem fullSpanItem = (FullSpanItem) this.f2524b.get(size);
                            if (fullSpanItem.f2519a >= i) {
                                if (fullSpanItem.f2519a < i3) {
                                    this.f2524b.remove(size);
                                } else {
                                    fullSpanItem.f2519a -= i2;
                                }
                            }
                        }
                    }
                }
            }
        }

        final void m2276b(int i, int i2) {
            if (this.f2523a != null) {
                if (i < this.f2523a.length) {
                    int i3 = i + i2;
                    m2277c(i3);
                    System.arraycopy(this.f2523a, i, this.f2523a, i3, (this.f2523a.length - i) - i2);
                    Arrays.fill(this.f2523a, i, i3, -1);
                    if (this.f2524b != null) {
                        for (i3 = this.f2524b.size() - 1; i3 >= 0; i3--) {
                            FullSpanItem fullSpanItem = (FullSpanItem) this.f2524b.get(i3);
                            if (fullSpanItem.f2519a >= i) {
                                fullSpanItem.f2519a += i2;
                            }
                        }
                    }
                }
            }
        }

        public final void m2274a(FullSpanItem fullSpanItem) {
            if (this.f2524b == null) {
                this.f2524b = new ArrayList();
            }
            int size = this.f2524b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f2524b.get(i);
                if (fullSpanItem2.f2519a == fullSpanItem.f2519a) {
                    this.f2524b.remove(i);
                }
                if (fullSpanItem2.f2519a >= fullSpanItem.f2519a) {
                    this.f2524b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f2524b.add(fullSpanItem);
        }

        public final FullSpanItem m2278d(int i) {
            if (this.f2524b == null) {
                return null;
            }
            for (int size = this.f2524b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f2524b.get(size);
                if (fullSpanItem.f2519a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem m2271a(int i, int i2, int i3) {
            if (this.f2524b == null) {
                return null;
            }
            int size = this.f2524b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f2524b.get(i4);
                if (fullSpanItem.f2519a >= i2) {
                    return null;
                }
                if (fullSpanItem.f2519a >= i && (i3 == 0 || fullSpanItem.f2520b == i3 || fullSpanItem.f2522d)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C02301();
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        static class C02301 implements Creator<SavedState> {
            C02301() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public int describeContents() {
            return 0;
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            if (this.mSpanOffsetsSize > 0) {
                this.mSpanOffsets = new int[this.mSpanOffsetsSize];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            if (this.mSpanLookupSize > 0) {
                this.mSpanLookup = new int[this.mSpanLookupSize];
                parcel.readIntArray(this.mSpanLookup);
            }
            boolean z = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.mLastLayoutRTL = z;
            this.mFullSpanItems = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout);
            parcel.writeInt(this.mAnchorLayoutFromEnd);
            parcel.writeInt(this.mLastLayoutRTL);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    class Span {
        ArrayList<View> f2525a = new ArrayList();
        int f2526b = Integer.MIN_VALUE;
        int f2527c = Integer.MIN_VALUE;
        int f2528d = null;
        final int f2529e;
        final /* synthetic */ StaggeredGridLayoutManager f2530f;

        Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f2530f = staggeredGridLayoutManager;
            this.f2529e = i;
        }

        final int m2284a(int i) {
            if (this.f2526b != Integer.MIN_VALUE) {
                return this.f2526b;
            }
            if (this.f2525a.size() == 0) {
                return i;
            }
            m2281h();
            return this.f2526b;
        }

        private void m2281h() {
            View view = (View) this.f2525a.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f2526b = this.f2530f.f12070b.mo661a(view);
            if (layoutParams.f12059b) {
                FullSpanItem d = this.f2530f.f12076h.m2278d(layoutParams.f2382c.m2224c());
                if (d != null && d.f2520b == -1) {
                    this.f2526b -= d.m2269a(this.f2529e);
                }
            }
        }

        final int m2283a() {
            if (this.f2526b != Integer.MIN_VALUE) {
                return this.f2526b;
            }
            m2281h();
            return this.f2526b;
        }

        final int m2288b(int i) {
            if (this.f2527c != Integer.MIN_VALUE) {
                return this.f2527c;
            }
            if (this.f2525a.size() == 0) {
                return i;
            }
            m2282i();
            return this.f2527c;
        }

        private void m2282i() {
            View view = (View) this.f2525a.get(this.f2525a.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f2527c = this.f2530f.f12070b.mo664b(view);
            if (layoutParams.f12059b) {
                FullSpanItem d = this.f2530f.f12076h.m2278d(layoutParams.f2382c.m2224c());
                if (d != null && d.f2520b == 1) {
                    this.f2527c += d.m2269a(this.f2529e);
                }
            }
        }

        final int m2287b() {
            if (this.f2527c != Integer.MIN_VALUE) {
                return this.f2527c;
            }
            m2282i();
            return this.f2527c;
        }

        final void m2290c() {
            this.f2525a.clear();
            this.f2526b = Integer.MIN_VALUE;
            this.f2527c = Integer.MIN_VALUE;
            this.f2528d = 0;
        }

        final void m2291c(int i) {
            this.f2526b = i;
            this.f2527c = i;
        }

        final void m2292d() {
            int size = this.f2525a.size();
            View view = (View) this.f2525a.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f12058a = null;
            if (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2243u()) {
                this.f2528d -= this.f2530f.f12070b.mo670e(view);
            }
            if (size == 1) {
                this.f2526b = Integer.MIN_VALUE;
            }
            this.f2527c = Integer.MIN_VALUE;
        }

        final void m2294e() {
            View view = (View) this.f2525a.remove(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f12058a = null;
            if (this.f2525a.size() == 0) {
                this.f2527c = Integer.MIN_VALUE;
            }
            if (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2243u()) {
                this.f2528d -= this.f2530f.f12070b.mo670e(view);
            }
            this.f2526b = Integer.MIN_VALUE;
        }

        static LayoutParams m2280c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        final void m2293d(int i) {
            if (this.f2526b != Integer.MIN_VALUE) {
                this.f2526b += i;
            }
            if (this.f2527c != Integer.MIN_VALUE) {
                this.f2527c += i;
            }
        }

        public final int m2295f() {
            if (this.f2530f.f12072d) {
                return m2279b(this.f2525a.size() - 1, -1);
            }
            return m2279b(0, this.f2525a.size());
        }

        public final int m2296g() {
            if (this.f2530f.f12072d) {
                return m2279b(0, this.f2525a.size());
            }
            return m2279b(this.f2525a.size() - 1, -1);
        }

        public final View m2285a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                i2 = this.f2525a.size() - 1;
                while (i2 >= 0) {
                    View view2 = (View) this.f2525a.get(i2);
                    if ((this.f2530f.f12072d && LayoutManager.m2070a(view2) >= i) || ((!this.f2530f.f12072d && LayoutManager.m2070a(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i2--;
                    view = view2;
                }
            } else {
                i2 = this.f2525a.size();
                int i3 = 0;
                while (i3 < i2) {
                    View view3 = (View) this.f2525a.get(i3);
                    if ((this.f2530f.f12072d && LayoutManager.m2070a(view3) <= i) || ((!this.f2530f.f12072d && LayoutManager.m2070a(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        final void m2286a(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f12058a = this;
            this.f2525a.add(0, view);
            this.f2526b = Integer.MIN_VALUE;
            if (this.f2525a.size() == 1) {
                this.f2527c = Integer.MIN_VALUE;
            }
            if (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2243u()) {
                this.f2528d += this.f2530f.f12070b.mo670e(view);
            }
        }

        final void m2289b(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f12058a = this;
            this.f2525a.add(view);
            this.f2527c = Integer.MIN_VALUE;
            if (this.f2525a.size() == 1) {
                this.f2526b = Integer.MIN_VALUE;
            }
            if (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2243u()) {
                this.f2528d += this.f2530f.f12070b.mo670e(view);
            }
        }

        private int m2279b(int i, int i2) {
            int b = this.f2530f.f12070b.mo663b();
            int c = this.f2530f.f12070b.mo665c();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.f2525a.get(i);
                int a = this.f2530f.f12070b.mo661a(view);
                int b2 = this.f2530f.f12070b.mo664b(view);
                Object obj = null;
                Object obj2 = a <= c ? 1 : null;
                if (b2 >= b) {
                    obj = 1;
                }
                if (obj2 != null && r8 != null && (a < b || b2 > c)) {
                    return LayoutManager.m2070a(view);
                }
                i += i3;
            }
            return -1;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        Span f12058a;
        boolean f12059b;

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

        public final int m10846a() {
            if (this.f12058a == null) {
                return -1;
            }
            return this.f12058a.f2529e;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        this.f12066L = true;
        this.f12068N = new C02281(this);
        context = LayoutManager.m2071a(context, attributeSet, i, i2);
        attributeSet = context.f2360a;
        if (attributeSet == null || attributeSet == 1) {
            mo632a((String) 0);
            if (attributeSet != this.f12078j) {
                this.f12078j = attributeSet;
                attributeSet = this.f12070b;
                this.f12070b = this.f12071c;
                this.f12071c = attributeSet;
                m2148n();
            }
            m10863d(context.f2361b);
            m10855a(context.f2362c);
            if (this.f12082n == null) {
                z = false;
            }
            this.f2378w = z;
            this.f12080l = new LayoutState();
            m10867h();
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f12066L = true;
        this.f12068N = new C02281(this);
        this.f12078j = i2;
        m10863d(i);
        if (this.f12082n == 0) {
            z = false;
        }
        this.f2378w = z;
        this.f12080l = new LayoutState();
        m10867h();
    }

    private void m10867h() {
        this.f12070b = OrientationHelper.m1989a(this, this.f12078j);
        this.f12071c = OrientationHelper.m1989a(this, 1 - this.f12078j);
    }

    final boolean m10918g() {
        if (!(m2151q() == 0 || this.f12082n == 0)) {
            if (this.f2377v) {
                int m;
                int A;
                if (this.f12073e) {
                    m = m10877m();
                    A = m10847A();
                } else {
                    m = m10847A();
                    A = m10877m();
                }
                if (m == 0 && m10869i() != null) {
                    this.f12076h.m2272a();
                    this.f2376u = true;
                    m2148n();
                    return true;
                } else if (!this.f12065K) {
                    return false;
                } else {
                    int i = this.f12073e ? -1 : 1;
                    A++;
                    FullSpanItem a = this.f12076h.m2271a(m, A, i);
                    if (a == null) {
                        this.f12065K = false;
                        this.f12076h.m2270a(A);
                        return false;
                    }
                    FullSpanItem a2 = this.f12076h.m2271a(m, a.f2519a, i * -1);
                    if (a2 == null) {
                        this.f12076h.m2270a(a.f2519a);
                    } else {
                        this.f12076h.m2270a(a2.f2519a + 1);
                    }
                    this.f2376u = true;
                    m2148n();
                    return true;
                }
            }
        }
        return false;
    }

    public final void mo732h(int i) {
        if (i == 0) {
            m10918g();
        }
    }

    public final void mo630a(RecyclerView recyclerView, Recycler recycler) {
        m2113a((Runnable) this.f12068N);
        for (recycler = null; recycler < this.f12077i; recycler++) {
            this.f12069a[recycler].m2290c();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m10869i() {
        /*
        r12 = this;
        r0 = r12.m2151q();
        r1 = 1;
        r0 = r0 - r1;
        r2 = new java.util.BitSet;
        r3 = r12.f12077i;
        r2.<init>(r3);
        r3 = r12.f12077i;
        r4 = 0;
        r2.set(r4, r3, r1);
        r3 = r12.f12078j;
        r5 = -1;
        if (r3 != r1) goto L_0x0020;
    L_0x0018:
        r3 = r12.m10876l();
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        r3 = r1;
        goto L_0x0021;
    L_0x0020:
        r3 = r5;
    L_0x0021:
        r6 = r12.f12073e;
        if (r6 == 0) goto L_0x0027;
    L_0x0025:
        r6 = r5;
        goto L_0x002b;
    L_0x0027:
        r0 = r0 + 1;
        r6 = r0;
        r0 = r4;
    L_0x002b:
        if (r0 >= r6) goto L_0x002e;
    L_0x002d:
        r5 = r1;
    L_0x002e:
        if (r0 == r6) goto L_0x00ee;
    L_0x0030:
        r7 = r12.m2134e(r0);
        r8 = r7.getLayoutParams();
        r8 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r8;
        r9 = r8.f12058a;
        r9 = r9.f2529e;
        r9 = r2.get(r9);
        if (r9 == 0) goto L_0x0097;
    L_0x0044:
        r9 = r8.f12058a;
        r10 = r12.f12073e;
        if (r10 == 0) goto L_0x006f;
    L_0x004a:
        r10 = r9.m2287b();
        r11 = r12.f12070b;
        r11 = r11.mo665c();
        if (r10 >= r11) goto L_0x008c;
    L_0x0056:
        r10 = r9.f2525a;
        r9 = r9.f2525a;
        r9 = r9.size();
        r9 = r9 - r1;
        r9 = r10.get(r9);
        r9 = (android.view.View) r9;
        r9 = android.support.v7.widget.StaggeredGridLayoutManager.Span.m2280c(r9);
        r9 = r9.f12059b;
        if (r9 != 0) goto L_0x008c;
    L_0x006d:
        r9 = r1;
        goto L_0x008d;
    L_0x006f:
        r10 = r9.m2283a();
        r11 = r12.f12070b;
        r11 = r11.mo663b();
        if (r10 <= r11) goto L_0x008c;
    L_0x007b:
        r9 = r9.f2525a;
        r9 = r9.get(r4);
        r9 = (android.view.View) r9;
        r9 = android.support.v7.widget.StaggeredGridLayoutManager.Span.m2280c(r9);
        r9 = r9.f12059b;
        if (r9 != 0) goto L_0x008c;
    L_0x008b:
        goto L_0x006d;
    L_0x008c:
        r9 = r4;
    L_0x008d:
        if (r9 == 0) goto L_0x0090;
    L_0x008f:
        return r7;
    L_0x0090:
        r9 = r8.f12058a;
        r9 = r9.f2529e;
        r2.clear(r9);
    L_0x0097:
        r9 = r8.f12059b;
        if (r9 != 0) goto L_0x00eb;
    L_0x009b:
        r9 = r0 + r5;
        if (r9 == r6) goto L_0x00eb;
    L_0x009f:
        r9 = r12.m2134e(r9);
        r10 = r12.f12073e;
        if (r10 == 0) goto L_0x00b9;
    L_0x00a7:
        r10 = r12.f12070b;
        r10 = r10.mo664b(r7);
        r11 = r12.f12070b;
        r11 = r11.mo664b(r9);
        if (r10 >= r11) goto L_0x00b6;
    L_0x00b5:
        return r7;
    L_0x00b6:
        if (r10 != r11) goto L_0x00cc;
    L_0x00b8:
        goto L_0x00ca;
    L_0x00b9:
        r10 = r12.f12070b;
        r10 = r10.mo661a(r7);
        r11 = r12.f12070b;
        r11 = r11.mo661a(r9);
        if (r10 <= r11) goto L_0x00c8;
    L_0x00c7:
        return r7;
    L_0x00c8:
        if (r10 != r11) goto L_0x00cc;
    L_0x00ca:
        r10 = r1;
        goto L_0x00cd;
    L_0x00cc:
        r10 = r4;
    L_0x00cd:
        if (r10 == 0) goto L_0x00eb;
    L_0x00cf:
        r9 = r9.getLayoutParams();
        r9 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r9;
        r8 = r8.f12058a;
        r8 = r8.f2529e;
        r9 = r9.f12058a;
        r9 = r9.f2529e;
        r8 = r8 - r9;
        if (r8 >= 0) goto L_0x00e2;
    L_0x00e0:
        r8 = r1;
        goto L_0x00e3;
    L_0x00e2:
        r8 = r4;
    L_0x00e3:
        if (r3 >= 0) goto L_0x00e7;
    L_0x00e5:
        r9 = r1;
        goto L_0x00e8;
    L_0x00e7:
        r9 = r4;
    L_0x00e8:
        if (r8 == r9) goto L_0x00eb;
    L_0x00ea:
        return r7;
    L_0x00eb:
        r0 = r0 + r5;
        goto L_0x002e;
    L_0x00ee:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.i():android.view.View");
    }

    private void m10863d(int i) {
        mo632a(null);
        if (i != this.f12077i) {
            this.f12076h.m2272a();
            m2148n();
            this.f12077i = i;
            this.f12081m = new BitSet(this.f12077i);
            this.f12069a = new Span[this.f12077i];
            for (i = 0; i < this.f12077i; i++) {
                this.f12069a[i] = new Span(this, i);
            }
            m2148n();
        }
    }

    private void m10855a(boolean z) {
        mo632a(null);
        if (!(this.f12061G == null || this.f12061G.mReverseLayout == z)) {
            this.f12061G.mReverseLayout = z;
        }
        this.f12072d = z;
        m2148n();
    }

    public final void mo632a(String str) {
        if (this.f12061G == null) {
            super.mo632a(str);
        }
    }

    private void m10874k() {
        boolean z = true;
        if (this.f12078j != 1) {
            if (m10876l()) {
                if (this.f12072d) {
                    z = false;
                }
                this.f12073e = z;
            }
        }
        z = this.f12072d;
        this.f12073e = z;
    }

    public final void mo723a(Rect rect, int i, int i2) {
        int t = m2154t() + m2156v();
        int u = m2155u() + m2157w();
        if (this.f12078j == 1) {
            rect = LayoutManager.m2068a(i2, (int) rect.height() + u, ViewCompat.m1253n(this.f2372q));
            i = LayoutManager.m2068a(i, (this.f12079k * this.f12077i) + t, ViewCompat.m1252m(this.f2372q));
        } else {
            i = LayoutManager.m2068a(i, (int) rect.width() + t, ViewCompat.m1252m(this.f2372q));
            rect = LayoutManager.m2068a(i2, (int) (this.f12079k * this.f12077i) + u, ViewCompat.m1253n(this.f2372q));
        }
        m2145i(i, rect);
    }

    public final void mo628a(State state) {
        super.mo628a(state);
        this.f12074f = -1;
        this.f12075g = Integer.MIN_VALUE;
        this.f12061G = null;
        this.f12064J.m2268a();
    }

    private void m10870i(int i) {
        this.f12079k = i / this.f12077i;
        this.f12062H = MeasureSpec.makeMeasureSpec(i, this.f12071c.mo673g());
    }

    public final boolean mo640c() {
        return this.f12061G == null;
    }

    public final int mo634b(State state) {
        return m10866h(state);
    }

    private int m10866h(State state) {
        if (m2151q() == 0) {
            return null;
        }
        return ScrollbarHelper.m2257a(state, this.f12070b, m10856b(this.f12066L ^ 1), m10862c(this.f12066L ^ 1), this, this.f12066L, this.f12073e);
    }

    public final int mo637c(State state) {
        return m10866h(state);
    }

    public final int mo642d(State state) {
        return m10868i(state);
    }

    private int m10868i(State state) {
        if (m2151q() == 0) {
            return null;
        }
        return ScrollbarHelper.m2256a(state, this.f12070b, m10856b(this.f12066L ^ 1), m10862c(this.f12066L ^ 1), this, this.f12066L);
    }

    public final int mo644e(State state) {
        return m10868i(state);
    }

    public final int mo646f(State state) {
        return m10871j(state);
    }

    private int m10871j(State state) {
        if (m2151q() == 0) {
            return null;
        }
        return ScrollbarHelper.m2258b(state, this.f12070b, m10856b(this.f12066L ^ 1), m10862c(this.f12066L ^ 1), this, this.f12066L);
    }

    public final int mo648g(State state) {
        return m10871j(state);
    }

    private void m10854a(View view, int i, int i2) {
        m2128c(view, this.f12063I);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i = m10860c(i, layoutParams.leftMargin + this.f12063I.left, layoutParams.rightMargin + this.f12063I.right);
        i2 = m10860c(i2, layoutParams.topMargin + this.f12063I.top, layoutParams.bottomMargin + this.f12063I.bottom);
        if (m2112a(view, i, i2, (android.support.v7.widget.RecyclerView.LayoutParams) layoutParams)) {
            view.measure(i, i2);
        }
    }

    private static int m10860c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return i;
            }
        }
        return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
    }

    public final void mo627a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f12061G = (SavedState) parcelable;
            m2148n();
        }
    }

    public final Parcelable mo643d() {
        if (this.f12061G != null) {
            return new SavedState(this.f12061G);
        }
        Parcelable savedState = new SavedState();
        savedState.mReverseLayout = this.f12072d;
        savedState.mAnchorLayoutFromEnd = this.f12083o;
        savedState.mLastLayoutRTL = this.f12060F;
        int i = 0;
        if (this.f12076h == null || this.f12076h.f2523a == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = this.f12076h.f2523a;
            savedState.mSpanLookupSize = savedState.mSpanLookup.length;
            savedState.mFullSpanItems = this.f12076h.f2524b;
        }
        int i2 = -1;
        if (m2151q() > 0) {
            int m;
            View c;
            if (this.f12083o) {
                m = m10877m();
            } else {
                m = m10847A();
            }
            savedState.mAnchorPosition = m;
            if (this.f12073e) {
                c = m10862c(true);
            } else {
                c = m10856b(true);
            }
            if (c != null) {
                i2 = LayoutManager.m2070a(c);
            }
            savedState.mVisibleAnchorPosition = i2;
            savedState.mSpanOffsetsSize = this.f12077i;
            savedState.mSpanOffsets = new int[this.f12077i];
            while (i < this.f12077i) {
                if (this.f12083o) {
                    m = this.f12069a[i].m2288b(Integer.MIN_VALUE);
                    if (m != Integer.MIN_VALUE) {
                        m -= this.f12070b.mo665c();
                    }
                } else {
                    m = this.f12069a[i].m2284a(Integer.MIN_VALUE);
                    if (m != Integer.MIN_VALUE) {
                        m -= this.f12070b.mo663b();
                    }
                }
                savedState.mSpanOffsets[i] = m;
                i++;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public final void mo724a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        recycler = view.getLayoutParams();
        if ((recycler instanceof LayoutParams) == null) {
            super.m2106a(view, accessibilityNodeInfoCompat);
            return;
        }
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) recycler;
        view = true;
        if (this.f12078j == null) {
            state = layoutParams.m10846a();
            if (layoutParams.f12059b) {
                view = this.f12077i;
            }
            i = state;
            i2 = view;
            i3 = -1;
            i4 = i3;
        } else {
            state = layoutParams.m10846a();
            if (layoutParams.f12059b) {
                view = this.f12077i;
            }
            i3 = state;
            i4 = view;
            i = -1;
            i2 = i;
        }
        accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(i, i2, i3, i4, layoutParams.f12059b, false));
    }

    public final void mo631a(AccessibilityEvent accessibilityEvent) {
        super.mo631a(accessibilityEvent);
        if (m2151q() > 0) {
            View b = m10856b(false);
            View c = m10862c(false);
            if (b != null) {
                if (c != null) {
                    int a = LayoutManager.m2070a(b);
                    int a2 = LayoutManager.m2070a(c);
                    if (a < a2) {
                        accessibilityEvent.setFromIndex(a);
                        accessibilityEvent.setToIndex(a2);
                        return;
                    }
                    accessibilityEvent.setFromIndex(a2);
                    accessibilityEvent.setToIndex(a);
                }
            }
        }
    }

    public final int mo718a(Recycler recycler, State state) {
        if (this.f12078j == 0) {
            return this.f12077i;
        }
        return super.mo718a(recycler, state);
    }

    public final int mo726b(Recycler recycler, State state) {
        if (this.f12078j == 1) {
            return this.f12077i;
        }
        return super.mo726b(recycler, state);
    }

    private View m10856b(boolean z) {
        int b = this.f12070b.mo663b();
        int c = this.f12070b.mo665c();
        int q = m2151q();
        View view = null;
        for (int i = 0; i < q; i++) {
            View e = m2134e(i);
            int a = this.f12070b.mo661a(e);
            if (this.f12070b.mo664b(e) > b && a < c) {
                if (a < b) {
                    if (z) {
                        if (view == null) {
                            view = e;
                        }
                    }
                }
                return e;
            }
        }
        return view;
    }

    private View m10862c(boolean z) {
        int b = this.f12070b.mo663b();
        int c = this.f12070b.mo665c();
        View view = null;
        for (int q = m2151q() - 1; q >= 0; q--) {
            View e = m2134e(q);
            int a = this.f12070b.mo661a(e);
            int b2 = this.f12070b.mo664b(e);
            if (b2 > b && a < c) {
                if (b2 > c) {
                    if (z) {
                        if (view == null) {
                            view = e;
                        }
                    }
                }
                return e;
            }
        }
        return view;
    }

    private void m10852a(Recycler recycler, State state, boolean z) {
        int l = m10875l(Integer.MIN_VALUE);
        if (l != Integer.MIN_VALUE) {
            int c = this.f12070b.mo665c() - l;
            if (c > 0) {
                c -= -m10861c(-c, recycler, state);
                if (z && c > 0) {
                    this.f12070b.mo662a(c);
                }
            }
        }
    }

    private void m10859b(Recycler recycler, State state, boolean z) {
        int k = m10873k(RedditJobManager.f10810d);
        if (k != RedditJobManager.f10810d) {
            k -= this.f12070b.mo663b();
            if (k > 0) {
                k -= m10861c(k, recycler, state);
                if (z && k > 0) {
                    this.f12070b.mo662a(-k);
                }
            }
        }
    }

    private void m10849a(int i, State state) {
        boolean z = false;
        this.f12080l.f2290b = 0;
        this.f12080l.f2291c = i;
        if (m2150p()) {
            state = state.getTargetScrollPosition();
            if (state != -1) {
                if (this.f12073e == (state < i)) {
                    state = this.f12070b.mo669e();
                    i = 0;
                } else {
                    i = this.f12070b.mo669e();
                    state = null;
                }
                if (m2149o()) {
                    this.f12080l.f2295g = this.f12070b.mo667d() + state;
                    this.f12080l.f2294f = -i;
                } else {
                    this.f12080l.f2294f = this.f12070b.mo663b() - i;
                    this.f12080l.f2295g = this.f12070b.mo665c() + state;
                }
                this.f12080l.f2296h = false;
                this.f12080l.f2289a = true;
                i = this.f12080l;
                if (this.f12070b.mo673g() == null && this.f12070b.mo667d() == null) {
                    z = true;
                }
                i.f2297i = z;
            }
        }
        i = 0;
        state = i;
        if (m2149o()) {
            this.f12080l.f2295g = this.f12070b.mo667d() + state;
            this.f12080l.f2294f = -i;
        } else {
            this.f12080l.f2294f = this.f12070b.mo663b() - i;
            this.f12080l.f2295g = this.f12070b.mo665c() + state;
        }
        this.f12080l.f2296h = false;
        this.f12080l.f2289a = true;
        i = this.f12080l;
        z = true;
        i.f2297i = z;
    }

    private void m10872j(int i) {
        this.f12080l.f2293e = i;
        LayoutState layoutState = this.f12080l;
        int i2 = 1;
        if (this.f12073e != (i == -1)) {
            i2 = -1;
        }
        layoutState.f2292d = i2;
    }

    public final void mo730f(int i) {
        super.mo730f(i);
        for (int i2 = 0; i2 < this.f12077i; i2++) {
            this.f12069a[i2].m2293d(i);
        }
    }

    public final void mo731g(int i) {
        super.mo731g(i);
        for (int i2 = 0; i2 < this.f12077i; i2++) {
            this.f12069a[i2].m2293d(i);
        }
    }

    public final void mo727b(int i, int i2) {
        m10864d(i, i2, 2);
    }

    public final void mo722a(int i, int i2) {
        m10864d(i, i2, 1);
    }

    public final void mo721a() {
        this.f12076h.m2272a();
        m2148n();
    }

    public final void mo729d(int i, int i2) {
        m10864d(i, i2, 8);
    }

    public final void mo728c(int i, int i2) {
        m10864d(i, i2, 4);
    }

    private void m10864d(int i, int i2, int i3) {
        int i4;
        int i5;
        int m = this.f12073e ? m10877m() : m10847A();
        if (i3 != 8) {
            i4 = i + i2;
        } else if (i < i2) {
            i4 = i2 + 1;
        } else {
            i5 = i + 1;
            i4 = i2;
            this.f12076h.m2275b(i4);
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        this.f12076h.m2276b(i, i2);
                        break;
                    case 2:
                        this.f12076h.m2273a(i, i2);
                        break;
                    default:
                        break;
                }
            }
            this.f12076h.m2273a(i, 1);
            this.f12076h.m2276b(i2, 1);
            if (i5 <= m) {
                if (i4 <= (this.f12073e == 0 ? m10847A() : m10877m())) {
                    m2148n();
                }
            }
        }
        i5 = i4;
        i4 = i;
        this.f12076h.m2275b(i4);
        if (i3 != 8) {
            switch (i3) {
                case 1:
                    this.f12076h.m2276b(i, i2);
                    break;
                case 2:
                    this.f12076h.m2273a(i, i2);
                    break;
                default:
                    break;
            }
        }
        this.f12076h.m2273a(i, 1);
        this.f12076h.m2276b(i2, 1);
        if (i5 <= m) {
            if (this.f12073e == 0) {
            }
            if (i4 <= (this.f12073e == 0 ? m10847A() : m10877m())) {
                m2148n();
            }
        }
    }

    private int m10848a(Recycler recycler, LayoutState layoutState, State state) {
        int c;
        Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        boolean z = false;
        boolean z2 = true;
        this.f12081m.set(0, this.f12077i, true);
        int i = this.f12080l.f2297i ? layoutState2.f2293e == 1 ? RedditJobManager.f10810d : Integer.MIN_VALUE : layoutState2.f2293e == 1 ? layoutState2.f2295g + layoutState2.f2290b : layoutState2.f2294f - layoutState2.f2290b;
        m10865e(layoutState2.f2293e, i);
        if (r0.f12073e) {
            c = r0.f12070b.mo665c();
        } else {
            c = r0.f12070b.mo663b();
        }
        int i2 = 0;
        while (layoutState.m1971a(state) && (r0.f12080l.f2297i || !r0.f12081m.isEmpty())) {
            int i3;
            boolean z3;
            Span span;
            int i4;
            int i5;
            Span span2;
            int b;
            int i6;
            Span span3;
            int b2;
            int i7;
            Span span4;
            boolean z4;
            FullSpanItem fullSpanItem;
            FullSpanItem fullSpanItem2;
            int b3;
            boolean z5;
            View b4 = recycler2.m2183b(layoutState2.f2291c);
            layoutState2.f2291c += layoutState2.f2292d;
            LayoutParams layoutParams = (LayoutParams) b4.getLayoutParams();
            int c2 = layoutParams.f2382c.m2224c();
            LazySpanLookup lazySpanLookup = r0.f12076h;
            if (lazySpanLookup.f2523a != null) {
                if (c2 < lazySpanLookup.f2523a.length) {
                    i3 = lazySpanLookup.f2523a[c2];
                    z3 = i3 != -1 ? z2 : z;
                    if (z3) {
                        span = r0.f12069a[i3];
                    } else {
                        if (layoutParams.f12059b) {
                            if (m10878m(layoutState2.f2293e)) {
                                i4 = z2;
                                i5 = r0.f12077i;
                                i3 = z;
                            } else {
                                i3 = r0.f12077i - z2;
                                i5 = -1;
                                i4 = i5;
                            }
                            span2 = null;
                            if (layoutState2.f2293e != z2) {
                                b = r0.f12070b.mo663b();
                                i6 = RedditJobManager.f10810d;
                                while (i3 != i5) {
                                    span3 = r0.f12069a[i3];
                                    b2 = span3.m2288b(b);
                                    if (b2 < i6) {
                                        span2 = span3;
                                        i6 = b2;
                                    }
                                    i3 += i4;
                                }
                            } else {
                                b = r0.f12070b.mo665c();
                                i7 = Integer.MIN_VALUE;
                                while (i3 != i5) {
                                    span4 = r0.f12069a[i3];
                                    b2 = span4.m2284a(b);
                                    if (b2 > i7) {
                                        span2 = span4;
                                        i7 = b2;
                                    }
                                    i3 += i4;
                                }
                            }
                            span = span2;
                        } else {
                            span = r0.f12069a[z];
                        }
                        LazySpanLookup lazySpanLookup2 = r0.f12076h;
                        lazySpanLookup2.m2277c(c2);
                        lazySpanLookup2.f2523a[c2] = span.f2529e;
                    }
                    layoutParams.f12058a = span;
                    if (layoutState2.f2293e != z2) {
                        z4 = false;
                        super.m2104a(b4, -1, false);
                    } else {
                        z4 = false;
                        super.m2104a(b4, 0, false);
                    }
                    if (layoutParams.f12059b) {
                        if (r0.f12078j != z2) {
                            m10854a(b4, LayoutManager.m2069a(r0.f12079k, r0.f2365B, (int) z4, layoutParams.width, z4), LayoutManager.m2069a(r0.f2368E, r0.f2366C, (int) z4, layoutParams.height, z2));
                        } else {
                            m10854a(b4, LayoutManager.m2069a(r0.f2367D, r0.f2365B, (int) z4, layoutParams.width, z2), LayoutManager.m2069a(r0.f12079k, r0.f2366C, (int) z4, layoutParams.height, z4));
                        }
                    } else if (r0.f12078j != z2) {
                        m10854a(b4, r0.f12062H, LayoutManager.m2069a(r0.f2368E, r0.f2366C, (int) z4, layoutParams.height, z2));
                    } else {
                        m10854a(b4, LayoutManager.m2069a(r0.f2367D, r0.f2365B, (int) z4, layoutParams.width, z2), r0.f12062H);
                    }
                    if (layoutState2.f2293e != z2) {
                        if (layoutParams.f12059b) {
                            b = span.m2288b(c);
                        } else {
                            b = m10875l(c);
                        }
                        i7 = r0.f12070b.mo670e(b4) + b;
                        if (z3 && layoutParams.f12059b) {
                            fullSpanItem = new FullSpanItem();
                            fullSpanItem.f2521c = new int[r0.f12077i];
                            for (b2 = 0; b2 < r0.f12077i; b2++) {
                                fullSpanItem.f2521c[b2] = b - r0.f12069a[b2].m2288b(b);
                            }
                            fullSpanItem.f2520b = -1;
                            fullSpanItem.f2519a = c2;
                            r0.f12076h.m2274a(fullSpanItem);
                        }
                    } else {
                        if (layoutParams.f12059b) {
                            b = span.m2284a(c);
                        } else {
                            b = m10873k(c);
                        }
                        i7 = b;
                        b = i7 - r0.f12070b.mo670e(b4);
                        if (z3 && layoutParams.f12059b) {
                            fullSpanItem2 = new FullSpanItem();
                            fullSpanItem2.f2521c = new int[r0.f12077i];
                            for (i6 = 0; i6 < r0.f12077i; i6++) {
                                fullSpanItem2.f2521c[i6] = r0.f12069a[i6].m2284a(i7) - i7;
                            }
                            fullSpanItem2.f2520b = 1;
                            fullSpanItem2.f2519a = c2;
                            r0.f12076h.m2274a(fullSpanItem2);
                        }
                    }
                    if (layoutParams.f12059b || layoutState2.f2292d != -1) {
                        b2 = 1;
                    } else {
                        if (z3) {
                            b2 = true;
                        } else {
                            if (layoutState2.f2293e == 1) {
                                i6 = Integer.MIN_VALUE;
                                b3 = r0.f12069a[0].m2288b(Integer.MIN_VALUE);
                                b2 = 1;
                                while (b2 < r0.f12077i) {
                                    if (r0.f12069a[b2].m2288b(i6) != b3) {
                                        b3 = 0;
                                        break;
                                    }
                                    b2++;
                                    i6 = Integer.MIN_VALUE;
                                }
                                b3 = 1;
                                b3 ^= 1;
                                b2 = true;
                            } else {
                                b3 = r0.f12069a[0].m2284a(Integer.MIN_VALUE);
                                for (b2 = 1; b2 < r0.f12077i; b2++) {
                                    if (r0.f12069a[b2].m2284a(Integer.MIN_VALUE) != b3) {
                                        b3 = 0;
                                        break;
                                    }
                                }
                                b3 = 1;
                                b2 = true;
                                b3 ^= 1;
                            }
                            if (b3 != 0) {
                                fullSpanItem2 = r0.f12076h.m2278d(c2);
                                if (fullSpanItem2 != null) {
                                    fullSpanItem2.f2522d = b2;
                                }
                            }
                        }
                        r0.f12065K = b2;
                    }
                    if (layoutState2.f2293e != b2) {
                        if (layoutParams.f12059b) {
                            layoutParams.f12058a.m2289b(b4);
                        } else {
                            for (b3 = r0.f12077i - b2; b3 >= 0; b3--) {
                                r0.f12069a[b3].m2289b(b4);
                            }
                        }
                    } else if (layoutParams.f12059b) {
                        layoutParams.f12058a.m2286a(b4);
                    } else {
                        for (b3 = r0.f12077i - 1; b3 >= 0; b3--) {
                            r0.f12069a[b3].m2286a(b4);
                        }
                    }
                    if (m10876l() || r0.f12078j != 1) {
                        if (layoutParams.f12059b) {
                            b3 = (span.f2529e * r0.f12079k) + r0.f12071c.mo663b();
                        } else {
                            b3 = r0.f12071c.mo663b();
                        }
                        b2 = b3;
                        b3 = r0.f12071c.mo670e(b4) + b2;
                    } else {
                        if (layoutParams.f12059b) {
                            b3 = r0.f12071c.mo665c();
                        } else {
                            b3 = r0.f12071c.mo665c() - (((r0.f12077i - 1) - span.f2529e) * r0.f12079k);
                        }
                        b2 = b3 - r0.f12071c.mo670e(b4);
                    }
                    if (r0.f12078j != 1) {
                        LayoutManager.m2073a(b4, b2, b, b3, i7);
                    } else {
                        LayoutManager.m2073a(b4, b, b2, i7, b3);
                    }
                    if (layoutParams.f12059b) {
                        m10853a(span, r0.f12080l.f2293e, i);
                    } else {
                        m10865e(r0.f12080l.f2293e, i);
                    }
                    m10851a(recycler2, r0.f12080l);
                    if (r0.f12080l.f2296h && b4.hasFocusable()) {
                        if (layoutParams.f12059b) {
                            r0.f12081m.set(span.f2529e, false);
                        } else {
                            r0.f12081m.clear();
                        }
                    }
                    z2 = true;
                    z5 = z2;
                    z = false;
                }
            }
            i3 = -1;
            if (i3 != -1) {
            }
            if (z3) {
                span = r0.f12069a[i3];
            } else {
                if (layoutParams.f12059b) {
                    if (m10878m(layoutState2.f2293e)) {
                        i4 = z2;
                        i5 = r0.f12077i;
                        i3 = z;
                    } else {
                        i3 = r0.f12077i - z2;
                        i5 = -1;
                        i4 = i5;
                    }
                    span2 = null;
                    if (layoutState2.f2293e != z2) {
                        b = r0.f12070b.mo665c();
                        i7 = Integer.MIN_VALUE;
                        while (i3 != i5) {
                            span4 = r0.f12069a[i3];
                            b2 = span4.m2284a(b);
                            if (b2 > i7) {
                                span2 = span4;
                                i7 = b2;
                            }
                            i3 += i4;
                        }
                    } else {
                        b = r0.f12070b.mo663b();
                        i6 = RedditJobManager.f10810d;
                        while (i3 != i5) {
                            span3 = r0.f12069a[i3];
                            b2 = span3.m2288b(b);
                            if (b2 < i6) {
                                span2 = span3;
                                i6 = b2;
                            }
                            i3 += i4;
                        }
                    }
                    span = span2;
                } else {
                    span = r0.f12069a[z];
                }
                LazySpanLookup lazySpanLookup22 = r0.f12076h;
                lazySpanLookup22.m2277c(c2);
                lazySpanLookup22.f2523a[c2] = span.f2529e;
            }
            layoutParams.f12058a = span;
            if (layoutState2.f2293e != z2) {
                z4 = false;
                super.m2104a(b4, 0, false);
            } else {
                z4 = false;
                super.m2104a(b4, -1, false);
            }
            if (layoutParams.f12059b) {
                if (r0.f12078j != z2) {
                    m10854a(b4, LayoutManager.m2069a(r0.f2367D, r0.f2365B, (int) z4, layoutParams.width, z2), LayoutManager.m2069a(r0.f12079k, r0.f2366C, (int) z4, layoutParams.height, z4));
                } else {
                    m10854a(b4, LayoutManager.m2069a(r0.f12079k, r0.f2365B, (int) z4, layoutParams.width, z4), LayoutManager.m2069a(r0.f2368E, r0.f2366C, (int) z4, layoutParams.height, z2));
                }
            } else if (r0.f12078j != z2) {
                m10854a(b4, LayoutManager.m2069a(r0.f2367D, r0.f2365B, (int) z4, layoutParams.width, z2), r0.f12062H);
            } else {
                m10854a(b4, r0.f12062H, LayoutManager.m2069a(r0.f2368E, r0.f2366C, (int) z4, layoutParams.height, z2));
            }
            if (layoutState2.f2293e != z2) {
                if (layoutParams.f12059b) {
                    b = span.m2284a(c);
                } else {
                    b = m10873k(c);
                }
                i7 = b;
                b = i7 - r0.f12070b.mo670e(b4);
                fullSpanItem2 = new FullSpanItem();
                fullSpanItem2.f2521c = new int[r0.f12077i];
                for (i6 = 0; i6 < r0.f12077i; i6++) {
                    fullSpanItem2.f2521c[i6] = r0.f12069a[i6].m2284a(i7) - i7;
                }
                fullSpanItem2.f2520b = 1;
                fullSpanItem2.f2519a = c2;
                r0.f12076h.m2274a(fullSpanItem2);
            } else {
                if (layoutParams.f12059b) {
                    b = span.m2288b(c);
                } else {
                    b = m10875l(c);
                }
                i7 = r0.f12070b.mo670e(b4) + b;
                fullSpanItem = new FullSpanItem();
                fullSpanItem.f2521c = new int[r0.f12077i];
                for (b2 = 0; b2 < r0.f12077i; b2++) {
                    fullSpanItem.f2521c[b2] = b - r0.f12069a[b2].m2288b(b);
                }
                fullSpanItem.f2520b = -1;
                fullSpanItem.f2519a = c2;
                r0.f12076h.m2274a(fullSpanItem);
            }
            if (layoutParams.f12059b) {
            }
            b2 = 1;
            if (layoutState2.f2293e != b2) {
                if (layoutParams.f12059b) {
                    layoutParams.f12058a.m2286a(b4);
                } else {
                    for (b3 = r0.f12077i - 1; b3 >= 0; b3--) {
                        r0.f12069a[b3].m2286a(b4);
                    }
                }
            } else if (layoutParams.f12059b) {
                layoutParams.f12058a.m2289b(b4);
            } else {
                for (b3 = r0.f12077i - b2; b3 >= 0; b3--) {
                    r0.f12069a[b3].m2289b(b4);
                }
            }
            if (m10876l()) {
            }
            if (layoutParams.f12059b) {
                b3 = (span.f2529e * r0.f12079k) + r0.f12071c.mo663b();
            } else {
                b3 = r0.f12071c.mo663b();
            }
            b2 = b3;
            b3 = r0.f12071c.mo670e(b4) + b2;
            if (r0.f12078j != 1) {
                LayoutManager.m2073a(b4, b, b2, i7, b3);
            } else {
                LayoutManager.m2073a(b4, b2, b, b3, i7);
            }
            if (layoutParams.f12059b) {
                m10853a(span, r0.f12080l.f2293e, i);
            } else {
                m10865e(r0.f12080l.f2293e, i);
            }
            m10851a(recycler2, r0.f12080l);
            if (layoutParams.f12059b) {
                r0.f12081m.set(span.f2529e, false);
            } else {
                r0.f12081m.clear();
            }
            z2 = true;
            z5 = z2;
            z = false;
        }
        if (i2 == 0) {
            m10851a(recycler2, r0.f12080l);
        }
        if (r0.f12080l.f2293e == -1) {
            i = r0.f12070b.mo663b() - m10873k(r0.f12070b.mo663b());
        } else {
            i = m10875l(r0.f12070b.mo665c()) - r0.f12070b.mo665c();
        }
        return i > 0 ? Math.min(layoutState2.f2290b, i) : 0;
    }

    private void m10851a(Recycler recycler, LayoutState layoutState) {
        if (layoutState.f2289a) {
            if (!layoutState.f2297i) {
                if (layoutState.f2290b != 0) {
                    int i = 1;
                    int i2;
                    int i3;
                    int a;
                    int i4;
                    if (layoutState.f2293e == -1) {
                        i2 = layoutState.f2294f;
                        i3 = layoutState.f2294f;
                        a = this.f12069a[0].m2284a(i3);
                        while (i < this.f12077i) {
                            int a2 = this.f12069a[i].m2284a(i3);
                            if (a2 > a) {
                                a = a2;
                            }
                            i++;
                        }
                        i2 -= a;
                        if (i2 < 0) {
                            i4 = layoutState.f2295g;
                        } else {
                            i4 = layoutState.f2295g - Math.min(i2, layoutState.f2290b);
                        }
                        m10858b(recycler, i4);
                        return;
                    }
                    i2 = layoutState.f2295g;
                    i3 = this.f12069a[0].m2288b(i2);
                    while (i < this.f12077i) {
                        a = this.f12069a[i].m2288b(i2);
                        if (a < i3) {
                            i3 = a;
                        }
                        i++;
                    }
                    i3 -= layoutState.f2295g;
                    if (i3 < 0) {
                        i4 = layoutState.f2294f;
                    } else {
                        i4 = Math.min(i3, layoutState.f2290b) + layoutState.f2294f;
                    }
                    m10850a(recycler, i4);
                } else if (layoutState.f2293e == -1) {
                    m10858b(recycler, layoutState.f2295g);
                } else {
                    m10850a(recycler, layoutState.f2294f);
                }
            }
        }
    }

    private void m10865e(int i, int i2) {
        for (int i3 = 0; i3 < this.f12077i; i3++) {
            if (!this.f12069a[i3].f2525a.isEmpty()) {
                m10853a(this.f12069a[i3], i, i2);
            }
        }
    }

    private int m10873k(int i) {
        int a = this.f12069a[0].m2284a(i);
        for (int i2 = 1; i2 < this.f12077i; i2++) {
            int a2 = this.f12069a[i2].m2284a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int m10875l(int i) {
        int b = this.f12069a[0].m2288b(i);
        for (int i2 = 1; i2 < this.f12077i; i2++) {
            int b2 = this.f12069a[i2].m2288b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m10850a(Recycler recycler, int i) {
        while (m2151q() > 0) {
            int i2 = 0;
            View e = m2134e(0);
            if (this.f12070b.mo664b(e) <= i && this.f12070b.mo666c(e) <= i) {
                LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
                if (layoutParams.f12059b) {
                    int i3 = 0;
                    while (i3 < this.f12077i) {
                        if (this.f12069a[i3].f2525a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    while (i2 < this.f12077i) {
                        this.f12069a[i2].m2294e();
                        i2++;
                    }
                } else if (layoutParams.f12058a.f2525a.size() != 1) {
                    layoutParams.f12058a.m2294e();
                } else {
                    return;
                }
                m2107a(e, recycler);
            } else {
                return;
            }
        }
    }

    private void m10858b(Recycler recycler, int i) {
        int q = m2151q() - 1;
        while (q >= 0) {
            View e = m2134e(q);
            if (this.f12070b.mo661a(e) >= i && this.f12070b.mo668d(e) >= i) {
                LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
                if (layoutParams.f12059b) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < this.f12077i) {
                        if (this.f12069a[i3].f2525a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    while (i2 < this.f12077i) {
                        this.f12069a[i2].m2292d();
                        i2++;
                    }
                } else if (layoutParams.f12058a.f2525a.size() != 1) {
                    layoutParams.f12058a.m2292d();
                } else {
                    return;
                }
                m2107a(e, recycler);
                q--;
            } else {
                return;
            }
        }
    }

    private boolean m10878m(int i) {
        if (this.f12078j == 0) {
            return (i == -1) != this.f12073e;
        } else {
            return ((i == -1) == this.f12073e) == m10876l();
        }
    }

    public final boolean mo647f() {
        return this.f12078j == 1;
    }

    public final boolean mo645e() {
        return this.f12078j == 0;
    }

    public final int mo622a(int i, Recycler recycler, State state) {
        return m10861c(i, recycler, state);
    }

    public final int mo633b(int i, Recycler recycler, State state) {
        return m10861c(i, recycler, state);
    }

    private int m10879n(int i) {
        if (m2151q() == 0) {
            return this.f12073e != 0 ? 1 : -1;
        } else {
            return (i < m10847A()) != this.f12073e ? -1 : 1;
        }
    }

    public final PointF mo635b(int i) {
        i = m10879n(i);
        PointF pointF = new PointF();
        if (i == 0) {
            return 0;
        }
        if (this.f12078j == 0) {
            pointF.x = (float) i;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) i;
        }
        return pointF;
    }

    public final void mo629a(RecyclerView recyclerView, int i) {
        SmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.f2409g = i;
        m2099a(linearSmoothScroller);
    }

    public final void mo638c(int i) {
        if (!(this.f12061G == null || this.f12061G.mAnchorPosition == i)) {
            this.f12061G.invalidateAnchorPositionInfo();
        }
        this.f12074f = i;
        this.f12075g = Integer.MIN_VALUE;
        m2148n();
    }

    public final void mo625a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.f12078j != 0) {
            i = i2;
        }
        if (m2151q() != 0) {
            if (i != 0) {
                m10857b(i, state);
                if (this.f12067M == 0 || this.f12067M.length < this.f12077i) {
                    this.f12067M = new int[this.f12077i];
                }
                i = 0;
                i2 = 0;
                int i3 = i2;
                while (i2 < this.f12077i) {
                    int a;
                    if (this.f12080l.f2292d == -1) {
                        a = this.f12080l.f2294f - this.f12069a[i2].m2284a(this.f12080l.f2294f);
                    } else {
                        a = this.f12069a[i2].m2288b(this.f12080l.f2295g) - this.f12080l.f2295g;
                    }
                    if (a >= 0) {
                        this.f12067M[i3] = a;
                        i3++;
                    }
                    i2++;
                }
                Arrays.sort(this.f12067M, 0, i3);
                while (i < i3 && this.f12080l.m1971a(state) != 0) {
                    layoutPrefetchRegistry.mo620a(this.f12080l.f2291c, this.f12067M[i]);
                    i2 = this.f12080l;
                    i2.f2291c += this.f12080l.f2292d;
                    i++;
                }
            }
        }
    }

    private void m10857b(int i, State state) {
        int m;
        int i2;
        if (i > 0) {
            m = m10877m();
            i2 = 1;
        } else {
            i2 = -1;
            m = m10847A();
        }
        this.f12080l.f2289a = true;
        m10849a(m, state);
        m10872j(i2);
        this.f12080l.f2291c = m + this.f12080l.f2292d;
        this.f12080l.f2290b = Math.abs(i);
    }

    private int m10861c(int i, Recycler recycler, State state) {
        if (m2151q() != 0) {
            if (i != 0) {
                m10857b(i, state);
                state = m10848a(recycler, this.f12080l, state);
                if (this.f12080l.f2290b >= state) {
                    i = i < 0 ? -state : state;
                }
                this.f12070b.mo662a(-i);
                this.f12083o = this.f12073e;
                this.f12080l.f2290b = 0;
                m10851a(recycler, this.f12080l);
                return i;
            }
        }
        return 0;
    }

    private int m10877m() {
        int q = m2151q();
        if (q == 0) {
            return 0;
        }
        return LayoutManager.m2070a(m2134e(q - 1));
    }

    private int m10847A() {
        if (m2151q() == 0) {
            return 0;
        }
        return LayoutManager.m2070a(m2134e(0));
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams mo636b() {
        if (this.f12078j == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams mo719a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams mo720a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean mo725a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final View mo624a(View view, int i, Recycler recycler, State state) {
        if (m2151q() == 0) {
            return null;
        }
        State b = m2118b(view);
        if (b == null) {
            return null;
        }
        LayoutParams layoutParams;
        boolean z;
        Span span;
        int m;
        int i2;
        m10874k();
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        switch (i) {
                            case 1:
                                if (!(this.f12078j == 1 || m10876l() == 0)) {
                                    break;
                                }
                            case 2:
                                if (!(this.f12078j == 1 || m10876l() == 0)) {
                                    break;
                                }
                        }
                    } else if (this.f12078j == 1) {
                    }
                } else if (this.f12078j == 0) {
                }
                i = 1;
                if (i != Integer.MIN_VALUE) {
                    return null;
                }
                layoutParams = (LayoutParams) b.getLayoutParams();
                z = layoutParams.f12059b;
                span = layoutParams.f12058a;
                if (i != 1) {
                    m = m10877m();
                } else {
                    m = m10847A();
                }
                m10849a(m, state);
                m10872j(i);
                this.f12080l.f2291c = this.f12080l.f2292d + m;
                this.f12080l.f2290b = (int) (0.33333334f * ((float) this.f12070b.mo669e()));
                this.f12080l.f2296h = true;
                i2 = 0;
                this.f12080l.f2289a = false;
                m10848a(recycler, this.f12080l, state);
                this.f12083o = this.f12073e;
                if (!z) {
                    recycler = span.m2285a(m, i);
                    if (!(recycler == null || recycler == b)) {
                        return recycler;
                    }
                }
                if (m10878m(i) == null) {
                    for (recycler = this.f12077i - 1; recycler >= null; recycler--) {
                        state = this.f12069a[recycler].m2285a(m, i);
                        if (state == null && state != b) {
                            return state;
                        }
                    }
                } else {
                    for (recycler = null; recycler < this.f12077i; recycler++) {
                        state = this.f12069a[recycler].m2285a(m, i);
                        if (state == null && state != b) {
                            return state;
                        }
                    }
                }
                recycler = (this.f12072d ^ 1) != (i != -1 ? 1 : null) ? 1 : null;
                if (!z) {
                    if (recycler == null) {
                        state = span.m2295f();
                    } else {
                        state = span.m2296g();
                    }
                    state = mo623a((int) state);
                    if (!(state == null || state == b)) {
                        return state;
                    }
                }
                if (m10878m(i) == 0) {
                    for (i = this.f12077i - 1; i >= 0; i--) {
                        if (i == span.f2529e) {
                            if (recycler == null) {
                                state = this.f12069a[i].m2295f();
                            } else {
                                state = this.f12069a[i].m2296g();
                            }
                            state = mo623a((int) state);
                            if (!(state == null || state == b)) {
                                return state;
                            }
                        }
                    }
                } else {
                    while (i2 < this.f12077i) {
                        if (recycler == null) {
                            i = this.f12069a[i2].m2295f();
                        } else {
                            i = this.f12069a[i2].m2296g();
                        }
                        i = mo623a(i);
                        if (i == 0 && i != b) {
                            return i;
                        }
                        i2++;
                    }
                }
                return null;
            } else if (this.f12078j == 1) {
                i = -1;
                if (i != Integer.MIN_VALUE) {
                    return null;
                }
                layoutParams = (LayoutParams) b.getLayoutParams();
                z = layoutParams.f12059b;
                span = layoutParams.f12058a;
                if (i != 1) {
                    m = m10847A();
                } else {
                    m = m10877m();
                }
                m10849a(m, state);
                m10872j(i);
                this.f12080l.f2291c = this.f12080l.f2292d + m;
                this.f12080l.f2290b = (int) (0.33333334f * ((float) this.f12070b.mo669e()));
                this.f12080l.f2296h = true;
                i2 = 0;
                this.f12080l.f2289a = false;
                m10848a(recycler, this.f12080l, state);
                this.f12083o = this.f12073e;
                if (z) {
                    recycler = span.m2285a(m, i);
                    return recycler;
                }
                if (m10878m(i) == null) {
                    for (recycler = null; recycler < this.f12077i; recycler++) {
                        state = this.f12069a[recycler].m2285a(m, i);
                        if (state == null) {
                        }
                    }
                } else {
                    for (recycler = this.f12077i - 1; recycler >= null; recycler--) {
                        state = this.f12069a[recycler].m2285a(m, i);
                        if (state == null) {
                        }
                    }
                }
                if (i != -1) {
                }
                if ((this.f12072d ^ 1) != (i != -1 ? 1 : null)) {
                }
                if (z) {
                    if (recycler == null) {
                        state = span.m2296g();
                    } else {
                        state = span.m2295f();
                    }
                    state = mo623a((int) state);
                    return state;
                }
                if (m10878m(i) == 0) {
                    while (i2 < this.f12077i) {
                        if (recycler == null) {
                            i = this.f12069a[i2].m2296g();
                        } else {
                            i = this.f12069a[i2].m2295f();
                        }
                        i = mo623a(i);
                        if (i == 0) {
                        }
                        i2++;
                    }
                } else {
                    for (i = this.f12077i - 1; i >= 0; i--) {
                        if (i == span.f2529e) {
                            if (recycler == null) {
                                state = this.f12069a[i].m2296g();
                            } else {
                                state = this.f12069a[i].m2295f();
                            }
                            state = mo623a((int) state);
                            return state;
                        }
                    }
                }
                return null;
            }
        } else if (this.f12078j == 0) {
            i = -1;
            if (i != Integer.MIN_VALUE) {
                return null;
            }
            layoutParams = (LayoutParams) b.getLayoutParams();
            z = layoutParams.f12059b;
            span = layoutParams.f12058a;
            if (i != 1) {
                m = m10877m();
            } else {
                m = m10847A();
            }
            m10849a(m, state);
            m10872j(i);
            this.f12080l.f2291c = this.f12080l.f2292d + m;
            this.f12080l.f2290b = (int) (0.33333334f * ((float) this.f12070b.mo669e()));
            this.f12080l.f2296h = true;
            i2 = 0;
            this.f12080l.f2289a = false;
            m10848a(recycler, this.f12080l, state);
            this.f12083o = this.f12073e;
            if (z) {
                recycler = span.m2285a(m, i);
                return recycler;
            }
            if (m10878m(i) == null) {
                for (recycler = this.f12077i - 1; recycler >= null; recycler--) {
                    state = this.f12069a[recycler].m2285a(m, i);
                    if (state == null) {
                    }
                }
            } else {
                for (recycler = null; recycler < this.f12077i; recycler++) {
                    state = this.f12069a[recycler].m2285a(m, i);
                    if (state == null) {
                    }
                }
            }
            if (i != -1) {
            }
            if ((this.f12072d ^ 1) != (i != -1 ? 1 : null)) {
            }
            if (z) {
                if (recycler == null) {
                    state = span.m2295f();
                } else {
                    state = span.m2296g();
                }
                state = mo623a((int) state);
                return state;
            }
            if (m10878m(i) == 0) {
                for (i = this.f12077i - 1; i >= 0; i--) {
                    if (i == span.f2529e) {
                        if (recycler == null) {
                            state = this.f12069a[i].m2295f();
                        } else {
                            state = this.f12069a[i].m2296g();
                        }
                        state = mo623a((int) state);
                        return state;
                    }
                }
            } else {
                while (i2 < this.f12077i) {
                    if (recycler == null) {
                        i = this.f12069a[i2].m2295f();
                    } else {
                        i = this.f12069a[i2].m2296g();
                    }
                    i = mo623a(i);
                    if (i == 0) {
                    }
                    i2++;
                }
            }
            return null;
        }
        i = Integer.MIN_VALUE;
        if (i != Integer.MIN_VALUE) {
            return null;
        }
        layoutParams = (LayoutParams) b.getLayoutParams();
        z = layoutParams.f12059b;
        span = layoutParams.f12058a;
        if (i != 1) {
            m = m10847A();
        } else {
            m = m10877m();
        }
        m10849a(m, state);
        m10872j(i);
        this.f12080l.f2291c = this.f12080l.f2292d + m;
        this.f12080l.f2290b = (int) (0.33333334f * ((float) this.f12070b.mo669e()));
        this.f12080l.f2296h = true;
        i2 = 0;
        this.f12080l.f2289a = false;
        m10848a(recycler, this.f12080l, state);
        this.f12083o = this.f12073e;
        if (z) {
            recycler = span.m2285a(m, i);
            return recycler;
        }
        if (m10878m(i) == null) {
            for (recycler = null; recycler < this.f12077i; recycler++) {
                state = this.f12069a[recycler].m2285a(m, i);
                if (state == null) {
                }
            }
        } else {
            for (recycler = this.f12077i - 1; recycler >= null; recycler--) {
                state = this.f12069a[recycler].m2285a(m, i);
                if (state == null) {
                }
            }
        }
        if (i != -1) {
        }
        if ((this.f12072d ^ 1) != (i != -1 ? 1 : null)) {
        }
        if (z) {
            if (recycler == null) {
                state = span.m2296g();
            } else {
                state = span.m2295f();
            }
            state = mo623a((int) state);
            return state;
        }
        if (m10878m(i) == 0) {
            while (i2 < this.f12077i) {
                if (recycler == null) {
                    i = this.f12069a[i2].m2296g();
                } else {
                    i = this.f12069a[i2].m2295f();
                }
                i = mo623a(i);
                if (i == 0) {
                }
                i2++;
            }
        } else {
            for (i = this.f12077i - 1; i >= 0; i--) {
                if (i == span.f2529e) {
                    if (recycler == null) {
                        state = this.f12069a[i].m2296g();
                    } else {
                        state = this.f12069a[i].m2295f();
                    }
                    state = mo623a((int) state);
                    return state;
                }
            }
        }
        return null;
    }

    private boolean m10876l() {
        return ViewCompat.m1242f(this.f2372q) == 1;
    }

    public final void mo639c(Recycler recycler, State state) {
        boolean z = true;
        while (true) {
            AnchorInfo anchorInfo = this.f12064J;
            if (!(this.f12061G == null && this.f12074f == -1) && state.getItemCount() == 0) {
                m2126c(recycler);
                anchorInfo.m2268a();
                return;
            }
            boolean z2;
            int i;
            int i2;
            boolean z3;
            int a;
            int a2;
            View a3;
            int i3;
            Span span;
            boolean z4;
            AnchorInfo anchorInfo2;
            Span[] spanArr;
            int q;
            float f;
            View e;
            float e2;
            int i4;
            LayoutParams layoutParams;
            if (anchorInfo.f2516e && this.f12074f == -1) {
                if (this.f12061G == null) {
                    z2 = false;
                    if (z2) {
                        anchorInfo.m2268a();
                        if (this.f12061G == null) {
                            if (this.f12061G.mSpanOffsetsSize > 0) {
                                if (this.f12061G.mSpanOffsetsSize != this.f12077i) {
                                    for (i = 0; i < this.f12077i; i++) {
                                        this.f12069a[i].m2290c();
                                        i2 = this.f12061G.mSpanOffsets[i];
                                        if (i2 == Integer.MIN_VALUE) {
                                            if (this.f12061G.mAnchorLayoutFromEnd) {
                                                i2 += this.f12070b.mo663b();
                                            } else {
                                                i2 += this.f12070b.mo665c();
                                            }
                                        }
                                        this.f12069a[i].m2291c(i2);
                                    }
                                } else {
                                    this.f12061G.invalidateSpanInfo();
                                    this.f12061G.mAnchorPosition = this.f12061G.mVisibleAnchorPosition;
                                }
                            }
                            this.f12060F = this.f12061G.mLastLayoutRTL;
                            m10855a(this.f12061G.mReverseLayout);
                            m10874k();
                            if (this.f12061G.mAnchorPosition == -1) {
                                this.f12074f = this.f12061G.mAnchorPosition;
                                anchorInfo.f2514c = this.f12061G.mAnchorLayoutFromEnd;
                            } else {
                                anchorInfo.f2514c = this.f12073e;
                            }
                            if (this.f12061G.mSpanLookupSize > 1) {
                                this.f12076h.f2523a = this.f12061G.mSpanLookup;
                                this.f12076h.f2524b = this.f12061G.mFullSpanItems;
                            }
                        } else {
                            m10874k();
                            anchorInfo.f2514c = this.f12073e;
                        }
                        if (!state.isPreLayout()) {
                            if (this.f12074f == -1) {
                                if (this.f12074f >= 0) {
                                    if (this.f12074f >= state.getItemCount()) {
                                        if (!(this.f12061G == null || this.f12061G.mAnchorPosition == -1)) {
                                            if (this.f12061G.mSpanOffsetsSize <= 0) {
                                                anchorInfo.f2513b = Integer.MIN_VALUE;
                                                anchorInfo.f2512a = this.f12074f;
                                                z3 = true;
                                                if (!z3) {
                                                    if (this.f12083o) {
                                                        i = state.getItemCount();
                                                        for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                                                            a = LayoutManager.m2070a(m2134e(i2));
                                                            if (a < 0 && a < i) {
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        i = state.getItemCount();
                                                        i2 = m2151q();
                                                        for (a = 0; a < i2; a++) {
                                                            a2 = LayoutManager.m2070a(m2134e(a));
                                                            if (a2 < 0 && a2 < i) {
                                                                a = a2;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    a = 0;
                                                    anchorInfo.f2512a = a;
                                                    anchorInfo.f2513b = Integer.MIN_VALUE;
                                                }
                                                anchorInfo.f2516e = true;
                                            }
                                        }
                                        a3 = mo623a(this.f12074f);
                                        if (a3 == null) {
                                            if (this.f12073e) {
                                                i2 = m10847A();
                                            } else {
                                                i2 = m10877m();
                                            }
                                            anchorInfo.f2512a = i2;
                                            if (this.f12075g == Integer.MIN_VALUE) {
                                                if (anchorInfo.f2514c) {
                                                    anchorInfo.f2513b = (this.f12070b.mo663b() + this.f12075g) - this.f12070b.mo661a(a3);
                                                } else {
                                                    anchorInfo.f2513b = (this.f12070b.mo665c() - this.f12075g) - this.f12070b.mo664b(a3);
                                                }
                                            } else if (this.f12070b.mo670e(a3) <= this.f12070b.mo669e()) {
                                                if (anchorInfo.f2514c) {
                                                    i = this.f12070b.mo663b();
                                                } else {
                                                    i = this.f12070b.mo665c();
                                                }
                                                anchorInfo.f2513b = i;
                                            } else {
                                                i2 = this.f12070b.mo661a(a3) - this.f12070b.mo663b();
                                                if (i2 >= 0) {
                                                    anchorInfo.f2513b = -i2;
                                                } else {
                                                    i2 = this.f12070b.mo665c() - this.f12070b.mo664b(a3);
                                                    if (i2 >= 0) {
                                                        anchorInfo.f2513b = i2;
                                                    } else {
                                                        anchorInfo.f2513b = Integer.MIN_VALUE;
                                                    }
                                                }
                                            }
                                        } else {
                                            anchorInfo.f2512a = this.f12074f;
                                            if (this.f12075g != Integer.MIN_VALUE) {
                                                anchorInfo.f2514c = m10879n(anchorInfo.f2512a) != 1;
                                                if (anchorInfo.f2514c) {
                                                    i = anchorInfo.f2518g.f12070b.mo663b();
                                                } else {
                                                    i = anchorInfo.f2518g.f12070b.mo665c();
                                                }
                                                anchorInfo.f2513b = i;
                                            } else {
                                                i = this.f12075g;
                                                if (anchorInfo.f2514c) {
                                                    anchorInfo.f2513b = anchorInfo.f2518g.f12070b.mo663b() + i;
                                                } else {
                                                    anchorInfo.f2513b = anchorInfo.f2518g.f12070b.mo665c() - i;
                                                }
                                            }
                                            anchorInfo.f2515d = true;
                                        }
                                        z3 = true;
                                        if (z3) {
                                            if (this.f12083o) {
                                                i = state.getItemCount();
                                                for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                                                    a = LayoutManager.m2070a(m2134e(i2));
                                                    if (a < 0) {
                                                    }
                                                }
                                            } else {
                                                i = state.getItemCount();
                                                i2 = m2151q();
                                                for (a = 0; a < i2; a++) {
                                                    a2 = LayoutManager.m2070a(m2134e(a));
                                                    if (a2 < 0) {
                                                    }
                                                }
                                            }
                                            a = 0;
                                            anchorInfo.f2512a = a;
                                            anchorInfo.f2513b = Integer.MIN_VALUE;
                                        }
                                        anchorInfo.f2516e = true;
                                    }
                                }
                                this.f12074f = -1;
                                this.f12075g = Integer.MIN_VALUE;
                            }
                        }
                        z3 = false;
                        if (z3) {
                            if (this.f12083o) {
                                i = state.getItemCount();
                                for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                                    a = LayoutManager.m2070a(m2134e(i2));
                                    if (a < 0) {
                                    }
                                }
                            } else {
                                i = state.getItemCount();
                                i2 = m2151q();
                                for (a = 0; a < i2; a++) {
                                    a2 = LayoutManager.m2070a(m2134e(a));
                                    if (a2 < 0) {
                                    }
                                }
                            }
                            a = 0;
                            anchorInfo.f2512a = a;
                            anchorInfo.f2513b = Integer.MIN_VALUE;
                        }
                        anchorInfo.f2516e = true;
                    }
                    if (this.f12061G == null && this.f12074f == -1 && !(anchorInfo.f2514c == this.f12083o && m10876l() == this.f12060F)) {
                        this.f12076h.m2272a();
                        anchorInfo.f2515d = true;
                    }
                    if (m2151q() > 0 && (this.f12061G == null || this.f12061G.mSpanOffsetsSize <= 0)) {
                        if (anchorInfo.f2515d) {
                            if (!z2) {
                                if (this.f12064J.f2517f == null) {
                                    for (i3 = 0; i3 < this.f12077i; i3++) {
                                        span = this.f12069a[i3];
                                        span.m2290c();
                                        span.m2291c(this.f12064J.f2517f[i3]);
                                    }
                                }
                            }
                            for (i3 = 0; i3 < this.f12077i; i3++) {
                                span = this.f12069a[i3];
                                z4 = this.f12073e;
                                a = anchorInfo.f2513b;
                                if (z4) {
                                    a2 = span.m2284a(Integer.MIN_VALUE);
                                } else {
                                    a2 = span.m2288b(Integer.MIN_VALUE);
                                }
                                span.m2290c();
                                if (a2 != Integer.MIN_VALUE && (!z4 || a2 >= span.f2530f.f12070b.mo665c())) {
                                    if (!z4 || a2 <= span.f2530f.f12070b.mo663b()) {
                                        if (a != Integer.MIN_VALUE) {
                                            a2 += a;
                                        }
                                        span.f2527c = a2;
                                        span.f2526b = a2;
                                    }
                                }
                            }
                            anchorInfo2 = this.f12064J;
                            spanArr = this.f12069a;
                            i2 = spanArr.length;
                            if (anchorInfo2.f2517f == null || anchorInfo2.f2517f.length < i2) {
                                anchorInfo2.f2517f = new int[anchorInfo2.f2518g.f12069a.length];
                            }
                            for (a = 0; a < i2; a++) {
                                anchorInfo2.f2517f[a] = spanArr[a].m2284a(Integer.MIN_VALUE);
                            }
                        } else {
                            for (i3 = 0; i3 < this.f12077i; i3++) {
                                this.f12069a[i3].m2290c();
                                if (anchorInfo.f2513b != Integer.MIN_VALUE) {
                                    this.f12069a[i3].m2291c(anchorInfo.f2513b);
                                }
                            }
                        }
                    }
                    m2097a(recycler);
                    this.f12080l.f2289a = false;
                    this.f12065K = false;
                    m10870i(this.f12071c.mo669e());
                    m10849a(anchorInfo.f2512a, state);
                    if (anchorInfo.f2514c) {
                        m10872j(1);
                        m10848a(recycler, this.f12080l, state);
                        m10872j(-1);
                        this.f12080l.f2291c = anchorInfo.f2512a + this.f12080l.f2292d;
                        m10848a(recycler, this.f12080l, state);
                    } else {
                        m10872j(-1);
                        m10848a(recycler, this.f12080l, state);
                        m10872j(1);
                        this.f12080l.f2291c = anchorInfo.f2512a + this.f12080l.f2292d;
                        m10848a(recycler, this.f12080l, state);
                    }
                    if (this.f12071c.mo673g() != 1073741824) {
                        q = m2151q();
                        f = 0.0f;
                        for (i3 = 0; i3 < q; i3++) {
                            e = m2134e(i3);
                            e2 = (float) this.f12071c.mo670e(e);
                            if (e2 < f) {
                                if (((LayoutParams) e.getLayoutParams()).f12059b) {
                                    e2 = (1.0f * e2) / ((float) this.f12077i);
                                }
                                f = Math.max(f, e2);
                            }
                        }
                        i3 = this.f12079k;
                        i = Math.round(f * ((float) this.f12077i));
                        if (this.f12071c.mo673g() == Integer.MIN_VALUE) {
                            i = Math.min(i, this.f12071c.mo669e());
                        }
                        m10870i(i);
                        if (this.f12079k != i3) {
                            for (i4 = 0; i4 < q; i4++) {
                                a3 = m2134e(i4);
                                layoutParams = (LayoutParams) a3.getLayoutParams();
                                if (layoutParams.f12059b) {
                                    if (m10876l() || this.f12078j != 1) {
                                        a = layoutParams.f12058a.f2529e * this.f12079k;
                                        i2 = layoutParams.f12058a.f2529e * i3;
                                        if (this.f12078j != 1) {
                                            a3.offsetLeftAndRight(a - i2);
                                        } else {
                                            a3.offsetTopAndBottom(a - i2);
                                        }
                                    } else {
                                        a3.offsetLeftAndRight(((-((this.f12077i - 1) - layoutParams.f12058a.f2529e)) * this.f12079k) - ((-((this.f12077i - 1) - layoutParams.f12058a.f2529e)) * i3));
                                    }
                                }
                            }
                        }
                    }
                    if (m2151q() > 0) {
                        if (this.f12073e) {
                            m10859b(recycler, state, true);
                            m10852a(recycler, state, false);
                        } else {
                            m10852a(recycler, state, true);
                            m10859b(recycler, state, false);
                        }
                    }
                    if (z && !state.isPreLayout()) {
                        z = this.f12082n == 0 && m2151q() > 0 && (this.f12065K || m10869i() != null);
                        if (z) {
                            m2113a(this.f12068N);
                            if (m10918g()) {
                                z = true;
                                if (state.isPreLayout()) {
                                    this.f12064J.m2268a();
                                }
                                this.f12083o = anchorInfo.f2514c;
                                this.f12060F = m10876l();
                                if (!z) {
                                    this.f12064J.m2268a();
                                    z = false;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    z = false;
                    if (state.isPreLayout()) {
                        this.f12064J.m2268a();
                    }
                    this.f12083o = anchorInfo.f2514c;
                    this.f12060F = m10876l();
                    if (!z) {
                        this.f12064J.m2268a();
                        z = false;
                    } else {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                anchorInfo.m2268a();
                if (this.f12061G == null) {
                    m10874k();
                    anchorInfo.f2514c = this.f12073e;
                } else {
                    if (this.f12061G.mSpanOffsetsSize > 0) {
                        if (this.f12061G.mSpanOffsetsSize != this.f12077i) {
                            this.f12061G.invalidateSpanInfo();
                            this.f12061G.mAnchorPosition = this.f12061G.mVisibleAnchorPosition;
                        } else {
                            for (i = 0; i < this.f12077i; i++) {
                                this.f12069a[i].m2290c();
                                i2 = this.f12061G.mSpanOffsets[i];
                                if (i2 == Integer.MIN_VALUE) {
                                    if (this.f12061G.mAnchorLayoutFromEnd) {
                                        i2 += this.f12070b.mo663b();
                                    } else {
                                        i2 += this.f12070b.mo665c();
                                    }
                                }
                                this.f12069a[i].m2291c(i2);
                            }
                        }
                    }
                    this.f12060F = this.f12061G.mLastLayoutRTL;
                    m10855a(this.f12061G.mReverseLayout);
                    m10874k();
                    if (this.f12061G.mAnchorPosition == -1) {
                        anchorInfo.f2514c = this.f12073e;
                    } else {
                        this.f12074f = this.f12061G.mAnchorPosition;
                        anchorInfo.f2514c = this.f12061G.mAnchorLayoutFromEnd;
                    }
                    if (this.f12061G.mSpanLookupSize > 1) {
                        this.f12076h.f2523a = this.f12061G.mSpanLookup;
                        this.f12076h.f2524b = this.f12061G.mFullSpanItems;
                    }
                }
                if (state.isPreLayout()) {
                    if (this.f12074f == -1) {
                        if (this.f12074f >= 0) {
                            if (this.f12074f >= state.getItemCount()) {
                                if (this.f12061G.mSpanOffsetsSize <= 0) {
                                    anchorInfo.f2513b = Integer.MIN_VALUE;
                                    anchorInfo.f2512a = this.f12074f;
                                    z3 = true;
                                    if (z3) {
                                        if (this.f12083o) {
                                            i = state.getItemCount();
                                            i2 = m2151q();
                                            for (a = 0; a < i2; a++) {
                                                a2 = LayoutManager.m2070a(m2134e(a));
                                                if (a2 < 0) {
                                                }
                                            }
                                        } else {
                                            i = state.getItemCount();
                                            for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                                                a = LayoutManager.m2070a(m2134e(i2));
                                                if (a < 0) {
                                                }
                                            }
                                        }
                                        a = 0;
                                        anchorInfo.f2512a = a;
                                        anchorInfo.f2513b = Integer.MIN_VALUE;
                                    }
                                    anchorInfo.f2516e = true;
                                } else {
                                    a3 = mo623a(this.f12074f);
                                    if (a3 == null) {
                                        anchorInfo.f2512a = this.f12074f;
                                        if (this.f12075g != Integer.MIN_VALUE) {
                                            i = this.f12075g;
                                            if (anchorInfo.f2514c) {
                                                anchorInfo.f2513b = anchorInfo.f2518g.f12070b.mo663b() + i;
                                            } else {
                                                anchorInfo.f2513b = anchorInfo.f2518g.f12070b.mo665c() - i;
                                            }
                                        } else {
                                            if (m10879n(anchorInfo.f2512a) != 1) {
                                            }
                                            anchorInfo.f2514c = m10879n(anchorInfo.f2512a) != 1;
                                            if (anchorInfo.f2514c) {
                                                i = anchorInfo.f2518g.f12070b.mo663b();
                                            } else {
                                                i = anchorInfo.f2518g.f12070b.mo665c();
                                            }
                                            anchorInfo.f2513b = i;
                                        }
                                        anchorInfo.f2515d = true;
                                    } else {
                                        if (this.f12073e) {
                                            i2 = m10847A();
                                        } else {
                                            i2 = m10877m();
                                        }
                                        anchorInfo.f2512a = i2;
                                        if (this.f12075g == Integer.MIN_VALUE) {
                                            if (this.f12070b.mo670e(a3) <= this.f12070b.mo669e()) {
                                                i2 = this.f12070b.mo661a(a3) - this.f12070b.mo663b();
                                                if (i2 >= 0) {
                                                    i2 = this.f12070b.mo665c() - this.f12070b.mo664b(a3);
                                                    if (i2 >= 0) {
                                                        anchorInfo.f2513b = Integer.MIN_VALUE;
                                                    } else {
                                                        anchorInfo.f2513b = i2;
                                                    }
                                                } else {
                                                    anchorInfo.f2513b = -i2;
                                                }
                                            } else {
                                                if (anchorInfo.f2514c) {
                                                    i = this.f12070b.mo663b();
                                                } else {
                                                    i = this.f12070b.mo665c();
                                                }
                                                anchorInfo.f2513b = i;
                                            }
                                        } else if (anchorInfo.f2514c) {
                                            anchorInfo.f2513b = (this.f12070b.mo663b() + this.f12075g) - this.f12070b.mo661a(a3);
                                        } else {
                                            anchorInfo.f2513b = (this.f12070b.mo665c() - this.f12075g) - this.f12070b.mo664b(a3);
                                        }
                                    }
                                    z3 = true;
                                    if (z3) {
                                        if (this.f12083o) {
                                            i = state.getItemCount();
                                            for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                                                a = LayoutManager.m2070a(m2134e(i2));
                                                if (a < 0) {
                                                }
                                            }
                                        } else {
                                            i = state.getItemCount();
                                            i2 = m2151q();
                                            for (a = 0; a < i2; a++) {
                                                a2 = LayoutManager.m2070a(m2134e(a));
                                                if (a2 < 0) {
                                                }
                                            }
                                        }
                                        a = 0;
                                        anchorInfo.f2512a = a;
                                        anchorInfo.f2513b = Integer.MIN_VALUE;
                                    }
                                    anchorInfo.f2516e = true;
                                }
                            }
                        }
                        this.f12074f = -1;
                        this.f12075g = Integer.MIN_VALUE;
                    }
                }
                z3 = false;
                if (z3) {
                    if (this.f12083o) {
                        i = state.getItemCount();
                        i2 = m2151q();
                        for (a = 0; a < i2; a++) {
                            a2 = LayoutManager.m2070a(m2134e(a));
                            if (a2 < 0) {
                            }
                        }
                    } else {
                        i = state.getItemCount();
                        for (i2 = m2151q() - 1; i2 >= 0; i2--) {
                            a = LayoutManager.m2070a(m2134e(i2));
                            if (a < 0) {
                            }
                        }
                    }
                    a = 0;
                    anchorInfo.f2512a = a;
                    anchorInfo.f2513b = Integer.MIN_VALUE;
                }
                anchorInfo.f2516e = true;
            }
            this.f12076h.m2272a();
            anchorInfo.f2515d = true;
            if (anchorInfo.f2515d) {
                if (z2) {
                    if (this.f12064J.f2517f == null) {
                        for (i3 = 0; i3 < this.f12077i; i3++) {
                            span = this.f12069a[i3];
                            span.m2290c();
                            span.m2291c(this.f12064J.f2517f[i3]);
                        }
                    }
                }
                for (i3 = 0; i3 < this.f12077i; i3++) {
                    span = this.f12069a[i3];
                    z4 = this.f12073e;
                    a = anchorInfo.f2513b;
                    if (z4) {
                        a2 = span.m2284a(Integer.MIN_VALUE);
                    } else {
                        a2 = span.m2288b(Integer.MIN_VALUE);
                    }
                    span.m2290c();
                    if (z4) {
                    }
                    if (a != Integer.MIN_VALUE) {
                        a2 += a;
                    }
                    span.f2527c = a2;
                    span.f2526b = a2;
                }
                anchorInfo2 = this.f12064J;
                spanArr = this.f12069a;
                i2 = spanArr.length;
                anchorInfo2.f2517f = new int[anchorInfo2.f2518g.f12069a.length];
                for (a = 0; a < i2; a++) {
                    anchorInfo2.f2517f[a] = spanArr[a].m2284a(Integer.MIN_VALUE);
                }
            } else {
                for (i3 = 0; i3 < this.f12077i; i3++) {
                    this.f12069a[i3].m2290c();
                    if (anchorInfo.f2513b != Integer.MIN_VALUE) {
                        this.f12069a[i3].m2291c(anchorInfo.f2513b);
                    }
                }
            }
            m2097a(recycler);
            this.f12080l.f2289a = false;
            this.f12065K = false;
            m10870i(this.f12071c.mo669e());
            m10849a(anchorInfo.f2512a, state);
            if (anchorInfo.f2514c) {
                m10872j(1);
                m10848a(recycler, this.f12080l, state);
                m10872j(-1);
                this.f12080l.f2291c = anchorInfo.f2512a + this.f12080l.f2292d;
                m10848a(recycler, this.f12080l, state);
            } else {
                m10872j(-1);
                m10848a(recycler, this.f12080l, state);
                m10872j(1);
                this.f12080l.f2291c = anchorInfo.f2512a + this.f12080l.f2292d;
                m10848a(recycler, this.f12080l, state);
            }
            if (this.f12071c.mo673g() != 1073741824) {
                q = m2151q();
                f = 0.0f;
                for (i3 = 0; i3 < q; i3++) {
                    e = m2134e(i3);
                    e2 = (float) this.f12071c.mo670e(e);
                    if (e2 < f) {
                        if (((LayoutParams) e.getLayoutParams()).f12059b) {
                            e2 = (1.0f * e2) / ((float) this.f12077i);
                        }
                        f = Math.max(f, e2);
                    }
                }
                i3 = this.f12079k;
                i = Math.round(f * ((float) this.f12077i));
                if (this.f12071c.mo673g() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.f12071c.mo669e());
                }
                m10870i(i);
                if (this.f12079k != i3) {
                    for (i4 = 0; i4 < q; i4++) {
                        a3 = m2134e(i4);
                        layoutParams = (LayoutParams) a3.getLayoutParams();
                        if (layoutParams.f12059b) {
                            if (m10876l()) {
                            }
                            a = layoutParams.f12058a.f2529e * this.f12079k;
                            i2 = layoutParams.f12058a.f2529e * i3;
                            if (this.f12078j != 1) {
                                a3.offsetTopAndBottom(a - i2);
                            } else {
                                a3.offsetLeftAndRight(a - i2);
                            }
                        }
                    }
                }
            }
            if (m2151q() > 0) {
                if (this.f12073e) {
                    m10859b(recycler, state, true);
                    m10852a(recycler, state, false);
                } else {
                    m10852a(recycler, state, true);
                    m10859b(recycler, state, false);
                }
            }
            if (this.f12082n == 0) {
            }
            if (z) {
                m2113a(this.f12068N);
                if (m10918g()) {
                    z = true;
                    if (state.isPreLayout()) {
                        this.f12064J.m2268a();
                    }
                    this.f12083o = anchorInfo.f2514c;
                    this.f12060F = m10876l();
                    if (!z) {
                        this.f12064J.m2268a();
                        z = false;
                    } else {
                        return;
                    }
                }
            }
            z = false;
            if (state.isPreLayout()) {
                this.f12064J.m2268a();
            }
            this.f12083o = anchorInfo.f2514c;
            this.f12060F = m10876l();
            if (!z) {
                this.f12064J.m2268a();
                z = false;
            } else {
                return;
            }
        }
    }

    private void m10853a(Span span, int i, int i2) {
        int i3 = span.f2528d;
        if (i == -1) {
            if (span.m2283a() + i3 <= i2) {
                this.f12081m.set(span.f2529e, false);
            }
            return;
        }
        if (span.m2287b() - i3 >= i2) {
            this.f12081m.set(span.f2529e, false);
        }
    }
}
