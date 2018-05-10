package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$fqNameOrNull$1 extends Lambda implements Function1<FqNameUnsafe, Boolean> {
    public static final DescriptorUtilsKt$fqNameOrNull$1 f38809a = new DescriptorUtilsKt$fqNameOrNull$1();

    DescriptorUtilsKt$fqNameOrNull$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqNameUnsafe fqNameUnsafe = (FqNameUnsafe) obj;
        Intrinsics.m26847b(fqNameUnsafe, "it");
        return Boolean.valueOf(fqNameUnsafe.m27419c());
    }
}
