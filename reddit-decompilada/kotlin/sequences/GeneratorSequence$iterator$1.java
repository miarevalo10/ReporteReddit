package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\t\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "(Lkotlin/sequences/GeneratorSequence;)V", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sequences.kt */
public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    final /* synthetic */ GeneratorSequence f33119a;
    private T f33120b;
    private int f33121c = -2;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    GeneratorSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.f33119a = generatorSequence;
    }

    private final void m33699a() {
        Object invoke;
        if (this.f33121c == -2) {
            invoke = this.f33119a.f33122a.invoke();
        } else {
            Function1 b = this.f33119a.f33123b;
            Object obj = this.f33120b;
            if (obj == null) {
                Intrinsics.m26842a();
            }
            invoke = b.mo6492a(obj);
        }
        this.f33120b = invoke;
        this.f33121c = this.f33120b == null ? 0 : 1;
    }

    public final T next() {
        if (this.f33121c < 0) {
            m33699a();
        }
        if (this.f33121c == 0) {
            throw new NoSuchElementException();
        }
        T t = this.f33120b;
        if (t == null) {
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        this.f33121c = -1;
        return t;
    }

    public final boolean hasNext() {
        if (this.f33121c < 0) {
            m33699a();
        }
        return this.f33121c == 1;
    }
}
