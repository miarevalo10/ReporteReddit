package com.instabug.library.util;

import java.util.List;

public class StringUtility {
    public static String trimString(String str) {
        return trimString(str, 4096);
    }

    public static String trimString(String str, int i) {
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static String[] trimStrings(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = trimString(strArr[i]);
        }
        return strArr;
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+(?:\\.\\d+)?");
    }

    public static int compareVersion(String str, String str2) throws NumberFormatException {
        str = str.split("\\.");
        str2 = str2.split("\\.");
        int i = 0;
        while (true) {
            if (i >= str.length) {
                if (i >= str2.length) {
                    return 0;
                }
            }
            if (i >= str.length || i >= str2.length) {
                if (i < str.length) {
                    if (Integer.parseInt(str[i]) != 0) {
                        return 1;
                    }
                } else if (i < str2.length && Integer.parseInt(str2[i]) != 0) {
                    return -1;
                }
            } else if (Integer.parseInt(str[i]) < Integer.parseInt(str2[i])) {
                return -1;
            } else {
                if (Integer.parseInt(str[i]) > Integer.parseInt(str2[i])) {
                    return 1;
                }
            }
            i++;
        }
    }

    public static String removeExtension(String str) {
        return str.replaceFirst("[.][^.]+$", "");
    }

    public static String toCommaSeparated(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuilder.append((String) list.get(i));
            stringBuilder.append(",");
        }
        stringBuilder.append((String) list.get(list.size() - 1));
        return stringBuilder.toString();
    }
}
