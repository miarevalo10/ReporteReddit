package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public final class zzu {
    private static final Pattern f5971a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean m4921a(String str) {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
