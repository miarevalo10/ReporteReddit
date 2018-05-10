package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolverKt$getErasedUpperBound$1 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ TypeParameterDescriptor f38446a;

    JavaTypeResolverKt$getErasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor) {
        this.f38446a = typeParameterDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        StringBuilder stringBuilder = new StringBuilder("Can't compute erased upper bound of type parameter `");
        stringBuilder.append(this.f38446a);
        stringBuilder.append("`");
        Object c = ErrorUtils.m27943c(stringBuilder.toString());
        Intrinsics.m26843a(c, "ErrorUtils.createErrorTy… type parameter `$this`\")");
        return c;
    }
}
