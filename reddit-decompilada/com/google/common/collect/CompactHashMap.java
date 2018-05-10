package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    transient long[] f8401a;
    transient Object[] f8402b;
    transient Object[] f8403c;
    transient float f8404d;
    transient int f8405e;
    transient int f8406f;
    private transient int[] f8407g;
    private transient int f8408h;
    private transient Set<K> f8409i;
    private transient Set<Entry<K, V>> f8410j;
    private transient Collection<V> f8411k;

    class EntrySetView extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ CompactHashMap f8394a;

        EntrySetView(CompactHashMap compactHashMap) {
            this.f8394a = compactHashMap;
        }

        public int size() {
            return this.f8394a.f8406f;
        }

        public void clear() {
            this.f8394a.clear();
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C11722(this.f8394a);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f8394a.m7091a(entry.getKey());
            if (a == -1 || Objects.m14557a(this.f8394a.f8403c[a], entry.getValue()) == null) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                int a = this.f8394a.m7091a(entry.getKey());
                if (!(a == -1 || Objects.m14557a(this.f8394a.f8403c[a], entry.getValue()) == null)) {
                    this.f8394a.m7095a(this.f8394a.f8402b[a], (int) (this.f8394a.f8401a[a] >>> 32));
                    return true;
                }
            }
            return null;
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        int f8395b;
        int f8396c;
        int f8397d;
        final /* synthetic */ CompactHashMap f8398e;

        abstract T mo2390a(int i);

        private Itr(CompactHashMap compactHashMap) {
            this.f8398e = compactHashMap;
            this.f8395b = this.f8398e.f8405e;
            this.f8396c = this.f8398e.isEmpty() != null ? -1 : null;
            this.f8397d = -1;
        }

        public boolean hasNext() {
            return this.f8396c >= 0;
        }

        public T next() {
            m7086a();
            if (hasNext()) {
                this.f8397d = this.f8396c;
                T a = mo2390a(this.f8396c);
                int i = this.f8396c + 1;
                if (i >= this.f8398e.f8406f) {
                    i = -1;
                }
                this.f8396c = i;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            m7086a();
            CollectPreconditions.m7082a(this.f8397d >= 0);
            this.f8395b++;
            this.f8398e.m7095a(this.f8398e.f8402b[this.f8397d], (int) (this.f8398e.f8401a[this.f8397d] >>> 32));
            this.f8396c = CompactHashMap.m7088a(this.f8396c);
            this.f8397d = -1;
        }

        private void m7086a() {
            if (this.f8398e.f8405e != this.f8395b) {
                throw new ConcurrentModificationException();
            }
        }
    }

    class KeySetView extends AbstractSet<K> {
        final /* synthetic */ CompactHashMap f8399a;

        KeySetView(CompactHashMap compactHashMap) {
            this.f8399a = compactHashMap;
        }

        public int size() {
            return this.f8399a.f8406f;
        }

        public boolean contains(Object obj) {
            return this.f8399a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            int a = this.f8399a.m7091a(obj);
            if (a == -1) {
                return null;
            }
            this.f8399a.m7095a(this.f8399a.f8402b[a], (int) (this.f8399a.f8401a[a] >>> 32));
            return true;
        }

        public Iterator<K> iterator() {
            return new C11711(this.f8399a);
        }

        public void clear() {
            this.f8399a.clear();
        }
    }

    class ValuesView extends AbstractCollection<V> {
        final /* synthetic */ CompactHashMap f8400a;

        ValuesView(CompactHashMap compactHashMap) {
            this.f8400a = compactHashMap;
        }

        public int size() {
            return this.f8400a.f8406f;
        }

        public void clear() {
            this.f8400a.clear();
        }

        public Iterator<V> iterator() {
            return new C11733(this.f8400a);
        }
    }

    class C11711 extends Itr<K> {
        final /* synthetic */ CompactHashMap f14881a;

        C11711(CompactHashMap compactHashMap) {
            this.f14881a = compactHashMap;
            super();
        }

        final K mo2390a(int i) {
            return this.f14881a.f8402b[i];
        }
    }

    class C11722 extends Itr<Entry<K, V>> {
        final /* synthetic */ CompactHashMap f14882a;

        C11722(CompactHashMap compactHashMap) {
            this.f14882a = compactHashMap;
            super();
        }

        final /* synthetic */ Object mo2390a(int i) {
            return new MapEntry(this.f14882a, i);
        }
    }

    class C11733 extends Itr<V> {
        final /* synthetic */ CompactHashMap f14883a;

        C11733(CompactHashMap compactHashMap) {
            this.f14883a = compactHashMap;
            super();
        }

        final V mo2390a(int i) {
            return this.f14883a.f8403c[i];
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {
        final /* synthetic */ CompactHashMap f14884a;
        private final K f14885b;
        private int f14886c;

        MapEntry(CompactHashMap compactHashMap, int i) {
            this.f14884a = compactHashMap;
            this.f14885b = compactHashMap.f8402b[i];
            this.f14886c = i;
        }

        public final K getKey() {
            return this.f14885b;
        }

        private void m14720a() {
            if (this.f14886c == -1 || this.f14886c >= this.f14884a.size() || !Objects.m14557a(this.f14885b, this.f14884a.f8402b[this.f14886c])) {
                this.f14886c = this.f14884a.m7091a(this.f14885b);
            }
        }

        public final V getValue() {
            m14720a();
            return this.f14886c == -1 ? null : this.f14884a.f8403c[this.f14886c];
        }

        public final V setValue(V v) {
            m14720a();
            if (this.f14886c == -1) {
                this.f14884a.put(this.f14885b, v);
                return null;
            }
            V v2 = this.f14884a.f8403c[this.f14886c];
            this.f14884a.f8403c[this.f14886c] = v;
            return v2;
        }
    }

    static int m7088a(int i) {
        return i - 1;
    }

    private static long m7092a(long j, int i) {
        return (j & -4294967296L) | (((long) i) & 4294967295L);
    }

    public static <K, V> CompactHashMap<K, V> m7093a() {
        return new CompactHashMap((byte) 0);
    }

    CompactHashMap() {
        m7096b(3);
    }

    private CompactHashMap(byte b) {
        this((int) (byte) 12);
    }

    private CompactHashMap(int i) {
        m7096b(12);
    }

    private void m7096b(int i) {
        Preconditions.m6914a(i >= 0, (Object) "Initial capacity must be non-negative");
        Preconditions.m6914a(true, (Object) "Illegal load factor");
        int b = Hashing.m7114b(i);
        this.f8407g = m7097c(b);
        this.f8404d = 1.0f;
        this.f8402b = new Object[i];
        this.f8403c = new Object[i];
        i = new long[i];
        Arrays.fill(i, -1);
        this.f8401a = i;
        this.f8408h = Math.max(1, (int) (((float) b) * 1065353216));
    }

    private static int[] m7097c(int i) {
        i = new int[i];
        Arrays.fill(i, -1);
        return i;
    }

    public V put(K k, V v) {
        int i;
        K k2 = k;
        long[] jArr = this.f8401a;
        Object[] objArr = this.f8402b;
        Object[] objArr2 = this.f8403c;
        int a = Hashing.m7113a((Object) k);
        int length = (this.f8407g.length - 1) & a;
        int i2 = this.f8406f;
        int i3 = this.f8407g[length];
        if (i3 == -1) {
            r0.f8407g[length] = i2;
            i = i2;
        } else {
            long j;
            int i4;
            while (true) {
                j = jArr[i3];
                i4 = i2;
                if (((int) (j >>> 32)) == a && Objects.m14557a(k2, objArr[i3])) {
                    V v2 = objArr2[i3];
                    objArr2[i3] = v;
                    return v2;
                }
                length = (int) j;
                if (length == -1) {
                    break;
                }
                i3 = length;
                i2 = i4;
            }
            i = i4;
            jArr[i3] = m7092a(j, i);
        }
        int i5 = RedditJobManager.f10810d;
        if (i == RedditJobManager.f10810d) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        i2 = i + 1;
        int length2 = r0.f8401a.length;
        if (i2 > length2) {
            int max = Math.max(1, length2 >>> 1) + length2;
            if (max >= 0) {
                i5 = max;
            }
            if (i5 != length2) {
                r0.f8402b = Arrays.copyOf(r0.f8402b, i5);
                r0.f8403c = Arrays.copyOf(r0.f8403c, i5);
                long[] jArr2 = r0.f8401a;
                max = jArr2.length;
                jArr2 = Arrays.copyOf(jArr2, i5);
                if (i5 > max) {
                    Arrays.fill(jArr2, max, i5, -1);
                }
                r0.f8401a = jArr2;
            }
        }
        r0.f8401a[i] = (((long) a) << 32) | 4294967295L;
        r0.f8402b[i] = k2;
        r0.f8403c[i] = v;
        r0.f8406f = i2;
        if (i >= r0.f8408h) {
            m7098d(2 * r0.f8407g.length);
        }
        r0.f8405e++;
        return null;
    }

    private void m7098d(int i) {
        if (this.f8407g.length >= 1073741824) {
            this.f8408h = RedditJobManager.f10810d;
            return;
        }
        int i2 = ((int) (((float) i) * this.f8404d)) + 1;
        i = m7097c(i);
        long[] jArr = this.f8401a;
        int length = i.length - 1;
        for (int i3 = 0; i3 < this.f8406f; i3++) {
            int i4 = (int) (jArr[i3] >>> 32);
            int i5 = i4 & length;
            int i6 = i[i5];
            i[i5] = i3;
            jArr[i3] = (((long) i4) << 32) | (((long) i6) & 4294967295L);
        }
        this.f8408h = i2;
        this.f8407g = i;
    }

    private int m7091a(Object obj) {
        int a = Hashing.m7113a(obj);
        int i = this.f8407g[(this.f8407g.length - 1) & a];
        while (i != -1) {
            long j = this.f8401a[i];
            if (((int) (j >>> 32)) == a && Objects.m14557a(obj, this.f8402b[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        return m7091a(obj) != -1 ? true : null;
    }

    public V get(Object obj) {
        obj = m7091a(obj);
        if (obj == -1) {
            return null;
        }
        return this.f8403c[obj];
    }

    public V remove(Object obj) {
        return m7095a(obj, Hashing.m7113a(obj));
    }

    public Set<K> keySet() {
        if (this.f8409i != null) {
            return this.f8409i;
        }
        Set<K> keySetView = new KeySetView(this);
        this.f8409i = keySetView;
        return keySetView;
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f8410j != null) {
            return this.f8410j;
        }
        Set<Entry<K, V>> entrySetView = new EntrySetView(this);
        this.f8410j = entrySetView;
        return entrySetView;
    }

    public int size() {
        return this.f8406f;
    }

    public boolean isEmpty() {
        return this.f8406f == 0;
    }

    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.f8406f; i++) {
            if (Objects.m14557a(obj, this.f8403c[i])) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        if (this.f8411k != null) {
            return this.f8411k;
        }
        Collection<V> valuesView = new ValuesView(this);
        this.f8411k = valuesView;
        return valuesView;
    }

    public void clear() {
        this.f8405e++;
        Arrays.fill(this.f8402b, 0, this.f8406f, null);
        Arrays.fill(this.f8403c, 0, this.f8406f, null);
        Arrays.fill(this.f8407g, -1);
        Arrays.fill(this.f8401a, -1);
        this.f8406f = 0;
    }

    private V m7095a(Object obj, int i) {
        int length = (this.f8407g.length - 1) & i;
        int i2 = this.f8407g[length];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (((int) (this.f8401a[i2] >>> 32)) == i && Objects.m14557a(obj, this.f8402b[i2])) {
                break;
            }
            i3 = (int) this.f8401a[i2];
            if (i3 == -1) {
                return null;
            }
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        obj = this.f8403c[i2];
        if (i3 == -1) {
            this.f8407g[length] = (int) this.f8401a[i2];
        } else {
            this.f8401a[i3] = m7092a(this.f8401a[i3], (int) this.f8401a[i2]);
        }
        i = size() - 1;
        if (i2 < i) {
            this.f8402b[i2] = this.f8402b[i];
            this.f8403c[i2] = this.f8403c[i];
            this.f8402b[i] = null;
            this.f8403c[i] = null;
            long j = this.f8401a[i];
            this.f8401a[i2] = j;
            this.f8401a[i] = -1;
            length = ((int) (j >>> 32)) & (this.f8407g.length - 1);
            int i5 = this.f8407g[length];
            if (i5 == i) {
                this.f8407g[length] = i2;
            } else {
                long j2;
                while (true) {
                    j2 = this.f8401a[i5];
                    length = (int) j2;
                    if (length == i) {
                        break;
                    }
                    i5 = length;
                }
                this.f8401a[i5] = m7092a(j2, i2);
            }
        } else {
            this.f8402b[i2] = null;
            this.f8403c[i2] = null;
            this.f8401a[i2] = -1;
        }
        this.f8406f--;
        this.f8405e++;
        return obj;
    }
}
