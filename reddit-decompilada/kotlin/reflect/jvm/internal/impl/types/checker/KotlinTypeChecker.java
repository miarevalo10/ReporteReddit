package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

public interface KotlinTypeChecker {
    public static final KotlinTypeChecker f26349a = NewKotlinTypeChecker.f33078b;

    public interface TypeConstructorEquality {
        boolean mo5914a(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    boolean mo5935a(KotlinType kotlinType, KotlinType kotlinType2);

    boolean mo5936b(KotlinType kotlinType, KotlinType kotlinType2);
}
