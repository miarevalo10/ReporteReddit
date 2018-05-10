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
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$typeAliasProtos$2 extends Lambda implements Function0<Map<Name, ? extends List<? extends TypeAlias>>> {
    final /* synthetic */ DeserializedMemberScope f38896a;
    final /* synthetic */ Collection f38897b;

    DeserializedMemberScope$typeAliasProtos$2(DeserializedMemberScope deserializedMemberScope, Collection collection) {
        this.f38896a = deserializedMemberScope;
        this.f38897b = collection;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        DeserializationContext deserializationContext = this.f38896a.f38901b;
        DeserializedMemberScope deserializedMemberScope = this.f38896a;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : this.f38897b) {
            Name b = deserializedMemberScope.f38901b.f26246d.mo5830b(((TypeAlias) ((MessageLite) next)).f40484f);
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
