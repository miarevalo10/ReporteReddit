package kotlin.coroutines.experimental.jvm.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H$J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00058\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/experimental/jvm/internal/CoroutineImpl;", "Lkotlin/jvm/internal/Lambda;", "Lkotlin/coroutines/experimental/Continuation;", "", "arity", "", "completion", "(ILkotlin/coroutines/experimental/Continuation;)V", "_context", "Lkotlin/coroutines/experimental/CoroutineContext;", "_facade", "context", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "facade", "getFacade", "()Lkotlin/coroutines/experimental/Continuation;", "label", "create", "", "value", "doResume", "data", "exception", "", "resume", "resumeWithException", "kotlin-stdlib"}, k = 1, mv = {1, 1, 9})
/* compiled from: CoroutineImpl.kt */
public abstract class CoroutineImpl extends Lambda implements Continuation<Object> {
    private final CoroutineContext f38202a;
    private Continuation<Object> f38203b;
    protected int f38204l;
    protected Continuation<Object> f38205m;

    public abstract Object mo7253a(Throwable th);

    public CoroutineImpl(Continuation<Object> continuation) {
        super(2);
        this.f38205m = continuation;
        this.f38204l = this.f38205m != null ? null : -1;
        continuation = this.f38205m;
        this.f38202a = continuation != null ? continuation.mo5682a() : null;
    }

    public final CoroutineContext mo5682a() {
        CoroutineContext coroutineContext = this.f38202a;
        if (coroutineContext == null) {
            Intrinsics.m26842a();
        }
        return coroutineContext;
    }

    public final Continuation<Object> m38209b() {
        if (this.f38203b == null) {
            CoroutineContext coroutineContext = this.f38202a;
            if (coroutineContext == null) {
                Intrinsics.m26842a();
            }
            this.f38203b = CoroutineIntrinsics.m26817a(coroutineContext, this);
        }
        Continuation<Object> continuation = this.f38203b;
        if (continuation == null) {
            Intrinsics.m26842a();
        }
        return continuation;
    }

    public final void mo5683a(Object obj) {
        obj = this.f38205m;
        if (obj == null) {
            Intrinsics.m26842a();
        }
        try {
            Object a = mo7253a(null);
            if (a != IntrinsicsKt.m26814a()) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                obj.mo5683a(a);
            }
        } catch (Throwable th) {
            obj.mo5684b(th);
        }
    }

    public final void mo5684b(Throwable th) {
        Intrinsics.m26847b(th, "exception");
        Continuation continuation = this.f38205m;
        if (continuation == null) {
            Intrinsics.m26842a();
        }
        try {
            th = mo7253a(th);
            if (th != IntrinsicsKt.m26814a()) {
                if (continuation == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation.mo5683a(th);
            }
        } catch (Throwable th2) {
            continuation.mo5684b(th2);
        }
    }

    public Continuation<Unit> mo7254a(Object obj, Continuation<?> continuation) {
        Intrinsics.m26847b(continuation, "completion");
        throw ((Throwable) new IllegalStateException("create(Any?;Continuation) has not been overridden"));
    }
}
