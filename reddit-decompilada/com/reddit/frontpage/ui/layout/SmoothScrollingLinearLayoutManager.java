package com.reddit.frontpage.ui.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;
import com.reddit.frontpage.util.SmoothScrollUtil;

public class SmoothScrollingLinearLayoutManager extends LinearLayoutManager {
    public SmoothScrollingLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public static LinearLayoutManager m35006a(final Activity activity, final ItemChangedListener itemChangedListener) {
        return new SmoothScrollingLinearLayoutManager(activity) {
            private boolean f37258c;

            public final void m37585a(State state) {
                super.a(state);
                if (this.f37258c == null) {
                    state = k();
                    int m = m();
                    boolean z = (activity instanceof MainActivity) && ((MainActivity) activity).f40815d;
                    if (!z) {
                        itemChangedListener.mo4827a(state, m);
                    }
                    this.f37258c = true;
                }
            }
        };
    }

    public final void m35007a(RecyclerView recyclerView, int i) {
        SmoothScroller c28961 = new SmoothScroller(this, recyclerView.getContext(), SmoothScrollUtil.m23906a(recyclerView, this.i, i)) {
            final /* synthetic */ SmoothScrollingLinearLayoutManager f37255f;

            public final PointF m37584c(int i) {
                return this.f37255f.b(i);
            }
        };
        c28961.g = i;
        a(c28961);
    }
}
