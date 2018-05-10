package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

public class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final WeakValueReference<Object, Object, Object> f8466g = new C11801();
    final transient int f8467a;
    final transient int f8468b;
    final transient Segment<K, V, E, S>[] f8469c;
    final int f8470d;
    final Equivalence<Object> f8471e;
    final transient InternalEntryHelper<K, V, E, S> f8472f;
    transient Set<K> f8473h;
    transient Collection<V> f8474i;
    transient Set<Entry<K, V>> f8475j;

    abstract class HashIterator<T> implements Iterator<T> {
        int f8447b;
        int f8448c = -1;
        Segment<K, V, E, S> f8449d;
        AtomicReferenceArray<E> f8450e;
        E f8451f;
        WriteThroughEntry f8452g;
        WriteThroughEntry f8453h;
        final /* synthetic */ MapMakerInternalMap f8454i;

        HashIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f8454i = mapMakerInternalMap;
            this.f8447b = mapMakerInternalMap.f8469c.length - 1;
            m7172b();
        }

        private void m7172b() {
            this.f8452g = null;
            if (!m7173c() && !m7174d()) {
                while (this.f8447b >= 0) {
                    Segment[] segmentArr = this.f8454i.f8469c;
                    int i = this.f8447b;
                    this.f8447b = i - 1;
                    this.f8449d = segmentArr[i];
                    if (this.f8449d.f8456b != 0) {
                        this.f8450e = this.f8449d.f8459e;
                        this.f8448c = this.f8450e.length() - 1;
                        if (m7174d()) {
                            return;
                        }
                    }
                }
            }
        }

        private boolean m7173c() {
            if (this.f8451f != null) {
                do {
                    this.f8451f = this.f8451f.mo2408c();
                    if (this.f8451f != null) {
                    }
                } while (!m7171a(this.f8451f));
                return true;
            }
            return false;
        }

        private boolean m7174d() {
            while (this.f8448c >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.f8450e;
                int i = this.f8448c;
                this.f8448c = i - 1;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i);
                this.f8451f = internalEntry;
                if (internalEntry != null && (m7171a(this.f8451f) || m7173c())) {
                    return true;
                }
            }
            return false;
        }

        private boolean m7171a(E e) {
            try {
                Object a = e.mo2406a();
                e = MapMakerInternalMap.m7214a((InternalEntry) e);
                if (e != null) {
                    this.f8452g = new WriteThroughEntry(this.f8454i, a, e);
                    return true;
                }
                this.f8449d.m7207e();
                return null;
            } finally {
                this.f8449d.m7207e();
            }
        }

        public boolean hasNext() {
            return this.f8452g != null;
        }

        final WriteThroughEntry m7175a() {
            if (this.f8452g == null) {
                throw new NoSuchElementException();
            }
            this.f8453h = this.f8452g;
            m7172b();
            return this.f8453h;
        }

        public void remove() {
            CollectPreconditions.m7082a(this.f8453h != null);
            this.f8454i.remove(this.f8453h.getKey());
            this.f8453h = null;
        }
    }

    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        K mo2406a();

        int mo2407b();

        E mo2408c();

        V mo3614d();
    }

    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E mo2410a(S s, E e, E e2);

        E mo2411a(S s, K k, int i, E e);

        S mo2412a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i);

        Strength mo2413a();

        void mo2414a(S s, E e, V v);
    }

    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        public Object[] toArray() {
            return MapMakerInternalMap.m7215a((Collection) this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.m7215a((Collection) this).toArray(tArr);
        }
    }

    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        final MapMakerInternalMap<K, V, E, S> f8455a;
        volatile int f8456b;
        int f8457c;
        int f8458d;
        volatile AtomicReferenceArray<E> f8459e;
        final int f8460f;
        final AtomicInteger f8461g = new AtomicInteger();

        abstract S mo2415a();

        void mo2416b() {
        }

        void mo2417c() {
        }

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i) {
            this.f8455a = mapMakerInternalMap;
            this.f8460f = -1;
            mapMakerInternalMap = m7186a(i);
            this.f8458d = (mapMakerInternalMap.length() * 3) / 4;
            if (this.f8458d == this.f8460f) {
                this.f8458d++;
            }
            this.f8459e = mapMakerInternalMap;
        }

        private void m7187a(E e, V v) {
            this.f8455a.f8472f.mo2414a(mo2415a(), (InternalEntry) e, (Object) v);
        }

        private E m7185a(E e, E e2) {
            return this.f8455a.f8472f.mo2410a(mo2415a(), (InternalEntry) e, (InternalEntry) e2);
        }

        private static AtomicReferenceArray<E> m7186a(int i) {
            return new AtomicReferenceArray(i);
        }

        final void m7206d() {
            if (tryLock()) {
                try {
                    mo2416b();
                } finally {
                    unlock();
                }
            }
        }

        final void m7198a(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    InternalEntry internalEntry = (InternalEntry) poll;
                    MapMakerInternalMap mapMakerInternalMap = this.f8455a;
                    int b = internalEntry.mo2407b();
                    mapMakerInternalMap.m7216a(b).m7189a(internalEntry, b);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        final void m7201b(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    WeakValueReference weakValueReference = (WeakValueReference) poll;
                    MapMakerInternalMap mapMakerInternalMap = this.f8455a;
                    InternalEntry a = weakValueReference.mo2402a();
                    int b = a.mo2407b();
                    mapMakerInternalMap.m7216a(b).m7190a(a.mo2406a(), b, weakValueReference);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        private E m7192d(Object obj, int i) {
            if (this.f8456b != 0) {
                AtomicReferenceArray atomicReferenceArray = this.f8459e;
                for (E e = (InternalEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); e != null; e = e.mo2408c()) {
                    if (e.mo2407b() == i) {
                        Object a = e.mo2406a();
                        if (a == null) {
                            m7206d();
                        } else if (this.f8455a.f8471e.m6878a(obj, a)) {
                            return e;
                        }
                    }
                }
            }
            return null;
        }

        final boolean m7202b(Object obj, int i) {
            try {
                boolean z = false;
                if (this.f8456b != 0) {
                    obj = m7192d(obj, i);
                    if (!(obj == null || obj.mo3614d() == null)) {
                        z = true;
                    }
                    m7207e();
                    return z;
                }
                m7207e();
                return false;
            } catch (Throwable th) {
                m7207e();
            }
        }

        final V m7197a(K k, int i, V v, boolean z) {
            lock();
            try {
                int i2;
                V v2;
                m7193f();
                int i3 = this.f8456b + 1;
                if (i3 > this.f8458d) {
                    AtomicReferenceArray atomicReferenceArray = this.f8459e;
                    int length = atomicReferenceArray.length();
                    if (length < 1073741824) {
                        i2 = this.f8456b;
                        AtomicReferenceArray a = m7186a(length << 1);
                        this.f8458d = (a.length() * 3) / 4;
                        int length2 = a.length() - 1;
                        for (int i4 = 0; i4 < length; i4++) {
                            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i4);
                            if (internalEntry != null) {
                                InternalEntry c = internalEntry.mo2408c();
                                int b = internalEntry.mo2407b() & length2;
                                if (c == null) {
                                    a.set(b, internalEntry);
                                } else {
                                    InternalEntry internalEntry2 = internalEntry;
                                    while (c != null) {
                                        int b2 = c.mo2407b() & length2;
                                        if (b2 != b) {
                                            internalEntry2 = c;
                                            b = b2;
                                        }
                                        c = c.mo2408c();
                                    }
                                    a.set(b, internalEntry2);
                                    while (internalEntry != internalEntry2) {
                                        int b3 = internalEntry.mo2407b() & length2;
                                        InternalEntry a2 = m7185a(internalEntry, (InternalEntry) a.get(b3));
                                        if (a2 != null) {
                                            a.set(b3, a2);
                                        } else {
                                            i2--;
                                        }
                                        internalEntry = internalEntry.mo2408c();
                                    }
                                }
                            }
                        }
                        this.f8459e = a;
                        this.f8456b = i2;
                    }
                    i3 = this.f8456b + 1;
                }
                AtomicReferenceArray atomicReferenceArray2 = this.f8459e;
                i2 = (atomicReferenceArray2.length() - 1) & i;
                InternalEntry internalEntry3 = (InternalEntry) atomicReferenceArray2.get(i2);
                InternalEntry internalEntry4 = internalEntry3;
                while (true) {
                    v2 = null;
                    if (internalEntry4 != null) {
                        Object a3 = internalEntry4.mo2406a();
                        if (internalEntry4.mo2407b() == i && a3 != null && this.f8455a.f8471e.m6878a(k, a3)) {
                            break;
                        }
                        internalEntry4 = internalEntry4.mo2408c();
                    } else {
                        this.f8457c++;
                        InternalEntry a4 = this.f8455a.f8472f.mo2411a(mo2415a(), k, i, internalEntry3);
                        m7187a(a4, (Object) v);
                        atomicReferenceArray2.set(i2, a4);
                        this.f8456b = i3;
                        unlock();
                        return v2;
                    }
                }
                k = internalEntry4.mo3614d();
                if (k == null) {
                    this.f8457c++;
                    m7187a(internalEntry4, (Object) v);
                    this.f8456b = this.f8456b;
                    return v2;
                } else if (z) {
                    unlock();
                    return k;
                } else {
                    this.f8457c++;
                    m7187a(internalEntry4, (Object) v);
                    unlock();
                    return k;
                }
            } finally {
                unlock();
            }
        }

        final boolean m7199a(K k, int i, V v, V v2) {
            lock();
            try {
                m7193f();
                AtomicReferenceArray atomicReferenceArray = this.f8459e;
                int length = (atomicReferenceArray.length() - 1) & i;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.mo2408c()) {
                    Object a = internalEntry2.mo2406a();
                    if (internalEntry2.mo2407b() == i && a != null && this.f8455a.f8471e.m6878a(k, a)) {
                        k = internalEntry2.mo3614d();
                        if (k == null) {
                            if (m7188a(internalEntry2) != null) {
                                k = this.f8456b;
                                this.f8457c += 1;
                                i = this.f8456b - 1;
                                atomicReferenceArray.set(length, m7191b(internalEntry, internalEntry2));
                                this.f8456b = i;
                            }
                            unlock();
                            return false;
                        } else if (this.f8455a.m7217b().m6878a(v, k) != null) {
                            this.f8457c += 1;
                            m7187a(internalEntry2, (Object) v2);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } catch (Throwable th) {
                unlock();
            }
        }

        final V m7196a(K k, int i, V v) {
            lock();
            try {
                m7193f();
                AtomicReferenceArray atomicReferenceArray = this.f8459e;
                int length = (atomicReferenceArray.length() - 1) & i;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.mo2408c()) {
                    Object a = internalEntry2.mo2406a();
                    if (internalEntry2.mo2407b() == i && a != null && this.f8455a.f8471e.m6878a(k, a)) {
                        k = internalEntry2.mo3614d();
                        if (k == null) {
                            if (m7188a(internalEntry2) != null) {
                                k = this.f8456b;
                                this.f8457c++;
                                i = this.f8456b - 1;
                                atomicReferenceArray.set(length, m7191b(internalEntry, internalEntry2));
                                this.f8456b = i;
                            }
                            unlock();
                            return null;
                        }
                        this.f8457c++;
                        m7187a(internalEntry2, (Object) v);
                        unlock();
                        return k;
                    }
                }
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
            }
        }

        final V m7204c(Object obj, int i) {
            lock();
            m7193f();
            int i2 = this.f8456b;
            AtomicReferenceArray atomicReferenceArray = this.f8459e;
            int length = (atomicReferenceArray.length() - 1) & i;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            InternalEntry internalEntry2 = internalEntry;
            while (true) {
                V v = null;
                if (internalEntry2 != null) {
                    Object a = internalEntry2.mo2406a();
                    if (internalEntry2.mo2407b() == i && a != null && this.f8455a.f8471e.m6878a(obj, a)) {
                        break;
                    }
                    try {
                        internalEntry2 = internalEntry2.mo2408c();
                    } finally {
                        unlock();
                    }
                } else {
                    unlock();
                    return v;
                }
            }
            obj = internalEntry2.mo3614d();
            if (obj == null && m7188a(internalEntry2) == 0) {
                return v;
            }
            this.f8457c++;
            i = m7191b(internalEntry, internalEntry2);
            int i3 = this.f8456b - 1;
            atomicReferenceArray.set(length, i);
            this.f8456b = i3;
            unlock();
            return obj;
        }

        final boolean m7203b(Object obj, int i, Object obj2) {
            boolean z;
            lock();
            m7193f();
            int i2 = this.f8456b;
            AtomicReferenceArray atomicReferenceArray = this.f8459e;
            int length = (atomicReferenceArray.length() - 1) & i;
            InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
            InternalEntry internalEntry2 = internalEntry;
            while (true) {
                z = false;
                if (internalEntry2 != null) {
                    Object a = internalEntry2.mo2406a();
                    if (internalEntry2.mo2407b() == i && a != null && this.f8455a.f8471e.m6878a(obj, a)) {
                        break;
                    }
                    try {
                        internalEntry2 = internalEntry2.mo2408c();
                    } finally {
                        unlock();
                    }
                } else {
                    unlock();
                    return false;
                }
            }
            if (this.f8455a.m7217b().m6878a(obj2, internalEntry2.mo3614d()) != null) {
                z = true;
            } else if (m7188a(internalEntry2) == null) {
                unlock();
                return false;
            }
            this.f8457c += 1;
            i = this.f8456b - 1;
            atomicReferenceArray.set(length, m7191b(internalEntry, internalEntry2));
            this.f8456b = i;
            return z;
        }

        private E m7191b(E e, E e2) {
            int i = this.f8456b;
            E c = e2.mo2408c();
            InternalEntry c2;
            while (c2 != e2) {
                E a = m7185a(c2, (InternalEntry) c);
                if (a != null) {
                    c = a;
                } else {
                    i--;
                }
                c2 = c2.mo2408c();
            }
            this.f8456b = i;
            return c;
        }

        private boolean m7189a(E e, int i) {
            lock();
            try {
                int i2 = this.f8456b;
                AtomicReferenceArray atomicReferenceArray = this.f8459e;
                boolean z = true;
                i &= atomicReferenceArray.length() - z;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i);
                for (InternalEntry internalEntry2 = internalEntry; internalEntry2 != null; internalEntry2 = internalEntry2.mo2408c()) {
                    if (internalEntry2 == e) {
                        this.f8457c += z;
                        e = m7191b(internalEntry, internalEntry2);
                        int i3 = this.f8456b - z;
                        atomicReferenceArray.set(i, e);
                        this.f8456b = i3;
                        return z;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        private boolean m7190a(K k, int i, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                int i2 = this.f8456b;
                AtomicReferenceArray atomicReferenceArray = this.f8459e;
                boolean z = true;
                int length = (atomicReferenceArray.length() - z) & i;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object a = internalEntry2.mo2406a();
                    if (internalEntry2.mo2407b() != i || a == null || !this.f8455a.f8471e.m6878a(k, a)) {
                        internalEntry2 = internalEntry2.mo2408c();
                    } else if (((WeakValueEntry) internalEntry2).mo3615e() == weakValueReference) {
                        this.f8457c += z;
                        i = this.f8456b - z;
                        atomicReferenceArray.set(length, m7191b(internalEntry, internalEntry2));
                        this.f8456b = i;
                        return z;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean m7188a(E e) {
            return e.mo3614d() == null ? true : null;
        }

        final void m7207e() {
            if ((this.f8461g.incrementAndGet() & 63) == 0) {
                m7193f();
            }
        }

        private void m7193f() {
            if (tryLock()) {
                try {
                    mo2416b();
                    this.f8461g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        final V m7195a(Object obj, int i) {
            try {
                obj = m7192d(obj, i);
                if (obj == null) {
                    return null;
                }
                obj = obj.mo3614d();
                if (obj == null) {
                    m7206d();
                }
                m7207e();
                return obj;
            } finally {
                m7207e();
            }
        }
    }

    enum Strength {
        ;

        abstract Equivalence<Object> mo2409a();
    }

    final class Values extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap f8465a;

        Values(MapMakerInternalMap mapMakerInternalMap) {
            this.f8465a = mapMakerInternalMap;
        }

        public final Iterator<V> iterator() {
            return new ValueIterator(this.f8465a);
        }

        public final int size() {
            return this.f8465a.size();
        }

        public final boolean isEmpty() {
            return this.f8465a.isEmpty();
        }

        public final boolean contains(Object obj) {
            return this.f8465a.containsValue(obj);
        }

        public final void clear() {
            this.f8465a.clear();
        }

        public final Object[] toArray() {
            return MapMakerInternalMap.m7215a((Collection) this).toArray();
        }

        public final <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.m7215a((Collection) this).toArray(tArr);
        }
    }

    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        E mo2402a();

        WeakValueReference<K, V, E> mo2403a(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        V get();
    }

    static class C11801 implements WeakValueReference<Object, Object, Object> {
        public final /* bridge */ /* synthetic */ InternalEntry mo2402a() {
            return null;
        }

        public final /* bridge */ /* synthetic */ WeakValueReference mo2403a(ReferenceQueue referenceQueue, InternalEntry internalEntry) {
            return this;
        }

        public final void clear() {
        }

        public final Object get() {
            return null;
        }

        C11801() {
        }
    }

    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final K f14904a;
        final int f14905b;
        final E f14906c;

        AbstractStrongKeyEntry(K k, int i, E e) {
            this.f14904a = k;
            this.f14905b = i;
            this.f14906c = e;
        }

        public final K mo2406a() {
            return this.f14904a;
        }

        public final int mo2407b() {
            return this.f14905b;
        }

        public final E mo2408c() {
            return this.f14906c;
        }
    }

    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int f14907a;
        final E f14908b;

        AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k, int i, E e) {
            super(k, referenceQueue);
            this.f14907a = i;
            this.f14908b = e;
        }

        public final K mo2406a() {
            return get();
        }

        public final int mo2407b() {
            return this.f14907a;
        }

        public final E mo2408c() {
            return this.f14908b;
        }
    }

    final class EntryIterator extends HashIterator<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap f14909a;

        EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f14909a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public final /* synthetic */ Object next() {
            return m7175a();
        }
    }

    final class EntrySet extends SafeToArraySet<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap f14910a;

        EntrySet(MapMakerInternalMap mapMakerInternalMap) {
            this.f14910a = mapMakerInternalMap;
            super();
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new EntryIterator(this.f14910a);
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                return false;
            }
            key = this.f14910a.get(key);
            if (key == null || this.f14910a.m7217b().m6878a(entry.getValue(), key) == null) {
                return false;
            }
            return true;
        }

        public final boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null || this.f14910a.remove(key, entry.getValue()) == null) {
                return false;
            }
            return true;
        }

        public final int size() {
            return this.f14910a.size();
        }

        public final boolean isEmpty() {
            return this.f14910a.isEmpty();
        }

        public final void clear() {
            this.f14910a.clear();
        }
    }

    final class KeyIterator extends HashIterator<K> {
        final /* synthetic */ MapMakerInternalMap f14911a;

        KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f14911a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public final K next() {
            return m7175a().getKey();
        }
    }

    final class KeySet extends SafeToArraySet<K> {
        final /* synthetic */ MapMakerInternalMap f14912a;

        KeySet(MapMakerInternalMap mapMakerInternalMap) {
            this.f14912a = mapMakerInternalMap;
            super();
        }

        public final Iterator<K> iterator() {
            return new KeyIterator(this.f14912a);
        }

        public final int size() {
            return this.f14912a.size();
        }

        public final boolean isEmpty() {
            return this.f14912a.isEmpty();
        }

        public final boolean contains(Object obj) {
            return this.f14912a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.f14912a.remove(obj) != null ? true : null;
        }

        public final void clear() {
            this.f14912a.clear();
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        final /* bridge */ /* synthetic */ Segment mo2415a() {
            return this;
        }

        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i) {
            super(mapMakerInternalMap, i);
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> f14915h = new ReferenceQueue();

        final /* bridge */ /* synthetic */ Segment mo2415a() {
            return this;
        }

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i) {
            super(mapMakerInternalMap, i);
        }

        final void mo2416b() {
            m7201b(this.f14915h);
        }

        final void mo2417c() {
            do {
            } while (this.f14915h.poll() != null);
        }
    }

    interface StrongValueEntry extends InternalEntry {
    }

    final class ValueIterator extends HashIterator<V> {
        final /* synthetic */ MapMakerInternalMap f14916a;

        ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f14916a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public final V next() {
            return m7175a().getValue();
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> f14918h = new ReferenceQueue();

        final /* bridge */ /* synthetic */ Segment mo2415a() {
            return this;
        }

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i) {
            super(mapMakerInternalMap, i);
        }

        final void mo2416b() {
            m7198a(this.f14918h);
        }

        final void mo2417c() {
            do {
            } while (this.f14918h.poll() != null);
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> f14920h = new ReferenceQueue();
        private final ReferenceQueue<V> f14921i = new ReferenceQueue();

        final /* bridge */ /* synthetic */ Segment mo2415a() {
            return this;
        }

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i) {
            super(mapMakerInternalMap, i);
        }

        final void mo2416b() {
            m7198a(this.f14920h);
            m7201b(this.f14921i);
        }

        final void mo2417c() {
            do {
            } while (this.f14920h.poll() != null);
        }
    }

    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference<K, V, E> mo3615e();
    }

    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        final E f14922a;

        WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.f14922a = e;
        }

        public final E mo2402a() {
            return this.f14922a;
        }

        public final WeakValueReference<K, V, E> mo2403a(ReferenceQueue<V> referenceQueue, E e) {
            return new WeakValueReferenceImpl(referenceQueue, get(), e);
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K f14923a;
        V f14924b;
        final /* synthetic */ MapMakerInternalMap f14925c;

        WriteThroughEntry(MapMakerInternalMap mapMakerInternalMap, K k, V v) {
            this.f14925c = mapMakerInternalMap;
            this.f14923a = k;
            this.f14924b = v;
        }

        public final K getKey() {
            return this.f14923a;
        }

        public final V getValue() {
            return this.f14924b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.f14923a.equals(entry.getKey()) || this.f14924b.equals(entry.getValue()) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f14923a.hashCode() ^ this.f14924b.hashCode();
        }

        public final V setValue(V v) {
            V put = this.f14925c.put(this.f14923a, v);
            this.f14924b = v;
            return put;
        }
    }

    static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        volatile V f18454d = null;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> f14913a = new Helper();

            Helper() {
            }

            public final /* synthetic */ InternalEntry mo2410a(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyStrongValueEntry strongKeyStrongValueEntry = (StrongKeyStrongValueEntry) internalEntry;
                segment = new StrongKeyStrongValueEntry(strongKeyStrongValueEntry.a, strongKeyStrongValueEntry.b, (StrongKeyStrongValueEntry) internalEntry2);
                segment.f18454d = strongKeyStrongValueEntry.f18454d;
                return segment;
            }

            public final /* synthetic */ InternalEntry mo2411a(Segment segment, Object obj, int i, InternalEntry internalEntry) {
                return new StrongKeyStrongValueEntry(obj, i, (StrongKeyStrongValueEntry) internalEntry);
            }

            static <K, V> Helper<K, V> m14768b() {
                return f14913a;
            }

            public final Strength mo2413a() {
                return Strength.f8462a;
            }

            public final /* synthetic */ Segment mo2412a(MapMakerInternalMap mapMakerInternalMap, int i) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i);
            }
        }

        StrongKeyStrongValueEntry(K k, int i, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
            super(k, i, strongKeyStrongValueEntry);
        }

        public final V mo3614d() {
            return this.f18454d;
        }
    }

    static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> f18455d = MapMakerInternalMap.m7212a();

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> f14914a = new Helper();

            Helper() {
            }

            public final /* synthetic */ InternalEntry mo2410a(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                StrongKeyWeakValueSegment strongKeyWeakValueSegment = (StrongKeyWeakValueSegment) segment;
                internalEntry = (StrongKeyWeakValueEntry) internalEntry;
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry2;
                if (Segment.m7188a(internalEntry)) {
                    return null;
                }
                segment = strongKeyWeakValueSegment.f14915h;
                InternalEntry strongKeyWeakValueEntry2 = new StrongKeyWeakValueEntry(internalEntry.a, internalEntry.b, strongKeyWeakValueEntry);
                strongKeyWeakValueEntry2.f18455d = internalEntry.f18455d.mo2403a(segment, strongKeyWeakValueEntry2);
                return strongKeyWeakValueEntry2;
            }

            public final /* synthetic */ InternalEntry mo2411a(Segment segment, Object obj, int i, InternalEntry internalEntry) {
                return new StrongKeyWeakValueEntry(obj, i, (StrongKeyWeakValueEntry) internalEntry);
            }

            public final /* synthetic */ void mo2414a(Segment segment, InternalEntry internalEntry, Object obj) {
                StrongKeyWeakValueEntry strongKeyWeakValueEntry = (StrongKeyWeakValueEntry) internalEntry;
                segment = ((StrongKeyWeakValueSegment) segment).f14915h;
                WeakValueReference weakValueReference = strongKeyWeakValueEntry.f18455d;
                strongKeyWeakValueEntry.f18455d = new WeakValueReferenceImpl(segment, obj, strongKeyWeakValueEntry);
                weakValueReference.clear();
            }

            static <K, V> Helper<K, V> m14775b() {
                return f14914a;
            }

            public final Strength mo2413a() {
                return Strength.f8463b;
            }

            public final /* synthetic */ Segment mo2412a(MapMakerInternalMap mapMakerInternalMap, int i) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i);
            }
        }

        StrongKeyWeakValueEntry(K k, int i, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
            super(k, i, strongKeyWeakValueEntry);
        }

        public final V mo3614d() {
            return this.f18455d.get();
        }

        public final WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> mo3615e() {
            return this.f18455d;
        }
    }

    static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        volatile V f18456c = null;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final Helper<?, ?> f14917a = new Helper();

            Helper() {
            }

            public final /* synthetic */ InternalEntry mo2410a(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyStrongValueSegment weakKeyStrongValueSegment = (WeakKeyStrongValueSegment) segment;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry = (WeakKeyStrongValueEntry) internalEntry;
                WeakKeyStrongValueEntry weakKeyStrongValueEntry2 = (WeakKeyStrongValueEntry) internalEntry2;
                if (weakKeyStrongValueEntry.get() == null) {
                    return null;
                }
                InternalEntry weakKeyStrongValueEntry3 = new WeakKeyStrongValueEntry(weakKeyStrongValueSegment.f14918h, weakKeyStrongValueEntry.get(), weakKeyStrongValueEntry.a, weakKeyStrongValueEntry2);
                weakKeyStrongValueEntry3.f18456c = weakKeyStrongValueEntry.f18456c;
                return weakKeyStrongValueEntry3;
            }

            public final /* synthetic */ InternalEntry mo2411a(Segment segment, Object obj, int i, InternalEntry internalEntry) {
                return new WeakKeyStrongValueEntry(((WeakKeyStrongValueSegment) segment).f14918h, obj, i, (WeakKeyStrongValueEntry) internalEntry);
            }

            static <K, V> Helper<K, V> m14785b() {
                return f14917a;
            }

            public final Strength mo2413a() {
                return Strength.f8462a;
            }

            public final /* synthetic */ Segment mo2412a(MapMakerInternalMap mapMakerInternalMap, int i) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i);
            }
        }

        WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k, int i, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
            super(referenceQueue, k, i, weakKeyStrongValueEntry);
        }

        public final V mo3614d() {
            return this.f18456c;
        }
    }

    static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> f18457c = MapMakerInternalMap.m7212a();

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final Helper<?, ?> f14919a = new Helper();

            Helper() {
            }

            public final /* synthetic */ InternalEntry mo2410a(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2) {
                WeakKeyWeakValueSegment weakKeyWeakValueSegment = (WeakKeyWeakValueSegment) segment;
                internalEntry = (WeakKeyWeakValueEntry) internalEntry;
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry2;
                if (internalEntry.get() == null || Segment.m7188a(internalEntry)) {
                    return null;
                }
                ReferenceQueue a = weakKeyWeakValueSegment.f14920h;
                segment = weakKeyWeakValueSegment.f14921i;
                InternalEntry weakKeyWeakValueEntry2 = new WeakKeyWeakValueEntry(a, internalEntry.get(), internalEntry.a, weakKeyWeakValueEntry);
                weakKeyWeakValueEntry2.f18457c = internalEntry.f18457c.mo2403a(segment, weakKeyWeakValueEntry2);
                return weakKeyWeakValueEntry2;
            }

            public final /* synthetic */ InternalEntry mo2411a(Segment segment, Object obj, int i, InternalEntry internalEntry) {
                return new WeakKeyWeakValueEntry(((WeakKeyWeakValueSegment) segment).f14920h, obj, i, (WeakKeyWeakValueEntry) internalEntry);
            }

            public final /* synthetic */ void mo2414a(Segment segment, InternalEntry internalEntry, Object obj) {
                WeakKeyWeakValueEntry weakKeyWeakValueEntry = (WeakKeyWeakValueEntry) internalEntry;
                segment = ((WeakKeyWeakValueSegment) segment).f14921i;
                WeakValueReference weakValueReference = weakKeyWeakValueEntry.f18457c;
                weakKeyWeakValueEntry.f18457c = new WeakValueReferenceImpl(segment, obj, weakKeyWeakValueEntry);
                weakValueReference.clear();
            }

            static <K, V> Helper<K, V> m14795b() {
                return f14919a;
            }

            public final Strength mo2413a() {
                return Strength.f8463b;
            }

            public final /* synthetic */ Segment mo2412a(MapMakerInternalMap mapMakerInternalMap, int i) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i);
            }
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k, int i, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
            super(referenceQueue, k, i, weakKeyWeakValueEntry);
        }

        public final V mo3614d() {
            return this.f18457c.get();
        }

        public final WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> mo3615e() {
            return this.f18457c;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.f8470d = Math.min(mapMaker.m7168b(), 65536);
        this.f8471e = (Equivalence) MoreObjects.m6895a(mapMaker.f8446f, mapMaker.m7169c().mo2409a());
        this.f8472f = internalEntryHelper;
        mapMaker = Math.min(mapMaker.m7167a(), 1073741824);
        internalEntryHelper = null;
        int i = 1;
        int i2 = 0;
        int i3 = 1;
        while (i3 < this.f8470d) {
            i2++;
            i3 <<= 1;
        }
        this.f8468b = 32 - i2;
        this.f8467a = i3 - 1;
        this.f8469c = new Segment[i3];
        i2 = mapMaker / i3;
        if (i3 * i2 < mapMaker) {
            i2++;
        }
        while (i < i2) {
            i <<= 1;
        }
        while (internalEntryHelper < this.f8469c.length) {
            this.f8469c[internalEntryHelper] = this.f8472f.mo2412a(this, i);
            internalEntryHelper++;
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> m7213a(MapMaker mapMaker) {
        if (mapMaker.m7169c() == Strength.f8462a && mapMaker.m7170d() == Strength.f8462a) {
            return new MapMakerInternalMap(mapMaker, Helper.m14768b());
        }
        if (mapMaker.m7169c() == Strength.f8462a && mapMaker.m7170d() == Strength.f8463b) {
            return new MapMakerInternalMap(mapMaker, Helper.m14775b());
        }
        if (mapMaker.m7169c() == Strength.f8463b && mapMaker.m7170d() == Strength.f8462a) {
            return new MapMakerInternalMap(mapMaker, Helper.m14785b());
        }
        if (mapMaker.m7169c() == Strength.f8463b && mapMaker.m7170d() == Strength.f8463b) {
            return new MapMakerInternalMap(mapMaker, Helper.m14795b());
        }
        throw new AssertionError();
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> m7212a() {
        return f8466g;
    }

    private int m7211a(Object obj) {
        obj = this.f8471e.m6877a(obj);
        obj += (obj << 15) ^ -12931;
        obj ^= obj >>> 10;
        obj += obj << 3;
        obj ^= obj >>> 6;
        obj += (obj << 2) + (obj << 14);
        return obj ^ (obj >>> 16);
    }

    final Segment<K, V, E, S> m7216a(int i) {
        return this.f8469c[(i >>> this.f8468b) & this.f8467a];
    }

    static V m7214a(E e) {
        if (e.mo2406a() == null) {
            return null;
        }
        e = e.mo3614d();
        if (e == null) {
            return null;
        }
        return e;
    }

    final Equivalence<Object> m7217b() {
        return this.f8472f.mo2413a().mo2409a();
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f8469c;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].f8456b != 0) {
                return false;
            }
            j += (long) segmentArr[i].f8457c;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].f8456b != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].f8457c;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = 0;
        for (Segment segment : this.f8469c) {
            j += (long) segment.f8456b;
        }
        return Ints.m7284b(j);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m7211a(obj);
        return m7216a(a).m7195a(obj, a);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m7211a(obj);
        return m7216a(a).m7202b(obj, a);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        boolean z2;
        Segment[] segmentArr = this.f8469c;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            int i2 = z;
            while (i2 < length) {
                Segment segment = segmentArr[i2];
                int i3 = segment.f8456b;
                AtomicReferenceArray atomicReferenceArray = segment.f8459e;
                for (int i4 = z; i4 < atomicReferenceArray.length(); i4++) {
                    for (InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i4); internalEntry != null; internalEntry = internalEntry.mo2408c()) {
                        Object d;
                        if (internalEntry.mo2406a() == null) {
                            segment.m7206d();
                        } else {
                            d = internalEntry.mo3614d();
                            if (d == null) {
                                segment.m7206d();
                            }
                            if (d == null && m7217b().m6878a(obj2, d)) {
                                return true;
                            }
                        }
                        d = null;
                        if (d == null) {
                        }
                    }
                }
                j2 += (long) segment.f8457c;
                i2++;
                z = false;
            }
            if (j2 == j) {
                z2 = false;
                break;
            }
            i++;
            j = j2;
            z = false;
        }
        z2 = z;
        return z2;
    }

    public V put(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7211a((Object) k);
        return m7216a(a).m7197a((Object) k, a, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7211a((Object) k);
        return m7216a(a).m7197a((Object) k, a, (Object) v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m7211a(obj);
        return m7216a(a).m7204c(obj, a);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                int a = m7211a(obj);
                return m7216a(a).m7203b(obj, a, obj2);
            }
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v2);
        if (v == null) {
            return null;
        }
        int a = m7211a((Object) k);
        return m7216a(a).m7199a((Object) k, a, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7211a((Object) k);
        return m7216a(a).m7196a((Object) k, a, (Object) v);
    }

    public void clear() {
        Segment[] segmentArr = this.f8469c;
        int length = segmentArr.length;
        for (int i = 0; i < length; i++) {
            Segment segment = segmentArr[i];
            if (segment.f8456b != 0) {
                segment.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = segment.f8459e;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    segment.mo2417c();
                    segment.f8461g.set(0);
                    segment.f8457c++;
                    segment.f8456b = 0;
                } finally {
                    segment.unlock();
                }
            }
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f8473h;
        if (set != null) {
            return set;
        }
        set = new KeySet(this);
        this.f8473h = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f8474i;
        if (collection != null) {
            return collection;
        }
        collection = new Values(this);
        this.f8474i = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f8475j;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f8475j = set;
        return set;
    }

    static /* synthetic */ ArrayList m7215a(Collection collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.m7149a(arrayList, collection.iterator());
        return arrayList;
    }
}
