package okhttp3.internal.cache;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
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
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

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
    private final Runnable cleanupRunnable = new C21791();
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

    class C21791 implements Runnable {
        C21791() {
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1 = r1.initialized;	 Catch:{ all -> 0x0041 }
            r2 = 1;	 Catch:{ all -> 0x0041 }
            r1 = r1 ^ r2;	 Catch:{ all -> 0x0041 }
            r3 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r3 = r3.closed;	 Catch:{ all -> 0x0041 }
            r1 = r1 | r3;	 Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0012;	 Catch:{ all -> 0x0041 }
        L_0x0010:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0012:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0018 }
            r1.trimToSize();	 Catch:{ IOException -> 0x0018 }
            goto L_0x001c;
        L_0x0018:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1.mostRecentTrimFailed = r2;	 Catch:{ all -> 0x0041 }
        L_0x001c:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r1 = r1.journalRebuildRequired();	 Catch:{ IOException -> 0x002f }
            if (r1 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x002f }
        L_0x0024:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r1.rebuildJournal();	 Catch:{ IOException -> 0x002f }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x002f }
            r3 = 0;	 Catch:{ IOException -> 0x002f }
            r1.redundantOpCount = r3;	 Catch:{ IOException -> 0x002f }
            goto L_0x003f;
        L_0x002f:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r1.mostRecentRebuildFailed = r2;	 Catch:{ all -> 0x0041 }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ all -> 0x0041 }
            r2 = okio.Okio.m28290a();	 Catch:{ all -> 0x0041 }
            r2 = okio.Okio.m28288a(r2);	 Catch:{ all -> 0x0041 }
            r1.journalWriter = r2;	 Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            return;	 Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception;	 Catch:{ all -> 0x0041 }
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.1.run():void");
        }
    }

    class C21803 implements Iterator<Snapshot> {
        final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;

        C21803() {
        }

        public boolean hasNext() {
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.closed) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Snapshot snapshot = ((Entry) this.delegate.next()).snapshot();
                    if (snapshot != null) {
                        this.nextSnapshot = snapshot;
                        return true;
                    }
                }
                return false;
            }
        }

        public Snapshot next() {
            if (hasNext()) {
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                return this.removeSnapshot;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.removeSnapshot;
            if (r0 != 0) goto L_0x000c;
        L_0x0004:
            r0 = new java.lang.IllegalStateException;
            r1 = "remove() before next()";
            r0.<init>(r1);
            throw r0;
        L_0x000c:
            r0 = 0;
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r2 = r3.removeSnapshot;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r2 = r2.key;	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r1.remove(r2);	 Catch:{ IOException -> 0x001f, all -> 0x001b }
            r3.removeSnapshot = r0;
            return;
        L_0x001b:
            r1 = move-exception;
            r3.removeSnapshot = r0;
            throw r1;
        L_0x001f:
            r3.removeSnapshot = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.3.remove():void");
        }
    }

    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable != null ? null : new boolean[DiskLruCache.this.valueCount];
        }

        final void detach() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r3.entry;
            r0 = r0.currentEditor;
            if (r0 != r3) goto L_0x0022;
        L_0x0006:
            r0 = 0;
        L_0x0007:
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r0 >= r1) goto L_0x001d;
        L_0x000d:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x001a }
            r1 = r1.fileSystem;	 Catch:{ IOException -> 0x001a }
            r2 = r3.entry;	 Catch:{ IOException -> 0x001a }
            r2 = r2.dirtyFiles;	 Catch:{ IOException -> 0x001a }
            r2 = r2[r0];	 Catch:{ IOException -> 0x001a }
            r1.delete(r2);	 Catch:{ IOException -> 0x001a }
        L_0x001a:
            r0 = r0 + 1;
            goto L_0x0007;
        L_0x001d:
            r0 = r3.entry;
            r1 = 0;
            r0.currentEditor = r1;
        L_0x0022:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.detach():void");
        }

        public final okio.Source newSource(int r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r4.done;	 Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x000d;	 Catch:{ all -> 0x002f }
        L_0x0007:
            r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x002f }
            r5.<init>();	 Catch:{ all -> 0x002f }
            throw r5;	 Catch:{ all -> 0x002f }
        L_0x000d:
            r1 = r4.entry;	 Catch:{ all -> 0x002f }
            r1 = r1.readable;	 Catch:{ all -> 0x002f }
            r2 = 0;	 Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002d;	 Catch:{ all -> 0x002f }
        L_0x0014:
            r1 = r4.entry;	 Catch:{ all -> 0x002f }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x002f }
            if (r1 == r4) goto L_0x001b;
        L_0x001a:
            goto L_0x002d;
        L_0x001b:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x002b }
            r1 = r1.fileSystem;	 Catch:{ FileNotFoundException -> 0x002b }
            r3 = r4.entry;	 Catch:{ FileNotFoundException -> 0x002b }
            r3 = r3.cleanFiles;	 Catch:{ FileNotFoundException -> 0x002b }
            r5 = r3[r5];	 Catch:{ FileNotFoundException -> 0x002b }
            r5 = r1.source(r5);	 Catch:{ FileNotFoundException -> 0x002b }
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r5;	 Catch:{ all -> 0x002f }
        L_0x002b:
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r2;	 Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            return r2;	 Catch:{ all -> 0x002f }
        L_0x002f:
            r5 = move-exception;	 Catch:{ all -> 0x002f }
            monitor-exit(r0);	 Catch:{ all -> 0x002f }
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }

        public final okio.Sink newSink(int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r3.done;	 Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x000d;	 Catch:{ all -> 0x003f }
        L_0x0007:
            r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003f }
            r4.<init>();	 Catch:{ all -> 0x003f }
            throw r4;	 Catch:{ all -> 0x003f }
        L_0x000d:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x003f }
            if (r1 == r3) goto L_0x0019;	 Catch:{ all -> 0x003f }
        L_0x0013:
            r4 = okio.Okio.m28290a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x0019:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.readable;	 Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0024;	 Catch:{ all -> 0x003f }
        L_0x001f:
            r1 = r3.written;	 Catch:{ all -> 0x003f }
            r2 = 1;	 Catch:{ all -> 0x003f }
            r1[r4] = r2;	 Catch:{ all -> 0x003f }
        L_0x0024:
            r1 = r3.entry;	 Catch:{ all -> 0x003f }
            r1 = r1.dirtyFiles;	 Catch:{ all -> 0x003f }
            r4 = r1[r4];	 Catch:{ all -> 0x003f }
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0039 }
            r1 = r1.fileSystem;	 Catch:{ FileNotFoundException -> 0x0039 }
            r4 = r1.sink(r4);	 Catch:{ FileNotFoundException -> 0x0039 }
            r1 = new okhttp3.internal.cache.DiskLruCache$Editor$1;	 Catch:{ all -> 0x003f }
            r1.<init>(r4);	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r1;	 Catch:{ all -> 0x003f }
        L_0x0039:
            r4 = okio.Okio.m28290a();	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            return r4;	 Catch:{ all -> 0x003f }
        L_0x003f:
            r4 = move-exception;	 Catch:{ all -> 0x003f }
            monitor-exit(r0);	 Catch:{ all -> 0x003f }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        public final void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public final void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public final void abortUnlessCommitted() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            monitor-enter(r0);
            r1 = r3.done;	 Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013;	 Catch:{ all -> 0x0015 }
        L_0x0007:
            r1 = r3.entry;	 Catch:{ all -> 0x0015 }
            r1 = r1.currentEditor;	 Catch:{ all -> 0x0015 }
            if (r1 != r3) goto L_0x0013;
        L_0x000d:
            r1 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x0013 }
            r2 = 0;	 Catch:{ IOException -> 0x0013 }
            r1.completeEdit(r3, r2);	 Catch:{ IOException -> 0x0013 }
        L_0x0013:
            monitor-exit(r0);	 Catch:{ all -> 0x0015 }
            return;	 Catch:{ all -> 0x0015 }
        L_0x0015:
            r1 = move-exception;	 Catch:{ all -> 0x0015 }
            monitor-exit(r0);	 Catch:{ all -> 0x0015 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            str = stringBuilder.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                stringBuilder.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
                stringBuilder.setLength(str);
            }
        }

        final void setLengths(java.lang.String[] r5) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r5.length;
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r0 == r1) goto L_0x000c;
        L_0x0007:
            r5 = r4.invalidLengths(r5);
            throw r5;
        L_0x000c:
            r0 = 0;
        L_0x000d:
            r1 = r5.length;	 Catch:{ NumberFormatException -> 0x001e }
            if (r0 >= r1) goto L_0x001d;	 Catch:{ NumberFormatException -> 0x001e }
        L_0x0010:
            r1 = r4.lengths;	 Catch:{ NumberFormatException -> 0x001e }
            r2 = r5[r0];	 Catch:{ NumberFormatException -> 0x001e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x001e }
            r1[r0] = r2;	 Catch:{ NumberFormatException -> 0x001e }
            r0 = r0 + 1;
            goto L_0x000d;
        L_0x001d:
            return;
        L_0x001e:
            r5 = r4.invalidLengths(r5);
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Entry.setLengths(java.lang.String[]):void");
        }

        final void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long n : this.lengths) {
                bufferedSink.mo6775h(32).mo6786n(n);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        final okhttp3.internal.cache.DiskLruCache.Snapshot snapshot() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 != 0) goto L_0x000e;
        L_0x0008:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x000e:
            r0 = okhttp3.internal.cache.DiskLruCache.this;
            r0 = r0.valueCount;
            r0 = new okio.Source[r0];
            r1 = r10.lengths;
            r1 = r1.clone();
            r7 = r1;
            r7 = (long[]) r7;
            r8 = 0;
            r1 = r8;
        L_0x001f:
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.valueCount;	 Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 >= r2) goto L_0x0036;	 Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0025:
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.fileSystem;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r10.cleanFiles;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r3[r1];	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = r2.source(r3);	 Catch:{ FileNotFoundException -> 0x0044 }
            r0[r1] = r2;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1 = r1 + 1;	 Catch:{ FileNotFoundException -> 0x0044 }
            goto L_0x001f;	 Catch:{ FileNotFoundException -> 0x0044 }
        L_0x0036:
            r9 = new okhttp3.internal.cache.DiskLruCache$Snapshot;	 Catch:{ FileNotFoundException -> 0x0044 }
            r2 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ FileNotFoundException -> 0x0044 }
            r3 = r10.key;	 Catch:{ FileNotFoundException -> 0x0044 }
            r4 = r10.sequenceNumber;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1 = r9;	 Catch:{ FileNotFoundException -> 0x0044 }
            r6 = r0;	 Catch:{ FileNotFoundException -> 0x0044 }
            r1.<init>(r3, r4, r6, r7);	 Catch:{ FileNotFoundException -> 0x0044 }
            return r9;
        L_0x0044:
            r1 = okhttp3.internal.cache.DiskLruCache.this;
            r1 = r1.valueCount;
            if (r8 >= r1) goto L_0x0056;
        L_0x004a:
            r1 = r0[r8];
            if (r1 == 0) goto L_0x0056;
        L_0x004e:
            r1 = r0[r8];
            okhttp3.internal.Util.closeQuietly(r1);
            r8 = r8 + 1;
            goto L_0x0044;
        L_0x0056:
            r0 = okhttp3.internal.cache.DiskLruCache.this;	 Catch:{ IOException -> 0x005b }
            r0.removeEntry(r10);	 Catch:{ IOException -> 0x005b }
        L_0x005b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Entry.snapshot():okhttp3.internal.cache.DiskLruCache$Snapshot");
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int i) {
            return this.sources[i];
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public final void close() {
            for (Closeable closeQuietly : this.sources) {
                Util.closeQuietly(closeQuietly);
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
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (Throwable e) {
                    Platform platform = Platform.get();
                    StringBuilder stringBuilder = new StringBuilder("DiskLruCache ");
                    stringBuilder.append(this.directory);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    platform.log(5, stringBuilder.toString(), e);
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
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
    }

    private void readJournal() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.fileSystem;
        r1 = r8.journalFile;
        r0 = r0.source(r1);
        r0 = okio.Okio.m28289a(r0);
        r1 = r0.mo6788q();	 Catch:{ all -> 0x00ab }
        r2 = r0.mo6788q();	 Catch:{ all -> 0x00ab }
        r3 = r0.mo6788q();	 Catch:{ all -> 0x00ab }
        r4 = r0.mo6788q();	 Catch:{ all -> 0x00ab }
        r5 = r0.mo6788q();	 Catch:{ all -> 0x00ab }
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
        r2 = r0.mo6788q();	 Catch:{ EOFException -> 0x005c }
        r8.readJournalLine(r2);	 Catch:{ EOFException -> 0x005c }
        r1 = r1 + 1;
        goto L_0x0052;
    L_0x005c:
        r2 = r8.lruEntries;	 Catch:{ all -> 0x00ab }
        r2 = r2.size();	 Catch:{ all -> 0x00ab }
        r1 = r1 - r2;	 Catch:{ all -> 0x00ab }
        r8.redundantOpCount = r1;	 Catch:{ all -> 0x00ab }
        r1 = r0.mo6769d();	 Catch:{ all -> 0x00ab }
        if (r1 != 0) goto L_0x006f;	 Catch:{ all -> 0x00ab }
    L_0x006b:
        r8.rebuildJournal();	 Catch:{ all -> 0x00ab }
        goto L_0x0075;	 Catch:{ all -> 0x00ab }
    L_0x006f:
        r1 = r8.newJournalWriter();	 Catch:{ all -> 0x00ab }
        r8.journalWriter = r1;	 Catch:{ all -> 0x00ab }
    L_0x0075:
        okhttp3.internal.Util.closeQuietly(r0);
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
        okhttp3.internal.Util.closeQuietly(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.m28288a(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class cls = DiskLruCache.class;
            }

            protected void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
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
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            str = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(str);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
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
        this.fileSystem.delete(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(entry.cleanFiles[i]);
                    this.fileSystem.delete(entry.dirtyFiles[i]);
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
        BufferedSink a = Okio.m28288a(this.fileSystem.sink(this.journalFileTmp));
        try {
            a.mo6760b(MAGIC).mo6775h(10);
            a.mo6760b(VERSION_1).mo6775h(10);
            a.mo6786n((long) this.appVersion).mo6775h(10);
            a.mo6786n((long) this.valueCount).mo6775h(10);
            a.mo6775h(10);
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    a.mo6760b(DIRTY).mo6775h(32);
                    a.mo6760b(entry.key);
                    a.mo6775h(10);
                } else {
                    a.mo6760b(CLEAN).mo6775h(32);
                    a.mo6760b(entry.key);
                    entry.writeLengths(a);
                    a.mo6775h(10);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } finally {
            a.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
        r3 = this;
        monitor-enter(r3);
        r3.initialize();	 Catch:{ all -> 0x0050 }
        r3.checkNotClosed();	 Catch:{ all -> 0x0050 }
        r3.validateKey(r4);	 Catch:{ all -> 0x0050 }
        r0 = r3.lruEntries;	 Catch:{ all -> 0x0050 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0050 }
        r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0050 }
        r1 = 0;
        if (r0 == 0) goto L_0x004e;
    L_0x0015:
        r2 = r0.readable;	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x004e;
    L_0x001a:
        r0 = r0.snapshot();	 Catch:{ all -> 0x0050 }
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
        r1 = r1.mo6760b(r2);	 Catch:{ all -> 0x0050 }
        r2 = 32;
        r1 = r1.mo6775h(r2);	 Catch:{ all -> 0x0050 }
        r4 = r1.mo6760b(r4);	 Catch:{ all -> 0x0050 }
        r1 = 10;
        r4.mo6775h(r1);	 Catch:{ all -> 0x0050 }
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.initialize();	 Catch:{ all -> 0x0074 }
        r5.checkNotClosed();	 Catch:{ all -> 0x0074 }
        r5.validateKey(r6);	 Catch:{ all -> 0x0074 }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x0074 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0074 }
        r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0074 }
        r1 = -1;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r2 = 0;
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r3 = r0.sequenceNumber;	 Catch:{ all -> 0x0074 }
        r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r7 == 0) goto L_0x0023;
    L_0x0021:
        monitor-exit(r5);
        return r2;
    L_0x0023:
        if (r0 == 0) goto L_0x002b;
    L_0x0025:
        r7 = r0.currentEditor;	 Catch:{ all -> 0x0074 }
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
        r7 = r7.mo6760b(r8);	 Catch:{ all -> 0x0074 }
        r8 = 32;
        r7 = r7.mo6775h(r8);	 Catch:{ all -> 0x0074 }
        r7 = r7.mo6760b(r6);	 Catch:{ all -> 0x0074 }
        r8 = 10;
        r7.mo6775h(r8);	 Catch:{ all -> 0x0074 }
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
        r0 = new okhttp3.internal.cache.DiskLruCache$Entry;	 Catch:{ all -> 0x0074 }
        r0.<init>(r6);	 Catch:{ all -> 0x0074 }
        r7 = r5.lruEntries;	 Catch:{ all -> 0x0074 }
        r7.put(r6, r0);	 Catch:{ all -> 0x0074 }
    L_0x0062:
        r6 = new okhttp3.internal.cache.DiskLruCache$Editor;	 Catch:{ all -> 0x0074 }
        r6.<init>(r0);	 Catch:{ all -> 0x0074 }
        r0.currentEditor = r6;	 Catch:{ all -> 0x0074 }
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
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
    final synchronized void completeEdit(okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r10.entry;	 Catch:{ all -> 0x00f8 }
        r1 = r0.currentEditor;	 Catch:{ all -> 0x00f8 }
        if (r1 == r10) goto L_0x000d;
    L_0x0007:
        r10 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00f8 }
        r10.<init>();	 Catch:{ all -> 0x00f8 }
        throw r10;	 Catch:{ all -> 0x00f8 }
    L_0x000d:
        r1 = 0;
        if (r11 == 0) goto L_0x004a;
    L_0x0010:
        r2 = r0.readable;	 Catch:{ all -> 0x00f8 }
        if (r2 != 0) goto L_0x004a;
    L_0x0014:
        r2 = r1;
    L_0x0015:
        r3 = r9.valueCount;	 Catch:{ all -> 0x00f8 }
        if (r2 >= r3) goto L_0x004a;
    L_0x0019:
        r3 = r10.written;	 Catch:{ all -> 0x00f8 }
        r3 = r3[r2];	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0036;
    L_0x001f:
        r10.abort();	 Catch:{ all -> 0x00f8 }
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
        r4 = r0.dirtyFiles;	 Catch:{ all -> 0x00f8 }
        r4 = r4[r2];	 Catch:{ all -> 0x00f8 }
        r3 = r3.exists(r4);	 Catch:{ all -> 0x00f8 }
        if (r3 != 0) goto L_0x0047;
    L_0x0042:
        r10.abort();	 Catch:{ all -> 0x00f8 }
        monitor-exit(r9);
        return;
    L_0x0047:
        r2 = r2 + 1;
        goto L_0x0015;
    L_0x004a:
        r10 = r9.valueCount;	 Catch:{ all -> 0x00f8 }
        if (r1 >= r10) goto L_0x0082;
    L_0x004e:
        r10 = r0.dirtyFiles;	 Catch:{ all -> 0x00f8 }
        r10 = r10[r1];	 Catch:{ all -> 0x00f8 }
        if (r11 == 0) goto L_0x007a;
    L_0x0054:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r2 = r2.exists(r10);	 Catch:{ all -> 0x00f8 }
        if (r2 == 0) goto L_0x007f;
    L_0x005c:
        r2 = r0.cleanFiles;	 Catch:{ all -> 0x00f8 }
        r2 = r2[r1];	 Catch:{ all -> 0x00f8 }
        r3 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r3.rename(r10, r2);	 Catch:{ all -> 0x00f8 }
        r10 = r0.lengths;	 Catch:{ all -> 0x00f8 }
        r3 = r10[r1];	 Catch:{ all -> 0x00f8 }
        r10 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r5 = r10.size(r2);	 Catch:{ all -> 0x00f8 }
        r10 = r0.lengths;	 Catch:{ all -> 0x00f8 }
        r10[r1] = r5;	 Catch:{ all -> 0x00f8 }
        r7 = r9.size;	 Catch:{ all -> 0x00f8 }
        r7 = r7 - r3;
        r7 = r7 + r5;
        r9.size = r7;	 Catch:{ all -> 0x00f8 }
        goto L_0x007f;
    L_0x007a:
        r2 = r9.fileSystem;	 Catch:{ all -> 0x00f8 }
        r2.delete(r10);	 Catch:{ all -> 0x00f8 }
    L_0x007f:
        r1 = r1 + 1;
        goto L_0x004a;
    L_0x0082:
        r10 = r9.redundantOpCount;	 Catch:{ all -> 0x00f8 }
        r1 = 1;
        r10 = r10 + r1;
        r9.redundantOpCount = r10;	 Catch:{ all -> 0x00f8 }
        r10 = 0;
        r0.currentEditor = r10;	 Catch:{ all -> 0x00f8 }
        r10 = r0.readable;	 Catch:{ all -> 0x00f8 }
        r10 = r10 | r11;
        r2 = 10;
        r3 = 32;
        if (r10 == 0) goto L_0x00be;
    L_0x0094:
        r0.readable = r1;	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r1 = "CLEAN";
        r10 = r10.mo6760b(r1);	 Catch:{ all -> 0x00f8 }
        r10.mo6775h(r3);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r1 = r0.key;	 Catch:{ all -> 0x00f8 }
        r10.mo6760b(r1);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r0.writeLengths(r10);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r10.mo6775h(r2);	 Catch:{ all -> 0x00f8 }
        if (r11 == 0) goto L_0x00dc;
    L_0x00b4:
        r10 = r9.nextSequenceNumber;	 Catch:{ all -> 0x00f8 }
        r1 = 1;
        r1 = r1 + r10;
        r9.nextSequenceNumber = r1;	 Catch:{ all -> 0x00f8 }
        r0.sequenceNumber = r10;	 Catch:{ all -> 0x00f8 }
        goto L_0x00dc;
    L_0x00be:
        r10 = r9.lruEntries;	 Catch:{ all -> 0x00f8 }
        r11 = r0.key;	 Catch:{ all -> 0x00f8 }
        r10.remove(r11);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r11 = "REMOVE";
        r10 = r10.mo6760b(r11);	 Catch:{ all -> 0x00f8 }
        r10.mo6775h(r3);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r11 = r0.key;	 Catch:{ all -> 0x00f8 }
        r10.mo6760b(r11);	 Catch:{ all -> 0x00f8 }
        r10 = r9.journalWriter;	 Catch:{ all -> 0x00f8 }
        r10.mo6775h(r2);	 Catch:{ all -> 0x00f8 }
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
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
        r6 = (okhttp3.internal.cache.DiskLruCache.Entry) r6;	 Catch:{ all -> 0x0029 }
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    final boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.mo6760b(REMOVE).mo6775h(32).mo6760b(entry.key).mo6775h(10);
        this.lruEntries.remove(entry.key);
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
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
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
        this.fileSystem.deleteContents(this.directory);
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
        return new C21803();
    }
}
