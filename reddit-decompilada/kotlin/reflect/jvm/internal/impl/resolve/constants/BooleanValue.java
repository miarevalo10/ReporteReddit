package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class BooleanValue extends ConstantValue<Boolean> {
    private final SimpleType f32938a;

    public BooleanValue(boolean z, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Boolean.valueOf(z));
        this.f32938a = kotlinBuiltIns.m27025w();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f32938a;
    }
}
