package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class C2572xc0ff27f9 implements AnnotationVisitor {
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader f32767a;
    final /* synthetic */ ArrayList f32768b;

    public final void mo5803a() {
    }

    C2572xc0ff27f9(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ArrayList arrayList) {
        this.f32767a = abstractBinaryClassAnnotationAndConstantLoader;
        this.f32768b = arrayList;
    }

    public final AnnotationArgumentVisitor mo5802a(ClassId classId, SourceElement sourceElement) {
        Intrinsics.m26847b(classId, "classId");
        Intrinsics.m26847b(sourceElement, "source");
        return AbstractBinaryClassAnnotationAndConstantLoader.m33138a(this.f32767a, classId, sourceElement, (List) this.f32768b);
    }
}
