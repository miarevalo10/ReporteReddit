package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument.Factory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotation.kt */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements JavaAnnotation {
    public final Annotation f36099a;

    public ReflectJavaAnnotation(Annotation annotation) {
        Intrinsics.m26847b(annotation, "annotation");
        this.f36099a = annotation;
    }

    public final Collection<JavaAnnotationArgument> mo6701a() {
        Object[] objArr = (Object[]) JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a(this.f36099a)).getDeclaredMethods();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Method method = (Method) obj;
            Factory factory = ReflectJavaAnnotationArgument.f32756a;
            Object invoke = method.invoke(this.f36099a, new Object[0]);
            Intrinsics.m26843a(invoke, "method.invoke(annotation)");
            arrayList.add(Factory.m27247a(invoke, Name.m27424a(method.getName())));
        }
        return (List) arrayList;
    }

    public final ClassId mo6702b() {
        return ReflectClassUtilKt.m27244e(JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a(this.f36099a)));
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaAnnotation) || Intrinsics.m26845a(this.f36099a, ((ReflectJavaAnnotation) obj).f36099a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f36099a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f36099a);
        return stringBuilder.toString();
    }

    public final /* synthetic */ JavaClass mo6703c() {
        return new ReflectJavaClass(JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a(this.f36099a)));
    }
}
