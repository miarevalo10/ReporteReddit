package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides f26051a = null;

    static {
        DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides = new DescriptorEquivalenceForOverrides();
    }

    private DescriptorEquivalenceForOverrides() {
        f26051a = this;
    }

    public final boolean m27626a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return Intrinsics.m26845a(((ClassDescriptor) declarationDescriptor).mo7610c(), ((ClassDescriptor) declarationDescriptor2).mo7610c());
        } else if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return m27624a((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, (Function2) DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.f38804a);
        } else {
            if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
                CallableDescriptor callableDescriptor = (CallableDescriptor) declarationDescriptor;
                CallableDescriptor callableDescriptor2 = (CallableDescriptor) declarationDescriptor2;
                Intrinsics.m26847b(callableDescriptor, "a");
                Intrinsics.m26847b(callableDescriptor2, "b");
                if (Intrinsics.m26845a((Object) callableDescriptor, (Object) callableDescriptor2)) {
                    return true;
                }
                if ((Intrinsics.m26845a(callableDescriptor.mo6689i(), callableDescriptor2.mo6689i()) ^ 1) == 0 && !Intrinsics.m26845a(callableDescriptor.aD_(), callableDescriptor2.aD_())) {
                    DeclarationDescriptor declarationDescriptor3 = callableDescriptor;
                    if (!DescriptorUtils.m27651b(declarationDescriptor3)) {
                        DeclarationDescriptor declarationDescriptor4 = callableDescriptor2;
                        if (!DescriptorUtils.m27651b(declarationDescriptor4)) {
                            if (m27623a(declarationDescriptor3, declarationDescriptor4, (Function2) C2983xc15c0bd8.f38802a)) {
                                OverridingUtil a = OverridingUtil.m27688a((TypeConstructorEquality) new C2581x10bda471(callableDescriptor, callableDescriptor2));
                                if (!Intrinsics.m26845a(a.m27706a(callableDescriptor, callableDescriptor2, null, true).m27679b(), Result.OVERRIDABLE) || Intrinsics.m26845a(a.m27706a(callableDescriptor2, callableDescriptor, null, true).m27679b(), Result.OVERRIDABLE) == null) {
                                    return false;
                                }
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return false;
            } else if ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) {
                return Intrinsics.m26845a(((PackageFragmentDescriptor) declarationDescriptor).mo7722d(), ((PackageFragmentDescriptor) declarationDescriptor2).mo7722d());
            } else {
                return Intrinsics.m26845a((Object) declarationDescriptor, (Object) declarationDescriptor2);
            }
        }
    }

    private final boolean m27624a(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        if (Intrinsics.m26845a((Object) typeParameterDescriptor, (Object) typeParameterDescriptor2)) {
            return true;
        }
        if (Intrinsics.m26845a(typeParameterDescriptor.aD_(), typeParameterDescriptor2.aD_()) || m27623a((DeclarationDescriptor) typeParameterDescriptor, (DeclarationDescriptor) typeParameterDescriptor2, (Function2) function2) == null || typeParameterDescriptor.mo7713g() != typeParameterDescriptor2.mo7713g()) {
            return false;
        }
        return true;
    }

    private final boolean m27623a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        declarationDescriptor = declarationDescriptor.aD_();
        declarationDescriptor2 = declarationDescriptor2.aD_();
        if (!(declarationDescriptor instanceof CallableMemberDescriptor)) {
            if (!(declarationDescriptor2 instanceof CallableMemberDescriptor)) {
                return m27626a(declarationDescriptor, declarationDescriptor2);
            }
        }
        return ((Boolean) function2.mo6497a(declarationDescriptor, declarationDescriptor2)).booleanValue();
    }
}
