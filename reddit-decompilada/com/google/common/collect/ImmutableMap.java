package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Entry<?, ?>[] f8429a = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> f8430b;
    private transient ImmutableSet<K> f8431c;
    private transient ImmutableCollection<V> f8432d;

    public static class Builder<K, V> {
        Comparator<? super V> f8425a;
        Object[] f8426b;
        int f8427c;
        boolean f8428d;

        public Builder() {
            this(4);
        }

        Builder(int i) {
            this.f8426b = new Object[(2 * i)];
            this.f8427c = 0;
            this.f8428d = false;
        }

        private void m7122a(int i) {
            i *= 2;
            if (i > this.f8426b.length) {
                this.f8426b = Arrays.copyOf(this.f8426b, com.google.common.collect.ImmutableCollection.Builder.m7115a(this.f8426b.length, i));
                this.f8428d = false;
            }
        }

        public final Builder<K, V> m7124a(K k, V v) {
            m7122a(this.f8427c + 1);
            CollectPreconditions.m7081a((Object) k, (Object) v);
            this.f8426b[this.f8427c * 2] = k;
            this.f8426b[(2 * this.f8427c) + 1] = v;
            this.f8427c++;
            return this;
        }

        public final Builder<K, V> m7123a(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                m7122a(this.f8427c + ((Collection) iterable).size());
            }
            for (Entry entry : iterable) {
                m7124a(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public final ImmutableMap<K, V> m7125a() {
            if (this.f8425a != null) {
                if (this.f8428d) {
                    this.f8426b = Arrays.copyOf(this.f8426b, this.f8427c * 2);
                }
                Entry[] entryArr = new Entry[this.f8427c];
                int i = 0;
                for (int i2 = 0; i2 < this.f8427c; i2++) {
                    int i3 = 2 * i2;
                    entryArr[i2] = new SimpleImmutableEntry(this.f8426b[i3], this.f8426b[i3 + 1]);
                }
                Arrays.sort(entryArr, 0, this.f8427c, new ByFunctionOrdering(Maps.m7221a(), Ordering.m7244a(this.f8425a)));
                while (i < this.f8427c) {
                    int i4 = 2 * i;
                    this.f8426b[i4] = entryArr[i].getKey();
                    this.f8426b[i4 + 1] = entryArr[i].getValue();
                    i++;
                }
            }
            this.f8428d = true;
            return RegularImmutableMap.m14813a(this.f8427c, this.f8426b);
        }
    }

    abstract ImmutableSet<Entry<K, V>> mo2423c();

    abstract ImmutableSet<K> mo2424d();

    abstract ImmutableCollection<V> mo2425e();

    public abstract V get(Object obj);

    public /* synthetic */ Set entrySet() {
        return m7130f();
    }

    public /* synthetic */ Collection values() {
        return m7131g();
    }

    public static <K, V> ImmutableMap<K, V> m7126a() {
        return RegularImmutableMap.f14931b;
    }

    public static <K, V> ImmutableMap<K, V> m7127a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        CollectPreconditions.m7081a((Object) k, (Object) v);
        CollectPreconditions.m7081a((Object) k2, (Object) v2);
        CollectPreconditions.m7081a((Object) k3, (Object) v3);
        CollectPreconditions.m7081a((Object) k4, (Object) v4);
        return RegularImmutableMap.m14813a(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> Builder<K, V> m7129b() {
        return new Builder();
    }

    public static <K, V> ImmutableMap<K, V> m7128a(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            return (ImmutableMap) map;
        }
        Iterable entrySet = map.entrySet();
        Builder builder = new Builder(entrySet instanceof Collection ? ((Collection) entrySet).size() : 4);
        builder.m7123a(entrySet);
        return builder.m7125a();
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null ? true : null;
    }

    public boolean containsValue(Object obj) {
        return m7131g().contains(obj);
    }

    public final V getOrDefault(Object obj, V v) {
        obj = get(obj);
        return obj != null ? obj : v;
    }

    private ImmutableSet<Entry<K, V>> m7130f() {
        ImmutableSet<Entry<K, V>> immutableSet = this.f8430b;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = mo2423c();
        this.f8430b = immutableSet;
        return immutableSet;
    }

    private ImmutableCollection<V> m7131g() {
        ImmutableCollection<V> immutableCollection = this.f8432d;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = mo2425e();
        this.f8432d = immutableCollection;
        return immutableCollection;
    }

    public boolean equals(Object obj) {
        return Maps.m7232d(this, obj);
    }

    public int hashCode() {
        return Sets.m7252a(m7130f());
    }

    public String toString() {
        return Maps.m7223a((Map) this);
    }

    public /* synthetic */ Set keySet() {
        Set set = this.f8431c;
        if (set != null) {
            return set;
        }
        set = mo2424d();
        this.f8431c = set;
        return set;
    }
}
