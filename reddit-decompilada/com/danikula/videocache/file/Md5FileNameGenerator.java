package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.ProxyCacheUtils;

public class Md5FileNameGenerator implements FileNameGenerator {
    public final String mo1104a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        Object substring = (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
        str = ProxyCacheUtils.m3348d(str);
        if (TextUtils.isEmpty(substring)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(substring);
        return stringBuilder.toString();
    }
}
