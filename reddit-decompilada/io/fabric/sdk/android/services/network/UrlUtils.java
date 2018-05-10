package io.fabric.sdk.android.services.network;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

public final class UrlUtils {
    public static TreeMap<String, String> m26423a(URI uri, boolean z) {
        return m26422a(uri.getRawQuery(), z);
    }

    public static TreeMap<String, String> m26422a(String str, boolean z) {
        TreeMap<String, String> treeMap = new TreeMap();
        if (str == null) {
            return treeMap;
        }
        for (String split : str.split("&")) {
            String[] split2 = split.split(Operation.EQUALS);
            if (split2.length == 2) {
                if (z) {
                    treeMap.put(m26425c(split2[0]), m26425c(split2[1]));
                } else {
                    treeMap.put(split2[0], split2[1]);
                }
            } else if (!TextUtils.isEmpty(split2[0])) {
                if (z) {
                    treeMap.put(m26425c(split2[0]), "");
                } else {
                    treeMap.put(split2[0], "");
                }
            }
        }
        return treeMap;
    }

    public static String m26421a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF8");
        } catch (String str2) {
            throw new RuntimeException(str2.getMessage(), str2);
        }
    }

    private static String m26425c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (String str2) {
            throw new RuntimeException(str2.getMessage(), str2);
        }
    }

    public static String m26424b(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        str = m26421a(str);
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '*') {
                stringBuilder.append("%2A");
            } else if (charAt == '+') {
                stringBuilder.append("%20");
            } else {
                if (charAt == '%') {
                    int i2 = i + 2;
                    if (i2 < length && str.charAt(i + 1) == '7' && str.charAt(i2) == 'E') {
                        stringBuilder.append('~');
                        i = i2;
                    }
                }
                stringBuilder.append(charAt);
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
