package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

/* compiled from: JvmBuiltInsSettings.kt */
public final class C3048xaea9d104 extends PackageFragmentDescriptorImpl {
    final /* synthetic */ JvmBuiltInsSettings f40806a;

    C3048xaea9d104(JvmBuiltInsSettings jvmBuiltInsSettings, ModuleDescriptor moduleDescriptor, FqName fqName) {
        this.f40806a = jvmBuiltInsSettings;
        super(moduleDescriptor, fqName);
    }

    public final /* bridge */ /* synthetic */ MemberScope aC_() {
        return Empty.f38819a;
    }
}
