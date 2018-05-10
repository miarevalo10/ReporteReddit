package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstUtil.kt */
public final class ConstUtil {
    public static final ConstUtil f25476a = null;

    static {
        ConstUtil constUtil = new ConstUtil();
    }

    private ConstUtil() {
        f25476a = this;
    }

    public static final boolean m27043a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        return ConstUtilKt.m27044a(kotlinType);
    }
}
