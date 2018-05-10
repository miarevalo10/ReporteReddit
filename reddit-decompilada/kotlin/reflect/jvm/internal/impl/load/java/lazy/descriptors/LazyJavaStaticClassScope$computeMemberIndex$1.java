package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$computeMemberIndex$1 extends Lambda implements Function1<JavaMember, Boolean> {
    public static final LazyJavaStaticClassScope$computeMemberIndex$1 f38431a = new LazyJavaStaticClassScope$computeMemberIndex$1();

    LazyJavaStaticClassScope$computeMemberIndex$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        JavaMember javaMember = (JavaMember) obj;
        Intrinsics.m26847b(javaMember, "it");
        return Boolean.valueOf(javaMember.mo7100m());
    }
}
