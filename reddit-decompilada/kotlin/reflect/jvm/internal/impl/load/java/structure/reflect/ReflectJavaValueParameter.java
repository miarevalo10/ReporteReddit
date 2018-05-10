package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaValueParameter.kt */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements JavaValueParameter {
    private final ReflectJavaType f38465a;
    private final Annotation[] f38466b;
    private final String f38467c;
    private final boolean f38468d;

    public final /* synthetic */ JavaAnnotation mo7092a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return ReflectJavaAnnotationOwnerKt.m27251a(this.f38466b, fqName);
    }

    public final boolean mo7108d() {
        return this.f38468d;
    }

    public ReflectJavaValueParameter(ReflectJavaType reflectJavaType, Annotation[] annotationArr, String str, boolean z) {
        Intrinsics.m26847b(reflectJavaType, "type");
        Intrinsics.m26847b(annotationArr, "reflectAnnotations");
        this.f38465a = reflectJavaType;
        this.f38466b = annotationArr;
        this.f38467c = str;
        this.f38468d = z;
    }

    public final Name mo7106b() {
        String str = this.f38467c;
        return str != null ? Name.m27427d(str) : null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f38468d ? "vararg " : "");
        stringBuilder.append(mo7106b());
        stringBuilder.append(": ");
        stringBuilder.append(this.f38465a);
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ Collection mo7091a() {
        return ReflectJavaAnnotationOwnerKt.m27250a(this.f38466b);
    }

    public final /* bridge */ /* synthetic */ JavaType mo7107c() {
        return this.f38465a;
    }
}
