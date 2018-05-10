package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XPostImageCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private XPostImageCardLinkViewHolder f34397b;

    public XPostImageCardLinkViewHolder_ViewBinding(XPostImageCardLinkViewHolder xPostImageCardLinkViewHolder, View view) {
        super(xPostImageCardLinkViewHolder, view);
        this.f34397b = xPostImageCardLinkViewHolder;
        xPostImageCardLinkViewHolder.cardBodyView = (SmallCardBodyView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", SmallCardBodyView.class);
    }

    public final void mo6516a() {
        XPostImageCardLinkViewHolder xPostImageCardLinkViewHolder = this.f34397b;
        if (xPostImageCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34397b = null;
        xPostImageCardLinkViewHolder.cardBodyView = null;
        super.mo6516a();
    }
}
