package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaDeprecatedAnnotationDescriptor extends JavaAnnotationDescriptor {
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> f36084b;

    public final Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        return (Map) this.f36084b.invoke();
    }

    public JavaDeprecatedAnnotationDescriptor(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Object j = lazyJavaResolverContext.f25703b.f25700p.mo7089b().m27012j();
        Intrinsics.m26843a(j, "c.module.builtIns.deprecatedAnnotation");
        super(lazyJavaResolverContext, javaAnnotation, j);
        this.f36084b = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new JavaDeprecatedAnnotationDescriptor$valueArguments$1(this, lazyJavaResolverContext));
    }
}
