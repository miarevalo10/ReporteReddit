package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: SpecialTypes.kt */
public final class AbbreviatedType extends DelegatingSimpleType {
    public final SimpleType f40539a;
    public final SimpleType f40540b;

    public final boolean mo6742d() {
        return false;
    }

    public AbbreviatedType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "delegate");
        Intrinsics.m26847b(simpleType2, "abbreviation");
        this.f40539a = simpleType;
        this.f40540b = simpleType2;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        return m41925c(annotations);
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return m41926c(z);
    }

    public final /* synthetic */ SimpleType mo7296b(Annotations annotations) {
        return m41925c(annotations);
    }

    public final /* synthetic */ SimpleType mo7297b(boolean z) {
        return m41926c(z);
    }

    protected final SimpleType mo7611e() {
        return this.f40539a;
    }

    private AbbreviatedType m41925c(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new AbbreviatedType(this.f40539a.mo7296b(annotations), this.f40540b);
    }

    private AbbreviatedType m41926c(boolean z) {
        return new AbbreviatedType(this.f40539a.mo7297b(z), this.f40540b.mo7297b(z));
    }
}
