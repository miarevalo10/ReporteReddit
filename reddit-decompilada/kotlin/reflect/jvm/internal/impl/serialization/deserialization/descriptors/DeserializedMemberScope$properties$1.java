package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$properties$1 extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ DeserializedMemberScope f38892a;

    DeserializedMemberScope$properties$1(DeserializedMemberScope deserializedMemberScope) {
        this.f38892a = deserializedMemberScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "it");
        return DeserializedMemberScope.m38630b(this.f38892a, name);
    }
}
