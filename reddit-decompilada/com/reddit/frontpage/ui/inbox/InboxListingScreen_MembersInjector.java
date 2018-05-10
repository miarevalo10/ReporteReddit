package com.reddit.frontpage.ui.inbox;

import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportPresenter;
import dagger.MembersInjector;

public final class InboxListingScreen_MembersInjector implements MembersInjector<InboxListingScreen> {
    public static void m30061a(InboxListingScreen inboxListingScreen, ThingReportPresenter thingReportPresenter) {
        inboxListingScreen.f39180w = thingReportPresenter;
    }
}
