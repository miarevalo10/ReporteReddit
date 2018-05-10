package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> f14931b = new RegularImmutableMap(null, new Object[0], 0);
    final transient Object[] f14932c;
    private final transient int[] f14933d;
    private final transient int f14934e;

    static class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient ImmutableMap<K, V> f18462a;
        private final transient Object[] f18463b;
        private final transient int f18464c = null;
        private final transient int f18465d;

        class C16131 extends ImmutableList<Entry<K, V>> {
            final /* synthetic */ EntrySet f18461a;

            public final boolean mo3604c() {
                return true;
            }

            C16131(EntrySet entrySet) {
                this.f18461a = entrySet;
            }

            public int size() {
                return this.f18461a.f18465d;
            }

            public /* synthetic */ Object get(int i) {
                Preconditions.m6907a(i, this.f18461a.f18465d);
                int i2 = 2 * i;
                return new SimpleImmutableEntry(this.f18461a.f18463b[this.f18461a.f18464c + i2], this.f18461a.f18463b[i2 + (this.f18461a.f18464c ^ 1)]);
            }
        }

        final boolean mo3604c() {
            return true;
        }

        public /* synthetic */ Iterator iterator() {
            return mo2397a();
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i) {
            this.f18462a = immutableMap;
            this.f18463b = objArr;
            this.f18465d = i;
        }

        public final UnmodifiableIterator<Entry<K, V>> mo2397a() {
            return mo2398b().m14740a(0);
        }

        final ImmutableList<Entry<K, V>> mo3616f() {
            return new C16131(this);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            obj = entry.getValue();
            if (obj == null || obj.equals(this.f18462a.get(key)) == null) {
                return false;
            }
            return true;
        }

        public int size() {
            return this.f18465d;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableMap<K, ?> f18466a;
        private final transient ImmutableList<K> f18467b;

        final boolean mo3604c() {
            return true;
        }

        public final /* synthetic */ Iterator iterator() {
            return mo2397a();
        }

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f18466a = immutableMap;
            this.f18467b = immutableList;
        }

        public final ImmutableList<K> mo2398b() {
            return this.f18467b;
        }

        public final boolean contains(Object obj) {
            return this.f18466a.get(obj) != null ? true : null;
        }

        public final int size() {
            return this.f18466a.size();
        }

        public final UnmodifiableIterator<K> mo2397a() {
            return this.f18467b.m14740a(0);
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] f18468a;
        private final transient int f18469b;
        private final transient int f18470c;

        final boolean mo3604c() {
            return true;
        }

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.f18468a = objArr;
            this.f18469b = i;
            this.f18470c = i2;
        }

        public final Object get(int i) {
            Preconditions.m6907a(i, this.f18470c);
            return this.f18468a[(2 * i) + this.f18469b];
        }

        public final int size() {
            return this.f18470c;
        }
    }

    static <K, V> RegularImmutableMap<K, V> m14813a(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) f14931b;
        }
        int[] iArr = null;
        int i2 = 0;
        if (i == 1) {
            CollectPreconditions.m7081a(objArr[0], objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        Preconditions.m6920b(i, objArr.length >> 1);
        int a = ImmutableSet.m14742a(i);
        if (i == 1) {
            CollectPreconditions.m7081a(objArr[0], objArr[1]);
        } else {
            int i3 = a - 1;
            int[] iArr2 = new int[a];
            Arrays.fill(iArr2, -1);
            while (i2 < i) {
                int i4 = 2 * i2;
                int i5 = i4 + 0;
                Object obj = objArr[i5];
                Object obj2 = objArr[i4 + 1];
                CollectPreconditions.m7081a(obj, obj2);
                int a2 = Hashing.m7112a(obj.hashCode());
                while (true) {
                    a2 &= i3;
                    int i6 = iArr2[a2];
                    if (i6 == -1) {
                        break;
                    } else if (objArr[i6].equals(obj)) {
                        StringBuilder stringBuilder = new StringBuilder("Multiple entries with same key: ");
                        stringBuilder.append(obj);
                        stringBuilder.append(Operation.EQUALS);
                        stringBuilder.append(obj2);
                        stringBuilder.append(" and ");
                        stringBuilder.append(objArr[i6]);
                        stringBuilder.append(Operation.EQUALS);
                        stringBuilder.append(objArr[i6 ^ 1]);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else {
                        a2++;
                    }
                }
                iArr2[a2] = i5;
                i2++;
            }
            iArr = iArr2;
        }
        return new RegularImmutableMap(iArr, objArr, i);
    }

    private RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.f14933d = iArr;
        this.f14932c = objArr;
        this.f14934e = i;
    }

    public final int size() {
        return this.f14934e;
    }

    public final V get(Object obj) {
        int[] iArr = this.f14933d;
        Object[] objArr = this.f14932c;
        int i = this.f14934e;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            return objArr[0].equals(obj) != null ? objArr[1] : null;
        } else {
            if (iArr == null) {
                return null;
            }
            i = iArr.length - 1;
            int a = Hashing.m7112a(obj.hashCode());
            while (true) {
                a &= i;
                int i2 = iArr[a];
                if (i2 == -1) {
                    return null;
                }
                if (objArr[i2].equals(obj)) {
                    return objArr[i2 ^ 1];
                }
                a++;
            }
        }
    }

    final ImmutableSet<Entry<K, V>> mo2423c() {
        return new EntrySet(this, this.f14932c, this.f14934e);
    }

    final ImmutableSet<K> mo2424d() {
        return new KeySet(this, new KeysOrValuesAsList(this.f14932c, 0, this.f14934e));
    }

    final ImmutableCollection<V> mo2425e() {
        return new KeysOrValuesAsList(this.f14932c, 1, this.f14934e);
    }
}
