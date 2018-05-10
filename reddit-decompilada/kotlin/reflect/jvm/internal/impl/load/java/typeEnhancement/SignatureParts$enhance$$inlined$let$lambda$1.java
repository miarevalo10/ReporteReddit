package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: signatureEnhancement.kt */
final class SignatureParts$enhance$$inlined$let$lambda$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    final /* synthetic */ TypeEnhancementInfo f38753a;
    final /* synthetic */ Function1 f38754b;

    SignatureParts$enhance$$inlined$let$lambda$1(TypeEnhancementInfo typeEnhancementInfo, Function1 function1) {
        this.f38753a = typeEnhancementInfo;
        this.f38754b = function1;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = ((Number) obj).intValue();
        JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers) this.f38753a.f25775a.get(Integer.valueOf(obj));
        return javaTypeQualifiers == null ? (JavaTypeQualifiers) this.f38754b.mo6492a(Integer.valueOf(obj)) : javaTypeQualifiers;
    }
}
