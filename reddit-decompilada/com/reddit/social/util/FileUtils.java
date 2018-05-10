package com.reddit.social.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static void m24772a(File file, String str) throws IOException {
        File file2;
        File createTempFile = File.createTempFile("saved_file", "temp");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            if (createTempFile.renameTo(file) == null) {
                StringBuilder stringBuilder = new StringBuilder("Error renaming temp file to \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\"");
                throw new IOException(stringBuilder.toString());
            }
            fileOutputStream.close();
        } catch (String str2) {
            file2.addSuppressed(str2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m24770a(java.io.File r7) throws java.io.IOException {
        /*
        r0 = new java.io.FileInputStream;
        r0.<init>(r7);
        r7 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x002e }
        r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x002e }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x002e }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x002e }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002e }
        r2.<init>();	 Catch:{ Throwable -> 0x002e }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r4 = new char[r3];	 Catch:{ Throwable -> 0x002e }
    L_0x0019:
        r5 = 0;
        r6 = r1.read(r4, r5, r3);	 Catch:{ Throwable -> 0x002e }
        if (r6 <= 0) goto L_0x0024;
    L_0x0020:
        r2.append(r4, r5, r6);	 Catch:{ Throwable -> 0x002e }
        goto L_0x0019;
    L_0x0024:
        r1 = r2.toString();	 Catch:{ Throwable -> 0x002e }
        r0.close();
        return r1;
    L_0x002c:
        r1 = move-exception;
        goto L_0x0030;
    L_0x002e:
        r7 = move-exception;
        throw r7;	 Catch:{ all -> 0x002c }
    L_0x0030:
        if (r7 == 0) goto L_0x003b;
    L_0x0032:
        r0.close();	 Catch:{ Throwable -> 0x0036 }
        goto L_0x003e;
    L_0x0036:
        r0 = move-exception;
        r7.addSuppressed(r0);
        goto L_0x003e;
    L_0x003b:
        r0.close();
    L_0x003e:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.util.FileUtils.a(java.io.File):java.lang.String");
    }

    public static String m24771a(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes());
        str = instance.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : str) {
            stringBuffer.append(Integer.toHexString(255 & b));
        }
        return stringBuffer.toString();
    }
}
