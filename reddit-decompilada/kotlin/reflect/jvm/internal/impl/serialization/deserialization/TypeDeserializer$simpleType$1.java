package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$simpleType$1 extends Lambda implements Function1<Type, List<? extends Argument>> {
    final /* synthetic */ TypeDeserializer f38862a;

    TypeDeserializer$simpleType$1(TypeDeserializer typeDeserializer) {
        this.f38862a = typeDeserializer;
        super(1);
    }

    public final List<Argument> m38614a(Type type) {
        Intrinsics.m26847b(type, "$receiver");
        Collection collection = type.f40453e;
        type = ProtoTypeTableUtilKt.m27878b(type, this.f38862a.f26273d.f26248f);
        type = type != null ? m38614a(type) : null;
        if (type == null) {
            type = CollectionsKt__CollectionsKt.m26790a();
        }
        return CollectionsKt___CollectionsKt.m41423b(collection, (Iterable) type);
    }
}
