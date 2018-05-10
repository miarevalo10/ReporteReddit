package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    static class CacheHeader {
        public long f2820a;
        public String f2821b;
        public String f2822c;
        public long f2823d;
        public long f2824e;
        public long f2825f;
        public long f2826g;
        public Map<String, String> f2827h;

        private CacheHeader() {
        }

        public CacheHeader(String str, Entry entry) {
            this.f2821b = str;
            this.f2820a = (long) entry.f2750a.length;
            this.f2822c = entry.f2751b;
            this.f2823d = entry.f2752c;
            this.f2824e = entry.f2753d;
            this.f2825f = entry.f2754e;
            this.f2826g = entry.f2755f;
            this.f2827h = entry.f2756g;
        }

        public static CacheHeader m2463a(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            cacheHeader.f2821b = DiskBasedCache.readString(inputStream);
            cacheHeader.f2822c = DiskBasedCache.readString(inputStream);
            if (cacheHeader.f2822c.equals("")) {
                cacheHeader.f2822c = null;
            }
            cacheHeader.f2823d = DiskBasedCache.readLong(inputStream);
            cacheHeader.f2824e = DiskBasedCache.readLong(inputStream);
            cacheHeader.f2825f = DiskBasedCache.readLong(inputStream);
            cacheHeader.f2826g = DiskBasedCache.readLong(inputStream);
            cacheHeader.f2827h = DiskBasedCache.readStringStringMap(inputStream);
            return cacheHeader;
        }

        public final boolean m2464a(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.f2821b);
                DiskBasedCache.writeString(outputStream, this.f2822c == null ? "" : this.f2822c);
                DiskBasedCache.writeLong(outputStream, this.f2823d);
                DiskBasedCache.writeLong(outputStream, this.f2824e);
                DiskBasedCache.writeLong(outputStream, this.f2825f);
                DiskBasedCache.writeLong(outputStream, this.f2826g);
                DiskBasedCache.writeStringStringMap(this.f2827h, outputStream);
                outputStream.flush();
                return true;
            } catch (OutputStream outputStream2) {
                VolleyLog.m2456b("%s", outputStream2.toString());
                return false;
            }
        }
    }

    private static class CountingInputStream extends FilterInputStream {
        private int f2828a;

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.f2828a = null;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f2828a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            bArr = super.read(bArr, i, i2);
            if (bArr != -1) {
                this.f2828a += bArr;
            }
            return bArr;
        }
    }

    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0;
        VolleyLog.m2456b("Cache cleared.", new Object[0]);
    }

    public synchronized com.android.volley.Cache.Entry get(java.lang.String r12) {
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
        r0 = r11.mEntries;	 Catch:{ all -> 0x00b1 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x00b1 }
        r0 = (com.android.volley.toolbox.DiskBasedCache.CacheHeader) r0;	 Catch:{ all -> 0x00b1 }
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r11);
        return r1;
    L_0x000e:
        r2 = r11.getFileForKey(r12);	 Catch:{ all -> 0x00b1 }
        r3 = 1;
        r4 = 2;
        r5 = 0;
        r6 = new com.android.volley.toolbox.DiskBasedCache$CountingInputStream;	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        r8 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        r8.<init>(r2);	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        r6.<init>(r7);	 Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
        com.android.volley.toolbox.DiskBasedCache.CacheHeader.m2463a(r6);	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r7 = r2.length();	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = r6.f2828a;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = (long) r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r7 = r7 - r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r7 = (int) r7;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r7 = streamToBytes(r6, r7);	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8 = new com.android.volley.Cache$Entry;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.<init>();	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2750a = r7;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r7 = r0.f2822c;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2751b = r7;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = r0.f2823d;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2752c = r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = r0.f2824e;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2753d = r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = r0.f2825f;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2754e = r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r9 = r0.f2826g;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2755f = r9;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r0 = r0.f2827h;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r8.f2756g = r0;	 Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
        r6.close();	 Catch:{ IOException -> 0x005a }
        monitor-exit(r11);
        return r8;
    L_0x005a:
        monitor-exit(r11);
        return r1;
    L_0x005c:
        r0 = move-exception;
        goto L_0x0065;
    L_0x005e:
        r0 = move-exception;
        goto L_0x0087;
    L_0x0060:
        r12 = move-exception;
        r6 = r1;
        goto L_0x00a8;
    L_0x0063:
        r0 = move-exception;
        r6 = r1;
    L_0x0065:
        r7 = "%s: %s";	 Catch:{ all -> 0x00a7 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00a7 }
        r2 = r2.getAbsolutePath();	 Catch:{ all -> 0x00a7 }
        r4[r5] = r2;	 Catch:{ all -> 0x00a7 }
        r0 = r0.toString();	 Catch:{ all -> 0x00a7 }
        r4[r3] = r0;	 Catch:{ all -> 0x00a7 }
        com.android.volley.VolleyLog.m2456b(r7, r4);	 Catch:{ all -> 0x00a7 }
        r11.remove(r12);	 Catch:{ all -> 0x00a7 }
        if (r6 == 0) goto L_0x0083;
    L_0x007d:
        r6.close();	 Catch:{ IOException -> 0x0081 }
        goto L_0x0083;
    L_0x0081:
        monitor-exit(r11);
        return r1;
    L_0x0083:
        monitor-exit(r11);
        return r1;
    L_0x0085:
        r0 = move-exception;
        r6 = r1;
    L_0x0087:
        r7 = "%s: %s";	 Catch:{ all -> 0x00a7 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00a7 }
        r2 = r2.getAbsolutePath();	 Catch:{ all -> 0x00a7 }
        r4[r5] = r2;	 Catch:{ all -> 0x00a7 }
        r0 = r0.toString();	 Catch:{ all -> 0x00a7 }
        r4[r3] = r0;	 Catch:{ all -> 0x00a7 }
        com.android.volley.VolleyLog.m2456b(r7, r4);	 Catch:{ all -> 0x00a7 }
        r11.remove(r12);	 Catch:{ all -> 0x00a7 }
        if (r6 == 0) goto L_0x00a5;
    L_0x009f:
        r6.close();	 Catch:{ IOException -> 0x00a3 }
        goto L_0x00a5;
    L_0x00a3:
        monitor-exit(r11);
        return r1;
    L_0x00a5:
        monitor-exit(r11);
        return r1;
    L_0x00a7:
        r12 = move-exception;
    L_0x00a8:
        if (r6 == 0) goto L_0x00b0;
    L_0x00aa:
        r6.close();	 Catch:{ IOException -> 0x00ae }
        goto L_0x00b0;
    L_0x00ae:
        monitor-exit(r11);
        return r1;
    L_0x00b0:
        throw r12;	 Catch:{ all -> 0x00b1 }
    L_0x00b1:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.get(java.lang.String):com.android.volley.Cache$Entry");
    }

    public synchronized void initialize() {
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
        monitor-enter(r8);
        r0 = r8.mRootDirectory;	 Catch:{ all -> 0x006e }
        r0 = r0.exists();	 Catch:{ all -> 0x006e }
        r1 = 0;	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x006e }
    L_0x000a:
        r0 = r8.mRootDirectory;	 Catch:{ all -> 0x006e }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x006e }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x006e }
        r2 = 1;	 Catch:{ all -> 0x006e }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x006e }
        r3 = r8.mRootDirectory;	 Catch:{ all -> 0x006e }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006e }
        r2[r1] = r3;	 Catch:{ all -> 0x006e }
        com.android.volley.VolleyLog.m2457c(r0, r2);	 Catch:{ all -> 0x006e }
    L_0x0022:
        monitor-exit(r8);
        return;
    L_0x0024:
        r0 = r8.mRootDirectory;	 Catch:{ all -> 0x006e }
        r0 = r0.listFiles();	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r8);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x006e }
    L_0x002f:
        if (r1 >= r2) goto L_0x006c;	 Catch:{ all -> 0x006e }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x006e }
        r4 = 0;
        r5 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0058 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0058 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x0058 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x0058 }
        r4 = com.android.volley.toolbox.DiskBasedCache.CacheHeader.m2463a(r5);	 Catch:{ IOException -> 0x0054, all -> 0x0051 }
        r6 = r3.length();	 Catch:{ IOException -> 0x0054, all -> 0x0051 }
        r4.f2820a = r6;	 Catch:{ IOException -> 0x0054, all -> 0x0051 }
        r6 = r4.f2821b;	 Catch:{ IOException -> 0x0054, all -> 0x0051 }
        r8.putEntry(r6, r4);	 Catch:{ IOException -> 0x0054, all -> 0x0051 }
        r5.close();	 Catch:{ IOException -> 0x0069 }
        goto L_0x0069;
    L_0x0051:
        r0 = move-exception;
        r4 = r5;
        goto L_0x005e;
    L_0x0054:
        r4 = r5;
        goto L_0x0058;
    L_0x0056:
        r0 = move-exception;
        goto L_0x005e;
    L_0x0058:
        if (r3 == 0) goto L_0x0064;
    L_0x005a:
        r3.delete();	 Catch:{ all -> 0x0056 }
        goto L_0x0064;
    L_0x005e:
        if (r4 == 0) goto L_0x0063;
    L_0x0060:
        r4.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0063:
        throw r0;	 Catch:{ all -> 0x006e }
    L_0x0064:
        if (r4 == 0) goto L_0x0069;
    L_0x0066:
        r4.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0069:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x006c:
        monitor-exit(r8);
        return;
    L_0x006e:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.initialize():void");
    }

    public synchronized void invalidate(String str, boolean z) {
        Entry entry = get(str);
        if (entry != null) {
            entry.f2755f = 0;
            if (z) {
                entry.f2754e = 0;
            }
            put(str, entry);
        }
    }

    public synchronized void put(java.lang.String r7, com.android.volley.Cache.Entry r8) {
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
        r6 = this;
        monitor-enter(r6);
        r0 = r8.f2750a;	 Catch:{ all -> 0x005a }
        r0 = r0.length;	 Catch:{ all -> 0x005a }
        r6.pruneIfNeeded(r0);	 Catch:{ all -> 0x005a }
        r0 = r6.getFileForKey(r7);	 Catch:{ all -> 0x005a }
        r1 = 0;
        r2 = 1;
        r3 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0045 }
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0045 }
        r4.<init>(r0);	 Catch:{ IOException -> 0x0045 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0045 }
        r4 = new com.android.volley.toolbox.DiskBasedCache$CacheHeader;	 Catch:{ IOException -> 0x0045 }
        r4.<init>(r7, r8);	 Catch:{ IOException -> 0x0045 }
        r5 = r4.m2464a(r3);	 Catch:{ IOException -> 0x0045 }
        if (r5 != 0) goto L_0x0038;	 Catch:{ IOException -> 0x0045 }
    L_0x0022:
        r3.close();	 Catch:{ IOException -> 0x0045 }
        r7 = "Failed to write header for %s";	 Catch:{ IOException -> 0x0045 }
        r8 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x0045 }
        r3 = r0.getAbsolutePath();	 Catch:{ IOException -> 0x0045 }
        r8[r1] = r3;	 Catch:{ IOException -> 0x0045 }
        com.android.volley.VolleyLog.m2456b(r7, r8);	 Catch:{ IOException -> 0x0045 }
        r7 = new java.io.IOException;	 Catch:{ IOException -> 0x0045 }
        r7.<init>();	 Catch:{ IOException -> 0x0045 }
        throw r7;	 Catch:{ IOException -> 0x0045 }
    L_0x0038:
        r8 = r8.f2750a;	 Catch:{ IOException -> 0x0045 }
        r3.write(r8);	 Catch:{ IOException -> 0x0045 }
        r3.close();	 Catch:{ IOException -> 0x0045 }
        r6.putEntry(r7, r4);	 Catch:{ IOException -> 0x0045 }
        monitor-exit(r6);
        return;
    L_0x0045:
        r7 = r0.delete();	 Catch:{ all -> 0x005a }
        if (r7 != 0) goto L_0x0058;	 Catch:{ all -> 0x005a }
    L_0x004b:
        r7 = "Could not clean up file %s";	 Catch:{ all -> 0x005a }
        r8 = new java.lang.Object[r2];	 Catch:{ all -> 0x005a }
        r0 = r0.getAbsolutePath();	 Catch:{ all -> 0x005a }
        r8[r1] = r0;	 Catch:{ all -> 0x005a }
        com.android.volley.VolleyLog.m2456b(r7, r8);	 Catch:{ all -> 0x005a }
    L_0x0058:
        monitor-exit(r6);
        return;
    L_0x005a:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.put(java.lang.String, com.android.volley.Cache$Entry):void");
    }

    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.m2456b("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(valueOf);
        stringBuilder.append(String.valueOf(str.substring(length).hashCode()));
        return stringBuilder.toString();
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    private void pruneIfNeeded(int i) {
        long j = (long) i;
        if (this.mTotalSize + j >= ((long) this.mMaxCacheSizeInBytes)) {
            if (VolleyLog.f2814b) {
                VolleyLog.m2454a("Pruning old cache entries.", new Object[0]);
            }
            long j2 = r0.mTotalSize;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = r0.mEntries.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                long j3;
                CacheHeader cacheHeader = (CacheHeader) ((Map.Entry) it.next()).getValue();
                if (getFileForKey(cacheHeader.f2821b).delete()) {
                    j3 = j;
                    r0.mTotalSize -= cacheHeader.f2820a;
                } else {
                    j3 = j;
                    VolleyLog.m2456b("Could not delete cache entry for key=%s, filename=%s", cacheHeader.f2821b, getFilenameForKey(cacheHeader.f2821b));
                }
                it.remove();
                i2++;
                if (((float) (r0.mTotalSize + j3)) < ((float) r0.mMaxCacheSizeInBytes) * HYSTERESIS_FACTOR) {
                    break;
                }
                j = j3;
            }
            if (VolleyLog.f2814b) {
                VolleyLog.m2454a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(r0.mTotalSize - j2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.f2820a - ((CacheHeader) this.mEntries.get(str)).f2820a;
        } else {
            this.mTotalSize += cacheHeader.f2820a;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = (CacheHeader) this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.f2820a;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes, read ");
        stringBuilder.append(i2);
        stringBuilder.append(" bytes");
        throw new IOException(stringBuilder.toString());
    }

    private static int read(InputStream inputStream) throws IOException {
        inputStream = inputStream.read();
        if (inputStream != -1) {
            return inputStream;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | ((((read(inputStream) << 0) | 0) | (read(inputStream) << 8)) | (read(inputStream) << 16));
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long readLong(InputStream inputStream) throws IOException {
        return (((((((((((long) read(inputStream)) & 255) << null) | 0) | ((((long) read(inputStream)) & 255) << 8)) | ((((long) read(inputStream)) & 255) << 16)) | ((((long) read(inputStream)) & 255) << 24)) | ((((long) read(inputStream)) & 255) << 32)) | ((((long) read(inputStream)) & 255) << 40)) | ((((long) read(inputStream)) & 255) << 48)) | ((255 & ((long) read(inputStream))) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        str = str.getBytes("UTF-8");
        writeLong(outputStream, (long) str.length);
        outputStream.write(str, 0, str.length);
    }

    static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            writeInt(outputStream, map.size());
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Map.Entry entry = (Map.Entry) map.next();
                writeString(outputStream, (String) entry.getKey());
                writeString(outputStream, (String) entry.getValue());
            }
            return;
        }
        writeInt(outputStream, null);
    }

    static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        int readInt = readInt(inputStream);
        Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            emptyMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return emptyMap;
    }
}
