package kotlin.reflect.jvm.internal.impl.protobuf;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    boolean f25954a;
    private final int f25955b;
    private List<Entry> f25956c;
    private Map<K, V> f25957d;
    private volatile EntrySet f25958e;

    private static class EmptySet {
        private static final Iterator<Object> f25944a = new C21411();
        private static final Iterable<Object> f25945b = new C21422();

        static class C21411 implements Iterator<Object> {
            public final boolean hasNext() {
                return false;
            }

            C21411() {
            }

            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        static class C21422 implements Iterable<Object> {
            C21422() {
            }

            public final Iterator<Object> iterator() {
                return EmptySet.f25944a;
            }
        }

        static <T> Iterable<T> m27553a() {
            return f25945b;
        }
    }

    private class Entry implements Comparable<Entry>, java.util.Map.Entry<K, V> {
        final K f25946a;
        final /* synthetic */ SmallSortedMap f25947b;
        private V f25948c;

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f25946a.compareTo(((Entry) obj).f25946a);
        }

        Entry(SmallSortedMap smallSortedMap, java.util.Map.Entry<K, V> entry) {
            this(smallSortedMap, (Comparable) entry.getKey(), entry.getValue());
        }

        Entry(SmallSortedMap smallSortedMap, K k, V v) {
            this.f25947b = smallSortedMap;
            this.f25946a = k;
            this.f25948c = v;
        }

        public V getValue() {
            return this.f25948c;
        }

        public V setValue(V v) {
            this.f25947b.m27564d();
            V v2 = this.f25948c;
            this.f25948c = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return m27555a(this.f25946a, entry.getKey()) && m27555a(this.f25948c, entry.getValue()) != null;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f25946a == null ? 0 : this.f25946a.hashCode();
            if (this.f25948c != null) {
                i = this.f25948c.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            String valueOf = String.valueOf(String.valueOf(this.f25946a));
            String valueOf2 = String.valueOf(String.valueOf(this.f25948c));
            StringBuilder stringBuilder = new StringBuilder((1 + valueOf.length()) + valueOf2.length());
            stringBuilder.append(valueOf);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(valueOf2);
            return stringBuilder.toString();
        }

        private static boolean m27555a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null ? true : null;
            } else {
                return obj.equals(obj2);
            }
        }

        public /* bridge */ /* synthetic */ Object getKey() {
            return this.f25946a;
        }
    }

    private class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap f25949a;
        private int f25950b;
        private boolean f25951c;
        private Iterator<java.util.Map.Entry<K, V>> f25952d;

        private EntryIterator(SmallSortedMap smallSortedMap) {
            this.f25949a = smallSortedMap;
            this.f25950b = -1;
        }

        public boolean hasNext() {
            if (this.f25950b + 1 >= this.f25949a.f25956c.size()) {
                if (!m27556a().hasNext()) {
                    return false;
                }
            }
            return true;
        }

        public void remove() {
            if (this.f25951c) {
                this.f25951c = false;
                this.f25949a.m27564d();
                if (this.f25950b < this.f25949a.f25956c.size()) {
                    SmallSortedMap smallSortedMap = this.f25949a;
                    int i = this.f25950b;
                    this.f25950b = i - 1;
                    smallSortedMap.m27562c(i);
                    return;
                }
                m27556a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<java.util.Map.Entry<K, V>> m27556a() {
            if (this.f25952d == null) {
                this.f25952d = this.f25949a.f25957d.entrySet().iterator();
            }
            return this.f25952d;
        }

        public /* synthetic */ Object next() {
            this.f25951c = true;
            int i = this.f25950b + 1;
            this.f25950b = i;
            if (i < this.f25949a.f25956c.size()) {
                return (java.util.Map.Entry) this.f25949a.f25956c.get(this.f25950b);
            }
            return (java.util.Map.Entry) m27556a().next();
        }
    }

    private class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap f25953a;

        private EntrySet(SmallSortedMap smallSortedMap) {
            this.f25953a = smallSortedMap;
        }

        public /* synthetic */ boolean add(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (contains(entry)) {
                return null;
            }
            this.f25953a.m27566a((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public int size() {
            return this.f25953a.size();
        }

        public boolean contains(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            Object obj2 = this.f25953a.get(entry.getKey());
            obj = entry.getValue();
            if (obj2 != obj) {
                if (obj2 == null || obj2.equals(obj) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean remove(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (!contains(entry)) {
                return null;
            }
            this.f25953a.remove(entry.getKey());
            return true;
        }

        public void clear() {
            this.f25953a.clear();
        }
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m27566a((Comparable) obj, obj2);
    }

    static <FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> m27559a(int i) {
        return new SmallSortedMap<FieldDescriptorType, Object>(i) {
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                return super.m27566a((FieldDescriptorLite) obj, obj2);
            }

            public final void mo5881a() {
                if (!this.f25954a) {
                    java.util.Map.Entry b;
                    for (int i = 0; i < m27568b(); i++) {
                        b = m27569b(i);
                        if (((FieldDescriptorLite) b.getKey()).mo5867c()) {
                            b.setValue(Collections.unmodifiableList((List) b.getValue()));
                        }
                    }
                    for (java.util.Map.Entry b2 : m27570c()) {
                        if (((FieldDescriptorLite) b2.getKey()).mo5867c()) {
                            b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                        }
                    }
                }
                super.mo5881a();
            }
        };
    }

    private SmallSortedMap(int i) {
        this.f25955b = i;
        this.f25956c = Collections.emptyList();
        this.f25957d = Collections.emptyMap();
    }

    public void mo5881a() {
        if (!this.f25954a) {
            this.f25957d = this.f25957d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f25957d);
            this.f25954a = true;
        }
    }

    public final int m27568b() {
        return this.f25956c.size();
    }

    public final java.util.Map.Entry<K, V> m27569b(int i) {
        return (java.util.Map.Entry) this.f25956c.get(i);
    }

    public final Iterable<java.util.Map.Entry<K, V>> m27570c() {
        return this.f25957d.isEmpty() ? EmptySet.m27553a() : this.f25957d.entrySet();
    }

    public int size() {
        return this.f25956c.size() + this.f25957d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (m27557a(comparable) < 0) {
            if (this.f25957d.containsKey(comparable) == null) {
                return null;
            }
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m27557a(comparable);
        if (a >= 0) {
            return ((Entry) this.f25956c.get(a)).getValue();
        }
        return this.f25957d.get(comparable);
    }

    public final V m27566a(K k, V v) {
        m27564d();
        int a = m27557a((Comparable) k);
        if (a >= 0) {
            return ((Entry) this.f25956c.get(a)).setValue(v);
        }
        m27564d();
        if (this.f25956c.isEmpty() && !(this.f25956c instanceof ArrayList)) {
            this.f25956c = new ArrayList(this.f25955b);
        }
        a = -(a + 1);
        if (a >= this.f25955b) {
            return m27565e().put(k, v);
        }
        if (this.f25956c.size() == this.f25955b) {
            Entry entry = (Entry) this.f25956c.remove(this.f25955b - 1);
            m27565e().put(entry.f25946a, entry.getValue());
        }
        this.f25956c.add(a, new Entry(this, k, v));
        return null;
    }

    public void clear() {
        m27564d();
        if (!this.f25956c.isEmpty()) {
            this.f25956c.clear();
        }
        if (!this.f25957d.isEmpty()) {
            this.f25957d.clear();
        }
    }

    public V remove(Object obj) {
        m27564d();
        Comparable comparable = (Comparable) obj;
        int a = m27557a(comparable);
        if (a >= 0) {
            return m27562c(a);
        }
        if (this.f25957d.isEmpty()) {
            return null;
        }
        return this.f25957d.remove(comparable);
    }

    private V m27562c(int i) {
        m27564d();
        i = ((Entry) this.f25956c.remove(i)).getValue();
        if (!this.f25957d.isEmpty()) {
            Iterator it = m27565e().entrySet().iterator();
            this.f25956c.add(new Entry(this, (java.util.Map.Entry) it.next()));
            it.remove();
        }
        return i;
    }

    private int m27557a(K k) {
        int compareTo;
        int size = this.f25956c.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo(((Entry) this.f25956c.get(size)).f25946a);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        compareTo = 0;
        while (compareTo <= size) {
            int i = (compareTo + size) / 2;
            int compareTo2 = k.compareTo(((Entry) this.f25956c.get(i)).f25946a);
            if (compareTo2 < 0) {
                size = i - 1;
            } else if (compareTo2 <= 0) {
                return i;
            } else {
                compareTo = i + 1;
            }
        }
        return -(compareTo + 1);
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        if (this.f25958e == null) {
            this.f25958e = new EntrySet();
        }
        return this.f25958e;
    }

    private void m27564d() {
        if (this.f25954a) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> m27565e() {
        m27564d();
        if (this.f25957d.isEmpty() && !(this.f25957d instanceof TreeMap)) {
            this.f25957d = new TreeMap();
        }
        return (SortedMap) this.f25957d;
    }
}
