package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ModuleDescriptor.kt */
public interface ModuleDescriptor extends DeclarationDescriptor {

    /* compiled from: ModuleDescriptor.kt */
    public static final class Capability<T> {
        private final String f25494a;

        public Capability(String str) {
            Intrinsics.m26847b(str, "name");
            this.f25494a = str;
        }

        public final String toString() {
            return this.f25494a;
        }
    }

    /* compiled from: ModuleDescriptor.kt */
    public static final class DefaultImpls {
        public static ModuleDescriptor m27081a(ModuleDescriptor moduleDescriptor, TypeSubstitutor typeSubstitutor) {
            Intrinsics.m26847b(typeSubstitutor, "substitutor");
            return moduleDescriptor;
        }

        public static <R, D> R m27080a(ModuleDescriptor moduleDescriptor, DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            Intrinsics.m26847b(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.mo5730a(moduleDescriptor, (Object) d);
        }
    }

    <T> T mo7085a(Capability<T> capability);

    Collection<FqName> mo7086a(FqName fqName, Function1<? super Name, Boolean> function1);

    PackageViewDescriptor mo7087a(FqName fqName);

    boolean mo7088a(ModuleDescriptor moduleDescriptor);

    KotlinBuiltIns mo7089b();

    SourceKind mo7090c();
}
