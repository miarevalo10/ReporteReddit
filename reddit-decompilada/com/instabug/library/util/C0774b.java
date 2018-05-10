package com.instabug.library.util;

import java.security.MessageDigest;

/* compiled from: MD5Generator */
public class C0774b {
    public static String m8363a(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    str = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                    StringBuilder stringBuilder = new StringBuilder();
                    for (byte b : str) {
                        int i = b & 255;
                        if (i < 16) {
                            stringBuilder.append("0");
                            stringBuilder.append(Integer.toHexString(i));
                        } else {
                            stringBuilder.append(Integer.toHexString(i));
                        }
                    }
                    return stringBuilder.toString();
                } catch (String str2) {
                    str2.printStackTrace();
                    return null;
                }
            }
        }
        return "";
    }
}
