package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeResolver.kt */
final class LazyJavaTypeAttributes$typeAnnotations$1 extends Lambda implements Function1<FqName, Boolean> {
    public static final LazyJavaTypeAttributes$typeAnnotations$1 f38447a = new LazyJavaTypeAttributes$typeAnnotations$1();

    LazyJavaTypeAttributes$typeAnnotations$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "it");
        return Boolean.valueOf(JvmAnnotationNamesKt.m27163f().contains(fqName));
    }
}
