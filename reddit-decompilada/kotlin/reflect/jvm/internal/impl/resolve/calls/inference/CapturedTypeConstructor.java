package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructor implements TypeConstructor {
    public NewCapturedTypeConstructor f32934a;
    public final TypeProjection f32935b;

    public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
        return null;
    }

    public final boolean mo5725d() {
        return true;
    }

    public CapturedTypeConstructor(TypeProjection typeProjection) {
        Intrinsics.m26847b(typeProjection, "typeProjection");
        this.f32935b = typeProjection;
        typeProjection = Intrinsics.m26845a(this.f32935b.mo6735b(), Variance.f26337a) ^ 1;
        if (_Assertions.f25274a && typeProjection == null) {
            typeProjection = new StringBuilder("Only nontrivial projections can be captured, not: ");
            typeProjection.append(this.f32935b);
            throw new AssertionError(typeProjection.toString());
        }
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Collection<KotlinType> aL_() {
        Object c;
        if (Intrinsics.m26845a(this.f32935b.mo6735b(), Variance.f26339c)) {
            c = this.f32935b.mo6736c();
            Intrinsics.m26843a(c, "typeProjection.type");
        } else {
            c = mo5726e().m27016n();
            Intrinsics.m26843a(c, "builtIns.nullableAnyType");
            c = (KotlinType) c;
        }
        return CollectionsKt__CollectionsKt.m26791a(c);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CapturedTypeConstructor(");
        stringBuilder.append(this.f32935b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final KotlinBuiltIns mo5726e() {
        Object e = this.f32935b.mo6736c().mo6743g().mo5726e();
        Intrinsics.m26843a(e, "typeProjection.type.constructor.builtIns");
        return e;
    }
}
