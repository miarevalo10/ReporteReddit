package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ListingFilterBarView;

public class NotificationsInboxListingScreen_ViewBinding extends InboxListingScreen_ViewBinding {
    private NotificationsInboxListingScreen f34300b;

    public NotificationsInboxListingScreen_ViewBinding(NotificationsInboxListingScreen notificationsInboxListingScreen, View view) {
        super(notificationsInboxListingScreen, view);
        this.f34300b = notificationsInboxListingScreen;
        notificationsInboxListingScreen.sortContainer = (FrameLayout) Utils.b(view, C1761R.id.sort_container, "field 'sortContainer'", FrameLayout.class);
        notificationsInboxListingScreen.sortBar = (ListingFilterBarView) Utils.b(view, C1761R.id.listing_filter_bar, "field 'sortBar'", ListingFilterBarView.class);
    }

    public final void mo6500a() {
        NotificationsInboxListingScreen notificationsInboxListingScreen = this.f34300b;
        if (notificationsInboxListingScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34300b = null;
        notificationsInboxListingScreen.sortContainer = null;
        notificationsInboxListingScreen.sortBar = null;
        super.mo6500a();
    }
}
