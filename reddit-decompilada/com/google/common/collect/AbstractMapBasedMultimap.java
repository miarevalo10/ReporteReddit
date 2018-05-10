package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection.WrappedIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private transient Map<K, Collection<V>> f18441a;
    private transient int f18442b;

    private class WrappedCollection extends AbstractCollection<V> {
        final K f8387b;
        Collection<V> f8388c;
        final WrappedCollection f8389d;
        final Collection<V> f8390e;
        final /* synthetic */ AbstractMapBasedMultimap f8391f;

        class WrappedIterator implements Iterator<V> {
            final Iterator<V> f8384a;
            final Collection<V> f8385b = this.f8386c.f8388c;
            final /* synthetic */ WrappedCollection f8386c;

            WrappedIterator(WrappedCollection wrappedCollection) {
                this.f8386c = wrappedCollection;
                this.f8384a = AbstractMapBasedMultimap.m19260b(wrappedCollection.f8388c);
            }

            WrappedIterator(WrappedCollection wrappedCollection, Iterator<V> it) {
                this.f8386c = wrappedCollection;
                this.f8384a = it;
            }

            final void m7076a() {
                this.f8386c.m7077a();
                if (this.f8386c.f8388c != this.f8385b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                m7076a();
                return this.f8384a.hasNext();
            }

            public V next() {
                m7076a();
                return this.f8384a.next();
            }

            public void remove() {
                this.f8384a.remove();
                this.f8386c.f8391f.f18442b = this.f8386c.f8391f.f18442b - 1;
                this.f8386c.m7078b();
            }
        }

        WrappedCollection(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Collection<V> collection, WrappedCollection wrappedCollection) {
            this.f8391f = abstractMapBasedMultimap;
            this.f8387b = k;
            this.f8388c = collection;
            this.f8389d = wrappedCollection;
            this.f8390e = wrappedCollection == null ? null : wrappedCollection.f8388c;
        }

        final void m7077a() {
            if (this.f8389d != null) {
                this.f8389d.m7077a();
                if (this.f8389d.f8388c != this.f8390e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f8388c.isEmpty()) {
                Collection collection = (Collection) this.f8391f.f18441a.get(this.f8387b);
                if (collection != null) {
                    this.f8388c = collection;
                }
            }
        }

        final void m7078b() {
            WrappedCollection wrappedCollection = this;
            while (wrappedCollection.f8389d != null) {
                wrappedCollection = wrappedCollection.f8389d;
            }
            if (wrappedCollection.f8388c.isEmpty()) {
                wrappedCollection.f8391f.f18441a.remove(wrappedCollection.f8387b);
            }
        }

        final void m7079c() {
            WrappedCollection wrappedCollection = this;
            while (wrappedCollection.f8389d != null) {
                wrappedCollection = wrappedCollection.f8389d;
            }
            wrappedCollection.f8391f.f18441a.put(wrappedCollection.f8387b, wrappedCollection.f8388c);
        }

        public int size() {
            m7077a();
            return this.f8388c.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            m7077a();
            return this.f8388c.equals(obj);
        }

        public int hashCode() {
            m7077a();
            return this.f8388c.hashCode();
        }

        public String toString() {
            m7077a();
            return this.f8388c.toString();
        }

        public Iterator<V> iterator() {
            m7077a();
            return new WrappedIterator(this);
        }

        public boolean add(V v) {
            m7077a();
            boolean isEmpty = this.f8388c.isEmpty();
            v = this.f8388c.add(v);
            if (v != null) {
                this.f8391f.f18442b = this.f8391f.f18442b + 1;
                if (isEmpty) {
                    m7079c();
                }
            }
            return v;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return null;
            }
            int size = size();
            collection = this.f8388c.addAll(collection);
            if (collection != null) {
                this.f8391f.f18442b = this.f8391f.f18442b + (this.f8388c.size() - size);
                if (size == 0) {
                    m7079c();
                }
            }
            return collection;
        }

        public boolean contains(Object obj) {
            m7077a();
            return this.f8388c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            m7077a();
            return this.f8388c.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.f8388c.clear();
                this.f8391f.f18442b = this.f8391f.f18442b - size;
                m7078b();
            }
        }

        public boolean remove(Object obj) {
            m7077a();
            obj = this.f8388c.remove(obj);
            if (obj != null) {
                this.f8391f.f18442b = this.f8391f.f18442b - 1;
                m7078b();
            }
            return obj;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return null;
            }
            int size = size();
            collection = this.f8388c.removeAll(collection);
            if (collection != null) {
                this.f8391f.f18442b = this.f8391f.f18442b + (this.f8388c.size() - size);
                m7078b();
            }
            return collection;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.m6908a((Object) collection);
            int size = size();
            collection = this.f8388c.retainAll(collection);
            if (collection != null) {
                this.f8391f.f18442b = this.f8391f.f18442b + (this.f8388c.size() - size);
                m7078b();
            }
            return collection;
        }
    }

    private class AsMap extends ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> f14870a;
        final /* synthetic */ AbstractMapBasedMultimap f14871b;

        class AsMapIterator implements Iterator<Entry<K, Collection<V>>> {
            final Iterator<Entry<K, Collection<V>>> f8378a = this.f8380c.f14870a.entrySet().iterator();
            Collection<V> f8379b;
            final /* synthetic */ AsMap f8380c;

            AsMapIterator(AsMap asMap) {
                this.f8380c = asMap;
            }

            public boolean hasNext() {
                return this.f8378a.hasNext();
            }

            public void remove() {
                this.f8378a.remove();
                this.f8380c.f14871b.f18442b = this.f8380c.f14871b.f18442b - this.f8379b.size();
                this.f8379b.clear();
            }

            public /* synthetic */ Object next() {
                Entry entry = (Entry) this.f8378a.next();
                this.f8379b = (Collection) entry.getValue();
                return this.f8380c.m14707a(entry);
            }
        }

        class AsMapEntries extends EntrySet<K, Collection<V>> {
            final /* synthetic */ AsMap f18435a;

            AsMapEntries(AsMap asMap) {
                this.f18435a = asMap;
            }

            final Map<K, Collection<V>> mo3592a() {
                return this.f18435a;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator(this.f18435a);
            }

            public boolean contains(Object obj) {
                return Collections2.m7085a(this.f18435a.f14870a.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return null;
                }
                AbstractMapBasedMultimap.m19258a(this.f18435a.f14871b, ((Entry) obj).getKey());
                return true;
            }
        }

        AsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f14871b = abstractMapBasedMultimap;
            this.f14870a = map;
        }

        protected final Set<Entry<K, Collection<V>>> mo2384a() {
            return new AsMapEntries(this);
        }

        public boolean containsKey(Object obj) {
            return Maps.m7228b(this.f14870a, obj);
        }

        public Set<K> keySet() {
            return this.f14871b.mo4392e();
        }

        public int size() {
            return this.f14870a.size();
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (this.f14870a.equals(obj) == null) {
                    return null;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f14870a.hashCode();
        }

        public String toString() {
            return this.f14870a.toString();
        }

        public void clear() {
            if (this.f14870a == this.f14871b.f18441a) {
                this.f14871b.mo4391b();
            } else {
                Iterators.m7158f(new AsMapIterator(this));
            }
        }

        final Entry<K, Collection<V>> m14707a(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return Maps.m7225a(key, this.f14871b.m19265a(key, (Collection) entry.getValue()));
        }

        public /* synthetic */ Object remove(Object obj) {
            Collection collection = (Collection) this.f14870a.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection a = this.f14871b.mo4053a();
            a.addAll(collection);
            this.f14871b.f18442b = this.f14871b.f18442b - collection.size();
            collection.clear();
            return a;
        }

        public /* synthetic */ Object get(Object obj) {
            Collection collection = (Collection) Maps.m7222a(this.f14870a, obj);
            if (collection == null) {
                return null;
            }
            return this.f14871b.m19265a(obj, collection);
        }
    }

    private class WrappedList extends WrappedCollection implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap f14873g;

        private class WrappedListIterator extends WrappedIterator implements ListIterator<V> {
            final /* synthetic */ WrappedList f14872d;

            WrappedListIterator(WrappedList wrappedList) {
                this.f14872d = wrappedList;
                super(wrappedList);
            }

            public WrappedListIterator(WrappedList wrappedList, int i) {
                this.f14872d = wrappedList;
                super(wrappedList, ((List) wrappedList.f8388c).listIterator(i));
            }

            public boolean hasPrevious() {
                return m14709b().hasPrevious();
            }

            public V previous() {
                return m14709b().previous();
            }

            public int nextIndex() {
                return m14709b().nextIndex();
            }

            public int previousIndex() {
                return m14709b().previousIndex();
            }

            public void set(V v) {
                m14709b().set(v);
            }

            public void add(V v) {
                boolean isEmpty = this.f14872d.isEmpty();
                m14709b().add(v);
                this.f14872d.f14873g.f18442b = this.f14872d.f14873g.f18442b + 1;
                if (isEmpty) {
                    this.f14872d.m7079c();
                }
            }

            private ListIterator<V> m14709b() {
                m7076a();
                return (ListIterator) this.f8384a;
            }
        }

        WrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, WrappedCollection wrappedCollection) {
            this.f14873g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, wrappedCollection);
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            i = ((List) this.f8388c).addAll(i, collection);
            if (i != 0) {
                this.f14873g.f18442b = this.f14873g.f18442b + (this.f8388c.size() - size);
                if (size == 0) {
                    m7079c();
                }
            }
            return i;
        }

        public V get(int i) {
            m7077a();
            return ((List) this.f8388c).get(i);
        }

        public V set(int i, V v) {
            m7077a();
            return ((List) this.f8388c).set(i, v);
        }

        public void add(int i, V v) {
            m7077a();
            boolean isEmpty = this.f8388c.isEmpty();
            ((List) this.f8388c).add(i, v);
            this.f14873g.f18442b = this.f14873g.f18442b + 1;
            if (isEmpty) {
                m7079c();
            }
        }

        public V remove(int i) {
            m7077a();
            i = ((List) this.f8388c).remove(i);
            this.f14873g.f18442b = this.f14873g.f18442b - 1;
            m7078b();
            return i;
        }

        public int indexOf(Object obj) {
            m7077a();
            return ((List) this.f8388c).indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            m7077a();
            return ((List) this.f8388c).lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            m7077a();
            return new WrappedListIterator(this);
        }

        public ListIterator<V> listIterator(int i) {
            m7077a();
            return new WrappedListIterator(this, i);
        }

        public List<V> subList(int i, int i2) {
            m7077a();
            return this.f14873g.m19256a(this.f8387b, ((List) this.f8388c).subList(i, i2), this.f8389d == 0 ? this : this.f8389d);
        }
    }

    private class WrappedSet extends WrappedCollection implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap f14874a;

        WrappedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Set<V> set) {
            this.f14874a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return null;
            }
            int size = size();
            collection = Sets.m7258a((Set) this.c, (Collection) collection);
            if (collection != null) {
                this.f14874a.f18442b = this.f14874a.f18442b + (this.c.size() - size);
                m7078b();
            }
            return collection;
        }
    }

    private class WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f14875g;

        WrappedSortedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, SortedSet<V> sortedSet, WrappedCollection wrappedCollection) {
            this.f14875g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, sortedSet, wrappedCollection);
        }

        public Comparator<? super V> comparator() {
            return mo3599d().comparator();
        }

        public V first() {
            m7077a();
            return mo3599d().first();
        }

        public V last() {
            m7077a();
            return mo3599d().last();
        }

        public SortedSet<V> headSet(V v) {
            m7077a();
            return new WrappedSortedSet(this.f14875g, this.f8387b, mo3599d().headSet(v), this.f8389d == null ? this : this.f8389d);
        }

        public SortedSet<V> subSet(V v, V v2) {
            m7077a();
            return new WrappedSortedSet(this.f14875g, this.f8387b, mo3599d().subSet(v, v2), this.f8389d == null ? this : this.f8389d);
        }

        public SortedSet<V> tailSet(V v) {
            m7077a();
            return new WrappedSortedSet(this.f14875g, this.f8387b, mo3599d().tailSet(v), this.f8389d == null ? this : this.f8389d);
        }

        SortedSet<V> mo3599d() {
            return (SortedSet) this.f8388c;
        }
    }

    private class KeySet extends KeySet<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap f18436a;

        KeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f18436a = abstractMapBasedMultimap;
            super(map);
        }

        public void clear() {
            Iterators.m7158f(iterator());
        }

        public Iterator<K> iterator() {
            final Iterator it = this.f14929d.entrySet().iterator();
            return new Iterator<K>(this) {
                Entry<K, Collection<V>> f8381a;
                final /* synthetic */ KeySet f8383c;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.f8381a = (Entry) it.next();
                    return this.f8381a.getKey();
                }

                public void remove() {
                    CollectPreconditions.m7082a(this.f8381a != null);
                    Collection collection = (Collection) this.f8381a.getValue();
                    it.remove();
                    this.f8383c.f18436a.f18442b = this.f8383c.f18436a.f18442b - collection.size();
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.f14929d.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                this.f18436a.f18442b = this.f18436a.f18442b - size;
            } else {
                size = 0;
            }
            if (size > 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f14929d.keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (this.f14929d.keySet().equals(obj) == null) {
                    return null;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f14929d.keySet().hashCode();
        }
    }

    private class RandomAccessWrappedList extends WrappedList implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap f18437a;

        RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, WrappedCollection wrappedCollection) {
            this.f18437a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, wrappedCollection);
        }
    }

    private class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
        SortedSet<K> f18438d;
        final /* synthetic */ AbstractMapBasedMultimap f18439e;

        /* synthetic */ Set mo3598e() {
            return mo4047b();
        }

        public /* synthetic */ Set keySet() {
            return mo4048c();
        }

        SortedAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f18439e = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> mo4049d() {
            return (SortedMap) this.a;
        }

        public Comparator<? super K> comparator() {
            return mo4049d().comparator();
        }

        public K firstKey() {
            return mo4049d().firstKey();
        }

        public K lastKey() {
            return mo4049d().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new SortedAsMap(this.f18439e, mo4049d().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new SortedAsMap(this.f18439e, mo4049d().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new SortedAsMap(this.f18439e, mo4049d().tailMap(k));
        }

        public SortedSet<K> mo4048c() {
            SortedSet<K> sortedSet = this.f18438d;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = mo4047b();
            this.f18438d = sortedSet;
            return sortedSet;
        }

        SortedSet<K> mo4047b() {
            return new SortedKeySet(this.f18439e, mo4049d());
        }
    }

    class WrappedNavigableSet extends WrappedSortedSet implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f18440a;

        WrappedNavigableSet(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, NavigableSet<V> navigableSet, WrappedCollection wrappedCollection) {
            this.f18440a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, navigableSet, wrappedCollection);
        }

        public V pollFirst() {
            return Iterators.m7157e(iterator());
        }

        public V pollLast() {
            return Iterators.m7157e(descendingIterator());
        }

        private NavigableSet<V> m19251a(NavigableSet<V> navigableSet) {
            return new WrappedNavigableSet(this.f18440a, this.b, navigableSet, this.f8389d == null ? this : this.f8389d);
        }

        public Iterator<V> descendingIterator() {
            return new WrappedIterator(this, ((NavigableSet) super.mo3599d()).descendingIterator());
        }

        public V lower(V v) {
            return ((NavigableSet) super.mo3599d()).lower(v);
        }

        public V floor(V v) {
            return ((NavigableSet) super.mo3599d()).floor(v);
        }

        public V ceiling(V v) {
            return ((NavigableSet) super.mo3599d()).ceiling(v);
        }

        public V higher(V v) {
            return ((NavigableSet) super.mo3599d()).higher(v);
        }

        public NavigableSet<V> descendingSet() {
            return m19251a(((NavigableSet) super.mo3599d()).descendingSet());
        }

        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return m19251a(((NavigableSet) super.mo3599d()).subSet(v, z, v2, z2));
        }

        public NavigableSet<V> headSet(V v, boolean z) {
            return m19251a(((NavigableSet) super.mo3599d()).headSet(v, z));
        }

        public NavigableSet<V> tailSet(V v, boolean z) {
            return m19251a(((NavigableSet) super.mo3599d()).tailSet(v, z));
        }

        final /* bridge */ /* synthetic */ SortedSet mo3599d() {
            return (NavigableSet) super.mo3599d();
        }
    }

    class NavigableAsMap extends SortedAsMap implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap f19259c;

        final /* synthetic */ SortedSet mo4047b() {
            return m20482f();
        }

        final /* synthetic */ Set mo3598e() {
            return m20482f();
        }

        NavigableAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.f19259c = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        public Entry<K, Collection<V>> pollFirstEntry() {
            return m20481a(entrySet().iterator());
        }

        public Entry<K, Collection<V>> pollLastEntry() {
            return m20481a(descendingMap().entrySet().iterator());
        }

        private Entry<K, Collection<V>> m20481a(Iterator<Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Entry entry = (Entry) it.next();
            Collection a = this.f19259c.mo4053a();
            a.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.m7225a(entry.getKey(), AbstractMapBasedMultimap.m19254a(a));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(this.f19259c, ((NavigableMap) super.mo4049d()).descendingMap());
        }

        private NavigableSet<K> m20482f() {
            return new NavigableKeySet(this.f19259c, (NavigableMap) super.mo4049d());
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new NavigableAsMap(this.f19259c, ((NavigableMap) super.mo4049d()).subMap(k, z, k2, z2));
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new NavigableAsMap(this.f19259c, ((NavigableMap) super.mo4049d()).headMap(k, z));
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new NavigableAsMap(this.f19259c, ((NavigableMap) super.mo4049d()).tailMap(k, z));
        }

        public Entry<K, Collection<V>> lowerEntry(K k) {
            k = ((NavigableMap) super.mo4049d()).lowerEntry(k);
            if (k == null) {
                return null;
            }
            return m14707a(k);
        }

        public K lowerKey(K k) {
            return ((NavigableMap) super.mo4049d()).lowerKey(k);
        }

        public Entry<K, Collection<V>> floorEntry(K k) {
            k = ((NavigableMap) super.mo4049d()).floorEntry(k);
            if (k == null) {
                return null;
            }
            return m14707a(k);
        }

        public K floorKey(K k) {
            return ((NavigableMap) super.mo4049d()).floorKey(k);
        }

        public Entry<K, Collection<V>> ceilingEntry(K k) {
            k = ((NavigableMap) super.mo4049d()).ceilingEntry(k);
            if (k == null) {
                return null;
            }
            return m14707a(k);
        }

        public K ceilingKey(K k) {
            return ((NavigableMap) super.mo4049d()).ceilingKey(k);
        }

        public Entry<K, Collection<V>> higherEntry(K k) {
            k = ((NavigableMap) super.mo4049d()).higherEntry(k);
            if (k == null) {
                return null;
            }
            return m14707a(k);
        }

        public K higherKey(K k) {
            return ((NavigableMap) super.mo4049d()).higherKey(k);
        }

        public Entry<K, Collection<V>> firstEntry() {
            Entry firstEntry = ((NavigableMap) super.mo4049d()).firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return m14707a(firstEntry);
        }

        public Entry<K, Collection<V>> lastEntry() {
            Entry lastEntry = ((NavigableMap) super.mo4049d()).lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return m14707a(lastEntry);
        }

        public NavigableSet<K> navigableKeySet() {
            return (NavigableSet) super.mo4048c();
        }

        public final /* bridge */ /* synthetic */ SortedSet mo4048c() {
            return (NavigableSet) super.mo4048c();
        }

        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        public /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        final /* bridge */ /* synthetic */ SortedMap mo4049d() {
            return (NavigableMap) super.mo4049d();
        }

        public /* synthetic */ Set keySet() {
            return (NavigableSet) super.mo4048c();
        }
    }

    private class SortedKeySet extends KeySet implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap f19260c;

        SortedKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f19260c = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        public Comparator<? super K> comparator() {
            return mo4294a().comparator();
        }

        public K first() {
            return mo4294a().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new SortedKeySet(this.f19260c, mo4294a().headMap(k));
        }

        public K last() {
            return mo4294a().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new SortedKeySet(this.f19260c, mo4294a().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new SortedKeySet(this.f19260c, mo4294a().tailMap(k));
        }

        SortedMap<K, Collection<V>> mo4294a() {
            return (SortedMap) this.f14929d;
        }
    }

    class NavigableKeySet extends SortedKeySet implements NavigableSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap f19721b;

        NavigableKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.f19721b = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        public K pollFirst() {
            return Iterators.m7157e(iterator());
        }

        public K pollLast() {
            return Iterators.m7157e(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(this.f19721b, ((NavigableMap) super.mo4294a()).descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return new NavigableKeySet(this.f19721b, ((NavigableMap) super.mo4294a()).headMap(k, z));
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new NavigableKeySet(this.f19721b, ((NavigableMap) super.mo4294a()).subMap(k, z, k2, z2));
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return new NavigableKeySet(this.f19721b, ((NavigableMap) super.mo4294a()).tailMap(k, z));
        }

        public K lower(K k) {
            return ((NavigableMap) super.mo4294a()).lowerKey(k);
        }

        public K floor(K k) {
            return ((NavigableMap) super.mo4294a()).floorKey(k);
        }

        public K ceiling(K k) {
            return ((NavigableMap) super.mo4294a()).ceilingKey(k);
        }

        public K higher(K k) {
            return ((NavigableMap) super.mo4294a()).higherKey(k);
        }

        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        public /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        final /* bridge */ /* synthetic */ SortedMap mo4294a() {
            return (NavigableMap) super.mo4294a();
        }
    }

    abstract Collection<V> mo4053a();

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.m6913a(map.isEmpty());
        this.f18441a = map;
    }

    public boolean mo2387a(K k, V v) {
        Collection collection = (Collection) this.f18441a.get(k);
        if (collection == null) {
            collection = mo4053a();
            if (collection.add(v) != null) {
                this.f18442b += 1;
                this.f18441a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(v) == null) {
            return null;
        } else {
            this.f18442b += 1;
            return true;
        }
    }

    static <E> Collection<E> m19254a(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return Sets.m7256a((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public void mo4391b() {
        for (Collection clear : this.f18441a.values()) {
            clear.clear();
        }
        this.f18441a.clear();
        this.f18442b = 0;
    }

    public Collection<V> mo3600a(K k) {
        Collection collection = (Collection) this.f18441a.get(k);
        if (collection == null) {
            collection = mo4053a();
        }
        return m19265a((Object) k, collection);
    }

    final Collection<V> m19265a(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new WrappedNavigableSet(this, k, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return m19256a(k, (List) collection, null);
        }
        return new WrappedCollection(this, k, collection, null);
    }

    private List<V> m19256a(K k, List<V> list, WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(this, k, list, wrappedCollection) : new WrappedList(this, k, list, wrappedCollection);
    }

    final Set<K> mo3601c() {
        if (this.f18441a instanceof NavigableMap) {
            return new NavigableKeySet(this, (NavigableMap) this.f18441a);
        }
        if (this.f18441a instanceof SortedMap) {
            return new SortedKeySet(this, (SortedMap) this.f18441a);
        }
        return new KeySet(this, this.f18441a);
    }

    final Map<K, Collection<V>> mo3602d() {
        if (this.f18441a instanceof NavigableMap) {
            return new NavigableAsMap(this, (NavigableMap) this.f18441a);
        }
        if (this.f18441a instanceof SortedMap) {
            return new SortedAsMap(this, (SortedMap) this.f18441a);
        }
        return new AsMap(this, this.f18441a);
    }

    static /* synthetic */ Iterator m19260b(Collection collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    static /* synthetic */ void m19258a(AbstractMapBasedMultimap abstractMapBasedMultimap, Object obj) {
        Collection collection = (Collection) Maps.m7229c(abstractMapBasedMultimap.f18441a, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            abstractMapBasedMultimap.f18442b -= size;
        }
    }
}
