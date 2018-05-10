package org.slf4j.helpers;

import java.io.PrintStream;

public final class Util {
    private static boolean f27229a = false;

    public static java.lang.String m28711a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 != 0) goto L_0x000a;
    L_0x0002:
        r1 = new java.lang.IllegalArgumentException;
        r0 = "null input";
        r1.<init>(r0);
        throw r1;
    L_0x000a:
        r0 = 0;
        r1 = java.lang.System.getProperty(r1);	 Catch:{ SecurityException -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = r0;
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.helpers.Util.a(java.lang.String):java.lang.String");
    }

    public static boolean m28713b(String str) {
        str = m28711a(str);
        if (str == null) {
            return null;
        }
        return str.equalsIgnoreCase("true");
    }

    public static final void m28712a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void m28714c(String str) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder("SLF4J: ");
        stringBuilder.append(str);
        printStream.println(stringBuilder.toString());
    }
}
