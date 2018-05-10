package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    private final List<ModuleDescriptorImpl> f32669a;
    private final Set<ModuleDescriptorImpl> f32670b;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set) {
        Intrinsics.m26847b(list, "allDependencies");
        Intrinsics.m26847b(set, "modulesWhoseInternalsAreVisible");
        this.f32669a = list;
        this.f32670b = set;
    }

    public final List<ModuleDescriptorImpl> mo5758a() {
        return this.f32669a;
    }

    public final Set<ModuleDescriptorImpl> mo5759b() {
        return this.f32670b;
    }
}
