package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: methodSignatureBuilding.kt */
final class SignatureBuildingComponents$jvmDescriptor$1 extends Lambda implements Function1<String, String> {
    public static final SignatureBuildingComponents$jvmDescriptor$1 f38780a = new SignatureBuildingComponents$jvmDescriptor$1();

    SignatureBuildingComponents$jvmDescriptor$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "it");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        return SignatureBuildingComponents.m27366d(str);
    }
}
