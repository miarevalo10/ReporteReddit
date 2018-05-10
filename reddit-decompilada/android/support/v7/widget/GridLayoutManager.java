package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f16699a = null;
    int f16700b = -1;
    int[] f16701c;
    View[] f16702d;
    final SparseIntArray f16703e = new SparseIntArray();
    final SparseIntArray f16704f = new SparseIntArray();
    SpanSizeLookup f16705g = new DefaultSpanSizeLookup();
    final Rect f16706h = new Rect();

    public static abstract class SpanSizeLookup {
        final SparseIntArray f2287a = new SparseIntArray();
        private boolean f2288b = false;

        public static int m1968c(int i, int i2) {
            int i3 = 0;
            int i4 = i3;
            int i5 = i4;
            while (i3 < i) {
                i4++;
                if (i4 == i2) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i2) {
                    i5++;
                    i4 = 1;
                }
                i3++;
            }
            return i4 + 1 > i2 ? i5 + 1 : i5;
        }

        final int m1970b(int i, int i2) {
            if (!this.f2288b) {
                return mo621a(i, i2);
            }
            int i3 = this.f2287a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i2 = mo621a(i, i2);
            this.f2287a.put(i, i2);
            return i2;
        }

        public int mo621a(int i, int i2) {
            if (1 == i2) {
                return 0;
            }
            int size;
            int i3;
            if (this.f2288b && this.f2287a.size() > 0) {
                size = this.f2287a.size() - 1;
                i3 = 0;
                while (i3 <= size) {
                    int i4 = (i3 + size) >>> 1;
                    if (this.f2287a.keyAt(i4) < i) {
                        i3 = i4 + 1;
                    } else {
                        size = i4 - 1;
                    }
                }
                i3--;
                i3 = (i3 < 0 || i3 >= this.f2287a.size()) ? -1 : this.f2287a.keyAt(i3);
                if (i3 >= 0) {
                    size = this.f2287a.get(i3) + 1;
                    i3++;
                    while (i3 < i) {
                        size++;
                        if (size == i2) {
                            size = 0;
                        } else if (size > i2) {
                            size = 1;
                        }
                        i3++;
                    }
                    if (size + 1 > i2) {
                        return size;
                    }
                    return 0;
                }
            }
            i3 = 0;
            size = i3;
            while (i3 < i) {
                size++;
                if (size == i2) {
                    size = 0;
                } else if (size > i2) {
                    size = 1;
                }
                i3++;
            }
            if (size + 1 > i2) {
                return 0;
            }
            return size;
        }
    }

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public final int mo621a(int i, int i2) {
            return i % i2;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        int f11974a = -1;
        int f11975b = 0;

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
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m16931j(LayoutManager.m2071a(context, attributeSet, i, i2).f2361b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m16931j(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m16931j(i);
    }

    public final void mo3243a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo3243a(false);
    }

    public final int mo718a(Recycler recycler, State state) {
        if (this.i == 0) {
            return this.f16700b;
        }
        if (state.getItemCount() <= 0) {
            return null;
        }
        return m16923a(recycler, state, state.getItemCount() - 1) + 1;
    }

    public final int mo726b(Recycler recycler, State state) {
        if (this.i == 1) {
            return this.f16700b;
        }
        if (state.getItemCount() <= 0) {
            return null;
        }
        return m16923a(recycler, state, state.getItemCount() - 1) + 1;
    }

    public final void mo724a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            recycler = m16923a(recycler, state, layoutParams2.f2382c.m2224c());
            boolean z;
            if (this.i == null) {
                state = layoutParams2.f11974a;
                int i = layoutParams2.f11975b;
                z = this.f16700b > 1 && layoutParams2.f11975b == this.f16700b;
                accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(state, i, recycler, 1, z, false));
                return;
            }
            int i2 = layoutParams2.f11974a;
            int i3 = layoutParams2.f11975b;
            z = this.f16700b > 1 && layoutParams2.f11975b == this.f16700b;
            accessibilityNodeInfoCompat.m1325a(CollectionItemInfoCompat.m1317a(recycler, 1, i2, i3, z, false));
            return;
        }
        super.m2106a(view, accessibilityNodeInfoCompat);
    }

    public final void mo639c(Recycler recycler, State state) {
        if (state.isPreLayout()) {
            int q = m2151q();
            for (int i = 0; i < q; i++) {
                LayoutParams layoutParams = (LayoutParams) m2134e(i).getLayoutParams();
                int c = layoutParams.f2382c.m2224c();
                this.f16703e.put(c, layoutParams.f11975b);
                this.f16704f.put(c, layoutParams.f11974a);
            }
        }
        super.mo639c(recycler, state);
        this.f16703e.clear();
        this.f16704f.clear();
    }

    public final void mo628a(State state) {
        super.mo628a(state);
        this.f16699a = null;
    }

    public final void mo722a(int i, int i2) {
        this.f16705g.f2287a.clear();
    }

    public final void mo721a() {
        this.f16705g.f2287a.clear();
    }

    public final void mo727b(int i, int i2) {
        this.f16705g.f2287a.clear();
    }

    public final void mo728c(int i, int i2) {
        this.f16705g.f2287a.clear();
    }

    public final void mo729d(int i, int i2) {
        this.f16705g.f2287a.clear();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams mo636b() {
        if (this.i == 0) {
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

    public final void mo723a(Rect rect, int i, int i2) {
        if (this.f16701c == null) {
            super.mo723a(rect, i, i2);
        }
        int t = m2154t() + m2156v();
        int u = m2155u() + m2157w();
        if (this.i == 1) {
            rect = LayoutManager.m2068a(i2, (int) rect.height() + u, ViewCompat.m1253n(this.f2372q));
            i = LayoutManager.m2068a(i, this.f16701c[this.f16701c.length - 1] + t, ViewCompat.m1252m(this.f2372q));
        } else {
            i = LayoutManager.m2068a(i, (int) rect.width() + t, ViewCompat.m1252m(this.f2372q));
            rect = LayoutManager.m2068a(i2, (int) this.f16701c[this.f16701c.length - 1] + u, ViewCompat.m1253n(this.f2372q));
        }
        m2145i(i, rect);
    }

    private void m16929i(int i) {
        int[] iArr = this.f16701c;
        int i2 = this.f16700b;
        int i3 = 1;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i2 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i2;
        i %= i2;
        int i6 = 0;
        while (i3 <= i2) {
            int i7;
            i4 += i;
            if (i4 <= 0 || i2 - i4 >= i) {
                i7 = i5;
            } else {
                i7 = i5 + 1;
                i4 -= i2;
            }
            i6 += i7;
            iArr[i3] = i6;
            i3++;
        }
        this.f16701c = iArr;
    }

    private int m16930j(int i, int i2) {
        if (this.i == 1 && m10717h()) {
            return this.f16701c[this.f16700b - i] - this.f16701c[(this.f16700b - i) - i2];
        }
        return this.f16701c[i2 + i] - this.f16701c[i];
    }

    final void mo3240a(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
        super.mo3240a(recycler, state, anchorInfo, i);
        m16921A();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            i = i == 1 ? 1 : 0;
            int b = m16926b(recycler, state, anchorInfo.f2300a);
            if (i != 0) {
                while (b > 0 && anchorInfo.f2300a > 0) {
                    anchorInfo.f2300a--;
                    b = m16926b(recycler, state, anchorInfo.f2300a);
                }
            } else {
                i = state.getItemCount() - 1;
                int i2 = anchorInfo.f2300a;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    int b2 = m16926b(recycler, state, i3);
                    if (b2 <= b) {
                        break;
                    }
                    i2 = i3;
                    b = b2;
                }
                anchorInfo.f2300a = i2;
            }
        }
        m16922B();
    }

    private void m16922B() {
        if (this.f16702d == null || this.f16702d.length != this.f16700b) {
            this.f16702d = new View[this.f16700b];
        }
    }

    public final int mo622a(int i, Recycler recycler, State state) {
        m16921A();
        m16922B();
        return super.mo622a(i, recycler, state);
    }

    public final int mo633b(int i, Recycler recycler, State state) {
        m16921A();
        m16922B();
        return super.mo633b(i, recycler, state);
    }

    final View mo3239a(Recycler recycler, State state, int i, int i2, int i3) {
        m10718i();
        int b = this.j.mo663b();
        int c = this.j.mo665c();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View e = m2134e(i);
            int a = LayoutManager.m2070a(e);
            if (a >= 0 && a < i3 && m16926b(recycler, state, a) == 0) {
                if (!((android.support.v7.widget.RecyclerView.LayoutParams) e.getLayoutParams()).f2382c.m2237o()) {
                    if (this.j.mo661a(e) < c) {
                        if (this.j.mo664b(e) >= b) {
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

    private int m16923a(Recycler recycler, State state, int i) {
        if (state.isPreLayout() == null) {
            return SpanSizeLookup.m1968c(i, this.f16700b);
        }
        recycler = recycler.m2177a(i);
        if (recycler != -1) {
            return SpanSizeLookup.m1968c(recycler, this.f16700b);
        }
        state = new StringBuilder("Cannot find span size for pre layout position. ");
        state.append(i);
        Log.w("GridLayoutManager", state.toString());
        return null;
    }

    private int m16926b(Recycler recycler, State state, int i) {
        if (state.isPreLayout() == null) {
            return this.f16705g.m1970b(i, this.f16700b);
        }
        state = this.f16704f.get(i, -1);
        if (state != -1) {
            return state;
        }
        recycler = recycler.m2177a(i);
        if (recycler != -1) {
            return this.f16705g.m1970b(recycler, this.f16700b);
        }
        state = new StringBuilder("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        state.append(i);
        Log.w("GridLayoutManager", state.toString());
        return null;
    }

    private int m16928c(Recycler recycler, State state, int i) {
        if (state.isPreLayout() == null) {
            return 1;
        }
        state = this.f16703e.get(i, -1);
        if (state != -1) {
            return state;
        }
        if (recycler.m2177a(i) != -1) {
            return 1;
        }
        state = new StringBuilder("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        state.append(i);
        Log.w("GridLayoutManager", state.toString());
        return 1;
    }

    final void mo3242a(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.f16700b;
        for (int i2 = 0; i2 < this.f16700b && layoutState.m1979a(state) && i > 0; i2++) {
            layoutPrefetchRegistry.mo620a(layoutState.f2312d, Math.max(0, layoutState.f2315g));
            i--;
            layoutState.f2312d += layoutState.f2313e;
        }
    }

    final void mo3241a(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        Recycler recycler2 = recycler;
        State state2 = state;
        LayoutState layoutState2 = layoutState;
        LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int h = this.j.mo674h();
        boolean z = false;
        boolean z2 = h != 1073741824;
        int i = m2151q() > 0 ? r0.f16701c[r0.f16700b] : 0;
        if (z2) {
            m16921A();
        }
        boolean z3 = layoutState2.f2313e == 1;
        int i2 = r0.f16700b;
        if (!z3) {
            i2 = m16926b(recycler2, state2, layoutState2.f2312d) + m16928c(recycler2, state2, layoutState2.f2312d);
        }
        int i3 = i2;
        i2 = 0;
        while (i2 < r0.f16700b && layoutState2.m1979a(state2) && i3 > 0) {
            int i4 = layoutState2.f2312d;
            int c = m16928c(recycler2, state2, i4);
            if (c <= r0.f16700b) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                View a = layoutState2.m1977a(recycler2);
                if (a == null) {
                    break;
                }
                r0.f16702d[i2] = a;
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Item at position ");
                stringBuilder.append(i4);
                stringBuilder.append(" requires ");
                stringBuilder.append(c);
                stringBuilder.append(" spans but GridLayoutManager has only ");
                stringBuilder.append(r0.f16700b);
                stringBuilder.append(" spans.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i2 == 0) {
            layoutChunkResult2.f2306b = true;
            return;
        }
        int i5;
        float f = 0.0f;
        m16924a(recycler2, state2, i2, z3);
        int i6 = 0;
        int i7 = i6;
        while (i6 < i2) {
            View view = r0.f16702d[i6];
            if (layoutState2.f2319k == null) {
                if (z3) {
                    super.m2104a(view, -1, z);
                } else {
                    super.m2104a(view, (int) z, z);
                }
            } else if (z3) {
                super.m2104a(view, -1, true);
            } else {
                super.m2104a(view, (int) z, true);
            }
            m2128c(view, r0.f16706h);
            m16927b(view, h, z);
            i3 = r0.j.mo670e(view);
            if (i3 > i7) {
                i7 = i3;
            }
            float f2 = (1.0f * ((float) r0.j.mo672f(view))) / ((float) ((LayoutParams) view.getLayoutParams()).f11975b);
            if (f2 > f) {
                f = f2;
            }
            i6++;
            z = false;
        }
        if (z2) {
            m16929i(Math.max(Math.round(f * ((float) r0.f16700b)), i));
            i7 = 0;
            for (i6 = 0; i6 < i2; i6++) {
                View view2 = r0.f16702d[i6];
                m16927b(view2, 1073741824, true);
                h = r0.j.mo670e(view2);
                if (h > i7) {
                    i7 = h;
                }
            }
        }
        for (i6 = 0; i6 < i2; i6++) {
            LayoutParams layoutParams;
            int j;
            view2 = r0.f16702d[i6];
            if (r0.j.mo670e(view2) != i7) {
                layoutParams = (LayoutParams) view2.getLayoutParams();
                Rect rect = layoutParams.d;
                int i8 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                i = ((rect.left + rect.right) + layoutParams.leftMargin) + layoutParams.rightMargin;
                j = m16930j(layoutParams.f11974a, layoutParams.f11975b);
                if (r0.i == 1) {
                    int a2 = LayoutManager.m2069a(j, 1073741824, i, layoutParams.width, false);
                    j = MeasureSpec.makeMeasureSpec(i7 - i8, 1073741824);
                    i = a2;
                } else {
                    i = MeasureSpec.makeMeasureSpec(i7 - i, 1073741824);
                    j = LayoutManager.m2069a(j, 1073741824, i8, layoutParams.height, false);
                }
                m16925a(view2, i, j, true);
            }
        }
        int i9 = 0;
        layoutChunkResult2.f2305a = i7;
        if (r0.i != 1) {
            if (layoutState2.f2314f == -1) {
                j = layoutState2.f2310b;
                i5 = j - i7;
                i6 = j;
            } else {
                j = layoutState2.f2310b;
                i6 = j + i7;
                i5 = j;
            }
            i7 = 0;
            j = i7;
        } else if (layoutState2.f2314f == -1) {
            j = layoutState2.f2310b;
            i6 = j - i7;
            i7 = j;
            i5 = 0;
            j = i6;
            i6 = i5;
        } else {
            j = layoutState2.f2310b;
            i7 = j + i7;
            i6 = 0;
            i5 = i6;
        }
        while (i9 < i2) {
            view2 = r0.f16702d[i9];
            layoutParams = (LayoutParams) view2.getLayoutParams();
            if (r0.i != 1) {
                i7 = m2155u() + r0.f16701c[layoutParams.f11974a];
                j = i7;
                i7 = r0.j.mo672f(view2) + i7;
            } else if (m10717h()) {
                i6 = m2154t() + r0.f16701c[r0.f16700b - layoutParams.f11974a];
                i5 = i6 - r0.j.mo672f(view2);
            } else {
                i6 = m2154t() + r0.f16701c[layoutParams.f11974a];
                i5 = i6;
                i6 = r0.j.mo672f(view2) + i6;
            }
            LayoutManager.m2073a(view2, i5, j, i6, i7);
            if (layoutParams.f2382c.m2237o() || layoutParams.f2382c.m2243u()) {
                layoutChunkResult2.f2307c = true;
            }
            layoutChunkResult2.f2308d = view2.hasFocusable() | layoutChunkResult2.f2308d;
            i9++;
        }
        Arrays.fill(r0.f16702d, null);
    }

    private void m16927b(View view, int i, boolean z) {
        int a;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.d;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = ((rect.left + rect.right) + layoutParams.leftMargin) + layoutParams.rightMargin;
        int j = m16930j(layoutParams.f11974a, layoutParams.f11975b);
        if (this.i == 1) {
            i = LayoutManager.m2069a(j, i, i3, layoutParams.width, false);
            a = LayoutManager.m2069a(this.j.mo669e(), this.f2366C, i2, layoutParams.height, true);
        } else {
            i = LayoutManager.m2069a(j, i, i2, layoutParams.height, false);
            int a2 = LayoutManager.m2069a(this.j.mo669e(), this.f2365B, i3, layoutParams.width, true);
            a = i;
            i = a2;
        }
        m16925a(view, i, a, z);
    }

    private void m16925a(View view, int i, int i2, boolean z) {
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            if (this.f2379x && LayoutManager.m2076b(view.getMeasuredWidth(), i, layoutParams.width)) {
                if (LayoutManager.m2076b(view.getMeasuredHeight(), i2, layoutParams.height)) {
                    z = false;
                }
            }
            z = true;
        } else {
            z = m2112a(view, i, i2, layoutParams);
        }
        if (z) {
            view.measure(i, i2);
        }
    }

    private void m16924a(Recycler recycler, State state, int i, boolean z) {
        int i2 = -1;
        int i3 = 0;
        if (z) {
            z = true;
            i2 = i;
            i = 0;
        } else {
            i--;
            z = true;
        }
        while (i != i2) {
            View view = this.f16702d[i];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f11975b = m16928c(recycler, state, LayoutManager.m2070a(view));
            layoutParams.f11974a = i3;
            i3 += layoutParams.f11975b;
            i += z;
        }
    }

    private void m16931j(int i) {
        if (i != this.f16700b) {
            this.f16699a = true;
            if (i <= 0) {
                StringBuilder stringBuilder = new StringBuilder("Span count should be at least 1. Provided ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f16700b = i;
            this.f16705g.f2287a.clear();
            m2148n();
        }
    }

    public final View mo624a(View view, int i, Recycler recycler, State state) {
        GridLayoutManager gridLayoutManager = this;
        Recycler recycler2 = recycler;
        State state2 = state;
        View b = m2118b(view);
        View view2 = null;
        if (b == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
        int i2 = layoutParams.f11974a;
        int i3 = layoutParams.f11974a + layoutParams.f11975b;
        if (super.mo624a(view, i, recycler, state) == null) {
            return null;
        }
        int q;
        int i4;
        int i5;
        if (((mo641d(i) == 1) != gridLayoutManager.k ? 1 : 0) != 0) {
            q = m2151q() - 1;
            i4 = -1;
            i5 = i4;
        } else {
            i4 = m2151q();
            i5 = 1;
            q = 0;
        }
        int i6 = (gridLayoutManager.i == 1 && m10717h()) ? 1 : 0;
        int a = m16923a(recycler2, state2, q);
        int i7 = -1;
        int i8 = i5;
        int i9 = 0;
        int i10 = 0;
        View view3 = null;
        i5 = i7;
        while (q != i4) {
            int i11 = i4;
            i4 = m16923a(recycler2, state2, q);
            View e = m2134e(q);
            if (e == b) {
                break;
            }
            View view4;
            int i12;
            if (!e.hasFocusable() || i4 == a) {
                LayoutParams layoutParams2 = (LayoutParams) e.getLayoutParams();
                int i13 = layoutParams2.f11974a;
                view4 = b;
                i12 = a;
                int i14 = layoutParams2.f11974a + layoutParams2.f11975b;
                if (e.hasFocusable() && i13 == i2 && i14 == i3) {
                    return e;
                }
                Object obj;
                if (!(e.hasFocusable() && view2 == null) && (e.hasFocusable() || view3 != null)) {
                    a = Math.min(i14, i3) - Math.max(i13, i2);
                    if (e.hasFocusable()) {
                        if (a <= i10) {
                            if (a == i10) {
                                if (i6 == (i13 > i7 ? 1 : 0)) {
                                }
                            }
                        }
                    } else if (view2 == null && m2146i(e)) {
                        if (a <= i9) {
                            if (a == i9) {
                                if (i6 == (i13 > i5 ? 1 : 0)) {
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        if (e.hasFocusable()) {
                            view3 = e;
                            i5 = layoutParams2.f11974a;
                            i9 = Math.min(i14, i3) - Math.max(i13, i2);
                        } else {
                            i10 = Math.min(i14, i3) - Math.max(i13, i2);
                            i7 = layoutParams2.f11974a;
                            view2 = e;
                        }
                    }
                }
                obj = 1;
                if (obj == null) {
                    if (e.hasFocusable()) {
                        view3 = e;
                        i5 = layoutParams2.f11974a;
                        i9 = Math.min(i14, i3) - Math.max(i13, i2);
                    } else {
                        i10 = Math.min(i14, i3) - Math.max(i13, i2);
                        i7 = layoutParams2.f11974a;
                        view2 = e;
                    }
                }
            } else if (view2 != null) {
                break;
            } else {
                view4 = b;
                i12 = a;
            }
            q += i8;
            i4 = i11;
            b = view4;
            a = i12;
            recycler2 = recycler;
            state2 = state;
        }
        return view2 != null ? view2 : view3;
    }

    public final boolean mo640c() {
        return this.n == null && !this.f16699a;
    }

    private void m16921A() {
        int v;
        if (this.f11984i == 1) {
            v = (this.f2367D - m2156v()) - m2154t();
        } else {
            v = (this.f2368E - m2157w()) - m2155u();
        }
        m16929i(v);
    }
}
