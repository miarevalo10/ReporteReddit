package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.upstream.cache.Cache.Listener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public final class SimpleCache implements Cache {
    private final File cacheDir;
    private final CacheEvictor evictor;
    private final CachedContentIndex index;
    private CacheException initializationException;
    private final HashMap<String, ArrayList<Listener>> listeners;
    private final HashMap<String, CacheSpan> lockedSpans;
    private long totalSpace;

    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr, boolean z) {
        this(file, cacheEvictor, new CachedContentIndex(file, bArr, z));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex) {
        this.totalSpace = 0;
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.lockedSpans = new HashMap();
        this.index = cachedContentIndex;
        this.listeners = new HashMap();
        file = new ConditionVariable();
        new Thread(this, "SimpleCache.initialize()") {
            final /* synthetic */ SimpleCache f5211b;

            public void run() {
                synchronized (this.f5211b) {
                    file.open();
                    try {
                        this.f5211b.initialize();
                    } catch (CacheException e) {
                        this.f5211b.initializationException = e;
                    }
                    this.f5211b.evictor;
                }
            }
        }.start();
        file.block();
    }

    public final synchronized NavigableSet<CacheSpan> addListener(String str, Listener listener) {
        ArrayList arrayList = (ArrayList) this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    public final synchronized void removeListener(String str, Listener listener) {
        ArrayList arrayList = (ArrayList) this.listeners.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty() != null) {
                this.listeners.remove(str);
            }
        }
    }

    public final synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        str = this.index.m4176b(str);
        if (str != null) {
            if (!str.f5200c.isEmpty()) {
                return new TreeSet(str.f5200c);
            }
        }
        return null;
    }

    public final synchronized Set<String> getKeys() {
        return new HashSet(this.index.f5202a.keySet());
    }

    public final synchronized long getCacheSpace() {
        return this.totalSpace;
    }

    public final synchronized SimpleCacheSpan startReadWrite(String str, long j) throws InterruptedException, CacheException {
        SimpleCacheSpan startReadWriteNonBlocking;
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    public final synchronized SimpleCacheSpan startReadWriteNonBlocking(String str, long j) throws CacheException {
        if (this.initializationException != null) {
            throw this.initializationException;
        }
        j = getSpan(str, j);
        if (j.d) {
            str = this.index.m4176b(str);
            Assertions.m4186b(str.f5200c.remove(j));
            int i = str.f5198a;
            Assertions.m4186b(j.d);
            long currentTimeMillis = System.currentTimeMillis();
            CacheSpan simpleCacheSpan = new SimpleCacheSpan(j.a, j.b, j.c, currentTimeMillis, SimpleCacheSpan.m12712a(j.e.getParentFile(), i, j.b, currentTimeMillis));
            if (j.e.renameTo(simpleCacheSpan.e)) {
                str.f5200c.add(simpleCacheSpan);
                notifySpanTouched(j, simpleCacheSpan);
                return simpleCacheSpan;
            }
            StringBuilder stringBuilder = new StringBuilder("Renaming of ");
            stringBuilder.append(j.e);
            stringBuilder.append(" to ");
            stringBuilder.append(simpleCacheSpan.e);
            stringBuilder.append(" failed.");
            throw new CacheException(stringBuilder.toString());
        } else if (this.lockedSpans.containsKey(str)) {
            return null;
        } else {
            this.lockedSpans.put(str, j);
            return j;
        }
    }

    public final synchronized File startFile(String str, long j, long j2) throws CacheException {
        Assertions.m4186b(this.lockedSpans.containsKey(str));
        if (this.cacheDir.exists() == null) {
            removeStaleSpansAndCachedContents();
            this.cacheDir.mkdirs();
        }
        return SimpleCacheSpan.m12712a(this.cacheDir, this.index.m4178c(str), j, System.currentTimeMillis());
    }

    public final synchronized void commitFile(File file) throws CacheException {
        SimpleCacheSpan a = SimpleCacheSpan.m12709a(file, this.index);
        boolean z = false;
        Assertions.m4186b(a != null);
        Assertions.m4186b(this.lockedSpans.containsKey(a.a));
        if (!file.exists()) {
            return;
        }
        if (file.length() == 0) {
            file.delete();
            return;
        }
        file = Long.valueOf(getContentLength(a.a));
        if (file.longValue() != -1) {
            if (a.b + a.c <= file.longValue()) {
                z = true;
            }
            Assertions.m4186b(z);
        }
        addSpan(a);
        this.index.m4175a();
        notifyAll();
    }

    public final synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.m4186b(cacheSpan == this.lockedSpans.remove(cacheSpan.f5192a) ? true : null);
        notifyAll();
    }

    private SimpleCacheSpan getSpan(String str, long j) throws CacheException {
        CachedContent b = this.index.m4176b(str);
        if (b == null) {
            return SimpleCacheSpan.m12713b(str, j);
        }
        while (true) {
            str = b.m4170a(j);
            if (!str.d || str.e.exists()) {
                return str;
            }
            removeStaleSpansAndCachedContents();
        }
        return str;
    }

    private void initialize() throws CacheException {
        if (this.cacheDir.exists()) {
            CachedContentIndex cachedContentIndex = this.index;
            Assertions.m4186b(cachedContentIndex.f5205d ^ 1);
            if (!cachedContentIndex.m4179c()) {
                AtomicFile atomicFile = cachedContentIndex.f5204c;
                atomicFile.f5214a.delete();
                atomicFile.f5215b.delete();
                cachedContentIndex.f5202a.clear();
                cachedContentIndex.f5203b.clear();
            }
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.getName().equals("cached_content_index.exi")) {
                        SimpleCacheSpan a = file.length() > 0 ? SimpleCacheSpan.m12709a(file, this.index) : null;
                        if (a != null) {
                            addSpan(a);
                        } else {
                            file.delete();
                        }
                    }
                }
                this.index.m4177b();
                this.index.m4175a();
                return;
            }
            return;
        }
        this.cacheDir.mkdirs();
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.index.m4173a(simpleCacheSpan.a).f5200c.add(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.c;
        notifySpanAdded(simpleCacheSpan);
    }

    private void removeSpan(CacheSpan cacheSpan, boolean z) throws CacheException {
        CachedContent b = this.index.m4176b(cacheSpan.f5192a);
        if (b != null) {
            Object obj;
            if (b.f5200c.remove(cacheSpan)) {
                cacheSpan.f5196e.delete();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.totalSpace -= cacheSpan.f5194c;
                if (z) {
                    try {
                        if (b.f5200c.isEmpty()) {
                            this.index.m4180d(b.f5199b);
                            this.index.m4175a();
                        }
                    } catch (Throwable th) {
                        notifySpanRemoved(cacheSpan);
                    }
                }
                notifySpanRemoved(cacheSpan);
            }
        }
    }

    public final synchronized void removeSpan(CacheSpan cacheSpan) throws CacheException {
        removeSpan(cacheSpan, true);
    }

    private void removeStaleSpansAndCachedContents() throws CacheException {
        LinkedList linkedList = new LinkedList();
        for (CachedContent cachedContent : this.index.f5202a.values()) {
            Iterator it = cachedContent.f5200c.iterator();
            while (it.hasNext()) {
                CacheSpan cacheSpan = (CacheSpan) it.next();
                if (!cacheSpan.f5196e.exists()) {
                    linkedList.add(cacheSpan);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            removeSpan((CacheSpan) it2.next(), false);
        }
        this.index.m4177b();
        this.index.m4175a();
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList arrayList = (ArrayList) this.listeners.get(cacheSpan.f5192a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = (ArrayList) this.listeners.get(simpleCacheSpan.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = (ArrayList) this.listeners.get(simpleCacheSpan.a);
        if (arrayList != null) {
            for (cacheSpan = arrayList.size() - 1; cacheSpan >= null; cacheSpan--) {
                arrayList.get(cacheSpan);
            }
        }
    }

    public final synchronized boolean isCached(String str, long j, long j2) {
        str = this.index.m4176b(str);
        str = (str == null || str.m4169a(j, j2) < j2) ? null : true;
        return str;
    }

    public final synchronized long getCachedBytes(String str, long j, long j2) {
        str = this.index.m4176b(str);
        if (str != null) {
            return str.m4169a(j, j2);
        }
        return -j2;
    }

    public final synchronized void setContentLength(String str, long j) throws CacheException {
        CachedContentIndex cachedContentIndex = this.index;
        CachedContent b = cachedContentIndex.m4176b(str);
        if (b == null) {
            cachedContentIndex.m4174a(str, j);
        } else if (b.f5201d != j) {
            b.f5201d = j;
            cachedContentIndex.f5205d = true;
        }
        this.index.m4175a();
    }

    public final synchronized long getContentLength(String str) {
        str = this.index.m4176b(str);
        if (str == null) {
            return -1;
        }
        return str.f5201d;
    }
}
