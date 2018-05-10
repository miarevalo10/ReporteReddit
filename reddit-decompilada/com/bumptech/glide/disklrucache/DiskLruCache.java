package com.bumptech.glide.disklrucache;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new C02681(this);
    private final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
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

    class C02681 implements Callable<Void> {
        final /* synthetic */ DiskLruCache f3255a;

        C02681(DiskLruCache diskLruCache) {
            this.f3255a = diskLruCache;
        }

        public /* synthetic */ Object call() throws Exception {
            return m2794a();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Void m2794a() throws java.lang.Exception {
            /*
            r4 = this;
            r0 = r4.f3255a;
            monitor-enter(r0);
            r1 = r4.f3255a;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalWriter;	 Catch:{ all -> 0x0028 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x000e:
            r1 = r4.f3255a;	 Catch:{ all -> 0x0028 }
            r1.trimToSize();	 Catch:{ all -> 0x0028 }
            r1 = r4.f3255a;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalRebuildRequired();	 Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026;
        L_0x001b:
            r1 = r4.f3255a;	 Catch:{ all -> 0x0028 }
            r1.rebuildJournal();	 Catch:{ all -> 0x0028 }
            r1 = r4.f3255a;	 Catch:{ all -> 0x0028 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.1.a():java.lang.Void");
        }
    }

    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {
        public boolean f3256a;
        public final /* synthetic */ DiskLruCache f3257b;
        private final Entry f3258c;
        private final boolean[] f3259d;

        private Editor(DiskLruCache diskLruCache, Entry entry) {
            this.f3257b = diskLruCache;
            this.f3258c = entry;
            this.f3259d = entry.f3265f != null ? null : new boolean[diskLruCache.valueCount];
        }

        public final File m2797a() throws IOException {
            File file;
            synchronized (this.f3257b) {
                if (this.f3258c.f3266g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f3258c.f3265f) {
                    this.f3259d[0] = true;
                }
                file = this.f3258c.f3261b[0];
                if (!this.f3257b.directory.exists()) {
                    this.f3257b.directory.mkdirs();
                }
            }
            return file;
        }

        public final void m2798b() throws IOException {
            this.f3257b.completeEdit(this, false);
        }

        public final void m2799c() {
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
            r1 = this;
            r0 = r1.f3256a;
            if (r0 != 0) goto L_0x0008;
        L_0x0004:
            r1.m2798b();	 Catch:{ IOException -> 0x0008 }
            return;
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.Editor.c():void");
        }
    }

    private final class Entry {
        File[] f3260a;
        File[] f3261b;
        final /* synthetic */ DiskLruCache f3262c;
        private final String f3263d;
        private final long[] f3264e;
        private boolean f3265f;
        private Editor f3266g;
        private long f3267h;

        private Entry(DiskLruCache diskLruCache, String str) {
            this.f3262c = diskLruCache;
            this.f3263d = str;
            this.f3264e = new long[diskLruCache.valueCount];
            this.f3260a = new File[diskLruCache.valueCount];
            this.f3261b = new File[diskLruCache.valueCount];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < diskLruCache.valueCount; i++) {
                stringBuilder.append(i);
                this.f3260a[i] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.f3261b[i] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        public final String m2810a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.f3264e) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        private static IOException m2802a(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        static /* synthetic */ void m2803a(com.bumptech.glide.disklrucache.DiskLruCache.Entry r4, java.lang.String[] r5) throws java.io.IOException {
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
            r1 = r4.f3262c;
            r1 = r1.valueCount;
            if (r0 == r1) goto L_0x000e;
        L_0x0009:
            r4 = m2802a(r5);
            throw r4;
        L_0x000e:
            r0 = 0;
        L_0x000f:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x0020 }
            if (r0 >= r1) goto L_0x001f;	 Catch:{ NumberFormatException -> 0x0020 }
        L_0x0012:
            r1 = r4.f3264e;	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x0020 }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0020 }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x0020 }
            r0 = r0 + 1;
            goto L_0x000f;
        L_0x001f:
            return;
        L_0x0020:
            r4 = m2802a(r5);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.Entry.a(com.bumptech.glide.disklrucache.DiskLruCache$Entry, java.lang.String[]):void");
        }
    }

    public final class Value {
        public final File[] f3268a;
        final /* synthetic */ DiskLruCache f3269b;
        private final String f3270c;
        private final long f3271d;
        private final long[] f3272e;

        private Value(DiskLruCache diskLruCache, String str, long j, File[] fileArr, long[] jArr) {
            this.f3269b = diskLruCache;
            this.f3270c = str;
            this.f3271d = j;
            this.f3268a = fileArr;
            this.f3272e = jArr;
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
        r0 = new com.bumptech.glide.disklrucache.StrictLineReader;
        r1 = new java.io.FileInputStream;
        r2 = r8.journalFile;
        r1.<init>(r2);
        r2 = com.bumptech.glide.disklrucache.Util.f3279a;
        r0.<init>(r1, r2);
        r1 = r0.m2813a();	 Catch:{ all -> 0x00bf }
        r2 = r0.m2813a();	 Catch:{ all -> 0x00bf }
        r3 = r0.m2813a();	 Catch:{ all -> 0x00bf }
        r4 = r0.m2813a();	 Catch:{ all -> 0x00bf }
        r5 = r0.m2813a();	 Catch:{ all -> 0x00bf }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x00bf }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x00bf }
        if (r6 == 0) goto L_0x008e;	 Catch:{ all -> 0x00bf }
    L_0x002a:
        r6 = "1";	 Catch:{ all -> 0x00bf }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x00bf }
        if (r6 == 0) goto L_0x008e;	 Catch:{ all -> 0x00bf }
    L_0x0032:
        r6 = r8.appVersion;	 Catch:{ all -> 0x00bf }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x00bf }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x00bf }
        if (r3 == 0) goto L_0x008e;	 Catch:{ all -> 0x00bf }
    L_0x003e:
        r3 = r8.valueCount;	 Catch:{ all -> 0x00bf }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x00bf }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00bf }
        if (r3 == 0) goto L_0x008e;	 Catch:{ all -> 0x00bf }
    L_0x004a:
        r3 = "";	 Catch:{ all -> 0x00bf }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x00bf }
        if (r3 != 0) goto L_0x0053;
    L_0x0052:
        goto L_0x008e;
    L_0x0053:
        r1 = 0;
        r2 = r1;
    L_0x0055:
        r3 = r0.m2813a();	 Catch:{ EOFException -> 0x005f }
        r8.readJournalLine(r3);	 Catch:{ EOFException -> 0x005f }
        r2 = r2 + 1;
        goto L_0x0055;
    L_0x005f:
        r3 = r8.lruEntries;	 Catch:{ all -> 0x00bf }
        r3 = r3.size();	 Catch:{ all -> 0x00bf }
        r2 = r2 - r3;	 Catch:{ all -> 0x00bf }
        r8.redundantOpCount = r2;	 Catch:{ all -> 0x00bf }
        r2 = r0.f3274a;	 Catch:{ all -> 0x00bf }
        r3 = -1;	 Catch:{ all -> 0x00bf }
        r4 = 1;	 Catch:{ all -> 0x00bf }
        if (r2 != r3) goto L_0x006f;	 Catch:{ all -> 0x00bf }
    L_0x006e:
        r1 = r4;	 Catch:{ all -> 0x00bf }
    L_0x006f:
        if (r1 == 0) goto L_0x0075;	 Catch:{ all -> 0x00bf }
    L_0x0071:
        r8.rebuildJournal();	 Catch:{ all -> 0x00bf }
        goto L_0x008a;	 Catch:{ all -> 0x00bf }
    L_0x0075:
        r1 = new java.io.BufferedWriter;	 Catch:{ all -> 0x00bf }
        r2 = new java.io.OutputStreamWriter;	 Catch:{ all -> 0x00bf }
        r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00bf }
        r5 = r8.journalFile;	 Catch:{ all -> 0x00bf }
        r3.<init>(r5, r4);	 Catch:{ all -> 0x00bf }
        r4 = com.bumptech.glide.disklrucache.Util.f3279a;	 Catch:{ all -> 0x00bf }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00bf }
        r1.<init>(r2);	 Catch:{ all -> 0x00bf }
        r8.journalWriter = r1;	 Catch:{ all -> 0x00bf }
    L_0x008a:
        com.bumptech.glide.disklrucache.Util.m2815a(r0);
        return;
    L_0x008e:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00bf }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bf }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x00bf }
        r6.<init>(r7);	 Catch:{ all -> 0x00bf }
        r6.append(r1);	 Catch:{ all -> 0x00bf }
        r1 = ", ";	 Catch:{ all -> 0x00bf }
        r6.append(r1);	 Catch:{ all -> 0x00bf }
        r6.append(r2);	 Catch:{ all -> 0x00bf }
        r1 = ", ";	 Catch:{ all -> 0x00bf }
        r6.append(r1);	 Catch:{ all -> 0x00bf }
        r6.append(r4);	 Catch:{ all -> 0x00bf }
        r1 = ", ";	 Catch:{ all -> 0x00bf }
        r6.append(r1);	 Catch:{ all -> 0x00bf }
        r6.append(r5);	 Catch:{ all -> 0x00bf }
        r1 = "]";	 Catch:{ all -> 0x00bf }
        r6.append(r1);	 Catch:{ all -> 0x00bf }
        r1 = r6.toString();	 Catch:{ all -> 0x00bf }
        r3.<init>(r1);	 Catch:{ all -> 0x00bf }
        throw r3;	 Catch:{ all -> 0x00bf }
    L_0x00bf:
        r1 = move-exception;
        com.bumptech.glide.disklrucache.Util.m2815a(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.readJournal():void");
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
            entry.f3265f = true;
            entry.f3266g = null;
            Entry.m2803a(entry, split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.f3266g = new Editor(entry);
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
            if (entry.f3266g == null) {
                while (i < this.valueCount) {
                    this.size += entry.f3264e[i];
                    i++;
                }
            } else {
                entry.f3266g = null;
                while (i < this.valueCount) {
                    deleteIfExists(entry.f3260a[i]);
                    deleteIfExists(entry.f3261b[i]);
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
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.f3279a));
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
                if (entry.f3266g != null) {
                    stringBuilder = new StringBuilder("DIRTY ");
                    stringBuilder.append(entry.f3263d);
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder("CLEAN ");
                    stringBuilder.append(entry.f3263d);
                    stringBuilder.append(entry.m2810a());
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.f3279a));
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

    public final synchronized Value get(String str) throws IOException {
        checkNotClosed();
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f3265f) {
            return null;
        }
        for (File exists : entry.f3260a) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append(READ);
        this.journalWriter.append(' ');
        this.journalWriter.append(str);
        this.journalWriter.append('\n');
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Value(str, entry.f3267h, entry.f3260a, entry.f3264e);
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.checkNotClosed();	 Catch:{ all -> 0x005e }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x005e }
        r0 = r0.get(r6);	 Catch:{ all -> 0x005e }
        r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x005e }
        r1 = -1;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0013:
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r3 = r0.f3267h;	 Catch:{ all -> 0x005e }
        r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r7 == 0) goto L_0x001f;
    L_0x001d:
        monitor-exit(r5);
        return r2;
    L_0x001f:
        r7 = 0;
        if (r0 != 0) goto L_0x002d;
    L_0x0022:
        r0 = new com.bumptech.glide.disklrucache.DiskLruCache$Entry;	 Catch:{ all -> 0x005e }
        r0.<init>(r6);	 Catch:{ all -> 0x005e }
        r8 = r5.lruEntries;	 Catch:{ all -> 0x005e }
        r8.put(r6, r0);	 Catch:{ all -> 0x005e }
        goto L_0x0035;
    L_0x002d:
        r8 = r0.f3266g;	 Catch:{ all -> 0x005e }
        if (r8 == 0) goto L_0x0035;
    L_0x0033:
        monitor-exit(r5);
        return r2;
    L_0x0035:
        r8 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor;	 Catch:{ all -> 0x005e }
        r8.<init>(r0);	 Catch:{ all -> 0x005e }
        r0.f3266g = r8;	 Catch:{ all -> 0x005e }
        r7 = r5.journalWriter;	 Catch:{ all -> 0x005e }
        r0 = "DIRTY";
        r7.append(r0);	 Catch:{ all -> 0x005e }
        r7 = r5.journalWriter;	 Catch:{ all -> 0x005e }
        r0 = 32;
        r7.append(r0);	 Catch:{ all -> 0x005e }
        r7 = r5.journalWriter;	 Catch:{ all -> 0x005e }
        r7.append(r6);	 Catch:{ all -> 0x005e }
        r6 = r5.journalWriter;	 Catch:{ all -> 0x005e }
        r7 = 10;
        r6.append(r7);	 Catch:{ all -> 0x005e }
        r6 = r5.journalWriter;	 Catch:{ all -> 0x005e }
        r6.flush();	 Catch:{ all -> 0x005e }
        monitor-exit(r5);
        return r8;
    L_0x005e:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.edit(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
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
    private synchronized void completeEdit(com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.f3258c;	 Catch:{ all -> 0x010b }
        r1 = r0.f3266g;	 Catch:{ all -> 0x010b }
        if (r1 == r10) goto L_0x0011;
    L_0x000b:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010b }
        r10.<init>();	 Catch:{ all -> 0x010b }
        throw r10;	 Catch:{ all -> 0x010b }
    L_0x0011:
        r1 = 0;
        if (r11 == 0) goto L_0x0050;
    L_0x0014:
        r2 = r0.f3265f;	 Catch:{ all -> 0x010b }
        if (r2 != 0) goto L_0x0050;
    L_0x001a:
        r2 = r1;
    L_0x001b:
        r3 = r9.valueCount;	 Catch:{ all -> 0x010b }
        if (r2 >= r3) goto L_0x0050;
    L_0x001f:
        r3 = r10.f3259d;	 Catch:{ all -> 0x010b }
        r3 = r3[r2];	 Catch:{ all -> 0x010b }
        if (r3 != 0) goto L_0x003e;
    L_0x0027:
        r10.m2798b();	 Catch:{ all -> 0x010b }
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010b }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r0 = "Newly created entry didn't create value for index ";
        r11.<init>(r0);	 Catch:{ all -> 0x010b }
        r11.append(r2);	 Catch:{ all -> 0x010b }
        r11 = r11.toString();	 Catch:{ all -> 0x010b }
        r10.<init>(r11);	 Catch:{ all -> 0x010b }
        throw r10;	 Catch:{ all -> 0x010b }
    L_0x003e:
        r3 = r0.f3261b;	 Catch:{ all -> 0x010b }
        r3 = r3[r2];	 Catch:{ all -> 0x010b }
        r3 = r3.exists();	 Catch:{ all -> 0x010b }
        if (r3 != 0) goto L_0x004d;
    L_0x0048:
        r10.m2798b();	 Catch:{ all -> 0x010b }
        monitor-exit(r9);
        return;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0050:
        r10 = r9.valueCount;	 Catch:{ all -> 0x010b }
        if (r1 >= r10) goto L_0x0084;
    L_0x0054:
        r10 = r0.f3261b;	 Catch:{ all -> 0x010b }
        r10 = r10[r1];	 Catch:{ all -> 0x010b }
        if (r11 == 0) goto L_0x007e;
    L_0x005a:
        r2 = r10.exists();	 Catch:{ all -> 0x010b }
        if (r2 == 0) goto L_0x0081;
    L_0x0060:
        r2 = r0.f3260a;	 Catch:{ all -> 0x010b }
        r2 = r2[r1];	 Catch:{ all -> 0x010b }
        r10.renameTo(r2);	 Catch:{ all -> 0x010b }
        r10 = r0.f3264e;	 Catch:{ all -> 0x010b }
        r3 = r10[r1];	 Catch:{ all -> 0x010b }
        r5 = r2.length();	 Catch:{ all -> 0x010b }
        r10 = r0.f3264e;	 Catch:{ all -> 0x010b }
        r10[r1] = r5;	 Catch:{ all -> 0x010b }
        r7 = r9.size;	 Catch:{ all -> 0x010b }
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.size = r7;	 Catch:{ all -> 0x010b }
        goto L_0x0081;
    L_0x007e:
        deleteIfExists(r10);	 Catch:{ all -> 0x010b }
    L_0x0081:
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0084:
        r10 = r9.redundantOpCount;	 Catch:{ all -> 0x010b }
        r10 = r10 + 1;
        r9.redundantOpCount = r10;	 Catch:{ all -> 0x010b }
        r10 = 0;
        r0.f3266g = r10;	 Catch:{ all -> 0x010b }
        r10 = r0.f3265f;	 Catch:{ all -> 0x010b }
        r10 = r10 | r11;
        r1 = 10;
        r2 = 32;
        if (r10 == 0) goto L_0x00cc;
    L_0x0099:
        r0.f3265f = true;	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r3 = "CLEAN";
        r10.append(r3);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r10.append(r2);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r2 = r0.f3263d;	 Catch:{ all -> 0x010b }
        r10.append(r2);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r2 = r0.m2810a();	 Catch:{ all -> 0x010b }
        r10.append(r2);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r10.append(r1);	 Catch:{ all -> 0x010b }
        if (r11 == 0) goto L_0x00ef;
    L_0x00c1:
        r10 = r9.nextSequenceNumber;	 Catch:{ all -> 0x010b }
        r1 = 1;
        r1 = r1 + r10;
        r9.nextSequenceNumber = r1;	 Catch:{ all -> 0x010b }
        r0.f3267h = r10;	 Catch:{ all -> 0x010b }
        goto L_0x00ef;
    L_0x00cc:
        r10 = r9.lruEntries;	 Catch:{ all -> 0x010b }
        r11 = r0.f3263d;	 Catch:{ all -> 0x010b }
        r10.remove(r11);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r11 = "REMOVE";
        r10.append(r11);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r10.append(r2);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r11 = r0.f3263d;	 Catch:{ all -> 0x010b }
        r10.append(r11);	 Catch:{ all -> 0x010b }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r10.append(r1);	 Catch:{ all -> 0x010b }
    L_0x00ef:
        r10 = r9.journalWriter;	 Catch:{ all -> 0x010b }
        r10.flush();	 Catch:{ all -> 0x010b }
        r10 = r9.size;	 Catch:{ all -> 0x010b }
        r0 = r9.maxSize;	 Catch:{ all -> 0x010b }
        r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r10 > 0) goto L_0x0102;
    L_0x00fc:
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x010b }
        if (r10 == 0) goto L_0x0109;
    L_0x0102:
        r10 = r9.executorService;	 Catch:{ all -> 0x010b }
        r11 = r9.cleanupCallable;	 Catch:{ all -> 0x010b }
        r10.submit(r11);	 Catch:{ all -> 0x010b }
    L_0x0109:
        monitor-exit(r9);
        return;
    L_0x010b:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.completeEdit(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
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
        r7.checkNotClosed();	 Catch:{ all -> 0x008a }
        r0 = r7.lruEntries;	 Catch:{ all -> 0x008a }
        r0 = r0.get(r8);	 Catch:{ all -> 0x008a }
        r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x008a }
        r1 = 0;
        if (r0 == 0) goto L_0x0088;
    L_0x000f:
        r2 = r0.f3266g;	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0088;
    L_0x0016:
        r2 = r7.valueCount;	 Catch:{ all -> 0x008a }
        if (r1 >= r2) goto L_0x0054;
    L_0x001a:
        r2 = r0.f3260a;	 Catch:{ all -> 0x008a }
        r2 = r2[r1];	 Catch:{ all -> 0x008a }
        r3 = r2.exists();	 Catch:{ all -> 0x008a }
        if (r3 == 0) goto L_0x003e;
    L_0x0024:
        r3 = r2.delete();	 Catch:{ all -> 0x008a }
        if (r3 != 0) goto L_0x003e;
    L_0x002a:
        r8 = new java.io.IOException;	 Catch:{ all -> 0x008a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r1 = "failed to delete ";
        r0.<init>(r1);	 Catch:{ all -> 0x008a }
        r0.append(r2);	 Catch:{ all -> 0x008a }
        r0 = r0.toString();	 Catch:{ all -> 0x008a }
        r8.<init>(r0);	 Catch:{ all -> 0x008a }
        throw r8;	 Catch:{ all -> 0x008a }
    L_0x003e:
        r2 = r7.size;	 Catch:{ all -> 0x008a }
        r4 = r0.f3264e;	 Catch:{ all -> 0x008a }
        r5 = r4[r1];	 Catch:{ all -> 0x008a }
        r2 = r2 - r5;
        r7.size = r2;	 Catch:{ all -> 0x008a }
        r2 = r0.f3264e;	 Catch:{ all -> 0x008a }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x008a }
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0054:
        r0 = r7.redundantOpCount;	 Catch:{ all -> 0x008a }
        r1 = 1;
        r0 = r0 + r1;
        r7.redundantOpCount = r0;	 Catch:{ all -> 0x008a }
        r0 = r7.journalWriter;	 Catch:{ all -> 0x008a }
        r2 = "REMOVE";
        r0.append(r2);	 Catch:{ all -> 0x008a }
        r0 = r7.journalWriter;	 Catch:{ all -> 0x008a }
        r2 = 32;
        r0.append(r2);	 Catch:{ all -> 0x008a }
        r0 = r7.journalWriter;	 Catch:{ all -> 0x008a }
        r0.append(r8);	 Catch:{ all -> 0x008a }
        r0 = r7.journalWriter;	 Catch:{ all -> 0x008a }
        r2 = 10;
        r0.append(r2);	 Catch:{ all -> 0x008a }
        r0 = r7.lruEntries;	 Catch:{ all -> 0x008a }
        r0.remove(r8);	 Catch:{ all -> 0x008a }
        r8 = r7.journalRebuildRequired();	 Catch:{ all -> 0x008a }
        if (r8 == 0) goto L_0x0086;
    L_0x007f:
        r8 = r7.executorService;	 Catch:{ all -> 0x008a }
        r0 = r7.cleanupCallable;	 Catch:{ all -> 0x008a }
        r8.submit(r0);	 Catch:{ all -> 0x008a }
    L_0x0086:
        monitor-exit(r7);
        return r1;
    L_0x0088:
        monitor-exit(r7);
        return r1;
    L_0x008a:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
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
                if (entry.f3266g != null) {
                    entry.f3266g.m2798b();
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
        Util.m2816a(this.directory);
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.m2814a(new InputStreamReader(inputStream, Util.f3280b));
    }
}
