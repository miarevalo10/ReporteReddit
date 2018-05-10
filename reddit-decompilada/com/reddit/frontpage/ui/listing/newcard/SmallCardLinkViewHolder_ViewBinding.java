package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SmallCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private SmallCardLinkViewHolder f34392b;

    public SmallCardLinkViewHolder_ViewBinding(SmallCardLinkViewHolder smallCardLinkViewHolder, View view) {
        super(smallCardLinkViewHolder, view);
        this.f34392b = smallCardLinkViewHolder;
        smallCardLinkViewHolder.cardBodyView = (SmallCardBodyView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", SmallCardBodyView.class);
    }

    public final void mo6516a() {
        SmallCardLinkViewHolder smallCardLinkViewHolder = this.f34392b;
        if (smallCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34392b = null;
        smallCardLinkViewHolder.cardBodyView = null;
        super.mo6516a();
    }
}
