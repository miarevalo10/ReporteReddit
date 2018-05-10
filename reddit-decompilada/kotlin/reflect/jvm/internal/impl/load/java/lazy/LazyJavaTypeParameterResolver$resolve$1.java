package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: resolvers.kt */
final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {
    final /* synthetic */ LazyJavaTypeParameterResolver f38374a;

    LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        this.f38374a = lazyJavaTypeParameterResolver;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        JavaTypeParameter javaTypeParameter = (JavaTypeParameter) obj;
        Intrinsics.m26847b(javaTypeParameter, "typeParameter");
        Integer num = (Integer) this.f38374a.f32707a.get(javaTypeParameter);
        if (num == null) {
            return null;
        }
        return new LazyJavaTypeParameterDescriptor(ContextKt.m27200a(this.f38374a.f32709c, (TypeParameterResolver) this.f38374a), javaTypeParameter, this.f38374a.f32711e + num.intValue(), this.f38374a.f32710d);
    }
}
