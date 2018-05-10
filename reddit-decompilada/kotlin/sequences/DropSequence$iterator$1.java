package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\t\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "(Lkotlin/sequences/DropSequence;)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sequences.kt */
public final class DropSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    final /* synthetic */ DropSequence f33103a;
    private final Iterator<T> f33104b;
    private int f33105c;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    DropSequence$iterator$1(DropSequence dropSequence) {
        this.f33103a = dropSequence;
        this.f33104b = dropSequence.f36194a.mo5679a();
        this.f33105c = dropSequence.f36195b;
    }

    private final void m33687a() {
        while (this.f33105c > 0 && this.f33104b.hasNext()) {
            this.f33104b.next();
            this.f33105c--;
        }
    }

    public final T next() {
        m33687a();
        return this.f33104b.next();
    }

    public final boolean hasNext() {
        m33687a();
        return this.f33104b.hasNext();
    }
}
