package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    final Builder f11382a;
    final NotificationCompat.Builder f11383b;
    RemoteViews f11384c;
    RemoteViews f11385d;
    final List<Bundle> f11386e = new ArrayList();
    final Bundle f11387f = new Bundle();
    int f11388g;
    RemoteViews f11389h;

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        Iterator it;
        this.f11383b = builder;
        if (VERSION.SDK_INT >= 26) {
            this.f11382a = new Builder(builder.f1119a, builder.f1112H);
        } else {
            this.f11382a = new Builder(builder.f1119a);
        }
        Notification notification = builder.f1117M;
        boolean z = false;
        Builder deleteIntent = this.f11382a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f1125g).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f1121c).setContentText(builder.f1122d).setContentInfo(builder.f1127i).setContentIntent(builder.f1123e).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.f1124f;
        if ((notification.flags & 128) != 0) {
            z = true;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z).setLargeIcon(builder.f1126h).setNumber(builder.f1128j).setProgress(builder.f1135q, builder.f1136r, builder.f1137s);
        if (VERSION.SDK_INT >= 16) {
            this.f11382a.setSubText(builder.f1133o).setUsesChronometer(builder.f1131m).setPriority(builder.f1129k);
            it = builder.f1120b.iterator();
            while (it.hasNext()) {
                m9999a((Action) it.next());
            }
            if (builder.f1105A != null) {
                this.f11387f.putAll(builder.f1105A);
            }
            if (VERSION.SDK_INT < 20) {
                if (builder.f1141w) {
                    this.f11387f.putBoolean("android.support.localOnly", true);
                }
                if (builder.f1138t != null) {
                    this.f11387f.putString("android.support.groupKey", builder.f1138t);
                    if (builder.f1139u) {
                        this.f11387f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f11387f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (builder.f1140v != null) {
                    this.f11387f.putString("android.support.sortKey", builder.f1140v);
                }
            }
            this.f11384c = builder.f1109E;
            this.f11385d = builder.f1110F;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f11382a.setShowWhen(builder.f1130l);
            if (!(VERSION.SDK_INT >= 21 || builder.f1118N == null || builder.f1118N.isEmpty())) {
                this.f11387f.putStringArray("android.people", (String[]) builder.f1118N.toArray(new String[builder.f1118N.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f11382a.setLocalOnly(builder.f1141w).setGroup(builder.f1138t).setGroupSummary(builder.f1139u).setSortKey(builder.f1140v);
            this.f11388g = builder.f1116L;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f11382a.setCategory(builder.f1144z).setColor(builder.f1106B).setVisibility(builder.f1107C).setPublicVersion(builder.f1108D);
            it = builder.f1118N.iterator();
            while (it.hasNext()) {
                this.f11382a.addPerson((String) it.next());
            }
            this.f11389h = builder.f1111G;
        }
        if (VERSION.SDK_INT >= 24) {
            this.f11382a.setExtras(builder.f1105A).setRemoteInputHistory(builder.f1134p);
            if (builder.f1109E != null) {
                this.f11382a.setCustomContentView(builder.f1109E);
            }
            if (builder.f1110F != null) {
                this.f11382a.setCustomBigContentView(builder.f1110F);
            }
            if (builder.f1111G != null) {
                this.f11382a.setCustomHeadsUpContentView(builder.f1111G);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f11382a.setBadgeIconType(builder.f1113I).setShortcutId(builder.f1114J).setTimeoutAfter(builder.f1115K).setGroupAlertBehavior(builder.f1116L);
            if (builder.f1143y) {
                this.f11382a.setColorized(builder.f1142x);
            }
        }
    }

    public final Builder mo256a() {
        return this.f11382a;
    }

    private void m9999a(Action action) {
        if (VERSION.SDK_INT >= 20) {
            Bundle bundle;
            Notification.Action.Builder builder = new Notification.Action.Builder(action.f1102e, action.f1103f, action.f1104g);
            if (action.f1099b != null) {
                for (RemoteInput addRemoteInput : RemoteInput.m10003a(action.f1099b)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (action.f1098a != null) {
                bundle = new Bundle(action.f1098a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.f1101d);
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.f1101d);
            }
            builder.addExtras(bundle);
            this.f11382a.addAction(builder.build());
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            this.f11386e.add(NotificationCompatJellybean.m687a(this.f11382a, action));
        }
    }

    static void m9998a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
