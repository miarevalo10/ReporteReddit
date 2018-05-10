package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SmallCardBodyView_ViewBinding implements Unbinder {
    private SmallCardBodyView f29135b;

    public SmallCardBodyView_ViewBinding(SmallCardBodyView smallCardBodyView, View view) {
        this.f29135b = smallCardBodyView;
        smallCardBodyView.titleView = (RightIndentTextView) Utils.b(view, C1761R.id.link_title, "field 'titleView'", RightIndentTextView.class);
        smallCardBodyView.thumbnailView = (LinkThumbnailView) Utils.a(view, C1761R.id.link_thumbnail, "field 'thumbnailView'", LinkThumbnailView.class);
        smallCardBodyView.selfTextView = (RightIndentTextView) Utils.a(view, C1761R.id.link_self_text, "field 'selfTextView'", RightIndentTextView.class);
        smallCardBodyView.flairView = (LinkFlairView) Utils.a(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
        smallCardBodyView.smallXpostCardBody = (XpostSmallCardBodyView) Utils.a(view, C1761R.id.xpost_small_card_body, "field 'smallXpostCardBody'", XpostSmallCardBodyView.class);
        smallCardBodyView.videoXpostCardBody = (XpostImageCardBodyView) Utils.a(view, C1761R.id.xpost_large_card_body, "field 'videoXpostCardBody'", XpostImageCardBodyView.class);
    }

    public final void m30249a() {
        SmallCardBodyView smallCardBodyView = this.f29135b;
        if (smallCardBodyView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29135b = null;
        smallCardBodyView.titleView = null;
        smallCardBodyView.thumbnailView = null;
        smallCardBodyView.selfTextView = null;
        smallCardBodyView.flairView = null;
        smallCardBodyView.smallXpostCardBody = null;
        smallCardBodyView.videoXpostCardBody = null;
    }
}
