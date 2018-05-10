package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$simpleName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Data f38239a;

    KClassImpl$Data$simpleName$2(Data data) {
        this.f38239a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        if (this.f38239a.f32579h.f38246b.isAnonymousClass()) {
            return null;
        }
        ClassId a = this.f38239a.f32579h.m38229i();
        if (a.f25852a) {
            return Data.m32890a(this.f38239a.f32579h.f38246b);
        }
        Object a2 = a.m27400c().m27429a();
        Intrinsics.m26843a(a2, "classId.shortClassName.asString()");
        return a2;
    }
}
