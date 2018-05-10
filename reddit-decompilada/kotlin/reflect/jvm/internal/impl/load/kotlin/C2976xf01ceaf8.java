package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JvmBuiltInsSettings.kt */
final class C2976xf01ceaf8 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ JvmBuiltInsSettings f38772a;

    C2976xf01ceaf8(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.f38772a = jvmBuiltInsSettings;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object m = this.f38772a.f32809j.mo7089b().m27015m();
        Intrinsics.m26843a(m, "moduleDescriptor.builtIns.anyType");
        return m;
    }
}
