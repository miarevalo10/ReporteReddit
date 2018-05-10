package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "(Lkotlin/sequences/TransformingSequence;)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sequences.kt */
public final class TransformingSequence$iterator$1 implements Iterator<R>, KMappedMarker {
    final /* synthetic */ TransformingSequence f33131a;
    private final Iterator<T> f33132b;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    TransformingSequence$iterator$1(TransformingSequence transformingSequence) {
        this.f33131a = transformingSequence;
        this.f33132b = transformingSequence.f33133a.mo5679a();
    }

    public final R next() {
        return this.f33131a.f33134b.mo6492a(this.f33132b.next());
    }

    public final boolean hasNext() {
        return this.f33132b.hasNext();
    }
}
