package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getFunctions$2 extends Lambda implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ Name f38776a;

    JvmBuiltInsSettings$getFunctions$2(Name name) {
        this.f38776a = name;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        MemberScope memberScope = (MemberScope) obj;
        Intrinsics.m26847b(memberScope, "it");
        return memberScope.mo6698b(this.f38776a, NoLookupLocation.f32674d);
    }
}
