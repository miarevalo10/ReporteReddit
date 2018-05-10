package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class InboxListingScreen$$Lambda$2 implements OnClickListener {
    private final InboxListingScreen f21235a;

    InboxListingScreen$$Lambda$2(InboxListingScreen inboxListingScreen) {
        this.f21235a = inboxListingScreen;
    }

    public final void onClick(View view) {
        SessionManager.b().a(Util.m24019e(this.f21235a.am_()), false);
    }
}
