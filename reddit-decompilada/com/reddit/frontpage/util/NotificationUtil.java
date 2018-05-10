package com.reddit.frontpage.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationManagerCompat.CancelTask;
import android.support.v4.app.TaskStackBuilder;
import android.text.Html;
import android.text.TextUtils;
import bolts.Task;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.instabug.chat.model.Attachment;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import timber.log.Timber;

public class NotificationUtil {
    private static final Random f21775a = new Random();

    static final /* synthetic */ Object m23850a(String str, String str2) throws Exception {
        try {
            NotificationManagerCompat a = NotificationManagerCompat.a(FrontpageApplication.f27402a);
            str2 = Integer.parseInt(str2);
            a.b.cancel(str, str2);
            if (VERSION.SDK_INT <= 19) {
                a.a(new CancelTask(a.a.getPackageName(), str2, str));
            }
        } catch (String str3) {
            Timber.e("Push notification cancel exception: %s", new Object[]{str3.toString()});
        }
        return null;
    }

    private static void m23857b(Map<String, String> map) {
        FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
        String str = (String) map.get("id");
        String str2 = (String) map.get("type");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Timber.e("Push notification tracking issue. ID=%s TYPE=%s", new Object[]{str, str2});
        } else {
            String str3 = (String) map.get("extra_event_params");
            if (NotificationManagerCompat.a(FrontpageApplication.f27402a).a()) {
                AppAnalytics.m21857a(str, str2, str3);
            } else {
                AppAnalytics.m21863b(str, str2, str3);
            }
        }
        Task.a(new NotificationUtil$$Lambda$1(str2, map, frontpageApplication, str), Task.b);
    }

    static final /* synthetic */ Object m23851a(String str, Map map, FrontpageApplication frontpageApplication, final String str2) throws Exception {
        boolean z = true;
        if ("transcoding_complete".equals(str) != null) {
            str = (String) map.get("video_key");
            if (TextUtils.isEmpty(str) == null) {
                Timber.b("Transcoding complete notification, video key [%s], error [%s]", new Object[]{str, (String) map.get("transcoding_error")});
                frontpageApplication.startService(VideoUploadService.getVideoTranscodingFinishedIntent(frontpageApplication, str, TextUtils.isEmpty(r11)));
            } else {
                Timber.e("Received transconfing complete notification without video key", new Object[0]);
            }
            return null;
        }
        CharSequence f;
        int nextInt;
        int parseInt;
        String str3;
        str = NotificationManagerCompat.a(frontpageApplication);
        final Builder builder = new Builder(frontpageApplication, "notifications");
        builder.a(C1761R.drawable.notification_reddit).h = BitmapFactory.decodeResource(FrontpageApplication.f27402a.getResources(), C1761R.mipmap.ic_launcher);
        if (TextUtils.isEmpty((CharSequence) map.get("title"))) {
            f = Util.m24027f((int) C1761R.string.app_name);
        } else {
            f = (String) map.get("title");
        }
        builder.a(f);
        if (!TextUtils.isEmpty((CharSequence) map.get("body"))) {
            builder.b((CharSequence) map.get("body"));
        }
        String str4 = (String) map.get("deeplink");
        if (!TextUtils.isEmpty(str4)) {
            TaskStackBuilder b = TaskStackBuilder.a(FrontpageApplication.f27402a).b(IntentUtil.m23753a((String) map.get("id"), (String) map.get("type"), (String) map.get("extra_event_params"), str4, (String) map.get("account_id")));
            nextInt = f21775a.nextInt();
            if (b.b.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
            }
            Intent[] intentArr = (Intent[]) b.b.toArray(new Intent[b.b.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Timber.b("Push notification pending intent: %s", new Object[]{TaskStackBuilder.a.a(b.c, intentArr, nextInt).toString()});
            builder.e = r5;
        }
        if (map.containsKey("auto_cancel")) {
            builder.a(Boolean.parseBoolean((String) map.get("auto_cancel")));
        } else {
            builder.a(true);
        }
        if (map.containsKey("priority")) {
            str4 = (String) map.get("priority");
            nextInt = Integer.parseInt(str4);
            if (nextInt < -2 || nextInt > 2) {
                z = false;
            }
            if (z) {
                parseInt = Integer.parseInt(str4);
                builder.k = parseInt;
                if (map.containsKey("ticker")) {
                    str3 = (String) map.get("ticker");
                    if (!TextUtils.isEmpty(str3)) {
                        builder.c(str3);
                    }
                }
                if (map.containsKey("big_text")) {
                    String str5 = (String) map.get("big_summary");
                    builder.a(new BigTextStyle().b(Html.fromHtml((String) map.get("big_text"))).a(str5));
                }
                if (map.containsKey("ongoing")) {
                    builder.a(2, Boolean.valueOf((String) map.get("ongoing")).booleanValue());
                }
                if (map.containsKey("group")) {
                    builder.t = (String) map.get("group");
                }
                if (map.containsKey("group_summary")) {
                    builder.u = Boolean.valueOf((String) map.get("group_summary")).booleanValue();
                }
                if (map.containsKey("number")) {
                    builder.j = Integer.parseInt((String) map.get("number"));
                }
                if (map.containsKey("sound_uri")) {
                    str3 = (String) map.get("sound_uri");
                    if (!TextUtils.isEmpty(str3)) {
                        builder.a(Uri.parse(str3));
                    }
                }
                if (map.containsKey("only_alert_once")) {
                    builder.a(8, Boolean.valueOf((String) map.get("only_alert_once")).booleanValue());
                }
                if (TextUtils.isEmpty((CharSequence) map.get(Attachment.TYPE_IMAGE))) {
                    GlideApp.a(frontpageApplication).h().load((String) map.get(Attachment.TYPE_IMAGE)).into(new SimpleTarget<Bitmap>() {
                        public final /* synthetic */ void m39617a(Object obj, Transition transition) {
                            Bitmap bitmap = (Bitmap) obj;
                            try {
                                transition = builder;
                                Style bigPictureStyle = new BigPictureStyle();
                                bigPictureStyle.a = bitmap;
                                transition.a(bigPictureStyle);
                                str.a(str2, builder.a());
                            } catch (Object obj2) {
                                Timber.c(obj2, "Push notification exception!", new Object[0]);
                            }
                        }
                    });
                } else {
                    str.a(str2, builder.a());
                }
                return null;
            }
        }
        parseInt = 2;
        builder.k = parseInt;
        if (map.containsKey("ticker")) {
            str3 = (String) map.get("ticker");
            if (TextUtils.isEmpty(str3)) {
                builder.c(str3);
            }
        }
        if (map.containsKey("big_text")) {
            String str52 = (String) map.get("big_summary");
            builder.a(new BigTextStyle().b(Html.fromHtml((String) map.get("big_text"))).a(str52));
        }
        if (map.containsKey("ongoing")) {
            builder.a(2, Boolean.valueOf((String) map.get("ongoing")).booleanValue());
        }
        if (map.containsKey("group")) {
            builder.t = (String) map.get("group");
        }
        if (map.containsKey("group_summary")) {
            builder.u = Boolean.valueOf((String) map.get("group_summary")).booleanValue();
        }
        if (map.containsKey("number")) {
            builder.j = Integer.parseInt((String) map.get("number"));
        }
        if (map.containsKey("sound_uri")) {
            str3 = (String) map.get("sound_uri");
            if (TextUtils.isEmpty(str3)) {
                builder.a(Uri.parse(str3));
            }
        }
        if (map.containsKey("only_alert_once")) {
            builder.a(8, Boolean.valueOf((String) map.get("only_alert_once")).booleanValue());
        }
        if (TextUtils.isEmpty((CharSequence) map.get(Attachment.TYPE_IMAGE))) {
            GlideApp.a(frontpageApplication).h().load((String) map.get(Attachment.TYPE_IMAGE)).into(/* anonymous class already generated */);
        } else {
            str.a(str2, builder.a());
        }
        return null;
    }

    public static void m23852a(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("id", UUID.randomUUID().toString());
        hashMap.put("type", "type");
        hashMap.put("title", str);
        hashMap.put("body", str2);
        hashMap.put("deeplink", str3);
        hashMap.put("extra_event_params", "{\"arbitrary\":\"yes\",\"predefined\":\"no\"}");
        m23857b(hashMap);
    }

    public static boolean m23854a() {
        return NotificationManagerCompat.a(FrontpageApplication.f27402a).a();
    }

    public static boolean m23855a(Context context) {
        return NotificationManagerCompat.a(context).a();
    }

    @RequiresApi(26)
    public static void m23856b(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("notifications", context.getString(C1761R.string.label_notifications), 3);
        notificationChannel.enableVibration(null);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public static NotificationChannel m23858c(Context context) {
        return ((NotificationManager) context.getSystemService("notification")).getNotificationChannel("notifications");
    }

    public static void m23853a(Map<String, String> map) {
        if (Boolean.parseBoolean((String) map.get("cancel"))) {
            String str = (String) map.get("cancel_id");
            if (!TextUtils.isEmpty(str)) {
                Task.a(new NotificationUtil$$Lambda$0((String) map.get("cancel_tag"), str), Task.b);
            }
            return;
        }
        m23857b((Map) map);
    }
}
