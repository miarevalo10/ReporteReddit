package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaDeprecatedAnnotationDescriptor$valueArguments$1 extends Lambda implements Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>> {
    final /* synthetic */ JavaDeprecatedAnnotationDescriptor f38366a;
    final /* synthetic */ LazyJavaResolverContext f38367b;

    JavaDeprecatedAnnotationDescriptor$valueArguments$1(JavaDeprecatedAnnotationDescriptor javaDeprecatedAnnotationDescriptor, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38366a = javaDeprecatedAnnotationDescriptor;
        this.f38367b = lazyJavaResolverContext;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        for (Object next : this.f38366a.m33021d()) {
            Object i = ((ValueParameterDescriptor) next).mo6689i();
            JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.f25649a;
            if (Intrinsics.m26845a(i, JavaAnnotationMapper.m27183a())) {
                break;
            }
        }
        Object next2 = null;
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) next2;
        if (valueParameterDescriptor != null) {
            Map a = MapsKt__MapsKt.m36120a(TuplesKt.m26780a(valueParameterDescriptor, new ConstantValueFactory(this.f38367b.f25703b.f25700p.mo7089b()).m27724a((Object) "Deprecated in Java")));
            if (a != null) {
                return a;
            }
        }
        return MapsKt__MapsKt.m36116a();
    }
}
