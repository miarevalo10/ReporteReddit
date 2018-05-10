package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001d*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001d\u001e\u001f B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\u000b\u0010\u0012\u001a\u00078\u0000¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00062\u000b\u0010\u0012\u001a\u00078\u0000¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "Lkotlin/UnsafeVariance;", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: AbstractList.kt */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    public static final Companion f36004a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000¢\u0006\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AbstractList.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m26782a(int i, int i2) {
            if (i >= 0) {
                if (i < i2) {
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("index: ");
            stringBuilder.append(i);
            stringBuilder.append(", size: ");
            stringBuilder.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        public static void m26785b(int i, int i2) {
            if (i >= 0) {
                if (i <= i2) {
                    return;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("index: ");
            stringBuilder.append(i);
            stringBuilder.append(", size: ");
            stringBuilder.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        public static void m26783a(int i, int i2, int i3) {
            if (i >= 0) {
                if (i2 <= i3) {
                    if (i > i2) {
                        StringBuilder stringBuilder = new StringBuilder("fromIndex: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" > toIndex: ");
                        stringBuilder.append(i2);
                        throw ((Throwable) new IllegalArgumentException(stringBuilder.toString()));
                    }
                    return;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("fromIndex: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", toIndex: ");
            stringBuilder2.append(i2);
            stringBuilder2.append(", size: ");
            stringBuilder2.append(i3);
            throw new IndexOutOfBoundsException(stringBuilder2.toString());
        }

        public static int m26781a(Collection<?> collection) {
            Intrinsics.m26847b(collection, "c");
            int i = 1;
            for (Object next : collection) {
                i = (next != null ? next.hashCode() : 0) + (31 * i);
            }
            return i;
        }

        public static boolean m26784a(Collection<?> collection, Collection<?> collection2) {
            Intrinsics.m26847b(collection, "c");
            Intrinsics.m26847b(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            collection2 = collection2.iterator();
            for (Object a : collection) {
                if ((Intrinsics.m26845a(a, collection2.next()) ^ 1) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AbstractList.kt */
    private class IteratorImpl implements Iterator<E>, KMappedMarker {
        int f32500a;
        final /* synthetic */ AbstractList f32501b;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public IteratorImpl(AbstractList abstractList) {
            this.f32501b = abstractList;
        }

        public boolean hasNext() {
            return this.f32500a < this.f32501b.size();
        }

        public E next() {
            if (hasNext()) {
                AbstractList abstractList = this.f32501b;
                int i = this.f32500a;
                this.f32500a = i + 1;
                return abstractList.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AbstractList.kt */
    private class ListIteratorImpl extends IteratorImpl implements ListIterator<E>, KMappedMarker {
        final /* synthetic */ AbstractList f36003c;

        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ListIteratorImpl(AbstractList abstractList, int i) {
            this.f36003c = abstractList;
            super(abstractList);
            Companion companion = AbstractList.f36004a;
            Companion.m26785b(i, abstractList.size());
            this.f32500a = i;
        }

        public E previous() {
            if (hasPrevious()) {
                AbstractList abstractList = this.f36003c;
                this.f32500a--;
                return abstractList.get(this.f32500a);
            }
            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return this.f32500a > 0;
        }

        public int nextIndex() {
            return this.f32500a;
        }

        public int previousIndex() {
            return this.f32500a - 1;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AbstractList.kt */
    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int f38192b;
        private final AbstractList<E> f38193c;
        private final int f38194d;

        public SubList(AbstractList<? extends E> abstractList, int i, int i2) {
            Intrinsics.m26847b(abstractList, "list");
            this.f38193c = abstractList;
            this.f38194d = i;
            Companion.m26783a(this.f38194d, i2, this.f38193c.size());
            this.f38192b = i2 - this.f38194d;
        }

        public final E get(int i) {
            Companion.m26782a(i, this.f38192b);
            return this.f38193c.get(this.f38194d + i);
        }

        public final int mo7058a() {
            return this.f38192b;
        }
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int i);

    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractList() {
    }

    public Iterator<E> iterator() {
        return new IteratorImpl(this);
    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    public ListIterator<E> listIterator(int i) {
        return new ListIteratorImpl(this, i);
    }

    public List<E> subList(int i, int i2) {
        return new SubList(this, i, i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.m26784a((Collection) this, (Collection) obj);
        }
        return null;
    }

    public int hashCode() {
        return Companion.m26781a(this);
    }

    public int indexOf(Object obj) {
        int i = 0;
        for (Object a : this) {
            if (Intrinsics.m26845a(a, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.m26845a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
