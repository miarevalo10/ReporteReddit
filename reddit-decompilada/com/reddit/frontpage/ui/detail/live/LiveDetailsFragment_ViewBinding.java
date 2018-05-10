package com.reddit.frontpage.ui.detail.live;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class LiveDetailsFragment_ViewBinding implements Unbinder {
    private LiveDetailsFragment f28964b;

    public LiveDetailsFragment_ViewBinding(LiveDetailsFragment liveDetailsFragment, View view) {
        this.f28964b = liveDetailsFragment;
        liveDetailsFragment.detailsView = (BaseHtmlTextView) Utils.b(view, C1761R.id.live_update_details, "field 'detailsView'", BaseHtmlTextView.class);
    }

    public final void m30030a() {
        LiveDetailsFragment liveDetailsFragment = this.f28964b;
        if (liveDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28964b = null;
        liveDetailsFragment.detailsView = null;
    }
}
