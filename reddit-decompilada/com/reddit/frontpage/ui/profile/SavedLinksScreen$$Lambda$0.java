package com.reddit.frontpage.ui.profile;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.datalibrary.frontpage.data.provider.SavedLinksProvider;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter.OnLinkHiddenListener;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;

final /* synthetic */ class SavedLinksScreen$$Lambda$0 implements OnLinkHiddenListener {
    private final SavedLinksScreen f29235a;

    SavedLinksScreen$$Lambda$0(SavedLinksScreen savedLinksScreen) {
        this.f29235a = savedLinksScreen;
    }

    public final void mo4978a(LinkViewHolder linkViewHolder) {
        SavedLinksScreen savedLinksScreen = this.f29235a;
        ViewHolder viewHolder = linkViewHolder;
        if (savedLinksScreen.w instanceof SavedLinksProvider) {
            SavedLinksProvider savedLinksProvider = (SavedLinksProvider) savedLinksScreen.w;
            savedLinksProvider.mObjects.remove(viewHolder.d());
            savedLinksScreen.y.f(viewHolder.d());
        }
    }
}
