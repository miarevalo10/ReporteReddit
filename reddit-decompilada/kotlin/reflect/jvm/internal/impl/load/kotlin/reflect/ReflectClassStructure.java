package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectKotlinClass.kt */
final class ReflectClassStructure {
    public static final ReflectClassStructure f25845a = null;

    static {
        ReflectClassStructure reflectClassStructure = new ReflectClassStructure();
    }

    private ReflectClassStructure() {
        f25845a = this;
    }

    public static void m27386a(Class<?> cls, AnnotationVisitor annotationVisitor) {
        Intrinsics.m26847b(cls, "klass");
        Intrinsics.m26847b(annotationVisitor, "visitor");
        cls = cls.getDeclaredAnnotations();
        for (Annotation annotation : cls) {
            Intrinsics.m26843a((Object) annotation, "annotation");
            m27387a(annotationVisitor, annotation);
        }
        annotationVisitor.mo5803a();
    }

    static void m27387a(AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class a = JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a(annotation));
        annotationVisitor = annotationVisitor.mo5802a(ReflectClassUtilKt.m27244e(a), new ReflectAnnotationSource(annotation));
        if (annotationVisitor != null) {
            f25845a.m27388a((AnnotationArgumentVisitor) annotationVisitor, annotation, a);
            annotationVisitor = Unit.f25273a;
        }
    }

    final void m27388a(AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        cls = cls.getDeclaredMethods();
        for (Method method : cls) {
            Name a = Name.m27424a(method.getName());
            Intrinsics.m26843a((Object) a, "Name.identifier(method.name)");
            Object invoke = method.invoke(annotation, new Object[0]);
            if (invoke == null) {
                Intrinsics.m26842a();
            }
            Class cls2 = invoke.getClass();
            if (ReflectKotlinClassKt.f25846a.contains(cls2)) {
                annotationArgumentVisitor.mo5817a(a, invoke);
            } else if (ReflectClassUtilKt.m27241b(cls2)) {
                if (!cls2.isEnum()) {
                    cls2 = cls2.getEnclosingClass();
                }
                r4 = ReflectClassUtilKt.m27244e(cls2);
                if (invoke == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
                invoke = Name.m27424a(((Enum) invoke).name());
                Intrinsics.m26843a(invoke, "Name.identifier((value as Enum<*>).name)");
                annotationArgumentVisitor.mo5818a(a, r4, invoke);
            } else if (Annotation.class.isAssignableFrom(cls2)) {
                Object obj = (Class) ArraysKt___ArraysKt.m36103d((Object[]) cls2.getInterfaces());
                AnnotationArgumentVisitor a2 = annotationArgumentVisitor.mo5814a(a, ReflectClassUtilKt.m27244e(obj));
                if (a2 != null) {
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Annotation");
                    }
                    Annotation annotation2 = (Annotation) invoke;
                    Intrinsics.m26843a(obj, "annotationClass");
                    m27388a(a2, annotation2, obj);
                }
            } else if (cls2.isArray()) {
                AnnotationArrayArgumentVisitor a3 = annotationArgumentVisitor.mo5815a(a);
                if (a3 != null) {
                    cls2 = cls2.getComponentType();
                    Object[] objArr;
                    if (cls2.isEnum()) {
                        r4 = ReflectClassUtilKt.m27244e(cls2);
                        if (invoke == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                        objArr = (Object[]) invoke;
                        for (Object obj2 : objArr) {
                            Object obj22;
                            if (obj22 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                            }
                            obj22 = Name.m27424a(((Enum) obj22).name());
                            Intrinsics.m26843a(obj22, "Name.identifier((element as Enum<*>).name)");
                            a3.mo5821a(r4, obj22);
                        }
                    } else if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                    } else {
                        objArr = (Object[]) invoke;
                        for (Object a4 : objArr) {
                            a3.mo5820a(a4);
                        }
                    }
                    a3.mo5819a();
                }
            } else {
                annotation = new StringBuilder("Unsupported annotation argument value (");
                annotation.append(cls2);
                annotation.append("): ");
                annotation.append(invoke);
                throw ((Throwable) new UnsupportedOperationException(annotation.toString()));
            }
        }
        annotationArgumentVisitor.mo5816a();
    }
}
