package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1 extends Lambda implements Function1<JavaType, Boolean> {
    public static final JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1 f38437a = new JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1();

    JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(m38405a((JavaType) obj));
    }

    public static boolean m38405a(JavaType javaType) {
        if (!(javaType instanceof JavaWildcardType)) {
            javaType = null;
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        if (javaWildcardType != null) {
            javaWildcardType = javaWildcardType;
            if (javaWildcardType.mo6715a() != null && javaWildcardType.mo6716b() == null) {
                return true;
            }
        }
        return false;
    }
}
