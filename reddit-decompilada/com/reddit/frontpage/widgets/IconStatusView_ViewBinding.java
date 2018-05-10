package com.reddit.frontpage.widgets;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class IconStatusView_ViewBinding implements Unbinder {
    private IconStatusView f29451b;

    public IconStatusView_ViewBinding(IconStatusView iconStatusView, View view) {
        this.f29451b = iconStatusView;
        iconStatusView.flaggedCountView = (TextView) Utils.b(view, C1761R.id.text_flagged, "field 'flaggedCountView'", TextView.class);
        iconStatusView.iconStickied = (ImageView) Utils.b(view, C1761R.id.icon_stickied, "field 'iconStickied'", ImageView.class);
        iconStatusView.iconArchived = (ImageView) Utils.b(view, C1761R.id.icon_archived, "field 'iconArchived'", ImageView.class);
        iconStatusView.iconLocked = (ImageView) Utils.b(view, C1761R.id.icon_locked, "field 'iconLocked'", ImageView.class);
        iconStatusView.iconFlagged = (ImageView) Utils.b(view, C1761R.id.icon_flagged, "field 'iconFlagged'", ImageView.class);
        iconStatusView.iconApproved = (ImageView) Utils.b(view, C1761R.id.icon_approved, "field 'iconApproved'", ImageView.class);
        iconStatusView.iconRemoved = (ImageView) Utils.b(view, C1761R.id.icon_removed, "field 'iconRemoved'", ImageView.class);
        iconStatusView.iconSpammed = (ImageView) Utils.b(view, C1761R.id.icon_spam, "field 'iconSpammed'", ImageView.class);
    }

    public final void m30483a() {
        IconStatusView iconStatusView = this.f29451b;
        if (iconStatusView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29451b = null;
        iconStatusView.flaggedCountView = null;
        iconStatusView.iconStickied = null;
        iconStatusView.iconArchived = null;
        iconStatusView.iconLocked = null;
        iconStatusView.iconFlagged = null;
        iconStatusView.iconApproved = null;
        iconStatusView.iconRemoved = null;
        iconStatusView.iconSpammed = null;
    }
}
