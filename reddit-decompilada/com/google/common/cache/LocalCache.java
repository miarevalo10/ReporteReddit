package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache.SimpleStatsCounter;
import com.google.common.cache.AbstractCache.StatsCounter;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger f8327a = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> f8328u = new C11501();
    static final Queue<?> f8329v = new C04402();
    final int f8330b;
    final int f8331c;
    final Segment<K, V>[] f8332d;
    final int f8333e;
    final Equivalence<Object> f8334f;
    final Equivalence<Object> f8335g;
    final Strength f8336h;
    final Strength f8337i;
    final long f8338j;
    final Weigher<K, V> f8339k;
    final long f8340l;
    final long f8341m;
    final long f8342n;
    final Queue<RemovalNotification<K, V>> f8343o;
    final RemovalListener<K, V> f8344p;
    final Ticker f8345q;
    final EntryFactory f8346r;
    final StatsCounter f8347s;
    final CacheLoader<? super K, V> f8348t;
    Set<K> f8349w;
    Collection<V> f8350x;
    Set<Entry<K, V>> f8351y;

    static class C04402 extends AbstractQueue<Object> {
        public final boolean offer(Object obj) {
            return true;
        }

        public final Object peek() {
            return null;
        }

        public final Object poll() {
            return null;
        }

        public final int size() {
            return 0;
        }

        C04402() {
        }

        public final Iterator<Object> iterator() {
            return ImmutableSet.m14751e().mo2397a();
        }
    }

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        final ConcurrentMap<?, ?> f8277a;
        final /* synthetic */ LocalCache f8278b;

        AbstractCacheSet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f8278b = localCache;
            this.f8277a = concurrentMap;
        }

        public int size() {
            return this.f8277a.size();
        }

        public boolean isEmpty() {
            return this.f8277a.isEmpty();
        }

        public void clear() {
            this.f8277a.clear();
        }

        public Object[] toArray() {
            return LocalCache.m7023a((Collection) this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.m7023a((Collection) this).toArray(eArr);
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> f8279a = new C16041(this);

        class C16041 extends AbstractReferenceEntry<K, V> {
            ReferenceEntry<K, V> f18409a = this;
            ReferenceEntry<K, V> f18410b = this;
            final /* synthetic */ AccessQueue f18411c;

            public final void mo2358a(long j) {
            }

            public final long mo2368e() {
                return Long.MAX_VALUE;
            }

            C16041(AccessQueue accessQueue) {
                this.f18411c = accessQueue;
            }

            public final ReferenceEntry<K, V> mo2369f() {
                return this.f18409a;
            }

            public final void mo2360a(ReferenceEntry<K, V> referenceEntry) {
                this.f18409a = referenceEntry;
            }

            public final ReferenceEntry<K, V> mo2370g() {
                return this.f18410b;
            }

            public final void mo2363b(ReferenceEntry<K, V> referenceEntry) {
                this.f18410b = referenceEntry;
            }
        }

        AccessQueue() {
        }

        public final /* synthetic */ boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            LocalCache.m7026a(referenceEntry.mo2370g(), referenceEntry.mo2369f());
            LocalCache.m7026a(this.f8279a.mo2370g(), referenceEntry);
            LocalCache.m7026a(referenceEntry, this.f8279a);
            return true;
        }

        public final /* synthetic */ Object peek() {
            return m6957a();
        }

        private ReferenceEntry<K, V> m6957a() {
            ReferenceEntry<K, V> f = this.f8279a.mo2369f();
            return f == this.f8279a ? null : f;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry g = referenceEntry.mo2370g();
            ReferenceEntry f = referenceEntry.mo2369f();
            LocalCache.m7026a(g, f);
            LocalCache.m7025a(referenceEntry);
            return f != NullEntry.f14859a ? true : null;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).mo2369f() != NullEntry.f14859a ? true : null;
        }

        public final boolean isEmpty() {
            return this.f8279a.mo2369f() == this.f8279a;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry f = this.f8279a.mo2369f(); f != this.f8279a; f = f.mo2369f()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry f = this.f8279a.mo2369f();
            while (f != this.f8279a) {
                ReferenceEntry f2 = f.mo2369f();
                LocalCache.m7025a(f);
                f = f2;
            }
            this.f8279a.mo2360a(this.f8279a);
            this.f8279a.mo2363b(this.f8279a);
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, m6957a()) {
                final /* synthetic */ AccessQueue f18412a;

                protected final /* synthetic */ Object mo3591a(Object obj) {
                    ReferenceEntry f = ((ReferenceEntry) obj).mo2369f();
                    return f == this.f18412a.f8279a ? null : f;
                }
            };
        }

        public final /* synthetic */ Object poll() {
            ReferenceEntry f = this.f8279a.mo2369f();
            if (f == this.f8279a) {
                return null;
            }
            remove(f);
            return f;
        }
    }

    enum EntryFactory {
        ;
        
        static final EntryFactory[] f8288i = null;

        abstract <K, V> ReferenceEntry<K, V> mo2374a(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry);

        static {
            f8288i = new EntryFactory[]{f8280a, f8281b, f8282c, f8283d, f8284e, f8285f, f8286g, f8287h};
        }

        static EntryFactory m6958a(Strength strength, boolean z, boolean z2) {
            int i = 0;
            strength = (strength == Strength.f8319c ? 4 : null) | z;
            if (z2) {
                i = 2;
            }
            return f8288i[strength | i];
        }

        <K, V> ReferenceEntry<K, V> mo2375a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return mo2374a(segment, referenceEntry.mo2366d(), referenceEntry.mo2364c(), referenceEntry2);
        }

        static <K, V> void m6959a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.mo2358a(referenceEntry.mo2368e());
            LocalCache.m7026a(referenceEntry.mo2370g(), (ReferenceEntry) referenceEntry2);
            LocalCache.m7026a((ReferenceEntry) referenceEntry2, referenceEntry.mo2369f());
            LocalCache.m7025a((ReferenceEntry) referenceEntry);
        }

        static <K, V> void m6960b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.mo2362b(referenceEntry.mo2371h());
            LocalCache.m7028b(referenceEntry.mo2373j(), referenceEntry2);
            LocalCache.m7028b(referenceEntry2, referenceEntry.mo2372i());
            LocalCache.m7027b(referenceEntry);
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {
        int f8290b;
        int f8291c = -1;
        Segment<K, V> f8292d;
        AtomicReferenceArray<ReferenceEntry<K, V>> f8293e;
        ReferenceEntry<K, V> f8294f;
        WriteThroughEntry f8295g;
        WriteThroughEntry f8296h;
        final /* synthetic */ LocalCache f8297i;

        HashIterator(LocalCache localCache) {
            this.f8297i = localCache;
            this.f8290b = localCache.f8332d.length - 1;
            m6964b();
        }

        private void m6964b() {
            this.f8295g = null;
            if (!m6965c() && !m6966d()) {
                while (this.f8290b >= 0) {
                    Segment[] segmentArr = this.f8297i.f8332d;
                    int i = this.f8290b;
                    this.f8290b = i - 1;
                    this.f8292d = segmentArr[i];
                    if (this.f8292d.f8304b != 0) {
                        this.f8293e = this.f8292d.f8308f;
                        this.f8291c = this.f8293e.length() - 1;
                        if (m6966d()) {
                            return;
                        }
                    }
                }
            }
        }

        private boolean m6965c() {
            if (this.f8294f != null) {
                do {
                    this.f8294f = this.f8294f.mo2361b();
                    if (this.f8294f != null) {
                    }
                } while (!m6963a(this.f8294f));
                return true;
            }
            return false;
        }

        private boolean m6966d() {
            while (this.f8291c >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.f8293e;
                int i = this.f8291c;
                this.f8291c = i - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
                this.f8294f = referenceEntry;
                if (referenceEntry != null && (m6963a(this.f8294f) || m6965c())) {
                    return true;
                }
            }
            return false;
        }

        private boolean m6963a(ReferenceEntry<K, V> referenceEntry) {
            try {
                long a = this.f8297i.f8345q.mo2329a();
                Object d = referenceEntry.mo2366d();
                LocalCache localCache = this.f8297i;
                Object obj = null;
                if (referenceEntry.mo2366d() != null) {
                    Object obj2 = referenceEntry.mo2357a().get();
                    if (obj2 != null) {
                        if (localCache.m7037a((ReferenceEntry) referenceEntry, a) == null) {
                            obj = obj2;
                        }
                    }
                }
                if (obj != null) {
                    this.f8295g = new WriteThroughEntry(this.f8297i, d, obj);
                    return true;
                }
                this.f8292d.m7003a();
                return null;
            } finally {
                this.f8292d.m7003a();
            }
        }

        public boolean hasNext() {
            return this.f8295g != null;
        }

        final WriteThroughEntry m6967a() {
            if (this.f8295g == null) {
                throw new NoSuchElementException();
            }
            this.f8296h = this.f8295g;
            m6964b();
            return this.f8296h;
        }

        public void remove() {
            Preconditions.m6921b(this.f8296h != null);
            this.f8297i.remove(this.f8296h.getKey());
            this.f8296h = null;
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final LocalCache<K, V> f8303a;
        volatile int f8304b;
        long f8305c;
        int f8306d;
        int f8307e;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> f8308f;
        final long f8309g;
        final ReferenceQueue<K> f8310h;
        final ReferenceQueue<V> f8311i;
        final Queue<ReferenceEntry<K, V>> f8312j;
        final AtomicInteger f8313k = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> f8314l;
        final Queue<ReferenceEntry<K, V>> f8315m;
        final StatsCounter f8316n;

        Segment(LocalCache<K, V> localCache, int i, long j, StatsCounter statsCounter) {
            this.f8303a = localCache;
            this.f8309g = j;
            this.f8316n = (StatsCounter) Preconditions.m6908a((Object) statsCounter);
            i = m6975a(i);
            this.f8307e = (i.length() * 3) / 4;
            if (this.f8303a.m7038b() == null && ((long) this.f8307e) == this.f8309g) {
                this.f8307e++;
            }
            this.f8308f = i;
            j = null;
            this.f8310h = localCache.m7044h() != 0 ? new ReferenceQueue() : 0;
            if (localCache.m7045i() != 0) {
                j = new ReferenceQueue();
            }
            this.f8311i = j;
            if (localCache.m7042f() != 0) {
                i = new ConcurrentLinkedQueue();
            } else {
                i = LocalCache.m7031l();
            }
            this.f8312j = i;
            if (localCache.m7039c() != 0) {
                i = new WriteQueue();
            } else {
                i = LocalCache.m7031l();
            }
            this.f8314l = i;
            if (localCache.m7042f() != null) {
                localCache = new AccessQueue();
            } else {
                localCache = LocalCache.m7031l();
            }
            this.f8315m = localCache;
        }

        private static AtomicReferenceArray<ReferenceEntry<K, V>> m6975a(int i) {
            return new AtomicReferenceArray(i);
        }

        private ReferenceEntry<K, V> m6972a(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            return this.f8303a.f8346r.mo2374a(this, Preconditions.m6908a((Object) k), i, referenceEntry);
        }

        private ReferenceEntry<K, V> m6969a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.mo2366d() == null) {
                return null;
            }
            ValueReference a = referenceEntry.mo2357a();
            Object obj = a.get();
            if (obj == null && a.mo2354d()) {
                return null;
            }
            referenceEntry = this.f8303a.f8346r.mo2375a(this, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            referenceEntry.mo2359a(a.mo2350a(this.f8311i, obj, referenceEntry));
            return referenceEntry;
        }

        private void m6977a(ReferenceEntry<K, V> referenceEntry, V v, long j) {
            ValueReference a = referenceEntry.mo2357a();
            Weigher weigher = this.f8303a.f8339k;
            Preconditions.m6922b(true, (Object) "Weights must be non-negative");
            referenceEntry.mo2359a(this.f8303a.f8337i.mo2378a(this, referenceEntry, v));
            m6993f();
            this.f8305c++;
            if (this.f8303a.m7040d()) {
                referenceEntry.mo2358a(j);
            }
            if (this.f8303a.m7043g()) {
                referenceEntry.mo2362b(j);
            }
            this.f8315m.add(referenceEntry);
            this.f8314l.add(referenceEntry);
            a.mo2351a(v);
        }

        final V m6998a(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            Preconditions.m6908a((Object) k);
            Preconditions.m6908a((Object) cacheLoader);
            try {
                if (this.f8304b != 0) {
                    ReferenceEntry d = m6990d(k, i);
                    if (d != null) {
                        long a = this.f8303a.f8345q.mo2329a();
                        Object a2 = m6996a(d, a);
                        if (a2 != null) {
                            m6987b(d, a);
                            this.f8316n.mo2331a(1);
                            k = m6973a(d, (Object) k, i, a2, a, (CacheLoader) cacheLoader);
                            m7003a();
                            return k;
                        }
                        ValueReference a3 = d.mo2357a();
                        if (a3.mo2353c()) {
                            k = m6974a(d, (Object) k, a3);
                            m7003a();
                            return k;
                        }
                    }
                }
                k = m6984b((Object) k, i, (CacheLoader) cacheLoader);
                m7003a();
                return k;
            } catch (K k2) {
                i = k2.getCause();
                if ((i instanceof Error) != null) {
                    throw new ExecutionError((Error) i);
                } else if ((i instanceof RuntimeException) != null) {
                    throw new UncheckedExecutionException(i);
                } else {
                    throw k2;
                }
            } catch (Throwable th) {
                m7003a();
            }
        }

        private V m6984b(K r18, int r19, com.google.common.cache.CacheLoader<? super K, V> r20) throws java.util.concurrent.ExecutionException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.utils.BlockUtils.getBlockByInsn(BlockUtils.java:172)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:90)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r17 = this;
            r1 = r17;
            r2 = r18;
            r3 = r19;
            r17.lock();
            r4 = r1.f8303a;	 Catch:{ all -> 0x00d4 }
            r4 = r4.f8345q;	 Catch:{ all -> 0x00d4 }
            r4 = r4.mo2329a();	 Catch:{ all -> 0x00d4 }
            r1.m7004a(r4);	 Catch:{ all -> 0x00d4 }
            r6 = r1.f8304b;	 Catch:{ all -> 0x00d4 }
            r7 = 1;	 Catch:{ all -> 0x00d4 }
            r6 = r6 - r7;	 Catch:{ all -> 0x00d4 }
            r8 = r1.f8308f;	 Catch:{ all -> 0x00d4 }
            r9 = r8.length();	 Catch:{ all -> 0x00d4 }
            r9 = r9 - r7;	 Catch:{ all -> 0x00d4 }
            r9 = r9 & r3;	 Catch:{ all -> 0x00d4 }
            r10 = r8.get(r9);	 Catch:{ all -> 0x00d4 }
            r10 = (com.google.common.cache.ReferenceEntry) r10;	 Catch:{ all -> 0x00d4 }
            r11 = r10;	 Catch:{ all -> 0x00d4 }
        L_0x0027:
            if (r11 == 0) goto L_0x008e;	 Catch:{ all -> 0x00d4 }
        L_0x0029:
            r13 = r11.mo2366d();	 Catch:{ all -> 0x00d4 }
            r14 = r11.mo2364c();	 Catch:{ all -> 0x00d4 }
            if (r14 != r3) goto L_0x0089;	 Catch:{ all -> 0x00d4 }
        L_0x0033:
            if (r13 == 0) goto L_0x0089;	 Catch:{ all -> 0x00d4 }
        L_0x0035:
            r14 = r1.f8303a;	 Catch:{ all -> 0x00d4 }
            r14 = r14.f8334f;	 Catch:{ all -> 0x00d4 }
            r14 = r14.m6878a(r2, r13);	 Catch:{ all -> 0x00d4 }
            if (r14 == 0) goto L_0x0089;	 Catch:{ all -> 0x00d4 }
        L_0x003f:
            r14 = r11.mo2357a();	 Catch:{ all -> 0x00d4 }
            r15 = r14.mo2353c();	 Catch:{ all -> 0x00d4 }
            if (r15 == 0) goto L_0x004b;	 Catch:{ all -> 0x00d4 }
        L_0x0049:
            r4 = 0;	 Catch:{ all -> 0x00d4 }
            goto L_0x0090;	 Catch:{ all -> 0x00d4 }
        L_0x004b:
            r15 = r14.get();	 Catch:{ all -> 0x00d4 }
            if (r15 != 0) goto L_0x005b;	 Catch:{ all -> 0x00d4 }
        L_0x0051:
            r4 = r14.mo2349a();	 Catch:{ all -> 0x00d4 }
            r5 = com.google.common.cache.RemovalCause.f8355c;	 Catch:{ all -> 0x00d4 }
            r1.m7005a(r13, r15, r4, r5);	 Catch:{ all -> 0x00d4 }
            goto L_0x006c;	 Catch:{ all -> 0x00d4 }
        L_0x005b:
            r12 = r1.f8303a;	 Catch:{ all -> 0x00d4 }
            r12 = r12.m7037a(r11, r4);	 Catch:{ all -> 0x00d4 }
            if (r12 == 0) goto L_0x007a;	 Catch:{ all -> 0x00d4 }
        L_0x0063:
            r4 = r14.mo2349a();	 Catch:{ all -> 0x00d4 }
            r5 = com.google.common.cache.RemovalCause.f8356d;	 Catch:{ all -> 0x00d4 }
            r1.m7005a(r13, r15, r4, r5);	 Catch:{ all -> 0x00d4 }
        L_0x006c:
            r4 = r1.f8314l;	 Catch:{ all -> 0x00d4 }
            r4.remove(r11);	 Catch:{ all -> 0x00d4 }
            r4 = r1.f8315m;	 Catch:{ all -> 0x00d4 }
            r4.remove(r11);	 Catch:{ all -> 0x00d4 }
            r1.f8304b = r6;	 Catch:{ all -> 0x00d4 }
            r4 = r7;	 Catch:{ all -> 0x00d4 }
            goto L_0x0090;	 Catch:{ all -> 0x00d4 }
        L_0x007a:
            r1.m6989c(r11, r4);	 Catch:{ all -> 0x00d4 }
            r2 = r1.f8316n;	 Catch:{ all -> 0x00d4 }
            r2.mo2331a(r7);	 Catch:{ all -> 0x00d4 }
            r17.unlock();
            r17.m7011c();
            return r15;
        L_0x0089:
            r11 = r11.mo2361b();	 Catch:{ all -> 0x00d4 }
            goto L_0x0027;	 Catch:{ all -> 0x00d4 }
        L_0x008e:
            r4 = r7;	 Catch:{ all -> 0x00d4 }
            r14 = 0;	 Catch:{ all -> 0x00d4 }
        L_0x0090:
            if (r4 == 0) goto L_0x00a8;	 Catch:{ all -> 0x00d4 }
        L_0x0092:
            r12 = new com.google.common.cache.LocalCache$LoadingValueReference;	 Catch:{ all -> 0x00d4 }
            r12.<init>();	 Catch:{ all -> 0x00d4 }
            if (r11 != 0) goto L_0x00a4;	 Catch:{ all -> 0x00d4 }
        L_0x0099:
            r11 = r1.m6972a(r2, r3, r10);	 Catch:{ all -> 0x00d4 }
            r11.mo2359a(r12);	 Catch:{ all -> 0x00d4 }
            r8.set(r9, r11);	 Catch:{ all -> 0x00d4 }
            goto L_0x00a9;	 Catch:{ all -> 0x00d4 }
        L_0x00a4:
            r11.mo2359a(r12);	 Catch:{ all -> 0x00d4 }
            goto L_0x00a9;
        L_0x00a8:
            r12 = 0;
        L_0x00a9:
            r17.unlock();
            r17.m7011c();
            if (r4 == 0) goto L_0x00cf;
        L_0x00b1:
            monitor-enter(r11);	 Catch:{ all -> 0x00c7 }
            r4 = r20;
            r4 = r12.m14621a(r2, r4);	 Catch:{ all -> 0x00c3 }
            r2 = r1.m7000a(r2, r3, r12, r4);	 Catch:{ all -> 0x00c3 }
            monitor-exit(r11);	 Catch:{ all -> 0x00c3 }
            r3 = r1.f8316n;
            r3.mo2334b(r7);
            return r2;
        L_0x00c3:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r11);	 Catch:{ all -> 0x00c3 }
            throw r2;	 Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r0 = move-exception;
            r2 = r0;
            r3 = r1.f8316n;
            r3.mo2334b(r7);
            throw r2;
        L_0x00cf:
            r2 = r1.m6974a(r11, r2, r14);
            return r2;
        L_0x00d4:
            r0 = move-exception;
            r2 = r0;
            r17.unlock();
            r17.m7011c();
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.b(java.lang.Object, int, com.google.common.cache.CacheLoader):V");
        }

        private V m6974a(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.mo2353c()) {
                Preconditions.m6923b(Thread.holdsLock(referenceEntry) ^ true, "Recursive load of: %s", k);
                try {
                    valueReference = valueReference.mo2355e();
                    if (valueReference == null) {
                        valueReference = new StringBuilder("CacheLoader returned null for key ");
                        valueReference.append(k);
                        valueReference.append(".");
                        throw new InvalidCacheLoadException(valueReference.toString());
                    }
                    m6987b((ReferenceEntry) referenceEntry, this.f8303a.f8345q.mo2329a());
                    return valueReference;
                } finally {
                    this.f8316n.mo2334b(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        final V m7000a(K k, int i, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) throws ExecutionException {
            Throwable th;
            try {
                listenableFuture = Uninterruptibles.m7340a(listenableFuture);
                if (listenableFuture == null) {
                    try {
                        StringBuilder stringBuilder = new StringBuilder("CacheLoader returned null for key ");
                        stringBuilder.append(k);
                        stringBuilder.append(".");
                        throw new InvalidCacheLoadException(stringBuilder.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        if (listenableFuture == null) {
                            this.f8316n.mo2335b(loadingValueReference.m14629f());
                            m6980a((Object) k, i, (LoadingValueReference) loadingValueReference);
                        }
                        throw th;
                    }
                }
                this.f8316n.mo2332a(loadingValueReference.m14629f());
                m6981a((Object) k, i, (LoadingValueReference) loadingValueReference, (Object) listenableFuture);
                if (listenableFuture == null) {
                    this.f8316n.mo2335b(loadingValueReference.m14629f());
                    m6980a((Object) k, i, (LoadingValueReference) loadingValueReference);
                }
                return listenableFuture;
            } catch (Throwable th3) {
                th = th3;
                listenableFuture = null;
                if (listenableFuture == null) {
                    this.f8316n.mo2335b(loadingValueReference.m14629f());
                    m6980a((Object) k, i, (LoadingValueReference) loadingValueReference);
                }
                throw th;
            }
        }

        private V m6973a(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            if (this.f8303a.m7041e() && j - referenceEntry.mo2371h() > this.f8303a.f8342n && referenceEntry.mo2357a().mo2353c() == null) {
                referenceEntry = m6999a((Object) k, i, (CacheLoader) cacheLoader, true);
                if (referenceEntry != null) {
                    return referenceEntry;
                }
            }
            return v;
        }

        final V m6999a(K r8, int r9, com.google.common.cache.CacheLoader<? super K, V> r10, boolean r11) {
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
            r7 = this;
            r4 = r7.m6968a(r8, r9, r11);
            r11 = 0;
            if (r4 != 0) goto L_0x0008;
        L_0x0007:
            return r11;
        L_0x0008:
            r10 = r4.m14621a(r8, r10);
            r6 = new com.google.common.cache.LocalCache$Segment$1;
            r0 = r6;
            r1 = r7;
            r2 = r8;
            r3 = r9;
            r5 = r10;
            r0.<init>(r1, r2, r3, r4, r5);
            r8 = com.google.common.util.concurrent.MoreExecutors.m7338a();
            r10.mo4057a(r6, r8);
            r8 = r10.isDone();
            if (r8 == 0) goto L_0x0028;
        L_0x0023:
            r8 = com.google.common.util.concurrent.Uninterruptibles.m7340a(r10);	 Catch:{ Throwable -> 0x0028 }
            return r8;
        L_0x0028:
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a(java.lang.Object, int, com.google.common.cache.CacheLoader, boolean):V");
        }

        private LoadingValueReference<K, V> m6968a(K k, int i, boolean z) {
            lock();
            try {
                long a = this.f8303a.f8345q.mo2329a();
                m7004a(a);
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(k, d)) {
                        k = referenceEntry2.mo2357a();
                        if (k.mo2353c() == 0) {
                            if (!z || a - referenceEntry2.mo2371h() >= this.f8303a.f8342n) {
                                this.f8306d++;
                                ValueReference loadingValueReference = new LoadingValueReference(k);
                                referenceEntry2.mo2359a(loadingValueReference);
                                unlock();
                                m7011c();
                                return loadingValueReference;
                            }
                        }
                        unlock();
                        m7011c();
                        return null;
                    }
                    referenceEntry2 = referenceEntry2.mo2361b();
                }
                this.f8306d++;
                ValueReference loadingValueReference2 = new LoadingValueReference();
                k = m6972a((Object) k, i, referenceEntry);
                k.mo2359a(loadingValueReference2);
                atomicReferenceArray.set(length, k);
                unlock();
                m7011c();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                m7011c();
            }
        }

        private void m6991d() {
            if (tryLock()) {
                try {
                    m6992e();
                } finally {
                    unlock();
                }
            }
        }

        private void m6992e() {
            int i = 0;
            if (this.f8303a.m7044h()) {
                int i2 = 0;
                do {
                    Reference poll = this.f8310h.poll();
                    if (poll == null) {
                        break;
                    }
                    ReferenceEntry referenceEntry = (ReferenceEntry) poll;
                    LocalCache localCache = this.f8303a;
                    int c = referenceEntry.mo2364c();
                    localCache.m7033a(c).m6978a(referenceEntry, c);
                    i2++;
                } while (i2 != 16);
            }
            if (this.f8303a.m7045i()) {
                do {
                    Reference poll2 = this.f8311i.poll();
                    if (poll2 != null) {
                        ValueReference valueReference = (ValueReference) poll2;
                        LocalCache localCache2 = this.f8303a;
                        ReferenceEntry b = valueReference.mo2352b();
                        c = b.mo2364c();
                        localCache2.m7033a(c).m6982a(b.mo2366d(), c, valueReference);
                        i++;
                    } else {
                        return;
                    }
                } while (i != 16);
            }
        }

        private void m6987b(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.f8303a.m7040d()) {
                referenceEntry.mo2358a(j);
            }
            this.f8312j.add(referenceEntry);
        }

        private void m6989c(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.f8303a.m7040d()) {
                referenceEntry.mo2358a(j);
            }
            this.f8315m.add(referenceEntry);
        }

        private void m6993f() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.f8312j.poll();
                if (referenceEntry == null) {
                    return;
                }
                if (this.f8315m.contains(referenceEntry)) {
                    this.f8315m.add(referenceEntry);
                }
            }
        }

        private void m6985b(long j) {
            if (tryLock()) {
                try {
                    m6988c(j);
                } finally {
                    unlock();
                }
            }
        }

        private void m6988c(long j) {
            m6993f();
            ReferenceEntry referenceEntry;
            do {
                referenceEntry = (ReferenceEntry) this.f8314l.peek();
                if (referenceEntry == null || !this.f8303a.m7037a(referenceEntry, j)) {
                    do {
                        referenceEntry = (ReferenceEntry) this.f8315m.peek();
                        if (referenceEntry == null || !this.f8303a.m7037a(referenceEntry, j)) {
                            return;
                        }
                    } while (m6979a(referenceEntry, referenceEntry.mo2364c(), RemovalCause.f8356d));
                    throw new AssertionError();
                }
            } while (m6979a(referenceEntry, referenceEntry.mo2364c(), RemovalCause.f8356d));
            throw new AssertionError();
        }

        final void m7005a(K k, V v, int i, RemovalCause removalCause) {
            this.f8305c -= (long) i;
            if (removalCause.mo2383a() != 0) {
                this.f8316n.mo2330a();
            }
            if (this.f8303a.f8343o != LocalCache.f8329v) {
                this.f8303a.f8343o.offer(RemovalNotification.m7069a(k, v, removalCause));
            }
        }

        private void m6976a(ReferenceEntry<K, V> referenceEntry) {
            if (this.f8303a.m7036a()) {
                m6993f();
                if (((long) referenceEntry.mo2357a().mo2349a()) <= this.f8309g || m6979a((ReferenceEntry) referenceEntry, referenceEntry.mo2364c(), RemovalCause.f8357e) != null) {
                    while (this.f8305c > this.f8309g) {
                        ReferenceEntry g = m6994g();
                        if (m6979a(g, g.mo2364c(), RemovalCause.f8357e) == null) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        private ReferenceEntry<K, V> m6994g() {
            for (ReferenceEntry<K, V> referenceEntry : this.f8315m) {
                if (referenceEntry.mo2357a().mo2349a() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        private ReferenceEntry<K, V> m6971a(Object obj, int i, long j) {
            ReferenceEntry d = m6990d(obj, i);
            if (d == null) {
                return null;
            }
            if (!this.f8303a.m7037a(d, j)) {
                return d;
            }
            m6985b(j);
            return null;
        }

        final V m6996a(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.mo2366d() == null) {
                m6991d();
                return null;
            }
            V v = referenceEntry.mo2357a().get();
            if (v == null) {
                m6991d();
                return null;
            } else if (this.f8303a.m7037a((ReferenceEntry) referenceEntry, j) == null) {
                return v;
            } else {
                m6985b(j);
                return null;
            }
        }

        final V m6997a(Object obj, int i) {
            try {
                V v = null;
                if (this.f8304b != 0) {
                    long a = this.f8303a.f8345q.mo2329a();
                    ReferenceEntry a2 = m6971a(obj, i, a);
                    if (a2 == null) {
                        return v;
                    }
                    Object obj2 = a2.mo2357a().get();
                    if (obj2 != null) {
                        m6987b(a2, a);
                        obj = m6973a(a2, a2.mo2366d(), i, obj2, a, this.f8303a.f8348t);
                        m7003a();
                        return obj;
                    }
                    m6991d();
                }
                m7003a();
                return v;
            } finally {
                m7003a();
            }
        }

        final boolean m7008b(Object obj, int i) {
            try {
                boolean z = false;
                if (this.f8304b != 0) {
                    obj = m6971a(obj, i, this.f8303a.f8345q.mo2329a());
                    if (obj == null) {
                        return z;
                    }
                    if (obj.mo2357a().get() != null) {
                        z = true;
                    }
                    m7003a();
                    return z;
                }
                m7003a();
                return z;
            } finally {
                m7003a();
            }
        }

        final V m7002a(K k, int i, V v, boolean z) {
            lock();
            try {
                V v2;
                long a = this.f8303a.f8345q.mo2329a();
                m7004a(a);
                if (this.f8304b + 1 > this.f8307e) {
                    m6995h();
                    int i2 = this.f8304b;
                }
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    v2 = null;
                    if (referenceEntry2 != null) {
                        Object d = referenceEntry2.mo2366d();
                        if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(k, d)) {
                            break;
                        }
                        referenceEntry2 = referenceEntry2.mo2361b();
                    } else {
                        this.f8306d++;
                        ReferenceEntry a2 = m6972a((Object) k, i, referenceEntry);
                        m6977a(a2, (Object) v, a);
                        atomicReferenceArray.set(length, a2);
                        this.f8304b++;
                        m6976a(a2);
                        unlock();
                        m7011c();
                        return v2;
                    }
                }
                i = referenceEntry2.mo2357a();
                Object obj = i.get();
                if (obj == null) {
                    this.f8306d++;
                    if (i.mo2354d()) {
                        m7005a((Object) k, obj, i.mo2349a(), RemovalCause.f8355c);
                        m6977a(referenceEntry2, (Object) v, a);
                        k = this.f8304b;
                    } else {
                        m6977a(referenceEntry2, (Object) v, a);
                        k = this.f8304b + 1;
                    }
                    this.f8304b = k;
                    m6976a(referenceEntry2);
                    return v2;
                } else if (z) {
                    m6989c(referenceEntry2, a);
                    unlock();
                    m7011c();
                    return obj;
                } else {
                    this.f8306d++;
                    m7005a((Object) k, obj, i.mo2349a(), RemovalCause.f8354b);
                    m6977a(referenceEntry2, (Object) v, a);
                    m6976a(referenceEntry2);
                    unlock();
                    m7011c();
                    return obj;
                }
            } finally {
                unlock();
                m7011c();
            }
        }

        private void m6995h() {
            AtomicReferenceArray atomicReferenceArray = this.f8308f;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.f8304b;
                AtomicReferenceArray a = m6975a(length << 1);
                this.f8307e = (a.length() * 3) / 4;
                int length2 = a.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry b = referenceEntry.mo2361b();
                        int c = referenceEntry.mo2364c() & length2;
                        if (b == null) {
                            a.set(c, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (b != null) {
                                int c2 = b.mo2364c() & length2;
                                if (c2 != c) {
                                    referenceEntry2 = b;
                                    c = c2;
                                }
                                b = b.mo2361b();
                            }
                            a.set(c, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int c3 = referenceEntry.mo2364c() & length2;
                                ReferenceEntry a2 = m6969a(referenceEntry, (ReferenceEntry) a.get(c3));
                                if (a2 != null) {
                                    a.set(c3, a2);
                                } else {
                                    m6986b(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.mo2361b();
                            }
                        }
                    }
                }
                this.f8308f = a;
                this.f8304b = i;
            }
        }

        final boolean m7006a(K k, int i, V v, V v2) {
            Segment segment = this;
            Object obj = k;
            int i2 = i;
            lock();
            try {
                long a = segment.f8303a.f8345q.mo2329a();
                m7004a(a);
                AtomicReferenceArray atomicReferenceArray = segment.f8308f;
                int length = i2 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.mo2361b()) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() == i2 && d != null && segment.f8303a.f8334f.m6878a(obj, d)) {
                        ValueReference a2 = referenceEntry2.mo2357a();
                        Object obj2 = a2.get();
                        if (obj2 == null) {
                            if (a2.mo2354d()) {
                                int i3 = segment.f8304b;
                                segment.f8306d++;
                                i2 = segment.f8304b - 1;
                                atomicReferenceArray.set(length, m6970a(referenceEntry, referenceEntry2, d, obj2, a2, RemovalCause.f8355c));
                                segment.f8304b = i2;
                            }
                            unlock();
                            m7011c();
                            return false;
                        } else if (segment.f8303a.f8335g.m6878a(v, obj2)) {
                            segment.f8306d++;
                            m7005a(obj, obj2, a2.mo2349a(), RemovalCause.f8354b);
                            m6977a(referenceEntry2, (Object) v2, a);
                            m6976a(referenceEntry2);
                            unlock();
                            m7011c();
                            return true;
                        } else {
                            m6989c(referenceEntry2, a);
                            unlock();
                            m7011c();
                            return false;
                        }
                    }
                    V v3 = v;
                    V v4 = v2;
                }
                unlock();
                m7011c();
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                unlock();
                m7011c();
            }
        }

        final V m7001a(K k, int i, V v) {
            lock();
            try {
                long a = this.f8303a.f8345q.mo2329a();
                m7004a(a);
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.mo2361b()) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(k, d)) {
                        ValueReference a2 = referenceEntry2.mo2357a();
                        Object obj = a2.get();
                        if (obj == null) {
                            if (a2.mo2354d() != null) {
                                k = this.f8304b;
                                this.f8306d++;
                                i = this.f8304b - 1;
                                atomicReferenceArray.set(length, m6970a(referenceEntry, referenceEntry2, d, obj, a2, RemovalCause.f8355c));
                                this.f8304b = i;
                            }
                            unlock();
                            m7011c();
                            return null;
                        }
                        this.f8306d++;
                        m7005a((Object) k, obj, a2.mo2349a(), RemovalCause.f8354b);
                        m6977a(referenceEntry2, (Object) v, a);
                        m6976a(referenceEntry2);
                        unlock();
                        m7011c();
                        return obj;
                    }
                }
                unlock();
                m7011c();
                return null;
            } catch (Throwable th) {
                unlock();
                m7011c();
            }
        }

        final V m7010c(Object obj, int i) {
            lock();
            try {
                m7004a(this.f8303a.f8345q.mo2329a());
                int i2 = this.f8304b;
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.mo2361b()) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(obj, d)) {
                        ValueReference a = referenceEntry2.mo2357a();
                        obj = a.get();
                        if (obj != null) {
                            i = RemovalCause.f8353a;
                        } else if (a.mo2354d() != 0) {
                            i = RemovalCause.f8355c;
                        } else {
                            unlock();
                            m7011c();
                            return null;
                        }
                        RemovalCause removalCause = i;
                        this.f8306d++;
                        int i3 = this.f8304b - 1;
                        atomicReferenceArray.set(length, m6970a(referenceEntry, referenceEntry2, d, obj, a, removalCause));
                        this.f8304b = i3;
                        return obj;
                    }
                }
                unlock();
                m7011c();
                return null;
            } finally {
                unlock();
                m7011c();
            }
        }

        private boolean m6981a(K k, int i, LoadingValueReference<K, V> loadingValueReference, V v) {
            lock();
            long a = this.f8303a.f8345q.mo2329a();
            m7004a(a);
            boolean z = true;
            int i2 = this.f8304b + z;
            if (i2 > this.f8307e) {
                m6995h();
                i2 = this.f8304b + z;
            }
            AtomicReferenceArray atomicReferenceArray = this.f8308f;
            int length = (atomicReferenceArray.length() - z) & i;
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            ReferenceEntry referenceEntry2 = referenceEntry;
            while (referenceEntry2 != null) {
                Object d = referenceEntry2.mo2366d();
                if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(k, d)) {
                    i = referenceEntry2.mo2357a();
                    Object obj = i.get();
                    if (loadingValueReference != i) {
                        if (obj != null || i == LocalCache.f8328u) {
                            m7005a((Object) k, (Object) v, 0, RemovalCause.f8354b);
                            unlock();
                            m7011c();
                            return false;
                        }
                    }
                    this.f8306d += z;
                    if (loadingValueReference.mo2354d() != 0) {
                        m7005a((Object) k, obj, loadingValueReference.mo2349a(), obj == null ? RemovalCause.f8355c : RemovalCause.f8354b);
                        i2--;
                    }
                    m6977a(referenceEntry2, (Object) v, a);
                    this.f8304b = i2;
                    m6976a(referenceEntry2);
                    return z;
                }
                try {
                    referenceEntry2 = referenceEntry2.mo2361b();
                } finally {
                    unlock();
                    m7011c();
                }
            }
            this.f8306d += z;
            ReferenceEntry a2 = m6972a((Object) k, i, referenceEntry);
            m6977a(a2, (Object) v, a);
            atomicReferenceArray.set(length, a2);
            this.f8304b = i2;
            m6976a(a2);
            unlock();
            m7011c();
            return z;
        }

        final boolean m7009b(Object obj, int i, Object obj2) {
            lock();
            try {
                m7004a(this.f8303a.f8345q.mo2329a());
                int i2 = this.f8304b;
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.mo2361b()) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() == i && d != null && this.f8303a.f8334f.m6878a(obj, d)) {
                        RemovalCause removalCause;
                        ValueReference a = referenceEntry2.mo2357a();
                        Object obj3 = a.get();
                        if (this.f8303a.f8335g.m6878a(obj2, obj3) != null) {
                            removalCause = RemovalCause.f8353a;
                        } else if (obj3 != null || a.mo2354d() == null) {
                            unlock();
                            m7011c();
                            return false;
                        } else {
                            removalCause = RemovalCause.f8355c;
                        }
                        this.f8306d++;
                        obj2 = this.f8304b - 1;
                        atomicReferenceArray.set(length, m6970a(referenceEntry, referenceEntry2, d, obj3, a, removalCause));
                        this.f8304b = obj2;
                        if (removalCause != RemovalCause.f8353a) {
                            z = false;
                        }
                        unlock();
                        m7011c();
                        return z;
                    }
                }
                unlock();
                m7011c();
                return false;
            } catch (Throwable th) {
                unlock();
                m7011c();
            }
        }

        private ReferenceEntry<K, V> m6970a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            m7005a((Object) k, (Object) v, valueReference.mo2349a(), removalCause);
            this.f8314l.remove(referenceEntry2);
            this.f8315m.remove(referenceEntry2);
            if (valueReference.mo2353c() == null) {
                return m6983b((ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            }
            valueReference.mo2351a(null);
            return referenceEntry;
        }

        private ReferenceEntry<K, V> m6983b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.f8304b;
            ReferenceEntry<K, V> b = referenceEntry2.mo2361b();
            ReferenceEntry b2;
            while (b2 != referenceEntry2) {
                ReferenceEntry<K, V> a = m6969a(b2, (ReferenceEntry) b);
                if (a != null) {
                    b = a;
                } else {
                    m6986b(b2);
                    i--;
                }
                b2 = b2.mo2361b();
            }
            this.f8304b = i;
            return b;
        }

        private void m6986b(ReferenceEntry<K, V> referenceEntry) {
            Object d = referenceEntry.mo2366d();
            referenceEntry.mo2364c();
            m7005a(d, referenceEntry.mo2357a().get(), referenceEntry.mo2357a().mo2349a(), RemovalCause.f8355c);
            this.f8314l.remove(referenceEntry);
            this.f8315m.remove(referenceEntry);
        }

        private boolean m6978a(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.f8304b;
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                boolean z = true;
                i &= atomicReferenceArray.length() - z;
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(i);
                for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.mo2361b()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.f8306d += z;
                        int i3 = this.f8304b - z;
                        atomicReferenceArray.set(i, m6970a(referenceEntry2, referenceEntry3, referenceEntry3.mo2366d(), referenceEntry3.mo2357a().get(), referenceEntry3.mo2357a(), RemovalCause.f8355c));
                        this.f8304b = i3;
                        return z;
                    }
                }
                unlock();
                m7011c();
                return null;
            } finally {
                unlock();
                m7011c();
            }
        }

        private boolean m6982a(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                int i2 = this.f8304b;
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                boolean z = true;
                int length = (atomicReferenceArray.length() - z) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() != i || d == null || !this.f8303a.f8334f.m6878a(k, d)) {
                        referenceEntry2 = referenceEntry2.mo2361b();
                    } else if (referenceEntry2.mo2357a() == valueReference) {
                        this.f8306d += z;
                        i = this.f8304b - z;
                        atomicReferenceArray.set(length, m6970a(referenceEntry, referenceEntry2, d, valueReference.get(), (ValueReference) valueReference, RemovalCause.f8355c));
                        this.f8304b = i;
                        return z;
                    } else {
                        unlock();
                        if (isHeldByCurrentThread() == null) {
                            m7011c();
                        }
                        return false;
                    }
                }
                unlock();
                if (isHeldByCurrentThread() == null) {
                    m7011c();
                }
                return false;
            } finally {
                unlock();
                if (isHeldByCurrentThread() == 0) {
                    m7011c();
                }
            }
        }

        private boolean m6980a(K k, int i, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f8308f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object d = referenceEntry2.mo2366d();
                    if (referenceEntry2.mo2364c() != i || d == null || !this.f8303a.f8334f.m6878a(k, d)) {
                        referenceEntry2 = referenceEntry2.mo2361b();
                    } else if (referenceEntry2.mo2357a() == loadingValueReference) {
                        if (loadingValueReference.mo2354d() != null) {
                            referenceEntry2.mo2359a(loadingValueReference.f14853a);
                        } else {
                            atomicReferenceArray.set(length, m6983b(referenceEntry, referenceEntry2));
                        }
                        unlock();
                        m7011c();
                        return true;
                    } else {
                        unlock();
                        m7011c();
                        return false;
                    }
                }
                unlock();
                m7011c();
                return false;
            } catch (Throwable th) {
                unlock();
                m7011c();
            }
        }

        private boolean m6979a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.f8304b;
            AtomicReferenceArray atomicReferenceArray = this.f8308f;
            i &= atomicReferenceArray.length() - 1;
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(i);
            for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.mo2361b()) {
                if (referenceEntry3 == referenceEntry) {
                    this.f8306d += 1;
                    referenceEntry = m6970a(referenceEntry2, referenceEntry3, referenceEntry3.mo2366d(), referenceEntry3.mo2357a().get(), referenceEntry3.mo2357a(), removalCause);
                    removalCause = this.f8304b - 1;
                    atomicReferenceArray.set(i, referenceEntry);
                    this.f8304b = removalCause;
                    return true;
                }
            }
            return null;
        }

        final void m7003a() {
            if ((this.f8313k.incrementAndGet() & 63) == 0) {
                m7007b();
            }
        }

        final void m7007b() {
            m7004a(this.f8303a.f8345q.mo2329a());
            m7011c();
        }

        final void m7004a(long j) {
            if (tryLock()) {
                try {
                    m6992e();
                    m6988c(j);
                    this.f8313k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        final void m7011c() {
            if (!isHeldByCurrentThread()) {
                do {
                } while (((RemovalNotification) this.f8303a.f8343o.poll()) != null);
            }
        }

        private ReferenceEntry<K, V> m6990d(Object obj, int i) {
            AtomicReferenceArray atomicReferenceArray = this.f8308f;
            for (ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); referenceEntry != null; referenceEntry = referenceEntry.mo2361b()) {
                if (referenceEntry.mo2364c() == i) {
                    Object d = referenceEntry.mo2366d();
                    if (d == null) {
                        m6991d();
                    } else if (this.f8303a.f8334f.m6878a(obj, d)) {
                        return referenceEntry;
                    }
                }
            }
            return null;
        }
    }

    enum Strength {
        ;

        abstract Equivalence<Object> mo2377a();

        abstract <K, V> ValueReference<K, V> mo2378a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v);
    }

    interface ValueReference<K, V> {
        int mo2349a();

        ValueReference<K, V> mo2350a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry);

        void mo2351a(V v);

        ReferenceEntry<K, V> mo2352b();

        boolean mo2353c();

        boolean mo2354d();

        V mo2355e() throws ExecutionException;

        V get();
    }

    final class Values extends AbstractCollection<V> {
        final /* synthetic */ LocalCache f8321a;
        private final ConcurrentMap<?, ?> f8322b;

        Values(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f8321a = localCache;
            this.f8322b = concurrentMap;
        }

        public final int size() {
            return this.f8322b.size();
        }

        public final boolean isEmpty() {
            return this.f8322b.isEmpty();
        }

        public final void clear() {
            this.f8322b.clear();
        }

        public final Iterator<V> iterator() {
            return new ValueIterator(this.f8321a);
        }

        public final boolean contains(Object obj) {
            return this.f8322b.containsValue(obj);
        }

        public final Object[] toArray() {
            return LocalCache.m7023a((Collection) this).toArray();
        }

        public final <E> E[] toArray(E[] eArr) {
            return LocalCache.m7023a((Collection) this).toArray(eArr);
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> f8323a = new C16061(this);

        class C16061 extends AbstractReferenceEntry<K, V> {
            ReferenceEntry<K, V> f18429a = this;
            ReferenceEntry<K, V> f18430b = this;
            final /* synthetic */ WriteQueue f18431c;

            public final void mo2362b(long j) {
            }

            public final long mo2371h() {
                return Long.MAX_VALUE;
            }

            C16061(WriteQueue writeQueue) {
                this.f18431c = writeQueue;
            }

            public final ReferenceEntry<K, V> mo2372i() {
                return this.f18429a;
            }

            public final void mo2365c(ReferenceEntry<K, V> referenceEntry) {
                this.f18429a = referenceEntry;
            }

            public final ReferenceEntry<K, V> mo2373j() {
                return this.f18430b;
            }

            public final void mo2367d(ReferenceEntry<K, V> referenceEntry) {
                this.f18430b = referenceEntry;
            }
        }

        WriteQueue() {
        }

        public final /* synthetic */ boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            LocalCache.m7028b(referenceEntry.mo2373j(), referenceEntry.mo2372i());
            LocalCache.m7028b(this.f8323a.mo2373j(), referenceEntry);
            LocalCache.m7028b(referenceEntry, this.f8323a);
            return true;
        }

        public final /* synthetic */ Object peek() {
            return m7021a();
        }

        private ReferenceEntry<K, V> m7021a() {
            ReferenceEntry<K, V> i = this.f8323a.mo2372i();
            return i == this.f8323a ? null : i;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry j = referenceEntry.mo2373j();
            ReferenceEntry i = referenceEntry.mo2372i();
            LocalCache.m7028b(j, i);
            LocalCache.m7027b(referenceEntry);
            return i != NullEntry.f14859a ? true : null;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).mo2372i() != NullEntry.f14859a ? true : null;
        }

        public final boolean isEmpty() {
            return this.f8323a.mo2372i() == this.f8323a;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry i2 = this.f8323a.mo2372i(); i2 != this.f8323a; i2 = i2.mo2372i()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry i = this.f8323a.mo2372i();
            while (i != this.f8323a) {
                ReferenceEntry i2 = i.mo2372i();
                LocalCache.m7027b(i);
                i = i2;
            }
            this.f8323a.mo2365c(this.f8323a);
            this.f8323a.mo2367d(this.f8323a);
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, m7021a()) {
                final /* synthetic */ WriteQueue f18432a;

                protected final /* synthetic */ Object mo3591a(Object obj) {
                    ReferenceEntry i = ((ReferenceEntry) obj).mo2372i();
                    return i == this.f18432a.f8323a ? null : i;
                }
            };
        }

        public final /* synthetic */ Object poll() {
            ReferenceEntry i = this.f8323a.mo2372i();
            if (i == this.f8323a) {
                return null;
            }
            remove(i);
            return i;
        }
    }

    final class WriteThroughEntry implements Entry<K, V> {
        final K f8324a;
        V f8325b;
        final /* synthetic */ LocalCache f8326c;

        WriteThroughEntry(LocalCache localCache, K k, V v) {
            this.f8326c = localCache;
            this.f8324a = k;
            this.f8325b = v;
        }

        public final K getKey() {
            return this.f8324a;
        }

        public final V getValue() {
            return this.f8325b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.f8324a.equals(entry.getKey()) || this.f8325b.equals(entry.getValue()) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f8324a.hashCode() ^ this.f8325b.hashCode();
        }

        public final V setValue(V v) {
            V put = this.f8326c.put(this.f8324a, v);
            this.f8325b = v;
            return put;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    static class C11501 implements ValueReference<Object, Object> {
        public final int mo2349a() {
            return 0;
        }

        public final ValueReference<Object, Object> mo2350a(ReferenceQueue<Object> referenceQueue, Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public final void mo2351a(Object obj) {
        }

        public final ReferenceEntry<Object, Object> mo2352b() {
            return null;
        }

        public final boolean mo2353c() {
            return false;
        }

        public final boolean mo2354d() {
            return false;
        }

        public final Object mo2355e() {
            return null;
        }

        public final Object get() {
            return null;
        }

        C11501() {
        }
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ValueReference<K, V> mo2357a() {
            throw new UnsupportedOperationException();
        }

        public void mo2359a(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2361b() {
            throw new UnsupportedOperationException();
        }

        public int mo2364c() {
            throw new UnsupportedOperationException();
        }

        public K mo2366d() {
            throw new UnsupportedOperationException();
        }

        public long mo2368e() {
            throw new UnsupportedOperationException();
        }

        public void mo2358a(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2369f() {
            throw new UnsupportedOperationException();
        }

        public void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2370g() {
            throw new UnsupportedOperationException();
        }

        public void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long mo2371h() {
            throw new UnsupportedOperationException();
        }

        public void mo2362b(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2372i() {
            throw new UnsupportedOperationException();
        }

        public void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2373j() {
            throw new UnsupportedOperationException();
        }

        public void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    final class EntryIterator extends HashIterator<Entry<K, V>> {
        final /* synthetic */ LocalCache f14848a;

        EntryIterator(LocalCache localCache) {
            this.f14848a = localCache;
            super(localCache);
        }

        public final /* synthetic */ Object next() {
            return m6967a();
        }
    }

    final class EntrySet extends AbstractCacheSet<Entry<K, V>> {
        final /* synthetic */ LocalCache f14849c;

        EntrySet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f14849c = localCache;
            super(localCache, concurrentMap);
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new EntryIterator(this.f14849c);
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
            key = this.f14849c.get(key);
            if (key == null || this.f14849c.f8335g.m6878a(entry.getValue(), key) == null) {
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
            if (key == null || this.f14849c.remove(key, entry.getValue()) == null) {
                return false;
            }
            return true;
        }
    }

    final class KeyIterator extends HashIterator<K> {
        final /* synthetic */ LocalCache f14850a;

        KeyIterator(LocalCache localCache) {
            this.f14850a = localCache;
            super(localCache);
        }

        public final K next() {
            return m6967a().getKey();
        }
    }

    final class KeySet extends AbstractCacheSet<K> {
        final /* synthetic */ LocalCache f14851c;

        KeySet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f14851c = localCache;
            super(localCache, concurrentMap);
        }

        public final Iterator<K> iterator() {
            return new KeyIterator(this.f14851c);
        }

        public final boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.a.remove(obj) != null ? true : null;
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> f14853a;
        final SettableFuture<V> f14854b;
        final Stopwatch f14855c;

        class C11591 implements Function<V, V> {
            final /* synthetic */ LoadingValueReference f14852a;

            C11591(LoadingValueReference loadingValueReference) {
                this.f14852a = loadingValueReference;
            }

            public V apply(V v) {
                this.f14852a.m14625b(v);
                return v;
            }
        }

        public final ValueReference<K, V> mo2350a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public final ReferenceEntry<K, V> mo2352b() {
            return null;
        }

        public final boolean mo2353c() {
            return true;
        }

        public LoadingValueReference() {
            this(LocalCache.m7029j());
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.f14854b = SettableFuture.m21569e();
            this.f14855c = Stopwatch.m6927a();
            this.f14853a = valueReference;
        }

        public final boolean mo2354d() {
            return this.f14853a.mo2354d();
        }

        public final int mo2349a() {
            return this.f14853a.mo2349a();
        }

        public final boolean m14625b(V v) {
            return this.f14854b.mo4399a((Object) v);
        }

        public final boolean m14623a(Throwable th) {
            return this.f14854b.mo4400a(th);
        }

        public final void mo2351a(V v) {
            if (v != null) {
                m14625b(v);
            } else {
                this.f14853a = LocalCache.m7029j();
            }
        }

        public final ListenableFuture<V> m14621a(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f14855c.m6932d();
                Object obj = this.f14853a.get();
                if (obj == null) {
                    Object a = cacheLoader.mo2376a(k);
                    return m14625b(a) != null ? this.f14854b : Futures.m14882a(a);
                } else {
                    Preconditions.m6908a((Object) k);
                    Preconditions.m6908a(obj);
                    k = Futures.m14882a(cacheLoader.mo2376a(k));
                    if (k == null) {
                        return Futures.m14882a((Object) null);
                    }
                    return Futures.m14881a(k, new C11591(this), MoreExecutors.m7338a());
                }
            } catch (Throwable th) {
                cacheLoader = m14623a(th) != null ? this.f14854b : Futures.m14883a(th);
                if ((th instanceof InterruptedException) != null) {
                    Thread.currentThread().interrupt();
                }
                return cacheLoader;
            }
        }

        public final long m14629f() {
            return this.f14855c.m6930a(TimeUnit.NANOSECONDS);
        }

        public final V mo2355e() throws ExecutionException {
            return Uninterruptibles.m7340a(this.f14854b);
        }

        public V get() {
            return this.f14853a.get();
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        final LocalCache<K, V> f14858a;

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.f14858a = localCache;
        }

        public V getIfPresent(Object obj) {
            LocalCache localCache = this.f14858a;
            int a = localCache.m7032a(Preconditions.m6908a(obj));
            obj = localCache.m7033a(a).m6997a(obj, a);
            if (obj == null) {
                localCache.f8347s.mo2334b(1);
            } else {
                localCache.f8347s.mo2331a(1);
            }
            return obj;
        }

        public V get(K k, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.m6908a((Object) callable);
            return this.f14858a.m7035a((Object) k, new CacheLoader<Object, V>(this) {
                final /* synthetic */ LocalManualCache f14857b;

                public final V mo2376a(Object obj) throws Exception {
                    return callable.call();
                }
            });
        }

        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            LocalCache localCache = this.f14858a;
            Map c = Maps.m7230c();
            int i = 0;
            int i2 = 0;
            for (Object next : iterable) {
                Object obj = localCache.get(next);
                if (obj == null) {
                    i2++;
                } else {
                    c.put(next, obj);
                    i++;
                }
            }
            localCache.f8347s.mo2331a(i);
            localCache.f8347s.mo2334b(i2);
            return ImmutableMap.m7128a(c);
        }

        public void put(K k, V v) {
            this.f14858a.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.f14858a.putAll(map);
        }

        public void invalidate(Object obj) {
            Preconditions.m6908a(obj);
            this.f14858a.remove(obj);
        }

        public void invalidateAll(Iterable<?> iterable) {
            LocalCache localCache = this.f14858a;
            for (Object remove : iterable) {
                localCache.remove(remove);
            }
        }

        public void invalidateAll() {
            this.f14858a.clear();
        }

        public long size() {
            return this.f14858a.m7046m();
        }

        public ConcurrentMap<K, V> asMap() {
            return this.f14858a;
        }

        public CacheStats stats() {
            SimpleStatsCounter simpleStatsCounter = new SimpleStatsCounter();
            simpleStatsCounter.m14569a(this.f14858a.f8347s);
            for (Segment segment : this.f14858a.f8332d) {
                simpleStatsCounter.m14569a(segment.f8316n);
            }
            return simpleStatsCounter.mo2333b();
        }

        public void cleanUp() {
            for (Segment b : this.f14858a.f8332d) {
                b.m7007b();
            }
        }
    }

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        ;

        public final ValueReference<Object, Object> mo2357a() {
            return null;
        }

        public final void mo2358a(long j) {
        }

        public final void mo2359a(ValueReference<Object, Object> valueReference) {
        }

        public final void mo2360a(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final ReferenceEntry<Object, Object> mo2361b() {
            return null;
        }

        public final void mo2362b(long j) {
        }

        public final void mo2363b(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final int mo2364c() {
            return 0;
        }

        public final void mo2365c(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final Object mo2366d() {
            return null;
        }

        public final void mo2367d(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final long mo2368e() {
            return 0;
        }

        public final ReferenceEntry<Object, Object> mo2369f() {
            return this;
        }

        public final ReferenceEntry<Object, Object> mo2370g() {
            return this;
        }

        public final long mo2371h() {
            return 0;
        }

        public final ReferenceEntry<Object, Object> mo2372i() {
            return this;
        }

        public final ReferenceEntry<Object, Object> mo2373j() {
            return this;
        }

        private NullEntry(String str) {
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> f14861a;

        public final int mo2349a() {
            return 1;
        }

        public final void mo2351a(V v) {
        }

        public final boolean mo2353c() {
            return false;
        }

        public final boolean mo2354d() {
            return true;
        }

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.f14861a = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2352b() {
            return this.f14861a;
        }

        public final ValueReference<K, V> mo2350a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }

        public final V mo2355e() {
            return get();
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V f14862a;

        public final int mo2349a() {
            return 1;
        }

        public final ValueReference<K, V> mo2350a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public final void mo2351a(V v) {
        }

        public final ReferenceEntry<K, V> mo2352b() {
            return null;
        }

        public final boolean mo2353c() {
            return false;
        }

        public final boolean mo2354d() {
            return true;
        }

        StrongValueReference(V v) {
            this.f14862a = v;
        }

        public V get() {
            return this.f14862a;
        }

        public final V mo2355e() {
            return get();
        }
    }

    final class ValueIterator extends HashIterator<V> {
        final /* synthetic */ LocalCache f14863a;

        ValueIterator(LocalCache localCache) {
            this.f14863a = localCache;
            super(localCache);
        }

        public final V next() {
            return m6967a().getValue();
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int f14864g;
        final ReferenceEntry<K, V> f14865h;
        volatile ValueReference<K, V> f14866i = LocalCache.m7029j();

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.f14864g = i;
            this.f14865h = referenceEntry;
        }

        public final K mo2366d() {
            return get();
        }

        public long mo2368e() {
            throw new UnsupportedOperationException();
        }

        public void mo2358a(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2369f() {
            throw new UnsupportedOperationException();
        }

        public void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2370g() {
            throw new UnsupportedOperationException();
        }

        public void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long mo2371h() {
            throw new UnsupportedOperationException();
        }

        public void mo2362b(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2372i() {
            throw new UnsupportedOperationException();
        }

        public void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> mo2373j() {
            throw new UnsupportedOperationException();
        }

        public void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public final ValueReference<K, V> mo2357a() {
            return this.f14866i;
        }

        public final void mo2359a(ValueReference<K, V> valueReference) {
            this.f14866i = valueReference;
        }

        public final int mo2364c() {
            return this.f14864g;
        }

        public final ReferenceEntry<K, V> mo2361b() {
            return this.f14865h;
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> f14867a;

        public final int mo2349a() {
            return 1;
        }

        public final void mo2351a(V v) {
        }

        public final boolean mo2353c() {
            return false;
        }

        public final boolean mo2354d() {
            return true;
        }

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.f14867a = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2352b() {
            return this.f14867a;
        }

        public final ValueReference<K, V> mo2350a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        public final V mo2355e() {
            return get();
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        public V get(K k) throws ExecutionException {
            LocalCache localCache = this.a;
            return localCache.m7035a((Object) k, localCache.f8348t);
        }

        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (K k2) {
                throw new UncheckedExecutionException(k2.getCause());
            }
        }

        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.a.m7034a((Iterable) iterable);
        }

        public void refresh(K k) {
            LocalCache localCache = this.a;
            int a = localCache.m7032a(Preconditions.m6908a((Object) k));
            localCache.m7033a(a).m6999a((Object) k, a, localCache.f8348t, false);
        }

        public final V apply(K k) {
            return getUnchecked(k);
        }
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final K f18413g;
        final int f18414h;
        final ReferenceEntry<K, V> f18415i;
        volatile ValueReference<K, V> f18416j = LocalCache.m7029j();

        StrongEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            this.f18413g = k;
            this.f18414h = i;
            this.f18415i = referenceEntry;
        }

        public final K mo2366d() {
            return this.f18413g;
        }

        public final ValueReference<K, V> mo2357a() {
            return this.f18416j;
        }

        public final void mo2359a(ValueReference<K, V> valueReference) {
            this.f18416j = valueReference;
        }

        public final int mo2364c() {
            return this.f18414h;
        }

        public final ReferenceEntry<K, V> mo2361b() {
            return this.f18415i;
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long f18417a = -1;
        ReferenceEntry<K, V> f18418b = LocalCache.m7030k();
        ReferenceEntry<K, V> f18419c = LocalCache.m7030k();

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long mo2368e() {
            return this.f18417a;
        }

        public final void mo2358a(long j) {
            this.f18417a = j;
        }

        public final ReferenceEntry<K, V> mo2369f() {
            return this.f18418b;
        }

        public final void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            this.f18418b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2370g() {
            return this.f18419c;
        }

        public final void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            this.f18419c = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long f18420a = Long.MAX_VALUE;
        ReferenceEntry<K, V> f18421b = LocalCache.m7030k();
        ReferenceEntry<K, V> f18422c = LocalCache.m7030k();
        volatile long f18423d = Long.MAX_VALUE;
        ReferenceEntry<K, V> f18424e = LocalCache.m7030k();
        ReferenceEntry<K, V> f18425f = LocalCache.m7030k();

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long mo2368e() {
            return this.f18420a;
        }

        public final void mo2358a(long j) {
            this.f18420a = j;
        }

        public final ReferenceEntry<K, V> mo2369f() {
            return this.f18421b;
        }

        public final void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            this.f18421b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2370g() {
            return this.f18422c;
        }

        public final void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            this.f18422c = referenceEntry;
        }

        public final long mo2371h() {
            return this.f18423d;
        }

        public final void mo2362b(long j) {
            this.f18423d = j;
        }

        public final ReferenceEntry<K, V> mo2372i() {
            return this.f18424e;
        }

        public final void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            this.f18424e = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2373j() {
            return this.f18425f;
        }

        public final void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            this.f18425f = referenceEntry;
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long f18426a = -1;
        ReferenceEntry<K, V> f18427b = LocalCache.m7030k();
        ReferenceEntry<K, V> f18428c = LocalCache.m7030k();

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long mo2371h() {
            return this.f18426a;
        }

        public final void mo2362b(long j) {
            this.f18426a = j;
        }

        public final ReferenceEntry<K, V> mo2372i() {
            return this.f18427b;
        }

        public final void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            this.f18427b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2373j() {
            return this.f18428c;
        }

        public final void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            this.f18428c = referenceEntry;
        }
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long f19247a = -1;
        ReferenceEntry<K, V> f19248b = LocalCache.m7030k();
        ReferenceEntry<K, V> f19249c = LocalCache.m7030k();

        StrongAccessEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long mo2368e() {
            return this.f19247a;
        }

        public final void mo2358a(long j) {
            this.f19247a = j;
        }

        public final ReferenceEntry<K, V> mo2369f() {
            return this.f19248b;
        }

        public final void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            this.f19248b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2370g() {
            return this.f19249c;
        }

        public final void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            this.f19249c = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long f19250a = Long.MAX_VALUE;
        ReferenceEntry<K, V> f19251b = LocalCache.m7030k();
        ReferenceEntry<K, V> f19252c = LocalCache.m7030k();
        volatile long f19253d = Long.MAX_VALUE;
        ReferenceEntry<K, V> f19254e = LocalCache.m7030k();
        ReferenceEntry<K, V> f19255f = LocalCache.m7030k();

        StrongAccessWriteEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long mo2368e() {
            return this.f19250a;
        }

        public final void mo2358a(long j) {
            this.f19250a = j;
        }

        public final ReferenceEntry<K, V> mo2369f() {
            return this.f19251b;
        }

        public final void mo2360a(ReferenceEntry<K, V> referenceEntry) {
            this.f19251b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2370g() {
            return this.f19252c;
        }

        public final void mo2363b(ReferenceEntry<K, V> referenceEntry) {
            this.f19252c = referenceEntry;
        }

        public final long mo2371h() {
            return this.f19253d;
        }

        public final void mo2362b(long j) {
            this.f19253d = j;
        }

        public final ReferenceEntry<K, V> mo2372i() {
            return this.f19254e;
        }

        public final void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            this.f19254e = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2373j() {
            return this.f19255f;
        }

        public final void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            this.f19255f = referenceEntry;
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long f19256a = -1;
        ReferenceEntry<K, V> f19257b = LocalCache.m7030k();
        ReferenceEntry<K, V> f19258c = LocalCache.m7030k();

        StrongWriteEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public final long mo2371h() {
            return this.f19256a;
        }

        public final void mo2362b(long j) {
            this.f19256a = j;
        }

        public final ReferenceEntry<K, V> mo2372i() {
            return this.f19257b;
        }

        public final void mo2365c(ReferenceEntry<K, V> referenceEntry) {
            this.f19257b = referenceEntry;
        }

        public final ReferenceEntry<K, V> mo2373j() {
            return this.f19258c;
        }

        public final void mo2367d(ReferenceEntry<K, V> referenceEntry) {
            this.f19258c = referenceEntry;
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        long j;
        Queue queue;
        int i;
        int i2;
        int i3;
        Ticker ticker;
        Strength strength;
        boolean z;
        boolean z2;
        int i4;
        long j2;
        long j3;
        this.f8333e = Math.min(cacheBuilder.f8257g == -1 ? 4 : cacheBuilder.f8257g, 65536);
        this.f8336h = cacheBuilder.m6953c();
        this.f8337i = cacheBuilder.m6954d();
        this.f8334f = (Equivalence) MoreObjects.m6895a(cacheBuilder.f8266p, cacheBuilder.m6953c().mo2377a());
        this.f8335g = (Equivalence) MoreObjects.m6895a(cacheBuilder.f8267q, cacheBuilder.m6954d().mo2377a());
        long j4 = 0;
        if (cacheBuilder.f8263m != 0) {
            if (cacheBuilder.f8264n != 0) {
                j = cacheBuilder.f8260j == null ? cacheBuilder.f8258h : cacheBuilder.f8259i;
                this.f8338j = j;
                this.f8339k = (Weigher) MoreObjects.m6895a(cacheBuilder.f8260j, OneWeigher.f14846a);
                this.f8340l = cacheBuilder.f8264n != -1 ? 0 : cacheBuilder.f8264n;
                this.f8341m = cacheBuilder.f8263m != -1 ? 0 : cacheBuilder.f8263m;
                if (cacheBuilder.f8265o == -1) {
                    j4 = cacheBuilder.f8265o;
                }
                this.f8342n = j4;
                this.f8344p = (RemovalListener) MoreObjects.m6895a(cacheBuilder.f8268r, NullListener.f14844a);
                if (this.f8344p != NullListener.f14844a) {
                    queue = f8329v;
                } else {
                    queue = new ConcurrentLinkedQueue();
                }
                this.f8343o = queue;
                i = 0;
                i2 = 1;
                if (!m7043g()) {
                    if (m7040d()) {
                        i3 = 0;
                        if (cacheBuilder.f8269s == null) {
                            ticker = cacheBuilder.f8269s;
                        } else if (i3 == 0) {
                            ticker = Ticker.m6941b();
                        } else {
                            ticker = CacheBuilder.f8253d;
                        }
                        this.f8345q = ticker;
                        strength = this.f8336h;
                        if (!m7042f()) {
                            if (!m7040d()) {
                                z = false;
                                if (!m7039c()) {
                                    if (!m7043g()) {
                                        z2 = false;
                                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                                        this.f8348t = cacheLoader;
                                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                                        if (m7036a() && !m7038b()) {
                                            cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                                        }
                                        i4 = 0;
                                        i3 = 1;
                                        while (i3 < this.f8333e && (!m7036a() || ((long) (i3 * 20)) <= this.f8338j)) {
                                            i4++;
                                            i3 <<= 1;
                                        }
                                        this.f8331c = 32 - i4;
                                        this.f8330b = i3 - 1;
                                        this.f8332d = new Segment[i3];
                                        i4 = cacheLoader / i3;
                                        if (i4 * i3 < cacheLoader) {
                                            i4++;
                                        }
                                        while (i2 < i4) {
                                            i2 <<= 1;
                                        }
                                        if (m7036a() == null) {
                                            j2 = (long) i3;
                                            j4 = (this.f8338j / j2) + 1;
                                            j3 = this.f8338j % j2;
                                            while (i < this.f8332d.length) {
                                                if (((long) i) != j3) {
                                                    j4--;
                                                }
                                                this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                                i++;
                                            }
                                        }
                                        while (i < this.f8332d.length) {
                                            this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                            i++;
                                        }
                                        return;
                                    }
                                }
                                z2 = true;
                                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                                this.f8348t = cacheLoader;
                                if (cacheBuilder.f8256f != -1) {
                                }
                                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                                i4 = 0;
                                i3 = 1;
                                while (i3 < this.f8333e) {
                                    i4++;
                                    i3 <<= 1;
                                }
                                this.f8331c = 32 - i4;
                                this.f8330b = i3 - 1;
                                this.f8332d = new Segment[i3];
                                i4 = cacheLoader / i3;
                                if (i4 * i3 < cacheLoader) {
                                    i4++;
                                }
                                while (i2 < i4) {
                                    i2 <<= 1;
                                }
                                if (m7036a() == null) {
                                    while (i < this.f8332d.length) {
                                        this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                        i++;
                                    }
                                    return;
                                }
                                j2 = (long) i3;
                                j4 = (this.f8338j / j2) + 1;
                                j3 = this.f8338j % j2;
                                while (i < this.f8332d.length) {
                                    if (((long) i) != j3) {
                                        j4--;
                                    }
                                    this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                    i++;
                                }
                            }
                        }
                        z = true;
                        if (m7039c()) {
                            if (!m7043g()) {
                                z2 = false;
                                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                                this.f8348t = cacheLoader;
                                if (cacheBuilder.f8256f != -1) {
                                }
                                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                                i4 = 0;
                                i3 = 1;
                                while (i3 < this.f8333e) {
                                    i4++;
                                    i3 <<= 1;
                                }
                                this.f8331c = 32 - i4;
                                this.f8330b = i3 - 1;
                                this.f8332d = new Segment[i3];
                                i4 = cacheLoader / i3;
                                if (i4 * i3 < cacheLoader) {
                                    i4++;
                                }
                                while (i2 < i4) {
                                    i2 <<= 1;
                                }
                                if (m7036a() == null) {
                                    j2 = (long) i3;
                                    j4 = (this.f8338j / j2) + 1;
                                    j3 = this.f8338j % j2;
                                    while (i < this.f8332d.length) {
                                        if (((long) i) != j3) {
                                            j4--;
                                        }
                                        this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                        i++;
                                    }
                                }
                                while (i < this.f8332d.length) {
                                    this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                    i++;
                                }
                                return;
                            }
                        }
                        z2 = true;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            while (i < this.f8332d.length) {
                                this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                            return;
                        }
                        j2 = (long) i3;
                        j4 = (this.f8338j / j2) + 1;
                        j3 = this.f8338j % j2;
                        while (i < this.f8332d.length) {
                            if (((long) i) != j3) {
                                j4--;
                            }
                            this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                    }
                }
                i3 = 1;
                if (cacheBuilder.f8269s == null) {
                    ticker = cacheBuilder.f8269s;
                } else if (i3 == 0) {
                    ticker = CacheBuilder.f8253d;
                } else {
                    ticker = Ticker.m6941b();
                }
                this.f8345q = ticker;
                strength = this.f8336h;
                if (m7042f()) {
                    if (!m7040d()) {
                        z = false;
                        if (m7039c()) {
                            if (!m7043g()) {
                                z2 = false;
                                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                                this.f8348t = cacheLoader;
                                if (cacheBuilder.f8256f != -1) {
                                }
                                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                                i4 = 0;
                                i3 = 1;
                                while (i3 < this.f8333e) {
                                    i4++;
                                    i3 <<= 1;
                                }
                                this.f8331c = 32 - i4;
                                this.f8330b = i3 - 1;
                                this.f8332d = new Segment[i3];
                                i4 = cacheLoader / i3;
                                if (i4 * i3 < cacheLoader) {
                                    i4++;
                                }
                                while (i2 < i4) {
                                    i2 <<= 1;
                                }
                                if (m7036a() == null) {
                                    j2 = (long) i3;
                                    j4 = (this.f8338j / j2) + 1;
                                    j3 = this.f8338j % j2;
                                    while (i < this.f8332d.length) {
                                        if (((long) i) != j3) {
                                            j4--;
                                        }
                                        this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                        i++;
                                    }
                                }
                                while (i < this.f8332d.length) {
                                    this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                    i++;
                                }
                                return;
                            }
                        }
                        z2 = true;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            while (i < this.f8332d.length) {
                                this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                            return;
                        }
                        j2 = (long) i3;
                        j4 = (this.f8338j / j2) + 1;
                        j3 = this.f8338j % j2;
                        while (i < this.f8332d.length) {
                            if (((long) i) != j3) {
                                j4--;
                            }
                            this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                    }
                }
                z = true;
                if (m7039c()) {
                    if (!m7043g()) {
                        z2 = false;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            j2 = (long) i3;
                            j4 = (this.f8338j / j2) + 1;
                            j3 = this.f8338j % j2;
                            while (i < this.f8332d.length) {
                                if (((long) i) != j3) {
                                    j4--;
                                }
                                this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                        }
                        while (i < this.f8332d.length) {
                            this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                        return;
                    }
                }
                z2 = true;
                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                this.f8348t = cacheLoader;
                if (cacheBuilder.f8256f != -1) {
                }
                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                i4 = 0;
                i3 = 1;
                while (i3 < this.f8333e) {
                    i4++;
                    i3 <<= 1;
                }
                this.f8331c = 32 - i4;
                this.f8330b = i3 - 1;
                this.f8332d = new Segment[i3];
                i4 = cacheLoader / i3;
                if (i4 * i3 < cacheLoader) {
                    i4++;
                }
                while (i2 < i4) {
                    i2 <<= 1;
                }
                if (m7036a() == null) {
                    while (i < this.f8332d.length) {
                        this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                        i++;
                    }
                    return;
                }
                j2 = (long) i3;
                j4 = (this.f8338j / j2) + 1;
                j3 = this.f8338j % j2;
                while (i < this.f8332d.length) {
                    if (((long) i) != j3) {
                        j4--;
                    }
                    this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                    i++;
                }
            }
        }
        j = 0;
        this.f8338j = j;
        this.f8339k = (Weigher) MoreObjects.m6895a(cacheBuilder.f8260j, OneWeigher.f14846a);
        if (cacheBuilder.f8264n != -1) {
        }
        this.f8340l = cacheBuilder.f8264n != -1 ? 0 : cacheBuilder.f8264n;
        if (cacheBuilder.f8263m != -1) {
        }
        this.f8341m = cacheBuilder.f8263m != -1 ? 0 : cacheBuilder.f8263m;
        if (cacheBuilder.f8265o == -1) {
            j4 = cacheBuilder.f8265o;
        }
        this.f8342n = j4;
        this.f8344p = (RemovalListener) MoreObjects.m6895a(cacheBuilder.f8268r, NullListener.f14844a);
        if (this.f8344p != NullListener.f14844a) {
            queue = new ConcurrentLinkedQueue();
        } else {
            queue = f8329v;
        }
        this.f8343o = queue;
        i = 0;
        i2 = 1;
        if (m7043g()) {
            if (m7040d()) {
                i3 = 0;
                if (cacheBuilder.f8269s == null) {
                    ticker = cacheBuilder.f8269s;
                } else if (i3 == 0) {
                    ticker = Ticker.m6941b();
                } else {
                    ticker = CacheBuilder.f8253d;
                }
                this.f8345q = ticker;
                strength = this.f8336h;
                if (m7042f()) {
                    if (!m7040d()) {
                        z = false;
                        if (m7039c()) {
                            if (!m7043g()) {
                                z2 = false;
                                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                                this.f8348t = cacheLoader;
                                if (cacheBuilder.f8256f != -1) {
                                }
                                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                                i4 = 0;
                                i3 = 1;
                                while (i3 < this.f8333e) {
                                    i4++;
                                    i3 <<= 1;
                                }
                                this.f8331c = 32 - i4;
                                this.f8330b = i3 - 1;
                                this.f8332d = new Segment[i3];
                                i4 = cacheLoader / i3;
                                if (i4 * i3 < cacheLoader) {
                                    i4++;
                                }
                                while (i2 < i4) {
                                    i2 <<= 1;
                                }
                                if (m7036a() == null) {
                                    j2 = (long) i3;
                                    j4 = (this.f8338j / j2) + 1;
                                    j3 = this.f8338j % j2;
                                    while (i < this.f8332d.length) {
                                        if (((long) i) != j3) {
                                            j4--;
                                        }
                                        this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                        i++;
                                    }
                                }
                                while (i < this.f8332d.length) {
                                    this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                    i++;
                                }
                                return;
                            }
                        }
                        z2 = true;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            while (i < this.f8332d.length) {
                                this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                            return;
                        }
                        j2 = (long) i3;
                        j4 = (this.f8338j / j2) + 1;
                        j3 = this.f8338j % j2;
                        while (i < this.f8332d.length) {
                            if (((long) i) != j3) {
                                j4--;
                            }
                            this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                    }
                }
                z = true;
                if (m7039c()) {
                    if (!m7043g()) {
                        z2 = false;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            j2 = (long) i3;
                            j4 = (this.f8338j / j2) + 1;
                            j3 = this.f8338j % j2;
                            while (i < this.f8332d.length) {
                                if (((long) i) != j3) {
                                    j4--;
                                }
                                this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                        }
                        while (i < this.f8332d.length) {
                            this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                        return;
                    }
                }
                z2 = true;
                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                this.f8348t = cacheLoader;
                if (cacheBuilder.f8256f != -1) {
                }
                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                i4 = 0;
                i3 = 1;
                while (i3 < this.f8333e) {
                    i4++;
                    i3 <<= 1;
                }
                this.f8331c = 32 - i4;
                this.f8330b = i3 - 1;
                this.f8332d = new Segment[i3];
                i4 = cacheLoader / i3;
                if (i4 * i3 < cacheLoader) {
                    i4++;
                }
                while (i2 < i4) {
                    i2 <<= 1;
                }
                if (m7036a() == null) {
                    while (i < this.f8332d.length) {
                        this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                        i++;
                    }
                    return;
                }
                j2 = (long) i3;
                j4 = (this.f8338j / j2) + 1;
                j3 = this.f8338j % j2;
                while (i < this.f8332d.length) {
                    if (((long) i) != j3) {
                        j4--;
                    }
                    this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                    i++;
                }
            }
        }
        i3 = 1;
        if (cacheBuilder.f8269s == null) {
            ticker = cacheBuilder.f8269s;
        } else if (i3 == 0) {
            ticker = CacheBuilder.f8253d;
        } else {
            ticker = Ticker.m6941b();
        }
        this.f8345q = ticker;
        strength = this.f8336h;
        if (m7042f()) {
            if (!m7040d()) {
                z = false;
                if (m7039c()) {
                    if (!m7043g()) {
                        z2 = false;
                        this.f8346r = EntryFactory.m6958a(strength, z, z2);
                        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                        this.f8348t = cacheLoader;
                        if (cacheBuilder.f8256f != -1) {
                        }
                        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                        i4 = 0;
                        i3 = 1;
                        while (i3 < this.f8333e) {
                            i4++;
                            i3 <<= 1;
                        }
                        this.f8331c = 32 - i4;
                        this.f8330b = i3 - 1;
                        this.f8332d = new Segment[i3];
                        i4 = cacheLoader / i3;
                        if (i4 * i3 < cacheLoader) {
                            i4++;
                        }
                        while (i2 < i4) {
                            i2 <<= 1;
                        }
                        if (m7036a() == null) {
                            j2 = (long) i3;
                            j4 = (this.f8338j / j2) + 1;
                            j3 = this.f8338j % j2;
                            while (i < this.f8332d.length) {
                                if (((long) i) != j3) {
                                    j4--;
                                }
                                this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                                i++;
                            }
                        }
                        while (i < this.f8332d.length) {
                            this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                            i++;
                        }
                        return;
                    }
                }
                z2 = true;
                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                this.f8348t = cacheLoader;
                if (cacheBuilder.f8256f != -1) {
                }
                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                i4 = 0;
                i3 = 1;
                while (i3 < this.f8333e) {
                    i4++;
                    i3 <<= 1;
                }
                this.f8331c = 32 - i4;
                this.f8330b = i3 - 1;
                this.f8332d = new Segment[i3];
                i4 = cacheLoader / i3;
                if (i4 * i3 < cacheLoader) {
                    i4++;
                }
                while (i2 < i4) {
                    i2 <<= 1;
                }
                if (m7036a() == null) {
                    while (i < this.f8332d.length) {
                        this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                        i++;
                    }
                    return;
                }
                j2 = (long) i3;
                j4 = (this.f8338j / j2) + 1;
                j3 = this.f8338j % j2;
                while (i < this.f8332d.length) {
                    if (((long) i) != j3) {
                        j4--;
                    }
                    this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                    i++;
                }
            }
        }
        z = true;
        if (m7039c()) {
            if (!m7043g()) {
                z2 = false;
                this.f8346r = EntryFactory.m6958a(strength, z, z2);
                this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
                this.f8348t = cacheLoader;
                if (cacheBuilder.f8256f != -1) {
                }
                cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
                cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
                i4 = 0;
                i3 = 1;
                while (i3 < this.f8333e) {
                    i4++;
                    i3 <<= 1;
                }
                this.f8331c = 32 - i4;
                this.f8330b = i3 - 1;
                this.f8332d = new Segment[i3];
                i4 = cacheLoader / i3;
                if (i4 * i3 < cacheLoader) {
                    i4++;
                }
                while (i2 < i4) {
                    i2 <<= 1;
                }
                if (m7036a() == null) {
                    j2 = (long) i3;
                    j4 = (this.f8338j / j2) + 1;
                    j3 = this.f8338j % j2;
                    while (i < this.f8332d.length) {
                        if (((long) i) != j3) {
                            j4--;
                        }
                        this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                        i++;
                    }
                }
                while (i < this.f8332d.length) {
                    this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                    i++;
                }
                return;
            }
        }
        z2 = true;
        this.f8346r = EntryFactory.m6958a(strength, z, z2);
        this.f8347s = (StatsCounter) cacheBuilder.f8270t.mo2328a();
        this.f8348t = cacheLoader;
        if (cacheBuilder.f8256f != -1) {
        }
        cacheLoader = Math.min(cacheBuilder.f8256f != -1 ? 16 : cacheBuilder.f8256f, 1073741824);
        cacheLoader = Math.min(cacheLoader, (int) this.f8338j);
        i4 = 0;
        i3 = 1;
        while (i3 < this.f8333e) {
            i4++;
            i3 <<= 1;
        }
        this.f8331c = 32 - i4;
        this.f8330b = i3 - 1;
        this.f8332d = new Segment[i3];
        i4 = cacheLoader / i3;
        if (i4 * i3 < cacheLoader) {
            i4++;
        }
        while (i2 < i4) {
            i2 <<= 1;
        }
        if (m7036a() == null) {
            while (i < this.f8332d.length) {
                this.f8332d[i] = m7022a(i2, -1, (StatsCounter) cacheBuilder.f8270t.mo2328a());
                i++;
            }
            return;
        }
        j2 = (long) i3;
        j4 = (this.f8338j / j2) + 1;
        j3 = this.f8338j % j2;
        while (i < this.f8332d.length) {
            if (((long) i) != j3) {
                j4--;
            }
            this.f8332d[i] = m7022a(i2, j4, (StatsCounter) cacheBuilder.f8270t.mo2328a());
            i++;
        }
    }

    final boolean m7036a() {
        return this.f8338j >= 0;
    }

    final boolean m7038b() {
        return this.f8339k != OneWeigher.f14846a;
    }

    final boolean m7039c() {
        return this.f8341m > 0;
    }

    final boolean m7040d() {
        return this.f8340l > 0;
    }

    final boolean m7041e() {
        return this.f8342n > 0;
    }

    final boolean m7042f() {
        if (!m7040d()) {
            if (!m7036a()) {
                return false;
            }
        }
        return true;
    }

    final boolean m7043g() {
        if (!m7039c()) {
            if (!m7041e()) {
                return false;
            }
        }
        return true;
    }

    final boolean m7044h() {
        return this.f8336h != Strength.f8317a;
    }

    final boolean m7045i() {
        return this.f8337i != Strength.f8317a;
    }

    static <K, V> ValueReference<K, V> m7029j() {
        return f8328u;
    }

    static <K, V> ReferenceEntry<K, V> m7030k() {
        return NullEntry.f14859a;
    }

    static <E> Queue<E> m7031l() {
        return f8329v;
    }

    final int m7032a(Object obj) {
        obj = this.f8334f.m6877a(obj);
        obj += (obj << 15) ^ -12931;
        obj ^= obj >>> 10;
        obj += obj << 3;
        obj ^= obj >>> 6;
        obj += (obj << 2) + (obj << 14);
        return obj ^ (obj >>> 16);
    }

    final Segment<K, V> m7033a(int i) {
        return this.f8332d[(i >>> this.f8331c) & this.f8330b];
    }

    private Segment<K, V> m7022a(int i, long j, StatsCounter statsCounter) {
        return new Segment(this, i, j, statsCounter);
    }

    final boolean m7037a(ReferenceEntry<K, V> referenceEntry, long j) {
        Preconditions.m6908a((Object) referenceEntry);
        if (m7040d() && j - referenceEntry.mo2368e() >= this.f8340l) {
            return true;
        }
        if (!m7039c() || j - referenceEntry.mo2371h() < this.f8341m) {
            return null;
        }
        return true;
    }

    static <K, V> void m7026a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.mo2360a((ReferenceEntry) referenceEntry2);
        referenceEntry2.mo2363b((ReferenceEntry) referenceEntry);
    }

    static <K, V> void m7028b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.mo2365c(referenceEntry2);
        referenceEntry2.mo2367d(referenceEntry);
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f8332d;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].f8304b != 0) {
                return false;
            }
            j += (long) segmentArr[i].f8306d;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].f8304b != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].f8306d;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    final long m7046m() {
        long j = 0;
        for (Segment segment : this.f8332d) {
            j += (long) Math.max(0, segment.f8304b);
        }
        return j;
    }

    public int size() {
        return Ints.m7284b(m7046m());
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m7032a(obj);
        return m7033a(a).m6997a(obj, a);
    }

    public V getOrDefault(Object obj, V v) {
        obj = get(obj);
        return obj != null ? obj : v;
    }

    final V m7035a(K k, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int a = m7032a(Preconditions.m6908a((Object) k));
        return m7033a(a).m6998a((Object) k, a, (CacheLoader) cacheLoader);
    }

    final com.google.common.collect.ImmutableMap<K, V> m7034a(java.lang.Iterable<? extends K> r8) throws java.util.concurrent.ExecutionException {
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
        r7 = this;
        r0 = com.google.common.collect.Maps.m7230c();
        r1 = com.google.common.collect.Sets.m7260b();
        r8 = r8.iterator();
        r2 = 0;
        r3 = r2;
    L_0x000e:
        r4 = r8.hasNext();
        if (r4 == 0) goto L_0x0030;
    L_0x0014:
        r4 = r8.next();
        r5 = r7.get(r4);
        r6 = r0.containsKey(r4);
        if (r6 != 0) goto L_0x000e;
    L_0x0022:
        r0.put(r4, r5);
        if (r5 != 0) goto L_0x002d;
    L_0x0027:
        r2 = r2 + 1;
        r1.add(r4);
        goto L_0x000e;
    L_0x002d:
        r3 = r3 + 1;
        goto L_0x000e;
    L_0x0030:
        r8 = r1.isEmpty();	 Catch:{ all -> 0x0091 }
        if (r8 != 0) goto L_0x0082;
    L_0x0036:
        r8 = r7.f8348t;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r8 = r7.m7024a(r1, r8);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r4 = r1.iterator();	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
    L_0x0040:
        r5 = r4.hasNext();	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        if (r5 == 0) goto L_0x0082;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
    L_0x0046:
        r5 = r4.next();	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r6 = r8.get(r5);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        if (r6 != 0) goto L_0x0064;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
    L_0x0050:
        r8 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r4 = new java.lang.StringBuilder;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r6 = "loadAll failed to return a value for ";	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r4.<init>(r6);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r4.append(r5);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r4 = r4.toString();	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        r8.<init>(r4);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        throw r8;	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
    L_0x0064:
        r0.put(r5, r6);	 Catch:{ UnsupportedLoadingOperationException -> 0x0068 }
        goto L_0x0040;
    L_0x0068:
        r8 = r1.iterator();	 Catch:{ all -> 0x0091 }
    L_0x006c:
        r1 = r8.hasNext();	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x0082;	 Catch:{ all -> 0x0091 }
    L_0x0072:
        r1 = r8.next();	 Catch:{ all -> 0x0091 }
        r2 = r2 + -1;	 Catch:{ all -> 0x0091 }
        r4 = r7.f8348t;	 Catch:{ all -> 0x0091 }
        r4 = r7.m7035a(r1, r4);	 Catch:{ all -> 0x0091 }
        r0.put(r1, r4);	 Catch:{ all -> 0x0091 }
        goto L_0x006c;	 Catch:{ all -> 0x0091 }
    L_0x0082:
        r8 = com.google.common.collect.ImmutableMap.m7128a(r0);	 Catch:{ all -> 0x0091 }
        r0 = r7.f8347s;
        r0.mo2331a(r3);
        r0 = r7.f8347s;
        r0.mo2334b(r2);
        return r8;
    L_0x0091:
        r8 = move-exception;
        r0 = r7.f8347s;
        r0.mo2331a(r3);
        r0 = r7.f8347s;
        r0.mo2334b(r2);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.a(java.lang.Iterable):com.google.common.collect.ImmutableMap<K, V>");
    }

    private Map<K, V> m7024a(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Preconditions.m6908a((Object) cacheLoader);
        Preconditions.m6908a((Object) set);
        set = Stopwatch.m6928b();
        boolean z = false;
        try {
            Map<K, V> a = CacheLoader.m6955a();
            StringBuilder stringBuilder;
            if (a == null) {
                this.f8347s.mo2335b(set.m6930a(TimeUnit.NANOSECONDS));
                stringBuilder = new StringBuilder();
                stringBuilder.append(cacheLoader);
                stringBuilder.append(" returned null map from loadAll");
                throw new InvalidCacheLoadException(stringBuilder.toString());
            }
            long a2 = set.f8242a.mo2329a();
            Preconditions.m6922b(set.f8243b, (Object) "This stopwatch is already stopped.");
            set.f8243b = false;
            set.f8244c += a2 - set.f8245d;
            for (Entry entry : a.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key != null) {
                    if (value != null) {
                        put(key, value);
                    }
                }
                z = true;
            }
            if (z) {
                this.f8347s.mo2335b(set.m6930a(TimeUnit.NANOSECONDS));
                stringBuilder = new StringBuilder();
                stringBuilder.append(cacheLoader);
                stringBuilder.append(" returned null keys or values from loadAll");
                throw new InvalidCacheLoadException(stringBuilder.toString());
            }
            this.f8347s.mo2332a(set.m6930a(TimeUnit.NANOSECONDS));
            return a;
        } catch (CacheLoader<? super K, V> cacheLoader2) {
            throw cacheLoader2;
        } catch (CacheLoader<? super K, V> cacheLoader22) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(cacheLoader22);
        } catch (CacheLoader<? super K, V> cacheLoader222) {
            throw new UncheckedExecutionException(cacheLoader222);
        } catch (CacheLoader<? super K, V> cacheLoader2222) {
            throw new ExecutionException(cacheLoader2222);
        } catch (CacheLoader<? super K, V> cacheLoader22222) {
            throw new ExecutionError(cacheLoader22222);
        } catch (Throwable th) {
            cacheLoader22222 = th;
            z = true;
        }
        if (!z) {
            this.f8347s.mo2335b(set.m6930a(TimeUnit.NANOSECONDS));
        }
        throw cacheLoader22222;
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m7032a(obj);
        return m7033a(a).m7008b(obj, a);
    }

    public boolean containsValue(Object obj) {
        LocalCache localCache = this;
        Object obj2 = obj;
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        boolean z2;
        long a = localCache.f8345q.mo2329a();
        Segment[] segmentArr = localCache.f8332d;
        long j = -1;
        int i = 0;
        while (i < 3) {
            Segment[] segmentArr2;
            long j2;
            int length = segmentArr.length;
            long j3 = 0;
            int i2 = z;
            while (i2 < length) {
                Segment segment = segmentArr[i2];
                int i3 = segment.f8304b;
                AtomicReferenceArray atomicReferenceArray = segment.f8308f;
                for (int i4 = z; i4 < atomicReferenceArray.length(); i4++) {
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i4);
                    while (referenceEntry != null) {
                        segmentArr2 = segmentArr;
                        Object a2 = segment.m6996a(referenceEntry, a);
                        if (a2 != null) {
                            j2 = a;
                            if (localCache.f8335g.m6878a(obj2, a2)) {
                                return true;
                            }
                        } else {
                            j2 = a;
                        }
                        referenceEntry = referenceEntry.mo2361b();
                        segmentArr = segmentArr2;
                        a = j2;
                    }
                    j2 = a;
                    segmentArr2 = segmentArr;
                }
                segmentArr2 = segmentArr;
                j3 += (long) segment.f8306d;
                i2++;
                a = a;
                z = false;
            }
            j2 = a;
            segmentArr2 = segmentArr;
            if (j3 == j) {
                z2 = false;
                break;
            }
            i++;
            j = j3;
            segmentArr = segmentArr2;
            a = j2;
            z = false;
        }
        z2 = z;
        return z2;
    }

    public V put(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7032a((Object) k);
        return m7033a(a).m7002a((Object) k, a, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7032a((Object) k);
        return m7033a(a).m7002a((Object) k, a, (Object) v, true);
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
        int a = m7032a(obj);
        return m7033a(a).m7010c(obj, a);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                int a = m7032a(obj);
                return m7033a(a).m7009b(obj, a, obj2);
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
        int a = m7032a((Object) k);
        return m7033a(a).m7006a((Object) k, a, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        Preconditions.m6908a((Object) k);
        Preconditions.m6908a((Object) v);
        int a = m7032a((Object) k);
        return m7033a(a).m7001a((Object) k, a, (Object) v);
    }

    public void clear() {
        Segment[] segmentArr = this.f8332d;
        int length = segmentArr.length;
        for (int i = 0; i < length; i++) {
            Segment segment = segmentArr[i];
            if (segment.f8304b != 0) {
                segment.lock();
                try {
                    int i2;
                    segment.m7004a(segment.f8303a.f8345q.mo2329a());
                    AtomicReferenceArray atomicReferenceArray = segment.f8308f;
                    for (i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2); referenceEntry != null; referenceEntry = referenceEntry.mo2361b()) {
                            if (referenceEntry.mo2357a().mo2354d()) {
                                RemovalCause removalCause;
                                Object d = referenceEntry.mo2366d();
                                Object obj = referenceEntry.mo2357a().get();
                                if (d != null) {
                                    if (obj != null) {
                                        removalCause = RemovalCause.f8353a;
                                        referenceEntry.mo2364c();
                                        segment.m7005a(d, obj, referenceEntry.mo2357a().mo2349a(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.f8355c;
                                referenceEntry.mo2364c();
                                segment.m7005a(d, obj, referenceEntry.mo2357a().mo2349a(), removalCause);
                            }
                        }
                    }
                    for (i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    if (segment.f8303a.m7044h()) {
                        do {
                        } while (segment.f8310h.poll() != null);
                    }
                    if (segment.f8303a.m7045i()) {
                        do {
                        } while (segment.f8311i.poll() != null);
                    }
                    segment.f8314l.clear();
                    segment.f8315m.clear();
                    segment.f8313k.set(0);
                    segment.f8306d++;
                    segment.f8304b = 0;
                } finally {
                    segment.unlock();
                    segment.m7011c();
                }
            }
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f8349w;
        if (set != null) {
            return set;
        }
        set = new KeySet(this, this);
        this.f8349w = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f8350x;
        if (collection != null) {
            return collection;
        }
        collection = new Values(this, this);
        this.f8350x = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f8351y;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this, this);
        this.f8351y = set;
        return set;
    }

    static <K, V> void m7025a(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry referenceEntry2 = NullEntry.f14859a;
        referenceEntry.mo2360a(referenceEntry2);
        referenceEntry.mo2363b(referenceEntry2);
    }

    static <K, V> void m7027b(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry referenceEntry2 = NullEntry.f14859a;
        referenceEntry.mo2365c(referenceEntry2);
        referenceEntry.mo2367d(referenceEntry2);
    }

    static /* synthetic */ ArrayList m7023a(Collection collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.m7149a(arrayList, collection.iterator());
        return arrayList;
    }
}
