package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2$parameterizedTypeArguments$2 extends Lambda implements Function0<List<? extends Type>> {
    final /* synthetic */ KTypeImpl$arguments$2 f38306a;

    KTypeImpl$arguments$2$parameterizedTypeArguments$2(KTypeImpl$arguments$2 kTypeImpl$arguments$2) {
        this.f38306a = kTypeImpl$arguments$2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return ReflectClassUtilKt.m27240a(this.f38306a.f38307a.m32900b());
    }
}
