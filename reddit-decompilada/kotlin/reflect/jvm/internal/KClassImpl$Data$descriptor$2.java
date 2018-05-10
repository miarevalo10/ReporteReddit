package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$descriptor$2 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ Data f38233a;

    KClassImpl$Data$descriptor$2(Data data) {
        this.f38233a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object a;
        ClassId a2 = this.f38233a.f32579h.m38229i();
        RuntimeModuleData d = ((Data) this.f38233a.f32579h.f38245a.mo5694a()).m26910d();
        if (a2.f25852a) {
            a = d.f25848a.m27832a(a2);
        } else {
            a = FindClassInModuleKt.m27838a(d.f25848a.f26230c, a2);
        }
        if (a != null) {
            return a;
        }
        KClassImpl.m38227b(this.f38233a.f32579h);
        throw null;
    }
}
