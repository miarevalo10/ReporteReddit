package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class XPostCompactCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private XPostCompactCardLinkViewHolder f34396b;

    public XPostCompactCardLinkViewHolder_ViewBinding(XPostCompactCardLinkViewHolder xPostCompactCardLinkViewHolder, View view) {
        super(xPostCompactCardLinkViewHolder, view);
        this.f34396b = xPostCompactCardLinkViewHolder;
        xPostCompactCardLinkViewHolder.cardBodyView = (CompactLinkView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", CompactLinkView.class);
    }

    public final void mo6516a() {
        XPostCompactCardLinkViewHolder xPostCompactCardLinkViewHolder = this.f34396b;
        if (xPostCompactCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34396b = null;
        xPostCompactCardLinkViewHolder.cardBodyView = null;
        super.mo6516a();
    }
}
