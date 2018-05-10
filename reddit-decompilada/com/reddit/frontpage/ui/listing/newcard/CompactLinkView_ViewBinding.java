package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkHeaderView;

public class CompactLinkView_ViewBinding implements Unbinder {
    private CompactLinkView f29124b;

    public CompactLinkView_ViewBinding(CompactLinkView compactLinkView, View view) {
        this.f29124b = compactLinkView;
        compactLinkView.thumbnailView = (LinkThumbnailView) Utils.a(view, C1761R.id.link_thumbnail, "field 'thumbnailView'", LinkThumbnailView.class);
        compactLinkView.xpostCardBody = (XpostCompactCardBodyView) Utils.a(view, C1761R.id.xpost_compact_card_body, "field 'xpostCardBody'", XpostCompactCardBodyView.class);
        compactLinkView.linkHeaderView = (LinkHeaderView) Utils.b(view, C1761R.id.link_header, "field 'linkHeaderView'", LinkHeaderView.class);
        compactLinkView.titleView = (RightIndentTextView) Utils.b(view, C1761R.id.link_title, "field 'titleView'", RightIndentTextView.class);
        compactLinkView.flairView = (LinkFlairView) Utils.b(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
    }

    public final void m30242a() {
        CompactLinkView compactLinkView = this.f29124b;
        if (compactLinkView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29124b = null;
        compactLinkView.thumbnailView = null;
        compactLinkView.xpostCardBody = null;
        compactLinkView.linkHeaderView = null;
        compactLinkView.titleView = null;
        compactLinkView.flairView = null;
    }
}
