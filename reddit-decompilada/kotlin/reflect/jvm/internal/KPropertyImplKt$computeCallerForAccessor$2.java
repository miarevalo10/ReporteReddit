package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Accessor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"isJvmStaticProperty", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImplKt$computeCallerForAccessor$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Accessor f38295a;

    KPropertyImplKt$computeCallerForAccessor$2(Accessor accessor) {
        this.f38295a = accessor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return Boolean.valueOf(m38286a());
    }

    public final boolean m38286a() {
        return this.f38295a.mo7255d().m36189m().mo5718q().mo6679a(UtilKt.m26935a()) != null;
    }
}
