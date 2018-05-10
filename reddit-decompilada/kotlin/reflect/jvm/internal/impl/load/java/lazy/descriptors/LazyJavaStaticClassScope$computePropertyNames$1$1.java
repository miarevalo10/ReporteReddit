package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$computePropertyNames$1$1 extends Lambda implements Function1<MemberScope, Set<? extends Name>> {
    public static final LazyJavaStaticClassScope$computePropertyNames$1$1 f38435a = new LazyJavaStaticClassScope$computePropertyNames$1$1();

    LazyJavaStaticClassScope$computePropertyNames$1$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        MemberScope memberScope = (MemberScope) obj;
        Intrinsics.m26847b(memberScope, "it");
        return memberScope.aF_();
    }
}
