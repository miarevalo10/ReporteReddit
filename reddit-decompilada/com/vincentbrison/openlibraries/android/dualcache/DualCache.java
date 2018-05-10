package com.vincentbrison.openlibraries.android.dualcache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Entry;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.jakewharton.disklrucache.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DualCache<T> {
    private static final int VALUES_PER_CACHE_ENTRY = 1;
    private final int appVersion;
    private final File diskCacheFolder;
    private DiskLruCache diskLruCache;
    private final DualCacheDiskMode diskMode;
    private final DiskCacheSerializer<T> diskSerializer;
    private final DualCacheLock dualCacheLock = new DualCacheLock();
    private final Logger logger;
    private final LoggerHelper loggerHelper;
    private final int maxDiskSizeBytes;
    private final RamLruCache ramCacheLru;
    private final DualCacheRamMode ramMode;
    private final CacheSerializer<T> ramSerializer;

    static /* synthetic */ class C20961 {
        static final /* synthetic */ int[] f24308b = new int[DualCacheDiskMode.values().length];

        static {
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
            r0 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.values();
            r0 = r0.length;
            r0 = new int[r0];
            f24308b = r0;
            r0 = 1;
            r1 = f24308b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.vincentbrison.openlibraries.android.dualcache.DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.values();
            r1 = r1.length;
            r1 = new int[r1];
            f24307a = r1;
            r1 = f24307a;	 Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER;	 Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0027 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            r0 = f24307a;	 Catch:{ NoSuchFieldError -> 0x0032 }
            r1 = com.vincentbrison.openlibraries.android.dualcache.DualCacheRamMode.ENABLE_WITH_REFERENCE;	 Catch:{ NoSuchFieldError -> 0x0032 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0032 }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x0032 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0032 }
        L_0x0032:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.DualCache.1.<clinit>():void");
        }
    }

    DualCache(int i, Logger logger, DualCacheRamMode dualCacheRamMode, CacheSerializer<T> cacheSerializer, int i2, SizeOf<T> sizeOf, DualCacheDiskMode dualCacheDiskMode, DiskCacheSerializer<T> diskCacheSerializer, int i3, File file) {
        this.appVersion = i;
        this.ramMode = dualCacheRamMode;
        this.ramSerializer = cacheSerializer;
        this.diskMode = dualCacheDiskMode;
        this.diskSerializer = diskCacheSerializer;
        this.diskCacheFolder = file;
        this.logger = logger;
        this.loggerHelper = new LoggerHelper(logger);
        switch (dualCacheRamMode) {
            case ENABLE_WITH_SPECIFIC_SERIALIZER:
                this.ramCacheLru = new StringLruCache(i2);
                break;
            case ENABLE_WITH_REFERENCE:
                this.ramCacheLru = new ReferenceLruCache(i2, sizeOf);
                break;
            default:
                this.ramCacheLru = 0;
                break;
        }
        if (C20961.f24308b[dualCacheDiskMode.ordinal()] != 1) {
            this.maxDiskSizeBytes = 0;
            return;
        }
        this.maxDiskSizeBytes = i3;
        try {
            openDiskLruCache(file);
        } catch (Throwable e) {
            logger.m26011a(e);
        }
    }

    private void openDiskLruCache(File file) throws IOException {
        this.diskLruCache = DiskLruCache.open(file, this.appVersion, 1, (long) this.maxDiskSizeBytes);
    }

    public long getRamUsedInBytes() {
        if (this.ramCacheLru == null) {
            return -1;
        }
        return (long) this.ramCacheLru.size();
    }

    public long getDiskUsedInBytes() {
        if (this.diskLruCache == null) {
            return -1;
        }
        return this.diskLruCache.size();
    }

    public DualCacheRamMode getRAMMode() {
        return this.ramMode;
    }

    public DualCacheDiskMode getDiskMode() {
        return this.diskMode;
    }

    public void put(String str, T t) {
        String b;
        Throwable th;
        Throwable e;
        if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
            this.ramCacheLru.put(str, t);
        }
        Closeable closeable = null;
        if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
            b = this.ramSerializer.m26002b();
            this.ramCacheLru.put(str, b);
        } else {
            b = null;
        }
        if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
            try {
                this.dualCacheLock.m26007a(str);
                Editor edit = this.diskLruCache.edit(str);
                if (this.ramSerializer == this.diskSerializer) {
                    try {
                        t = new OutputStreamWriter(edit.a(), Util.b);
                        try {
                            t.write(b);
                            Util.a(t);
                        } catch (Throwable th2) {
                            th = th2;
                            Util.a(t);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        t = null;
                        Util.a(t);
                        throw th;
                    }
                }
                OutputStream a = edit.a();
                try {
                    this.diskSerializer.m26004a(a, t);
                    closeable = a;
                } catch (IOException e2) {
                    e = e2;
                    closeable = a;
                    try {
                        this.logger.m26011a(e);
                        this.dualCacheLock.m26008b(str);
                        IOUtil.m26009a(closeable);
                    } catch (Throwable th4) {
                        t = th4;
                        this.dualCacheLock.m26008b(str);
                        IOUtil.m26009a(closeable);
                        throw t;
                    }
                } catch (Throwable th5) {
                    t = th5;
                    closeable = a;
                    this.dualCacheLock.m26008b(str);
                    IOUtil.m26009a(closeable);
                    throw t;
                }
                if (edit.b != null) {
                    DiskLruCache.access$2200(edit.d, edit, false);
                    edit.d.remove(Entry.d(edit.a));
                } else {
                    DiskLruCache.access$2200(edit.d, edit, true);
                }
                edit.c = true;
            } catch (IOException e3) {
                e = e3;
                this.logger.m26011a(e);
                this.dualCacheLock.m26008b(str);
                IOUtil.m26009a(closeable);
            }
            this.dualCacheLock.m26008b(str);
            IOUtil.m26009a(closeable);
        }
    }

    public T get(String str) {
        T t;
        Logger logger;
        StringBuilder stringBuilder;
        Snapshot snapshot;
        Logger logger2;
        StringBuilder stringBuilder2;
        Closeable closeable;
        T a;
        boolean equals = this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER);
        boolean equals2 = this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE);
        if (!equals) {
            if (!equals2) {
                t = null;
                if (t != null) {
                    logger = this.loggerHelper.f24319a;
                    stringBuilder = new StringBuilder("Entry for ");
                    stringBuilder.append(str);
                    stringBuilder.append(" is not in RAM.");
                    logger.m26010a(stringBuilder.toString());
                    if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                        try {
                            this.dualCacheLock.m26007a(str);
                            snapshot = this.diskLruCache.get(str);
                        } catch (Throwable e) {
                            this.logger.m26011a(e);
                            snapshot = null;
                            if (snapshot != null) {
                                logger2 = this.loggerHelper.f24319a;
                                stringBuilder2 = new StringBuilder("Entry for ");
                                stringBuilder2.append(str);
                                stringBuilder2.append(" is on disk.");
                                logger2.m26010a(stringBuilder2.toString());
                                closeable = snapshot.a[0];
                                try {
                                    a = this.diskSerializer.m26003a(closeable);
                                } catch (IOException e2) {
                                    a = e2;
                                    this.logger.m26011a((Throwable) a);
                                } finally {
                                    IOUtil.m26009a(closeable);
                                }
                                if (a != null) {
                                    if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                                        if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                            this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                                        }
                                    } else if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                        this.ramCacheLru.put(str, a);
                                    }
                                    return a;
                                }
                                return null;
                            }
                            logger = this.loggerHelper.f24319a;
                            stringBuilder = new StringBuilder("Entry for ");
                            stringBuilder.append(str);
                            stringBuilder.append(" is not on disk.");
                            logger.m26010a(stringBuilder.toString());
                            a = null;
                            if (a != null) {
                                if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                                    if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                        this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                                    }
                                } else if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                    this.ramCacheLru.put(str, a);
                                }
                                return a;
                            }
                            return null;
                        } finally {
                            this.dualCacheLock.m26008b(str);
                        }
                        if (snapshot != null) {
                            logger2 = this.loggerHelper.f24319a;
                            stringBuilder2 = new StringBuilder("Entry for ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(" is on disk.");
                            logger2.m26010a(stringBuilder2.toString());
                            closeable = snapshot.a[0];
                            a = this.diskSerializer.m26003a(closeable);
                            if (a != null) {
                                if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                                    if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                        this.ramCacheLru.put(str, a);
                                    }
                                } else if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                    this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                                }
                                return a;
                            }
                        }
                        logger = this.loggerHelper.f24319a;
                        stringBuilder = new StringBuilder("Entry for ");
                        stringBuilder.append(str);
                        stringBuilder.append(" is not on disk.");
                        logger.m26010a(stringBuilder.toString());
                    }
                    a = null;
                    if (a != null) {
                        if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                            if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                                this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                            }
                        } else if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                            this.ramCacheLru.put(str, a);
                        }
                        return a;
                    }
                }
                logger2 = this.loggerHelper.f24319a;
                stringBuilder2 = new StringBuilder("Entry for ");
                stringBuilder2.append(str);
                stringBuilder2.append(" is in RAM.");
                logger2.m26010a(stringBuilder2.toString());
                if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE) != null) {
                    return t;
                }
                if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER) != null) {
                    return this.ramSerializer.m26001a();
                }
                return null;
            }
        }
        t = this.ramCacheLru.get(str);
        if (t != null) {
            logger2 = this.loggerHelper.f24319a;
            stringBuilder2 = new StringBuilder("Entry for ");
            stringBuilder2.append(str);
            stringBuilder2.append(" is in RAM.");
            logger2.m26010a(stringBuilder2.toString());
            if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE) != null) {
                return t;
            }
            if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER) != null) {
                return this.ramSerializer.m26001a();
            }
        }
        logger = this.loggerHelper.f24319a;
        stringBuilder = new StringBuilder("Entry for ");
        stringBuilder.append(str);
        stringBuilder.append(" is not in RAM.");
        logger.m26010a(stringBuilder.toString());
        if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
            this.dualCacheLock.m26007a(str);
            snapshot = this.diskLruCache.get(str);
            if (snapshot != null) {
                logger = this.loggerHelper.f24319a;
                stringBuilder = new StringBuilder("Entry for ");
                stringBuilder.append(str);
                stringBuilder.append(" is not on disk.");
                logger.m26010a(stringBuilder.toString());
            } else {
                logger2 = this.loggerHelper.f24319a;
                stringBuilder2 = new StringBuilder("Entry for ");
                stringBuilder2.append(str);
                stringBuilder2.append(" is on disk.");
                logger2.m26010a(stringBuilder2.toString());
                closeable = snapshot.a[0];
                a = this.diskSerializer.m26003a(closeable);
                if (a != null) {
                    if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                        if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                            this.ramCacheLru.put(str, a);
                        }
                    } else if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                        this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                    }
                    return a;
                }
            }
        }
        a = null;
        if (a != null) {
            if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_REFERENCE)) {
                if (this.ramMode.equals(DualCacheRamMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                    this.ramCacheLru.put(str, this.ramSerializer.m26002b());
                }
            } else if (this.diskMode.equals(DualCacheDiskMode.ENABLE_WITH_SPECIFIC_SERIALIZER)) {
                this.ramCacheLru.put(str, a);
            }
            return a;
        }
        return null;
    }

    public void delete(String str) {
        if (!this.ramMode.equals(DualCacheRamMode.DISABLE)) {
            this.ramCacheLru.remove(str);
        }
        if (!this.diskMode.equals(DualCacheDiskMode.DISABLE)) {
            try {
                this.dualCacheLock.m26007a(str);
                this.diskLruCache.remove(str);
            } catch (Throwable e) {
                this.logger.m26011a(e);
            } catch (Throwable th) {
                this.dualCacheLock.m26008b(str);
            }
            this.dualCacheLock.m26008b(str);
        }
    }

    public void invalidate() {
        invalidateDisk();
        invalidateRAM();
    }

    public void invalidateRAM() {
        if (!this.ramMode.equals(DualCacheRamMode.DISABLE)) {
            this.ramCacheLru.evictAll();
        }
    }

    public void invalidateDisk() {
        if (!this.diskMode.equals(DualCacheDiskMode.DISABLE)) {
            try {
                this.dualCacheLock.f24312a.writeLock().lock();
                this.diskLruCache.delete();
                openDiskLruCache(this.diskCacheFolder);
            } catch (Throwable e) {
                this.logger.m26011a(e);
            } catch (Throwable th) {
                this.dualCacheLock.m26006a();
            }
            this.dualCacheLock.m26006a();
        }
    }

    public boolean contains(String str) {
        if (!this.ramMode.equals(DualCacheRamMode.DISABLE) && this.ramCacheLru.snapshot().containsKey(str)) {
            return true;
        }
        try {
            this.dualCacheLock.m26007a(str);
            if (!(this.diskMode.equals(DualCacheDiskMode.DISABLE) || this.diskLruCache.get(str) == null)) {
                this.dualCacheLock.m26008b(str);
                return true;
            }
        } catch (Throwable e) {
            this.logger.m26011a(e);
        } catch (Throwable th) {
            this.dualCacheLock.m26008b(str);
        }
        this.dualCacheLock.m26008b(str);
        return null;
    }
}
