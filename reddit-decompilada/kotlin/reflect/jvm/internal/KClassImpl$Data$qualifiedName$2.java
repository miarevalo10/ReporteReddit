package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lorg/jetbrains/annotations/NotNull;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$qualifiedName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Data f38238a;

    KClassImpl$Data$qualifiedName$2(Data data) {
        this.f38238a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        if (this.f38238a.f32579h.f38246b.isAnonymousClass()) {
            return null;
        }
        ClassId a = this.f38238a.f32579h.m38229i();
        if (a.f25852a) {
            return null;
        }
        return a.m27403f().m27407a();
    }
}
