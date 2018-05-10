package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LinkThumbnailView_ViewBinding implements Unbinder {
    private LinkThumbnailView f29127b;

    public LinkThumbnailView_ViewBinding(LinkThumbnailView linkThumbnailView, View view) {
        this.f29127b = linkThumbnailView;
        linkThumbnailView.thumbnailView = (ImageView) Utils.b(view, C1761R.id.link_thumbnail_image, "field 'thumbnailView'", ImageView.class);
    }

    public final void m30244a() {
        LinkThumbnailView linkThumbnailView = this.f29127b;
        if (linkThumbnailView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29127b = null;
        linkThumbnailView.thumbnailView = null;
    }
}
