package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.MultiTargetPlatform.Common;
import kotlin.reflect.jvm.internal.impl.resolve.MultiTargetPlatformKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    static final /* synthetic */ KProperty[] f38347a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModuleDescriptorImpl.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    private final Map<Capability<? extends Object>, Object> f38348b;
    private ModuleDependencies f38349c;
    private PackageFragmentProvider f38350d;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> f38351e;
    private final Set<ModuleDescriptor> f38352f;
    private final Lazy f38353g;
    private final StorageManager f38354h;
    private final KotlinBuiltIns f38355i;
    private final SourceKind f38356j;

    public ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns) {
        this(name, storageManager, kotlinBuiltIns, null, null, 48);
    }

    public final DeclarationDescriptor aD_() {
        return null;
    }

    private ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, SourceKind sourceKind, Map<Capability<?>, ? extends Object> map) {
        Intrinsics.m26847b(name, "moduleName");
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        Intrinsics.m26847b(sourceKind, "sourceKind");
        Intrinsics.m26847b(map, "capabilities");
        Companion companion = Annotations.f32643a;
        super(Companion.m27115a(), name);
        this.f38354h = storageManager;
        this.f38355i = kotlinBuiltIns;
        this.f38356j = sourceKind;
        if (name.f25866a == null) {
            kotlinBuiltIns = new StringBuilder("Module name must be special: ");
            kotlinBuiltIns.append(name);
            throw ((Throwable) new IllegalArgumentException(kotlinBuiltIns.toString()));
        }
        this.f38348b = MapsKt__MapsKt.m36119a((Map) map, (Map) MapsKt__MapsKt.m36116a());
        this.f38351e = this.f38354h.mo5925a((Function1) new ModuleDescriptorImpl$packages$1(this));
        this.f38352f = (Set) new LinkedHashSet();
        this.f38353g = LazyKt.m26777a((Function0) new C2932x39a25915(this));
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
        return DefaultImpls.m27080a(this, declarationDescriptorVisitor, d);
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        return DefaultImpls.m27081a(this, typeSubstitutor);
    }

    public final KotlinBuiltIns mo7089b() {
        return this.f38355i;
    }

    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, SourceKind sourceKind, Map map, int i) {
        if ((i & 16) != 0) {
            sourceKind = SourceKind.f25500a;
        }
        SourceKind sourceKind2 = sourceKind;
        if ((i & 32) != null) {
            map = MapsKt__MapsKt.m36116a();
        }
        this(name, storageManager, kotlinBuiltIns, sourceKind2, map);
    }

    public final SourceKind mo7090c() {
        return this.f38356j;
    }

    private List<ModuleDescriptor> m38331f() {
        ModuleDependencies moduleDependencies = this.f38349c;
        if (moduleDependencies == null) {
            StringBuilder stringBuilder = new StringBuilder("Dependencies of module ");
            stringBuilder.append(m38333h());
            stringBuilder.append(" were not set");
            throw new AssertionError(stringBuilder.toString());
        }
        Collection arrayList = new ArrayList();
        for (Object next : moduleDependencies.mo5758a()) {
            if ((Intrinsics.m26845a((ModuleDescriptorImpl) next, (Object) this) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final PackageViewDescriptor mo7087a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return (PackageViewDescriptor) this.f38351e.mo6492a(fqName);
    }

    public final Collection<FqName> mo7086a(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(function1, "nameFilter");
        return m38344d().mo5711a(fqName, function1);
    }

    private final boolean m38332g() {
        return this.f38350d != null;
    }

    public final void m38339a(ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.m26847b(moduleDescriptorImplArr, "descriptors");
        moduleDescriptorImplArr = ArraysKt___ArraysKt.m36109i((Object[]) moduleDescriptorImplArr);
        Intrinsics.m26847b(moduleDescriptorImplArr, "descriptors");
        ModuleDependencies moduleDependenciesImpl = new ModuleDependenciesImpl(moduleDescriptorImplArr, SetsKt__SetsKt.m26799a());
        Intrinsics.m26847b(moduleDependenciesImpl, "dependencies");
        moduleDescriptorImplArr = this.f38349c == null ? 1 : null;
        if (_Assertions.f25274a && moduleDescriptorImplArr == null) {
            moduleDescriptorImplArr = new StringBuilder("Dependencies of ");
            moduleDescriptorImplArr.append(m38333h());
            moduleDescriptorImplArr.append(" were already set");
            throw new AssertionError(moduleDescriptorImplArr.toString());
        }
        this.f38349c = moduleDependenciesImpl;
        if (Intrinsics.m26845a(MultiTargetPlatformKt.m27671a(this), Common.f32931c) == null) {
            for (ModuleDescriptor moduleDescriptor : m38331f()) {
                ModuleDescriptor moduleDescriptor2;
                if ((Intrinsics.m26845a(MultiTargetPlatformKt.m27671a(moduleDescriptor2), Common.f32931c) ^ 1) == 0 && (Intrinsics.m26845a(moduleDescriptor2.mo7090c(), this.f38356j) ^ 1) == 0) {
                    if (!(moduleDescriptor2 instanceof ModuleDescriptorImpl)) {
                        moduleDescriptor2 = null;
                    }
                    ModuleDescriptorImpl moduleDescriptorImpl = (ModuleDescriptorImpl) moduleDescriptor2;
                    if (moduleDescriptorImpl != null) {
                        Set set = moduleDescriptorImpl.f38352f;
                        if (set != null) {
                            set.add(this);
                        }
                    }
                }
            }
        }
    }

    public final boolean mo7088a(ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(moduleDescriptor, "targetModule");
        if (!Intrinsics.m26845a((Object) this, (Object) moduleDescriptor)) {
            ModuleDependencies moduleDependencies = this.f38349c;
            if (moduleDependencies == null) {
                Intrinsics.m26842a();
            }
            if (CollectionsKt___CollectionsKt.m41420a((Iterable) moduleDependencies.mo5759b(), (Object) moduleDescriptor) == null) {
                return null;
            }
        }
        return true;
    }

    private final String m38333h() {
        Object name = mo6689i().toString();
        Intrinsics.m26843a(name, "name.toString()");
        return name;
    }

    public final void m38338a(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.m26847b(packageFragmentProvider, "providerForModuleContent");
        int g = m38332g() ^ 1;
        if (_Assertions.f25274a && g == 0) {
            packageFragmentProvider = new StringBuilder("Attempt to initialize module ");
            packageFragmentProvider.append(m38333h());
            packageFragmentProvider.append(" twice");
            throw new AssertionError(packageFragmentProvider.toString());
        }
        this.f38350d = packageFragmentProvider;
    }

    public final <T> T mo7085a(Capability<T> capability) {
        Intrinsics.m26847b(capability, "capability");
        capability = this.f38348b.get(capability);
        if (!(capability instanceof Object)) {
            capability = null;
        }
        return capability;
    }

    public final PackageFragmentProvider m38344d() {
        return (CompositePackageFragmentProvider) this.f38353g.mo5678b();
    }
}
