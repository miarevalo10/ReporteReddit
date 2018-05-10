package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> f14894a = new Itr(RegularImmutableList.f18458a, 0);

    public static final class Builder<E> extends ArrayBasedBuilder<E> {
        public Builder() {
            this((byte) 0);
        }

        private Builder(byte b) {
        }

        public final Builder<E> m19281c(E e) {
            super.mo3608a((Object) e);
            return this;
        }

        public final Builder<E> m19280b(Iterable<? extends E> iterable) {
            super.mo2394a((Iterable) iterable);
            return this;
        }

        public final ImmutableList<E> m19278a() {
            this.c = true;
            return ImmutableList.m14734b(this.a, this.b);
        }

        public final /* synthetic */ com.google.common.collect.ImmutableCollection.Builder mo2395b(Object obj) {
            super.mo3608a(obj);
            return this;
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int f18445a;
        final transient int f18446b;
        final /* synthetic */ ImmutableList f18447c;

        final boolean mo3604c() {
            return true;
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.m14740a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return mo3609a(i, i2);
        }

        SubList(ImmutableList immutableList, int i, int i2) {
            this.f18447c = immutableList;
            this.f18445a = i;
            this.f18446b = i2;
        }

        public int size() {
            return this.f18446b;
        }

        public E get(int i) {
            Preconditions.m6907a(i, this.f18446b);
            return this.f18447c.get(i + this.f18445a);
        }

        public final ImmutableList<E> mo3609a(int i, int i2) {
            Preconditions.m6912a(i, i2, this.f18446b);
            return this.f18447c.mo3609a(i + this.f18445a, i2 + this.f18445a);
        }

        public /* synthetic */ ListIterator listIterator() {
            return m14740a(0);
        }

        public /* synthetic */ Iterator iterator() {
            return m14740a(0);
        }
    }

    static class Itr<E> extends AbstractIndexedListIterator<E> {
        private final ImmutableList<E> f19261a;

        Itr(ImmutableList<E> immutableList, int i) {
            super(immutableList.size(), i);
            this.f19261a = immutableList;
        }

        protected final E mo4056a(int i) {
            return this.f19261a.get(i);
        }
    }

    public final ImmutableList<E> mo2398b() {
        return this;
    }

    public int hashCode() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.common.collect.ImmutableList.hashCode():int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableList.hashCode():int");
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        return m14740a(i);
    }

    public /* synthetic */ List subList(int i, int i2) {
        return mo3609a(i, i2);
    }

    public static <E> ImmutableList<E> m14735d() {
        return RegularImmutableList.f18458a;
    }

    public static <E> ImmutableList<E> m14726a(E e) {
        e = ObjectArrays.m7240a(e);
        return m14734b(e, e.length);
    }

    public static <E> ImmutableList<E> m14727a(E e, E e2, E e3, E e4) {
        e = ObjectArrays.m7240a(e, e2, e3, e4);
        return m14734b(e, e.length);
    }

    public static <E> ImmutableList<E> m14728a(E e, E e2, E e3, E e4, E e5, E e6) {
        e = ObjectArrays.m7240a(e, e2, e3, e4, e5, e6);
        return m14734b(e, e.length);
    }

    public static <E> ImmutableList<E> m14729a(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        e = ObjectArrays.m7240a(e, e2, e3, e4, e5, e6, e7);
        return m14734b(e, e.length);
    }

    public static <E> ImmutableList<E> m14730a(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            collection = ((ImmutableCollection) collection).mo2398b();
            if (collection.mo3604c()) {
                collection = collection.toArray();
                collection = m14734b(collection, collection.length);
            }
            return collection;
        }
        collection = ObjectArrays.m7240a(collection.toArray());
        return m14734b(collection, collection.length);
    }

    public static <E> ImmutableList<E> m14732a(E[] eArr) {
        if (eArr.length == 0) {
            return RegularImmutableList.f18458a;
        }
        eArr = ObjectArrays.m7240a((Object[]) eArr.clone());
        return m14734b(eArr, eArr.length);
    }

    public static <E> ImmutableList<E> m14731a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.m6908a((Object) comparator);
        Object[] c = Iterables.m7143c(iterable);
        ObjectArrays.m7240a(c);
        Arrays.sort(c, comparator);
        return m14734b(c, c.length);
    }

    static <E> ImmutableList<E> m14733b(Object[] objArr) {
        return m14734b(objArr, objArr.length);
    }

    ImmutableList() {
    }

    public final UnmodifiableListIterator<E> m14740a(int i) {
        Preconditions.m6920b(i, size());
        if (isEmpty()) {
            return f14894a;
        }
        return new Itr(this, i);
    }

    public int indexOf(Object obj) {
        return obj == null ? -1 : Lists.m7165b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        return obj == null ? -1 : Lists.m7166c(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= null ? true : null;
    }

    public ImmutableList<E> mo3609a(int i, int i2) {
        Preconditions.m6912a(i, i2, size());
        i2 -= i;
        if (i2 == size()) {
            return this;
        }
        if (i2 == 0) {
            return RegularImmutableList.f18458a;
        }
        return new SubList(this, i, i2);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    int mo2396a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(Object obj) {
        return Lists.m7164a((List) this, obj);
    }

    public static <E> Builder<E> m14736e() {
        return new Builder();
    }

    static <E> ImmutableList<E> m14734b(Object[] objArr, int i) {
        if (i == 0) {
            return RegularImmutableList.f18458a;
        }
        return new RegularImmutableList(objArr, i);
    }

    public final UnmodifiableIterator<E> mo2397a() {
        return m14740a(0);
    }

    public /* synthetic */ Iterator iterator() {
        return m14740a(0);
    }

    public /* synthetic */ ListIterator listIterator() {
        return m14740a(0);
    }
}
