package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
public final class PossiblyInnerType {
    public final ClassifierDescriptorWithTypeParameters f25495a;
    public final List<TypeProjection> f25496b;
    public final PossiblyInnerType f25497c;

    public PossiblyInnerType(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, List<? extends TypeProjection> list, PossiblyInnerType possiblyInnerType) {
        Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics.m26847b(list, "arguments");
        this.f25495a = classifierDescriptorWithTypeParameters;
        this.f25496b = list;
        this.f25497c = possiblyInnerType;
    }
}
