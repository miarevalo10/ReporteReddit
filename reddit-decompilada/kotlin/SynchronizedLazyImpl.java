package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
final class SynchronizedLazyImpl<T> implements Serializable, Lazy<T> {
    private Function0<? extends T> f32493a;
    private volatile Object f32494b;
    private final Object f32495c;

    private SynchronizedLazyImpl(Function0<? extends T> function0) {
        Intrinsics.m26847b(function0, "initializer");
        this.f32493a = function0;
        this.f32494b = UNINITIALIZED_VALUE.f25272a;
        this.f32495c = this;
    }

    public final T mo5678b() {
        T t = this.f32494b;
        if (t != UNINITIALIZED_VALUE.f25272a) {
            return t;
        }
        T t2;
        synchronized (this.f32495c) {
            t2 = this.f32494b;
            if (t2 == UNINITIALIZED_VALUE.f25272a) {
                Function0 function0 = this.f32493a;
                if (function0 == null) {
                    Intrinsics.m26842a();
                }
                t2 = function0.invoke();
                this.f32494b = t2;
                this.f32493a = null;
            }
        }
        return t2;
    }

    public final String toString() {
        return (this.f32494b != UNINITIALIZED_VALUE.f25272a ? 1 : null) != null ? String.valueOf(mo5678b()) : "Lazy value not initialized yet.";
    }
}
