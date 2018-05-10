package com.google.gson;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    ;

    static String m14906a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
                stringBuilder.append(str2);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    static String m14905a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(charAt)) {
            stringBuilder.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        if (i == str.length()) {
            return stringBuilder.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        charAt = Character.toUpperCase(charAt);
        i++;
        if (i < str.length()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(charAt);
            stringBuilder2.append(str.substring(i));
            str = stringBuilder2.toString();
        } else {
            str = String.valueOf(charAt);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
