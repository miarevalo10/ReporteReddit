package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeCheckerKt {
    public static final /* synthetic */ boolean m28030b(SimpleType simpleType) {
        return (simpleType.mo6742d() || (simpleType.mo6743g().mo5724c() instanceof TypeAliasDescriptor) || (simpleType.mo6743g().mo5724c() == null && !(simpleType instanceof CapturedType) && (simpleType instanceof NewCapturedType) == null)) ? null : true;
    }
}
