package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$extractQualifiersFromAnnotations$1 extends Lambda implements Function2<List<? extends FqName>, T, T> {
    final /* synthetic */ KotlinType f38761a;

    TypeQualifiersKt$extractQualifiersFromAnnotations$1(KotlinType kotlinType) {
        this.f38761a = kotlinType;
        super(2);
    }

    public final <T> T m38526a(List<FqName> list, T t) {
        Object obj;
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(t, "qualifier");
        list = list.iterator();
        do {
            obj = null;
            if (!list.hasNext()) {
                break;
            }
            if (this.f38761a.mo5718q().mo6679a((FqName) list.next()) != null) {
                obj = 1;
                continue;
            }
        } while (obj == null);
        obj = 1;
        return obj != null ? t : null;
    }
}
