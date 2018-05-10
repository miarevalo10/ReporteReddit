package com.reddit.frontpage.service.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.reddit.frontpage.util.NotificationUtil;
import java.util.Map;
import timber.log.Timber;

public class RedditMessagingService extends FirebaseMessagingService {
    public final void m34883a(RemoteMessage remoteMessage) {
        int i = 0;
        Timber.b("Push notification received", new Object[0]);
        Timber.b("Push Notification from: %s", new Object[]{remoteMessage.a.getString("from")});
        Map a = remoteMessage.a();
        if (a != null) {
            if (a.size() != 0) {
                Timber.b("Push Notification data payload: %s", new Object[]{a.toString()});
                if (remoteMessage.a() != null) {
                    Timber.b("Push notification has no payload, short circuiting.", new Object[0]);
                } else {
                    i = 1;
                }
                if (i == 0) {
                    NotificationUtil.m23853a(remoteMessage.a());
                }
            }
        }
        Timber.b("Push notification data payload was null or empty", new Object[0]);
        if (remoteMessage.a() != null) {
            i = 1;
        } else {
            Timber.b("Push notification has no payload, short circuiting.", new Object[0]);
        }
        if (i == 0) {
            NotificationUtil.m23853a(remoteMessage.a());
        }
    }
}
