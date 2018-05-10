package android.arch.core.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Iterator;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V> implements Iterable<java.util.Map.Entry<K, V>> {
    public Entry<K, V> f16a;
    public Entry<K, V> f17b;
    public WeakHashMap<Object<K, V>, Boolean> f18c = new WeakHashMap();
    public int f19d = 0;

    static class Entry<K, V> implements java.util.Map.Entry<K, V> {
        final K f7a;
        final V f8b;
        Entry<K, V> f9c;
        Entry<K, V> f10d;

        public K getKey() {
            return this.f7a;
        }

        public V getValue() {
            return this.f8b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f7a);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(this.f8b);
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f7a.equals(entry.f7a) && this.f8b.equals(entry.f8b) != null;
        }
    }

    private class IteratorWithAdditions implements Iterator<java.util.Map.Entry<K, V>> {
        final /* synthetic */ SafeIterableMap f11a;
        private Entry<K, V> f12b;
        private boolean f13c;

        private IteratorWithAdditions(SafeIterableMap safeIterableMap) {
            this.f11a = safeIterableMap;
            this.f13c = true;
        }

        public boolean hasNext() {
            return this.f13c ? this.f11a.f16a != null : (this.f12b == null || this.f12b.f9c == null) ? false : true;
        }

        public /* synthetic */ Object next() {
            Entry a;
            if (this.f13c) {
                this.f13c = false;
                a = this.f11a.f16a;
            } else {
                a = this.f12b != null ? this.f12b.f9c : null;
            }
            this.f12b = a;
            return this.f12b;
        }
    }

    private static abstract class ListIterator<K, V> implements Iterator<java.util.Map.Entry<K, V>> {
        Entry<K, V> f14a;
        Entry<K, V> f15b;

        abstract Entry<K, V> mo1a(Entry<K, V> entry);

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f14a = entry2;
            this.f15b = entry;
        }

        public boolean hasNext() {
            return this.f15b != null;
        }

        public /* synthetic */ Object next() {
            Entry a;
            Entry entry = this.f15b;
            if (this.f15b != this.f14a) {
                if (this.f14a != null) {
                    a = mo1a(this.f15b);
                    this.f15b = a;
                    return entry;
                }
            }
            a = null;
            this.f15b = a;
            return entry;
        }
    }

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        final Entry<K, V> mo1a(Entry<K, V> entry) {
            return entry.f9c;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        final Entry<K, V> mo1a(Entry<K, V> entry) {
            return entry.f10d;
        }
    }

    public Iterator<java.util.Map.Entry<K, V>> iterator() {
        Iterator ascendingIterator = new AscendingIterator(this.f16a, this.f17b);
        this.f18c.put(ascendingIterator, Boolean.valueOf(false));
        return ascendingIterator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (this.f19d != safeIterableMap.f19d) {
            return false;
        }
        Iterator it = iterator();
        obj = safeIterableMap.iterator();
        while (it.hasNext() && obj.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            Object next = obj.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && obj.hasNext() == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((java.util.Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
