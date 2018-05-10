package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: annotationUtil.kt */
public final class AnnotationUtilKt {
    private static final FqName f25534a = new FqName("kotlin.internal.InlineOnly");

    public static /* synthetic */ AnnotationDescriptor m27110a(KotlinBuiltIns kotlinBuiltIns, String str) {
        KotlinBuiltIns kotlinBuiltIns2 = kotlinBuiltIns;
        String str2 = str;
        String str3 = "";
        String str4 = "WARNING";
        Intrinsics.m26847b(kotlinBuiltIns2, "$receiver");
        Intrinsics.m26847b(str2, "message");
        Intrinsics.m26847b(str3, "replaceWith");
        Intrinsics.m26847b(str4, "level");
        ClassDescriptor j = kotlinBuiltIns.m27012j();
        ClassConstructorDescriptor aH_ = j.aH_();
        if (aH_ == null) {
            Intrinsics.m26842a();
        }
        List k = aH_.mo7757k();
        ClassDescriptor b = kotlinBuiltIns2.m27003b(Name.m27424a("ReplaceWith"));
        ClassConstructorDescriptor aH_2 = b.aH_();
        if (aH_2 == null) {
            Intrinsics.m26842a();
        }
        List k2 = aH_2.mo7757k();
        KotlinType h = j.mo7714h();
        Pair[] pairArr = new Pair[3];
        Collection collection = k;
        pairArr[0] = TuplesKt.m26780a(m27108a(collection, "message"), new StringValue(str2, kotlinBuiltIns2));
        ValueParameterDescriptor a = m27108a(collection, "replaceWith");
        KotlinType h2 = b.mo7714h();
        r14 = new Pair[2];
        Collection collection2 = k2;
        r14[0] = TuplesKt.m26780a(m27108a(collection2, "expression"), new StringValue(str3, kotlinBuiltIns2));
        ValueParameterDescriptor a2 = m27108a(collection2, "imports");
        List a3 = CollectionsKt__CollectionsKt.m26790a();
        Object a4 = kotlinBuiltIns2.m27002a(Variance.f26337a, (KotlinType) kotlinBuiltIns.m27027y());
        Intrinsics.m26843a(a4, "getArrayType(Variance.INVARIANT, stringType)");
        r14[1] = TuplesKt.m26780a(a2, new ArrayValue(a3, (KotlinType) a4, kotlinBuiltIns2));
        pairArr[1] = TuplesKt.m26780a(a, new AnnotationValue(new AnnotationDescriptorImpl(h2, MapsKt__MapsKt.m36121a(r14), SourceElement.f25498a)));
        a = m27108a(collection, "level");
        ClassDescriptor a5 = KotlinBuiltIns.m26966a(kotlinBuiltIns2.m27003b(KotlinBuiltIns.f25420j.f25404y.m27412e()), str4);
        if (a5 == null) {
            StringBuilder stringBuilder = new StringBuilder("Deprecation level ");
            stringBuilder.append(str4);
            stringBuilder.append(" not found");
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        pairArr[2] = TuplesKt.m26780a(a, new EnumValue(a5));
        return new AnnotationDescriptorImpl(h, MapsKt__MapsKt.m36121a(pairArr), SourceElement.f25498a);
    }

    public static final AnnotationDescriptor m27109a(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "$receiver");
        return new AnnotationDescriptorImpl(kotlinBuiltIns.m26998a(KotlinBuiltIns.f25420j.f25362I).mo7714h(), MapsKt__MapsKt.m36116a(), SourceElement.f25498a);
    }

    private static final ValueParameterDescriptor m27108a(Collection<? extends ValueParameterDescriptor> collection, String str) {
        Object obj = null;
        Object obj2 = null;
        for (Object next : collection) {
            if (Intrinsics.m26845a(((ValueParameterDescriptor) next).mo6689i().m27429a(), (Object) str)) {
                if (obj2 != null) {
                    throw ((Throwable) new IllegalArgumentException("Collection contains more than one matching element."));
                }
                obj2 = 1;
                obj = next;
            }
        }
        if (obj2 != null) {
            return (ValueParameterDescriptor) obj;
        }
        throw ((Throwable) new NoSuchElementException("Collection contains no element matching the predicate."));
    }

    public static final boolean m27112a(MemberDescriptor memberDescriptor) {
        Intrinsics.m26847b(memberDescriptor, "$receiver");
        if (memberDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            if (!(m27111a(callableMemberDescriptor) || m27111a(DescriptorUtils.m27648b(callableMemberDescriptor)))) {
                Intrinsics.m26847b(memberDescriptor, "$receiver");
                if (memberDescriptor instanceof FunctionDescriptor) {
                    if (m27113b(callableMemberDescriptor) || m27113b(DescriptorUtils.m27648b(callableMemberDescriptor))) {
                        boolean b = ((FunctionDescriptor) memberDescriptor).mo7752b();
                        if (!_Assertions.f25274a || b) {
                            memberDescriptor = 1;
                            if (memberDescriptor == null) {
                                return true;
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder("Function is not inline: ");
                        stringBuilder.append(memberDescriptor);
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
                memberDescriptor = null;
                if (memberDescriptor == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static final boolean m27111a(CallableMemberDescriptor callableMemberDescriptor) {
        for (TypeParameterDescriptor l : callableMemberDescriptor.mo7735f()) {
            if (l.mo7717l()) {
                return true;
            }
        }
        return null;
    }

    private static final boolean m27113b(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.mo5718q().mo6682b(f25534a);
    }
}
