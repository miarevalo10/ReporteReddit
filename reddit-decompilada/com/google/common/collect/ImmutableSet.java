package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private transient ImmutableList<E> f14895a;

    public static class Builder<E> extends ArrayBasedBuilder<E> {
        Object[] f18448d;
        private int f18449e;

        public final /* synthetic */ ArrayBasedBuilder mo3608a(Object obj) {
            return m19288c(obj);
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo2395b(Object obj) {
            return m19288c(obj);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.common.collect.ImmutableSet.Builder<E> m19288c(E r5) {
            /*
            r4 = this;
            com.google.common.base.Preconditions.m6908a(r5);
            r0 = r4.f18448d;
            if (r0 == 0) goto L_0x003d;
        L_0x0007:
            r0 = r4.b;
            r0 = com.google.common.collect.ImmutableSet.m14742a(r0);
            r1 = r4.f18448d;
            r1 = r1.length;
            if (r0 > r1) goto L_0x003d;
        L_0x0012:
            r0 = r4.f18448d;
            r0 = r0.length;
            r0 = r0 + -1;
            r1 = r5.hashCode();
            r2 = com.google.common.collect.Hashing.m7112a(r1);
        L_0x001f:
            r2 = r2 & r0;
            r3 = r4.f18448d;
            r3 = r3[r2];
            if (r3 != 0) goto L_0x0033;
        L_0x0026:
            r0 = r4.f18448d;
            r0[r2] = r5;
            r0 = r4.f18449e;
            r0 = r0 + r1;
            r4.f18449e = r0;
            super.mo3608a(r5);
            goto L_0x003c;
        L_0x0033:
            r3 = r3.equals(r5);
            if (r3 != 0) goto L_0x003c;
        L_0x0039:
            r2 = r2 + 1;
            goto L_0x001f;
        L_0x003c:
            return r4;
        L_0x003d:
            r0 = 0;
            r4.f18448d = r0;
            super.mo3608a(r5);
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSet.Builder.c(java.lang.Object):com.google.common.collect.ImmutableSet$Builder<E>");
        }

        public final ImmutableSet<E> m19286a() {
            switch (this.b) {
                case 0:
                    return ImmutableSet.m14751e();
                case 1:
                    return ImmutableSet.m14745a(this.a[0]);
                default:
                    ImmutableSet<E> a;
                    if (this.f18448d == null || ImmutableSet.m14742a(this.b) != this.f18448d.length) {
                        a = ImmutableSet.m14749b(this.b, this.a);
                        this.b = a.size();
                    } else {
                        Object[] copyOf;
                        if (ImmutableSet.m14750b(this.b, this.a.length)) {
                            copyOf = Arrays.copyOf(this.a, this.b);
                        } else {
                            copyOf = this.a;
                        }
                        ImmutableSet<E> regularImmutableSet = new RegularImmutableSet(copyOf, this.f18449e, this.f18448d, this.f18448d.length - 1, this.b);
                    }
                    this.c = true;
                    this.f18448d = null;
                    return a;
            }
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo2394a(Iterable iterable) {
            Preconditions.m6908a((Object) iterable);
            if (this.f18448d != null) {
                for (Object c : iterable) {
                    m19288c(c);
                }
            } else {
                super.mo2394a(iterable);
            }
            return this;
        }
    }

    private static boolean m14750b(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public abstract UnmodifiableIterator<E> mo2397a();

    boolean mo3605d() {
        return false;
    }

    public /* synthetic */ Iterator iterator() {
        return mo2397a();
    }

    public static <E> ImmutableSet<E> m14751e() {
        return RegularImmutableSet.f18471a;
    }

    public static <E> ImmutableSet<E> m14745a(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> m14746a(E e, E e2, E e3) {
        return m14749b(3, e, e2, e3);
    }

    private static <E> ImmutableSet<E> m14749b(int i, Object... objArr) {
        while (true) {
            switch (i) {
                case 0:
                    return RegularImmutableSet.f18471a;
                case 1:
                    return m14745a(objArr[0]);
                default:
                    int a = m14742a(i);
                    Object[] objArr2 = new Object[a];
                    int i2 = a - 1;
                    int i3 = 0;
                    int i4 = i3;
                    int i5 = i4;
                    while (i3 < i) {
                        Object a2 = ObjectArrays.m7238a(objArr[i3], i3);
                        int hashCode = a2.hashCode();
                        int a3 = Hashing.m7112a(hashCode);
                        while (true) {
                            int i6 = a3 & i2;
                            Object obj = objArr2[i6];
                            if (obj == null) {
                                a3 = i5 + 1;
                                objArr[i5] = a2;
                                objArr2[i6] = a2;
                                i4 += hashCode;
                                i5 = a3;
                            } else if (!obj.equals(a2)) {
                                a3++;
                            }
                            i3++;
                        }
                    }
                    Arrays.fill(objArr, i5, i, null);
                    if (i5 == 1) {
                        return new SingletonImmutableSet(objArr[0], i4);
                    }
                    if (m14742a(i5) < a / 2) {
                        i = i5;
                    } else {
                        if (m14750b(i5, objArr.length) != 0) {
                            objArr = Arrays.copyOf(objArr, i5);
                        }
                        return new RegularImmutableSet(objArr, i4, objArr2, i2, i5);
                    }
            }
        }
    }

    static int m14742a(int i) {
        i = Math.max(i, 2);
        boolean z = true;
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (i >= 1073741824) {
            z = false;
        }
        Preconditions.m6914a(z, (Object) "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> m14747a(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.mo3604c()) {
                return immutableSet;
            }
        }
        Object[] toArray = collection.toArray();
        return m14749b(toArray.length, toArray);
    }

    public static <E> ImmutableSet<E> m14744a(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return m14747a((Collection) iterable);
        }
        Object it = iterable.iterator();
        if (!it.hasNext()) {
            return RegularImmutableSet.f18471a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return m14745a(next);
        }
        Builder c = new Builder().m19288c(next);
        Preconditions.m6908a(it);
        while (it.hasNext()) {
            c.m19288c(it.next());
        }
        return c.m19286a();
    }

    ImmutableSet() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && mo3605d() && ((ImmutableSet) obj).mo3605d() && hashCode() != obj.hashCode()) {
            return null;
        }
        return Sets.m7257a((Set) this, obj);
    }

    public int hashCode() {
        return Sets.m7252a((Set) this);
    }

    public ImmutableList<E> mo2398b() {
        ImmutableList<E> immutableList = this.f14895a;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = mo3616f();
        this.f14895a = immutableList;
        return immutableList;
    }

    ImmutableList<E> mo3616f() {
        return ImmutableList.m14733b(toArray());
    }

    public static <E> Builder<E> m14752g() {
        return new Builder();
    }
}
