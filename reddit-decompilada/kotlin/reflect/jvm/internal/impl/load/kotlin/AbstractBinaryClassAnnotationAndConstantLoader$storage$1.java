package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1 extends Lambda implements Function1<KotlinJvmBinaryClass, Storage<? extends A, ? extends C>> {
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader f38765a;

    AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader) {
        this.f38765a = abstractBinaryClassAnnotationAndConstantLoader;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        KotlinJvmBinaryClass kotlinJvmBinaryClass = (KotlinJvmBinaryClass) obj;
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        return AbstractBinaryClassAnnotationAndConstantLoader.m33137a(this.f38765a, kotlinJvmBinaryClass);
    }
}
