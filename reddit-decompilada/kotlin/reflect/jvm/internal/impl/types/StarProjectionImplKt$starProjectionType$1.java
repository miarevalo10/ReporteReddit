package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt$starProjectionType$1 extends TypeConstructorSubstitution {
    final /* synthetic */ List f36173a;

    StarProjectionImplKt$starProjectionType$1(List list) {
        this.f36173a = list;
    }

    public final TypeProjection mo6737a(TypeConstructor typeConstructor) {
        Intrinsics.m26847b(typeConstructor, "key");
        if (!this.f36173a.contains(typeConstructor)) {
            return null;
        }
        typeConstructor = typeConstructor.mo5724c();
        if (typeConstructor != null) {
            return TypeUtils.m28009a((TypeParameterDescriptor) typeConstructor);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
    }
}
