package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.List;

public class LinearLayoutManager extends LayoutManager implements ScrollVectorProvider {
    private LayoutState f11976a;
    private boolean f11977b;
    private boolean f11978c;
    private boolean f11979d;
    private boolean f11980e;
    private boolean f11981f;
    private final LayoutChunkResult f11982g;
    private int f11983h;
    public int f11984i;
    OrientationHelper f11985j;
    boolean f11986k;
    int f11987l;
    int f11988m;
    SavedState f11989n;
    final AnchorInfo f11990o;

    class AnchorInfo {
        int f2300a;
        int f2301b;
        boolean f2302c;
        boolean f2303d;
        final /* synthetic */ LinearLayoutManager f2304e;

        AnchorInfo(LinearLayoutManager linearLayoutManager) {
            this.f2304e = linearLayoutManager;
            m1973a();
        }

        final void m1973a() {
            this.f2300a = -1;
            this.f2301b = Integer.MIN_VALUE;
            this.f2302c = false;
            this.f2303d = false;
        }

        final void m1975b() {
            int c;
            if (this.f2302c) {
                c = this.f2304e.f11985j.mo665c();
            } else {
                c = this.f2304e.f11985j.mo663b();
            }
            this.f2301b = c;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("AnchorInfo{mPosition=");
            stringBuilder.append(this.f2300a);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.f2301b);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.f2302c);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.f2303d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        static boolean m1972a(View view, State state) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2224c() < 0 || layoutParams.f2382c.m2224c() >= state.getItemCount()) ? null : true;
        }

        public final void m1974a(View view) {
            int a = this.f2304e.f11985j.m1991a();
            if (a >= 0) {
                m1976b(view);
                return;
            }
            this.f2300a = LayoutManager.m2070a(view);
            int c;
            if (this.f2302c) {
                c = (this.f2304e.f11985j.mo665c() - a) - this.f2304e.f11985j.mo664b(view);
                this.f2301b = this.f2304e.f11985j.mo665c() - c;
                if (c > 0) {
                    int e;
                    e = this.f2301b - this.f2304e.f11985j.mo670e(view);
                    a = this.f2304e.f11985j.mo663b();
                    e -= a + Math.min(this.f2304e.f11985j.mo661a(view) - a, 0);
                    if (e < 0) {
                        this.f2301b += Math.min(c, -e);
                    }
                }
                return;
            }
            c = this.f2304e.f11985j.mo661a(view);
            e = c - this.f2304e.f11985j.mo663b();
            this.f2301b = c;
            if (e > 0) {
                view = (this.f2304e.f11985j.mo665c() - Math.min(0, (this.f2304e.f11985j.mo665c() - a) - this.f2304e.f11985j.mo664b(view))) - (c + this.f2304e.f11985j.mo670e(view));
                if (view < null) {
                    this.f2301b -= Math.min(e, -view);
                }
            }
        }

        public final void m1976b(View view) {
            if (this.f2302c) {
                this.f2301b = this.f2304e.f11985j.mo664b(view) + this.f2304e.f11985j.m1991a();
            } else {
                this.f2301b = this.f2304e.f11985j.mo661a(view);
            }
            this.f2300a = LayoutManager.m2070a(view);
        }
    }

    protected static class LayoutChunkResult {
        public int f2305a;
        public boolean f2306b;
        public boolean f2307c;
        public boolean f2308d;

        protected LayoutChunkResult() {
        }
    }

    static class LayoutState {
        boolean f2309a = true;
        int f2310b;
        int f2311c;
        int f2312d;
        int f2313e;
        int f2314f;
        int f2315g;
        int f2316h = 0;
        boolean f2317i = false;
        int f2318j;
        List<ViewHolder> f2319k = null;
        boolean f2320l;

        LayoutState() {
        }

        final boolean m1979a(State state) {
            return (this.f2312d < 0 || this.f2312d >= state.getItemCount()) ? null : true;
        }

        final View m1977a(Recycler recycler) {
            if (this.f2319k != null) {
                recycler = this.f2319k.size();
                int i = 0;
                while (i < recycler) {
                    View view = ((ViewHolder) this.f2319k.get(i)).f2424c;
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.f2382c.m2237o() || this.f2312d != layoutParams.f2382c.m2224c()) {
                        i++;
                    } else {
                        m1978a(view);
                        return view;
                    }
                }
                return null;
            }
            recycler = recycler.m2183b(this.f2312d);
            this.f2312d += this.f2313e;
            return recycler;
        }

        public final void m1978a(View view) {
            int size = this.f2319k.size();
            View view2 = null;
            int i = RedditJobManager.f10810d;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((ViewHolder) this.f2319k.get(i2)).f2424c;
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                if (!(view3 == view || layoutParams.f2382c.m2237o())) {
                    int c = (layoutParams.f2382c.m2224c() - this.f2312d) * this.f2313e;
                    if (c >= 0 && c < r2) {
                        if (c == 0) {
                            view2 = view3;
                            break;
                        } else {
                            view2 = view3;
                            i = c;
                        }
                    }
                }
            }
            if (view2 == null) {
                this.f2312d = -1;
            } else {
                this.f2312d = ((LayoutParams) view2.getLayoutParams()).f2382c.m2224c();
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C02081();
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        static class C02081 implements Creator<SavedState> {
            C02081() {
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
            this.mAnchorOffset = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.mAnchorLayoutFromEnd = z;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd);
        }
    }

    void mo3240a(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f11978c = false;
        this.f11986k = false;
        this.f11979d = false;
        this.f11980e = true;
        this.f11987l = -1;
        this.f11988m = Integer.MIN_VALUE;
        this.f11989n = null;
        this.f11990o = new AnchorInfo(this);
        this.f11982g = new LayoutChunkResult();
        this.f11983h = 2;
        m10676i(i);
        m10702b(z);
        this.f2378w = true;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f11978c = false;
        this.f11986k = false;
        this.f11979d = false;
        this.f11980e = true;
        this.f11987l = -1;
        this.f11988m = Integer.MIN_VALUE;
        this.f11989n = null;
        this.f11990o = new AnchorInfo(this);
        this.f11982g = new LayoutChunkResult();
        this.f11983h = 2;
        context = LayoutManager.m2071a(context, attributeSet, i, i2);
        m10676i(context.f2360a);
        m10702b(context.f2362c);
        mo3243a(context.f2363d);
        this.f2378w = true;
    }

    public LayoutParams mo636b() {
        return new LayoutParams(-2, -2);
    }

    public final void mo630a(RecyclerView recyclerView, Recycler recycler) {
        super.mo630a(recyclerView, recycler);
        if (this.f11981f != null) {
            m2126c(recycler);
            recycler.m2179a();
        }
    }

    public final void mo631a(AccessibilityEvent accessibilityEvent) {
        super.mo631a(accessibilityEvent);
        if (m2151q() > 0) {
            accessibilityEvent.setFromIndex(m10720k());
            accessibilityEvent.setToIndex(m10722m());
        }
    }

    public final Parcelable mo643d() {
        if (this.f11989n != null) {
            return new SavedState(this.f11989n);
        }
        Parcelable savedState = new SavedState();
        if (m2151q() > 0) {
            m10718i();
            boolean z = this.f11977b ^ this.f11986k;
            savedState.mAnchorLayoutFromEnd = z;
            View D;
            if (z) {
                D = m10658D();
                savedState.mAnchorOffset = this.f11985j.mo665c() - this.f11985j.mo664b(D);
                savedState.mAnchorPosition = LayoutManager.m2070a(D);
            } else {
                D = m10657C();
                savedState.mAnchorPosition = LayoutManager.m2070a(D);
                savedState.mAnchorOffset = this.f11985j.mo661a(D) - this.f11985j.mo663b();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public final void mo627a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f11989n = (SavedState) parcelable;
            m2148n();
        }
    }

    public final boolean mo645e() {
        return this.f11984i == 0;
    }

    public final boolean mo647f() {
        return this.f11984i == 1;
    }

    public void mo3243a(boolean z) {
        mo632a(null);
        if (this.f11979d != z) {
            this.f11979d = z;
            m2148n();
        }
    }

    public final int m10715g() {
        return this.f11984i;
    }

    private void m10676i(int i) {
        if (i == 0 || i == 1) {
            mo632a(null);
            if (i != this.f11984i) {
                this.f11984i = i;
                this.f11985j = null;
                m2148n();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("invalid orientation:");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void m10655A() {
        boolean z = true;
        if (this.f11984i != 1) {
            if (m10717h()) {
                if (this.f11978c) {
                    z = false;
                }
                this.f11986k = z;
            }
        }
        z = this.f11978c;
        this.f11986k = z;
    }

    public final void m10702b(boolean z) {
        mo632a(null);
        if (z != this.f11978c) {
            this.f11978c = z;
            m2148n();
        }
    }

    public final View mo623a(int i) {
        int q = m2151q();
        if (q == 0) {
            return 0;
        }
        int a = i - LayoutManager.m2070a(m2134e(0));
        if (a >= 0 && a < q) {
            View e = m2134e(a);
            if (LayoutManager.m2070a(e) == i) {
                return e;
            }
        }
        return super.mo623a(i);
    }

    private int m10674h(State state) {
        return state.hasTargetScrollPosition() != null ? this.f11985j.mo669e() : null;
    }

    public void mo629a(RecyclerView recyclerView, int i) {
        SmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.f2409g = i;
        m2099a(linearSmoothScroller);
    }

    public final PointF mo635b(int i) {
        if (m2151q() == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 1;
        if (i < LayoutManager.m2070a(m2134e(0))) {
            i2 = 1;
        }
        if (i2 != this.f11986k) {
            i3 = -1;
        }
        if (this.f11984i == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo639c(android.support.v7.widget.RecyclerView.Recycler r18, android.support.v7.widget.RecyclerView.State r19) {
        /*
        r17 = this;
        r6 = r17;
        r7 = r18;
        r8 = r19;
        r0 = r6.f11989n;
        r9 = -1;
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r0 = r6.f11987l;
        if (r0 == r9) goto L_0x0019;
    L_0x000f:
        r0 = r19.getItemCount();
        if (r0 != 0) goto L_0x0019;
    L_0x0015:
        r17.m2126c(r18);
        return;
    L_0x0019:
        r0 = r6.f11989n;
        if (r0 == 0) goto L_0x002b;
    L_0x001d:
        r0 = r6.f11989n;
        r0 = r0.hasValidAnchor();
        if (r0 == 0) goto L_0x002b;
    L_0x0025:
        r0 = r6.f11989n;
        r0 = r0.mAnchorPosition;
        r6.f11987l = r0;
    L_0x002b:
        r17.m10718i();
        r0 = r6.f11976a;
        r10 = 0;
        r0.f2309a = r10;
        r17.m10655A();
        r0 = r17.m2158x();
        r1 = r6.f11990o;
        r1 = r1.f2303d;
        r11 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r12 = 1;
        if (r1 == 0) goto L_0x0071;
    L_0x0043:
        r1 = r6.f11987l;
        if (r1 != r9) goto L_0x0071;
    L_0x0047:
        r1 = r6.f11989n;
        if (r1 == 0) goto L_0x004c;
    L_0x004b:
        goto L_0x0071;
    L_0x004c:
        if (r0 == 0) goto L_0x022e;
    L_0x004e:
        r1 = r6.f11985j;
        r1 = r1.mo661a(r0);
        r2 = r6.f11985j;
        r2 = r2.mo665c();
        if (r1 >= r2) goto L_0x006a;
    L_0x005c:
        r1 = r6.f11985j;
        r1 = r1.mo664b(r0);
        r2 = r6.f11985j;
        r2 = r2.mo663b();
        if (r1 > r2) goto L_0x022e;
    L_0x006a:
        r1 = r6.f11990o;
        r1.m1974a(r0);
        goto L_0x022e;
    L_0x0071:
        r0 = r6.f11990o;
        r0.m1973a();
        r0 = r6.f11990o;
        r1 = r6.f11986k;
        r2 = r6.f11979d;
        r1 = r1 ^ r2;
        r0.f2302c = r1;
        r13 = r6.f11990o;
        r0 = r19.isPreLayout();
        if (r0 != 0) goto L_0x0189;
    L_0x0087:
        r0 = r6.f11987l;
        if (r0 != r9) goto L_0x008d;
    L_0x008b:
        goto L_0x0189;
    L_0x008d:
        r0 = r6.f11987l;
        if (r0 < 0) goto L_0x0185;
    L_0x0091:
        r0 = r6.f11987l;
        r1 = r19.getItemCount();
        if (r0 < r1) goto L_0x009b;
    L_0x0099:
        goto L_0x0185;
    L_0x009b:
        r0 = r6.f11987l;
        r13.f2300a = r0;
        r0 = r6.f11989n;
        if (r0 == 0) goto L_0x00d3;
    L_0x00a3:
        r0 = r6.f11989n;
        r0 = r0.hasValidAnchor();
        if (r0 == 0) goto L_0x00d3;
    L_0x00ab:
        r0 = r6.f11989n;
        r0 = r0.mAnchorLayoutFromEnd;
        r13.f2302c = r0;
        r0 = r13.f2302c;
        if (r0 == 0) goto L_0x00c3;
    L_0x00b5:
        r0 = r6.f11985j;
        r0 = r0.mo665c();
        r1 = r6.f11989n;
        r1 = r1.mAnchorOffset;
        r0 = r0 - r1;
        r13.f2301b = r0;
        goto L_0x00d0;
    L_0x00c3:
        r0 = r6.f11985j;
        r0 = r0.mo663b();
        r1 = r6.f11989n;
        r1 = r1.mAnchorOffset;
        r0 = r0 + r1;
        r13.f2301b = r0;
    L_0x00d0:
        r0 = r12;
        goto L_0x018a;
    L_0x00d3:
        r0 = r6.f11988m;
        if (r0 != r11) goto L_0x0163;
    L_0x00d7:
        r0 = r6.f11987l;
        r0 = r6.mo623a(r0);
        if (r0 == 0) goto L_0x0140;
    L_0x00df:
        r1 = r6.f11985j;
        r1 = r1.mo670e(r0);
        r2 = r6.f11985j;
        r2 = r2.mo669e();
        if (r1 <= r2) goto L_0x00f1;
    L_0x00ed:
        r13.m1975b();
        goto L_0x00d0;
    L_0x00f1:
        r1 = r6.f11985j;
        r1 = r1.mo661a(r0);
        r2 = r6.f11985j;
        r2 = r2.mo663b();
        r1 = r1 - r2;
        if (r1 >= 0) goto L_0x010b;
    L_0x0100:
        r0 = r6.f11985j;
        r0 = r0.mo663b();
        r13.f2301b = r0;
        r13.f2302c = r10;
        goto L_0x00d0;
    L_0x010b:
        r1 = r6.f11985j;
        r1 = r1.mo665c();
        r2 = r6.f11985j;
        r2 = r2.mo664b(r0);
        r1 = r1 - r2;
        if (r1 >= 0) goto L_0x0125;
    L_0x011a:
        r0 = r6.f11985j;
        r0 = r0.mo665c();
        r13.f2301b = r0;
        r13.f2302c = r12;
        goto L_0x00d0;
    L_0x0125:
        r1 = r13.f2302c;
        if (r1 == 0) goto L_0x0137;
    L_0x0129:
        r1 = r6.f11985j;
        r0 = r1.mo664b(r0);
        r1 = r6.f11985j;
        r1 = r1.m1991a();
        r0 = r0 + r1;
        goto L_0x013d;
    L_0x0137:
        r1 = r6.f11985j;
        r0 = r1.mo661a(r0);
    L_0x013d:
        r13.f2301b = r0;
        goto L_0x00d0;
    L_0x0140:
        r0 = r17.m2151q();
        if (r0 <= 0) goto L_0x015e;
    L_0x0146:
        r0 = r6.m2134e(r10);
        r0 = android.support.v7.widget.RecyclerView.LayoutManager.m2070a(r0);
        r1 = r6.f11987l;
        if (r1 >= r0) goto L_0x0154;
    L_0x0152:
        r0 = r12;
        goto L_0x0155;
    L_0x0154:
        r0 = r10;
    L_0x0155:
        r1 = r6.f11986k;
        if (r0 != r1) goto L_0x015b;
    L_0x0159:
        r0 = r12;
        goto L_0x015c;
    L_0x015b:
        r0 = r10;
    L_0x015c:
        r13.f2302c = r0;
    L_0x015e:
        r13.m1975b();
        goto L_0x00d0;
    L_0x0163:
        r0 = r6.f11986k;
        r13.f2302c = r0;
        r0 = r6.f11986k;
        if (r0 == 0) goto L_0x0178;
    L_0x016b:
        r0 = r6.f11985j;
        r0 = r0.mo665c();
        r1 = r6.f11988m;
        r0 = r0 - r1;
        r13.f2301b = r0;
        goto L_0x00d0;
    L_0x0178:
        r0 = r6.f11985j;
        r0 = r0.mo663b();
        r1 = r6.f11988m;
        r0 = r0 + r1;
        r13.f2301b = r0;
        goto L_0x00d0;
    L_0x0185:
        r6.f11987l = r9;
        r6.f11988m = r11;
    L_0x0189:
        r0 = r10;
    L_0x018a:
        if (r0 != 0) goto L_0x022a;
    L_0x018c:
        r0 = r17.m2151q();
        if (r0 == 0) goto L_0x0217;
    L_0x0192:
        r0 = r17.m2158x();
        if (r0 == 0) goto L_0x01a4;
    L_0x0198:
        r1 = android.support.v7.widget.LinearLayoutManager.AnchorInfo.m1972a(r0, r8);
        if (r1 == 0) goto L_0x01a4;
    L_0x019e:
        r13.m1974a(r0);
    L_0x01a1:
        r0 = r12;
        goto L_0x0218;
    L_0x01a4:
        r0 = r6.f11977b;
        r1 = r6.f11979d;
        if (r0 != r1) goto L_0x0217;
    L_0x01aa:
        r0 = r13.f2302c;
        if (r0 == 0) goto L_0x01b7;
    L_0x01ae:
        r0 = r6.f11986k;
        if (r0 != 0) goto L_0x01c0;
    L_0x01b2:
        r0 = r17.m10672d(r18, r19);
        goto L_0x01d0;
    L_0x01b7:
        r0 = r6.f11986k;
        if (r0 == 0) goto L_0x01c0;
    L_0x01bb:
        r0 = r17.m10672d(r18, r19);
        goto L_0x01d0;
    L_0x01c0:
        r3 = 0;
        r4 = r17.m2151q();
        r5 = r19.getItemCount();
        r0 = r6;
        r1 = r7;
        r2 = r8;
        r0 = r0.mo3239a(r1, r2, r3, r4, r5);
    L_0x01d0:
        if (r0 == 0) goto L_0x0217;
    L_0x01d2:
        r13.m1976b(r0);
        r1 = r19.isPreLayout();
        if (r1 != 0) goto L_0x01a1;
    L_0x01db:
        r1 = r17.mo640c();
        if (r1 == 0) goto L_0x01a1;
    L_0x01e1:
        r1 = r6.f11985j;
        r1 = r1.mo661a(r0);
        r2 = r6.f11985j;
        r2 = r2.mo665c();
        if (r1 >= r2) goto L_0x0200;
    L_0x01ef:
        r1 = r6.f11985j;
        r0 = r1.mo664b(r0);
        r1 = r6.f11985j;
        r1 = r1.mo663b();
        if (r0 >= r1) goto L_0x01fe;
    L_0x01fd:
        goto L_0x0200;
    L_0x01fe:
        r0 = r10;
        goto L_0x0201;
    L_0x0200:
        r0 = r12;
    L_0x0201:
        if (r0 == 0) goto L_0x01a1;
    L_0x0203:
        r0 = r13.f2302c;
        if (r0 == 0) goto L_0x020e;
    L_0x0207:
        r0 = r6.f11985j;
        r0 = r0.mo665c();
        goto L_0x0214;
    L_0x020e:
        r0 = r6.f11985j;
        r0 = r0.mo663b();
    L_0x0214:
        r13.f2301b = r0;
        goto L_0x01a1;
    L_0x0217:
        r0 = r10;
    L_0x0218:
        if (r0 != 0) goto L_0x022a;
    L_0x021a:
        r13.m1975b();
        r0 = r6.f11979d;
        if (r0 == 0) goto L_0x0227;
    L_0x0221:
        r0 = r19.getItemCount();
        r0 = r0 - r12;
        goto L_0x0228;
    L_0x0227:
        r0 = r10;
    L_0x0228:
        r13.f2300a = r0;
    L_0x022a:
        r0 = r6.f11990o;
        r0.f2303d = r12;
    L_0x022e:
        r0 = r6.m10674h(r8);
        r1 = r6.f11976a;
        r1 = r1.f2318j;
        if (r1 < 0) goto L_0x023b;
    L_0x0238:
        r1 = r0;
        r0 = r10;
        goto L_0x023c;
    L_0x023b:
        r1 = r10;
    L_0x023c:
        r2 = r6.f11985j;
        r2 = r2.mo663b();
        r0 = r0 + r2;
        r2 = r6.f11985j;
        r2 = r2.mo671f();
        r1 = r1 + r2;
        r2 = r19.isPreLayout();
        if (r2 == 0) goto L_0x028a;
    L_0x0250:
        r2 = r6.f11987l;
        if (r2 == r9) goto L_0x028a;
    L_0x0254:
        r2 = r6.f11988m;
        if (r2 == r11) goto L_0x028a;
    L_0x0258:
        r2 = r6.f11987l;
        r2 = r6.mo623a(r2);
        if (r2 == 0) goto L_0x028a;
    L_0x0260:
        r3 = r6.f11986k;
        if (r3 == 0) goto L_0x0275;
    L_0x0264:
        r3 = r6.f11985j;
        r3 = r3.mo665c();
        r4 = r6.f11985j;
        r2 = r4.mo664b(r2);
        r3 = r3 - r2;
        r2 = r6.f11988m;
        r3 = r3 - r2;
        goto L_0x0285;
    L_0x0275:
        r3 = r6.f11985j;
        r2 = r3.mo661a(r2);
        r3 = r6.f11985j;
        r3 = r3.mo663b();
        r2 = r2 - r3;
        r3 = r6.f11988m;
        r3 = r3 - r2;
    L_0x0285:
        if (r3 <= 0) goto L_0x0289;
    L_0x0287:
        r0 = r0 + r3;
        goto L_0x028a;
    L_0x0289:
        r1 = r1 - r3;
    L_0x028a:
        r2 = r6.f11990o;
        r2 = r2.f2302c;
        if (r2 == 0) goto L_0x0298;
    L_0x0290:
        r2 = r6.f11986k;
        if (r2 == 0) goto L_0x0296;
    L_0x0294:
        r2 = r12;
        goto L_0x029d;
    L_0x0296:
        r2 = r9;
        goto L_0x029d;
    L_0x0298:
        r2 = r6.f11986k;
        if (r2 == 0) goto L_0x0294;
    L_0x029c:
        goto L_0x0296;
    L_0x029d:
        r3 = r6.f11990o;
        r6.mo3240a(r7, r8, r3, r2);
        r17.m2097a(r18);
        r2 = r6.f11976a;
        r3 = r17.m10656B();
        r2.f2320l = r3;
        r2 = r6.f11976a;
        r3 = r19.isPreLayout();
        r2.f2317i = r3;
        r2 = r6.f11990o;
        r2 = r2.f2302c;
        if (r2 == 0) goto L_0x0314;
    L_0x02bb:
        r2 = r6.f11990o;
        r6.m10669b(r2);
        r2 = r6.f11976a;
        r2.f2316h = r0;
        r0 = r6.f11976a;
        r6.m10662a(r7, r0, r8, r10);
        r0 = r6.f11976a;
        r0 = r0.f2310b;
        r2 = r6.f11976a;
        r2 = r2.f2312d;
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        if (r3 <= 0) goto L_0x02dc;
    L_0x02d7:
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        r1 = r1 + r3;
    L_0x02dc:
        r3 = r6.f11990o;
        r6.m10665a(r3);
        r3 = r6.f11976a;
        r3.f2316h = r1;
        r1 = r6.f11976a;
        r3 = r1.f2312d;
        r4 = r6.f11976a;
        r4 = r4.f2313e;
        r3 = r3 + r4;
        r1.f2312d = r3;
        r1 = r6.f11976a;
        r6.m10662a(r7, r1, r8, r10);
        r1 = r6.f11976a;
        r1 = r1.f2310b;
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        if (r3 <= 0) goto L_0x036c;
    L_0x02ff:
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        r6.m10680k(r2, r0);
        r0 = r6.f11976a;
        r0.f2316h = r3;
        r0 = r6.f11976a;
        r6.m10662a(r7, r0, r8, r10);
        r0 = r6.f11976a;
        r0 = r0.f2310b;
        goto L_0x036c;
    L_0x0314:
        r2 = r6.f11990o;
        r6.m10665a(r2);
        r2 = r6.f11976a;
        r2.f2316h = r1;
        r1 = r6.f11976a;
        r6.m10662a(r7, r1, r8, r10);
        r1 = r6.f11976a;
        r1 = r1.f2310b;
        r2 = r6.f11976a;
        r2 = r2.f2312d;
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        if (r3 <= 0) goto L_0x0335;
    L_0x0330:
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        r0 = r0 + r3;
    L_0x0335:
        r3 = r6.f11990o;
        r6.m10669b(r3);
        r3 = r6.f11976a;
        r3.f2316h = r0;
        r0 = r6.f11976a;
        r3 = r0.f2312d;
        r4 = r6.f11976a;
        r4 = r4.f2313e;
        r3 = r3 + r4;
        r0.f2312d = r3;
        r0 = r6.f11976a;
        r6.m10662a(r7, r0, r8, r10);
        r0 = r6.f11976a;
        r0 = r0.f2310b;
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        if (r3 <= 0) goto L_0x036c;
    L_0x0358:
        r3 = r6.f11976a;
        r3 = r3.f2311c;
        r6.m10678j(r2, r1);
        r1 = r6.f11976a;
        r1.f2316h = r3;
        r1 = r6.f11976a;
        r6.m10662a(r7, r1, r8, r10);
        r1 = r6.f11976a;
        r1 = r1.f2310b;
    L_0x036c:
        r2 = r17.m2151q();
        if (r2 <= 0) goto L_0x0392;
    L_0x0372:
        r2 = r6.f11986k;
        r3 = r6.f11979d;
        r2 = r2 ^ r3;
        if (r2 == 0) goto L_0x0386;
    L_0x0379:
        r2 = r6.m10661a(r1, r7, r8, r12);
        r0 = r0 + r2;
        r1 = r1 + r2;
        r2 = r6.m10668b(r0, r7, r8, r10);
        r0 = r0 + r2;
        r1 = r1 + r2;
        goto L_0x0392;
    L_0x0386:
        r2 = r6.m10668b(r0, r7, r8, r12);
        r0 = r0 + r2;
        r1 = r1 + r2;
        r2 = r6.m10661a(r1, r7, r8, r10);
        r0 = r0 + r2;
        r1 = r1 + r2;
    L_0x0392:
        r2 = r19.willRunPredictiveAnimations();
        if (r2 == 0) goto L_0x043b;
    L_0x0398:
        r2 = r17.m2151q();
        if (r2 == 0) goto L_0x043b;
    L_0x039e:
        r2 = r19.isPreLayout();
        if (r2 != 0) goto L_0x043b;
    L_0x03a4:
        r2 = r17.mo640c();
        if (r2 != 0) goto L_0x03ac;
    L_0x03aa:
        goto L_0x043b;
    L_0x03ac:
        r2 = r7.f2395d;
        r3 = r2.size();
        r4 = r6.m2134e(r10);
        r4 = android.support.v7.widget.RecyclerView.LayoutManager.m2070a(r4);
        r5 = r10;
        r11 = r5;
        r13 = r11;
    L_0x03bd:
        if (r5 >= r3) goto L_0x03f4;
    L_0x03bf:
        r14 = r2.get(r5);
        r14 = (android.support.v7.widget.RecyclerView.ViewHolder) r14;
        r15 = r14.m2237o();
        if (r15 != 0) goto L_0x03f0;
    L_0x03cb:
        r15 = r14.m2224c();
        if (r15 >= r4) goto L_0x03d3;
    L_0x03d1:
        r15 = r12;
        goto L_0x03d4;
    L_0x03d3:
        r15 = r10;
    L_0x03d4:
        r12 = r6.f11986k;
        if (r15 == r12) goto L_0x03da;
    L_0x03d8:
        r12 = r9;
        goto L_0x03db;
    L_0x03da:
        r12 = 1;
    L_0x03db:
        if (r12 != r9) goto L_0x03e7;
    L_0x03dd:
        r12 = r6.f11985j;
        r14 = r14.f2424c;
        r12 = r12.mo670e(r14);
        r11 = r11 + r12;
        goto L_0x03f0;
    L_0x03e7:
        r12 = r6.f11985j;
        r14 = r14.f2424c;
        r12 = r12.mo670e(r14);
        r13 = r13 + r12;
    L_0x03f0:
        r5 = r5 + 1;
        r12 = 1;
        goto L_0x03bd;
    L_0x03f4:
        r3 = r6.f11976a;
        r3.f2319k = r2;
        r2 = 0;
        if (r11 <= 0) goto L_0x0418;
    L_0x03fb:
        r3 = r17.m10657C();
        r3 = android.support.v7.widget.RecyclerView.LayoutManager.m2070a(r3);
        r6.m10680k(r3, r0);
        r0 = r6.f11976a;
        r0.f2316h = r11;
        r0 = r6.f11976a;
        r0.f2311c = r10;
        r0 = r6.f11976a;
        r0.m1978a(r2);
        r0 = r6.f11976a;
        r6.m10662a(r7, r0, r8, r10);
    L_0x0418:
        if (r13 <= 0) goto L_0x0437;
    L_0x041a:
        r0 = r17.m10658D();
        r0 = android.support.v7.widget.RecyclerView.LayoutManager.m2070a(r0);
        r6.m10678j(r0, r1);
        r0 = r6.f11976a;
        r0.f2316h = r13;
        r0 = r6.f11976a;
        r0.f2311c = r10;
        r0 = r6.f11976a;
        r0.m1978a(r2);
        r0 = r6.f11976a;
        r6.m10662a(r7, r0, r8, r10);
    L_0x0437:
        r0 = r6.f11976a;
        r0.f2319k = r2;
    L_0x043b:
        r0 = r19.isPreLayout();
        if (r0 != 0) goto L_0x044a;
    L_0x0441:
        r0 = r6.f11985j;
        r1 = r0.mo669e();
        r0.f2339b = r1;
        goto L_0x044f;
    L_0x044a:
        r0 = r6.f11990o;
        r0.m1973a();
    L_0x044f:
        r0 = r6.f11979d;
        r6.f11977b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.c(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State):void");
    }

    public void mo628a(State state) {
        super.mo628a(state);
        this.f11989n = null;
        this.f11987l = -1;
        this.f11988m = Integer.MIN_VALUE;
        this.f11990o.m1973a();
    }

    private int m10661a(int i, Recycler recycler, State state, boolean z) {
        int c = this.f11985j.mo665c() - i;
        if (c <= 0) {
            return 0;
        }
        recycler = -m10670c(-c, recycler, state);
        i += recycler;
        if (z) {
            int c2 = this.f11985j.mo665c() - i;
            if (c2 > null) {
                this.f11985j.mo662a(c2);
                return c2 + recycler;
            }
        }
        return recycler;
    }

    private int m10668b(int i, Recycler recycler, State state, boolean z) {
        int b = i - this.f11985j.mo663b();
        if (b <= 0) {
            return 0;
        }
        recycler = -m10670c(b, recycler, state);
        i += recycler;
        if (z) {
            i -= this.f11985j.mo663b();
            if (i > 0) {
                this.f11985j.mo662a(-i);
                return recycler - i;
            }
        }
        return recycler;
    }

    private void m10665a(AnchorInfo anchorInfo) {
        m10678j(anchorInfo.f2300a, anchorInfo.f2301b);
    }

    private void m10678j(int i, int i2) {
        this.f11976a.f2311c = this.f11985j.mo665c() - i2;
        this.f11976a.f2313e = this.f11986k ? -1 : 1;
        this.f11976a.f2312d = i;
        this.f11976a.f2314f = 1;
        this.f11976a.f2310b = i2;
        this.f11976a.f2315g = Integer.MIN_VALUE;
    }

    private void m10669b(AnchorInfo anchorInfo) {
        m10680k(anchorInfo.f2300a, anchorInfo.f2301b);
    }

    private void m10680k(int i, int i2) {
        this.f11976a.f2311c = i2 - this.f11985j.mo663b();
        this.f11976a.f2312d = i;
        this.f11976a.f2313e = this.f11986k ? 1 : -1;
        this.f11976a.f2314f = -1;
        this.f11976a.f2310b = i2;
        this.f11976a.f2315g = Integer.MIN_VALUE;
    }

    final void m10718i() {
        if (this.f11976a == null) {
            this.f11976a = new LayoutState();
        }
        if (this.f11985j == null) {
            this.f11985j = OrientationHelper.m1989a(this, this.f11984i);
        }
    }

    public void mo638c(int i) {
        this.f11987l = i;
        this.f11988m = Integer.MIN_VALUE;
        if (this.f11989n != 0) {
            this.f11989n.invalidateAnchor();
        }
        m2148n();
    }

    public final void m10711e(int i, int i2) {
        this.f11987l = i;
        this.f11988m = i2;
        if (this.f11989n != 0) {
            this.f11989n.invalidateAnchor();
        }
        m2148n();
    }

    public int mo622a(int i, Recycler recycler, State state) {
        if (this.f11984i == 1) {
            return 0;
        }
        return m10670c(i, recycler, state);
    }

    public int mo633b(int i, Recycler recycler, State state) {
        if (this.f11984i == 0) {
            return 0;
        }
        return m10670c(i, recycler, state);
    }

    public final int mo634b(State state) {
        return m10675i(state);
    }

    public final int mo637c(State state) {
        return m10675i(state);
    }

    public final int mo642d(State state) {
        return m10677j(state);
    }

    public final int mo644e(State state) {
        return m10677j(state);
    }

    public final int mo646f(State state) {
        return m10679k(state);
    }

    public final int mo648g(State state) {
        return m10679k(state);
    }

    private int m10675i(State state) {
        if (m2151q() == 0) {
            return null;
        }
        m10718i();
        return ScrollbarHelper.m2257a(state, this.f11985j, m10671c(this.f11980e ^ 1), m10673d(this.f11980e ^ 1), this, this.f11980e, this.f11986k);
    }

    private int m10677j(State state) {
        if (m2151q() == 0) {
            return null;
        }
        m10718i();
        return ScrollbarHelper.m2256a(state, this.f11985j, m10671c(this.f11980e ^ 1), m10673d(this.f11980e ^ 1), this, this.f11980e);
    }

    private int m10679k(State state) {
        if (m2151q() == 0) {
            return null;
        }
        m10718i();
        return ScrollbarHelper.m2258b(state, this.f11985j, m10671c(this.f11980e ^ 1), m10673d(this.f11980e ^ 1), this, this.f11980e);
    }

    private void m10664a(int i, int i2, boolean z, State state) {
        this.f11976a.f2320l = m10656B();
        this.f11976a.f2316h = m10674h(state);
        this.f11976a.f2314f = i;
        state = -1;
        View D;
        LayoutState layoutState;
        if (i == 1) {
            i = this.f11976a;
            i.f2316h += this.f11985j.mo671f();
            D = m10658D();
            layoutState = this.f11976a;
            if (!this.f11986k) {
                state = 1;
            }
            layoutState.f2313e = state;
            this.f11976a.f2312d = LayoutManager.m2070a(D) + this.f11976a.f2313e;
            this.f11976a.f2310b = this.f11985j.mo664b(D);
            i = this.f11985j.mo664b(D) - this.f11985j.mo665c();
        } else {
            D = m10657C();
            layoutState = this.f11976a;
            layoutState.f2316h += this.f11985j.mo663b();
            layoutState = this.f11976a;
            if (this.f11986k) {
                state = 1;
            }
            layoutState.f2313e = state;
            this.f11976a.f2312d = LayoutManager.m2070a(D) + this.f11976a.f2313e;
            this.f11976a.f2310b = this.f11985j.mo661a(D);
            i = (-this.f11985j.mo661a(D)) + this.f11985j.mo663b();
        }
        this.f11976a.f2311c = i2;
        if (z) {
            i2 = this.f11976a;
            i2.f2311c -= i;
        }
        this.f11976a.f2315g = i;
    }

    private boolean m10656B() {
        return this.f11985j.mo673g() == 0 && this.f11985j.mo667d() == 0;
    }

    void mo3242a(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.f2312d;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.mo620a(i, Math.max(null, layoutState.f2315g));
        }
    }

    public final void mo626a(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        int i3 = -1;
        if (this.f11989n == null || !this.f11989n.hasValidAnchor()) {
            m10655A();
            z = this.f11986k;
            i2 = this.f11987l == -1 ? z ? i - 1 : 0 : this.f11987l;
        } else {
            z = this.f11989n.mAnchorLayoutFromEnd;
            i2 = this.f11989n.mAnchorPosition;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f11983h && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.mo620a(i2, 0);
            i2 += i3;
        }
    }

    public final void mo625a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.f11984i != 0) {
            i = i2;
        }
        if (m2151q() != 0) {
            if (i != 0) {
                m10718i();
                m10664a(i > 0 ? 1 : -1, Math.abs(i), true, state);
                mo3242a(state, this.f11976a, layoutPrefetchRegistry);
            }
        }
    }

    private int m10670c(int i, Recycler recycler, State state) {
        if (m2151q() != 0) {
            if (i != 0) {
                this.f11976a.f2309a = true;
                m10718i();
                int i2 = i > 0 ? 1 : -1;
                int abs = Math.abs(i);
                m10664a(i2, abs, true, state);
                int a = this.f11976a.f2315g + m10662a(recycler, this.f11976a, state, false);
                if (a < 0) {
                    return 0;
                }
                if (abs > a) {
                    i = i2 * a;
                }
                this.f11985j.mo662a(-i);
                this.f11976a.f2318j = i;
                return i;
            }
        }
        return 0;
    }

    public final void mo632a(String str) {
        if (this.f11989n == null) {
            super.mo632a(str);
        }
    }

    private void m10666a(Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (i2--; i2 >= i; i2--) {
                    m2094a(i2, recycler);
                }
                return;
            }
            while (i > i2) {
                m2094a(i, recycler);
                i--;
            }
        }
    }

    private void m10667a(Recycler recycler, LayoutState layoutState) {
        if (layoutState.f2309a) {
            if (!layoutState.f2320l) {
                int q;
                int d;
                View e;
                View e2;
                if (layoutState.f2314f == -1) {
                    layoutState = layoutState.f2315g;
                    q = m2151q();
                    if (layoutState >= null) {
                        d = this.f11985j.mo667d() - layoutState;
                        int i;
                        if (this.f11986k != null) {
                            i = null;
                            while (i < q) {
                                e = m2134e(i);
                                if (this.f11985j.mo661a(e) >= d) {
                                    if (this.f11985j.mo668d(e) >= d) {
                                        i++;
                                    }
                                }
                                m10666a(recycler, 0, i);
                                return;
                            }
                            return;
                        }
                        q--;
                        i = q;
                        while (i >= null) {
                            e2 = m2134e(i);
                            if (this.f11985j.mo661a(e2) >= d) {
                                if (this.f11985j.mo668d(e2) >= d) {
                                    i--;
                                }
                            }
                            m10666a(recycler, q, i);
                            return;
                        }
                    }
                    return;
                }
                layoutState = layoutState.f2315g;
                if (layoutState >= null) {
                    q = m2151q();
                    if (this.f11986k) {
                        q--;
                        d = q;
                        while (d >= 0) {
                            e2 = m2134e(d);
                            if (this.f11985j.mo664b(e2) <= layoutState) {
                                if (this.f11985j.mo666c(e2) <= layoutState) {
                                    d--;
                                }
                            }
                            m10666a(recycler, q, d);
                            return;
                        }
                        return;
                    }
                    d = 0;
                    while (d < q) {
                        e = m2134e(d);
                        if (this.f11985j.mo664b(e) <= layoutState) {
                            if (this.f11985j.mo666c(e) <= layoutState) {
                                d++;
                            }
                        }
                        m10666a(recycler, 0, d);
                        return;
                    }
                }
            }
        }
    }

    private int m10662a(Recycler recycler, LayoutState layoutState, State state, boolean z) {
        int i = layoutState.f2311c;
        if (layoutState.f2315g != Integer.MIN_VALUE) {
            if (layoutState.f2311c < 0) {
                layoutState.f2315g += layoutState.f2311c;
            }
            m10667a(recycler, layoutState);
        }
        int i2 = layoutState.f2311c + layoutState.f2316h;
        LayoutChunkResult layoutChunkResult = this.f11982g;
        while (true) {
            if ((!layoutState.f2320l && i2 <= 0) || !layoutState.m1979a(state)) {
                break;
            }
            layoutChunkResult.f2305a = 0;
            layoutChunkResult.f2306b = false;
            layoutChunkResult.f2307c = false;
            layoutChunkResult.f2308d = false;
            mo3241a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f2306b) {
                layoutState.f2310b += layoutChunkResult.f2305a * layoutState.f2314f;
                if (!(layoutChunkResult.f2307c && this.f11976a.f2319k == null && state.isPreLayout())) {
                    layoutState.f2311c -= layoutChunkResult.f2305a;
                    i2 -= layoutChunkResult.f2305a;
                }
                if (layoutState.f2315g != Integer.MIN_VALUE) {
                    layoutState.f2315g += layoutChunkResult.f2305a;
                    if (layoutState.f2311c < 0) {
                        layoutState.f2315g += layoutState.f2311c;
                    }
                    m10667a(recycler, layoutState);
                }
                if (z && layoutChunkResult.f2308d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.f2311c;
    }

    void mo3241a(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        View a = layoutState.m1977a(recycler);
        if (a == null) {
            layoutChunkResult.f2306b = true;
            return;
        }
        int v;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (layoutState.f2319k == null) {
            if (this.f11986k == (layoutState.f2314f == -1)) {
                super.m2104a(a, -1, false);
            } else {
                super.m2104a(a, 0, false);
            }
        } else {
            if (this.f11986k == (layoutState.f2314f == -1)) {
                super.m2104a(a, -1, true);
            } else {
                super.m2104a(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect itemDecorInsetsForChild = this.f2372q.getItemDecorInsetsForChild(a);
        int i2 = 0 + (itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom);
        int a2 = LayoutManager.m2069a(this.f2367D, this.f2365B, (((m2154t() + m2156v()) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + ((itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + 0), layoutParams2.width, mo645e());
        i2 = LayoutManager.m2069a(this.f2368E, this.f2366C, (((m2155u() + m2157w()) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + i2, layoutParams2.height, mo647f());
        if (m2112a(a, a2, i2, layoutParams2)) {
            a.measure(a2, i2);
        }
        layoutChunkResult.f2305a = this.f11985j.mo670e(a);
        int i3;
        if (this.f11984i == 1) {
            if (m10717h()) {
                v = this.f2367D - m2156v();
                i2 = v - this.f11985j.mo672f(a);
            } else {
                i2 = m2154t();
                v = this.f11985j.mo672f(a) + i2;
            }
            if (layoutState.f2314f == -1) {
                i = layoutState.f2310b;
                i3 = v;
                v = layoutState.f2310b - layoutChunkResult.f2305a;
                layoutState = i3;
            } else {
                i3 = layoutState.f2310b;
                i = layoutState.f2310b + layoutChunkResult.f2305a;
                layoutState = v;
                v = i3;
            }
        } else {
            v = m2155u();
            i2 = this.f11985j.mo672f(a) + v;
            if (layoutState.f2314f == -1) {
                i3 = i2;
                i2 = layoutState.f2310b - layoutChunkResult.f2305a;
                layoutState = layoutState.f2310b;
            } else {
                i = layoutState.f2310b;
                layoutState = layoutState.f2310b + layoutChunkResult.f2305a;
                i3 = i2;
                i2 = i;
            }
            i = i3;
        }
        LayoutManager.m2073a(a, i2, v, (int) layoutState, i);
        if (!(layoutParams.f2382c.m2237o() == null && layoutParams.f2382c.m2243u() == null)) {
            layoutChunkResult.f2307c = true;
        }
        layoutChunkResult.f2308d = a.hasFocusable();
    }

    final int mo641d(int i) {
        if (i == 17) {
            return this.f11984i == 0 ? -1 : Integer.MIN_VALUE;
        } else {
            if (i == 33) {
                return this.f11984i == 1 ? -1 : Integer.MIN_VALUE;
            } else {
                if (i == 66) {
                    return this.f11984i == 0 ? 1 : Integer.MIN_VALUE;
                } else {
                    if (i == 130) {
                        return this.f11984i == 1 ? 1 : Integer.MIN_VALUE;
                    } else {
                        switch (i) {
                            case 1:
                                return (this.f11984i == 1 || m10717h() == 0) ? -1 : 1;
                            case 2:
                                return (this.f11984i == 1 || m10717h() == 0) ? 1 : -1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }
    }

    private View m10657C() {
        return m2134e(this.f11986k ? m2151q() - 1 : 0);
    }

    private View m10658D() {
        return m2134e(this.f11986k ? 0 : m2151q() - 1);
    }

    private View m10671c(boolean z) {
        if (this.f11986k) {
            return m10663a(m2151q() - 1, -1, z, true);
        }
        return m10663a(0, m2151q(), z, true);
    }

    private View m10673d(boolean z) {
        if (this.f11986k) {
            return m10663a(0, m2151q(), z, true);
        }
        return m10663a(m2151q() - 1, -1, z, true);
    }

    private View m10672d(Recycler recycler, State state) {
        return mo3239a(recycler, state, m2151q() - 1, -1, state.getItemCount());
    }

    View mo3239a(Recycler recycler, State state, int i, int i2, int i3) {
        m10718i();
        recycler = this.f11985j.mo663b();
        state = this.f11985j.mo665c();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View e = m2134e(i);
            int a = LayoutManager.m2070a(e);
            if (a >= 0 && a < i3) {
                if (!((LayoutParams) e.getLayoutParams()).f2382c.m2237o()) {
                    if (this.f11985j.mo661a(e) < state) {
                        if (this.f11985j.mo664b(e) >= recycler) {
                            return e;
                        }
                    }
                    if (view == null) {
                        view = e;
                    }
                } else if (view2 == null) {
                    view2 = e;
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View m10659E() {
        return m10681l(0, m2151q());
    }

    private View m10660F() {
        return m10681l(m2151q() - 1, -1);
    }

    public final int m10720k() {
        View a = m10663a(0, m2151q(), false, true);
        if (a == null) {
            return -1;
        }
        return LayoutManager.m2070a(a);
    }

    public final int m10721l() {
        View a = m10663a(0, m2151q(), true, false);
        if (a == null) {
            return -1;
        }
        return LayoutManager.m2070a(a);
    }

    public final int m10722m() {
        View a = m10663a(m2151q() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return LayoutManager.m2070a(a);
    }

    private View m10663a(int i, int i2, boolean z, boolean z2) {
        m10718i();
        int i3 = 320;
        z = z ? true : true;
        if (!z2) {
            i3 = 0;
        }
        if (this.f11984i) {
            return this.s.m2369a(i, i2, z, i3);
        }
        return this.r.m2369a(i, i2, z, i3);
    }

    private View m10681l(int i, int i2) {
        m10718i();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return m2134e(i);
        }
        int i3;
        int i4;
        if (this.f11985j.mo661a(m2134e(i)) < this.f11985j.mo663b()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.f11984i == 0) {
            return this.r.m2369a(i, i2, i3, i4);
        }
        return this.s.m2369a(i, i2, i3, i4);
    }

    public View mo624a(View view, int i, Recycler recycler, State state) {
        m10655A();
        if (m2151q() == null) {
            return null;
        }
        int d = mo641d(i);
        if (d == -2147483648) {
            return null;
        }
        m10718i();
        m10718i();
        m10664a(d, (int) (0.33333334f * ((float) this.f11985j.mo669e())), false, state);
        this.f11976a.f2315g = Integer.MIN_VALUE;
        this.f11976a.f2309a = false;
        m10662a(recycler, this.f11976a, state, true);
        if (d == -1) {
            if (this.f11986k != null) {
                recycler = m10660F();
            } else {
                recycler = m10659E();
            }
        } else if (this.f11986k != null) {
            recycler = m10659E();
        } else {
            recycler = m10660F();
        }
        if (d == -1) {
            view = m10657C();
        } else {
            view = m10658D();
        }
        if (view.hasFocusable() == 0) {
            return recycler;
        }
        if (recycler == null) {
            return null;
        }
        return view;
    }

    public boolean mo640c() {
        return this.f11989n == null && this.f11977b == this.f11979d;
    }

    protected final boolean m10717h() {
        return ViewCompat.m1242f(this.f2372q) == 1;
    }

    final boolean mo649j() {
        if (!(this.f2366C == 1073741824 || this.f2365B == 1073741824)) {
            boolean z;
            int q = m2151q();
            for (int i = 0; i < q; i++) {
                ViewGroup.LayoutParams layoutParams = m2134e(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
