package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaTargetAnnotationDescriptor$valueArguments$1 extends Lambda implements Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>> {
    final /* synthetic */ JavaTargetAnnotationDescriptor f38370a;
    final /* synthetic */ LazyJavaResolverContext f38371b;

    JavaTargetAnnotationDescriptor$valueArguments$1(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38370a = javaTargetAnnotationDescriptor;
        this.f38371b = lazyJavaResolverContext;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object a;
        JavaAnnotationArgument javaAnnotationArgument = this.f38370a.f32698a;
        JavaAnnotationTargetMapper javaAnnotationTargetMapper;
        if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            javaAnnotationTargetMapper = JavaAnnotationTargetMapper.f25659a;
            a = JavaAnnotationTargetMapper.m27185a(((JavaArrayAnnotationArgument) this.f38370a.f32698a).mo6705b(), this.f38371b.f25703b.f25700p.mo7089b());
        } else if (!(javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument)) {
            return MapsKt__MapsKt.m36116a();
        } else {
            javaAnnotationTargetMapper = JavaAnnotationTargetMapper.f25659a;
            a = JavaAnnotationTargetMapper.m27185a(CollectionsKt__CollectionsKt.m26791a((Object) this.f38370a.f32698a), this.f38371b.f25703b.f25700p.mo7089b());
        }
        return MapsKt__MapsKt.m36120a(TuplesKt.m26780a(CollectionsKt___CollectionsKt.m41441h(this.f38370a.m33021d()), a));
    }
}
