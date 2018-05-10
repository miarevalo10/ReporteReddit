package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$typeAliasByName$1 extends Lambda implements Function1<Name, TypeAliasDescriptor> {
    final /* synthetic */ DeserializedMemberScope f38895a;

    DeserializedMemberScope$typeAliasByName$1(DeserializedMemberScope deserializedMemberScope) {
        this.f38895a = deserializedMemberScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "it");
        return DeserializedMemberScope.m38634c(this.f38895a, name);
    }
}
