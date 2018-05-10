package com.sendbird.android.shadow.okhttp3.internal.io;

import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSystem {
    public static final FileSystem f23538a = new C24851();

    class C24851 implements FileSystem {
        C24851() {
        }

        public final Source mo5357a(File file) throws FileNotFoundException {
            return Okio.m25620a(file);
        }

        public final com.sendbird.android.shadow.okio.Sink mo5359b(java.io.File r2) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = com.sendbird.android.shadow.okio.Okio.m25624b(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = com.sendbird.android.shadow.okio.Okio.m25624b(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.io.FileSystem.1.b(java.io.File):com.sendbird.android.shadow.okio.Sink");
        }

        public final com.sendbird.android.shadow.okio.Sink mo5360c(java.io.File r2) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = com.sendbird.android.shadow.okio.Okio.m25627c(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = com.sendbird.android.shadow.okio.Okio.m25627c(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.io.FileSystem.1.c(java.io.File):com.sendbird.android.shadow.okio.Sink");
        }

        public final void mo5361d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder stringBuilder = new StringBuilder("failed to delete ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }

        public final boolean mo5362e(File file) {
            return file.exists();
        }

        public final long mo5363f(File file) {
            return file.length();
        }

        public final void mo5358a(File file, File file2) throws IOException {
            mo5361d(file2);
            if (!file.renameTo(file2)) {
                StringBuilder stringBuilder = new StringBuilder("failed to rename ");
                stringBuilder.append(file);
                stringBuilder.append(" to ");
                stringBuilder.append(file2);
                throw new IOException(stringBuilder.toString());
            }
        }

        public final void mo5364g(File file) throws IOException {
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
                    mo5364g(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("failed to delete ");
                    stringBuilder2.append(file2);
                    throw new IOException(stringBuilder2.toString());
                }
            }
        }
    }

    Source mo5357a(File file) throws FileNotFoundException;

    void mo5358a(File file, File file2) throws IOException;

    Sink mo5359b(File file) throws FileNotFoundException;

    Sink mo5360c(File file) throws FileNotFoundException;

    void mo5361d(File file) throws IOException;

    boolean mo5362e(File file);

    long mo5363f(File file);

    void mo5364g(File file) throws IOException;
}
