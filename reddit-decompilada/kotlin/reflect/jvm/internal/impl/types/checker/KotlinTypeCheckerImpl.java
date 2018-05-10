package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;

public class KotlinTypeCheckerImpl implements KotlinTypeChecker {
    private final TypeCheckingProcedure f33075b;

    public static KotlinTypeChecker m33619a(final TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality != null) {
            return new KotlinTypeCheckerImpl(new TypeCheckingProcedure(new TypeCheckerProcedureCallbacksImpl() {
                public final boolean mo5941a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                    if (typeConstructor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"constructor1", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1", "assertEqualTypeConstructors"}));
                    } else if (typeConstructor2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"constructor2", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1", "assertEqualTypeConstructors"}));
                    } else {
                        if (!typeConstructor.equals(typeConstructor2)) {
                            if (typeConstructorEquality.mo5914a(typeConstructor, typeConstructor2) == null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"equalityAxioms", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "withAxioms"}));
    }

    private KotlinTypeCheckerImpl(TypeCheckingProcedure typeCheckingProcedure) {
        this.f33075b = typeCheckingProcedure;
    }

    public final boolean mo5935a(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "isSubtypeOf"}));
        } else if (kotlinType2 != null) {
            return this.f33075b.m28052c(kotlinType, kotlinType2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "isSubtypeOf"}));
        }
    }

    public final boolean mo5936b(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "equalTypes"}));
        } else if (kotlinType2 != null) {
            return this.f33075b.m28051b(kotlinType, kotlinType2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "equalTypes"}));
        }
    }
}
