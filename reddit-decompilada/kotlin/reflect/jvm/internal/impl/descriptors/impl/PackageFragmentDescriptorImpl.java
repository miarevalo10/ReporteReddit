package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: PackageFragmentDescriptorImpl.kt */
public abstract class PackageFragmentDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PackageFragmentDescriptor {
    public final FqName f40724d;

    public PackageFragmentDescriptorImpl(ModuleDescriptor moduleDescriptor, FqName fqName) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        Intrinsics.m26847b(fqName, "fqName");
        DeclarationDescriptor declarationDescriptor = moduleDescriptor;
        Companion companion = Annotations.f32643a;
        super(declarationDescriptor, Companion.m27115a(), fqName.m27413f(), SourceElement.f25498a);
        this.f40724d = fqName;
    }

    public final /* synthetic */ DeclarationDescriptor aD_() {
        return mo7721c();
    }

    public final FqName mo7722d() {
        return this.f40724d;
    }

    public final DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        return this;
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.mo5731a((PackageFragmentDescriptor) this, (Object) d);
    }

    public final ModuleDescriptor mo7721c() {
        DeclarationDescriptor aD_ = super.aD_();
        if (aD_ != null) {
            return (ModuleDescriptor) aD_;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    public SourceElement mo7258r() {
        Object obj = SourceElement.f25498a;
        Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
        return obj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("package ");
        stringBuilder.append(this.f40724d);
        return stringBuilder.toString();
    }
}
