package com.reddit.frontpage.ui.inbox;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.inbox.InboxListingScreen.OnThreadClickedListener;
import com.reddit.frontpage.util.MessageUtil;

final /* synthetic */ class ModeratorInboxListingScreen$$Lambda$0 implements OnThreadClickedListener {
    private final ModeratorInboxListingScreen f29005a;

    ModeratorInboxListingScreen$$Lambda$0(ModeratorInboxListingScreen moderatorInboxListingScreen) {
        this.f29005a = moderatorInboxListingScreen;
    }

    public final void mo4977a(MessageThread messageThread) {
        Screen screen = this.f29005a;
        Message message = (Message) messageThread.f21245c.m23360a(0).f21182a.getData();
        String id = message.getId();
        Routing.m22623a(screen, Nav.m22567b(id, MessageUtil.m23814a(message)));
        if (MessageThreadScreen.f39192y.get(id) == null) {
            MessageUtil.m23817a(SessionManager.b().c, message, 5);
        }
        MessageThreadScreen.f39192y.put(id, Boolean.valueOf(false));
    }
}
