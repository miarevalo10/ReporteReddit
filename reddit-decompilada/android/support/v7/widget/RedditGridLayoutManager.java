package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.util.AttributeSet;
import com.reddit.frontpage.util.SmoothScrollUtil;

public class RedditGridLayoutManager extends GridLayoutManager {
    public RedditGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public RedditGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public RedditGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    public final void mo629a(RecyclerView recyclerView, int i) {
        SmoothScroller c17051 = new com.reddit.frontpage.ui.layout.SmoothScroller(this, recyclerView.getContext(), SmoothScrollUtil.a(recyclerView, this.f11984i, i)) {
            final /* synthetic */ RedditGridLayoutManager f18867f;

            public final PointF m19956c(int i) {
                return this.f18867f.mo635b(i);
            }
        };
        c17051.f2409g = i;
        m2099a(c17051);
    }
}
