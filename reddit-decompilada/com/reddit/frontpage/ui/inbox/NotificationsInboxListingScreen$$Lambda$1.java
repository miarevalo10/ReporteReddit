package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SimpleSortOptionsDialog;

final /* synthetic */ class NotificationsInboxListingScreen$$Lambda$1 implements OnClickListener {
    private final NotificationsInboxListingScreen f21248a;

    NotificationsInboxListingScreen$$Lambda$1(NotificationsInboxListingScreen notificationsInboxListingScreen) {
        this.f21248a = notificationsInboxListingScreen;
    }

    public final void onClick(View view) {
        view = this.f21248a;
        new SimpleSortOptionsDialog(view.f40157v, view.am_(), view.am_().getResources().getString(C1761R.string.title_sort_notifications), NotificationsInboxListingScreen.f40154B, NotificationsInboxListingScreen.f40155C, view.m40991R(), false, null).f20405a.show();
    }
}
