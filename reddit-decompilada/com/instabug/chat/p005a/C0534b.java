package com.instabug.chat.p005a;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.instabug.chat.C0520R;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.InstabugChat;
import com.instabug.chat.model.C0552c;
import com.instabug.chat.model.Message;
import com.instabug.chat.model.Message.C0546a;
import com.instabug.chat.p005a.C0532a.C0530b;
import com.instabug.chat.p007d.C0542c;
import com.instabug.chat.settings.C0554a;
import com.instabug.chat.ui.C0559a;
import com.instabug.library.C0593R;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugAppData;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.json.JSONObject;

/* compiled from: NotificationManager */
public class C0534b {
    private static C0534b f9237b;
    private int f9238a;
    private final C0532a f9239c = new C0532a();
    private InstabugAppData f9240d;
    private List<Message> f9241e;

    private C0534b() {
    }

    public static C0534b m7867a() {
        if (f9237b == null) {
            f9237b = new C0534b();
        }
        return f9237b;
    }

    public final void m7875a(Context context, List<Message> list) {
        CharSequence a;
        Intent a2;
        this.f9240d = new InstabugAppData(context);
        String str = "";
        List<Message> arrayList = new ArrayList();
        arrayList.addAll(list);
        Object obj = ((Message) list.get(0)).f15378b;
        Collections.sort(arrayList, new C0546a(1));
        int i = 1;
        for (Message message : arrayList) {
            String str2 = message.f15378b;
            if (!str2.equals(obj)) {
                i++;
                obj = str2;
            }
        }
        this.f9238a = i == 1 ? 0 : 1;
        this.f9241e = list;
        C0552c c0552c = null;
        switch (this.f9238a) {
            case 0:
                Message message2 = (Message) list.get(list.size() - 1);
                a = C0534b.m7869a(context, 0, (List) list);
                a2 = C0559a.m7965a(context, message2.f15378b);
                break;
            case 1:
                a = C0534b.m7869a(context, 1, (List) list);
                a2 = C0559a.m7964a(context);
                break;
            default:
                a = str;
                a2 = null;
                break;
        }
        if (InstabugCore.isAppOnForeground()) {
            Activity activity;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = InstabugCore.getTargetActivity();
            }
            if (InstabugCore.isForegroundBusy()) {
                ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
                if (chatPlugin == null || chatPlugin.getState() != 1) {
                    m7870a(context, a2, a);
                    return;
                }
            }
            Message message3 = (Message) list.get(list.size() - 1);
            switch (this.f9238a) {
                case 0:
                    c0552c = new C0552c();
                    c0552c.f9289a = C0534b.m7869a((Context) activity, 0, (List) list);
                    c0552c.f9290b = m7868a(activity, 0, message3.f15380d);
                    c0552c.f9291c = message3.f15381e;
                    break;
                case 1:
                    c0552c = new C0552c();
                    c0552c.f9289a = C0534b.m7869a((Context) activity, 1, (List) list);
                    c0552c.f9290b = m7868a(activity, 1, message3.f15380d);
                    c0552c.f9291c = message3.f15381e;
                    break;
                default:
                    break;
            }
            this.f9239c.m7866a(activity, c0552c, new C0530b(this) {
                final /* synthetic */ C0534b f15358b;

                public final void mo2565a() {
                    C0534b.m7872a(this.f15358b, activity);
                }
            });
            return;
        }
        m7870a(context, a2, a);
    }

    public final void m7874a(Context context) {
        context = MediaPlayer.create(context, C0593R.raw.new_message);
        if (VERSION.SDK_INT >= 21) {
            context.setAudioAttributes(new Builder().setUsage(5).setContentType(4).build());
        } else {
            context.setAudioStreamType(5);
        }
        context.start();
        context.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ C0534b f9236b;

            public void onCompletion(MediaPlayer mediaPlayer) {
                context.release();
            }
        });
    }

    private static String m7869a(Context context, int i, List<Message> list) {
        switch (i) {
            case 0:
                return ((Message) list.get(list.size() - 1)).f15379c;
            case 1:
                context = context.getResources();
                i = ((Message) list.get(list.size() - 1)).f15380d.split(" ");
                return String.format(context.getString(C0593R.string.instabug_str_notifications_body), new Object[]{Integer.valueOf(list.size()), i[0]});
            default:
                return "";
        }
    }

    private String m7868a(Activity activity, int i, String str) {
        activity = activity.getResources();
        switch (i) {
            case 0:
                i = new StringBuilder();
                i.append(str);
                i.append(" (");
                i.append(String.format(activity.getString(C0593R.string.instabug_str_notification_title), new Object[]{this.f9240d.getAppName()}));
                i.append(")");
                return i.toString();
            case 1:
                return String.format(activity.getString(C0520R.string.instabug_str_notification_title), new Object[]{this.f9240d.getAppName()});
            default:
                return "";
        }
    }

    private void m7870a(Context context, Intent intent, CharSequence charSequence) {
        int i = C0554a.m7954i();
        if (i == -1 || i == 0) {
            i = this.f9240d.getAppIcon();
        }
        String str = "ibg_channel";
        intent = PendingIntent.getActivity(context, 0, intent, MQEncoder.CARRY_MASK);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        charSequence = new NotificationCompat.Builder(context, str).m674a(i).m679a(this.f9240d.getAppName()).m682b(charSequence).m680a(true);
        charSequence.f1112H = str;
        charSequence.f1123e = intent;
        if (VERSION.SDK_INT >= 16) {
            charSequence.f1129k = 1;
        }
        if (VERSION.SDK_INT >= 21) {
            charSequence.f1117M.vibrate = new long[0];
        }
        if (C0554a.m7952g() != null) {
            charSequence.m676a(defaultUri);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            if (VERSION.SDK_INT >= 26) {
                intent = new NotificationChannel(str, this.f9240d.getAppName(), 4);
                intent.setImportance(4);
                notificationManager.createNotificationChannel(intent);
            }
            notificationManager.notify(0, charSequence.m673a());
        }
    }

    public static void m7871a(Bundle bundle) {
        if (InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == State.ENABLED && InstabugChat.isInstabugNotification(bundle) != null) {
            C0542c.m7913a().m7924b();
        }
    }

    public static void m7873a(Map<String, String> map) {
        if (InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == State.ENABLED && InstabugChat.isInstabugNotification((Map) map) != null) {
            C0542c.m7913a().m7924b();
        }
    }

    public final boolean m7876b(Bundle bundle) {
        try {
            bundle = new JSONObject(bundle.getString("message")).getString("IBGHost");
            StringBuilder stringBuilder = new StringBuilder("IBGHost: ");
            stringBuilder.append(bundle);
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            if (!(bundle == null || Boolean.parseBoolean(bundle) == null)) {
                return true;
            }
        } catch (Bundle bundle2) {
            InstabugSDKLogger.m8358e(this, "Parsing GCM response failed", bundle2);
        } catch (Bundle bundle22) {
            InstabugSDKLogger.m8358e(this, "Something went wrong while showing notification", bundle22);
        }
        return null;
    }

    public final boolean m7877b(Map<String, String> map) {
        if (map.containsKey("message")) {
            try {
                map = new JSONObject((String) map.get("message")).getString("IBGHost");
                if (!(map == null || Boolean.parseBoolean(map) == null)) {
                    return true;
                }
            } catch (Map<String, String> map2) {
                InstabugSDKLogger.m8358e(this, "Parsing GCM response failed", map2);
            } catch (Map<String, String> map22) {
                InstabugSDKLogger.m8358e(this, "Something went wrong while showing notification", map22);
            }
        }
        return null;
    }

    static /* synthetic */ void m7872a(C0534b c0534b, Activity activity) {
        switch (c0534b.f9238a) {
            case 0:
                activity.startActivity(C0559a.m7965a(activity, ((Message) c0534b.f9241e.get(c0534b.f9241e.size() - 1)).f15378b));
                return;
            case 1:
                activity.startActivity(C0559a.m7964a(activity));
                break;
            default:
                break;
        }
    }
}
