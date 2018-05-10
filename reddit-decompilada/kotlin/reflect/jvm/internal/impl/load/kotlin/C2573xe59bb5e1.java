package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class C2573xe59bb5e1 implements AnnotationArgumentVisitor {
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 f32773a;
    final /* synthetic */ AnnotationArgumentVisitor f32774b;
    final /* synthetic */ Name f32775c;
    final /* synthetic */ ArrayList f32776d;
    private final /* synthetic */ AnnotationArgumentVisitor f32777e;

    public final AnnotationArgumentVisitor mo5814a(Name name, ClassId classId) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(classId, "classId");
        return this.f32777e.mo5814a(name, classId);
    }

    public final AnnotationArrayArgumentVisitor mo5815a(Name name) {
        Intrinsics.m26847b(name, "name");
        return this.f32777e.mo5815a(name);
    }

    public final void mo5817a(Name name, Object obj) {
        this.f32777e.mo5817a(name, obj);
    }

    public final void mo5818a(Name name, ClassId classId, Name name2) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(classId, "enumClassId");
        Intrinsics.m26847b(name2, "enumEntryName");
        this.f32777e.mo5818a(name, classId, name2);
    }

    C2573xe59bb5e1(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1, AnnotationArgumentVisitor annotationArgumentVisitor, Name name, ArrayList arrayList) {
        this.f32773a = binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1;
        this.f32774b = annotationArgumentVisitor;
        this.f32775c = name;
        this.f32776d = arrayList;
        this.f32777e = annotationArgumentVisitor;
    }

    public final void mo5816a() {
        this.f32774b.mo5816a();
        this.f32773a.m33170a(this.f32775c, (ConstantValue) new AnnotationValue((AnnotationDescriptor) CollectionsKt___CollectionsKt.m41441h((List) this.f32776d)));
    }
}
