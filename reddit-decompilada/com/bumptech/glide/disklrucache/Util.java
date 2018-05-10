package com.bumptech.glide.disklrucache;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

final class Util {
    static final Charset f3279a = Charset.forName("US-ASCII");
    static final Charset f3280b = Charset.forName("UTF-8");

    static String m2814a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            reader.close();
        }
    }

    static void m2816a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            StringBuilder stringBuilder = new StringBuilder("not a readable directory: ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
        file = listFiles.length;
        int i = 0;
        while (i < file) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m2816a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("failed to delete file: ");
                stringBuilder2.append(file2);
                throw new IOException(stringBuilder2.toString());
            }
        }
    }

    static void m2815a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0.close();	 Catch:{ RuntimeException -> 0x0005, Exception -> 0x0004 }
        return;
    L_0x0004:
        return;
    L_0x0005:
        r0 = move-exception;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.Util.a(java.io.Closeable):void");
    }
}
