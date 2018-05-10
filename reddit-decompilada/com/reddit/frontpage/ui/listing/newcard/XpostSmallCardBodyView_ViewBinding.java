package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XpostSmallCardBodyView_ViewBinding implements Unbinder {
    private XpostSmallCardBodyView f29147b;

    public XpostSmallCardBodyView_ViewBinding(XpostSmallCardBodyView xpostSmallCardBodyView, View view) {
        this.f29147b = xpostSmallCardBodyView;
        xpostSmallCardBodyView.thumbnailView = (LinkThumbnailView) Utils.b(view, C1761R.id.xpost_link_thumbnail, "field 'thumbnailView'", LinkThumbnailView.class);
        xpostSmallCardBodyView.titleView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_link_title, "field 'titleView'", RightIndentTextView.class);
        xpostSmallCardBodyView.headerMetadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_header_metadata, "field 'headerMetadataView'", RightIndentTextView.class);
        xpostSmallCardBodyView.metadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_metadata_text, "field 'metadataView'", RightIndentTextView.class);
    }

    public final void m30253a() {
        XpostSmallCardBodyView xpostSmallCardBodyView = this.f29147b;
        if (xpostSmallCardBodyView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29147b = null;
        xpostSmallCardBodyView.thumbnailView = null;
        xpostSmallCardBodyView.titleView = null;
        xpostSmallCardBodyView.headerMetadataView = null;
        xpostSmallCardBodyView.metadataView = null;
    }
}
