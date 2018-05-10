package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnFlingListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class SnapHelper extends OnFlingListener {
    RecyclerView f12055a;
    Scroller f12056b;
    private final OnScrollListener f12057c = new C10361(this);

    class C10361 extends OnScrollListener {
        boolean f12053a = null;
        final /* synthetic */ SnapHelper f12054b;

        C10361(SnapHelper snapHelper) {
            this.f12054b = snapHelper;
        }

        public final void mo716a(RecyclerView recyclerView, int i) {
            super.mo716a(recyclerView, i);
            if (i == 0 && this.f12053a != null) {
                this.f12053a = null;
                this.f12054b.m10841a();
            }
        }

        public final void mo616a(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f12053a = true;
            }
        }
    }

    public abstract int mo3244a(LayoutManager layoutManager, int i, int i2);

    public abstract View mo3245a(LayoutManager layoutManager);

    public abstract int[] mo3246a(LayoutManager layoutManager, View view);

    public final boolean mo717a(int i, int i2) {
        LayoutManager layoutManager = this.f12055a.getLayoutManager();
        if (layoutManager == null || this.f12055a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f12055a.getMinFlingVelocity();
        if (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) {
            if (layoutManager instanceof ScrollVectorProvider) {
                SmoothScroller b = mo3255b(layoutManager);
                if (b != null) {
                    i = mo3244a(layoutManager, i, i2);
                    if (i != -1) {
                        b.f2409g = i;
                        layoutManager.m2099a(b);
                        i = 1;
                        if (i == 0) {
                            return true;
                        }
                    }
                }
            }
            i = 0;
            if (i == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void m10842a(RecyclerView recyclerView) throws IllegalStateException {
        if (this.f12055a != recyclerView) {
            if (this.f12055a != null) {
                this.f12055a.removeOnScrollListener(this.f12057c);
                this.f12055a.setOnFlingListener(null);
            }
            this.f12055a = recyclerView;
            if (this.f12055a != null) {
                if (this.f12055a.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                this.f12055a.addOnScrollListener(this.f12057c);
                this.f12055a.setOnFlingListener(this);
                this.f12056b = new Scroller(this.f12055a.getContext(), new DecelerateInterpolator());
                m10841a();
            }
        }
    }

    final void m10841a() {
        if (this.f12055a != null) {
            LayoutManager layoutManager = this.f12055a.getLayoutManager();
            if (layoutManager != null) {
                View a = mo3245a(layoutManager);
                if (a != null) {
                    int[] a2 = mo3246a(layoutManager, a);
                    if (!(a2[0] == 0 && a2[1] == 0)) {
                        this.f12055a.smoothScrollBy(a2[0], a2[1]);
                    }
                }
            }
        }
    }

    @Deprecated
    protected LinearSmoothScroller mo3255b(LayoutManager layoutManager) {
        if ((layoutManager instanceof ScrollVectorProvider) == null) {
            return null;
        }
        return new LinearSmoothScroller(this, this.f12055a.getContext()) {
            final /* synthetic */ SnapHelper f16722f;

            protected final void mo652a(View view, Action action) {
                if (this.f16722f.f12055a != null) {
                    view = this.f16722f.mo3246a(this.f16722f.f12055a.getLayoutManager(), view);
                    int i = view[0];
                    view = view[1];
                    int a = m10725a(Math.max(Math.abs(i), Math.abs(view)));
                    if (a > 0) {
                        action.m2191a(i, view, a, this.b);
                    }
                }
            }

            protected final float mo3253a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
