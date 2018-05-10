package com.reddit.frontpage.commons.analytics.events.v2;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Platform;
import com.reddit.frontpage.util.Util;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public abstract class BasePayload {
    public static final String EVENT_PLATFORM_NAME = "android";
    public static final int EVENT_VERSION = 2;
    private static final Pattern SOURCE_VERB_NOUN_PATTERN = Pattern.compile("(\\w+)__(\\w+)_(\\w+)");
    public final String amazon_ad_id = Config.l;
    public final String app_name = "android";
    public final String app_version = Util.m23960a((int) C1761R.string.fmt_build_version, "3.1.2", Integer.valueOf(209200));
    public boolean compact_view;
    public final String device_id = Config.g;
    public final String domain = "Android";
    public final int event_version = 2;
    public final String foreground_notification_id = Config.o;
    public final String google_ad_id = Config.k;
    public final Long install_ts = Config.n;
    public final boolean is_xpromo = (TextUtils.isEmpty(Config.i) ^ true);
    public final String language = Locale.getDefault().getLanguage();
    public final String language_name = Locale.getDefault().getDisplayLanguage();
    public String loid;
    public long loid_created;
    public String loid_type;
    public final String mweb_loid = Config.i;
    public boolean nightmode;
    public String noun;
    public final String os_version = String.valueOf(VERSION.SDK_INT);
    public final String platform_browser_name = Platform.f29397a.getBrowserName();
    public final String platform_device_id = Platform.f29397a.getDeviceId();
    public final String platform_device_name = Platform.f29397a.getDeviceName();
    public final String platform_name = Platform.f29397a.getPlatformName();
    public final String platform_os_name = Platform.f29397a.getOsName();
    public final String platform_os_version = Platform.f29397a.getOsVersion();
    public String screen_name;
    public final String session_id = Config.b();
    public String source;
    public long sr_id;
    public String sr_name;
    public String target_fullname;
    public String target_type;
    public final String user_agent = Config.b;
    public String user_id36;
    public String user_name;
    public final long utc_offset = TimeUnit.HOURS.convert((long) TimeZone.getDefault().getOffset(System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    public String verb;

    BasePayload(String str) {
        String[] a = Config.a();
        if (a != null && a.length == 4) {
            this.loid = a[0];
            this.loid_created = Long.parseLong(a[2]);
            this.loid_type = "token_loid";
        } else if (TextUtils.isEmpty(Config.i)) {
            this.loid = Config.g;
            this.loid_created = Config.n.longValue();
            this.loid_type = "device_id";
        } else {
            this.loid = Config.i;
            this.loid_created = Config.m;
            this.loid_type = "mweb_loid";
        }
        str = SOURCE_VERB_NOUN_PATTERN.matcher(str);
        if (str.find()) {
            this.source = str.group(1);
            this.verb = str.group(2);
            this.noun = str.group(3);
        }
    }
}
