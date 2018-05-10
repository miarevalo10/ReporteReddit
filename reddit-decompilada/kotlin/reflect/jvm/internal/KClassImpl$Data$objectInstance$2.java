package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$objectInstance$2 extends Lambda implements Function0<T> {
    final /* synthetic */ Data f38237a;

    KClassImpl$Data$objectInstance$2(Data data) {
        this.f38237a = data;
        super(0);
    }

    public final T invoke() {
        ClassDescriptor a = this.f38237a.m32891a();
        if ((Intrinsics.m26845a(a.mo7771g(), ClassKind.OBJECT) ^ 1) != 0) {
            return null;
        }
        Field declaredField;
        Object obj;
        if (a.mo7772k()) {
            CompanionObjectMapping companionObjectMapping = CompanionObjectMapping.f25352a;
            if (!CompanionObjectMapping.m26943a(a)) {
                declaredField = this.f38237a.f32579h.f38246b.getEnclosingClass().getDeclaredField(a.mo6689i().m27429a());
                obj = declaredField.get(null);
                if (obj == null) {
                    return obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
        }
        declaredField = this.f38237a.f32579h.f38246b.getDeclaredField("INSTANCE");
        obj = declaredField.get(null);
        if (obj == null) {
            return obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}
