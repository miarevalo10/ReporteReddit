package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
final class SignatureParts {
    private final KotlinType f25768a;
    private final Collection<KotlinType> f25769b;
    private final boolean f25770c;

    public SignatureParts(KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z) {
        Intrinsics.m26847b(kotlinType, "fromOverride");
        Intrinsics.m26847b(collection, "fromOverridden");
        this.f25768a = kotlinType;
        this.f25769b = collection;
        this.f25770c = z;
    }

    public final PartEnhancementResult m27273a(TypeEnhancementInfo typeEnhancementInfo) {
        Function1 a = TypeQualifiersKt.m27282a(this.f25768a, this.f25769b, this.f25770c);
        typeEnhancementInfo = typeEnhancementInfo != null ? new SignatureParts$enhance$$inlined$let$lambda$1(typeEnhancementInfo, a) : null;
        KotlinType kotlinType = this.f25768a;
        if (typeEnhancementInfo == null) {
            typeEnhancementInfo = a;
        }
        typeEnhancementInfo = TypeEnhancementKt.m27277a(kotlinType, typeEnhancementInfo);
        if (typeEnhancementInfo != null) {
            return new PartEnhancementResult((KotlinType) typeEnhancementInfo, true);
        }
        return new PartEnhancementResult(this.f25768a, false);
    }
}
