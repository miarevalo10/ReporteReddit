package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragment.kt */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final NotNullLazyValue<MemberScope> f40807a = this.f40809c.mo5926a((Function0) new DeserializedPackageFragment$memberScope$1(this));
    public DeserializationComponents f40808b;
    private final StorageManager f40809c;

    public abstract ClassDataFinder mo7792a();

    public abstract MemberScope mo7793b();

    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(moduleDescriptor, "module");
        super(moduleDescriptor, fqName);
        this.f40809c = storageManager;
    }

    public final MemberScope aC_() {
        return (MemberScope) this.f40807a.invoke();
    }
}
