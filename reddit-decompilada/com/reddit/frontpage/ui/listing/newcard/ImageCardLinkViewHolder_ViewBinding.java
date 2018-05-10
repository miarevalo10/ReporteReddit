package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkTitleView;

public class ImageCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private ImageCardLinkViewHolder f34376b;

    public ImageCardLinkViewHolder_ViewBinding(ImageCardLinkViewHolder imageCardLinkViewHolder, View view) {
        super(imageCardLinkViewHolder, view);
        this.f34376b = imageCardLinkViewHolder;
        imageCardLinkViewHolder.titleView = (LinkTitleView) Utils.b(view, C1761R.id.link_title, "field 'titleView'", LinkTitleView.class);
        imageCardLinkViewHolder.flairView = (LinkFlairView) Utils.b(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
        imageCardLinkViewHolder.previewView = (ImageView) Utils.b(view, C1761R.id.link_preview, "field 'previewView'", ImageView.class);
        imageCardLinkViewHolder.domainView = (TextView) Utils.b(view, C1761R.id.domain, "field 'domainView'", TextView.class);
    }

    public final void mo6516a() {
        ImageCardLinkViewHolder imageCardLinkViewHolder = this.f34376b;
        if (imageCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34376b = null;
        imageCardLinkViewHolder.titleView = null;
        imageCardLinkViewHolder.flairView = null;
        imageCardLinkViewHolder.previewView = null;
        imageCardLinkViewHolder.domainView = null;
        super.mo6516a();
    }
}
