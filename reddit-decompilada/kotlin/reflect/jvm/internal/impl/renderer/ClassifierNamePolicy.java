package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: ClassifierNamePolicy.kt */
public interface ClassifierNamePolicy {

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED f32883a = null;

        static {
            FULLY_QUALIFIED fully_qualified = new FULLY_QUALIFIED();
        }

        private FULLY_QUALIFIED() {
            f32883a = this;
        }

        public final String mo5884a(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            Intrinsics.m26847b(classifierDescriptor, "classifier");
            Intrinsics.m26847b(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name i = ((TypeParameterDescriptor) classifierDescriptor).mo6689i();
                Intrinsics.m26843a((Object) i, "classifier.name");
                return descriptorRenderer.mo5893a(i);
            }
            FqNameUnsafe c = DescriptorUtils.m27653c(classifierDescriptor);
            Intrinsics.m26843a((Object) c, "DescriptorUtils.getFqName(classifier)");
            return descriptorRenderer.mo5892a(c);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT f32884a = null;

        static {
            SHORT shortR = new SHORT();
        }

        private SHORT() {
            f32884a = this;
        }

        public final String mo5884a(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            Intrinsics.m26847b(classifierDescriptor, "classifier");
            Intrinsics.m26847b(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name i = ((TypeParameterDescriptor) classifierDescriptor).mo6689i();
                Intrinsics.m26843a((Object) i, "classifier.name");
                return descriptorRenderer.mo5893a(i);
            }
            descriptorRenderer = new ArrayList();
            classifierDescriptor = classifierDescriptor;
            do {
                if (classifierDescriptor == null) {
                    Intrinsics.m26842a();
                }
                descriptorRenderer.add(classifierDescriptor.mo6689i());
                classifierDescriptor = classifierDescriptor.aD_();
            } while (classifierDescriptor instanceof ClassDescriptor);
            return RenderingUtilsKt.m27620a(CollectionsKt__ReversedViewsKt.m39799c((List) descriptorRenderer));
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED f32885a = null;

        static {
            SOURCE_CODE_QUALIFIED source_code_qualified = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
            f32885a = this;
        }

        public final String mo5884a(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            Intrinsics.m26847b(classifierDescriptor, "classifier");
            Intrinsics.m26847b(descriptorRenderer, "renderer");
            return m33341a(classifierDescriptor);
        }

        private String m33341a(ClassifierDescriptor classifierDescriptor) {
            Intrinsics.m26847b(classifierDescriptor, "descriptor");
            String a = RenderingUtilsKt.m27622a(classifierDescriptor.mo6689i());
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return a;
            }
            Object aD_ = classifierDescriptor.aD_();
            Intrinsics.m26843a(aD_, "descriptor.containingDeclaration");
            aD_ = aD_ instanceof ClassDescriptor ? m33341a((ClassifierDescriptor) aD_) : aD_ instanceof PackageFragmentDescriptor ? RenderingUtilsKt.m27621a(((PackageFragmentDescriptor) aD_).mo7722d().m27409b()) : null;
            if (aD_ == null || (Intrinsics.m26845a(aD_, (Object) "") ^ 1) == 0) {
                return a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aD_);
            stringBuilder.append(".");
            stringBuilder.append(a);
            return stringBuilder.toString();
        }
    }

    String mo5884a(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer);
}
