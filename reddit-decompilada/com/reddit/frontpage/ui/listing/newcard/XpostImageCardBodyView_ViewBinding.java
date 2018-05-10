package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XpostImageCardBodyView_ViewBinding implements Unbinder {
    private XpostImageCardBodyView f29146b;

    public XpostImageCardBodyView_ViewBinding(XpostImageCardBodyView xpostImageCardBodyView, View view) {
        this.f29146b = xpostImageCardBodyView;
        xpostImageCardBodyView.preview = (ImageView) Utils.a(view, C1761R.id.xpost_link_preview, "field 'preview'", ImageView.class);
        xpostImageCardBodyView.titleView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_link_title, "field 'titleView'", RightIndentTextView.class);
        xpostImageCardBodyView.headerMetadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_header_metadata, "field 'headerMetadataView'", RightIndentTextView.class);
        xpostImageCardBodyView.metadataView = (RightIndentTextView) Utils.b(view, C1761R.id.xpost_metadata_text, "field 'metadataView'", RightIndentTextView.class);
        xpostImageCardBodyView.playIcon = (ImageView) Utils.a(view, C1761R.id.xpost_video_play_icon, "field 'playIcon'", ImageView.class);
    }

    public final void m30252a() {
        XpostImageCardBodyView xpostImageCardBodyView = this.f29146b;
        if (xpostImageCardBodyView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29146b = null;
        xpostImageCardBodyView.preview = null;
        xpostImageCardBodyView.titleView = null;
        xpostImageCardBodyView.headerMetadataView = null;
        xpostImageCardBodyView.metadataView = null;
        xpostImageCardBodyView.playIcon = null;
    }
}
