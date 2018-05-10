package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$computeArguments$$inlined$map$lambda$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ JavaTypeAttributes f38438a;
    final /* synthetic */ TypeConstructor f38439b;

    JavaTypeResolver$computeArguments$$inlined$map$lambda$1(JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        this.f38438a = javaTypeAttributes;
        this.f38439b = typeConstructor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ClassifierDescriptor c = this.f38439b.mo5724c();
        if (c == null) {
            Intrinsics.m26842a();
        }
        return TypeUtilsKt.m28069f(c.mo7714h());
    }
}
