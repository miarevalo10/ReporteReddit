package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty0Impl.Getter;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KProperty0Impl.kt */
final class KProperty0Impl$getter_$1 extends Lambda implements Function0<Getter<? extends R>> {
    final /* synthetic */ KProperty0Impl f38271a;

    KProperty0Impl$getter_$1(KProperty0Impl kProperty0Impl) {
        this.f38271a = kProperty0Impl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new Getter(this.f38271a);
    }
}
