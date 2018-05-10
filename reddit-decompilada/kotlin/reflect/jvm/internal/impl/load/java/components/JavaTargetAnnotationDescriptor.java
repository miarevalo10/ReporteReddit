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
public final class JavaTargetAnnotationDescriptor extends JavaAnnotationDescriptor {
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> f36086b;

    public final Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        return (Map) this.f36086b.invoke();
    }

    public JavaTargetAnnotationDescriptor(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(javaAnnotation, "annotation");
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Object k = lazyJavaResolverContext.f25703b.f25700p.mo7089b().m27013k();
        Intrinsics.m26843a(k, "c.module.builtIns.targetAnnotation");
        super(lazyJavaResolverContext, javaAnnotation, k);
        this.f36086b = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new JavaTargetAnnotationDescriptor$valueArguments$1(this, lazyJavaResolverContext));
    }
}
