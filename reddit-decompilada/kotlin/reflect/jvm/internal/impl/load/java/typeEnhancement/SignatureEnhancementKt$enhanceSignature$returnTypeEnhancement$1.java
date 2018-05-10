package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1 extends Lambda implements Function1<D, KotlinType> {
    public static final SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1 f38751a = new SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1();

    SignatureEnhancementKt$enhanceSignature$returnTypeEnhancement$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "it");
        obj = callableMemberDescriptor.aN_();
        if (obj == null) {
            Intrinsics.m26842a();
        }
        return obj;
    }
}
