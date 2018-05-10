package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    protected final Visibility f40760a;
    private List<? extends TypeParameterDescriptor> f40761b;
    private final AbstractTypeAliasDescriptor$typeConstructor$1 f40762c = new AbstractTypeAliasDescriptor$typeConstructor$1(this);

    public abstract List<TypeParameterDescriptor> mo7811k();

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public final boolean mo7745p() {
        return false;
    }

    public final /* synthetic */ ClassifierDescriptor aI_() {
        return m42585m();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return m42585m();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return m42585m();
    }

    public AbstractTypeAliasDescriptor(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement, Visibility visibility) {
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(sourceElement, "sourceElement");
        Intrinsics.m26847b(visibility, "visibilityImpl");
        super(declarationDescriptor, annotations, name, sourceElement);
        this.f40760a = visibility;
    }

    public final void m42587a(List<? extends TypeParameterDescriptor> list) {
        Intrinsics.m26847b(list, "declaredTypeParameters");
        this.f40761b = list;
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.mo5737a((TypeAliasDescriptor) this, (Object) d);
    }

    public boolean mo7742l() {
        return TypeUtils.m28011a((KotlinType) mo7809b(), (Function1) new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        List<TypeParameterDescriptor> list = this.f40761b;
        if (list == null) {
            Intrinsics.m26844a("declaredTypeParametersImpl");
        }
        return list;
    }

    public final Modality aG_() {
        return Modality.f25488a;
    }

    public final Visibility mo7257j() {
        return this.f40760a;
    }

    public final TypeConstructor mo7610c() {
        return this.f40762c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("typealias ");
        stringBuilder.append(mo6689i().m27429a());
        return stringBuilder.toString();
    }

    private TypeAliasDescriptor m42585m() {
        DeclarationDescriptorWithSource aO_ = super.aO_();
        if (aO_ != null) {
            return (TypeAliasDescriptor) aO_;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
}
