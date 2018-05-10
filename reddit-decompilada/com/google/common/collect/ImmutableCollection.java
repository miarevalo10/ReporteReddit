package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] f8424a = new Object[0];

    public static abstract class Builder<E> {
        public abstract Builder<E> mo2395b(E e);

        static int m7115a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            i = (i + (i >> 1)) + 1;
            if (i < i2) {
                i = Integer.highestOneBit(i2 - 1) << 1;
            }
            return i < 0 ? RedditJobManager.f10810d : i;
        }

        Builder() {
        }

        public Builder<E> mo2394a(Iterable<? extends E> iterable) {
            for (Object b : iterable) {
                mo2395b(b);
            }
            return this;
        }
    }

    static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] f14889a = new Object[4];
        int f14890b = 0;
        boolean f14891c;

        public /* synthetic */ Builder mo2395b(Object obj) {
            return mo3608a(obj);
        }

        ArrayBasedBuilder() {
            CollectPreconditions.m7080a(4, "initialCapacity");
        }

        private void m14722a(int i) {
            if (this.f14889a.length < i) {
                this.f14889a = Arrays.copyOf(this.f14889a, Builder.m7115a(this.f14889a.length, i));
                this.f14891c = false;
                return;
            }
            if (this.f14891c != 0) {
                this.f14889a = (Object[]) this.f14889a.clone();
                this.f14891c = false;
            }
        }

        public ArrayBasedBuilder<E> mo3608a(E e) {
            Preconditions.m6908a((Object) e);
            m14722a(this.f14890b + 1);
            Object[] objArr = this.f14889a;
            int i = this.f14890b;
            this.f14890b = i + 1;
            objArr[i] = e;
            return this;
        }

        public Builder<E> mo2394a(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                m14722a(this.f14890b + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f14890b = ((ImmutableCollection) collection).mo2396a(this.f14889a, this.f14890b);
                    return this;
                }
            }
            super.mo2394a(iterable);
            return this;
        }
    }

    public abstract UnmodifiableIterator<E> mo2397a();

    abstract boolean mo3604c();

    public abstract boolean contains(Object obj);

    public /* synthetic */ Iterator iterator() {
        return mo2397a();
    }

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return f8424a;
        }
        Object[] objArr = new Object[size];
        mo2396a(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        Preconditions.m6908a((Object) tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = ObjectArrays.m7241a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo2396a(tArr, 0);
        return tArr;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> mo2398b() {
        return isEmpty() ? ImmutableList.m14735d() : ImmutableList.m14733b(toArray());
    }

    int mo2396a(Object[] objArr, int i) {
        Iterator a = mo2397a();
        while (a.hasNext()) {
            int i2 = i + 1;
            objArr[i] = a.next();
            i = i2;
        }
        return i;
    }
}
