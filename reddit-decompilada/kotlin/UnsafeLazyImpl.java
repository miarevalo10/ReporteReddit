package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
public final class UnsafeLazyImpl<T> implements Serializable, Lazy<T> {
    private Function0<? extends T> f32496a;
    private Object f32497b = UNINITIALIZED_VALUE.f25272a;

    public UnsafeLazyImpl(Function0<? extends T> function0) {
        Intrinsics.m26847b(function0, "initializer");
        this.f32496a = function0;
    }

    public final T mo5678b() {
        if (this.f32497b == UNINITIALIZED_VALUE.f25272a) {
            Function0 function0 = this.f32496a;
            if (function0 == null) {
                Intrinsics.m26842a();
            }
            this.f32497b = function0.invoke();
            this.f32496a = null;
        }
        return this.f32497b;
    }

    public final String toString() {
        return (this.f32497b != UNINITIALIZED_VALUE.f25272a ? 1 : null) != null ? String.valueOf(mo5678b()) : "Lazy value not initialized yet.";
    }
}
