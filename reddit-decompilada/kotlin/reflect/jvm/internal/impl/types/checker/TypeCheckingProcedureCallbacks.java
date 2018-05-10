package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

public interface TypeCheckingProcedureCallbacks {
    boolean mo5938a(KotlinType kotlinType, KotlinType kotlinType2);

    boolean mo5939a(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure);

    boolean mo5940a(KotlinType kotlinType, TypeProjection typeProjection);

    boolean mo5941a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);

    boolean mo5942b(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedure typeCheckingProcedure);
}
