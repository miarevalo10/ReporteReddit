package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 implements AnnotationArgumentVisitor {
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl f32781a;
    final /* synthetic */ ClassDescriptor f32782b;
    final /* synthetic */ List f32783c;
    final /* synthetic */ SourceElement f32784d;
    private final HashMap<ValueParameterDescriptor, ConstantValue<?>> f32785e = new HashMap();

    BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, ClassDescriptor classDescriptor, List list, SourceElement sourceElement) {
        this.f32781a = binaryClassAnnotationAndConstantLoaderImpl;
        this.f32782b = classDescriptor;
        this.f32783c = list;
        this.f32784d = sourceElement;
    }

    public final void mo5817a(Name name, Object obj) {
        if (name != null) {
            m33170a(name, m33171b(name, obj));
        }
    }

    public final void mo5818a(Name name, ClassId classId, Name name2) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(classId, "enumClassId");
        Intrinsics.m26847b(name2, "enumEntryName");
        m33170a(name, m33168a(classId, name2));
    }

    public final AnnotationArrayArgumentVisitor mo5815a(Name name) {
        Intrinsics.m26847b(name, "name");
        return new C2574xfa5093a1(this, name);
    }

    public final AnnotationArgumentVisitor mo5814a(Name name, ClassId classId) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.f32781a;
        SourceElement sourceElement = SourceElement.f25498a;
        Intrinsics.m26843a((Object) sourceElement, "SourceElement.NO_SOURCE");
        return new C2573xe59bb5e1(this, binaryClassAnnotationAndConstantLoaderImpl.mo6721a(classId, sourceElement, (List) arrayList), name, arrayList);
    }

    private final ConstantValue<?> m33168a(ClassId classId, Name name) {
        ClassDescriptor a = this.f32781a.m36300a(classId);
        if (Intrinsics.m26845a(a.mo7771g(), ClassKind.ENUM_CLASS)) {
            ClassifierDescriptor c = a.mo7739t().mo6699c(name, NoLookupLocation.f32689s);
            if (c instanceof ClassDescriptor) {
                this.f32781a.f36113c;
                return ConstantValueFactory.m27717a((ClassDescriptor) c);
            }
        }
        this.f32781a.f36113c;
        StringBuilder stringBuilder = new StringBuilder("Unresolved enum entry: ");
        stringBuilder.append(classId);
        stringBuilder.append(".");
        stringBuilder.append(name);
        return ConstantValueFactory.m27718a(stringBuilder.toString());
    }

    public final void mo5816a() {
        this.f32783c.add(new AnnotationDescriptorImpl(this.f32782b.mo7714h(), this.f32785e, this.f32784d));
    }

    private final ConstantValue<?> m33171b(Name name, Object obj) {
        obj = this.f32781a.f36113c.m27724a(obj);
        if (obj != null) {
            return obj;
        }
        this.f32781a.f36113c;
        obj = new StringBuilder("Unsupported annotation argument: ");
        obj.append(name);
        return ConstantValueFactory.m27718a(obj.toString());
    }

    private final void m33170a(Name name, ConstantValue<?> constantValue) {
        name = DescriptorResolverUtils.m27178a(name, this.f32782b);
        if (name != null) {
            this.f32785e.put(name, constantValue);
        }
    }
}
