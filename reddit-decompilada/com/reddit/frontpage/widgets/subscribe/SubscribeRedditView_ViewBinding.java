package com.reddit.frontpage.widgets.subscribe;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SubscribeRedditView_ViewBinding implements Unbinder {
    private SubscribeRedditView f29537b;

    public SubscribeRedditView_ViewBinding(SubscribeRedditView subscribeRedditView, View view) {
        this.f29537b = subscribeRedditView;
        subscribeRedditView.subscribeImage = (ImageView) Utils.b(view, C1761R.id.subscribe_image, "field 'subscribeImage'", ImageView.class);
    }

    public final void m30541a() {
        SubscribeRedditView subscribeRedditView = this.f29537b;
        if (subscribeRedditView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29537b = null;
        subscribeRedditView.subscribeImage = null;
    }
}
