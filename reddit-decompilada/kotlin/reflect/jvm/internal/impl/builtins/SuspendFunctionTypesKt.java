package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: suspendFunctionTypes.kt */
public final class SuspendFunctionTypesKt {
    private static final MutableClassDescriptor f25453a;

    public static final MutableClassDescriptor m27033a() {
        return f25453a;
    }

    static {
        Object a = ErrorUtils.m27932a();
        Intrinsics.m26843a(a, "ErrorUtils.getErrorModule()");
        Object obj = DescriptorUtils.f26055d;
        Intrinsics.m26843a(obj, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME");
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(a, obj), ClassKind.INTERFACE, DescriptorUtils.f26056e.m27412e(), SourceElement.f25498a);
        Modality modality = Modality.f25491d;
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setModality"}));
        } else if (MutableClassDescriptor.f40917f || modality != Modality.f25489b) {
            mutableClassDescriptor.f40918a = modality;
            Visibility visibility = Visibilities.f25508e;
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setVisibility"}));
            }
            mutableClassDescriptor.f40919b = visibility;
            DeclarationDescriptor declarationDescriptor = mutableClassDescriptor;
            Companion companion = Annotations.f32643a;
            List a2 = CollectionsKt__CollectionsKt.m26791a((Object) TypeParameterDescriptorImpl.m42660a(declarationDescriptor, Companion.m27115a(), Variance.f26338b, Name.m27424a("T"), 0));
            if (a2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setTypeParameterDescriptors"}));
            } else if (mutableClassDescriptor.f40920c != null) {
                r2 = new StringBuilder("Type parameters are already set for ");
                r2.append(mutableClassDescriptor.mo6689i());
                throw new IllegalStateException(r2.toString());
            } else {
                mutableClassDescriptor.f40920c = new ArrayList(a2);
                mutableClassDescriptor.m42949w();
                f25453a = mutableClassDescriptor;
            }
        } else {
            r2 = new StringBuilder("Implement getSealedSubclasses() for this class: ");
            r2.append(mutableClassDescriptor.getClass());
            throw new AssertionError(r2.toString());
        }
    }

    public static final SimpleType m27034a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "suspendFunType");
        boolean b = FunctionTypesKt.m26949b(kotlinType);
        if (!_Assertions.f25274a || b) {
            KotlinBuiltIns a = TypeUtilsKt.m28060a(kotlinType);
            Annotations q = kotlinType.mo5718q();
            KotlinType d = FunctionTypesKt.m26951d(kotlinType);
            Iterable<TypeProjection> f = FunctionTypesKt.m26953f(kotlinType);
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(f));
            for (TypeProjection c : f) {
                arrayList.add(c.mo6736c());
            }
            arrayList = (List) arrayList;
            Companion companion = Annotations.f32643a;
            Annotations a2 = Companion.m27115a();
            Object c2 = f25453a.mo7610c();
            Intrinsics.m26843a(c2, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
            List a3 = CollectionsKt___CollectionsKt.m41419a(arrayList, (Object) KotlinTypeFactory.m27951a(a2, c2, CollectionsKt__CollectionsKt.m26791a((Object) TypeUtilsKt.m28068e(FunctionTypesKt.m26952e(kotlinType))), false));
            Object n = TypeUtilsKt.m28060a(kotlinType).m27016n();
            Intrinsics.m26843a(n, "suspendFunType.builtIns.nullableAnyType");
            return FunctionTypesKt.m26947a(a, q, d, a3, (KotlinType) n, false).mo7297b(kotlinType.mo6741c());
        }
        StringBuilder stringBuilder = new StringBuilder("This type should be suspend function type: ");
        stringBuilder.append(kotlinType);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final SimpleType m27035b(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "funType");
        boolean a = FunctionTypesKt.m26948a(kotlinType);
        if (!_Assertions.f25274a || a) {
            TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41439g(FunctionTypesKt.m26953f(kotlinType));
            if (typeProjection != null) {
                KotlinType c = typeProjection.mo6736c();
                if (c != null) {
                    ClassifierDescriptor c2 = c.mo6743g().mo5724c();
                    if ((Intrinsics.m26845a(c2 != null ? DescriptorUtilsKt.m27742b((DeclarationDescriptor) c2) : null, DescriptorUtils.f26056e) ^ 1) == 0) {
                        if (c.mo6739a().size() == 1) {
                            Object c3 = ((TypeProjection) CollectionsKt___CollectionsKt.m41441h(c.mo6739a())).mo6736c();
                            KotlinBuiltIns a2 = TypeUtilsKt.m28060a(kotlinType);
                            Annotations q = kotlinType.mo5718q();
                            KotlinType d = FunctionTypesKt.m26951d(kotlinType);
                            Iterable<TypeProjection> j = CollectionsKt___CollectionsKt.m41445j(FunctionTypesKt.m26953f(kotlinType));
                            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(j));
                            for (TypeProjection c4 : j) {
                                arrayList.add(c4.mo6736c());
                            }
                            List list = (List) arrayList;
                            Intrinsics.m26843a(c3, "suspendReturnType");
                            return FunctionTypesKt.m26947a(a2, q, d, list, c3, true).mo7297b(kotlinType.mo6741c());
                        }
                    }
                    return null;
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("This type should be function type: ");
        stringBuilder.append(kotlinType);
        throw new AssertionError(stringBuilder.toString());
    }
}
