package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* compiled from: DeclaredMemberIndex.kt */
final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex f38375a;

    ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        this.f38375a = classDeclaredMemberIndex;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        JavaMethod javaMethod = (JavaMethod) obj;
        Intrinsics.m26847b(javaMethod, "m");
        obj = (((Boolean) this.f38375a.f32714a.mo6492a(javaMethod)).booleanValue() && DescriptorResolverUtils.m27179a(javaMethod) == null) ? true : null;
        return Boolean.valueOf(obj);
    }
}
