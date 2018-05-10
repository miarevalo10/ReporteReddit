package com.google.common.base;

public final class Ascii {
    private static boolean m6872a(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static String m6871a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (m6872a(str.charAt(i))) {
                str = str.toCharArray();
                while (i < length) {
                    char c = str[i];
                    if (m6872a(c)) {
                        str[i] = (char) (c ^ 32);
                    }
                    i++;
                }
                return String.valueOf(str);
            }
            i++;
        }
        return str;
    }
}
