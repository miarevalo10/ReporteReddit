package kotlin.collections;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\t2\u000b\u0010\n\u001a\u00078\u0000¢\u0006\u0002\b\u000bH\u0002¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u000b0\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H¦\u0002J\u0015\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0014¢\u0006\u0002\u0010\u0015J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0013\"\u0004\b\u0001\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0013H\u0014¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "Lkotlin/UnsafeVariance;", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: AbstractCollection.kt */
public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    public abstract int mo7058a();

    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractCollection() {
    }

    public final int size() {
        return mo7058a();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.m26847b(collection, "elements");
        Iterable<Object> iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object contains : iterable) {
                if (!contains(contains)) {
                    return null;
                }
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.m41412a((Iterable) this, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, null, (Function1) new AbstractCollection$toString$1(this), 24);
    }

    public Object[] toArray() {
        return CollectionToArray.m26836a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.m26847b(tArr, "array");
        tArr = CollectionToArray.m26837a(this, tArr);
        if (tArr != null) {
            return tArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean contains(Object obj) {
        if (!((this instanceof Collection) && isEmpty())) {
            for (Object a : this) {
                if (Intrinsics.m26845a(a, obj)) {
                    return true;
                }
            }
        }
        return null;
    }
}
