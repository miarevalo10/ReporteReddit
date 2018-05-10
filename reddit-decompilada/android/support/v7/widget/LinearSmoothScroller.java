package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

public class LinearSmoothScroller extends SmoothScroller {
    protected final LinearInterpolator f11991a = new LinearInterpolator();
    protected final DecelerateInterpolator f11992b = new DecelerateInterpolator();
    protected PointF f11993c;
    protected int f11994d = 0;
    protected int f11995e = 0;
    private final float f11996f;

    private static int m10723a(int i, int i2) {
        i2 = i - i2;
        return i * i2 <= 0 ? 0 : i2;
    }

    public LinearSmoothScroller(Context context) {
        this.f11996f = mo3253a(context.getResources().getDisplayMetrics());
    }

    protected final void mo650a() {
        this.f11995e = 0;
        this.f11994d = 0;
        this.f11993c = null;
    }

    protected float mo3253a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    protected final int m10725a(int i) {
        return (int) Math.ceil(((double) mo3254b(i)) / 0.3356d);
    }

    protected int mo3254b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f11996f));
    }

    public int m10731b() {
        if (this.f11993c != null) {
            if (this.f11993c.y != 0.0f) {
                return this.f11993c.y > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public int m10726a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                i3 -= i;
                if (i3 > 0) {
                    return i3;
                }
                i4 -= i2;
                return i4 < 0 ? i4 : 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    protected void mo652a(View view, Action action) {
        int i;
        LayoutManager layoutManager;
        int a;
        int i2 = 0;
        if (this.f11993c != null) {
            if (this.f11993c.x != 0.0f) {
                i = this.f11993c.x > 0.0f ? 1 : -1;
                layoutManager = this.f2411i;
                if (layoutManager != null) {
                    if (!layoutManager.mo645e()) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        i2 = m10726a(LayoutManager.m2080e(view) - layoutParams.leftMargin, LayoutManager.m2082g(view) + layoutParams.rightMargin, layoutManager.m2154t(), layoutManager.f2367D - layoutManager.m2156v(), i);
                    }
                }
                view = m10727a(view, m10731b());
                a = m10725a((int) Math.sqrt((double) ((i2 * i2) + (view * view))));
                if (a > 0) {
                    action.m2191a(-i2, -view, a, this.f11992b);
                }
            }
        }
        i = 0;
        layoutManager = this.f2411i;
        if (layoutManager != null) {
            if (!layoutManager.mo645e()) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                i2 = m10726a(LayoutManager.m2080e(view) - layoutParams2.leftMargin, LayoutManager.m2082g(view) + layoutParams2.rightMargin, layoutManager.m2154t(), layoutManager.f2367D - layoutManager.m2156v(), i);
            }
        }
        view = m10727a(view, m10731b());
        a = m10725a((int) Math.sqrt((double) ((i2 * i2) + (view * view))));
        if (a > 0) {
            action.m2191a(-i2, -view, a, this.f11992b);
        }
    }

    protected final void mo651a(int i, int i2, Action action) {
        if (this.f2410h.mLayout.m2151q() == 0) {
            m2199c();
            return;
        }
        this.f11994d = m10723a(this.f11994d, i);
        this.f11995e = m10723a(this.f11995e, i2);
        if (this.f11994d == 0 && this.f11995e == 0) {
            i = m10733c(this.f2409g);
            if (i != 0) {
                if (i.x != 0 || i.y != 0) {
                    i2 = (float) Math.sqrt((double) ((i.x * i.x) + (i.y * i.y)));
                    i.x /= i2;
                    i.y /= i2;
                    this.f11993c = i;
                    this.f11994d = (int) (i.x * 1176256512);
                    this.f11995e = (int) (10000.0f * i.y);
                    action.m2191a((int) (((float) this.f11994d) * 1067030938), (int) (((float) this.f11995e) * 1.2f), (int) (((float) mo3254b(AbstractSpiCall.DEFAULT_TIMEOUT)) * 1067030938), this.f11991a);
                }
            }
            action.f2401a = this.f2409g;
            m2199c();
        }
    }

    public int m10727a(View view, int i) {
        LayoutManager layoutManager = this.f2411i;
        if (layoutManager != null) {
            if (layoutManager.mo647f()) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return m10726a(LayoutManager.m2081f(view) - layoutParams.topMargin, LayoutManager.m2083h(view) + layoutParams.bottomMargin, layoutManager.m2155u(), layoutManager.f2368E - layoutManager.m2157w(), i);
            }
        }
        return null;
    }

    public PointF m10733c(int i) {
        LayoutManager layoutManager = this.f2411i;
        if (layoutManager instanceof ScrollVectorProvider) {
            return ((ScrollVectorProvider) layoutManager).mo635b(i);
        }
        StringBuilder stringBuilder = new StringBuilder("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
        stringBuilder.append(ScrollVectorProvider.class.getCanonicalName());
        Log.w("LinearSmoothScroller", stringBuilder.toString());
        return 0;
    }
}
