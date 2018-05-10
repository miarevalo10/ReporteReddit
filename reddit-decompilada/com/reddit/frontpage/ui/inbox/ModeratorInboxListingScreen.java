package com.reddit.frontpage.ui.inbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider.MessageErrorEvent;

public class ModeratorInboxListingScreen extends InboxListingScreen {
    public String getAnalyticsScreenName() {
        return "inbox_moderator";
    }

    public final String mo7443w() {
        return "moderator";
    }

    public static ModeratorInboxListingScreen m40985Q() {
        return new ModeratorInboxListingScreen();
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39177A = new ModeratorInboxListingScreen$$Lambda$0(this);
        return this.K;
    }

    public void onEvent(ErrorEvent errorEvent) {
        if (errorEvent instanceof MessageErrorEvent) {
            m39184b((Exception) errorEvent.exception);
        } else {
            super.onEvent(errorEvent);
        }
    }
}
