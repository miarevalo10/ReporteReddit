package com.reddit.frontpage.util;

import android.net.Uri;

public class ImgurUtil {
    public static boolean m23728a(String str) {
        return m23727a(Uri.parse(str));
    }

    public static boolean m23727a(Uri uri) {
        uri = uri.getHost();
        return (uri == null || uri.endsWith("imgur.com") == null) ? null : true;
    }

    public static String m23729b(String str) {
        if (!Util.m24002b(str) && !Util.m24011c(str)) {
            return null;
        }
        str = str.substring(0, str.lastIndexOf(46) + 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("mp4");
        return stringBuilder.toString();
    }
}
