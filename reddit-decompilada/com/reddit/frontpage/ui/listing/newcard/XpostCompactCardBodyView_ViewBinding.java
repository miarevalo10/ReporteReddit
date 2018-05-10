package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XpostCompactCardBodyView_ViewBinding implements Unbinder {
    private XpostCompactCardBodyView f29145b;

    public XpostCompactCardBodyView_ViewBinding(XpostCompactCardBodyView xpostCompactCardBodyView, View view) {
        this.f29145b = xpostCompactCardBodyView;
        xpostCompactCardBodyView.thumbnailView = (LinkThumbnailView) Utils.b(view, C1761R.id.xpost_link_thumbnail, "field 'thumbnailView'", LinkThumbnailView.class);
        xpostCompactCardBodyView.titleView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_link_title, "field 'titleView'", RightIndentTextView.class);
        xpostCompactCardBodyView.headerMetadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_header_metadata, "field 'headerMetadataView'", RightIndentTextView.class);
        xpostCompactCardBodyView.metadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_metadata_text, "field 'metadataView'", RightIndentTextView.class);
    }

    public final void m30251a() {
        XpostCompactCardBodyView xpostCompactCardBodyView = this.f29145b;
        if (xpostCompactCardBodyView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29145b = null;
        xpostCompactCardBodyView.thumbnailView = null;
        xpostCompactCardBodyView.titleView = null;
        xpostCompactCardBodyView.headerMetadataView = null;
        xpostCompactCardBodyView.metadataView = null;
    }
}
