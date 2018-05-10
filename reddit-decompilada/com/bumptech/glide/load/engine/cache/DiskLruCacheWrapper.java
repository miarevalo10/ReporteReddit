package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    private final SafeKeyGenerator f12503a;
    private final File f12504b;
    private final long f12505c;
    private final DiskCacheWriteLocker f12506d = new DiskCacheWriteLocker();
    private DiskLruCache f12507e;

    public static DiskCache m11424a(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    private DiskLruCacheWrapper(File file, long j) {
        this.f12504b = file;
        this.f12505c = j;
        this.f12503a = new SafeKeyGenerator();
    }

    private synchronized DiskLruCache m11423a() throws IOException {
        if (this.f12507e == null) {
            this.f12507e = DiskLruCache.open(this.f12504b, 1, 1, this.f12505c);
        }
        return this.f12507e;
    }

    public File get(Key key) {
        String a = this.f12503a.m2977a(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            StringBuilder stringBuilder = new StringBuilder("Get: Obtained: ");
            stringBuilder.append(a);
            stringBuilder.append(" for for Key: ");
            stringBuilder.append(key);
            Log.v("DiskLruCacheWrapper", stringBuilder.toString());
        }
        try {
            Value value = m11423a().get(a);
            if (value != null) {
                return value.f3268a[0];
            }
            return null;
        } catch (Throwable e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    public void put(Key key, Writer writer) {
        WriteLock writeLock;
        String a = this.f12503a.m2977a(key);
        DiskCacheWriteLocker diskCacheWriteLocker = this.f12506d;
        synchronized (diskCacheWriteLocker) {
            writeLock = (WriteLock) diskCacheWriteLocker.f3453a.get(a);
            if (writeLock == null) {
                writeLock = diskCacheWriteLocker.f3454b.m2968a();
                diskCacheWriteLocker.f3453a.put(a, writeLock);
            }
            writeLock.f3451b++;
        }
        writeLock.f3450a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                StringBuilder stringBuilder = new StringBuilder("Put: Obtained: ");
                stringBuilder.append(a);
                stringBuilder.append(" for for Key: ");
                stringBuilder.append(key);
                Log.v("DiskLruCacheWrapper", stringBuilder.toString());
            }
            try {
                key = m11423a();
                if (key.get(a) == null) {
                    key = key.edit(a);
                    if (key == null) {
                        writer = new StringBuilder("Had two simultaneous puts for: ");
                        writer.append(a);
                        throw new IllegalStateException(writer.toString());
                    }
                    if (writer.mo906a(key.m2797a()) != null) {
                        key.f3257b.completeEdit(key, true);
                        key.f3256a = true;
                    }
                    key.m2799c();
                    this.f12506d.m2969a(a);
                }
            } catch (Key key2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5) != null) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", key2);
                }
            } catch (Throwable th) {
                key2.m2799c();
            }
        } finally {
            this.f12506d.m2969a(a);
        }
    }

    public void delete(Key key) {
        try {
            m11423a().remove(this.f12503a.m2977a(key));
        } catch (Key key2) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", key2);
            }
        }
    }

    public synchronized void clear() {
        try {
            m11423a().delete();
            m11425b();
        } catch (Throwable e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e);
                }
                m11425b();
            } catch (Throwable th) {
                m11425b();
            }
        }
    }

    private synchronized void m11425b() {
        this.f12507e = null;
    }
}
