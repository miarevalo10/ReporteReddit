package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;

/* compiled from: LazyJavaClassDescriptor.kt */
final class C2938xbaf55d8a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassTypeConstructor f38383a;

    C2938xbaf55d8a(LazyJavaClassTypeConstructor lazyJavaClassTypeConstructor) {
        this.f38383a = lazyJavaClassTypeConstructor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return TypeParameterUtilsKt.m27089a((ClassifierDescriptorWithTypeParameters) this.f38383a.f38384a);
    }
}
