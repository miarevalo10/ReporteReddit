package com.reddit.frontpage.widgets;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SubscribeToggleIcon_ViewBinding implements Unbinder {
    private SubscribeToggleIcon f29495b;

    public SubscribeToggleIcon_ViewBinding(SubscribeToggleIcon subscribeToggleIcon, View view) {
        this.f29495b = subscribeToggleIcon;
        subscribeToggleIcon.icon = (ImageView) Utils.b(view, C1761R.id.icon, "field 'icon'", ImageView.class);
    }

    public final void m30503a() {
        SubscribeToggleIcon subscribeToggleIcon = this.f29495b;
        if (subscribeToggleIcon == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29495b = null;
        subscribeToggleIcon.icon = null;
    }
}
