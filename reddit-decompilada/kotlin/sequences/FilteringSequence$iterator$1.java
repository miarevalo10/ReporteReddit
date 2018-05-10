package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\t\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "(Lkotlin/sequences/FilteringSequence;)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sequences.kt */
public final class FilteringSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    final /* synthetic */ FilteringSequence f33106a;
    private final Iterator<T> f33107b;
    private int f33108c = -1;
    private T f33109d;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    FilteringSequence$iterator$1(FilteringSequence filteringSequence) {
        this.f33106a = filteringSequence;
        this.f33107b = filteringSequence.f33110a.mo5679a();
    }

    private final void m33689a() {
        while (this.f33107b.hasNext()) {
            Object next = this.f33107b.next();
            if (((Boolean) this.f33106a.f33112c.mo6492a(next)).booleanValue() == this.f33106a.f33111b) {
                this.f33109d = next;
                this.f33108c = 1;
                return;
            }
        }
        this.f33108c = 0;
    }

    public final T next() {
        if (this.f33108c == -1) {
            m33689a();
        }
        if (this.f33108c == 0) {
            throw new NoSuchElementException();
        }
        T t = this.f33109d;
        this.f33109d = null;
        this.f33108c = -1;
        return t;
    }

    public final boolean hasNext() {
        if (this.f33108c == -1) {
            m33689a();
        }
        return this.f33108c == 1;
    }
}
