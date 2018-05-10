package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzfhy<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    boolean f7448a;
    private final int f7449b;
    private List<zzfid> f7450c;
    private Map<K, V> f7451d;
    private volatile zzfif f7452e;
    private Map<K, V> f7453f;

    private zzfhy(int i) {
        this.f7449b = i;
        this.f7450c = Collections.emptyList();
        this.f7451d = Collections.emptyMap();
        this.f7453f = Collections.emptyMap();
    }

    private final int m6060a(K k) {
        int compareTo;
        int size = this.f7450c.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((zzfid) this.f7450c.get(size)).getKey());
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
            int compareTo2 = k.compareTo((Comparable) ((zzfid) this.f7450c.get(i)).getKey());
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

    static <FieldDescriptorType extends zzffs<FieldDescriptorType>> zzfhy<FieldDescriptorType, Object> m6061a(int i) {
        return new zzfhz(i);
    }

    private final V m6065c(int i) {
        m6067d();
        V value = ((zzfid) this.f7450c.remove(i)).getValue();
        if (!this.f7451d.isEmpty()) {
            Iterator it = m6068e().entrySet().iterator();
            this.f7450c.add(new zzfid(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final void m6067d() {
        if (this.f7448a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> m6068e() {
        m6067d();
        if (this.f7451d.isEmpty() && !(this.f7451d instanceof TreeMap)) {
            this.f7451d = new TreeMap();
            this.f7453f = ((TreeMap) this.f7451d).descendingMap();
        }
        return (SortedMap) this.f7451d;
    }

    public final V m6069a(K k, V v) {
        m6067d();
        int a = m6060a((Comparable) k);
        if (a >= 0) {
            return ((zzfid) this.f7450c.get(a)).setValue(v);
        }
        m6067d();
        if (this.f7450c.isEmpty() && !(this.f7450c instanceof ArrayList)) {
            this.f7450c = new ArrayList(this.f7449b);
        }
        a = -(a + 1);
        if (a >= this.f7449b) {
            return m6068e().put(k, v);
        }
        if (this.f7450c.size() == this.f7449b) {
            zzfid com_google_android_gms_internal_zzfid = (zzfid) this.f7450c.remove(this.f7449b - 1);
            m6068e().put((Comparable) com_google_android_gms_internal_zzfid.getKey(), com_google_android_gms_internal_zzfid.getValue());
        }
        this.f7450c.add(a, new zzfid(this, k, v));
        return null;
    }

    public void mo1917a() {
        if (!this.f7448a) {
            this.f7451d = this.f7451d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f7451d);
            this.f7453f = this.f7453f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f7453f);
            this.f7448a = true;
        }
    }

    public final int m6071b() {
        return this.f7450c.size();
    }

    public final Entry<K, V> m6072b(int i) {
        return (Entry) this.f7450c.get(i);
    }

    public final Iterable<Entry<K, V>> m6073c() {
        return this.f7451d.isEmpty() ? zzfia.m6074a() : this.f7451d.entrySet();
    }

    public void clear() {
        m6067d();
        if (!this.f7450c.isEmpty()) {
            this.f7450c.clear();
        }
        if (!this.f7451d.isEmpty()) {
            this.f7451d.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (m6060a(comparable) < 0) {
            if (!this.f7451d.containsKey(comparable)) {
                return false;
            }
        }
        return true;
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f7452e == null) {
            this.f7452e = new zzfif();
        }
        return this.f7452e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfhy)) {
            return super.equals(obj);
        }
        zzfhy com_google_android_gms_internal_zzfhy = (zzfhy) obj;
        int size = size();
        if (size != com_google_android_gms_internal_zzfhy.size()) {
            return false;
        }
        int b = m6071b();
        if (b != com_google_android_gms_internal_zzfhy.m6071b()) {
            return entrySet().equals(com_google_android_gms_internal_zzfhy.entrySet());
        }
        for (int i = 0; i < b; i++) {
            if (!m6072b(i).equals(com_google_android_gms_internal_zzfhy.m6072b(i))) {
                return false;
            }
        }
        return b != size ? this.f7451d.equals(com_google_android_gms_internal_zzfhy.f7451d) : true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m6060a(comparable);
        return a >= 0 ? ((zzfid) this.f7450c.get(a)).getValue() : this.f7451d.get(comparable);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (i < m6071b()) {
            i2 += ((zzfid) this.f7450c.get(i)).hashCode();
            i++;
        }
        return this.f7451d.size() > 0 ? i2 + this.f7451d.hashCode() : i2;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m6069a((Comparable) obj, obj2);
    }

    public V remove(Object obj) {
        m6067d();
        Comparable comparable = (Comparable) obj;
        int a = m6060a(comparable);
        return a >= 0 ? m6065c(a) : this.f7451d.isEmpty() ? null : this.f7451d.remove(comparable);
    }

    public int size() {
        return this.f7450c.size() + this.f7451d.size();
    }
}
