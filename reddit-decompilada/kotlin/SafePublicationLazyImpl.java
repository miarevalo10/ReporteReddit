package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\b@\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
final class SafePublicationLazyImpl<T> implements Serializable, Lazy<T> {
    public static final Companion f32488a = new Companion();
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f32489e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");
    private volatile Function0<? extends T> f32490b;
    private volatile Object f32491c = UNINITIALIZED_VALUE.f25272a;
    private final Object f32492d = UNINITIALIZED_VALUE.f25272a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Rd\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "getValueUpdater", "()Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Lazy.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public SafePublicationLazyImpl(Function0<? extends T> function0) {
        Intrinsics.m26847b(function0, "initializer");
        this.f32490b = function0;
    }

    public final T mo5678b() {
        T t = this.f32491c;
        if (t != UNINITIALIZED_VALUE.f25272a) {
            return t;
        }
        Function0 function0 = this.f32490b;
        if (function0 != null) {
            t = function0.invoke();
            if (f32489e.compareAndSet(this, UNINITIALIZED_VALUE.f25272a, t)) {
                this.f32490b = null;
                return t;
            }
        }
        return this.f32491c;
    }

    public final String toString() {
        return (this.f32491c != UNINITIALIZED_VALUE.f25272a ? 1 : null) != null ? String.valueOf(mo5678b()) : "Lazy value not initialized yet.";
    }
}
