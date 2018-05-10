package android.support.v4.util;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class MapCollections<K, V> {
    EntrySet f1407b;
    KeySet f1408c;
    ValuesCollection f1409d;

    final class ArrayIterator<T> implements Iterator<T> {
        final int f1395a;
        int f1396b;
        int f1397c;
        boolean f1398d = false;
        final /* synthetic */ MapCollections f1399e;

        ArrayIterator(MapCollections mapCollections, int i) {
            this.f1399e = mapCollections;
            this.f1395a = i;
            this.f1396b = mapCollections.mo353a();
        }

        public final boolean hasNext() {
            return this.f1397c < this.f1396b;
        }

        public final T next() {
            if (hasNext()) {
                T a = this.f1399e.mo355a(this.f1397c, this.f1395a);
                this.f1397c++;
                this.f1398d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.f1398d) {
                this.f1397c--;
                this.f1396b--;
                this.f1398d = false;
                this.f1399e.mo357a(this.f1397c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class EntrySet implements Set<Entry<K, V>> {
        final /* synthetic */ MapCollections f1400a;

        EntrySet(MapCollections mapCollections) {
            this.f1400a = mapCollections;
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f1400a.mo353a();
            for (Entry entry : collection) {
                this.f1400a.mo358a(entry.getKey(), entry.getValue());
            }
            return a != this.f1400a.mo353a() ? true : null;
        }

        public final void clear() {
            this.f1400a.mo361c();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f1400a.mo354a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return ContainerHelpers.m1008a(this.f1400a.mo355a(a, 1), entry.getValue());
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.f1400a.mo353a() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new MapIterator(this.f1400a);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return this.f1400a.mo353a();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return MapCollections.m1022a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int a = this.f1400a.mo353a() - 1; a >= 0; a--) {
                int i2;
                int i3;
                Object a2 = this.f1400a.mo355a(a, 0);
                Object a3 = this.f1400a.mo355a(a, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 == null) {
                    i3 = 0;
                } else {
                    i3 = a3.hashCode();
                }
                i += i2 ^ i3;
            }
            return i;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections f1401a;

        KeySet(MapCollections mapCollections) {
            this.f1401a = mapCollections;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.f1401a.mo361c();
        }

        public final boolean contains(Object obj) {
            return this.f1401a.mo354a(obj) >= null ? true : null;
        }

        public final boolean containsAll(Collection<?> collection) {
            return MapCollections.m1021a(this.f1401a.mo360b(), (Collection) collection);
        }

        public final boolean isEmpty() {
            return this.f1401a.mo353a() == 0;
        }

        public final Iterator<K> iterator() {
            return new ArrayIterator(this.f1401a, 0);
        }

        public final boolean remove(Object obj) {
            int a = this.f1401a.mo354a(obj);
            if (a < null) {
                return null;
            }
            this.f1401a.mo357a(a);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            return MapCollections.m1023b(this.f1401a.mo360b(), collection);
        }

        public final boolean retainAll(Collection<?> collection) {
            return MapCollections.m1024c(this.f1401a.mo360b(), collection);
        }

        public final int size() {
            return this.f1401a.mo353a();
        }

        public final Object[] toArray() {
            return this.f1401a.m1034b(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.f1401a.m1031a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return MapCollections.m1022a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int a = this.f1401a.mo353a() - 1; a >= 0; a--) {
                int i2;
                Object a2 = this.f1401a.mo355a(a, 0);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                i += i2;
            }
            return i;
        }
    }

    final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f1402a;
        int f1403b;
        boolean f1404c = false;
        final /* synthetic */ MapCollections f1405d;

        MapIterator(MapCollections mapCollections) {
            this.f1405d = mapCollections;
            this.f1402a = mapCollections.mo353a() - 1;
            this.f1403b = -1;
        }

        public final boolean hasNext() {
            return this.f1403b < this.f1402a;
        }

        public final void remove() {
            if (this.f1404c) {
                this.f1405d.mo357a(this.f1403b);
                this.f1403b--;
                this.f1402a--;
                this.f1404c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.f1404c) {
                return this.f1405d.mo355a(this.f1403b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.f1404c) {
                return this.f1405d.mo355a(this.f1403b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.f1404c) {
                return this.f1405d.mo356a(this.f1403b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.f1404c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!ContainerHelpers.m1008a(entry.getKey(), this.f1405d.mo355a(this.f1403b, 0)) || ContainerHelpers.m1008a(entry.getValue(), this.f1405d.mo355a(this.f1403b, 1)) == null) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            if (this.f1404c) {
                int i;
                int i2 = 0;
                Object a = this.f1405d.mo355a(this.f1403b, 0);
                Object a2 = this.f1405d.mo355a(this.f1403b, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 != null) {
                    i2 = a2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }

        public final /* synthetic */ Object next() {
            if (hasNext()) {
                this.f1403b++;
                this.f1404c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections f1406a;

        ValuesCollection(MapCollections mapCollections) {
            this.f1406a = mapCollections;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.f1406a.mo361c();
        }

        public final boolean contains(Object obj) {
            return this.f1406a.mo359b(obj) >= null ? true : null;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.f1406a.mo353a() == 0;
        }

        public final Iterator<V> iterator() {
            return new ArrayIterator(this.f1406a, 1);
        }

        public final boolean remove(Object obj) {
            int b = this.f1406a.mo359b(obj);
            if (b < null) {
                return null;
            }
            this.f1406a.mo357a(b);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int a = this.f1406a.mo353a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f1406a.mo355a(i, 1))) {
                    this.f1406a.mo357a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int a = this.f1406a.mo353a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f1406a.mo355a(i, 1))) {
                    this.f1406a.mo357a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.f1406a.mo353a();
        }

        public final Object[] toArray() {
            return this.f1406a.m1034b(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.f1406a.m1031a((Object[]) tArr, 1);
        }
    }

    protected abstract int mo353a();

    protected abstract int mo354a(Object obj);

    protected abstract Object mo355a(int i, int i2);

    protected abstract V mo356a(int i, V v);

    protected abstract void mo357a(int i);

    protected abstract void mo358a(K k, V v);

    protected abstract int mo359b(Object obj);

    protected abstract Map<K, V> mo360b();

    protected abstract void mo361c();

    MapCollections() {
    }

    public static <K, V> boolean m1021a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return null;
            }
        }
        return true;
    }

    public static <K, V> boolean m1023b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size() ? true : null;
    }

    public static <K, V> boolean m1024c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size() ? true : null;
    }

    public final Object[] m1034b(int i) {
        int a = mo353a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo355a(i2, i);
        }
        return objArr;
    }

    public final <T> T[] m1031a(T[] tArr, int i) {
        int a = mo353a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = mo355a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = 0;
        }
        return tArr;
    }

    public static <T> boolean m1022a(java.util.Set<T> r4, java.lang.Object r5) {
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
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        if (r1 != r3) goto L_0x001c;	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        return r2;
    L_0x001d:
        return r2;
    L_0x001e:
        return r2;
    L_0x001f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.MapCollections.a(java.util.Set, java.lang.Object):boolean");
    }

    public final Set<K> m1036d() {
        if (this.f1408c == null) {
            this.f1408c = new KeySet(this);
        }
        return this.f1408c;
    }
}
