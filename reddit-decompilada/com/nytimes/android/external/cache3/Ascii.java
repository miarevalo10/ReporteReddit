package com.nytimes.android.external.cache3;

public final class Ascii {
    private static boolean m8533a(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static String m8532a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (m8533a(str.charAt(i))) {
                str = str.toCharArray();
                while (i < length) {
                    char c = str[i];
                    if (m8533a(c)) {
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
