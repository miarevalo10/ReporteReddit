package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory.Companion;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: functionTypes.kt */
public final class FunctionTypesKt {
    public static final boolean m26948a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6743g().mo5724c();
        return Intrinsics.m26845a(kotlinType != null ? m26945a((DeclarationDescriptor) kotlinType) : null, Kind.f25456a);
    }

    public static final boolean m26949b(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6743g().mo5724c();
        return Intrinsics.m26845a(kotlinType != null ? m26945a((DeclarationDescriptor) kotlinType) : null, Kind.f25457b);
    }

    public static final boolean m26950c(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6743g().mo5724c();
        Object a = kotlinType != null ? m26945a((DeclarationDescriptor) kotlinType) : null;
        if (!Intrinsics.m26845a(a, Kind.f25456a)) {
            if (Intrinsics.m26845a(a, Kind.f25457b) == null) {
                return null;
            }
        }
        return true;
    }

    private static final boolean m26955h(KotlinType kotlinType) {
        kotlinType = kotlinType.mo5718q();
        Object obj = KotlinBuiltIns.f25420j.f25405z;
        Intrinsics.m26843a(obj, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return kotlinType.mo6679a(obj) != null ? true : null;
    }

    private static Kind m26945a(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            return null;
        }
        declarationDescriptor = DescriptorUtilsKt.m27738a(declarationDescriptor);
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        if (declarationDescriptor.m27419c()) {
            if (!declarationDescriptor.f25861b.isEmpty()) {
                declarationDescriptor = declarationDescriptor.m27420d();
                Companion companion = BuiltInFictitiousFunctionClassFactory.f32627a;
                Object a = declarationDescriptor.m27412e().m27429a();
                Intrinsics.m26843a(a, "fqName.shortName().asString()");
                Object d = declarationDescriptor.m27411d();
                Intrinsics.m26843a(d, "fqName.parent()");
                Intrinsics.m26847b(a, "className");
                Intrinsics.m26847b(d, "packageFqName");
                declarationDescriptor = Companion.m27036a(a, d);
                if (declarationDescriptor != null) {
                    return declarationDescriptor.f25454a;
                }
                return null;
            }
        }
        return null;
    }

    public static final KotlinType m26951d(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        boolean c = m26950c(kotlinType);
        if (!_Assertions.f25274a || c) {
            return m26955h(kotlinType) ? ((TypeProjection) CollectionsKt___CollectionsKt.m41430d((List) kotlinType.mo6739a())).mo6736c() : null;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Not a function type: ");
            stringBuilder.append(kotlinType);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public static final KotlinType m26952e(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        boolean c = m26950c(kotlinType);
        if (!_Assertions.f25274a || c) {
            Object c2 = ((TypeProjection) CollectionsKt___CollectionsKt.m41437f((List) kotlinType.mo6739a())).mo6736c();
            Intrinsics.m26843a(c2, "arguments.last().type");
            return c2;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a function type: ");
        stringBuilder.append(kotlinType);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final List<TypeProjection> m26953f(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        boolean c = m26950c(kotlinType);
        if (!_Assertions.f25274a || c) {
            List a = kotlinType.mo6739a();
            Intrinsics.m26847b(kotlinType, "$receiver");
            int i = 0;
            int i2 = (m26950c(kotlinType) && m26955h(kotlinType)) ? 1 : 0;
            int size = a.size() - 1;
            if (i2 <= size) {
                i = 1;
            }
            if (!_Assertions.f25274a || r2 != 0) {
                return a.subList(i2, size);
            }
            StringBuilder stringBuilder = new StringBuilder("Not an exact function type: ");
            stringBuilder.append(kotlinType);
            throw new AssertionError(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("Not a function type: ");
        stringBuilder.append(kotlinType);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final Name m26954g(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo5718q();
        Object obj = KotlinBuiltIns.f25420j.f25354A;
        Intrinsics.m26843a(obj, "KotlinBuiltIns.FQ_NAMES.parameterName");
        kotlinType = kotlinType.mo6679a(obj);
        if (kotlinType == null) {
            return null;
        }
        kotlinType = CollectionsKt___CollectionsKt.m41442i((Iterable) kotlinType.mo5720b().values());
        if (!(kotlinType instanceof StringValue)) {
            kotlinType = null;
        }
        StringValue stringValue = (StringValue) kotlinType;
        if (stringValue != null) {
            String str = (String) stringValue.mo5919b();
            if (str != null) {
                str = (String) AddToStdlibKt.m28126a(str, C2926x6e03f836.f38316a);
                if (str != null) {
                    return Name.m27424a(str);
                }
            }
        }
        return null;
    }

    public static final SimpleType m26947a(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List<? extends KotlinType> list, KotlinType kotlinType2, boolean z) {
        Object c;
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(list, "parameterTypes");
        Intrinsics.m26847b(kotlinType2, "returnType");
        Intrinsics.m26847b(list, "parameterTypes");
        Intrinsics.m26847b(kotlinType2, "returnType");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        ArrayList arrayList = new ArrayList((list.size() + (kotlinType != null ? 1 : 0)) + 1);
        Collection collection = arrayList;
        CollectionsKt.m28092a(collection, kotlinType != null ? TypeUtilsKt.m28068e(kotlinType) : null);
        for (KotlinType e : list) {
            collection.add(TypeUtilsKt.m28068e(e));
        }
        arrayList.add(TypeUtilsKt.m28068e(kotlinType2));
        List list2 = arrayList;
        int size = list.size();
        if (kotlinType != null) {
            size++;
        }
        if (z) {
            c = kotlinBuiltIns.m27004c(size);
        } else {
            c = kotlinBuiltIns.m26997a(KotlinBuiltIns.m26965a(size));
            if (c == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFunction"}));
            }
        }
        if (kotlinType != null) {
            Object obj = KotlinBuiltIns.f25420j.f25405z;
            Intrinsics.m26843a(obj, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (annotations.mo6679a(obj) == null) {
                annotations = (Annotations) new AnnotationsImpl(CollectionsKt___CollectionsKt.m41426c((Iterable) annotations, (Object) new AnnotationDescriptorImpl(kotlinBuiltIns.m27003b(KotlinBuiltIns.f25420j.f25405z.m27412e()).mo7714h(), MapsKt__MapsKt.m36116a(), SourceElement.f25498a)));
            }
        }
        Intrinsics.m26843a(c, "classDescriptor");
        return KotlinTypeFactory.m27950a(annotations, c, list2);
    }
}
