package com.reddit.frontpage.ui.live;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.UpdatingWhenView;

public class LiveUpdateViewHolder_ViewBinding implements Unbinder {
    private LiveUpdateViewHolder f29164b;

    public LiveUpdateViewHolder_ViewBinding(LiveUpdateViewHolder liveUpdateViewHolder, View view) {
        this.f29164b = liveUpdateViewHolder;
        liveUpdateViewHolder.authorView = (TextView) Utils.b(view, C1761R.id.live_update_author, "field 'authorView'", TextView.class);
        liveUpdateViewHolder.ageView = (UpdatingWhenView) Utils.b(view, C1761R.id.live_update_age, "field 'ageView'", UpdatingWhenView.class);
        liveUpdateViewHolder.domainView = (TextView) Utils.b(view, C1761R.id.live_update_domain, "field 'domainView'", TextView.class);
        liveUpdateViewHolder.container = (ViewGroup) Utils.b(view, C1761R.id.live_update_container, "field 'container'", ViewGroup.class);
    }

    public final void m30271a() {
        LiveUpdateViewHolder liveUpdateViewHolder = this.f29164b;
        if (liveUpdateViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29164b = null;
        liveUpdateViewHolder.authorView = null;
        liveUpdateViewHolder.ageView = null;
        liveUpdateViewHolder.domainView = null;
        liveUpdateViewHolder.container = null;
    }
}
