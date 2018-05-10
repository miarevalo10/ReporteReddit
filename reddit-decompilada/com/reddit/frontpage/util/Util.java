package com.reddit.frontpage.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import com.crashlytics.android.Crashlytics;
import com.instabug.chat.model.Attachment;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.common.ThingUtil;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.SaveMediaJob;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.sync.SyncSchedule;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine;
import com.reddit.frontpage.ui.detail.web.WebViewFallback;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import timber.log.Timber;

public class Util {
    public static Set<Pattern> f21809a;
    public static Set<Pattern> f21810b;
    public static Set<Pattern> f21811c;
    public static Set<Pattern> f21812d;
    private static final AtomicLong f21813e = new AtomicLong(-1000);
    private static final Pattern f21814f = Pattern.compile("<[^>]*>|<a .*?$|&.+?;|\\s*\\n\\s*");
    private static final String[] f21815g = new String[]{"gifv", "mp4", "webm"};
    private static final String[] f21816h = new String[]{"gif"};

    public static void m24006c() {
    }

    public static double m24035i(int i) {
        return ((double) i) / 1609.344d;
    }

    public static Activity m23954a(Context context) {
        while (!(context instanceof Activity)) {
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                StringBuilder stringBuilder = new StringBuilder("Couldn't get an activity from ");
                stringBuilder.append(context);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (Activity) context;
    }

    public static int m23953a(String str) {
        if (TextUtils.isEmpty(str)) {
            return ResourcesUtil.m22740i(FrontpageApplication.f27402a, C1761R.attr.rdt_default_key_color);
        }
        return Color.parseColor(str);
    }

    public static int m23951a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return ResourcesUtil.m22740i(context, C1761R.attr.rdt_default_key_color);
        }
        return Color.parseColor(str);
    }

    public static void m23985a(ShapedIconView shapedIconView, String str, String str2, String str3) {
        m23986a(shapedIconView, str, str2, str3, false);
    }

    public static void m23986a(ShapedIconView shapedIconView, String str, String str2, String str3, boolean z) {
        m23988a(shapedIconView, str2, str3, SubredditUtil.m23920a((CharSequence) str), z);
    }

    public static void m23980a(ShapedIconView shapedIconView, Subreddit subreddit) {
        String str = null;
        String keyColor = subreddit != null ? subreddit.getKeyColor() : null;
        if (subreddit != null) {
            str = subreddit.getIconImg();
        }
        m23988a(shapedIconView, str, keyColor, false, false);
    }

    @Deprecated
    public static void m23978a(ShapedIconView shapedIconView, com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit) {
        m23979a(shapedIconView, subreddit, AccountPrefsUtil.m23629a(Boolean.valueOf(subreddit.over_18)));
    }

    @Deprecated
    public static void m23976a(ShapedIconView shapedIconView) {
        m23987a(shapedIconView, null, null, false);
    }

    public static void m23977a(ShapedIconView shapedIconView, Account account) {
        m24008c(shapedIconView, account.subreddit, false);
    }

    public static void m23982a(ShapedIconView shapedIconView, String str, String str2) {
        m23987a(shapedIconView, str, str2, false);
    }

    public static void m24000b(ShapedIconView shapedIconView) {
        m23984a(shapedIconView, null, null, null, null, null, false);
    }

    public static void m23987a(ShapedIconView shapedIconView, String str, String str2, boolean z) {
        m23984a(shapedIconView, str, str2, null, null, null, z);
    }

    public static void m23988a(ShapedIconView shapedIconView, String str, String str2, boolean z, boolean z2) {
        m23983a(shapedIconView, str, str2, null, null, null, null, z, z2);
    }

    public static void m23981a(ShapedIconView shapedIconView, String str, Integer num, boolean z) {
        m23983a(shapedIconView, str, null, num, null, null, null, z, false);
    }

    public static void m23984a(ShapedIconView shapedIconView, String str, String str2, Integer num, Integer num2, Integer num3, boolean z) {
        m23983a(shapedIconView, str, str2, null, num, num2, num3, z, false);
    }

    public static void m23983a(ShapedIconView shapedIconView, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, boolean z, boolean z2) {
        Context context = shapedIconView.getContext();
        if (!TextUtils.isEmpty(str2)) {
            str2 = Color.parseColor(str2);
        } else if (num != null) {
            str2 = num.intValue();
        } else {
            if (num2 != null) {
                str2 = num2.intValue();
            } else {
                str2 = num3 != null ? m23950a(num3.intValue()) : z ? C1761R.attr.rdt_default_user_key_color : C1761R.attr.rdt_default_key_color;
            }
            str2 = ResourcesUtil.m22740i(context, str2);
        }
        shapedIconView.setPadding(0, 0, 0, 0);
        if (z2) {
            shapedIconView.post(new Util$$Lambda$0(shapedIconView));
        } else if (TextUtils.isEmpty(str) != null) {
            if (num4 == null) {
                str = ResourcesUtil.m22724b(context, z ? C1761R.drawable.ic_icon_redditor : C1761R.drawable.ic_icon_planet, C1761R.attr.rdt_light_text_color);
            } else if (num4.intValue() == C1761R.drawable.ic_icon_moderate) {
                str = ResourcesUtil.m22730d(context, num4.intValue(), ContextCompat.c(context, C1761R.color.rdt_green));
                str2 = ContextCompat.c(context, C1761R.color.rdt_white);
            } else {
                str = ResourcesUtil.m22724b(context, num4.intValue(), C1761R.attr.rdt_light_text_color);
            }
            shapedIconView.setImageDrawable(new InsetDrawable(str, shapedIconView.getResources().getDimensionPixelSize(C1761R.dimen.three_quarter_pad)));
        } else {
            GlideApp.a(context).b(str).into(shapedIconView);
        }
        shapedIconView.setShape(z ? true : 2);
        shapedIconView = shapedIconView.getBackground();
        if ((shapedIconView instanceof GradientDrawable) != null) {
            ((GradientDrawable) shapedIconView).setColor(str2);
        } else {
            shapedIconView.setColorFilter(str2, Mode.SRC_ATOP);
        }
    }

    @Deprecated
    public static int m23952a(Link link) {
        List crosspostParentList = link.getCrosspostParentList();
        if (crosspostParentList != null && !crosspostParentList.isEmpty()) {
            return 10;
        }
        if (link.isSelf()) {
            return link.getPreview() != null ? 3 : 2;
        } else {
            if (link.getPreview() != null) {
                if (m24010c(link)) {
                    return 5;
                }
                if (m24043l(link) != null) {
                    return 4;
                }
            }
            return 1;
        }
    }

    public static ClientLink m23994b(Link link) {
        link = link.getCrosspostParentList();
        return (link == null || link.isEmpty()) ? null : (ClientLink) link.get(0);
    }

    @Deprecated
    public static boolean m24002b(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        for (String str2 : f21815g) {
            StringBuilder stringBuilder = new StringBuilder(".");
            stringBuilder.append(str2);
            if (str.endsWith(stringBuilder.toString())) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean m24011c(String str) {
        str = str.toLowerCase();
        for (String str2 : f21816h) {
            StringBuilder stringBuilder = new StringBuilder(".");
            stringBuilder.append(str2);
            if (str.endsWith(stringBuilder.toString())) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean m24010c(Link link) {
        if (link.isVideo()) {
            return true;
        }
        if (f21811c == null || f21812d == null) {
            AppConfigSyncRoutine.m29921a(FrontpageSettings.a().t());
        }
        String url = link.getUrl();
        boolean z = (m24002b(url) || m24011c(url)) && m24015d(link);
        if (link.getPreview() == null || (!z && link.getPostHint().equals("rich:video") == null && m23991a(url, f21811c, f21812d) == null)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean m24015d(Link link) {
        if (link.isVideo()) {
            return !(link.getMedia() == null || link.getMedia().getRedditVideo() == null) || ((link instanceof ClientLink) && ((ClientLink) link).getVideoDashUrl() != null);
        } else {
            LinkPreview preview = link.getPreview();
            return m24045m(link) != null ? TextUtils.isEmpty(preview.getRedditVideoPreview().getDashUrl()) == null : preview != null && TextUtils.isEmpty(preview.getMp4Url()) == null;
        }
    }

    public static boolean m24016d(String str) {
        if (str == null) {
            return false;
        }
        str = Uri.parse(str).getHost();
        if (str != null) {
            if (str.startsWith("www.")) {
                str = str.substring(4);
            }
            if (Arrays.asList(m24023e((int) C1761R.array.safe_harbor_domains)).contains(str) != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean m24045m(Link link) {
        return (!FrontpageSettings.a().t().c() || link.getPreview() == null || link.getPreview().getRedditVideoPreview() == null) ? null : true;
    }

    public static boolean m24022e(Link link) {
        return (!m24045m(link) || link.getPreview().getRedditVideoPreview().isGif() == null) ? null : true;
    }

    public static boolean m24028f(Link link) {
        return (link.getPreview() == null || link.getPreview().getRedditVideoPreview() == null || link.getPreview().getRedditVideoPreview().isGif() == null) ? null : true;
    }

    public static boolean m24031g(Link link) {
        if (link.isVideo()) {
            return true;
        }
        if (m24045m(link) && link.getPreview().getRedditVideoPreview().isGif() == null) {
            return true;
        }
        return false;
    }

    public static boolean m24034h(Link link) {
        if (link.isVideo()) {
            return true;
        }
        if (link.getPreview() == null || link.getPreview().getRedditVideoPreview() == null) {
            return null;
        }
        return true;
    }

    public static String m24036i(Link link) {
        if (link.isVideo()) {
            if (link.getMedia() != null && link.getMedia().getRedditVideo() != null) {
                return link.getMedia().getRedditVideo().getDashUrl();
            }
            if (link instanceof ClientLink) {
                return ((ClientLink) link).getVideoDashUrl();
            }
        }
        link = link.getPreview();
        if (!FrontpageSettings.a().t().c() || link == null || link.getRedditVideoPreview() == null || TextUtils.isEmpty(link.getRedditVideoPreview().getDashUrl())) {
            return link != null ? link.getMp4Url() : null;
        } else {
            return link.getRedditVideoPreview().getDashUrl();
        }
    }

    public static String m23964a(String str, String str2) {
        if (ImgurUtil.m23727a(Uri.parse(str))) {
            return ImgurUtil.m23729b(str);
        }
        return TextUtils.isEmpty(str2) == null ? str2 : null;
    }

    public static String m23963a(Link link, Point point) {
        return m23996b(link, point);
    }

    public static String m23996b(Link link, Point point) {
        if (link.isVideo()) {
            if (link.getMedia() != null && link.getMedia().getRedditVideo() != null) {
                return link.getMedia().getRedditVideo().getDashUrl();
            }
            if (link instanceof ClientLink) {
                return ((ClientLink) link).getVideoDashUrl();
            }
        }
        LinkPreview preview = link.getPreview();
        if (preview == null) {
            return null;
        }
        if (FrontpageSettings.a().t().c() && preview != null && preview.getRedditVideoPreview() != null && !TextUtils.isEmpty(preview.getRedditVideoPreview().getDashUrl())) {
            return preview.getRedditVideoPreview().getDashUrl();
        }
        point = m23958a(preview.getMp4Resolutions(), point);
        if (point != null) {
            return point.getUrl();
        }
        if (TextUtils.isEmpty(preview.getMp4Url()) == null) {
            return preview.getMp4Url();
        }
        if (ImgurUtil.m23727a(Uri.parse(link.getUrl())) != null) {
            return ImgurUtil.m23729b(link.getUrl());
        }
        return null;
    }

    public static ImageResolution m23958a(List<ImageResolution> list, Point point) {
        ImageResolution imageResolution = null;
        if (list.isEmpty()) {
            return null;
        }
        for (ImageResolution imageResolution2 : list) {
            if (((double) (imageResolution2.getHeight() / 2)) > ((double) point.y) * 1.1d || ((double) (imageResolution2.getWidth() / 2)) > ((double) point.x) * 1.1d) {
                break;
            } else if (imageResolution2.getHeight() > 0 && imageResolution2.getWidth() > 0) {
                imageResolution = imageResolution2;
            }
        }
        return imageResolution;
    }

    public static String m24038j(Link link) {
        if (link.isVideo()) {
            if (link.getMedia() != null && link.getMedia().getRedditVideo() != null) {
                return link.getMedia().getRedditVideo().getScrubberMediaUrl();
            }
            if (link instanceof ClientLink) {
                return ((ClientLink) link).getVideoScrubberUrl();
            }
        }
        return m24036i(link);
    }

    public static String m24040k(Link link) {
        link = link.getPreview();
        return link != null ? link.getGifUrl() : null;
    }

    @Deprecated
    public static boolean m24043l(Link link) {
        if (f21809a == null || f21810b == null) {
            AppConfigSyncRoutine.m29921a(FrontpageSettings.a().t());
        }
        return (link.getPreview() == null || m24010c(link) || (!TextUtils.equals(link.getPostHint(), Attachment.TYPE_IMAGE) && m23991a(link.getUrl(), f21809a, f21810b) == null)) ? null : true;
    }

    @Deprecated
    private static boolean m23991a(String str, Set<Pattern> set, Set<Pattern> set2) {
        for (Pattern matcher : set2) {
            if (matcher.matcher(str).find()) {
                return false;
            }
        }
        for (Pattern matcher2 : set) {
            if (matcher2.matcher(str).find() != null) {
                return true;
            }
        }
        return false;
    }

    public static void m23969a(Context context, String str, String str2) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
    }

    @Deprecated
    public static int m23950a(int i) {
        return FrontpageApplication.f27402a.getResources().getColor(i);
    }

    public static final String m23995b(int i) {
        return String.format("#%06X", new Object[]{Integer.valueOf(i & 16777215)});
    }

    public static int m24004c(int i) {
        return FrontpageApplication.f27402a.getResources().getDimensionPixelOffset(i);
    }

    public static int m24012d(int i) {
        return FrontpageApplication.f27402a.getResources().getDimensionPixelSize(i);
    }

    public static int[] m23992a() {
        TypedArray obtainTypedArray = FrontpageApplication.f27402a.getResources().obtainTypedArray(C1761R.array.snoomoji_icons);
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            iArr[i] = obtainTypedArray.getResourceId(i, -1);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    public static String[] m24023e(int i) {
        return FrontpageApplication.f27402a.getResources().getStringArray(i);
    }

    public static Point m23955a(Activity activity) {
        if (activity == null) {
            return m23993b();
        }
        return m23956a(activity.getWindowManager().getDefaultDisplay());
    }

    public static Point m23993b() {
        return m23956a(((WindowManager) FrontpageApplication.f27402a.getApplicationContext().getSystemService("window")).getDefaultDisplay());
    }

    private static Point m23956a(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    public static final void m23998b(Context context) {
        SyncSchedule.m23258a(context);
        android.accounts.Account a = AccountUtil.a(FrontpageApplication.f27402a);
        if (a != null) {
            SyncSchedule.m23255a(a);
        }
    }

    public static void m23967a(Activity activity, Uri uri, int i, String str, String str2) {
        if (IntentUtil.m23758a(uri)) {
            activity.startActivity(IntentUtil.m23763b(uri));
        } else {
            m23997b(activity, uri, i, str, str2);
        }
    }

    public static void m23973a(RedditThemedActivity redditThemedActivity, Uri uri, String str) {
        m23997b(redditThemedActivity, uri, ResourcesUtil.m22740i(redditThemedActivity, C1761R.attr.rdt_active_color), null, str);
    }

    private static void m23997b(Activity activity, Uri uri, int i, String str, String str2) {
        CustomTabsActivityHelper.m21970a(activity, new Builder().a(i).a(), uri, str, str2, new WebViewFallback(uri, Integer.valueOf(i)));
    }

    public static void m23966a(Activity activity, Uri uri) {
        m23968a(activity, uri, null);
    }

    public static void m23968a(Activity activity, Uri uri, String str) {
        if (VideoUtil.m24055a(uri)) {
            IntentUtil.m23756a((Context) activity, uri);
        } else {
            m23967a(activity, uri, ResourcesUtil.m22740i(activity, C1761R.attr.rdt_toolbar_color), null, str);
        }
    }

    public static int m24005c(Context context) {
        return ResourcesUtil.m22740i(context, C1761R.attr.rdt_toolbar_color);
    }

    public static boolean m24003b(String str, String str2) {
        CharSequence charSequence = null;
        str = str == null ? null : str.toLowerCase();
        if (str2 != null) {
            charSequence = str2.toLowerCase();
        }
        return TextUtils.equals(str, charSequence);
    }

    public static void m24020e(String str) {
        m24021e(str, null);
    }

    private static void m24021e(String str, String str2) {
        RedditJobManager.a().a(new SaveMediaJob(str, str2));
    }

    public static void m23974a(Screen screen, String str) {
        m23975a(screen, str, null);
    }

    public static void m23975a(Screen screen, String str, String str2) {
        if (PermissionUtil.m23865a(screen) != null) {
            m24021e(str, str2);
        }
    }

    public static long m24024f(String str) {
        return Long.parseLong(ThingUtil.b(str), 36);
    }

    public static void m24009c(String str, String str2) {
        Crashlytics.log(String.format("%s: %s", new Object[]{str, str2}));
    }

    public static Activity m24014d(Context context) {
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public static FragmentActivity m24019e(Context context) {
        return (FragmentActivity) m24014d(context);
    }

    public static BaseActivity m24025f(Context context) {
        return (BaseActivity) m24014d(context);
    }

    public static long m24013d() {
        return f21813e.getAndDecrement();
    }

    public static String m24030g(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = f21814f.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            stringBuilder.append(str, i, matcher.start());
            char charAt = group.charAt(0);
            if (charAt == '\n') {
                stringBuilder.append(' ');
            } else if (charAt == '&') {
                String str2;
                i = -1;
                switch (group.hashCode()) {
                    case 1234696:
                        if (group.equals("&gt;")) {
                            i = 8;
                            break;
                        }
                        break;
                    case 1239501:
                        if (group.equals("&lt;")) {
                            i = 10;
                            break;
                        }
                        break;
                    case 36187165:
                        if (group.equals("&#34;")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 36187289:
                        if (group.equals("&#38;")) {
                            i = 1;
                            break;
                        }
                        break;
                    case 36187320:
                        if (group.equals("&#39;")) {
                            i = 5;
                            break;
                        }
                        break;
                    case 36189924:
                        if (group.equals("&#60;")) {
                            i = 11;
                            break;
                        }
                        break;
                    case 36189986:
                        if (group.equals("&#62;")) {
                            i = 9;
                            break;
                        }
                        break;
                    case 38091805:
                        if (group.equals("&amp;")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 1121744173:
                        if (group.equals("&#160;")) {
                            i = 7;
                            break;
                        }
                        break;
                    case 1180936162:
                        if (group.equals("&apos;")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 1192528612:
                        if (group.equals("&nbsp;")) {
                            i = 6;
                            break;
                        }
                        break;
                    case 1195861484:
                        if (group.equals("&quot;")) {
                            i = 2;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (i) {
                    case 0:
                    case 1:
                        str2 = "&";
                        break;
                    case 2:
                    case 3:
                        str2 = "\"";
                        break;
                    case 4:
                    case 5:
                        str2 = "'";
                        break;
                    case 6:
                    case 7:
                        str2 = " ";
                        break;
                    case 8:
                    case 9:
                        str2 = Operation.GREATER_THAN;
                        break;
                    case 10:
                    case 11:
                        str2 = Operation.LESS_THAN;
                        break;
                    default:
                        str2 = "";
                        break;
                }
                stringBuilder.append(str2);
            }
            i = matcher.end();
        }
        stringBuilder.append(str, i, str.length());
        m23990a(stringBuilder);
        return stringBuilder.toString();
    }

    private static void m23990a(StringBuilder stringBuilder) {
        if (stringBuilder.length() != 0) {
            int length = stringBuilder.length() - 1;
            int i = length;
            while (length >= 0 && Character.isWhitespace(stringBuilder.charAt(length))) {
                i = length;
                length--;
            }
            stringBuilder.setLength(i);
        }
    }

    public static String m24033h(String str) {
        if (str.length() == 0) {
            return str;
        }
        int length = str.length() - 1;
        int i = length;
        while (length >= 0 && Character.isWhitespace(str.charAt(length))) {
            i = length;
            length--;
        }
        return str.substring(0, i + 1);
    }

    @Deprecated
    public static String m24027f(int i) {
        try {
            return FrontpageApplication.f27402a.getString(i);
        } catch (int i2) {
            Timber.c(i2, "Resources.NotFoundException while using Util.getString()", new Object[0]);
            return "";
        }
    }

    @Deprecated
    public static String m23960a(int i, Object... objArr) {
        return FrontpageApplication.f27402a.getString(i, objArr);
    }

    public static String m23959a(int i, int i2, Object... objArr) {
        return FrontpageApplication.f27402a.getResources().getQuantityString(i, i2, objArr);
    }

    public static int m24029g(int i) {
        return FrontpageApplication.f27402a.getResources().getDimensionPixelSize(i);
    }

    public static float m24018e() {
        return (float) FrontpageApplication.f27402a.getResources().getDimensionPixelSize(C1761R.dimen.body_text_size);
    }

    @Deprecated
    public static Drawable m24032h(int i) {
        Resources resources = FrontpageApplication.f27402a.getResources();
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, null);
        }
        return resources.getDrawable(i);
    }

    @Deprecated
    public static Drawable m23957a(int i, Mode mode) {
        Drawable mutate = m24032h((int) C1761R.drawable.ic_icon_back).getConstantState().newDrawable(FrontpageApplication.f27402a.getResources()).mutate();
        mutate.setColorFilter(i, mode);
        return mutate;
    }

    public static String m24026f() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FrontpageApplication.f27402a.getResources().openRawResource(C1761R.raw.acknowledgements)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringBuilder.toString();
                }
                stringBuilder.append(readLine);
                stringBuilder.append('\n');
            }
        } catch (Exception e) {
            Timber.e(String.valueOf(e), new Object[0]);
            return null;
        }
    }

    public static void m23971a(SearchView searchView) {
        searchView.setIconified(false);
    }

    public static boolean m24017d(String str, String str2) {
        return m24003b(m24044m(str), m24044m(str2));
    }

    private static String m24044m(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().startsWith("/u/")) {
            return str.substring(3);
        }
        return str.toLowerCase().startsWith("u/") ? str.substring(2) : str;
    }

    public static Map<String, String> m23965a(Bundle bundle) {
        Map<String, String> hashMap = new HashMap();
        if (bundle == null) {
            return hashMap;
        }
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public static String m24037i(String str) {
        str = MimeTypeMap.getFileExtensionFromUrl(str);
        return str != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : null;
    }

    public static String m24039j(String str) {
        if (str.startsWith(Kind.COMMENT)) {
            return Kind.COMMENT;
        }
        if (str.startsWith(Kind.LINK)) {
            return Kind.LINK;
        }
        if (str.startsWith(Kind.MESSAGE)) {
            return Kind.MESSAGE;
        }
        if (str.startsWith(Kind.SUBREDDIT)) {
            return Kind.SUBREDDIT;
        }
        return str.startsWith(Kind.ACCOUNT) != null ? Kind.ACCOUNT : "";
    }

    public static String m23961a(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < 60000) {
            return m24027f((int) 2131887099);
        }
        StringBuilder stringBuilder;
        if (currentTimeMillis < 3600000) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((int) Math.floor((double) (currentTimeMillis / 60000)));
            stringBuilder.append(m24027f((int) 2131887098));
            return stringBuilder.toString();
        } else if (currentTimeMillis < 86400000) {
            j = new StringBuilder();
            j.append((int) Math.floor((double) (currentTimeMillis / 3600000)));
            j.append(m24027f((int) C1761R.string.rdt_displayable_hour));
            return j.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append((int) Math.floor((double) (currentTimeMillis / 86400000)));
            stringBuilder.append(m24027f((int) 2131887096));
            return stringBuilder.toString();
        }
    }

    public static void m23970a(android.support.v4.widget.SwipeRefreshLayout r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        android.support.v4.widget.SwipeRefreshLayoutHelper.a(r1);	 Catch:{ Throwable -> 0x0004 }
        return;
    L_0x0004:
        r0 = 4;
        r0 = new int[r0];
        r0 = {2131099878, 2131099817, 2131099864, 2131099833};
        r1.setColorSchemeResources(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.Util.a(android.support.v4.widget.SwipeRefreshLayout):void");
    }

    public static void m23989a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                Timber.c(closeable2, "Unable to close", new Object[0]);
            }
        }
    }

    public static boolean m24041k(String str) {
        return TextUtils.equals(str, m24027f((int) C1761R.string.deleted_author));
    }

    public static String m24042l(String str) {
        return m23960a((int) C1761R.string.fmt_u_name, str);
    }

    public static void m23972a(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void m23999b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static String m23962a(Location location) {
        if (location == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(location.getLatitude());
        stringBuilder.append(",");
        stringBuilder.append(location.getLongitude());
        return stringBuilder.toString();
    }

    @Deprecated
    public static void m23979a(ShapedIconView shapedIconView, com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, boolean z) {
        Object obj = (subreddit == null || !SubredditUtil.m23920a(subreddit.display_name)) ? null : 1;
        if (obj != null) {
            m24008c(shapedIconView, subreddit, z);
        } else {
            m24001b(shapedIconView, subreddit, z);
        }
    }

    @Deprecated
    public static void m24001b(ShapedIconView shapedIconView, com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, boolean z) {
        String str;
        String str2 = null;
        if (subreddit != null) {
            str = subreddit.key_color;
        } else {
            str = null;
        }
        if (subreddit != null) {
            str2 = subreddit.icon_img;
        }
        m23988a(shapedIconView, str2, str, (boolean) null, z);
    }

    @Deprecated
    private static void m24008c(ShapedIconView shapedIconView, com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit subreddit, boolean z) {
        String str;
        String str2 = null;
        if (subreddit != null) {
            str = subreddit.key_color;
        } else {
            str = null;
        }
        if (subreddit != null) {
            str2 = subreddit.icon_img;
        }
        m23988a(shapedIconView, str2, str, true, z);
    }
}
