package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LiveThreadViewHolder_ViewBinding implements Unbinder {
    private LiveThreadViewHolder f29134b;

    public LiveThreadViewHolder_ViewBinding(LiveThreadViewHolder liveThreadViewHolder, View view) {
        this.f29134b = liveThreadViewHolder;
        liveThreadViewHolder.viewers = (TextView) Utils.b(view, C1761R.id.live_viewers, "field 'viewers'", TextView.class);
        liveThreadViewHolder.title = (TextView) Utils.b(view, C1761R.id.live_link_title, "field 'title'", TextView.class);
    }

    public final void m30248a() {
        LiveThreadViewHolder liveThreadViewHolder = this.f29134b;
        if (liveThreadViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29134b = null;
        liveThreadViewHolder.viewers = null;
        liveThreadViewHolder.title = null;
    }
}
