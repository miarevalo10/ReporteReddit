package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getJavaAnalogue$fqName$1 extends Lambda implements Function1<FqNameUnsafe, Boolean> {
    public static final JvmBuiltInsSettings$getJavaAnalogue$fqName$1 f38777a = new JvmBuiltInsSettings$getJavaAnalogue$fqName$1();

    JvmBuiltInsSettings$getJavaAnalogue$fqName$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqNameUnsafe fqNameUnsafe = (FqNameUnsafe) obj;
        Intrinsics.m26847b(fqNameUnsafe, "it");
        return Boolean.valueOf(fqNameUnsafe.m27419c());
    }
}
