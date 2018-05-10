package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: JvmPackageScope.kt */
final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<List<? extends MemberScope>> {
    final /* synthetic */ JvmPackageScope f38376a;

    JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        this.f38376a = jvmPackageScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (KotlinJvmBinaryClass a : this.f38376a.f36095e.m42680b().values()) {
            MemberScope a2 = this.f38376a.f36094d.f25703b.f25688d.m27299a((PackageFragmentDescriptor) this.f38376a.f36095e, a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return CollectionsKt.m28089a((Collection) (List) arrayList);
    }
}
