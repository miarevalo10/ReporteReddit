package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

class TypeCheckerProcedureCallbacksImpl implements TypeCheckingProcedureCallbacks {
    public final boolean mo5938a(KotlinType kotlinType, KotlinType kotlinType2) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "noCorrespondingSupertype"}));
        } else if (kotlinType2 != null) {
            return false;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "noCorrespondingSupertype"}));
        }
    }

    public final boolean mo5940a(KotlinType kotlinType, TypeProjection typeProjection) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "capture"}));
        } else if (typeProjection != null) {
            return false;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "capture"}));
        }
    }

    TypeCheckerProcedureCallbacksImpl() {
    }

    public final boolean mo5939a(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"}));
        } else if (typeCheckingProcedure != null) {
            return typeCheckingProcedure.m28051b(kotlinType, kotlinType2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeCheckingProcedure", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"}));
        }
    }

    public boolean mo5941a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        if (typeConstructor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypeConstructors"}));
        } else if (typeConstructor2 != null) {
            return typeConstructor.equals(typeConstructor2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"b", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypeConstructors"}));
        }
    }

    public final boolean mo5942b(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"}));
        } else if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"}));
        } else if (typeCheckingProcedure != null) {
            return typeCheckingProcedure.m28052c(kotlinType, kotlinType2);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeCheckingProcedure", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"}));
        }
    }
}
