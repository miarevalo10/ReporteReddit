package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Getter;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$Getter$caller$2 extends Lambda implements Function0<FunctionCaller<?>> {
    final /* synthetic */ Getter f38282a;

    KPropertyImpl$Getter$caller$2(Getter getter) {
        this.f38282a = getter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return KPropertyImplKt.m26912a(this.f38282a, true);
    }
}
