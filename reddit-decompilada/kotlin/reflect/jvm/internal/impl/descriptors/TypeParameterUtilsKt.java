package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: typeParameterUtils.kt */
public final class TypeParameterUtilsKt {
    public static final List<TypeParameterDescriptor> m27089a(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "$receiver");
        Object s = classifierDescriptorWithTypeParameters.mo7719s();
        if (classifierDescriptorWithTypeParameters.mo7742l() || (classifierDescriptorWithTypeParameters.aD_() instanceof CallableDescriptor)) {
            Object obj;
            List list;
            DeclarationDescriptor declarationDescriptor = classifierDescriptorWithTypeParameters;
            List d = SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33714d(SequencesKt___SequencesKt.m33712c(DescriptorUtilsKt.m27746e(declarationDescriptor), C2930x246a49e2.f38328a), C2931x246a49e3.f38329a));
            Iterator a = DescriptorUtilsKt.m27746e(declarationDescriptor).mo5679a();
            do {
                list = null;
                if (!a.hasNext()) {
                    obj = null;
                    break;
                }
                obj = a.next();
            } while (!(obj instanceof ClassDescriptor));
            ClassDescriptor classDescriptor = (ClassDescriptor) obj;
            if (classDescriptor != null) {
                TypeConstructor c = classDescriptor.mo7610c();
                if (c != null) {
                    list = c.mo5723b();
                }
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.m26790a();
            }
            if (d.isEmpty() && list.isEmpty()) {
                Object s2 = classifierDescriptorWithTypeParameters.mo7719s();
                Intrinsics.m26843a(s2, "declaredTypeParameters");
                return s2;
            }
            Iterable<TypeParameterDescriptor> b = CollectionsKt___CollectionsKt.m41423b((Collection) d, (Iterable) list);
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
            for (TypeParameterDescriptor capturedTypeParameterDescriptor : b) {
                arrayList.add(new CapturedTypeParameterDescriptor(capturedTypeParameterDescriptor, declarationDescriptor, s.size()));
            }
            return CollectionsKt___CollectionsKt.m41423b((Collection) s, (Iterable) (List) arrayList);
        }
        Intrinsics.m26843a(s, "declaredParameters");
        return s;
    }

    public static final PossiblyInnerType m27090a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
        if (!(c instanceof ClassifierDescriptorWithTypeParameters)) {
            c = null;
        }
        return m27091a(kotlinType, (ClassifierDescriptorWithTypeParameters) c, 0);
    }

    private static final PossiblyInnerType m27091a(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        PossiblyInnerType possiblyInnerType = null;
        if (classifierDescriptorWithTypeParameters != null) {
            DeclarationDescriptor declarationDescriptor = classifierDescriptorWithTypeParameters;
            if (!ErrorUtils.m27938a(declarationDescriptor)) {
                int size = classifierDescriptorWithTypeParameters.mo7719s().size() + i;
                if (classifierDescriptorWithTypeParameters.mo7742l()) {
                    i = kotlinType.mo6739a().subList(i, size);
                    DeclarationDescriptor aD_ = classifierDescriptorWithTypeParameters.aD_();
                    if (aD_ instanceof ClassifierDescriptorWithTypeParameters) {
                        possiblyInnerType = aD_;
                    }
                    return new PossiblyInnerType(classifierDescriptorWithTypeParameters, i, m27091a(kotlinType, (ClassifierDescriptorWithTypeParameters) possiblyInnerType, size));
                }
                Object obj;
                if (size != kotlinType.mo6739a().size()) {
                    if (!DescriptorUtils.m27651b(declarationDescriptor)) {
                        obj = null;
                        if (_Assertions.f25274a || r1 != null) {
                            return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.mo6739a().subList(i, kotlinType.mo6739a().size()), null);
                        }
                        classifierDescriptorWithTypeParameters = new StringBuilder();
                        classifierDescriptorWithTypeParameters.append(kotlinType.mo6739a().size() - size);
                        classifierDescriptorWithTypeParameters.append(" trailing arguments were found in ");
                        classifierDescriptorWithTypeParameters.append(kotlinType);
                        classifierDescriptorWithTypeParameters.append(" type");
                        throw ((Throwable) new AssertionError(classifierDescriptorWithTypeParameters.toString()));
                    }
                }
                obj = 1;
                if (_Assertions.f25274a) {
                }
                return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.mo6739a().subList(i, kotlinType.mo6739a().size()), null);
            }
        }
        return null;
    }
}
