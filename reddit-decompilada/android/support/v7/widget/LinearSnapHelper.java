package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.view.View;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class LinearSnapHelper extends SnapHelper {
    private OrientationHelper f16707c;
    private OrientationHelper f16708d;

    public final int[] mo3246a(LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.mo645e()) {
            iArr[0] = m16957a(layoutManager, view, m16960d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.mo647f()) {
            iArr[1] = m16957a(layoutManager, view, m16959c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final int mo3244a(LayoutManager layoutManager, int i, int i2) {
        if (!(layoutManager instanceof ScrollVectorProvider)) {
            return -1;
        }
        int y = layoutManager.m2159y();
        if (y == 0) {
            return -1;
        }
        View a = mo3245a(layoutManager);
        if (a == null) {
            return -1;
        }
        int a2 = LayoutManager.m2070a(a);
        if (a2 == -1) {
            return -1;
        }
        int i3 = y - 1;
        PointF b = ((ScrollVectorProvider) layoutManager).mo635b(i3);
        if (b == null) {
            return -1;
        }
        if (layoutManager.mo645e()) {
            i = m16956a(layoutManager, m16960d(layoutManager), i, 0);
            if (b.x < 0.0f) {
                i = -i;
            }
        } else {
            i = 0;
        }
        if (layoutManager.mo647f()) {
            i2 = m16956a(layoutManager, m16959c(layoutManager), 0, i2);
            if (b.y < 0.0f) {
                i2 = -i2;
            }
        } else {
            i2 = 0;
        }
        if (layoutManager.mo647f() != null) {
            i = i2;
        }
        if (i == 0) {
            return -1;
        }
        a2 += i;
        if (a2 < 0) {
            a2 = 0;
        }
        if (a2 >= y) {
            a2 = i3;
        }
        return a2;
    }

    public final View mo3245a(LayoutManager layoutManager) {
        if (layoutManager.mo647f()) {
            return m16958a(layoutManager, m16959c(layoutManager));
        }
        return layoutManager.mo645e() ? m16958a(layoutManager, m16960d(layoutManager)) : null;
    }

    private static int m16957a(LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        int a = orientationHelper.mo661a(view) + (orientationHelper.mo670e(view) / 2);
        if (layoutManager.m2149o() != null) {
            layoutManager = orientationHelper.mo663b() + (orientationHelper.mo669e() / 2);
        } else {
            layoutManager = orientationHelper.mo667d() / 2;
        }
        return a - layoutManager;
    }

    private static View m16958a(LayoutManager layoutManager, OrientationHelper orientationHelper) {
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

    private OrientationHelper m16959c(LayoutManager layoutManager) {
        if (this.f16707c == null || this.f16707c.f2338a != layoutManager) {
            this.f16707c = OrientationHelper.m1990b(layoutManager);
        }
        return this.f16707c;
    }

    private OrientationHelper m16960d(LayoutManager layoutManager) {
        if (this.f16708d == null || this.f16708d.f2338a != layoutManager) {
            this.f16708d = OrientationHelper.m1988a(layoutManager);
        }
        return this.f16708d;
    }

    private int m16956a(LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        r0 = new int[2];
        this.f12056b.fling(0, 0, i, i2, Integer.MIN_VALUE, RedditJobManager.f10810d, Integer.MIN_VALUE, RedditJobManager.f10810d);
        r0[0] = this.f12056b.getFinalX();
        r0[1] = this.f12056b.getFinalY();
        i = layoutManager.m2151q();
        float f = 1.0f;
        if (i != 0) {
            View view = null;
            int i3 = Integer.MIN_VALUE;
            int i4 = RedditJobManager.f10810d;
            View view2 = view;
            for (int i5 = 0; i5 < i; i5++) {
                View e = layoutManager.m2134e(i5);
                int a = LayoutManager.m2070a(e);
                if (a != -1) {
                    if (a < i4) {
                        view2 = e;
                        i4 = a;
                    }
                    if (a > i3) {
                        view = e;
                        i3 = a;
                    }
                }
            }
            if (view2 != null) {
                if (view != null) {
                    orientationHelper = Math.max(orientationHelper.mo664b(view2), orientationHelper.mo664b(view)) - Math.min(orientationHelper.mo661a(view2), orientationHelper.mo661a(view));
                    if (orientationHelper != null) {
                        f = (1.0f * ((float) orientationHelper)) / ((float) ((i3 - i4) + 1));
                    }
                }
            }
        }
        if (f <= null) {
            return 0;
        }
        return Math.round(((float) (Math.abs(r0[0]) > Math.abs(r0[1]) ? r0[0] : r0[1])) / f);
    }
}
