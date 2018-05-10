package com.reddit.frontpage.ui.inbox;

import android.view.View;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider;

public class MessagesInboxListingScreen extends InboxListingScreen {
    public String getAnalyticsScreenName() {
        return "inbox_messages";
    }

    public final String mo7443w() {
        return "messages";
    }

    public static MessagesInboxListingScreen m40981Q() {
        return new MessagesInboxListingScreen();
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        this.z.a(false, null);
    }

    protected final void mo7144v() {
        this.z = new MessageListingProvider("messages");
        m37523a(this.z);
    }
}
