package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;

/* compiled from: NotFoundClasses.kt */
final class C2991x8eab408c extends Lambda implements Function1<Type, Type> {
    final /* synthetic */ TypeTable f38858a;

    C2991x8eab408c(TypeTable typeTable) {
        this.f38858a = typeTable;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Type type = (Type) obj;
        Intrinsics.m26847b(type, "it");
        return ProtoTypeTableUtilKt.m27878b(type, this.f38858a);
    }
}
