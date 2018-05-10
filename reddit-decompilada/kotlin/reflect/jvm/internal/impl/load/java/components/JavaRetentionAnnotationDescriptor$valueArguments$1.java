package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaRetentionAnnotationDescriptor$valueArguments$1 extends Lambda implements Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>> {
    final /* synthetic */ JavaRetentionAnnotationDescriptor f38368a;
    final /* synthetic */ LazyJavaResolverContext f38369b;

    JavaRetentionAnnotationDescriptor$valueArguments$1(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38368a = javaRetentionAnnotationDescriptor;
        this.f38369b = lazyJavaResolverContext;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        if (!(this.f38368a.f32698a instanceof JavaEnumValueAnnotationArgument)) {
            return MapsKt__MapsKt.m36116a();
        }
        JavaAnnotationTargetMapper javaAnnotationTargetMapper = JavaAnnotationTargetMapper.f25659a;
        return MapsKt__MapsKt.m36120a(TuplesKt.m26780a(CollectionsKt___CollectionsKt.m41441h(this.f38368a.m33021d()), JavaAnnotationTargetMapper.m27186a(this.f38368a.f32698a, this.f38369b.f25703b.f25700p.mo7089b())));
    }
}
