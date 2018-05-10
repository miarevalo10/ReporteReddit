package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.Mutable;

public class OverridingUtil {
    public static final OverridingUtil f26084a = new OverridingUtil(new C25821());
    static final /* synthetic */ boolean f26085b = true;
    private static final List<ExternalOverridabilityCondition> f26086c = CollectionsKt___CollectionsKt.m41449n(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    private final TypeConstructorEquality f26087d;

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo f26081a = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result f26082b;
        private final String f26083c;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public static OverrideCompatibilityInfo m27676a() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = f26081a;
            if (overrideCompatibilityInfo != null) {
                return overrideCompatibilityInfo;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "success"}));
        }

        public static OverrideCompatibilityInfo m27677a(String str) {
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public static OverrideCompatibilityInfo m27678b(String str) {
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        private OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"success", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "<init>"}));
            } else if (str == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "<init>"}));
            } else {
                this.f26082b = result;
                this.f26083c = str;
            }
        }

        public final Result m27679b() {
            Result result = this.f26082b;
            if (result != null) {
                return result;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo", "getResult"}));
        }
    }

    static class C25821 implements TypeConstructorEquality {
        C25821() {
        }

        public final boolean mo5914a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1", "equals"}));
            } else if (typeConstructor2 != null) {
                return typeConstructor.equals(typeConstructor2);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1", "equals"}));
            }
        }
    }

    static class C27654 implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        C27654() {
        }

        public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
            return (CallableMemberDescriptor) obj;
        }
    }

    static class C27676 implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        C27676() {
        }

        public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
            return (CallableMemberDescriptor) obj;
        }
    }

    public static OverridingUtil m27688a(TypeConstructorEquality typeConstructorEquality) {
        return new OverridingUtil(typeConstructorEquality);
    }

    private OverridingUtil(TypeConstructorEquality typeConstructorEquality) {
        this.f26087d = typeConstructorEquality;
    }

    private static <D extends CallableDescriptor> Set<D> m27684a(Set<D> set) {
        Function1 a = FunctionsKt.m28105a();
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"transform", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterOverrides"}));
        } else if (set.size() <= 1) {
            return set;
        } else {
            Set<D> linkedHashSet = new LinkedHashSet();
            for (Object next : set) {
                CallableDescriptor callableDescriptor = (CallableDescriptor) a.mo6492a(next);
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    CallableDescriptor callableDescriptor2 = (CallableDescriptor) a.mo6492a(it.next());
                    if (!m27705c(callableDescriptor, callableDescriptor2)) {
                        if (m27705c(callableDescriptor2, callableDescriptor)) {
                            break;
                        }
                    } else {
                        it.remove();
                    }
                }
                linkedHashSet.add(next);
            }
            if (f26085b || !linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
            StringBuilder stringBuilder = new StringBuilder("All candidates filtered out from ");
            stringBuilder.append(set);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    private static <D extends CallableDescriptor> boolean m27705c(D d, D d2) {
        if (d == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"f", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "overrides"}));
        } else if (d2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"g", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "overrides"}));
        } else if (!d.equals(d2) && DescriptorEquivalenceForOverrides.f26051a.m27626a(d.aM_(), d2.aM_())) {
            return true;
        } else {
            d2 = d2.aM_();
            for (CallableDescriptor a : DescriptorUtils.m27635a((CallableDescriptor) d)) {
                if (DescriptorEquivalenceForOverrides.f26051a.m27626a(d2, a)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static void m27692a(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "collectOverriddenDeclarations"}));
        } else if (set == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "collectOverriddenDeclarations"}));
        } else if (callableMemberDescriptor.mo7760t().m27041a()) {
            set.add(callableMemberDescriptor);
        } else if (callableMemberDescriptor.mo7609m().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("No overridden descriptors found for (fake override) ");
            stringBuilder.append(callableMemberDescriptor);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            for (CallableMemberDescriptor a : callableMemberDescriptor.mo7609m()) {
                m27692a(a, (Set) set);
            }
        }
    }

    private OverrideCompatibilityInfo m27687a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
        } else {
            callableDescriptor = m27706a(callableDescriptor, callableDescriptor2, classDescriptor, false);
            if (callableDescriptor != null) {
                return callableDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
        }
    }

    public final OverrideCompatibilityInfo m27706a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
        } else {
            z = m27707a(callableDescriptor, callableDescriptor2, z);
            int i = z.m27679b() == Result.OVERRIDABLE ? 1 : 0;
            for (ExternalOverridabilityCondition externalOverridabilityCondition : f26086c) {
                if (externalOverridabilityCondition.mo5760a() != Contract.CONFLICTS_ONLY && (i == 0 || externalOverridabilityCondition.mo5760a() != Contract.SUCCESS_ONLY)) {
                    switch (externalOverridabilityCondition.mo5761a(callableDescriptor, callableDescriptor2, classDescriptor)) {
                        case OVERRIDABLE:
                            i = 1;
                            break;
                        case CONFLICT:
                            return OverrideCompatibilityInfo.m27678b("External condition failed");
                        case INCOMPATIBLE:
                            return OverrideCompatibilityInfo.m27677a("External condition");
                        default:
                            break;
                    }
                }
            }
            if (i != 0) {
                for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f26086c) {
                    if (externalOverridabilityCondition2.mo5760a() == Contract.CONFLICTS_ONLY) {
                        switch (externalOverridabilityCondition2.mo5761a(callableDescriptor, callableDescriptor2, classDescriptor)) {
                            case OVERRIDABLE:
                                callableDescriptor2 = new StringBuilder("Contract violation in ");
                                callableDescriptor2.append(externalOverridabilityCondition2.getClass().getName());
                                callableDescriptor2.append(" condition. It's not supposed to end with success");
                                throw new IllegalStateException(callableDescriptor2.toString());
                            case CONFLICT:
                                return OverrideCompatibilityInfo.m27678b("External condition failed");
                            case INCOMPATIBLE:
                                return OverrideCompatibilityInfo.m27677a("External condition");
                            default:
                                break;
                        }
                    }
                }
                callableDescriptor = OverrideCompatibilityInfo.m27676a();
                if (callableDescriptor != null) {
                    return callableDescriptor;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
            } else if (z) {
                return z;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableBy"}));
            }
        }
    }

    public final OverrideCompatibilityInfo m27707a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z) {
        int i = 0;
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"}));
        } else if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getBasicOverridabilityProblem"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getBasicOverridabilityProblem"}));
        } else {
            List a;
            List a2;
            List f;
            List f2;
            KotlinTypeChecker a3;
            int i2;
            int i3;
            boolean z2 = callableDescriptor instanceof FunctionDescriptor;
            OverrideCompatibilityInfo overrideCompatibilityInfo = null;
            if (!z2 || (callableDescriptor2 instanceof FunctionDescriptor)) {
                boolean z3 = callableDescriptor instanceof PropertyDescriptor;
                if (!z3 || (callableDescriptor2 instanceof PropertyDescriptor)) {
                    if (z2 || z3) {
                        if (callableDescriptor.mo6689i().equals(callableDescriptor2.mo6689i())) {
                            OverrideCompatibilityInfo a4;
                            if ((callableDescriptor.mo7755d() == null ? 1 : 0) != (callableDescriptor2.mo7755d() == null ? 1 : 0)) {
                                a4 = OverrideCompatibilityInfo.m27677a("Receiver presence mismatch");
                            } else if (callableDescriptor.mo7757k().size() != callableDescriptor2.mo7757k().size()) {
                                a4 = OverrideCompatibilityInfo.m27677a("Value parameter number mismatch");
                            } else {
                                a4 = null;
                            }
                            if (a4 != null) {
                                overrideCompatibilityInfo = a4;
                            }
                        } else {
                            overrideCompatibilityInfo = OverrideCompatibilityInfo.m27677a("Name mismatch");
                        }
                        if (overrideCompatibilityInfo != null) {
                            return overrideCompatibilityInfo;
                        }
                        a = m27683a(callableDescriptor);
                        a2 = m27683a(callableDescriptor2);
                        f = callableDescriptor.mo7735f();
                        f2 = callableDescriptor2.mo7735f();
                        if (f.size() == f2.size()) {
                            while (i < a.size()) {
                                if (KotlinTypeChecker.f26349a.mo5936b((KotlinType) a.get(i), (KotlinType) a2.get(i)) == null) {
                                    return OverrideCompatibilityInfo.m27677a("Type parameter number mismatch");
                                }
                                i++;
                            }
                            return OverrideCompatibilityInfo.m27678b("Type parameter number mismatch");
                        }
                        a3 = m27690a(f, f2);
                        for (i2 = 0; i2 < f.size(); i2++) {
                            if (!m27700a((TypeParameterDescriptor) f.get(i2), (TypeParameterDescriptor) f2.get(i2), a3)) {
                                return OverrideCompatibilityInfo.m27677a("Type parameter bounds mismatch");
                            }
                        }
                        for (i3 = 0; i3 < a.size(); i3++) {
                            if (!m27701a((KotlinType) a.get(i3), (KotlinType) a2.get(i3), a3)) {
                                return OverrideCompatibilityInfo.m27677a("Value parameter type mismatch");
                            }
                        }
                        if (!z2 && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).mo7747B() != ((FunctionDescriptor) callableDescriptor2).mo7747B()) {
                            return OverrideCompatibilityInfo.m27678b("Incompatible suspendability");
                        }
                        if (z) {
                            callableDescriptor = callableDescriptor.aN_();
                            callableDescriptor2 = callableDescriptor2.aN_();
                            if (!(callableDescriptor == null || callableDescriptor2 == null)) {
                                z = callableDescriptor2.mo6742d() && callableDescriptor.mo6742d();
                                if (!z && a3.mo5935a(callableDescriptor2, callableDescriptor) == null) {
                                    return OverrideCompatibilityInfo.m27678b("Return type mismatch");
                                }
                            }
                        }
                        callableDescriptor = OverrideCompatibilityInfo.m27676a();
                        if (callableDescriptor == null) {
                            return callableDescriptor;
                        }
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"}));
                    }
                    z = new StringBuilder("This type of CallableDescriptor cannot be checked for overridability: ");
                    z.append(callableDescriptor);
                    throw new IllegalArgumentException(z.toString());
                }
            }
            overrideCompatibilityInfo = OverrideCompatibilityInfo.m27677a("Member kind mismatch");
            if (overrideCompatibilityInfo != null) {
                return overrideCompatibilityInfo;
            }
            a = m27683a(callableDescriptor);
            a2 = m27683a(callableDescriptor2);
            f = callableDescriptor.mo7735f();
            f2 = callableDescriptor2.mo7735f();
            if (f.size() == f2.size()) {
                a3 = m27690a(f, f2);
                for (i2 = 0; i2 < f.size(); i2++) {
                    if (!m27700a((TypeParameterDescriptor) f.get(i2), (TypeParameterDescriptor) f2.get(i2), a3)) {
                        return OverrideCompatibilityInfo.m27677a("Type parameter bounds mismatch");
                    }
                }
                for (i3 = 0; i3 < a.size(); i3++) {
                    if (!m27701a((KotlinType) a.get(i3), (KotlinType) a2.get(i3), a3)) {
                        return OverrideCompatibilityInfo.m27677a("Value parameter type mismatch");
                    }
                }
                if (!z2) {
                }
                if (z) {
                    callableDescriptor = callableDescriptor.aN_();
                    callableDescriptor2 = callableDescriptor2.aN_();
                    if (!callableDescriptor2.mo6742d()) {
                    }
                    return OverrideCompatibilityInfo.m27678b("Return type mismatch");
                }
                callableDescriptor = OverrideCompatibilityInfo.m27676a();
                if (callableDescriptor == null) {
                    return callableDescriptor;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isOverridableByWithoutExternalConditions"}));
            }
            while (i < a.size()) {
                if (KotlinTypeChecker.f26349a.mo5936b((KotlinType) a.get(i), (KotlinType) a2.get(i)) == null) {
                    return OverrideCompatibilityInfo.m27677a("Type parameter number mismatch");
                }
                i++;
            }
            return OverrideCompatibilityInfo.m27678b("Type parameter number mismatch");
        }
    }

    private KotlinTypeChecker m27690a(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        int i = 0;
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"firstParameters", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"}));
        } else if (list2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"secondParameters", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createTypeChecker"}));
        } else if (!f26085b && list.size() != list2.size()) {
            StringBuilder stringBuilder = new StringBuilder("Should be the same number of type parameters: ");
            stringBuilder.append(list);
            stringBuilder.append(" vs ");
            stringBuilder.append(list2);
            throw new AssertionError(stringBuilder.toString());
        } else if (list.isEmpty()) {
            return KotlinTypeCheckerImpl.m33619a(this.f26087d);
        } else {
            final Map hashMap = new HashMap();
            while (i < list.size()) {
                hashMap.put(((TypeParameterDescriptor) list.get(i)).mo7610c(), ((TypeParameterDescriptor) list2.get(i)).mo7610c());
                i++;
            }
            return KotlinTypeCheckerImpl.m33619a(new TypeConstructorEquality(this) {
                final /* synthetic */ OverridingUtil f32933b;

                public final boolean mo5914a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                    if (typeConstructor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$2", "equals"}));
                    } else if (typeConstructor2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$2", "equals"}));
                    } else if (this.f32933b.f26087d.mo5914a(typeConstructor, typeConstructor2)) {
                        return true;
                    } else {
                        TypeConstructor typeConstructor3 = (TypeConstructor) hashMap.get(typeConstructor);
                        TypeConstructor typeConstructor4 = (TypeConstructor) hashMap.get(typeConstructor2);
                        return ((typeConstructor3 == null || typeConstructor3.equals(typeConstructor2) == null) && (typeConstructor4 == null || typeConstructor4.equals(typeConstructor) == null)) ? false : true;
                    }
                }
            });
        }
    }

    private static boolean m27701a(KotlinType kotlinType, KotlinType kotlinType2, KotlinTypeChecker kotlinTypeChecker) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeInSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeInSub", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"}));
        } else if (kotlinTypeChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeChecker", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypesEquivalent"}));
        } else {
            boolean z = kotlinType.mo6742d() && kotlinType2.mo6742d();
            if (!z) {
                if (kotlinTypeChecker.mo5936b(kotlinType, kotlinType2) == null) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean m27700a(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, KotlinTypeChecker kotlinTypeChecker) {
        if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superTypeParameter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"}));
        } else if (typeParameterDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subTypeParameter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"}));
        } else if (kotlinTypeChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeChecker", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "areTypeParametersEquivalent"}));
        } else {
            TypeParameterDescriptor<KotlinType> j = typeParameterDescriptor.mo7715j();
            List arrayList = new ArrayList(typeParameterDescriptor2.mo7715j());
            if (j.size() != arrayList.size()) {
                return false;
            }
            for (KotlinType kotlinType : j) {
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    if (m27701a(kotlinType, (KotlinType) listIterator.next(), kotlinTypeChecker)) {
                        listIterator.remove();
                    }
                }
                return false;
            }
            return true;
        }
    }

    private static List<KotlinType> m27683a(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor d = callableDescriptor.mo7755d();
        List<KotlinType> arrayList = new ArrayList();
        if (d != null) {
            arrayList.add(d.mo7777x());
        }
        for (ValueParameterDescriptor x : callableDescriptor.mo7757k()) {
            arrayList.add(x.mo7777x());
        }
        return arrayList;
    }

    public static void m27695a(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"}));
        } else if (collection2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromCurrent", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "generateOverridesInFunctionGroup"}));
        } else {
            Collection linkedHashSet = new LinkedHashSet(collection);
            for (CallableMemberDescriptor a : collection2) {
                linkedHashSet.removeAll(m27682a(a, (Collection) collection, classDescriptor, overridingStrategy));
            }
            m27694a(classDescriptor, linkedHashSet, overridingStrategy);
        }
    }

    private static Collection<CallableMemberDescriptor> m27682a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromCurrent", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptorsFromSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"}));
        } else if (overridingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractAndBindOverridesForMember"}));
        } else {
            Collection<CallableMemberDescriptor> arrayList = new ArrayList(collection.size());
            Collection b = SmartSet.m28120b();
            for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility : collection) {
                Result b2 = f26084a.m27687a((CallableDescriptor) declarationDescriptorWithVisibility, (CallableDescriptor) callableMemberDescriptor, classDescriptor).m27679b();
                if (callableMemberDescriptor != null) {
                    if (declarationDescriptorWithVisibility != null) {
                        int i = (Visibilities.m27096a(declarationDescriptorWithVisibility.mo7257j()) || !Visibilities.m27095a(declarationDescriptorWithVisibility, (DeclarationDescriptor) callableMemberDescriptor)) ? 0 : 1;
                        switch (b2) {
                            case OVERRIDABLE:
                                if (i != 0) {
                                    b.add(declarationDescriptorWithVisibility);
                                }
                                arrayList.add(declarationDescriptorWithVisibility);
                                break;
                            case CONFLICT:
                                if (i != 0) {
                                    overridingStrategy.mo5915b(declarationDescriptorWithVisibility, callableMemberDescriptor);
                                }
                                arrayList.add(declarationDescriptorWithVisibility);
                                break;
                            default:
                                break;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromSuper", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibleForOverride"}));
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overriding", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibleForOverride"}));
            }
            overridingStrategy.mo6692a(callableMemberDescriptor, b);
            return arrayList;
        }
    }

    public static boolean m27697a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecific"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecific"}));
        } else {
            KotlinType aN_ = callableDescriptor.aN_();
            KotlinType aN_2 = callableDescriptor2.aN_();
            StringBuilder stringBuilder;
            if (!f26085b && aN_ == null) {
                stringBuilder = new StringBuilder("Return type of ");
                stringBuilder.append(callableDescriptor);
                stringBuilder.append(" is null");
                throw new AssertionError(stringBuilder.toString());
            } else if (!f26085b && aN_2 == null) {
                stringBuilder = new StringBuilder("Return type of ");
                stringBuilder.append(callableDescriptor2);
                stringBuilder.append(" is null");
                throw new AssertionError(stringBuilder.toString());
            } else if (!m27699a((DeclarationDescriptorWithVisibility) callableDescriptor, (DeclarationDescriptorWithVisibility) callableDescriptor2)) {
                return false;
            } else {
                if (callableDescriptor instanceof SimpleFunctionDescriptor) {
                    if (f26085b || (callableDescriptor2 instanceof SimpleFunctionDescriptor)) {
                        return m27698a(callableDescriptor, aN_, callableDescriptor2, aN_2);
                    }
                    stringBuilder = new StringBuilder("b is ");
                    stringBuilder.append(callableDescriptor2.getClass());
                    throw new AssertionError(stringBuilder.toString());
                } else if (!(callableDescriptor instanceof PropertyDescriptor)) {
                    stringBuilder = new StringBuilder("Unexpected callable: ");
                    stringBuilder.append(callableDescriptor.getClass());
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (f26085b || (callableDescriptor2 instanceof PropertyDescriptor)) {
                    boolean a;
                    PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
                    PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
                    DeclarationDescriptorWithVisibility c = propertyDescriptor.mo7827c();
                    DeclarationDescriptorWithVisibility c2 = propertyDescriptor2.mo7827c();
                    if (c != null) {
                        if (c2 != null) {
                            a = m27699a(c, c2);
                            if (!a) {
                                return false;
                            }
                            if (propertyDescriptor.mo7807y() || !propertyDescriptor2.mo7807y()) {
                                return (propertyDescriptor.mo7807y() || !propertyDescriptor2.mo7807y()) && m27698a(callableDescriptor, aN_, callableDescriptor2, aN_2) != null;
                            } else {
                                return f26084a.m27690a(callableDescriptor.mo7735f(), callableDescriptor2.mo7735f()).mo5936b(aN_, aN_2);
                            }
                        }
                    }
                    a = true;
                    if (!a) {
                        return false;
                    }
                    if (propertyDescriptor.mo7807y()) {
                    }
                    if (!propertyDescriptor.mo7807y()) {
                    }
                } else {
                    stringBuilder = new StringBuilder("b is ");
                    stringBuilder.append(callableDescriptor2.getClass());
                    throw new AssertionError(stringBuilder.toString());
                }
            }
        }
    }

    private static boolean m27699a(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibilityMoreSpecific"}));
        } else if (declarationDescriptorWithVisibility2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isVisibilityMoreSpecific"}));
        } else {
            declarationDescriptorWithVisibility = Visibilities.m27097b(declarationDescriptorWithVisibility.mo7257j(), declarationDescriptorWithVisibility2.mo7257j());
            if (declarationDescriptorWithVisibility != null) {
                if (declarationDescriptorWithVisibility.intValue() < null) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean m27696a(CallableDescriptor callableDescriptor, Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"candidate", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecificThenAllOf"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isMoreSpecificThenAllOf"}));
        } else {
            for (CallableDescriptor a : collection) {
                if (!m27697a(callableDescriptor, a)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean m27698a(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"aReturnType", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"}));
        } else if (callableDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"}));
        } else if (kotlinType2 != null) {
            return f26084a.m27690a(callableDescriptor.mo7735f(), callableDescriptor2.mo7735f()).mo5935a(kotlinType, kotlinType2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"bReturnType", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "isReturnTypeMoreSpecific"}));
        }
    }

    public static <H> H m27680a(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overridables", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
        } else if (function1 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptorByHandle", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
        } else if (!f26085b && collection.isEmpty()) {
            throw new AssertionError("Should have at least one overridable descriptor");
        } else if (collection.size() == 1) {
            collection = CollectionsKt___CollectionsKt.m41429d((Iterable) collection);
            if (collection != null) {
                return collection;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
        } else {
            Iterable arrayList = new ArrayList(2);
            Collection d = CollectionsKt___CollectionsKt.m41431d((Iterable) collection, (Function1) function1);
            H d2 = CollectionsKt___CollectionsKt.m41429d((Iterable) collection);
            CallableDescriptor callableDescriptor = (CallableDescriptor) function1.mo6492a(d2);
            for (H next : collection) {
                CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.mo6492a(next);
                if (m27696a(callableDescriptor2, d)) {
                    arrayList.add(next);
                }
                if (m27697a(callableDescriptor2, callableDescriptor) && !m27697a(callableDescriptor, callableDescriptor2)) {
                    d2 = next;
                }
            }
            if (arrayList.isEmpty() != null) {
                if (d2 != null) {
                    return d2;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
            } else if (arrayList.size() == 1) {
                collection = CollectionsKt___CollectionsKt.m41429d(arrayList);
                if (collection != null) {
                    return collection;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
            } else {
                collection = null;
                for (Collection<H> next2 : arrayList) {
                    if (!FlexibleTypesKt.m27946a(((CallableDescriptor) function1.mo6492a(next2)).aN_())) {
                        collection = next2;
                        break;
                    }
                }
                if (collection == null) {
                    collection = CollectionsKt___CollectionsKt.m41429d(arrayList);
                    if (collection != null) {
                        return collection;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
                } else if (collection != null) {
                    return collection;
                } else {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "selectMostSpecificMember"}));
                }
            }
        }
    }

    private static void m27691a(Collection<CallableMemberDescriptor> collection, final ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overridables", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"}));
        } else if (overridingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverride"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterVisibleFakeOverrides"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"toFilter", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "filterVisibleFakeOverrides"}));
        } else {
            Collection collection2;
            Collection<CallableMemberDescriptor> c = CollectionsKt___CollectionsKt.m41427c((Iterable) collection, new Function1<CallableMemberDescriptor, Boolean>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility = (CallableMemberDescriptor) obj;
                    obj = (Visibilities.m27096a(declarationDescriptorWithVisibility.mo7257j()) || Visibilities.m27095a(declarationDescriptorWithVisibility, classDescriptor) == null) ? null : true;
                    return Boolean.valueOf(obj);
                }
            });
            boolean isEmpty = c.isEmpty();
            if (!isEmpty) {
                collection2 = c;
            }
            classDescriptor = ((CallableMemberDescriptor) m27680a(collection2, new C27654())).mo7748a(classDescriptor, m27685a(collection2), isEmpty ? Visibilities.f25511h : Visibilities.f25510g, Kind.FAKE_OVERRIDE);
            overridingStrategy.mo6692a(classDescriptor, collection2);
            if (f26085b != null || classDescriptor.mo7609m().isEmpty() == null) {
                overridingStrategy.mo6690a(classDescriptor);
                return;
            }
            classDescriptor = new StringBuilder("Overridden descriptors should be set for ");
            classDescriptor.append(Kind.FAKE_OVERRIDE);
            throw new AssertionError(classDescriptor.toString());
        }
    }

    private static Modality m27685a(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"}));
        }
        int i = 0;
        int i2 = i;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            switch (callableMemberDescriptor.aG_()) {
                case f25488a:
                    collection = Modality.f25488a;
                    if (collection != null) {
                        return collection;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"}));
                case f25489b:
                    StringBuilder stringBuilder = new StringBuilder("Member cannot have SEALED modality: ");
                    stringBuilder.append(callableMemberDescriptor);
                    throw new IllegalStateException(stringBuilder.toString());
                case f25490c:
                    i = 1;
                    break;
                case f25491d:
                    i2 = 1;
                    break;
                default:
                    break;
            }
        }
        if (i != 0 && r6 == 0) {
            collection = Modality.f25490c;
            if (collection != null) {
                return collection;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"}));
        } else if (i != 0 || r6 == 0) {
            Set hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                if (callableMemberDescriptor2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getOverriddenDeclarations"}));
                }
                Set linkedHashSet = new LinkedHashSet();
                m27692a(callableMemberDescriptor2, linkedHashSet);
                hashSet.addAll(linkedHashSet);
            }
            collection = m27702b(m27684a(hashSet));
            if (collection != null) {
                return collection;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"}));
        } else {
            collection = Modality.f25491d;
            if (collection != null) {
                return collection;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "determineModality"}));
        }
    }

    private static Modality m27702b(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getMinimalModality"}));
        }
        Enum enumR = Modality.f25491d;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            if (callableMemberDescriptor.aG_().compareTo(enumR) < 0) {
                enumR = callableMemberDescriptor.aG_();
            }
        }
        if (enumR != null) {
            return enumR;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "getMinimalModality"}));
    }

    public static <H> Collection<H> m27681a(H h, @Mutable Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overrider", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"}));
        } else if (function1 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptorByHandle", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"}));
        } else {
            Collection<H> arrayList = new ArrayList();
            arrayList.add(h);
            CallableDescriptor callableDescriptor = (CallableDescriptor) function1.mo6492a(h);
            collection = collection.iterator();
            while (collection.hasNext()) {
                H next = collection.next();
                CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.mo6492a(next);
                if (h == next) {
                    collection.remove();
                } else {
                    Result b = m27703b(callableDescriptor, callableDescriptor2);
                    if (b == Result.OVERRIDABLE) {
                        arrayList.add(next);
                        collection.remove();
                    } else if (b == Result.CONFLICT) {
                        function12.mo6492a(next);
                        collection.remove();
                    }
                }
            }
            return arrayList;
        }
    }

    public static Result m27703b(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        Result b = f26084a.m27687a(callableDescriptor2, callableDescriptor, null).m27679b();
        callableDescriptor = f26084a.m27687a(callableDescriptor, callableDescriptor2, null).m27679b();
        if (b == Result.OVERRIDABLE && callableDescriptor == Result.OVERRIDABLE) {
            return Result.OVERRIDABLE;
        }
        if (b != Result.CONFLICT) {
            if (callableDescriptor != Result.CONFLICT) {
                return Result.INCOMPATIBLE;
            }
        }
        return Result.CONFLICT;
    }

    public static void m27693a(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        if (callableMemberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"memberDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "resolveUnknownVisibilityForMember"}));
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.mo7609m()) {
            if (callableMemberDescriptor2.mo7257j() == Visibilities.f25510g) {
                m27693a(callableMemberDescriptor2, (Function1) function1);
            }
        }
        if (callableMemberDescriptor.mo7257j() == Visibilities.f25510g) {
            Visibility visibility;
            Visibility a = m27686a(callableMemberDescriptor);
            if (a == null) {
                if (function1 != null) {
                    function1.mo6492a(callableMemberDescriptor);
                }
                visibility = Visibilities.f25508e;
            } else {
                visibility = a;
            }
            if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
                PropertyDescriptorImpl propertyDescriptorImpl = (PropertyDescriptorImpl) callableMemberDescriptor;
                if (visibility == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setVisibility"}));
                }
                propertyDescriptorImpl.f40934a = visibility;
                for (CallableMemberDescriptor a2 : ((PropertyDescriptor) callableMemberDescriptor).mo7828u()) {
                    m27693a(a2, a == null ? null : function1);
                }
            } else if ((callableMemberDescriptor instanceof FunctionDescriptorImpl) != null) {
                FunctionDescriptorImpl functionDescriptorImpl = (FunctionDescriptorImpl) callableMemberDescriptor;
                if (visibility == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl", "setVisibility"}));
                }
                functionDescriptorImpl.f40766d = visibility;
            } else if (f26085b == null && (callableMemberDescriptor instanceof PropertyAccessorDescriptorImpl) == null) {
                throw new AssertionError();
            } else {
                ((PropertyAccessorDescriptorImpl) callableMemberDescriptor).f40929d = visibility;
            }
        }
    }

    private static Visibility m27686a(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"memberDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "computeVisibilityToInherit"}));
        }
        Collection<CallableMemberDescriptor> m = callableMemberDescriptor.mo7609m();
        Visibility c = m27704c(m);
        if (c == null) {
            return null;
        }
        if (callableMemberDescriptor.mo7760t() != Kind.FAKE_OVERRIDE) {
            return c.mo5763b();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : m) {
            if (callableMemberDescriptor2.aG_() != Modality.f25491d && !callableMemberDescriptor2.mo7257j().equals(c)) {
                return null;
            }
        }
        return c;
    }

    private static Visibility m27704c(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptors", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "findMaxVisibility"}));
        } else if (collection.isEmpty()) {
            return Visibilities.f25514k;
        } else {
            Visibility visibility;
            loop0:
            while (true) {
                visibility = null;
                for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                    Visibility j = callableMemberDescriptor.mo7257j();
                    if (f26085b || j != Visibilities.f25510g) {
                        if (visibility != null) {
                            Integer b = Visibilities.m27097b(j, visibility);
                            if (b != null) {
                                if (b.intValue() > 0) {
                                }
                            }
                        }
                        visibility = j;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Visibility should have been computed for ");
                        stringBuilder.append(callableMemberDescriptor);
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
                break loop0;
            }
            if (visibility == null) {
                return null;
            }
            for (CallableMemberDescriptor j2 : collection) {
                Integer b2 = Visibilities.m27097b(visibility, j2.mo7257j());
                if (b2 != null) {
                    if (b2.intValue() < 0) {
                    }
                }
                return null;
            }
            return visibility;
        }
    }

    private static void m27694a(ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection, final OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverrides"}));
        } else if (overridingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "createAndBindFakeOverrides"}));
        } else {
            boolean z;
            if (collection.size() < 2) {
                z = true;
            } else {
                final DeclarationDescriptor aD_ = ((CallableMemberDescriptor) collection.iterator().next()).aD_();
                z = CollectionsKt___CollectionsKt.m41435e(collection, new Function1<CallableMemberDescriptor, Boolean>() {
                    public final /* synthetic */ Object mo6492a(Object obj) {
                        return Boolean.valueOf(((CallableMemberDescriptor) obj).aD_() == aD_ ? true : null);
                    }
                });
            }
            if (z) {
                for (CallableMemberDescriptor singleton : collection) {
                    m27691a(Collections.singleton(singleton), classDescriptor, overridingStrategy);
                }
                return;
            }
            Collection linkedList = new LinkedList(collection);
            while (linkedList.isEmpty() == null) {
                final Object a = VisibilityUtilKt.m27709a(linkedList);
                if (a == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overrider", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"}));
                } else if (overridingStrategy == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"strategy", "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil", "extractMembersOverridableInBothWays"}));
                } else {
                    m27691a(m27681a(a, linkedList, new C27676(), new Function1<CallableMemberDescriptor, Unit>() {
                        public final /* synthetic */ Object mo6492a(Object obj) {
                            overridingStrategy.mo5916c(a, (CallableMemberDescriptor) obj);
                            return Unit.f25273a;
                        }
                    }), classDescriptor, overridingStrategy);
                }
            }
        }
    }
}
