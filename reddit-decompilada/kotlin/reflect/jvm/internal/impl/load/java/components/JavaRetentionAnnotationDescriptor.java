package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaRetentionAnnotationDescriptor extends JavaAnnotationDescriptor {
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> f36085b;

    public final Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        return (Map) this.f36085b.invoke();
    }

    public JavaRetentionAnnotationDescriptor(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(javaAnnotation, "annotation");
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Object a = lazyJavaResolverContext.f25703b.f25700p.mo7089b().m26999a(KotlinBuiltIns.f25420j.f25359F.m27412e());
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getRetentionAnnotation"}));
        }
        Intrinsics.m26843a(a, "c.module.builtIns.retentionAnnotation");
        super(lazyJavaResolverContext, javaAnnotation, a);
        this.f36085b = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new JavaRetentionAnnotationDescriptor$valueArguments$1(this, lazyJavaResolverContext));
    }
}
