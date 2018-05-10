package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory f32847c = new Factory();
    public final Class<?> f32848a;
    public final KotlinClassHeader f32849b;

    /* compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        private Factory() {
        }

        public static ReflectKotlinClass m27389a(Class<?> cls) {
            Intrinsics.m26847b(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure reflectClassStructure = ReflectClassStructure.f25845a;
            ReflectClassStructure.m27386a((Class) cls, (AnnotationVisitor) readKotlinClassHeaderAnnotationVisitor);
            if (readKotlinClassHeaderAnnotationVisitor.f32845h != null) {
                KotlinClassHeader kotlinClassHeader;
                if (!readKotlinClassHeaderAnnotationVisitor.f32838a.m33204a()) {
                    readKotlinClassHeaderAnnotationVisitor.f32844g = readKotlinClassHeaderAnnotationVisitor.f32842e;
                }
                if (readKotlinClassHeaderAnnotationVisitor.f32838a != null) {
                    if (readKotlinClassHeaderAnnotationVisitor.f32838a.m33204a()) {
                        byte b;
                        if (!(readKotlinClassHeaderAnnotationVisitor.f32845h == Kind.f25828b || readKotlinClassHeaderAnnotationVisitor.f32845h == Kind.f25829c)) {
                            if (readKotlinClassHeaderAnnotationVisitor.f32845h != Kind.f25832f) {
                                b = (byte) 0;
                                if (b != (byte) 0 && readKotlinClassHeaderAnnotationVisitor.f32842e == null) {
                                }
                                kotlinClassHeader = new KotlinClassHeader(readKotlinClassHeaderAnnotationVisitor.f32845h, readKotlinClassHeaderAnnotationVisitor.f32838a == null ? readKotlinClassHeaderAnnotationVisitor.f32838a : JvmMetadataVersion.f32811b, readKotlinClassHeaderAnnotationVisitor.f32839b == null ? readKotlinClassHeaderAnnotationVisitor.f32839b : JvmBytecodeBinaryVersion.f32696b, readKotlinClassHeaderAnnotationVisitor.f32842e, readKotlinClassHeaderAnnotationVisitor.f32844g, readKotlinClassHeaderAnnotationVisitor.f32843f, readKotlinClassHeaderAnnotationVisitor.f32840c, readKotlinClassHeaderAnnotationVisitor.f32841d);
                                if (r2 == null) {
                                    return null;
                                }
                                return new ReflectKotlinClass(cls, r2);
                            }
                        }
                        b = (byte) 1;
                    }
                }
                readKotlinClassHeaderAnnotationVisitor.f32842e = null;
                if (readKotlinClassHeaderAnnotationVisitor.f32838a == null) {
                }
                if (readKotlinClassHeaderAnnotationVisitor.f32839b == null) {
                }
                kotlinClassHeader = new KotlinClassHeader(readKotlinClassHeaderAnnotationVisitor.f32845h, readKotlinClassHeaderAnnotationVisitor.f32838a == null ? readKotlinClassHeaderAnnotationVisitor.f32838a : JvmMetadataVersion.f32811b, readKotlinClassHeaderAnnotationVisitor.f32839b == null ? readKotlinClassHeaderAnnotationVisitor.f32839b : JvmBytecodeBinaryVersion.f32696b, readKotlinClassHeaderAnnotationVisitor.f32842e, readKotlinClassHeaderAnnotationVisitor.f32844g, readKotlinClassHeaderAnnotationVisitor.f32843f, readKotlinClassHeaderAnnotationVisitor.f32840c, readKotlinClassHeaderAnnotationVisitor.f32841d);
                if (r2 == null) {
                    return new ReflectKotlinClass(cls, r2);
                }
                return null;
            }
            KotlinClassHeader kotlinClassHeader2 = null;
            if (kotlinClassHeader2 == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, kotlinClassHeader2);
        }
    }

    private ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f32848a = cls;
        this.f32849b = kotlinClassHeader;
    }

    public final KotlinClassHeader mo5853c() {
        return this.f32849b;
    }

    public final String mo5852b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringsKt__StringsJVMKt.m41941a(this.f32848a.getName(), '.', '/'));
        stringBuilder.append(".class");
        return stringBuilder.toString();
    }

    public final ClassId mo5849a() {
        return ReflectClassUtilKt.m27244e(this.f32848a);
    }

    public final void mo5850a(AnnotationVisitor annotationVisitor) {
        Intrinsics.m26847b(annotationVisitor, "visitor");
        ReflectClassStructure reflectClassStructure = ReflectClassStructure.f25845a;
        ReflectClassStructure.m27386a(this.f32848a, annotationVisitor);
    }

    public final void mo5851a(MemberVisitor memberVisitor) {
        int i;
        MemberVisitor memberVisitor2 = memberVisitor;
        Intrinsics.m26847b(memberVisitor2, "visitor");
        ReflectClassStructure reflectClassStructure = ReflectClassStructure.f25845a;
        Class cls = this.f32848a;
        Intrinsics.m26847b(cls, "klass");
        Intrinsics.m26847b(memberVisitor2, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int i2;
            Object a = Name.m27424a(method.getName());
            Intrinsics.m26843a(a, "Name.identifier(method.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.f25850a;
            Intrinsics.m26843a((Object) method, "method");
            MethodAnnotationVisitor a2 = memberVisitor2.mo5804a(a, SignatureSerializer.m27395a(method));
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                AnnotationVisitor annotationVisitor = a2;
                Intrinsics.m26843a((Object) annotation, "annotation");
                ReflectClassStructure.m27387a(annotationVisitor, annotation);
            }
            for (IndexedValue indexedValue : ArraysKt___ArraysKt.m36112l((Object[]) method.getParameterAnnotations())) {
                i2 = indexedValue.f25277a;
                declaredAnnotations = (Annotation[]) indexedValue.f25278b;
                for (Object obj : declaredAnnotations) {
                    Class a3 = JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a((Annotation) obj));
                    ClassId e = ReflectClassUtilKt.m27244e(a3);
                    Intrinsics.m26843a(obj, "annotation");
                    AnnotationArgumentVisitor a4 = a2.mo6717a(i2, e, new ReflectAnnotationSource(obj));
                    if (a4 != null) {
                        a4 = a4;
                        ReflectClassStructure reflectClassStructure2 = ReflectClassStructure.f25845a;
                        Intrinsics.m26843a(obj, "annotation");
                        reflectClassStructure2.m27388a(a4, obj, a3);
                        Unit unit = Unit.f25273a;
                    }
                }
            }
            a2.mo5803a();
        }
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        int i3 = 0;
        while (i3 < declaredConstructors.length) {
            ReflectKotlinClass reflectKotlinClass;
            Constructor constructor = declaredConstructors[i3];
            a = Name.m27426c("<init>");
            Intrinsics.m26843a(a, "Name.special(\"<init>\")");
            signatureSerializer = SignatureSerializer.f25850a;
            Intrinsics.m26843a((Object) constructor, "constructor");
            a2 = memberVisitor2.mo5804a(a, SignatureSerializer.m27393a(constructor));
            declaredAnnotations = constructor.getDeclaredAnnotations();
            for (Annotation annotation2 : declaredAnnotations) {
                annotationVisitor = a2;
                Intrinsics.m26843a((Object) annotation2, "annotation");
                ReflectClassStructure.m27387a(annotationVisitor, annotation2);
            }
            Object[] objArr = (Object[]) constructor.getParameterAnnotations();
            if ((1 ^ (objArr.length == 0 ? 1 : 0)) != 0) {
                int length = ((Object[]) constructor.getParameterTypes()).length - objArr.length;
                for (IndexedValue indexedValue2 : ArraysKt___ArraysKt.m36112l(objArr)) {
                    i = indexedValue2.f25277a;
                    Annotation[] annotationArr = (Annotation[]) indexedValue2.f25278b;
                    int i4 = 0;
                    while (i4 < annotationArr.length) {
                        Object obj2 = annotationArr[i4];
                        Class a5 = JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a((Annotation) obj2));
                        int i5 = i + length;
                        ClassId e2 = ReflectClassUtilKt.m27244e(a5);
                        Intrinsics.m26843a(obj2, "annotation");
                        AnnotationArgumentVisitor a6 = a2.mo6717a(i5, e2, new ReflectAnnotationSource(obj2));
                        if (a6 != null) {
                            a6 = a6;
                            ReflectClassStructure reflectClassStructure3 = ReflectClassStructure.f25845a;
                            Intrinsics.m26843a(obj2, "annotation");
                            reflectClassStructure3.m27388a(a6, obj2, a5);
                            Unit unit2 = Unit.f25273a;
                        }
                        i4++;
                        reflectKotlinClass = this;
                    }
                }
            }
            a2.mo5803a();
            i3++;
            reflectKotlinClass = this;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            Object a7 = Name.m27424a(field.getName());
            Intrinsics.m26843a(a7, "Name.identifier(field.name)");
            SignatureSerializer signatureSerializer2 = SignatureSerializer.f25850a;
            Intrinsics.m26843a((Object) field, "field");
            AnnotationVisitor b = memberVisitor2.mo5805b(a7, SignatureSerializer.m27394a(field));
            Annotation[] declaredAnnotations2 = field.getDeclaredAnnotations();
            for (Annotation annotation3 : declaredAnnotations2) {
                Intrinsics.m26843a((Object) annotation3, "annotation");
                ReflectClassStructure.m27387a(b, annotation3);
            }
            b.mo5803a();
        }
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof ReflectKotlinClass) || Intrinsics.m26845a(this.f32848a, ((ReflectKotlinClass) obj).f32848a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f32848a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f32848a);
        return stringBuilder.toString();
    }
}
