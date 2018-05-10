package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XPostSmallCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private XPostSmallCardLinkViewHolder f34399b;

    public XPostSmallCardLinkViewHolder_ViewBinding(XPostSmallCardLinkViewHolder xPostSmallCardLinkViewHolder, View view) {
        super(xPostSmallCardLinkViewHolder, view);
        this.f34399b = xPostSmallCardLinkViewHolder;
        xPostSmallCardLinkViewHolder.cardBodyView = (SmallCardBodyView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", SmallCardBodyView.class);
    }

    public final void mo6516a() {
        XPostSmallCardLinkViewHolder xPostSmallCardLinkViewHolder = this.f34399b;
        if (xPostSmallCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34399b = null;
        xPostSmallCardLinkViewHolder.cardBodyView = null;
        super.mo6516a();
    }
}
