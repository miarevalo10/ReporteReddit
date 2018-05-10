package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyJavaClassDescriptor.kt */
final class LazyJavaClassDescriptor$typeConstructor$1 extends Lambda implements Function0<LazyJavaClassTypeConstructor> {
    final /* synthetic */ LazyJavaClassDescriptor f38388a;

    LazyJavaClassDescriptor$typeConstructor$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        this.f38388a = lazyJavaClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new LazyJavaClassTypeConstructor(this.f38388a);
    }
}
