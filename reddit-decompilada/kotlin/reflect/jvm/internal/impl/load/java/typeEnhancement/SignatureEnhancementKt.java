package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancementKt {
    public static final <D extends CallableMemberDescriptor> Collection<D> m27269a(Collection<? extends D> collection) {
        Intrinsics.m26847b(collection, "platformSignatures");
        Iterable<CallableMemberDescriptor> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (CallableMemberDescriptor a : iterable) {
            arrayList.add(m27270a(a));
        }
        return (List) arrayList;
    }

    private static final <D extends CallableMemberDescriptor> D m27270a(D d) {
        if (!(d instanceof JavaCallableMemberDescriptor)) {
            return d;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
        boolean z = true;
        if (Intrinsics.m26845a(javaCallableMemberDescriptor.mo7760t(), Kind.FAKE_OVERRIDE) && javaCallableMemberDescriptor.mo7759s().mo7609m().size() == 1) {
            return d;
        }
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo2;
        Iterable<ValueParameterDescriptor> k;
        Collection arrayList;
        SignatureParts a;
        List list;
        TypeEnhancementInfo typeEnhancementInfo;
        List<PartEnhancementResult> list2;
        SignatureParts a2;
        TypeEnhancementInfo typeEnhancementInfo2;
        PartEnhancementResult a3;
        boolean z2;
        Collection collection;
        KotlinType kotlinType = null;
        PartEnhancementResult a4 = javaCallableMemberDescriptor.mo7755d() != null ? m27271a(d, false, C2973xf7c621fd.f38750a).m27273a(null) : null;
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) (!(d instanceof JavaMethodDescriptor) ? null : d);
        if (javaMethodDescriptor != null) {
            javaMethodDescriptor = javaMethodDescriptor;
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
            DeclarationDescriptor aD_ = javaMethodDescriptor.aD_();
            if (aD_ == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) aD_;
            String a5 = MethodSignatureMappingKt.m27351a((FunctionDescriptor) javaMethodDescriptor, true);
            Intrinsics.m26843a((Object) a5, "this.computeJvmDescriptor()");
            a5 = SignatureBuildingComponents.m27359a(classDescriptor, a5);
            if (a5 != null) {
                predefinedFunctionEnhancementInfo = (PredefinedFunctionEnhancementInfo) PredefinedEnhancementInfoKt.m27259a().get(a5);
                if (predefinedFunctionEnhancementInfo != null) {
                    predefinedFunctionEnhancementInfo2 = predefinedFunctionEnhancementInfo;
                    boolean z3 = predefinedFunctionEnhancementInfo2.f25757b.size() != javaCallableMemberDescriptor.mo7757k().size();
                    if (_Assertions.f25274a || z3) {
                        Unit unit = Unit.f25273a;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Predefined enhancement info for ");
                        stringBuilder.append(d);
                        stringBuilder.append(" has ");
                        stringBuilder.append(predefinedFunctionEnhancementInfo2.f25757b.size());
                        stringBuilder.append(", but ");
                        stringBuilder.append(javaCallableMemberDescriptor.mo7757k().size());
                        stringBuilder.append(" expected");
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
                k = javaCallableMemberDescriptor.mo7757k();
                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
                for (ValueParameterDescriptor valueParameterDescriptor : k) {
                    a = m27271a(d, false, new C2974x108cca0c(valueParameterDescriptor));
                    if (predefinedFunctionEnhancementInfo != null) {
                        list = predefinedFunctionEnhancementInfo.f25757b;
                        if (list != null) {
                            typeEnhancementInfo = (TypeEnhancementInfo) CollectionsKt___CollectionsKt.m41425c(list, valueParameterDescriptor.mo7801c());
                            arrayList.add(a.m27273a(typeEnhancementInfo));
                        }
                    }
                    typeEnhancementInfo = null;
                    arrayList.add(a.m27273a(typeEnhancementInfo));
                }
                list2 = (List) arrayList;
                a2 = m27271a(d, true, SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1.f38751a);
                if (predefinedFunctionEnhancementInfo == null) {
                    typeEnhancementInfo2 = predefinedFunctionEnhancementInfo.f25756a;
                } else {
                    typeEnhancementInfo2 = null;
                }
                a3 = a2.m27273a(typeEnhancementInfo2);
                if (a4 == null) {
                    z2 = a4.f25751b;
                } else {
                    z2 = false;
                }
                if (!(z2 || a3.f25751b)) {
                    for (PartEnhancementResult partEnhancementResult : list2) {
                        if (partEnhancementResult.f25751b) {
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        return d;
                    }
                }
                if (a4 != null) {
                    kotlinType = a4.f25750a;
                }
                Iterable<PartEnhancementResult> iterable = list2;
                collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (PartEnhancementResult partEnhancementResult2 : iterable) {
                    collection.add(partEnhancementResult2.f25750a);
                }
                d = javaCallableMemberDescriptor.mo7832a(kotlinType, (List) collection, a3.f25750a);
                if (d == null) {
                    return (CallableMemberDescriptor) d;
                }
                throw new TypeCastException("null cannot be cast to non-null type D");
            }
        }
        predefinedFunctionEnhancementInfo = null;
        if (predefinedFunctionEnhancementInfo != null) {
            predefinedFunctionEnhancementInfo2 = predefinedFunctionEnhancementInfo;
            if (predefinedFunctionEnhancementInfo2.f25757b.size() != javaCallableMemberDescriptor.mo7757k().size()) {
            }
            if (_Assertions.f25274a) {
            }
            Unit unit2 = Unit.f25273a;
        }
        k = javaCallableMemberDescriptor.mo7757k();
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
        for (ValueParameterDescriptor valueParameterDescriptor2 : k) {
            a = m27271a(d, false, new C2974x108cca0c(valueParameterDescriptor2));
            if (predefinedFunctionEnhancementInfo != null) {
                list = predefinedFunctionEnhancementInfo.f25757b;
                if (list != null) {
                    typeEnhancementInfo = (TypeEnhancementInfo) CollectionsKt___CollectionsKt.m41425c(list, valueParameterDescriptor2.mo7801c());
                    arrayList.add(a.m27273a(typeEnhancementInfo));
                }
            }
            typeEnhancementInfo = null;
            arrayList.add(a.m27273a(typeEnhancementInfo));
        }
        list2 = (List) arrayList;
        a2 = m27271a(d, true, SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1.f38751a);
        if (predefinedFunctionEnhancementInfo == null) {
            typeEnhancementInfo2 = null;
        } else {
            typeEnhancementInfo2 = predefinedFunctionEnhancementInfo.f25756a;
        }
        a3 = a2.m27273a(typeEnhancementInfo2);
        if (a4 == null) {
            z2 = false;
        } else {
            z2 = a4.f25751b;
        }
        while (r6.hasNext()) {
            if (partEnhancementResult.f25751b) {
                break;
            }
        }
        z = false;
        if (z) {
            return d;
        }
        if (a4 != null) {
            kotlinType = a4.f25750a;
        }
        Iterable<PartEnhancementResult> iterable2 = list2;
        collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        while (r1.hasNext()) {
            collection.add(partEnhancementResult2.f25750a);
        }
        d = javaCallableMemberDescriptor.mo7832a(kotlinType, (List) collection, a3.f25750a);
        if (d == null) {
            return (CallableMemberDescriptor) d;
        }
        throw new TypeCastException("null cannot be cast to non-null type D");
    }

    private static final <D extends CallableMemberDescriptor> SignatureParts m27271a(D d, boolean z, Function1<? super D, ? extends KotlinType> function1) {
        KotlinType kotlinType = (KotlinType) function1.mo6492a(d);
        Iterable<CallableMemberDescriptor> m = d.mo7609m();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(m));
        for (CallableMemberDescriptor callableMemberDescriptor : m) {
            if (callableMemberDescriptor == null) {
                throw new TypeCastException("null cannot be cast to non-null type D");
            }
            arrayList.add((KotlinType) function1.mo6492a(callableMemberDescriptor));
        }
        return new SignatureParts(kotlinType, (List) arrayList, z);
    }
}
