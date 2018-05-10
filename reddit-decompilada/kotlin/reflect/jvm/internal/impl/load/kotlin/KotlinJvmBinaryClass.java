package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: KotlinJvmBinaryClass.kt */
public interface KotlinJvmBinaryClass {

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationArgumentVisitor {
        AnnotationArgumentVisitor mo5814a(Name name, ClassId classId);

        AnnotationArrayArgumentVisitor mo5815a(Name name);

        void mo5816a();

        void mo5817a(Name name, Object obj);

        void mo5818a(Name name, ClassId classId, Name name2);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationArrayArgumentVisitor {
        void mo5819a();

        void mo5820a(Object obj);

        void mo5821a(ClassId classId, Name name);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationVisitor {
        AnnotationArgumentVisitor mo5802a(ClassId classId, SourceElement sourceElement);

        void mo5803a();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface MemberVisitor {
        MethodAnnotationVisitor mo5804a(Name name, String str);

        AnnotationVisitor mo5805b(Name name, String str);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor mo6717a(int i, ClassId classId, SourceElement sourceElement);
    }

    ClassId mo5849a();

    void mo5850a(AnnotationVisitor annotationVisitor);

    void mo5851a(MemberVisitor memberVisitor);

    String mo5852b();

    KotlinClassHeader mo5853c();
}
