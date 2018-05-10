package com.reddit.frontpage.ui.live;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LiveUpdatesFragment_ViewBinding implements Unbinder {
    private LiveUpdatesFragment f29169b;

    public LiveUpdatesFragment_ViewBinding(LiveUpdatesFragment liveUpdatesFragment, View view) {
        this.f29169b = liveUpdatesFragment;
        liveUpdatesFragment.updateCounterView = (TextView) Utils.b(view, C1761R.id.update_counter, "field 'updateCounterView'", TextView.class);
        liveUpdatesFragment.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.update_list, "field 'recyclerView'", RecyclerView.class);
        liveUpdatesFragment.refreshLayout = (SwipeRefreshLayout) Utils.b(view, C1761R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    public final void m30285a() {
        LiveUpdatesFragment liveUpdatesFragment = this.f29169b;
        if (liveUpdatesFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29169b = null;
        liveUpdatesFragment.updateCounterView = null;
        liveUpdatesFragment.recyclerView = null;
        liveUpdatesFragment.refreshLayout = null;
    }
}
