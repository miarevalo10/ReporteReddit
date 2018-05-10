package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: typeParameterUtils.kt */
final class CapturedTypeParameterDescriptor implements TypeParameterDescriptor {
    private final TypeParameterDescriptor f40716a;
    private final DeclarationDescriptor f40717b;
    private final int f40718c;

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.f40716a.mo7078a(declarationDescriptorVisitor, d);
    }

    public final TypeParameterDescriptor mo7709a(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        return this.f40716a.mo7709a(typeSubstitutor);
    }

    public final boolean mo7711b() {
        return true;
    }

    public final TypeConstructor mo7610c() {
        return this.f40716a.mo7610c();
    }

    public final SimpleType mo7714h() {
        return this.f40716a.mo7714h();
    }

    public final Name mo6689i() {
        return this.f40716a.mo6689i();
    }

    public final List<KotlinType> mo7715j() {
        return this.f40716a.mo7715j();
    }

    public final Variance mo7716k() {
        return this.f40716a.mo7716k();
    }

    public final boolean mo7717l() {
        return this.f40716a.mo7717l();
    }

    public final Annotations mo5718q() {
        return this.f40716a.mo5718q();
    }

    public final SourceElement mo7258r() {
        return this.f40716a.mo7258r();
    }

    public CapturedTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        Intrinsics.m26847b(typeParameterDescriptor, "originalDescriptor");
        Intrinsics.m26847b(declarationDescriptor, "declarationDescriptor");
        this.f40716a = typeParameterDescriptor;
        this.f40717b = declarationDescriptor;
        this.f40718c = i;
    }

    public final /* synthetic */ ClassifierDescriptor aI_() {
        return mo7712d();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7712d();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7709a(typeSubstitutor);
    }

    public final TypeParameterDescriptor mo7712d() {
        return this.f40716a.mo7712d();
    }

    public final DeclarationDescriptor aD_() {
        return this.f40717b;
    }

    public final int mo7713g() {
        return this.f40718c + this.f40716a.mo7713g();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f40716a.toString());
        stringBuilder.append("[inner-copy]");
        return stringBuilder.toString();
    }
}
