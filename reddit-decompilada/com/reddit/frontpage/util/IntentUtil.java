package com.reddit.frontpage.util;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.instabug.library.model.NetworkLog;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.service.api.UploadService;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.EditActivityLegacy;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.GatewayBrowserActivity;
import com.reddit.frontpage.LightboxActivity;
import com.reddit.frontpage.LiveThreadActivity;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.ModMailActivity;
import com.reddit.frontpage.RedditDeepLinkActivity;
import com.reddit.frontpage.ReplyActivityLegacy;
import com.reddit.frontpage.WebBrowserActivity;
import com.reddit.frontpage.commons.analytics.ShareIntentReceiver;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper;
import com.reddit.frontpage.notifications.NotificationActivity;
import com.reddit.frontpage.service.sync.PreferencesSyncService;
import com.reddit.frontpage.ui.detail.web.WebViewFallback;
import com.reddit.frontpage.ui.preferences.PreferencesActivity;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import java.io.File;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.parceler.Parcels;

public class IntentUtil {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m23755a(android.content.Context r8, android.content.Intent r9) {
        /*
        r0 = com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings.a();
        r1 = r0.p();
        r2 = android.support.v4.app.TaskStackBuilder.a(r8);
        r3 = 0;
        r4 = 0;
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x002a }
        if (r5 != 0) goto L_0x0022;
    L_0x0014:
        r5 = new android.content.Intent;	 Catch:{ Exception -> 0x002a }
        r6 = "android.intent.action.VIEW";
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x002a }
        r7 = com.reddit.frontpage.RedditDeepLinkActivity.class;
        r5.<init>(r6, r1, r8, r7);	 Catch:{ Exception -> 0x002a }
        goto L_0x0023;
    L_0x0022:
        r5 = r4;
    L_0x0023:
        r0.a(r4);
        r4 = r5;
        goto L_0x0035;
    L_0x0028:
        r8 = move-exception;
        goto L_0x0049;
    L_0x002a:
        r1 = move-exception;
        r5 = "Failed to create deep link";
        r6 = new java.lang.Object[r3];	 Catch:{ all -> 0x0028 }
        timber.log.Timber.c(r1, r5, r6);	 Catch:{ all -> 0x0028 }
        r0.a(r4);
    L_0x0035:
        if (r4 != 0) goto L_0x0041;
    L_0x0037:
        r0 = 1;
        r4 = m23751a(r8, r0);
        if (r9 == 0) goto L_0x0041;
    L_0x003e:
        r4.fillIn(r9, r3);
    L_0x0041:
        r8 = r2.b(r4);
        r8.a();
        return;
    L_0x0049:
        r0.a(r4);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.IntentUtil.a(android.content.Context, android.content.Intent):void");
    }

    public static Intent m23751a(Context context, boolean z) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("com.reddit.frontpage.requires_init", z);
        return intent;
    }

    public static Intent m23745a(Context context, ScreenDeepLinker screenDeepLinker) {
        context = m23751a(context, false);
        context.putExtra("com.reddit.frontpage.deep_linker", Parcels.m28672a((Object) screenDeepLinker));
        return context;
    }

    public static Intent m23746a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(NetworkLog.PLAIN_TEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        if (VERSION.SDK_INT < 22) {
            return Intent.createChooser(intent, Util.m24027f((int) C1761R.string.action_share));
        }
        return Intent.createChooser(intent, Util.m24027f((int) C1761R.string.action_share), PendingIntent.getBroadcast(context, 0, new Intent(context, ShareIntentReceiver.class), MQEncoder.CARRY_MASK).getIntentSender());
    }

    public static Intent m23744a(Context context, LiveThread liveThread) {
        Intent intent = new Intent(context, LiveThreadActivity.class);
        intent.putExtra("com.reddit.live_thread", Parcels.m28672a((Object) liveThread));
        return intent;
    }

    public static Intent m23761b(Context context, String str) {
        Intent intent = new Intent(context, LiveThreadActivity.class);
        intent.putExtra("live_thread_id_mvp", str);
        return intent;
    }

    public static Intent m23747a(Context context, String str, int i) {
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("com.reddit.extra.initial_url", str);
        intent.putExtra("com.reddit.extra.color", i);
        return intent;
    }

    public static Intent m23762b(Context context, String str, int i) {
        Intent intent = new Intent(context, ModMailActivity.class);
        intent.putExtra("com.reddit.extra.initial_url", str);
        intent.putExtra("com.reddit.extra.color", i);
        return intent;
    }

    public static Intent m23749a(Context context, String str, String str2, int i) {
        Intent intent = new Intent(context, GatewayBrowserActivity.class);
        intent.putExtra("com.reddit.extra.initial_url", str);
        intent.putExtra("com.reddit.extra.color", i);
        intent.putExtra("com.reddit.extra.title_override", str2);
        return intent;
    }

    public static Intent m23738a(Context context) {
        Intent intent = new Intent(context, PreferencesActivity.class);
        intent.addFlags(131072);
        return intent;
    }

    public static Intent m23740a(Context context, Replyable replyable) {
        Intent intent = new Intent(context, ReplyActivityLegacy.class);
        intent.putExtra("wrapper", replyable);
        return intent;
    }

    public static Intent m23741a(Context context, Comment comment) {
        Intent intent = new Intent(context, EditActivityLegacy.class);
        intent.putExtra("extra_wrapper", Parcels.m28672a((Object) comment));
        return intent;
    }

    public static Intent m23742a(Context context, Link link) {
        Intent intent = new Intent(context, EditActivityLegacy.class);
        intent.putExtra("extra_wrapper", Parcels.m28672a((Object) link));
        return intent;
    }

    public static Intent m23759b(Context context) {
        Intent intent = new Intent(context, PreferencesSyncService.class);
        intent.putExtra("action", "fetch");
        return intent;
    }

    public static Intent m23765c(Context context) {
        Intent intent = new Intent(context, PreferencesSyncService.class);
        intent.putExtra("action", "set");
        return intent;
    }

    public static boolean m23758a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.reddit.frontpage");
        intent.setData(uri);
        uri = FrontpageApplication.f27402a.getPackageManager().resolveActivity(intent, 0);
        if (uri == null || TextUtils.equals(RedditDeepLinkActivity.class.getCanonicalName(), uri.activityInfo.name) == null) {
            return false;
        }
        return true;
    }

    public static Intent m23752a(String str) {
        return m23763b(Uri.parse(str));
    }

    public static Intent m23763b(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setComponent(new ComponentName(FrontpageApplication.f27402a, RedditDeepLinkActivity.class));
        return intent;
    }

    public static Intent m23748a(Context context, String str, String str2) {
        Intent intent = new Intent(context, UploadService.class);
        intent.putExtra(UploadService.EXTRA_PATH, Uri.fromFile(new File(str)));
        intent.putExtra(UploadService.EXTRA_REQUEST_ID, str2);
        return intent;
    }

    public static Intent m23764b(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    public static void m23756a(Context context, Uri uri) {
        context.startActivity(new Intent("android.intent.action.VIEW", uri));
    }

    public static void m23757a(Context context, Link link, String str) {
        Uri parse = Uri.parse(link.getUrl());
        if (VideoUtil.m24055a(parse)) {
            m23756a(context, parse);
        } else if (Util.m24015d(link)) {
            context.startActivity(m23743a(context, link, str, 2));
        } else {
            String str2;
            if (link.getSubredditDetail() != null) {
                str2 = link.getSubredditDetail().key_color;
            } else {
                str2 = null;
            }
            CustomTabsActivityHelper.m21970a(Util.m24014d(context), new Builder().a(Util.m23951a(context, str2)).a(), Uri.parse(link.getUrl()), link.getName(), str, new WebViewFallback(link));
        }
    }

    public static Intent m23753a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(FrontpageApplication.f27402a, NotificationActivity.class);
        intent.putExtra("com.reddit.extra.id", str);
        intent.putExtra("com.reddit.extra.type", str2);
        intent.putExtra("com.reddit.extra.extras", str3);
        intent.putExtra("com.reddit.extra.uri", str4);
        intent.putExtra("account_id", str5);
        return intent;
    }

    public static Intent m23760b(Context context, Link link, String str) {
        return m23743a(context, link, str, 1);
    }

    public static Intent m23750a(Context context, String str, String str2, int i, int i2) {
        Intent intent = new Intent(context, LightboxActivity.class);
        intent.putExtra("com.reddit.frontpage.extra_image_url", str);
        intent.putExtra("com.reddit.frontpage.extra_source_page", str2);
        intent.putExtra("com.reddit.frontpage.extra_type", 1);
        intent.putExtra("com.reddit.frontpage.extra_image_width", i);
        intent.putExtra("com.reddit.frontpage.extra_image_height", i2);
        return intent;
    }

    public static Intent m23739a(Context context, Uri uri, Uri uri2, String str) {
        Intent intent = new Intent(context, LightboxActivity.class);
        intent.putExtra("com.reddit.frontpage.extra_video_uri", uri);
        intent.putExtra("com.reddit.frontpage.extra_video_preview_uri", uri2);
        intent.putExtra("com.reddit.frontpage.extra_source_page", str);
        intent.putExtra("com.reddit.frontpage.extra_type", 2);
        return intent;
    }

    private static Intent m23743a(Context context, Link link, String str, int i) {
        Intent intent = new Intent(context, LightboxActivity.class);
        intent.putExtra("com.reddit.frontpage.extra_link", Parcels.m28672a((Object) link));
        intent.putExtra("com.reddit.frontpage.extra_source_page", str);
        intent.putExtra("com.reddit.frontpage.extra_type", i);
        return intent;
    }

    public static <T extends Parcelable> T m23754a(Intent intent, String str, Class<T> cls) {
        intent = intent.getParcelableExtra(str);
        return (intent == null || cls.isInstance(intent) == null) ? null : (Parcelable) cls.cast(intent);
    }
}
