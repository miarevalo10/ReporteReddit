package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: PackageViewDescriptor.kt */
public interface PackageViewDescriptor extends DeclarationDescriptor {

    /* compiled from: PackageViewDescriptor.kt */
    public static final class DefaultImpls {
        public static boolean m27086a(PackageViewDescriptor packageViewDescriptor) {
            return packageViewDescriptor.mo7083f().isEmpty();
        }
    }

    FqName mo7080b();

    MemberScope mo7081c();

    ModuleDescriptor mo7082d();

    List<PackageFragmentDescriptor> mo7083f();

    boolean mo7084g();
}
