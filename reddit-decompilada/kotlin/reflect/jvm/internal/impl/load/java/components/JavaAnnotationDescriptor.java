package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: JavaAnnotationMapper.kt */
public class JavaAnnotationDescriptor implements AnnotationDescriptor {
    final JavaAnnotationArgument f32698a;
    private final SourceElement f32699b;
    private final ClassDescriptor f32700c;

    public JavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(classDescriptor, "kotlinAnnotationClassDescriptor");
        this.f32700c = classDescriptor;
        this.f32699b = javaAnnotation != null ? lazyJavaResolverContext.f25703b.f25695k.mo5773a(javaAnnotation) : SourceElement.f25498a;
        this.f32698a = javaAnnotation != null ? (JavaAnnotationArgument) CollectionsKt___CollectionsKt.m41433e((Iterable) javaAnnotation.mo6701a()) : null;
    }

    public final SourceElement mo5721c() {
        return this.f32699b;
    }

    protected final List<ValueParameterDescriptor> m33021d() {
        Object k = ((ClassConstructorDescriptor) CollectionsKt___CollectionsKt.m41440h((Iterable) this.f32700c.mo7770f())).mo7757k();
        Intrinsics.m26843a(k, "kotlinAnnotationClassDes….single().valueParameters");
        return k;
    }

    public Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        return MapsKt__MapsKt.m36116a();
    }

    public final /* synthetic */ KotlinType mo5719a() {
        return this.f32700c.mo7714h();
    }
}
