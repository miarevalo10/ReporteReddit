package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    static final /* synthetic */ KProperty[] f38340c = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    final ModuleDescriptorImpl f38341a;
    final FqName f38342b;
    private final NotNullLazyValue f38343d;
    private final MemberScope f38344e;

    public final List<PackageFragmentDescriptor> mo7083f() {
        return (List) StorageKt.m27920a(this.f38343d, f38340c[0]);
    }

    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager) {
        Intrinsics.m26847b(moduleDescriptorImpl, "module");
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(storageManager, "storageManager");
        Companion companion = Annotations.f32643a;
        super(Companion.m27115a(), fqName.m27413f());
        this.f38341a = moduleDescriptorImpl;
        this.f38342b = fqName;
        this.f38343d = storageManager.mo5926a((Function0) new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.f38344e = (MemberScope) new LazyScopeAdapter(storageManager.mo5926a((Function0) new LazyPackageViewDescriptorImpl$memberScope$1(this)));
    }

    public final boolean mo7084g() {
        return DefaultImpls.m27086a(this);
    }

    public final FqName mo7080b() {
        return this.f38342b;
    }

    public final MemberScope mo7081c() {
        return this.f38344e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PackageViewDescriptor)) {
            obj = null;
        }
        PackageViewDescriptor packageViewDescriptor = (PackageViewDescriptor) obj;
        if (packageViewDescriptor == null || !Intrinsics.m26845a(this.f38342b, packageViewDescriptor.mo7080b()) || Intrinsics.m26845a(this.f38341a, packageViewDescriptor.mo7082d()) == null) {
            return false;
        }
        return true;
    }

    public final DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        return this;
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.mo5732a((PackageViewDescriptor) this, (Object) d);
    }

    public final /* synthetic */ DeclarationDescriptor aD_() {
        PackageViewDescriptor packageViewDescriptor;
        if (this.f38342b.f25856b.f25861b.isEmpty()) {
            packageViewDescriptor = null;
        } else {
            ModuleDescriptorImpl moduleDescriptorImpl = this.f38341a;
            FqName d = this.f38342b.m27411d();
            Intrinsics.m26843a((Object) d, "fqName.parent()");
            packageViewDescriptor = moduleDescriptorImpl.mo7087a(d);
        }
        return packageViewDescriptor;
    }

    public final int hashCode() {
        return (31 * this.f38341a.hashCode()) + this.f38342b.hashCode();
    }

    public final /* bridge */ /* synthetic */ ModuleDescriptor mo7082d() {
        return this.f38341a;
    }
}
