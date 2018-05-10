package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.util.DisplayMetrics;
import android.view.View;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class PagerSnapHelper extends SnapHelper {
    private OrientationHelper f16716c;
    private OrientationHelper f16717d;

    public final int[] mo3246a(LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.mo645e()) {
            iArr[0] = m16971a(layoutManager, view, m16975d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.mo647f()) {
            iArr[1] = m16971a(layoutManager, view, m16974c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final View mo3245a(LayoutManager layoutManager) {
        if (layoutManager.mo647f()) {
            return m16972a(layoutManager, m16974c(layoutManager));
        }
        return layoutManager.mo645e() ? m16972a(layoutManager, m16975d(layoutManager)) : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo3244a(android.support.v7.widget.RecyclerView.LayoutManager r6, int r7, int r8) {
        /*
        r5 = this;
        r0 = r6.m2159y();
        r1 = -1;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = 0;
        r3 = r6.mo647f();
        if (r3 == 0) goto L_0x0018;
    L_0x000f:
        r2 = r5.m16974c(r6);
        r2 = m16973b(r6, r2);
        goto L_0x0026;
    L_0x0018:
        r3 = r6.mo645e();
        if (r3 == 0) goto L_0x0026;
    L_0x001e:
        r2 = r5.m16975d(r6);
        r2 = m16973b(r6, r2);
    L_0x0026:
        if (r2 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = android.support.v7.widget.RecyclerView.LayoutManager.m2070a(r2);
        if (r2 != r1) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r1 = r6.mo645e();
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x003e;
    L_0x0038:
        if (r7 <= 0) goto L_0x003c;
    L_0x003a:
        r7 = r4;
        goto L_0x0041;
    L_0x003c:
        r7 = r3;
        goto L_0x0041;
    L_0x003e:
        if (r8 <= 0) goto L_0x003c;
    L_0x0040:
        goto L_0x003a;
    L_0x0041:
        r8 = r6 instanceof android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
        if (r8 == 0) goto L_0x005c;
    L_0x0045:
        r6 = (android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) r6;
        r0 = r0 - r4;
        r6 = r6.mo635b(r0);
        if (r6 == 0) goto L_0x005c;
    L_0x004e:
        r8 = r6.x;
        r0 = 0;
        r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r8 < 0) goto L_0x005b;
    L_0x0055:
        r6 = r6.y;
        r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r6 >= 0) goto L_0x005c;
    L_0x005b:
        r3 = r4;
    L_0x005c:
        if (r3 == 0) goto L_0x0062;
    L_0x005e:
        if (r7 == 0) goto L_0x0061;
    L_0x0060:
        r2 = r2 - r4;
    L_0x0061:
        return r2;
    L_0x0062:
        if (r7 == 0) goto L_0x0065;
    L_0x0064:
        r2 = r2 + r4;
    L_0x0065:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.PagerSnapHelper.a(android.support.v7.widget.RecyclerView$LayoutManager, int, int):int");
    }

    protected final LinearSmoothScroller mo3255b(LayoutManager layoutManager) {
        if ((layoutManager instanceof ScrollVectorProvider) == null) {
            return null;
        }
        return new LinearSmoothScroller(this, this.a.getContext()) {
            final /* synthetic */ PagerSnapHelper f16715f;

            protected final void mo652a(View view, Action action) {
                view = this.f16715f.mo3246a(this.f16715f.a.getLayoutManager(), view);
                int i = view[0];
                view = view[1];
                int a = m10725a(Math.max(Math.abs(i), Math.abs(view)));
                if (a > 0) {
                    action.m2191a(i, view, a, this.b);
                }
            }

            protected final float mo3253a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            protected final int mo3254b(int i) {
                return Math.min(100, super.mo3254b(i));
            }
        };
    }

    private static int m16971a(LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        int a = orientationHelper.mo661a(view) + (orientationHelper.mo670e(view) / 2);
        if (layoutManager.m2149o() != null) {
            layoutManager = orientationHelper.mo663b() + (orientationHelper.mo669e() / 2);
        } else {
            layoutManager = orientationHelper.mo667d() / 2;
        }
        return a - layoutManager;
    }

    private static View m16972a(LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int q = layoutManager.m2151q();
        View view = null;
        if (q == 0) {
            return null;
        }
        int b;
        if (layoutManager.m2149o()) {
            b = orientationHelper.mo663b() + (orientationHelper.mo669e() / 2);
        } else {
            b = orientationHelper.mo667d() / 2;
        }
        int i = RedditJobManager.f10810d;
        for (int i2 = 0; i2 < q; i2++) {
            View e = layoutManager.m2134e(i2);
            int abs = Math.abs((orientationHelper.mo661a(e) + (orientationHelper.mo670e(e) / 2)) - b);
            if (abs < i) {
                view = e;
                i = abs;
            }
        }
        return view;
    }

    private static View m16973b(LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int q = layoutManager.m2151q();
        View view = null;
        if (q == 0) {
            return null;
        }
        int i = RedditJobManager.f10810d;
        for (int i2 = 0; i2 < q; i2++) {
            View e = layoutManager.m2134e(i2);
            int a = orientationHelper.mo661a(e);
            if (a < i) {
                view = e;
                i = a;
            }
        }
        return view;
    }

    private OrientationHelper m16974c(LayoutManager layoutManager) {
        if (this.f16716c == null || this.f16716c.f2338a != layoutManager) {
            this.f16716c = OrientationHelper.m1990b(layoutManager);
        }
        return this.f16716c;
    }

    private OrientationHelper m16975d(LayoutManager layoutManager) {
        if (this.f16717d == null || this.f16717d.f2338a != layoutManager) {
            this.f16717d = OrientationHelper.m1988a(layoutManager);
        }
        return this.f16717d;
    }
}
