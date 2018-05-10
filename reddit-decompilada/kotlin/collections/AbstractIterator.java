package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: AbstractIterator.kt */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    State f32498a = State.f25280b;
    T f32499b;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25276a;

        static {
            int[] iArr = new int[State.values().length];
            f25276a = iArr;
            iArr[State.f25281c.ordinal()] = 1;
            f25276a[State.f25279a.ordinal()] = 2;
        }
    }

    protected abstract void mo6656a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        if (this.f32498a != State.f25282d) {
            switch (WhenMappings.f25276a[this.f32498a.ordinal()]) {
                case 1:
                    return false;
                case 2:
                    return true;
                default:
                    this.f32498a = State.f25282d;
                    mo6656a();
                    return this.f32498a == State.f25279a;
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public T next() {
        if (hasNext()) {
            this.f32498a = State.f25280b;
            return this.f32499b;
        }
        throw new NoSuchElementException();
    }
}
