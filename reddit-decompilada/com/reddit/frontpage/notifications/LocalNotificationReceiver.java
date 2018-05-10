package com.reddit.frontpage.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.reddit.frontpage.util.NotificationUtil;
import com.reddit.frontpage.util.Util;

public class LocalNotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (intent.getExtras() != null) {
                if ("com.reddit.frontpage.notifications.ACTION_SEND_NOTIFICATION".equals(intent.getAction()) != null) {
                    NotificationUtil.m23853a(Util.m23965a(intent.getExtras()));
                }
            }
        }
    }
}
