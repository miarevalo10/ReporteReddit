package com.reddit.datalibrary.frontpage.redditauth;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class Config {
    public static final Uri f10813a = Uri.parse("https://www.reddit.com");
    public static final String f10814b = Util.a(C1761R.string.fmt_user_agent, new Object[]{"3.1.2", Integer.valueOf(209200), VERSION.RELEASE});
    public static String f10815c;
    public static String f10816d;
    public static String f10817e;
    public static volatile String f10818f;
    public static String f10819g;
    public static volatile String f10820h;
    public static String f10821i;
    public static String f10822j;
    public static String f10823k;
    public static String f10824l;
    public static long f10825m;
    public static Long f10826n;
    public static String f10827o;
    private static String[] f10828p;
    private static String f10829q;
    private static long f10830r;

    public static void m9152a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f10820h = str;
            InternalSettings.m9061a().f10763a.edit().putString("com.reddit.frontpage.install_settings.lo_id", str).apply();
            f10828p = null;
        }
    }

    public static String[] m9153a() {
        if (f10828p == null && !TextUtils.isEmpty(f10820h)) {
            f10828p = TextUtils.split(f10820h, "\\.");
        }
        return f10828p;
    }

    public static void m9155b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f10818f = str;
            String[] split = TextUtils.split(str, "\\.");
            if (split.length == 4) {
                f10829q = split[null];
                f10830r = Long.parseLong(split[2]);
                return;
            }
            f10829q = str;
            f10830r = 0;
        }
    }

    public static String m9154b() {
        return f10829q;
    }

    public static long m9156c() {
        return f10830r;
    }

    public static void m9158d() {
        f10827o = null;
    }

    public static void m9157c(String str) {
        f10827o = str;
    }

    public static void m9159d(String str) {
        if (!TextUtils.isEmpty(str)) {
            f10822j = str;
            InternalSettings.m9061a().f10763a.edit().putString("com.reddit.frontpage.install_settings.reddit_ad_id", str).apply();
        }
    }

    public static String m9160e() {
        return f10822j != null ? f10822j : "";
    }

    public static void m9161e(String str) {
        f10823k = str;
    }

    public static void m9163f(String str) {
        f10824l = str;
    }

    public static String m9162f() {
        if (TextUtils.isEmpty(f10823k)) {
            return !TextUtils.isEmpty(f10824l) ? f10824l : "";
        } else {
            return f10823k;
        }
    }
}
