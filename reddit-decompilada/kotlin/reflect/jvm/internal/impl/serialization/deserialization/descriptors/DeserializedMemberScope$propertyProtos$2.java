package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$propertyProtos$2 extends Lambda implements Function0<Map<Name, ? extends List<? extends Property>>> {
    final /* synthetic */ DeserializedMemberScope f38893a;
    final /* synthetic */ Collection f38894b;

    DeserializedMemberScope$propertyProtos$2(DeserializedMemberScope deserializedMemberScope, Collection collection) {
        this.f38893a = deserializedMemberScope;
        this.f38894b = collection;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        DeserializedMemberScope deserializedMemberScope = this.f38893a;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : this.f38894b) {
            Name b = deserializedMemberScope.f38901b.f26246d.mo5830b(((Property) ((MessageLite) next)).f40422g);
            ArrayList arrayList = linkedHashMap.get(b);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(b, arrayList);
            }
            arrayList.add(next);
        }
        return linkedHashMap;
    }
}
