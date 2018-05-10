package com.android.volley;

import java.security.MessageDigest;

class InternalUtils {
    private static final char[] f2771a = "0123456789ABCDEF".toCharArray();

    public static String m2439a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            str = str.getBytes("UTF-8");
            int i = 0;
            instance.update(str, 0, str.length);
            str = instance.digest();
            char[] cArr = new char[(str.length * 2)];
            while (i < str.length) {
                int i2 = str[i] & 255;
                int i3 = i * 2;
                cArr[i3] = f2771a[i2 >>> 4];
                cArr[i3 + 1] = f2771a[i2 & 15];
                i++;
            }
            return new String(cArr);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        } catch (String str22) {
            str22.printStackTrace();
            return null;
        }
    }
}
