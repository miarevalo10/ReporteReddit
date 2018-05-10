package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$1 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$1 f38953a = new OperatorChecks$checks$1();

    OperatorChecks$checks$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) obj;
        Intrinsics.m26847b(functionDescriptor, "$receiver");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41439g((List) functionDescriptor.mo7757k());
        Object obj2 = null;
        if (valueParameterDescriptor != null) {
            valueParameterDescriptor = valueParameterDescriptor;
            if (!DescriptorUtilsKt.m27740a(valueParameterDescriptor) && valueParameterDescriptor.mo7803n() == null) {
                obj2 = 1;
            }
        }
        obj = OperatorChecks.f33093a;
        return obj2 == null ? "last parameter should not have a default value or be a vararg" : null;
    }
}
