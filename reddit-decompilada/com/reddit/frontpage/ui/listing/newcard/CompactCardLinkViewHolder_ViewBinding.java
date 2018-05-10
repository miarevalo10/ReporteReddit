package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class CompactCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private CompactCardLinkViewHolder f34375b;

    public CompactCardLinkViewHolder_ViewBinding(CompactCardLinkViewHolder compactCardLinkViewHolder, View view) {
        super(compactCardLinkViewHolder, view);
        this.f34375b = compactCardLinkViewHolder;
        compactCardLinkViewHolder.bodyView = (CompactLinkView) Utils.b(view, C1761R.id.link_card_body, "field 'bodyView'", CompactLinkView.class);
    }

    public final void mo6516a() {
        CompactCardLinkViewHolder compactCardLinkViewHolder = this.f34375b;
        if (compactCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34375b = null;
        compactCardLinkViewHolder.bodyView = null;
        super.mo6516a();
    }
}
