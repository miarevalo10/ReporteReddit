package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor {

    private static class ExtractedDex extends File {
        public long f799a = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    static java.util.List<? extends java.io.File> m405a(android.content.Context r19, java.io.File r20, java.io.File r21, java.lang.String r22) throws java.io.IOException {
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
        r2 = r22;
        r1 = "MultiDex";
        r3 = new java.lang.StringBuilder;
        r4 = "MultiDexExtractor.load(";
        r3.<init>(r4);
        r4 = r20.getPath();
        r3.append(r4);
        r4 = ", false, ";
        r3.append(r4);
        r3.append(r2);
        r4 = ")";
        r3.append(r4);
        r3 = r3.toString();
        android.util.Log.i(r1, r3);
        r5 = m411b(r20);
        r8 = new java.io.File;
        r1 = "MultiDex.lock";
        r3 = r21;
        r8.<init>(r3, r1);
        r9 = new java.io.RandomAccessFile;
        r1 = "rw";
        r9.<init>(r8, r1);
        r10 = 0;
        r11 = r9.getChannel();	 Catch:{ all -> 0x0136 }
        r1 = "MultiDex";	 Catch:{ all -> 0x0132 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0132 }
        r7 = "Blocking on lock ";	 Catch:{ all -> 0x0132 }
        r4.<init>(r7);	 Catch:{ all -> 0x0132 }
        r7 = r8.getPath();	 Catch:{ all -> 0x0132 }
        r4.append(r7);	 Catch:{ all -> 0x0132 }
        r4 = r4.toString();	 Catch:{ all -> 0x0132 }
        android.util.Log.i(r1, r4);	 Catch:{ all -> 0x0132 }
        r12 = r11.lock();	 Catch:{ all -> 0x0132 }
        r1 = "MultiDex";	 Catch:{ all -> 0x012f }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
        r4.<init>();	 Catch:{ all -> 0x012f }
        r7 = r8.getPath();	 Catch:{ all -> 0x012f }
        r4.append(r7);	 Catch:{ all -> 0x012f }
        r7 = " locked";	 Catch:{ all -> 0x012f }
        r4.append(r7);	 Catch:{ all -> 0x012f }
        r4 = r4.toString();	 Catch:{ all -> 0x012f }
        android.util.Log.i(r1, r4);	 Catch:{ all -> 0x012f }
        r1 = m404a(r19);	 Catch:{ all -> 0x012f }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
        r4.<init>();	 Catch:{ all -> 0x012f }
        r4.append(r2);	 Catch:{ all -> 0x012f }
        r7 = "timestamp";	 Catch:{ all -> 0x012f }
        r4.append(r7);	 Catch:{ all -> 0x012f }
        r4 = r4.toString();	 Catch:{ all -> 0x012f }
        r13 = -1;	 Catch:{ all -> 0x012f }
        r15 = r1.getLong(r4, r13);	 Catch:{ all -> 0x012f }
        r17 = m403a(r20);	 Catch:{ all -> 0x012f }
        r4 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1));	 Catch:{ all -> 0x012f }
        if (r4 != 0) goto L_0x00b3;	 Catch:{ all -> 0x012f }
    L_0x0097:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012f }
        r4.<init>();	 Catch:{ all -> 0x012f }
        r4.append(r2);	 Catch:{ all -> 0x012f }
        r7 = "crc";	 Catch:{ all -> 0x012f }
        r4.append(r7);	 Catch:{ all -> 0x012f }
        r4 = r4.toString();	 Catch:{ all -> 0x012f }
        r13 = r1.getLong(r4, r13);	 Catch:{ all -> 0x012f }
        r1 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00b3;
    L_0x00b1:
        r1 = 0;
        goto L_0x00b4;
    L_0x00b3:
        r1 = 1;
    L_0x00b4:
        if (r1 != 0) goto L_0x00d3;
    L_0x00b6:
        r1 = m412b(r19, r20, r21, r22);	 Catch:{ IOException -> 0x00bc }
        r13 = r1;
        goto L_0x00e8;
    L_0x00bc:
        r0 = move-exception;
        r1 = "MultiDex";	 Catch:{ all -> 0x012f }
        r4 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction";	 Catch:{ all -> 0x012f }
        android.util.Log.w(r1, r4, r0);	 Catch:{ all -> 0x012f }
        r13 = m406a(r20, r21);	 Catch:{ all -> 0x012f }
        r3 = m403a(r20);	 Catch:{ all -> 0x012f }
        r1 = r19;	 Catch:{ all -> 0x012f }
        r7 = r13;	 Catch:{ all -> 0x012f }
        m407a(r1, r2, r3, r5, r7);	 Catch:{ all -> 0x012f }
        goto L_0x00e8;	 Catch:{ all -> 0x012f }
    L_0x00d3:
        r1 = "MultiDex";	 Catch:{ all -> 0x012f }
        r4 = "Detected that extraction must be performed.";	 Catch:{ all -> 0x012f }
        android.util.Log.i(r1, r4);	 Catch:{ all -> 0x012f }
        r13 = m406a(r20, r21);	 Catch:{ all -> 0x012f }
        r3 = m403a(r20);	 Catch:{ all -> 0x012f }
        r1 = r19;	 Catch:{ all -> 0x012f }
        r7 = r13;	 Catch:{ all -> 0x012f }
        m407a(r1, r2, r3, r5, r7);	 Catch:{ all -> 0x012f }
    L_0x00e8:
        if (r12 == 0) goto L_0x0107;
    L_0x00ea:
        r12.release();	 Catch:{ IOException -> 0x00ee }
        goto L_0x0107;
    L_0x00ee:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = new java.lang.StringBuilder;
        r3 = "Failed to release lock on ";
        r2.<init>(r3);
        r3 = r8.getPath();
        r2.append(r3);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
        r10 = r0;
    L_0x0107:
        if (r11 == 0) goto L_0x010c;
    L_0x0109:
        m408a(r11);
    L_0x010c:
        m408a(r9);
        if (r10 == 0) goto L_0x0112;
    L_0x0111:
        throw r10;
    L_0x0112:
        r1 = "MultiDex";
        r2 = new java.lang.StringBuilder;
        r3 = "load found ";
        r2.<init>(r3);
        r3 = r13.size();
        r2.append(r3);
        r3 = " secondary dex files";
        r2.append(r3);
        r2 = r2.toString();
        android.util.Log.i(r1, r2);
        return r13;
    L_0x012f:
        r0 = move-exception;
        r1 = r0;
        goto L_0x013a;
    L_0x0132:
        r0 = move-exception;
        r1 = r0;
        r12 = r10;
        goto L_0x013a;
    L_0x0136:
        r0 = move-exception;
        r1 = r0;
        r11 = r10;
        r12 = r11;
    L_0x013a:
        if (r12 == 0) goto L_0x0157;
    L_0x013c:
        r12.release();	 Catch:{ IOException -> 0x0140 }
        goto L_0x0157;
    L_0x0140:
        r2 = "MultiDex";
        r3 = new java.lang.StringBuilder;
        r4 = "Failed to release lock on ";
        r3.<init>(r4);
        r4 = r8.getPath();
        r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0157:
        if (r11 == 0) goto L_0x015c;
    L_0x0159:
        m408a(r11);
    L_0x015c:
        m408a(r9);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.a(android.content.Context, java.io.File, java.io.File, java.lang.String):java.util.List<? extends java.io.File>");
    }

    private static List<ExtractedDex> m412b(Context context, File file, File file2, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append(".classes");
        String stringBuilder2 = stringBuilder.toString();
        SharedPreferences a = m404a(context);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str2);
        stringBuilder3.append("dex.number");
        int i = a.getInt(stringBuilder3.toString(), 1);
        List<ExtractedDex> arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(i2);
            stringBuilder4.append(".zip");
            File extractedDex = new ExtractedDex(file2, stringBuilder4.toString());
            if (extractedDex.isFile()) {
                extractedDex.f799a = m411b(extractedDex);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append("dex.crc.");
                stringBuilder4.append(i2);
                long j = a.getLong(stringBuilder4.toString(), -1);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append("dex.time.");
                stringBuilder4.append(i2);
                long j2 = a.getLong(stringBuilder4.toString(), -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str3 = stringBuilder2;
                    SharedPreferences sharedPreferences = a;
                    if (j == extractedDex.f799a) {
                        arrayList.add(extractedDex);
                        i2++;
                        stringBuilder2 = str3;
                        a = sharedPreferences;
                    }
                }
                StringBuilder stringBuilder5 = new StringBuilder("Invalid extracted dex: ");
                stringBuilder5.append(extractedDex);
                stringBuilder5.append(" (key \"");
                stringBuilder5.append(str2);
                stringBuilder5.append("\"), expected modification time: ");
                stringBuilder5.append(j2);
                stringBuilder5.append(", modification time: ");
                stringBuilder5.append(lastModified);
                stringBuilder5.append(", expected crc: ");
                stringBuilder5.append(j);
                stringBuilder5.append(", file crc: ");
                stringBuilder5.append(extractedDex.f799a);
                throw new IOException(stringBuilder5.toString());
            }
            stringBuilder = new StringBuilder("Missing extracted secondary dex file '");
            stringBuilder.append(extractedDex.getPath());
            stringBuilder.append("'");
            throw new IOException(stringBuilder.toString());
        }
        return arrayList;
    }

    private static long m403a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long m411b(File file) throws IOException {
        long a = ZipUtil.m413a(file);
        return a == -1 ? a - 1 : a;
    }

    private static List<ExtractedDex> m406a(File file, File file2) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append(".classes");
        String stringBuilder2 = stringBuilder.toString();
        m409a(file2, stringBuilder2);
        List<ExtractedDex> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        file = 2;
        File extractedDex;
        int i;
        StringBuilder stringBuilder3;
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stringBuilder2);
                stringBuilder4.append(file);
                stringBuilder4.append(".zip");
                extractedDex = new ExtractedDex(file2, stringBuilder4.toString());
                arrayList.add(extractedDex);
                StringBuilder stringBuilder5 = new StringBuilder("Extraction is needed for file ");
                stringBuilder5.append(extractedDex);
                Log.i("MultiDex", stringBuilder5.toString());
                int i2 = 0;
                i = i2;
                while (i2 < 3 && i == 0) {
                    i2++;
                    m410a(zipFile, entry, extractedDex, stringBuilder2);
                    extractedDex.f799a = m411b(extractedDex);
                    i = 1;
                    String str = "MultiDex";
                    stringBuilder3 = new StringBuilder("Extraction ");
                    stringBuilder3.append(i != 0 ? "succeeded" : "failed");
                    stringBuilder3.append(" - length ");
                    stringBuilder3.append(extractedDex.getAbsolutePath());
                    stringBuilder3.append(": ");
                    stringBuilder3.append(extractedDex.length());
                    stringBuilder3.append(" - crc: ");
                    stringBuilder3.append(extractedDex.f799a);
                    Log.i(str, stringBuilder3.toString());
                    if (i == 0) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            stringBuilder3 = new StringBuilder("Failed to delete corrupted secondary dex '");
                            stringBuilder3.append(extractedDex.getPath());
                            stringBuilder3.append("'");
                            Log.w("MultiDex", stringBuilder3.toString());
                        }
                    }
                }
                if (i == 0) {
                    stringBuilder = new StringBuilder("Could not create zip file ");
                    stringBuilder.append(extractedDex.getAbsolutePath());
                    stringBuilder.append(" for secondary dex (");
                    stringBuilder.append(file);
                    stringBuilder.append(")");
                    throw new IOException(stringBuilder.toString());
                }
                file++;
                StringBuilder stringBuilder6 = new StringBuilder("classes");
                stringBuilder6.append(file);
                stringBuilder6.append(".dex");
                entry = zipFile.getEntry(stringBuilder6.toString());
            }
            try {
                zipFile.close();
            } catch (File file3) {
                Log.w("MultiDex", "Failed to close resource", file3);
            }
            return arrayList;
        } catch (Throwable e) {
            stringBuilder3 = new StringBuilder("Failed to read crc from ");
            stringBuilder3.append(extractedDex.getAbsolutePath());
            Log.w("MultiDex", stringBuilder3.toString(), e);
            i = 0;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (File file22) {
                Log.w("MultiDex", "Failed to close resource", file22);
            }
        }
    }

    private static void m407a(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        context = m404a(context).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("timestamp");
        context.putLong(stringBuilder.toString(), j);
        j = new StringBuilder();
        j.append(str);
        j.append("crc");
        context.putLong(j.toString(), j2);
        j = new StringBuilder();
        j.append(str);
        j.append("dex.number");
        context.putInt(j.toString(), list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("dex.crc.");
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), extractedDex.f799a);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("dex.time.");
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), extractedDex.lastModified());
            i++;
        }
        context.commit();
    }

    private static SharedPreferences m404a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void m409a(File file, final String str) {
        str = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                file = file.getName();
                return (file.startsWith(str) || file.equals("MultiDex.lock") != null) ? null : true;
            }
        });
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder("Failed to list secondary dex dir content (");
            stringBuilder.append(file.getPath());
            stringBuilder.append(").");
            Log.w("MultiDex", stringBuilder.toString());
            return;
        }
        for (File file2 : str) {
            StringBuilder stringBuilder2 = new StringBuilder("Trying to delete old file ");
            stringBuilder2.append(file2.getPath());
            stringBuilder2.append(" of size ");
            stringBuilder2.append(file2.length());
            Log.i("MultiDex", stringBuilder2.toString());
            if (file2.delete()) {
                stringBuilder2 = new StringBuilder("Deleted old file ");
                stringBuilder2.append(file2.getPath());
                Log.i("MultiDex", stringBuilder2.toString());
            } else {
                stringBuilder2 = new StringBuilder("Failed to delete old file ");
                stringBuilder2.append(file2.getPath());
                Log.w("MultiDex", stringBuilder2.toString());
            }
        }
    }

    private static void m410a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder stringBuilder = new StringBuilder("tmp-");
        stringBuilder.append(str);
        str = File.createTempFile(stringBuilder.toString(), ".zip", file.getParentFile());
        StringBuilder stringBuilder2 = new StringBuilder("Extracting ");
        stringBuilder2.append(str.getPath());
        Log.i("MultiDex", stringBuilder2.toString());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            zipEntry = new byte[16384];
            for (int read = inputStream.read(zipEntry); read != -1; read = inputStream.read(zipEntry)) {
                zipOutputStream.write(zipEntry, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (str.setReadOnly() == null) {
                stringBuilder = new StringBuilder("Failed to mark readonly \"");
                stringBuilder.append(str.getAbsolutePath());
                stringBuilder.append("\" (tmp of \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\")");
                throw new IOException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder("Renaming to ");
            stringBuilder.append(file.getPath());
            Log.i("MultiDex", stringBuilder.toString());
            if (str.renameTo(file) == null) {
                stringBuilder = new StringBuilder("Failed to rename \"");
                stringBuilder.append(str.getAbsolutePath());
                stringBuilder.append("\" to \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\"");
                throw new IOException(stringBuilder.toString());
            }
            m408a(inputStream);
            str.delete();
        } catch (Throwable th) {
            m408a(inputStream);
            str.delete();
        }
    }

    private static void m408a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Closeable closeable2) {
            Log.w("MultiDex", "Failed to close resource", closeable2);
        }
    }
}
