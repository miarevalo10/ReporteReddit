package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class C2571x2cf49cf1 implements MemberVisitor {
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader f32764a;
    final /* synthetic */ HashMap f32765b;
    final /* synthetic */ HashMap f32766c;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class MemberAnnotationVisitor implements AnnotationVisitor {
        private final ArrayList<A> f32761a = new ArrayList();
        final MemberSignature f32762b;
        final /* synthetic */ C2571x2cf49cf1 f32763c;

        public MemberAnnotationVisitor(C2571x2cf49cf1 c2571x2cf49cf1, MemberSignature memberSignature) {
            Intrinsics.m26847b(memberSignature, "signature");
            this.f32763c = c2571x2cf49cf1;
            this.f32762b = memberSignature;
        }

        public final AnnotationArgumentVisitor mo5802a(ClassId classId, SourceElement sourceElement) {
            Intrinsics.m26847b(classId, "classId");
            Intrinsics.m26847b(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.m33138a(this.f32763c.f32764a, classId, sourceElement, (List) this.f32761a);
        }

        public final void mo5803a() {
            if ((this.f32761a.isEmpty() ^ 1) != 0) {
                this.f32763c.f32765b.put(this.f32762b, this.f32761a);
            }
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements MethodAnnotationVisitor {
        final /* synthetic */ C2571x2cf49cf1 f36111a;

        public AnnotationVisitorForMethod(C2571x2cf49cf1 c2571x2cf49cf1, MemberSignature memberSignature) {
            Intrinsics.m26847b(memberSignature, "signature");
            this.f36111a = c2571x2cf49cf1;
            super(c2571x2cf49cf1, memberSignature);
        }

        public final AnnotationArgumentVisitor mo6717a(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics.m26847b(classId, "classId");
            Intrinsics.m26847b(sourceElement, "source");
            Companion companion = MemberSignature.f25800b;
            i = Companion.m27345a(this.f32762b, i);
            List list = (List) this.f36111a.f32765b.get(i);
            if (list == null) {
                list = new ArrayList();
                this.f36111a.f32765b.put(i, list);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.m33138a(this.f36111a.f32764a, classId, sourceElement, list);
        }
    }

    C2571x2cf49cf1(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, HashMap hashMap, HashMap hashMap2) {
        this.f32764a = abstractBinaryClassAnnotationAndConstantLoader;
        this.f32765b = hashMap;
        this.f32766c = hashMap2;
    }

    public final MethodAnnotationVisitor mo5804a(Name name, String str) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(str, "desc");
        Companion companion = MemberSignature.f25800b;
        String a = name.m27429a();
        Intrinsics.m26843a((Object) a, "name.asString()");
        return new AnnotationVisitorForMethod(this, Companion.m27344a(a, str));
    }

    public final AnnotationVisitor mo5805b(Name name, String str) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(str, "desc");
        Companion companion = MemberSignature.f25800b;
        Object a = name.m27429a();
        Intrinsics.m26843a(a, "name.asString()");
        return (AnnotationVisitor) new MemberAnnotationVisitor(this, Companion.m27347b(a, str));
    }
}
