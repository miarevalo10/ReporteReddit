package com.jakewharton.disklrucache;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM = new C08232();
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new C08221(this);
    private final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    class C08221 implements Callable<Void> {
        final /* synthetic */ DiskLruCache f9997a;

        C08221(DiskLruCache diskLruCache) {
            this.f9997a = diskLruCache;
        }

        public /* synthetic */ Object call() throws Exception {
            return m8446a();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Void m8446a() throws java.lang.Exception {
            /*
            r4 = this;
            r0 = r4.f9997a;
            monitor-enter(r0);
            r1 = r4.f9997a;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalWriter;	 Catch:{ all -> 0x0028 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x000e:
            r1 = r4.f9997a;	 Catch:{ all -> 0x0028 }
            r1.trimToSize();	 Catch:{ all -> 0x0028 }
            r1 = r4.f9997a;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalRebuildRequired();	 Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026;
        L_0x001b:
            r1 = r4.f9997a;	 Catch:{ all -> 0x0028 }
            r1.rebuildJournal();	 Catch:{ all -> 0x0028 }
            r1 = r4.f9997a;	 Catch:{ all -> 0x0028 }
            r3 = 0;
            r1.redundantOpCount = r3;	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x0028:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.1.a():java.lang.Void");
        }
    }

    static class C08232 extends OutputStream {
        public final void write(int i) throws IOException {
        }

        C08232() {
        }
    }

    public final class Editor {
        public final Entry f9999a;
        public boolean f10000b;
        public boolean f10001c;
        public final /* synthetic */ DiskLruCache f10002d;
        private final boolean[] f10003e;

        private class FaultHidingOutputStream extends FilterOutputStream {
            final /* synthetic */ Editor f9998a;

            private FaultHidingOutputStream(Editor editor, OutputStream outputStream) {
                this.f9998a = editor;
                super(outputStream);
            }

            public void write(int r2) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.out;	 Catch:{ IOException -> 0x0006 }
                r0.write(r2);	 Catch:{ IOException -> 0x0006 }
                return;
            L_0x0006:
                r2 = r1.f9998a;
                r2.f10000b = true;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.FaultHidingOutputStream.write(int):void");
            }

            public void write(byte[] r2, int r3, int r4) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.out;	 Catch:{ IOException -> 0x0006 }
                r0.write(r2, r3, r4);	 Catch:{ IOException -> 0x0006 }
                return;
            L_0x0006:
                r2 = r1.f9998a;
                r2.f10000b = true;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.FaultHidingOutputStream.write(byte[], int, int):void");
            }

            public void close() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.out;	 Catch:{ IOException -> 0x0006 }
                r0.close();	 Catch:{ IOException -> 0x0006 }
                return;
            L_0x0006:
                r0 = r1.f9998a;
                r0.f10000b = true;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.FaultHidingOutputStream.close():void");
            }

            public void flush() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.out;	 Catch:{ IOException -> 0x0006 }
                r0.flush();	 Catch:{ IOException -> 0x0006 }
                return;
            L_0x0006:
                r0 = r1.f9998a;
                r0.f10000b = true;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.FaultHidingOutputStream.flush():void");
            }
        }

        private Editor(DiskLruCache diskLruCache, Entry entry) {
            this.f10002d = diskLruCache;
            this.f9999a = entry;
            this.f10003e = entry.f10007d != null ? null : new boolean[diskLruCache.valueCount];
        }

        public final java.io.OutputStream m8450a() throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f10002d;
            monitor-enter(r0);
            r1 = r4.f9999a;	 Catch:{ all -> 0x0046 }
            r1 = r1.f10008e;	 Catch:{ all -> 0x0046 }
            if (r1 == r4) goto L_0x0011;	 Catch:{ all -> 0x0046 }
        L_0x000b:
            r1 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0046 }
            r1.<init>();	 Catch:{ all -> 0x0046 }
            throw r1;	 Catch:{ all -> 0x0046 }
        L_0x0011:
            r1 = r4.f9999a;	 Catch:{ all -> 0x0046 }
            r1 = r1.f10007d;	 Catch:{ all -> 0x0046 }
            r2 = 0;	 Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x001f;	 Catch:{ all -> 0x0046 }
        L_0x001a:
            r1 = r4.f10003e;	 Catch:{ all -> 0x0046 }
            r3 = 1;	 Catch:{ all -> 0x0046 }
            r1[r2] = r3;	 Catch:{ all -> 0x0046 }
        L_0x001f:
            r1 = r4.f9999a;	 Catch:{ all -> 0x0046 }
            r1 = r1.m8464b(r2);	 Catch:{ all -> 0x0046 }
            r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x002b }
            r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x002b }
            goto L_0x0039;
        L_0x002b:
            r3 = r4.f10002d;	 Catch:{ all -> 0x0046 }
            r3 = r3.directory;	 Catch:{ all -> 0x0046 }
            r3.mkdirs();	 Catch:{ all -> 0x0046 }
            r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0040 }
            r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0040 }
        L_0x0039:
            r1 = new com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream;	 Catch:{ all -> 0x0046 }
            r1.<init>(r3);	 Catch:{ all -> 0x0046 }
            monitor-exit(r0);	 Catch:{ all -> 0x0046 }
            return r1;	 Catch:{ all -> 0x0046 }
        L_0x0040:
            r1 = com.jakewharton.disklrucache.DiskLruCache.NULL_OUTPUT_STREAM;	 Catch:{ all -> 0x0046 }
            monitor-exit(r0);	 Catch:{ all -> 0x0046 }
            return r1;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r1 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r0);	 Catch:{ all -> 0x0046 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.a():java.io.OutputStream");
        }

        public final void m8451b() throws IOException {
            this.f10002d.completeEdit(this, false);
        }
    }

    private final class Entry {
        final /* synthetic */ DiskLruCache f10004a;
        private final String f10005b;
        private final long[] f10006c;
        private boolean f10007d;
        private Editor f10008e;
        private long f10009f;

        private Entry(DiskLruCache diskLruCache, String str) {
            this.f10004a = diskLruCache;
            this.f10005b = str;
            this.f10006c = new long[diskLruCache.valueCount];
        }

        public final String m8463a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.f10006c) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        private static IOException m8454a(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        public final File m8462a(int i) {
            File access$1900 = this.f10004a.directory;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f10005b);
            stringBuilder.append(".");
            stringBuilder.append(i);
            return new File(access$1900, stringBuilder.toString());
        }

        public final File m8464b(int i) {
            File access$1900 = this.f10004a.directory;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f10005b);
            stringBuilder.append(".");
            stringBuilder.append(i);
            stringBuilder.append(".tmp");
            return new File(access$1900, stringBuilder.toString());
        }

        static /* synthetic */ void m8455a(com.jakewharton.disklrucache.DiskLruCache.Entry r4, java.lang.String[] r5) throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = r5.length;
            r1 = r4.f10004a;
            r1 = r1.valueCount;
            if (r0 == r1) goto L_0x000e;
        L_0x0009:
            r4 = m8454a(r5);
            throw r4;
        L_0x000e:
            r0 = 0;
        L_0x000f:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x0020 }
            if (r0 >= r1) goto L_0x001f;	 Catch:{ NumberFormatException -> 0x0020 }
        L_0x0012:
            r1 = r4.f10006c;	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0020 }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x0020 }
            r0 = r0 + 1;
            goto L_0x000f;
        L_0x001f:
            return;
        L_0x0020:
            r4 = m8454a(r5);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Entry.a(com.jakewharton.disklrucache.DiskLruCache$Entry, java.lang.String[]):void");
        }
    }

    public final class Snapshot implements Closeable {
        public final InputStream[] f10010a;
        final /* synthetic */ DiskLruCache f10011b;
        private final String f10012c;
        private final long f10013d;
        private final long[] f10014e;

        private Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f10011b = diskLruCache;
            this.f10012c = str;
            this.f10013d = j;
            this.f10010a = inputStreamArr;
            this.f10014e = jArr;
        }

        public final void close() {
            for (Closeable a : this.f10010a) {
                Util.m8469a(a);
            }
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, JOURNAL_FILE);
        this.journalFileTmp = new File(file2, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file2, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.f10021a));
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder("DiskLruCache ");
                    stringBuilder.append(file);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    printStream.println(stringBuilder.toString());
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j);
            diskLruCache.rebuildJournal();
            return diskLruCache;
        }
    }

    private void readJournal() throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = new com.jakewharton.disklrucache.StrictLineReader;
        r1 = new java.io.FileInputStream;
        r2 = r8.journalFile;
        r1.<init>(r2);
        r2 = com.jakewharton.disklrucache.Util.f10021a;
        r0.<init>(r1, r2);
        r1 = r0.m8467a();	 Catch:{ all -> 0x009c }
        r2 = r0.m8467a();	 Catch:{ all -> 0x009c }
        r3 = r0.m8467a();	 Catch:{ all -> 0x009c }
        r4 = r0.m8467a();	 Catch:{ all -> 0x009c }
        r5 = r0.m8467a();	 Catch:{ all -> 0x009c }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x009c }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x009c }
        if (r6 == 0) goto L_0x006b;	 Catch:{ all -> 0x009c }
    L_0x002a:
        r6 = "1";	 Catch:{ all -> 0x009c }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x009c }
        if (r6 == 0) goto L_0x006b;	 Catch:{ all -> 0x009c }
    L_0x0032:
        r6 = r8.appVersion;	 Catch:{ all -> 0x009c }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x009c }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x009c }
        if (r3 == 0) goto L_0x006b;	 Catch:{ all -> 0x009c }
    L_0x003e:
        r3 = r8.valueCount;	 Catch:{ all -> 0x009c }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x009c }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x009c }
        if (r3 == 0) goto L_0x006b;	 Catch:{ all -> 0x009c }
    L_0x004a:
        r3 = "";	 Catch:{ all -> 0x009c }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x009c }
        if (r3 != 0) goto L_0x0053;
    L_0x0052:
        goto L_0x006b;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        r2 = r0.m8467a();	 Catch:{ EOFException -> 0x005e }
        r8.readJournalLine(r2);	 Catch:{ EOFException -> 0x005e }
        r1 = r1 + 1;
        goto L_0x0054;
    L_0x005e:
        r2 = r8.lruEntries;	 Catch:{ all -> 0x009c }
        r2 = r2.size();	 Catch:{ all -> 0x009c }
        r1 = r1 - r2;	 Catch:{ all -> 0x009c }
        r8.redundantOpCount = r1;	 Catch:{ all -> 0x009c }
        com.jakewharton.disklrucache.Util.m8469a(r0);
        return;
    L_0x006b:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x009c }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x009c }
        r6.<init>(r7);	 Catch:{ all -> 0x009c }
        r6.append(r1);	 Catch:{ all -> 0x009c }
        r1 = ", ";	 Catch:{ all -> 0x009c }
        r6.append(r1);	 Catch:{ all -> 0x009c }
        r6.append(r2);	 Catch:{ all -> 0x009c }
        r1 = ", ";	 Catch:{ all -> 0x009c }
        r6.append(r1);	 Catch:{ all -> 0x009c }
        r6.append(r4);	 Catch:{ all -> 0x009c }
        r1 = ", ";	 Catch:{ all -> 0x009c }
        r6.append(r1);	 Catch:{ all -> 0x009c }
        r6.append(r5);	 Catch:{ all -> 0x009c }
        r1 = "]";	 Catch:{ all -> 0x009c }
        r6.append(r1);	 Catch:{ all -> 0x009c }
        r1 = r6.toString();	 Catch:{ all -> 0x009c }
        r3.<init>(r1);	 Catch:{ all -> 0x009c }
        throw r3;	 Catch:{ all -> 0x009c }
    L_0x009c:
        r1 = move-exception;
        com.jakewharton.disklrucache.Util.m8469a(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
        String substring;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
        }
        substring = str.substring(i, indexOf2);
        Entry entry = (Entry) this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.f10007d = true;
            entry.f10008e = null;
            Entry.m8455a(entry, split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.f10008e = new Editor(entry);
        } else {
            if (indexOf2 == -1 && indexOf == 4) {
                if (str.startsWith(READ)) {
                    return;
                }
            }
            stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.f10008e == null) {
                while (i < this.valueCount) {
                    this.size += entry.f10006c[i];
                    i++;
                }
            } else {
                entry.f10008e = null;
                while (i < this.valueCount) {
                    deleteIfExists(entry.m8462a(i));
                    deleteIfExists(entry.m8464b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.f10021a));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write(VERSION_1);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                StringBuilder stringBuilder;
                if (entry.f10008e != null) {
                    stringBuilder = new StringBuilder("DIRTY ");
                    stringBuilder.append(entry.f10005b);
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder("CLEAN ");
                    stringBuilder.append(entry.f10005b);
                    stringBuilder.append(entry.m8463a());
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.f10021a));
        } finally {
            bufferedWriter.close();
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && file.delete() == null) {
            throw new IOException();
        }
    }

    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (file.renameTo(file2) == null) {
            throw new IOException();
        }
    }

    public final synchronized com.jakewharton.disklrucache.DiskLruCache.Snapshot get(java.lang.String r12) throws java.io.IOException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r11 = this;
        monitor-enter(r11);
        r11.checkNotClosed();	 Catch:{ all -> 0x0084 }
        r11.validateKey(r12);	 Catch:{ all -> 0x0084 }
        r0 = r11.lruEntries;	 Catch:{ all -> 0x0084 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x0084 }
        r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0084 }
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r11);
        return r1;
    L_0x0014:
        r2 = r0.f10007d;	 Catch:{ all -> 0x0084 }
        if (r2 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r11);
        return r1;
    L_0x001c:
        r2 = r11.valueCount;	 Catch:{ all -> 0x0084 }
        r8 = new java.io.InputStream[r2];	 Catch:{ all -> 0x0084 }
        r2 = 0;
        r3 = r2;
    L_0x0022:
        r4 = r11.valueCount;	 Catch:{ FileNotFoundException -> 0x0072 }
        if (r3 >= r4) goto L_0x0034;	 Catch:{ FileNotFoundException -> 0x0072 }
    L_0x0026:
        r4 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0072 }
        r5 = r0.m8462a(r3);	 Catch:{ FileNotFoundException -> 0x0072 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0072 }
        r8[r3] = r4;	 Catch:{ FileNotFoundException -> 0x0072 }
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x0034:
        r1 = r11.redundantOpCount;	 Catch:{ all -> 0x0084 }
        r1 = r1 + 1;	 Catch:{ all -> 0x0084 }
        r11.redundantOpCount = r1;	 Catch:{ all -> 0x0084 }
        r1 = r11.journalWriter;	 Catch:{ all -> 0x0084 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0084 }
        r3 = "READ ";	 Catch:{ all -> 0x0084 }
        r2.<init>(r3);	 Catch:{ all -> 0x0084 }
        r2.append(r12);	 Catch:{ all -> 0x0084 }
        r3 = 10;	 Catch:{ all -> 0x0084 }
        r2.append(r3);	 Catch:{ all -> 0x0084 }
        r2 = r2.toString();	 Catch:{ all -> 0x0084 }
        r1.append(r2);	 Catch:{ all -> 0x0084 }
        r1 = r11.journalRebuildRequired();	 Catch:{ all -> 0x0084 }
        if (r1 == 0) goto L_0x005f;	 Catch:{ all -> 0x0084 }
    L_0x0058:
        r1 = r11.executorService;	 Catch:{ all -> 0x0084 }
        r2 = r11.cleanupCallable;	 Catch:{ all -> 0x0084 }
        r1.submit(r2);	 Catch:{ all -> 0x0084 }
    L_0x005f:
        r1 = new com.jakewharton.disklrucache.DiskLruCache$Snapshot;	 Catch:{ all -> 0x0084 }
        r6 = r0.f10009f;	 Catch:{ all -> 0x0084 }
        r9 = r0.f10006c;	 Catch:{ all -> 0x0084 }
        r10 = 0;	 Catch:{ all -> 0x0084 }
        r3 = r1;	 Catch:{ all -> 0x0084 }
        r4 = r11;	 Catch:{ all -> 0x0084 }
        r5 = r12;	 Catch:{ all -> 0x0084 }
        r3.<init>(r5, r6, r8, r9);	 Catch:{ all -> 0x0084 }
        monitor-exit(r11);
        return r1;
    L_0x0072:
        r12 = r11.valueCount;	 Catch:{ all -> 0x0084 }
        if (r2 >= r12) goto L_0x0082;	 Catch:{ all -> 0x0084 }
    L_0x0076:
        r12 = r8[r2];	 Catch:{ all -> 0x0084 }
        if (r12 == 0) goto L_0x0082;	 Catch:{ all -> 0x0084 }
    L_0x007a:
        r12 = r8[r2];	 Catch:{ all -> 0x0084 }
        com.jakewharton.disklrucache.Util.m8469a(r12);	 Catch:{ all -> 0x0084 }
        r2 = r2 + 1;
        goto L_0x0072;
    L_0x0082:
        monitor-exit(r11);
        return r1;
    L_0x0084:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.get(java.lang.String):com.jakewharton.disklrucache.DiskLruCache$Snapshot");
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.jakewharton.disklrucache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.checkNotClosed();	 Catch:{ all -> 0x005f }
        r5.validateKey(r6);	 Catch:{ all -> 0x005f }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x005f }
        r0 = r0.get(r6);	 Catch:{ all -> 0x005f }
        r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x005f }
        r1 = -1;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r2 = 0;
        if (r1 == 0) goto L_0x0022;
    L_0x0016:
        if (r0 == 0) goto L_0x0020;
    L_0x0018:
        r3 = r0.f10009f;	 Catch:{ all -> 0x005f }
        r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r7 == 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r5);
        return r2;
    L_0x0022:
        r7 = 0;
        if (r0 != 0) goto L_0x0030;
    L_0x0025:
        r0 = new com.jakewharton.disklrucache.DiskLruCache$Entry;	 Catch:{ all -> 0x005f }
        r0.<init>(r6);	 Catch:{ all -> 0x005f }
        r8 = r5.lruEntries;	 Catch:{ all -> 0x005f }
        r8.put(r6, r0);	 Catch:{ all -> 0x005f }
        goto L_0x0038;
    L_0x0030:
        r8 = r0.f10008e;	 Catch:{ all -> 0x005f }
        if (r8 == 0) goto L_0x0038;
    L_0x0036:
        monitor-exit(r5);
        return r2;
    L_0x0038:
        r8 = new com.jakewharton.disklrucache.DiskLruCache$Editor;	 Catch:{ all -> 0x005f }
        r8.<init>(r0);	 Catch:{ all -> 0x005f }
        r0.f10008e = r8;	 Catch:{ all -> 0x005f }
        r7 = r5.journalWriter;	 Catch:{ all -> 0x005f }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
        r1 = "DIRTY ";
        r0.<init>(r1);	 Catch:{ all -> 0x005f }
        r0.append(r6);	 Catch:{ all -> 0x005f }
        r6 = 10;
        r0.append(r6);	 Catch:{ all -> 0x005f }
        r6 = r0.toString();	 Catch:{ all -> 0x005f }
        r7.write(r6);	 Catch:{ all -> 0x005f }
        r6 = r5.journalWriter;	 Catch:{ all -> 0x005f }
        r6.flush();	 Catch:{ all -> 0x005f }
        monitor-exit(r5);
        return r8;
    L_0x005f:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.edit(java.lang.String, long):com.jakewharton.disklrucache.DiskLruCache$Editor");
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public final synchronized long size() {
        return this.size;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void completeEdit(com.jakewharton.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.f9999a;	 Catch:{ all -> 0x0107 }
        r1 = r0.f10008e;	 Catch:{ all -> 0x0107 }
        if (r1 == r10) goto L_0x0011;
    L_0x000b:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0107 }
        r10.<init>();	 Catch:{ all -> 0x0107 }
        throw r10;	 Catch:{ all -> 0x0107 }
    L_0x0011:
        r1 = 0;
        if (r11 == 0) goto L_0x0050;
    L_0x0014:
        r2 = r0.f10007d;	 Catch:{ all -> 0x0107 }
        if (r2 != 0) goto L_0x0050;
    L_0x001a:
        r2 = r1;
    L_0x001b:
        r3 = r9.valueCount;	 Catch:{ all -> 0x0107 }
        if (r2 >= r3) goto L_0x0050;
    L_0x001f:
        r3 = r10.f10003e;	 Catch:{ all -> 0x0107 }
        r3 = r3[r2];	 Catch:{ all -> 0x0107 }
        if (r3 != 0) goto L_0x003e;
    L_0x0027:
        r10.m8451b();	 Catch:{ all -> 0x0107 }
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0107 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r0 = "Newly created entry didn't create value for index ";
        r11.<init>(r0);	 Catch:{ all -> 0x0107 }
        r11.append(r2);	 Catch:{ all -> 0x0107 }
        r11 = r11.toString();	 Catch:{ all -> 0x0107 }
        r10.<init>(r11);	 Catch:{ all -> 0x0107 }
        throw r10;	 Catch:{ all -> 0x0107 }
    L_0x003e:
        r3 = r0.m8464b(r2);	 Catch:{ all -> 0x0107 }
        r3 = r3.exists();	 Catch:{ all -> 0x0107 }
        if (r3 != 0) goto L_0x004d;
    L_0x0048:
        r10.m8451b();	 Catch:{ all -> 0x0107 }
        monitor-exit(r9);
        return;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0050:
        r10 = r9.valueCount;	 Catch:{ all -> 0x0107 }
        if (r1 >= r10) goto L_0x0084;
    L_0x0054:
        r10 = r0.m8464b(r1);	 Catch:{ all -> 0x0107 }
        if (r11 == 0) goto L_0x007e;
    L_0x005a:
        r2 = r10.exists();	 Catch:{ all -> 0x0107 }
        if (r2 == 0) goto L_0x0081;
    L_0x0060:
        r2 = r0.m8462a(r1);	 Catch:{ all -> 0x0107 }
        r10.renameTo(r2);	 Catch:{ all -> 0x0107 }
        r10 = r0.f10006c;	 Catch:{ all -> 0x0107 }
        r3 = r10[r1];	 Catch:{ all -> 0x0107 }
        r5 = r2.length();	 Catch:{ all -> 0x0107 }
        r10 = r0.f10006c;	 Catch:{ all -> 0x0107 }
        r10[r1] = r5;	 Catch:{ all -> 0x0107 }
        r7 = r9.size;	 Catch:{ all -> 0x0107 }
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.size = r7;	 Catch:{ all -> 0x0107 }
        goto L_0x0081;
    L_0x007e:
        deleteIfExists(r10);	 Catch:{ all -> 0x0107 }
    L_0x0081:
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0084:
        r10 = r9.redundantOpCount;	 Catch:{ all -> 0x0107 }
        r10 = r10 + 1;
        r9.redundantOpCount = r10;	 Catch:{ all -> 0x0107 }
        r10 = 0;
        r0.f10008e = r10;	 Catch:{ all -> 0x0107 }
        r10 = r0.f10007d;	 Catch:{ all -> 0x0107 }
        r10 = r10 | r11;
        r1 = 10;
        if (r10 == 0) goto L_0x00c8;
    L_0x0097:
        r0.f10007d = true;	 Catch:{ all -> 0x0107 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x0107 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r3 = "CLEAN ";
        r2.<init>(r3);	 Catch:{ all -> 0x0107 }
        r3 = r0.f10005b;	 Catch:{ all -> 0x0107 }
        r2.append(r3);	 Catch:{ all -> 0x0107 }
        r3 = r0.m8463a();	 Catch:{ all -> 0x0107 }
        r2.append(r3);	 Catch:{ all -> 0x0107 }
        r2.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r2.toString();	 Catch:{ all -> 0x0107 }
        r10.write(r1);	 Catch:{ all -> 0x0107 }
        if (r11 == 0) goto L_0x00eb;
    L_0x00bd:
        r10 = r9.nextSequenceNumber;	 Catch:{ all -> 0x0107 }
        r1 = 1;
        r1 = r1 + r10;
        r9.nextSequenceNumber = r1;	 Catch:{ all -> 0x0107 }
        r0.f10009f = r10;	 Catch:{ all -> 0x0107 }
        goto L_0x00eb;
    L_0x00c8:
        r10 = r9.lruEntries;	 Catch:{ all -> 0x0107 }
        r11 = r0.f10005b;	 Catch:{ all -> 0x0107 }
        r10.remove(r11);	 Catch:{ all -> 0x0107 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x0107 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r2 = "REMOVE ";
        r11.<init>(r2);	 Catch:{ all -> 0x0107 }
        r0 = r0.f10005b;	 Catch:{ all -> 0x0107 }
        r11.append(r0);	 Catch:{ all -> 0x0107 }
        r11.append(r1);	 Catch:{ all -> 0x0107 }
        r11 = r11.toString();	 Catch:{ all -> 0x0107 }
        r10.write(r11);	 Catch:{ all -> 0x0107 }
    L_0x00eb:
        r10 = r9.journalWriter;	 Catch:{ all -> 0x0107 }
        r10.flush();	 Catch:{ all -> 0x0107 }
        r10 = r9.size;	 Catch:{ all -> 0x0107 }
        r0 = r9.maxSize;	 Catch:{ all -> 0x0107 }
        r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r10 > 0) goto L_0x00fe;
    L_0x00f8:
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x0107 }
        if (r10 == 0) goto L_0x0105;
    L_0x00fe:
        r10 = r9.executorService;	 Catch:{ all -> 0x0107 }
        r11 = r9.cleanupCallable;	 Catch:{ all -> 0x0107 }
        r10.submit(r11);	 Catch:{ all -> 0x0107 }
    L_0x0105:
        monitor-exit(r9);
        return;
    L_0x0107:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.completeEdit(com.jakewharton.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE && this.redundantOpCount >= this.lruEntries.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r8) throws java.io.IOException {
        /*
        r7 = this;
        monitor-enter(r7);
        r7.checkNotClosed();	 Catch:{ all -> 0x008b }
        r7.validateKey(r8);	 Catch:{ all -> 0x008b }
        r0 = r7.lruEntries;	 Catch:{ all -> 0x008b }
        r0 = r0.get(r8);	 Catch:{ all -> 0x008b }
        r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x008b }
        r1 = 0;
        if (r0 == 0) goto L_0x0089;
    L_0x0012:
        r2 = r0.f10008e;	 Catch:{ all -> 0x008b }
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0089;
    L_0x0019:
        r2 = r7.valueCount;	 Catch:{ all -> 0x008b }
        if (r1 >= r2) goto L_0x0057;
    L_0x001d:
        r2 = r0.m8462a(r1);	 Catch:{ all -> 0x008b }
        r3 = r2.exists();	 Catch:{ all -> 0x008b }
        if (r3 == 0) goto L_0x0041;
    L_0x0027:
        r3 = r2.delete();	 Catch:{ all -> 0x008b }
        if (r3 != 0) goto L_0x0041;
    L_0x002d:
        r8 = new java.io.IOException;	 Catch:{ all -> 0x008b }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r1 = "failed to delete ";
        r0.<init>(r1);	 Catch:{ all -> 0x008b }
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r0.toString();	 Catch:{ all -> 0x008b }
        r8.<init>(r0);	 Catch:{ all -> 0x008b }
        throw r8;	 Catch:{ all -> 0x008b }
    L_0x0041:
        r2 = r7.size;	 Catch:{ all -> 0x008b }
        r4 = r0.f10006c;	 Catch:{ all -> 0x008b }
        r5 = r4[r1];	 Catch:{ all -> 0x008b }
        r2 = r2 - r5;
        r7.size = r2;	 Catch:{ all -> 0x008b }
        r2 = r0.f10006c;	 Catch:{ all -> 0x008b }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x008b }
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x0057:
        r0 = r7.redundantOpCount;	 Catch:{ all -> 0x008b }
        r1 = 1;
        r0 = r0 + r1;
        r7.redundantOpCount = r0;	 Catch:{ all -> 0x008b }
        r0 = r7.journalWriter;	 Catch:{ all -> 0x008b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r3 = "REMOVE ";
        r2.<init>(r3);	 Catch:{ all -> 0x008b }
        r2.append(r8);	 Catch:{ all -> 0x008b }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x008b }
        r2 = r2.toString();	 Catch:{ all -> 0x008b }
        r0.append(r2);	 Catch:{ all -> 0x008b }
        r0 = r7.lruEntries;	 Catch:{ all -> 0x008b }
        r0.remove(r8);	 Catch:{ all -> 0x008b }
        r8 = r7.journalRebuildRequired();	 Catch:{ all -> 0x008b }
        if (r8 == 0) goto L_0x0087;
    L_0x0080:
        r8 = r7.executorService;	 Catch:{ all -> 0x008b }
        r0 = r7.cleanupCallable;	 Catch:{ all -> 0x008b }
        r8.submit(r0);	 Catch:{ all -> 0x008b }
    L_0x0087:
        monitor-exit(r7);
        return r1;
    L_0x0089:
        monitor-exit(r7);
        return r1;
    L_0x008b:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.f10008e != null) {
                    entry.f10008e.m8451b();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public final void delete() throws IOException {
        close();
        Util.m8470a(this.directory);
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,64}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.m8468a(new InputStreamReader(inputStream, Util.f10022b));
    }
}
