package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$allValueArguments$1 extends Lambda implements Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>> {
    final /* synthetic */ LazyJavaAnnotationDescriptor f38377a;

    LazyJavaAnnotationDescriptor$allValueArguments$1(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        this.f38377a = lazyJavaAnnotationDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return LazyJavaAnnotationDescriptor.m33056c(this.f38377a);
    }
}
