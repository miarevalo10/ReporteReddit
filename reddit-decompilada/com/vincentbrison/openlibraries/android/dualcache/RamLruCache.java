package com.vincentbrison.openlibraries.android.dualcache;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class RamLruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    protected V create(K k) {
        return null;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public RamLruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r5 = new java.lang.NullPointerException;
        r0 = "key == null";
        r5.<init>(r0);
        throw r5;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.map;	 Catch:{ all -> 0x0059 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r5 = r4.hitCount;	 Catch:{ all -> 0x0059 }
        r5 = r5 + 1;
        r4.hitCount = r5;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        return r0;
    L_0x001b:
        r0 = r4.missCount;	 Catch:{ all -> 0x0059 }
        r0 = r0 + 1;
        r4.missCount = r0;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        r0 = r4.create(r5);
        if (r0 != 0) goto L_0x002a;
    L_0x0028:
        r5 = 0;
        return r5;
    L_0x002a:
        monitor-enter(r4);
        r1 = r4.createCount;	 Catch:{ all -> 0x0056 }
        r1 = r1 + 1;
        r4.createCount = r1;	 Catch:{ all -> 0x0056 }
        r1 = r4.map;	 Catch:{ all -> 0x0056 }
        r1 = r1.put(r5, r0);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x003f;
    L_0x0039:
        r2 = r4.map;	 Catch:{ all -> 0x0056 }
        r2.put(r5, r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0048;
    L_0x003f:
        r2 = r4.size;	 Catch:{ all -> 0x0056 }
        r3 = r4.safeSizeOf(r5, r0);	 Catch:{ all -> 0x0056 }
        r2 = r2 + r3;
        r4.size = r2;	 Catch:{ all -> 0x0056 }
    L_0x0048:
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0050;
    L_0x004b:
        r2 = 0;
        r4.entryRemoved(r2, r5, r0, r1);
        return r1;
    L_0x0050:
        r5 = r4.maxSize;
        r4.trimToSize(r5);
        return r0;
    L_0x0056:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        throw r5;
    L_0x0059:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vincentbrison.openlibraries.android.dualcache.RamLruCache.get(java.lang.Object):V");
    }

    public final V put(K k, V v) {
        if (k != null) {
            if (v != null) {
                V put;
                synchronized (this) {
                    this.putCount++;
                    this.size += safeSizeOf(k, v);
                    put = this.map.put(k, v);
                    if (put != null) {
                        this.size -= safeSizeOf(k, put);
                    }
                }
                if (put != null) {
                    entryRemoved(false, k, put, v);
                }
                trimToSize(this.maxSize);
                return put;
            }
        }
        throw new NullPointerException("key == null || value == null");
    }

    public void trimToSize(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.size >= 0) {
                    if (this.map.isEmpty() && this.size != 0) {
                        break;
                    } else if (this.size <= i) {
                        return;
                    } else {
                        Entry entry;
                        try {
                            entry = (Entry) this.map.getClass().getMethod("eldest", new Class[0]).invoke(this.map, new Object[0]);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                            entry = null;
                            if (entry != null) {
                                key = entry.getKey();
                                value = entry.getValue();
                                this.map.remove(key);
                                this.size -= safeSizeOf(key, value);
                                this.evictionCount++;
                                entryRemoved(true, key, value, null);
                            } else {
                                return;
                            }
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                            entry = null;
                            if (entry != null) {
                                return;
                            }
                            key = entry.getKey();
                            value = entry.getValue();
                            this.map.remove(key);
                            this.size -= safeSizeOf(key, value);
                            this.evictionCount++;
                            entryRemoved(true, key, value, null);
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                            entry = null;
                            if (entry != null) {
                                key = entry.getKey();
                                value = entry.getValue();
                                this.map.remove(key);
                                this.size -= safeSizeOf(key, value);
                                this.evictionCount++;
                                entryRemoved(true, key, value, null);
                            } else {
                                return;
                            }
                        }
                        if (entry != null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                }
                break;
            }
            entryRemoved(true, key, value, null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(".sizeOf() is reporting inconsistent results!");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final V remove(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        return remove;
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        StringBuilder stringBuilder = new StringBuilder("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        i = i != 0 ? (100 * this.hitCount) / i : 0;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
    }
}
