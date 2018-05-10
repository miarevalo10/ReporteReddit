package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$hasDefaultValue$2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
    public static final DescriptorUtilsKt$hasDefaultValue$2 f38810a = new DescriptorUtilsKt$hasDefaultValue$2();

    DescriptorUtilsKt$hasDefaultValue$2() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ValueParameterDescriptor.class);
    }

    public final String mo5687b() {
        return "declaresDefaultValue";
    }

    public final String mo6932c() {
        return "declaresDefaultValue()Z";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
        Intrinsics.m26847b(valueParameterDescriptor, "p1");
        return Boolean.valueOf(valueParameterDescriptor.mo7802h());
    }
}
