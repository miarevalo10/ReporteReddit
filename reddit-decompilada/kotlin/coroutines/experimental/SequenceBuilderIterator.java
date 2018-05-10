package kotlin.coroutines.experimental;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006'"}, d2 = {"Lkotlin/coroutines/experimental/SequenceBuilderIterator;", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "Lkotlin/coroutines/experimental/Continuation;", "", "()V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/experimental/Continuation;", "setNextStep", "(Lkotlin/coroutines/experimental/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/coroutines/experimental/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: SequenceBuilder.kt */
final class SequenceBuilderIterator<T> extends SequenceBuilder<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    Continuation<? super Unit> f32520a;
    private int f32521b;
    private T f32522c;
    private Iterator<? extends T> f32523d;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ void mo5683a(Object obj) {
        Intrinsics.m26847b((Unit) obj, "value");
        this.f32521b = 4;
    }

    public final boolean hasNext() {
        while (true) {
            switch (this.f32521b) {
                case 0:
                    break;
                case 1:
                    Iterator it = this.f32523d;
                    if (it == null) {
                        Intrinsics.m26842a();
                    }
                    if (!it.hasNext()) {
                        this.f32523d = null;
                        break;
                    }
                    this.f32521b = 2;
                    return true;
                case 2:
                case 3:
                    return true;
                case 4:
                    return false;
                default:
                    throw m32824b();
            }
            this.f32521b = 5;
            Continuation continuation = this.f32520a;
            if (continuation == null) {
                Intrinsics.m26842a();
            }
            this.f32520a = null;
            continuation.mo5683a(Unit.f25273a);
        }
    }

    public final T next() {
        do {
            switch (this.f32521b) {
                case 0:
                case 1:
                    break;
                case 2:
                    this.f32521b = 1;
                    Iterator it = this.f32523d;
                    if (it == null) {
                        Intrinsics.m26842a();
                    }
                    return it.next();
                case 3:
                    this.f32521b = 0;
                    T t = this.f32522c;
                    this.f32522c = null;
                    return t;
                default:
                    throw m32824b();
            }
        } while (hasNext());
        throw new NoSuchElementException();
    }

    private final Throwable m32824b() {
        switch (this.f32521b) {
            case 4:
                return new NoSuchElementException();
            case 5:
                return new IllegalStateException("Iterator has failed.");
            default:
                StringBuilder stringBuilder = new StringBuilder("Unexpected state of the iterator: ");
                stringBuilder.append(this.f32521b);
                return new IllegalStateException(stringBuilder.toString());
        }
    }

    public final Object mo5681a(T t, Continuation<? super Unit> continuation) {
        this.f32522c = t;
        this.f32521b = 3;
        this.f32520a = CoroutineIntrinsics.m26816a(continuation);
        return IntrinsicsKt.m26814a();
    }

    public final void mo5684b(Throwable th) {
        Intrinsics.m26847b(th, "exception");
        throw th;
    }

    public final CoroutineContext mo5682a() {
        return EmptyCoroutineContext.f32519a;
    }
}
