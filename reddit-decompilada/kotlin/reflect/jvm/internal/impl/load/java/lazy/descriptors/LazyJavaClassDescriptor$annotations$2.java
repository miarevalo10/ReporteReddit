package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;

/* compiled from: LazyJavaClassDescriptor.kt */
final class LazyJavaClassDescriptor$annotations$2 extends Lambda implements Function0<Annotations> {
    final /* synthetic */ LazyJavaClassDescriptor f38386a;

    LazyJavaClassDescriptor$annotations$2(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        this.f38386a = lazyJavaClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return LazyJavaAnnotationsKt.m27201a(this.f38386a.f40956a, this.f38386a.f40959f);
    }
}
