package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$3 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$3 f38956a = new OperatorChecks$checks$3();

    OperatorChecks$checks$3() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) obj;
        Intrinsics.m26847b(functionDescriptor, "$receiver");
        ReceiverParameterDescriptor e = functionDescriptor.mo7756e();
        if (e == null) {
            e = functionDescriptor.mo7755d();
        }
        OperatorChecks operatorChecks = OperatorChecks.f33093a;
        Object obj2 = null;
        if (e != null) {
            KotlinType aN_ = functionDescriptor.aN_();
            if (aN_ != null) {
                KotlinType x = e.mo7777x();
                Intrinsics.m26843a((Object) x, "receiver.type");
                obj = TypeUtilsKt.m28064a(aN_, x);
            } else {
                obj = null;
            }
            if (obj != null) {
                obj2 = 1;
            }
        }
        return obj2 == null ? "receiver must be a supertype of the return type" : null;
    }
}
