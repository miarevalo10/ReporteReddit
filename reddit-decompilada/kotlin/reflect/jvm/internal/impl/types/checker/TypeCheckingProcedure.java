package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class TypeCheckingProcedure {
    static final /* synthetic */ boolean f26366a = true;
    private final TypeCheckingProcedureCallbacks f26367b;

    public enum EnrichedProjectionKind {
        f26361a,
        OUT,
        INV,
        STAR;

        public static EnrichedProjectionKind m28042a(Variance variance) {
            if (variance == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"}));
            }
            switch (variance) {
                case f26337a:
                    variance = INV;
                    if (variance != null) {
                        return variance;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"}));
                case f26338b:
                    variance = f26361a;
                    if (variance != null) {
                        return variance;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"}));
                case f26339c:
                    variance = OUT;
                    if (variance != null) {
                        return variance;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"}));
                default:
                    throw new IllegalStateException("Unknown variance");
            }
        }
    }

    public static KotlinType m28043a(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"}));
        } else if (kotlinType2 != null) {
            return m28044a(kotlinType, kotlinType2, new TypeCheckerProcedureCallbacksImpl());
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"}));
        }
    }

    private static KotlinType m28044a(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"}));
        } else if (typeCheckingProcedureCallbacks != null) {
            return UtilsKt.m28059a(kotlinType, kotlinType2, typeCheckingProcedureCallbacks);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeCheckingProcedureCallbacks", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"}));
        }
    }

    private static KotlinType m28047b(TypeParameterDescriptor typeParameterDescriptor, TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"}));
        } else if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"argument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"}));
        } else {
            int i;
            if (typeProjection.mo6735b() != Variance.f26338b) {
                if (typeParameterDescriptor.mo7716k() != Variance.f26338b) {
                    i = 0;
                    typeParameterDescriptor = i == 0 ? DescriptorUtilsKt.m27745d(typeParameterDescriptor).m27016n() : typeProjection.mo6736c();
                    if (typeParameterDescriptor == null) {
                        return typeParameterDescriptor;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"}));
                }
            }
            i = 1;
            if (i == 0) {
            }
            if (typeParameterDescriptor == null) {
                return typeParameterDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"}));
        }
    }

    private static KotlinType m28048c(TypeParameterDescriptor typeParameterDescriptor, TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"}));
        } else if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"argument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"}));
        } else {
            int i;
            if (typeProjection.mo6735b() != Variance.f26339c) {
                if (typeParameterDescriptor.mo7716k() != Variance.f26339c) {
                    i = 0;
                    typeParameterDescriptor = i == 0 ? DescriptorUtilsKt.m27745d(typeParameterDescriptor).m27014l() : typeProjection.mo6736c();
                    if (typeParameterDescriptor == null) {
                        return typeParameterDescriptor;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"}));
                }
            }
            i = 1;
            if (i == 0) {
            }
            if (typeParameterDescriptor == null) {
                return typeParameterDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"}));
        }
    }

    public TypeCheckingProcedure(TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        this.f26367b = typeCheckingProcedureCallbacks;
    }

    public final boolean m28051b(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type1", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "equalTypes"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type2", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "equalTypes"}));
        } else if (kotlinType == kotlinType2) {
            return true;
        } else {
            if (FlexibleTypesKt.m27946a(kotlinType)) {
                if (FlexibleTypesKt.m27946a(kotlinType2)) {
                    return (kotlinType.mo6742d() || kotlinType2.mo6742d() || !m28052c(kotlinType, kotlinType2) || m28052c(kotlinType2, kotlinType) == null) ? false : true;
                } else {
                    return m28049d(kotlinType2, kotlinType);
                }
            } else if (FlexibleTypesKt.m27946a(kotlinType2)) {
                return m28049d(kotlinType, kotlinType2);
            } else {
                if (kotlinType.mo6741c() != kotlinType2.mo6741c()) {
                    return false;
                }
                if (kotlinType.mo6741c()) {
                    return this.f26367b.mo5939a(TypeUtils.m28014c(kotlinType), TypeUtils.m28014c(kotlinType2), this);
                }
                TypeConstructor g = kotlinType.mo6743g();
                TypeConstructor g2 = kotlinType2.mo6743g();
                if (!this.f26367b.mo5941a(g, g2)) {
                    return false;
                }
                kotlinType = kotlinType.mo6739a();
                kotlinType2 = kotlinType2.mo6739a();
                if (kotlinType.size() != kotlinType2.size()) {
                    return false;
                }
                for (int i = 0; i < kotlinType.size(); i++) {
                    TypeProjection typeProjection = (TypeProjection) kotlinType.get(i);
                    TypeProjection typeProjection2 = (TypeProjection) kotlinType2.get(i);
                    if (!typeProjection.mo6734a() || !typeProjection2.mo6734a()) {
                        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) g.mo5723b().get(i);
                        TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) g2.mo5723b().get(i);
                        if (!(m28046a(typeProjection, typeProjection2, typeParameterDescriptor) || (m28045a(typeParameterDescriptor, typeProjection) == m28045a(typeParameterDescriptor2, typeProjection2) && this.f26367b.mo5939a(typeProjection.mo6736c(), typeProjection2.mo6736c(), this)))) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }

    private boolean m28049d(KotlinType kotlinType, KotlinType kotlinType2) {
        if (f26366a || !FlexibleTypesKt.m27946a(kotlinType)) {
            return (!m28052c(FlexibleTypesKt.m27947b(kotlinType2).f38926a, kotlinType) || m28052c(kotlinType, FlexibleTypesKt.m27947b(kotlinType2).f38927b) == null) ? null : true;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Only inflexible types are allowed here: ");
            stringBuilder.append(kotlinType);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public static EnrichedProjectionKind m28045a(TypeParameterDescriptor typeParameterDescriptor, TypeProjection typeProjection) {
        if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameter", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getEffectiveProjectionKind"}));
        } else if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeArgument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getEffectiveProjectionKind"}));
        } else {
            typeParameterDescriptor = typeParameterDescriptor.mo7716k();
            typeProjection = typeProjection.mo6735b();
            if (typeProjection == Variance.f26337a) {
                TypeProjection typeProjection2 = typeProjection;
                typeProjection = typeParameterDescriptor;
                typeParameterDescriptor = typeProjection2;
            }
            if (typeParameterDescriptor == Variance.f26338b && typeProjection == Variance.f26339c) {
                return EnrichedProjectionKind.STAR;
            }
            if (typeParameterDescriptor == Variance.f26339c && typeProjection == Variance.f26338b) {
                return EnrichedProjectionKind.STAR;
            }
            return EnrichedProjectionKind.m28042a(typeProjection);
        }
    }

    public final boolean m28052c(KotlinType kotlinType, KotlinType kotlinType2) {
        while (kotlinType != null) {
            if (kotlinType2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "isSubtypeOf"}));
            } else if (TypeCapabilitiesKt.m27961a(kotlinType, kotlinType2)) {
                if (kotlinType.mo6741c() != null) {
                    if (kotlinType2.mo6741c() == null) {
                        return false;
                    }
                }
                return true;
            } else {
                KotlinType c = TypeCapabilitiesKt.m27963c(kotlinType);
                KotlinType d = TypeCapabilitiesKt.m27964d(kotlinType2);
                if (c == kotlinType) {
                    if (d == kotlinType2) {
                        if (!kotlinType.mo6742d()) {
                            if (!kotlinType2.mo6742d()) {
                                if (!kotlinType2.mo6741c() && kotlinType.mo6741c()) {
                                    return false;
                                }
                                if (KotlinBuiltIns.m26990f(kotlinType)) {
                                    return true;
                                }
                                c = m28044a(kotlinType, kotlinType2, this.f26367b);
                                if (c == null) {
                                    return this.f26367b.mo5938a(kotlinType, kotlinType2);
                                }
                                if (kotlinType2.mo6741c() != null || c.mo6741c() == null) {
                                    return m28050e(c, kotlinType2);
                                }
                                return false;
                            }
                        }
                        return true;
                    }
                }
                kotlinType = c;
                kotlinType2 = d;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "isSubtypeOf"}));
    }

    private boolean m28050e(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "checkSubtypeForTheSameConstructor"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "checkSubtypeForTheSameConstructor"}));
        } else {
            TypeConstructor g = kotlinType.mo6743g();
            kotlinType = kotlinType.mo6739a();
            kotlinType2 = kotlinType2.mo6739a();
            if (kotlinType.size() != kotlinType2.size()) {
                return false;
            }
            List b = g.mo5723b();
            for (int i = 0; i < b.size(); i++) {
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) b.get(i);
                TypeProjection typeProjection = (TypeProjection) kotlinType2.get(i);
                TypeProjection typeProjection2 = (TypeProjection) kotlinType.get(i);
                if (!(typeProjection.mo6734a() || m28046a(typeProjection2, typeProjection, typeParameterDescriptor))) {
                    boolean z;
                    KotlinType b2;
                    KotlinType c;
                    if (!typeProjection2.mo6736c().mo6742d()) {
                        if (!typeProjection.mo6736c().mo6742d()) {
                            z = false;
                            if (z || typeParameterDescriptor.mo7716k() != Variance.f26337a || typeProjection2.mo6735b() != Variance.f26337a || typeProjection.mo6735b() != Variance.f26337a) {
                                b2 = m28047b(typeParameterDescriptor, typeProjection);
                                if (!this.f26367b.mo5942b(m28047b(typeParameterDescriptor, typeProjection2), b2, this)) {
                                    return false;
                                }
                                b2 = m28048c(typeParameterDescriptor, typeProjection);
                                c = m28048c(typeParameterDescriptor, typeProjection2);
                                if (typeProjection.mo6735b() == Variance.f26339c) {
                                    if (!this.f26367b.mo5942b(b2, c, this)) {
                                        return false;
                                    }
                                } else if (!(f26366a || KotlinBuiltIns.m26989e(b2))) {
                                    throw new AssertionError("In component must be Nothing for out-projection");
                                }
                            } else if (!this.f26367b.mo5939a(typeProjection2.mo6736c(), typeProjection.mo6736c(), this)) {
                                return false;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    b2 = m28047b(typeParameterDescriptor, typeProjection);
                    if (!this.f26367b.mo5942b(m28047b(typeParameterDescriptor, typeProjection2), b2, this)) {
                        return false;
                    }
                    b2 = m28048c(typeParameterDescriptor, typeProjection);
                    c = m28048c(typeParameterDescriptor, typeProjection2);
                    if (typeProjection.mo6735b() == Variance.f26339c) {
                        throw new AssertionError("In component must be Nothing for out-projection");
                    } else if (!this.f26367b.mo5942b(b2, c, this)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private boolean m28046a(TypeProjection typeProjection, TypeProjection typeProjection2, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtypeArgumentProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"}));
        } else if (typeProjection2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypeArgumentProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"}));
        } else if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"}));
        } else if (typeParameterDescriptor.mo7716k() == Variance.f26337a && typeProjection.mo6735b() != Variance.f26337a && typeProjection2.mo6735b() == Variance.f26337a) {
            return this.f26367b.mo5940a(typeProjection2.mo6736c(), typeProjection);
        } else {
            return false;
        }
    }
}
