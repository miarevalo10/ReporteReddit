package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedType extends SimpleType implements SubtypingRepresentatives {
    public final TypeProjection f39733a;
    public final CapturedTypeConstructor f39734b;
    private final boolean f39735c;
    private final Annotations f39736d;

    public final boolean mo6742d() {
        return false;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        return m39934c(annotations);
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return m39935c(z);
    }

    public final /* synthetic */ SimpleType mo7296b(Annotations annotations) {
        return m39934c(annotations);
    }

    public final /* synthetic */ SimpleType mo7297b(boolean z) {
        return m39935c(z);
    }

    public /* synthetic */ CapturedType(TypeProjection typeProjection) {
        CapturedTypeConstructor capturedTypeConstructor = new CapturedTypeConstructor(typeProjection);
        Companion companion = Annotations.f32643a;
        this(typeProjection, capturedTypeConstructor, false, Companion.m27115a());
    }

    public final boolean mo6741c() {
        return this.f39735c;
    }

    public final Annotations mo5718q() {
        return this.f39736d;
    }

    private CapturedType(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations) {
        Intrinsics.m26847b(typeProjection, "typeProjection");
        Intrinsics.m26847b(capturedTypeConstructor, "constructor");
        Intrinsics.m26847b(annotations, "annotations");
        this.f39733a = typeProjection;
        this.f39734b = capturedTypeConstructor;
        this.f39735c = z;
        this.f39736d = annotations;
    }

    public final List<TypeProjection> mo6739a() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final MemberScope mo6740b() {
        Object a = ErrorUtils.m27934a("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics.m26843a(a, "ErrorUtils.createErrorSc…system resolution\", true)");
        return a;
    }

    public final KotlinType mo7115e() {
        Variance variance = Variance.f26339c;
        Object n = TypeUtilsKt.m28060a((KotlinType) this).m27016n();
        Intrinsics.m26843a(n, "builtIns.nullableAnyType");
        Object a = m39933a(variance, (KotlinType) n);
        Intrinsics.m26843a(a, "representative(OUT_VARIA…builtIns.nullableAnyType)");
        return a;
    }

    public final KotlinType mo7116f() {
        Variance variance = Variance.f26338b;
        Object l = TypeUtilsKt.m28060a((KotlinType) this).m27014l();
        Intrinsics.m26843a(l, "builtIns.nothingType");
        Object a = m39933a(variance, (KotlinType) l);
        Intrinsics.m26843a(a, "representative(IN_VARIANCE, builtIns.nothingType)");
        return a;
    }

    private final KotlinType m39933a(Variance variance, KotlinType kotlinType) {
        return Intrinsics.m26845a(this.f39733a.mo6735b(), (Object) variance) != null ? this.f39733a.mo6736c() : kotlinType;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("Captured(");
        stringBuilder2.append(this.f39733a);
        stringBuilder2.append(")");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(this.f39735c ? Operation.EMPTY_PARAM : "");
        return stringBuilder.toString();
    }

    private CapturedType m39934c(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new CapturedType(this.f39733a, this.f39734b, this.f39735c, annotations);
    }

    public final boolean mo7114a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        return this.f39734b == kotlinType.mo6743g() ? true : null;
    }

    private CapturedType m39935c(boolean z) {
        return z == this.f39735c ? this : new CapturedType(this.f39733a, this.f39734b, z, this.f39736d);
    }

    public final /* bridge */ /* synthetic */ TypeConstructor mo6743g() {
        return this.f39734b;
    }
}
