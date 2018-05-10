package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Maps {

    static class Values<K, V> extends AbstractCollection<V> {
        final Map<K, V> f8476a;

        Values(Map<K, V> map) {
            this.f8476a = (Map) Preconditions.m6908a((Object) map);
        }

        public boolean remove(java.lang.Object r4) {
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
            r0 = super.remove(r4);	 Catch:{ UnsupportedOperationException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r3.f8476a;
            r0 = r0.entrySet();
            r0 = r0.iterator();
        L_0x000f:
            r1 = r0.hasNext();
            if (r1 == 0) goto L_0x0030;
        L_0x0015:
            r1 = r0.next();
            r1 = (java.util.Map.Entry) r1;
            r2 = r1.getValue();
            r2 = com.google.common.base.Objects.m14557a(r4, r2);
            if (r2 == 0) goto L_0x000f;
        L_0x0025:
            r4 = r3.f8476a;
            r0 = r1.getKey();
            r4.remove(r0);
            r4 = 1;
            return r4;
        L_0x0030:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.Values.remove(java.lang.Object):boolean");
        }

        public boolean removeAll(java.util.Collection<?> r5) {
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
            r0 = com.google.common.base.Preconditions.m6908a(r5);	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = (java.util.Collection) r0;	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = super.removeAll(r0);	 Catch:{ UnsupportedOperationException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = com.google.common.collect.Sets.m7254a();
            r1 = r4.f8476a;
            r1 = r1.entrySet();
            r1 = r1.iterator();
        L_0x0019:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x0037;
        L_0x001f:
            r2 = r1.next();
            r2 = (java.util.Map.Entry) r2;
            r3 = r2.getValue();
            r3 = r5.contains(r3);
            if (r3 == 0) goto L_0x0019;
        L_0x002f:
            r2 = r2.getKey();
            r0.add(r2);
            goto L_0x0019;
        L_0x0037:
            r5 = r4.f8476a;
            r5 = r5.keySet();
            r5 = r5.removeAll(r0);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.Values.removeAll(java.util.Collection):boolean");
        }

        public boolean retainAll(java.util.Collection<?> r5) {
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
            r0 = com.google.common.base.Preconditions.m6908a(r5);	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = (java.util.Collection) r0;	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = super.retainAll(r0);	 Catch:{ UnsupportedOperationException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = com.google.common.collect.Sets.m7254a();
            r1 = r4.f8476a;
            r1 = r1.entrySet();
            r1 = r1.iterator();
        L_0x0019:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x0037;
        L_0x001f:
            r2 = r1.next();
            r2 = (java.util.Map.Entry) r2;
            r3 = r2.getValue();
            r3 = r5.contains(r3);
            if (r3 == 0) goto L_0x0019;
        L_0x002f:
            r2 = r2.getKey();
            r0.add(r2);
            goto L_0x0019;
        L_0x0037:
            r5 = r4.f8476a;
            r5 = r5.keySet();
            r5 = r5.retainAll(r0);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.Values.retainAll(java.util.Collection):boolean");
        }

        public Iterator<V> iterator() {
            return Maps.m7227b(this.f8476a.entrySet().iterator());
        }

        public int size() {
            return this.f8476a.size();
        }

        public boolean isEmpty() {
            return this.f8476a.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f8476a.containsValue(obj);
        }

        public void clear() {
            this.f8476a.clear();
        }
    }

    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> f8477a;
        private transient Set<K> f8478b;
        private transient Collection<V> f8479c;

        abstract Set<Entry<K, V>> mo2384a();

        ViewCachingAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.f8477a;
            if (set != null) {
                return set;
            }
            set = mo2384a();
            this.f8477a = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.f8478b;
            if (set != null) {
                return set;
            }
            set = mo3598e();
            this.f8478b = set;
            return set;
        }

        Set<K> mo3598e() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.f8479c;
            if (collection != null) {
                return collection;
            }
            collection = new Values(this);
            this.f8479c = collection;
            return collection;
        }
    }

    private enum EntryFunction implements Function<Entry<?, ?>, Object> {
    }

    static abstract class EntrySet<K, V> extends ImprovedAbstractSet<Entry<K, V>> {
        abstract Map<K, V> mo3592a();

        EntrySet() {
        }

        public int size() {
            return mo3592a().size();
        }

        public void clear() {
            mo3592a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object a = Maps.m7222a(mo3592a(), key);
            if (Objects.m14557a(a, entry.getValue()) == null || (a == null && mo3592a().containsKey(key) == null)) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return mo3592a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return null;
            }
            return mo3592a().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(java.util.Collection<?> r2) {
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
            r1 = this;
            r0 = com.google.common.base.Preconditions.m6908a(r2);	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = (java.util.Collection) r0;	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = super.removeAll(r0);	 Catch:{ UnsupportedOperationException -> 0x000b }
            return r0;
        L_0x000b:
            r2 = r2.iterator();
            r2 = com.google.common.collect.Sets.m7259a(r1, r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.EntrySet.removeAll(java.util.Collection):boolean");
        }

        public boolean retainAll(java.util.Collection<?> r4) {
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
            r0 = com.google.common.base.Preconditions.m6908a(r4);	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = (java.util.Collection) r0;	 Catch:{ UnsupportedOperationException -> 0x000b }
            r0 = super.retainAll(r0);	 Catch:{ UnsupportedOperationException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = r4.size();
            r0 = com.google.common.collect.Sets.m7255a(r0);
            r4 = r4.iterator();
        L_0x0017:
            r1 = r4.hasNext();
            if (r1 == 0) goto L_0x0031;
        L_0x001d:
            r1 = r4.next();
            r2 = r3.contains(r1);
            if (r2 == 0) goto L_0x0017;
        L_0x0027:
            r1 = (java.util.Map.Entry) r1;
            r1 = r1.getKey();
            r0.add(r1);
            goto L_0x0017;
        L_0x0031:
            r4 = r3.mo3592a();
            r4 = r4.keySet();
            r4 = r4.retainAll(r0);
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.EntrySet.retainAll(java.util.Collection):boolean");
        }
    }

    static class KeySet<K, V> extends ImprovedAbstractSet<K> {
        final Map<K, V> f14929d;

        KeySet(Map<K, V> map) {
            this.f14929d = (Map) Preconditions.m6908a((Object) map);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return null;
            }
            this.f14929d.remove(obj);
            return true;
        }

        public Iterator<K> iterator() {
            return Maps.m7224a(this.f14929d.entrySet().iterator());
        }

        public int size() {
            return this.f14929d.size();
        }

        public boolean isEmpty() {
            return this.f14929d.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f14929d.containsKey(obj);
        }

        public void clear() {
            this.f14929d.clear();
        }
    }

    static <V> Function<Entry<?, V>, V> m7221a() {
        return EntryFunction.f14927b;
    }

    static <K, V> Iterator<K> m7224a(Iterator<Entry<K, V>> it) {
        return new TransformedIterator<Entry<K, V>, K>(it) {
            final /* synthetic */ Object mo2401a(Object obj) {
                return ((Entry) obj).getKey();
            }
        };
    }

    static <K, V> Iterator<V> m7227b(Iterator<Entry<K, V>> it) {
        return new TransformedIterator<Entry<K, V>, V>(it) {
            final /* synthetic */ Object mo2401a(Object obj) {
                return ((Entry) obj).getValue();
            }
        };
    }

    public static <K, V> HashMap<K, V> m7226b() {
        return new HashMap();
    }

    static int m7220a(int i) {
        if (i >= 3) {
            return i < 1073741824 ? (int) ((((float) i) / 1061158912) + 1065353216) : RedditJobManager.f10810d;
        } else {
            CollectPreconditions.m7080a(i, "expectedSize");
            return i + 1;
        }
    }

    public static <K, V> LinkedHashMap<K, V> m7230c() {
        return new LinkedHashMap();
    }

    public static <K, V> ConcurrentMap<K, V> m7231d() {
        return new ConcurrentHashMap();
    }

    public static <K, V> Entry<K, V> m7225a(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static <V> V m7222a(java.util.Map<?, V> r0, java.lang.Object r1) {
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
        com.google.common.base.Preconditions.m6908a(r0);
        r0 = r0.get(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.a(java.util.Map, java.lang.Object):V");
    }

    static boolean m7228b(java.util.Map<?, ?> r0, java.lang.Object r1) {
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
        com.google.common.base.Preconditions.m6908a(r0);
        r0 = r0.containsKey(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.b(java.util.Map, java.lang.Object):boolean");
    }

    static <V> V m7229c(java.util.Map<?, V> r0, java.lang.Object r1) {
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
        com.google.common.base.Preconditions.m6908a(r0);
        r0 = r0.remove(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.c(java.util.Map, java.lang.Object):V");
    }

    static boolean m7232d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return null;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    static String m7223a(Map<?, ?> map) {
        StringBuilder a = Collections2.m7083a(map.size());
        a.append('{');
        map = map.entrySet().iterator();
        Object obj = 1;
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (obj == null) {
                a.append(", ");
            }
            obj = null;
            a.append(entry.getKey());
            a.append('=');
            a.append(entry.getValue());
        }
        a.append('}');
        return a.toString();
    }
}
