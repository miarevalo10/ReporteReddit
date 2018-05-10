package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: VarianceChecker.kt */
public interface TypeHolderArgument<D extends TypeHolder<? extends D>> {
    TypeProjection mo5842a();

    TypeParameterDescriptor mo5843b();

    D mo5844c();
}
