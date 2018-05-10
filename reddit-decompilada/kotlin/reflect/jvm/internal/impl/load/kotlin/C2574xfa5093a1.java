package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class C2574xfa5093a1 implements AnnotationArrayArgumentVisitor {
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 f32778a;
    final /* synthetic */ Name f32779b;
    private final ArrayList<ConstantValue<?>> f32780c = new ArrayList();

    C2574xfa5093a1(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1, Name name) {
        this.f32778a = binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1;
        this.f32779b = name;
    }

    public final void mo5820a(Object obj) {
        this.f32780c.add(this.f32778a.m33171b(this.f32779b, obj));
    }

    public final void mo5821a(ClassId classId, Name name) {
        Intrinsics.m26847b(classId, "enumClassId");
        Intrinsics.m26847b(name, "enumEntryName");
        this.f32780c.add(this.f32778a.m33168a(classId, name));
    }

    public final void mo5819a() {
        ValueParameterDescriptor a = DescriptorResolverUtils.m27178a(this.f32779b, this.f32778a.f32782b);
        if (a != null) {
            this.f32780c.trimToSize();
            Map a2 = this.f32778a.f32785e;
            ConstantValueFactory a3 = this.f32778a.f32781a.f36113c;
            List list = this.f32780c;
            Object x = a.mo7777x();
            Intrinsics.m26843a(x, "parameter.type");
            a2.put(a, a3.m27720a(list, x));
        }
    }
}
