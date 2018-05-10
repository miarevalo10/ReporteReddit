package com.reddit.frontpage.ui.live;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class LiveThreadHeader_ViewBinding implements Unbinder {
    private LiveThreadHeader f29158b;

    public LiveThreadHeader_ViewBinding(LiveThreadHeader liveThreadHeader, View view) {
        this.f29158b = liveThreadHeader;
        liveThreadHeader.titleView = (TextView) Utils.b(view, C1761R.id.live_thread_title, "field 'titleView'", TextView.class);
        liveThreadHeader.descriptionView = (BaseHtmlTextView) Utils.b(view, C1761R.id.live_thread_description, "field 'descriptionView'", BaseHtmlTextView.class);
    }

    public final void m30264a() {
        LiveThreadHeader liveThreadHeader = this.f29158b;
        if (liveThreadHeader == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29158b = null;
        liveThreadHeader.titleView = null;
        liveThreadHeader.descriptionView = null;
    }
}
