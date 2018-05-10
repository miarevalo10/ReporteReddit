package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyJavaStaticClassScope.kt */
final class C2942xd2f8c9a5 extends Lambda implements Function1<MemberScope, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ Name f38434a;

    C2942xd2f8c9a5(Name name) {
        this.f38434a = name;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        MemberScope memberScope = (MemberScope) obj;
        Intrinsics.m26847b(memberScope, "it");
        return memberScope.mo6694a(this.f38434a, NoLookupLocation.f32685o);
    }
}
