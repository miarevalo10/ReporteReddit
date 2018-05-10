package com.sendbird.android.shadow.okhttp3.internal.cache;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.io.FileSystem;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new C20411(this);
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    class C20411 implements Runnable {
        final /* synthetic */ DiskLruCache f23366a;

        C20411(DiskLruCache diskLruCache) {
            this.f23366a = diskLruCache;
        }

        public void run() {
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
            r4 = this;
            r0 = r4.f23366a;
            monitor-enter(r0);
            r1 = r4.f23366a;	 Catch:{ all -> 0x0041 }
            r1 = r1.initialized;	 Catch:{ all -> 0x0041 }
            r2 = 1;	 Catch:{ all -> 0x0041 }
            r1 = r1 ^ r2;	 Catch:{ all -> 0x0041 }
            r3 = r4.f23366a;	 Catch:{ all -> 0x0041 }
            r3 = r3.closed;	 Catch:{ all -> 0x0041 }
            r1 = r1 | r3;	 Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0012;	 Catch:{ all -> 0x0041 }
        L_0x0010:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0012:
            r1 = r4.f23366a;	 Catch:{ IOException -> 0x0018 }
            r1.trimToSize();	 Catch:{ IOException -> 0x0018 }
            goto L_0x001c;
        L_0x0018:
            r1 = r4.f23366a;	 Catch:{ all -> 0x0041 }
            r1.mostRecentTrimFailed = r2;	 Catch:{ all -> 0x0041 }
        L_0x001c:
            r1 = r4.f23366a;	 Catch:{ IOException -> 0x002f }
            r1 = r1.journalRebuildRequired();	 Catch:{ IOException -> 0x002f }
            if (r1 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x002f }
        L_0x0024:
            r1 = r4.f23366a;	 Catch:{ IOException -> 0x002f }
            r1.rebuildJournal();	 Catch:{ IOException -> 0x002f }
            r1 = r4.f23366a;	 Catch:{ IOException -> 0x002f }
            r3 = 0;	 Catch:{ IOException -> 0x002f }
            r1.redundantOpCount = r3;	 Catch:{ IOException -> 0x002f }
            goto L_0x003f;
        L_0x002f:
            r1 = r4.f23366a;	 Catch:{ all -> 0x0041 }
            r1.mostRecentRebuildFailed = r2;	 Catch:{ all -> 0x0041 }
            r1 = r4.f23366a;	 Catch:{ all -> 0x0041 }
            r2 = com.sendbird.android.shadow.okio.Okio.m25616a();	 Catch:{ all -> 0x0041 }
            r2 = com.sendbird.android.shadow.okio.Okio.m25614a(r2);	 Catch:{ all -> 0x0041 }
            r1.journalWriter = r2;	 Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;	 Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception;	 Catch:{ all -> 0x0041 }
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.1.run():void");
        }
    }

    class C20423 implements Iterator<Snapshot> {
        final Iterator<Entry> f23367a = new ArrayList(this.f23370d.lruEntries.values()).iterator();
        Snapshot f23368b;
        Snapshot f23369c;
        final /* synthetic */ DiskLruCache f23370d;

        C20423(DiskLruCache diskLruCache) {
            this.f23370d = diskLruCache;
        }

        public boolean hasNext() {
            if (this.f23368b != null) {
                return true;
            }
            synchronized (this.f23370d) {
                if (this.f23370d.closed) {
                    return false;
                }
                while (this.f23367a.hasNext()) {
                    Snapshot a = ((Entry) this.f23367a.next()).m25389a();
                    if (a != null) {
                        this.f23368b = a;
                        return true;
                    }
                }
                return false;
            }
        }

        public void remove() {
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
            r3 = this;
            r0 = r3.f23369c;
            if (r0 != 0) goto L_0x000c;
        L_0x0004:
            r0 = new java.lang.IllegalStateException;
            r1 = "remove() before next()";
            r0.<init>(r1);
            throw r0;
        L_0x000c:
            r0 = 0;
            r1 = r3.f23370d;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r2 = r3.f23369c;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r2 = r2.f23383a;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r1.remove(r2);	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r3.f23369c = r0;
            return;
        L_0x001b:
            r1 = move-exception;
            r3.f23369c = r0;
            throw r1;
        L_0x001f:
            r3.f23369c = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.3.remove():void");
        }

        public /* synthetic */ Object next() {
            if (hasNext()) {
                this.f23369c = this.f23368b;
                this.f23368b = null;
                return this.f23369c;
            }
            throw new NoSuchElementException();
        }
    }

    public final class Editor {
        final Entry f23371a;
        final boolean[] f23372b;
        final /* synthetic */ DiskLruCache f23373c;
        private boolean f23374d;

        Editor(DiskLruCache diskLruCache, Entry entry) {
            this.f23373c = diskLruCache;
            this.f23371a = entry;
            this.f23372b = entry.f23379e != null ? null : new boolean[diskLruCache.valueCount];
        }

        final void m25385a() {
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
            r3 = this;
            r0 = r3.f23371a;
            r0 = r0.f23380f;
            if (r0 != r3) goto L_0x0022;
        L_0x0006:
            r0 = 0;
        L_0x0007:
            r1 = r3.f23373c;
            r1 = r1.valueCount;
            if (r0 >= r1) goto L_0x001d;
        L_0x000d:
            r1 = r3.f23373c;	 Catch:{ IOException -> 0x001a }
            r1 = r1.fileSystem;	 Catch:{ IOException -> 0x001a }
            r2 = r3.f23371a;	 Catch:{ IOException -> 0x001a }
            r2 = r2.f23378d;	 Catch:{ IOException -> 0x001a }
            r2 = r2[r0];	 Catch:{ IOException -> 0x001a }
            r1.mo5361d(r2);	 Catch:{ IOException -> 0x001a }
        L_0x001a:
            r0 = r0 + 1;
            goto L_0x0007;
        L_0x001d:
            r0 = r3.f23371a;
            r1 = 0;
            r0.f23380f = r1;
        L_0x0022:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor.a():void");
        }

        public final com.sendbird.android.shadow.okio.Sink m25384a(int r4) {
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
            r3 = this;
            r0 = r3.f23373c;
            monitor-enter(r0);
            r1 = r3.f23374d;	 Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x000d;	 Catch:{ all -> 0x003f }
        L_0x0007:
            r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003f }
            r4.<init>();	 Catch:{ all -> 0x003f }
            throw r4;	 Catch:{ all -> 0x003f }
        L_0x000d:
            r1 = r3.f23371a;	 Catch:{ all -> 0x003f }
            r1 = r1.f23380f;	 Catch:{ all -> 0x003f }
            if (r1 == r3) goto L_0x0019;	 Catch:{ all -> 0x003f }
        L_0x0013:
            r4 = com.sendbird.android.shadow.okio.Okio.m25616a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0019:
            r1 = r3.f23371a;	 Catch:{ all -> 0x003f }
            r1 = r1.f23379e;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0024;	 Catch:{ all -> 0x003f }
        L_0x001f:
            r1 = r3.f23372b;	 Catch:{ all -> 0x003f }
            r2 = 1;	 Catch:{ all -> 0x003f }
            r1[r4] = r2;	 Catch:{ all -> 0x003f }
        L_0x0024:
            r1 = r3.f23371a;	 Catch:{ all -> 0x003f }
            r1 = r1.f23378d;	 Catch:{ all -> 0x003f }
            r4 = r1[r4];	 Catch:{ all -> 0x003f }
            r1 = r3.f23373c;	 Catch:{ FileNotFoundException -> 0x0039 }
            r1 = r1.fileSystem;	 Catch:{ FileNotFoundException -> 0x0039 }
            r4 = r1.mo5359b(r4);	 Catch:{ FileNotFoundException -> 0x0039 }
            r1 = new com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Editor$1;	 Catch:{ all -> 0x003f }
            r1.<init>(r3, r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r1;	 Catch:{ all -> 0x003f }
        L_0x0039:
            r4 = com.sendbird.android.shadow.okio.Okio.m25616a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x003f:
            r4 = move-exception;	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor.a(int):com.sendbird.android.shadow.okio.Sink");
        }

        public final void m25386b() throws IOException {
            synchronized (this.f23373c) {
                if (this.f23374d) {
                    throw new IllegalStateException();
                }
                if (this.f23371a.f23380f == this) {
                    this.f23373c.completeEdit(this, true);
                }
                this.f23374d = true;
            }
        }

        public final void m25387c() throws IOException {
            synchronized (this.f23373c) {
                if (this.f23374d) {
                    throw new IllegalStateException();
                }
                if (this.f23371a.f23380f == this) {
                    this.f23373c.completeEdit(this, false);
                }
                this.f23374d = true;
            }
        }
    }

    private final class Entry {
        final String f23375a;
        final long[] f23376b;
        final File[] f23377c;
        final File[] f23378d;
        boolean f23379e;
        Editor f23380f;
        long f23381g;
        final /* synthetic */ DiskLruCache f23382h;

        Entry(DiskLruCache diskLruCache, String str) {
            this.f23382h = diskLruCache;
            this.f23375a = str;
            this.f23376b = new long[diskLruCache.valueCount];
            this.f23377c = new File[diskLruCache.valueCount];
            this.f23378d = new File[diskLruCache.valueCount];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < diskLruCache.valueCount; i++) {
                stringBuilder.append(i);
                this.f23377c[i] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.f23378d[i] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        final void m25391a(java.lang.String[] r5) throws java.io.IOException {
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
            r4 = this;
            r0 = r5.length;
            r1 = r4.f23382h;
            r1 = r1.valueCount;
            if (r0 == r1) goto L_0x000c;
        L_0x0007:
            r5 = m25388b(r5);
            throw r5;
        L_0x000c:
            r0 = 0;
        L_0x000d:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x001e }
            if (r0 >= r1) goto L_0x001d;	 Catch:{ NumberFormatException -> 0x001e }
        L_0x0010:
            r1 = r4.f23376b;	 Catch:{ NumberFormatException -> 0x001e }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x001e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x001e }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x001e }
            r0 = r0 + 1;
            goto L_0x000d;
        L_0x001d:
            return;
        L_0x001e:
            r5 = m25388b(r5);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Entry.a(java.lang.String[]):void");
        }

        final void m25390a(BufferedSink bufferedSink) throws IOException {
            for (long l : this.f23376b) {
                bufferedSink.mo6570h(32).mo6576l(l);
            }
        }

        private static IOException m25388b(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        final com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Snapshot m25389a() {
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
            r10 = this;
            r0 = r10.f23382h;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 != 0) goto L_0x000e;
        L_0x0008:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x000e:
            r0 = r10.f23382h;
            r0 = r0.valueCount;
            r0 = new com.sendbird.android.shadow.okio.Source[r0];
            r1 = r10.f23376b;
            r1 = r1.clone();
            r7 = r1;
            r7 = (long[]) r7;
            r8 = 0;
            r1 = r8;
        L_0x001f:
            r2 = r10.f23382h;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.valueCount;	 Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 >= r2) goto L_0x0036;	 Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0025:
            r2 = r10.f23382h;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.fileSystem;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r10.f23377c;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r3[r1];	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.mo5357a(r3);	 Catch:{ FileNotFoundException -> 0x0044 }
            r0[r1] = r2;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1 = r1 + 1;	 Catch:{ FileNotFoundException -> 0x0044 }
            goto L_0x001f;	 Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0036:
            r9 = new com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Snapshot;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r10.f23382h;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r10.f23375a;	 Catch:{ FileNotFoundException -> 0x0044 }
            r4 = r10.f23381g;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1 = r9;	 Catch:{ FileNotFoundException -> 0x0044 }
            r6 = r0;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1.<init>(r2, r3, r4, r6, r7);	 Catch:{ FileNotFoundException -> 0x0044 }
            return r9;
        L_0x0044:
            r1 = r10.f23382h;
            r1 = r1.valueCount;
            if (r8 >= r1) goto L_0x0056;
        L_0x004a:
            r1 = r0[r8];
            if (r1 == 0) goto L_0x0056;
        L_0x004e:
            r1 = r0[r8];
            com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r1);
            r8 = r8 + 1;
            goto L_0x0044;
        L_0x0056:
            r0 = r10.f23382h;	 Catch:{ IOException -> 0x005b }
            r0.removeEntry(r10);	 Catch:{ IOException -> 0x005b }
        L_0x005b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Entry.a():com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Snapshot");
        }
    }

    public final class Snapshot implements Closeable {
        public final String f23383a;
        public final long f23384b;
        public final Source[] f23385c;
        public final /* synthetic */ DiskLruCache f23386d;
        private final long[] f23387e;

        Snapshot(DiskLruCache diskLruCache, String str, long j, Source[] sourceArr, long[] jArr) {
            this.f23386d = diskLruCache;
            this.f23383a = str;
            this.f23384b = j;
            this.f23385c = sourceArr;
            this.f23387e = jArr;
        }

        public final void close() {
            for (Closeable a : this.f23385c) {
                Util.m25366a(a);
            }
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public final synchronized void initialize() throws IOException {
        if (!this.initialized) {
            if (this.fileSystem.mo5362e(this.journalFileBackup)) {
                if (this.fileSystem.mo5362e(this.journalFile)) {
                    this.fileSystem.mo5361d(this.journalFileBackup);
                } else {
                    this.fileSystem.mo5358a(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.mo5362e(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (Throwable e) {
                    Platform b = Platform.m25549b();
                    StringBuilder stringBuilder = new StringBuilder("DiskLruCache ");
                    stringBuilder.append(this.directory);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    b.mo5370a(5, stringBuilder.toString(), e);
                    delete();
                } finally {
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.m25364a("OkHttp DiskLruCache", true)));
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.fileSystem;
        r1 = r8.journalFile;
        r0 = r0.mo5357a(r1);
        r0 = com.sendbird.android.shadow.okio.Okio.m25615a(r0);
        r1 = r0.mo6579p();	 Catch:{ all -> 0x00ab }
        r2 = r0.mo6579p();	 Catch:{ all -> 0x00ab }
        r3 = r0.mo6579p();	 Catch:{ all -> 0x00ab }
        r4 = r0.mo6579p();	 Catch:{ all -> 0x00ab }
        r5 = r0.mo6579p();	 Catch:{ all -> 0x00ab }
        r6 = "libcore.io.DiskLruCache";	 Catch:{ all -> 0x00ab }
        r6 = r6.equals(r1);	 Catch:{ all -> 0x00ab }
        if (r6 == 0) goto L_0x0079;	 Catch:{ all -> 0x00ab }
    L_0x0028:
        r6 = "1";	 Catch:{ all -> 0x00ab }
        r6 = r6.equals(r2);	 Catch:{ all -> 0x00ab }
        if (r6 == 0) goto L_0x0079;	 Catch:{ all -> 0x00ab }
    L_0x0030:
        r6 = r8.appVersion;	 Catch:{ all -> 0x00ab }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x00ab }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x00ab }
        if (r3 == 0) goto L_0x0079;	 Catch:{ all -> 0x00ab }
    L_0x003c:
        r3 = r8.valueCount;	 Catch:{ all -> 0x00ab }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x00ab }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x00ab }
        if (r3 == 0) goto L_0x0079;	 Catch:{ all -> 0x00ab }
    L_0x0048:
        r3 = "";	 Catch:{ all -> 0x00ab }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x00ab }
        if (r3 != 0) goto L_0x0051;
    L_0x0050:
        goto L_0x0079;
    L_0x0051:
        r1 = 0;
    L_0x0052:
        r2 = r0.mo6579p();	 Catch:{ EOFException -> 0x005c }
        r8.readJournalLine(r2);	 Catch:{ EOFException -> 0x005c }
        r1 = r1 + 1;
        goto L_0x0052;
    L_0x005c:
        r2 = r8.lruEntries;	 Catch:{ all -> 0x00ab }
        r2 = r2.size();	 Catch:{ all -> 0x00ab }
        r1 = r1 - r2;	 Catch:{ all -> 0x00ab }
        r8.redundantOpCount = r1;	 Catch:{ all -> 0x00ab }
        r1 = r0.mo6562d();	 Catch:{ all -> 0x00ab }
        if (r1 != 0) goto L_0x006f;	 Catch:{ all -> 0x00ab }
    L_0x006b:
        r8.rebuildJournal();	 Catch:{ all -> 0x00ab }
        goto L_0x0075;	 Catch:{ all -> 0x00ab }
    L_0x006f:
        r1 = r8.newJournalWriter();	 Catch:{ all -> 0x00ab }
        r8.journalWriter = r1;	 Catch:{ all -> 0x00ab }
    L_0x0075:
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
        return;
    L_0x0079:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00ab }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ab }
        r7 = "unexpected journal header: [";	 Catch:{ all -> 0x00ab }
        r6.<init>(r7);	 Catch:{ all -> 0x00ab }
        r6.append(r1);	 Catch:{ all -> 0x00ab }
        r1 = ", ";	 Catch:{ all -> 0x00ab }
        r6.append(r1);	 Catch:{ all -> 0x00ab }
        r6.append(r2);	 Catch:{ all -> 0x00ab }
        r1 = ", ";	 Catch:{ all -> 0x00ab }
        r6.append(r1);	 Catch:{ all -> 0x00ab }
        r6.append(r4);	 Catch:{ all -> 0x00ab }
        r1 = ", ";	 Catch:{ all -> 0x00ab }
        r6.append(r1);	 Catch:{ all -> 0x00ab }
        r6.append(r5);	 Catch:{ all -> 0x00ab }
        r1 = "]";	 Catch:{ all -> 0x00ab }
        r6.append(r1);	 Catch:{ all -> 0x00ab }
        r1 = r6.toString();	 Catch:{ all -> 0x00ab }
        r3.<init>(r1);	 Catch:{ all -> 0x00ab }
        throw r3;	 Catch:{ all -> 0x00ab }
    L_0x00ab:
        r1 = move-exception;
        com.sendbird.android.shadow.okhttp3.internal.Util.m25366a(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.m25614a(new FaultHidingSink(this, this.fileSystem.mo5360c(this.journalFile)) {
            static final /* synthetic */ boolean f37605a = true;
            final /* synthetic */ DiskLruCache f37606b;

            static {
                Class cls = DiskLruCache.class;
            }

            protected final void mo7032b() {
                if (f37605a || Thread.holdsLock(this.f37606b)) {
                    this.f37606b.hasJournalErrors = true;
                    return;
                }
                throw new AssertionError();
            }
        });
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
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.f23379e = true;
            entry.f23380f = null;
            entry.m25391a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.f23380f = new Editor(this, entry);
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
        this.fileSystem.mo5361d(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.f23380f == null) {
                while (i < this.valueCount) {
                    this.size += entry.f23376b[i];
                    i++;
                }
            } else {
                entry.f23380f = null;
                while (i < this.valueCount) {
                    this.fileSystem.mo5361d(entry.f23377c[i]);
                    this.fileSystem.mo5361d(entry.f23378d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    final synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        BufferedSink a = Okio.m25614a(this.fileSystem.mo5359b(this.journalFileTmp));
        try {
            a.mo6553b(MAGIC).mo6570h(10);
            a.mo6553b(VERSION_1).mo6570h(10);
            a.mo6576l((long) this.appVersion).mo6570h(10);
            a.mo6576l((long) this.valueCount).mo6570h(10);
            a.mo6570h(10);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.f23380f != null) {
                    a.mo6553b(DIRTY).mo6570h(32);
                    a.mo6553b(entry.f23375a);
                    a.mo6570h(10);
                } else {
                    a.mo6553b(CLEAN).mo6570h(32);
                    a.mo6553b(entry.f23375a);
                    entry.m25390a(a);
                    a.mo6570h(10);
                }
            }
            if (this.fileSystem.mo5362e(this.journalFile)) {
                this.fileSystem.mo5358a(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.mo5358a(this.journalFileTmp, this.journalFile);
            this.fileSystem.mo5361d(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } finally {
            a.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
        r3 = this;
        monitor-enter(r3);
        r3.initialize();	 Catch:{ all -> 0x0050 }
        r3.checkNotClosed();	 Catch:{ all -> 0x0050 }
        r3.validateKey(r4);	 Catch:{ all -> 0x0050 }
        r0 = r3.lruEntries;	 Catch:{ all -> 0x0050 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0050 }
        r0 = (com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0050 }
        r1 = 0;
        if (r0 == 0) goto L_0x004e;
    L_0x0015:
        r2 = r0.f23379e;	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x004e;
    L_0x001a:
        r0 = r0.m25389a();	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r3);
        return r1;
    L_0x0022:
        r1 = r3.redundantOpCount;	 Catch:{ all -> 0x0050 }
        r1 = r1 + 1;
        r3.redundantOpCount = r1;	 Catch:{ all -> 0x0050 }
        r1 = r3.journalWriter;	 Catch:{ all -> 0x0050 }
        r2 = "READ";
        r1 = r1.mo6553b(r2);	 Catch:{ all -> 0x0050 }
        r2 = 32;
        r1 = r1.mo6570h(r2);	 Catch:{ all -> 0x0050 }
        r4 = r1.mo6553b(r4);	 Catch:{ all -> 0x0050 }
        r1 = 10;
        r4.mo6570h(r1);	 Catch:{ all -> 0x0050 }
        r4 = r3.journalRebuildRequired();	 Catch:{ all -> 0x0050 }
        if (r4 == 0) goto L_0x004c;
    L_0x0045:
        r4 = r3.executor;	 Catch:{ all -> 0x0050 }
        r1 = r3.cleanupRunnable;	 Catch:{ all -> 0x0050 }
        r4.execute(r1);	 Catch:{ all -> 0x0050 }
    L_0x004c:
        monitor-exit(r3);
        return r0;
    L_0x004e:
        monitor-exit(r3);
        return r1;
    L_0x0050:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.get(java.lang.String):com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.initialize();	 Catch:{ all -> 0x0074 }
        r5.checkNotClosed();	 Catch:{ all -> 0x0074 }
        r5.validateKey(r6);	 Catch:{ all -> 0x0074 }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x0074 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0074 }
        r0 = (com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0074 }
        r1 = -1;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r2 = 0;
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r3 = r0.f23381g;	 Catch:{ all -> 0x0074 }
        r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r7 == 0) goto L_0x0023;
    L_0x0021:
        monitor-exit(r5);
        return r2;
    L_0x0023:
        if (r0 == 0) goto L_0x002b;
    L_0x0025:
        r7 = r0.f23380f;	 Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r5);
        return r2;
    L_0x002b:
        r7 = r5.mostRecentTrimFailed;	 Catch:{ all -> 0x0074 }
        if (r7 != 0) goto L_0x006b;
    L_0x002f:
        r7 = r5.mostRecentRebuildFailed;	 Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x0034;
    L_0x0033:
        goto L_0x006b;
    L_0x0034:
        r7 = r5.journalWriter;	 Catch:{ all -> 0x0074 }
        r8 = "DIRTY";
        r7 = r7.mo6553b(r8);	 Catch:{ all -> 0x0074 }
        r8 = 32;
        r7 = r7.mo6570h(r8);	 Catch:{ all -> 0x0074 }
        r7 = r7.mo6553b(r6);	 Catch:{ all -> 0x0074 }
        r8 = 10;
        r7.mo6570h(r8);	 Catch:{ all -> 0x0074 }
        r7 = r5.journalWriter;	 Catch:{ all -> 0x0074 }
        r7.flush();	 Catch:{ all -> 0x0074 }
        r7 = r5.hasJournalErrors;	 Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x0056;
    L_0x0054:
        monitor-exit(r5);
        return r2;
    L_0x0056:
        if (r0 != 0) goto L_0x0062;
    L_0x0058:
        r0 = new com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Entry;	 Catch:{ all -> 0x0074 }
        r0.<init>(r5, r6);	 Catch:{ all -> 0x0074 }
        r7 = r5.lruEntries;	 Catch:{ all -> 0x0074 }
        r7.put(r6, r0);	 Catch:{ all -> 0x0074 }
    L_0x0062:
        r6 = new com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Editor;	 Catch:{ all -> 0x0074 }
        r6.<init>(r5, r0);	 Catch:{ all -> 0x0074 }
        r0.f23380f = r6;	 Catch:{ all -> 0x0074 }
        monitor-exit(r5);
        return r6;
    L_0x006b:
        r6 = r5.executor;	 Catch:{ all -> 0x0074 }
        r7 = r5.cleanupRunnable;	 Catch:{ all -> 0x0074 }
        r6.execute(r7);	 Catch:{ all -> 0x0074 }
        monitor-exit(r5);
        return r2;
    L_0x0074:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized != null) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized void completeEdit(com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.f23371a;	 Catch:{ all -> 0x00f8 }
        r1 = r0.f23380f;	 Catch:{ all -> 0x00f8 }
        if (r1 == r10) goto L_0x000d;
    L_0x0007:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00f8 }
        r10.<init>();	 Catch:{ all -> 0x00f8 }
        throw r10;	 Catch:{ all -> 0x00f8 }
    L_0x000d:
        r1 = 0;
        if (r11 == 0) goto L_0x004a;
    L_0x0010:
        r2 = r0.f23379e;	 Catch:{ all -> 0x00f8 }
        if (r2 != 0) goto L_0x004a;
    L_0x0014:
        r2 = r1;
    L_0x0015:
        r3 = r9.valueCount;	 Catch:{ all -> 0x00f8 }
        if (r2 >= r3) goto L_0x004a;
    L_0x0019:
        r3 = r10.f23372b;	 Catch:{ all -> 0x00f8 }
        r3 = r3[r2];	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0036;
    L_0x001f:
        r10.m25387c();	 Catch:{ all -> 0x00f8 }
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00f8 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f8 }
        r0 = "Newly created entry didn't create value for index ";
        r11.<init>(r0);	 Catch:{ all -> 0x00f8 }
        r11.append(r2);	 Catch:{ all -> 0x00f8 }
        r11 = r11.toString();	 Catch:{ all -> 0x00f8 }
        r10.<init>(r11);	 Catch:{ all -> 0x00f8 }
        throw r10;	 Catch:{ all -> 0x00f8 }
    L_0x0036:
        r3 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r4 = r0.f23378d;	 Catch:{ all -> 0x00f8 }
        r4 = r4[r2];	 Catch:{ all -> 0x00f8 }
        r3 = r3.mo5362e(r4);	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0047;
    L_0x0042:
        r10.m25387c();	 Catch:{ all -> 0x00f8 }
        monitor-exit(r9);
        return;
    L_0x0047:
        r2 = r2 + 1;
        goto L_0x0015;
    L_0x004a:
        r10 = r9.valueCount;	 Catch:{ all -> 0x00f8 }
        if (r1 >= r10) goto L_0x0082;
    L_0x004e:
        r10 = r0.f23378d;	 Catch:{ all -> 0x00f8 }
        r10 = r10[r1];	 Catch:{ all -> 0x00f8 }
        if (r11 == 0) goto L_0x007a;
    L_0x0054:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r2 = r2.mo5362e(r10);	 Catch:{ all -> 0x00f8 }
        if (r2 == 0) goto L_0x007f;
    L_0x005c:
        r2 = r0.f23377c;	 Catch:{ all -> 0x00f8 }
        r2 = r2[r1];	 Catch:{ all -> 0x00f8 }
        r3 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r3.mo5358a(r10, r2);	 Catch:{ all -> 0x00f8 }
        r10 = r0.f23376b;	 Catch:{ all -> 0x00f8 }
        r3 = r10[r1];	 Catch:{ all -> 0x00f8 }
        r10 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r5 = r10.mo5363f(r2);	 Catch:{ all -> 0x00f8 }
        r10 = r0.f23376b;	 Catch:{ all -> 0x00f8 }
        r10[r1] = r5;	 Catch:{ all -> 0x00f8 }
        r7 = r9.size;	 Catch:{ all -> 0x00f8 }
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.size = r7;	 Catch:{ all -> 0x00f8 }
        goto L_0x007f;
    L_0x007a:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r2.mo5361d(r10);	 Catch:{ all -> 0x00f8 }
    L_0x007f:
        r1 = r1 + 1;
        goto L_0x004a;
    L_0x0082:
        r10 = r9.redundantOpCount;	 Catch:{ all -> 0x00f8 }
        r1 = 1;
        r10 = r10 + r1;
        r9.redundantOpCount = r10;	 Catch:{ all -> 0x00f8 }
        r10 = 0;
        r0.f23380f = r10;	 Catch:{ all -> 0x00f8 }
        r10 = r0.f23379e;	 Catch:{ all -> 0x00f8 }
        r10 = r10 | r11;
        r2 = 10;
        r3 = 32;
        if (r10 == 0) goto L_0x00be;
    L_0x0094:
        r0.f23379e = r1;	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r1 = "CLEAN";
        r10 = r10.mo6553b(r1);	 Catch:{ all -> 0x00f8 }
        r10.mo6570h(r3);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r1 = r0.f23375a;	 Catch:{ all -> 0x00f8 }
        r10.mo6553b(r1);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r0.m25390a(r10);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r10.mo6570h(r2);	 Catch:{ all -> 0x00f8 }
        if (r11 == 0) goto L_0x00dc;
    L_0x00b4:
        r10 = r9.nextSequenceNumber;	 Catch:{ all -> 0x00f8 }
        r1 = 1;
        r1 = r1 + r10;
        r9.nextSequenceNumber = r1;	 Catch:{ all -> 0x00f8 }
        r0.f23381g = r10;	 Catch:{ all -> 0x00f8 }
        goto L_0x00dc;
    L_0x00be:
        r10 = r9.lruEntries;	 Catch:{ all -> 0x00f8 }
        r11 = r0.f23375a;	 Catch:{ all -> 0x00f8 }
        r10.remove(r11);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r11 = "REMOVE";
        r10 = r10.mo6553b(r11);	 Catch:{ all -> 0x00f8 }
        r10.mo6570h(r3);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r11 = r0.f23375a;	 Catch:{ all -> 0x00f8 }
        r10.mo6553b(r11);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r10.mo6570h(r2);	 Catch:{ all -> 0x00f8 }
    L_0x00dc:
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r10.flush();	 Catch:{ all -> 0x00f8 }
        r10 = r9.size;	 Catch:{ all -> 0x00f8 }
        r0 = r9.maxSize;	 Catch:{ all -> 0x00f8 }
        r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r10 > 0) goto L_0x00ef;
    L_0x00e9:
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x00f8 }
        if (r10 == 0) goto L_0x00f6;
    L_0x00ef:
        r10 = r9.executor;	 Catch:{ all -> 0x00f8 }
        r11 = r9.cleanupRunnable;	 Catch:{ all -> 0x00f8 }
        r10.execute(r11);	 Catch:{ all -> 0x00f8 }
    L_0x00f6:
        monitor-exit(r9);
        return;
    L_0x00f8:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.completeEdit(com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    final boolean journalRebuildRequired() {
        return this.redundantOpCount >= CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE && this.redundantOpCount >= this.lruEntries.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r6) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.initialize();	 Catch:{ all -> 0x0029 }
        r5.checkNotClosed();	 Catch:{ all -> 0x0029 }
        r5.validateKey(r6);	 Catch:{ all -> 0x0029 }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x0029 }
        r6 = r0.get(r6);	 Catch:{ all -> 0x0029 }
        r6 = (com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.Entry) r6;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        if (r6 != 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r5);
        return r0;
    L_0x0017:
        r6 = r5.removeEntry(r6);	 Catch:{ all -> 0x0029 }
        if (r6 == 0) goto L_0x0027;
    L_0x001d:
        r1 = r5.size;	 Catch:{ all -> 0x0029 }
        r3 = r5.maxSize;	 Catch:{ all -> 0x0029 }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x0027;
    L_0x0025:
        r5.mostRecentTrimFailed = r0;	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r5);
        return r6;
    L_0x0029:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    final boolean removeEntry(Entry entry) throws IOException {
        if (entry.f23380f != null) {
            entry.f23380f.m25385a();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.mo5361d(entry.f23377c[i]);
            this.size -= entry.f23376b[i];
            entry.f23376b[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.mo6553b(REMOVE).mo6570h(32).mo6553b(entry.f23375a).mo6570h(10);
        this.lruEntries.remove(entry.f23375a);
        if (journalRebuildRequired() != null) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public final synchronized void close() throws IOException {
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.f23380f != null) {
                        entry.f23380f.m25387c();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry((Entry) this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.mo5364g(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
        this.mostRecentTrimFailed = false;
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new C20423(this);
    }
}
