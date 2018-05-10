package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$returnType_$1 extends Lambda implements Function0<KTypeImpl> {
    final /* synthetic */ KCallableImpl f38223a;

    KCallableImpl$returnType_$1(KCallableImpl kCallableImpl) {
        this.f38223a = kCallableImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object aN_ = this.f38223a.mo6676a().aN_();
        if (aN_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(aN_, "descriptor.returnType!!");
        return new KTypeImpl(aN_, new Function0<Type>() {
            public final /* synthetic */ Object invoke() {
                return this.f38223a.mo6677c().f25324b;
            }
        });
    }
}
