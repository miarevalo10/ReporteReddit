package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedType extends SimpleType {
    final NewCapturedTypeConstructor f39990a;
    final UnwrappedType f39991b;
    private final CaptureStatus f39992c;
    private final Annotations f39993d;
    private final boolean f39994e;

    public final boolean mo6742d() {
        return false;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        return m40525c(annotations);
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return m40526c(z);
    }

    public final /* synthetic */ SimpleType mo7296b(Annotations annotations) {
        return m40525c(annotations);
    }

    public final /* synthetic */ SimpleType mo7297b(boolean z) {
        return m40526c(z);
    }

    private /* synthetic */ NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType) {
        Companion companion = Annotations.f32643a;
        this(captureStatus, newCapturedTypeConstructor, unwrappedType, Companion.m27115a(), false);
    }

    public final Annotations mo5718q() {
        return this.f39993d;
    }

    public final boolean mo6741c() {
        return this.f39994e;
    }

    public NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations, boolean z) {
        Intrinsics.m26847b(captureStatus, "captureStatus");
        Intrinsics.m26847b(newCapturedTypeConstructor, "constructor");
        Intrinsics.m26847b(annotations, "annotations");
        this.f39992c = captureStatus;
        this.f39990a = newCapturedTypeConstructor;
        this.f39991b = unwrappedType;
        this.f39993d = annotations;
        this.f39994e = z;
    }

    public NewCapturedType(CaptureStatus captureStatus, UnwrappedType unwrappedType, TypeProjection typeProjection) {
        Intrinsics.m26847b(captureStatus, "captureStatus");
        Intrinsics.m26847b(typeProjection, "projection");
        this(captureStatus, new NewCapturedTypeConstructor(typeProjection), unwrappedType);
    }

    public final List<TypeProjection> mo6739a() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final MemberScope mo6740b() {
        Object a = ErrorUtils.m27934a("No member resolution should be done on captured type!", true);
        Intrinsics.m26843a(a, "ErrorUtils.createErrorSc…on captured type!\", true)");
        return a;
    }

    private NewCapturedType m40525c(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new NewCapturedType(this.f39992c, this.f39990a, this.f39991b, annotations, this.f39994e);
    }

    private NewCapturedType m40526c(boolean z) {
        return new NewCapturedType(this.f39992c, this.f39990a, this.f39991b, this.f39993d, z);
    }

    public final /* bridge */ /* synthetic */ TypeConstructor mo6743g() {
        return this.f39990a;
    }
}
