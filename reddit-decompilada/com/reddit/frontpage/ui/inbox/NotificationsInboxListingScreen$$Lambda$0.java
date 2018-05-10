package com.reddit.frontpage.ui.inbox;

import android.app.Activity;
import android.net.Uri;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.Notification;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.ui.inbox.InboxListingScreen.OnThreadClickedListener;
import com.reddit.frontpage.util.MessageUtil;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class NotificationsInboxListingScreen$$Lambda$0 implements OnThreadClickedListener {
    private final NotificationsInboxListingScreen f29006a;

    NotificationsInboxListingScreen$$Lambda$0(NotificationsInboxListingScreen notificationsInboxListingScreen) {
        this.f29006a = notificationsInboxListingScreen;
    }

    public final void mo4977a(MessageThread messageThread) {
        Object id;
        NotificationsInboxListingScreen notificationsInboxListingScreen = this.f29006a;
        ReplyableWrapper replyableWrapper = messageThread.f21245c.m23360a(0).f21182a;
        Activity am_;
        if (messageThread.f21245c.m23360a(0).f21182a.getKind().equals(Kind.NOTIFICATION)) {
            Notification notification = (Notification) replyableWrapper.getData();
            id = notification.getId();
            if (MessageThreadScreen.f39192y.get(id) == null) {
                MessageUtil.m23818a(SessionManager.b().c, notification);
            }
            am_ = notificationsInboxListingScreen.am_();
            StringBuilder stringBuilder = new StringBuilder("https://www.reddit.com/");
            stringBuilder.append(notification.context);
            Util.m23966a(am_, Uri.parse(stringBuilder.toString()));
        } else {
            Message message = (Message) replyableWrapper.getData();
            String name = message.getName();
            am_ = notificationsInboxListingScreen.am_();
            StringBuilder stringBuilder2 = new StringBuilder("https://www.reddit.com");
            stringBuilder2.append(message.context);
            Util.m23966a(am_, Uri.parse(stringBuilder2.toString()));
            if (MessageThreadScreen.f39192y.get(name) == null) {
                MessageUtil.m23817a(SessionManager.b().c, message, MessageUtil.m23813a(messageThread));
            }
            id = name;
        }
        MessageThreadScreen.f39192y.put(id, Boolean.valueOf(false));
    }
}
