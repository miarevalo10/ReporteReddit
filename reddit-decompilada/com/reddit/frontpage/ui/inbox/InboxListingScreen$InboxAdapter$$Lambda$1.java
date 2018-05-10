package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class InboxListingScreen$InboxAdapter$$Lambda$1 implements OnClickListener {
    private final InboxAdapter f21241a;
    private final MessageThread f21242b;

    InboxListingScreen$InboxAdapter$$Lambda$1(InboxAdapter inboxAdapter, MessageThread messageThread) {
        this.f21241a = inboxAdapter;
        this.f21242b = messageThread;
    }

    public final void onClick(View view) {
        view = this.f21241a;
        MessageThread messageThread = this.f21242b;
        if (view.f28995a.f39177A != null) {
            view.f28995a.f39177A.mo4977a(messageThread);
        } else {
            view.f28995a.f39178B.mo4977a(messageThread);
        }
    }
}
