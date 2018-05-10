package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$fqName$1 extends Lambda implements Function0<FqName> {
    final /* synthetic */ LazyJavaAnnotationDescriptor f38380a;

    LazyJavaAnnotationDescriptor$fqName$1(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        this.f38380a = lazyJavaAnnotationDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ClassId b = this.f38380a.f32720a.mo6702b();
        return b != null ? b.m27403f() : null;
    }
}
