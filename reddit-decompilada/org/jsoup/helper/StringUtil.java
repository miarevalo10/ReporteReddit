package org.jsoup.helper;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

public final class StringUtil {
    private static final String[] f26962a = new String[]{"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    public static boolean m28449b(int i) {
        if (!(i == 32 || i == 9 || i == 10 || i == 12)) {
            if (i != 13) {
                return false;
            }
        }
        return true;
    }

    public static String m28444a(Collection collection, String str) {
        collection = collection.iterator();
        if (!collection.hasNext()) {
            return "";
        }
        String obj = collection.next().toString();
        if (!collection.hasNext()) {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(obj);
        while (collection.hasNext()) {
            stringBuilder.append(str);
            stringBuilder.append(collection.next());
        }
        return stringBuilder.toString();
    }

    public static String m28442a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("width must be > 0");
        } else if (i < f26962a.length) {
            return f26962a[i];
        } else {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = ' ';
            }
            return String.valueOf(cArr);
        }
    }

    public static boolean m28447a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    if (!m28449b(str.codePointAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static boolean m28450b(String str) {
        if (str != null) {
            if (str.length() != 0) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    if (!Character.isDigit(str.codePointAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void m28446a(StringBuilder stringBuilder, String str, boolean z) {
        int length = str.length();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!m28449b(codePointAt)) {
                stringBuilder.appendCodePoint(codePointAt);
                i3 = 0;
                i2 = 1;
            } else if (!(z && r3 == 0) && r4 == 0) {
                stringBuilder.append(' ');
                i3 = 1;
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static boolean m28448a(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m28451b(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= null ? true : null;
    }

    public static URL m28445a(URL url, String str) throws MalformedURLException {
        if (str.startsWith(Operation.EMPTY_PARAM)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(url.getPath());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            StringBuilder stringBuilder2 = new StringBuilder(Operation.DIVISION);
            stringBuilder2.append(url.getFile());
            url = new URL(protocol, host, port, stringBuilder2.toString());
        }
        return new URL(url, str);
    }

    public static java.lang.String m28443a(java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x000e }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x000e }
        r1 = m28445a(r0, r2);	 Catch:{ MalformedURLException -> 0x0018 }
        r1 = r1.toExternalForm();	 Catch:{ MalformedURLException -> 0x0018 }
        return r1;	 Catch:{ MalformedURLException -> 0x0018 }
    L_0x000e:
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0018 }
        r1.<init>(r2);	 Catch:{ MalformedURLException -> 0x0018 }
        r1 = r1.toExternalForm();	 Catch:{ MalformedURLException -> 0x0018 }
        return r1;
    L_0x0018:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.StringUtil.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
