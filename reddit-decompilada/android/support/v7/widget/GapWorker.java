package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> f2281a = new ThreadLocal();
    static Comparator<Task> f2282e = new C02071();
    ArrayList<RecyclerView> f2283b = new ArrayList();
    long f2284c;
    long f2285d;
    private ArrayList<Task> f2286f = new ArrayList();

    static class C02071 implements Comparator<Task> {
        C02071() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Task task = (Task) obj;
            Task task2 = (Task) obj2;
            if ((task.f2279d == null ? 1 : 0) != (task2.f2279d == null ? 1 : 0)) {
                return task.f2279d == null ? 1 : -1;
            } else {
                if (task.f2276a != task2.f2276a) {
                    return task.f2276a != null ? -1 : 1;
                } else {
                    int i = task2.f2277b - task.f2277b;
                    if (i != 0) {
                        return i;
                    }
                    obj = task.f2278c - task2.f2278c;
                    if (obj != null) {
                        return obj;
                    }
                    return 0;
                }
            }
        }
    }

    static class Task {
        public boolean f2276a;
        public int f2277b;
        public int f2278c;
        public RecyclerView f2279d;
        public int f2280e;

        Task() {
        }
    }

    static class LayoutPrefetchRegistryImpl implements LayoutPrefetchRegistry {
        int f11970a;
        int f11971b;
        int[] f11972c;
        int f11973d;

        LayoutPrefetchRegistryImpl() {
        }

        final void m10652a(RecyclerView recyclerView, boolean z) {
            this.f11973d = 0;
            if (this.f11972c != null) {
                Arrays.fill(this.f11972c, -1);
            }
            LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.f2380y) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.m10571d()) {
                        layoutManager.mo626a(recyclerView.mAdapter.mo39a(), (LayoutPrefetchRegistry) this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.mo625a(this.f11970a, this.f11971b, recyclerView.mState, (LayoutPrefetchRegistry) this);
                }
                if (this.f11973d > layoutManager.f2381z) {
                    layoutManager.f2381z = this.f11973d;
                    layoutManager.f2364A = z;
                    recyclerView.mRecycler.m2184b();
                }
            }
        }

        public final void mo620a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.f11973d * 2;
                if (this.f11972c == null) {
                    this.f11972c = new int[4];
                    Arrays.fill(this.f11972c, -1);
                } else if (i3 >= this.f11972c.length) {
                    Object obj = this.f11972c;
                    this.f11972c = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.f11972c, 0, obj.length);
                }
                this.f11972c[i3] = i;
                this.f11972c[i3 + 1] = i2;
                this.f11973d++;
            }
        }

        final boolean m10653a(int i) {
            if (this.f11972c != null) {
                int i2 = this.f11973d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f11972c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        final void m10650a() {
            if (this.f11972c != null) {
                Arrays.fill(this.f11972c, -1);
            }
            this.f11973d = 0;
        }
    }

    GapWorker() {
    }

    final void m1967a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2284c == 0) {
            this.f2284c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView = recyclerView.mPrefetchRegistry;
        recyclerView.f11970a = i;
        recyclerView.f11971b = i2;
    }

    public final void run() {
        Throwable th;
        long j;
        GapWorker gapWorker = this;
        try {
            TraceCompat.m975a("RV Prefetch");
            if (gapWorker.f2283b.isEmpty()) {
                gapWorker.f2284c = 0;
                TraceCompat.m974a();
                return;
            }
            int size = gapWorker.f2283b.size();
            long j2 = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = (RecyclerView) gapWorker.f2283b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j2 = Math.max(recyclerView.getDrawingTime(), j2);
                }
            }
            if (j2 == 0) {
                gapWorker.f2284c = 0;
                TraceCompat.m974a();
                return;
            }
            int i2;
            long toNanos = TimeUnit.MILLISECONDS.toNanos(j2) + gapWorker.f2285d;
            size = gapWorker.f2283b.size();
            int i3 = 0;
            int i4 = i3;
            while (i3 < size) {
                RecyclerView recyclerView2 = (RecyclerView) gapWorker.f2283b.get(i3);
                if (recyclerView2.getWindowVisibility() == 0) {
                    recyclerView2.mPrefetchRegistry.m10652a(recyclerView2, false);
                    i4 += recyclerView2.mPrefetchRegistry.f11973d;
                }
                i3++;
            }
            gapWorker.f2286f.ensureCapacity(i4);
            i3 = 0;
            i4 = i3;
            while (i3 < size) {
                RecyclerView recyclerView3 = (RecyclerView) gapWorker.f2283b.get(i3);
                if (recyclerView3.getWindowVisibility() == 0) {
                    LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView3.mPrefetchRegistry;
                    int abs = Math.abs(layoutPrefetchRegistryImpl.f11970a) + Math.abs(layoutPrefetchRegistryImpl.f11971b);
                    int i5 = i4;
                    for (i4 = 0; i4 < layoutPrefetchRegistryImpl.f11973d * 2; i4 += 2) {
                        Task task;
                        if (i5 >= gapWorker.f2286f.size()) {
                            task = new Task();
                            try {
                                gapWorker.f2286f.add(task);
                            } catch (Throwable th2) {
                                th = th2;
                                j = 0;
                            }
                        } else {
                            task = (Task) gapWorker.f2286f.get(i5);
                        }
                        i2 = layoutPrefetchRegistryImpl.f11972c[i4 + 1];
                        task.f2276a = i2 <= abs;
                        task.f2277b = abs;
                        task.f2278c = i2;
                        task.f2279d = recyclerView3;
                        task.f2280e = layoutPrefetchRegistryImpl.f11972c[i4];
                        i5++;
                    }
                    i4 = i5;
                }
                i3++;
            }
            Collections.sort(gapWorker.f2286f, f2282e);
            for (i2 = 0; i2 < gapWorker.f2286f.size(); i2++) {
                Task task2 = (Task) gapWorker.f2286f.get(i2);
                if (task2.f2279d == null) {
                    break;
                }
                ViewHolder a = m1966a(task2.f2279d, task2.f2280e, task2.f2276a ? Long.MAX_VALUE : toNanos);
                if (!(a == null || a.f2425d == null || !a.m2236n() || a.m2234l())) {
                    RecyclerView recyclerView4 = (RecyclerView) a.f2425d.get();
                    if (recyclerView4 != null) {
                        if (recyclerView4.mDataSetHasChangedAfterLayout && recyclerView4.mChildHelper.m1906b() != 0) {
                            recyclerView4.removeAndRecycleViews();
                        }
                        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView4.mPrefetchRegistry;
                        layoutPrefetchRegistryImpl2.m10652a(recyclerView4, true);
                        if (layoutPrefetchRegistryImpl2.f11973d != 0) {
                            TraceCompat.m975a("RV Nested Prefetch");
                            recyclerView4.mState.prepareForNestedPrefetch(recyclerView4.mAdapter);
                            for (i4 = 0; i4 < layoutPrefetchRegistryImpl2.f11973d * 2; i4 += 2) {
                                m1966a(recyclerView4, layoutPrefetchRegistryImpl2.f11972c[i4], toNanos);
                            }
                            TraceCompat.m974a();
                        }
                    }
                }
                task2.f2276a = false;
                task2.f2277b = 0;
                task2.f2278c = 0;
                task2.f2279d = null;
                task2.f2280e = 0;
            }
            gapWorker.f2284c = 0;
            TraceCompat.m974a();
        } catch (Throwable th22) {
            j = 0;
            th = th22;
            gapWorker.f2284c = j;
            TraceCompat.m974a();
            throw th;
        }
    }

    private static ViewHolder m1966a(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int b = recyclerView.mChildHelper.m1906b();
        for (int i2 = 0; i2 < b; i2++) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m1910c(i2));
            if (childViewHolderInt.f2426e == i && !childViewHolderInt.m2234l()) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            return null;
        }
        Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            ViewHolder a = recycler.m2178a(i, j);
            if (a != null) {
                if (a.m2236n() == null || a.m2234l() != null) {
                    recycler.m2181a(a, false);
                } else {
                    recycler.m2182a(a.f2424c);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return a;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }
}
