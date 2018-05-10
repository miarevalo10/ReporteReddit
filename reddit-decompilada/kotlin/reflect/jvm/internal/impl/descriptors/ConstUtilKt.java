package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: ConstUtil.kt */
public final class ConstUtilKt {
    public static final boolean m27044a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return ((!KotlinBuiltIns.m26988d(kotlinType) || TypeUtils.m28015d(kotlinType)) && KotlinBuiltIns.m26995k(kotlinType) == null) ? null : true;
    }
}
