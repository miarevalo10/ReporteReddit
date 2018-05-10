package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e¸\u0006\u0000"}, d2 = {"kotlin/coroutines/experimental/intrinsics/IntrinsicsKt$buildContinuationByInvokeCall$continuation$1", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlin/coroutines/experimental/Continuation;Lkotlin/jvm/functions/Function0;)V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: Intrinsics.kt */
public final class C2553xe6b592e8 implements Continuation<Unit> {
    final /* synthetic */ Continuation f32524a;
    final /* synthetic */ Function2 f32525b;
    final /* synthetic */ Object f32526c;
    final /* synthetic */ Continuation f32527d;

    public C2553xe6b592e8(Continuation continuation, Function2 function2, Object obj, Continuation continuation2) {
        this.f32524a = continuation;
        this.f32525b = function2;
        this.f32526c = obj;
        this.f32527d = continuation2;
    }

    public final /* synthetic */ void mo5683a(Object obj) {
        Intrinsics.m26847b((Unit) obj, "value");
        obj = this.f32524a;
        try {
            Object obj2 = this.f32525b;
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
            }
            obj2 = ((Function2) TypeIntrinsics.m26870a(obj2, 2)).mo6497a(this.f32526c, this.f32527d);
            if (obj2 != IntrinsicsKt.m26814a()) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                obj.mo5683a(obj2);
            }
        } catch (Throwable th) {
            obj.mo5684b(th);
        }
    }

    public final CoroutineContext mo5682a() {
        return this.f32524a.mo5682a();
    }

    public final void mo5684b(Throwable th) {
        Intrinsics.m26847b(th, "exception");
        this.f32524a.mo5684b(th);
    }
}
