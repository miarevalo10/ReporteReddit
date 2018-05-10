package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KTypeParameterImpl.kt */
final class KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1 extends Lambda implements Function0 {
    final /* synthetic */ KTypeParameterImpl$upperBounds$2 f38309a;

    KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1(KTypeParameterImpl$upperBounds$2 kTypeParameterImpl$upperBounds$2) {
        this.f38309a = kTypeParameterImpl$upperBounds$2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        StringBuilder stringBuilder = new StringBuilder("Java type is not yet supported for type parameters: ");
        stringBuilder.append(this.f38309a.f38310a.f36043a);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder("An operation is not implemented: ");
        stringBuilder3.append(stringBuilder2);
        throw new NotImplementedError(stringBuilder3.toString());
    }
}
